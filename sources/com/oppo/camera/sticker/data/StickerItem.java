package com.oppo.camera.sticker.data;

import android.os.Parcel;
import android.os.Parcelable;

public class StickerItem implements Parcelable {
    public static final Parcelable.Creator<StickerItem> CREATOR = new Parcelable.Creator<StickerItem>() {
        /* renamed from: a */
        public StickerItem createFromParcel(Parcel parcel) {
            StickerItem stickerItem = new StickerItem();
            long unused = stickerItem.mStickerId = parcel.readLong();
            String unused2 = stickerItem.mCategoryId = parcel.readString();
            int unused3 = stickerItem.mCategoryPos = parcel.readInt();
            String unused4 = stickerItem.mStickerUUID = parcel.readString();
            String unused5 = stickerItem.mStickerName = parcel.readString();
            String unused6 = stickerItem.mFileContentUri = parcel.readString();
            String unused7 = stickerItem.mFileDownloadUrl = parcel.readString();
            String unused8 = stickerItem.mFileMd5 = parcel.readString();
            String unused9 = stickerItem.mThumbnailFileUri = parcel.readString();
            String unused10 = stickerItem.mThumbnailUrl = parcel.readString();
            String unused11 = stickerItem.mThumbnailMd5 = parcel.readString();
            String unused12 = stickerItem.mLogoFileUri = parcel.readString();
            String unused13 = stickerItem.mLogoUrl = parcel.readString();
            String unused14 = stickerItem.mLogoMd5 = parcel.readString();
            String unused15 = stickerItem.mDownloadUid = parcel.readString();
            long unused16 = stickerItem.mVersion = parcel.readLong();
            long unused17 = stickerItem.mProtocolVersion = parcel.readLong();
            long unused18 = stickerItem.mDownloadTime = parcel.readLong();
            long unused19 = stickerItem.mLastRequestTime = parcel.readLong();
            int unused20 = stickerItem.mPosition = parcel.readInt();
            int unused21 = stickerItem.mDownloadState = parcel.readInt();
            long unused22 = stickerItem.mAttribute = parcel.readLong();
            boolean z = true;
            boolean unused23 = stickerItem.mHasMusic = parcel.readInt() != 0;
            boolean unused24 = stickerItem.mNeedUpdate = parcel.readInt() != 0;
            boolean unused25 = stickerItem.mIsBuildIn = parcel.readInt() != 0;
            boolean unused26 = stickerItem.mIsNew = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                z = false;
            }
            boolean unused27 = stickerItem.mIsValid = z;
            int unused28 = stickerItem.mMaterialType = parcel.readInt();
            return stickerItem;
        }

