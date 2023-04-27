package com.oppo.camera.ui.control;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.a.a.f;
import com.a.a.g;
import com.a.a.h;
import com.a.a.j;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.ui.o;
import com.oppo.camera.util.Util;

public class ThumbImageView extends o {

    /* renamed from: a  reason: collision with root package name */
    public static int f3902a;
    private int A;
    private boolean B;

    /* renamed from: b  reason: collision with root package name */
    Paint f3903b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    /* access modifiers changed from: private */
    public int k;
    private long l;
    private long m;
    /* access modifiers changed from: private */
    public float n;
    private boolean o;
    private boolean p;
    private Bitmap q;
    private Bitmap r;
    private Rect s;
    private Rect t;
    private Rect u;
    private Rect v;
    private Drawable w;
    /* access modifiers changed from: private */
    public Drawable x;
    private f y;
    private a z;

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return false;
    }

    public ThumbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0.5f;
        this.o = false;
        this.p = false;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.f3903b = new Paint();
        this.A = 0;
        this.B = false;
        Resources resources = context.getResources();
        this.c = resources.getDimensionPixelSize(R.dimen.thumbnail_round_corner_radius);
        this.d = resources.getDimensionPixelSize(R.dimen.thumbnail_round_stroke_width);
        this.w = resources.getDrawable(R.drawable.thumbnail_bg_normal);
        f3902a = resources.getDimensionPixelSize(R.dimen.thumbnail_width_nomal);
        this.A = context.getResources().getDimensionPixelSize(R.dimen.movie_thumbnail_round_corner_radius);
        this.f3903b.setStrokeWidth((float) context.getResources().getDimensionPixelSize(R.dimen.movie_thumbnail_bg_line));
        this.f3903b.setAntiAlias(true);
        this.f3903b.setColor(context.getResources().getColor(R.color.color_black_with_50_percent_transparency));
        this.f3903b.setStyle(Paint.Style.STROKE);
    }

    public ThumbImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public int getDegree() {
        return this.f;
    }

    public void a(int i2, boolean z2) {
        int i3 = i2 >= 0 ? i2 % 360 : (i2 % 360) + 360;
        if (i3 != this.f) {
            this.f = i3;
            if (this.k == 0) {
                if (z2) {
                    this.g = this.e;
                    this.l = AnimationUtils.currentAnimationTimeMillis();
                    int i4 = this.f - this.e;
                    if (i4 < 0) {
                        i4 += 360;
                    }
                    if (i4 > 180) {
                        i4 -= 360;
                    }
                    this.o = i4 >= 0;
                    this.m = this.l + ((long) ((Math.abs(i4) * 1000) / 270));
                } else {
                    this.e = this.f;
                }
                invalidate();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - (paddingLeft * 2);
        int height = getHeight() - (paddingTop * 2);
        if (this.p) {
            Drawable drawable = getDrawable();
            if (drawable == null) {
                e.a("ThumbImageView", "ondraw(), drawable is null 1 ,so return ");
                return;
            }
            Rect bounds = drawable.getBounds();
            int i2 = bounds.right - bounds.left;
            int i3 = bounds.bottom - bounds.top;
            if (i2 == 0 || i3 == 0) {
                e.e("ThumbImageView", "ondraw w and h is zero,so return ");
                return;
            }
            if (this.e != this.f) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                if (currentAnimationTimeMillis < this.m) {
                    int i4 = (int) (currentAnimationTimeMillis - this.l);
                    int i5 = this.g;
                    if (!this.o) {
                        i4 = -i4;
                    }
                    int i6 = i5 + ((i4 * 270) / 1000);
                    this.e = i6 >= 0 ? i6 % 360 : (i6 % 360) + 360;
                    invalidate();
                } else {
                    this.e = this.f;
                }
            }
            int saveCount = canvas.getSaveCount();
            if (getScaleType() == ImageView.ScaleType.FIT_CENTER && (width < i2 || height < i3)) {
                float f2 = (float) width;
                float f3 = (float) height;
                float min = Math.min(f2 / ((float) i2), f3 / ((float) i3));
                canvas.scale(min, min, f2 * 0.5f, f3 * 0.5f);
            }
            float f4 = (float) paddingLeft;
            float f5 = ((float) width) * 0.5f;
            float f6 = ((float) height) * 0.5f;
            canvas.translate(f4 + f5, f4 + f6);
            canvas.rotate((float) (-this.e));
            float f7 = (float) (-paddingLeft);
            canvas.translate(f7 - f5, f7 - f6);
            drawable.draw(canvas);
            canvas.restoreToCount(saveCount);
            a(canvas, (RectF) null);
            return;
        }
        int i7 = this.k;
        if (i7 == 0) {
            Drawable drawable2 = getDrawable();
            if (drawable2 != null) {
                Rect bounds2 = drawable2.getBounds();
                int i8 = bounds2.right - bounds2.left;
                int i9 = bounds2.bottom - bounds2.top;
                if (i8 != 0 && i9 != 0) {
                    if (this.e != this.f) {
                        long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                        if (currentAnimationTimeMillis2 < this.m) {
                            int i10 = (int) (currentAnimationTimeMillis2 - this.l);
                            int i11 = this.g;
                            if (!this.o) {
                                i10 = -i10;
                            }
                            int i12 = i11 + ((i10 * 270) / 1000);
                            this.e = i12 >= 0 ? i12 % 360 : (i12 % 360) + 360;
                            invalidate();
                        } else {
                            this.e = this.f;
                        }
                    }
                    int saveCount2 = canvas.getSaveCount();
                    if (getScaleType() == ImageView.ScaleType.FIT_CENTER && (width < i8 || height < i9)) {
                        float f8 = (float) width;
                        float f9 = (float) height;
                        float min2 = Math.min(f8 / ((float) i8), f9 / ((float) i9));
                        canvas.scale(min2, min2, f8 * 0.5f, f9 * 0.5f);
                    }
                    canvas.translate(((float) paddingLeft) + (((float) width) * 0.5f), ((float) paddingTop) + (((float) height) * 0.5f));
                    canvas.rotate((float) (-this.e));
                    canvas.translate(((float) (-width)) * 0.5f, ((float) (-height)) * 0.5f);
                    canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
                    drawable2.draw(canvas);
                    canvas.restoreToCount(saveCount2);
                    a(canvas, (RectF) null);
                }
            }
        } else if (i7 == 2) {
            float f10 = (float) width;
            float f11 = f10 * 0.5f;
            float f12 = (float) height;
            float f13 = 0.5f * f12;
            canvas.translate(((float) paddingLeft) + f11, ((float) paddingTop) + f13);
            canvas.rotate((float) (-this.e));
            canvas.translate(((float) (-paddingLeft)) - f11, ((float) (-paddingTop)) - f13);
            float f14 = this.n;
            this.i = (int) (f10 * f14);
            this.j = (int) (f12 * f14);
            Rect rect = this.u;
            int i13 = paddingLeft + (width / 2);
            int i14 = this.i;
            rect.left = i13 - i14;
            int i15 = paddingTop + (height / 2);
            int i16 = this.j;
            rect.top = i15 - i16;
            rect.right = i13 + i14;
            rect.bottom = i15 + i16;
            Bitmap bitmap = this.q;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, this.v, rect, (Paint) null);
                a(canvas, new RectF(this.u));
            }
        }
    }

    private void a(Canvas canvas, RectF rectF) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (this.B && layoutParams != null) {
            if (rectF == null) {
                float f2 = (float) (layoutParams.width - (paddingLeft * 2));
                float f3 = (float) (layoutParams.height - (paddingTop * 2));
                int i2 = this.A;
                canvas.drawRoundRect(0.0f, 0.0f, f2, f3, (float) i2, (float) i2, this.f3903b);
                return;
            }
            int i3 = this.A;
            canvas.drawRoundRect(rectF, (float) i3, (float) i3, this.f3903b);
        }
    }

    public void a(Bitmap bitmap, int i2, boolean z2) {
        e.a("ThumbImageView", "setBitmap, mAnimationState: " + this.k + ", bitmap: " + bitmap + ", isdefault: " + z2 + ", mbDefaultBitmap: " + this.p);
        boolean z3 = this.p;
        this.p = z2;
        if (bitmap == null) {
            this.q = bitmap;
            setImageDrawable((Drawable) null);
            return;
        }
        if (z3 && !this.p) {
            setImageDrawable(this.w);
        }
        this.r = bitmap;
        this.q = a(bitmap, true);
        this.x = Util.a(getContext(), this.q);
        com.oppo.camera.perf.a.b("capture");
        if (i2 == 0 || getVisibility() != 0) {
            setImageDrawable(this.x);
        } else {
            a(i2);
        }
    }

    public Bitmap a(Bitmap bitmap, boolean z2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int paddingLeft = (layoutParams.width - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (layoutParams.height - getPaddingTop()) - getPaddingBottom();
        if (!(bitmap.getWidth() == paddingLeft && bitmap.getHeight() == paddingTop)) {
            bitmap = ThumbnailUtils.extractThumbnail(bitmap, paddingLeft, paddingTop);
        }
        return z2 ? e.a(bitmap, this.c, this.d, !this.B) : bitmap;
    }

    public void a(int i2) {
        e.a("ThumbImageView", "startNewThumbAnimation");
        this.k = 2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - (paddingLeft * 2);
        int height = getHeight() - (paddingTop * 2);
        if (this.y == null) {
            b();
        }
        this.v = new Rect(0, 0, width, height);
        int i3 = paddingLeft + (width / 2);
        int i4 = paddingTop + (height / 2);
        this.u = new Rect(i3, i4, i3, i4);
        if (1 == i2) {
            this.y.a(0.30000001192092896d).b(0.5d);
        } else if (2 == i2) {
            this.y.a(0.375d).b(0.5d);
        }
    }

    private void b() {
        this.y = j.c().b().a(g.b(2.0d, 40.0d));
        this.y.a((h) new a());
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 == 0) {
            invalidate();
        }
    }

    public void a() {
        Bitmap bitmap = this.q;
        if (bitmap != null) {
            bitmap.recycle();
            this.q = null;
        }
        Bitmap bitmap2 = this.r;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.r = null;
        }
    }

    private class a extends com.a.a.e {
        private a() {
        }

        public void a(f fVar) {
            int unused = ThumbImageView.this.k = 2;
            float unused2 = ThumbImageView.this.n = (float) fVar.c();
            if (Float.compare(ThumbImageView.this.n, 0.5f) > 0) {
                float unused3 = ThumbImageView.this.n = 0.5f;
                fVar.j();
            }
            ThumbImageView.this.invalidate();
        }

        public void b(f fVar) {
            e.a("ThumbImageView", "ThumbReboundListener, onSpringAtRest, endNewThumbAnimation");
            int unused = ThumbImageView.this.k = 0;
            if (ThumbImageView.this.x != null) {
                ThumbImageView thumbImageView = ThumbImageView.this;
                thumbImageView.setImageDrawable(thumbImageView.x);
            }
        }
    }

    public void b(int i2, boolean z2) {
        this.c = i2;
        this.B = z2;
        if (this.r != null) {
            a(0, false);
            a(this.r, 0, this.p);
        }
    }
}
