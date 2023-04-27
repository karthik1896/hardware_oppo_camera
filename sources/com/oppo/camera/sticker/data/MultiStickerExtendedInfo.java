package com.oppo.camera.sticker.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MultiStickerExtendedInfo implements Parcelable {
    public static final Parcelable.Creator<MultiStickerExtendedInfo> CREATOR = new Parcelable.Creator<MultiStickerExtendedInfo>() {
        /* renamed from: a */
        public MultiStickerExtendedInfo createFromParcel(Parcel parcel) {
            MultiStickerExtendedInfo multiStickerExtendedInfo = new MultiStickerExtendedInfo();
            String unused = multiStickerExtendedInfo.mStickerName = parcel.readString();
            boolean unused2 = multiStickerExtendedInfo.mIsFitToSize = parcel.readInt() != 0;
            int unused3 = multiStickerExtendedInfo.mPositionType = parcel.readInt();
            int unused4 = multiStickerExtendedInfo.mZPosition = parcel.readInt();
            String unused5 = multiStickerExtendedInfo.mBaseSize16x9 = parcel.readString();
            String unused6 = multiStickerExtendedInfo.mDisplayRect16x9 = parcel.readString();
            String unused7 = multiStickerExtendedInfo.mFileContentUri16x9 = parcel.readString();
            String unused8 = multiStickerExtendedInfo.mBaseSize4x3 = parcel.readString();
            String unused9 = multiStickerExtendedInfo.mDisplayRect4x3 = parcel.readString();
            String unused10 = multiStickerExtendedInfo.mFileContentUri4x3 = parcel.readString();
            String unused11 = multiStickerExtendedInfo.mBaseSize1x1 = parcel.readString();
            String unused12 = multiStickerExtendedInfo.mDisplayRect1x1 = parcel.readString();
            String unused13 = multiStickerExtendedInfo.mFileContentUri1x1 = parcel.readString();
            return multiStickerExtendedInfo;
        }

        /* renamed from: a */
        public MultiStickerExtendedInfo[] newArray(int i) {
            return new MultiStickerExtendedInfo[i];
        }
    };
    public static final int POSITION_TYPE_BACKGROUND = 2;
    public static final int POSITION_TYPE_FOREGROUND = 0;
    public static final int POSITION_TYPE_NORMAL = 1;
    /* access modifiers changed from: private */
    @SerializedName("mBaseSize16_9")
    @Expose
    public String mBaseSize16x9;
    /* access modifiers changed from: private */
    @SerializedName("mBaseSize1_1")
    @Expose
    public String mBaseSize1x1;
    /* access modifiers changed from: private */
    @SerializedName("mBaseSize4_3")
    @Expose
    public String mBaseSize4x3;
    /* access modifiers changed from: private */
    @SerializedName("mDisplayRect16_9")
    @Expose
    public String mDisplayRect16x9;
    /* access modifiers changed from: private */
    @SerializedName("mDisplayRect1_1")
    @Expose
    public String mDisplayRect1x1;
    /* access modifiers changed from: private */
    @SerializedName("mDisplayRect4_3")
    @Expose
    public String mDisplayRect4x3;
    /* access modifiers changed from: private */
    public String mFileContentUri16x9;
    /* access modifiers changed from: private */
    public String mFileContentUri1x1;
    /* access modifiers changed from: private */
    public String mFileContentUri4x3;
    /* access modifiers changed from: private */
    @SerializedName("mbStickerFitToSize")
    @Expose
    public boolean mIsFitToSize;
    /* access modifiers changed from: private */
    @Expose
    public int mPositionType;
    /* access modifiers changed from: private */
    @Expose
    public String mStickerName;
    /* access modifiers changed from: private */
    @Expose
    public int mZPosition;

    public int describeContents() {
        return 0;
    }

    public String getStickerName() {
        return this.mStickerName;
    }

    public void setStickerName(String str) {
        this.mStickerName = str;
    }

    public boolean getIsFitToSize() {
        return this.mIsFitToSize;
    }

    public void setIsFitToSize(boolean z) {
        this.mIsFitToSize = z;
    }

    public int getPositionType() {
        return this.mPositionType;
    }

    public void setPositionType(int i) {
        this.mPositionType = i;
    }

    public int getZPosition() {
        return this.mZPosition;
    }

    public void setZPosition(int i) {
        this.mZPosition = i;
    }

    public String getBaseSize16x9() {
        return this.mBaseSize16x9;
    }

    public void setBaseSize16x9(String str) {
        this.mBaseSize16x9 = str;
    }

    public String getDisplayRect16x9() {
        return this.mDisplayRect16x9;
    }

    public void setDisplayRect16x9(String str) {
        this.mDisplayRect16x9 = str;
    }

    public String getBaseSize4x3() {
        return this.mBaseSize4x3;
    }

    public void setBaseSize4x3(String str) {
        this.mBaseSize4x3 = str;
    }

    public String getDisplayRect4x3() {
        return this.mDisplayRect4x3;
    }

    public void setDisplayRect4x3(String str) {
        this.mDisplayRect4x3 = str;
    }

    public String getBaseSize1x1() {
        return this.mBaseSize1x1;
    }

    public void setBaseSize1x1(String str) {
        this.mBaseSize1x1 = str;
    }

    public String getDisplayRect1x1() {
        return this.mDisplayRect1x1;
    }

    public void setDisplayRect1x1(String str) {
        this.mDisplayRect1x1 = str;
    }

    public String getFileContentUri16x9() {
        return this.mFileContentUri16x9;
    }

    public void setFileContentUri16x9(String str) {
        this.mFileContentUri16x9 = str;
    }

    public String getFileContentUri4x3() {
        return this.mFileContentUri4x3;
    }

    public void setFileContentUri4x3(String str) {
        this.mFileContentUri4x3 = str;
    }

    public String getFileContentUri1x1() {
        return this.mFileContentUri1x1;
    }

    public void setFileContentUri1x1(String str) {
        this.mFileContentUri1x1 = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mStickerName);
        parcel.writeInt(this.mIsFitToSize ? 1 : 0);
        parcel.writeInt(this.mPositionType);
        parcel.writeInt(this.mZPosition);
        parcel.writeString(this.mBaseSize16x9);
        parcel.writeString(this.mDisplayRect16x9);
        parcel.writeString(this.mFileContentUri16x9);
        parcel.writeString(this.mBaseSize4x3);
        parcel.writeString(this.mDisplayRect4x3);
        parcel.writeString(this.mFileContentUri4x3);
        parcel.writeString(this.mBaseSize1x1);
        parcel.writeString(this.mDisplayRect1x1);
        parcel.writeString(this.mFileContentUri1x1);
    }

    public String toString() {
        return "[name: " + this.mStickerName + ", fit: " + this.mIsFitToSize + ", pType: " + this.mPositionType + ", zPos: " + this.mZPosition + ", BS16: " + this.mBaseSize16x9 + ", DR16: " + this.mDisplayRect16x9 + ", BS4: " + this.mBaseSize4x3 + ", DR4: " + this.mDisplayRect4x3 + ", BS1: " + this.mBaseSize1x1 + ", DR1: " + this.mDisplayRect1x1 + "]";
    }
}
