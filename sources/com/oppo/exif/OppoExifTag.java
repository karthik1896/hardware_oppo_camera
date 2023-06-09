package com.oppo.exif;

import com.oppo.exif.OppoExifInterface;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import org.apache.commons.codec.CharEncoding;

public class OppoExifTag {
    public static final String EXIF_KEY_TAGFLAGS = "tagflags";
    public static final int EXIF_TAG_AI_ID_PHOTO = 16384;
    public static final int EXIF_TAG_BOKEH = 16;
    public static final int EXIF_TAG_DOUBLE_EXPOSURE = 32768;
    public static final int EXIF_TAG_ENHANCE_TEXT = 4096;
    public static final int EXIF_TAG_FACE_BEAUTY = 2;
    public static final int EXIF_TAG_FAST_VIDEO = 8;
    public static final int EXIF_TAG_FILTER = 1024;
    public static final int EXIF_TAG_FRONT_CAMERA = 1;
    public static final int EXIF_TAG_MODEL = 128;
    public static final int EXIF_TAG_NIGHT_SCENE = 2048;
    public static final int EXIF_TAG_PANORAMA = 4;
    public static final String EXIF_TAG_PREFIX = "oppo_";
    public static final int EXIF_TAG_PROFESSION = 256;
    public static final int EXIF_TAG_RELIGHT = 64;
    public static final int EXIF_TAG_STICKER = 512;
    public static final int EXIF_TAG_SUPER_HIGH_RESOLUTION = 8192;
    public static final int EXIF_TAG_WITH_ORIENTATION = 32;
    private static final long LONG_MAX = 2147483647L;
    private static final long LONG_MIN = -2147483648L;
    static final int SIZE_UNDEFINED = 0;
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    public static final short TYPE_ASCII = 2;
    public static final short TYPE_LONG = 9;
    public static final short TYPE_RATIONAL = 10;
    private static final int[] TYPE_TO_SIZE_MAP = new int[11];
    public static final short TYPE_UNDEFINED = 7;
    public static final short TYPE_UNSIGNED_BYTE = 1;
    public static final short TYPE_UNSIGNED_LONG = 4;
    public static final short TYPE_UNSIGNED_RATIONAL = 5;
    public static final short TYPE_UNSIGNED_SHORT = 3;
    private static final long UNSIGNED_LONG_MAX = 4294967295L;
    private static final int UNSIGNED_SHORT_MAX = 65535;
    private static Charset US_ASCII = Charset.forName(CharEncoding.US_ASCII);
    private int mComponentCountActual;
    private final short mDataType;
    private boolean mHasDefinedDefaultComponentCount;
    private int mIfd;
    private int mOffset;
    private final short mTagId;
    private Object mValue = null;

    private static String convertTypeToString(short s) {
        switch (s) {
            case 1:
                return "UNSIGNED_BYTE";
            case 2:
                return "ASCII";
            case 3:
                return "UNSIGNED_SHORT";
            case 4:
                return "UNSIGNED_LONG";
            case 5:
                return "UNSIGNED_RATIONAL";
            case 7:
                return "UNDEFINED";
            case 9:
                return "LONG";
            case 10:
                return "RATIONAL";
            default:
                return "";
        }
    }

    public static boolean isValidIfd(int i) {
        return i == 0 || i == 1 || i == 2 || i == 3 || i == 4;
    }

    public static boolean isValidType(short s) {
        return s == 1 || s == 2 || s == 3 || s == 4 || s == 5 || s == 7 || s == 9 || s == 10;
    }

    static {
        int[] iArr = TYPE_TO_SIZE_MAP;
        iArr[1] = 1;
        iArr[2] = 1;
        iArr[3] = 2;
        iArr[4] = 4;
        iArr[5] = 8;
        iArr[7] = 1;
        iArr[9] = 4;
        iArr[10] = 8;
    }

