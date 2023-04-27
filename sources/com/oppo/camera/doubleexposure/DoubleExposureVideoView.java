package com.oppo.camera.doubleexposure;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.oppo.camera.R;
import com.oppo.camera.e;

public class DoubleExposureVideoView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private VideoView f2801a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ImageView f2802b = null;
    /* access modifiers changed from: private */
    public Uri c = null;
    private Thread d = null;
    /* access modifiers changed from: private */
    public a e = null;
    /* access modifiers changed from: private */
    public Handler f = new Handler(Looper.getMainLooper());
    private boolean g = false;
    private Runnable h = new Runnable() {
        public void run() {
            if (DoubleExposureVideoView.this.c != null) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(DoubleExposureVideoView.this.getContext(), DoubleExposureVideoView.this.c);
                try {
                    final Bitmap frameAtIndex = mediaMetadataRetriever.getFrameAtIndex(2);
                    if (!(frameAtIndex == null || DoubleExposureVideoView.this.f == null)) {
                        DoubleExposureVideoView.this.f.post(new Runnable() {
                            public void run() {
                                if (DoubleExposureVideoView.this.f2802b != null) {
                                    DoubleExposureVideoView.this.f2802b.setImageBitmap(frameAtIndex);
                                }
                                if (DoubleExposureVideoView.this.e != null) {
                                    DoubleExposureVideoView.this.e.a(frameAtIndex);
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (DoubleExposureVideoView.this.e != null) {
                        DoubleExposureVideoView.this.e.a();
                    }
                    e.e("DoubleExposureVideoView", "LoadThumbTask error " + e.toString());
                } catch (Throwable th) {
                    mediaMetadataRetriever.close();
                    throw th;
                }
                mediaMetadataRetriever.close();
            }
        }
    };

    public interface a {
        void a();

        void a(Bitmap bitmap);
    }

    public DoubleExposureVideoView(Context context) {
        super(context);
        c();
    }

    public DoubleExposureVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public DoubleExposureVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    private void c() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.common_bottom_double_exposure_video_layout, this, false);
        this.f2801a = (VideoView) inflate.findViewById(R.id.videoView);
        this.f2802b = (ImageView) inflate.findViewById(R.id.iv_video_thumb);
        this.f2801a.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                if (3 != i || DoubleExposureVideoView.this.f2802b == null) {
                    return true;
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(DoubleExposureVideoView.this.f2802b, "alpha", new float[]{1.0f, 0.0f});
                ofFloat.setDuration(100);
                ofFloat.setRepeatCount(0);
                ofFloat.start();
                return true;
            }
        });
        this.f2801a.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
        addView(inflate);
        this.f2801a.setEnabled(false);
        this.f2801a.setZOrderOnTop(false);
        AnonymousClass3 r0 = new ViewOutlineProvider() {
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(new Rect(0, 0, view.getWidth(), view.getHeight()), view.getContext().getResources().getDimension(R.dimen.common_bottom_guide_background_radius));
            }
        };
        this.f2801a.setOutlineProvider(r0);
        ImageView imageView = this.f2802b;
        if (imageView != null) {
            imageView.setOutlineProvider(r0);
        }
        this.f2801a.setClipToOutline(true);
        ImageView imageView2 = this.f2802b;
        if (imageView2 != null) {
            imageView2.setClipToOutline(true);
        }
    }

    public void setVideoUri(Uri uri) {
        this.c = uri;
        this.f2801a.setVideoURI(this.c);
        if (!this.g) {
            this.d = new Thread(this.h);
            this.d.start();
        }
    }

    public void setVideoThumb(Bitmap bitmap) {
        this.g = true;
        this.f2802b.setImageBitmap(bitmap);
    }

    public void a() {
        VideoView videoView;
        if (this.c != null && (videoView = this.f2801a) != null && !videoView.isPlaying()) {
            this.f2801a.seekTo(0);
            this.f2801a.start();
        }
    }

    public void b() {
        VideoView videoView = this.f2801a;
        if (videoView != null) {
            videoView.pause();
        }
        ImageView imageView = this.f2802b;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.f2802b.setAlpha(1.0f);
        }
    }

    public Uri getVideoUri() {
        return this.c;
    }

    public void setThumbLoadListener(a aVar) {
        this.e = aVar;
    }
}
