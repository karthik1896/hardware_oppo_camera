package com.airbnb.lottie.e.a;

import com.airbnb.lottie.e.a.c;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* compiled from: JsonUtf8Reader */
final class e extends c {
    private static final ByteString g = ByteString.encodeUtf8("'\\");
    private static final ByteString h = ByteString.encodeUtf8("\"\\");
    private static final ByteString i = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    private static final ByteString j = ByteString.encodeUtf8("\n\r");
    private static final ByteString k = ByteString.encodeUtf8("*/");
    private final BufferedSource l;
    private final Buffer m;
    private int n = 0;
    private long o;
    private int p;
    private String q;

    e(BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            this.l = bufferedSource;
            this.m = bufferedSource.getBuffer();
            a(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    public void a() throws IOException {
        int i2 = this.n;
        if (i2 == 0) {
            i2 = o();
        }
        if (i2 == 3) {
            a(1);
            this.d[this.f1742a - 1] = 0;
            this.n = 0;
            return;
        }
        throw new a("Expected BEGIN_ARRAY but was " + f() + " at path " + n());
    }

    public void b() throws IOException {
        int i2 = this.n;
        if (i2 == 0) {
            i2 = o();
        }
        if (i2 == 4) {
            this.f1742a--;
            int[] iArr = this.d;
            int i3 = this.f1742a - 1;
            iArr[i3] = iArr[i3] + 1;
            this.n = 0;
            return;
        }
        throw new a("Expected END_ARRAY but was " + f() + " at path " + n());
    }

    public void c() throws IOException {
        int i2 = this.n;
        if (i2 == 0) {
            i2 = o();
        }
        if (i2 == 1) {
            a(3);
            this.n = 0;
            return;
        }
        throw new a("Expected BEGIN_OBJECT but was " + f() + " at path " + n());
    }

    public void d() throws IOException {
        int i2 = this.n;
        if (i2 == 0) {
            i2 = o();
        }
        if (i2 == 2) {
            this.f1742a--;
            this.c[this.f1742a] = null;
            int[] iArr = this.d;
            int i3 = this.f1742a - 1;
            iArr[i3] = iArr[i3] + 1;
            this.n = 0;
            return;
        }
        throw new a("Expected END_OBJECT but was " + f() + " at path " + n());
    }

    public boolean e() throws IOException {
        int i2 = this.n;
        if (i2 == 0) {
            i2 = o();
        }
        return (i2 == 2 || i2 == 4 || i2 == 18) ? false : true;
    }

    public c.b f() throws IOException {
        int i2 = this.n;
        if (i2 == 0) {
            i2 = o();
        }
        switch (i2) {
            case 1:
                return c.b.BEGIN_OBJECT;
            case 2:
                return c.b.END_OBJECT;
            case 3:
                return c.b.BEGIN_ARRAY;
            case 4:
                return c.b.END_ARRAY;
            case 5:
            case 6:
                return c.b.BOOLEAN;
            case 7:
                return c.b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return c.b.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return c.b.NAME;
            case 16:
            case 17:
                return c.b.NUMBER;
            case 18:
                return c.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    private int o() throws IOException {
        int i2 = this.f1743b[this.f1742a - 1];
        if (i2 == 1) {
            this.f1743b[this.f1742a - 1] = 2;
        } else if (i2 == 2) {
            int a2 = a(true);
            this.m.readByte();
            if (a2 != 44) {
                if (a2 == 59) {
                    t();
                } else if (a2 == 93) {
                    this.n = 4;
                    return 4;
                } else {
                    throw a("Unterminated array");
                }
            }
        } else if (i2 == 3 || i2 == 5) {
            this.f1743b[this.f1742a - 1] = 4;
            if (i2 == 5) {
                int a3 = a(true);
                this.m.readByte();
                if (a3 != 44) {
                    if (a3 == 59) {
                        t();
                    } else if (a3 == 125) {
                        this.n = 2;
                        return 2;
                    } else {
                        throw a("Unterminated object");
                    }
                }
            }
            int a4 = a(true);
            if (a4 == 34) {
                this.m.readByte();
                this.n = 13;
                return 13;
            } else if (a4 == 39) {
                this.m.readByte();
                t();
                this.n = 12;
                return 12;
            } else if (a4 != 125) {
                t();
                if (b((int) (char) a4)) {
                    this.n = 14;
                    return 14;
                }
                throw a("Expected name");
            } else if (i2 != 5) {
                this.m.readByte();
                this.n = 2;
                return 2;
            } else {
                throw a("Expected name");
            }
        } else if (i2 == 4) {
            this.f1743b[this.f1742a - 1] = 5;
            int a5 = a(true);
            this.m.readByte();
            if (a5 != 58) {
                if (a5 == 61) {
                    t();
                    if (this.l.request(1) && this.m.getByte(0) == 62) {
                        this.m.readByte();
                    }
                } else {
                    throw a("Expected ':'");
                }
            }
        } else if (i2 == 6) {
            this.f1743b[this.f1742a - 1] = 7;
        } else if (i2 == 7) {
            if (a(false) == -1) {
                this.n = 18;
                return 18;
            }
            t();
        } else if (i2 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int a6 = a(true);
        if (a6 == 34) {
            this.m.readByte();
            this.n = 9;
            return 9;
        } else if (a6 != 39) {
            if (!(a6 == 44 || a6 == 59)) {
                if (a6 == 91) {
                    this.m.readByte();
                    this.n = 3;
                    return 3;
                } else if (a6 != 93) {
                    if (a6 != 123) {
                        int p2 = p();
                        if (p2 != 0) {
                            return p2;
                        }
                        int q2 = q();
                        if (q2 != 0) {
                            return q2;
                        }
                        if (b((int) this.m.getByte(0))) {
                            t();
                            this.n = 10;
                            return 10;
                        }
                        throw a("Expected value");
                    }
                    this.m.readByte();
                    this.n = 1;
                    return 1;
                } else if (i2 == 1) {
                    this.m.readByte();
                    this.n = 4;
                    return 4;
                }
            }
            if (i2 == 1 || i2 == 2) {
                t();
                this.n = 7;
                return 7;
            }
            throw a("Unexpected value");
        } else {
            t();
            this.m.readByte();
            this.n = 8;
            return 8;
        }
    }

    private int p() throws IOException {
        String str;
        String str2;
        int i2;
        byte b2 = this.m.getByte(0);
        if (b2 == 116 || b2 == 84) {
            i2 = 5;
            str2 = "true";
            str = "TRUE";
        } else if (b2 == 102 || b2 == 70) {
            i2 = 6;
            str2 = "false";
            str = "FALSE";
        } else if (b2 != 110 && b2 != 78) {
            return 0;
        } else {
            i2 = 7;
            str2 = "null";
            str = "NULL";
        }
        int length = str2.length();
        int i3 = 1;
        while (i3 < length) {
            int i4 = i3 + 1;
            if (!this.l.request((long) i4)) {
                return 0;
            }
            byte b3 = this.m.getByte((long) i3);
            if (b3 != str2.charAt(i3) && b3 != str.charAt(i3)) {
                return 0;
            }
            i3 = i4;
        }
        if (this.l.request((long) (length + 1)) && b((int) this.m.getByte((long) length))) {
            return 0;
        }
        this.m.skip((long) length);
        this.n = i2;
        return i2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int q() throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = 0
            r3 = 1
            r4 = 0
            r8 = r1
            r7 = r3
            r5 = r4
            r6 = r5
            r10 = r6
        L_0x000b:
            okio.BufferedSource r11 = r0.l
            int r12 = r5 + 1
            long r13 = (long) r12
            boolean r11 = r11.request(r13)
            r15 = 2
            if (r11 != 0) goto L_0x0019
            goto L_0x0086
        L_0x0019:
            okio.Buffer r11 = r0.m
            long r13 = (long) r5
            byte r11 = r11.getByte(r13)
            r13 = 43
            r14 = 5
            if (r11 == r13) goto L_0x00d5
            r13 = 69
            if (r11 == r13) goto L_0x00cc
            r13 = 101(0x65, float:1.42E-43)
            if (r11 == r13) goto L_0x00cc
            r13 = 45
            if (r11 == r13) goto L_0x00c2
            r13 = 46
            if (r11 == r13) goto L_0x00bd
            r13 = 48
            if (r11 < r13) goto L_0x0080
            r13 = 57
            if (r11 <= r13) goto L_0x003e
            goto L_0x0080
        L_0x003e:
            if (r6 == r3) goto L_0x0078
            if (r6 != 0) goto L_0x0043
            goto L_0x0078
        L_0x0043:
            if (r6 != r15) goto L_0x0068
            int r5 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x004a
            return r4
        L_0x004a:
            r13 = 10
            long r13 = r13 * r8
            int r11 = r11 + -48
            long r3 = (long) r11
            long r13 = r13 - r3
            r3 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x0063
            if (r3 != 0) goto L_0x0061
            int r3 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r3 = 0
            goto L_0x0064
        L_0x0063:
            r3 = 1
        L_0x0064:
            r3 = r3 & r7
            r7 = r3
            r8 = r13
            goto L_0x007e
        L_0x0068:
            r3 = 3
            if (r6 != r3) goto L_0x006f
            r4 = 0
            r6 = 4
            goto L_0x00d9
        L_0x006f:
            if (r6 == r14) goto L_0x0074
            r3 = 6
            if (r6 != r3) goto L_0x007e
        L_0x0074:
            r4 = 0
            r6 = 7
            goto L_0x00d9
        L_0x0078:
            int r11 = r11 + -48
            int r3 = -r11
            long r3 = (long) r3
            r8 = r3
            r6 = r15
        L_0x007e:
            r4 = 0
            goto L_0x00d9
        L_0x0080:
            boolean r3 = r0.b((int) r11)
            if (r3 != 0) goto L_0x00bb
        L_0x0086:
            if (r6 != r15) goto L_0x00a9
            if (r7 == 0) goto L_0x00a9
            r3 = -9223372036854775808
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x0092
            if (r10 == 0) goto L_0x00a9
        L_0x0092:
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0098
            if (r10 != 0) goto L_0x00a9
        L_0x0098:
            if (r10 == 0) goto L_0x009b
            goto L_0x009c
        L_0x009b:
            long r8 = -r8
        L_0x009c:
            r0.o = r8
            okio.Buffer r1 = r0.m
            long r2 = (long) r5
            r1.skip(r2)
            r1 = 16
            r0.n = r1
            return r1
        L_0x00a9:
            if (r6 == r15) goto L_0x00b4
            r1 = 4
            if (r6 == r1) goto L_0x00b4
            r1 = 7
            if (r6 != r1) goto L_0x00b2
            goto L_0x00b4
        L_0x00b2:
            r4 = 0
            return r4
        L_0x00b4:
            r0.p = r5
            r1 = 17
            r0.n = r1
            return r1
        L_0x00bb:
            r4 = 0
            return r4
        L_0x00bd:
            r3 = 3
            if (r6 != r15) goto L_0x00c1
            goto L_0x00d8
        L_0x00c1:
            return r4
        L_0x00c2:
            r3 = 6
            if (r6 != 0) goto L_0x00c8
            r6 = 1
            r10 = 1
            goto L_0x00d9
        L_0x00c8:
            if (r6 != r14) goto L_0x00cb
            goto L_0x00d8
        L_0x00cb:
            return r4
        L_0x00cc:
            if (r6 == r15) goto L_0x00d3
            r3 = 4
            if (r6 != r3) goto L_0x00d2
            goto L_0x00d3
        L_0x00d2:
            return r4
        L_0x00d3:
            r6 = r14
            goto L_0x00d9
        L_0x00d5:
            r3 = 6
            if (r6 != r14) goto L_0x00dd
        L_0x00d8:
            r6 = r3
        L_0x00d9:
            r5 = r12
            r3 = 1
            goto L_0x000b
        L_0x00dd:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.e.a.e.q():int");
    }

    private boolean b(int i2) throws IOException {
        if (i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 32) {
            return false;
        }
        if (i2 != 35) {
            if (i2 == 44) {
                return false;
            }
            if (!(i2 == 47 || i2 == 61)) {
                if (i2 == 123 || i2 == 125 || i2 == 58) {
                    return false;
                }
                if (i2 != 59) {
                    switch (i2) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        t();
        return false;
    }

    public String g() throws IOException {
        String str;
        int i2 = this.n;
        if (i2 == 0) {
            i2 = o();
        }
        if (i2 == 14) {
            str = r();
        } else if (i2 == 13) {
            str = a(h);
        } else if (i2 == 12) {
            str = a(g);
        } else if (i2 == 15) {
            str = this.q;
        } else {
            throw new a("Expected a name but was " + f() + " at path " + n());
        }
        this.n = 0;
        this.c[this.f1742a - 1] = str;
        return str;
    }

    public int a(c.a aVar) throws IOException {
        int i2 = this.n;
        if (i2 == 0) {
            i2 = o();
        }
        if (i2 < 12 || i2 > 15) {
            return -1;
        }
        if (i2 == 15) {
            return a(this.q, aVar);
        }
        int select = this.l.select(aVar.f1745b);
        if (select != -1) {
            this.n = 0;
            this.c[this.f1742a - 1] = aVar.f1744a[select];
            return select;
        }
        String str = this.c[this.f1742a - 1];
        String g2 = g();
        int a2 = a(g2, aVar);
        if (a2 == -1) {
            this.n = 15;
            this.q = g2;
            this.c[this.f1742a - 1] = str;
        }
        return a2;
    }

    public void h() throws IOException {
        if (!this.f) {
            int i2 = this.n;
            if (i2 == 0) {
                i2 = o();
            }
            if (i2 == 14) {
                s();
            } else if (i2 == 13) {
                b(h);
            } else if (i2 == 12) {
                b(g);
            } else if (i2 != 15) {
                throw new a("Expected a name but was " + f() + " at path " + n());
            }
            this.n = 0;
            this.c[this.f1742a - 1] = "null";
            return;
        }
        throw new a("Cannot skip unexpected " + f() + " at " + n());
    }

    private int a(String str, c.a aVar) {
        int length = aVar.f1744a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(aVar.f1744a[i2])) {
                this.n = 0;
                this.c[this.f1742a - 1] = str;
                return i2;
            }
        }
        return -1;
    }

    public String i() throws IOException {
        String str;
        int i2 = this.n;
        if (i2 == 0) {
            i2 = o();
        }
        if (i2 == 10) {
            str = r();
        } else if (i2 == 9) {
            str = a(h);
        } else if (i2 == 8) {
            str = a(g);
        } else if (i2 == 11) {
            str = this.q;
            this.q = null;
        } else if (i2 == 16) {
            str = Long.toString(this.o);
        } else if (i2 == 17) {
            str = this.m.readUtf8((long) this.p);
        } else {
            throw new a("Expected a string but was " + f() + " at path " + n());
        }
        this.n = 0;
        int[] iArr = this.d;
        int i3 = this.f1742a - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    public boolean j() throws IOException {
        int i2 = this.n;
        if (i2 == 0) {
            i2 = o();
        }
        if (i2 == 5) {
            this.n = 0;
            int[] iArr = this.d;
            int i3 = this.f1742a - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        } else if (i2 == 6) {
            this.n = 0;
            int[] iArr2 = this.d;
            int i4 = this.f1742a - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        } else {
            throw new a("Expected a boolean but was " + f() + " at path " + n());
        }
    }

    public double k() throws IOException {
        int i2 = this.n;
        if (i2 == 0) {
            i2 = o();
        }
        if (i2 == 16) {
            this.n = 0;
            int[] iArr = this.d;
            int i3 = this.f1742a - 1;
            iArr[i3] = iArr[i3] + 1;
            return (double) this.o;
        }
        if (i2 == 17) {
            this.q = this.m.readUtf8((long) this.p);
        } else if (i2 == 9) {
            this.q = a(h);
        } else if (i2 == 8) {
            this.q = a(g);
        } else if (i2 == 10) {
            this.q = r();
        } else if (i2 != 11) {
            throw new a("Expected a double but was " + f() + " at path " + n());
        }
        this.n = 11;
        try {
            double parseDouble = Double.parseDouble(this.q);
            if (this.e || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
                this.q = null;
                this.n = 0;
                int[] iArr2 = this.d;
                int i4 = this.f1742a - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseDouble;
            }
            throw new b("JSON forbids NaN and infinities: " + parseDouble + " at path " + n());
        } catch (NumberFormatException unused) {
            throw new a("Expected a double but was " + this.q + " at path " + n());
        }
    }

    private String a(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long indexOfElement = this.l.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw a("Unterminated string");
            } else if (this.m.getByte(indexOfElement) == 92) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.m.readUtf8(indexOfElement));
                this.m.readByte();
                sb.append(w());
            } else if (sb == null) {
                String readUtf8 = this.m.readUtf8(indexOfElement);
                this.m.readByte();
                return readUtf8;
            } else {
                sb.append(this.m.readUtf8(indexOfElement));
                this.m.readByte();
                return sb.toString();
            }
        }
    }

    private String r() throws IOException {
        long indexOfElement = this.l.indexOfElement(i);
        return indexOfElement != -1 ? this.m.readUtf8(indexOfElement) : this.m.readUtf8();
    }

    private void b(ByteString byteString) throws IOException {
        while (true) {
            long indexOfElement = this.l.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw a("Unterminated string");
            } else if (this.m.getByte(indexOfElement) == 92) {
                this.m.skip(indexOfElement + 1);
                w();
            } else {
                this.m.skip(indexOfElement + 1);
                return;
            }
        }
    }

    private void s() throws IOException {
        long indexOfElement = this.l.indexOfElement(i);
        Buffer buffer = this.m;
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        buffer.skip(indexOfElement);
    }

    public int l() throws IOException {
        String str;
        int i2 = this.n;
        if (i2 == 0) {
            i2 = o();
        }
        if (i2 == 16) {
            long j2 = this.o;
            int i3 = (int) j2;
            if (j2 == ((long) i3)) {
                this.n = 0;
                int[] iArr = this.d;
                int i4 = this.f1742a - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new a("Expected an int but was " + this.o + " at path " + n());
        }
        if (i2 == 17) {
            this.q = this.m.readUtf8((long) this.p);
        } else if (i2 == 9 || i2 == 8) {
            if (i2 == 9) {
                str = a(h);
            } else {
                str = a(g);
            }
            this.q = str;
            try {
                int parseInt = Integer.parseInt(this.q);
                this.n = 0;
                int[] iArr2 = this.d;
                int i5 = this.f1742a - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i2 != 11) {
            throw new a("Expected an int but was " + f() + " at path " + n());
        }
        this.n = 11;
        try {
            double parseDouble = Double.parseDouble(this.q);
            int i6 = (int) parseDouble;
            if (((double) i6) == parseDouble) {
                this.q = null;
                this.n = 0;
                int[] iArr3 = this.d;
                int i7 = this.f1742a - 1;
                iArr3[i7] = iArr3[i7] + 1;
                return i6;
            }
            throw new a("Expected an int but was " + this.q + " at path " + n());
        } catch (NumberFormatException unused2) {
            throw new a("Expected an int but was " + this.q + " at path " + n());
        }
    }

    public void close() throws IOException {
        this.n = 0;
        this.f1743b[0] = 8;
        this.f1742a = 1;
        this.m.clear();
        this.l.close();
    }

    public void m() throws IOException {
        if (!this.f) {
            int i2 = 0;
            do {
                int i3 = this.n;
                if (i3 == 0) {
                    i3 = o();
                }
                if (i3 == 3) {
                    a(1);
                } else if (i3 == 1) {
                    a(3);
                } else {
                    if (i3 == 4) {
                        i2--;
                        if (i2 >= 0) {
                            this.f1742a--;
                        } else {
                            throw new a("Expected a value but was " + f() + " at path " + n());
                        }
                    } else if (i3 == 2) {
                        i2--;
                        if (i2 >= 0) {
                            this.f1742a--;
                        } else {
                            throw new a("Expected a value but was " + f() + " at path " + n());
                        }
                    } else if (i3 == 14 || i3 == 10) {
                        s();
                    } else if (i3 == 9 || i3 == 13) {
                        b(h);
                    } else if (i3 == 8 || i3 == 12) {
                        b(g);
                    } else if (i3 == 17) {
                        this.m.skip((long) this.p);
                    } else if (i3 == 18) {
                        throw new a("Expected a value but was " + f() + " at path " + n());
                    }
                    this.n = 0;
                }
                i2++;
                this.n = 0;
            } while (i2 != 0);
            int[] iArr = this.d;
            int i4 = this.f1742a - 1;
            iArr[i4] = iArr[i4] + 1;
            this.c[this.f1742a - 1] = "null";
            return;
        }
        throw new a("Cannot skip unexpected " + f() + " at " + n());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        r6.m.skip((long) (r3 - 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        if (r1 != 47) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r6.l.request(2) != false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        t();
        r3 = r6.m.getByte(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        if (r3 == 42) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        if (r3 == 47) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004e, code lost:
        r6.m.readByte();
        r6.m.readByte();
        u();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        r6.m.readByte();
        r6.m.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
        if (v() == false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
        throw a("Unterminated comment");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
        if (r1 != 35) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0078, code lost:
        t();
        u();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007f, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L_0x0001:
            r1 = r0
        L_0x0002:
            okio.BufferedSource r2 = r6.l
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L_0x0082
            okio.Buffer r2 = r6.m
            long r4 = (long) r1
            byte r1 = r2.getByte(r4)
            r2 = 10
            if (r1 == r2) goto L_0x0080
            r2 = 32
            if (r1 == r2) goto L_0x0080
            r2 = 13
            if (r1 == r2) goto L_0x0080
            r2 = 9
            if (r1 != r2) goto L_0x0025
            goto L_0x0080
        L_0x0025:
            okio.Buffer r2 = r6.m
            int r3 = r3 + -1
            long r3 = (long) r3
            r2.skip(r3)
            r2 = 47
            if (r1 != r2) goto L_0x0074
            okio.BufferedSource r3 = r6.l
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L_0x003c
            return r1
        L_0x003c:
            r6.t()
            okio.Buffer r3 = r6.m
            r4 = 1
            byte r3 = r3.getByte(r4)
            r4 = 42
            if (r3 == r4) goto L_0x005c
            if (r3 == r2) goto L_0x004e
            return r1
        L_0x004e:
            okio.Buffer r1 = r6.m
            r1.readByte()
            okio.Buffer r1 = r6.m
            r1.readByte()
            r6.u()
            goto L_0x0001
        L_0x005c:
            okio.Buffer r1 = r6.m
            r1.readByte()
            okio.Buffer r1 = r6.m
            r1.readByte()
            boolean r1 = r6.v()
            if (r1 == 0) goto L_0x006d
            goto L_0x0001
        L_0x006d:
            java.lang.String r7 = "Unterminated comment"
            com.airbnb.lottie.e.a.b r7 = r6.a((java.lang.String) r7)
            throw r7
        L_0x0074:
            r2 = 35
            if (r1 != r2) goto L_0x007f
            r6.t()
            r6.u()
            goto L_0x0001
        L_0x007f:
            return r1
        L_0x0080:
            r1 = r3
            goto L_0x0002
        L_0x0082:
            if (r7 != 0) goto L_0x0086
            r7 = -1
            return r7
        L_0x0086:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.e.a.e.a(boolean):int");
    }

    private void t() throws IOException {
        if (!this.e) {
            throw a("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void u() throws IOException {
        long indexOfElement = this.l.indexOfElement(j);
        Buffer buffer = this.m;
        buffer.skip(indexOfElement != -1 ? indexOfElement + 1 : buffer.size());
    }

    private boolean v() throws IOException {
        long indexOf = this.l.indexOf(k);
        boolean z = indexOf != -1;
        Buffer buffer = this.m;
        buffer.skip(z ? indexOf + ((long) k.size()) : buffer.size());
        return z;
    }

    public String toString() {
        return "JsonReader(" + this.l + ")";
    }

    private char w() throws IOException {
        int i2;
        int i3;
        if (this.l.request(1)) {
            byte readByte = this.m.readByte();
            if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
                return (char) readByte;
            }
            if (readByte == 98) {
                return 8;
            }
            if (readByte == 102) {
                return 12;
            }
            if (readByte == 110) {
                return 10;
            }
            if (readByte == 114) {
                return 13;
            }
            if (readByte == 116) {
                return 9;
            }
            if (readByte != 117) {
                if (this.e) {
                    return (char) readByte;
                }
                throw a("Invalid escape sequence: \\" + ((char) readByte));
            } else if (this.l.request(4)) {
                char c = 0;
                for (int i4 = 0; i4 < 4; i4++) {
                    byte b2 = this.m.getByte((long) i4);
                    char c2 = (char) (c << 4);
                    if (b2 < 48 || b2 > 57) {
                        if (b2 >= 97 && b2 <= 102) {
                            i2 = b2 - 97;
                        } else if (b2 < 65 || b2 > 70) {
                            throw a("\\u" + this.m.readUtf8(4));
                        } else {
                            i2 = b2 - 65;
                        }
                        i3 = i2 + 10;
                    } else {
                        i3 = b2 - 48;
                    }
                    c = (char) (c2 + i3);
                }
                this.m.skip(4);
                return c;
            } else {
                throw new EOFException("Unterminated escape sequence at path " + n());
            }
        } else {
            throw a("Unterminated escape sequence");
        }
    }
}
