package org.apache.commons.codec.binary;

public class Base32 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 5;
    private static final int BYTES_PER_ENCODED_BLOCK = 8;
    private static final int BYTES_PER_UNENCODED_BLOCK = 5;
    private static final byte[] CHUNK_SEPARATOR = {13, 10};
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 63, -1, -1, 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
    private static final byte[] ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55};
    private static final byte[] HEX_DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 63, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};
    private static final byte[] HEX_ENCODE_TABLE = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86};
    private static final int MASK_5BITS = 31;
    private long bitWorkArea;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    public Base32() {
        this(false);
    }

    public Base32(boolean z) {
        this(0, (byte[]) null, z);
    }

    public Base32(int i) {
        this(i, CHUNK_SEPARATOR);
    }

    public Base32(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Base32(int i, byte[] bArr, boolean z) {
        super(5, 8, i, bArr == null ? 0 : bArr.length);
        if (z) {
            this.encodeTable = HEX_ENCODE_TABLE;
            this.decodeTable = HEX_DECODE_TABLE;
        } else {
            this.encodeTable = ENCODE_TABLE;
            this.decodeTable = DECODE_TABLE;
        }
        if (i <= 0) {
            this.encodeSize = 8;
            this.lineSeparator = null;
        } else if (bArr == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("lineLength ");
            stringBuffer.append(i);
            stringBuffer.append(" > 0, but lineSeparator is null");
            throw new IllegalArgumentException(stringBuffer.toString());
        } else if (!containsAlphabetOrPad(bArr)) {
            this.encodeSize = bArr.length + 8;
            this.lineSeparator = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.lineSeparator, 0, bArr.length);
        } else {
            String newStringUtf8 = StringUtils.newStringUtf8(bArr);
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("lineSeparator must not contain Base32 characters: [");
            stringBuffer2.append(newStringUtf8);
            stringBuffer2.append("]");
            throw new IllegalArgumentException(stringBuffer2.toString());
        }
        this.decodeSize = this.encodeSize - 1;
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
                int i4 = i + 1;
                byte b3 = bArr[i];
                if (b3 == 61) {
                    this.eof = true;
                    break;
                }
                ensureBufferSize(this.decodeSize);
                if (b3 >= 0) {
                    byte[] bArr2 = this.decodeTable;
                    if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                        this.modulus = (this.modulus + 1) % 8;
                        this.bitWorkArea = (this.bitWorkArea << 5) + ((long) b2);
                        if (this.modulus == 0) {
                            byte[] bArr3 = this.buffer;
                            int i5 = this.pos;
                            this.pos = i5 + 1;
                            bArr3[i5] = (byte) ((int) ((this.bitWorkArea >> 32) & 255));
                            byte[] bArr4 = this.buffer;
                            int i6 = this.pos;
                            this.pos = i6 + 1;
                            bArr4[i6] = (byte) ((int) ((this.bitWorkArea >> 24) & 255));
                            byte[] bArr5 = this.buffer;
                            int i7 = this.pos;
                            this.pos = i7 + 1;
                            bArr5[i7] = (byte) ((int) ((this.bitWorkArea >> 16) & 255));
                            byte[] bArr6 = this.buffer;
                            int i8 = this.pos;
                            this.pos = i8 + 1;
                            bArr6[i8] = (byte) ((int) ((this.bitWorkArea >> 8) & 255));
                            byte[] bArr7 = this.buffer;
                            int i9 = this.pos;
                            this.pos = i9 + 1;
                            bArr7[i9] = (byte) ((int) (this.bitWorkArea & 255));
                        }
                    }
                }
                i3++;
                i = i4;
            }
            if (this.eof && this.modulus >= 2) {
                ensureBufferSize(this.decodeSize);
                switch (this.modulus) {
                    case 2:
                        byte[] bArr8 = this.buffer;
                        int i10 = this.pos;
                        this.pos = i10 + 1;
                        bArr8[i10] = (byte) ((int) ((this.bitWorkArea >> 2) & 255));
                        return;
                    case 3:
                        byte[] bArr9 = this.buffer;
                        int i11 = this.pos;
                        this.pos = i11 + 1;
                        bArr9[i11] = (byte) ((int) ((this.bitWorkArea >> 7) & 255));
                        return;
                    case 4:
                        this.bitWorkArea >>= 4;
                        byte[] bArr10 = this.buffer;
                        int i12 = this.pos;
                        this.pos = i12 + 1;
                        bArr10[i12] = (byte) ((int) ((this.bitWorkArea >> 8) & 255));
                        byte[] bArr11 = this.buffer;
                        int i13 = this.pos;
                        this.pos = i13 + 1;
                        bArr11[i13] = (byte) ((int) (this.bitWorkArea & 255));
                        return;
                    case 5:
                        this.bitWorkArea >>= 1;
                        byte[] bArr12 = this.buffer;
                        int i14 = this.pos;
                        this.pos = i14 + 1;
                        bArr12[i14] = (byte) ((int) ((this.bitWorkArea >> 16) & 255));
                        byte[] bArr13 = this.buffer;
                        int i15 = this.pos;
                        this.pos = i15 + 1;
                        bArr13[i15] = (byte) ((int) ((this.bitWorkArea >> 8) & 255));
                        byte[] bArr14 = this.buffer;
                        int i16 = this.pos;
                        this.pos = i16 + 1;
                        bArr14[i16] = (byte) ((int) (this.bitWorkArea & 255));
                        return;
                    case 6:
                        this.bitWorkArea >>= 6;
                        byte[] bArr15 = this.buffer;
                        int i17 = this.pos;
                        this.pos = i17 + 1;
                        bArr15[i17] = (byte) ((int) ((this.bitWorkArea >> 16) & 255));
                        byte[] bArr16 = this.buffer;
                        int i18 = this.pos;
                        this.pos = i18 + 1;
                        bArr16[i18] = (byte) ((int) ((this.bitWorkArea >> 8) & 255));
                        byte[] bArr17 = this.buffer;
                        int i19 = this.pos;
                        this.pos = i19 + 1;
                        bArr17[i19] = (byte) ((int) (this.bitWorkArea & 255));
                        return;
                    case 7:
                        this.bitWorkArea >>= 3;
                        byte[] bArr18 = this.buffer;
                        int i20 = this.pos;
                        this.pos = i20 + 1;
                        bArr18[i20] = (byte) ((int) ((this.bitWorkArea >> 24) & 255));
                        byte[] bArr19 = this.buffer;
                        int i21 = this.pos;
                        this.pos = i21 + 1;
                        bArr19[i21] = (byte) ((int) ((this.bitWorkArea >> 16) & 255));
                        byte[] bArr20 = this.buffer;
                        int i22 = this.pos;
                        this.pos = i22 + 1;
                        bArr20[i22] = (byte) ((int) ((this.bitWorkArea >> 8) & 255));
                        byte[] bArr21 = this.buffer;
                        int i23 = this.pos;
                        this.pos = i23 + 1;
                        bArr21[i23] = (byte) ((int) (this.bitWorkArea & 255));
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v54, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v55, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(byte[] r12, int r13, int r14) {
        /*
            r11 = this;
            boolean r0 = r11.eof
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r1 = 1
            if (r14 >= 0) goto L_0x025f
            r11.eof = r1
            int r12 = r11.modulus
            if (r12 != 0) goto L_0x0014
            int r12 = r11.lineLength
            if (r12 != 0) goto L_0x0014
            return
        L_0x0014:
            int r12 = r11.encodeSize
            r11.ensureBufferSize(r12)
            int r12 = r11.pos
            int r13 = r11.modulus
            r14 = 3
            r2 = 2
            r3 = 61
            if (r13 == r1) goto L_0x01d5
            r4 = 4
            if (r13 == r2) goto L_0x0158
            if (r13 == r14) goto L_0x00cd
            if (r13 == r4) goto L_0x002c
            goto L_0x0239
        L_0x002c:
            byte[] r13 = r11.buffer
            int r1 = r11.pos
            int r4 = r1 + 1
            r11.pos = r4
            byte[] r4 = r11.encodeTable
            long r5 = r11.bitWorkArea
            r7 = 27
            long r5 = r5 >> r7
            int r5 = (int) r5
            r5 = r5 & 31
            byte r4 = r4[r5]
            r13[r1] = r4
            byte[] r13 = r11.buffer
            int r1 = r11.pos
            int r4 = r1 + 1
            r11.pos = r4
            byte[] r4 = r11.encodeTable
            long r5 = r11.bitWorkArea
            r7 = 22
            long r5 = r5 >> r7
            int r5 = (int) r5
            r5 = r5 & 31
            byte r4 = r4[r5]
            r13[r1] = r4
            byte[] r13 = r11.buffer
            int r1 = r11.pos
            int r4 = r1 + 1
            r11.pos = r4
            byte[] r4 = r11.encodeTable
            long r5 = r11.bitWorkArea
            r7 = 17
            long r5 = r5 >> r7
            int r5 = (int) r5
            r5 = r5 & 31
            byte r4 = r4[r5]
            r13[r1] = r4
            byte[] r13 = r11.buffer
            int r1 = r11.pos
            int r4 = r1 + 1
            r11.pos = r4
            byte[] r4 = r11.encodeTable
            long r5 = r11.bitWorkArea
            r7 = 12
            long r5 = r5 >> r7
            int r5 = (int) r5
            r5 = r5 & 31
            byte r4 = r4[r5]
            r13[r1] = r4
            byte[] r13 = r11.buffer
            int r1 = r11.pos
            int r4 = r1 + 1
            r11.pos = r4
            byte[] r4 = r11.encodeTable
            long r5 = r11.bitWorkArea
            r7 = 7
            long r5 = r5 >> r7
            int r5 = (int) r5
            r5 = r5 & 31
            byte r4 = r4[r5]
            r13[r1] = r4
            byte[] r13 = r11.buffer
            int r1 = r11.pos
            int r4 = r1 + 1
            r11.pos = r4
            byte[] r4 = r11.encodeTable
            long r5 = r11.bitWorkArea
            long r5 = r5 >> r2
            int r2 = (int) r5
            r2 = r2 & 31
            byte r2 = r4[r2]
            r13[r1] = r2
            byte[] r13 = r11.buffer
            int r1 = r11.pos
            int r2 = r1 + 1
            r11.pos = r2
            byte[] r2 = r11.encodeTable
            long r4 = r11.bitWorkArea
            long r4 = r4 << r14
            int r14 = (int) r4
            r14 = r14 & 31
            byte r14 = r2[r14]
            r13[r1] = r14
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r1 = r14 + 1
            r11.pos = r1
            r13[r14] = r3
            goto L_0x0239
        L_0x00cd:
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r2 = r14 + 1
            r11.pos = r2
            byte[] r2 = r11.encodeTable
            long r5 = r11.bitWorkArea
            r7 = 19
            long r5 = r5 >> r7
            int r5 = (int) r5
            r5 = r5 & 31
            byte r2 = r2[r5]
            r13[r14] = r2
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r2 = r14 + 1
            r11.pos = r2
            byte[] r2 = r11.encodeTable
            long r5 = r11.bitWorkArea
            r7 = 14
            long r5 = r5 >> r7
            int r5 = (int) r5
            r5 = r5 & 31
            byte r2 = r2[r5]
            r13[r14] = r2
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r2 = r14 + 1
            r11.pos = r2
            byte[] r2 = r11.encodeTable
            long r5 = r11.bitWorkArea
            r7 = 9
            long r5 = r5 >> r7
            int r5 = (int) r5
            r5 = r5 & 31
            byte r2 = r2[r5]
            r13[r14] = r2
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r2 = r14 + 1
            r11.pos = r2
            byte[] r2 = r11.encodeTable
            long r5 = r11.bitWorkArea
            long r4 = r5 >> r4
            int r4 = (int) r4
            r4 = r4 & 31
            byte r2 = r2[r4]
            r13[r14] = r2
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r2 = r14 + 1
            r11.pos = r2
            byte[] r2 = r11.encodeTable
            long r4 = r11.bitWorkArea
            long r4 = r4 << r1
            int r1 = (int) r4
            r1 = r1 & 31
            byte r1 = r2[r1]
            r13[r14] = r1
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r1 = r14 + 1
            r11.pos = r1
            r13[r14] = r3
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r1 = r14 + 1
            r11.pos = r1
            r13[r14] = r3
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r1 = r14 + 1
            r11.pos = r1
            r13[r14] = r3
            goto L_0x0239
        L_0x0158:
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r2 = r14 + 1
            r11.pos = r2
            byte[] r2 = r11.encodeTable
            long r5 = r11.bitWorkArea
            r7 = 11
            long r5 = r5 >> r7
            int r5 = (int) r5
            r5 = r5 & 31
            byte r2 = r2[r5]
            r13[r14] = r2
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r2 = r14 + 1
            r11.pos = r2
            byte[] r2 = r11.encodeTable
            long r5 = r11.bitWorkArea
            r7 = 6
            long r5 = r5 >> r7
            int r5 = (int) r5
            r5 = r5 & 31
            byte r2 = r2[r5]
            r13[r14] = r2
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r2 = r14 + 1
            r11.pos = r2
            byte[] r2 = r11.encodeTable
            long r5 = r11.bitWorkArea
            long r5 = r5 >> r1
            int r1 = (int) r5
            r1 = r1 & 31
            byte r1 = r2[r1]
            r13[r14] = r1
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r1 = r14 + 1
            r11.pos = r1
            byte[] r1 = r11.encodeTable
            long r5 = r11.bitWorkArea
            long r4 = r5 << r4
            int r2 = (int) r4
            r2 = r2 & 31
            byte r1 = r1[r2]
            r13[r14] = r1
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r1 = r14 + 1
            r11.pos = r1
            r13[r14] = r3
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r1 = r14 + 1
            r11.pos = r1
            r13[r14] = r3
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r1 = r14 + 1
            r11.pos = r1
            r13[r14] = r3
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r1 = r14 + 1
            r11.pos = r1
            r13[r14] = r3
            goto L_0x0239
        L_0x01d5:
            byte[] r13 = r11.buffer
            int r1 = r11.pos
            int r4 = r1 + 1
            r11.pos = r4
            byte[] r4 = r11.encodeTable
            long r5 = r11.bitWorkArea
            long r5 = r5 >> r14
            int r14 = (int) r5
            r14 = r14 & 31
            byte r14 = r4[r14]
            r13[r1] = r14
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r1 = r14 + 1
            r11.pos = r1
            byte[] r1 = r11.encodeTable
            long r4 = r11.bitWorkArea
            long r4 = r4 << r2
            int r2 = (int) r4
            r2 = r2 & 31
            byte r1 = r1[r2]
            r13[r14] = r1
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r1 = r14 + 1
            r11.pos = r1
            r13[r14] = r3
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r1 = r14 + 1
            r11.pos = r1
            r13[r14] = r3
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r1 = r14 + 1
            r11.pos = r1
            r13[r14] = r3
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r1 = r14 + 1
            r11.pos = r1
            r13[r14] = r3
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r1 = r14 + 1
            r11.pos = r1
            r13[r14] = r3
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            int r1 = r14 + 1
            r11.pos = r1
            r13[r14] = r3
        L_0x0239:
            int r13 = r11.currentLinePos
            int r14 = r11.pos
            int r14 = r14 - r12
            int r13 = r13 + r14
            r11.currentLinePos = r13
            int r12 = r11.lineLength
            if (r12 <= 0) goto L_0x0359
            int r12 = r11.currentLinePos
            if (r12 <= 0) goto L_0x0359
            byte[] r12 = r11.lineSeparator
            byte[] r13 = r11.buffer
            int r14 = r11.pos
            byte[] r1 = r11.lineSeparator
            int r1 = r1.length
            java.lang.System.arraycopy(r12, r0, r13, r14, r1)
            int r12 = r11.pos
            byte[] r13 = r11.lineSeparator
            int r13 = r13.length
            int r12 = r12 + r13
            r11.pos = r12
            goto L_0x0359
        L_0x025f:
            r2 = r13
            r13 = r0
        L_0x0261:
            if (r13 >= r14) goto L_0x0359
            int r3 = r11.encodeSize
            r11.ensureBufferSize(r3)
            int r3 = r11.modulus
            int r3 = r3 + r1
            r4 = 5
            int r3 = r3 % r4
            r11.modulus = r3
            int r3 = r2 + 1
            byte r2 = r12[r2]
            if (r2 >= 0) goto L_0x0277
            int r2 = r2 + 256
        L_0x0277:
            long r5 = r11.bitWorkArea
            r7 = 8
            long r5 = r5 << r7
            long r8 = (long) r2
            long r5 = r5 + r8
            r11.bitWorkArea = r5
            int r2 = r11.modulus
            if (r2 != 0) goto L_0x0354
            byte[] r2 = r11.buffer
            int r5 = r11.pos
            int r6 = r5 + 1
            r11.pos = r6
            byte[] r6 = r11.encodeTable
            long r8 = r11.bitWorkArea
            r10 = 35
            long r8 = r8 >> r10
            int r8 = (int) r8
            r8 = r8 & 31
            byte r6 = r6[r8]
            r2[r5] = r6
            byte[] r2 = r11.buffer
            int r5 = r11.pos
            int r6 = r5 + 1
            r11.pos = r6
            byte[] r6 = r11.encodeTable
            long r8 = r11.bitWorkArea
            r10 = 30
            long r8 = r8 >> r10
            int r8 = (int) r8
            r8 = r8 & 31
            byte r6 = r6[r8]
            r2[r5] = r6
            byte[] r2 = r11.buffer
            int r5 = r11.pos
            int r6 = r5 + 1
            r11.pos = r6
            byte[] r6 = r11.encodeTable
            long r8 = r11.bitWorkArea
            r10 = 25
            long r8 = r8 >> r10
            int r8 = (int) r8
            r8 = r8 & 31
            byte r6 = r6[r8]
            r2[r5] = r6
            byte[] r2 = r11.buffer
            int r5 = r11.pos
            int r6 = r5 + 1
            r11.pos = r6
            byte[] r6 = r11.encodeTable
            long r8 = r11.bitWorkArea
            r10 = 20
            long r8 = r8 >> r10
            int r8 = (int) r8
            r8 = r8 & 31
            byte r6 = r6[r8]
            r2[r5] = r6
            byte[] r2 = r11.buffer
            int r5 = r11.pos
            int r6 = r5 + 1
            r11.pos = r6
            byte[] r6 = r11.encodeTable
            long r8 = r11.bitWorkArea
            r10 = 15
            long r8 = r8 >> r10
            int r8 = (int) r8
            r8 = r8 & 31
            byte r6 = r6[r8]
            r2[r5] = r6
            byte[] r2 = r11.buffer
            int r5 = r11.pos
            int r6 = r5 + 1
            r11.pos = r6
            byte[] r6 = r11.encodeTable
            long r8 = r11.bitWorkArea
            r10 = 10
            long r8 = r8 >> r10
            int r8 = (int) r8
            r8 = r8 & 31
            byte r6 = r6[r8]
            r2[r5] = r6
            byte[] r2 = r11.buffer
            int r5 = r11.pos
            int r6 = r5 + 1
            r11.pos = r6
            byte[] r6 = r11.encodeTable
            long r8 = r11.bitWorkArea
            long r8 = r8 >> r4
            int r4 = (int) r8
            r4 = r4 & 31
            byte r4 = r6[r4]
            r2[r5] = r4
            byte[] r2 = r11.buffer
            int r4 = r11.pos
            int r5 = r4 + 1
            r11.pos = r5
            byte[] r5 = r11.encodeTable
            long r8 = r11.bitWorkArea
            int r6 = (int) r8
            r6 = r6 & 31
            byte r5 = r5[r6]
            r2[r4] = r5
            int r2 = r11.currentLinePos
            int r2 = r2 + r7
            r11.currentLinePos = r2
            int r2 = r11.lineLength
            if (r2 <= 0) goto L_0x0354
            int r2 = r11.lineLength
            int r4 = r11.currentLinePos
            if (r2 > r4) goto L_0x0354
            byte[] r2 = r11.lineSeparator
            byte[] r4 = r11.buffer
            int r5 = r11.pos
            byte[] r6 = r11.lineSeparator
            int r6 = r6.length
            java.lang.System.arraycopy(r2, r0, r4, r5, r6)
            int r2 = r11.pos
            byte[] r4 = r11.lineSeparator
            int r4 = r4.length
            int r2 = r2 + r4
            r11.pos = r2
            r11.currentLinePos = r0
        L_0x0354:
            int r13 = r13 + 1
            r2 = r3
            goto L_0x0261
        L_0x0359:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.binary.Base32.encode(byte[], int, int):void");
    }

    public boolean isInAlphabet(byte b2) {
        if (b2 >= 0) {
            byte[] bArr = this.decodeTable;
            return b2 < bArr.length && bArr[b2] != -1;
        }
    }
}
