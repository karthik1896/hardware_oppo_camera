package com.oppo.camera.doubleexposure;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.meicam.sdk.NvsAVFileInfo;
import com.meicam.sdk.NvsAudioResolution;
import com.meicam.sdk.NvsMultiThumbnailSequenceView;
import com.meicam.sdk.NvsRational;
import com.meicam.sdk.NvsSize;
import com.meicam.sdk.NvsStreamingContext;
import com.meicam.sdk.NvsTimeline;
import com.meicam.sdk.NvsVideoClip;
import com.meicam.sdk.NvsVideoResolution;
import com.meicam.sdk.NvsVideoTrack;
import com.oppo.camera.R;
import com.oppo.camera.ui.widget.e;
import com.oppo.camera.util.h;
import java.util.ArrayList;

/* compiled from: VideoClipManager */
public class g implements NvsStreamingContext.PlaybackCallback2, e.a {

    /* renamed from: a  reason: collision with root package name */
    private String f2822a = "";

    /* renamed from: b  reason: collision with root package name */
    private NvsStreamingContext f2823b = null;
    private NvsTimeline c = null;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private e g = null;
    private Activity h = null;
    private com.oppo.camera.ui.e i = null;
    private Handler j = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                g.this.m();
            } else if (i == 2) {
                g.this.l();
            }
        }
    };

    /* compiled from: VideoClipManager */
    public interface a {
        void onVideoClipDone();
    }

    public g(ViewGroup viewGroup, Activity activity, com.oppo.camera.ui.e eVar) {
        this.h = activity;
        this.i = eVar;
        this.f2823b = NvsStreamingContext.getInstance();
        this.g = (e) viewGroup.findViewById(R.id.video_clip_view);
        this.g.setSeekToCallback(this);
        this.f2823b.setPlaybackCallback2(this);
        this.f2823b.setPlaybackCallback(new NvsStreamingContext.PlaybackCallback() {
            public void onPlaybackPreloadingCompletion(NvsTimeline nvsTimeline) {
                com.oppo.camera.e.e("VideoClipManager", "onPlaybackPreloadingCompletion");
            }

            public void onPlaybackStopped(NvsTimeline nvsTimeline) {
                com.oppo.camera.e.e("VideoClipManager", "onPlaybackStopped");
            }

            public void onPlaybackEOF(NvsTimeline nvsTimeline) {
                com.oppo.camera.e.e("VideoClipManager", "onPlaybackEOF");
                g.this.f();
            }
        });
    }

    public boolean a(String str) {
        NvsTimeline nvsTimeline = this.c;
        if (nvsTimeline != null) {
            this.f2823b.removeTimeline(nvsTimeline);
        }
        this.f2822a = str;
        NvsAVFileInfo aVFileInfo = this.f2823b.getAVFileInfo(this.f2822a);
        if (aVFileInfo != null) {
            NvsSize videoStreamDimension = aVFileInfo.getVideoStreamDimension(0);
            NvsRational videoStreamFrameRate = aVFileInfo.getVideoStreamFrameRate(0);
            if (videoStreamDimension != null) {
                int videoStreamRotation = aVFileInfo.getVideoStreamRotation(0);
                if (1 == videoStreamRotation || 3 == videoStreamRotation) {
                    this.d = videoStreamDimension.width;
                    this.e = videoStreamDimension.height;
                } else {
                    this.d = videoStreamDimension.height;
                    this.e = videoStreamDimension.width;
                }
            }
            if (videoStreamFrameRate != null) {
                this.f = videoStreamFrameRate.num;
            }
        }
        NvsVideoResolution nvsVideoResolution = new NvsVideoResolution();
        nvsVideoResolution.imagePAR = new NvsRational(1, 1);
        NvsRational nvsRational = new NvsRational(30, 1);
        nvsVideoResolution.imageWidth = this.e;
        nvsVideoResolution.imageHeight = this.d;
        NvsAudioResolution nvsAudioResolution = new NvsAudioResolution();
        nvsAudioResolution.sampleRate = 44100;
        nvsAudioResolution.channelCount = 2;
        this.c = this.f2823b.createTimeline(nvsVideoResolution, nvsRational, nvsAudioResolution);
        NvsTimeline nvsTimeline2 = this.c;
        if (nvsTimeline2 == null || aVFileInfo == null) {
            com.oppo.camera.e.a("VideoClipManager", "setFilePath, video parsing failure");
            h.a(this.h, R.string.mode_double_exposure_video_cannot_resolve);
            com.oppo.camera.ui.e eVar = this.i;
            if (eVar != null) {
                eVar.t((int) R.string.mode_double_exposure_video_cannot_resolve);
            }
            return false;
        }
        this.f2822a = str;
        NvsVideoTrack appendVideoTrack = nvsTimeline2.appendVideoTrack();
        appendVideoTrack.appendClip(this.f2822a);
        this.f2823b.connectTimelineWithLiveWindow(this.c, this.g.getLiveWindow());
        this.g.getThumbnail().setThumbnailImageFillMode(1);
        this.g.getThumbnail().setThumbnailAspectRatio(1.0f);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < appendVideoTrack.getClipCount(); i2++) {
            NvsVideoClip clipByIndex = appendVideoTrack.getClipByIndex(i2);
            if (clipByIndex != null) {
                NvsMultiThumbnailSequenceView.ThumbnailSequenceDesc thumbnailSequenceDesc = new NvsMultiThumbnailSequenceView.ThumbnailSequenceDesc();
                thumbnailSequenceDesc.mediaFilePath = clipByIndex.getFilePath();
                thumbnailSequenceDesc.trimIn = clipByIndex.getTrimIn();
                thumbnailSequenceDesc.trimOut = clipByIndex.getTrimOut();
                thumbnailSequenceDesc.inPoint = clipByIndex.getInPoint();
                thumbnailSequenceDesc.outPoint = clipByIndex.getOutPoint();
                thumbnailSequenceDesc.stillImageHint = false;
                arrayList.add(thumbnailSequenceDesc);
            }
        }
        com.oppo.camera.e.b("VideoClipManager", "setFilePath: " + this.f2822a + " info: " + aVFileInfo);
        this.g.getThumbnail().setThumbnailSequenceDescArray(arrayList);
        m();
        try {
            this.g.a(this.e, this.d);
            this.g.setTotalTime(this.c.getDuration());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        b(0.0f);
        f();
        return true;
    }

    public void a() {
        this.g.setVisibility(0);
    }

    public void b() {
        this.f2822a = null;
        this.c = null;
        this.g.setVisibility(8);
        this.f2823b.pausePlayback();
        this.f2823b.stop();
    }

    public void a(boolean z) {
        this.f2822a = null;
        this.c = null;
        this.g.a(z);
        this.f2823b.pausePlayback();
        this.f2823b.stop();
    }

    public void c() {
        this.f2823b.pausePlayback();
    }

    public void d() {
        this.f2823b.stop();
        this.h = null;
        this.i = null;
        this.g = null;
        this.f2823b = null;
    }

    public void e() {
        if (o()) {
            f();
        } else {
            b();
        }
    }

    public void f() {
        a(-1.0f);
    }

    public void a(float f2) {
        if (this.c != null) {
            this.f2823b.setAudioOutputDeviceVolume(0.0f);
            if (0.0f >= f2) {
                f2 = this.g.getLeftVideoProcess();
            }
            if (f2 > this.g.getRightVideoProcess()) {
                f2 = this.g.getLeftVideoProcess();
            }
            this.f2823b.playbackTimeline(this.c, (long) (f2 * ((float) this.c.getDuration())), (long) (this.g.getRightVideoProcess() * ((float) this.c.getDuration())), 1, true, 0);
        }
    }

    public void g() {
        this.j.removeMessages(1);
        this.j.sendEmptyMessage(1);
    }

    public boolean b(float f2) {
        if (this.c == null) {
            return false;
        }
        this.f2823b.stopRecording();
        NvsStreamingContext nvsStreamingContext = this.f2823b;
        NvsTimeline nvsTimeline = this.c;
        return nvsStreamingContext.seekTimeline(nvsTimeline, (long) (f2 * ((float) nvsTimeline.getDuration())), 1, 2);
    }

    public void h() {
        this.j.sendEmptyMessage(2);
    }

    public void a(String str, NvsStreamingContext.CompileCallback2 compileCallback2) {
        this.f2823b.pausePlayback();
        this.f2823b.setCompileCallback2(compileCallback2);
        if (this.f2823b.compileTimeline(this.c, (long) (this.g.getLeftVideoProcess() * ((float) this.c.getDuration())), (long) (this.g.getRightVideoProcess() * ((float) this.c.getDuration())), str, 256, 2, 0)) {
            h();
        }
    }

    public String i() {
        return this.f2822a;
    }

    public b j() {
        long leftVideoProcess = ((long) (this.g.getLeftVideoProcess() * ((float) this.c.getDuration()))) / 1000;
        long rightVideoProcess = ((long) (this.g.getRightVideoProcess() * ((float) this.c.getDuration()))) / 1000;
        b bVar = new b(this.f2822a, leftVideoProcess, rightVideoProcess, true);
        bVar.a(this.f);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.d);
        stringBuffer.append("x");
        stringBuffer.append(this.e);
        bVar.a(stringBuffer.toString());
        com.oppo.camera.e.b("VideoClipManager", "getClipVideoInfo startTime: " + leftVideoProcess + ", endTime: " + rightVideoProcess);
        return bVar;
    }

    public void onPlaybackTimelinePosition(NvsTimeline nvsTimeline, long j2) {
        this.g.setThumbProcess((((float) j2) * 1.0f) / ((float) nvsTimeline.getDuration()));
    }

    public void c(float f2) {
        if (!TextUtils.isEmpty(this.f2822a)) {
            b(f2);
        }
    }

    public void d(float f2) {
        a(f2);
    }

    public void k() {
        com.oppo.camera.ui.e eVar = this.i;
        if (eVar != null) {
            eVar.a(R.string.camera_double_exposure_max_recording_hint, 0, true, false, false, false, false, true, 5000);
        }
    }

    public void l() {
        this.g.a();
    }

    public void m() {
        this.g.b();
    }

    public boolean n() {
        return this.g.c();
    }

    public boolean o() {
        return this.g.d();
    }

    public void a(e.b bVar) {
        this.g.setVideoClipClick(bVar);
    }

    public void a(int i2) {
        e eVar = this.g;
        if (eVar != null) {
            eVar.setOrientation(i2);
        }
    }
}
