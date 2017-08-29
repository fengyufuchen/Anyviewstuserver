package com.anyview.server.handler;

import java.net.InetSocketAddress;

import com.anyview.action.PkAddCustomFileAction;
import com.anyview.action.PkAddCustomPrjAction;
import com.anyview.action.PkCatalogAction;
import com.anyview.action.PkChangePasswordAction;
import com.anyview.action.PkCustomPrjAction;
import com.anyview.action.PkDeleteCustomFileAction;
import com.anyview.action.PkDeleteCustomPrjAction;
import com.anyview.action.PkGetAllUniversitiesAction;
import com.anyview.action.PkGetClassAction;
import com.anyview.action.PkGetExerciseContentAction;
import com.anyview.action.PkLoadTestInfoAction;
import com.anyview.action.PkLoginAction;
import com.anyview.action.PkLogoutAction;
import com.anyview.action.PkProblemAction;
import com.anyview.action.PkSaveExerciseAction;
import com.anyview.action.PkUpdateCmpTimesAction;
import com.anyview.action.PkUpdateCustomFileContentAction;
import com.anyview.action.PkUpdateCustomFileNameAction;
import com.anyview.action.PkUpdateCustomPrjNameAction;
import com.anyview.action.PkUpdateRunResultAction;
import com.anyview.codec.pojo.request.PkAddCustomFileRequest;
import com.anyview.codec.pojo.request.PkAddCustomPrjRequest;
import com.anyview.codec.pojo.request.PkCatalogRequest;
import com.anyview.codec.pojo.request.PkChangePasswordRequest;
import com.anyview.codec.pojo.request.PkCustomPrjRequest;
import com.anyview.codec.pojo.request.PkDeleteCustomFileRequest;
import com.anyview.codec.pojo.request.PkDeleteCustomPrjRequest;
import com.anyview.codec.pojo.request.PkGetAllUniversitiesRequest;
import com.anyview.codec.pojo.request.PkGetClassRequest;
import com.anyview.codec.pojo.request.PkGetExerciseContentRequest;
import com.anyview.codec.pojo.request.PkLoadTestInfoRequest;
import com.anyview.codec.pojo.request.PkLoginRequest;
import com.anyview.codec.pojo.request.PkLogoutRequest;
import com.anyview.codec.pojo.request.PkPingRequest;
import com.anyview.codec.pojo.request.PkProblemRequest;
import com.anyview.codec.pojo.request.PkSaveExerciseRequest;
import com.anyview.codec.pojo.request.PkUpdateCmpTimesRequest;
import com.anyview.codec.pojo.request.PkUpdateCustomFileContentRequest;
import com.anyview.codec.pojo.request.PkUpdateCustomFileNameRequest;
import com.anyview.codec.pojo.request.PkUpdateCustomPrjNameRequest;
import com.anyview.codec.pojo.request.PkUpdateRunResultRequest;
import com.anyview.codec.pojo.response.PkAddCustomFileResponse;
import com.anyview.codec.pojo.response.PkAddCustomPrjResponse;
import com.anyview.codec.pojo.response.PkCatalogResponse;
import com.anyview.codec.pojo.response.PkChangePasswordResponse;
import com.anyview.codec.pojo.response.PkCustomPrjResponse;
import com.anyview.codec.pojo.response.PkDeleteCustomFileResponse;
import com.anyview.codec.pojo.response.PkDeleteCustomPrjResponse;
import com.anyview.codec.pojo.response.PkGetAllUniversitiesResponse;
import com.anyview.codec.pojo.response.PkGetClassResponse;
import com.anyview.codec.pojo.response.PkGetExerciseContentResponse;
import com.anyview.codec.pojo.response.PkLoadTestInfoResponse;
import com.anyview.codec.pojo.response.PkLoginResponse;
import com.anyview.codec.pojo.response.PkLogoutResponse;
import com.anyview.codec.pojo.response.PkPongResponse;
import com.anyview.codec.pojo.response.PkProblemResponse;
import com.anyview.codec.pojo.response.PkSaveExerciseResponse;
import com.anyview.codec.pojo.response.PkUpdateCmpTimesResponse;
import com.anyview.codec.pojo.response.PkUpdateCustomFileContentResponse;
import com.anyview.codec.pojo.response.PkUpdateCustomFileNameResponse;
import com.anyview.codec.pojo.response.PkUpdateCustomPrjNameResponse;
import com.anyview.codec.pojo.response.PkUpdateRunResultResponse;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.ReadTimeoutException;

