package com.pace2car.netty5;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author Pace2Car
 * @date 2019/6/18 15:41
 */
public class ServerHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("收到消息：" + msg);
        // 回复
        ctx.writeAndFlush(Unpooled.copiedBuffer(msg.toString().getBytes()));
    }
}
