package com.oppo.exif;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

class OppoExifModifier {
    public static final boolean DEBUG = false;
    public static final String TAG = "ExifModifier";
    private final ByteBuffer mByteBuffer;
    private final OppoExifInterface mInterface;
    private int mOffsetBase;
    private final List<TagOffset> mTagOffsets = new ArrayList();
    private final OppoExifData mTagToModified;

    private static class TagOffset {
        final int mOffset;
        final OppoExifTag mTag;

        TagOffset(OppoExifTag oppoExifTag, int i) {
            this.mTag = oppoExifTag;
            this.mOffset = i;
        }
    }

    protected OppoExifModifier(ByteBuffer byteBuffer, OppoExifInterface oppoExifInterface) throws IOException, OppoExifInvalidFormatException {
        OppoByteBufferInputStream oppoByteBufferInputStream;
        this.mByteBuffer = byteBuffer;
        this.mOffsetBase = byteBuffer.position();
        this.mInterface = oppoExifInterface;
        try {
            oppoByteBufferInputStream = new OppoByteBufferInputStream(byteBuffer);
            try {
                OppoExifParser parse = OppoExifParser.parse(oppoByteBufferInputStream, this.mInterface);
                this.mTagToModified = new OppoExifData(parse.getByteOrder());
                this.mOffsetBase += parse.getTiffStartPosition();
                this.mByteBuffer.position(0);
                OppoExifInterface.closeSilently(oppoByteBufferInputStream);
            } catch (Throwable th) {
                th = th;
                OppoExifInterface.closeSilently(oppoByteBufferInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            oppoByteBufferInputStream = null;
            OppoExifInterface.closeSilently(oppoByteBufferInputStream);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public ByteOrder getByteOrder() {
        return this.mTagToModified.getByteOrder();
    }

    /* access modifiers changed from: protected */
    public boolean commit() throws IOException, OppoExifInvalidFormatException {
        OppoByteBufferInputStream oppoByteBufferInputStream;
        Throwable th;
        OppoExifTag tag;
        OppoIfdData oppoIfdData = null;
        try {
            oppoByteBufferInputStream = new OppoByteBufferInputStream(this.mByteBuffer);
            try {
                OppoIfdData[] oppoIfdDataArr = {this.mTagToModified.getIfdData(0), this.mTagToModified.getIfdData(1), this.mTagToModified.getIfdData(2), this.mTagToModified.getIfdData(3), this.mTagToModified.getIfdData(4)};
                int i = oppoIfdDataArr[0] != null ? 1 : 0;
                if (oppoIfdDataArr[1] != null) {
                    i |= 2;
                }
                if (oppoIfdDataArr[2] != null) {
                    i |= 4;
                }
                if (oppoIfdDataArr[4] != null) {
                    i |= 8;
                }
                if (oppoIfdDataArr[3] != null) {
                    i |= 16;
                }
                OppoExifParser parse = OppoExifParser.parse(oppoByteBufferInputStream, i, this.mInterface);
                for (int next = parse.next(); next != 5; next = parse.next()) {
                    if (next == 0) {
                        oppoIfdData = oppoIfdDataArr[parse.getCurrentIfd()];
                        if (oppoIfdData == null) {
                            parse.skipRemainingTagsInCurrentIfd();
                        }
                    } else if (next == 1) {
                        OppoExifTag tag2 = parse.getTag();
                        if (!(tag2 == null || oppoIfdData == null || (tag = oppoIfdData.getTag(tag2.getTagId())) == null)) {
                            if (tag.getComponentCount() == tag2.getComponentCount()) {
                                if (tag.getDataType() == tag2.getDataType()) {
                                    this.mTagOffsets.add(new TagOffset(tag, tag2.getOffset()));
                                    oppoIfdData.removeTag(tag2.getTagId());
                                    if (oppoIfdData.getTagCount() == 0) {
                                        parse.skipRemainingTagsInCurrentIfd();
                                    }
                                }
                            }
                            OppoExifInterface.closeSilently(oppoByteBufferInputStream);
                            return false;
                        }
                    }
                }
                int length = oppoIfdDataArr.length;
                int i2 = 0;
                while (i2 < length) {
                    OppoIfdData oppoIfdData2 = oppoIfdDataArr[i2];
                    if (oppoIfdData2 == null || oppoIfdData2.getTagCount() <= 0) {
                        i2++;
                    } else {
                        OppoExifInterface.closeSilently(oppoByteBufferInputStream);
                        return false;
                    }
                }
                modify();
                OppoExifInterface.closeSilently(oppoByteBufferInputStream);
                return true;
            } catch (Throwable th2) {
                th = th2;
                OppoExifInterface.closeSilently(oppoByteBufferInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            oppoByteBufferInputStream = null;
            th = th4;
            OppoExifInterface.closeSilently(oppoByteBufferInputStream);
            throw th;
        }
    }

    private void modify() {
        this.mByteBuffer.order(getByteOrder());
        for (TagOffset next : this.mTagOffsets) {
            writeTagValue(next.mTag, next.mOffset);
        }
    }

    private void writeTagValue(OppoExifTag oppoExifTag, int i) {
        this.mByteBuffer.position(i + this.mOffsetBase);
        int i2 = 0;
        switch (oppoExifTag.getDataType()) {
            case 1:
            case 7:
                byte[] bArr = new byte[oppoExifTag.getComponentCount()];
                oppoExifTag.getBytes(bArr);
                this.mByteBuffer.put(bArr);
                return;
            case 2:
                byte[] stringByte = oppoExifTag.getStringByte();
                if (stringByte.length == oppoExifTag.getComponentCount()) {
                    stringByte[stringByte.length - 1] = 0;
                    this.mByteBuffer.put(stringByte);
                    return;
                }
                this.mByteBuffer.put(stringByte);
                this.mByteBuffer.put((byte) 0);
                return;
            case 3:
                int componentCount = oppoExifTag.getComponentCount();
                while (i2 < componentCount) {
                    this.mByteBuffer.putShort((short) ((int) oppoExifTag.getValueAt(i2)));
                    i2++;
                }
                return;
            case 4:
            case 9:
                int componentCount2 = oppoExifTag.getComponentCount();
                while (i2 < componentCount2) {
                    this.mByteBuffer.putInt((int) oppoExifTag.getValueAt(i2));
                    i2++;
                }
                return;
            case 5:
            case 10:
                int componentCount3 = oppoExifTag.getComponentCount();
                while (i2 < componentCount3) {
                    OppoRational rational = oppoExifTag.getRational(i2);
                    this.mByteBuffer.putInt((int) rational.getNumerator());
                    this.mByteBuffer.putInt((int) rational.getDenominator());
                    i2++;
                }
                return;
            default:
                return;
        }
    }

    public void modifyTag(OppoExifTag oppoExifTag) {
        this.mTagToModified.addTag(oppoExifTag);
    }
}
