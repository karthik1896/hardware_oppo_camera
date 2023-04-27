package com.oppo.camera.ui.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.Size;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.a.a.g;
import com.a.a.h;
import com.a.a.j;
import com.oppo.camera.R;
import com.oppo.camera.d;
import com.oppo.camera.ui.control.ThumbImageView;
import com.oppo.camera.ui.control.b;
import com.oppo.camera.ui.control.e;
import com.oppo.camera.ui.f;
import com.oppo.camera.util.Util;

/* compiled from: CameraSuperTextUI */
public class a implements d {
    private Activity d = null;
    /* access modifiers changed from: private */
    public f e = null;
    private b f = null;
    /* access modifiers changed from: private */
    public ViewGroup g = null;
    /* access modifiers changed from: private */
    public Bitmap h = null;
    private Bitmap i = null;
    /* access modifiers changed from: private */
    public e j = null;
    private boolean k = false;
    private boolean l = false;
    /* access modifiers changed from: private */
    public com.oppo.camera.ui.widget.b m = null;
    private j n = j.c();
    private ObjectAnimator o = null;
    private ObjectAnimator p = null;
    /* access modifiers changed from: private */
    public boolean q = false;
    /* access modifiers changed from: private */
    public boolean r = false;
    private int s = 0;
    private int t = 0;
    /* access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    public Handler u = new Handler() {
        public void handleMessage(Message message) {
            com.oppo.camera.e.a("CameraSuperTextUI", "handleMessage, msg: " + message.what);
            if (message.what == 101) {
                a.this.d();
            }
        }
    };

    public a(Activity activity, f fVar, b bVar) {
        this.d = activity;
        this.e = fVar;
        this.f = bVar;
    }

    public void a(ViewGroup viewGroup) {
        this.g = viewGroup;
    }

    public void a() {
        this.k = false;
    }

    public void b() {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        this.k = true;
        this.l = true;
        if (this.q && (objectAnimator2 = this.o) != null) {
            objectAnimator2.end();
            this.o = null;
        }
        if (this.r && (objectAnimator = this.p) != null) {
            objectAnimator.end();
            this.p = null;
        }
        this.g.removeView(this.m);
    }

    public void c() {
        Handler handler = this.u;
        if (handler != null) {
            handler.removeMessages(101);
            this.u = null;
        }
        this.d = null;
        this.g = null;
    }

    public void a(Bitmap bitmap, e.a aVar, e eVar, int i2) {
        com.oppo.camera.e.e("CameraSuperTextUI", "showSuperTextResultView start");
        this.h = bitmap;
        this.j = eVar;
        this.t = i2;
        ThumbImageView p2 = this.f.p();
        if (this.k || this.l) {
            a(p2, eVar, bitmap);
            return;
        }
        Size a2 = this.e.a(1.3333333333333333d);
        if (a2 != null) {
            int v = Util.v() + (a2.getWidth() / 2);
            com.oppo.camera.e.a("CameraSuperTextUI", "showSuperTextResultView, size.width: " + a2.getWidth() + ", size.height: " + a2.getHeight() + ", topBarHeight: " + Util.v() + ", bitmap.width: " + bitmap.getWidth() + ", bitmap.height: " + bitmap.getHeight());
            a(bitmap, v);
            StringBuilder sb = new StringBuilder();
            sb.append("showSuperTextResultView, bitmapWidth: ");
            sb.append(bitmap.getWidth());
            sb.append(", bitmapHeight: ");
            sb.append(bitmap.getHeight());
            com.oppo.camera.e.e("CameraSuperTextUI", sb.toString());
            final com.a.a.f b2 = this.n.b();
            b2.a(g.b(5.0d, 8.0d));
            b2.a(false);
            b2.a((h) new com.a.a.e() {
                public void a(com.a.a.f fVar) {
                    super.a(fVar);
                    float c = (float) fVar.c();
                    com.oppo.camera.e.a("CameraSuperTextUI", "onSpringUpdate, currentScaleValue: " + c);
                    a.this.m.setAlpha(c);
                    float f = (c * 0.38f) + 0.72f;
                    a.this.m.setScaleX(f);
                    a.this.m.setScaleY(f);
                }

                public void b(com.a.a.f fVar) {
                    super.b(fVar);
                    b2.a();
                    if (a.this.u != null) {
                        a.this.u.sendEmptyMessageDelayed(101, 500);
                    }
                }
            });
            b2.b(1.0d);
        }
    }

    private void a(Bitmap bitmap, int i2) {
        this.i = a(bitmap);
        this.m = new com.oppo.camera.ui.widget.b(this.d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.i.getWidth(), this.i.getHeight());
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.topMargin = i2 - (this.i.getHeight() / 2);
        layoutParams.leftMargin = 0;
        this.m.setLayoutParams(layoutParams);
        this.m.setBitmap(this.i);
        this.g.addView(this.m);
        this.m.setVisibility(0);
        this.m.setAlpha(0.0f);
    }

    private Bitmap a(Bitmap bitmap) {
        Size W = this.e.W();
        if (W == null) {
            com.oppo.camera.e.e("CameraSuperTextUI", "createAnimBitmap, preview size is null");
            return bitmap;
        }
        int E = Util.E();
        Bitmap a2 = Util.a(E, (W.getWidth() * E) / W.getHeight(), Bitmap.Config.ARGB_8888);
        a2.eraseColor(0);
        Canvas canvas = new Canvas(a2);
        canvas.drawBitmap(bitmap, ((float) (a2.getWidth() - bitmap.getWidth())) / 2.0f, ((float) (a2.getHeight() - bitmap.getHeight())) / 2.0f, (Paint) null);
        canvas.save();
        canvas.restore();
        com.oppo.camera.e.a("CameraSuperTextUI", "createAnimBitmap, result width: " + a2.getWidth() + ", height: " + a2.getHeight());
        return a2;
    }

    /* access modifiers changed from: private */
    public void a(ThumbImageView thumbImageView, e eVar, Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            com.oppo.camera.e.a("CameraSuperTextUI", "updateThumbnailWithoutAnimation");
            b bVar = this.f;
            if (bVar != null) {
                bVar.b(eVar);
                this.f.a(eVar);
            }
            if (thumbImageView != null) {
                thumbImageView.a(Util.a(thumbImageView.a(bitmap, false), this.t), 0, false);
            }
            this.e.b(false);
            this.e.T();
            e();
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        final ThumbImageView p2 = this.f.p();
        if (this.h != null && this.j != null) {
            if (this.k) {
                com.oppo.camera.e.e("CameraSuperTextUI", "executeSuperTextMoveAnimation, stop");
                a(p2, this.j, this.h);
                this.g.removeView(this.m);
                return;
            }
            Size a2 = this.e.a(1.3333333333333333d);
            if (a2 != null) {
                int v = Util.v() + (a2.getWidth() / 2);
                int[] iArr = new int[2];
                p2.getLocationOnScreen(iArr);
                float width = (float) p2.getWidth();
                float height = (float) p2.getHeight();
                float f2 = ((float) iArr[0]) + (width / 2.0f);
                float f3 = ((float) iArr[1]) + (height / 2.0f);
                float width2 = width / ((float) this.h.getWidth());
                float height2 = height / ((float) this.h.getHeight());
                int dimensionPixelSize = this.d.getResources().getDimensionPixelSize(R.dimen.thumbnail_round_corner_radius);
                int i2 = dimensionPixelSize;
                this.o = ObjectAnimator.ofPropertyValuesHolder(p2, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 0.6f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 0.6f}), PropertyValuesHolder.ofFloat("alpha", new float[]{1.0f, 0.0f})}).setDuration(300);
                this.o.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                        boolean unused = a.this.q = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        p2.setScaleX(1.0f);
                        p2.setScaleY(1.0f);
                        p2.setAlpha(1.0f);
                        a aVar = a.this;
                        aVar.a(p2, aVar.j, a.this.h);
                        boolean unused = a.this.q = false;
                        a.this.e();
                    }
                });
                PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, width2});
                PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, height2});
                PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("translationX", new float[]{0.0f, f2 - ((float) (a2.getHeight() / 2))});
                PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("translationY", new float[]{0.0f, f3 - ((float) v)});
                PropertyValuesHolder ofFloat5 = PropertyValuesHolder.ofFloat("mRadius", new float[]{0.0f, ((float) i2) / width2});
                this.p = ObjectAnimator.ofPropertyValuesHolder(this.m, new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5}).setDuration(300);
                this.m.setLayerType(2, (Paint) null);
                this.p.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                        boolean unused = a.this.r = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        a.this.m.setLayerType(0, (Paint) null);
                        a.this.g.removeView(a.this.m);
                        a.this.e.b(false);
                        a.this.e.T();
                        boolean unused = a.this.r = false;
                    }
                });
                this.p.start();
                this.o.start();
            }
        }
    }

    public void a(int i2) {
        this.s = i2;
    }

    public void a(boolean z) {
        this.l = z;
    }

    /* access modifiers changed from: private */
    public void e() {
        Bitmap bitmap = this.h;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.h.recycle();
        }
        Bitmap bitmap2 = this.i;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.i.recycle();
        }
    }
}
