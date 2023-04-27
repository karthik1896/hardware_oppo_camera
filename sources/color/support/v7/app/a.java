package color.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.f;
import color.support.v7.appcompat.R;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.lang.ref.WeakReference;

/* compiled from: AlertController */
public class a {
    boolean A;
    private final Context B;
    private final int C;
    private View D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private boolean J = false;
    private Drawable K;
    private Drawable L;
    private Drawable M;
    private int N = 0;
    private Drawable O;
    private ImageView P;
    private TextView Q;
    private TextView R;
    private View S;
    private int T;
    private boolean U;
    private int V = 0;
    private int W = 0;
    private final View.OnClickListener X = new View.OnClickListener() {
        public void onClick(View view) {
            Message message;
            if (view == a.this.f && a.this.h != null) {
                message = Message.obtain(a.this.h);
            } else if (view != a.this.i || a.this.k == null) {
                message = (view != a.this.l || a.this.n == null) ? null : Message.obtain(a.this.n);
            } else {
                message = Message.obtain(a.this.k);
            }
            if (message != null) {
                message.sendToTarget();
            }
            a.this.w.obtainMessage(1, a.this.f1460a).sendToTarget();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final f f1460a;

    /* renamed from: b  reason: collision with root package name */
    final Window f1461b;
    CharSequence c;
    CharSequence d;
    ListView e;
    Button f;
    CharSequence g;
    Message h;
    Button i;
    CharSequence j;
    Message k;
    Button l;
    CharSequence m;
    Message n;
    ScrollView o;
    ListAdapter p;
    int q = -1;
    protected int r;
    int s;
    int t;
    int u;
    int v;
    Handler w;
    boolean x = false;
    boolean y;
    boolean z;

    /* compiled from: AlertController */
    private static final class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<DialogInterface> f1481a;

        public b(DialogInterface dialogInterface) {
            this.f1481a = new WeakReference<>(dialogInterface);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f1481a.get(), message.what);
            } else if (i == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static boolean a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            return true;
        }
        return false;
    }

