package com.oppo.exif;

import com.oppo.exif.OppoExifInterface;
import java.io.BufferedOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class OppoExifOutputStream extends FilterOutputStream {
    private static final boolean DEBUG = false;
    private static final int EXIF_HEADER = 1165519206;
    private static final int MAX_EXIF_SIZE = 65535;
    private static final int STATE_FRAME_HEADER = 1;
    private static final int STATE_JPEG_DATA = 2;
    private static final int STATE_SOI = 0;
    private static final int STREAMBUFFER_SIZE = 65536;
    private static final String TAG = "ExifOutputStream";
    private static final short TAG_SIZE = 12;
    private static final short TIFF_BIG_ENDIAN = 19789;
    private static final short TIFF_HEADER = 42;
    private static final short TIFF_HEADER_SIZE = 8;
    private static final short TIFF_LITTLE_ENDIAN = 18761;
    private ByteBuffer mBuffer = ByteBuffer.allocate(4);
    private int mByteToCopy;
    private int mByteToSkip;
    private OppoExifData mExifData;
    private final OppoExifInterface mInterface;
    private byte[] mSingleByteArray = new byte[1];
    private int mState = 0;

    protected OppoExifOutputStream(OutputStream outputStream, OppoExifInterface oppoExifInterface) {
        super(new BufferedOutputStream(outputStream, 65536));
        this.mInterface = oppoExifInterface;
    }

    /* access modifiers changed from: protected */
    public void setExifData(OppoExifData oppoExifData) {
        this.mExifData = oppoExifData;
    }

    /* access modifiers changed from: protected */
    public OppoExifData getExifData() {
        return this.mExifData;
    }

    private int requestByteToBuffer(int i, byte[] bArr, int i2, int i3) {
        int position = i - this.mBuffer.position();
        if (i3 <= position) {
            position = i3;
        }
        this.mBuffer.put(bArr, i2, position);
        return position;
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        while (true) {
            if ((this.mByteToSkip > 0 || this.mByteToCopy > 0 || this.mState != 2) && i2 > 0) {
                int i3 = this.mByteToSkip;
                if (i3 > 0) {
                    if (i2 <= i3) {
                        i3 = i2;
                    }
                    i2 -= i3;
                    this.mByteToSkip -= i3;
                    i += i3;
                }
                int i4 = this.mByteToCopy;
                if (i4 > 0) {
                    if (i2 <= i4) {
                        i4 = i2;
                    }
                    this.out.write(bArr, i, i4);
                    i2 -= i4;
                    this.mByteToCopy -= i4;
                    i += i4;
                }
                if (i2 != 0) {
                    int i5 = this.mState;
                    if (i5 == 0) {
                        int requestByteToBuffer = requestByteToBuffer(2, bArr, i, i2);
                        i += requestByteToBuffer;
                        i2 -= requestByteToBuffer;
                        if (this.mBuffer.position() >= 2) {
                            this.mBuffer.rewind();
                            if (this.mBuffer.getShort() == -40) {
                                this.out.write(this.mBuffer.array(), 0, 2);
                                this.mState = 1;
                                this.mBuffer.rewind();
                                writeExifData();
                            } else {
                                throw new IOException("Not a valid jpeg image, cannot write exif");
                            }
                        } else {
                            return;
                        }
                    } else if (i5 != 1) {
                        continue;
                    } else {
                        int requestByteToBuffer2 = requestByteToBuffer(4, bArr, i, i2);
                        i += requestByteToBuffer2;
                        i2 -= requestByteToBuffer2;
                        if (this.mBuffer.position() == 2 && this.mBuffer.getShort() == -39) {
                            this.out.write(this.mBuffer.array(), 0, 2);
                            this.mBuffer.rewind();
                        }
                        if (this.mBuffer.position() >= 4) {
                            this.mBuffer.rewind();
                            short s = this.mBuffer.getShort();
                            if (s == -31) {
                                this.mByteToSkip = (this.mBuffer.getShort() & OppoExifInterface.ColorSpace.UNCALIBRATED) - 2;
                                this.mState = 2;
                            } else if (!OppoJpegHeader.isSofMarker(s)) {
                                this.out.write(this.mBuffer.array(), 0, 4);
                                this.mByteToCopy = (this.mBuffer.getShort() & OppoExifInterface.ColorSpace.UNCALIBRATED) - 2;
                            } else {
                                this.out.write(this.mBuffer.array(), 0, 4);
                                this.mState = 2;
                            }
                            this.mBuffer.rewind();
                        } else {
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
        }
        if (i2 > 0) {
            this.out.write(bArr, i, i2);
        }
    }

    public void write(int i) throws IOException {
        byte[] bArr = this.mSingleByteArray;
        bArr[0] = (byte) (i & 255);
        write(bArr);
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    private void writeExifData() throws IOException {
        OppoExifData oppoExifData = this.mExifData;
        if (oppoExifData != null) {
            ArrayList<OppoExifTag> stripNullValueTags = stripNullValueTags(oppoExifData);
            createRequiredIfdAndTag();
            int calculateAllOffset = calculateAllOffset() + 8;
            if (calculateAllOffset <= 65535) {
                OrderedDataOutputStream orderedDataOutputStream = new OrderedDataOutputStream(this.out);
                orderedDataOutputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
                orderedDataOutputStream.writeShort(-31);
                orderedDataOutputStream.writeShort((short) calculateAllOffset);
                orderedDataOutputStream.writeInt(EXIF_HEADER);
                orderedDataOutputStream.writeShort(0);
                if (this.mExifData.getByteOrder() == ByteOrder.BIG_ENDIAN) {
                    orderedDataOutputStream.writeShort(TIFF_BIG_ENDIAN);
                } else {
                    orderedDataOutputStream.writeShort(TIFF_LITTLE_ENDIAN);
                }
                orderedDataOutputStream.setByteOrder(this.mExifData.getByteOrder());
                orderedDataOutputStream.writeShort(TIFF_HEADER);
                orderedDataOutputStream.writeInt(8);
                writeAllTags(orderedDataOutputStream);
                writeThumbnail(orderedDataOutputStream);
                Iterator<OppoExifTag> it = stripNullValueTags.iterator();
                while (it.hasNext()) {
                    this.mExifData.addTag(it.next());
                }
                return;
            }
            throw new IOException("Exif header is too large (>64Kb)");
        }
    }

    private ArrayList<OppoExifTag> stripNullValueTags(OppoExifData oppoExifData) {
        ArrayList<OppoExifTag> arrayList = new ArrayList<>();
        List<OppoExifTag> allTags = oppoExifData.getAllTags();
        if (allTags != null && allTags.size() > 0) {
            for (OppoExifTag next : allTags) {
                if (next.getValue() == null && !OppoExifInterface.isOffsetTag(next.getTagId())) {
                    oppoExifData.removeTag(next.getTagId(), next.getIfd());
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    private void writeThumbnail(OrderedDataOutputStream orderedDataOutputStream) throws IOException {
        if (this.mExifData.hasCompressedThumbnail()) {
            orderedDataOutputStream.write(this.mExifData.getCompressedThumbnail());
        } else if (this.mExifData.hasUncompressedStrip()) {
            for (int i = 0; i < this.mExifData.getStripCount(); i++) {
                orderedDataOutputStream.write(this.mExifData.getStrip(i));
            }
        }
    }

    private void writeAllTags(OrderedDataOutputStream orderedDataOutputStream) throws IOException {
        writeIfd(this.mExifData.getIfdData(0), orderedDataOutputStream);
        writeIfd(this.mExifData.getIfdData(2), orderedDataOutputStream);
        OppoIfdData ifdData = this.mExifData.getIfdData(3);
        if (ifdData != null) {
            writeIfd(ifdData, orderedDataOutputStream);
        }
        OppoIfdData ifdData2 = this.mExifData.getIfdData(4);
        if (ifdData2 != null) {
            writeIfd(ifdData2, orderedDataOutputStream);
        }
        if (this.mExifData.getIfdData(1) != null) {
            writeIfd(this.mExifData.getIfdData(1), orderedDataOutputStream);
        }
    }

    private void writeIfd(OppoIfdData oppoIfdData, OrderedDataOutputStream orderedDataOutputStream) throws IOException {
        OppoExifTag[] allTags = oppoIfdData.getAllTags();
        orderedDataOutputStream.writeShort((short) allTags.length);
        for (OppoExifTag oppoExifTag : allTags) {
            orderedDataOutputStream.writeShort(oppoExifTag.getTagId());
            orderedDataOutputStream.writeShort(oppoExifTag.getDataType());
            orderedDataOutputStream.writeInt(oppoExifTag.getComponentCount());
            if (oppoExifTag.getDataSize() > 4) {
                orderedDataOutputStream.writeInt(oppoExifTag.getOffset());
            } else {
                writeTagValue(oppoExifTag, orderedDataOutputStream);
                int dataSize = 4 - oppoExifTag.getDataSize();
                for (int i = 0; i < dataSize; i++) {
                    orderedDataOutputStream.write(0);
                }
            }
        }
        orderedDataOutputStream.writeInt(oppoIfdData.getOffsetToNextIfd());
        for (OppoExifTag oppoExifTag2 : allTags) {
            if (oppoExifTag2.getDataSize() > 4) {
                writeTagValue(oppoExifTag2, orderedDataOutputStream);
            }
        }
    }

    private int calculateOffsetOfIfd(OppoIfdData oppoIfdData, int i) {
        int tagCount = i + (oppoIfdData.getTagCount() * 12) + 2 + 4;
        for (OppoExifTag oppoExifTag : oppoIfdData.getAllTags()) {
            if (oppoExifTag.getDataSize() > 4) {
                oppoExifTag.setOffset(tagCount);
                tagCount += oppoExifTag.getDataSize();
            }
        }
        return tagCount;
    }

    private void createRequiredIfdAndTag() throws IOException {
        OppoIfdData ifdData = this.mExifData.getIfdData(0);
        if (ifdData == null) {
            ifdData = new OppoIfdData(0);
            this.mExifData.addIfdData(ifdData);
        }
        OppoExifTag buildUninitializedTag = this.mInterface.buildUninitializedTag(OppoExifInterface.TAG_EXIF_IFD);
        if (buildUninitializedTag != null) {
            ifdData.setTag(buildUninitializedTag);
            OppoIfdData ifdData2 = this.mExifData.getIfdData(2);
            if (ifdData2 == null) {
                ifdData2 = new OppoIfdData(2);
                this.mExifData.addIfdData(ifdData2);
            }
            if (this.mExifData.getIfdData(4) != null) {
                OppoExifTag buildUninitializedTag2 = this.mInterface.buildUninitializedTag(OppoExifInterface.TAG_GPS_IFD);
                if (buildUninitializedTag2 != null) {
                    ifdData.setTag(buildUninitializedTag2);
                } else {
                    throw new IOException("No definition for crucial exif tag: " + OppoExifInterface.TAG_GPS_IFD);
                }
            }
            if (this.mExifData.getIfdData(3) != null) {
                OppoExifTag buildUninitializedTag3 = this.mInterface.buildUninitializedTag(OppoExifInterface.TAG_INTEROPERABILITY_IFD);
                if (buildUninitializedTag3 != null) {
                    ifdData2.setTag(buildUninitializedTag3);
                } else {
                    throw new IOException("No definition for crucial exif tag: " + OppoExifInterface.TAG_INTEROPERABILITY_IFD);
                }
            }
            OppoIfdData ifdData3 = this.mExifData.getIfdData(1);
            if (this.mExifData.hasCompressedThumbnail()) {
                if (ifdData3 == null) {
                    ifdData3 = new OppoIfdData(1);
                    this.mExifData.addIfdData(ifdData3);
                }
                OppoExifTag buildUninitializedTag4 = this.mInterface.buildUninitializedTag(OppoExifInterface.TAG_JPEG_INTERCHANGE_FORMAT);
                if (buildUninitializedTag4 != null) {
                    ifdData3.setTag(buildUninitializedTag4);
                    OppoExifTag buildUninitializedTag5 = this.mInterface.buildUninitializedTag(OppoExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
                    if (buildUninitializedTag5 != null) {
                        buildUninitializedTag5.setValue(this.mExifData.getCompressedThumbnail().length);
                        ifdData3.setTag(buildUninitializedTag5);
                        ifdData3.removeTag(OppoExifInterface.getTrueTagKey(OppoExifInterface.TAG_STRIP_OFFSETS));
                        ifdData3.removeTag(OppoExifInterface.getTrueTagKey(OppoExifInterface.TAG_STRIP_BYTE_COUNTS));
                        return;
                    }
                    throw new IOException("No definition for crucial exif tag: " + OppoExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
                }
                throw new IOException("No definition for crucial exif tag: " + OppoExifInterface.TAG_JPEG_INTERCHANGE_FORMAT);
            } else if (this.mExifData.hasUncompressedStrip()) {
                if (ifdData3 == null) {
                    ifdData3 = new OppoIfdData(1);
                    this.mExifData.addIfdData(ifdData3);
                }
                int stripCount = this.mExifData.getStripCount();
                OppoExifTag buildUninitializedTag6 = this.mInterface.buildUninitializedTag(OppoExifInterface.TAG_STRIP_OFFSETS);
                if (buildUninitializedTag6 != null) {
                    OppoExifTag buildUninitializedTag7 = this.mInterface.buildUninitializedTag(OppoExifInterface.TAG_STRIP_BYTE_COUNTS);
                    if (buildUninitializedTag7 != null) {
                        long[] jArr = new long[stripCount];
                        for (int i = 0; i < this.mExifData.getStripCount(); i++) {
                            jArr[i] = (long) this.mExifData.getStrip(i).length;
                        }
                        buildUninitializedTag7.setValue(jArr);
                        ifdData3.setTag(buildUninitializedTag6);
                        ifdData3.setTag(buildUninitializedTag7);
                        ifdData3.removeTag(OppoExifInterface.getTrueTagKey(OppoExifInterface.TAG_JPEG_INTERCHANGE_FORMAT));
                        ifdData3.removeTag(OppoExifInterface.getTrueTagKey(OppoExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH));
                        return;
                    }
                    throw new IOException("No definition for crucial exif tag: " + OppoExifInterface.TAG_STRIP_BYTE_COUNTS);
                }
                throw new IOException("No definition for crucial exif tag: " + OppoExifInterface.TAG_STRIP_OFFSETS);
            } else if (ifdData3 != null) {
                ifdData3.removeTag(OppoExifInterface.getTrueTagKey(OppoExifInterface.TAG_STRIP_OFFSETS));
                ifdData3.removeTag(OppoExifInterface.getTrueTagKey(OppoExifInterface.TAG_STRIP_BYTE_COUNTS));
                ifdData3.removeTag(OppoExifInterface.getTrueTagKey(OppoExifInterface.TAG_JPEG_INTERCHANGE_FORMAT));
                ifdData3.removeTag(OppoExifInterface.getTrueTagKey(OppoExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH));
            }
        } else {
            throw new IOException("No definition for crucial exif tag: " + OppoExifInterface.TAG_EXIF_IFD);
        }
    }

    private int calculateAllOffset() {
        OppoIfdData ifdData = this.mExifData.getIfdData(0);
        int calculateOffsetOfIfd = calculateOffsetOfIfd(ifdData, 8);
        ifdData.getTag(OppoExifInterface.getTrueTagKey(OppoExifInterface.TAG_EXIF_IFD)).setValue(calculateOffsetOfIfd);
        OppoIfdData ifdData2 = this.mExifData.getIfdData(2);
        int calculateOffsetOfIfd2 = calculateOffsetOfIfd(ifdData2, calculateOffsetOfIfd);
        OppoIfdData ifdData3 = this.mExifData.getIfdData(3);
        if (ifdData3 != null) {
            ifdData2.getTag(OppoExifInterface.getTrueTagKey(OppoExifInterface.TAG_INTEROPERABILITY_IFD)).setValue(calculateOffsetOfIfd2);
            calculateOffsetOfIfd2 = calculateOffsetOfIfd(ifdData3, calculateOffsetOfIfd2);
        }
        OppoIfdData ifdData4 = this.mExifData.getIfdData(4);
        if (ifdData4 != null) {
            ifdData.getTag(OppoExifInterface.getTrueTagKey(OppoExifInterface.TAG_GPS_IFD)).setValue(calculateOffsetOfIfd2);
            calculateOffsetOfIfd2 = calculateOffsetOfIfd(ifdData4, calculateOffsetOfIfd2);
        }
        OppoIfdData ifdData5 = this.mExifData.getIfdData(1);
        if (ifdData5 == null) {
            return calculateOffsetOfIfd2;
        }
        ifdData.setOffsetToNextIfd(calculateOffsetOfIfd2);
        int calculateOffsetOfIfd3 = calculateOffsetOfIfd(ifdData5, calculateOffsetOfIfd2);
        if (this.mExifData.hasCompressedThumbnail()) {
            ifdData5.getTag(OppoExifInterface.getTrueTagKey(OppoExifInterface.TAG_JPEG_INTERCHANGE_FORMAT)).setValue(calculateOffsetOfIfd3);
            return calculateOffsetOfIfd3 + this.mExifData.getCompressedThumbnail().length;
        } else if (!this.mExifData.hasUncompressedStrip()) {
            return calculateOffsetOfIfd3;
        } else {
            long[] jArr = new long[this.mExifData.getStripCount()];
            for (int i = 0; i < this.mExifData.getStripCount(); i++) {
                jArr[i] = (long) calculateOffsetOfIfd3;
                calculateOffsetOfIfd3 += this.mExifData.getStrip(i).length;
            }
            ifdData5.getTag(OppoExifInterface.getTrueTagKey(OppoExifInterface.TAG_STRIP_OFFSETS)).setValue(jArr);
            return calculateOffsetOfIfd3;
        }
    }

    static void writeTagValue(OppoExifTag oppoExifTag, OrderedDataOutputStream orderedDataOutputStream) throws IOException {
        int i = 0;
        switch (oppoExifTag.getDataType()) {
            case 1:
            case 7:
                byte[] bArr = new byte[oppoExifTag.getComponentCount()];
                oppoExifTag.getBytes(bArr);
                orderedDataOutputStream.write(bArr);
                return;
            case 2:
                byte[] stringByte = oppoExifTag.getStringByte();
                if (stringByte != null && stringByte.length != 0) {
                    if (stringByte.length == oppoExifTag.getComponentCount()) {
                        stringByte[stringByte.length - 1] = 0;
                        orderedDataOutputStream.write(stringByte);
                        return;
                    }
                    orderedDataOutputStream.write(stringByte);
                    orderedDataOutputStream.write(0);
                    return;
                }
                return;
            case 3:
                int componentCount = oppoExifTag.getComponentCount();
                while (i < componentCount) {
                    orderedDataOutputStream.writeShort((short) ((int) oppoExifTag.getValueAt(i)));
                    i++;
                }
                return;
            case 4:
            case 9:
                int componentCount2 = oppoExifTag.getComponentCount();
                while (i < componentCount2) {
                    orderedDataOutputStream.writeInt((int) oppoExifTag.getValueAt(i));
                    i++;
                }
                return;
            case 5:
            case 10:
                int componentCount3 = oppoExifTag.getComponentCount();
                while (i < componentCount3) {
                    orderedDataOutputStream.writeRational(oppoExifTag.getRational(i));
                    i++;
                }
                return;
            default:
                return;
        }
    }
}
