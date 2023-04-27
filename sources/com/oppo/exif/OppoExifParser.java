package com.oppo.exif;

import android.util.Log;
import com.oppo.exif.OppoExifInterface;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.codec.CharEncoding;

class OppoExifParser {
    protected static final short BIG_ENDIAN_TAG = 19789;
    protected static final int DEFAULT_IFD0_OFFSET = 8;
    public static final int EVENT_COMPRESSED_IMAGE = 3;
    public static final int EVENT_END = 5;
    public static final int EVENT_NEW_TAG = 1;
    public static final int EVENT_START_OF_IFD = 0;
    public static final int EVENT_UNCOMPRESSED_STRIP = 4;
    public static final int EVENT_VALUE_OF_REGISTERED_TAG = 2;
    protected static final int EXIF_HEADER = 1165519206;
    protected static final short EXIF_HEADER_TAIL = 0;
    protected static final short LITTLE_ENDIAN_TAG = 18761;
    private static final boolean LOGV = false;
    protected static final int OFFSET_SIZE = 2;
    public static final int OPTION_IFD_0 = 1;
    public static final int OPTION_IFD_1 = 2;
    public static final int OPTION_IFD_EXIF = 4;
    public static final int OPTION_IFD_GPS = 8;
    public static final int OPTION_IFD_INTEROPERABILITY = 16;
    public static final int OPTION_THUMBNAIL = 32;
    private static final String TAG = "ExifParser";
    private static final short TAG_EXIF_IFD = OppoExifInterface.getTrueTagKey(OppoExifInterface.TAG_EXIF_IFD);
    private static final short TAG_GPS_IFD = OppoExifInterface.getTrueTagKey(OppoExifInterface.TAG_GPS_IFD);
    private static final short TAG_INTEROPERABILITY_IFD = OppoExifInterface.getTrueTagKey(OppoExifInterface.TAG_INTEROPERABILITY_IFD);
    private static final short TAG_JPEG_INTERCHANGE_FORMAT = OppoExifInterface.getTrueTagKey(OppoExifInterface.TAG_JPEG_INTERCHANGE_FORMAT);
    private static final short TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = OppoExifInterface.getTrueTagKey(OppoExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
    protected static final int TAG_SIZE = 12;
    private static final short TAG_STRIP_BYTE_COUNTS = OppoExifInterface.getTrueTagKey(OppoExifInterface.TAG_STRIP_BYTE_COUNTS);
    private static final short TAG_STRIP_OFFSETS = OppoExifInterface.getTrueTagKey(OppoExifInterface.TAG_STRIP_OFFSETS);
    protected static final short TIFF_HEADER_TAIL = 42;
    private static final Charset US_ASCII = Charset.forName(CharEncoding.US_ASCII);
    private int mApp1End;
    private boolean mContainExifData = false;
    private final TreeMap<Integer, Object> mCorrespondingEvent = new TreeMap<>();
    private byte[] mDataAboveIfd0;
    private int mIfd0Position;
    private int mIfdStartOffset = 0;
    private int mIfdType;
    private ImageEvent mImageEvent;
    private final OppoExifInterface mInterface;
    private OppoExifTag mJpegSizeTag;
    private boolean mNeedToParseOffsetsInCurrentIfd;
    private int mNumOfTagInIfd = 0;
    private int mOffsetToApp1EndFromSOF = 0;
    private final int mOptions;
    private int mStripCount;
    private OppoExifTag mStripSizeTag;
    private OppoExifTag mTag;
    private int mTiffStartPosition;
    private final OppoCountedDataInputStream mTiffStream;

    private boolean isIfdRequested(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return i == 4 && (this.mOptions & 8) != 0;
                    }
                    if ((this.mOptions & 16) != 0) {
                        return true;
                    }
                    return false;
                } else if ((this.mOptions & 4) != 0) {
                    return true;
                } else {
                    return false;
                }
            } else if ((this.mOptions & 2) != 0) {
                return true;
            } else {
                return false;
            }
        } else if ((this.mOptions & 1) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isThumbnailRequested() {
        return (this.mOptions & 32) != 0;
    }

    private OppoExifParser(InputStream inputStream, int i, OppoExifInterface oppoExifInterface) throws IOException, OppoExifInvalidFormatException {
        if (inputStream != null) {
            this.mInterface = oppoExifInterface;
            this.mContainExifData = seekTiffData(inputStream);
            this.mTiffStream = new OppoCountedDataInputStream(inputStream);
            this.mOptions = i;
            if (this.mContainExifData) {
                parseTiffHeader();
                long readUnsignedInt = this.mTiffStream.readUnsignedInt();
                if (readUnsignedInt <= 2147483647L) {
                    int i2 = (int) readUnsignedInt;
                    this.mIfd0Position = i2;
                    this.mIfdType = 0;
                    if (isIfdRequested(0) || needToParseOffsetsInCurrentIfd()) {
                        registerIfd(0, readUnsignedInt);
                        if (readUnsignedInt != 8) {
                            this.mDataAboveIfd0 = new byte[(i2 - 8)];
                            read(this.mDataAboveIfd0);
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new OppoExifInvalidFormatException("Invalid offset " + readUnsignedInt);
            }
            return;
        }
        throw new IOException("Null argument inputStream to ExifParser");
    }

    protected static OppoExifParser parse(InputStream inputStream, int i, OppoExifInterface oppoExifInterface) throws IOException, OppoExifInvalidFormatException {
        return new OppoExifParser(inputStream, i, oppoExifInterface);
    }

    protected static OppoExifParser parse(InputStream inputStream, OppoExifInterface oppoExifInterface) throws IOException, OppoExifInvalidFormatException {
        return new OppoExifParser(inputStream, 63, oppoExifInterface);
    }

    /* access modifiers changed from: protected */
    public int next() throws IOException, OppoExifInvalidFormatException {
        if (!this.mContainExifData) {
            return 5;
        }
        int readByteCount = this.mTiffStream.getReadByteCount();
        int i = this.mIfdStartOffset + 2 + (this.mNumOfTagInIfd * 12);
        if (readByteCount < i) {
            this.mTag = readTag();
            OppoExifTag oppoExifTag = this.mTag;
            if (oppoExifTag == null) {
                return next();
            }
            if (this.mNeedToParseOffsetsInCurrentIfd) {
                checkOffsetOrImageTag(oppoExifTag);
            }
            return 1;
        }
        if (readByteCount == i) {
            if (this.mIfdType == 0) {
                long readUnsignedLong = readUnsignedLong();
                if ((isIfdRequested(1) || isThumbnailRequested()) && readUnsignedLong != 0) {
                    registerIfd(1, readUnsignedLong);
                }
            } else {
                int intValue = this.mCorrespondingEvent.size() > 0 ? this.mCorrespondingEvent.firstEntry().getKey().intValue() - this.mTiffStream.getReadByteCount() : 4;
                if (intValue < 4) {
                    Log.w(TAG, "Invalid size of link to next IFD: " + intValue);
                } else {
                    long readUnsignedLong2 = readUnsignedLong();
                    if (readUnsignedLong2 != 0) {
                        Log.w(TAG, "Invalid link to next IFD: " + readUnsignedLong2);
                    }
                }
            }
        }
        while (this.mCorrespondingEvent.size() != 0) {
            Map.Entry<Integer, Object> pollFirstEntry = this.mCorrespondingEvent.pollFirstEntry();
            Object value = pollFirstEntry.getValue();
            try {
                skipTo(pollFirstEntry.getKey().intValue());
                if (value instanceof IfdEvent) {
                    IfdEvent ifdEvent = (IfdEvent) value;
                    this.mIfdType = ifdEvent.ifd;
                    this.mNumOfTagInIfd = this.mTiffStream.readUnsignedShort();
                    this.mIfdStartOffset = pollFirstEntry.getKey().intValue();
                    if ((this.mNumOfTagInIfd * 12) + this.mIfdStartOffset + 2 > this.mApp1End) {
                        Log.w(TAG, "Invalid size of IFD " + this.mIfdType);
                        return 5;
                    }
                    this.mNeedToParseOffsetsInCurrentIfd = needToParseOffsetsInCurrentIfd();
                    if (ifdEvent.isRequested) {
                        return 0;
                    }
                    skipRemainingTagsInCurrentIfd();
                } else if (value instanceof ImageEvent) {
                    this.mImageEvent = (ImageEvent) value;
                    return this.mImageEvent.type;
                } else {
                    ExifTagEvent exifTagEvent = (ExifTagEvent) value;
                    this.mTag = exifTagEvent.tag;
                    if (this.mTag.getDataType() != 7) {
                        readFullTagValue(this.mTag);
                        checkOffsetOrImageTag(this.mTag);
                    }
                    if (exifTagEvent.isRequested) {
                        return 2;
                    }
                }
            } catch (IOException unused) {
                Log.w(TAG, "Failed to skip to data at: " + pollFirstEntry.getKey() + " for " + value.getClass().getName() + ", the file may be broken.");
            }
        }
        return 5;
    }

    /* access modifiers changed from: protected */
    public void skipRemainingTagsInCurrentIfd() throws IOException, OppoExifInvalidFormatException {
        int i = this.mIfdStartOffset + 2 + (this.mNumOfTagInIfd * 12);
        int readByteCount = this.mTiffStream.getReadByteCount();
        if (readByteCount <= i) {
            if (this.mNeedToParseOffsetsInCurrentIfd) {
                while (readByteCount < i) {
                    this.mTag = readTag();
                    readByteCount += 12;
                    OppoExifTag oppoExifTag = this.mTag;
                    if (oppoExifTag != null) {
                        checkOffsetOrImageTag(oppoExifTag);
                    }
                }
            } else {
                skipTo(i);
            }
            long readUnsignedLong = readUnsignedLong();
            if (this.mIfdType != 0) {
                return;
            }
            if ((isIfdRequested(1) || isThumbnailRequested()) && readUnsignedLong > 0) {
                registerIfd(1, readUnsignedLong);
            }
        }
    }

    private boolean needToParseOffsetsInCurrentIfd() {
        int i = this.mIfdType;
        if (i != 0) {
            if (i == 1) {
                return isThumbnailRequested();
            }
            if (i != 2) {
                return false;
            }
            return isIfdRequested(3);
        } else if (isIfdRequested(2) || isIfdRequested(4) || isIfdRequested(3) || isIfdRequested(1)) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public OppoExifTag getTag() {
        return this.mTag;
    }

    /* access modifiers changed from: protected */
    public int getTagCountInCurrentIfd() {
        return this.mNumOfTagInIfd;
    }

    /* access modifiers changed from: protected */
    public int getCurrentIfd() {
        return this.mIfdType;
    }

    /* access modifiers changed from: protected */
    public int getStripIndex() {
        return this.mImageEvent.stripIndex;
    }

    /* access modifiers changed from: protected */
    public int getStripCount() {
        return this.mStripCount;
    }

    /* access modifiers changed from: protected */
    public int getStripSize() {
        OppoExifTag oppoExifTag = this.mStripSizeTag;
        if (oppoExifTag == null) {
            return 0;
        }
        return (int) oppoExifTag.getValueAt(0);
    }

    /* access modifiers changed from: protected */
    public int getCompressedImageSize() {
        OppoExifTag oppoExifTag = this.mJpegSizeTag;
        if (oppoExifTag == null) {
            return 0;
        }
        return (int) oppoExifTag.getValueAt(0);
    }

    private void skipTo(int i) throws IOException {
        this.mTiffStream.skipTo((long) i);
        while (!this.mCorrespondingEvent.isEmpty() && this.mCorrespondingEvent.firstKey().intValue() < i) {
            this.mCorrespondingEvent.pollFirstEntry();
        }
    }

    /* access modifiers changed from: protected */
    public void registerForTagValue(OppoExifTag oppoExifTag) {
        if (oppoExifTag.getOffset() >= this.mTiffStream.getReadByteCount()) {
            this.mCorrespondingEvent.put(Integer.valueOf(oppoExifTag.getOffset()), new ExifTagEvent(oppoExifTag, true));
        }
    }

    private void registerIfd(int i, long j) {
        this.mCorrespondingEvent.put(Integer.valueOf((int) j), new IfdEvent(i, isIfdRequested(i)));
    }

    private void registerCompressedImage(long j) {
        this.mCorrespondingEvent.put(Integer.valueOf((int) j), new ImageEvent(3));
    }

    private void registerUncompressedStrip(int i, long j) {
        this.mCorrespondingEvent.put(Integer.valueOf((int) j), new ImageEvent(4, i));
    }

    private OppoExifTag readTag() throws IOException, OppoExifInvalidFormatException {
        short readShort = this.mTiffStream.readShort();
        short readShort2 = this.mTiffStream.readShort();
        long readUnsignedInt = this.mTiffStream.readUnsignedInt();
        if (readUnsignedInt > 2147483647L) {
            throw new OppoExifInvalidFormatException("Number of component is larger then Integer.MAX_VALUE");
        } else if (!OppoExifTag.isValidType(readShort2)) {
            Log.w(TAG, String.format("Tag %04x: Invalid data type %d", new Object[]{Short.valueOf(readShort), Short.valueOf(readShort2)}));
            this.mTiffStream.skip(4);
            return null;
        } else {
            int i = (int) readUnsignedInt;
            OppoExifTag oppoExifTag = new OppoExifTag(readShort, readShort2, i, this.mIfdType, i != 0);
            int dataSize = oppoExifTag.getDataSize();
            if (dataSize > 4) {
                long readUnsignedInt2 = this.mTiffStream.readUnsignedInt();
                if (readUnsignedInt2 > 2147483647L) {
                    throw new OppoExifInvalidFormatException("offset is larger then Integer.MAX_VALUE");
                } else if (readUnsignedInt2 >= ((long) this.mIfd0Position) || readShort2 != 7) {
                    oppoExifTag.setOffset((int) readUnsignedInt2);
                } else {
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.mDataAboveIfd0, ((int) readUnsignedInt2) - 8, bArr, 0, i);
                    oppoExifTag.setValue(bArr);
                }
            } else {
                boolean hasDefinedCount = oppoExifTag.hasDefinedCount();
                oppoExifTag.setHasDefinedCount(false);
                readFullTagValue(oppoExifTag);
                oppoExifTag.setHasDefinedCount(hasDefinedCount);
                this.mTiffStream.skip((long) (4 - dataSize));
                oppoExifTag.setOffset(this.mTiffStream.getReadByteCount() - 4);
            }
            return oppoExifTag;
        }
    }

    private void checkOffsetOrImageTag(OppoExifTag oppoExifTag) {
        if (oppoExifTag.getComponentCount() != 0) {
            short tagId = oppoExifTag.getTagId();
            int ifd = oppoExifTag.getIfd();
            if (tagId != TAG_EXIF_IFD || !checkAllowed(ifd, OppoExifInterface.TAG_EXIF_IFD)) {
                if (tagId != TAG_GPS_IFD || !checkAllowed(ifd, OppoExifInterface.TAG_GPS_IFD)) {
                    if (tagId != TAG_INTEROPERABILITY_IFD || !checkAllowed(ifd, OppoExifInterface.TAG_INTEROPERABILITY_IFD)) {
                        if (tagId != TAG_JPEG_INTERCHANGE_FORMAT || !checkAllowed(ifd, OppoExifInterface.TAG_JPEG_INTERCHANGE_FORMAT)) {
                            if (tagId != TAG_JPEG_INTERCHANGE_FORMAT_LENGTH || !checkAllowed(ifd, OppoExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH)) {
                                if (tagId != TAG_STRIP_OFFSETS || !checkAllowed(ifd, OppoExifInterface.TAG_STRIP_OFFSETS)) {
                                    if (tagId == TAG_STRIP_BYTE_COUNTS && checkAllowed(ifd, OppoExifInterface.TAG_STRIP_BYTE_COUNTS) && isThumbnailRequested() && oppoExifTag.hasValue()) {
                                        this.mStripSizeTag = oppoExifTag;
                                    }
                                } else if (!isThumbnailRequested()) {
                                } else {
                                    if (oppoExifTag.hasValue()) {
                                        for (int i = 0; i < oppoExifTag.getComponentCount(); i++) {
                                            registerUncompressedStrip(i, oppoExifTag.getValueAt(i));
                                        }
                                        return;
                                    }
                                    this.mCorrespondingEvent.put(Integer.valueOf(oppoExifTag.getOffset()), new ExifTagEvent(oppoExifTag, false));
                                }
                            } else if (isThumbnailRequested()) {
                                this.mJpegSizeTag = oppoExifTag;
                            }
                        } else if (isThumbnailRequested()) {
                            registerCompressedImage(oppoExifTag.getValueAt(0));
                        }
                    } else if (isIfdRequested(3)) {
                        registerIfd(3, oppoExifTag.getValueAt(0));
                    }
                } else if (isIfdRequested(4)) {
                    registerIfd(4, oppoExifTag.getValueAt(0));
                }
            } else if (isIfdRequested(2) || isIfdRequested(3)) {
                registerIfd(2, oppoExifTag.getValueAt(0));
            }
        }
    }

    private boolean checkAllowed(int i, int i2) {
        int i3 = this.mInterface.getTagInfo().get(i2);
        if (i3 == 0) {
            return false;
        }
        return OppoExifInterface.isIfdAllowed(i3, i);
    }

    /* access modifiers changed from: protected */
    public void readFullTagValue(OppoExifTag oppoExifTag) throws IOException {
        try {
            short dataType = oppoExifTag.getDataType();
            if (dataType == 2 || dataType == 7 || dataType == 1) {
                int componentCount = oppoExifTag.getComponentCount();
                if (this.mCorrespondingEvent.size() > 0 && this.mCorrespondingEvent.firstEntry().getKey().intValue() < this.mTiffStream.getReadByteCount() + componentCount) {
                    Object value = this.mCorrespondingEvent.firstEntry().getValue();
                    if (value instanceof ImageEvent) {
                        Log.w(TAG, "Thumbnail overlaps value for tag: \n" + oppoExifTag.toString());
                        Map.Entry<Integer, Object> pollFirstEntry = this.mCorrespondingEvent.pollFirstEntry();
                        Log.w(TAG, "Invalid thumbnail offset: " + pollFirstEntry.getKey());
                    } else {
                        if (value instanceof IfdEvent) {
                            Log.w(TAG, "Ifd " + ((IfdEvent) value).ifd + " overlaps value for tag: \n" + oppoExifTag.toString());
                        } else if (value instanceof ExifTagEvent) {
                            Log.w(TAG, "Tag value for tag: \n" + ((ExifTagEvent) value).tag.toString() + " overlaps value for tag: \n" + oppoExifTag.toString());
                        }
                        int intValue = this.mCorrespondingEvent.firstEntry().getKey().intValue() - this.mTiffStream.getReadByteCount();
                        Log.w(TAG, "Invalid size of tag: \n" + oppoExifTag.toString() + " setting count to: " + intValue);
                        oppoExifTag.forceSetComponentCount(intValue);
                    }
                }
            }
            int i = 0;
            switch (oppoExifTag.getDataType()) {
                case 1:
                case 7:
                    byte[] bArr = new byte[oppoExifTag.getComponentCount()];
                    read(bArr);
                    oppoExifTag.setValue(bArr);
                    return;
                case 2:
                    oppoExifTag.setValue(readString(oppoExifTag.getComponentCount()));
                    return;
                case 3:
                    int[] iArr = new int[oppoExifTag.getComponentCount()];
                    int length = iArr.length;
                    while (i < length) {
                        iArr[i] = readUnsignedShort();
                        i++;
                    }
                    oppoExifTag.setValue(iArr);
                    return;
                case 4:
                    long[] jArr = new long[oppoExifTag.getComponentCount()];
                    int length2 = jArr.length;
                    while (i < length2) {
                        jArr[i] = readUnsignedLong();
                        i++;
                    }
                    oppoExifTag.setValue(jArr);
                    return;
                case 5:
                    OppoRational[] oppoRationalArr = new OppoRational[oppoExifTag.getComponentCount()];
                    int length3 = oppoRationalArr.length;
                    while (i < length3) {
                        oppoRationalArr[i] = readUnsignedRational();
                        i++;
                    }
                    oppoExifTag.setValue(oppoRationalArr);
                    return;
                case 9:
                    int[] iArr2 = new int[oppoExifTag.getComponentCount()];
                    int length4 = iArr2.length;
                    while (i < length4) {
                        iArr2[i] = readLong();
                        i++;
                    }
                    oppoExifTag.setValue(iArr2);
                    return;
                case 10:
                    OppoRational[] oppoRationalArr2 = new OppoRational[oppoExifTag.getComponentCount()];
                    int length5 = oppoRationalArr2.length;
                    while (i < length5) {
                        oppoRationalArr2[i] = readRational();
                        i++;
                    }
                    oppoExifTag.setValue(oppoRationalArr2);
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            Log.e(TAG, "readFullTagValue e = " + th);
        }
    }

    private void parseTiffHeader() throws IOException, OppoExifInvalidFormatException {
        short readShort = this.mTiffStream.readShort();
        if (18761 == readShort) {
            this.mTiffStream.setByteOrder(ByteOrder.LITTLE_ENDIAN);
        } else if (19789 == readShort) {
            this.mTiffStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        } else {
            throw new OppoExifInvalidFormatException("Invalid TIFF header");
        }
        if (this.mTiffStream.readShort() != 42) {
            throw new OppoExifInvalidFormatException("Invalid TIFF header");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005e, code lost:
        android.util.Log.w(TAG, "Invalid JPEG format.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean seekTiffData(java.io.InputStream r8) throws java.io.IOException, com.oppo.exif.OppoExifInvalidFormatException {
        /*
            r7 = this;
            com.oppo.exif.OppoCountedDataInputStream r0 = new com.oppo.exif.OppoCountedDataInputStream
            r0.<init>(r8)
            short r8 = r0.readShort()
            r1 = -40
            if (r8 != r1) goto L_0x0066
            short r8 = r0.readShort()
        L_0x0011:
            r1 = -39
            r2 = 0
            if (r8 == r1) goto L_0x0065
            boolean r1 = com.oppo.exif.OppoJpegHeader.isSofMarker(r8)
            if (r1 != 0) goto L_0x0065
            int r1 = r0.readUnsignedShort()
            r3 = -31
            if (r8 != r3) goto L_0x004a
            r8 = 8
            if (r1 < r8) goto L_0x004a
            int r8 = r0.readInt()
            short r3 = r0.readShort()
            int r1 = r1 + -6
            r4 = 1165519206(0x45786966, float:3974.5874)
            if (r8 != r4) goto L_0x004a
            if (r3 != 0) goto L_0x004a
            int r8 = r0.getReadByteCount()
            r7.mTiffStartPosition = r8
            r7.mApp1End = r1
            int r8 = r7.mTiffStartPosition
            int r0 = r7.mApp1End
            int r8 = r8 + r0
            r7.mOffsetToApp1EndFromSOF = r8
            r8 = 1
            return r8
        L_0x004a:
            r8 = 2
            if (r1 < r8) goto L_0x005e
            int r1 = r1 + -2
            long r3 = (long) r1
            long r5 = r0.skip(r3)
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 == 0) goto L_0x0059
            goto L_0x005e
        L_0x0059:
            short r8 = r0.readShort()
            goto L_0x0011
        L_0x005e:
            java.lang.String r8 = "ExifParser"
            java.lang.String r0 = "Invalid JPEG format."
            android.util.Log.w(r8, r0)
        L_0x0065:
            return r2
        L_0x0066:
            com.oppo.exif.OppoExifInvalidFormatException r8 = new com.oppo.exif.OppoExifInvalidFormatException
            java.lang.String r0 = "Invalid JPEG format"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.exif.OppoExifParser.seekTiffData(java.io.InputStream):boolean");
    }

    /* access modifiers changed from: protected */
    public int getOffsetToExifEndFromSOF() {
        return this.mOffsetToApp1EndFromSOF;
    }

    /* access modifiers changed from: protected */
    public int getTiffStartPosition() {
        return this.mTiffStartPosition;
    }

    /* access modifiers changed from: protected */
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.mTiffStream.read(bArr, i, i2);
    }

    /* access modifiers changed from: protected */
    public int read(byte[] bArr) throws IOException {
        return this.mTiffStream.read(bArr);
    }

    /* access modifiers changed from: protected */
    public String readString(int i) throws IOException {
        return readString(i, US_ASCII);
    }

    /* access modifiers changed from: protected */
    public String readString(int i, Charset charset) throws IOException {
        return i > 0 ? this.mTiffStream.readString(i, charset) : "";
    }

    /* access modifiers changed from: protected */
    public int readUnsignedShort() throws IOException {
        return this.mTiffStream.readShort() & OppoExifInterface.ColorSpace.UNCALIBRATED;
    }

    /* access modifiers changed from: protected */
    public long readUnsignedLong() throws IOException {
        return ((long) readLong()) & 4294967295L;
    }

    /* access modifiers changed from: protected */
    public OppoRational readUnsignedRational() throws IOException {
        return new OppoRational(readUnsignedLong(), readUnsignedLong());
    }

    /* access modifiers changed from: protected */
    public int readLong() throws IOException {
        return this.mTiffStream.readInt();
    }

    /* access modifiers changed from: protected */
    public OppoRational readRational() throws IOException {
        return new OppoRational((long) readLong(), (long) readLong());
    }

    private static class ImageEvent {
        int stripIndex;
        int type;

        ImageEvent(int i) {
            this.stripIndex = 0;
            this.type = i;
        }

        ImageEvent(int i, int i2) {
            this.type = i;
            this.stripIndex = i2;
        }
    }

    private static class IfdEvent {
        int ifd;
        boolean isRequested;

        IfdEvent(int i, boolean z) {
            this.ifd = i;
            this.isRequested = z;
        }
    }

    private static class ExifTagEvent {
        boolean isRequested;
        OppoExifTag tag;

        ExifTagEvent(OppoExifTag oppoExifTag, boolean z) {
            this.tag = oppoExifTag;
            this.isRequested = z;
        }
    }

    /* access modifiers changed from: protected */
    public ByteOrder getByteOrder() {
        return this.mTiffStream.getByteOrder();
    }
}
