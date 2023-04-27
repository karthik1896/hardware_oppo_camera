package com.sensetime.stmobile;

import android.opengl.GLES20;
import android.opengl.GLES30;
import com.oppo.camera.util.d;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;

public class STGLRender {
    public static final String CAMERA_INPUT_FRAGMENT_SHADER = "precision mediump float;\nvarying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\n\nvoid main()\n{\ngl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
    private static final String CAMERA_INPUT_VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nvarying vec2 textureCoordinate;\n\nvoid main()\n{\ntextureCoordinate = inputTextureCoordinate.xy;\ngl_Position = position;\n}";
    public static final float[] CUBE = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final String POSITION_COORDINATE = "position";
    private static final String PROGRAM_ID = "program";
    private static final String TEXTURE_COORDINATE = "inputTextureCoordinate";
    public static final float[] TEXTURE_NO_ROTATION = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static final String TEXTURE_UNIFORM = "inputImageTexture";
    public static final float[] TEXTURE_VERTICAL_FLIP = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private int[] mFrameBufferTexturesResize;
    private int[] mFrameBuffersResize;
    private FloatBuffer mGLCubeBuffer;
    private FloatBuffer mGLSaveTextureBuffer;
    private int mHeight = 0;
    private boolean mIsInitialized;
    private int[] mOesFrameBuffer;
    private HashMap<String, Integer> mProgram = new HashMap<>();
    private FloatBuffer mVertexBuffer;
    private int mWidth = 0;

