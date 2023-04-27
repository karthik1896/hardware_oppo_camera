package com.oppo.camera.sticker.data;

import android.os.Parcel;
import android.os.Parcelable;

public class StickerCategoryItem implements Parcelable {
    public static final Parcelable.Creator<StickerCategoryItem> CREATOR = new Parcelable.Creator<StickerCategoryItem>() {
        /* renamed from: a */
        public StickerCategoryItem createFromParcel(Parcel parcel) {
            StickerCategoryItem stickerCategoryItem = new StickerCategoryItem();
            String unused = stickerCategoryItem.mReadableId = parcel.readString();
            String unused2 = stickerCategoryItem.mCategoryName = parcel.readString();
            String unused3 = stickerCategoryItem.mIconUrl = parcel.readString();
            String unused4 = stickerCategoryItem.mIconFileUri = parcel.readString();
            String unused5 = stickerCategoryItem.mIconMd5 = parcel.readString();
            String unused6 = stickerCategoryItem.mIconHighlightUrl = parcel.readString();
            String unused7 = stickerCategoryItem.mIconHighlightFileUri = parcel.readString();
            String unused8 = stickerCategoryItem.mIconHighlightMd5 = parcel.readString();
            long unused9 = stickerCategoryItem.mLastRequestTime = parcel.readLong();
            int unused10 = stickerCategoryItem.mPosition = parcel.readInt();
            boolean z = true;
            boolean unused11 = stickerCategoryItem.mIsNew = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                z = false;
            }
            boolean unused12 = stickerCategoryItem.mIsValid = z;
            return stickerCategoryItem;
        }

        /* renamed from: a */
        public StickerCategoryItem[] newArray(int i) {
            return new StickerCategoryItem[i];
        }
    };
    public static final String MY_CATEGORY_ID = "my_category_e5a3fe9c";
    /* access modifiers changed from: private */
    public String mCategoryName = null;
    /* access modifiers changed from: private */
    public String mIconFileUri = null;
    /* access modifiers changed from: private */
    public String mIconHighlightFileUri = null;
    /* access modifiers changed from: private */
    public String mIconHighlightMd5 = null;
    /* access modifiers changed from: private */
    public String mIconHighlightUrl = null;
    /* access modifiers changed from: private */
    public String mIconMd5 = null;
    /* access modifiers changed from: private */
    public String mIconUrl = null;
    /* access modifiers changed from: private */
    public boolean mIsNew = false;
    /* access modifiers changed from: private */
    public boolean mIsValid = true;
    /* access modifiers changed from: private */
    public long mLastRequestTime = 0;
    /* access modifiers changed from: private */
    public int mPosition = 0;
    /* access modifiers changed from: private */
    public String mReadableId = null;

    public int describeContents() {
        return 0;
    }

    public String getReadableId() {
        return this.mReadableId;
    }

    public void setReadableId(String str) {
        this.mReadableId = str;
    }

    public String getCategoryName() {
        return this.mCategoryName;
    }

    public void setCategoryName(String str) {
        this.mCategoryName = str;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public void setIconUrl(String str) {
        this.mIconUrl = str;
    }

    public String getIconFileUri() {
        return this.mIconFileUri;
    }

    public void setIconFileUri(String str) {
        this.mIconFileUri = str;
    }

    public String getIconMd5() {
        return this.mIconMd5;
    }

    public void setIconMd5(String str) {
        this.mIconMd5 = str;
    }

    public String getIconHighlightUrl() {
        return this.mIconHighlightUrl;
    }

    public void setIconHighlightUrl(String str) {
        this.mIconHighlightUrl = str;
    }

    public String getIconHighlightFileUri() {
        return this.mIconHighlightFileUri;
    }

    public void setIconHighlightFileUri(String str) {
        this.mIconHighlightFileUri = str;
    }

    public String getIconHighlightMd5() {
        return this.mIconHighlightMd5;
    }

    public void setIconHighlightMd5(String str) {
        this.mIconHighlightMd5 = str;
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

    public boolean isCategoryNew() {
        return this.mIsNew;
    }

    public void setCategoryNew(boolean z) {
        this.mIsNew = z;
    }

    public boolean isCategoryValid() {
        return this.mIsValid;
    }

    public void setCategoryValid(boolean z) {
        this.mIsValid = z;
    }

    public void copy(StickerCategoryItem stickerCategoryItem) {
        this.mReadableId = stickerCategoryItem.mReadableId;
        this.mCategoryName = stickerCategoryItem.mCategoryName;
        this.mIconUrl = stickerCategoryItem.mIconUrl;
        this.mIconMd5 = stickerCategoryItem.mIconMd5;
        this.mIconFileUri = stickerCategoryItem.mIconFileUri;
        this.mIconHighlightUrl = stickerCategoryItem.mIconHighlightUrl;
        this.mIconHighlightMd5 = stickerCategoryItem.mIconHighlightMd5;
        this.mIconHighlightFileUri = stickerCategoryItem.mIconHighlightFileUri;
        this.mLastRequestTime = stickerCategoryItem.mLastRequestTime;
        this.mPosition = stickerCategoryItem.mPosition;
        this.mIsNew = stickerCategoryItem.mIsNew;
        this.mIsValid = stickerCategoryItem.mIsValid;
    }

    public static boolean isMyCategory(String str) {
        return MY_CATEGORY_ID.equals(str);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mReadableId);
        parcel.writeString(this.mCategoryName);
        parcel.writeString(this.mIconUrl);
        parcel.writeString(this.mIconFileUri);
        parcel.writeString(this.mIconMd5);
        parcel.writeString(this.mIconHighlightUrl);
        parcel.writeString(this.mIconHighlightFileUri);
        parcel.writeString(this.mIconHighlightMd5);
        parcel.writeLong(this.mLastRequestTime);
        parcel.writeInt(this.mPosition);
        parcel.writeInt(this.mIsNew ? 1 : 0);
        parcel.writeInt(this.mIsValid ? 1 : 0);
    }

    public String toString() {
        return "[id: " + this.mReadableId + ", name: " + this.mCategoryName + ", pos: " + this.mPosition + ", isNew: " + this.mIsNew + ", uri: " + this.mIconFileUri + ", hUri: " + this.mIconHighlightFileUri + "]";
    }
}
