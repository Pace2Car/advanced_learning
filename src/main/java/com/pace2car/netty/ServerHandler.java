package com.pace2car.netty;

import org.jboss.netty.channel.*;

import java.util.Scanner;

/**
 * @author Pace2Car
 * @date 2019/6/18 15:41
 */
public class ServerHandler extends SimpleChannelHandler {
    /**
     * 接收客户端数据
     * @param ctx
     * @param e
     * @throws Exception
     */
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        super.messageReceived(ctx, e);
        System.out.println("接受到数据：" + e.getMessage());
        ctx.getChannel().write("Hello Client");
    }

    /**
     * 异常处理
     * @param ctx
     * @param e
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        super.exceptionCaught(ctx, e);
        System.out.println("发生异常");
    }

    /**
     * 必须要建立连接，关闭通道时才会触发
     * @param ctx
     * @param e
     * @throws Exception
     */
    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        super.channelDisconnected(ctx, e);
        System.out.println("连接断开");
    }

    /**
     * 通道被关闭
     * @param ctx
     * @param e
     * @throws Exception
     */
    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        super.channelClosed(ctx, e);
        System.out.println("通道关闭");
    }

}
