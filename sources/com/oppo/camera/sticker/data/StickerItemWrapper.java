package com.oppo.camera.sticker.data;

import android.content.ContentValues;
import android.content.Context;
import com.oppo.camera.sticker.a.b;
import com.oppo.camera.sticker.download.thumbnail.a;
import com.oppo.camera.sticker.provider.FileProvider;
import java.io.File;

public class StickerItemWrapper extends StickerItem implements a {
    private static final String TAG = "StickerItemWrapper";
    private String mFilePath = null;
    private String mLogoPath = null;
    private String mThumbnailPath = null;

    public String getFilePath() {
        return this.mFilePath;
    }

    public void setFilePath(String str) {
        this.mFilePath = str;
    }

    public String getThumbnailPath() {
        return this.mThumbnailPath;
    }

    public void setThumbnailPath(String str) {
        this.mThumbnailPath = str;
    }

    public String getLogoPath() {
        return this.mLogoPath;
    }

    public void setLogoPath(String str) {
        this.mLogoPath = str;
    }

    public String getFirstDownloadUrl() {
        return getThumbnailUrl();
    }

    public String getFirstDownloadFileMd5() {
        return getThumbnailMd5();
    }

    public void onFirstDownloadFinish(Context context, boolean z, String str) {
        if (z) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("thumbnail_file_uri", FileProvider.a(context, new File(str)).toString());
            contentValues.put("thumbnail_path", str);
            b.a(context, "uuid", getStickerUUID(), contentValues);
        }
    }

    public String getSecondDownloadUrl() {
        return getLogoUrl();
    }

    public String getSecondDownloadFileMd5() {
        return getLogoMd5();
    }

    public void onSecondDownloadFinish(Context context, boolean z, String str) {
        if (z) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("logo_file_uri", FileProvider.a(context, new File(str)).toString());
            contentValues.put("logo_path", str);
            b.a(context, "uuid", getStickerUUID(), contentValues);
        }
    }

    public String getDownloadFilePath(Context context, String str) {
        return com.oppo.camera.sticker.c.b.a(context, com.oppo.camera.sticker.c.b.l, com.oppo.camera.sticker.c.b.a(str));
    }

    public String toDumpString() {
        return "[id: " + getStickerId() + ", name: " + getStickerName() + ", pos: " + getPosition() + ", reqTime: " + getLastRequestTime() + ", dState: " + getDownloadState() + ", dTime: " + getDownloadTime() + ", dUid: " + getDownloadUid() + ", cId: " + getCategoryId() + ", cPos: " + getCategoryPosition() + ", ver: " + getVersion() + ", pVer: " + getProtocolVersion() + ", attr: " + getAttribute() + ", buildIn: " + isBuildIn() + ", hasMusic: " + hasMusic() + ", nUpdate: " + needUpdate() + ", isNew: " + isStickerNew() + ", valid: " + isValid() + ", uuid: " + getStickerUUID() + ", fileMd5: " + getFileMd5() + ", thumbMd5: " + getThumbnailMd5() + ", logoMd5: " + getLogoMd5() + "]";
    }
}
