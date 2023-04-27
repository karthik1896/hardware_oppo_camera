package com.sensetime.faceapi;

import com.sensetime.faceapi.model.ResultCode;

public abstract class FaceHandleBase {
    protected byte[] mBuffer;
    protected long mCvFaceHandle;
    protected int[] mResultCode = new int[1];

    /* access modifiers changed from: protected */
    public abstract void releaseHandle();

    /* access modifiers changed from: protected */
    public boolean isHandleInitialized() {
        return this.mCvFaceHandle != 0;
    }

    /* access modifiers changed from: protected */
    public void checkResultCode(int i) {
        if (i != ResultCode.OK.getValue()) {
            throw new RuntimeException("Calling native method failed! ResultCode : " + i + " Reason : " + ResultCode.getDescription(i));
        }
    }

    /* access modifiers changed from: protected */
    public void checkResultCode() {
        checkResultCode(this.mResultCode[0]);
    }

    /* access modifiers changed from: protected */
    public byte[] createBufferIfNeed(int i, int i2) {
        int i3 = i * i2 * 4;
        byte[] bArr = this.mBuffer;
        if (bArr != null && bArr.length == i3) {
            return bArr;
        }
        this.mBuffer = new byte[i3];
        return this.mBuffer;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        release();
    }

    public void release() {
        if (this.mCvFaceHandle != 0) {
            this.mBuffer = null;
            releaseHandle();
            this.mCvFaceHandle = 0;
        }
    }
}
