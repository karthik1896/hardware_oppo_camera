package com.oppo.camera.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.dynamicanimation.a.b;
import androidx.dynamicanimation.a.d;
import androidx.dynamicanimation.a.f;
import com.meicam.sdk.NvsLiveWindow;
import com.meicam.sdk.NvsMultiThumbnailSequenceView;
import com.oppo.camera.R;
import com.oppo.camera.ui.RotateImageView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/* compiled from: VideoClipView */
public class e extends ViewGroup implements View.OnClickListener, NvsMultiThumbnailSequenceView.OnScrollChangeListener {
    private b A = null;
    private RectF B = new RectF();
    private RectF C = new RectF();
    private RectF D = new RectF();
    private RectF E = new RectF();
    private RectF F = new RectF();
    private RectF G = new RectF();
    private RectF H = new RectF();
    private NinePatch I;
    private DecimalFormat J = new DecimalFormat("00");
    private float K = 0.0f;
    private float L = 0.0f;
    private float M = 0.0f;
    private Bitmap N = null;
    private boolean O = false;
    private boolean P = false;
    /* access modifiers changed from: private */
    public boolean Q = false;
    private float R = 0.0f;
    private float S = 0.0f;
    /* access modifiers changed from: private */
    public int T = 0;
    /* access modifiers changed from: private */
    public boolean U = false;
    private boolean V = false;
    /* access modifiers changed from: private */
    public RectF W = new RectF();

