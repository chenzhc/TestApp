package com.test.app.netty.absinteger;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * Created by zc on 2015/6/1.
 */
public class AbsIntegerEncoder extends MessageToMessageEncoder<ByteBuf> {
    @Override
    protected void encode(ChannelHandlerContext ctx, ByteBuf msg,
                          List<Object> out) throws Exception {
        while(msg.readableBytes() >= 4){
            int value = Math.abs(msg.readInt());
            out.add(value);
        }
    }
}
