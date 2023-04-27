package androidx.preference;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.content.a.g;
import androidx.preference.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Preference implements Comparable<Preference> {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private int G;
    private int H;
    private a I;
    private List<Preference> J;
    private PreferenceGroup K;
    private boolean L;
    private boolean M;
    private d N;
    private e O;
    private final View.OnClickListener P;

    /* renamed from: a  reason: collision with root package name */
    private Context f977a;

    /* renamed from: b  reason: collision with root package name */
    private j f978b;
    private e c;
    private long d;
    private boolean e;
    private b f;
    private c g;
    private int h;
    private int i;
    private CharSequence j;
    private CharSequence k;
    private int l;
    private Drawable m;
    private String n;
    private Intent o;
    private String p;
    private Bundle q;
    private boolean r;
    private boolean s;
    private boolean t;
    private String u;
    private Object v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    interface a {
        void a(Preference preference);

        void b(Preference preference);
    }

    public interface b {
        boolean onPreferenceChange(Preference preference, Object obj);
    }

    public interface c {
        boolean onPreferenceClick(Preference preference);
    }

    public interface e<T extends Preference> {
        CharSequence a(T t);
    }

    /* access modifiers changed from: protected */
    public Object a(TypedArray typedArray, int i2) {
        return null;
    }

    @Deprecated
    public void a(androidx.core.g.a.d dVar) {
    }

    /* access modifiers changed from: protected */
    public void a(Object obj) {
    }

    /* access modifiers changed from: protected */
    public void g() {
    }

    public Preference(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.h = Integer.MAX_VALUE;
        this.i = 0;
        this.r = true;
        this.s = true;
        this.t = true;
        this.w = true;
        this.x = true;
        this.y = true;
        this.z = true;
        this.A = true;
        this.C = true;
        this.F = true;
        this.G = R.layout.preference;
        this.P = new View.OnClickListener() {
            public void onClick(View view) {
                Preference.this.a(view);
            }
        };
        this.f977a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Preference, i2, i3);
        this.l = g.b(obtainStyledAttributes, R.styleable.Preference_icon, R.styleable.Preference_android_icon, 0);
        this.n = g.b(obtainStyledAttributes, R.styleable.Preference_key, R.styleable.Preference_android_key);
        this.j = g.c(obtainStyledAttributes, R.styleable.Preference_title, R.styleable.Preference_android_title);
        this.k = g.c(obtainStyledAttributes, R.styleable.Preference_summary, R.styleable.Preference_android_summary);
        this.h = g.a(obtainStyledAttributes, R.styleable.Preference_order, R.styleable.Preference_android_order, Integer.MAX_VALUE);
        this.p = g.b(obtainStyledAttributes, R.styleable.Preference_fragment, R.styleable.Preference_android_fragment);
        this.G = g.b(obtainStyledAttributes, R.styleable.Preference_layout, R.styleable.Preference_android_layout, R.layout.preference);
        this.H = g.b(obtainStyledAttributes, R.styleable.Preference_widgetLayout, R.styleable.Preference_android_widgetLayout, 0);
        this.r = g.a(obtainStyledAttributes, R.styleable.Preference_enabled, R.styleable.Preference_android_enabled, true);
        this.s = g.a(obtainStyledAttributes, R.styleable.Preference_selectable, R.styleable.Preference_android_selectable, true);
        this.t = g.a(obtainStyledAttributes, R.styleable.Preference_persistent, R.styleable.Preference_android_persistent, true);
        this.u = g.b(obtainStyledAttributes, R.styleable.Preference_dependency, R.styleable.Preference_android_dependency);
        this.z = g.a(obtainStyledAttributes, R.styleable.Preference_allowDividerAbove, R.styleable.Preference_allowDividerAbove, this.s);
        this.A = g.a(obtainStyledAttributes, R.styleable.Preference_allowDividerBelow, R.styleable.Preference_allowDividerBelow, this.s);
        if (obtainStyledAttributes.hasValue(R.styleable.Preference_defaultValue)) {
            this.v = a(obtainStyledAttributes, R.styleable.Preference_defaultValue);
        } else if (obtainStyledAttributes.hasValue(R.styleable.Preference_android_defaultValue)) {
            this.v = a(obtainStyledAttributes, R.styleable.Preference_android_defaultValue);
        }
        this.F = g.a(obtainStyledAttributes, R.styleable.Preference_shouldDisableView, R.styleable.Preference_android_shouldDisableView, true);
        this.B = obtainStyledAttributes.hasValue(R.styleable.Preference_singleLineTitle);
        if (this.B) {
            this.C = g.a(obtainStyledAttributes, R.styleable.Preference_singleLineTitle, R.styleable.Preference_android_singleLineTitle, true);
        }
        this.D = g.a(obtainStyledAttributes, R.styleable.Preference_iconSpaceReserved, R.styleable.Preference_android_iconSpaceReserved, false);
        this.y = g.a(obtainStyledAttributes, R.styleable.Preference_isPreferenceVisible, R.styleable.Preference_isPreferenceVisible, true);
        this.E = g.a(obtainStyledAttributes, R.styleable.Preference_enableCopying, R.styleable.Preference_enableCopying, false);
        obtainStyledAttributes.recycle();
    }

    public Preference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, g.a(context, R.attr.preferenceStyle, 16842894));
    }

    public Preference(Context context) {
        this(context, (AttributeSet) null);
    }

    public void a(Intent intent) {
        this.o = intent;
    }

    public Intent q() {
        return this.o;
    }

    public String r() {
        return this.p;
    }

    public e s() {
        e eVar = this.c;
        if (eVar != null) {
            return eVar;
        }
        j jVar = this.f978b;
        if (jVar != null) {
            return jVar.b();
        }
        return null;
    }

    public Bundle t() {
        if (this.q == null) {
            this.q = new Bundle();
        }
        return this.q;
    }

    public void a(int i2) {
        this.G = i2;
    }

    public final int u() {
        return this.G;
    }

    public final int v() {
        return this.H;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.preference.l r9) {
        /*
            r8 = this;
            android.view.View r0 = r9.itemView
            android.view.View$OnClickListener r1 = r8.P
            r0.setOnClickListener(r1)
            int r1 = r8.i
            r0.setId(r1)
            r1 = 16908304(0x1020010, float:2.3877274E-38)
            android.view.View r1 = r9.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r2 = 0
            r3 = 0
            r4 = 8
            if (r1 == 0) goto L_0x0037
            java.lang.CharSequence r5 = r8.n()
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x0034
            r1.setText(r5)
            r1.setVisibility(r3)
            int r1 = r1.getCurrentTextColor()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0038
        L_0x0034:
            r1.setVisibility(r4)
        L_0x0037:
            r1 = r2
        L_0x0038:
            r5 = 16908310(0x1020016, float:2.387729E-38)
            android.view.View r5 = r9.a((int) r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0075
            java.lang.CharSequence r6 = r8.x()
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L_0x0072
            r5.setText(r6)
            r5.setVisibility(r3)
            boolean r6 = r8.B
            if (r6 == 0) goto L_0x005c
            boolean r6 = r8.C
            r5.setSingleLine(r6)
        L_0x005c:
            boolean r6 = r8.z()
            if (r6 != 0) goto L_0x0075
            boolean r6 = r8.y()
            if (r6 == 0) goto L_0x0075
            if (r1 == 0) goto L_0x0075
            int r1 = r1.intValue()
            r5.setTextColor(r1)
            goto L_0x0075
        L_0x0072:
            r5.setVisibility(r4)
        L_0x0075:
            r1 = 16908294(0x1020006, float:2.3877246E-38)
            android.view.View r1 = r9.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r5 = 4
            if (r1 == 0) goto L_0x00b0
            int r6 = r8.l
            if (r6 != 0) goto L_0x0089
            android.graphics.drawable.Drawable r6 = r8.m
            if (r6 == 0) goto L_0x009e
        L_0x0089:
            android.graphics.drawable.Drawable r6 = r8.m
            if (r6 != 0) goto L_0x0097
            android.content.Context r6 = r8.f977a
            int r7 = r8.l
            android.graphics.drawable.Drawable r6 = androidx.appcompat.a.a.a.b(r6, r7)
            r8.m = r6
        L_0x0097:
            android.graphics.drawable.Drawable r6 = r8.m
            if (r6 == 0) goto L_0x009e
            r1.setImageDrawable(r6)
        L_0x009e:
            android.graphics.drawable.Drawable r6 = r8.m
            if (r6 == 0) goto L_0x00a6
            r1.setVisibility(r3)
            goto L_0x00b0
        L_0x00a6:
            boolean r6 = r8.D
            if (r6 == 0) goto L_0x00ac
            r6 = r5
            goto L_0x00ad
        L_0x00ac:
            r6 = r4
        L_0x00ad:
            r1.setVisibility(r6)
        L_0x00b0:
            int r1 = androidx.preference.R.id.icon_frame
            android.view.View r1 = r9.a((int) r1)
            if (r1 != 0) goto L_0x00bf
            r1 = 16908350(0x102003e, float:2.3877403E-38)
            android.view.View r1 = r9.a((int) r1)
        L_0x00bf:
            if (r1 == 0) goto L_0x00d1
            android.graphics.drawable.Drawable r6 = r8.m
            if (r6 == 0) goto L_0x00c9
            r1.setVisibility(r3)
            goto L_0x00d1
        L_0x00c9:
            boolean r3 = r8.D
            if (r3 == 0) goto L_0x00ce
            r4 = r5
        L_0x00ce:
            r1.setVisibility(r4)
        L_0x00d1:
            boolean r1 = r8.F
            if (r1 == 0) goto L_0x00dd
            boolean r1 = r8.y()
            r8.a((android.view.View) r0, (boolean) r1)
            goto L_0x00e1
        L_0x00dd:
            r1 = 1
            r8.a((android.view.View) r0, (boolean) r1)
        L_0x00e1:
            boolean r1 = r8.z()
            r0.setFocusable(r1)
            r0.setClickable(r1)
            boolean r3 = r8.z
            r9.a((boolean) r3)
            boolean r3 = r8.A
            r9.b(r3)
            boolean r9 = r8.F()
            if (r9 == 0) goto L_0x0106
            androidx.preference.Preference$d r3 = r8.N
            if (r3 != 0) goto L_0x0106
            androidx.preference.Preference$d r3 = new androidx.preference.Preference$d
            r3.<init>(r8)
            r8.N = r3
        L_0x0106:
            if (r9 == 0) goto L_0x010b
            androidx.preference.Preference$d r3 = r8.N
            goto L_0x010c
        L_0x010b:
            r3 = r2
        L_0x010c:
            r0.setOnCreateContextMenuListener(r3)
            r0.setLongClickable(r9)
            if (r9 == 0) goto L_0x0119
            if (r1 != 0) goto L_0x0119
            androidx.core.g.v.a((android.view.View) r0, (android.graphics.drawable.Drawable) r2)
        L_0x0119:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.Preference.a(androidx.preference.l):void");
    }

    private void a(View view, boolean z2) {
        view.setEnabled(z2);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                a(viewGroup.getChildAt(childCount), z2);
            }
        }
    }

    public void b(int i2) {
        if (i2 != this.h) {
            this.h = i2;
            L();
        }
    }

    public int w() {
        return this.h;
    }

    public void b(CharSequence charSequence) {
        if ((charSequence == null && this.j != null) || (charSequence != null && !charSequence.equals(this.j))) {
            this.j = charSequence;
            i();
        }
    }

    public void c(int i2) {
        b((CharSequence) this.f977a.getString(i2));
    }

    public CharSequence x() {
        return this.j;
    }

    public void a(Drawable drawable) {
        if (this.m != drawable) {
            this.m = drawable;
            this.l = 0;
            i();
        }
    }

    public void d(int i2) {
        a(androidx.appcompat.a.a.a.b(this.f977a, i2));
        this.l = i2;
    }

    public CharSequence n() {
        if (G() != null) {
            return G().a(this);
        }
        return this.k;
    }

    public void a(CharSequence charSequence) {
        if (G() != null) {
            throw new IllegalStateException("Preference already has a SummaryProvider set.");
        } else if (!TextUtils.equals(this.k, charSequence)) {
            this.k = charSequence;
            i();
        }
    }

    public void e(int i2) {
        a((CharSequence) this.f977a.getString(i2));
    }

    public void a(boolean z2) {
        if (this.r != z2) {
            this.r = z2;
            b(j());
            i();
        }
    }

    public boolean y() {
        return this.r && this.w && this.x;
    }

    public boolean z() {
        return this.s;
    }

    public final boolean A() {
        return this.y;
    }

    /* access modifiers changed from: package-private */
    public long c_() {
        return this.d;
    }

    public String B() {
        return this.n;
    }

    public boolean C() {
        return !TextUtils.isEmpty(this.n);
    }

    public boolean D() {
        return this.t;
    }

    /* access modifiers changed from: protected */
    public boolean E() {
        return this.f978b != null && D() && C();
    }

    public boolean F() {
        return this.E;
    }

    public final void a(e eVar) {
        this.O = eVar;
        i();
    }

    public final e G() {
        return this.O;
    }

    public boolean b(Object obj) {
        b bVar = this.f;
        return bVar == null || bVar.onPreferenceChange(this, obj);
    }

    public void a(b bVar) {
        this.f = bVar;
    }

    public b H() {
        return this.f;
    }

    public void a(c cVar) {
        this.g = cVar;
    }

    /* access modifiers changed from: protected */
    public void a(View view) {
        I();
    }

    public void I() {
        j.c h2;
        if (y() && z()) {
            g();
            c cVar = this.g;
            if (cVar == null || !cVar.onPreferenceClick(this)) {
                j M2 = M();
                if ((M2 == null || (h2 = M2.h()) == null || !h2.a(this)) && this.o != null) {
                    J().startActivity(this.o);
                }
            }
        }
    }

    public Context J() {
        return this.f977a;
    }

    public SharedPreferences K() {
        if (this.f978b == null || s() != null) {
            return null;
        }
        return this.f978b.c();
    }

    /* renamed from: a */
    public int compareTo(Preference preference) {
        int i2 = this.h;
        int i3 = preference.h;
        if (i2 != i3) {
            return i2 - i3;
        }
        CharSequence charSequence = this.j;
        CharSequence charSequence2 = preference.j;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.j.toString());
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar) {
        this.I = aVar;
    }

    /* access modifiers changed from: protected */
    public void i() {
        a aVar = this.I;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    /* access modifiers changed from: protected */
    public void L() {
        a aVar = this.I;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public j M() {
        return this.f978b;
    }

    /* access modifiers changed from: protected */
    public void a(j jVar) {
        this.f978b = jVar;
        if (!this.e) {
            this.d = jVar.a();
        }
        d();
    }

    /* access modifiers changed from: protected */
    public void a(j jVar, long j2) {
        this.d = j2;
        this.e = true;
        try {
            a(jVar);
        } finally {
            this.e = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(PreferenceGroup preferenceGroup) {
        if (preferenceGroup == null || this.K == null) {
            this.K = preferenceGroup;
            return;
        }
        throw new IllegalStateException("This preference already has a parent. You must remove the existing parent before assigning a new one.");
    }

    public void N() {
        b();
    }

    public void O() {
        c();
        this.L = true;
    }

    /* access modifiers changed from: package-private */
    public final void P() {
        this.L = false;
    }

    private void b() {
        if (!TextUtils.isEmpty(this.u)) {
            Preference c2 = c(this.u);
            if (c2 != null) {
                c2.b(this);
                return;
            }
            throw new IllegalStateException("Dependency \"" + this.u + "\" not found for preference \"" + this.n + "\" (title: \"" + this.j + "\"");
        }
    }

    private void c() {
        Preference c2;
        String str = this.u;
        if (str != null && (c2 = c(str)) != null) {
            c2.c(this);
        }
    }

    /* access modifiers changed from: protected */
    public <T extends Preference> T c(String str) {
        j jVar = this.f978b;
        if (jVar == null) {
            return null;
        }
        return jVar.a((CharSequence) str);
    }

    private void b(Preference preference) {
        if (this.J == null) {
            this.J = new ArrayList();
        }
        this.J.add(preference);
        preference.a(this, j());
    }

    private void c(Preference preference) {
        List<Preference> list = this.J;
        if (list != null) {
            list.remove(preference);
        }
    }

    public void b(boolean z2) {
        List<Preference> list = this.J;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                list.get(i2).a(this, z2);
            }
        }
    }

    public void a(Preference preference, boolean z2) {
        if (this.w == z2) {
            this.w = !z2;
            b(j());
            i();
        }
    }

    public void b(Preference preference, boolean z2) {
        if (this.x == z2) {
            this.x = !z2;
            b(j());
            i();
        }
    }

    public boolean j() {
        return !y();
    }

    public PreferenceGroup Q() {
        return this.K;
    }

    /* access modifiers changed from: protected */
    public void R() {
        c();
    }

    public void c(Object obj) {
        this.v = obj;
    }

    private void d() {
        if (s() != null) {
            a(true, this.v);
        } else if (!E() || !K().contains(this.n)) {
            Object obj = this.v;
            if (obj != null) {
                a(false, obj);
            }
        } else {
            a(true, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void a(boolean z2, Object obj) {
        a(obj);
    }

    private void a(SharedPreferences.Editor editor) {
        if (this.f978b.f()) {
            editor.apply();
        }
    }

    /* access modifiers changed from: protected */
    public boolean d(String str) {
        if (!E()) {
            return false;
        }
        if (TextUtils.equals(str, e((String) null))) {
            return true;
        }
        e s2 = s();
        if (s2 != null) {
            s2.a(this.n, str);
        } else {
            SharedPreferences.Editor e2 = this.f978b.e();
            e2.putString(this.n, str);
            a(e2);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public String e(String str) {
        if (!E()) {
            return str;
        }
        e s2 = s();
        if (s2 != null) {
            return s2.b(this.n, str);
        }
        return this.f978b.c().getString(this.n, str);
    }

    public boolean b(Set<String> set) {
        if (!E()) {
            return false;
        }
        if (set.equals(c((Set<String>) null))) {
            return true;
        }
        e s2 = s();
        if (s2 != null) {
            s2.a(this.n, set);
        } else {
            SharedPreferences.Editor e2 = this.f978b.e();
            e2.putStringSet(this.n, set);
            a(e2);
        }
        return true;
    }

    public Set<String> c(Set<String> set) {
        if (!E()) {
            return set;
        }
        e s2 = s();
        if (s2 != null) {
            return s2.b(this.n, set);
        }
        return this.f978b.c().getStringSet(this.n, set);
    }

    /* access modifiers changed from: protected */
    public boolean f(int i2) {
        if (!E()) {
            return false;
        }
        if (i2 == g(~i2)) {
            return true;
        }
        e s2 = s();
        if (s2 != null) {
            s2.a(this.n, i2);
        } else {
            SharedPreferences.Editor e2 = this.f978b.e();
            e2.putInt(this.n, i2);
            a(e2);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public int g(int i2) {
        if (!E()) {
            return i2;
        }
        e s2 = s();
        if (s2 != null) {
            return s2.b(this.n, i2);
        }
        return this.f978b.c().getInt(this.n, i2);
    }

    /* access modifiers changed from: protected */
    public boolean c(boolean z2) {
        if (!E()) {
            return false;
        }
        if (z2 == d(!z2)) {
            return true;
        }
        e s2 = s();
        if (s2 != null) {
            s2.a(this.n, z2);
        } else {
            SharedPreferences.Editor e2 = this.f978b.e();
            e2.putBoolean(this.n, z2);
            a(e2);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean d(boolean z2) {
        if (!E()) {
            return z2;
        }
        e s2 = s();
        if (s2 != null) {
            return s2.b(this.n, z2);
        }
        return this.f978b.c().getBoolean(this.n, z2);
    }

    public String toString() {
        return S().toString();
    }

    /* access modifiers changed from: package-private */
    public StringBuilder S() {
        StringBuilder sb = new StringBuilder();
        CharSequence x2 = x();
        if (!TextUtils.isEmpty(x2)) {
            sb.append(x2);
            sb.append(' ');
        }
        CharSequence n2 = n();
        if (!TextUtils.isEmpty(n2)) {
            sb.append(n2);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb;
    }

    public void a(Bundle bundle) {
        b(bundle);
    }

    /* access modifiers changed from: package-private */
    public void b(Bundle bundle) {
        if (C()) {
            this.M = false;
            Parcelable k2 = k();
            if (!this.M) {
                throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
            } else if (k2 != null) {
                bundle.putParcelable(this.n, k2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable k() {
        this.M = true;
        return BaseSavedState.EMPTY_STATE;
    }

    public void c(Bundle bundle) {
        d(bundle);
    }

    /* access modifiers changed from: package-private */
    public void d(Bundle bundle) {
        Parcelable parcelable;
        if (C() && (parcelable = bundle.getParcelable(this.n)) != null) {
            this.M = false;
            a(parcelable);
            if (!this.M) {
                throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(Parcelable parcelable) {
        this.M = true;
        if (parcelable != BaseSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    public static class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new Parcelable.Creator<BaseSavedState>() {
            /* renamed from: a */
            public BaseSavedState createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            /* renamed from: a */
            public BaseSavedState[] newArray(int i) {
                return new BaseSavedState[i];
            }
        };

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        public BaseSavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private static class d implements MenuItem.OnMenuItemClickListener, View.OnCreateContextMenuListener {

        /* renamed from: a  reason: collision with root package name */
        private final Preference f980a;

        d(Preference preference) {
            this.f980a = preference;
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            CharSequence n = this.f980a.n();
            if (this.f980a.F() && !TextUtils.isEmpty(n)) {
                contextMenu.setHeaderTitle(n);
                contextMenu.add(0, 0, 0, R.string.copy).setOnMenuItemClickListener(this);
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            CharSequence n = this.f980a.n();
            ((ClipboardManager) this.f980a.J().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Preference", n));
            Toast.makeText(this.f980a.J(), this.f980a.J().getString(R.string.preference_copied, new Object[]{n}), 0).show();
            return true;
        }
    }
}
