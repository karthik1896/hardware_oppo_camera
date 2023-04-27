package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class ColognePhonetic implements StringEncoder {
    private static final char[][] PREPROCESS_MAP = {new char[]{196, 'A'}, new char[]{220, 'U'}, new char[]{214, 'O'}, new char[]{223, 'S'}};
    static Class class$java$lang$String;

    private abstract class CologneBuffer {
        protected final char[] data;
        protected int length = 0;
        private final ColognePhonetic this$0;

        /* access modifiers changed from: protected */
        public abstract char[] copyData(int i, int i2);

        public CologneBuffer(ColognePhonetic colognePhonetic, char[] cArr) {
            this.this$0 = colognePhonetic;
            this.data = cArr;
            this.length = cArr.length;
        }

        public CologneBuffer(ColognePhonetic colognePhonetic, int i) {
            this.this$0 = colognePhonetic;
            this.data = new char[i];
            this.length = 0;
        }

        public int length() {
            return this.length;
        }

        public String toString() {
            return new String(copyData(0, this.length));
        }
    }

    private class CologneOutputBuffer extends CologneBuffer {
        private final ColognePhonetic this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CologneOutputBuffer(ColognePhonetic colognePhonetic, int i) {
            super(colognePhonetic, i);
            this.this$0 = colognePhonetic;
        }

        public void addRight(char c) {
            this.data[this.length] = c;
            this.length++;
        }

        /* access modifiers changed from: protected */
        public char[] copyData(int i, int i2) {
            char[] cArr = new char[i2];
            System.arraycopy(this.data, i, cArr, 0, i2);
            return cArr;
        }
    }

    private class CologneInputBuffer extends CologneBuffer {
        private final ColognePhonetic this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CologneInputBuffer(ColognePhonetic colognePhonetic, char[] cArr) {
            super(colognePhonetic, cArr);
            this.this$0 = colognePhonetic;
        }

        public void addLeft(char c) {
            this.length++;
            this.data[getNextPos()] = c;
        }

        /* access modifiers changed from: protected */
        public char[] copyData(int i, int i2) {
            char[] cArr = new char[i2];
            System.arraycopy(this.data, (this.data.length - this.length) + i, cArr, 0, i2);
            return cArr;
        }

        public char getNextChar() {
            return this.data[getNextPos()];
        }

        /* access modifiers changed from: protected */
        public int getNextPos() {
            return this.data.length - this.length;
        }

        public char removeNext() {
            this.length--;
            return getNextChar();
        }
    }

    private static boolean arrayContains(char[] cArr, char c) {
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:75:0x011e, code lost:
        if (r7 != '/') goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0127, code lost:
        if (r8 <= '8') goto L_0x012c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0118  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String colognePhonetic(java.lang.String r17) {
        /*
            r16 = this;
            r0 = r16
            if (r17 != 0) goto L_0x0006
            r1 = 0
            return r1
        L_0x0006:
            java.lang.String r1 = r16.preprocess(r17)
            org.apache.commons.codec.language.ColognePhonetic$CologneOutputBuffer r2 = new org.apache.commons.codec.language.ColognePhonetic$CologneOutputBuffer
            int r3 = r1.length()
            r4 = 2
            int r3 = r3 * r4
            r2.<init>(r0, r3)
            org.apache.commons.codec.language.ColognePhonetic$CologneInputBuffer r3 = new org.apache.commons.codec.language.ColognePhonetic$CologneInputBuffer
            char[] r1 = r1.toCharArray()
            r3.<init>(r0, r1)
            int r1 = r3.length()
            r5 = 47
            r6 = 45
            r7 = r5
            r8 = r6
        L_0x0028:
            if (r1 <= 0) goto L_0x012f
            char r1 = r3.removeNext()
            int r9 = r3.length()
            if (r9 <= 0) goto L_0x0039
            char r10 = r3.getNextChar()
            goto L_0x003a
        L_0x0039:
            r10 = r6
        L_0x003a:
            r11 = 7
            char[] r12 = new char[r11]
            r12 = {65, 69, 73, 74, 79, 85, 89} // fill-array
            boolean r12 = arrayContains(r12, r1)
            if (r12 == 0) goto L_0x004a
            r8 = 48
            goto L_0x0116
        L_0x004a:
            r12 = 72
            if (r1 == r12) goto L_0x0110
            r14 = 65
            if (r1 < r14) goto L_0x0110
            r14 = 90
            if (r1 <= r14) goto L_0x0058
            goto L_0x0110
        L_0x0058:
            r15 = 66
            if (r1 == r15) goto L_0x010d
            r15 = 80
            if (r1 != r15) goto L_0x0064
            if (r10 == r12) goto L_0x0064
            goto L_0x010d
        L_0x0064:
            r12 = 68
            r15 = 3
            if (r1 == r12) goto L_0x006d
            r12 = 84
            if (r1 != r12) goto L_0x007c
        L_0x006d:
            char[] r12 = new char[r15]
            r12 = {83, 67, 90} // fill-array
            boolean r12 = arrayContains(r12, r10)
            if (r12 != 0) goto L_0x007c
            r8 = 50
            goto L_0x0116
        L_0x007c:
            r12 = 4
            char[] r12 = new char[r12]
            r12 = {87, 70, 80, 86} // fill-array
            boolean r12 = arrayContains(r12, r1)
            if (r12 == 0) goto L_0x008c
            r8 = 51
            goto L_0x0116
        L_0x008c:
            char[] r12 = new char[r15]
            r12 = {71, 75, 81} // fill-array
            boolean r12 = arrayContains(r12, r1)
            if (r12 == 0) goto L_0x009b
        L_0x0097:
            r8 = 52
            goto L_0x0116
        L_0x009b:
            r12 = 88
            r13 = 83
            if (r1 != r12) goto L_0x00b2
            char[] r12 = new char[r15]
            r12 = {67, 75, 81} // fill-array
            boolean r12 = arrayContains(r12, r8)
            if (r12 != 0) goto L_0x00b2
            r3.addLeft(r13)
            int r9 = r9 + 1
            goto L_0x0097
        L_0x00b2:
            if (r1 == r13) goto L_0x010a
            if (r1 != r14) goto L_0x00b7
            goto L_0x010a
        L_0x00b7:
            r12 = 67
            if (r1 != r12) goto L_0x00e2
            if (r7 != r5) goto L_0x00cb
            r8 = 9
            char[] r8 = new char[r8]
            r8 = {65, 72, 75, 76, 79, 81, 82, 85, 88} // fill-array
            boolean r8 = arrayContains(r8, r10)
            if (r8 == 0) goto L_0x010a
            goto L_0x0097
        L_0x00cb:
            char[] r12 = new char[r4]
            r12 = {83, 90} // fill-array
            boolean r8 = arrayContains(r12, r8)
            if (r8 != 0) goto L_0x010a
            char[] r8 = new char[r11]
            r8 = {65, 72, 79, 85, 75, 81, 88} // fill-array
            boolean r8 = arrayContains(r8, r10)
            if (r8 != 0) goto L_0x0097
            goto L_0x010a
        L_0x00e2:
            char[] r8 = new char[r15]
            r8 = {84, 68, 88} // fill-array
            boolean r8 = arrayContains(r8, r1)
            if (r8 == 0) goto L_0x00ee
            goto L_0x010a
        L_0x00ee:
            r8 = 82
            if (r1 != r8) goto L_0x00f5
            r8 = 55
            goto L_0x0116
        L_0x00f5:
            r8 = 76
            if (r1 != r8) goto L_0x00fc
            r8 = 53
            goto L_0x0116
        L_0x00fc:
            r8 = 77
            if (r1 == r8) goto L_0x0107
            r8 = 78
            if (r1 != r8) goto L_0x0105
            goto L_0x0107
        L_0x0105:
            r8 = r1
            goto L_0x0116
        L_0x0107:
            r8 = 54
            goto L_0x0116
        L_0x010a:
            r8 = 56
            goto L_0x0116
        L_0x010d:
            r8 = 49
            goto L_0x0116
        L_0x0110:
            if (r7 != r5) goto L_0x0115
        L_0x0112:
            r1 = r9
            goto L_0x0028
        L_0x0115:
            r8 = r6
        L_0x0116:
            if (r8 == r6) goto L_0x012c
            if (r7 == r8) goto L_0x0121
            r10 = 48
            if (r8 != r10) goto L_0x0129
            if (r7 == r5) goto L_0x0129
            goto L_0x0123
        L_0x0121:
            r10 = 48
        L_0x0123:
            if (r8 < r10) goto L_0x0129
            r7 = 56
            if (r8 <= r7) goto L_0x012c
        L_0x0129:
            r2.addRight(r8)
        L_0x012c:
            r7 = r8
            r8 = r1
            goto L_0x0112
        L_0x012f:
            java.lang.String r1 = r2.toString()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.ColognePhonetic.colognePhonetic(java.lang.String):java.lang.String");
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return encode((String) obj);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("This method’s parameter was expected to be of the type ");
        Class cls = class$java$lang$String;
        if (cls == null) {
            cls = class$("java.lang.String");
            class$java$lang$String = cls;
        }
        stringBuffer.append(cls.getName());
        stringBuffer.append(". But actually it was of the type ");
        stringBuffer.append(obj.getClass().getName());
        stringBuffer.append(".");
        throw new EncoderException(stringBuffer.toString());
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public String encode(String str) {
        return colognePhonetic(str);
    }

    public boolean isEncodeEqual(String str, String str2) {
        return colognePhonetic(str).equals(colognePhonetic(str2));
    }

    private String preprocess(String str) {
        char[] charArray = str.toUpperCase(Locale.GERMAN).toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] > 'Z') {
                int i2 = 0;
                while (true) {
                    char[][] cArr = PREPROCESS_MAP;
                    if (i2 >= cArr.length) {
                        break;
                    } else if (charArray[i] == cArr[i2][0]) {
                        charArray[i] = cArr[i2][1];
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        return new String(charArray);
    }
}
