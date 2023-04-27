package com.oppo.camera.sticker.download.thumbnail;

import android.content.Context;

/* compiled from: IThumbDownloadTask */
public interface a {
    String getDownloadFilePath(Context context, String str);

    String getFirstDownloadFileMd5();

    String getFirstDownloadUrl();

    String getSecondDownloadFileMd5();

    String getSecondDownloadUrl();

    void onFirstDownloadFinish(Context context, boolean z, String str);

    void onSecondDownloadFinish(Context context, boolean z, String str);
}