    /* renamed from: a  reason: collision with root package name */
    private NvsLiveWindow f4595a = null;
    /* access modifiers changed from: private */
    public boolean aa = false;
    private boolean ab = false;
    private Paint ac = new Paint();
    private Paint ad = new Paint();
    private int ae = 0;
    private boolean af = false;
    /* access modifiers changed from: private */
    public Handler ag = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (1 == message.what) {
                if (e.this.z != null && e.this.Q) {
                    boolean unused = e.this.Q = false;
                    e.this.z.d(-1.0f);
                }
            } else if (2 == message.what) {
                e.this.f4596b.updateThumbnails();
                if (((ViewGroup) e.this.f4596b.getChildAt(0)).getChildCount() == 0) {
                    e.this.ag.sendEmptyMessageDelayed(2, 100);
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public NvsMultiThumbnailSequenceView f4596b = null;
    private RotateImageView c = null;
    private RotateImageView d = null;
    private com.color.support.dialog.a.a e = null;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k = 1920;
    private int l = 1080;
    private int m = 0;
    private int n = 0;
    private float o = 1.7777778f;
    /* access modifiers changed from: private */
    public float p = 0.0f;
    private float q = 0.0f;
    private float r = 0.0f;
    private float s = 15.0f;
    private float t = 1.0f;
    private float u = 0.0f;
    private float v = 0.0f;
    private float w = 1.0f;
    private float x = 0.0f;
    private float y = 0.0f;
    /* access modifiers changed from: private */
    public a z = null;

    /* compiled from: VideoClipView */
    public interface a {
        void c(float f);

        void d(float f);

        void k();
    }

    /* compiled from: VideoClipView */
    public interface b {
        void a(float f, float f2);

        void dj();
    }

    public e(Context context) {
        super(context);
        f();
    }

    private void f() {
        this.ac.setAntiAlias(true);
        this.ac.setTextSize((float) getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_time_text_size));
        this.ac.setColor(-1);
        this.ac.setShadowLayer((float) getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_text_shadow_radius), 0.0f, (float) getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_text_shadow_y), getResources().getColor(R.color.num_seekbar_thumb_text_shadow_color, (Resources.Theme) null));
        this.ad.setAntiAlias(true);
        this.ad.setColor(-16777216);
        this.ae = getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_time_margin_bottom);
        this.P = true;
        this.N = BitmapFactory.decodeResource(getResources(), R.drawable.time_line);
        this.f4595a = new NvsLiveWindow(getContext());
        addView(this.f4595a, new ViewGroup.MarginLayoutParams(-2, -2));
        this.f = getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_height);
        this.g = getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_margin_bottom);
        this.h = getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_margin_left);
        this.i = getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_move_boundary);
        this.j = getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_offset);
        this.f4596b = new NvsMultiThumbnailSequenceView(getContext());
        addView(this.f4596b, new ViewGroup.MarginLayoutParams(-1, this.f));
        this.f4596b.setOnScrollChangeListenser(this);
        this.f4596b.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (1 != motionEvent.getAction() || 15.0f >= e.this.p) {
                    return false;
                }
                boolean unused = e.this.Q = true;
                e.this.ag.removeMessages(1);
                e.this.ag.sendEmptyMessageDelayed(1, 50);
                return false;
            }
        });
        this.c = new RotateImageView(getContext());
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_back_margin_left);
        this.c.setImageResource(R.drawable.btn_revert_pics_drawable);
        addView(this.c, marginLayoutParams);
        this.c.setOnClickListener(this);
        this.d = new RotateImageView(getContext());
        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams2.bottomMargin = getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_next_margin_bottom);
        this.d.setImageResource(R.drawable.ic_next_step);
        addView(this.d, marginLayoutParams2);
        this.d.setOnClickListener(this);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.video_editor_trim_normal);
        this.I = new NinePatch(decodeResource, decodeResource.getNinePatchChunk(), (String) null);
        this.n = getContext().getResources().getDisplayMetrics().widthPixels;
        this.m = (int) (((float) this.n) * this.o);
        setWillNotDraw(false);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = i4 - i2;
        int i11 = i5 - i3;
        int i12 = i11 - ((i11 - this.m) / 2);
        boolean z3 = true;
        if (1 != getLayoutDirection()) {
            z3 = false;
        }
        int i13 = this.k;
        int i14 = this.l;
        if (i13 > i14) {
            int i15 = this.m;
            i6 = (i11 - i15) / 2;
            i8 = (i14 * i15) / i13;
            int i16 = i15;
            i7 = (i10 - i8) / 2;
            i9 = i16;
        } else {
            int i17 = this.n;
            i9 = (i13 * i17) / i14;
            i6 = (i11 - i9) / 2;
            i8 = i17;
            i7 = i2;
        }
        int i18 = this.m;
        if (i9 > i18) {
            i9 = i18;
        }
        int i19 = this.n;
        if (i8 > i19) {
            i8 = i19;
        }
        this.f4595a.layout(i7, i6, i8 + i7, i9 + i6);
        int i20 = 15.0f < this.p ? i2 : this.h + this.j;
        int i21 = 15.0f < this.p ? i4 : (i4 - this.h) - this.j;
        int i22 = this.g + ((i11 - this.m) / 2);
        this.f4596b.layout(i20, (i5 - this.f) - i22, i21, i5 - i22);
        int intrinsicWidth = this.d.getDrawable().getIntrinsicWidth();
        int intrinsicWidth2 = this.d.getDrawable().getIntrinsicWidth();
        int i23 = (i10 - intrinsicWidth) / 2;
        int i24 = (i12 - intrinsicWidth2) - ((ViewGroup.MarginLayoutParams) this.d.getLayoutParams()).bottomMargin;
        this.d.layout(i23, i24, intrinsicWidth + i23, i24 + intrinsicWidth2);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.c.getLayoutParams();
        int intrinsicWidth3 = this.c.getDrawable().getIntrinsicWidth();
        int intrinsicWidth4 = this.c.getDrawable().getIntrinsicWidth();
        int i25 = i24 + ((intrinsicWidth2 - intrinsicWidth4) / 2);
        int i26 = z3 ? (i10 - marginLayoutParams.leftMargin) - intrinsicWidth3 : marginLayoutParams.leftMargin;
        this.c.layout(i26, i25, intrinsicWidth3 + i26, intrinsicWidth4 + i25);
        Rect rect = new Rect();
        this.f4596b.getHitRect(rect);
        if (!rect.contains((int) this.R, (int) this.S) && !this.O && this.P) {
            this.P = false;
            this.B.set((float) i2, (float) this.f4596b.getTop(), (float) i4, (float) this.f4596b.getBottom());
            this.G.set(this.B);
            RectF rectF = this.G;
            int i27 = this.h;
            rectF.left = (float) (i2 + i27);
            rectF.right = (float) (i4 - i27);
            this.H.set(rectF);
            this.E.set(this.G);
            RectF rectF2 = this.E;
            rectF2.right = rectF2.left + ((float) this.j);
            this.F.set(this.G);
            RectF rectF3 = this.F;
            rectF3.left = rectF3.right - ((float) this.j);
            this.B.left = this.E.right;
            this.B.right = this.F.left;
            this.D.set(this.B);
            this.W.setEmpty();
            float f2 = this.p;
            if (15.0f < f2) {
                this.r = (f2 / this.s) * this.D.width();
                this.f4596b.setPixelPerMicrosecond((double) (this.r / this.q));
                this.f4596b.setStartPadding((int) (this.D.left - ((float) getLeft())));
                this.f4596b.setEndPadding((int) (((float) getRight()) - this.D.right));
                this.r += (float) this.f4596b.getStartPadding();
                this.r += (float) this.f4596b.getEndPadding();
                float scrollX = ((float) this.f4596b.getScrollX()) + (this.B.left - this.D.left);
                this.v = scrollX / ((this.r - ((float) this.f4596b.getStartPadding())) - ((float) this.f4596b.getEndPadding()));
                this.w = (scrollX + this.B.width()) / ((this.r - ((float) this.f4596b.getStartPadding())) - ((float) this.f4596b.getEndPadding()));
            } else {
                this.r = (float) this.f4596b.getWidth();
                NvsMultiThumbnailSequenceView nvsMultiThumbnailSequenceView = this.f4596b;
                nvsMultiThumbnailSequenceView.setPixelPerMicrosecond((double) ((((float) nvsMultiThumbnailSequenceView.getWidth()) * 1.0f) / this.q));
                this.f4596b.setStartPadding(0);
                this.f4596b.setEndPadding(0);
                this.v = 0.0f;
                this.w = 1.0f;
            }
            this.y = this.v;
            setCurrentTime(getSelectTimeRatio() * this.s);
            this.f4596b.updateThumbnails();
            this.f4596b.stopNestedScroll();
            this.f4596b.scrollTo(0, 0);
            this.f4596b.scrollBy(0, 0);
            this.f4596b.smoothScrollBy(0, 0);
            this.f4596b.smoothScrollTo(0, 0);
        }
        g();
        if (((ViewGroup) this.f4596b.getChildAt(0)).getChildCount() == 0 && this.V) {
            this.V = false;
            this.ag.removeMessages(2);
            this.ag.sendEmptyMessage(2);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        canvas.drawColor(getResources().getColor(R.color.color_black_with_full_percent_transparency, (Resources.Theme) null));
        super.dispatchDraw(canvas);
        String str = "00:" + this.J.format((double) this.u);
        canvas.drawText(str, (((float) getWidth()) - this.ac.measureText(str)) / 2.0f, (float) (this.f4596b.getTop() - this.ae), this.ac);
        this.ad.setAlpha(127);
        float scrollX = this.D.left - ((float) this.f4596b.getScrollX());
        if (scrollX < ((float) getLeft())) {
            scrollX = (float) getLeft();
        }
        canvas.drawRect(scrollX, this.D.top, this.B.left, this.D.bottom, this.ad);
        float scrollX2 = this.D.right + ((this.r - ((float) this.f4596b.getScrollX())) - ((float) this.f4596b.getWidth()));
        if (scrollX2 > ((float) getRight())) {
            scrollX2 = (float) getRight();
        }
        canvas.drawRect(this.B.right, this.D.top, scrollX2, this.D.bottom, this.ad);
        if (this.W.isEmpty() || (!this.aa && this.W.right <= this.H.right && this.W.left >= this.H.left)) {
            this.I.draw(canvas, this.G);
        } else {
            this.I.draw(canvas, this.W);
        }
        if (!this.E.contains(this.K, this.L) && !this.F.contains(this.K, this.L)) {
            float width = this.B.left + (this.B.width() * this.x);
            float height = this.B.top - ((((float) this.N.getHeight()) - this.B.height()) / 2.0f);
            float f2 = this.B.right;
            if (((float) this.N.getWidth()) + width > f2) {
                width = f2 - ((float) this.N.getWidth());
            }
            this.ad.setAlpha(255);
            canvas.drawBitmap(this.N, width, height, this.ad);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.R = (float) ((int) motionEvent.getX());
            this.S = (float) ((int) motionEvent.getY());
            this.O = true;
        } else if (1 == motionEvent.getAction() || 3 == motionEvent.getAction()) {
            this.R = 0.0f;
            this.S = 0.0f;
            this.O = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2 = false;
        if (this.E.contains(this.R, this.S) || this.F.contains(this.R, this.S) || this.C.contains(this.R, this.S)) {
            if (1 != motionEvent.getAction()) {
                z2 = true;
            }
            this.ab = z2;
            return true;
        }
        if (motionEvent.getAction() == 0) {
            RectF rectF = new RectF(this.G.right, this.G.top, this.G.right + ((float) this.j), this.G.bottom);
            RectF rectF2 = new RectF(this.G.right - ((float) (this.j * 2)), this.G.top, this.G.right - ((float) this.j), this.G.bottom);
            RectF rectF3 = new RectF(this.G.left - ((float) this.j), this.G.top, this.G.left, this.G.bottom);
            RectF rectF4 = new RectF(this.G.left + ((float) this.j), this.G.top, this.G.left + ((float) (this.j * 2)), this.G.bottom);
            float width = this.B.left + (this.B.width() * this.x);
            float height = this.B.top - ((((float) this.N.getHeight()) - this.B.height()) / 2.0f);
            float f2 = this.B.right;
            if (((float) this.N.getWidth()) + width > f2) {
                width = f2 - ((float) this.N.getWidth());
            }
            this.C.set(width, height, ((float) this.N.getWidth()) + width, ((float) this.N.getHeight()) + height);
            this.C.left -= (float) this.N.getWidth();
            this.C.right += (float) this.N.getWidth();
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (rectF3.contains(x2, y2) || rectF2.contains(x2, y2) || rectF.contains(x2, y2) || rectF4.contains(x2, y2) || this.C.contains(x2, y2)) {
                z2 = true;
            }
            this.ab = z2;
        } else if (this.ab) {
            if (1 != motionEvent.getAction()) {
                z2 = true;
            }
            this.ab = z2;
            return true;
        }
        return this.ab;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && !this.U) {
            if (motionEvent.getAction() == 0) {
                this.K = (float) ((int) motionEvent.getX());
                this.L = (float) ((int) motionEvent.getY());
                this.M = motionEvent.getX();
                if (this.z == null || !this.C.contains(this.K, this.L)) {
                    RectF rectF = new RectF(this.G.right, this.G.top, this.G.right + ((float) this.j), this.G.bottom);
                    RectF rectF2 = new RectF(this.G.right - ((float) (this.j * 2)), this.G.top, this.G.right - ((float) this.j), this.G.bottom);
                    RectF rectF3 = new RectF(this.G.left - ((float) this.j), this.G.top, this.G.left, this.G.bottom);
                    RectF rectF4 = new RectF(this.G.left + ((float) this.j), this.G.top, this.G.left + ((float) (this.j * 2)), this.G.bottom);
                    if (this.D.contains(this.K, this.L) && (rectF3.contains(this.K, this.L) || rectF4.contains(this.K, this.L))) {
                        RectF rectF5 = this.G;
                        rectF5.left = this.K - (((float) this.j) / 2.0f);
                        this.E.set(rectF5);
                        RectF rectF6 = this.E;
                        rectF6.right = rectF6.left + ((float) this.j);
                    } else if (this.D.contains(this.K, this.L) && (rectF.contains(this.K, this.L) || rectF2.contains(this.K, this.L))) {
                        RectF rectF7 = this.G;
                        rectF7.right = this.K + (((float) this.j) / 2.0f);
                        this.F.set(rectF7);
                        RectF rectF8 = this.F;
                        rectF8.left = rectF8.right - ((float) this.j);
                    }
                    this.W.set(this.G);
                } else {
                    this.af = true;
                    this.z.c(this.y);
                }
            }
            if (!a(this.K, this.L) && !this.af) {
                return true;
            }
            int action = motionEvent.getAction();
            if (action == 1) {
                float width = ((this.t / 15.0f) * this.D.width()) + ((float) (this.j * 2));
                if (this.z != null && (15.0f < this.p || a(this.K, this.L) || this.af)) {
                    this.z.d(this.af ? this.y : -1.0f);
                }
                if (this.G.left <= this.H.left && this.G.width() <= width) {
                    this.G.left = this.H.left;
                    RectF rectF9 = this.G;
                    rectF9.right = rectF9.left + width;
                }
                if (this.W.left <= this.H.left && this.W.width() <= width) {
                    this.W.set(this.G);
                }
                if (this.G.right >= this.H.right && this.G.width() <= width) {
                    this.G.right = this.H.right;
                    RectF rectF10 = this.G;
                    rectF10.left = rectF10.right - width;
                }
                if (this.W.right >= this.H.right && this.W.width() <= width) {
                    this.W.set(this.G);
                }
                this.B.left = this.G.left + ((float) this.j);
                this.B.right = this.G.right - ((float) this.j);
                this.E.set(this.G);
                RectF rectF11 = this.E;
                rectF11.right = rectF11.left + ((float) this.j);
                this.F.set(this.G);
                RectF rectF12 = this.F;
                rectF12.left = rectF12.right - ((float) this.j);
                this.K = 0.0f;
                this.L = 0.0f;
                this.R = 0.0f;
                this.S = 0.0f;
                this.af = false;
                setCurrentTime(getSelectTimeRatio() * this.s);
                if (this.W.right > this.H.right) {
                    b(false);
                }
                if (this.W.left < this.H.left) {
                    b(true);
                }
                a aVar = this.z;
                if (aVar != null && 15.0f <= this.u) {
                    aVar.k();
                }
            } else if (action == 2) {
                if (!this.af && (this.E.contains(this.K, this.L) || this.F.contains(this.K, this.L))) {
                    a(motionEvent);
                } else if (this.af && (this.B.contains(this.C.left, this.C.centerY()) || (this.B.left < motionEvent.getX() && this.B.right > motionEvent.getX()))) {
                    this.x = ((motionEvent.getX() < this.B.left ? this.B.left : motionEvent.getX()) - this.B.left) / this.B.width();
                    float f2 = this.v;
                    this.y = f2 + (this.x * (this.w - f2));
                    g();
                    this.z.c(this.y);
                }
            }
            invalidate();
        }
        return true;
    }

    private void a(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        float f2 = x2 - this.M;
        boolean z2 = 0.0f <= f2;
        boolean contains = this.E.contains(this.K, this.L);
        boolean contains2 = this.F.contains(this.K, this.L);
        float width = ((this.t / 15.0f) * this.D.width()) + ((float) (this.j * 2));
        if (contains) {
            float left = (float) (getLeft() + this.i);
            if (this.W.left > this.H.left) {
                this.G.left += f2;
                this.W.left = this.G.left;
            } else {
                this.W.left += f2;
                this.G.left = this.H.left;
            }
            if (this.G.width() < width) {
                if (this.G.right >= this.H.right) {
                    this.G.right = this.H.right;
                } else {
                    this.G.right += f2;
                }
                this.W.right = this.G.right;
            }
            if (this.W.left <= left) {
                this.W.left = left;
            }
        } else if (contains2) {
            float right = (float) (getRight() - this.i);
            if (this.W.right < this.H.right) {
                this.G.right += f2;
                this.W.right = this.G.right;
            } else {
                this.W.right += f2;
                this.G.right = this.H.right;
            }
            if (this.G.width() < width) {
                if (this.G.left <= this.H.left) {
                    this.G.left = this.H.left;
                } else {
                    this.G.left += f2;
                }
                this.W.left = this.G.left;
            }
            if (this.W.right >= right) {
                this.W.right = right;
            }
        }
        if (contains || contains2) {
            if (this.G.width() <= width && 0.0f != f2) {
                if (z2 && this.G.right >= this.H.right) {
                    this.G.left = this.H.right - width;
                    this.G.right = this.H.right;
                } else if (this.G.left <= this.H.left) {
                    this.G.left = this.H.left;
                    this.G.right = this.H.left + width;
                }
            }
            if (this.G.left < this.H.left) {
                this.G.left = this.H.left;
            }
            if (this.G.right > this.H.right) {
                this.G.right = this.H.right;
            }
            this.B.left = this.G.left + ((float) this.j);
            this.B.right = this.G.right - ((float) this.j);
            this.x = 0.0f;
            float scrollX = ((float) this.f4596b.getScrollX()) + (this.B.left - this.D.left);
            this.v = scrollX / ((this.r - ((float) this.f4596b.getStartPadding())) - ((float) this.f4596b.getEndPadding()));
            this.w = (scrollX + this.B.width()) / ((this.r - ((float) this.f4596b.getStartPadding())) - ((float) this.f4596b.getEndPadding()));
            float f3 = this.E.contains(this.K, this.L) ? this.v : this.w;
            setCurrentTime(getSelectTimeRatio() * this.s);
            a aVar = this.z;
            if (!(aVar == null || f3 == this.y)) {
                aVar.c(f3);
            }
            this.y = f3;
            this.M = x2;
        }
    }

    private void b(final boolean z2) {
        float f2 = z2 ? this.W.left : this.W.right;
        final float f3 = z2 ? this.H.left : this.H.right;
        androidx.dynamicanimation.a.e eVar = new androidx.dynamicanimation.a.e(new d(f2));
        f fVar = new f(f3);
        fVar.a(1500.0f);
        fVar.b(0.5f);
        eVar.a(fVar);
        eVar.a((b.c) new b.c() {
            public void a(androidx.dynamicanimation.a.b bVar, float f, float f2) {
                if (z2) {
                    e.this.W.left = f;
                } else {
                    e.this.W.right = f;
                }
                boolean unused = e.this.aa = f != f3;
                e.this.invalidate();
            }
        });
        eVar.a();
    }

    private float getSelectTimeRatio() {
        if (0.0f == this.D.width()) {
            return 1.0f;
        }
        return this.B.width() / this.D.width();
    }

    private boolean a(float f2, float f3) {
        return this.C.contains((float) ((int) f2), (float) ((int) f3)) || this.E.contains(f2, f3) || this.F.contains(f2, f3);
    }

    public NvsLiveWindow getLiveWindow() {
        return this.f4595a;
    }

    public void setLiveWindow(NvsLiveWindow nvsLiveWindow) {
        this.f4595a = nvsLiveWindow;
    }

    public NvsMultiThumbnailSequenceView getThumbnail() {
        return this.f4596b;
    }

    public void setThumbProcess(float f2) {
        a(f2, true);
    }

    public float getThumbProcess() {
        return this.x;
    }

    public void a(float f2, boolean z2) {
        if (f2 != this.y) {
            float floatValue = new BigDecimal((double) (1.0f - f2)).setScale(2, RoundingMode.DOWN).floatValue();
            float f3 = this.v;
            if (f2 < f3) {
                f2 = f3;
            } else if (f2 >= this.w || 0.01f >= floatValue) {
                f2 = this.w;
            }
            this.y = f2;
            float f4 = this.w;
            float f5 = this.v;
            this.x = (f2 - f5) / (f4 - f5);
            if (z2) {
                invalidate();
            }
        }
    }

    public void a(int i2, int i3) {
        this.l = i2;
        this.k = i3;
        this.P = true;
        com.oppo.camera.e.b("VideoClipView", "setVideoSize mVideoWidth: " + this.l + ", mVideoHeight: " + this.k);
    }

    public void setTotalTime(long j2) {
        float f2 = (float) j2;
        this.q = f2;
        this.U = false;
        this.V = true;
        this.T = 0;
        this.p = a(f2);
        this.v = 0.0f;
        float f3 = this.p;
        this.w = f3 < 15.0f ? 1.0f : 15.0f / f3;
        this.x = 0.0f;
        float f4 = this.p;
        if (f4 >= 15.0f) {
            f4 = 15.0f;
        }
        this.s = f4;
        requestLayout();
        invalidate();
        com.oppo.camera.e.b("VideoClipView", "totalTime: " + j2 + " mTotalTimeSecond: " + this.p);
    }

    private void g() {
        float width = this.B.left + (this.B.width() * this.x);
        float height = this.B.top - ((((float) this.N.getHeight()) - this.B.height()) / 2.0f);
        float f2 = this.B.right;
        if (((float) this.N.getWidth()) + width > f2) {
            width = f2 - ((float) this.N.getWidth());
        }
        this.C.set(width, height, ((float) this.N.getWidth()) + width, ((float) this.N.getHeight()) + height);
        this.C.left -= (float) this.N.getWidth();
        this.C.right += (float) this.N.getWidth();
    }

    public void setCurrentTime(float f2) {
        this.u = new BigDecimal((double) f2).setScale(0, RoundingMode.DOWN).floatValue();
    }

    private float a(float f2) {
        return new BigDecimal((double) ((f2 * 1.0f) / 1000000.0f)).setScale(2, RoundingMode.DOWN).floatValue();
    }

    public void setSeekToCallback(a aVar) {
        this.z = aVar;
    }

    public float getLeftVideoProcess() {
        return this.v;
    }

    public void setLeftVideoProcess(float f2) {
        this.v = f2;
    }

    public float getRightVideoProcess() {
        return this.w;
    }

    public void setRightVideoProcess(float f2) {
        this.w = f2;
    }

    public void setVideoClipClick(b bVar) {
        this.A = bVar;
    }

    public void setOrientation(int i2) {
        this.c.a(i2, true);
        this.d.a(i2, true);
    }

    public void a() {
        if (this.e == null) {
            this.e = new com.color.support.dialog.a.a(getContext());
            this.e.setCancelable(false);
            this.e.setCanceledOnTouchOutside(false);
            this.e.setTitle(getResources().getString(R.string.mode_double_exposure_video_importing));
        }
        this.e.show();
    }

    public void setVisibility(int i2) {
        if (i2 == 0) {
            setAlpha(1.0f);
        }
        super.setVisibility(i2);
    }

    public void a(final boolean z2) {
        this.f4596b.scrollTo(0, 0);
        this.f4596b.smoothScrollTo(0, 0);
        this.T = 0;
        this.U = true;
        ValueAnimator duration = ValueAnimator.ofInt(new int[]{0, 255}).setDuration(300);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = e.this.T = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                e eVar = e.this;
                boolean unused2 = eVar.U = 255 != eVar.T;
                if (z2) {
                    if (255 == e.this.T) {
                        e.this.setVisibility(8);
                    } else {
                        e eVar2 = e.this;
                        eVar2.setAlpha(((float) (255 - eVar2.T)) / 255.0f);
                    }
                }
                e.this.invalidate();
            }
        });
        duration.start();
    }

    public void b() {
        com.color.support.dialog.a.a aVar = this.e;
        if (aVar != null) {
            aVar.dismiss();
        }
    }

    public boolean c() {
        com.color.support.dialog.a.a aVar = this.e;
        return aVar != null && aVar.isShowing();
    }

    public boolean d() {
        return getVisibility() == 0 && getAnimationAlpha() == 0 && !e();
    }

    public int getAnimationAlpha() {
        return this.T;
    }

    public boolean e() {
        return this.U;
    }

    public void onClick(View view) {
        b bVar = this.A;
        if (bVar != null) {
            if (view == this.c) {
                bVar.dj();
            } else if (view == this.d) {
                bVar.a(this.v, this.w);
            }
        }
    }

    public void onScrollChanged(NvsMultiThumbnailSequenceView nvsMultiThumbnailSequenceView, int i2, int i3) {
        if (15.0f <= this.p) {
            float f2 = ((float) i2) + (this.B.left - this.D.left);
            this.v = f2 / ((this.r - ((float) this.f4596b.getStartPadding())) - ((float) this.f4596b.getEndPadding()));
            this.w = (f2 + this.B.width()) / ((this.r - ((float) this.f4596b.getStartPadding())) - ((float) this.f4596b.getEndPadding()));
            this.y = this.v;
            a(0.0f, true);
            a aVar = this.z;
            if (aVar != null) {
                aVar.c(this.y);
            }
            this.ag.removeMessages(1);
            this.ag.sendEmptyMessageDelayed(1, 50);
        }
    }
}
