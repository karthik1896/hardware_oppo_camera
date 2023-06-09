package org.apache.commons.codec.binary;

import java.math.BigInteger;

public class Base64 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 6;
    private static final int BYTES_PER_ENCODED_BLOCK = 4;
    private static final int BYTES_PER_UNENCODED_BLOCK = 3;
    static final byte[] CHUNK_SEPARATOR = {13, 10};
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
    private static final int MASK_6BITS = 63;
    private static final byte[] STANDARD_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] URL_SAFE_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private int bitWorkArea;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    public Base64() {
        this(0);
    }

    public Base64(boolean z) {
        this(76, CHUNK_SEPARATOR, z);
    }

    public Base64(int i) {
        this(i, CHUNK_SEPARATOR);
    }

    public Base64(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Base64(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.decodeTable = DECODE_TABLE;
        if (bArr == null) {
            this.encodeSize = 4;
            this.lineSeparator = null;
        } else if (containsAlphabetOrPad(bArr)) {
            String newStringUtf8 = StringUtils.newStringUtf8(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("lineSeparator must not contain base64 characters: [");
            stringBuffer.append(newStringUtf8);
            stringBuffer.append("]");
            throw new IllegalArgumentException(stringBuffer.toString());
        } else if (i > 0) {
            this.encodeSize = bArr.length + 4;
            this.lineSeparator = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.lineSeparator, 0, bArr.length);
        } else {
            this.encodeSize = 4;
            this.lineSeparator = null;
        }
        this.decodeSize = this.encodeSize - 1;
        this.encodeTable = z ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
    }

    public boolean isUrlSafe() {
        return this.encodeTable == URL_SAFE_ENCODE_TABLE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v31, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(byte[] r8, int r9, int r10) {
        /*
            r7 = this;
            boolean r0 = r7.eof
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r1 = 1
            if (r10 >= 0) goto L_0x00d7
            r7.eof = r1
            int r8 = r7.modulus
            if (r8 != 0) goto L_0x0014
            int r8 = r7.lineLength
            if (r8 != 0) goto L_0x0014
            return
        L_0x0014:
            int r8 = r7.encodeSize
            r7.ensureBufferSize(r8)
            int r8 = r7.pos
            int r9 = r7.modulus
            r10 = 61
            r2 = 2
            if (r9 == r1) goto L_0x0071
            if (r9 == r2) goto L_0x0026
            goto L_0x00b1
        L_0x0026:
            byte[] r9 = r7.buffer
            int r1 = r7.pos
            int r3 = r1 + 1
            r7.pos = r3
            byte[] r3 = r7.encodeTable
            int r4 = r7.bitWorkArea
            int r4 = r4 >> 10
            r4 = r4 & 63
            byte r3 = r3[r4]
            r9[r1] = r3
            byte[] r9 = r7.buffer
            int r1 = r7.pos
            int r3 = r1 + 1
            r7.pos = r3
            byte[] r3 = r7.encodeTable
            int r4 = r7.bitWorkArea
            int r4 = r4 >> 4
            r4 = r4 & 63
            byte r3 = r3[r4]
            r9[r1] = r3
            byte[] r9 = r7.buffer
            int r1 = r7.pos
            int r3 = r1 + 1
            r7.pos = r3
            byte[] r3 = r7.encodeTable
            int r4 = r7.bitWorkArea
            int r2 = r4 << 2
            r2 = r2 & 63
            byte r2 = r3[r2]
            r9[r1] = r2
            byte[] r9 = STANDARD_ENCODE_TABLE
            if (r3 != r9) goto L_0x00b1
            byte[] r9 = r7.buffer
            int r1 = r7.pos
            int r2 = r1 + 1
            r7.pos = r2
            r9[r1] = r10
            goto L_0x00b1
        L_0x0071:
            byte[] r9 = r7.buffer
            int r1 = r7.pos
            int r3 = r1 + 1
            r7.pos = r3
            byte[] r3 = r7.encodeTable
            int r4 = r7.bitWorkArea
            int r2 = r4 >> 2
            r2 = r2 & 63
            byte r2 = r3[r2]
            r9[r1] = r2
            byte[] r9 = r7.buffer
            int r1 = r7.pos
            int r2 = r1 + 1
            r7.pos = r2
            byte[] r2 = r7.encodeTable
            int r3 = r7.bitWorkArea
            int r3 = r3 << 4
            r3 = r3 & 63
            byte r3 = r2[r3]
            r9[r1] = r3
            byte[] r9 = STANDARD_ENCODE_TABLE
            if (r2 != r9) goto L_0x00b1
            byte[] r9 = r7.buffer
            int r1 = r7.pos
            int r2 = r1 + 1
            r7.pos = r2
            r9[r1] = r10
            byte[] r9 = r7.buffer
            int r1 = r7.pos
            int r2 = r1 + 1
            r7.pos = r2
            r9[r1] = r10
        L_0x00b1:
            int r9 = r7.currentLinePos
            int r10 = r7.pos
            int r10 = r10 - r8
            int r9 = r9 + r10
            r7.currentLinePos = r9
            int r8 = r7.lineLength
            if (r8 <= 0) goto L_0x0173
            int r8 = r7.currentLinePos
            if (r8 <= 0) goto L_0x0173
            byte[] r8 = r7.lineSeparator
            byte[] r9 = r7.buffer
            int r10 = r7.pos
            byte[] r1 = r7.lineSeparator
            int r1 = r1.length
            java.lang.System.arraycopy(r8, r0, r9, r10, r1)
            int r8 = r7.pos
            byte[] r9 = r7.lineSeparator
            int r9 = r9.length
            int r8 = r8 + r9
            r7.pos = r8
            goto L_0x0173
        L_0x00d7:
            r2 = r9
            r9 = r0
        L_0x00d9:
            if (r9 >= r10) goto L_0x0173
            int r3 = r7.encodeSize
            r7.ensureBufferSize(r3)
            int r3 = r7.modulus
            int r3 = r3 + r1
            int r3 = r3 % 3
            r7.modulus = r3
            int r3 = r2 + 1
            byte r2 = r8[r2]
            if (r2 >= 0) goto L_0x00ef
            int r2 = r2 + 256
        L_0x00ef:
            int r4 = r7.bitWorkArea
            int r4 = r4 << 8
            int r4 = r4 + r2
            r7.bitWorkArea = r4
            int r2 = r7.modulus
            if (r2 != 0) goto L_0x016e
            byte[] r2 = r7.buffer
            int r4 = r7.pos
            int r5 = r4 + 1
            r7.pos = r5
            byte[] r5 = r7.encodeTable
            int r6 = r7.bitWorkArea
            int r6 = r6 >> 18
            r6 = r6 & 63
            byte r5 = r5[r6]
            r2[r4] = r5
            byte[] r2 = r7.buffer
            int r4 = r7.pos
            int r5 = r4 + 1
            r7.pos = r5
            byte[] r5 = r7.encodeTable
            int r6 = r7.bitWorkArea
            int r6 = r6 >> 12
            r6 = r6 & 63
            byte r5 = r5[r6]
            r2[r4] = r5
            byte[] r2 = r7.buffer
            int r4 = r7.pos
            int r5 = r4 + 1
            r7.pos = r5
            byte[] r5 = r7.encodeTable
            int r6 = r7.bitWorkArea
            int r6 = r6 >> 6
            r6 = r6 & 63
            byte r5 = r5[r6]
            r2[r4] = r5
            byte[] r2 = r7.buffer
            int r4 = r7.pos
            int r5 = r4 + 1
            r7.pos = r5
            byte[] r5 = r7.encodeTable
            int r6 = r7.bitWorkArea
            r6 = r6 & 63
            byte r5 = r5[r6]
            r2[r4] = r5
            int r2 = r7.currentLinePos
            int r2 = r2 + 4
            r7.currentLinePos = r2
            int r2 = r7.lineLength
            if (r2 <= 0) goto L_0x016e
            int r2 = r7.lineLength
            int r4 = r7.currentLinePos
            if (r2 > r4) goto L_0x016e
            byte[] r2 = r7.lineSeparator
            byte[] r4 = r7.buffer
            int r5 = r7.pos
            byte[] r6 = r7.lineSeparator
            int r6 = r6.length
            java.lang.System.arraycopy(r2, r0, r4, r5, r6)
            int r2 = r7.pos
            byte[] r4 = r7.lineSeparator
            int r4 = r4.length
            int r2 = r2 + r4
            r7.pos = r2
            r7.currentLinePos = r0
        L_0x016e:
            int r9 = r9 + 1
            r2 = r3
            goto L_0x00d9
        L_0x0173:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.binary.Base64.encode(byte[], int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void decode(byte[] bArr, int i, int i2) {
        byte b2;
        if (!this.eof) {
            if (i2 < 0) {
                this.eof = true;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                ensureBufferSize(this.decodeSize);
                int i4 = i + 1;
                byte b3 = bArr[i];
                if (b3 == 61) {
                    this.eof = true;
                    break;
                }
                if (b3 >= 0) {
                    byte[] bArr2 = DECODE_TABLE;
                    if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                        this.modulus = (this.modulus + 1) % 4;
                        this.bitWorkArea = (this.bitWorkArea << 6) + b2;
                        if (this.modulus == 0) {
                            byte[] bArr3 = this.buffer;
                            int i5 = this.pos;
                            this.pos = i5 + 1;
                            bArr3[i5] = (byte) ((this.bitWorkArea >> 16) & 255);
                            byte[] bArr4 = this.buffer;
                            int i6 = this.pos;
                            this.pos = i6 + 1;
                            bArr4[i6] = (byte) ((this.bitWorkArea >> 8) & 255);
                            byte[] bArr5 = this.buffer;
                            int i7 = this.pos;
                            this.pos = i7 + 1;
                            bArr5[i7] = (byte) (this.bitWorkArea & 255);
                        }
                    }
                }
                i3++;
                i = i4;
            }
            if (this.eof && this.modulus != 0) {
                ensureBufferSize(this.decodeSize);
                int i8 = this.modulus;
                if (i8 == 2) {
                    this.bitWorkArea >>= 4;
                    byte[] bArr6 = this.buffer;
                    int i9 = this.pos;
                    this.pos = i9 + 1;
                    bArr6[i9] = (byte) (this.bitWorkArea & 255);
                } else if (i8 == 3) {
                    this.bitWorkArea >>= 2;
                    byte[] bArr7 = this.buffer;
                    int i10 = this.pos;
                    this.pos = i10 + 1;
                    bArr7[i10] = (byte) ((this.bitWorkArea >> 8) & 255);
                    byte[] bArr8 = this.buffer;
                    int i11 = this.pos;
                    this.pos = i11 + 1;
                    bArr8[i11] = (byte) (this.bitWorkArea & 255);
                }
            }
        }
    }

    public static boolean isBase64(byte b2) {
        if (b2 != 61) {
            if (b2 >= 0) {
                byte[] bArr = DECODE_TABLE;
                if (b2 >= bArr.length || bArr[b2] == -1) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public static boolean isBase64(String str) {
        return isBase64(StringUtils.getBytesUtf8(str));
    }

    public static boolean isArrayByteBase64(byte[] bArr) {
        return isBase64(bArr);
    }

    public static boolean isBase64(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (!isBase64(bArr[i]) && !isWhiteSpace(bArr[i])) {
                return false;
            }
        }
        return true;
    }

    public static byte[] encodeBase64(byte[] bArr) {
        return encodeBase64(bArr, false);
    }

    public static String encodeBase64String(byte[] bArr) {
        return StringUtils.newStringUtf8(encodeBase64(bArr, false));
    }

    public static byte[] encodeBase64URLSafe(byte[] bArr) {
        return encodeBase64(bArr, false, true);
    }

    public static String encodeBase64URLSafeString(byte[] bArr) {
        return StringUtils.newStringUtf8(encodeBase64(bArr, false, true));
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        return encodeBase64(bArr, true);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        return encodeBase64(bArr, z, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2) {
        return encodeBase64(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Base64 base64 = z ? new Base64(z2) : new Base64(0, CHUNK_SEPARATOR, z2);
        long encodedLength = base64.getEncodedLength(bArr);
        if (encodedLength <= ((long) i)) {
            return base64.encode(bArr);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Input array too big, the output array would be bigger (");
        stringBuffer.append(encodedLength);
        stringBuffer.append(") than the specified maximum size of ");
        stringBuffer.append(i);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public static byte[] decodeBase64(String str) {
        return new Base64().decode(str);
    }

    public static byte[] decodeBase64(byte[] bArr) {
        return new Base64().decode(bArr);
    }

    public static BigInteger decodeInteger(byte[] bArr) {
        return new BigInteger(1, decodeBase64(bArr));
    }

    public static byte[] encodeInteger(BigInteger bigInteger) {
        if (bigInteger != null) {
            return encodeBase64(toIntegerBytes(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    static byte[] toIntegerBytes(BigInteger bigInteger) {
        int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == bitLength / 8) {
            return byteArray;
        }
        int i = 0;
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
            i = 1;
        }
        int i2 = bitLength / 8;
        int i3 = i2 - length;
        byte[] bArr = new byte[i2];
        System.arraycopy(byteArray, i, bArr, i3, length);
        return bArr;
    }

    /* access modifiers changed from: protected */
    public boolean isInAlphabet(byte b2) {
        if (b2 >= 0) {
            byte[] bArr = this.decodeTable;
            return b2 < bArr.length && bArr[b2] != -1;
        }
    }
}
