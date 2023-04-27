package com.oppo.camera.sticker;

import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import com.oppo.camera.e;
import com.oppo.camera.sticker.data.StickerItem;
import com.oppo.camera.sticker.data.b;
import com.oppo.camera.sticker.download.a;
import com.oppo.camera.sticker.download.thumbnail.ThumbDownloadService;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: StickerMediator */
public class h implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile h f3667a;

    /* renamed from: b  reason: collision with root package name */
    private Context f3668b = null;
    private b c = null;
    private ConcurrentHashMap<String, a> d = new ConcurrentHashMap<>();
    private boolean e = false;
    private boolean f = false;

    public static h a(Context context) {
        if (f3667a == null) {
            synchronized (h.class) {
                if (f3667a == null) {
                    e.b("StickerMediator", "getInstance");
                    f3667a = new h(context.getApplicationContext());
                }
            }
        }
        return f3667a;
    }

    private h(Context context) {
        e.b("StickerMediator", "StickerMediator");
        this.f3668b = context;
        this.c = new b(context);
        this.c.a((b.a) this);
    }

    public void a() {
        e.b("StickerMediator", "create, mbCreated: " + this.e + ", mbDataLoaded: " + this.f);
        e.a("StickerMediator.create");
        a.a().c(this.f3668b);
        if (!this.e) {
            this.c.a();
            this.e = true;
            if (!this.f) {
                this.c.d();
                com.oppo.camera.sticker.c.b.c(com.oppo.camera.sticker.c.b.k);
                this.f = true;
            }
        }
        e.b("StickerMediator.create");
    }

    public void b() {
        e.b("StickerMediator", "release, mIsCreated: " + this.e);
        if (this.e) {
            this.c.b();
            this.e = false;
        }
    }

    public synchronized void a(a aVar) {
        this.c.f();
        if (aVar != null) {
            String valueOf = String.valueOf(Binder.getCallingPid());
            if (this.d.get(valueOf) != null) {
                this.d.remove(valueOf);
            }
            this.d.put(valueOf, aVar);
            e.b("StickerMediator", "addStickerCallback, mStickerCallbacks.size: " + this.d.size());
        }
    }

    public synchronized void b(a aVar) {
        String valueOf = String.valueOf(Binder.getCallingPid());
        if (this.d.get(valueOf) != null) {
            this.d.remove(valueOf);
        }
        if (this.d.isEmpty()) {
            this.f3668b.stopService(new Intent(this.f3668b, ThumbDownloadService.class));
            e.b("StickerMediator", "removeStickerCallback, stop ThumbDownloadService");
        }
        e.b("StickerMediator", "removeStickerCallback, mStickerCallbacks.size: " + this.d.size());
    }

    public void c() {
        this.c.e();
    }

    public void a(StickerItem stickerItem) {
        e.b("StickerMediator", "updateStickerDownloadTime, item: " + stickerItem);
        this.c.a(stickerItem);
    }

    public void a(StickerItem stickerItem, boolean z) {
        this.c.a(stickerItem, z);
    }

    public void a(List<StickerItem> list) {
        this.c.a(list);
    }

    public void a(int i) {
        for (Map.Entry<String, a> value : this.d.entrySet()) {
            try {
                a aVar = (a) value.getValue();
                if (aVar != null) {
                    aVar.a(i);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void b(StickerItem stickerItem) {
        for (Map.Entry<String, a> value : this.d.entrySet()) {
            try {
                a aVar = (a) value.getValue();
                if (aVar != null) {
                    aVar.b(stickerItem);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c(StickerItem stickerItem) {
        for (Map.Entry<String, a> value : this.d.entrySet()) {
            try {
                a aVar = (a) value.getValue();
                if (aVar != null) {
                    aVar.c(stickerItem);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d(StickerItem stickerItem) {
        for (Map.Entry<String, a> value : this.d.entrySet()) {
            try {
                a aVar = (a) value.getValue();
                if (aVar != null) {
                    aVar.a(stickerItem);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void d() {
        for (Map.Entry<String, a> value : this.d.entrySet()) {
            try {
                a aVar = (a) value.getValue();
                if (aVar != null) {
                    aVar.a();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a(StickerItem stickerItem, int i) {
        for (Map.Entry<String, a> value : this.d.entrySet()) {
            try {
                a aVar = (a) value.getValue();
                if (aVar != null) {
                    aVar.a(stickerItem, i);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void b(StickerItem stickerItem, int i) {
        for (Map.Entry<String, a> value : this.d.entrySet()) {
            try {
                a aVar = (a) value.getValue();
                if (aVar != null) {
                    aVar.b(stickerItem, i);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