    public a(Context context, f fVar, Window window) {
        this.B = context;
        this.f1460a = fVar;
        this.f1461b = window;
        this.w = new b(fVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.ColorSupportAlertDialog, R.attr.colorAlertDialogStyle, 0);
        this.r = obtainStyledAttributes.getResourceId(R.styleable.ColorSupportAlertDialog_android_layout, 0);
        this.T = obtainStyledAttributes.getResourceId(R.styleable.ColorSupportAlertDialog_buttonPanelSideLayout, 0);
        this.s = obtainStyledAttributes.getResourceId(R.styleable.ColorSupportAlertDialog_listLayout, 0);
        this.t = obtainStyledAttributes.getResourceId(R.styleable.ColorSupportAlertDialog_multiChoiceItemLayout, 0);
        this.u = obtainStyledAttributes.getResourceId(R.styleable.ColorSupportAlertDialog_singleChoiceItemLayout, 0);
        this.v = obtainStyledAttributes.getResourceId(R.styleable.ColorSupportAlertDialog_listItemLayout, 0);
        this.U = obtainStyledAttributes.getBoolean(R.styleable.ColorSupportAlertDialog_showTitle, true);
        this.C = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorSupportAlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        fVar.supportRequestWindowFeature(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        this.f1460a.setContentView(b());
        d();
    }

    /* access modifiers changed from: protected */
    public int b() {
        int i2 = this.T;
        if (i2 == 0) {
            return this.r;
        }
        if (this.V == 1) {
            return i2;
        }
        return this.r;
    }

    public void a(CharSequence charSequence) {
        this.c = charSequence;
        TextView textView = this.Q;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void b(View view) {
        this.S = view;
    }

    public void b(CharSequence charSequence) {
        this.d = charSequence;
        TextView textView = this.R;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void a(int i2) {
        this.D = null;
        this.E = i2;
        this.J = false;
    }

    public void c(View view) {
        this.D = view;
        this.E = 0;
        this.J = false;
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        this.D = view;
        this.E = 0;
        this.J = true;
        this.F = i2;
        this.G = i3;
        this.H = i4;
        this.I = i5;
    }

    public void a(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.w.obtainMessage(i2, onClickListener);
        }
        if (i2 == -3) {
            this.m = charSequence;
            this.n = message;
            this.M = drawable;
        } else if (i2 == -2) {
            this.j = charSequence;
            this.k = message;
            this.L = drawable;
        } else if (i2 == -1) {
            this.g = charSequence;
            this.h = message;
            this.K = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void b(int i2) {
        this.O = null;
        this.N = i2;
        ImageView imageView = this.P;
        if (imageView == null) {
            return;
        }
        if (i2 != 0) {
            imageView.setVisibility(0);
            this.P.setImageResource(this.N);
            return;
        }
        imageView.setVisibility(8);
    }

    public void a(Drawable drawable) {
        this.O = drawable;
        this.N = 0;
        ImageView imageView = this.P;
        if (imageView == null) {
            return;
        }
        if (drawable != null) {
            imageView.setVisibility(0);
            this.P.setImageDrawable(drawable);
            return;
        }
        imageView.setVisibility(8);
    }

    public int c(int i2) {
        TypedValue typedValue = new TypedValue();
        this.B.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView c() {
        return this.e;
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        ScrollView scrollView = this.o;
        return scrollView != null && scrollView.executeKeyEvent(keyEvent);
    }

    public boolean b(int i2, KeyEvent keyEvent) {
        ScrollView scrollView = this.o;
        return scrollView != null && scrollView.executeKeyEvent(keyEvent);
    }

    private ViewGroup a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    /* access modifiers changed from: protected */
    public void d() {
        ListAdapter listAdapter;
        View findViewById;
        View findViewById2;
        View findViewById3 = this.f1461b.findViewById(R.id.parentPanel);
        View findViewById4 = findViewById3.findViewById(R.id.topPanel);
        View findViewById5 = findViewById3.findViewById(R.id.contentPanel);
        View findViewById6 = findViewById3.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R.id.customPanel);
        d(viewGroup);
        View findViewById7 = viewGroup.findViewById(R.id.topPanel);
        View findViewById8 = viewGroup.findViewById(R.id.contentPanel);
        View findViewById9 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup a2 = a(findViewById7, findViewById4);
        ViewGroup a3 = a(findViewById8, findViewById5);
        ViewGroup a4 = a(findViewById9, findViewById6);
        b(a3);
        c(a4);
        a(a2);
        char c2 = 0;
        boolean z2 = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z3 = (a2 == null || a2.getVisibility() == 8) ? false : true;
        boolean z4 = (a4 == null || a4.getVisibility() == 8) ? false : true;
        if (!(z4 || a3 == null || (findViewById2 = a3.findViewById(R.id.textSpacerNoButtons)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (z3) {
            ScrollView scrollView = this.o;
            if (scrollView != null) {
                scrollView.setClipToPadding(true);
            }
            View view = null;
            if (!(this.d == null && this.e == null)) {
                view = a2.findViewById(R.id.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (!(a3 == null || (findViewById = a3.findViewById(R.id.textSpacerNoTitle)) == null)) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.e;
        if (listView instanceof d) {
            ((d) listView).a(z3, z4);
        }
        if (!z2) {
            View view2 = this.e;
            if (view2 == null) {
                view2 = this.o;
            }
            if (view2 != null) {
                if (z4) {
                    c2 = 2;
                }
                a(a3, view2, z3 | c2 ? 1 : 0, 3);
            }
        }
        ListView listView2 = this.e;
        if (listView2 != null && (listAdapter = this.p) != null) {
            listView2.setAdapter(listAdapter);
            int i2 = this.q;
            if (i2 > -1) {
                listView2.setItemChecked(i2, true);
                listView2.setSelection(i2);
            }
        }
    }

    private void a(ViewGroup viewGroup, View view, int i2, int i3) {
        final View findViewById = this.f1461b.findViewById(R.id.scrollIndicatorUp);
        final View findViewById2 = this.f1461b.findViewById(R.id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i2 & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 != null && (i2 & 2) == 0) {
            viewGroup.removeView(findViewById2);
            findViewById2 = null;
        }
        if (findViewById != null || findViewById2 != null) {
            if (this.d != null) {
                this.o.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                    public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                        a.a(view, findViewById, findViewById2);
                    }
                });
                this.o.post(new Runnable() {
                    public void run() {
                        a.a(a.this.o, findViewById, findViewById2);
                    }
                });
                return;
            }
            ListView listView = this.e;
            if (listView != null) {
                listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                    public void onScrollStateChanged(AbsListView absListView, int i) {
                    }

                    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                        a.a(absListView, findViewById, findViewById2);
                    }
                });
                this.e.post(new Runnable() {
                    public void run() {
                        a.a(a.this.e, findViewById, findViewById2);
                    }
                });
                return;
            }
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
            }
        }
    }

    private void d(ViewGroup viewGroup) {
        View view = this.D;
        boolean z2 = false;
        if (view == null) {
            view = this.E != 0 ? LayoutInflater.from(this.B).inflate(this.E, viewGroup, false) : null;
        }
        if (view != null) {
            z2 = true;
        }
        if (!z2 || !a(view)) {
            this.f1461b.setFlags(STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_VIDEO, STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_VIDEO);
        }
        if (z2) {
            FrameLayout frameLayout = (FrameLayout) this.f1461b.findViewById(R.id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.J) {
                frameLayout.setPadding(this.F, this.G, this.H, this.I);
            }
            if (this.e != null) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void a(ViewGroup viewGroup) {
        if (this.S != null) {
            viewGroup.addView(this.S, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f1461b.findViewById(R.id.title_template).setVisibility(8);
            return;
        }
        this.P = (ImageView) this.f1461b.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.c)) || !this.U) {
            this.f1461b.findViewById(R.id.title_template).setVisibility(8);
            this.P.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        this.Q = (TextView) this.f1461b.findViewById(R.id.alertTitle);
        this.Q.setText(this.c);
        int i2 = this.N;
        if (i2 != 0) {
            this.P.setImageResource(i2);
            return;
        }
        Drawable drawable = this.O;
        if (drawable != null) {
            this.P.setImageDrawable(drawable);
            return;
        }
        this.Q.setPadding(this.P.getPaddingLeft(), this.P.getPaddingTop(), this.P.getPaddingRight(), this.P.getPaddingBottom());
        this.P.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void b(ViewGroup viewGroup) {
        this.o = (ScrollView) this.f1461b.findViewById(R.id.scrollView);
        this.o.setFocusable(false);
        this.o.setNestedScrollingEnabled(false);
        this.R = (TextView) viewGroup.findViewById(16908299);
        TextView textView = this.R;
        if (textView != null) {
            CharSequence charSequence = this.d;
            if (charSequence != null) {
                textView.setText(charSequence);
                return;
            }
            textView.setVisibility(8);
            this.o.removeView(this.R);
            if (this.e != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.o.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.o);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.e, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    static void a(View view, View view2, View view3) {
        int i2 = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i2 = 4;
            }
            view3.setVisibility(i2);
        }
    }

    /* access modifiers changed from: protected */
    public void c(ViewGroup viewGroup) {
        boolean z2;
        this.f = (Button) viewGroup.findViewById(16908313);
        this.f.setOnClickListener(this.X);
        boolean z3 = true;
        if (!TextUtils.isEmpty(this.g) || this.K != null) {
            this.f.setText(this.g);
            Drawable drawable = this.K;
            if (drawable != null) {
                int i2 = this.C;
                drawable.setBounds(0, 0, i2, i2);
                this.f.setCompoundDrawables(this.K, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.f.setVisibility(0);
            z2 = true;
        } else {
            this.f.setVisibility(8);
            z2 = false;
        }
        this.i = (Button) viewGroup.findViewById(16908314);
        this.i.setOnClickListener(this.X);
        if (!TextUtils.isEmpty(this.j) || this.L != null) {
            this.i.setText(this.j);
            Drawable drawable2 = this.L;
            if (drawable2 != null) {
                int i3 = this.C;
                drawable2.setBounds(0, 0, i3, i3);
                this.i.setCompoundDrawables(this.L, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.i.setVisibility(0);
            z2 |= true;
        } else {
            this.i.setVisibility(8);
        }
        this.l = (Button) viewGroup.findViewById(16908315);
        this.l.setOnClickListener(this.X);
        if (!TextUtils.isEmpty(this.m) || this.M != null) {
            this.l.setText(this.m);
            Drawable drawable3 = this.K;
            if (drawable3 != null) {
                int i4 = this.C;
                drawable3.setBounds(0, 0, i4, i4);
                this.f.setCompoundDrawables(this.K, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            this.l.setVisibility(0);
            z2 |= true;
        } else {
            this.l.setVisibility(8);
        }
        if (a(this.B)) {
            if (z2) {
                a(this.f);
            } else if (z2) {
                a(this.i);
            } else if (z2) {
                a(this.l);
            }
        }
        if (!z2) {
            z3 = false;
        }
        if (!z3) {
            viewGroup.setVisibility(8);
        }
    }

    private void a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public int e() {
        return this.W;
    }

    public void d(int i2) {
        this.W = i2;
    }

    /* compiled from: AlertController */
    public static class d extends ListView {

        /* renamed from: a  reason: collision with root package name */
        private final int f1484a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1485b;

        public d(Context context) {
            this(context, (AttributeSet) null);
        }

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
            this.f1485b = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f1484a = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        public void a(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f1484a, getPaddingRight(), z2 ? getPaddingBottom() : this.f1485b);
            }
        }
    }

    /* renamed from: color.support.v7.app.a$a  reason: collision with other inner class name */
    /* compiled from: AlertController */
    public static class C0045a {
        public DialogInterface.OnClickListener A;
        public int B;
        public View C;
        public int D;
        public int E;
        public int F;
        public int G;
        public boolean H = false;
        public boolean[] I;
        public boolean J;
        public boolean K;
        public int L = -1;
        public DialogInterface.OnMultiChoiceClickListener M;
        public Cursor N;
        public String O;
        public String P;
        public boolean Q;
        public AdapterView.OnItemSelectedListener R;
        public C0046a S;
        public boolean T = true;
        public int U;

        /* renamed from: a  reason: collision with root package name */
        public final Context f1471a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f1472b;
        public int c = 0;
        public Drawable d;
        public int e = 0;
        public CharSequence f;
        public View g;
        public CharSequence h;
        public CharSequence i;
        public Drawable j;
        public DialogInterface.OnClickListener k;
        public CharSequence l;
        public Drawable m;
        public DialogInterface.OnClickListener n;
        public CharSequence o;
        public Drawable p;
        public DialogInterface.OnClickListener q;
        public boolean r;
        public boolean s;
        public DialogInterface.OnCancelListener t;
        public DialogInterface.OnDismissListener u;
        public DialogInterface.OnKeyListener v;
        public CharSequence[] w;
        public CharSequence[] x;
        public boolean y;
        public ListAdapter z;

        /* renamed from: color.support.v7.app.a$a$a  reason: collision with other inner class name */
        /* compiled from: AlertController */
        public interface C0046a {
            void a(ListView listView);
        }

        public C0045a(Context context) {
            this.f1471a = context;
            this.r = true;
            this.f1472b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void a(a aVar) {
            View view = this.g;
            if (view != null) {
                aVar.b(view);
            } else {
                CharSequence charSequence = this.f;
                if (charSequence != null) {
                    aVar.a(charSequence);
                }
                Drawable drawable = this.d;
                if (drawable != null) {
                    aVar.a(drawable);
                }
                int i2 = this.c;
                if (i2 != 0) {
                    aVar.b(i2);
                }
                int i3 = this.e;
                if (i3 != 0) {
                    aVar.b(aVar.c(i3));
                }
            }
            aVar.x = this.y;
            CharSequence charSequence2 = this.h;
            if (charSequence2 != null) {
                aVar.b(charSequence2);
            }
            if (!(this.i == null && this.j == null)) {
                aVar.a(-1, this.i, this.k, (Message) null, this.j);
            }
            if (!(this.l == null && this.m == null)) {
                aVar.a(-2, this.l, this.n, (Message) null, this.m);
            }
            if (!(this.o == null && this.p == null)) {
                aVar.a(-3, this.o, this.q, (Message) null, this.p);
            }
            if (!(this.w == null && this.N == null && this.z == null)) {
                b(aVar);
            }
            View view2 = this.C;
            if (view2 == null) {
                int i4 = this.B;
                if (i4 != 0) {
                    aVar.a(i4);
                }
            } else if (this.H) {
                aVar.a(view2, this.D, this.E, this.F, this.G);
            } else {
                aVar.c(view2);
            }
            aVar.d(this.U);
            aVar.y = this.K;
            aVar.z = this.J;
            aVar.A = this.s;
        }

        /* JADX WARNING: type inference failed for: r10v0, types: [android.widget.ListAdapter] */
        /* JADX WARNING: type inference failed for: r10v2 */
        /* JADX WARNING: type inference failed for: r10v3 */
        /* JADX WARNING: type inference failed for: r10v4 */
        /* JADX WARNING: type inference failed for: r2v9, types: [android.widget.SimpleCursorAdapter] */
        /* JADX WARNING: type inference failed for: r1v23, types: [color.support.v7.app.a$a$2] */
        /* JADX WARNING: type inference failed for: r1v24, types: [color.support.v7.app.a$a$1] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void b(final color.support.v7.app.a r12) {
            /*
                r11 = this;
                android.view.LayoutInflater r0 = r11.f1472b
                int r1 = r12.s
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                color.support.v7.app.a$d r0 = (color.support.v7.app.a.d) r0
                boolean r1 = r11.J
                r8 = 0
                r9 = 1
                if (r1 == 0) goto L_0x0034
                android.database.Cursor r4 = r11.N
                if (r4 != 0) goto L_0x0027
                color.support.v7.app.a$a$1 r10 = new color.support.v7.app.a$a$1
                android.content.Context r3 = r11.f1471a
                int r4 = r12.t
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r11.w
                r1 = r10
                r2 = r11
                r7 = r0
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x0085
            L_0x0027:
                color.support.v7.app.a$a$2 r10 = new color.support.v7.app.a$a$2
                android.content.Context r3 = r11.f1471a
                r5 = 0
                r1 = r10
                r2 = r11
                r6 = r0
                r7 = r12
                r1.<init>(r3, r4, r5, r6, r7)
                goto L_0x0085
            L_0x0034:
                boolean r1 = r11.K
                if (r1 == 0) goto L_0x0064
                int r4 = r12.u
                android.database.Cursor r5 = r11.N
                r1 = 16908308(0x1020014, float:2.3877285E-38)
                if (r5 == 0) goto L_0x0054
                android.widget.SimpleCursorAdapter r10 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r11.f1471a
                java.lang.String[] r6 = new java.lang.String[r9]
                java.lang.String r2 = r11.O
                r6[r8] = r2
                int[] r7 = new int[r9]
                r7[r8] = r1
                r2 = r10
                r2.<init>(r3, r4, r5, r6, r7)
                goto L_0x0085
            L_0x0054:
                android.widget.ListAdapter r2 = r11.z
                if (r2 == 0) goto L_0x0059
                goto L_0x0062
            L_0x0059:
                color.support.v7.app.a$c r2 = new color.support.v7.app.a$c
                android.content.Context r3 = r11.f1471a
                java.lang.CharSequence[] r5 = r11.w
                r2.<init>(r3, r4, r1, r5)
            L_0x0062:
                r10 = r2
                goto L_0x0085
            L_0x0064:
                android.widget.ListAdapter r10 = r11.z
                if (r10 != 0) goto L_0x0085
                java.lang.CharSequence r1 = r11.f
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                r4 = r1 ^ 1
                java.lang.CharSequence r1 = r11.h
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                r5 = r1 ^ 1
                color.support.v7.app.e r1 = new color.support.v7.app.e
                android.content.Context r3 = r11.f1471a
                java.lang.CharSequence[] r6 = r11.w
                java.lang.CharSequence[] r7 = r11.x
                r2 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                r10 = r1
            L_0x0085:
                color.support.v7.app.a$a$a r1 = r11.S
                if (r1 == 0) goto L_0x008c
                r1.a(r0)
            L_0x008c:
                r12.p = r10
                int r1 = r11.L
                r12.q = r1
                android.content.DialogInterface$OnClickListener r1 = r11.A
                if (r1 == 0) goto L_0x009f
                color.support.v7.app.a$a$3 r1 = new color.support.v7.app.a$a$3
                r1.<init>(r12)
                r0.setOnItemClickListener(r1)
                goto L_0x00ab
            L_0x009f:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r11.M
                if (r1 == 0) goto L_0x00ab
                color.support.v7.app.a$a$4 r1 = new color.support.v7.app.a$a$4
                r1.<init>(r0, r12)
                r0.setOnItemClickListener(r1)
            L_0x00ab:
                android.widget.AdapterView$OnItemSelectedListener r1 = r11.R
                if (r1 == 0) goto L_0x00b2
                r0.setOnItemSelectedListener(r1)
            L_0x00b2:
                boolean r1 = r11.K
                if (r1 == 0) goto L_0x00c2
                int r1 = color.support.v7.appcompat.R.drawable.color_alert_dialog_item_background
                r0.setSelector(r1)
                r0.setItemsCanFocus(r8)
                r0.setChoiceMode(r9)
                goto L_0x00d2
            L_0x00c2:
                boolean r1 = r11.J
                if (r1 == 0) goto L_0x00d2
                int r1 = color.support.v7.appcompat.R.drawable.color_alert_dialog_item_background
                r0.setSelector(r1)
                r0.setItemsCanFocus(r8)
                r1 = 2
                r0.setChoiceMode(r1)
            L_0x00d2:
                r12.e = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: color.support.v7.app.a.C0045a.b(color.support.v7.app.a):void");
        }
    }

    /* compiled from: AlertController */
    private static class c extends ArrayAdapter<CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        private int f1482a;

        /* renamed from: b  reason: collision with root package name */
        private int f1483b;
        private int c;
        private int d;
        private int e;
        private int f;

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }

        public c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
            this.f1482a = context.getResources().getDimensionPixelOffset(R.dimen.alert_dialog_single_list_padding_left);
            this.f1483b = context.getResources().getDimensionPixelOffset(R.dimen.alert_dialog_single_list_padding_right);
            this.d = context.getResources().getDimensionPixelOffset(R.dimen.alert_dialog_single_list_padding_vertical);
            this.e = context.getResources().getDimensionPixelOffset(R.dimen.alert_dialog_item_padding_offset);
            this.c = context.getResources().getDimensionPixelOffset(R.dimen.alert_dialog_single_list_padding_vertical);
            this.f = context.getResources().getDimensionPixelOffset(R.dimen.alert_dialog_list_item_min_height);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i, view, viewGroup);
            view2.setMinimumHeight(this.f);
            view2.setPaddingRelative(this.f1482a, this.c, this.f1483b, this.d);
            return view2;
        }
    }
}
