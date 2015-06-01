package com.test.app.netty.fixedlength;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by zc on 2015/6/1.
 */
public class FixedLenthFrameDecoder extends ByteToMessageDecoder{

    private final int frameLength;

    public FixedLenthFrameDecoder(int frameLength) {
        this.frameLength = frameLength;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx,
                          ByteBuf in,
                          List<Object> out) throws Exception {
        while(in.readableBytes()>=frameLength){
            ByteBuf buf = in.readBytes(frameLength);
            out.add(buf);
        }
    }

}
