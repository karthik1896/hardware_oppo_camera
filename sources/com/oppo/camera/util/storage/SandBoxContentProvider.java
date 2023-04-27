package com.oppo.camera.util.storage;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;
import com.oppo.camera.z;
import java.io.File;

public class SandBoxContentProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    private static UriMatcher f4630a = new UriMatcher(-1);

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    static {
        f4630a.addURI("com.oppo.camera.gallery.cache.provider", "/wallpaper/cache/*", 1);
        f4630a.addURI("com.oppo.camera.gallery.cache.provider", "/wallpaper/locked/*", 2);
    }

    public String getType(Uri uri) {
        e.a("SandBoxContentProvider", "getType, uri: " + uri.toString());
        int match = f4630a.match(uri);
        if (match == 1) {
            String lastPathSegment = uri.getLastPathSegment();
            Uri a2 = a("com.coloros.gallery3d", z.b() + File.separator + lastPathSegment);
            if (a2 != null) {
                return a2.toString();
            }
            return null;
        } else if (match != 2) {
            return null;
        } else {
            String lastPathSegment2 = uri.getLastPathSegment();
            Uri a3 = a("com.coloros.gallery3d", getContext().getExternalCacheDir().getPath() + File.separator + lastPathSegment2 + ".cshot");
            if (a3 != null) {
                return a3.toString();
            }
            return null;
        }
    }

    private Uri a(String str, String str2) {
        if (!new File(str2).exists()) {
            return null;
        }
        Uri a2 = FileProvider.a(getContext(), "com.oppo.camera.gallery.cache.fileprovider", new File(str2));
        a(getContext(), str, a2);
        return a2;
    }

    private void a(Context context, String str, Uri uri) {
        context.grantUriPermission(str, uri, 3);
    }

    public static void a(Context context) {
        Uri a2 = FileProvider.a(context, "com.oppo.camera.gallery.cache.fileprovider", new File(Util.x(context).getPath()));
        Uri a3 = FileProvider.a(context, "com.oppo.camera.gallery.cache.fileprovider", new File(z.b()));
        context.revokeUriPermission("com.coloros.gallery3d", a2, 3);
        context.revokeUriPermission("com.coloros.gallery3d", a3, 3);
    }
}
