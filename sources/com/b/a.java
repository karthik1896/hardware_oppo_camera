package com.b;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.meicam.sdk.NvsAVFileInfo;
import com.meicam.sdk.NvsAudioResolution;
import com.meicam.sdk.NvsRational;
import com.meicam.sdk.NvsStreamingContext;
import com.meicam.sdk.NvsTimeline;
import com.meicam.sdk.NvsVideoClip;
import com.meicam.sdk.NvsVideoResolution;
import com.meicam.sdk.NvsVideoTrack;
import com.oppo.camera.e;
import com.oppo.camera.jni.YuvProcessUtil;
import java.util.Hashtable;

/* compiled from: MeicamVideoEngine */
public class a implements NvsStreamingContext.CompileCallback {

    /* renamed from: a  reason: collision with root package name */
    private long f1853a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1854b = true;
    private Activity c;
    private b d;
    private NvsStreamingContext e;
    private NvsTimeline f;
    private NvsVideoTrack g;

    private boolean b(int i) {
        if (i == 0) {
            return true;
        }
        if (i != 90) {
            if (i == 180) {
                return true;
            }
            if (i != 270) {
                return true;
            }
        }
        return false;
    }

    public a(Activity activity, b bVar) {
        this.c = activity;
        this.d = bVar;
        d();
    }

    private void d() {
        this.e = NvsStreamingContext.init(this.c, "assets:/9403-322-6dd69a7f2c6c8d1bbd304bd35a8a543b.lic");
        if (this.e == null) {
            Log.e("MeicamVideoEngine", "NvsStreamingContext onCreate: init fail !!!");
        } else {
            Log.d("MeicamVideoEngine", "NvsStreamingContext onCreate: init successful");
        }
    }

    public boolean a(int i) {
        if (this.e == null) {
            return false;
        }
        if (this.f != null && this.f1854b == b(i)) {
            return false;
        }
        e.b("MeicamVideoEngine", "initTimeline orientation: " + i + ", mbVideoOrientationPortrait: " + this.f1854b + " -> " + b(i));
        this.f1854b = b(i);
        NvsRational nvsRational = new NvsRational(30, 1);
        NvsAudioResolution nvsAudioResolution = new NvsAudioResolution();
        nvsAudioResolution.sampleRate = 44100;
        nvsAudioResolution.channelCount = 2;
        NvsVideoResolution nvsVideoResolution = new NvsVideoResolution();
        nvsVideoResolution.imagePAR = new NvsRational(1, 1);
        if (b(i)) {
            nvsVideoResolution.imageWidth = 720;
            nvsVideoResolution.imageHeight = 1280;
        } else {
            nvsVideoResolution.imageWidth = 1280;
            nvsVideoResolution.imageHeight = 720;
        }
        if (this.f != null) {
            this.e.stop(1);
            this.e.removeTimeline(this.f);
            this.e.clearCachedResources(false);
            this.f = null;
            e.b("MeicamVideoEngine", "orientation changed, need initTimeline again!");
        }
        this.f = this.e.createTimeline(nvsVideoResolution, nvsRational, nvsAudioResolution);
        this.g = this.f.appendVideoTrack();
        this.e.setCompileCallback(this);
        return true;
    }

