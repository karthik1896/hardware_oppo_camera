package com.oppo.camera.sticker.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnimojiStickerExtendedInfo implements Parcelable {
    public static final Parcelable.Creator<AnimojiStickerExtendedInfo> CREATOR = new Parcelable.Creator<AnimojiStickerExtendedInfo>() {
        /* renamed from: a */
        public AnimojiStickerExtendedInfo createFromParcel(Parcel parcel) {
            AnimojiStickerExtendedInfo animojiStickerExtendedInfo = new AnimojiStickerExtendedInfo();
            String unused = animojiStickerExtendedInfo.mBackgroundColor = parcel.readString();
            return animojiStickerExtendedInfo;
        }

        /* renamed from: a */
        public AnimojiStickerExtendedInfo[] newArray(int i) {
            return new AnimojiStickerExtendedInfo[i];
        }
    };
    /* access modifiers changed from: private */
    @SerializedName("background_color")
    @Expose
    public String mBackgroundColor = null;

    public int describeContents() {
        return 0;
    }

    public void setBackgroundColor(String str) {
        this.mBackgroundColor = str;
    }

    public String getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mBackgroundColor);
    }

    public String toString() {
        return "[color: " + this.mBackgroundColor + "]";
    }
}
