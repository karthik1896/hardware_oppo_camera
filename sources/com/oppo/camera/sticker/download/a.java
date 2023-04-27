package com.oppo.camera.sticker.download;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.android.providers.downloads.DownloadInfoData;
import com.oplus.a.a.a;
import com.oplus.a.a.b;
import com.oplus.os.OplusUsbEnvironment;
import com.oppo.camera.e;
import com.oppo.camera.sticker.data.StickerItem;
import com.oppo.camera.sticker.data.StickerItemWrapper;
import com.oppo.camera.sticker.h;
import com.oppo.camera.util.Util;
import java.io.File;
import java.util.List;

/* compiled from: DownloadManagerHelper */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f3648a;

    /* renamed from: b  reason: collision with root package name */
    private b f3649b = null;
    /* access modifiers changed from: private */
    public Object c = new Object();

    private String b() {
        return "application/x-zip-compressed";
    }

    public static a a() {
        if (f3648a == null) {
            synchronized (a.class) {
                if (f3648a == null) {
                    f3648a = new a();
                }
            }
        }
        return f3648a;
    }

    public void a(Context context) {
        if (this.f3649b == null) {
            this.f3649b = new b(context);
        }
        com.oplus.a.a.a.a(context, (String) null).a((b) this.f3649b);
    }

    public void b(Context context) {
        com.oplus.a.a.a.a(context, (String) null).a();
        this.f3649b = null;
    }

    private File a(String str) {
        String str2 = File.separator + "ColorOS" + File.separator + ".Sticker" + File.separator + ".download";
        File externalCacheDir = Util.f().getExternalCacheDir();
        if (externalCacheDir == null) {
            File file = new File(OplusUsbEnvironment.getInternalSdDirectory(Util.f()).getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + Util.f().getPackageName() + File.separator + "cache");
            if (!file.exists() && !file.mkdirs()) {
                e.e("DownloadManagerHelper", "getDownloadFilePath, cacheDir.mkdirs fail");
            }
            externalCacheDir = file;
        }
        File file2 = new File(externalCacheDir.getAbsolutePath() + str2, str);
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.exists() && parentFile.mkdirs()) {
            e.d("DownloadManagerHelper", "getDownloadFilePath, mkdirs fail! file: " + file2.getPath());
        }
        return file2;
    }

    public int a(Context context, StickerItem stickerItem, int i, boolean z) {
        if (stickerItem == null || TextUtils.isEmpty(stickerItem.getFileDownloadUrl())) {
            return -1;
        }
        e.b("DownloadManagerHelper", "startDownload, downloadType: " + i + ", allowMobileNetwork: " + z + ", stickerItem: " + stickerItem);
        File a2 = a(stickerItem.getStickerUUID());
        if (i != 1 || !a2.exists() || a2.delete()) {
            com.oplus.a.a.a a3 = com.oplus.a.a.a.a(context);
            a.e eVar = new a.e(Uri.parse(stickerItem.getFileDownloadUrl()));
            eVar.a(Uri.fromFile(a2));
            eVar.a((CharSequence) stickerItem.getStickerName());
            eVar.a(b());
            eVar.c(stickerItem.getFileMd5());
            eVar.b(2);
            eVar.a(true);
            eVar.b(stickerItem.getStickerUUID());
            if (z) {
                eVar.a(7);
            } else {
                eVar.a(6);
            }
            if (i == 2) {
                eVar.b(true);
            } else {
                eVar.b(false);
            }
            String a4 = a3.a(eVar);
            if (TextUtils.isEmpty(a4)) {
                return -3;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("download_uuid", a4);
            contentValues.put("is_new", false);
            int a5 = com.oppo.camera.sticker.a.b.a(context, "uuid", stickerItem.getStickerUUID(), contentValues);
            stickerItem.setDownloadUid(a4);
            stickerItem.setStickerNew(false);
            e.b("DownloadManagerHelper", "startDownload, update download uuid. result: " + a5 + ", downloadUuid: " + a4);
            return 0;
        }
        e.d("DownloadManagerHelper", "startDownload, delete exist file fail! path: " + a2);
        return -2;
    }

    public void a(Context context, StickerItem stickerItem, boolean z) {
        if (stickerItem == null) {
            e.d("DownloadManagerHelper", "resumeDownload, sticker item is null!");
            return;
        }
        com.oplus.a.a.a a2 = com.oplus.a.a.a.a(context);
        if (z) {
            a2.a(7, stickerItem.getDownloadUid());
        } else {
            a2.a(6, stickerItem.getDownloadUid());
        }
        a2.b(stickerItem.getDownloadUid());
    }

    public void b(Context context, StickerItem stickerItem, boolean z) {
        if (stickerItem == null) {
            e.d("DownloadManagerHelper", "restartDownload, sticker item is null!");
            return;
        }
        com.oplus.a.a.a a2 = com.oplus.a.a.a.a(context);
        if (z) {
            try {
                a2.a(7, stickerItem.getDownloadUid());
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            a2.a(6, stickerItem.getDownloadUid());
        }
        a2.a(stickerItem.getDownloadUid());
    }

    public void c(Context context, StickerItem stickerItem, boolean z) {
        e.b("DownloadManagerHelper", "startDownloadSticker, allowAllNetwork: " + z + ", stickerItem: " + stickerItem);
        if (stickerItem == null) {
            e.d("DownloadManagerHelper", "startDownloadSticker, stickerItem is null!");
            return;
        }
        StickerItemWrapper a2 = com.oppo.camera.sticker.a.b.a(context, "uuid", stickerItem.getStickerUUID());
        if (a2 == null) {
            e.d("DownloadManagerHelper", "startDownloadSticker, can not find the sticker in db! stickerItem: " + stickerItem);
            return;
        }
        boolean z2 = stickerItem.getDownloadState() != a2.getDownloadState();
        stickerItem.copy(a2);
        int downloadState = stickerItem.getDownloadState();
        if (stickerItem.needUpdate()) {
            int a3 = a(context, stickerItem, 2, z);
            if (a3 != 0) {
                h.a(context).a(stickerItem, a3);
            }
        } else if (downloadState == 0) {
            int a4 = a(context, stickerItem, 1, z);
            if (a4 != 0) {
                h.a(context).a(stickerItem, a4);
            }
        } else if (downloadState != 1 && downloadState != 2) {
            if (downloadState == 4) {
                a(context, stickerItem, z);
            } else if (downloadState != 8) {
                if (downloadState == 16) {
                    b(context, stickerItem, z);
                }
            } else if (z2) {
                e.d("DownloadManagerHelper", "startDownloadSticker, download state is different, restart it again!");
                b(context, stickerItem, z);
            }
        }
    }

    public void c(final Context context) {
        new Thread(new Runnable() {
            public void run() {
                synchronized (a.this.c) {
                    List<StickerItem> a2 = com.oppo.camera.sticker.a.b.a(context);
                    e.b("DownloadManagerHelper", "syncDownloadData, unDownloadSticker.size(): " + a2.size());
                    for (StickerItem next : a2) {
                        if (TextUtils.isEmpty(next.getDownloadUid())) {
                            e.d("DownloadManagerHelper", "syncDownloadDataFromDownloadCenter, sticker download uuid is empty! sticker: " + next);
                            com.oppo.camera.sticker.a.b.b(context, next);
                        } else {
                            e.b("DownloadManagerHelper", "unDownloadedSticker: " + next);
                            DownloadInfoData a3 = com.oplus.a.a.a.a(context).a(next.getDownloadUid());
                            e.b("DownloadManagerHelper", "downloadInfoData: " + a3);
                            if (a3 == null) {
                                e.d("DownloadManagerHelper", "syncDownloadDataFromDownloadCenter, download info is null! sticker: " + next);
                                com.oppo.camera.sticker.a.b.b(context, next);
                            } else if (a3.mStatus != 8) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("download_state", Integer.valueOf(a3.mStatus));
                                com.oppo.camera.sticker.a.b.a(context, "uuid", next.getStickerUUID(), contentValues);
                            } else if (!c.a(context, (StickerItemWrapper) next, a3.mFileName)) {
                                com.oppo.camera.sticker.a.b.b(context, next);
                            }
                        }
                    }
                }
            }
        }).start();
    }
}
