package com.oppo.camera.util;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES31;
import android.opengl.GLUtils;
import com.oppo.camera.e;
import com.sensetime.utils.OpenGLUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: OpenGLUtils */
public class d {
    public static int a(Bitmap bitmap) {
        if (bitmap == null) {
            return -1;
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        return iArr[0];
    }

    public static void a(int i) {
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
    }

    public static int a(String str, String str2) {
        int[] iArr = new int[1];
        int a2 = a(35633, str);
        if (a2 == 0) {
            return 0;
        }
        int a3 = a(35632, str2);
        if (a3 == 0) {
            GLES20.glDeleteShader(a2);
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram == 0) {
            return 0;
        }
        GLES20.glAttachShader(glCreateProgram, a2);
        GLES20.glAttachShader(glCreateProgram, a3);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 0) {
            e.e(OpenGLUtils.TAG, "loadProgram error, " + GLES20.glGetProgramInfoLog(glCreateProgram));
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        GLES20.glDeleteShader(a2);
        GLES20.glDeleteShader(a3);
        return glCreateProgram;
    }

    public static void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Throwable th = new Throwable();
            e.d(OpenGLUtils.TAG, "checkGlError, op: " + str + ", glError: 0x" + Integer.toHexString(glGetError), th);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.InputStreamReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: java.io.InputStreamReader} */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088 A[SYNTHETIC, Splitter:B:46:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0092 A[SYNTHETIC, Splitter:B:51:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009c A[SYNTHETIC, Splitter:B:56:0x009c] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00bb A[SYNTHETIC, Splitter:B:63:0x00bb] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c5 A[SYNTHETIC, Splitter:B:68:0x00c5] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00cf A[SYNTHETIC, Splitter:B:73:0x00cf] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00da A[SYNTHETIC, Splitter:B:79:0x00da] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x00e4 A[SYNTHETIC, Splitter:B:84:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00ee A[SYNTHETIC, Splitter:B:89:0x00ee] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:43:0x0072=Splitter:B:43:0x0072, B:60:0x00a5=Splitter:B:60:0x00a5} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r8, int r9) {
        /*
            java.lang.String r0 = "OpenGLUtils"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r2 = 0
            android.content.res.Resources r8 = r8.getResources()     // Catch:{ IOException -> 0x00a0, NotFoundException -> 0x006d, all -> 0x0067 }
            java.io.InputStream r8 = r8.openRawResource(r9)     // Catch:{ IOException -> 0x00a0, NotFoundException -> 0x006d, all -> 0x0067 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0062, NotFoundException -> 0x005d, all -> 0x005a }
            r3.<init>(r8)     // Catch:{ IOException -> 0x0062, NotFoundException -> 0x005d, all -> 0x005a }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0054, NotFoundException -> 0x004f, all -> 0x004b }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0054, NotFoundException -> 0x004f, all -> 0x004b }
        L_0x001a:
            java.lang.String r2 = r4.readLine()     // Catch:{ IOException -> 0x0048, NotFoundException -> 0x0046 }
            if (r2 == 0) goto L_0x0029
            r1.append(r2)     // Catch:{ IOException -> 0x0048, NotFoundException -> 0x0046 }
            r2 = 10
            r1.append(r2)     // Catch:{ IOException -> 0x0048, NotFoundException -> 0x0046 }
            goto L_0x001a
        L_0x0029:
            r4.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0031:
            r3.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0039:
            if (r8 == 0) goto L_0x00d2
            r8.close()     // Catch:{ IOException -> 0x0040 }
            goto L_0x00d2
        L_0x0040:
            r8 = move-exception
            r8.printStackTrace()
            goto L_0x00d2
        L_0x0046:
            r2 = move-exception
            goto L_0x0072
        L_0x0048:
            r2 = move-exception
            goto L_0x00a5
        L_0x004b:
            r9 = move-exception
            r4 = r2
            goto L_0x00d8
        L_0x004f:
            r4 = move-exception
            r7 = r4
            r4 = r2
            r2 = r7
            goto L_0x0072
        L_0x0054:
            r4 = move-exception
            r7 = r4
            r4 = r2
            r2 = r7
            goto L_0x00a5
        L_0x005a:
            r9 = move-exception
            r3 = r2
            goto L_0x006a
        L_0x005d:
            r3 = move-exception
            r4 = r2
            r2 = r3
            r3 = r4
            goto L_0x0072
        L_0x0062:
            r3 = move-exception
            r4 = r2
            r2 = r3
            r3 = r4
            goto L_0x00a5
        L_0x0067:
            r9 = move-exception
            r8 = r2
            r3 = r8
        L_0x006a:
            r4 = r3
            goto L_0x00d8
        L_0x006d:
            r8 = move-exception
            r3 = r2
            r4 = r3
            r2 = r8
            r8 = r4
        L_0x0072:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d7 }
            r5.<init>()     // Catch:{ all -> 0x00d7 }
            java.lang.String r6 = "readTextFileFromResource error, resource not found: "
            r5.append(r6)     // Catch:{ all -> 0x00d7 }
            r5.append(r9)     // Catch:{ all -> 0x00d7 }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x00d7 }
            com.oppo.camera.e.d(r0, r9, r2)     // Catch:{ all -> 0x00d7 }
            if (r4 == 0) goto L_0x0090
            r4.close()     // Catch:{ IOException -> 0x008c }
            goto L_0x0090
        L_0x008c:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0090:
            if (r3 == 0) goto L_0x009a
            r3.close()     // Catch:{ IOException -> 0x0096 }
            goto L_0x009a
        L_0x0096:
            r9 = move-exception
            r9.printStackTrace()
        L_0x009a:
            if (r8 == 0) goto L_0x00d2
            r8.close()     // Catch:{ IOException -> 0x0040 }
            goto L_0x00d2
        L_0x00a0:
            r8 = move-exception
            r3 = r2
            r4 = r3
            r2 = r8
            r8 = r4
        L_0x00a5:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d7 }
            r5.<init>()     // Catch:{ all -> 0x00d7 }
            java.lang.String r6 = "readTextFileFromResource error, could not open resource: "
            r5.append(r6)     // Catch:{ all -> 0x00d7 }
            r5.append(r9)     // Catch:{ all -> 0x00d7 }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x00d7 }
            com.oppo.camera.e.d(r0, r9, r2)     // Catch:{ all -> 0x00d7 }
            if (r4 == 0) goto L_0x00c3
            r4.close()     // Catch:{ IOException -> 0x00bf }
            goto L_0x00c3
        L_0x00bf:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00c3:
            if (r3 == 0) goto L_0x00cd
            r3.close()     // Catch:{ IOException -> 0x00c9 }
            goto L_0x00cd
        L_0x00c9:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00cd:
            if (r8 == 0) goto L_0x00d2
            r8.close()     // Catch:{ IOException -> 0x0040 }
        L_0x00d2:
            java.lang.String r8 = r1.toString()
            return r8
        L_0x00d7:
            r9 = move-exception
        L_0x00d8:
            if (r4 == 0) goto L_0x00e2
            r4.close()     // Catch:{ IOException -> 0x00de }
            goto L_0x00e2
        L_0x00de:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00e2:
            if (r3 == 0) goto L_0x00ec
            r3.close()     // Catch:{ IOException -> 0x00e8 }
            goto L_0x00ec
        L_0x00e8:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00ec:
            if (r8 == 0) goto L_0x00f6
            r8.close()     // Catch:{ IOException -> 0x00f2 }
            goto L_0x00f6
        L_0x00f2:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00f6:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.util.d.a(android.content.Context, int):java.lang.String");
    }

    public static int a(int i, String str) {
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
        e.e(OpenGLUtils.TAG, "loadShader, Could not compile shader " + i + ": " + GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public static int b(String str, String str2) {
        int a2 = a(35633, str);
        if (a2 == 0) {
            a("loadVertexShader");
            return 0;
        }
        int a3 = a(35632, str2);
        if (a3 == 0) {
            a("loadFragmentShader");
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram == 0) {
            a("glCreateProgram");
            return 0;
        }
        GLES20.glAttachShader(glCreateProgram, a2);
        a("glAttachVertexShader");
        GLES20.glAttachShader(glCreateProgram, a3);
        a("glAttachFragmentShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (1 == iArr[0]) {
            return glCreateProgram;
        }
        e.e(OpenGLUtils.TAG, "createProgram, Could not link program: " + GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glDeleteProgram(glCreateProgram);
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x006e A[SYNTHETIC, Splitter:B:53:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0077 A[Catch:{ Exception -> 0x007b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r5, android.content.res.Resources r6) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x007e }
            r1.<init>()     // Catch:{ Exception -> 0x007e }
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch:{ Throwable -> 0x0067, all -> 0x0064 }
            java.io.InputStream r5 = r6.open(r5)     // Catch:{ Throwable -> 0x0067, all -> 0x0064 }
        L_0x000e:
            int r6 = r5.read()     // Catch:{ Throwable -> 0x0049, all -> 0x0045 }
            r2 = -1
            if (r6 == r2) goto L_0x0019
            r1.write(r6)     // Catch:{ Throwable -> 0x0049, all -> 0x0045 }
            goto L_0x000e
        L_0x0019:
            byte[] r6 = r1.toByteArray()     // Catch:{ Throwable -> 0x0049, all -> 0x0045 }
            java.lang.String r2 = new java.lang.String     // Catch:{ Throwable -> 0x0049, all -> 0x0045 }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r6, r3)     // Catch:{ Throwable -> 0x0049, all -> 0x0045 }
            java.lang.String r6 = "\\r\\n"
            java.lang.String r3 = "\n"
            java.lang.String r6 = r2.replaceAll(r6, r3)     // Catch:{ Throwable -> 0x0043, all -> 0x003f }
            if (r5 == 0) goto L_0x0039
            r5.close()     // Catch:{ Throwable -> 0x0035, all -> 0x0032 }
            goto L_0x0039
        L_0x0032:
            r5 = move-exception
            r3 = r6
            goto L_0x006c
        L_0x0035:
            r5 = move-exception
            r0 = r5
            r3 = r6
            goto L_0x006a
        L_0x0039:
            r1.close()     // Catch:{ Exception -> 0x003d }
            goto L_0x0083
        L_0x003d:
            r5 = move-exception
            goto L_0x0080
        L_0x003f:
            r6 = move-exception
            r3 = r2
            r2 = r0
            goto L_0x0051
        L_0x0043:
            r6 = move-exception
            goto L_0x004b
        L_0x0045:
            r6 = move-exception
            r2 = r0
            r3 = r2
            goto L_0x0051
        L_0x0049:
            r6 = move-exception
            r2 = r0
        L_0x004b:
            throw r6     // Catch:{ all -> 0x004c }
        L_0x004c:
            r3 = move-exception
            r4 = r2
            r2 = r6
            r6 = r3
            r3 = r4
        L_0x0051:
            if (r5 == 0) goto L_0x0061
            if (r2 == 0) goto L_0x005e
            r5.close()     // Catch:{ Throwable -> 0x0059 }
            goto L_0x0061
        L_0x0059:
            r5 = move-exception
            r2.addSuppressed(r5)     // Catch:{ Throwable -> 0x0062 }
            goto L_0x0061
        L_0x005e:
            r5.close()     // Catch:{ Throwable -> 0x0062 }
        L_0x0061:
            throw r6     // Catch:{ Throwable -> 0x0062 }
        L_0x0062:
            r5 = move-exception
            goto L_0x0069
        L_0x0064:
            r5 = move-exception
            r3 = r0
            goto L_0x006c
        L_0x0067:
            r5 = move-exception
            r3 = r0
        L_0x0069:
            r0 = r5
        L_0x006a:
            throw r0     // Catch:{ all -> 0x006b }
        L_0x006b:
            r5 = move-exception
        L_0x006c:
            if (r0 == 0) goto L_0x0077
            r1.close()     // Catch:{ Throwable -> 0x0072 }
            goto L_0x007a
        L_0x0072:
            r6 = move-exception
            r0.addSuppressed(r6)     // Catch:{ Exception -> 0x007b }
            goto L_0x007a
        L_0x0077:
            r1.close()     // Catch:{ Exception -> 0x007b }
        L_0x007a:
            throw r5     // Catch:{ Exception -> 0x007b }
        L_0x007b:
            r5 = move-exception
            r6 = r3
            goto L_0x0080
        L_0x007e:
            r5 = move-exception
            r6 = r0
        L_0x0080:
            r5.printStackTrace()
        L_0x0083:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.util.d.a(java.lang.String, android.content.res.Resources):java.lang.String");
    }

    public static void a(int[] iArr, int[] iArr2, int i, int i2) {
        GLES31.glGenFramebuffers(iArr.length, iArr, 0);
        GLES31.glGenTextures(iArr2.length, iArr2, 0);
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            GLES31.glBindTexture(3553, iArr2[i3]);
            GLES31.glTexStorage2D(3553, 1, 32856, i, i2);
            GLES31.glTexParameterf(3553, 10240, 9729.0f);
            GLES31.glTexParameterf(3553, 10241, 9729.0f);
            GLES31.glTexParameterf(3553, 10242, 33071.0f);
            GLES31.glTexParameterf(3553, 10243, 33071.0f);
            GLES31.glBindFramebuffer(36160, iArr[i3]);
            GLES31.glFramebufferTexture2D(36160, 36064, 3553, iArr2[i3], 0);
            GLES31.glBindTexture(3553, 0);
            GLES31.glBindFramebuffer(36160, 0);
        }
        a("createStorageFrameBuffer");
    }

    public static FloatBuffer a(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }
}