    OppoExifTag(short s, short s2, int i, int i2, boolean z) {
        this.mTagId = s;
        this.mDataType = s2;
        this.mComponentCountActual = i;
        this.mHasDefinedDefaultComponentCount = z;
        this.mIfd = i2;
    }

    public static int getElementSize(short s) {
        return TYPE_TO_SIZE_MAP[s];
    }

    public int getIfd() {
        return this.mIfd;
    }

    /* access modifiers changed from: protected */
    public void setIfd(int i) {
        this.mIfd = i;
    }

    public short getTagId() {
        return this.mTagId;
    }

    public short getDataType() {
        return this.mDataType;
    }

    public int getDataSize() {
        return getComponentCount() * getElementSize(getDataType());
    }

    public int getComponentCount() {
        return this.mComponentCountActual;
    }

    /* access modifiers changed from: protected */
    public void forceSetComponentCount(int i) {
        this.mComponentCountActual = i;
    }

    public boolean hasValue() {
        return this.mValue != null;
    }

    public boolean setValue(int[] iArr) {
        if (checkBadComponentCount(iArr.length)) {
            return false;
        }
        short s = this.mDataType;
        if (s != 3 && s != 9 && s != 4) {
            return false;
        }
        if (this.mDataType == 3 && checkOverflowForUnsignedShort(iArr)) {
            return false;
        }
        if (this.mDataType == 4 && checkOverflowForUnsignedLong(iArr)) {
            return false;
        }
        long[] jArr = new long[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            jArr[i] = (long) iArr[i];
        }
        this.mValue = jArr;
        this.mComponentCountActual = iArr.length;
        return true;
    }

    public boolean setValue(int i) {
        return setValue(new int[]{i});
    }

    public boolean setValue(long[] jArr) {
        if (checkBadComponentCount(jArr.length) || this.mDataType != 4 || checkOverflowForUnsignedLong(jArr)) {
            return false;
        }
        this.mValue = jArr;
        this.mComponentCountActual = jArr.length;
        return true;
    }

    public boolean setValue(long j) {
        return setValue(new long[]{j});
    }

    public boolean setValue(String str) {
        short s = this.mDataType;
        if (s != 2 && s != 7) {
            return false;
        }
        byte[] bytes = str.getBytes(US_ASCII);
        if (bytes.length > 0) {
            if (!(bytes[bytes.length - 1] == 0 || this.mDataType == 7)) {
                bytes = Arrays.copyOf(bytes, bytes.length + 1);
            }
        } else if (this.mDataType == 2 && this.mComponentCountActual == 1) {
            bytes = new byte[]{0};
        }
        int length = bytes.length;
        if (checkBadComponentCount(length)) {
            return false;
        }
        this.mComponentCountActual = length;
        this.mValue = bytes;
        return true;
    }

    public boolean setValue(OppoRational[] oppoRationalArr) {
        if (checkBadComponentCount(oppoRationalArr.length)) {
            return false;
        }
        short s = this.mDataType;
        if (s != 5 && s != 10) {
            return false;
        }
        if (this.mDataType == 5 && checkOverflowForUnsignedRational(oppoRationalArr)) {
            return false;
        }
        if (this.mDataType == 10 && checkOverflowForRational(oppoRationalArr)) {
            return false;
        }
        this.mValue = oppoRationalArr;
        this.mComponentCountActual = oppoRationalArr.length;
        return true;
    }

    public boolean setValue(OppoRational oppoRational) {
        return setValue(new OppoRational[]{oppoRational});
    }

    public boolean setValue(byte[] bArr, int i, int i2) {
        if (checkBadComponentCount(i2)) {
            return false;
        }
        short s = this.mDataType;
        if (s != 1 && s != 7) {
            return false;
        }
        this.mValue = new byte[i2];
        System.arraycopy(bArr, i, this.mValue, 0, i2);
        this.mComponentCountActual = i2;
        return true;
    }