    public STGLRender() {
        this.mProgram.put(PROGRAM_ID, 0);
        this.mProgram.put(POSITION_COORDINATE, -1);
        this.mProgram.put(TEXTURE_UNIFORM, -1);
        this.mProgram.put(TEXTURE_COORDINATE, -1);
        this.mGLCubeBuffer = ByteBuffer.allocateDirect(CUBE.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLCubeBuffer.put(CUBE).position(0);
        this.mGLSaveTextureBuffer = ByteBuffer.allocateDirect(TEXTURE_NO_ROTATION.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLSaveTextureBuffer.put(TEXTURE_VERTICAL_FLIP).position(0);
    }

    public void init(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        initProgram(CAMERA_INPUT_FRAGMENT_SHADER, this.mProgram);
        initFrameBuffers();
        this.mIsInitialized = true;
        calculateVertexBuffer();
    }

    private void initProgram(String str, HashMap<String, Integer> hashMap) {
        if (hashMap.get(PROGRAM_ID).intValue() == 0) {
            int a2 = d.a(CAMERA_INPUT_VERTEX_SHADER, str);
            hashMap.put(PROGRAM_ID, Integer.valueOf(a2));
            hashMap.put(POSITION_COORDINATE, Integer.valueOf(GLES20.glGetAttribLocation(a2, POSITION_COORDINATE)));
            hashMap.put(TEXTURE_UNIFORM, Integer.valueOf(GLES20.glGetUniformLocation(a2, TEXTURE_UNIFORM)));
            hashMap.put(TEXTURE_COORDINATE, Integer.valueOf(GLES20.glGetAttribLocation(a2, TEXTURE_COORDINATE)));
        }
    }

    public void calculateVertexBuffer() {
        if (this.mVertexBuffer == null) {
            this.mVertexBuffer = ByteBuffer.allocateDirect(CUBE.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.mVertexBuffer.clear();
        this.mVertexBuffer.put(CUBE).position(0);
    }

    public void copyTexture(int i, int i2, int i3, int i4) {
        int i5 = i;
        if (this.mOesFrameBuffer == null) {
            this.mOesFrameBuffer = new int[1];
            GLES20.glGenFramebuffers(1, this.mOesFrameBuffer, 0);
        }
        GLES30.glBindFramebuffer(36008, this.mFrameBuffersResize[0]);
        GLES30.glBindTexture(3553, i5);
        GLES30.glFramebufferTexture2D(36008, 36064, 3553, i5, 0);
        GLES30.glBindFramebuffer(36009, this.mOesFrameBuffer[0]);
        GLES30.glFramebufferTexture2D(36009, 36064, 36197, i2, 0);
        GLES30.glBlitFramebuffer(0, 0, i3, i4, 0, 0, i3, i4, 16384, 9729);
        GLES30.glBindFramebuffer(36009, 0);
        GLES30.glBindFramebuffer(36008, 0);
        GLES30.glBindTexture(3553, 0);
        GLES30.glBindTexture(36197, 0);
    }

    public int resizeTexture(int i, int i2, int i3, int i4) {
        if (!this.mIsInitialized) {
            return -1;
        }
        GLES20.glUseProgram(this.mProgram.get(PROGRAM_ID).intValue());
        this.mVertexBuffer.position(0);
        int intValue = this.mProgram.get(POSITION_COORDINATE).intValue();
        GLES20.glVertexAttribPointer(intValue, 2, 5126, false, 0, this.mVertexBuffer);
        GLES20.glEnableVertexAttribArray(intValue);
        int intValue2 = this.mProgram.get(TEXTURE_COORDINATE).intValue();
        this.mGLSaveTextureBuffer.position(0);
        GLES20.glVertexAttribPointer(intValue2, 2, 5126, false, 0, this.mGLSaveTextureBuffer);
        GLES20.glEnableVertexAttribArray(intValue2);
        if (i != -1) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniform1i(this.mProgram.get(TEXTURE_UNIFORM).intValue(), 0);
        }
        GLES20.glBindFramebuffer(36160, this.mFrameBuffersResize[i4]);
        d.a("resizeTexture");
        GLES20.glViewport(0, 0, i2, i3);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(intValue);
        GLES20.glDisableVertexAttribArray(intValue2);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        return this.mFrameBufferTexturesResize[i4];
    }

    public void destroyResizeFrameBuffers() {
        int[] iArr = this.mFrameBufferTexturesResize;
        if (iArr != null) {
            GLES20.glDeleteTextures(1, iArr, 0);
            this.mFrameBufferTexturesResize = null;
        }
        int[] iArr2 = this.mFrameBuffersResize;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(1, iArr2, 0);
            this.mFrameBuffersResize = null;
        }
        int[] iArr3 = this.mOesFrameBuffer;
        if (iArr3 != null) {
            GLES20.glDeleteFramebuffers(1, iArr3, 0);
            this.mOesFrameBuffer = null;
        }
    }

    private void initFrameBuffers() {
        destroyResizeFrameBuffers();
        if (this.mFrameBuffersResize == null) {
            this.mFrameBuffersResize = new int[1];
            this.mFrameBufferTexturesResize = new int[1];
            GLES20.glGenFramebuffers(1, this.mFrameBuffersResize, 0);
            GLES20.glGenTextures(1, this.mFrameBufferTexturesResize, 0);
            bindFrameBuffer(this.mFrameBufferTexturesResize[0], this.mFrameBuffersResize[0], this.mWidth, this.mHeight);
        }
    }

    private void bindFrameBuffer(int i, int i2, int i3, int i4) {
        GLES20.glBindTexture(3553, i);
        GLES20.glTexImage2D(3553, 0, 6408, i3, i4, 0, 6408, 5121, (Buffer) null);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glBindFramebuffer(36160, i2);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public void destroy() {
        destroyResizeFrameBuffers();
        FloatBuffer floatBuffer = this.mVertexBuffer;
        if (floatBuffer != null) {
            floatBuffer.clear();
            this.mVertexBuffer = null;
        }
        FloatBuffer floatBuffer2 = this.mGLSaveTextureBuffer;
        if (floatBuffer2 != null) {
            floatBuffer2.clear();
            this.mGLSaveTextureBuffer = null;
        }
        FloatBuffer floatBuffer3 = this.mGLCubeBuffer;
        if (floatBuffer3 != null) {
            floatBuffer3.clear();
            this.mGLCubeBuffer = null;
        }
        HashMap<String, Integer> hashMap = this.mProgram;
        if (hashMap != null) {
            GLES20.glDeleteProgram(hashMap.get(PROGRAM_ID).intValue());
            this.mProgram.clear();
            this.mProgram = null;
        }
        this.mIsInitialized = false;
    }
}
