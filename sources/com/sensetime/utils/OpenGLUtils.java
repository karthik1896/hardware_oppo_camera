package com.sensetime.utils;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class OpenGLUtils {
    public static final int NO_TEXTURE = -1;
    public static final String TAG = "OpenGLUtils";

    public static int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Log.e("ES20_ERROR", "Could not compile shader " + i + ":");
        Log.e("ES20_ERROR", GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public static int createProgram(String str, String str2) {
        int loadShader;
        int loadShader2 = loadShader(35633, str);
        if (loadShader2 == 0 || (loadShader = loadShader(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, loadShader2);
            checkGlError("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, loadShader);
            checkGlError("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                Log.e("ES20_ERROR", "Could not link program: ");
                Log.e("ES20_ERROR", GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
        }
        return glCreateProgram;
    }

    public static void checkGlError(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("ES20_ERROR", str + ": glError " + glGetError);
            throw new RuntimeException(str + ": glError " + glGetError);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003f, code lost:
        r2 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0052 A[SYNTHETIC, Splitter:B:33:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005a A[Catch:{ IOException -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0069 A[SYNTHETIC, Splitter:B:44:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0071 A[Catch:{ IOException -> 0x006d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String loadFromAssetsFile(java.lang.String r5, android.content.res.Resources r6) {
        /*
            r0 = 0
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch:{ Exception -> 0x004a, all -> 0x0045 }
            java.io.InputStream r5 = r6.open(r5)     // Catch:{ Exception -> 0x004a, all -> 0x0045 }
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0042 }
            r6.<init>()     // Catch:{ Exception -> 0x0042 }
        L_0x000e:
            int r1 = r5.read()     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            r2 = -1
            if (r1 == r2) goto L_0x0019
            r6.write(r1)     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            goto L_0x000e
        L_0x0019:
            byte[] r1 = r6.toByteArray()     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r1, r3)     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            java.lang.String r0 = "\\r\\n"
            java.lang.String r1 = "\n"
            java.lang.String r0 = r2.replaceAll(r0, r1)     // Catch:{ Exception -> 0x003a, all -> 0x003c }
            r6.close()     // Catch:{ IOException -> 0x0035 }
            if (r5 == 0) goto L_0x0062
            r5.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0062
        L_0x0035:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x0062
        L_0x003a:
            r1 = move-exception
            goto L_0x0040
        L_0x003c:
            r0 = move-exception
            goto L_0x0067
        L_0x003e:
            r1 = move-exception
            r2 = r0
        L_0x0040:
            r0 = r6
            goto L_0x004d
        L_0x0042:
            r1 = move-exception
            r2 = r0
            goto L_0x004d
        L_0x0045:
            r5 = move-exception
            r6 = r0
            r0 = r5
            r5 = r6
            goto L_0x0067
        L_0x004a:
            r1 = move-exception
            r5 = r0
            r2 = r5
        L_0x004d:
            r1.printStackTrace()     // Catch:{ all -> 0x0063 }
            if (r0 == 0) goto L_0x0058
            r0.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x0058
        L_0x0056:
            r5 = move-exception
            goto L_0x005e
        L_0x0058:
            if (r5 == 0) goto L_0x0061
            r5.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x0061
        L_0x005e:
            r5.printStackTrace()
        L_0x0061:
            r0 = r2
        L_0x0062:
            return r0
        L_0x0063:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x0067:
            if (r6 == 0) goto L_0x006f
            r6.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x006f
        L_0x006d:
            r5 = move-exception
            goto L_0x0075
        L_0x006f:
            if (r5 == 0) goto L_0x0078
            r5.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0078
        L_0x0075:
            r5.printStackTrace()
        L_0x0078:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensetime.utils.OpenGLUtils.loadFromAssetsFile(java.lang.String, android.content.res.Resources):java.lang.String");
    }

    public static int loadSingleChannelTexture(ByteBuffer byteBuffer, int i, int i2, int i3) {
        int i4 = i3;
        int[] iArr = new int[1];
        if (i4 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glTexImage2D(3553, 0, 6406, i, i2, 0, 6406, 5121, byteBuffer);
        } else {
            GLES20.glBindTexture(3553, i4);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, i, i2, 6406, 5121, byteBuffer);
            iArr[0] = i4;
        }
        return iArr[0];
    }

    public static int loadTexture(Buffer buffer, int i, int i2, int i3) {
        int i4 = i3;
        int[] iArr = new int[1];
        if (i4 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, buffer);
        } else {
            GLES20.glBindTexture(3553, i4);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, i, i2, 6408, 5121, buffer);
            iArr[0] = i4;
        }
        return iArr[0];
    }

    public static int loadTexture(Bitmap bitmap, int i, boolean z) {
        int[] iArr = {-1};
        if (i == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        } else {
            GLES20.glBindTexture(3553, i);
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            iArr[0] = i;
        }
        if (z) {
            bitmap.recycle();
        }
        return iArr[0];
    }

    public static void readPix(int i, int i2, int i3, byte[] bArr) {
        GLES20.glFinish();
        int[] iArr = {0};
        IntBuffer wrap = IntBuffer.wrap(iArr);
        GLES20.glGenFramebuffers(1, wrap);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        int i4 = i;
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        GLES20.glReadPixels(0, 0, i2, i3, 6408, 5121, ByteBuffer.wrap(bArr));
        GLES20.glDeleteFramebuffers(1, wrap);
        GLES20.glFinish();
    }

    public static int genOESTexture() {
        int[] iArr = {-1};
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        return iArr[0];
    }

    public static void destroyTexture(int i) {
        if (-1 != i) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
        }
    }
}
