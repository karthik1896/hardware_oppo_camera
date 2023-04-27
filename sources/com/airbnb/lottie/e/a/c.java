package com.airbnb.lottie.e.a;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;

/* compiled from: JsonReader */
public abstract class c implements Closeable {
    private static final String[] g = new String[128];

    /* renamed from: a  reason: collision with root package name */
    int f1742a;

    /* renamed from: b  reason: collision with root package name */
    int[] f1743b = new int[32];
    String[] c = new String[32];
    int[] d = new int[32];
    boolean e;
    boolean f;

    /* compiled from: JsonReader */
    public enum b {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    public abstract int a(a aVar) throws IOException;

    public abstract void a() throws IOException;

    public abstract void b() throws IOException;

    public abstract void c() throws IOException;

    public abstract void d() throws IOException;

    public abstract boolean e() throws IOException;

    public abstract b f() throws IOException;

    public abstract String g() throws IOException;

    public abstract void h() throws IOException;

    public abstract String i() throws IOException;

    public abstract boolean j() throws IOException;

    public abstract double k() throws IOException;

    public abstract int l() throws IOException;

    public abstract void m() throws IOException;

    static {
        for (int i = 0; i <= 31; i++) {
            g[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        String[] strArr = g;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public static c a(BufferedSource bufferedSource) {
        return new e(bufferedSource);
    }

    c() {
    }

    /* access modifiers changed from: package-private */
    public final void a(int i) {
        int i2 = this.f1742a;
        int[] iArr = this.f1743b;
        if (i2 == iArr.length) {
            if (i2 != 256) {
                this.f1743b = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.c;
                this.c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.d;
                this.d = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new a("Nesting too deep at " + n());
            }
        }
        int[] iArr3 = this.f1743b;
        int i3 = this.f1742a;
        this.f1742a = i3 + 1;
        iArr3[i3] = i;
    }

    /* access modifiers changed from: package-private */
    public final b a(String str) throws b {
        throw new b(str + " at path " + n());
    }

    public final String n() {
        return d.a(this.f1742a, this.f1743b, this.c, this.d);
    }

    /* compiled from: JsonReader */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String[] f1744a;

        /* renamed from: b  reason: collision with root package name */
        final Options f1745b;

        private a(String[] strArr, Options options) {
            this.f1744a = strArr;
            this.f1745b = options;
        }

        public static a a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i = 0; i < strArr.length; i++) {
                    c.b(buffer, strArr[i]);
                    buffer.readByte();
                    byteStringArr[i] = buffer.readByteString();
                }
                return new a((String[]) strArr.clone(), Options.of(byteStringArr));
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(BufferedSink bufferedSink, String str) throws IOException {
        String str2;
        String[] strArr = g;
        bufferedSink.writeByte(34);
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i < i2) {
                bufferedSink.writeUtf8(str, i, i2);
            }
            bufferedSink.writeUtf8(str2);
            i = i2 + 1;
        }
        if (i < length) {
            bufferedSink.writeUtf8(str, i, length);
        }
        bufferedSink.writeByte(34);
    }
}
