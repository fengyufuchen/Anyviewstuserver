package com.anyview.action;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Controller;
import com.anyview.codec.pojo.request.PkLoginRequest;
import com.anyview.codec.pojo.response.PkLoginResponse;
import com.anyview.entities.StudentTable;
import com.anyview.service.PkLoginManager;
import com.anyview.utils.encryption.MD5Util;

import com.anyview.server.start.*;

/**
 * 
 * @author 吴汪洋
 * @date 2016年4月6日
 */
@Controller
public class PkLoginAction {

	PkLoginRequest loginRequestMsg;
	String ip;
	int port;

	// Spring: 注入bean
	private PkLoginManager pkLoginManager = (PkLoginManager) SubscribeServerStart.spctx.getBean("pkLoginManagerImpl");

	/**
	 * 登录状态缓存表 并发容器: ConcurrentHashMap 泛型: <String, StudentTable> String:
	 * 远程登录地址，格式：ip:port StudentTable: 实体对象
	 */
	public static Map<String, StudentTable> loginCache = new ConcurrentHashMap<String, StudentTable>();

	// 构造响应包
	PkLoginResponse builder = new PkLoginResponse();

	/**
	 * 默认构造器
	 * 
	 * @param loginRequestMsg
	 */
	public PkLoginAction(PkLoginRequest loginRequestMsg, String ip, int port) {
		this.loginRequestMsg = loginRequestMsg;
		this.ip = ip;
		this.port = port;
	}

	/**
	 * 接受登录请求，并响应
	 * 
	 * @return subscriberLoginRespMsg
	 * @throws Exception
	 */
	public PkLoginResponse pkLoginResponse() throws Exception {

		String subscriberAccount = loginRequestMsg.getSno();
		String subscriberPassword = loginRequestMsg.getPassword();
		int unid = loginRequestMsg.getUnid();
		String contextID = loginRequestMsg.getContextID();
		int cid = loginRequestMsg.getCid();

		List<StudentTable> stuList = pkLoginManager.getStudentInfo(subscriberAccount, unid);

		if (stuList.size() <= 0) {
			// Failure 1:帐户不存在
			builder.setLoginState(PkLoginResponse.LoginState.AccountNotExist);
			builder.setIpAddress(ip);
			builder.setPort(port);
			builder.setContextID(contextID);
		} else {
			// 帐户存在，校验帐户有效性、登录状态和密码

			StudentTable stu = (StudentTable) stuList.get(0);

			if (stu.getEnabled().intValue() == 0) {
				// Failure 2:帐户无效
				builder.setLoginState(PkLoginResponse.LoginState.AccountDisabled);
				builder.setIpAddress(ip);
				builder.setPort(port);
				builder.setContextID(contextID);
			} else if (stu.getLoginStatus().intValue() == 1
					|| loginCache.containsKey(ip + ":" + ((Integer) port).toString())) {
				// Failure 3:帐户有效，但已登录
				builder.setLoginState(PkLoginResponse.LoginState.DupeLogin);
				builder.setIpAddress(ip);
				builder.setPort(port);
				builder.setContextID(contextID);
			} else if (!subscriberPassword.equals(stu.getSpsw())
			// || ! MD5Util.validPassword(subscriberPassword, stu.getSpsw())
			) {
				// Failure 4:帐户有效，但密码不正确
				builder.setLoginState(PkLoginResponse.LoginState.PasswordError);
				builder.setIpAddress(ip);
				builder.setPort(port);
				builder.setContextID(contextID);
			} else {
				// Success:帐户有效，且未登录，密码正确
				int sid = stu.getSid();
				String unName = pkLoginManager.getUnNameByUnid(unid);
				String cname = pkLoginManager.getCNameByCid(cid);
				builder.setLoginState(PkLoginResponse.LoginState.LoginSuccess);
				builder.setIpAddress(ip);
				builder.setPort(port);
				builder.setSid(sid);
				builder.setSname(stu.getSname());
				builder.setUnid(unid);
				builder.setUnName(unName);
				builder.setCid(cid);
				builder.setCname(cname);
				builder.setSex(stu.getSsex());
				builder.setContextID(contextID);
				// 更新数据库:登录状态(成功)
				pkLoginManager.setLoginSuccessStatus(subscriberAccount, unid, ip, port);
				// loginCache.put(stu, true);
			}
		}
		return builder;
	}
}
