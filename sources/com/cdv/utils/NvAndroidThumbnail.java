package com.cdv.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Log;
import com.android.providers.downloads.Downloads;
import com.cdv.utils.NvAndroidBitmap;

public class NvAndroidThumbnail {
    private static final String TAG = "NvAndroidThumbnail";

    public static Bitmap createThumbnail(Context context, String str, boolean z, int i, int i2) {
        Cursor cursor;
        ContentResolver contentResolver;
        long j;
        Bitmap bitmap;
        int i3;
        Bitmap createRotatedBitmap;
        Context context2 = context;
        String str2 = str;
        boolean z2 = z;
        if (context2 == null || str2 == null || str.isEmpty()) {
            return null;
        }
        ContentResolver contentResolver2 = context.getContentResolver();
        if (contentResolver2 == null) {
            return null;
        }
        boolean startsWith = str2.startsWith("content://");
        NvAndroidBitmap.Size size = new NvAndroidBitmap.Size(i, i2);
        if (!startsWith) {
            cursor = contentResolver2.query(z2 ? MediaStore.Video.Media.EXTERNAL_CONTENT_URI : MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=?", new String[]{str2}, (String) null);
        } else {
            cursor = contentResolver2.query(Uri.parse(str), new String[]{"_id"}, (String) null, (String[]) null, (String) null);
        }
        if (cursor == null || !cursor.moveToFirst()) {
            if (cursor != null) {
                cursor.close();
            }
            return createThumbnailFromFile(context2, str2, z2, size);
        }
        int columnIndex = cursor.getColumnIndex("_id");
        if (columnIndex < 0) {
            cursor.close();
            return createThumbnailFromFile(context2, str2, z2, size);
        }
        long j2 = cursor.getLong(columnIndex);
        cursor.close();
        if (Build.VERSION.SDK_INT < 29) {
            Uri uri = z2 ? MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI : MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI;
            String[] strArr = {Downloads.Impl._DATA};
            StringBuilder sb = new StringBuilder();
            sb.append(z2 ? "video_id" : "image_id");
            sb.append("=?");
            contentResolver = contentResolver2;
            j = j2;
            Cursor query = contentResolver2.query(uri, strArr, sb.toString(), new String[]{String.valueOf(j2)}, (String) null);
            if (query != null && query.moveToFirst()) {
                if (z2) {
                    i3 = query.getColumnIndex(Downloads.Impl._DATA);
                } else {
                    i3 = query.getColumnIndex(Downloads.Impl._DATA);
                }
                if (i3 >= 0) {
                    String string = query.getString(i3);
                    query.close();
                    if (!string.isEmpty() && (createRotatedBitmap = NvAndroidBitmap.createRotatedBitmap(context2, string, size, 2, false)) != null) {
                        return transformSystemGeneratedBitmap(context2, createRotatedBitmap, str2, z2);
                    }
                    query = null;
                }
            }
            if (query != null) {
                query.close();
            }
        } else {
            contentResolver = contentResolver2;
            j = j2;
        }
        if (z2) {
            bitmap = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, j, 1, (BitmapFactory.Options) null);
        } else {
            bitmap = MediaStore.Images.Thumbnails.getThumbnail(contentResolver, j, 1, (BitmapFactory.Options) null);
        }
        if (bitmap != null) {
            return transformSystemGeneratedBitmap(context2, bitmap, str2, z2);
        }
        Log.w(TAG, String.format("Fail to get thumbnail file for media '%d'!", new Object[]{Long.valueOf(j)}));
        return createThumbnailFromFile(context2, str2, z2, size);
    }

    private static Bitmap transformSystemGeneratedBitmap(Context context, Bitmap bitmap, String str, boolean z) {
        NvAndroidBitmap.ImageInfo imageInfo;
        if (bitmap == null) {
            return null;
        }
        if (z || Build.VERSION.SDK_INT >= 29 || (imageInfo = NvAndroidBitmap.getImageInfo(context, str)) == null) {
            return bitmap;
        }
        try {
            return NvAndroidBitmap.transformBitmap(bitmap, imageInfo.orientation);
        } catch (Exception e) {
            e.printStackTrace();
            return bitmap;
        }
    }

    private static Bitmap createThumbnailFromFile(Context context, String str, boolean z, NvAndroidBitmap.Size size) {
        if (!z) {
            return NvAndroidBitmap.createRotatedBitmap(context, str, size, 2, false);
        }
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
        if (createVideoThumbnail == null) {
            Log.e(TAG, String.format("Failed to create video thumbnail bitmap for '%s'!", new Object[]{str}));
        }
        return createVideoThumbnail;
    }
}
