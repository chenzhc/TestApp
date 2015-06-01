package com.test.app.netty.toolangframe;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.TooLongFrameException;

import java.util.List;

/**
 * Created by zc on 2015/6/1.
 */
public class FrameChunkDecoder extends ByteToMessageDecoder {

    // 限制大小
    private final int maxFrameSize;

    public FrameChunkDecoder(int maxFrameSize) {
        this.maxFrameSize = maxFrameSize;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in,
                          List<Object> out) throws Exception {
        // 获取可读字节数
        int readableBytes = in.readableBytes();
        // 若可读字节数大于限制值,清空字节并抛出异常
        if (readableBytes > maxFrameSize) {
            in.clear();
            throw new TooLongFrameException();
        }
        // 读取ByteBuf并放到List中
        ByteBuf buf = in.readBytes(readableBytes);
        out.add(buf);
    }
}
