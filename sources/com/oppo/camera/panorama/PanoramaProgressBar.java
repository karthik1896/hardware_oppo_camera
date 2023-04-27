package com.oppo.camera.panorama;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;

public class PanoramaProgressBar extends View {

    /* renamed from: a  reason: collision with root package name */
    private static int f3471a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static int f3472b = 0;
    private static int c = 0;
    private static int d = 0;
    private static int e = 6;
    private static int f = 120;
    private static int g = 120;
    private static int h = 0;
    private static int i = 0;
    private static int j = 0;
    private static int k = 36;
    private static int l = 0;
    private static int m = 36;
    private static int n;
    private int A = 0;
    private int B = 0;
    private int C = 0;
    private int D = 0;
    private Drawable E = null;
    private Drawable F = null;
    private Drawable G = null;
    private Rect H = new Rect();
    private Rect I = new Rect();
    private Rect J = new Rect();
    private Rect K = new Rect();
    private Rect L = new Rect();
    private Resources M = null;
    private Paint N = null;
    private Path O = null;
    private Paint P = null;
    private Paint Q = null;
    private int R = 0;
    private RearPanoramaInterface S = null;
    private Bitmap o = null;
    private Canvas p = null;
    private Paint q = null;
    private boolean r = false;
    private int s = -1;
    private int t = 0;
    private int u = 0;
    private int v = 0;
    private int w = 0;
    private int x = 0;
    private int y = 0;
    private int z = 0;

    public interface RearPanoramaInterface {
        void onReportDirectionChange(int i);
    }

    public PanoramaProgressBar(Context context) {
        super(context);
        this.M = context.getApplicationContext().getResources();
        this.G = this.M.getDrawable(R.drawable.panrama_progress_bar_bg);
        this.E = this.M.getDrawable(R.drawable.arrow_left);
        this.F = this.M.getDrawable(R.drawable.arrow_right);
        f = this.M.getDimensionPixelSize(R.dimen.panorama_arrow_width);
        g = this.M.getDimensionPixelSize(R.dimen.panorama_arrow_height);
        e = this.M.getDimensionPixelSize(R.dimen.panorama_line_width);
        k = this.M.getDimensionPixelSize(R.dimen.panorama_progressbar_margin_left);
        m = this.M.getDimensionPixelSize(R.dimen.panorama_arrow_margin_left);
        n = this.M.getColor(R.color.color_white_with_50_percent_transparency);
        this.R = this.M.getDimensionPixelSize(R.dimen.panorama_rim_width);
        this.Q = new Paint();
        this.Q.setStyle(Paint.Style.STROKE);
        this.Q.setStrokeWidth((float) this.R);
        this.Q.setColor(-1);
    }

