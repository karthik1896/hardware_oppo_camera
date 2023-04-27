package com.oppo.camera.l;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oppo.camera.R;
import com.oppo.camera.doubleexposure.DoubleExposureVideoView;
import com.oppo.camera.e;
import com.oppo.camera.l.b;
import com.oppo.camera.util.Util;

/* compiled from: VideoViewPagerAdapter */
public class b extends RecyclerView.a<C0090b> {

    /* renamed from: a  reason: collision with root package name */
    private int[] f3433a = null;

    /* renamed from: b  reason: collision with root package name */
    private Uri[] f3434b = null;
    private Bitmap c = null;
    private Context d = null;
    private int e = -1;
    /* access modifiers changed from: private */
    public int f = 1;
    private DoubleExposureVideoView.a g = null;

    public b(Context context, int[] iArr, Uri[] uriArr) {
        this.f3433a = iArr;
        this.f3434b = uriArr;
        this.d = context;
    }

    public void a(DoubleExposureVideoView.a aVar) {
        this.g = aVar;
        Uri[] uriArr = this.f3434b;
        if (uriArr.length > 0) {
            Util.a((Runnable) new a(this.d, uriArr[0], this.g));
        }
    }

    public void a(int i) {
        this.e = i;
    }

    public int a() {
        return this.e;
    }

    public void a(Bitmap bitmap) {
        this.c = bitmap;
    }

    /* renamed from: a */
    public C0090b onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0090b bVar = new C0090b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.common_bottom_double_exposure_layout, viewGroup, false));
        bVar.setIsRecyclable(false);
        return bVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(final C0090b bVar, int i) {
        bVar.c.setText(this.f3433a[i]);
        bVar.c.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                if (bVar.c.getLineCount() <= 0) {
                    return false;
                }
                bVar.c.getViewTreeObserver().removeOnPreDrawListener(this);
                int unused = b.this.f = Math.max(bVar.c.getLineCount(), b.this.f);
                bVar.c.setMaxLines(Math.min(b.this.f, 3));
                bVar.c.setMinLines(Math.min(b.this.f, 3));
                return false;
            }
        });
        if (i == 0) {
            bVar.f3440b.setVideoThumb(this.c);
        }
        if (bVar.f3440b.getVideoUri() == null) {
            bVar.f3440b.setVideoUri(this.f3434b[i]);
        }
    }

    public int getItemCount() {
        return this.f3433a.length;
    }

    /* compiled from: VideoViewPagerAdapter */
    private static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Context f3437a = null;

        /* renamed from: b  reason: collision with root package name */
        private Uri f3438b = null;
        private DoubleExposureVideoView.a c = null;

        public a(Context context, Uri uri, DoubleExposureVideoView.a aVar) {
            this.f3437a = context;
            this.f3438b = uri;
            this.c = aVar;
        }

        public void run() {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.f3437a, this.f3438b);
            try {
                Bitmap frameAtIndex = mediaMetadataRetriever.getFrameAtIndex(2);
                if (!(frameAtIndex == null || this.c == null)) {
                    Util.ab().post(new Runnable(frameAtIndex) {
                        private final /* synthetic */ Bitmap f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void run() {
                            b.a.this.a(this.f$1);
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
                e.e("VideoViewPagerAdapter", "LoadThumbTask error " + e.toString());
            } catch (Throwable th) {
                mediaMetadataRetriever.close();
                throw th;
            }
            mediaMetadataRetriever.close();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(Bitmap bitmap) {
            this.c.a(bitmap);
        }
    }

    /* renamed from: com.oppo.camera.l.b$b  reason: collision with other inner class name */
    /* compiled from: VideoViewPagerAdapter */
    public final class C0090b extends RecyclerView.w {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public DoubleExposureVideoView f3440b = null;
        /* access modifiers changed from: private */
        public AppCompatTextView c = null;
        private AppCompatImageView d = null;

        public C0090b(View view) {
            super(view);
            this.c = (AppCompatTextView) view.findViewById(R.id.double_exposure_text);
            this.f3440b = (DoubleExposureVideoView) view.findViewById(R.id.videoView);
            this.d = (AppCompatImageView) view.findViewById(R.id.icon_image);
        }
    }
}