    public boolean a(String str, String str2, int i) {
        boolean z;
        String str3 = str;
        String str4 = str2;
        int i2 = i;
        if (this.e == null || this.f == null || TextUtils.isEmpty(str)) {
            e.e("MeicamVideoEngine", "compileSlowMotion return !");
            return false;
        }
        this.f1853a = System.currentTimeMillis();
        e.e("MeicamVideoEngine", "compileSlowMotion original contentUri: " + str3 + ", compileUri = " + str4);
        this.e.clearCachedResources(false);
        this.e.setMediaCodecVideoDecodingOperatingRate(str3, 240);
        this.e.enableGetAVFileInfoFromMediaExtractor(str3);
        NvsAVFileInfo aVFileInfo = this.e.getAVFileInfo(str3);
        if (aVFileInfo == null || aVFileInfo.getVideoStreamCount() == 0) {
            e.e("MeicamVideoEngine", "compileSlowMotion return for nvsAVFileInfo!");
            return false;
        }
        if (this.g.getClipCount() > 0) {
            this.g.removeAllClips();
        }
        int i3 = 32000000 / i2;
        int i4 = 8000000 / i2;
        double d2 = (double) i2;
        double d3 = 32.0d / d2;
        e.b("MeicamVideoEngine", "compileSlowMotion, clipHeadTime: " + i3 + ", clipMiddleTime: " + i4 + ", clipTailTime: " + i3 + ", clipChangeSpeed: " + d3);
        NvsAVFileInfo nvsAVFileInfo = aVFileInfo;
        long j = (long) i3;
        double d4 = d3;
        NvsVideoClip appendClip = this.g.appendClip(str, 0, j);
        if (appendClip != null) {
            appendClip.changeSpeed(d4);
        }
        int i5 = i4 + i3;
        long j2 = (long) (i3 + i5);
        long j3 = (long) i5;
        double d5 = d4;
        long j4 = j2;
        long j5 = j;
        long videoStreamDuration = nvsAVFileInfo.getVideoStreamDuration(0);
        NvsVideoClip appendClip2 = this.g.appendClip(str, j5, j3);
        if (appendClip2 != null) {
            appendClip2.changeSpeed(1.0d / d2);
        }
        NvsVideoClip appendClip3 = this.g.appendClip(str, j3, j4 > videoStreamDuration ? videoStreamDuration : j4);
        e.b("MeicamVideoEngine", "compileSlowMotion, videoStreamDuration: " + videoStreamDuration + ", videoStreamCompileEnd: " + j4);
        if (appendClip3 != null) {
            appendClip3.changeSpeed(d5);
        }
        this.g.setBuiltinTransition(0, (String) null);
        this.g.setBuiltinTransition(1, (String) null);
        this.g.setBuiltinTransition(2, (String) null);
        int streamingEngineState = this.e.getStreamingEngineState();
        e.e("MeicamVideoEngine", "compileSlowMotion, showResult mCompilePath: " + str2 + ", state: " + streamingEngineState);
        if (streamingEngineState == 0 || streamingEngineState == 4) {
            Hashtable hashtable = new Hashtable();
            hashtable.put("bitrate", Integer.valueOf(YuvProcessUtil.ExifInfo.EXPOSURE_BIAS_MULTIPLE));
            this.e.setCompileConfigurations(hashtable);
            NvsStreamingContext nvsStreamingContext = this.e;
            NvsTimeline nvsTimeline = this.f;
            z = nvsStreamingContext.compileTimeline(nvsTimeline, 0, nvsTimeline.getDuration(), str2, 4, 2, 0);
        } else {
            if (streamingEngineState == 5) {
                this.e.stop();
            }
            z = false;
        }
        e.b("MeicamVideoEngine", "compileSlowMotion, compileTimeline compileResult: " + z);
        return z;
    }

    public void a() {
        e.a("MeicamVideoEngine", "stopMeicamVideoEngine");
        this.e.stop(1);
    }

    public void b() {
        e.e("MeicamVideoEngine", "releaseMeicamVideoEngine start");
        this.e.stop(1);
        this.e.removeTimeline(this.f);
        this.e.clearCachedResources(false);
        this.e = null;
        this.g = null;
        this.f = null;
        this.d = null;
        e.e("MeicamVideoEngine", "releaseMeicamVideoEngine X");
    }

    public void onCompileProgress(NvsTimeline nvsTimeline, int i) {
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(1);
        }
    }

    public void onCompileFinished(NvsTimeline nvsTimeline) {
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(2);
        }
    }

    public void onCompileFailed(NvsTimeline nvsTimeline) {
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(3);
        }
    }

    public long c() {
        return this.f1853a;
    }
}
