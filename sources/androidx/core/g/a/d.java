package androidx.core.g.a;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.R;
import androidx.core.g.a.g;
import com.oppo.exif.OppoExifTag;
import com.sensetime.stmobile.STCommon;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: AccessibilityNodeInfoCompat */
public class d {
    private static int d;

    /* renamed from: a  reason: collision with root package name */
    public int f684a = -1;

    /* renamed from: b  reason: collision with root package name */
    private final AccessibilityNodeInfo f685b;
    private int c = -1;

    private static String d(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case OppoExifTag.EXIF_TAG_SUPER_HIGH_RESOLUTION /*8192*/:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case STCommon.ST_MOBILE_TRACKING_SINGLE_THREAD /*65536*/:
                return "ACTION_CUT";
            case STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_VIDEO /*131072*/:
                return "ACTION_SET_SELECTION";
            case STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE /*262144*/:
                return "ACTION_EXPAND";
            case STMobileHumanActionNative.ST_MOBILE_ENABLE_INPUT_CUSTOM /*524288*/:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            default:
                                return "ACTION_UNKNOWN";
                        }
                }
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    public static class a {
        public static final a A = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, (CharSequence) null, (g) null, (Class<? extends g.a>) null);
        public static final a B = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, (CharSequence) null, (g) null, (Class<? extends g.a>) null);
        public static final a C = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, (CharSequence) null, (g) null, (Class<? extends g.a>) null);
        public static final a D = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, 16908359, (CharSequence) null, (g) null, (Class<? extends g.a>) null);
        public static final a E = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, (CharSequence) null, (g) null, (Class<? extends g.a>) null);
        public static final a F = new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, 16908361, (CharSequence) null, (g) null, (Class<? extends g.a>) null);
        public static final a G = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, 16908348, (CharSequence) null, (g) null, (Class<? extends g.a>) null);
        public static final a H = new a(Build.VERSION.SDK_INT >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, (CharSequence) null, (g) null, g.f.class);
        public static final a I = new a(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, (CharSequence) null, (g) null, g.d.class);
        public static final a J = new a(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, (CharSequence) null, (g) null, (Class<? extends g.a>) null);
        public static final a K;

        /* renamed from: a  reason: collision with root package name */
        public static final a f686a = new a(1, (CharSequence) null);

        /* renamed from: b  reason: collision with root package name */
        public static final a f687b = new a(2, (CharSequence) null);
        public static final a c = new a(4, (CharSequence) null);
        public static final a d = new a(8, (CharSequence) null);
        public static final a e = new a(16, (CharSequence) null);
        public static final a f = new a(32, (CharSequence) null);
        public static final a g = new a(64, (CharSequence) null);
        public static final a h = new a(128, (CharSequence) null);
        public static final a i = new a(256, (CharSequence) null, g.b.class);
        public static final a j = new a(512, (CharSequence) null, g.b.class);
        public static final a k = new a(1024, (CharSequence) null, g.c.class);
        public static final a l = new a(2048, (CharSequence) null, g.c.class);
        public static final a m = new a(4096, (CharSequence) null);
        public static final a n = new a(OppoExifTag.EXIF_TAG_SUPER_HIGH_RESOLUTION, (CharSequence) null);
        public static final a o = new a(16384, (CharSequence) null);
        public static final a p = new a(32768, (CharSequence) null);
        public static final a q = new a(STCommon.ST_MOBILE_TRACKING_SINGLE_THREAD, (CharSequence) null);
        public static final a r = new a(STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_VIDEO, (CharSequence) null, g.C0021g.class);
        public static final a s = new a(STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE, (CharSequence) null);
        public static final a t = new a(STMobileHumanActionNative.ST_MOBILE_ENABLE_INPUT_CUSTOM, (CharSequence) null);
        public static final a u = new a(1048576, (CharSequence) null);
        public static final a v = new a(2097152, (CharSequence) null, g.h.class);
        public static final a w = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, 16908342, (CharSequence) null, (g) null, (Class<? extends g.a>) null);
        public static final a x = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, 16908343, (CharSequence) null, (g) null, g.e.class);
        public static final a y = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, (CharSequence) null, (g) null, (Class<? extends g.a>) null);
        public static final a z = new a(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, (CharSequence) null, (g) null, (Class<? extends g.a>) null);
        final Object L;
        protected final g M;
        private final int N;
        private final Class<? extends g.a> O;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction = null;
            if (Build.VERSION.SDK_INT >= 28) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            }
            K = new a(accessibilityAction, 16908357, (CharSequence) null, (g) null, (Class<? extends g.a>) null);
        }

        public a(int i2, CharSequence charSequence) {
            this((Object) null, i2, charSequence, (g) null, (Class<? extends g.a>) null);
        }

        a(Object obj) {
            this(obj, 0, (CharSequence) null, (g) null, (Class<? extends g.a>) null);
        }

        private a(int i2, CharSequence charSequence, Class<? extends g.a> cls) {
            this((Object) null, i2, charSequence, (g) null, cls);
        }

        a(Object obj, int i2, CharSequence charSequence, g gVar, Class<? extends g.a> cls) {
            this.N = i2;
            this.M = gVar;
            if (Build.VERSION.SDK_INT < 21 || obj != null) {
                this.L = obj;
            } else {
                this.L = new AccessibilityNodeInfo.AccessibilityAction(i2, charSequence);
            }
            this.O = cls;
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.L).getId();
            }
            return 0;
        }

        public CharSequence b() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.L).getLabel();
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0028  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(android.view.View r5, android.os.Bundle r6) {
            /*
                r4 = this;
                androidx.core.g.a.g r0 = r4.M
                r1 = 0
                if (r0 == 0) goto L_0x0049
                r0 = 0
                java.lang.Class<? extends androidx.core.g.a.g$a> r2 = r4.O
                if (r2 == 0) goto L_0x0042
                java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r3)     // Catch:{ Exception -> 0x0020 }
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.Object r1 = r2.newInstance(r1)     // Catch:{ Exception -> 0x0020 }
                androidx.core.g.a.g$a r1 = (androidx.core.g.a.g.a) r1     // Catch:{ Exception -> 0x0020 }
                r1.a(r6)     // Catch:{ Exception -> 0x001d }
                r0 = r1
                goto L_0x0042
            L_0x001d:
                r6 = move-exception
                r0 = r1
                goto L_0x0021
            L_0x0020:
                r6 = move-exception
            L_0x0021:
                java.lang.Class<? extends androidx.core.g.a.g$a> r1 = r4.O
                if (r1 != 0) goto L_0x0028
                java.lang.String r1 = "null"
                goto L_0x002c
            L_0x0028:
                java.lang.String r1 = r1.getName()
            L_0x002c:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Failed to execute command with argument class ViewCommandArgument: "
                r2.append(r3)
                r2.append(r1)
                java.lang.String r1 = r2.toString()
                java.lang.String r2 = "A11yActionCompat"
                android.util.Log.e(r2, r1, r6)
            L_0x0042:
                androidx.core.g.a.g r6 = r4.M
                boolean r5 = r6.perform(r5, r0)
                return r5
            L_0x0049:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.g.a.d.a.a(android.view.View, android.os.Bundle):boolean");
        }

        public a a(CharSequence charSequence, g gVar) {
            return new a((Object) null, this.N, charSequence, gVar, this.O);
        }

        public int hashCode() {
            Object obj = this.L;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.L;
            if (obj2 == null) {
                if (aVar.L != null) {
                    return false;
                }
                return true;
            } else if (!obj2.equals(aVar.L)) {
                return false;
            } else {
                return true;
            }
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final Object f688a;

        public static b a(int i, int i2, boolean z, int i3) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
            }
            return new b((Object) null);
        }

        public static b a(int i, int i2, boolean z) {
            if (Build.VERSION.SDK_INT >= 19) {
                return new b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
            }
            return new b((Object) null);
        }

        b(Object obj) {
            this.f688a = obj;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final Object f689a;

        public static c a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new c((Object) null);
        }

        c(Object obj) {
            this.f689a = obj;
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f689a).getColumnIndex();
            }
            return 0;
        }

        public int b() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f689a).getColumnSpan();
            }
            return 0;
        }

        public int c() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f689a).getRowIndex();
            }
            return 0;
        }

        public int d() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f689a).getRowSpan();
            }
            return 0;
        }

        public boolean e() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f689a).isSelected();
            }
            return false;
        }
    }

    /* renamed from: androidx.core.g.a.d$d  reason: collision with other inner class name */
    /* compiled from: AccessibilityNodeInfoCompat */
    public static class C0020d {

        /* renamed from: a  reason: collision with root package name */
        final Object f690a;

        public static C0020d a(int i, float f, float f2, float f3) {
            if (Build.VERSION.SDK_INT >= 19) {
                return new C0020d(AccessibilityNodeInfo.RangeInfo.obtain(i, f, f2, f3));
            }
            return new C0020d((Object) null);
        }

        C0020d(Object obj) {
            this.f690a = obj;
        }
    }

    private d(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f685b = accessibilityNodeInfo;
    }

    public static d a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new d(accessibilityNodeInfo);
    }

    public AccessibilityNodeInfo a() {
        return this.f685b;
    }

    public static d a(View view) {
        return a(AccessibilityNodeInfo.obtain(view));
    }

    public static d b() {
        return a(AccessibilityNodeInfo.obtain());
    }

    public static d a(d dVar) {
        return a(AccessibilityNodeInfo.obtain(dVar.f685b));
    }

    public void a(View view, int i) {
        this.c = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f685b.setSource(view, i);
        }
    }

    public int c() {
        return this.f685b.getChildCount();
    }

    public void b(View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f685b.addChild(view, i);
        }
    }

    public int d() {
        return this.f685b.getActions();
    }

    public void a(int i) {
        this.f685b.addAction(i);
    }

    private List<Integer> a(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.f685b.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList arrayList = new ArrayList();
        this.f685b.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public void a(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f685b.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.L);
        }
    }

    public boolean b(a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f685b.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.L);
        }
        return false;
    }

    public boolean a(int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.f685b.performAction(i, bundle);
        }
        return false;
    }

    public void b(View view) {
        this.f684a = -1;
        this.f685b.setParent(view);
    }

    public void c(View view, int i) {
        this.f684a = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.f685b.setParent(view, i);
        }
    }

    @Deprecated
    public void a(Rect rect) {
        this.f685b.getBoundsInParent(rect);
    }

    @Deprecated
    public void b(Rect rect) {
        this.f685b.setBoundsInParent(rect);
    }

    public void c(Rect rect) {
        this.f685b.getBoundsInScreen(rect);
    }

    public void d(Rect rect) {
        this.f685b.setBoundsInScreen(rect);
    }

    public boolean e() {
        return this.f685b.isCheckable();
    }

    public void a(boolean z) {
        this.f685b.setCheckable(z);
    }

    public boolean f() {
        return this.f685b.isChecked();
    }

    public void b(boolean z) {
        this.f685b.setChecked(z);
    }

    public boolean g() {
        return this.f685b.isFocusable();
    }

    public void c(boolean z) {
        this.f685b.setFocusable(z);
    }

    public boolean h() {
        return this.f685b.isFocused();
    }

    public void d(boolean z) {
        this.f685b.setFocused(z);
    }

    public void e(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f685b.setVisibleToUser(z);
        }
    }

    public void f(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f685b.setAccessibilityFocused(z);
        }
    }

    public boolean i() {
        return this.f685b.isSelected();
    }

    public void g(boolean z) {
        this.f685b.setSelected(z);
    }

    public boolean j() {
        return this.f685b.isClickable();
    }

    public void h(boolean z) {
        this.f685b.setClickable(z);
    }

    public boolean k() {
        return this.f685b.isLongClickable();
    }

    public boolean l() {
        return this.f685b.isEnabled();
    }

    public void i(boolean z) {
        this.f685b.setEnabled(z);
    }

    public boolean m() {
        return this.f685b.isPassword();
    }

    public boolean n() {
        return this.f685b.isScrollable();
    }

    public void j(boolean z) {
        this.f685b.setScrollable(z);
    }

    public CharSequence o() {
        return this.f685b.getPackageName();
    }

    public void a(CharSequence charSequence) {
        this.f685b.setPackageName(charSequence);
    }

    public CharSequence p() {
        return this.f685b.getClassName();
    }

    public void b(CharSequence charSequence) {
        this.f685b.setClassName(charSequence);
    }

    public CharSequence q() {
        if (!y()) {
            return this.f685b.getText();
        }
        List<Integer> a2 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List<Integer> a3 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List<Integer> a4 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List<Integer> a5 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f685b.getText(), 0, this.f685b.getText().length()));
        for (int i = 0; i < a2.size(); i++) {
            spannableString.setSpan(new a(a5.get(i).intValue(), this, w().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), a2.get(i).intValue(), a3.get(i).intValue(), a4.get(i).intValue());
        }
        return spannableString;
    }

    public void c(CharSequence charSequence) {
        this.f685b.setText(charSequence);
    }

    public void a(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 26) {
            z();
            e(view);
            ClickableSpan[] d2 = d(charSequence);
            if (d2 != null && d2.length > 0) {
                w().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R.id.accessibility_action_clickable_span);
                SparseArray<WeakReference<ClickableSpan>> c2 = c(view);
                int i = 0;
                while (d2 != null && i < d2.length) {
                    int a2 = a(d2[i], c2);
                    c2.put(a2, new WeakReference(d2[i]));
                    a(d2[i], (Spanned) charSequence, a2);
                    i++;
                }
            }
        }
    }

    private SparseArray<WeakReference<ClickableSpan>> c(View view) {
        SparseArray<WeakReference<ClickableSpan>> d2 = d(view);
        if (d2 != null) {
            return d2;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(R.id.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> d(View view) {
        return (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
    }

    public static ClickableSpan[] d(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private int a(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                if (clickableSpan.equals((ClickableSpan) sparseArray.valueAt(i).get())) {
                    return sparseArray.keyAt(i);
                }
            }
        }
        int i2 = d;
        d = i2 + 1;
        return i2;
    }

    private boolean y() {
        return !a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private void z() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f685b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.f685b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.f685b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.f685b.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    private void a(ClickableSpan clickableSpan, Spanned spanned, int i) {
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
    }

    private void e(View view) {
        SparseArray<WeakReference<ClickableSpan>> d2 = d(view);
        if (d2 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < d2.size(); i++) {
                if (d2.valueAt(i).get() == null) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d2.remove(((Integer) arrayList.get(i2)).intValue());
            }
        }
    }

    public CharSequence r() {
        return this.f685b.getContentDescription();
    }

    public void e(CharSequence charSequence) {
        this.f685b.setContentDescription(charSequence);
    }

    public void s() {
        this.f685b.recycle();
    }

    public String t() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f685b.getViewIdResourceName();
        }
        return null;
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f685b.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).f688a);
        }
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f685b.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).f689a);
        }
    }

    public c u() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        if (Build.VERSION.SDK_INT < 19 || (collectionItemInfo = this.f685b.getCollectionItemInfo()) == null) {
            return null;
        }
        return new c(collectionItemInfo);
    }

    public void a(C0020d dVar) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f685b.setRangeInfo((AccessibilityNodeInfo.RangeInfo) dVar.f690a);
        }
    }

    public List<a> v() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.f685b.getActionList() : null;
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new a(actionList.get(i)));
        }
        return arrayList;
    }

    public void f(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f685b.setHintText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f685b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public void g(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f685b.setError(charSequence);
        }
    }

    public Bundle w() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.f685b.getExtras();
        }
        return new Bundle();
    }

    public void b(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f685b.setMaxTextLength(i);
        }
    }

    public void k(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f685b.setDismissable(z);
        }
    }

    public void h(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f685b.setPaneTitle(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.f685b.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void l(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f685b.setScreenReaderFocusable(z);
        } else {
            a(1, z);
        }
    }

    public boolean x() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f685b.isShowingHintText();
        }
        return c(4);
    }

    public void m(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f685b.setShowingHintText(z);
        } else {
            a(4, z);
        }
    }

    public void n(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f685b.setHeading(z);
        } else {
            a(2, z);
        }
    }

    public void i(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f685b.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f685b;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f685b;
        if (accessibilityNodeInfo == null) {
            if (dVar.f685b != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(dVar.f685b)) {
            return false;
        }
        return this.c == dVar.c && this.f684a == dVar.f684a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        sb.append("; boundsInParent: " + rect);
        c(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(o());
        sb.append("; className: ");
        sb.append(p());
        sb.append("; text: ");
        sb.append(q());
        sb.append("; contentDescription: ");
        sb.append(r());
        sb.append("; viewId: ");
        sb.append(t());
        sb.append("; checkable: ");
        sb.append(e());
        sb.append("; checked: ");
        sb.append(f());
        sb.append("; focusable: ");
        sb.append(g());
        sb.append("; focused: ");
        sb.append(h());
        sb.append("; selected: ");
        sb.append(i());
        sb.append("; clickable: ");
        sb.append(j());
        sb.append("; longClickable: ");
        sb.append(k());
        sb.append("; enabled: ");
        sb.append(l());
        sb.append("; password: ");
        sb.append(m());
        sb.append("; scrollable: " + n());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<a> v = v();
            for (int i = 0; i < v.size(); i++) {
                a aVar = v.get(i);
                String d2 = d(aVar.a());
                if (d2.equals("ACTION_UNKNOWN") && aVar.b() != null) {
                    d2 = aVar.b().toString();
                }
                sb.append(d2);
                if (i != v.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int d3 = d();
            while (d3 != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(d3);
                d3 &= ~numberOfTrailingZeros;
                sb.append(d(numberOfTrailingZeros));
                if (d3 != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void a(int i, boolean z) {
        Bundle w = w();
        if (w != null) {
            int i2 = w.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i);
            if (!z) {
                i = 0;
            }
            w.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }

    private boolean c(int i) {
        Bundle w = w();
        if (w != null && (w.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i) == i) {
            return true;
        }
        return false;
    }
}