    public boolean setValue(byte[] bArr) {
        return setValue(bArr, 0, bArr.length);
    }

    public boolean setValue(byte b2) {
        return setValue(new byte[]{b2});
    }

    public boolean setValue(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Short) {
            return setValue((int) ((Short) obj).shortValue() & OppoExifInterface.ColorSpace.UNCALIBRATED);
        }
        if (obj instanceof String) {
            return setValue((String) obj);
        }
        if (obj instanceof int[]) {
            return setValue((int[]) obj);
        }
        if (obj instanceof long[]) {
            return setValue((long[]) obj);
        }
        if (obj instanceof OppoRational) {
            return setValue((OppoRational) obj);
        }
        if (obj instanceof OppoRational[]) {
            return setValue((OppoRational[]) obj);
        }
        if (obj instanceof byte[]) {
            return setValue((byte[]) obj);
        }
        if (obj instanceof Integer) {
            return setValue(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return setValue(((Long) obj).longValue());
        }
        if (obj instanceof Byte) {
            return setValue(((Byte) obj).byteValue());
        }
        if (obj instanceof Short[]) {
            Short[] shArr = (Short[]) obj;
            int[] iArr = new int[shArr.length];
            for (int i = 0; i < shArr.length; i++) {
                iArr[i] = shArr[i] == null ? 0 : shArr[i].shortValue() & OppoExifInterface.ColorSpace.UNCALIBRATED;
            }
            return setValue(iArr);
        } else if (obj instanceof Integer[]) {
            Integer[] numArr = (Integer[]) obj;
            int[] iArr2 = new int[numArr.length];
            for (int i2 = 0; i2 < numArr.length; i2++) {
                iArr2[i2] = numArr[i2] == null ? 0 : numArr[i2].intValue();
            }
            return setValue(iArr2);
        } else if (obj instanceof Long[]) {
            Long[] lArr = (Long[]) obj;
            long[] jArr = new long[lArr.length];
            for (int i3 = 0; i3 < lArr.length; i3++) {
                jArr[i3] = lArr[i3] == null ? 0 : lArr[i3].longValue();
            }
            return setValue(jArr);
        } else if (!(obj instanceof Byte[])) {
            return false;
        } else {
            Byte[] bArr = (Byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            for (int i4 = 0; i4 < bArr.length; i4++) {
                bArr2[i4] = bArr[i4] == null ? 0 : bArr[i4].byteValue();
            }
            return setValue(bArr2);
        }
    }

    public boolean setTimeValue(long j) {
        boolean value;
        synchronized (TIME_FORMAT) {
            value = setValue(TIME_FORMAT.format(new Date(j)));
        }
        return value;
    }

    public String getValueAsString() {
        Object obj = this.mValue;
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof byte[]) {
            return new String((byte[]) obj, US_ASCII);
        }
        return null;
    }

    public String getValueAsString(String str) {
        String valueAsString = getValueAsString();
        return valueAsString == null ? str : valueAsString;
    }

    public byte[] getValueAsBytes() {
        Object obj = this.mValue;
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        return null;
    }

    public byte getValueAsByte(byte b2) {
        byte[] valueAsBytes = getValueAsBytes();
        return (valueAsBytes == null || valueAsBytes.length < 1) ? b2 : valueAsBytes[0];
    }

    public OppoRational[] getValueAsRationals() {
        Object obj = this.mValue;
        if (obj instanceof OppoRational[]) {
            return (OppoRational[]) obj;
        }
        return null;
    }

    public OppoRational getValueAsRational(OppoRational oppoRational) {
        OppoRational[] valueAsRationals = getValueAsRationals();
        return (valueAsRationals == null || valueAsRationals.length < 1) ? oppoRational : valueAsRationals[0];
    }

    public OppoRational getValueAsRational(long j) {
        return getValueAsRational(new OppoRational(j, 1));
    }

