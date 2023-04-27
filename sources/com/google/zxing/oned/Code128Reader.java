package com.google.zxing.oned;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class Code128Reader extends OneDReader {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    static final int[][] CODE_PATTERNS = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    private static final int CODE_SHIFT = 98;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final float MAX_AVG_VARIANCE = 0.25f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;

    private static int[] findStartPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int[] iArr = new int[6];
        boolean z = false;
        int i = 0;
        int i2 = nextSet;
        while (nextSet < size) {
            if (bitArray.get(nextSet) != z) {
                iArr[i] = iArr[i] + 1;
            } else {
                if (i == 5) {
                    float f = MAX_AVG_VARIANCE;
                    int i3 = -1;
                    for (int i4 = 103; i4 <= 105; i4++) {
                        float patternMatchVariance = patternMatchVariance(iArr, CODE_PATTERNS[i4], MAX_INDIVIDUAL_VARIANCE);
                        if (patternMatchVariance < f) {
                            i3 = i4;
                            f = patternMatchVariance;
                        }
                    }
                    if (i3 < 0 || !bitArray.isRange(Math.max(0, i2 - ((nextSet - i2) / 2)), i2, false)) {
                        i2 += iArr[0] + iArr[1];
                        int i5 = i - 1;
                        System.arraycopy(iArr, 2, iArr, 0, i5);
                        iArr[i5] = 0;
                        iArr[i] = 0;
                        i--;
                    } else {
                        return new int[]{i2, nextSet, i3};
                    }
                } else {
                    i++;
                }
                iArr[i] = 1;
                z = !z;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int decodeCode(BitArray bitArray, int[] iArr, int i) throws NotFoundException {
        recordPattern(bitArray, i, iArr);
        float f = MAX_AVG_VARIANCE;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int[][] iArr2 = CODE_PATTERNS;
            if (i3 >= iArr2.length) {
                break;
            }
            float patternMatchVariance = patternMatchVariance(iArr, iArr2[i3], MAX_INDIVIDUAL_VARIANCE);
            if (patternMatchVariance < f) {
                i2 = i3;
                f = patternMatchVariance;
            }
            i3++;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0189, code lost:
        r12 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x018a, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x018b, code lost:
        if (r14 == false) goto L_0x0195;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x018f, code lost:
        if (r3 != 'e') goto L_0x0193;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0191, code lost:
        r3 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0193, code lost:
        r3 = 'e';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0197, code lost:
        r14 = r5;
        r5 = r12;
        r15 = 6;
        r12 = r8;
        r8 = r21;
        r23 = r16;
        r16 = r9;
        r9 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e2, code lost:
        if (r5 != false) goto L_0x0136;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0101, code lost:
        r5 = false;
        r10 = 'd';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0104, code lost:
        r12 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x012d, code lost:
        r5 = false;
        r10 = 'd';
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0134, code lost:
        if (r5 != false) goto L_0x0136;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0136, code lost:
        r5 = false;
        r10 = 'd';
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x013b, code lost:
        r5 = false;
        r10 = 'd';
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0140, code lost:
        r12 = r5;
        r3 = 'c';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0147, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0149, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x014a, code lost:
        r12 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x014b, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x014c, code lost:
        r10 = 'd';
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.Result decodeRow(int r25, com.google.zxing.common.BitArray r26, java.util.Map<com.google.zxing.DecodeHintType, ?> r27) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
            r24 = this;
            r0 = r26
            r1 = r27
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0012
            com.google.zxing.DecodeHintType r4 = com.google.zxing.DecodeHintType.ASSUME_GS1
            boolean r1 = r1.containsKey(r4)
            if (r1 == 0) goto L_0x0012
            r1 = r2
            goto L_0x0013
        L_0x0012:
            r1 = r3
        L_0x0013:
            int[] r4 = findStartPattern(r26)
            r5 = 2
            r6 = r4[r5]
            java.util.ArrayList r7 = new java.util.ArrayList
            r8 = 20
            r7.<init>(r8)
            byte r9 = (byte) r6
            java.lang.Byte r9 = java.lang.Byte.valueOf(r9)
            r7.add(r9)
            switch(r6) {
                case 103: goto L_0x0037;
                case 104: goto L_0x0034;
                case 105: goto L_0x0031;
                default: goto L_0x002c;
            }
        L_0x002c:
            com.google.zxing.FormatException r0 = com.google.zxing.FormatException.getFormatInstance()
            throw r0
        L_0x0031:
            r12 = 99
            goto L_0x0039
        L_0x0034:
            r12 = 100
            goto L_0x0039
        L_0x0037:
            r12 = 101(0x65, float:1.42E-43)
        L_0x0039:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r8)
            r8 = r4[r3]
            r14 = r4[r2]
            r15 = 6
            int[] r2 = new int[r15]
            r5 = r3
            r9 = r5
            r11 = r9
            r16 = r11
            r18 = r16
            r17 = r6
            r19 = 1
            r6 = r18
            r3 = r12
            r12 = r8
            r8 = r14
            r14 = r6
        L_0x0056:
            if (r6 != 0) goto L_0x01a5
            int r9 = decodeCode(r0, r2, r8)
            byte r12 = (byte) r9
            java.lang.Byte r12 = java.lang.Byte.valueOf(r12)
            r7.add(r12)
            r12 = 106(0x6a, float:1.49E-43)
            if (r9 == r12) goto L_0x006a
            r19 = 1
        L_0x006a:
            if (r9 == r12) goto L_0x0072
            int r18 = r18 + 1
            int r20 = r18 * r9
            int r17 = r17 + r20
        L_0x0072:
            r21 = r8
            r10 = 0
        L_0x0075:
            if (r10 >= r15) goto L_0x007e
            r22 = r2[r10]
            int r21 = r21 + r22
            int r10 = r10 + 1
            goto L_0x0075
        L_0x007e:
            switch(r9) {
                case 103: goto L_0x008c;
                case 104: goto L_0x008c;
                case 105: goto L_0x008c;
                default: goto L_0x0081;
            }
        L_0x0081:
            r10 = 96
            java.lang.String r15 = "]C1"
            switch(r3) {
                case 99: goto L_0x014f;
                case 100: goto L_0x00ee;
                case 101: goto L_0x0091;
                default: goto L_0x0088;
            }
        L_0x0088:
            r10 = 100
            goto L_0x0189
        L_0x008c:
            com.google.zxing.FormatException r0 = com.google.zxing.FormatException.getFormatInstance()
            throw r0
        L_0x0091:
            r12 = 64
            if (r9 >= r12) goto L_0x00a8
            if (r5 != r11) goto L_0x009f
            int r5 = r9 + 32
            char r5 = (char) r5
            r13.append(r5)
            goto L_0x0101
        L_0x009f:
            int r5 = r9 + 32
            int r5 = r5 + 128
            char r5 = (char) r5
            r13.append(r5)
            goto L_0x0101
        L_0x00a8:
            if (r9 >= r10) goto L_0x00ba
            if (r5 != r11) goto L_0x00b3
            int r5 = r9 + -64
            char r5 = (char) r5
            r13.append(r5)
            goto L_0x0101
        L_0x00b3:
            int r5 = r9 + 64
            char r5 = (char) r5
            r13.append(r5)
            goto L_0x0101
        L_0x00ba:
            r10 = 106(0x6a, float:1.49E-43)
            if (r9 == r10) goto L_0x00c0
            r19 = 0
        L_0x00c0:
            if (r9 == r10) goto L_0x0149
            switch(r9) {
                case 96: goto L_0x014a;
                case 97: goto L_0x014a;
                case 98: goto L_0x00ea;
                case 99: goto L_0x0140;
                case 100: goto L_0x00e5;
                case 101: goto L_0x00db;
                case 102: goto L_0x00c7;
                default: goto L_0x00c5;
            }
        L_0x00c5:
            goto L_0x014a
        L_0x00c7:
            if (r1 == 0) goto L_0x014a
            int r10 = r13.length()
            if (r10 != 0) goto L_0x00d4
            r13.append(r15)
            goto L_0x014a
        L_0x00d4:
            r10 = 29
            r13.append(r10)
            goto L_0x014a
        L_0x00db:
            if (r11 != 0) goto L_0x00e0
            if (r5 == 0) goto L_0x00e0
            goto L_0x012d
        L_0x00e0:
            if (r11 == 0) goto L_0x013b
            if (r5 == 0) goto L_0x013b
            goto L_0x0136
        L_0x00e5:
            r12 = r5
            r3 = 100
            goto L_0x014b
        L_0x00ea:
            r12 = r5
            r3 = 100
            goto L_0x0147
        L_0x00ee:
            if (r9 >= r10) goto L_0x0107
            if (r5 != r11) goto L_0x00f9
            int r5 = r9 + 32
            char r5 = (char) r5
            r13.append(r5)
            goto L_0x0101
        L_0x00f9:
            int r5 = r9 + 32
            int r5 = r5 + 128
            char r5 = (char) r5
            r13.append(r5)
        L_0x0101:
            r5 = 0
            r10 = 100
        L_0x0104:
            r12 = 0
            goto L_0x018b
        L_0x0107:
            r10 = 106(0x6a, float:1.49E-43)
            if (r9 == r10) goto L_0x010d
            r19 = 0
        L_0x010d:
            if (r9 == r10) goto L_0x0149
            switch(r9) {
                case 96: goto L_0x014a;
                case 97: goto L_0x014a;
                case 98: goto L_0x0144;
                case 99: goto L_0x0140;
                case 100: goto L_0x0129;
                case 101: goto L_0x0125;
                case 102: goto L_0x0113;
                default: goto L_0x0112;
            }
        L_0x0112:
            goto L_0x014a
        L_0x0113:
            if (r1 == 0) goto L_0x014a
            int r10 = r13.length()
            if (r10 != 0) goto L_0x011f
            r13.append(r15)
            goto L_0x014a
        L_0x011f:
            r10 = 29
            r13.append(r10)
            goto L_0x014a
        L_0x0125:
            r12 = r5
            r3 = 101(0x65, float:1.42E-43)
            goto L_0x014b
        L_0x0129:
            if (r11 != 0) goto L_0x0132
            if (r5 == 0) goto L_0x0132
        L_0x012d:
            r5 = 0
            r10 = 100
            r11 = 1
            goto L_0x0104
        L_0x0132:
            if (r11 == 0) goto L_0x013b
            if (r5 == 0) goto L_0x013b
        L_0x0136:
            r5 = 0
            r10 = 100
            r11 = 0
            goto L_0x0104
        L_0x013b:
            r5 = 0
            r10 = 100
            r12 = 1
            goto L_0x018b
        L_0x0140:
            r12 = r5
            r3 = 99
            goto L_0x014b
        L_0x0144:
            r12 = r5
            r3 = 101(0x65, float:1.42E-43)
        L_0x0147:
            r5 = 1
            goto L_0x014c
        L_0x0149:
            r6 = 1
        L_0x014a:
            r12 = r5
        L_0x014b:
            r5 = 0
        L_0x014c:
            r10 = 100
            goto L_0x018b
        L_0x014f:
            r10 = 100
            if (r9 >= r10) goto L_0x0160
            r12 = 10
            if (r9 >= r12) goto L_0x015c
            r12 = 48
            r13.append(r12)
        L_0x015c:
            r13.append(r9)
            goto L_0x0189
        L_0x0160:
            r12 = 106(0x6a, float:1.49E-43)
            if (r9 == r12) goto L_0x0166
            r19 = 0
        L_0x0166:
            if (r9 == r12) goto L_0x0185
            switch(r9) {
                case 100: goto L_0x0182;
                case 101: goto L_0x017e;
                case 102: goto L_0x016c;
                default: goto L_0x016b;
            }
        L_0x016b:
            goto L_0x0189
        L_0x016c:
            if (r1 == 0) goto L_0x0189
            int r12 = r13.length()
            if (r12 != 0) goto L_0x0178
            r13.append(r15)
            goto L_0x0189
        L_0x0178:
            r12 = 29
            r13.append(r12)
            goto L_0x0189
        L_0x017e:
            r12 = r5
            r3 = 101(0x65, float:1.42E-43)
            goto L_0x018a
        L_0x0182:
            r12 = r5
            r3 = r10
            goto L_0x018a
        L_0x0185:
            r12 = r5
            r5 = 0
            r6 = 1
            goto L_0x018b
        L_0x0189:
            r12 = r5
        L_0x018a:
            r5 = 0
        L_0x018b:
            if (r14 == 0) goto L_0x0195
            r14 = 101(0x65, float:1.42E-43)
            if (r3 != r14) goto L_0x0193
            r3 = r10
            goto L_0x0197
        L_0x0193:
            r3 = r14
            goto L_0x0197
        L_0x0195:
            r14 = 101(0x65, float:1.42E-43)
        L_0x0197:
            r14 = r5
            r5 = r12
            r15 = 6
            r12 = r8
            r8 = r21
            r23 = r16
            r16 = r9
            r9 = r23
            goto L_0x0056
        L_0x01a5:
            int r1 = r8 - r12
            int r2 = r0.getNextUnset(r8)
            int r5 = r26.getSize()
            int r6 = r2 - r12
            r8 = 2
            int r6 = r6 / r8
            int r6 = r6 + r2
            int r5 = java.lang.Math.min(r5, r6)
            r6 = 0
            boolean r0 = r0.isRange(r2, r5, r6)
            if (r0 == 0) goto L_0x0233
            int r18 = r18 * r9
            int r17 = r17 - r18
            int r0 = r17 % 103
            if (r0 != r9) goto L_0x022e
            int r0 = r13.length()
            if (r0 == 0) goto L_0x0229
            if (r0 <= 0) goto L_0x01e0
            if (r19 == 0) goto L_0x01e0
            r2 = 99
            if (r3 != r2) goto L_0x01db
            int r2 = r0 + -2
            r13.delete(r2, r0)
            goto L_0x01e0
        L_0x01db:
            int r2 = r0 + -1
            r13.delete(r2, r0)
        L_0x01e0:
            r0 = 1
            r2 = r4[r0]
            r0 = 0
            r3 = r4[r0]
            int r2 = r2 + r3
            float r0 = (float) r2
            r2 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r2
            float r3 = (float) r12
            float r1 = (float) r1
            float r1 = r1 / r2
            float r3 = r3 + r1
            int r1 = r7.size()
            byte[] r2 = new byte[r1]
            r4 = 0
        L_0x01f6:
            if (r4 >= r1) goto L_0x0207
            java.lang.Object r5 = r7.get(r4)
            java.lang.Byte r5 = (java.lang.Byte) r5
            byte r5 = r5.byteValue()
            r2[r4] = r5
            int r4 = r4 + 1
            goto L_0x01f6
        L_0x0207:
            com.google.zxing.Result r1 = new com.google.zxing.Result
            java.lang.String r4 = r13.toString()
            r5 = 2
            com.google.zxing.ResultPoint[] r5 = new com.google.zxing.ResultPoint[r5]
            com.google.zxing.ResultPoint r6 = new com.google.zxing.ResultPoint
            r7 = r25
            float r7 = (float) r7
            r6.<init>(r0, r7)
            r0 = 0
            r5[r0] = r6
            com.google.zxing.ResultPoint r0 = new com.google.zxing.ResultPoint
            r0.<init>(r3, r7)
            r3 = 1
            r5[r3] = r0
            com.google.zxing.BarcodeFormat r0 = com.google.zxing.BarcodeFormat.CODE_128
            r1.<init>(r4, r2, r5, r0)
            return r1
        L_0x0229:
            com.google.zxing.NotFoundException r0 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r0
        L_0x022e:
            com.google.zxing.ChecksumException r0 = com.google.zxing.ChecksumException.getChecksumInstance()
            throw r0
        L_0x0233:
            com.google.zxing.NotFoundException r0 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Reader.decodeRow(int, com.google.zxing.common.BitArray, java.util.Map):com.google.zxing.Result");
    }
}
