package com.anyview.codec.pojo.request;

import java.io.Serializable;

public enum AnyProtocolKind implements Serializable {
	
	pkGetAllUniversities,   //所有学校
	pkGetClass,             //班级
	pkGetCourse,            //课程
	pkLogin,            //登录          (客户请求)
	pkLogout,           //注销          (客户请求)
	//学生
	pkDownload,        //下载          (客户请求)
	pkSaveExercise,     //保存习题      (客户请求)
	pkChangePassword,  //修改密码      (客户请求)
	pkChangePersonal,   //修改个人资料  (客户请求)
	pkUpdateCmpTimes,   //更新编译次数  (客户请求)
	pkUpdateRunResult,  //更新运行结果  (客户请求)
	pkSaveFirstExercise,//保存首次习题  (客户请求)
	//学生及匿名用户
	pkCatalog,          //目录          (客户请求)
	pkProblem,         //读取题目      (客户请求)
	pkCourseCatalog,   //课程列表      (客户请求)
	pkTestStatusChange, //测验状态改变
	pkLoadTestInfo;     //获取测验信息
	
	
	private static final long serialVersionUID = 1L;
	 
}