package com.yumaolin.deepunderstand.messenger.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

public class UdpTransferClientHandle extends SimpleChannelInboundHandler<DatagramPacket>{

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
		String response =  packet.content().toString(CharsetUtil.UTF_8);
		if(response.startsWith("结果:")){	
			System.out.println(response);
			ctx.close();
		}
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
		ctx.close();
		cause.printStackTrace();
	}
}
