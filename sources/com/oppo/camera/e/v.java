package com.oppo.camera.e;

import android.hardware.HardwareBuffer;
import android.media.CamcorderProfile;
import android.media.MediaCodec;
import android.media.MediaRecorder;
import android.view.Surface;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.gl.q;
import com.oppo.camera.statistics.model.VideoRecordMsgData;
import com.oppo.camera.util.Util;
import com.oppo.camera.z;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: VideoRecorder */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public static float f2936a;

    /* renamed from: b  reason: collision with root package name */
    public int f2937b = 0;
    private boolean c = false;
    private MediaRecorder d = null;
    private c e = null;
    /* access modifiers changed from: private */
    public g f = null;
    /* access modifiers changed from: private */
    public e g = null;
    /* access modifiers changed from: private */
    public f h = null;
    /* access modifiers changed from: private */
    public d i = null;

    /* compiled from: VideoRecorder */
    public interface d {
        long a(MediaCodec.BufferInfo bufferInfo);
    }

    /* compiled from: VideoRecorder */
    public interface e {
        void a(Object obj, int i, int i2);
    }

    /* compiled from: VideoRecorder */
    public interface f {
        void F(int i);
    }

    /* compiled from: VideoRecorder */
    public interface g {
        void b(Object obj, int i, int i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002f A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String c(int r5, int r6) {
        /*
            r4 = this;
            r0 = 270(0x10e, float:3.78E-43)
            r1 = 180(0xb4, float:2.52E-43)
            r2 = 90
            if (r5 != 0) goto L_0x001a
            if (r6 == 0) goto L_0x0017
            if (r6 == r2) goto L_0x0014
            if (r6 == r1) goto L_0x0017
            if (r6 == r0) goto L_0x0011
            goto L_0x002f
        L_0x0011:
            java.lang.String r5 = "1"
            goto L_0x0031
        L_0x0014:
            java.lang.String r5 = "2"
            goto L_0x0031
        L_0x0017:
            java.lang.String r5 = "3"
            goto L_0x0031
        L_0x001a:
            r3 = 1
            if (r5 != r3) goto L_0x002f
            if (r6 == 0) goto L_0x002c
            if (r6 == r2) goto L_0x0029
            if (r6 == r1) goto L_0x002c
            if (r6 == r0) goto L_0x0026
            goto L_0x002f
        L_0x0026:
            java.lang.String r5 = "5"
            goto L_0x0031
        L_0x0029:
            java.lang.String r5 = "6"
            goto L_0x0031
        L_0x002c:
            java.lang.String r5 = "4"
            goto L_0x0031
        L_0x002f:
            java.lang.String r5 = ""
        L_0x0031:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.v.c(int, int):java.lang.String");
    }

    public v(boolean z, float f2) {
        this.c = z;
        f2936a = f2 * 10.0f;
        g();
    }

    private void g() {
        if (this.c) {
            this.e = new c();
            this.e.a((d) new a());
            this.e.a("on".equals(z.e()));
        } else {
            this.d = new MediaRecorder();
            this.d.setOnInfoListener(new c());
            this.d.setOnErrorListener(new b());
        }
        com.oppo.camera.e.e("VideoRecorder", "init, mbUseCameraMediaCodec: " + this.c);
    }

    /* compiled from: VideoRecorder */
    private class c implements MediaRecorder.OnInfoListener {
        private c() {
        }

        public void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
            if (v.this.f != null) {
                v.this.f.b(mediaRecorder, i, i2);
            }
        }
    }

    /* compiled from: VideoRecorder */
    private class b implements MediaRecorder.OnErrorListener {
        private b() {
        }

        public void onError(MediaRecorder mediaRecorder, int i, int i2) {
            if (v.this.g != null) {
                v.this.g.a(mediaRecorder, i, i2);
            }
        }
    }

    /* compiled from: VideoRecorder */
    private class a implements d {
        private a() {
        }

        public void a(c cVar, int i, int i2) {
            if (v.this.f != null) {
                v.this.f.b(cVar, i, i2);
            }
        }

        public void b(c cVar, int i, int i2) {
            if (v.this.g != null) {
                v.this.g.a(cVar, i, i2);
            }
        }

        public void a(int i) {
            if (v.this.h != null) {
                v.this.h.F(i);
            }
        }

        public long a(MediaCodec.BufferInfo bufferInfo) {
            if (v.this.i != null) {
                return v.this.i.a(bufferInfo);
            }
            return -1;
        }
    }

    public boolean a() {
        if (this.c) {
            return this.e.c();
        }
        this.d.start();
        return true;
    }

    public boolean b() {
        if (this.c) {
            this.e.a((d) null);
            return this.e.d();
        }
        this.d.setOnInfoListener((MediaRecorder.OnInfoListener) null);
        this.d.setOnErrorListener((MediaRecorder.OnErrorListener) null);
        this.d.stop();
        return true;
    }

    public boolean c() {
        if (this.c) {
            this.e = null;
        } else {
            this.d.reset();
            this.d.release();
            this.d = null;
        }
        com.oppo.camera.e.e("VideoRecorder", "release, mbUseCameraMediaCodec: " + this.c);
        return true;
    }

    public void a(int i2) {
        if (!this.c) {
            this.d.setAudioSource(i2);
        }
    }

    public void a(Surface surface) {
        if (!this.c) {
            this.d.setInputSurface(surface);
        }
    }

    public void b(int i2) {
        if (this.c) {
            this.e.h(i2);
        } else {
            this.d.setAudioEncodingBitRate(i2);
        }
    }

    public void c(int i2) {
        if (this.c) {
            this.e.i(i2);
        } else {
            this.d.setAudioChannels(i2);
        }
    }

    public void d(int i2) {
        if (this.c) {
            this.e.j(i2);
        } else {
            this.d.setAudioSamplingRate(i2);
        }
    }

    public void e(int i2) {
        if (this.c) {
            this.e.k(i2);
        } else {
            this.d.setAudioEncoder(i2);
        }
    }

    public void f(int i2) {
        if (!this.c) {
            this.d.setVideoSource(i2);
        }
    }

    public void a(CamcorderProfile camcorderProfile) {
        if (this.c) {
            this.e.a(camcorderProfile);
        } else {
            this.d.setProfile(camcorderProfile);
        }
    }

    public void g(int i2) {
        if (this.c) {
            this.e.d(i2);
        } else {
            this.d.setVideoEncodingBitRate(i2);
        }
    }

    public void h(int i2) {
        if (this.c) {
            if (i2 == 2) {
                i2 = 0;
            }
            this.e.f(i2);
            return;
        }
        this.d.setOutputFormat(i2);
    }

    public void i(int i2) {
        if (this.c) {
            this.e.e(i2);
        } else {
            this.d.setVideoFrameRate(i2);
        }
    }

    public void a(int i2, int i3) {
        if (this.c) {
            this.e.a(i2, i3);
        } else {
            this.d.setVideoSize(i2, i3);
        }
    }

    public void j(int i2) {
        if (this.c) {
            this.e.g(i2);
        } else {
            this.d.setVideoEncoder(i2);
        }
    }

    public void k(int i2) {
        if (this.c) {
            this.e.b(i2);
        }
    }

    public void b(int i2, int i3) {
        if (!this.c) {
            this.d.setVideoEncodingProfileLevel(i2, i3);
        }
    }

    public void a(float f2, float f3) {
        if (this.c) {
            this.e.a(f2, f3);
        } else {
            this.d.setLocation(f2, f3);
        }
    }

    public void l(int i2) {
        if (this.c) {
            this.e.a((long) i2);
        } else {
            this.d.setMaxDuration(i2);
        }
    }

    public void a(String str, String str2, int i2, int i3) {
        String c2 = c(i2, i3);
        if (this.c) {
            this.e.c(c2);
            this.e.a(str2);
            this.e.b(str);
            return;
        }
        a(str, str2, c2);
    }

    public void a(String str, String str2, String str3) {
        if (VideoRecordMsgData.END_TYPE_NORMAL.equals(str2)) {
            a("vendor.ozoaudio.device.value", "");
            a("vendor.ozoaudio.focus-mode.value", "off");
        } else if (ApsConstant.CAPTURE_MODE_PANORAMA.equals(str2)) {
            a("vendor.ozoaudio.device.value", str3);
            a("vendor.ozoaudio.focus-mode.value", "on");
        } else if ("focusing".equals(str2)) {
            a("vendor.ozoaudio.device.value", str3);
            a("vendor.ozoaudio.focus-mode.value", "on");
            a("vendor.ozoaudio.focus-gain.value", String.valueOf(Util.k(this.f2937b)));
        }
        if (Util.q()) {
            a("vendor.ozoaudio.wnr-mode.value", str);
        }
    }

    public void a(String str, String str2) {
        b("setParameter", str, str2);
    }

    public void b(String str, String str2, String str3) {
        Method method;
        try {
            method = MediaRecorder.class.getDeclaredMethod(str, new Class[]{String.class});
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            method = null;
        }
        method.setAccessible(true);
        try {
            if (this.d != null) {
                MediaRecorder mediaRecorder = this.d;
                method.invoke(mediaRecorder, new Object[]{str2 + "=" + str3});
            }
            method.setAccessible(false);
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    public void m(int i2) {
        com.oppo.camera.e.c("VideoRecorder", "setFocusingSoundVolume, soundVolume: " + i2);
        if (this.c) {
            c cVar = this.e;
            if (cVar != null) {
                cVar.a(i2);
                this.e.l(i2);
                return;
            }
            return;
        }
        this.f2937b = i2;
        a("vendor.ozoaudio.focus-gain.value", String.valueOf(Util.k(this.f2937b)));
    }

    public void n(int i2) {
        com.oppo.camera.e.a("VideoRecorder", "setVideoMirror, mirrorType: " + i2);
        if (this.d == null || this.c) {
            com.oppo.camera.e.e("VideoRecorder", "setVideoMirror, mMediaRecorder: " + this.d + ", mbUseCameraMediaCodec: " + this.c);
            return;
        }
        try {
            Method declaredMethod = MediaRecorder.class.getDeclaredMethod("setParameter", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            MediaRecorder mediaRecorder = this.d;
            declaredMethod.invoke(mediaRecorder, new Object[]{"set-video-mirror=" + i2});
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            com.oppo.camera.e.d("VideoRecorder", "setVideoMirror, NoSuchMethodException", e2);
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            com.oppo.camera.e.d("VideoRecorder", "setVideoMirror, InvocationTargetException", e3);
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
            com.oppo.camera.e.d("VideoRecorder", "setVideoMirror, IllegalAccessException", e4);
        }
    }

    public void d(int i2, int i3) {
        if (this.c) {
            this.e.c(i2);
        } else {
            this.d.setOrientationHint(com.oppo.camera.f.a.b(i3, i2));
        }
    }

    public void a(FileDescriptor fileDescriptor) {
        com.oppo.camera.e.a("VideoRecorder", "setOutputFile, fileDescriptor: " + fileDescriptor);
        if (this.c) {
            this.e.a(fileDescriptor);
        } else {
            this.d.setOutputFile(fileDescriptor);
        }
    }

    public void a(String str) {
        com.oppo.camera.e.a("VideoRecorder", "setOutputFile, path: " + str);
        if (this.c) {
            this.e.d(str);
        } else {
            this.d.setOutputFile(str);
        }
    }

    public void a(double d2) {
        if (!this.c) {
            this.d.setCaptureRate(d2);
        }
    }

    public void a(long j) {
        if (this.c) {
            this.e.b(j);
        } else {
            this.d.setMaxFileSize(j);
        }
    }

    public void a(e eVar) {
        this.g = eVar;
    }

    public void a(g gVar) {
        this.f = gVar;
    }

    public void a(f fVar) {
        this.h = fVar;
    }

    public void a(d dVar) {
        this.i = dVar;
    }

    public void a(q qVar) {
        if (this.c) {
            this.e.a(qVar);
        }
    }

    public void b(String str) {
        com.oppo.camera.e.e("VideoRecorder", "writeExifTag, exifInfo: " + str);
        if (this.d != null && !this.c) {
            try {
                Method declaredMethod = MediaRecorder.class.getDeclaredMethod("setParameter", new Class[]{String.class});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.d, new Object[]{"set-title=".concat(str)});
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
            }
        }
    }

    public void c(String str) {
        com.oppo.camera.e.e("VideoRecorder", "setMediaRecorderParameter, parameter: " + str);
        if (this.d != null && !this.c) {
            try {
                Method declaredMethod = MediaRecorder.class.getDeclaredMethod("setParameter", new Class[]{String.class});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.d, new Object[]{str});
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
            }
        }
    }

    public void d() throws IOException {
        if (this.c) {
            this.e.b();
        } else {
            this.d.prepare();
        }
    }

    public boolean e() {
        try {
            if (this.c) {
                this.e.f();
                return true;
            }
            this.d.resume();
            return true;
        } catch (RuntimeException e2) {
            com.oppo.camera.e.e("VideoRecorder", "resume, Could not resume video recorder");
            e2.printStackTrace();
            return false;
        }
    }

    public boolean f() {
        try {
            if (this.c) {
                this.e.e();
                return true;
            }
            this.d.pause();
            return true;
        } catch (RuntimeException e2) {
            e2.printStackTrace();
            com.oppo.camera.e.e("VideoRecorder", "pause, Could not pause video recorder");
            return false;
        }
    }

    public void o(int i2) {
        if (this.c) {
            this.e.c(i2);
        }
    }

    public void a(boolean z) {
        if (this.c) {
            this.e.b(z);
        }
    }

    public void b(boolean z) {
        if (this.c) {
            this.e.c(z);
        }
    }

    public void c(boolean z) {
        if (this.c) {
            this.e.d(z);
        }
    }

    public void a(HardwareBuffer hardwareBuffer) {
        if (this.c) {
            this.e.a(hardwareBuffer);
        }
    }
}
