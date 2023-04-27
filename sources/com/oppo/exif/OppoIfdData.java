package com.oppo.exif;

import java.util.HashMap;
import java.util.Map;

class OppoIfdData {
    private static final int[] sIfds = {0, 1, 2, 3, 4};
    private final Map<Short, OppoExifTag> mExifTags = new HashMap();
    private final int mIfdId;
    private int mOffsetToNextIfd = 0;

    OppoIfdData(int i) {
        this.mIfdId = i;
    }

    protected static int[] getIfds() {
        return sIfds;
    }

    /* access modifiers changed from: protected */
    public OppoExifTag[] getAllTags() {
        return (OppoExifTag[]) this.mExifTags.values().toArray(new OppoExifTag[this.mExifTags.size()]);
    }

    /* access modifiers changed from: protected */
    public int getId() {
        return this.mIfdId;
    }

    /* access modifiers changed from: protected */
    public OppoExifTag getTag(short s) {
        return this.mExifTags.get(Short.valueOf(s));
    }

    /* access modifiers changed from: protected */
    public OppoExifTag setTag(OppoExifTag oppoExifTag) {
        oppoExifTag.setIfd(this.mIfdId);
        return this.mExifTags.put(Short.valueOf(oppoExifTag.getTagId()), oppoExifTag);
    }

    /* access modifiers changed from: protected */
    public boolean checkCollision(short s) {
        return this.mExifTags.get(Short.valueOf(s)) != null;
    }

    /* access modifiers changed from: protected */
    public void removeTag(short s) {
        this.mExifTags.remove(Short.valueOf(s));
    }

    /* access modifiers changed from: protected */
    public int getTagCount() {
        return this.mExifTags.size();
    }

    /* access modifiers changed from: protected */
    public void setOffsetToNextIfd(int i) {
        this.mOffsetToNextIfd = i;
    }

    /* access modifiers changed from: protected */
    public int getOffsetToNextIfd() {
        return this.mOffsetToNextIfd;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof OppoIfdData)) {
            OppoIfdData oppoIfdData = (OppoIfdData) obj;
            if (oppoIfdData.getId() == this.mIfdId && oppoIfdData.getTagCount() == getTagCount()) {
                for (OppoExifTag oppoExifTag : oppoIfdData.getAllTags()) {
                    if (!OppoExifInterface.isOffsetTag(oppoExifTag.getTagId()) && !oppoExifTag.equals(this.mExifTags.get(Short.valueOf(oppoExifTag.getTagId())))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
