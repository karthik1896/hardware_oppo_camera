package com.oppo.camera.sticker.download.thumbnail;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.oppo.camera.e;
import com.oppo.camera.sticker.a.a;
import com.oppo.camera.sticker.c.c;
import com.oppo.camera.sticker.data.StickerCategoryItem;
import com.oppo.camera.sticker.data.StickerCategoryItemWrapper;
import com.oppo.camera.sticker.data.StickerItem;
import com.oppo.camera.sticker.data.StickerItemWrapper;
import com.oppo.camera.sticker.download.thumbnail.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThumbDownloadService extends Service implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private ThreadPoolExecutor f3653a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f3654b = 0;

    public void b(Context context, boolean z, String str) {
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        e.b("ThumbDownloadService", "onCreate");
        this.f3653a = a();
    }

    private ThreadPoolExecutor a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            e.d("ThumbDownloadService", "onStartCommand, intent is null");
            return 1;
        }
        final String action = intent.getAction();
        e.b("ThumbDownloadService", "onStartCommand, action: " + action);
        this.f3653a.submit(new Runnable() {
            public void run() {
                if ("com.coloros.providers.sticker.download.category.thumbnail".equals(action)) {
                    ThumbDownloadService thumbDownloadService = ThumbDownloadService.this;
                    thumbDownloadService.a(thumbDownloadService);
                } else if ("com.coloros.providers.sticker.download.sticker.thumbnail".equals(action)) {
                    ThumbDownloadService thumbDownloadService2 = ThumbDownloadService.this;
                    thumbDownloadService2.b(thumbDownloadService2);
                }
            }
        });
        return super.onStartCommand(intent, i, i2);
    }

    /* access modifiers changed from: private */
    public void a(Context context) {
        List<StickerCategoryItem> a2 = a.a(context);
        ArrayList<StickerCategoryItemWrapper> arrayList = new ArrayList<>();
        for (StickerCategoryItem next : a2) {
            if (next instanceof StickerCategoryItemWrapper) {
                StickerCategoryItemWrapper stickerCategoryItemWrapper = (StickerCategoryItemWrapper) next;
                if (TextUtils.isEmpty(stickerCategoryItemWrapper.getIconUrl()) && TextUtils.isEmpty(stickerCategoryItemWrapper.getIconHighlightUrl())) {
                    e.d("ThumbDownloadService", "no download url, categoryItemWrapper: " + stickerCategoryItemWrapper.getReadableId());
                } else if (TextUtils.isEmpty(next.getIconFileUri()) || TextUtils.isEmpty(next.getIconHighlightFileUri())) {
                    arrayList.add(stickerCategoryItemWrapper);
                } else if (!a(stickerCategoryItemWrapper.getIconPath(), stickerCategoryItemWrapper.getIconMd5())) {
                    arrayList.add(stickerCategoryItemWrapper);
                } else if (!a(stickerCategoryItemWrapper.getIconHighlightPath(), stickerCategoryItemWrapper.getIconHighlightMd5())) {
                    arrayList.add(stickerCategoryItemWrapper);
                }
            }
        }
        synchronized (this) {
            this.f3654b += arrayList.size();
        }
        for (StickerCategoryItemWrapper bVar : arrayList) {
            this.f3653a.submit(new b(this, bVar, this));
        }
    }

    /* access modifiers changed from: private */
    public void b(Context context) {
        List<StickerItem> a2 = com.oppo.camera.sticker.a.b.a(context, false);
        ArrayList<StickerItemWrapper> arrayList = new ArrayList<>();
        for (StickerItem next : a2) {
            if (next instanceof StickerItemWrapper) {
                StickerItemWrapper stickerItemWrapper = (StickerItemWrapper) next;
                if (TextUtils.isEmpty(stickerItemWrapper.getThumbnailUrl()) && TextUtils.isEmpty(stickerItemWrapper.getLogoUrl())) {
                    e.d("ThumbDownloadService", "downloadStickerThumbnail, no download url, sticker uuid: " + stickerItemWrapper.getStickerUUID() + ", name: " + stickerItemWrapper.getStickerName());
                } else if (TextUtils.isEmpty(stickerItemWrapper.getThumbnailFileUri())) {
                    arrayList.add(stickerItemWrapper);
                } else if (!TextUtils.isEmpty(stickerItemWrapper.getLogoUrl()) && TextUtils.isEmpty(stickerItemWrapper.getLogoFileUri())) {
                    arrayList.add(stickerItemWrapper);
                } else if (!a(stickerItemWrapper.getThumbnailPath(), stickerItemWrapper.getThumbnailMd5())) {
                    arrayList.add(stickerItemWrapper);
                } else if (!TextUtils.isEmpty(stickerItemWrapper.getLogoPath()) && !a(stickerItemWrapper.getLogoPath(), stickerItemWrapper.getLogoMd5())) {
                    arrayList.add(stickerItemWrapper);
                }
            }
        }
        synchronized (this) {
            this.f3654b += arrayList.size();
        }
        for (StickerItemWrapper bVar : arrayList) {
            this.f3653a.submit(new b(this, bVar, this));
        }
    }

    private boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return c.a(str, str2);
        }
        e.d("ThumbDownloadService", "checkMd5, empty value! filePath: " + str + ", fileMd5: " + str2);
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
        e.b("ThumbDownloadService", "onDestroy");
    }

    public void a(Context context, boolean z, String str) {
        synchronized (this) {
            this.f3654b--;
            e.b("ThumbDownloadService", "onFirstDownloadFinish, mThumbnailDownloadCount: " + this.f3654b);
            if (this.f3654b == 0) {
                androidx.e.a.a.a(getApplicationContext()).a(new Intent("com.sticker.thumbnail.service"));
            }
        }
    }
}