public class SubscribeServerHandler extends ChannelHandlerAdapter {
	private Integer sid;

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

		InetSocketAddress remoteAddress = (InetSocketAddress) ctx.channel().remoteAddress();
		String ip = remoteAddress.getAddress().getHostAddress();
		int port = remoteAddress.getPort();

		if (msg instanceof PkLoginRequest) {
			PkLoginRequest loginRequestMsg = (PkLoginRequest) msg;
			PkLoginAction pkLoginAction = new PkLoginAction(loginRequestMsg, ip, port);
			PkLoginResponse builder = pkLoginAction.pkLoginResponse();
			sid = builder.getSid();
			ctx.writeAndFlush(builder);
		}

		else if (msg instanceof PkChangePasswordRequest) {

			PkChangePasswordRequest changePasswordRequestMsg = (PkChangePasswordRequest) msg;
			PkChangePasswordAction pkChangePasswordAction = new PkChangePasswordAction(changePasswordRequestMsg);
			PkChangePasswordResponse builder = pkChangePasswordAction.pkChangePasswordResponse();
			ctx.writeAndFlush(builder);
		}

		else if (msg instanceof PkLogoutRequest) {
			System.out.println("收到 logout信息为:");
			PkLogoutRequest loginRequestMsg = (PkLogoutRequest) msg;
			System.out.println(loginRequestMsg);
			PkLogoutAction pkLogoutAction = new PkLogoutAction(loginRequestMsg);
			PkLogoutResponse builder = pkLogoutAction.pkLogoutResponse();

			ctx.writeAndFlush(builder);
		}

		else if (msg instanceof PkGetAllUniversitiesRequest) {
			PkGetAllUniversitiesRequest getAllUniversitiesRequestMsg = (PkGetAllUniversitiesRequest) msg;
			PkGetAllUniversitiesAction pkGetAllUniversitiesAction = new PkGetAllUniversitiesAction();
			PkGetAllUniversitiesResponse builder = pkGetAllUniversitiesAction.pkGetAllUniversitiesResponse();
			ctx.writeAndFlush(builder);
		}

		else if (msg instanceof PkCatalogRequest) {
			System.out.println("收到 catalog信息为:" + msg);
			PkCatalogRequest catalogRequest = (PkCatalogRequest) msg;
			System.out.println(catalogRequest);
			PkCatalogAction pkCatalogAction = new PkCatalogAction(catalogRequest);
			PkCatalogResponse builder = pkCatalogAction.pkCatalogResponse();
			ctx.writeAndFlush(builder);
		}

		else if (msg instanceof PkProblemRequest) {
			PkProblemRequest pkProblemRequest = (PkProblemRequest) msg;
			PkProblemAction pkProblemAction = new PkProblemAction(pkProblemRequest);
			PkProblemResponse builder = pkProblemAction.pkProblemResponse();
			ctx.writeAndFlush(builder);
		}

		else if (msg instanceof PkSaveExerciseRequest) {
			PkSaveExerciseRequest pkSaveExerciseRequest = (PkSaveExerciseRequest) msg;
			PkSaveExerciseAction pkSaveExerciseAction = new PkSaveExerciseAction(pkSaveExerciseRequest);
			PkSaveExerciseResponse builder = pkSaveExerciseAction.PkSaveExerciseResponse();
			ctx.writeAndFlush(builder);
		}