        /* renamed from: a */
        public StickerItem[] newArray(int i) {
            return new StickerItem[i];
        }
    };
    public static final int MATERIAL_TYPE_ANIEMOJI = 2;
    public static final int MATERIAL_TYPE_MULTI = 1;
    public static final int MATERIAL_TYPE_NORMAL = 0;
    public static final String RECYCLE_BIN_UUID = "68714002-1206-472f-a3c8-74eea52f7808";
    /* access modifiers changed from: private */
    public long mAttribute = 0;
    /* access modifiers changed from: private */
    public String mCategoryId = null;
    /* access modifiers changed from: private */
    public int mCategoryPos = 0;
    /* access modifiers changed from: private */
    public int mDownloadState = 0;
    /* access modifiers changed from: private */
    public long mDownloadTime = 0;
    /* access modifiers changed from: private */
    public String mDownloadUid = null;
    /* access modifiers changed from: private */
    public String mFileContentUri = null;
    /* access modifiers changed from: private */
    public String mFileDownloadUrl = null;
    /* access modifiers changed from: private */
    public String mFileMd5 = null;
    /* access modifiers changed from: private */
    public boolean mHasMusic = false;
    /* access modifiers changed from: private */
    public boolean mIsBuildIn = false;
    /* access modifiers changed from: private */
    public boolean mIsNew = false;
    /* access modifiers changed from: private */
    public boolean mIsValid = true;
    /* access modifiers changed from: private */
    public long mLastRequestTime = 0;
    /* access modifiers changed from: private */
    public String mLogoFileUri = null;
    /* access modifiers changed from: private */
    public String mLogoMd5 = null;
    /* access modifiers changed from: private */
    public String mLogoUrl = null;
    /* access modifiers changed from: private */
    public int mMaterialType;
    /* access modifiers changed from: private */
    public boolean mNeedUpdate = false;
    /* access modifiers changed from: private */
    public int mPosition = 0;
    /* access modifiers changed from: private */
    public long mProtocolVersion = 0;
    /* access modifiers changed from: private */
    public long mStickerId = 0;
    /* access modifiers changed from: private */
    public String mStickerName = null;
    /* access modifiers changed from: private */
    public String mStickerUUID = null;
    /* access modifiers changed from: private */
    public String mThumbnailFileUri = null;
    /* access modifiers changed from: private */
    public String mThumbnailMd5 = null;
    /* access modifiers changed from: private */
    public String mThumbnailUrl = null;
    /* access modifiers changed from: private */
    public long mVersion = 0;

    public int describeContents() {
        return 0;
    }

    public long getStickerId() {
        return this.mStickerId;
    }

    public void setStickerId(long j) {
        this.mStickerId = j;
    }

    public String getStickerUUID() {
        return this.mStickerUUID;
    }

    public void setStickerUUID(String str) {
        this.mStickerUUID = str;
    }

    public String getCategoryId() {
        return this.mCategoryId;
    }

    public void setCategoryId(String str) {
        this.mCategoryId = str;
    }

    public void setCategoryPosition(int i) {
        this.mCategoryPos = i;
    }

    public int getCategoryPosition() {
        return this.mCategoryPos;
    }

    public String getStickerName() {
        return this.mStickerName;
    }

    public void setStickerName(String str) {
        this.mStickerName = str;
    }

    public String getFileDownloadUrl() {
        return this.mFileDownloadUrl;
    }

    public void setFileDownloadUrl(String str) {
        this.mFileDownloadUrl = str;
    }

    public String getFileContentUri() {
        return this.mFileContentUri;
    }

    public void setFileContentUri(String str) {
        this.mFileContentUri = str;
    }

    public String getFileMd5() {
        return this.mFileMd5;
    }

    public void setFileMd5(String str) {
        this.mFileMd5 = str;
    }

    public String getThumbnailUrl() {
        return this.mThumbnailUrl;
    }

    public void setThumbnailUrl(String str) {
        this.mThumbnailUrl = str;
    }

    public String getThumbnailFileUri() {
        return this.mThumbnailFileUri;
    }

    public void setThumbnailFileUri(String str) {
        this.mThumbnailFileUri = str;
    }

    public String getThumbnailMd5() {
        return this.mThumbnailMd5;
    }

    public void setThumbnailMd5(String str) {
        this.mThumbnailMd5 = str;
    }

    public String getLogoUrl() {
        return this.mLogoUrl;
    }

    public void setLogoUrl(String str) {
        this.mLogoUrl = str;
    }

    public String getLogoFileUri() {
        return this.mLogoFileUri;
    }

    public void setLogoFileUri(String str) {
        this.mLogoFileUri = str;
    }

    public String getLogoMd5() {
        return this.mLogoMd5;
    }

    public void setLogoMd5(String str) {
        this.mLogoMd5 = str;
    }

    public String getDownloadUid() {
        return this.mDownloadUid;
    }

    public void setDownloadUid(String str) {
        this.mDownloadUid = str;
    }

    public long getVersion() {
        return this.mVersion;
    }

    public void setVersion(long j) {
        this.mVersion = j;
    }

    public long getProtocolVersion() {
        return this.mProtocolVersion;
    }

    public void setProtocolVersion(long j) {
        this.mProtocolVersion = j;
    }

    public long getDownloadTime() {
        return this.mDownloadTime;
    }

    public void setDownloadTime(long j) {
        this.mDownloadTime = j;
    }

    public long getLastRequestTime() {
        return this.mLastRequestTime;
    }

    public void setLastRequestTime(long j) {
        this.mLastRequestTime = j;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public int getDownloadState() {
        return this.mDownloadState;
    }

    public void setDownloadState(int i) {
        this.mDownloadState = i;
    }

    public long getAttribute() {
        return this.mAttribute;
    }

    public void setAttribute(long j) {
        this.mAttribute = j;
    }

    public boolean hasMusic() {
        return this.mHasMusic;
    }

    public void setHasMusic(boolean z) {
        this.mHasMusic = z;
    }

    public boolean needUpdate() {
        return this.mNeedUpdate;
    }

    public void setNeedUpdate(boolean z) {
        this.mNeedUpdate = z;
    }

    public boolean isBuildIn() {
        return this.mIsBuildIn;
    }

    public void setIsBuildIn(boolean z) {
        this.mIsBuildIn = z;
    }

    public boolean isStickerNew() {
        return this.mIsNew;
    }

    public void setStickerNew(boolean z) {
        this.mIsNew = z;
    }

    public boolean isValid() {
        return this.mIsValid;
    }

    public void setValid(boolean z) {
        this.mIsValid = z;
    }

    public int getMaterialType() {
        return this.mMaterialType;
    }

    public void setMaterialType(int i) {
        this.mMaterialType = i;
    }

    public boolean isDownloaded() {
        return this.mDownloadState == 8;
    }

    public boolean isRecycleBin() {
        return RECYCLE_BIN_UUID.equals(this.mStickerUUID);
    }

    public boolean matchAppAttribute(long j) {
        return (this.mAttribute & j) == j;
    }

    public void copy(StickerItem stickerItem) {
        this.mStickerId = stickerItem.mStickerId;
        this.mStickerUUID = stickerItem.mStickerUUID;
        this.mStickerName = stickerItem.mStickerName;
        this.mFileDownloadUrl = stickerItem.mFileDownloadUrl;
        this.mFileContentUri = stickerItem.mFileContentUri;
        this.mFileMd5 = stickerItem.mFileMd5;
        this.mThumbnailUrl = stickerItem.mThumbnailUrl;
        this.mThumbnailFileUri = stickerItem.mThumbnailFileUri;
        this.mThumbnailMd5 = stickerItem.mThumbnailMd5;
        this.mLogoUrl = stickerItem.mLogoUrl;
        this.mLogoFileUri = stickerItem.mLogoFileUri;
        this.mLogoMd5 = stickerItem.mLogoMd5;
        this.mDownloadUid = stickerItem.mDownloadUid;
        this.mVersion = stickerItem.mVersion;
        this.mProtocolVersion = stickerItem.mProtocolVersion;
        this.mDownloadTime = stickerItem.mDownloadTime;
        this.mLastRequestTime = stickerItem.mLastRequestTime;
        this.mCategoryId = stickerItem.mCategoryId;
        this.mCategoryPos = stickerItem.mCategoryPos;
        this.mPosition = stickerItem.mPosition;
        this.mDownloadState = stickerItem.mDownloadState;
        this.mAttribute = stickerItem.mAttribute;
        this.mHasMusic = stickerItem.mHasMusic;
        this.mNeedUpdate = stickerItem.mNeedUpdate;
        this.mIsBuildIn = stickerItem.mIsBuildIn;
        this.mIsNew = stickerItem.mIsNew;
        this.mIsValid = stickerItem.mIsValid;
        this.mMaterialType = stickerItem.mMaterialType;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mStickerId);
        parcel.writeString(this.mCategoryId);
        parcel.writeInt(this.mCategoryPos);
        parcel.writeString(this.mStickerUUID);
        parcel.writeString(this.mStickerName);
        parcel.writeString(this.mFileContentUri);
        parcel.writeString(this.mFileDownloadUrl);
        parcel.writeString(this.mFileMd5);
        parcel.writeString(this.mThumbnailFileUri);
        parcel.writeString(this.mThumbnailUrl);
        parcel.writeString(this.mThumbnailMd5);
        parcel.writeString(this.mLogoFileUri);
        parcel.writeString(this.mLogoUrl);
        parcel.writeString(this.mLogoMd5);
        parcel.writeString(this.mDownloadUid);
        parcel.writeLong(this.mVersion);
        parcel.writeLong(this.mProtocolVersion);
        parcel.writeLong(this.mDownloadTime);
        parcel.writeLong(this.mLastRequestTime);
        parcel.writeInt(this.mPosition);
        parcel.writeInt(this.mDownloadState);
        parcel.writeLong(this.mAttribute);
        parcel.writeInt(this.mHasMusic ? 1 : 0);
        parcel.writeInt(this.mNeedUpdate ? 1 : 0);
        parcel.writeInt(this.mIsBuildIn ? 1 : 0);
        parcel.writeInt(this.mIsNew ? 1 : 0);
        parcel.writeInt(this.mIsValid ? 1 : 0);
        parcel.writeInt(this.mMaterialType);
    }

    public String toString() {
        return "[id: " + this.mStickerId + ", name: " + this.mStickerName + ", pos: " + this.mPosition + ", cPos: " + this.mCategoryPos + ", state: " + this.mDownloadState + ", dTime: " + this.mDownloadTime + ", ver: " + this.mVersion + ", music:" + this.mHasMusic + ", pVer: " + this.mProtocolVersion + ", attr: " + this.mAttribute + ", buildIn: " + this.mIsBuildIn + ", type: " + this.mMaterialType + "]";
    }
}
