package com.oppo.camera.ui.beauty3d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import color.support.v7.app.b;
import com.oppo.camera.R;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.ui.CameraScreenHintView;
import com.oppo.camera.ui.OppoNumSeekBar;
import com.oppo.camera.ui.menu.OppoTextView;
import com.oppo.camera.util.Util;
import com.sensetime.stmobile.sticker_module_types.STStickerMakeupParamType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: Beauty3DEditUI */
public class d implements View.OnClickListener, OppoNumSeekBar.a {
    private a A = null;
    private a B = null;
    private a C = null;
    private a D = null;
    private a E = null;
    private LinearLayout F = null;
    private LinearLayout G = null;
    /* access modifiers changed from: private */
    public i H = null;
    private View I = null;
    private RelativeLayout J = null;
    /* access modifiers changed from: private */
    public GestureDetector K = null;
    private e L = null;
    private b M = null;
    private List<c> N = null;
    private boolean O = false;
    private View P = null;
    private View Q = null;
    private View R = null;
    private View S = null;
    private View T = null;
    private View U = null;
    private View V = null;
    private OppoTextView W = null;
    private OppoTextView X = null;
    private OppoTextView Y = null;
    private OppoTextView Z = null;

    /* renamed from: a  reason: collision with root package name */
    private Point f3835a = null;
    private View.OnTouchListener aA = new View.OnTouchListener() {
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (r4 != 3) goto L_0x005b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
            /*
                r3 = this;
                int r4 = r4.getId()
                r0 = 1
                r1 = 2131296566(0x7f090136, float:1.8211052E38)
                if (r4 == r1) goto L_0x000b
                return r0
            L_0x000b:
                int r4 = r5.getActionMasked()
                if (r4 == 0) goto L_0x004a
                if (r4 == r0) goto L_0x001a
                r1 = 2
                if (r4 == r1) goto L_0x004a
                r1 = 3
                if (r4 == r1) goto L_0x001a
                goto L_0x005b
            L_0x001a:
                com.oppo.camera.ui.beauty3d.d r4 = com.oppo.camera.ui.beauty3d.d.this
                boolean unused = r4.ar = r0
                com.oppo.camera.ui.beauty3d.d r4 = com.oppo.camera.ui.beauty3d.d.this
                com.oppo.camera.ui.beauty3d.i r4 = r4.H
                if (r4 == 0) goto L_0x0038
                com.oppo.camera.ui.beauty3d.d r4 = com.oppo.camera.ui.beauty3d.d.this
                com.oppo.camera.ui.beauty3d.i r4 = r4.H
                com.oppo.camera.ui.beauty3d.d r1 = com.oppo.camera.ui.beauty3d.d.this
                int[] r1 = r1.au
                java.lang.String r2 = "com.oplus.beauty3d.custom.mode"
                r4.a(r2, r1)
            L_0x0038:
                com.oppo.camera.ui.beauty3d.d r4 = com.oppo.camera.ui.beauty3d.d.this
                android.view.GestureDetector r4 = r4.K
                if (r4 == 0) goto L_0x005b
                com.oppo.camera.ui.beauty3d.d r4 = com.oppo.camera.ui.beauty3d.d.this
                android.view.GestureDetector r4 = r4.K
                r4.onTouchEvent(r5)
                goto L_0x005b
            L_0x004a:
                com.oppo.camera.ui.beauty3d.d r4 = com.oppo.camera.ui.beauty3d.d.this
                android.view.GestureDetector r4 = r4.K
                if (r4 == 0) goto L_0x005b
                com.oppo.camera.ui.beauty3d.d r4 = com.oppo.camera.ui.beauty3d.d.this
                android.view.GestureDetector r4 = r4.K
                r4.onTouchEvent(r5)
            L_0x005b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.beauty3d.d.AnonymousClass1.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    };
    private C0099d aB = new C0099d() {
        public void a(View view, int i) {
            com.oppo.camera.e.a("Beauty3DEditUI", "onItemClick, position: " + i);
            d.this.H();
            if (i == 0) {
                d.this.b(0);
            } else if (i == 1) {
                d.this.b(1);
            } else if (i == 2) {
                d.this.b(2);
            } else if (i == 3) {
                d.this.b(3);
            }
        }
    };
    private OppoTextView aa = null;
    private ImageView ab = null;
    private ImageView ac = null;
    private String ad = null;
    private String ae = null;
    private String af = null;
    private String ag = null;
    private String ah = null;
    private boolean ai = false;
    private c aj = new c();
    private CameraScreenHintView ak = null;
    /* access modifiers changed from: private */
    public int al = 0;
    private int am = 0;
    /* access modifiers changed from: private */
    public float an = 0.0f;
    /* access modifiers changed from: private */
    public boolean ao = false;
    private int ap = 0;
    /* access modifiers changed from: private */
    public boolean aq = false;
    /* access modifiers changed from: private */
    public boolean ar = true;
    private int[] as = {2};
    /* access modifiers changed from: private */
    public int[] at = {1};
    /* access modifiers changed from: private */
    public int[] au = {0};
    private int[] av = new int[8];
    private SparseArray<int[]> aw = new SparseArray<>();
    private SparseArray<int[]> ax = null;
    private int ay = 0;
    private int az = 0;

    /* renamed from: b  reason: collision with root package name */
    private Point f3836b = null;
    private Point c = null;
    private Point d = null;
    private Point e = null;
    /* access modifiers changed from: private */
    public Activity f = null;
    private ViewGroup g = null;
    private int h = 0;
    /* access modifiers changed from: private */
    public int i = 0;
    private boolean j = false;
    private TextView k = null;
    private TextView l = null;
    private TextView m = null;
    private TextView n = null;
    private TextView o = null;
    private TextView p = null;
    private TextView q = null;
    private ImageView r = null;
    private ImageView s = null;
    private RecyclerView t = null;
    private RelativeLayout u = null;
    private RelativeLayout v = null;
    private OppoNumSeekBar w = null;
    private OppoNumSeekBar x = null;
    private a y = null;
    private a z = null;

    public boolean a() {
        return true;
    }

    public d(Activity activity, i iVar, RelativeLayout relativeLayout) {
        this.f = activity;
        this.H = iVar;
        this.J = relativeLayout;
        this.K = new GestureDetector(this.f, new a());
        this.f3835a = new Point(400, 400);
        this.e = new Point(400, 1000);
        this.f3836b = new Point(400, STStickerMakeupParamType.ST_STICKER_PARAM_MAKEUP_FLOAT_SCALE);
        this.d = new Point(400, 1000);
        this.c = new Point(400, 400);
        com.oppo.camera.d.c.a().a(this.f);
    }

    private void s() {
        if (this.I == null) {
            this.I = this.f.getLayoutInflater().inflate(R.layout.beauty3d_bottom, (ViewGroup) null);
        }
        if (this.g == null) {
            this.g = (ViewGroup) this.f.findViewById(R.id.camera);
        }
        this.I.setBackgroundColor(-16777216);
        this.I.setVisibility(8);
        this.I.setEnabled(false);
        this.I.setOnTouchListener(this.aA);
        int dimension = (int) this.f.getResources().getDimension(R.dimen.beauty3d_edit_bottom_height);
        if (!this.j) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, dimension);
            layoutParams.addRule(12);
            this.g.addView(this.I, layoutParams);
            this.j = true;
            w();
        }
    }

    private void t() {
        if (this.P == null) {
            ViewGroup viewGroup = (ViewGroup) this.f.findViewById(R.id.camera);
            this.P = this.f.getLayoutInflater().inflate(R.layout.beauty3d_edit_setting, (ViewGroup) null);
            if (!this.ai) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(10);
                layoutParams.height = (int) this.f.getResources().getDimension(R.dimen.beauty3d_scan_setting_height);
                layoutParams.topMargin = 0;
                this.P.setLayoutParams(layoutParams);
                viewGroup.addView(this.P, layoutParams);
                this.ai = true;
            }
        }
    }

    public void b() {
        View view = this.I;
        if (view != null) {
            view.setVisibility(8);
            this.I.setEnabled(false);
        }
    }

    public void c() {
        View view = this.I;
        if (view != null) {
            view.setVisibility(0);
            this.I.setEnabled(true);
            this.I.setOnTouchListener(this.aA);
            x();
        }
    }

    public void d() {
        t();
        this.P.setOnTouchListener(this.aA);
        this.v = (RelativeLayout) this.P.findViewById(R.id.beauty3d_edit_setting);
        this.u = (RelativeLayout) this.P.findViewById(R.id.beauty3d_custom_setting);
        this.k = (TextView) this.P.findViewById(R.id.beauty3d_title);
        this.l = (TextView) this.P.findViewById(R.id.custom_title);
        this.k.setText(this.f.getString(R.string.beauty3d_face_edit_title));
        this.q = (TextView) this.P.findViewById(R.id.custom_rescan);
        this.q.setOnClickListener(this);
        this.u.setVisibility(4);
        this.v.setVisibility(4);
    }

    private void u() {
        RelativeLayout relativeLayout = this.u;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.v;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
        TextView textView = this.k;
        if (textView != null) {
            textView.setText(this.f.getString(R.string.beauty3d_face_edit_title));
            this.k.setVisibility(0);
        }
    }

    private void v() {
        RelativeLayout relativeLayout = this.u;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
            this.u.setEnabled(true);
        }
        TextView textView = this.l;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.k;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        TextView textView3 = this.q;
        if (textView3 != null) {
            textView3.setVisibility(0);
            this.q.setClickable(true);
            this.q.setOnClickListener(this);
        }
    }

    public void e() {
        View view = this.P;
        if (view != null) {
            view.setVisibility(4);
            this.P.setEnabled(false);
        }
    }

    public void f() {
        View view = this.P;
        if (view != null) {
            view.setOnTouchListener(this.aA);
            this.P.setVisibility(0);
            this.P.setEnabled(true);
        }
    }

    private void w() {
        this.I.setClickable(true);
        this.m = (TextView) this.I.findViewById(R.id.face3d_cancel);
        this.n = (TextView) this.I.findViewById(R.id.face3d_customize_cancel);
        this.o = (TextView) this.I.findViewById(R.id.face3d_save);
        this.p = (TextView) this.I.findViewById(R.id.face3d_customize);
        this.r = (ImageView) this.I.findViewById(R.id.redo_left);
        this.s = (ImageView) this.I.findViewById(R.id.redo_right);
        this.G = (LinearLayout) this.I.findViewById(R.id.down_seekbar_container);
        this.F = (LinearLayout) this.I.findViewById(R.id.up_seekbar_container);
        this.w = (OppoNumSeekBar) this.I.findViewById(R.id.up_seekbar);
        this.x = (OppoNumSeekBar) this.I.findViewById(R.id.down_seekbar);
        this.ab = (ImageView) this.I.findViewById(R.id.up_seekbar_view);
        this.ac = (ImageView) this.I.findViewById(R.id.down_seekbar_view);
        this.x.setEnabled(true);
        this.w.setEnabled(true);
        this.G.setVisibility(8);
        this.F.setVisibility(8);
        this.r.setVisibility(4);
        this.s.setVisibility(4);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.x.setOnProgressChangedListener(this);
        this.w.setOnProgressChangedListener(this);
        this.t = (RecyclerView) this.I.findViewById(R.id.beauty3d_recyclerview);
        B();
    }

    public void g() {
        int i2 = this.h;
        if (i2 == 1) {
            this.ab.setImageDrawable(this.D.f);
            this.ac.setImageDrawable(this.C.f);
        } else if (i2 == 2) {
            this.ac.setImageDrawable(this.B.f);
        } else if (i2 == 3) {
            this.ac.setImageDrawable(this.z.f);
            this.ab.setImageDrawable(this.y.f);
        } else if (i2 == 4) {
            this.ac.setImageDrawable(this.E.f);
        } else if (i2 == 5) {
            this.ac.setImageDrawable(this.A.f);
        }
    }

    public void a(int[] iArr) {
        if (this.ax == null && iArr != null && iArr.length >= 28) {
            this.ax = new SparseArray<>();
            for (int i2 = 0; i2 < 4; i2++) {
                int i3 = i2 * 7;
                this.ax.put(i2, Arrays.copyOfRange(iArr, i3, i3 + 7));
            }
        }
    }

    public int a(int i2) {
        int[] iArr;
        SparseArray<int[]> sparseArray = this.ax;
        if (sparseArray == null || (iArr = sparseArray.get(this.am)) == null || iArr.length <= i2) {
            return 0;
        }
        return iArr[i2];
    }

    private void d(int[] iArr) {
        if (iArr != null && iArr.length == 7) {
            a aVar = this.C;
            if (aVar != null) {
                aVar.a(a(0));
                this.C.f3829a = iArr[0];
            }
            a aVar2 = this.D;
            if (aVar2 != null) {
                aVar2.a(a(1));
                this.D.f3829a = iArr[1];
            }
            a aVar3 = this.B;
            if (aVar3 != null) {
                aVar3.a(a(2));
                this.B.f3829a = iArr[2];
            }
            a aVar4 = this.z;
            if (aVar4 != null) {
                aVar4.a(a(3));
                this.z.f3829a = iArr[3];
            }
            a aVar5 = this.y;
            if (aVar5 != null) {
                aVar5.a(a(4));
                this.y.f3829a = iArr[4];
            }
            a aVar6 = this.E;
            if (aVar6 != null) {
                aVar6.a(a(5));
                this.E.f3829a = iArr[5];
            }
            a aVar7 = this.A;
            if (aVar7 != null) {
                aVar7.a(a(6));
                this.A.f3829a = iArr[6];
            }
        }
    }

    public void b(int i2) {
        this.aq = true;
        this.h = 0;
        this.am = i2;
        int[] iArr = this.aw.get(this.am);
        if (iArr != null) {
            d(iArr);
            if (this.H != null) {
                M();
            }
            d(false);
            e(false);
            c cVar = this.aj;
            if (cVar != null) {
                cVar.f();
            }
        }
    }

    public void h() {
        if (this.M != null) {
            com.oppo.camera.e.a("Beauty3DEditUI", "onUpdateStyleViewPosition, mChoseStyle: " + this.am);
            List a2 = this.M.d;
            for (int i2 = 0; i2 < a2.size(); i2++) {
                if (i2 == this.am) {
                    a2.set(i2, true);
                } else {
                    a2.set(i2, false);
                }
            }
            this.M.notifyDataSetChanged();
        }
    }

    public void a(int i2, int i3) {
        com.oppo.camera.e.a("Beauty3DEditUI", "setSeekBarProgress: progress: " + i3 + ", mTouchLocation: " + this.h);
        int i4 = this.h;
        if (i4 != 1) {
            if (i4 == 2) {
                this.B.b(i3);
            } else if (i4 != 3) {
                if (i4 == 4) {
                    this.E.b(i3);
                } else if (i4 == 5) {
                    this.A.b(i3);
                }
            } else if (this.y.d == i2) {
                this.y.b(i3);
            } else if (this.z.d == i2) {
                this.z.b(i3);
            }
        } else if (this.C.d == i2) {
            this.C.b(i3);
        } else if (this.D.d == i2) {
            this.D.b(i3);
        }
    }

    public void i() {
        c();
        f();
        RelativeLayout relativeLayout = this.J;
        if (relativeLayout != null) {
            relativeLayout.setOnTouchListener(this.aA);
        }
    }

    public void b(int i2, int i3) {
        k();
        this.am = i3;
        if (i2 == 2) {
            J();
        }
    }

    public void j() {
        d();
        s();
        z();
        if (this.y == null) {
            this.y = new a(0, 100, this.f.getDrawable(R.drawable.beauty3d_small_face), R.id.up_seekbar);
        }
        if (this.z == null) {
            this.z = new a(0, 100, this.f.getDrawable(R.drawable.beauty3d_fix_face), R.id.down_seekbar);
        }
        if (this.A == null) {
            this.A = new a(-50, 50, this.f.getDrawable(R.drawable.beauty3d_chin), R.id.down_seekbar);
        }
        if (this.B == null) {
            this.B = new a(0, 100, this.f.getDrawable(R.drawable.beauty3d_big_eye), R.id.down_seekbar);
        }
        if (this.E == null) {
            this.E = new a(0, 100, this.f.getDrawable(R.drawable.beauty3d_cheekbone), R.id.down_seekbar);
        }
        if (this.D == null) {
            this.D = new a(0, 100, this.f.getDrawable(R.drawable.beauty3d_small_nose), R.id.up_seekbar);
        }
        if (this.C == null) {
            this.C = new a(0, 100, this.f.getDrawable(R.drawable.beauty3d_high_nose), R.id.down_seekbar);
        }
    }

    public void k() {
        x();
        u();
        TextView textView = this.m;
        if (textView != null) {
            textView.setVisibility(0);
            this.m.setClickable(true);
        }
        TextView textView2 = this.n;
        if (textView2 != null) {
            textView2.setVisibility(8);
            this.n.setClickable(false);
        }
        TextView textView3 = this.o;
        if (textView3 != null) {
            textView3.setVisibility(8);
            this.o.setClickable(false);
        }
        TextView textView4 = this.p;
        if (textView4 != null) {
            textView4.setVisibility(0);
            this.p.setClickable(true);
        }
        K();
        H();
        ImageView imageView = this.r;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        ImageView imageView2 = this.s;
        if (imageView2 != null) {
            imageView2.setVisibility(4);
        }
        this.i = 1;
    }

    private void x() {
        int I2;
        View view = this.I;
        if (view != null) {
            int i2 = 0;
            view.setVisibility(0);
            this.I.setEnabled(true);
            int dimension = (int) this.f.getResources().getDimension(R.dimen.beauty3d_edit_custom_bottom_height);
            int dimension2 = (int) this.f.getResources().getDimension(R.dimen.beauty3d_redo_margin_bottom);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.I.getLayoutParams();
            if (Util.J() && (I2 = Util.I() - dimension2) > 0) {
                i2 = I2;
            }
            layoutParams.bottomMargin = i2;
            layoutParams.height = dimension;
            com.oppo.camera.e.a("Beauty3DEditUI", "refreshBottomLayout, bottomMargin: " + i2 + ", height: " + dimension);
            this.I.setLayoutParams(layoutParams);
            this.I.requestLayout();
        }
    }

    private void y() {
        View view = this.Q;
        if (view != null && view.getVisibility() != 0) {
            this.Q.setVisibility(0);
        }
    }

    private void z() {
        RelativeLayout relativeLayout;
        com.oppo.camera.e.a("Beauty3DEditUI", "initPreview");
        RelativeLayout relativeLayout2 = this.J;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnTouchListener(this.aA);
        }
        A();
        if (!this.O && (relativeLayout = this.J) != null) {
            relativeLayout.addView(this.Q, -1, -1);
            View findViewById = this.Q.findViewById(R.id.cheekbone_ffd);
            if (findViewById != null) {
                findViewById.measure(0, 0);
                this.ay = findViewById.getMeasuredWidth() / 2;
            }
            b(false);
            a(this.R, this.f3835a, false);
            a(this.S, this.f3836b, false);
            a(this.T, this.d, false);
            a(this.U, this.c, true);
            a(this.V, this.e, true);
            this.O = true;
        }
    }

    private void a(View view, Point point, boolean z2) {
        if (view == null || point == null) {
            com.oppo.camera.e.e("Beauty3DEditUI", "updateFiveSenseViewLayout, view or point null");
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (z2) {
            layoutParams.width = point.x + this.ay;
            layoutParams.topMargin = point.y - (view.getMeasuredHeight() / 2);
            view.setLayoutParams(layoutParams);
            view.requestLayout();
            return;
        }
        layoutParams.width = (1080 - point.x) + this.ay;
        layoutParams.topMargin = point.y - (view.getMeasuredHeight() / 2);
        view.setLayoutParams(layoutParams);
        view.requestLayout();
    }

    private void A() {
        if (this.Q == null) {
            this.Q = this.f.getLayoutInflater().inflate(R.layout.beauty3d_fivesence_hint, (ViewGroup) null);
            this.Q.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return false;
                }
            });
        }
        this.R = this.Q.findViewById(R.id.eye_hint);
        this.S = this.Q.findViewById(R.id.nose_hint);
        this.T = this.Q.findViewById(R.id.chin_hint);
        this.U = this.Q.findViewById(R.id.face_hint);
        this.V = this.Q.findViewById(R.id.cheekbone_hint);
        this.R.measure(0, 0);
        this.S.measure(0, 0);
        this.T.measure(0, 0);
        this.U.measure(0, 0);
        this.V.measure(0, 0);
        this.W = (OppoTextView) this.Q.findViewById(R.id.eye_hint_title);
        this.X = (OppoTextView) this.Q.findViewById(R.id.nose_hint_title);
        this.Y = (OppoTextView) this.Q.findViewById(R.id.chin_hint_title);
        this.Z = (OppoTextView) this.Q.findViewById(R.id.face_hint_title);
        this.aa = (OppoTextView) this.Q.findViewById(R.id.cheekbone_hint_title);
        this.ad = this.f.getString(R.string.beauty3d_eye);
        this.ae = this.f.getString(R.string.beauty3d_nose);
        this.af = this.f.getString(R.string.beauty3d_chin);
        this.ag = this.f.getString(R.string.beauty3d_face_size);
        this.ah = this.f.getString(R.string.beauty3d_cheekbones);
        this.W.setText(this.ad);
        this.X.setText(this.ae);
        this.Y.setText(this.af);
        this.Z.setText(this.ag);
        this.aa.setText(this.ah);
    }

    public void a(String[] strArr) {
        if (strArr != null && strArr.length == 5) {
            OppoTextView oppoTextView = this.aa;
            if (!(oppoTextView == null || strArr[0] == null || strArr[0].equals(oppoTextView.getText()))) {
                this.aa.setText(strArr[0]);
                com.oppo.camera.e.a("Beauty3DEditUI", "setFiveSenseTitles, update CheekBone");
            }
            OppoTextView oppoTextView2 = this.Z;
            if (!(oppoTextView2 == null || strArr[1] == null || strArr[1].equals(oppoTextView2.getText()))) {
                this.Z.setText(strArr[1]);
                com.oppo.camera.e.a("Beauty3DEditUI", "setFiveSenseTitles, update Face");
            }
            OppoTextView oppoTextView3 = this.Y;
            if (!(oppoTextView3 == null || strArr[2] == null || strArr[2].equals(oppoTextView3.getText()))) {
                this.Y.setText(strArr[2]);
                com.oppo.camera.e.a("Beauty3DEditUI", "setFiveSenseTitles, update Chin");
            }
            OppoTextView oppoTextView4 = this.X;
            if (!(oppoTextView4 == null || strArr[3] == null || strArr[3].equals(oppoTextView4.getText()))) {
                this.X.setText(strArr[3]);
                com.oppo.camera.e.a("Beauty3DEditUI", "setFiveSenseTitles, update Nose");
            }
            OppoTextView oppoTextView5 = this.W;
            if (oppoTextView5 != null && strArr[4] != null && !strArr[4].equals(oppoTextView5.getText())) {
                this.W.setText(strArr[4]);
                com.oppo.camera.e.a("Beauty3DEditUI", "setFiveSenseTitles, update Eye");
            }
        }
    }

    public void b(int[] iArr) {
        boolean z2;
        if (iArr != null && iArr.length >= 10 && this.ar) {
            int i2 = 1440 - iArr[0];
            int i3 = 1080 - iArr[1];
            if (this.e.y == i2 && this.e.x == i3) {
                z2 = false;
            } else {
                Point point = this.e;
                point.y = i2;
                point.x = i3;
                z2 = true;
            }
            int i4 = 1440 - iArr[2];
            int i5 = 1080 - iArr[3];
            if (!(this.c.y == i4 && this.c.x == i5)) {
                Point point2 = this.c;
                point2.y = i4;
                point2.x = i5;
                z2 = true;
            }
            int i6 = 1440 - iArr[4];
            int i7 = 1080 - iArr[5];
            if (!(this.d.y == i6 && this.d.x == i7)) {
                Point point3 = this.d;
                point3.y = i6;
                point3.x = i7;
                z2 = true;
            }
            int i8 = 1440 - iArr[6];
            int i9 = 1080 - iArr[7];
            if (!(this.f3836b.y == i8 && this.f3836b.x == i9)) {
                Point point4 = this.f3836b;
                point4.y = i8;
                point4.x = i9;
                z2 = true;
            }
            int i10 = 1440 - iArr[8];
            int i11 = 1080 - iArr[9];
            if (!(this.f3835a.y == i10 && this.f3835a.x == i11)) {
                Point point5 = this.f3835a;
                point5.y = i10;
                point5.x = i11;
                z2 = true;
            }
            if (z2) {
                com.oppo.camera.e.a("Beauty3DEditUI", "setFiveSenseViewParams, result: " + iArr[0] + ", " + iArr[1] + ", " + iArr[2] + ", " + iArr[3] + ", " + iArr[4] + ", " + iArr[5] + ", " + iArr[6] + ", " + iArr[7] + ", " + iArr[8] + ", " + iArr[9]);
                b(false);
                a(this.R, this.f3835a, false);
                a(this.S, this.f3836b, false);
                a(this.T, this.d, false);
                a(this.U, this.c, true);
                a(this.V, this.e, true);
            }
            y();
        }
    }

    private void B() {
        this.L = new e(this.f);
        this.L.setOrientation(0);
        this.t.setLayoutManager(this.L);
        if (this.N == null) {
            this.N = new ArrayList(4);
            this.N.add(new c(this.f.getDrawable(R.drawable.beauty3d_style_natural), this.f.getResources().getString(R.string.beauty3d_face_style_natural)));
            this.N.add(new c(this.f.getDrawable(R.drawable.beauty3d_style_goose_egg), this.f.getResources().getString(R.string.beauty3d_face_style_delicate)));
            this.N.add(new c(this.f.getDrawable(R.drawable.beauty3d_style_lolita), this.f.getResources().getString(R.string.beauty3d_face_style_lolita)));
            this.N.add(new c(this.f.getDrawable(R.drawable.beauty3d_style_mode), this.f.getResources().getString(R.string.beauty3d_face_style_mode)));
        }
        this.M = new b(this.N, this.aB);
        this.t.setAdapter(this.M);
        this.t.addItemDecoration(new f((int) this.f.getResources().getDimension(R.dimen.beauty3d_edit_recyclerview_item_space)));
        K();
    }

    public void a(boolean z2) {
        if (z2) {
            D();
            this.i = 0;
            this.h = 0;
            this.al = 0;
            this.aq = false;
            this.ao = false;
            c cVar = this.aj;
            if (cVar != null) {
                cVar.f();
            }
        } else {
            e();
            b();
            b(false);
        }
        r();
        this.J.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
    }

    public void b(boolean z2) {
        View view = this.Q;
        if (view != null && view.getVisibility() == 0) {
            if (z2) {
                Util.b(this.Q);
            } else {
                this.Q.setVisibility(8);
            }
        }
    }

    private void C() {
        View view = this.Q;
        if (!(view == null || !this.O || this.J == null)) {
            Animation animation = view.getAnimation();
            if (animation != null) {
                animation.cancel();
            }
            this.Q.setVisibility(8);
            this.J.removeView(this.Q);
            this.Q.setAlpha(1.0f);
        }
        this.O = false;
    }

    public void l() {
        D();
        this.i = 0;
        this.ao = false;
        this.aq = false;
        this.f = null;
        this.g = null;
        this.I = null;
        this.P = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.J = null;
        this.w = null;
        this.x = null;
        this.F = null;
        this.G = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.aa = null;
    }

    private void D() {
        View view;
        View view2;
        C();
        ViewGroup viewGroup = this.g;
        if (!(viewGroup == null || (view2 = this.I) == null || !this.j)) {
            viewGroup.removeView(view2);
            this.j = false;
            this.I = null;
        }
        ViewGroup viewGroup2 = this.g;
        if (viewGroup2 != null && (view = this.P) != null && this.ai) {
            viewGroup2.removeView(view);
            this.ai = false;
            this.P = null;
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.custom_rescan) {
            switch (id) {
                case R.id.face3d_cancel:
                    a(true);
                    i iVar = this.H;
                    if (iVar != null) {
                        iVar.a();
                        return;
                    }
                    return;
                case R.id.face3d_customize:
                    i iVar2 = this.H;
                    if (iVar2 != null) {
                        iVar2.a("com.oplus.beauty3d.mode", new int[]{3});
                    }
                    J();
                    return;
                case R.id.face3d_customize_cancel:
                    I();
                    return;
                case R.id.face3d_save:
                    a(true);
                    i iVar3 = this.H;
                    if (iVar3 != null) {
                        iVar3.a("com.oplus.beauty3d.custom.mode", this.as);
                        this.H.b();
                    }
                    E();
                    return;
                default:
                    switch (id) {
                        case R.id.redo_left:
                            m();
                            return;
                        case R.id.redo_right:
                            n();
                            return;
                        default:
                            return;
                    }
            }
        } else {
            a(true);
            i iVar4 = this.H;
            if (iVar4 != null) {
                iVar4.a();
            }
        }
    }

    private void E() {
        boolean z2;
        int[] iArr = this.av;
        if (iArr != null && iArr.length >= 8) {
            int i2 = this.az;
            int i3 = this.am;
            if (i2 != i3) {
                z2 = true;
            } else {
                int[] iArr2 = this.aw.get(i3);
                if (iArr2 != null) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= iArr2.length) {
                            break;
                        }
                        int i5 = iArr2[i4];
                        i4++;
                        if (i5 != this.av[i4]) {
                            break;
                        }
                    }
                }
                z2 = false;
            }
            if (z2) {
                StringBuilder sb = new StringBuilder();
                int i6 = this.av[0];
                String str = null;
                if (i6 == 0) {
                    str = CameraStatisticsUtil.BEAUTY3D_NATURAL;
                } else if (i6 == 1) {
                    str = CameraStatisticsUtil.BEAUTY3D_GOOSE;
                } else if (i6 == 2) {
                    str = CameraStatisticsUtil.BEAUTY3D_LOLITA;
                } else if (i6 == 3) {
                    str = CameraStatisticsUtil.BEAUTY3D_MODE;
                }
                if (str != null) {
                    sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_CHOSE_STYLE, str));
                }
                sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_HIGH_NOSE, String.valueOf(this.av[1])));
                sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_SMALL_NOSE, String.valueOf(this.av[2])));
                sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_EYE, String.valueOf(this.av[3])));
                sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_FIX_FACE, String.valueOf(this.av[4])));
                sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_SMALL_FACE, String.valueOf(this.av[5])));
                sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_CHEEKBONE, String.valueOf(this.av[6])));
                sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_CHIN, String.valueOf(this.av[7])));
                if (sb.length() > 0) {
                    CameraStatisticsUtil.onCommon(this.f, CameraStatisticsUtil.EVENT_MENU_CLICK, sb.toString(), false);
                }
            }
        }
    }

    public void m() {
        if (this.aj.c() < 2) {
            d(false);
            return;
        }
        this.ao = true;
        c cVar = this.aj;
        cVar.b(cVar.a());
        b a2 = this.aj.a();
        this.aj.b(a2);
        com.oppo.camera.e.a("Beauty3DEditUI", "Beauty3DEditAction, mValueOwner: " + a2.f3832b + ", mValueLocation: " + a2.f3831a + ", mSbValue: " + a2.c);
        this.h = a2.f3831a;
        a(a2.f3832b, a2.c);
        M();
        G();
        if (this.aj.c() < 2) {
            d(false);
        } else {
            d(true);
        }
        if (this.aj.d() < 2) {
            e(false);
        } else {
            e(true);
        }
    }

    private void d(boolean z2) {
        ImageView imageView = this.r;
        if (imageView == null) {
            return;
        }
        if (z2) {
            imageView.setImageDrawable(this.f.getResources().getDrawable(R.drawable.beauty3d_left_arrow));
            this.r.setClickable(true);
            return;
        }
        imageView.setImageDrawable(this.f.getResources().getDrawable(R.drawable.beauty3d_left_arrow_grey));
        this.r.setClickable(false);
    }

    private void e(boolean z2) {
        ImageView imageView = this.s;
        if (imageView == null) {
            return;
        }
        if (z2) {
            imageView.setImageDrawable(this.f.getResources().getDrawable(R.drawable.beauty3d_right_arrow));
            this.s.setClickable(true);
            return;
        }
        imageView.setImageDrawable(this.f.getResources().getDrawable(R.drawable.beauty3d_right_arrow_grey));
        this.s.setClickable(false);
    }

    public void n() {
        if (this.aj.d() < 2) {
            e(false);
            return;
        }
        this.ao = true;
        c cVar = this.aj;
        cVar.a(cVar.b());
        b b2 = this.aj.b();
        this.h = b2.f3831a;
        a(b2.f3832b, b2.c);
        M();
        G();
        this.aj.a(b2);
        if (this.aj.c() < 2) {
            d(false);
        } else {
            d(true);
        }
        if (this.aj.d() < 2) {
            e(false);
        } else {
            e(true);
        }
    }

    private void F() {
        if (this.F.getVisibility() != 0) {
            this.F.setVisibility(0);
            this.F.setClickable(true);
        }
        if (this.G.getVisibility() != 0) {
            this.G.setVisibility(0);
            this.G.setClickable(true);
        }
    }

    private void c(int i2, int i3) {
        if (this.F.getId() == i2 && this.F.getVisibility() != i3) {
            this.F.setVisibility(i3);
            if (i3 == 0) {
                this.F.setClickable(true);
            } else {
                this.F.setClickable(false);
            }
        } else if (this.G.getId() == i2 && this.G.getVisibility() != i3) {
            this.G.setVisibility(0);
            if (i3 == 0) {
                this.G.setClickable(true);
            } else {
                this.G.setClickable(false);
            }
        }
    }

    private void G() {
        com.oppo.camera.e.a("Beauty3DEditUI", "showSeekBar");
        F();
        g();
        if (this.r.getVisibility() != 0) {
            this.r.setVisibility(0);
        }
        if (this.s.getVisibility() != 0) {
            this.s.setVisibility(0);
        }
        int i2 = this.h;
        if (i2 == 1) {
            c((int) R.id.up_seekbar_container, 0);
            this.w.c(this.D.b()).d(this.D.a()).a(this.D.f3830b).b(this.D.c).postInvalidate();
            this.x.c(this.C.b()).d(this.C.a()).a(this.C.f3830b).b(this.C.c).postInvalidate();
        } else if (i2 == 2) {
            c((int) R.id.up_seekbar_container, 4);
            this.x.c(this.B.b()).d(this.B.a()).a(this.B.f3830b).b(this.B.c).postInvalidate();
        } else if (i2 == 3) {
            c((int) R.id.up_seekbar_container, 0);
            this.w.c(this.y.b()).d(this.y.a()).a(this.y.f3830b).b(this.y.c).postInvalidate();
            this.x.c(this.z.b()).d(this.z.a()).a(this.z.f3830b).b(this.z.c).postInvalidate();
        } else if (i2 == 4) {
            c((int) R.id.up_seekbar_container, 4);
            this.x.c(this.E.b()).d(this.E.a()).a(this.E.f3830b).b(this.E.c).postInvalidate();
        } else if (i2 == 5) {
            c((int) R.id.up_seekbar_container, 4);
            this.x.c(this.A.b()).d(this.A.a()).a(this.A.f3830b).b(this.A.c).postInvalidate();
        }
    }

    /* access modifiers changed from: private */
    public void H() {
        com.oppo.camera.e.a("Beauty3DEditUI", "hideAllSeekBar");
        View view = this.I;
        if (view != null) {
            view.findViewById(R.id.up_seekbar_container).setVisibility(8);
            this.I.findViewById(R.id.up_seekbar_container).setEnabled(false);
            this.I.findViewById(R.id.down_seekbar_container).setVisibility(8);
            this.I.findViewById(R.id.down_seekbar_container).setEnabled(false);
        }
    }

    private void I() {
        new b.a(this.f, 2131821193).f(1).setNeutralButton((int) R.string.beauty3d_give_up_customize_face, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                d.this.a(true);
                if (d.this.H != null) {
                    d.this.H.c();
                }
            }
        }).setNegativeButton((int) R.string.beauty3d_cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    private void J() {
        v();
        h();
        L();
        TextView textView = this.p;
        if (textView != null) {
            textView.setVisibility(8);
            this.p.setClickable(false);
        }
        TextView textView2 = this.m;
        if (textView2 != null) {
            textView2.setVisibility(8);
            this.m.setClickable(false);
        }
        TextView textView3 = this.o;
        if (textView3 != null) {
            textView3.setVisibility(0);
            this.o.setClickable(true);
        }
        TextView textView4 = this.n;
        if (textView4 != null) {
            textView4.setClickable(true);
            this.n.setVisibility(0);
        }
        a(this.f.getString(R.string.beauty3d_customize_hint));
        Util.ab().postDelayed(new Runnable() {
            public void run() {
                d.this.r();
            }
        }, 3000);
        this.i = 2;
    }

    private void K() {
        RecyclerView recyclerView = this.t;
        if (recyclerView != null) {
            recyclerView.setClickable(false);
            this.t.setVisibility(8);
        }
    }

    private void L() {
        this.i = 2;
        RecyclerView recyclerView = this.t;
        if (recyclerView != null) {
            recyclerView.setClickable(true);
            this.t.setVisibility(0);
        }
    }

    public int o() {
        return this.i;
    }

    public int[] p() {
        return this.av;
    }

    public void a(OppoNumSeekBar oppoNumSeekBar, int i2, boolean z2) {
        com.oppo.camera.e.a("Beauty3DEditUI", "onProgressChanged, progress: " + i2);
        a(oppoNumSeekBar.getId(), i2);
        M();
    }

    public void a(OppoNumSeekBar oppoNumSeekBar, int i2) {
        this.ap = i2;
        this.aj.a(new b(this.h, oppoNumSeekBar.getId(), i2));
    }

    public void b(OppoNumSeekBar oppoNumSeekBar, int i2) {
        com.oppo.camera.e.a("Beauty3DEditUI", "getProgressOnActionUp, progress: " + i2 + ", mDownProgress: " + this.ap);
        if (this.ap != i2) {
            this.aj.a(new b(this.h, oppoNumSeekBar.getId(), i2));
            this.aj.e();
            e(false);
            if (this.aj.c() < 2) {
                d(false);
            } else {
                d(true);
            }
            a(oppoNumSeekBar.getId(), i2);
        } else if (this.aj.c() > 1) {
            this.aj.a();
        }
    }

    private void M() {
        int[] iArr = this.av;
        iArr[0] = this.am;
        a aVar = this.C;
        if (aVar != null) {
            iArr[1] = aVar.f3829a;
        }
        a aVar2 = this.D;
        if (aVar2 != null) {
            this.av[2] = aVar2.f3829a;
        }
        a aVar3 = this.B;
        if (aVar3 != null) {
            this.av[3] = aVar3.f3829a;
        }
        a aVar4 = this.z;
        if (aVar4 != null) {
            this.av[4] = aVar4.f3829a;
        }
        a aVar5 = this.y;
        if (aVar5 != null) {
            this.av[5] = aVar5.f3829a;
        }
        a aVar6 = this.E;
        if (aVar6 != null) {
            this.av[6] = aVar6.f3829a;
        }
        a aVar7 = this.A;
        if (aVar7 != null) {
            this.av[7] = aVar7.f3829a;
        }
        com.oppo.camera.e.a("Beauty3DEditUI", "updateFiveSenseParams, updateFiveSenseParams: " + this.av[0] + ", " + this.av[1] + ", " + this.av[2] + ", " + this.av[3] + ", " + this.av[4] + ", " + this.av[5] + ", " + this.av[6] + ", " + this.av[7]);
        i iVar = this.H;
        if (iVar != null) {
            iVar.a("com.oplus.beauty3d.custom.style", this.av);
        }
    }

    public void c(int[] iArr) {
        if (iArr != null && iArr.length >= 2 && iArr[0] == 2) {
            int i2 = iArr[1];
            com.oppo.camera.e.a("Beauty3DEditUI", "upParams, location: " + i2 + ", mTouchLocation: " + this.h + ", mbRedo: " + this.ao + ", mbChangeStyle: " + this.aq);
            if (2 == this.i && (this.h == i2 || this.ao || this.aq)) {
                return;
            }
            if (i2 == 2 || i2 == 1 || i2 == 3 || i2 == 5 || i2 == 4) {
                com.oppo.camera.e.a("Beauty3DEditUI", "update, location: " + i2);
                this.h = i2;
                G();
            }
        }
    }

    public void c(boolean z2) {
        View view = this.P;
        if (view != null) {
            view.setEnabled(z2);
            this.P.setClickable(z2);
        }
        View view2 = this.I;
        if (view2 != null) {
            view2.setEnabled(z2);
            this.I.setClickable(z2);
        }
    }

    public void a(int i2, int[] iArr) {
        this.az = i2;
        this.am = i2;
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = i3 * 7;
            this.aw.put(i3, Arrays.copyOfRange(iArr, i4, i4 + 7));
        }
    }

    public HashMap<String, int[]> q() {
        HashMap<String, int[]> hashMap = new HashMap<>();
        com.oppo.camera.e.a("Beauty3DEditUI", "getBeauty3DEditCurrParams, mChoseStyle: " + this.am + ", mDegree: " + this.al);
        if (this.i != 1) {
            hashMap.put("com.oplus.beauty3d.custom.style", this.av);
        }
        hashMap.put("com.oplus.beauty3d.analyses.rotatedegree", new int[]{this.al});
        return hashMap;
    }

    /* compiled from: Beauty3DEditUI */
    private class b extends RecyclerView.a<a> {

        /* renamed from: a  reason: collision with root package name */
        public C0099d f3845a = null;
        private List<c> c = null;
        /* access modifiers changed from: private */
        public List<Boolean> d = new ArrayList();

        public b(List<c> list, C0099d dVar) {
            this.c = list;
            this.f3845a = dVar;
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    this.d.add(true);
                } else {
                    this.d.add(false);
                }
            }
        }

        /* renamed from: a */
        public a onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beauty3d_edit_item, viewGroup, false);
            com.oppo.camera.e.a("Beauty3DEditUI", "ViewHolder, onCreateViewHolder, Tag: " + i);
            return new a(inflate, this.f3845a);
        }

        /* renamed from: a */
        public void onBindViewHolder(a aVar, int i) {
            aVar.f3847a.setImageDrawable(this.c.get(i).f3849a);
            aVar.f3848b.setText(this.c.get(i).f3850b);
            if (this.d.get(i).booleanValue()) {
                aVar.f3848b.setTextColor(Util.s(d.this.f));
                aVar.f3847a.setHighLight(true);
                return;
            }
            aVar.f3848b.setTextColor(d.this.f.getColor(R.color.camera_white));
            aVar.f3847a.setHighLight(false);
        }

        public int getItemCount() {
            return this.c.size();
        }

        /* compiled from: Beauty3DEditUI */
        public class a extends RecyclerView.w implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            public BorderRoundImageView f3847a = null;

            /* renamed from: b  reason: collision with root package name */
            public TextView f3848b = null;
            public C0099d c = null;

            public void onClick(View view) {
                for (int i = 0; i < b.this.d.size(); i++) {
                    b.this.d.set(i, false);
                }
                com.oppo.camera.e.a("Beauty3DEditUI", "ViewHolder, onClick, Position: " + getPosition());
                b.this.d.set(getPosition(), true);
                b.this.notifyDataSetChanged();
                C0099d dVar = this.c;
                if (dVar != null) {
                    dVar.a(view, getPosition());
                }
            }

            public a(View view, C0099d dVar) {
                super(view);
                this.f3847a = (BorderRoundImageView) view.findViewById(R.id.edit_item_view);
                this.f3848b = (TextView) view.findViewById(R.id.edit_item_title);
                this.c = dVar;
                view.setOnClickListener(this);
            }
        }
    }

    /* compiled from: Beauty3DEditUI */
    private class c {

        /* renamed from: a  reason: collision with root package name */
        public Drawable f3849a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f3850b = null;

        public c(Drawable drawable, String str) {
            this.f3849a = drawable;
            this.f3850b = str;
        }
    }

    /* compiled from: Beauty3DEditUI */
    public class f extends RecyclerView.h {

        /* renamed from: b  reason: collision with root package name */
        private int f3855b = 0;

        public f(int i) {
            this.f3855b = i;
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t tVar) {
            int i = this.f3855b;
            rect.right = i;
            rect.left = i;
        }
    }

    /* compiled from: Beauty3DEditUI */
    private class e extends LinearLayoutManager {

        /* renamed from: b  reason: collision with root package name */
        private int[] f3853b = new int[2];

        public e(Context context) {
            super(context);
        }

        public void onMeasure(RecyclerView.p pVar, RecyclerView.t tVar, int i, int i2) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < getItemCount(); i5++) {
                a(pVar, i5, View.MeasureSpec.makeMeasureSpec(i5, 0), View.MeasureSpec.makeMeasureSpec(i5, 0), this.f3853b);
                if (getOrientation() == 0) {
                    int[] iArr = this.f3853b;
                    i4 += iArr[0];
                    if (i5 == 0) {
                        i3 = iArr[1];
                    }
                } else {
                    int[] iArr2 = this.f3853b;
                    i3 += iArr2[1];
                    if (i5 == 0) {
                        i4 = iArr2[0];
                    }
                }
            }
            if (mode == Integer.MIN_VALUE || mode == 0 || mode != 1073741824) {
                size = i4;
            }
            if (mode2 == Integer.MIN_VALUE || mode2 == 0 || mode2 != 1073741824) {
                size2 = i3;
            }
            setMeasuredDimension(size, size2);
        }

        private void a(RecyclerView.p pVar, int i, int i2, int i3, int[] iArr) {
            View c = pVar.c(i);
            if (c != null) {
                RecyclerView.j jVar = (RecyclerView.j) c.getLayoutParams();
                c.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), jVar.width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), jVar.height));
                iArr[0] = c.getMeasuredWidth() + jVar.leftMargin + jVar.rightMargin;
                iArr[1] = c.getMeasuredHeight() + jVar.bottomMargin + jVar.topMargin;
                pVar.a(c);
            }
        }
    }

    private void N() {
        if (this.g != null && this.ak == null) {
            this.ak = (CameraScreenHintView) this.f.getLayoutInflater().inflate(R.layout.camera_screen_hint, (ViewGroup) null);
            this.g.addView(this.ak);
            this.ak.setOrientation(0);
        }
    }

    public void a(String str) {
        if (this.ak == null) {
            N();
            if (this.ak != null) {
                this.ak.a(0, (this.f.getResources().getDimensionPixelSize(R.dimen.down_hint_margin_bottom) + ((int) this.f.getResources().getDimension(R.dimen.beauty3d_edit_custom_bottom_height))) - this.ak.getViewGap(), 0, true);
            }
        }
        CameraScreenHintView cameraScreenHintView = this.ak;
        if (cameraScreenHintView != null) {
            cameraScreenHintView.bringToFront();
            this.ak.a(str, true, false, 0, (int) R.color.screen_hint_text_color);
        }
    }

    public void r() {
        CameraScreenHintView cameraScreenHintView = this.ak;
        if (cameraScreenHintView != null && cameraScreenHintView.getHintTextView().getVisibility() == 0) {
            this.ak.c(true);
        }
    }

    /* renamed from: com.oppo.camera.ui.beauty3d.d$d  reason: collision with other inner class name */
    /* compiled from: Beauty3DEditUI */
    private abstract class C0099d {
        /* access modifiers changed from: package-private */
        public void a(View view, int i) {
        }

        private C0099d() {
        }
    }

    /* compiled from: Beauty3DEditUI */
    private class a implements GestureDetector.OnGestureListener {
        private a() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            if (motionEvent == null) {
                return true;
            }
            boolean unused = d.this.ar = false;
            float unused2 = d.this.an = motionEvent.getRawX();
            return true;
        }

        public void onShowPress(MotionEvent motionEvent) {
            com.oppo.camera.e.a("Beauty3DEditUI", "Beauty3DGestureListener, onShowPress");
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (motionEvent == null) {
                return true;
            }
            float y = 1440.0f - motionEvent.getY();
            float x = 1080.0f - motionEvent.getX();
            com.oppo.camera.e.a("Beauty3DEditUI", "Beauty3DGestureListener, onSingleTapUp, x: " + y + ", y: " + x);
            if (d.this.i == 2) {
                boolean unused = d.this.ao = false;
                boolean unused2 = d.this.aq = false;
                d.this.H.a("com.oplus.beauty3d.custom.position", new int[]{(int) y, (int) x});
            }
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!(motionEvent == null || motionEvent2 == null)) {
                com.oppo.camera.e.a("Beauty3DEditUI", "Beauty3DGestureListener, onScroll, e1.X: " + motionEvent.getX() + ", e2.X:" + motionEvent2.getX());
                if (Math.abs((int) (motionEvent2.getX() - motionEvent.getX())) < 10) {
                    return true;
                }
                d.this.b(false);
                int unused = d.this.al = com.oppo.camera.d.c.a().a(motionEvent2.getRawX(), Util.E(), d.this.an, d.this.al);
                d.this.H.a("com.oplus.beauty3d.analyses.rotatedegree", new int[]{d.this.al});
                float unused2 = d.this.an = motionEvent2.getRawX();
            }
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            com.oppo.camera.e.a("Beauty3DEditUI", "Beauty3DGestureListener, onFling");
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            com.oppo.camera.e.a("Beauty3DEditUI", "Beauty3DGestureListener, onLongPress");
            if (d.this.i == 2) {
                d.this.H.a("com.oplus.beauty3d.custom.mode", d.this.at);
            }
        }
    }
}
