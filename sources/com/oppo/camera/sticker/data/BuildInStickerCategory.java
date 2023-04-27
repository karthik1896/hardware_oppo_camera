package com.oppo.camera.sticker.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;

public class BuildInStickerCategory implements Parcelable {
    public static final Parcelable.Creator<BuildInStickerCategory> CREATOR = new Parcelable.Creator<BuildInStickerCategory>() {
        /* renamed from: a */
        public BuildInStickerCategory createFromParcel(Parcel parcel) {
            BuildInStickerCategory buildInStickerCategory = new BuildInStickerCategory();
            String unused = buildInStickerCategory.mReadableId = parcel.readString();
            String unused2 = buildInStickerCategory.mCategoryName = parcel.readString();
            String unused3 = buildInStickerCategory.mIconPath = parcel.readString();
            String unused4 = buildInStickerCategory.mIconHighlightPath = parcel.readString();
            int unused5 = buildInStickerCategory.mPosition = parcel.readInt();
            return buildInStickerCategory;
        }

        /* renamed from: a */
        public BuildInStickerCategory[] newArray(int i) {
            return new BuildInStickerCategory[i];
        }
    };
    /* access modifiers changed from: private */
    @Expose
    public String mCategoryName = null;
    /* access modifiers changed from: private */
    @Expose
    public String mIconHighlightPath = null;
    /* access modifiers changed from: private */
    @Expose
    public String mIconPath = null;
    /* access modifiers changed from: private */
    @Expose
    public int mPosition = 0;
    /* access modifiers changed from: private */
    @Expose
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

    public String getIconPath() {
        return this.mIconPath;
    }

    public void setIconPath(String str) {
        this.mIconPath = str;
    }

    public String getIconHighlightPath() {
        return this.mIconHighlightPath;
    }

    public void setIconHighlightPath(String str) {
        this.mIconHighlightPath = str;
    }

    public StickerCategoryItemWrapper obtainStickerCategoryItem() {
        StickerCategoryItemWrapper stickerCategoryItemWrapper = new StickerCategoryItemWrapper();
        stickerCategoryItemWrapper.setReadableId(this.mReadableId);
        stickerCategoryItemWrapper.setCategoryName(this.mCategoryName);
        stickerCategoryItemWrapper.setPosition(this.mPosition);
        stickerCategoryItemWrapper.setIconPath(this.mIconPath);
        stickerCategoryItemWrapper.setIconHighlightPath(this.mIconHighlightPath);
        return stickerCategoryItemWrapper;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mReadableId);
        parcel.writeString(this.mCategoryName);
        parcel.writeString(this.mIconPath);
        parcel.writeString(this.mIconHighlightPath);
        parcel.writeInt(this.mPosition);
    }

    public String toString() {
        return "[id: " + this.mReadableId + ", pos: " + this.mPosition + ", name: " + this.mCategoryName + ", path: " + this.mIconPath + ", hPath: " + this.mIconHighlightPath + "]";
    }
}
