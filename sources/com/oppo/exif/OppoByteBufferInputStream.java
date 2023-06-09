package com.oppo.exif;

import java.io.InputStream;
import java.nio.ByteBuffer;

class OppoByteBufferInputStream extends InputStream {
    private ByteBuffer mBuf;

    public OppoByteBufferInputStream(ByteBuffer byteBuffer) {
        this.mBuf = byteBuffer;
    }

    public int read() {
        if (!this.mBuf.hasRemaining()) {
            return -1;
        }
        return this.mBuf.get() & 255;
    }

    public int read(byte[] bArr, int i, int i2) {
        if (!this.mBuf.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i2, this.mBuf.remaining());
        this.mBuf.get(bArr, i, min);
        return min;
    }
}