		else if (msg instanceof PkUpdateRunResultRequest) {

			PkUpdateRunResultRequest updateRunResultRequestmsg = (PkUpdateRunResultRequest) msg;
			PkUpdateRunResultAction pkUpdateRunResultAction = new PkUpdateRunResultAction(updateRunResultRequestmsg);
			PkUpdateRunResultResponse builder = pkUpdateRunResultAction.PkUpdateRunResultResponse();
			ctx.writeAndFlush(builder);
		} else if (msg instanceof PkUpdateCmpTimesRequest) {
			PkUpdateCmpTimesRequest updateCmpTimesRequestmsg = (PkUpdateCmpTimesRequest) msg;
			PkUpdateCmpTimesAction pkUpdateCmpTimesAction = new PkUpdateCmpTimesAction(updateCmpTimesRequestmsg);
			PkUpdateCmpTimesResponse builder = pkUpdateCmpTimesAction.PkUpdateCmpTimesResponse();
			ctx.writeAndFlush(builder);
		} else if (msg instanceof PkLoadTestInfoRequest) {
			PkLoadTestInfoRequest pkLoadTestInfoRequest = (PkLoadTestInfoRequest) msg;
			System.out.println(pkLoadTestInfoRequest);
			PkLoadTestInfoAction pkLoadTestInfoAction = new PkLoadTestInfoAction(pkLoadTestInfoRequest);
			PkLoadTestInfoResponse builder = pkLoadTestInfoAction.pkLoadTestInfoResponse();
			ctx.writeAndFlush(builder);
		} else if (msg instanceof PkCustomPrjRequest) {
			PkCustomPrjRequest pkCustomPrjRequest = (PkCustomPrjRequest) msg;
			System.out.println(pkCustomPrjRequest);
			PkCustomPrjAction pkCustomPrjAction = new PkCustomPrjAction(pkCustomPrjRequest);
			PkCustomPrjResponse builder = pkCustomPrjAction.pkCustomPrjResponse();
			ctx.writeAndFlush(builder);
		} else if (msg instanceof PkUpdateCustomFileContentRequest) {
			PkUpdateCustomFileContentRequest pkUpdateCustomFileRequest = (PkUpdateCustomFileContentRequest) msg;
			System.out.println(pkUpdateCustomFileRequest);
			PkUpdateCustomFileContentAction pkUpdateCustomFileAction = new PkUpdateCustomFileContentAction(
					pkUpdateCustomFileRequest);
			PkUpdateCustomFileContentResponse builder = pkUpdateCustomFileAction.pkUpdateCmpTimesResponse();
			ctx.writeAndFlush(builder);
		} else if (msg instanceof PkDeleteCustomPrjRequest) {
			PkDeleteCustomPrjRequest pkDeleteCustomPrjRequest = (PkDeleteCustomPrjRequest) msg;
			System.out.println(pkDeleteCustomPrjRequest);
			PkDeleteCustomPrjAction pkDeleteCustomPrjAction = new PkDeleteCustomPrjAction(pkDeleteCustomPrjRequest);
			PkDeleteCustomPrjResponse builder = pkDeleteCustomPrjAction.pkDeleteCustomPrjResponse();
			ctx.writeAndFlush(builder);
		} else if (msg instanceof PkDeleteCustomFileRequest) {
			PkDeleteCustomFileRequest pkDeleteCustomFileRequest = (PkDeleteCustomFileRequest) msg;
			System.out.println(pkDeleteCustomFileRequest);
			PkDeleteCustomFileAction pkDeleteCustomFileAction = new PkDeleteCustomFileAction(pkDeleteCustomFileRequest);
			PkDeleteCustomFileResponse builder = pkDeleteCustomFileAction.pkDeleteCustomFileResponse();
			ctx.writeAndFlush(builder);

		} else if (msg instanceof PkAddCustomPrjRequest) {
			PkAddCustomPrjRequest pkAddCustomPrjRequest = (PkAddCustomPrjRequest) msg;
			System.out.println(pkAddCustomPrjRequest);
			PkAddCustomPrjAction pkAddCustomPrjAction = new PkAddCustomPrjAction(pkAddCustomPrjRequest);
			PkAddCustomPrjResponse builder = pkAddCustomPrjAction.pkAddCustomPrjResponse();
			ctx.writeAndFlush(builder);
		} else if (msg instanceof PkAddCustomFileRequest) {
			PkAddCustomFileRequest pkAddCustomFileRequest = (PkAddCustomFileRequest) msg;
			System.out.println(pkAddCustomFileRequest);
			PkAddCustomFileAction pkAddCustomFileAction = new PkAddCustomFileAction(pkAddCustomFileRequest);
			PkAddCustomFileResponse builder = pkAddCustomFileAction.pkAddCustomFileResponse();
			ctx.writeAndFlush(builder);
		} else if (msg instanceof PkUpdateCustomFileNameRequest) {
			PkUpdateCustomFileNameRequest pkUpdateCustomFileNameRequest = (PkUpdateCustomFileNameRequest) msg;
			System.out.println(pkUpdateCustomFileNameRequest);
			PkUpdateCustomFileNameAction pkUpdateCustomFileNameAction = new PkUpdateCustomFileNameAction(
					pkUpdateCustomFileNameRequest);
			PkUpdateCustomFileNameResponse builder = pkUpdateCustomFileNameAction.pkUpdateCustomFileNameResponse();
			ctx.writeAndFlush(builder);
		} else if (msg instanceof PkUpdateCustomPrjNameRequest) {
			PkUpdateCustomPrjNameRequest pkUpdateCustomPrjNameRequest = (PkUpdateCustomPrjNameRequest) msg;
			System.out.println(pkUpdateCustomPrjNameRequest);
			PkUpdateCustomPrjNameAction pkUpdateCustomPrjNameAction = new PkUpdateCustomPrjNameAction(
					pkUpdateCustomPrjNameRequest);
			PkUpdateCustomPrjNameResponse builder = pkUpdateCustomPrjNameAction.pkUpdateCustomPrjNameResponse();
			ctx.writeAndFlush(builder);
		} else if (msg instanceof PkGetExerciseContentRequest) {
			PkGetExerciseContentRequest pkGetExerciseContentRequest = (PkGetExerciseContentRequest) msg;
			PkGetExerciseContentAction pkGetExerciseContentAction = new PkGetExerciseContentAction(
					pkGetExerciseContentRequest);
			PkGetExerciseContentResponse builder = pkGetExerciseContentAction.pkGetExerciseContentResponse();
			ctx.writeAndFlush(builder);
		} else if (msg instanceof PkGetClassRequest) {
			PkGetClassRequest pkGetClassRequest = (PkGetClassRequest) msg;
			PkGetClassAction pkGetClassAction = new PkGetClassAction(pkGetClassRequest);
			PkGetClassResponse builder = pkGetClassAction.pkGetClassResponse();
			ctx.writeAndFlush(builder);
		} else if (msg instanceof PkPingRequest) {
			System.out.println("收到客户端发来的ping请求");
			ctx.writeAndFlush(new PkPongResponse());
		}
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		if (cause instanceof ReadTimeoutException) {
			System.out.println("read time out");
		}
		cause.printStackTrace();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
		SubscribeServer.Channel_Group.add(ctx.channel());
		System.out.println("channel active,连接个数为" + SubscribeServer.Channel_Group.size());
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		super.channelInactive(ctx);
		System.out.println("channel inactive,连接个数为" + SubscribeServer.Channel_Group.size());
		PkLogoutRequest loginRequestMsg = new PkLogoutRequest();
		loginRequestMsg.setContextID("");
		loginRequestMsg.setSid(sid + "");
		PkLogoutAction pkLogoutAction = new PkLogoutAction(loginRequestMsg);
		pkLogoutAction.pkLogoutResponse();
	}

}
