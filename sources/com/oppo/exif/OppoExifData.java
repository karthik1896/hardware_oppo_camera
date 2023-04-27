package com.oppo.exif;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.codec.CharEncoding;

class OppoExifData {
    private static final String TAG = "ExifData";
    private static final byte[] USER_COMMENT_ASCII = {65, 83, 67, 73, 73, 0, 0, 0};
    private static final byte[] USER_COMMENT_JIS = {74, 73, 83, 0, 0, 0, 0, 0};
    private static final byte[] USER_COMMENT_UNICODE = {85, 78, 73, 67, 79, 68, 69, 0};
    private final ByteOrder mByteOrder;
    private final OppoIfdData[] mIfdDatas = new OppoIfdData[5];
    private ArrayList<byte[]> mStripBytes = new ArrayList<>();
    private byte[] mThumbnail;

    OppoExifData(ByteOrder byteOrder) {
        this.mByteOrder = byteOrder;
    }

    /* access modifiers changed from: protected */
    public byte[] getCompressedThumbnail() {
        return this.mThumbnail;
    }

    /* access modifiers changed from: protected */
    public void setCompressedThumbnail(byte[] bArr) {
        this.mThumbnail = bArr;
    }

    /* access modifiers changed from: protected */
    public boolean hasCompressedThumbnail() {
        return this.mThumbnail != null;
    }

    /* access modifiers changed from: protected */
    public void setStripBytes(int i, byte[] bArr) {
        if (i < this.mStripBytes.size()) {
            this.mStripBytes.set(i, bArr);
            return;
        }
        for (int size = this.mStripBytes.size(); size < i; size++) {
            this.mStripBytes.add((Object) null);
        }
        this.mStripBytes.add(bArr);
    }

    /* access modifiers changed from: protected */
    public int getStripCount() {
        return this.mStripBytes.size();
    }

    /* access modifiers changed from: protected */
    public byte[] getStrip(int i) {
        return this.mStripBytes.get(i);
    }

    /* access modifiers changed from: protected */
    public boolean hasUncompressedStrip() {
        return this.mStripBytes.size() != 0;
    }

    /* access modifiers changed from: protected */
    public ByteOrder getByteOrder() {
        return this.mByteOrder;
    }

    /* access modifiers changed from: protected */
    public OppoIfdData getIfdData(int i) {
        if (OppoExifTag.isValidIfd(i)) {
            return this.mIfdDatas[i];
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void addIfdData(OppoIfdData oppoIfdData) {
        this.mIfdDatas[oppoIfdData.getId()] = oppoIfdData;
    }

    /* access modifiers changed from: protected */
    public OppoIfdData getOrCreateIfdData(int i) {
        OppoIfdData oppoIfdData = this.mIfdDatas[i];
        if (oppoIfdData != null) {
            return oppoIfdData;
        }
        OppoIfdData oppoIfdData2 = new OppoIfdData(i);
        this.mIfdDatas[i] = oppoIfdData2;
        return oppoIfdData2;
    }

    /* access modifiers changed from: protected */
    public OppoExifTag getTag(short s, int i) {
        OppoIfdData oppoIfdData = this.mIfdDatas[i];
        if (oppoIfdData == null) {
            return null;
        }
        return oppoIfdData.getTag(s);
    }

    /* access modifiers changed from: protected */
    public OppoExifTag addTag(OppoExifTag oppoExifTag) {
        if (oppoExifTag != null) {
            return addTag(oppoExifTag, oppoExifTag.getIfd());
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public OppoExifTag addTag(OppoExifTag oppoExifTag, int i) {
        if (oppoExifTag == null || !OppoExifTag.isValidIfd(i)) {
            return null;
        }
        return getOrCreateIfdData(i).setTag(oppoExifTag);
    }

    /* access modifiers changed from: protected */
    public void clearThumbnailAndStrips() {
        this.mThumbnail = null;
        this.mStripBytes.clear();
    }

    /* access modifiers changed from: protected */
    public void removeThumbnailData() {
        clearThumbnailAndStrips();
        this.mIfdDatas[1] = null;
    }

    /* access modifiers changed from: protected */
    public void removeTag(short s, int i) {
        OppoIfdData oppoIfdData = this.mIfdDatas[i];
        if (oppoIfdData != null) {
            oppoIfdData.removeTag(s);
        }
    }

    /* access modifiers changed from: protected */
    public String getUserComment() {
        OppoExifTag tag;
        OppoIfdData oppoIfdData = this.mIfdDatas[0];
        if (oppoIfdData == null || (tag = oppoIfdData.getTag(OppoExifInterface.getTrueTagKey(OppoExifInterface.TAG_USER_COMMENT))) == null || tag.getComponentCount() < 8) {
            return null;
        }
        byte[] bArr = new byte[tag.getComponentCount()];
        tag.getBytes(bArr);
        byte[] bArr2 = new byte[8];
        System.arraycopy(bArr, 0, bArr2, 0, 8);
        try {
            if (Arrays.equals(bArr2, USER_COMMENT_ASCII)) {
                return new String(bArr, 8, bArr.length - 8, CharEncoding.US_ASCII);
            }
            if (Arrays.equals(bArr2, USER_COMMENT_JIS)) {
                return new String(bArr, 8, bArr.length - 8, "EUC-JP");
            }
            if (Arrays.equals(bArr2, USER_COMMENT_UNICODE)) {
                return new String(bArr, 8, bArr.length - 8, CharEncoding.UTF_16);
            }
            return null;
        } catch (UnsupportedEncodingException unused) {
            Log.w(TAG, "Failed to decode the user comment");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public List<OppoExifTag> getAllTags() {
        OppoExifTag[] allTags;
        ArrayList arrayList = new ArrayList();
        for (OppoIfdData oppoIfdData : this.mIfdDatas) {
            if (!(oppoIfdData == null || (allTags = oppoIfdData.getAllTags()) == null)) {
                for (OppoExifTag add : allTags) {
                    arrayList.add(add);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<OppoExifTag> getAllTagsForIfd(int i) {
        OppoExifTag[] allTags;
        OppoIfdData oppoIfdData = this.mIfdDatas[i];
        if (oppoIfdData == null || (allTags = oppoIfdData.getAllTags()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(allTags.length);
        for (OppoExifTag add : allTags) {
            arrayList.add(add);
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<OppoExifTag> getAllTagsForTagId(short s) {
        OppoExifTag tag;
        ArrayList arrayList = new ArrayList();
        for (OppoIfdData oppoIfdData : this.mIfdDatas) {
            if (!(oppoIfdData == null || (tag = oppoIfdData.getTag(s)) == null)) {
                arrayList.add(tag);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof OppoExifData)) {
            OppoExifData oppoExifData = (OppoExifData) obj;
            if (oppoExifData.mByteOrder == this.mByteOrder && oppoExifData.mStripBytes.size() == this.mStripBytes.size() && Arrays.equals(oppoExifData.mThumbnail, this.mThumbnail)) {
                for (int i = 0; i < this.mStripBytes.size(); i++) {
                    if (!Arrays.equals(oppoExifData.mStripBytes.get(i), this.mStripBytes.get(i))) {
                        return false;
                    }
                }
                for (int i2 = 0; i2 < 5; i2++) {
                    OppoIfdData ifdData = oppoExifData.getIfdData(i2);
                    OppoIfdData ifdData2 = getIfdData(i2);
                    if (ifdData != ifdData2 && ifdData != null && !ifdData.equals(ifdData2)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