    public void setRearPanoramaInterface(RearPanoramaInterface rearPanoramaInterface) {
        this.S = rearPanoramaInterface;
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7) {
        f3471a = i2;
        f3472b = i3;
        c = i4;
        d = i5;
        l = i6;
        k = i7;
        Rect rect = this.H;
        int i8 = c;
        int i9 = d;
        rect.set(i8, i9, f3471a + i8, f3472b + i9);
        this.N = new Paint();
        this.N.setStyle(Paint.Style.STROKE);
        this.N.setAntiAlias(true);
        this.N.setStrokeWidth((float) e);
        this.N.setColor(n);
        this.O = new Path();
        this.O.moveTo((float) c, (float) (d + (this.H.height() / 2)));
        this.O.lineTo((float) this.H.right, (float) (d + (this.H.height() / 2)));
        this.P = new Paint();
        this.q = new Paint();
        this.q.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    public void a() {
        int i2 = this.s;
        if (i2 == -1) {
            int i3 = this.y;
            this.u = (f3471a / 2) - (i3 / 2);
            int i4 = this.u;
            this.w = i3 + i4;
            this.v = d;
            int i5 = this.v;
            this.x = f3472b + i5;
            Rect rect = this.I;
            int i6 = l;
            rect.set(i4, i5 + i6, this.w, this.x - i6);
            this.K.set((this.u - m) - f, this.v + ((this.H.height() - g) / 2), this.u - m, this.x - ((this.H.height() - g) / 2));
            this.L.set(this.w + m, this.v + ((this.H.height() - g) / 2), this.w + m + f, this.x - ((this.H.height() - g) / 2));
            int i7 = this.t;
            if (i7 != 0) {
                if (2 == i7) {
                    this.C++;
                    this.B = (int) (((float) i) * a(((float) this.C) / 20.0f));
                    if (20 == this.C) {
                        this.B = i;
                    }
                    this.K.set(((this.u - m) - f) - this.B, this.v + ((this.H.height() - g) / 2) + this.z, (this.u - m) - this.B, (this.x - ((this.H.height() - g) / 2)) + this.z);
                    int i8 = this.K.left;
                    int i9 = c;
                    int i10 = k;
                    int i11 = m;
                    int i12 = this.A;
                    if (i8 < i9 + i10 + i11 + i12) {
                        this.K.left = i9 + i10 + i11 + i12;
                    }
                    if (this.K.left >= this.K.right || 20 == this.C) {
                        setContentDescription(getContext().getString(R.string.camera_description_arrow_left_to_right));
                        Rect rect2 = this.K;
                        rect2.right = rect2.left;
                        this.s = 3;
                        this.r = true;
                    }
                } else if (3 == i7) {
                    this.C++;
                    this.B = (int) (((float) i) * a(((float) this.C) / 20.0f));
                    if (20 == this.C) {
                        this.B = i;
                    }
                    this.L.set(this.w + m + this.B, this.v + ((this.H.height() - g) / 2) + this.z, this.w + m + f + this.B, (this.x - ((this.H.height() - g) / 2)) + this.z);
                    int i13 = this.L.right;
                    int i14 = c;
                    int i15 = f3471a;
                    int i16 = k;
                    int i17 = m;
                    int i18 = this.A;
                    if (i13 > (((i14 + i15) - i16) - i17) - i18) {
                        this.L.right = (((i14 + i15) - i16) - i17) - i18;
                    }
                    if (this.L.left >= this.L.right || 20 == this.C) {
                        setContentDescription(getContext().getString(R.string.camera_description_arrow_right_to_left));
                        Rect rect3 = this.L;
                        rect3.left = rect3.right;
                        this.s = 2;
                        this.r = true;
                    }
                } else if (4 == i7) {
                    this.C++;
                    this.B = (int) (((float) j) * a(((float) this.C) / 20.0f));
                    Rect rect4 = this.I;
                    int i19 = this.u;
                    int i20 = this.B;
                    rect4.left = i19 - i20;
                    rect4.right = this.w - i20;
                    if (20 == this.C) {
                        this.C = 0;
                        this.B = 0;
                        this.s = 3;
                        this.r = true;
                    }
                } else if (5 == i7) {
                    this.C++;
                    this.B = (int) (((float) j) * a(((float) this.C) / 20.0f));
                    Rect rect5 = this.I;
                    int i21 = this.u;
                    int i22 = this.B;
                    rect5.left = i21 + i22;
                    rect5.right = this.w + i22;
                    if (20 == this.C) {
                        this.C = 0;
                        this.B = 0;
                        this.s = 2;
                        this.r = true;
                    }
                }
            }
        } else if (i2 == 2) {
            int i23 = c;
            this.w = (f3471a + i23) - k;
            this.u = this.w - this.y;
            this.v = d;
            this.x = this.v + f3472b;
            if (this.u <= i23) {
                this.u = i23;
            }
            Rect rect6 = this.I;
            int i24 = this.u;
            int i25 = this.v;
            int i26 = l;
            rect6.set(i24, i25 + i26, this.w, this.x - i26);
            int i27 = this.t;
            if (i27 == 0) {
                int i28 = this.u;
                int i29 = c;
                int i30 = m;
                int i31 = f;
                if (i28 <= k + i29 + i30 + i31) {
                    this.J.set(i29 + i30, this.v + ((this.H.height() - g) / 2) + this.z, c + m + f, (this.x - ((this.H.height() - g) / 2)) + this.z);
                } else {
                    this.J.set((i28 - i30) - i31, this.v + ((this.H.height() - g) / 2) + this.z, this.u - m, (this.x - ((this.H.height() - g) / 2)) + this.z);
                }
            } else if (3 == i27) {
                this.C++;
                this.B = (int) (((float) i) * a(((float) this.C) / 20.0f));
                if (20 == this.C) {
                    this.B = i;
                }
                this.J.set((this.u - m) - (this.B - (i - f)), this.v + ((this.H.height() - g) / 2) + this.z, this.u - m, (this.x - ((this.H.height() - g) / 2)) + this.z);
                if (this.J.right - this.J.left >= f) {
                    Rect rect7 = this.J;
                    rect7.left = rect7.right - f;
                    this.B = 0;
                    this.C = 0;
                }
            } else if (1 == i27) {
                this.C++;
                this.B = (int) (((float) h) * a(((float) this.C) / 30.0f));
                if (30 == this.C) {
                    this.B = h;
                }
                if (this.r) {
                    this.J.set((this.u - m) - (this.B - (h - f)), this.v + ((this.H.height() - g) / 2) + this.z, this.u - m, (this.x - ((this.H.height() - g) / 2)) + this.z);
                    if (this.J.right - this.J.left >= f) {
                        Rect rect8 = this.J;
                        rect8.left = rect8.right - f;
                        this.B = 0;
                        this.C = 0;
                        return;
                    }
                    return;
                }
                this.J.set(((this.u - m) - f) - this.B, this.v + ((this.H.height() - g) / 2) + this.z, (this.u - m) - this.B, (this.x - ((this.H.height() - g) / 2)) + this.z);
                int i32 = this.J.left;
                int i33 = c;
                int i34 = k;
                int i35 = m;
                int i36 = this.A;
                if (i32 < i33 + i34 + i35 + i36) {
                    this.J.left = i33 + i34 + i35 + i36;
                }
                if (this.J.left >= this.J.right || 30 == this.C) {
                    setContentDescription(getContext().getString(R.string.camera_description_arrow_left_to_right));
                    Rect rect9 = this.J;
                    rect9.right = rect9.left;
                    this.s = 3;
                    this.r = true;
                }
            } else if (6 == i27) {
                this.C++;
                this.B = (int) (((float) j) * a(((float) this.C) / 20.0f));
                Rect rect10 = this.I;
                int i37 = this.u;
                int i38 = this.B;
                rect10.left = i37 - i38;
                rect10.right = this.w - i38;
                if (20 == this.C) {
                    this.C = 0;
                    this.B = 0;
                    this.s = -1;
                    this.r = true;
                }
            }
        } else if (i2 == 3) {
            this.u = c + k;
            int i39 = this.u;
            this.w = this.y + i39;
            this.v = d;
            this.x = this.v + f3472b;
            int i40 = this.w;
            if (i39 >= i40) {
                this.u = i40;
            }
            Rect rect11 = this.I;
            int i41 = this.u;
            int i42 = this.v;
            int i43 = l;
            rect11.set(i41, i42 + i43, this.w, this.x - i43);
            int i44 = this.t;
            if (i44 == 0) {
                int i45 = this.w;
                int i46 = m;
                int i47 = f;
                int i48 = i45 + i46 + i47;
                int i49 = c;
                int i50 = f3471a;
                if (i48 >= (i49 + i50) - i46) {
                    this.J.set(((i49 + i50) - i47) - i46, this.v + ((this.H.height() - g) / 2) + this.z, (c + f3471a) - m, (this.x - ((this.H.height() - g) / 2)) + this.z);
                } else {
                    this.J.set(i45 + i46, this.v + ((this.H.height() - g) / 2) + this.z, this.w + m + f, (this.x - ((this.H.height() - g) / 2)) + this.z);
                }
            } else if (2 == i44) {
                this.C++;
                this.B = (int) (((float) i) * a(((float) this.C) / 20.0f));
                if (20 == this.C) {
                    this.B = i;
                }
                this.J.set(this.w + m, this.v + ((this.H.height() - g) / 2) + this.z, this.w + m + (this.B - (i - f)), (this.x - ((this.H.height() - g) / 2)) + this.z);
                if (this.J.right - this.J.left >= f) {
                    Rect rect12 = this.J;
                    rect12.right = rect12.left + f;
                    this.B = 0;
                    this.C = 0;
                }
            } else if (1 == i44) {
                this.C++;
                this.B = (int) (((float) h) * a(((float) this.C) / 30.0f));
                if (30 == this.C) {
                    this.B = h;
                }
                if (this.r) {
                    this.J.set(this.w + m, this.v + ((this.H.height() - g) / 2) + this.z, this.w + m + (this.B - (h - f)), (this.x - ((this.H.height() - g) / 2)) + this.z);
                    if (this.J.right - this.J.left >= f) {
                        Rect rect13 = this.J;
                        rect13.right = rect13.left + f;
                        this.B = 0;
                        this.C = 0;
                        return;
                    }
                    return;
                }
                this.J.set(this.w + m + this.B, this.v + ((this.H.height() - g) / 2) + this.z, this.w + m + f + this.B, (this.x - ((this.H.height() - g) / 2)) + this.z);
                int i51 = this.J.right;
                int i52 = c;
                int i53 = f3471a;
                int i54 = k;
                int i55 = m;
                int i56 = this.A;
                if (i51 > (((i52 + i53) - i54) - i55) - i56) {
                    this.J.right = (((i52 + i53) - i54) - i55) - i56;
                }
                if (this.J.left >= this.J.right || 30 == this.C) {
                    setContentDescription(getContext().getString(R.string.camera_description_arrow_right_to_left));
                    Rect rect14 = this.J;
                    rect14.left = rect14.right;
                    this.s = 2;
                    this.r = true;
                }
            } else if (6 == i44) {
                this.C++;
                this.B = (int) (((float) j) * a(((float) this.C) / 20.0f));
                Rect rect15 = this.I;
                int i57 = this.u;
                int i58 = this.B;
                rect15.left = i57 + i58;
                rect15.right = this.w + i58;
                if (20 == this.C) {
                    this.C = 0;
                    this.B = 0;
                    this.s = -1;
                    this.r = true;
                }
            }
        }
    }

    public void setDisplay(Canvas canvas) {
        this.G.setBounds(this.H);
        this.G.draw(canvas);
        canvas.drawPath(this.O, this.N);
        Bitmap bitmap = this.o;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (float) this.I.left, (float) this.I.top, this.P);
            canvas.drawRect(((float) this.I.left) + (((float) this.R) / 2.0f), ((float) this.I.top) + (((float) this.R) / 2.0f), ((float) this.I.right) - (((float) this.R) / 2.0f), ((float) this.I.bottom) - (((float) this.R) / 2.0f), this.Q);
            canvas.save();
            canvas.restore();
        }
        int i2 = this.s;
        if (i2 == -1) {
            int i3 = this.t;
            if (i3 == 0 || 2 == i3) {
                this.E.setBounds(this.K);
                this.E.draw(canvas);
            }
            int i4 = this.t;
            if (i4 == 0 || 3 == i4) {
                this.F.setBounds(this.L);
                this.F.draw(canvas);
            }
        } else if (i2 != 2) {
            if (i2 == 3 && 6 != this.t) {
                this.F.setBounds(this.J);
                this.F.draw(canvas);
            }
        } else if (6 != this.t) {
            this.E.setBounds(this.J);
            this.E.draw(canvas);
        }
        if (this.r && this.B == 0) {
            setAnimationState(0);
            this.r = false;
            e.a("PanoramaProgressBar", "setDisplay, animate end");
        }
        this.P.reset();
        if (this.t == 0) {
            this.Q.setAlpha(255);
        }
        int i5 = this.t;
        if (1 == i5) {
            if (this.r) {
                this.D--;
            } else {
                this.D++;
            }
            int i6 = this.D;
            if (10 <= i6) {
                this.D = 10;
                this.P.setAlpha(0);
                this.Q.setAlpha(0);
            } else if (i6 <= 0) {
                this.D = 0;
                this.P.setAlpha(255);
                this.Q.setAlpha(255);
            } else {
                this.P.setAlpha((int) ((((float) (10 - i6)) / 10.0f) * 255.0f));
                this.Q.setAlpha((int) ((((float) (10 - this.D)) / 10.0f) * 255.0f));
            }
        } else if (2 == i5 || 3 == i5) {
            if (this.r) {
                this.D--;
            } else {
                this.D++;
            }
            int i7 = this.D;
            if (6 <= i7) {
                this.D = 6;
                this.P.setAlpha(0);
                this.Q.setAlpha(0);
            } else if (i7 <= 0) {
                this.D = 0;
                this.P.setAlpha(255);
                this.Q.setAlpha(255);
            } else {
                this.P.setAlpha((int) ((((float) (6 - i7)) / 6.0f) * 255.0f));
                this.Q.setAlpha((int) ((((float) (6 - this.D)) / 6.0f) * 255.0f));
            }
        }
    }

    public void onDraw(Canvas canvas) {
        a();
        setDisplay(canvas);
        if (d()) {
            invalidate();
        }
    }

    public void b() {
        Bitmap bitmap = this.o;
        if (bitmap != null) {
            bitmap.recycle();
            this.o = null;
        }
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.I.setEmpty();
        e();
        setAnimationState(0);
        setDirection(-1);
    }

    public void setVisibility(int i2) {
        if (i2 == 0) {
            this.o = null;
        }
        super.setVisibility(i2);
    }

    public void a(Bitmap bitmap, int i2, int i3) {
        Bitmap bitmap2;
        this.z = i3;
        if (i2 == 0 && this.y > this.A) {
            this.s = -1;
        }
        this.y = Math.abs(i2) + this.A;
        if (i2 <= 0 || (bitmap2 = this.o) == null) {
            this.o = bitmap;
        } else {
            int width = bitmap2.getWidth();
            int i4 = f3471a;
            if (width != i4) {
                this.o = Util.a(i4, f3472b, Bitmap.Config.ARGB_8888);
                this.p = new Canvas(this.o);
            }
            this.p.save();
            this.p.drawBitmap(bitmap, 0.0f, 0.0f, this.q);
            this.p.restore();
        }
        invalidate();
    }

    public void setFrameSize(int i2) {
        if (this.A != i2) {
            this.A = i2;
            if (h == 0) {
                h = (f3471a - (((this.A + k) + m) * 2)) + f;
            }
            if (i == 0) {
                int i3 = f3471a;
                int i4 = this.A;
                i = (((i3 - i4) / 2) - ((i4 + k) + (m * 2))) + f;
            }
            if (j == 0) {
                j = ((f3471a - this.A) / 2) - k;
            }
        }
    }

    public void c() {
        Bitmap bitmap = this.o;
        if (bitmap != null) {
            bitmap.recycle();
            this.o = null;
        }
    }

    public void setAnimationState(int i2) {
        e.a("PanoramaProgressBar", "setAnimationStateState, animationState: " + i2);
        this.t = i2;
    }

    public boolean d() {
        return this.t != 0;
    }

    public float a(float f2) {
        return ((float) (Math.cos(((double) (f2 + 1.0f)) * 3.141592653589793d) * 0.5d)) + 0.5f;
    }

    private void a(int i2) {
        if (!d()) {
            setAnimationState(i2);
            this.B = 0;
            this.C = 0;
            this.D = 0;
            b(i2);
            invalidate();
        }
    }

    private void b(int i2) {
        int i3 = 2;
        if (i2 == 1) {
            RearPanoramaInterface rearPanoramaInterface = this.S;
            if (3 == this.s) {
                i3 = 1;
            }
            rearPanoramaInterface.onReportDirectionChange(i3);
        } else if (i2 == 2) {
            this.S.onReportDirectionChange(5);
        } else if (i2 == 3) {
            this.S.onReportDirectionChange(4);
        }
    }

    public void setDirection(int i2) {
        this.s = i2;
        postInvalidate();
    }

    public int getDirection() {
        return this.s;
    }

    public void e() {
        this.J.setEmpty();
    }

    public void f() {
        e();
        this.B = 0;
        this.C = 0;
        setAnimationState(0);
        setDirection(-1);
    }

    /* access modifiers changed from: protected */
    public boolean a(MotionEvent motionEvent) {
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        Rect rect = this.H;
        if (rect == null || !rect.contains(x2, y2) || this.y != this.A) {
            return false;
        }
        if (-1 == this.s) {
            int i2 = this.u;
            if (x2 <= (i2 - m) - f || x2 >= i2) {
                int i3 = this.w;
                if (x2 > i3 && x2 < i3 + m + f) {
                    a(3);
                }
            } else {
                a(2);
            }
        } else {
            a(1);
        }
        return true;
    }
}
