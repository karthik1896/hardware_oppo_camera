package com.oppo.camera.util.storage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.oppo.camera.d;
import com.oppo.camera.e;
import com.oppo.camera.z;
import java.util.Iterator;
import java.util.Set;

/* compiled from: MediaStoreUtil */
public class a implements d {
    public static Uri a(Context context) {
        if ("off".equals(z.r)) {
            return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        }
        if ("on".equals(z.r) && Build.VERSION.SDK_INT >= 29) {
            Set<String> externalVolumeNames = MediaStore.getExternalVolumeNames(context);
            String h = z.h();
            if (externalVolumeNames.contains(h)) {
                e.b("MediaStoreUtil", "getStoragePlaceVideoUri VolumeNameForExternalDirectory: " + h);
                return MediaStore.Video.Media.getContentUri(h);
            }
            Iterator<String> it = externalVolumeNames.iterator();
            if (it.hasNext()) {
                return MediaStore.Video.Media.getContentUri(it.next());
            }
        }
        return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    }

    public static Uri a(Context context, ContentResolver contentResolver, ContentValues contentValues) {
        return contentResolver.insert(a(context), contentValues);
    }
}
