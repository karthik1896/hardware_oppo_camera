package com.oppo.camera.sticker.data;

import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.oppo.camera.e;
import com.oppo.camera.sticker.download.c;
import com.oppo.camera.sticker.f;
import com.oppo.camera.sticker.h;
import java.util.List;

/* compiled from: StickerDataManager */
public class b implements f.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f3645a = null;

    /* renamed from: b  reason: collision with root package name */
    private C0097b f3646b = null;
    private HandlerThread c = null;
    private f d = null;
    private a e = null;

    /* compiled from: StickerDataManager */
    public interface a {
        void a(int i);
    }

    public void a(int i) {
        a aVar = this.e;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public b(Context context) {
        this.f3645a = context;
        this.d = new f(context);
        this.d.a((f.a) this);
        this.c = new HandlerThread("StickerDataManager");
        this.c.start();
        this.f3646b = new C0097b(this.c.getLooper());
        c();
        e.b("StickerDataManager", "StickerDataManager this: " + this);
    }

    public void a() {
        e.b("StickerDataManager", "register this: " + this);
        com.oppo.camera.sticker.download.a.a().a(this.f3645a);
        f fVar = this.d;
        if (fVar != null) {
            fVar.a();
        }
    }

    public void b() {
        e.b("StickerDataManager", "unregister this: " + this);
        com.oppo.camera.sticker.download.a.a().b(this.f3645a);
        f fVar = this.d;
        if (fVar != null) {
            fVar.b();
        }
    }

    public void c() {
        if (!this.f3646b.hasMessages(1)) {
            this.f3646b.sendEmptyMessage(1);
        }
    }

    public void d() {
        if (!this.f3646b.hasMessages(2)) {
            e.b("StickerDataManager", "checkBuildInData");
            this.f3646b.sendEmptyMessage(2);
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        e.b("StickerDataManager", "checkBuildInDataByThread");
        e.a("checkBuildInDataByThread");
        a.a(this.f3645a);
        c();
        e.b("checkBuildInDataByThread");
    }

    public void e() {
        if (!this.f3646b.hasMessages(3)) {
            e.b("StickerDataManager", "requestSticker");
            this.f3646b.sendEmptyMessage(3);
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        e.b("StickerDataManager", "requestStickerByThread");
        e.a("requestStickerByThread");
        this.d.c();
        e.b("requestStickerByThread");
    }

    public void a(StickerItem stickerItem) {
        if (!this.f3646b.hasMessages(5)) {
            e.b("StickerDataManager", "updateStickerDownloadTime, item: " + stickerItem);
            Message obtainMessage = this.f3646b.obtainMessage(5);
            obtainMessage.obj = stickerItem;
            this.f3646b.sendMessage(obtainMessage);
        }
    }

    /* access modifiers changed from: private */
    public void a(StickerCategoryItem stickerCategoryItem) {
        e.b("StickerDataManager", "clickStickerCategoryByThread, item: " + stickerCategoryItem);
        if (stickerCategoryItem.isCategoryNew()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_new", 0);
            int a2 = com.oppo.camera.sticker.a.a.a(this.f3645a, "readable_id", stickerCategoryItem.getReadableId(), contentValues);
            e.b("StickerDataManager", "clickStickerCategoryByThread, count: " + a2);
        }
    }

    /* access modifiers changed from: private */
    public void b(StickerItem stickerItem) {
        e.b("StickerDataManager", "updateStickerDownloadTimeByThread, item: " + stickerItem);
        if (stickerItem.isBuildIn() && stickerItem.getDownloadTime() <= 0) {
            int a2 = com.oppo.camera.sticker.a.b.a(this.f3645a, stickerItem);
            e.b("StickerDataManager", "updateStickerDownloadTimeByThread, rowUpdate: " + a2);
            if (a2 > 0) {
                h.a(this.f3645a).c(stickerItem);
            }
        }
    }

    public void a(StickerItem stickerItem, boolean z) {
        if (!this.f3646b.hasMessages(6)) {
            e.b("StickerDataManager", "startDownloadSticker, item: " + stickerItem);
            Message obtainMessage = this.f3646b.obtainMessage(6);
            obtainMessage.arg1 = z ? 1 : 0;
            obtainMessage.obj = stickerItem;
            this.f3646b.sendMessage(obtainMessage);
        }
    }

    /* access modifiers changed from: private */
    public void b(StickerItem stickerItem, boolean z) {
        e.b("StickerDataManager", "downloadStickerItemByThread, item: " + stickerItem + ", allowAllNetwork: " + z);
        if (stickerItem == null || TextUtils.isEmpty(stickerItem.getStickerUUID())) {
            e.e("StickerDataManager", "downloadStickerItemByThread, item is null or empty. item: " + stickerItem);
        } else if (!stickerItem.isDownloaded() || stickerItem.needUpdate()) {
            com.oppo.camera.sticker.download.a.a().c(this.f3645a, stickerItem, z);
        } else if (stickerItem.isBuildIn() && stickerItem.getDownloadTime() <= 0) {
            com.oppo.camera.sticker.a.b.a(this.f3645a, stickerItem);
        }
    }

    public void a(List<StickerItem> list) {
        if (!this.f3646b.hasMessages(7, list)) {
            e.b("StickerDataManager", "delete, list: " + list);
            Message obtainMessage = this.f3646b.obtainMessage(7);
            obtainMessage.obj = list;
            this.f3646b.sendMessage(obtainMessage);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void b(List<StickerItem> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                c.a(this.f3645a, list, true);
                return;
            }
        }
        e.d("StickerDataManager", "deleteStickerItemsByThread, list is null or empty.");
    }

    public void f() {
        if (!this.f3646b.hasMessages(8)) {
            e.b("StickerDataManager", "autoClearClickNewStatus");
            this.f3646b.sendEmptyMessage(8);
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        long currentTimeMillis = System.currentTimeMillis();
        com.oppo.camera.sticker.a.b.a(this.f3645a, currentTimeMillis, 604800000);
        com.oppo.camera.sticker.a.a.a(this.f3645a, currentTimeMillis, 604800000);
    }

    /* renamed from: com.oppo.camera.sticker.data.b$b  reason: collision with other inner class name */
    /* compiled from: StickerDataManager */
    private class C0097b extends Handler {
        public C0097b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    return;
                case 2:
                    b.this.g();
                    return;
                case 3:
                    b.this.h();
                    return;
                case 4:
                    if (message.obj instanceof StickerCategoryItem) {
                        b.this.a((StickerCategoryItem) message.obj);
                        return;
                    }
                    return;
                case 5:
                    if (message.obj instanceof StickerItem) {
                        b.this.b((StickerItem) message.obj);
                        return;
                    }
                    return;
                case 6:
                    if (message.obj instanceof StickerItem) {
                        b bVar = b.this;
                        StickerItem stickerItem = (StickerItem) message.obj;
                        boolean z = true;
                        if (message.arg1 != 1) {
                            z = false;
                        }
                        bVar.b(stickerItem, z);
                        return;
                    }
                    return;
                case 7:
                    b.this.b((List<StickerItem>) (List) message.obj);
                    return;
                case 8:
                    b.this.i();
                    return;
                default:
                    e.e("StickerDataManager", "handleMessage, message, what: " + message.what);
                    return;
            }
        }
    }
}
