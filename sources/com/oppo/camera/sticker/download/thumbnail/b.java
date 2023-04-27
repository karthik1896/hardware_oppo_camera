package com.oppo.camera.sticker.download.thumbnail;

import android.content.Context;
import android.text.TextUtils;
import com.oppo.camera.e;
import com.oppo.camera.sticker.b.a;
import com.oppo.camera.sticker.c.c;
import java.io.File;
import java.util.Map;
import okhttp3.RequestBody;

/* compiled from: ThumbnailDownloadThread */
public class b implements Runnable {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f3657a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f3658b = null;
    /* access modifiers changed from: private */
    public a c = null;

    /* compiled from: ThumbnailDownloadThread */
    public interface a {
        void a(Context context, boolean z, String str);

        void b(Context context, boolean z, String str);
    }

    public b(Context context, a aVar, a aVar2) {
        this.f3657a = context;
        this.f3658b = aVar;
        this.c = aVar2;
    }

    public void run() {
        String firstDownloadUrl = this.f3658b.getFirstDownloadUrl();
        if (!TextUtils.isEmpty(firstDownloadUrl)) {
            final String downloadFilePath = this.f3658b.getDownloadFilePath(this.f3657a, firstDownloadUrl);
            if (!a(downloadFilePath, this.f3658b.getFirstDownloadFileMd5())) {
                a(firstDownloadUrl, downloadFilePath, new a.C0096a() {
                    public void a() {
                        b.this.f3658b.onFirstDownloadFinish(b.this.f3657a, true, downloadFilePath);
                        b.this.c.a(b.this.f3657a, true, downloadFilePath);
                        e.b("ThumbnailDownloadThread", "onSuccess, download success!");
                    }

                    public void a(String str) {
                        b.this.f3658b.onFirstDownloadFinish(b.this.f3657a, false, downloadFilePath);
                        b.this.c.a(b.this.f3657a, false, downloadFilePath);
                        if (com.oppo.camera.sticker.c.b.a(new File(downloadFilePath))) {
                            e.b("ThumbnailDownloadThread", "onFail, download fail! delete exist file fail!");
                        }
                        e.d("ThumbnailDownloadThread", "download fail! errorMsg: " + str);
                    }
                });
            } else {
                e.b("ThumbnailDownloadThread", "run, md5 is verified!, do not need download anymore!");
            }
        } else {
            e.b("ThumbnailDownloadThread", "firstDownloadUrl is empty!");
        }
        String secondDownloadUrl = this.f3658b.getSecondDownloadUrl();
        if (!TextUtils.isEmpty(secondDownloadUrl)) {
            final String downloadFilePath2 = this.f3658b.getDownloadFilePath(this.f3657a, secondDownloadUrl);
            if (!a(downloadFilePath2, this.f3658b.getSecondDownloadFileMd5())) {
                a(secondDownloadUrl, downloadFilePath2, new a.C0096a() {
                    public void a() {
                        b.this.f3658b.onSecondDownloadFinish(b.this.f3657a, true, downloadFilePath2);
                        b.this.c.b(b.this.f3657a, true, downloadFilePath2);
                        e.b("ThumbnailDownloadThread", "onSuccess, second download success!");
                    }

                    public void a(String str) {
                        b.this.f3658b.onSecondDownloadFinish(b.this.f3657a, false, downloadFilePath2);
                        b.this.c.b(b.this.f3657a, false, downloadFilePath2);
                        if (com.oppo.camera.sticker.c.b.a(new File(downloadFilePath2))) {
                            e.b("ThumbnailDownloadThread", "second download fail! delete exist file fail!");
                        }
                        e.d("ThumbnailDownloadThread", "onFail, second download fail! errorMsg: " + str);
                    }
                });
            } else {
                e.b("ThumbnailDownloadThread", "run, md5 is verified!, do not need download anymore!");
            }
        } else {
            e.b("ThumbnailDownloadThread", "secondDownloadUrl is empty!");
        }
    }

    private void a(String str, String str2, a.C0096a aVar) {
        e.b("ThumbnailDownloadThread", "download, destPath: " + str2);
        com.oppo.camera.sticker.b.a aVar2 = new com.oppo.camera.sticker.b.a(this.f3657a);
        aVar2.a(aVar2.a(a.b.POST, str, (Map<String, String>) null, (RequestBody) null), str2, aVar);
    }

    private boolean a(String str, String str2) {
        if (!new File(str).exists()) {
            e.d("ThumbnailDownloadThread", "checkMd5, file not exist!");
            return false;
        } else if (!TextUtils.isEmpty(str2)) {
            return c.a(str, str2);
        } else {
            e.d("ThumbnailDownloadThread", "checkMd5, empty md5!");
            return false;
        }
    }
}