    public int[] getValueAsInts() {
        Object obj = this.mValue;
        int[] iArr = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            iArr = new int[jArr.length];
            for (int i = 0; i < jArr.length; i++) {
                iArr[i] = (int) jArr[i];
            }
        }
        return iArr;
    }

    public int getValueAsInt(int i) {
        int[] valueAsInts = getValueAsInts();
        return (valueAsInts == null || valueAsInts.length < 1) ? i : valueAsInts[0];
    }

    public long[] getValueAsLongs() {
        Object obj = this.mValue;
        if (obj instanceof long[]) {
            return (long[]) obj;
        }
        return null;
    }

    public long getValueAsLong(long j) {
        long[] valueAsLongs = getValueAsLongs();
        return (valueAsLongs == null || valueAsLongs.length < 1) ? j : valueAsLongs[0];
    }

    public Object getValue() {
        return this.mValue;
    }

    public long forceGetValueAsLong(long j) {
        long[] valueAsLongs = getValueAsLongs();
        if (valueAsLongs != null && valueAsLongs.length >= 1) {
            return valueAsLongs[0];
        }
        byte[] valueAsBytes = getValueAsBytes();
        if (valueAsBytes != null && valueAsBytes.length >= 1) {
            return (long) valueAsBytes[0];
        }
        OppoRational[] valueAsRationals = getValueAsRationals();
        return (valueAsRationals == null || valueAsRationals.length < 1 || valueAsRationals[0].getDenominator() == 0) ? j : (long) valueAsRationals[0].toDouble();
    }

    public String forceGetValueAsString() {
        Object obj = this.mValue;
        if (obj == null) {
            return "";
        }
        if (obj instanceof byte[]) {
            if (this.mDataType == 2) {
                return new String((byte[]) obj, US_ASCII);
            }
            return Arrays.toString((byte[]) obj);
        } else if (obj instanceof long[]) {
            if (((long[]) obj).length == 1) {
                return String.valueOf(((long[]) obj)[0]);
            }
            return Arrays.toString((long[]) obj);
        } else if (!(obj instanceof Object[])) {
            return obj.toString();
        } else {
            if (((Object[]) obj).length != 1) {
                return Arrays.toString((Object[]) obj);
            }
            Object obj2 = ((Object[]) obj)[0];
            if (obj2 == null) {
                return "";
            }
            return obj2.toString();
        }
    }

    /* access modifiers changed from: protected */
    public long getValueAt(int i) {
        Object obj = this.mValue;
        if (obj instanceof long[]) {
            return ((long[]) obj)[i];
        }
        if (obj instanceof byte[]) {
            return (long) ((byte[]) obj)[i];
        }
        throw new IllegalArgumentException("Cannot get integer value from " + convertTypeToString(this.mDataType));
    }

    /* access modifiers changed from: protected */
    public String getString() {
        if (this.mDataType == 2) {
            return new String((byte[]) this.mValue, US_ASCII);
        }
        throw new IllegalArgumentException("Cannot get ASCII value from " + convertTypeToString(this.mDataType));
    }

    /* access modifiers changed from: protected */
    public byte[] getStringByte() {
        return (byte[]) this.mValue;
    }

    /* access modifiers changed from: protected */
    public OppoRational getRational(int i) {
        short s = this.mDataType;
        if (s == 10 || s == 5) {
            return ((OppoRational[]) this.mValue)[i];
        }
        throw new IllegalArgumentException("Cannot get RATIONAL value from " + convertTypeToString(this.mDataType));
    }

    /* access modifiers changed from: protected */
    public void getBytes(byte[] bArr) {
        getBytes(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: protected */
    public void getBytes(byte[] bArr, int i, int i2) {
        short s = this.mDataType;
        if (s == 7 || s == 1) {
            Object obj = this.mValue;
            int i3 = this.mComponentCountActual;
            if (i2 > i3) {
                i2 = i3;
            }
            System.arraycopy(obj, 0, bArr, i, i2);
            return;
        }
        throw new IllegalArgumentException("Cannot get BYTE value from " + convertTypeToString(this.mDataType));
    }

    /* access modifiers changed from: protected */
    public int getOffset() {
        return this.mOffset;
    }

    /* access modifiers changed from: protected */
    public void setOffset(int i) {
        this.mOffset = i;
    }

    /* access modifiers changed from: protected */
    public void setHasDefinedCount(boolean z) {
        this.mHasDefinedDefaultComponentCount = z;
    }

    /* access modifiers changed from: protected */
    public boolean hasDefinedCount() {
        return this.mHasDefinedDefaultComponentCount;
    }

    private boolean checkBadComponentCount(int i) {
        return this.mHasDefinedDefaultComponentCount && this.mComponentCountActual != i;
    }

    private boolean checkOverflowForUnsignedShort(int[] iArr) {
        for (int i : iArr) {
            if (i > 65535 || i < 0) {
                return true;
            }
        }
        return false;
    }

    private boolean checkOverflowForUnsignedLong(long[] jArr) {
        for (long j : jArr) {
            if (j < 0 || j > UNSIGNED_LONG_MAX) {
                return true;
            }
        }
        return false;
    }

    private boolean checkOverflowForUnsignedLong(int[] iArr) {
        for (int i : iArr) {
            if (i < 0) {
                return true;
            }
        }
        return false;
    }

    private boolean checkOverflowForUnsignedRational(OppoRational[] oppoRationalArr) {
        for (OppoRational oppoRational : oppoRationalArr) {
            if (oppoRational.getNumerator() < 0 || oppoRational.getDenominator() < 0 || oppoRational.getNumerator() > UNSIGNED_LONG_MAX || oppoRational.getDenominator() > UNSIGNED_LONG_MAX) {
                return true;
            }
        }
        return false;
    }

    private boolean checkOverflowForRational(OppoRational[] oppoRationalArr) {
        for (OppoRational oppoRational : oppoRationalArr) {
            if (oppoRational.getNumerator() < LONG_MIN || oppoRational.getDenominator() < LONG_MIN || oppoRational.getNumerator() > LONG_MAX || oppoRational.getDenominator() > LONG_MAX) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof OppoExifTag)) {
            return false;
        }
        OppoExifTag oppoExifTag = (OppoExifTag) obj;
        if (oppoExifTag.mTagId != this.mTagId || oppoExifTag.mComponentCountActual != this.mComponentCountActual || oppoExifTag.mDataType != this.mDataType) {
            return false;
        }
        Object obj2 = this.mValue;
        if (obj2 != null) {
            Object obj3 = oppoExifTag.mValue;
            if (obj3 == null) {
                return false;
            }
            if (obj2 instanceof long[]) {
                if (!(obj3 instanceof long[])) {
                    return false;
                }
                return Arrays.equals((long[]) obj2, (long[]) obj3);
            } else if (obj2 instanceof OppoRational[]) {
                if (!(obj3 instanceof OppoRational[])) {
                    return false;
                }
                return Arrays.equals((OppoRational[]) obj2, (OppoRational[]) obj3);
            } else if (!(obj2 instanceof byte[])) {
                return obj2.equals(obj3);
            } else {
                if (!(obj3 instanceof byte[])) {
                    return false;
                }
                return Arrays.equals((byte[]) obj2, (byte[]) obj3);
            }
        } else if (oppoExifTag.mValue == null) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        return String.format("tag id: %04X\n", new Object[]{Short.valueOf(this.mTagId)}) + "ifd id: " + this.mIfd + "\ntype: " + convertTypeToString(this.mDataType) + "\ncount: " + this.mComponentCountActual + "\noffset: " + this.mOffset + "\nvalue: " + forceGetValueAsString() + "\n";
    }
}
