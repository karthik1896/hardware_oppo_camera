package androidx.core.e;

import java.util.Locale;

/* compiled from: TextDirectionHeuristicsCompat */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final d f665a = new C0018e((c) null, false);

    /* renamed from: b  reason: collision with root package name */
    public static final d f666b = new C0018e((c) null, true);
    public static final d c = new C0018e(b.f669a, false);
    public static final d d = new C0018e(b.f669a, true);
    public static final d e = new C0018e(a.f667a, false);
    public static final d f = f.f672a;

    /* compiled from: TextDirectionHeuristicsCompat */
    private interface c {
        int a(CharSequence charSequence, int i, int i2);
    }

    static int a(int i) {
        if (i != 0) {
            return (i == 1 || i == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    private static abstract class d implements d {

        /* renamed from: a  reason: collision with root package name */
        private final c f670a;

        /* access modifiers changed from: protected */
        public abstract boolean a();

        d(c cVar) {
            this.f670a = cVar;
        }

        public boolean a(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            } else if (this.f670a == null) {
                return a();
            } else {
                return b(charSequence, i, i2);
            }
        }

        private boolean b(CharSequence charSequence, int i, int i2) {
            int a2 = this.f670a.a(charSequence, i, i2);
            if (a2 == 0) {
                return true;
            }
            if (a2 != 1) {
                return a();
            }
            return false;
        }
    }

    /* renamed from: androidx.core.e.e$e  reason: collision with other inner class name */
    /* compiled from: TextDirectionHeuristicsCompat */
    private static class C0018e extends d {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f671a;

        C0018e(c cVar, boolean z) {
            super(cVar);
            this.f671a = z;
        }

        /* access modifiers changed from: protected */
        public boolean a() {
            return this.f671a;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    private static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        static final b f669a = new b();

        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = e.b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }

        private b() {
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    private static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        static final a f667a = new a(true);

        /* renamed from: b  reason: collision with root package name */
        private final boolean f668b;

        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                int a2 = e.a(Character.getDirectionality(charSequence.charAt(i)));
                if (a2 != 0) {
                    if (a2 != 1) {
                        continue;
                        i++;
                    } else if (!this.f668b) {
                        return 1;
                    }
                } else if (this.f668b) {
                    return 0;
                }
                z = true;
                i++;
            }
            if (z) {
                return this.f668b ? 1 : 0;
            }
            return 2;
        }

        private a(boolean z) {
            this.f668b = z;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    private static class f extends d {

        /* renamed from: a  reason: collision with root package name */
        static final f f672a = new f();

        f() {
            super((c) null);
        }

        /* access modifiers changed from: protected */
        public boolean a() {
            return f.a(Locale.getDefault()) == 1;
        }
    }
}
