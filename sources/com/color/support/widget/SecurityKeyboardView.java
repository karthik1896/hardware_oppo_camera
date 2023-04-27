package com.color.support.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import color.support.v7.appcompat.R;
import color.support.v7.widget.e;
import com.color.support.widget.n;
import com.oppo.exif.OppoExifTag;
import com.sensetime.stmobile.STCommon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecurityKeyboardView extends View implements View.OnClickListener {
    private static final int[] aI = {16842909, 1, 16842913, 2, 16842908, 4, 16842910, 8, 16842919, 16, 16843518, 32, 16843547, 64, 16843623, 128, 16843624, 256, 16843625, 512};
    private static int[][][] aJ;
    private static int[][] aK;
    private static int aL = R.styleable.ViewDrawableStates.length;
    private static final int at = ViewConfiguration.getLongPressTimeout();
    private static int au = 12;
    private static final int[] c = {-5};
    private static final int[] d = {16843324};
    private n.a[] A;
    /* access modifiers changed from: private */
    public b B;
    private int C;
    private int D;
    private boolean E;
    private boolean F;
    private boolean G;
    private int H;
    private int I;
    private int J;
    private int K;
    /* access modifiers changed from: private */
    public int L;
    /* access modifiers changed from: private */
    public int M;
    private boolean N;
    private Paint O;
    private Rect P;
    private long Q;
    private long R;
    private int S;
    private int T;
    private int U;
    private int V;
    /* access modifiers changed from: private */
    public int W;

    /* renamed from: a  reason: collision with root package name */
    Handler f2143a;
    private StringBuilder aA;
    private boolean aB;
    private Rect aC;
    private Bitmap aD;
    private boolean aE;
    private Canvas aF;
    private AccessibilityManager aG;
    private AudioManager aH;
    private int aM;
    private int aN;
    private ColorStateList aO;
    private ColorStateList aP;
    private Drawable aQ;
    private Drawable aR;
    /* access modifiers changed from: private */
    public Typeface aS;
    private c aT;
    private int aU;
    private int aV;
    private int aW;
    private int aX;
    private int aY;
    private int aZ;
    private long aa;
    private long ab;
    private int[] ac;
    private GestureDetector ad;
    private int ae;
    private int af;
    private int ag;
    private int ah;
    private boolean ai;
    private n.a aj;
    private Rect ak;
    /* access modifiers changed from: private */
    public boolean al;
    /* access modifiers changed from: private */
    public d am;
    /* access modifiers changed from: private */
    public int an;
    /* access modifiers changed from: private */
    public boolean ao;
    private int ap;
    private float aq;
    private float ar;
    private Drawable as;
    private int[] av;
    private int aw;
    private int ax;
    private long ay;
    private boolean az;

    /* renamed from: b  reason: collision with root package name */
    protected List<Integer> f2144b;
    private boolean ba;
    private int bb;
    private boolean bc;
    private float bd;
    private int be;
    private int bf;
    private String[] bg;
    private int bh;
    private ColorStateList bi;
    /* access modifiers changed from: private */
    public int bj;
    private int bk;
    private int bl;
    private ArrayList<a> bm;
    private ArrayList<Drawable> bn;
    private Drawable bo;
    private List<int[]> bp;
    private n e;
    private int f;
    private int g;
    private int h;
    private int i;
    private float j;
    private int k;
    private float l;
    /* access modifiers changed from: private */
    public TextView m;
    private e n;
    private int o;
    private int p;
    private int q;
    private final int[] r;
    private PopupWindow s;
    private View t;
    private SecurityKeyboardView u;
    private boolean v;
    private View w;
    private int x;
    private int y;
    private Map<n.a, View> z;

    public interface b {
        void a();

        void a(int i);

        void a(int i, int[] iArr);

        void a(CharSequence charSequence);

        void b();

        void b(int i);

        void c();

        void d();
    }

    public interface c {
        void a(String str, int i);
    }

    public void setVerticalCorrection(int i2) {
    }

    static {
        int[] iArr = aI;
        int length = iArr.length / 2;
        if (length == aL) {
            int[] iArr2 = new int[iArr.length];
            for (int i2 = 0; i2 < aL; i2++) {
                int i3 = R.styleable.ViewDrawableStates[i2];
                int i4 = 0;
                while (true) {
                    int[] iArr3 = aI;
                    if (i4 >= iArr3.length) {
                        break;
                    }
                    if (iArr3[i4] == i3) {
                        int i5 = i2 * 2;
                        iArr2[i5] = i3;
                        iArr2[i5 + 1] = iArr3[i4 + 1];
                    }
                    i4 += 2;
                }
            }
            int i6 = 1 << length;
            aJ = new int[i6][][];
            aK = new int[i6][];
            for (int i7 = 0; i7 < aK.length; i7++) {
                aK[i7] = new int[Integer.bitCount(i7)];
                int i8 = 0;
                for (int i9 = 0; i9 < iArr2.length; i9 += 2) {
                    if ((iArr2[i9 + 1] & i7) != 0) {
                        aK[i7][i8] = iArr2[i9];
                        i8++;
                    }
                }
            }
            return;
        }
        throw new IllegalStateException("VIEW_STATE_IDS array length does not match ViewDrawableStates style array");
    }

    public SecurityKeyboardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SecurityKeyboardView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, R.style.SecurityKeyboardView);
    }

    public SecurityKeyboardView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f = -1;
        this.r = new int[2];
        this.E = false;
        this.F = true;
        this.G = true;
        this.V = -1;
        this.W = -1;
        this.ac = new int[12];
        this.ag = -1;
        this.ak = new Rect(0, 0, 0, 0);
        this.am = new d();
        this.ap = 1;
        this.av = new int[au];
        this.aA = new StringBuilder(1);
        this.aC = new Rect();
        this.f2144b = new ArrayList();
        this.aN = 0;
        this.aQ = null;
        this.aR = null;
        this.aS = null;
        this.aU = 0;
        this.aV = 0;
        this.aW = 0;
        this.aX = 0;
        this.aY = 0;
        this.aZ = 0;
        this.ba = true;
        this.bb = -1;
        this.bc = false;
        this.bd = -1.0f;
        this.be = -1;
        this.bf = -1;
        this.bg = null;
        this.bj = -1;
        this.bk = 2;
        this.bl = -1;
        this.bm = new ArrayList<>();
        this.bn = new ArrayList<>();
        this.bp = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SecurityKeyboardView, i2, R.style.SecurityKeyboardView);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.as = obtainStyledAttributes.getDrawable(R.styleable.SecurityKeyboardView_colorKeyBackground);
        this.C = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SecurityKeyboardView_colorVerticalCorrection, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SecurityKeyboardView_colorKeyPreviewLayout, 0);
        this.p = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SecurityKeyboardView_colorKeyPreviewOffset, 0);
        this.q = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SecurityKeyboardView_colorKeyPreviewHeight, 80);
        this.aM = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SecurityKeyboardView_colorKeyPreviewWidth, 80);
        this.h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SecurityKeyboardView_colorKeyTextSize, 18);
        this.i = obtainStyledAttributes.getColor(R.styleable.SecurityKeyboardView_colorKeyTextColor, -16777216);
        this.g = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SecurityKeyboardView_colorLabelTextSize, 14);
        this.ah = obtainStyledAttributes.getResourceId(R.styleable.SecurityKeyboardView_colorPopupLayout, 0);
        this.k = obtainStyledAttributes.getColor(R.styleable.SecurityKeyboardView_colorShadowColor, 0);
        this.j = obtainStyledAttributes.getFloat(R.styleable.SecurityKeyboardView_colorShadowRadius, 0.0f);
        this.aN = obtainStyledAttributes.getInt(R.styleable.SecurityKeyboardView_colorKeyBoardType, 0);
        this.aO = obtainStyledAttributes.getColorStateList(R.styleable.SecurityKeyboardView_colorTextColor);
        this.aP = obtainStyledAttributes.getColorStateList(R.styleable.SecurityKeyboardView_colorGoTextColor);
        this.aQ = obtainStyledAttributes.getDrawable(R.styleable.SecurityKeyboardView_colorSpecialKeyBg);
        this.aR = obtainStyledAttributes.getDrawable(R.styleable.SecurityKeyboardView_colorEndKeyBg);
        this.bi = obtainStyledAttributes.getColorStateList(R.styleable.SecurityKeyboardView_colorItemSymbolsColor);
        this.bo = obtainStyledAttributes.getDrawable(R.styleable.SecurityKeyboardView_colorSpecialItemBg);
        this.l = 0.5f;
        this.n = new e(context);
        if (resourceId != 0) {
            this.m = (TextView) layoutInflater.inflate(resourceId, (ViewGroup) null);
            this.o = (int) this.m.getTextSize();
            this.n.setContentView(this.m);
            this.n.setBackgroundDrawable((Drawable) null);
        } else {
            this.F = false;
        }
        this.n.setTouchable(false);
        this.n.a((e.b) new e.b() {
            public void a(WindowManager.LayoutParams layoutParams) {
                layoutParams.flags |= OppoExifTag.EXIF_TAG_SUPER_HIGH_RESOLUTION;
                layoutParams.setTitle("ColorSecurityPopupWindow");
            }
        });
        this.s = new PopupWindow(context);
        this.s.setBackgroundDrawable((Drawable) null);
        this.w = this;
        this.O = new Paint();
        this.O.setAntiAlias(true);
        this.O.setTextSize((float) 0);
        this.O.setTextAlign(Paint.Align.CENTER);
        this.O.setAlpha(255);
        this.P = new Rect(0, 0, 0, 0);
        this.z = new HashMap();
        Drawable drawable = this.as;
        if (drawable != null) {
            drawable.getPadding(this.P);
        }
        this.an = (int) (getResources().getDisplayMetrics().density * 500.0f);
        this.ao = true;
        this.aG = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.aH = (AudioManager) context.getSystemService("audio");
        n();
        setKeyboardType(1);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"HandlerLeak"})
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i();
        if (this.f2143a == null) {
            this.f2143a = new Handler() {
                public void handleMessage(Message message) {
                    int i = message.what;
                    if (i == 1) {
                        SecurityKeyboardView.this.d(message.arg1);
                    } else if (i == 2) {
                        Log.d("SecurityKeyboardView", "handleMessage MSG_REMOVE_PREVIEW");
                        SecurityKeyboardView.this.m.setVisibility(4);
                    } else if (i != 3) {
                        if (i == 4) {
                            boolean unused = SecurityKeyboardView.this.a((MotionEvent) message.obj);
                        }
                    } else if (SecurityKeyboardView.this.k()) {
                        sendMessageDelayed(Message.obtain(this, 3), 50);
                    }
                }
            };
        }
    }

    private void i() {
        if (this.ad == null) {
            this.ad = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    if (SecurityKeyboardView.this.al) {
                        return false;
                    }
                    float abs = Math.abs(f);
                    float abs2 = Math.abs(f2);
                    float x = motionEvent2.getX() - motionEvent.getX();
                    float y = motionEvent2.getY() - motionEvent.getY();
                    int width = SecurityKeyboardView.this.getWidth() / 2;
                    int height = SecurityKeyboardView.this.getHeight() / 2;
                    SecurityKeyboardView.this.am.a(1000);
                    float b2 = SecurityKeyboardView.this.am.b();
                    float c = SecurityKeyboardView.this.am.c();
                    boolean z = true;
                    if (f <= ((float) SecurityKeyboardView.this.an) || abs2 >= abs || x <= ((float) width)) {
                        if (f >= ((float) (-SecurityKeyboardView.this.an)) || abs2 >= abs || x >= ((float) (-width))) {
                            if (f2 >= ((float) (-SecurityKeyboardView.this.an)) || abs >= abs2 || y >= ((float) (-height))) {
                                if (f2 <= ((float) SecurityKeyboardView.this.an) || abs >= abs2 / 2.0f || y <= ((float) height)) {
                                    z = false;
                                } else if (!SecurityKeyboardView.this.ao || c >= f2 / 4.0f) {
                                    SecurityKeyboardView.this.e();
                                    return true;
                                }
                            } else if (!SecurityKeyboardView.this.ao || c <= f2 / 4.0f) {
                                SecurityKeyboardView.this.d();
                                return true;
                            }
                        } else if (!SecurityKeyboardView.this.ao || b2 <= f / 4.0f) {
                            SecurityKeyboardView.this.c();
                            return true;
                        }
                    } else if (!SecurityKeyboardView.this.ao || b2 >= f / 4.0f) {
                        SecurityKeyboardView.this.b();
                        return true;
                    }
                    if (z) {
                        SecurityKeyboardView securityKeyboardView = SecurityKeyboardView.this;
                        securityKeyboardView.a(securityKeyboardView.W, SecurityKeyboardView.this.L, SecurityKeyboardView.this.M, motionEvent.getEventTime());
                    }
                    return false;
                }
            });
            this.ad.setIsLongpressEnabled(false);
        }
    }

    /* access modifiers changed from: protected */
    public b getOnKeyboardActionListener() {
        return this.B;
    }

    public void setOnKeyboardActionListener(b bVar) {
        this.B = bVar;
    }

    public n getKeyboard() {
        return this.e;
    }

    public void setKeyboard(n nVar) {
        if (this.e != null) {
            c(-1);
        }
        l();
        this.e = nVar;
        List<n.a> a2 = this.e.a();
        this.A = (n.a[]) a2.toArray(new n.a[a2.size()]);
        requestLayout();
        this.aE = true;
        a();
        a(nVar);
        this.z.clear();
        this.ag = -1;
        this.ai = true;
    }

    public void setNewShifted(int i2) {
        n nVar = this.e;
        if (nVar != null) {
            nVar.a(i2);
            a();
        }
    }

    public int getNewShifted() {
        n nVar = this.e;
        if (nVar != null) {
            return nVar.d();
        }
        return -1;
    }

    public void setPreviewEnabled(boolean z2) {
        this.F = z2;
    }

    public void setPopupParent(View view) {
        this.w = view;
    }

    public void a(int i2, int i3) {
        this.x = i2;
        this.y = i3;
        if (this.n.isShowing()) {
            Log.d("SecurityKeyboardView", "PopupView is Showing");
            this.n.dismiss();
        }
    }

    public void setProximityCorrectionEnabled(boolean z2) {
        this.N = z2;
    }

    public void onClick(View view) {
        m();
    }

    private CharSequence a(CharSequence charSequence) {
        return (getNewShifted() < 1 || charSequence == null || charSequence.length() >= 3 || !Character.isLowerCase(charSequence.charAt(0))) ? charSequence : charSequence.toString().toUpperCase();
    }

    public void onMeasure(int i2, int i3) {
        if (this.e == null) {
            setMeasuredDimension(getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        } else {
            setMeasuredDimension(View.MeasureSpec.getSize(i2), this.e.b() + getPaddingTop() + getPaddingBottom());
        }
    }

    private void a(n nVar) {
        n.a[] aVarArr;
        if (nVar != null && (aVarArr = this.A) != null) {
            int i2 = 0;
            for (n.a aVar : aVarArr) {
                i2 += Math.min(aVar.e, aVar.f) + aVar.g;
            }
            if (i2 >= 0 && r0 != 0) {
                this.D = (int) ((((float) i2) * 1.4f) / ((float) r0));
                int i3 = this.D;
                this.D = i3 * i3;
            }
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        n nVar = this.e;
        this.aD = null;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aB || this.aD == null || this.aE) {
            j();
        }
        canvas.drawBitmap(this.aD, 0.0f, 0.0f, (Paint) null);
        if (h()) {
            a(canvas, this.bh);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:126:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0247  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void j() {
        /*
            r18 = this;
            r0 = r18
            android.graphics.Bitmap r1 = r0.aD
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x000c
            boolean r1 = r0.aE
            if (r1 == 0) goto L_0x0050
        L_0x000c:
            android.graphics.Bitmap r1 = r0.aD
            if (r1 == 0) goto L_0x002a
            boolean r4 = r0.aE
            if (r4 == 0) goto L_0x004b
            int r1 = r1.getWidth()
            int r4 = r18.getWidth()
            if (r1 != r4) goto L_0x002a
            android.graphics.Bitmap r1 = r0.aD
            int r1 = r1.getHeight()
            int r4 = r18.getHeight()
            if (r1 == r4) goto L_0x004b
        L_0x002a:
            int r1 = r18.getWidth()
            int r1 = java.lang.Math.max(r2, r1)
            int r4 = r18.getHeight()
            int r4 = java.lang.Math.max(r2, r4)
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r1, r4, r5)
            r0.aD = r1
            android.graphics.Canvas r1 = new android.graphics.Canvas
            android.graphics.Bitmap r4 = r0.aD
            r1.<init>(r4)
            r0.aF = r1
        L_0x004b:
            r18.a()
            r0.aE = r3
        L_0x0050:
            com.color.support.widget.n r1 = r0.e
            if (r1 != 0) goto L_0x0055
            return
        L_0x0055:
            android.graphics.Canvas r1 = r0.aF
            r1.save()
            android.graphics.Canvas r4 = r0.aF
            android.graphics.Rect r1 = r0.aC
            r4.clipRect(r1)
            android.graphics.Paint r9 = r0.O
            android.graphics.drawable.Drawable r1 = r0.as
            android.graphics.Rect r1 = r0.ak
            android.graphics.Rect r5 = r0.P
            int r6 = r18.getPaddingLeft()
            int r7 = r18.getPaddingTop()
            com.color.support.widget.n$a[] r8 = r0.A
            com.color.support.widget.n$a r10 = r0.aj
            int r11 = r0.i
            r9.setColor(r11)
            if (r10 == 0) goto L_0x00aa
            boolean r11 = r4.getClipBounds(r1)
            if (r11 == 0) goto L_0x00aa
            int r11 = r10.i
            int r11 = r11 + r6
            int r11 = r11 - r2
            int r12 = r1.left
            if (r11 > r12) goto L_0x00aa
            int r11 = r10.j
            int r11 = r11 + r7
            int r11 = r11 - r2
            int r12 = r1.top
            if (r11 > r12) goto L_0x00aa
            int r11 = r10.i
            int r12 = r10.e
            int r11 = r11 + r12
            int r11 = r11 + r6
            int r11 = r11 + r2
            int r12 = r1.right
            if (r11 < r12) goto L_0x00aa
            int r11 = r10.j
            int r12 = r10.f
            int r11 = r11 + r12
            int r11 = r11 + r7
            int r11 = r11 + r2
            int r1 = r1.bottom
            if (r11 < r1) goto L_0x00aa
            r1 = r2
            goto L_0x00ab
        L_0x00aa:
            r1 = r3
        L_0x00ab:
            android.graphics.PorterDuff$Mode r11 = android.graphics.PorterDuff.Mode.CLEAR
            r4.drawColor(r3, r11)
            int r11 = r8.length
            r12 = r3
        L_0x00b2:
            if (r12 >= r11) goto L_0x02e3
            r14 = r8[r12]
            if (r1 == 0) goto L_0x00c0
            if (r10 == r14) goto L_0x00c0
            r17 = r1
            r16 = r5
            goto L_0x02d9
        L_0x00c0:
            int[] r15 = r14.b()
            android.graphics.drawable.Drawable r13 = r0.aQ
            if (r13 == 0) goto L_0x0104
            int[] r13 = r14.f2227a
            r13 = r13[r3]
            r2 = -1
            if (r13 == r2) goto L_0x00fd
            int[] r2 = r14.f2227a
            r2 = r2[r3]
            r13 = -5
            if (r2 == r13) goto L_0x00fd
            int[] r2 = r14.f2227a
            r2 = r2[r3]
            r13 = -2
            if (r2 == r13) goto L_0x00fd
            int[] r2 = r14.f2227a
            r2 = r2[r3]
            r13 = -6
            if (r2 == r13) goto L_0x00fd
            int[] r2 = r14.f2227a
            r2 = r2[r3]
            r13 = -7
            if (r2 == r13) goto L_0x00fd
            boolean r2 = r18.h()
            if (r2 == 0) goto L_0x0104
            int r2 = r11 + -2
            if (r12 == r2) goto L_0x00fd
            int r2 = r11 + -6
            if (r12 == r2) goto L_0x00fd
            int r2 = r11 + -10
            if (r12 != r2) goto L_0x0104
        L_0x00fd:
            android.graphics.drawable.Drawable r2 = r0.aQ
            r17 = r1
            r13 = 10
            goto L_0x0119
        L_0x0104:
            android.graphics.drawable.Drawable r2 = r0.aR
            if (r2 == 0) goto L_0x0113
            int[] r2 = r14.f2227a
            r2 = r2[r3]
            r13 = 10
            if (r2 != r13) goto L_0x0115
            android.graphics.drawable.Drawable r2 = r0.aR
            goto L_0x0117
        L_0x0113:
            r13 = 10
        L_0x0115:
            android.graphics.drawable.Drawable r2 = r0.as
        L_0x0117:
            r17 = r1
        L_0x0119:
            int[] r1 = r14.f2227a
            r1 = r1[r3]
            if (r1 != r13) goto L_0x0126
            android.content.res.ColorStateList r1 = r0.aP
            int r1 = r1.getColorForState(r15, r3)
            goto L_0x012c
        L_0x0126:
            android.content.res.ColorStateList r1 = r0.aO
            int r1 = r1.getColorForState(r15, r3)
        L_0x012c:
            r9.setColor(r1)
            if (r2 == 0) goto L_0x0134
            r2.setState(r15)
        L_0x0134:
            java.lang.CharSequence r1 = r14.f2228b
            if (r1 != 0) goto L_0x013a
            r13 = 0
            goto L_0x0144
        L_0x013a:
            java.lang.CharSequence r1 = r14.f2228b
            java.lang.CharSequence r1 = r0.a((java.lang.CharSequence) r1)
            java.lang.String r13 = r1.toString()
        L_0x0144:
            if (r2 == 0) goto L_0x015e
            android.graphics.Rect r1 = r2.getBounds()
            int r15 = r14.e
            int r3 = r1.right
            if (r15 != r3) goto L_0x0156
            int r3 = r14.f
            int r1 = r1.bottom
            if (r3 == r1) goto L_0x015e
        L_0x0156:
            int r1 = r14.e
            int r3 = r14.f
            r15 = 0
            r2.setBounds(r15, r15, r1, r3)
        L_0x015e:
            int r1 = r14.i
            int r1 = r1 + r6
            float r1 = (float) r1
            int r3 = r14.j
            int r3 = r3 + r7
            float r3 = (float) r3
            r4.translate(r1, r3)
            if (r2 == 0) goto L_0x016e
            r2.draw(r4)
        L_0x016e:
            if (r13 == 0) goto L_0x0278
            r1 = 0
            char r2 = r13.charAt(r1)
            boolean r2 = java.lang.Character.isLowerCase(r2)
            r3 = 32
            if (r2 == 0) goto L_0x018d
            int[] r2 = r14.f2227a
            r2 = r2[r1]
            if (r2 == r3) goto L_0x018d
            int r2 = r0.aU
            float r2 = (float) r2
            r9.setTextSize(r2)
            r9.setFakeBoldText(r1)
            goto L_0x019c
        L_0x018d:
            int[] r2 = r14.f2227a
            r2 = r2[r1]
            if (r2 != r3) goto L_0x01a0
            int r2 = r0.aW
            float r2 = (float) r2
            r9.setTextSize(r2)
            r9.setFakeBoldText(r1)
        L_0x019c:
            r2 = r1
            r1 = 1
            goto L_0x0238
        L_0x01a0:
            int[] r2 = r14.f2227a
            r2 = r2[r1]
            r3 = -2
            if (r2 == r3) goto L_0x020b
            int[] r2 = r14.f2227a
            r2 = r2[r1]
            r3 = 10
            if (r2 == r3) goto L_0x020b
            int[] r2 = r14.f2227a
            r2 = r2[r1]
            r3 = -1
            if (r2 == r3) goto L_0x020b
            int[] r2 = r14.f2227a
            r2 = r2[r1]
            r3 = -6
            if (r2 != r3) goto L_0x01be
            goto L_0x020b
        L_0x01be:
            int[] r2 = r14.f2227a
            r2 = r2[r1]
            r3 = -7
            if (r2 != r3) goto L_0x01cf
            int r2 = r0.aZ
            float r2 = (float) r2
            r9.setTextSize(r2)
            r9.setFakeBoldText(r1)
            goto L_0x019c
        L_0x01cf:
            int r2 = r0.aV
            float r2 = (float) r2
            r9.setTextSize(r2)
            char r2 = r13.charAt(r1)
            boolean r2 = java.lang.Character.isDigit(r2)
            if (r2 == 0) goto L_0x01e3
            r9.setFakeBoldText(r1)
            goto L_0x019c
        L_0x01e3:
            java.lang.String r1 = "·"
            boolean r1 = r13.equals(r1)
            if (r1 == 0) goto L_0x01ff
            android.content.res.Resources r1 = r18.getResources()
            int r2 = color.support.v7.appcompat.R.dimen.oppo_password_kbd_symbols_center_dot
            int r1 = r1.getDimensionPixelOffset(r2)
            float r1 = (float) r1
            r9.setTextSize(r1)
            r1 = 1
            r9.setFakeBoldText(r1)
            r2 = 0
            goto L_0x0238
        L_0x01ff:
            r1 = 1
            int r2 = r0.aY
            float r2 = (float) r2
            r9.setTextSize(r2)
            r2 = 0
            r9.setFakeBoldText(r2)
            goto L_0x0238
        L_0x020b:
            r2 = r1
            r1 = 1
            int r3 = r0.aX
            float r3 = (float) r3
            r9.setTextSize(r3)
            int[] r3 = r14.f2227a
            r3 = r3[r2]
            r15 = 10
            if (r3 == r15) goto L_0x0235
            int[] r3 = r14.f2227a
            r3 = r3[r2]
            r15 = -2
            if (r3 == r15) goto L_0x0235
            int[] r3 = r14.f2227a
            r3 = r3[r2]
            r15 = -6
            if (r3 == r15) goto L_0x0235
            int[] r3 = r14.f2227a
            r3 = r3[r2]
            r15 = -7
            if (r3 != r15) goto L_0x0231
            goto L_0x0235
        L_0x0231:
            r9.setFakeBoldText(r2)
            goto L_0x0238
        L_0x0235:
            r9.setFakeBoldText(r2)
        L_0x0238:
            android.graphics.Typeface r3 = r0.aS
            if (r3 == 0) goto L_0x023f
            r9.setTypeface(r3)
        L_0x023f:
            int[] r3 = r14.f2227a
            r3 = r3[r2]
            r2 = 10
            if (r3 != r2) goto L_0x024c
            android.graphics.Typeface r2 = r0.aS
            r9.setTypeface(r2)
        L_0x024c:
            android.graphics.Paint$FontMetricsInt r2 = r9.getFontMetricsInt()
            int r3 = r14.f
            int r15 = r2.bottom
            int r1 = r2.top
            int r15 = r15 - r1
            int r3 = r3 - r15
            int r3 = r3 / 2
            int r1 = r2.top
            int r3 = r3 - r1
            int r1 = r5.bottom
            int r2 = r5.top
            int r1 = r1 - r2
            int r1 = r1 / 2
            int r3 = r3 + r1
            float r1 = (float) r3
            int r2 = r14.e
            int r3 = r5.left
            int r2 = r2 - r3
            int r3 = r5.right
            int r2 = r2 - r3
            int r2 = r2 / 2
            int r3 = r5.left
            int r2 = r2 + r3
            float r2 = (float) r2
            r4.drawText(r13, r2, r1, r9)
            goto L_0x02ca
        L_0x0278:
            android.graphics.drawable.Drawable r1 = r14.c
            if (r1 == 0) goto L_0x02ca
            int r1 = r14.e
            int r2 = r5.left
            int r1 = r1 - r2
            int r2 = r5.right
            int r1 = r1 - r2
            android.graphics.drawable.Drawable r2 = r14.c
            int r2 = r2.getIntrinsicWidth()
            int r1 = r1 - r2
            int r1 = r1 / 2
            int r2 = r5.left
            int r1 = r1 + r2
            int r2 = r14.f
            int r3 = r5.top
            int r2 = r2 - r3
            int r3 = r5.bottom
            int r2 = r2 - r3
            android.graphics.drawable.Drawable r3 = r14.c
            int r3 = r3.getIntrinsicHeight()
            int r2 = r2 - r3
            int r2 = r2 / 2
            int r3 = r5.top
            int r2 = r2 + r3
            float r3 = (float) r1
            float r13 = (float) r2
            r4.translate(r3, r13)
            android.graphics.drawable.Drawable r3 = r14.c
            android.graphics.drawable.Drawable r13 = r14.c
            int r13 = r13.getIntrinsicWidth()
            android.graphics.drawable.Drawable r15 = r14.c
            int r15 = r15.getIntrinsicHeight()
            r16 = r5
            r5 = 0
            r3.setBounds(r5, r5, r13, r15)
            android.graphics.drawable.Drawable r3 = r14.c
            r3.draw(r4)
            int r1 = -r1
            float r1 = (float) r1
            int r2 = -r2
            float r2 = (float) r2
            r4.translate(r1, r2)
            goto L_0x02cc
        L_0x02ca:
            r16 = r5
        L_0x02cc:
            int r1 = r14.i
            int r1 = -r1
            int r1 = r1 - r6
            float r1 = (float) r1
            int r2 = r14.j
            int r2 = -r2
            int r2 = r2 - r7
            float r2 = (float) r2
            r4.translate(r1, r2)
        L_0x02d9:
            int r12 = r12 + 1
            r5 = r16
            r1 = r17
            r2 = 1
            r3 = 0
            goto L_0x00b2
        L_0x02e3:
            r1 = 0
            r0.aj = r1
            boolean r1 = r0.v
            if (r1 == 0) goto L_0x0304
            float r1 = r0.l
            r2 = 1132396544(0x437f0000, float:255.0)
            float r1 = r1 * r2
            int r1 = (int) r1
            int r1 = r1 << 24
            r9.setColor(r1)
            r5 = 0
            r6 = 0
            int r1 = r18.getWidth()
            float r7 = (float) r1
            int r1 = r18.getHeight()
            float r8 = (float) r1
            r4.drawRect(r5, r6, r7, r8, r9)
        L_0x0304:
            android.graphics.Canvas r1 = r0.aF
            r1.restore()
            r1 = 0
            r0.aB = r1
            android.graphics.Rect r1 = r0.aC
            r1.setEmpty()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.widget.SecurityKeyboardView.j():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0039, code lost:
        if (r6 >= r0.D) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(int r19, int r20, int[] r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            com.color.support.widget.n$a[] r4 = r0.A
            int r5 = r0.D
            r6 = 1
            int r5 = r5 + r6
            int[] r7 = r0.av
            r8 = 2147483647(0x7fffffff, float:NaN)
            java.util.Arrays.fill(r7, r8)
            com.color.support.widget.n r7 = r0.e
            int[] r7 = r7.a((int) r1, (int) r2)
            int r8 = r7.length
            r13 = r5
            r5 = 0
            r11 = -1
            r12 = -1
        L_0x0021:
            if (r5 >= r8) goto L_0x0092
            r14 = r7[r5]
            r14 = r4[r14]
            boolean r15 = r14.a(r1, r2)
            if (r15 == 0) goto L_0x002f
            r11 = r7[r5]
        L_0x002f:
            boolean r6 = r0.N
            if (r6 == 0) goto L_0x003c
            int r6 = r14.b(r1, r2)
            int r10 = r0.D
            if (r6 < r10) goto L_0x003f
            goto L_0x003d
        L_0x003c:
            r6 = 0
        L_0x003d:
            if (r15 == 0) goto L_0x0042
        L_0x003f:
            r10 = r6
            r6 = 1
            goto L_0x0044
        L_0x0042:
            r10 = r6
            r6 = 0
        L_0x0044:
            if (r6 == 0) goto L_0x0086
            int[] r6 = r14.f2227a
            int r6 = r6.length
            if (r10 >= r13) goto L_0x004e
            r12 = r7[r5]
            r13 = r10
        L_0x004e:
            if (r3 != 0) goto L_0x0051
            goto L_0x0086
        L_0x0051:
            r15 = 0
        L_0x0052:
            int[] r9 = r0.av
            r16 = r4
            int r4 = r9.length
            if (r15 >= r4) goto L_0x0088
            r4 = r9[r15]
            if (r4 <= r10) goto L_0x007f
            int r4 = r15 + r6
            r17 = r7
            int r7 = r9.length
            int r7 = r7 - r15
            int r7 = r7 - r6
            java.lang.System.arraycopy(r9, r15, r9, r4, r7)
            int r7 = r3.length
            int r7 = r7 - r15
            int r7 = r7 - r6
            java.lang.System.arraycopy(r3, r15, r3, r4, r7)
            r4 = 0
        L_0x006e:
            if (r4 >= r6) goto L_0x008a
            int r7 = r15 + r4
            int[] r9 = r14.f2227a
            r9 = r9[r4]
            r3[r7] = r9
            int[] r9 = r0.av
            r9[r7] = r10
            int r4 = r4 + 1
            goto L_0x006e
        L_0x007f:
            r17 = r7
            int r15 = r15 + 1
            r4 = r16
            goto L_0x0052
        L_0x0086:
            r16 = r4
        L_0x0088:
            r17 = r7
        L_0x008a:
            int r5 = r5 + 1
            r4 = r16
            r7 = r17
            r6 = 1
            goto L_0x0021
        L_0x0092:
            r4 = -1
            if (r11 != r4) goto L_0x0097
            r9 = r12
            goto L_0x0098
        L_0x0097:
            r9 = r11
        L_0x0098:
            boolean r3 = r18.h()
            if (r3 == 0) goto L_0x00b1
            int r3 = r0.be
            if (r1 > r3) goto L_0x00b1
            float r1 = (float) r2
            int r2 = r0.bf
            int r3 = r0.C
            int r2 = r2 + r3
            float r2 = (float) r2
            float r3 = r0.bd
            float r2 = r2 - r3
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x00b1
            goto L_0x00b2
        L_0x00b1:
            r4 = r9
        L_0x00b2:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.widget.SecurityKeyboardView.a(int, int, int[]):int");
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3, int i4, long j2) {
        if (i2 != -1) {
            n.a[] aVarArr = this.A;
            if (i2 < aVarArr.length) {
                n.a aVar = aVarArr[i2];
                if (aVar.m != null) {
                    this.B.a(aVar.m);
                    this.B.b(-1);
                } else {
                    int i5 = aVar.f2227a[0];
                    int[] iArr = new int[au];
                    Arrays.fill(iArr, -1);
                    a(i3, i4, iArr);
                    if (this.az) {
                        if (this.ax != -1) {
                            this.B.a(-5, c);
                            a(i5, aVar);
                        } else {
                            this.ax = 0;
                        }
                        i5 = aVar.f2227a[this.ax];
                    }
                    a(i5, aVar);
                    this.B.a(i5, iArr);
                    this.B.b(i5);
                }
                this.aw = i2;
                this.ay = j2;
            }
        }
    }

    private CharSequence b(n.a aVar) {
        if (!this.az) {
            return a(aVar.f2228b);
        }
        int i2 = 0;
        this.aA.setLength(0);
        StringBuilder sb = this.aA;
        int[] iArr = aVar.f2227a;
        int i3 = this.ax;
        if (i3 >= 0) {
            i2 = i3;
        }
        sb.append((char) iArr[i2]);
        return a((CharSequence) this.aA);
    }

    private void c(int i2) {
        int i3 = this.f;
        e eVar = this.n;
        this.f = i2;
        n.a[] aVarArr = this.A;
        int i4 = this.f;
        if (i3 != i4) {
            if (i3 != -1 && aVarArr.length > i3) {
                n.a aVar = aVarArr[i3];
                aVar.a(i4 == -1);
                a(i3);
                int i5 = aVar.f2227a[0];
                c(256, i5);
                c(STCommon.ST_MOBILE_TRACKING_SINGLE_THREAD, i5);
            }
            int i6 = this.f;
            if (i6 != -1 && aVarArr.length > i6) {
                n.a aVar2 = aVarArr[i6];
                aVar2.a();
                a(this.f);
                int i7 = aVar2.f2227a[0];
                a(128, i7, aVar2);
                a(32768, i7, aVar2);
            }
        }
        boolean f2 = f(this.f);
        if (i3 != this.f && this.F && f2) {
            this.f2143a.removeMessages(1);
            if (eVar.isShowing() && i2 == -1) {
                Handler handler = this.f2143a;
                handler.sendMessageDelayed(handler.obtainMessage(2), 75);
            }
            if (i2 == -1) {
                return;
            }
            if (!eVar.isShowing() || this.m.getVisibility() != 0) {
                d(i2);
            } else {
                d(i2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void d(int i2) {
        e eVar = this.n;
        n.a[] aVarArr = this.A;
        if (i2 >= 0 && i2 < aVarArr.length) {
            n.a aVar = aVarArr[i2];
            if (aVar.c != null) {
                this.m.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, aVar.d != null ? aVar.d : aVar.c);
                this.m.setText((CharSequence) null);
            } else {
                this.m.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.m.setText(b(aVar));
                if (aVar.f2228b.length() <= 1 || aVar.f2227a.length >= 2) {
                    this.m.setTextSize(0, (float) this.o);
                    this.m.setTypeface(this.aS);
                } else {
                    this.m.setTextSize(0, (float) this.h);
                    this.m.setTypeface(Typeface.DEFAULT_BOLD);
                }
            }
            this.m.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            int i3 = this.aM;
            int i4 = this.q;
            ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = i3;
                layoutParams.height = i4;
            }
            if (!this.E) {
                this.H = ((aVar.i + (aVar.e / 2)) - (this.aM / 2)) + getPaddingLeft();
                this.I = (aVar.j - i4) + this.p;
            } else {
                this.H = 160 - (this.m.getMeasuredWidth() / 2);
                this.I = -this.m.getMeasuredHeight();
            }
            this.f2143a.removeMessages(2);
            getLocationInWindow(this.r);
            int[] iArr = this.r;
            iArr[0] = iArr[0] + this.x;
            iArr[1] = iArr[1] + this.y;
            this.m.getBackground().setState(aVar.r != 0 ? d : EMPTY_STATE_SET);
            int i5 = this.H;
            int[] iArr2 = this.r;
            this.H = i5 + iArr2[0];
            this.I += iArr2[1];
            getLocationOnScreen(iArr2);
            if (this.I + this.r[1] < 0) {
                if (aVar.i + aVar.e <= getWidth() / 2) {
                    this.H += (int) (((double) aVar.e) * 2.5d);
                } else {
                    this.H -= (int) (((double) aVar.e) * 2.5d);
                }
                this.I += i4;
            }
            if (eVar.isShowing()) {
                eVar.update(this.H, this.I, i3, i4);
            } else {
                eVar.setWidth(i3);
                eVar.setHeight(i4);
                eVar.showAtLocation(this.w, 0, this.H, this.I);
            }
            this.m.setVisibility(0);
        }
    }

    private void c(int i2, int i3) {
        String str;
        AccessibilityManager accessibilityManager = this.aG;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
            onInitializeAccessibilityEvent(obtain);
            if (i3 != 10) {
                switch (i3) {
                    case -6:
                        str = getContext().getString(R.string.keyboardview_keycode_alt);
                        break;
                    case -5:
                        str = getContext().getString(R.string.keyboardview_keycode_delete);
                        break;
                    case -4:
                        str = getContext().getString(R.string.keyboardview_keycode_done);
                        break;
                    case -3:
                        str = getContext().getString(R.string.keyboardview_keycode_cancel);
                        break;
                    case -2:
                        str = getContext().getString(R.string.keyboardview_keycode_mode_change);
                        break;
                    case -1:
                        str = getContext().getString(R.string.keyboardview_keycode_shift);
                        break;
                    default:
                        str = String.valueOf((char) i3);
                        break;
                }
            } else {
                str = getContext().getString(R.string.keyboardview_keycode_enter);
            }
            obtain.getText().add(str);
            this.aG.sendAccessibilityEvent(obtain);
        }
    }

    public void a() {
        this.aC.union(0, 0, getWidth(), getHeight());
        this.aB = true;
        invalidate();
    }

    public void a(int i2) {
        n.a[] aVarArr = this.A;
        if (aVarArr != null && i2 >= 0 && i2 < aVarArr.length) {
            n.a aVar = aVarArr[i2];
            this.aj = aVar;
            this.aC.union(aVar.i + getPaddingLeft(), aVar.j + getPaddingTop(), aVar.i + aVar.e + getPaddingLeft(), aVar.j + aVar.f + getPaddingTop());
            j();
            invalidate(aVar.i + getPaddingLeft(), aVar.j + getPaddingTop(), aVar.i + aVar.e + getPaddingLeft(), aVar.j + aVar.f + getPaddingTop());
        }
    }

    /* access modifiers changed from: private */
    public boolean a(MotionEvent motionEvent) {
        int i2;
        if (this.ah != 0 && (i2 = this.V) >= 0) {
            n.a[] aVarArr = this.A;
            if (i2 < aVarArr.length) {
                boolean a2 = a(aVarArr[i2]);
                if (a2) {
                    this.ai = true;
                    c(-1);
                }
                return a2;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean a(n.a aVar) {
        n nVar;
        int i2 = aVar.r;
        if (i2 == 0) {
            return false;
        }
        this.t = this.z.get(aVar);
        View view = this.t;
        if (view == null) {
            this.t = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(this.ah, (ViewGroup) null);
            this.u = (SecurityKeyboardView) this.t.findViewById(16908326);
            View findViewById = this.t.findViewById(16908327);
            if (findViewById != null) {
                findViewById.setOnClickListener(this);
            }
            this.u.setOnKeyboardActionListener(new b() {
                public void a() {
                }

                public void b() {
                }

                public void c() {
                }

                public void d() {
                }

                public void a(int i, int[] iArr) {
                    SecurityKeyboardView.this.B.a(i, iArr);
                    SecurityKeyboardView.this.m();
                }

                public void a(CharSequence charSequence) {
                    SecurityKeyboardView.this.B.a(charSequence);
                    SecurityKeyboardView.this.m();
                }

                public void a(int i) {
                    SecurityKeyboardView.this.B.a(i);
                }

                public void b(int i) {
                    SecurityKeyboardView.this.B.b(i);
                }
            });
            if (aVar.n != null) {
                nVar = new n(getContext(), i2, aVar.n, -1, getPaddingRight() + getPaddingLeft());
            } else {
                nVar = new n(getContext(), i2);
            }
            this.u.setKeyboard(nVar);
            this.u.setPopupParent(this);
            this.t.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
            this.z.put(aVar, this.t);
        } else {
            this.u = (SecurityKeyboardView) view.findViewById(16908326);
        }
        getLocationInWindow(this.r);
        this.ae = aVar.i + getPaddingLeft();
        this.af = aVar.j + getPaddingTop();
        this.ae = (this.ae + aVar.e) - this.t.getMeasuredWidth();
        this.af -= this.t.getMeasuredHeight();
        int paddingRight = this.ae + this.t.getPaddingRight() + this.r[0];
        int paddingBottom = this.af + this.t.getPaddingBottom() + this.r[1];
        this.u.a(paddingRight < 0 ? 0 : paddingRight, paddingBottom);
        this.u.setNewShifted(getNewShifted());
        this.s.setContentView(this.t);
        this.s.setWidth(this.t.getMeasuredWidth());
        this.s.setHeight(this.t.getMeasuredHeight());
        this.s.showAtLocation(this, 0, paddingRight, paddingBottom);
        this.v = true;
        a();
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        AccessibilityManager accessibilityManager = this.aG;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled() && motionEvent.getPointerCount() == 1) {
            int action = motionEvent.getAction();
            if (action == 7) {
                motionEvent.setAction(2);
            } else if (action == 9) {
                motionEvent.setAction(0);
            } else if (action == 10) {
                motionEvent.setAction(1);
            }
            onTouchEvent(motionEvent);
            motionEvent.setAction(action);
        }
        return super.onHoverEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        int action = motionEvent.getAction();
        long eventTime = motionEvent.getEventTime();
        boolean z2 = true;
        if (pointerCount != this.ap) {
            if (pointerCount == 1) {
                MotionEvent obtain = MotionEvent.obtain(eventTime, eventTime, 0, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
                boolean a2 = a(obtain, false);
                obtain.recycle();
                z2 = action == 1 ? a(motionEvent, true) : a2;
            } else {
                MotionEvent obtain2 = MotionEvent.obtain(eventTime, eventTime, 1, this.aq, this.ar, motionEvent.getMetaState());
                z2 = a(obtain2, true);
                obtain2.recycle();
            }
        } else if (pointerCount == 1) {
            z2 = a(motionEvent, false);
            this.aq = motionEvent.getX();
            this.ar = motionEvent.getY();
        }
        this.ap = pointerCount;
        return z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x014e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(android.view.MotionEvent r19, boolean r20) {
        /*
            r18 = this;
            r6 = r18
            r0 = r19
            float r1 = r19.getX()
            int r1 = (int) r1
            int r2 = r18.getPaddingLeft()
            int r1 = r1 - r2
            float r2 = r19.getY()
            int r2 = (int) r2
            int r3 = r18.getPaddingTop()
            int r2 = r2 - r3
            int r3 = r6.C
            int r4 = -r3
            if (r2 < r4) goto L_0x001e
            int r2 = r2 + r3
        L_0x001e:
            int r3 = r19.getAction()
            long r4 = r19.getEventTime()
            r7 = 0
            int r8 = r6.a((int) r1, (int) r2, (int[]) r7)
            boolean r9 = r18.g()
            r10 = 0
            r11 = 1
            r12 = -1
            if (r9 != 0) goto L_0x0065
            com.color.support.widget.n$a[] r9 = r6.A
            int r13 = r9.length
            int r13 = r13 - r11
            if (r8 == r13) goto L_0x0065
            boolean r0 = r6.bc
            if (r0 == 0) goto L_0x0064
            int r0 = r6.bb
            if (r0 == r12) goto L_0x0064
            int r1 = r9.length
            int r1 = r1 - r11
            if (r0 != r1) goto L_0x0064
            r0 = r9[r0]
            boolean r0 = r0.k
            if (r0 == 0) goto L_0x005f
            com.color.support.widget.n$a[] r0 = r6.A
            int r1 = r6.bb
            r0 = r0[r1]
            int r1 = r6.f
            if (r1 != r12) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r11 = r10
        L_0x0058:
            r0.a((boolean) r11)
            r6.f = r12
            r6.bc = r10
        L_0x005f:
            int r0 = r6.bb
            r6.a((int) r0)
        L_0x0064:
            return r10
        L_0x0065:
            r9 = r20
            r6.al = r9
            if (r3 != 0) goto L_0x0070
            com.color.support.widget.SecurityKeyboardView$d r9 = r6.am
            r9.a()
        L_0x0070:
            com.color.support.widget.SecurityKeyboardView$d r9 = r6.am
            r9.a((android.view.MotionEvent) r0)
            boolean r9 = r6.ai
            r13 = 3
            if (r9 == 0) goto L_0x007f
            if (r3 == 0) goto L_0x007f
            if (r3 == r13) goto L_0x007f
            return r11
        L_0x007f:
            android.view.GestureDetector r9 = r6.ad
            boolean r9 = r9.onTouchEvent(r0)
            r14 = 4
            if (r9 == 0) goto L_0x0096
            r6.c((int) r12)
            android.os.Handler r0 = r6.f2143a
            r0.removeMessages(r13)
            android.os.Handler r0 = r6.f2143a
            r0.removeMessages(r14)
            return r11
        L_0x0096:
            boolean r9 = r6.v
            if (r9 == 0) goto L_0x009d
            if (r3 == r13) goto L_0x009d
            return r11
        L_0x009d:
            float r9 = r19.getX()
            int r9 = (int) r9
            float r15 = r19.getY()
            int r15 = (int) r15
            int r7 = r6.d(r9, r15)
            r16 = r15
            r14 = 0
            if (r3 == 0) goto L_0x0268
            if (r3 == r11) goto L_0x01b4
            r10 = 2
            if (r3 == r10) goto L_0x00e2
            if (r3 == r13) goto L_0x00ba
            goto L_0x035c
        L_0x00ba:
            r18.l()
            r18.m()
            r6.ai = r11
            r6.c((int) r12)
            int r0 = r6.V
            r6.a((int) r0)
            boolean r0 = r18.h()
            if (r0 == 0) goto L_0x035c
            r7 = r16
            int r0 = r6.d(r9, r7)
            if (r12 == r0) goto L_0x035c
            java.lang.String[] r3 = r6.bg
            int r3 = r3.length
            if (r0 >= r3) goto L_0x035c
            r6.setItemRestore(r0)
            goto L_0x035c
        L_0x00e2:
            if (r8 == r12) goto L_0x011e
            int r3 = r6.V
            if (r3 != r12) goto L_0x00f1
            r6.V = r8
            long r9 = r6.Q
            long r9 = r4 - r9
            r6.ab = r9
            goto L_0x011e
        L_0x00f1:
            if (r8 != r3) goto L_0x00ff
            long r9 = r6.ab
            long r13 = r6.R
            long r13 = r4 - r13
            long r9 = r9 + r13
            r6.ab = r9
            r17 = r11
            goto L_0x0120
        L_0x00ff:
            int r3 = r6.ag
            if (r3 != r12) goto L_0x011e
            r18.n()
            int r3 = r6.V
            r6.S = r3
            int r3 = r6.J
            r6.T = r3
            int r3 = r6.K
            r6.U = r3
            long r9 = r6.ab
            long r9 = r9 + r4
            long r11 = r6.R
            long r9 = r9 - r11
            r6.aa = r9
            r6.V = r8
            r6.ab = r14
        L_0x011e:
            r17 = 0
        L_0x0120:
            if (r17 != 0) goto L_0x013a
            android.os.Handler r3 = r6.f2143a
            r9 = 4
            r3.removeMessages(r9)
            r3 = -1
            if (r8 == r3) goto L_0x013b
            android.os.Handler r8 = r6.f2143a
            android.os.Message r0 = r8.obtainMessage(r9, r0)
            android.os.Handler r8 = r6.f2143a
            int r9 = at
            long r9 = (long) r9
            r8.sendMessageDelayed(r0, r9)
            goto L_0x013b
        L_0x013a:
            r3 = -1
        L_0x013b:
            int r0 = r6.V
            if (r0 == r3) goto L_0x0141
            r6.bb = r0
        L_0x0141:
            int r0 = r6.V
            r6.c((int) r0)
            r6.R = r4
            boolean r0 = r18.h()
            if (r0 == 0) goto L_0x035c
            int r0 = r6.bl
            if (r7 == r0) goto L_0x01a1
            if (r3 == r7) goto L_0x01a1
            java.lang.String[] r0 = r6.bg
            int r0 = r0.length
            if (r7 >= r0) goto L_0x01a1
            r0 = 1
            r6.a((int) r7, (boolean) r0)
            java.util.ArrayList<com.color.support.widget.SecurityKeyboardView$a> r0 = r6.bm
            java.lang.Object r0 = r0.get(r7)
            com.color.support.widget.SecurityKeyboardView$a r0 = (com.color.support.widget.SecurityKeyboardView.a) r0
            android.graphics.drawable.Drawable r0 = r0.d()
            java.util.ArrayList<com.color.support.widget.SecurityKeyboardView$a> r3 = r6.bm
            java.lang.Object r3 = r3.get(r7)
            com.color.support.widget.SecurityKeyboardView$a r3 = (com.color.support.widget.SecurityKeyboardView.a) r3
            java.lang.String r3 = r3.c()
            r6.a((int) r7, (android.graphics.drawable.Drawable) r0)
            r18.invalidate()
            if (r3 == 0) goto L_0x01a1
            android.content.res.ColorStateList r0 = r6.bi
            if (r0 == 0) goto L_0x01a1
            int[] r0 = r6.b((int) r7)
            android.content.res.ColorStateList r3 = r6.bi
            int r4 = r3.getDefaultColor()
            int r0 = r3.getColorForState(r0, r4)
            java.util.ArrayList<com.color.support.widget.SecurityKeyboardView$a> r3 = r6.bm
            java.lang.Object r3 = r3.get(r7)
            com.color.support.widget.SecurityKeyboardView$a r3 = (com.color.support.widget.SecurityKeyboardView.a) r3
            android.text.TextPaint r3 = r3.h
            r3.setColor(r0)
            r18.invalidate()
        L_0x01a1:
            int r0 = r6.bl
            r3 = -1
            if (r3 == r0) goto L_0x01b0
            if (r7 == r0) goto L_0x01b0
            java.lang.String[] r3 = r6.bg
            int r3 = r3.length
            if (r0 >= r3) goto L_0x01b0
            r6.setItemRestore(r0)
        L_0x01b0:
            r6.bl = r7
            goto L_0x035c
        L_0x01b4:
            r7 = r16
            r18.l()
            int r0 = r6.V
            if (r8 != r0) goto L_0x01c7
            long r10 = r6.ab
            long r12 = r6.R
            long r12 = r4 - r12
            long r10 = r10 + r12
            r6.ab = r10
            goto L_0x01da
        L_0x01c7:
            r18.n()
            int r0 = r6.V
            r6.S = r0
            long r10 = r6.ab
            long r10 = r10 + r4
            long r12 = r6.R
            long r10 = r10 - r12
            r6.aa = r10
            r6.V = r8
            r6.ab = r14
        L_0x01da:
            long r10 = r6.ab
            long r12 = r6.aa
            int r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r0 >= 0) goto L_0x01f6
            r12 = 70
            int r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r0 >= 0) goto L_0x01f6
            int r0 = r6.S
            r3 = -1
            if (r0 == r3) goto L_0x01f7
            r6.V = r0
            int r0 = r6.T
            int r1 = r6.U
            r10 = r0
            r11 = r1
            goto L_0x01f9
        L_0x01f6:
            r3 = -1
        L_0x01f7:
            r10 = r1
            r11 = r2
        L_0x01f9:
            r6.c((int) r3)
            int[] r0 = r6.ac
            java.util.Arrays.fill(r0, r3)
            int r0 = r6.ag
            if (r0 != r3) goto L_0x0216
            boolean r0 = r6.v
            if (r0 != 0) goto L_0x0216
            boolean r0 = r6.ai
            if (r0 != 0) goto L_0x0216
            int r1 = r6.V
            r0 = r18
            r2 = r10
            r3 = r11
            r0.a(r1, r2, r3, r4)
        L_0x0216:
            r6.a((int) r8)
            r0 = -1
            r6.ag = r0
            int r0 = r6.V
            com.color.support.widget.n$a[] r1 = r6.A
            int r1 = r1.length
            r2 = 1
            int r1 = r1 - r2
            if (r0 != r1) goto L_0x0228
            r0 = 0
            r6.bc = r0
        L_0x0228:
            boolean r0 = r18.h()
            if (r0 == 0) goto L_0x0264
            int r0 = r6.d(r9, r7)
            r1 = -1
            if (r1 == r0) goto L_0x0264
            java.lang.String[] r1 = r6.bg
            int r1 = r1.length
            if (r0 >= r1) goto L_0x0264
            r6.setItemRestore(r0)
            com.color.support.widget.SecurityKeyboardView$b r1 = r6.B
            java.lang.String[] r2 = r6.bg
            r2 = r2[r0]
            r3 = 0
            char r2 = r2.charAt(r3)
            r4 = 0
            r1.a(r2, r4)
            com.color.support.widget.SecurityKeyboardView$b r1 = r6.B
            java.lang.String[] r2 = r6.bg
            r2 = r2[r0]
            char r2 = r2.charAt(r3)
            r1.b(r2)
            com.color.support.widget.SecurityKeyboardView$c r1 = r6.aT
            if (r1 == 0) goto L_0x0264
            java.lang.String[] r2 = r6.bg
            r0 = r2[r0]
            r1.a(r0, r3)
        L_0x0264:
            r1 = r10
            r2 = r11
            goto L_0x035c
        L_0x0268:
            r3 = r10
            r6.ai = r3
            r6.L = r1
            r6.M = r2
            r6.T = r1
            r6.U = r2
            r6.aa = r14
            r6.ab = r14
            r3 = -1
            r6.S = r3
            r6.V = r8
            r6.W = r8
            long r9 = r19.getEventTime()
            r6.Q = r9
            long r9 = r6.Q
            r6.R = r9
            r6.a((long) r4, (int) r8)
            boolean r4 = r18.h()
            if (r4 == 0) goto L_0x029e
            if (r3 == r7) goto L_0x029e
            java.lang.String[] r4 = r6.bg
            int r4 = r4.length
            if (r7 >= r4) goto L_0x029e
            com.color.support.widget.SecurityKeyboardView$b r4 = r6.B
            r4.a((int) r3)
            goto L_0x02b1
        L_0x029e:
            com.color.support.widget.SecurityKeyboardView$b r4 = r6.B
            if (r8 == r3) goto L_0x02ad
            com.color.support.widget.n$a[] r5 = r6.A
            r5 = r5[r8]
            int[] r5 = r5.f2227a
            r9 = 0
            r10 = r5[r9]
            r9 = r10
            goto L_0x02ae
        L_0x02ad:
            r9 = 0
        L_0x02ae:
            r4.a((int) r9)
        L_0x02b1:
            int r4 = r6.V
            if (r4 == r3) goto L_0x02b7
            r6.bb = r4
        L_0x02b7:
            int r3 = r6.V
            com.color.support.widget.n$a[] r4 = r6.A
            int r4 = r4.length
            r5 = 1
            int r4 = r4 - r5
            if (r3 != r4) goto L_0x02c2
            r6.bc = r5
        L_0x02c2:
            int r3 = r6.V
            if (r3 < 0) goto L_0x02ea
            com.color.support.widget.n$a[] r4 = r6.A
            r3 = r4[r3]
            boolean r3 = r3.s
            if (r3 == 0) goto L_0x02ea
            int r3 = r6.V
            r6.ag = r3
            android.os.Handler r3 = r6.f2143a
            android.os.Message r3 = r3.obtainMessage(r13)
            android.os.Handler r4 = r6.f2143a
            r9 = 400(0x190, double:1.976E-321)
            r4.sendMessageDelayed(r3, r9)
            r18.k()
            boolean r3 = r6.ai
            if (r3 == 0) goto L_0x02ea
            r3 = -1
            r6.ag = r3
            goto L_0x035c
        L_0x02ea:
            r3 = -1
            int r4 = r6.V
            if (r4 == r3) goto L_0x02fe
            android.os.Handler r3 = r6.f2143a
            r4 = 4
            android.os.Message r0 = r3.obtainMessage(r4, r0)
            android.os.Handler r3 = r6.f2143a
            int r4 = at
            long r4 = (long) r4
            r3.sendMessageDelayed(r0, r4)
        L_0x02fe:
            r6.c((int) r8)
            boolean r0 = r18.h()
            if (r0 == 0) goto L_0x035c
            r0 = -1
            if (r0 == r7) goto L_0x035c
            java.lang.String[] r0 = r6.bg
            int r0 = r0.length
            if (r7 >= r0) goto L_0x035c
            r6.bl = r7
            r6.e((int) r7)
            r0 = 1
            r6.a((int) r7, (boolean) r0)
            java.util.ArrayList<com.color.support.widget.SecurityKeyboardView$a> r0 = r6.bm
            java.lang.Object r0 = r0.get(r7)
            com.color.support.widget.SecurityKeyboardView$a r0 = (com.color.support.widget.SecurityKeyboardView.a) r0
            android.graphics.drawable.Drawable r0 = r0.d()
            java.util.ArrayList<com.color.support.widget.SecurityKeyboardView$a> r3 = r6.bm
            java.lang.Object r3 = r3.get(r7)
            com.color.support.widget.SecurityKeyboardView$a r3 = (com.color.support.widget.SecurityKeyboardView.a) r3
            java.lang.String r3 = r3.c()
            r6.a((int) r7, (android.graphics.drawable.Drawable) r0)
            r18.invalidate()
            if (r3 == 0) goto L_0x035c
            android.content.res.ColorStateList r0 = r6.bi
            if (r0 == 0) goto L_0x035c
            int[] r0 = r6.b((int) r7)
            android.content.res.ColorStateList r3 = r6.bi
            int r4 = r3.getDefaultColor()
            int r0 = r3.getColorForState(r0, r4)
            java.util.ArrayList<com.color.support.widget.SecurityKeyboardView$a> r3 = r6.bm
            java.lang.Object r3 = r3.get(r7)
            com.color.support.widget.SecurityKeyboardView$a r3 = (com.color.support.widget.SecurityKeyboardView.a) r3
            android.text.TextPaint r3 = r3.h
            r3.setColor(r0)
            r18.invalidate()
        L_0x035c:
            r6.J = r1
            r6.K = r2
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.widget.SecurityKeyboardView.a(android.view.MotionEvent, boolean):boolean");
    }

    private void e(int i2) {
        String str;
        AccessibilityManager accessibilityManager = this.aG;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            if (i2 == 0) {
                str = getContext().getString(R.string.color_keyboardview_keycode_asterisk);
            } else if (i2 == 1) {
                str = getContext().getString(R.string.color_keyboardview_keycode_minus);
            } else if (i2 != 2) {
                str = i2 != 3 ? null : getContext().getString(R.string.color_keyboardview_keycode_dollar);
            } else {
                str = getContext().getString(R.string.color_keyboardview_keycode_atsymbol);
            }
            if (str != null) {
                announceForAccessibility(str);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean k() {
        n.a aVar = this.A[this.ag];
        a(this.V, aVar.i, aVar.j, this.ay);
        return true;
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.B.b();
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.B.a();
    }

    /* access modifiers changed from: protected */
    public void d() {
        this.B.c();
    }

    /* access modifiers changed from: protected */
    public void e() {
        this.B.d();
    }

    public void f() {
        if (this.n.isShowing()) {
            this.n.dismiss();
        }
        this.bb = -1;
        l();
        m();
        this.aD = null;
        this.aF = null;
        this.z.clear();
    }

    private void l() {
        Handler handler = this.f2143a;
        if (handler != null) {
            handler.removeMessages(3);
            this.f2143a.removeMessages(4);
            this.f2143a.removeMessages(1);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    /* access modifiers changed from: private */
    public void m() {
        if (this.s.isShowing()) {
            this.s.dismiss();
            this.v = false;
            a();
        }
    }

    private void n() {
        this.aw = -1;
        this.ax = 0;
        this.ay = -1;
        this.az = false;
    }

    private void a(long j2, int i2) {
        if (i2 != -1) {
            n.a aVar = this.A[i2];
            if (aVar.f2227a.length > 1) {
                this.az = true;
                if (j2 >= this.ay + 800 || i2 != this.aw) {
                    this.ax = -1;
                } else {
                    this.ax = (this.ax + 1) % aVar.f2227a.length;
                }
            } else if (j2 > this.ay + 800 || i2 != this.aw) {
                n();
            }
        }
    }

    private void a(Canvas canvas, int i2) {
        String[] strArr = this.bg;
        float length = (((float) this.bf) - (((float) (strArr.length - 1)) * this.bd)) / ((float) strArr.length);
        for (int i3 = 0; i3 < this.bg.length; i3++) {
            Drawable d2 = this.bm.get(i3).d();
            if (d2 != null) {
                int paddingLeft = getPaddingLeft() + i2;
                float f2 = (float) i3;
                float f3 = length * f2;
                int paddingTop = (int) (((float) getPaddingTop()) + f3 + (this.bd * f2));
                float paddingTop2 = ((float) getPaddingTop()) + f3 + (f2 * this.bd);
                d2.setBounds(paddingLeft, paddingTop, this.be + paddingLeft, (int) (((float) paddingTop) + length));
                d2.draw(canvas);
                this.bm.get(i3).b(paddingTop2 + length);
                this.bm.get(i3).a(paddingTop2);
            }
        }
        for (int i4 = 0; i4 < this.bg.length; i4++) {
            TextPaint a2 = this.bm.get(i4).h;
            Paint.FontMetricsInt fontMetricsInt = a2.getFontMetricsInt();
            String str = this.bg[i4];
            if (str != null) {
                canvas.drawText(this.bg[i4], (float) (getPaddingLeft() + ((this.be - ((int) a2.measureText(str))) / 2) + i2), (float) ((int) ((((((float) (getPaddingTop() + this.bk)) + (((float) i4) * (this.bd + length))) + (length / 2.0f)) - ((float) ((fontMetricsInt.descent - fontMetricsInt.ascent) / 2))) - ((float) fontMetricsInt.ascent))), a2);
            }
        }
    }

    private void a(int i2, n.a aVar) {
        c cVar = this.aT;
        if (cVar != null && i2 != -1 && i2 != -2 && i2 != -6 && i2 != -7) {
            if (i2 == 10) {
                cVar.a("", 2);
            } else if (i2 == 32) {
                cVar.a(" ", 0);
            } else if (i2 == -5) {
                cVar.a("", 1);
            } else {
                String charSequence = aVar.f2228b == null ? null : a(aVar.f2228b).toString();
                if (charSequence != null) {
                    this.aT.a(charSequence, 0);
                }
            }
        }
    }

    private void o() {
        int length = this.bg.length;
        if (length >= 0) {
            for (int i2 = 0; i2 < length; i2++) {
                this.bn.add(this.bo.getConstantState().newDrawable());
                this.bm.add(new a(this.bn.get(i2), this.bg[i2]));
            }
            for (int i3 = 0; i3 < length; i3++) {
                int[][][] iArr = aJ;
                int[][] iArr2 = aK;
                iArr[i3] = new int[iArr2.length][];
                System.arraycopy(iArr2, 0, iArr[i3], 0, iArr2.length);
            }
            this.bp.clear();
            this.f2144b.clear();
            for (int i4 = 0; i4 < length; i4++) {
                this.bp.add(new int[aL]);
                this.f2144b.add(new Integer(0));
                a(i4, this.bm.get(i4).d());
                ColorStateList colorStateList = this.bi;
                if (colorStateList != null) {
                    this.bm.get(i4).h.setColor(colorStateList.getColorForState(b(i4), this.bi.getDefaultColor()));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2, Drawable drawable) {
        this.f2144b.set(i2, Integer.valueOf(this.f2144b.get(i2).intValue() | 1024));
        b(i2, drawable);
    }

    /* access modifiers changed from: protected */
    public void b(int i2, Drawable drawable) {
        int[] b2 = b(i2);
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(b2);
        }
    }

    /* access modifiers changed from: protected */
    public int[] b(int i2) {
        int intValue = this.f2144b.get(i2).intValue();
        if ((intValue & 1024) != 0) {
            this.bp.set(i2, b(i2, 0));
            this.f2144b.set(i2, Integer.valueOf(intValue & -1025));
        }
        return this.bp.get(i2);
    }

    /* access modifiers changed from: protected */
    public int[] b(int i2, int i3) {
        int intValue = this.f2144b.get(i2).intValue();
        char c2 = (this.f2144b.get(i2).intValue() & 16384) != 0 ? (char) 16 : 0;
        if ((intValue & 32) == 0) {
            c2 |= 8;
        }
        if (hasWindowFocus()) {
            c2 |= 1;
        }
        int[] iArr = aJ[i2][c2];
        if (i3 == 0) {
            return iArr;
        }
        if (iArr == null) {
            return new int[i3];
        }
        int[] iArr2 = new int[(iArr.length + i3)];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    private void a(int i2, boolean z2) {
        int intValue = this.f2144b.get(i2).intValue();
        this.f2144b.set(i2, Integer.valueOf(z2 ? intValue | 16384 : intValue & -16385));
    }

    private int d(int i2, int i3) {
        String[] strArr;
        int length;
        if (!h() || (strArr = this.bg) == null || (length = strArr.length) <= 0) {
            return -1;
        }
        for (int i4 = 0; i4 < length; i4++) {
            if (i2 >= getPaddingLeft() && i2 <= this.be + getPaddingLeft()) {
                float f2 = (float) i3;
                if (f2 >= this.bm.get(i4).a() && f2 <= this.bm.get(i4).b()) {
                    return i4;
                }
            }
        }
        return -1;
    }

    private void setItemRestore(int i2) {
        a(i2, false);
        Drawable d2 = this.bm.get(i2).d();
        String c2 = this.bm.get(i2).c();
        a(i2, d2);
        if (c2 != null && this.bi != null) {
            int[] b2 = b(i2);
            ColorStateList colorStateList = this.bi;
            this.bm.get(i2).h.setColor(colorStateList.getColorForState(b2, colorStateList.getDefaultColor()));
            invalidate();
        }
    }

    public boolean g() {
        return this.ba;
    }

    public void setKeyboardViewEnabled(boolean z2) {
        this.ba = z2;
    }

    public void setOnKeyboardCharListener(c cVar) {
        this.aT = cVar;
    }

    public void setKeyboardType(int i2) {
        this.aS = Typeface.DEFAULT;
        this.aU = getResources().getDimensionPixelOffset(R.dimen.color_security_keyboard_lower_letter_text_size);
        this.aW = getResources().getDimensionPixelOffset(R.dimen.color_security_keyboard_space_label_text_size);
        this.aV = getResources().getDimensionPixelOffset(R.dimen.color_security_keyboard_lower_letter_text_size);
        this.aX = getResources().getDimensionPixelOffset(R.dimen.color_security_keyboard_end_label_text_size);
        this.bj = getResources().getDimensionPixelOffset(R.dimen.color_security_numeric_keyboard_special_text_size);
        this.aY = getResources().getDimensionPixelOffset(R.dimen.oppo_password_kbd_symbols_special_symbols_textSize);
        this.aZ = getResources().getDimensionPixelOffset(R.dimen.oppo_password_kbd_skip_symbols_key_labelSize);
        this.bd = getResources().getDimension(R.dimen.oppo_password_numeric_keyboard_line_width);
        this.bg = getResources().getStringArray(R.array.color_security_numeric_keyboard_special_symbol);
        this.bh = getResources().getDimensionPixelOffset(R.dimen.color_security_numeric_keyboard_special_symbol_offset);
        this.be = getResources().getDimensionPixelSize(R.dimen.color_security_password_numeric_delete_dimen_keyWidth);
        this.bf = getResources().getDimensionPixelSize(R.dimen.color_security_password_numeric_special_height);
        this.be = (int) (((float) this.be) * n.a(getContext()));
        this.bf = (int) (((float) this.bf) * n.a(getContext()));
        this.bd *= n.a(getContext());
        this.bh = (int) (((float) this.bh) * n.a(getContext()));
        o();
    }

    public boolean h() {
        return this.e.e() == 3;
    }

    private void a(int i2, int i3, n.a aVar) {
        AccessibilityManager accessibilityManager = this.aG;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
            onInitializeAccessibilityEvent(obtain);
            String str = null;
            String charSequence = aVar.f2228b == null ? null : a(aVar.f2228b).toString();
            if (i3 != -7) {
                if (i3 != -6) {
                    if (i3 == -5) {
                        str = getContext().getString(R.string.keyboardview_keycode_delete);
                    } else if (i3 != -2) {
                        if (i3 != -1) {
                            str = i3 != 10 ? String.valueOf((char) i3) : getContext().getString(R.string.keyboardview_keycode_enter);
                        } else if (getNewShifted() == 2) {
                            str = getContext().getString(R.string.color_keyboard_view_keycode_low_shift);
                        } else if (getNewShifted() == 0) {
                            str = getContext().getString(R.string.color_keyboardview_keycode_initialcapitalization);
                        } else if (getNewShifted() == 1) {
                            str = getContext().getString(R.string.color_keyboardview_keycode_capslock);
                        }
                    } else if (charSequence != null && charSequence.equals("ABC")) {
                        str = getContext().getString(R.string.color_keyboardview_keycode_letters);
                    } else if (charSequence != null && charSequence.equals("?#+")) {
                        str = getContext().getString(R.string.color_keyboardview_keycode_symbol);
                    }
                } else if (charSequence != null && charSequence.equals("ABC")) {
                    str = getContext().getString(R.string.color_keyboardview_keycode_letters);
                } else if (charSequence != null && charSequence.equals("123")) {
                    str = getContext().getString(R.string.color_keyboardview_keycode_number);
                }
            } else if (charSequence != null && charSequence.equals("?#+")) {
                str = getContext().getString(R.string.color_keyboardview_keycode_symbol);
            } else if (charSequence != null && charSequence.equals("$¥€")) {
                str = getContext().getString(R.string.color_keyboardview_keycode_moresymbols);
            }
            if (i3 == -5 || i3 == -2 || i3 == -1 || i3 == 10 || i3 == -6 || i3 == -7) {
                announceForAccessibility(str);
            } else if (aVar.o != null) {
                announceForAccessibility(aVar.o.toString());
            } else if (aVar.f2228b != null) {
                announceForAccessibility(aVar.f2228b.toString());
            } else {
                obtain.getText().add(String.valueOf((char) i3));
                this.aG.sendAccessibilityEvent(obtain);
            }
        }
    }

    private boolean f(int i2) {
        if (this.f2143a == null) {
            Log.d("SecurityKeyboardView", "handler is null");
            return false;
        } else if (i2 == -1) {
            Log.d("SecurityKeyboardView", "handler isn't null and keyIndex is -1");
            Handler handler = this.f2143a;
            handler.sendMessageDelayed(handler.obtainMessage(2), 75);
            return false;
        } else {
            int i3 = this.A[i2].f2227a[0];
            if (this.A[i2].f2228b != null && i3 != -1 && i3 != -5 && i3 != -2 && i3 != 10 && i3 != 32 && i3 != -6 && i3 != -7) {
                return true;
            }
            Handler handler2 = this.f2143a;
            handler2.sendMessageDelayed(handler2.obtainMessage(2), 75);
            return false;
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        final float[] f2151a;

        /* renamed from: b  reason: collision with root package name */
        final float[] f2152b;
        final long[] c;
        float d;
        float e;

        private d() {
            this.f2151a = new float[4];
            this.f2152b = new float[4];
            this.c = new long[4];
        }

        public void a() {
            this.c[0] = 0;
        }

        public void a(MotionEvent motionEvent) {
            long eventTime = motionEvent.getEventTime();
            int historySize = motionEvent.getHistorySize();
            for (int i = 0; i < historySize; i++) {
                a(motionEvent.getHistoricalX(i), motionEvent.getHistoricalY(i), motionEvent.getHistoricalEventTime(i));
            }
            a(motionEvent.getX(), motionEvent.getY(), eventTime);
        }

        private void a(float f, float f2, long j) {
            long[] jArr = this.c;
            int i = -1;
            int i2 = 0;
            while (i2 < 4 && jArr[i2] != 0) {
                if (jArr[i2] < j - 200) {
                    i = i2;
                }
                i2++;
            }
            if (i2 == 4 && i < 0) {
                i = 0;
            }
            if (i == i2) {
                i--;
            }
            float[] fArr = this.f2151a;
            float[] fArr2 = this.f2152b;
            if (i >= 0) {
                int i3 = i + 1;
                int i4 = (4 - i) - 1;
                System.arraycopy(fArr, i3, fArr, 0, i4);
                System.arraycopy(fArr2, i3, fArr2, 0, i4);
                System.arraycopy(jArr, i3, jArr, 0, i4);
                i2 -= i3;
            }
            fArr[i2] = f;
            fArr2[i2] = f2;
            jArr[i2] = j;
            int i5 = i2 + 1;
            if (i5 < 4) {
                jArr[i5] = 0;
            }
        }

        public void a(int i) {
            a(i, Float.MAX_VALUE);
        }

        public void a(int i, float f) {
            float f2;
            float f3;
            float[] fArr;
            float f4 = f;
            float[] fArr2 = this.f2151a;
            float[] fArr3 = this.f2152b;
            long[] jArr = this.c;
            int i2 = 0;
            float f5 = fArr2[0];
            float f6 = fArr3[0];
            long j = jArr[0];
            while (i2 < 4 && jArr[i2] != 0) {
                i2++;
            }
            int i3 = 1;
            float f7 = 0.0f;
            float f8 = 0.0f;
            while (i3 < i2) {
                int i4 = (int) (jArr[i3] - j);
                if (i4 == 0) {
                    int i5 = i;
                    fArr = fArr2;
                } else {
                    float f9 = (float) i4;
                    fArr = fArr2;
                    float f10 = (float) i;
                    float f11 = ((fArr2[i3] - f5) / f9) * f10;
                    if (f7 != 0.0f) {
                        f11 = (f7 + f11) * 0.5f;
                    }
                    float f12 = ((fArr3[i3] - f6) / f9) * f10;
                    f8 = f8 == 0.0f ? f12 : (f8 + f12) * 0.5f;
                    f7 = f11;
                }
                i3++;
                fArr2 = fArr;
            }
            if (f7 < 0.0f) {
                f2 = Math.max(f7, -f4);
            } else {
                f2 = Math.min(f7, f4);
            }
            this.e = f2;
            if (f8 < 0.0f) {
                f3 = Math.max(f8, -f4);
            } else {
                f3 = Math.min(f8, f4);
            }
            this.d = f3;
        }

        public float b() {
            return this.e;
        }

        public float c() {
            return this.d;
        }
    }

    private class a {

        /* renamed from: a  reason: collision with root package name */
        public String f2149a = null;

        /* renamed from: b  reason: collision with root package name */
        public Drawable f2150b = null;
        private int d = 0;
        private int e = 0;
        private float f = 0.0f;
        private float g = 0.0f;
        /* access modifiers changed from: private */
        public TextPaint h = new TextPaint(1);

        public a(Drawable drawable, String str) {
            this.h.setAntiAlias(true);
            this.h.setTextSize((float) SecurityKeyboardView.this.bj);
            this.h.setTypeface(SecurityKeyboardView.this.aS);
            this.f2149a = str;
            this.f2150b = drawable;
        }

        public float a() {
            return this.f;
        }

        public void a(float f2) {
            this.f = f2;
        }

        public float b() {
            return this.g;
        }

        public void b(float f2) {
            this.g = f2;
        }

        public String c() {
            String str = this.f2149a;
            if (str != null) {
                return str;
            }
            return null;
        }

        public Drawable d() {
            Drawable drawable = this.f2150b;
            if (drawable != null) {
                return drawable;
            }
            return null;
        }
    }
}
