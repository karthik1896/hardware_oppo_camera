package androidx.core.e;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* compiled from: BidiFormatter */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final d f651a = e.c;

    /* renamed from: b  reason: collision with root package name */
    static final a f652b = new a(false, 2, f651a);
    static final a c = new a(true, 2, f651a);
    private static final String d = Character.toString(8206);
    private static final String e = Character.toString(8207);
    private final boolean f;
    private final int g;
    private final d h;

    /* renamed from: androidx.core.e.a$a  reason: collision with other inner class name */
    /* compiled from: BidiFormatter */
    public static final class C0016a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f653a;

        /* renamed from: b  reason: collision with root package name */
        private int f654b;
        private d c;

        public C0016a() {
            a(a.a(Locale.getDefault()));
        }

        public C0016a(boolean z) {
            a(z);
        }

        private void a(boolean z) {
            this.f653a = z;
            this.c = a.f651a;
            this.f654b = 2;
        }

        private static a b(boolean z) {
            return z ? a.c : a.f652b;
        }

        public a a() {
            if (this.f654b == 2 && this.c == a.f651a) {
                return b(this.f653a);
            }
            return new a(this.f653a, this.f654b, this.c);
        }
    }

    public static a a() {
        return new C0016a().a();
    }

    public static a a(boolean z) {
        return new C0016a(z).a();
    }

    a(boolean z, int i, d dVar) {
        this.f = z;
        this.g = i;
        this.h = dVar;
    }

    public boolean b() {
        return (this.g & 2) != 0;
    }

    private String b(CharSequence charSequence, d dVar) {
        boolean a2 = dVar.a(charSequence, 0, charSequence.length());
        if (!this.f && (a2 || b(charSequence) == 1)) {
            return d;
        }
        if (this.f) {
            return (!a2 || b(charSequence) == -1) ? e : "";
        }
        return "";
    }

    private String c(CharSequence charSequence, d dVar) {
        boolean a2 = dVar.a(charSequence, 0, charSequence.length());
        if (!this.f && (a2 || c(charSequence) == 1)) {
            return d;
        }
        if (this.f) {
            return (!a2 || c(charSequence) == -1) ? e : "";
        }
        return "";
    }

    public String a(String str, d dVar, boolean z) {
        if (str == null) {
            return null;
        }
        return a((CharSequence) str, dVar, z).toString();
    }

    public CharSequence a(CharSequence charSequence, d dVar, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean a2 = dVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (b() && z) {
            spannableStringBuilder.append(c(charSequence, a2 ? e.f666b : e.f665a));
        }
        if (a2 != this.f) {
            spannableStringBuilder.append(a2 ? (char) 8235 : 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append(b(charSequence, a2 ? e.f666b : e.f665a));
        }
        return spannableStringBuilder;
    }

    public CharSequence a(CharSequence charSequence, d dVar) {
        return a(charSequence, dVar, true);
    }

    public String a(String str) {
        return a(str, this.h, true);
    }

    public CharSequence a(CharSequence charSequence) {
        return a(charSequence, this.h, true);
    }

    static boolean a(Locale locale) {
        return f.a(locale) == 1;
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).b();
    }

    private static int c(CharSequence charSequence) {
        return new b(charSequence, false).a();
    }

    /* compiled from: BidiFormatter */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final byte[] f655a = new byte[1792];

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f656b;
        private final boolean c;
        private final int d;
        private int e;
        private char f;

        static {
            for (int i = 0; i < 1792; i++) {
                f655a[i] = Character.getDirectionality(i);
            }
        }

        b(CharSequence charSequence, boolean z) {
            this.f656b = charSequence;
            this.c = z;
            this.d = charSequence.length();
        }

        /* access modifiers changed from: package-private */
        public int a() {
            this.e = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.e < this.d && i == 0) {
                byte c2 = c();
                if (c2 != 0) {
                    if (c2 == 1 || c2 == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (c2 != 9) {
                        switch (c2) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                continue;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                continue;
                            case 18:
                                i3--;
                                i2 = 0;
                                continue;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.e > 0) {
                switch (d()) {
                    case 14:
                    case 15:
                        if (i == i3) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        break;
                    case 18:
                        i3++;
                        continue;
                }
                i3--;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
            r2 = r2 - 1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int b() {
            /*
                r7 = this;
                int r0 = r7.d
                r7.e = r0
                r0 = 0
                r1 = r0
                r2 = r1
            L_0x0007:
                int r3 = r7.e
                if (r3 <= 0) goto L_0x003b
                byte r3 = r7.d()
                r4 = -1
                if (r3 == 0) goto L_0x0034
                r5 = 1
                if (r3 == r5) goto L_0x002e
                r6 = 2
                if (r3 == r6) goto L_0x002e
                r6 = 9
                if (r3 == r6) goto L_0x0007
                switch(r3) {
                    case 14: goto L_0x0028;
                    case 15: goto L_0x0028;
                    case 16: goto L_0x0025;
                    case 17: goto L_0x0025;
                    case 18: goto L_0x0022;
                    default: goto L_0x001f;
                }
            L_0x001f:
                if (r1 != 0) goto L_0x0007
                goto L_0x0039
            L_0x0022:
                int r2 = r2 + 1
                goto L_0x0007
            L_0x0025:
                if (r1 != r2) goto L_0x002b
                return r5
            L_0x0028:
                if (r1 != r2) goto L_0x002b
                return r4
            L_0x002b:
                int r2 = r2 + -1
                goto L_0x0007
            L_0x002e:
                if (r2 != 0) goto L_0x0031
                return r5
            L_0x0031:
                if (r1 != 0) goto L_0x0007
                goto L_0x0039
            L_0x0034:
                if (r2 != 0) goto L_0x0037
                return r4
            L_0x0037:
                if (r1 != 0) goto L_0x0007
            L_0x0039:
                r1 = r2
                goto L_0x0007
            L_0x003b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.e.a.b.b():int");
        }

        private static byte a(char c2) {
            return c2 < 1792 ? f655a[c2] : Character.getDirectionality(c2);
        }

        /* access modifiers changed from: package-private */
        public byte c() {
            this.f = this.f656b.charAt(this.e);
            if (Character.isHighSurrogate(this.f)) {
                int codePointAt = Character.codePointAt(this.f656b, this.e);
                this.e += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.e++;
            byte a2 = a(this.f);
            if (!this.c) {
                return a2;
            }
            char c2 = this.f;
            if (c2 == '<') {
                return e();
            }
            return c2 == '&' ? g() : a2;
        }

        /* access modifiers changed from: package-private */
        public byte d() {
            this.f = this.f656b.charAt(this.e - 1);
            if (Character.isLowSurrogate(this.f)) {
                int codePointBefore = Character.codePointBefore(this.f656b, this.e);
                this.e -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.e--;
            byte a2 = a(this.f);
            if (!this.c) {
                return a2;
            }
            char c2 = this.f;
            if (c2 == '>') {
                return f();
            }
            return c2 == ';' ? h() : a2;
        }

        private byte e() {
            char charAt;
            int i = this.e;
            while (true) {
                int i2 = this.e;
                if (i2 < this.d) {
                    CharSequence charSequence = this.f656b;
                    this.e = i2 + 1;
                    this.f = charSequence.charAt(i2);
                    char c2 = this.f;
                    if (c2 == '>') {
                        return 12;
                    }
                    if (c2 == '\"' || c2 == '\'') {
                        char c3 = this.f;
                        do {
                            int i3 = this.e;
                            if (i3 >= this.d) {
                                break;
                            }
                            CharSequence charSequence2 = this.f656b;
                            this.e = i3 + 1;
                            charAt = charSequence2.charAt(i3);
                            this.f = charAt;
                        } while (charAt != c3);
                    }
                } else {
                    this.e = i;
                    this.f = '<';
                    return 13;
                }
            }
        }

        private byte f() {
            char charAt;
            int i = this.e;
            while (true) {
                int i2 = this.e;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f656b;
                int i3 = i2 - 1;
                this.e = i3;
                this.f = charSequence.charAt(i3);
                char c2 = this.f;
                if (c2 == '<') {
                    return 12;
                }
                if (c2 == '>') {
                    break;
                } else if (c2 == '\"' || c2 == '\'') {
                    char c3 = this.f;
                    do {
                        int i4 = this.e;
                        if (i4 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.f656b;
                        int i5 = i4 - 1;
                        this.e = i5;
                        charAt = charSequence2.charAt(i5);
                        this.f = charAt;
                    } while (charAt != c3);
                }
            }
            this.e = i;
            this.f = '>';
            return 13;
        }

        private byte g() {
            char charAt;
            do {
                int i = this.e;
                if (i >= this.d) {
                    return 12;
                }
                CharSequence charSequence = this.f656b;
                this.e = i + 1;
                charAt = charSequence.charAt(i);
                this.f = charAt;
            } while (charAt != ';');
            return 12;
        }

        private byte h() {
            char c2;
            int i = this.e;
            do {
                int i2 = this.e;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f656b;
                int i3 = i2 - 1;
                this.e = i3;
                this.f = charSequence.charAt(i3);
                c2 = this.f;
                if (c2 == '&') {
                    return 12;
                }
            } while (c2 != ';');
            this.e = i;
            this.f = ';';
            return 13;
        }
    }
}
