package com.oplus.a.a;

import android.net.Uri;
import com.android.providers.downloads.Downloads;

/* compiled from: OplusDownloads */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Uri f2678a = Uri.parse("content://downloads/oplusdownloads_listen");

    /* renamed from: b  reason: collision with root package name */
    public static final Uri f2679b = Uri.parse("content://downloads/oppodownloads_listen");
    public static final String[] c = {Downloads.Impl.COLUMN_ERROR_MSG, "extra", "'placeholder' AS status_detailed", "uuid", "statistics_id"};
}
