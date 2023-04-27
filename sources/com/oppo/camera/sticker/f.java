package com.oppo.camera.sticker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.anc.humanvideo.BuildConfig;
import com.oppo.camera.e;
import com.oppo.camera.sticker.a.b;
import com.oppo.camera.sticker.b.a;
import com.oppo.camera.sticker.c.d;
import com.oppo.camera.sticker.data.StickerCategoryItemWrapper;
import com.oppo.camera.sticker.data.StickerItemWrapper;
import com.oppo.camera.sticker.download.thumbnail.ThumbDownloadService;
import com.oppo.camera.sticker.protocol.Sticker;
import com.oppo.camera.sticker.protocol.StickerCategory;
import com.oppo.camera.sticker.protocol.StickerRequest;
import com.oppo.camera.sticker.protocol.StickerResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;

/* compiled from: StickerDataRequest */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private Context f3663a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f3664b = null;
    private BroadcastReceiver c = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            e.b("StickerDataRequest", "onReceive intent: " + intent.toString());
            if ("com.sticker.thumbnail.service".equals(intent.getAction()) && f.this.f3664b != null) {
                f.this.f3664b.a(1);
            }
        }
    };

    /* compiled from: StickerDataRequest */
    public interface a {
        void a(int i);
    }

    public void a() {
        e.b("StickerDataRequest", "register this: " + this);
        androidx.e.a.a.a(this.f3663a.getApplicationContext()).a(this.c, new IntentFilter("com.sticker.thumbnail.service"));
    }

    public void b() {
        e.b("StickerDataRequest", "unregister this: " + this);
        androidx.e.a.a.a(this.f3663a.getApplicationContext()).a(this.c);
    }

    public void a(a aVar) {
        this.f3664b = aVar;
    }

    public f(Context context) {
        this.f3663a = context;
    }

    public void c() {
        if (System.currentTimeMillis() - d.c(this.f3663a) <= d.b(this.f3663a)) {
            e.b("StickerDataRequest", "checkUpdateData, do not need update data!");
            a(this.f3663a);
            b(this.f3663a);
            return;
        }
        d();
    }

    private void d() {
        int f = d.f(this.f3663a);
        e.b("StickerDataRequest", "requestData, mode: " + f);
        com.oppo.camera.sticker.b.a aVar = new com.oppo.camera.sticker.b.a(this.f3663a);
        aVar.a(aVar.a(a.b.POST, aVar.a(this.f3663a, f), a(this.f3663a, f), aVar.a(a(f))), (a.c) new a.c() {
            public void a(ResponseBody responseBody) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    f.this.a(StickerResponse.ADAPTER.decode(responseBody.bytes()), currentTimeMillis);
                } catch (Exception e) {
                    e.d("StickerDataRequest", "requestData exception: " + e);
                }
            }

            public void a(String str) {
                e.b("StickerDataRequest", "onFail errorMsg: " + str);
            }
        });
    }

    private Map<String, String> a(Context context, int i) {
        return new HashMap();
    }

    private byte[] a(int i) {
        StickerRequest.Builder builder = new StickerRequest.Builder();
        builder.model(com.oppo.camera.sticker.c.a.a().b());
        builder.resResolution(com.oppo.camera.sticker.c.a.a().b(this.f3663a));
        builder.protocolVersion(BuildConfig.BUILD_NUMBER);
        builder.clientVersion(String.valueOf(com.oppo.camera.sticker.c.a.a().a(this.f3663a)));
        builder.colorosVersion(com.oppo.camera.sticker.c.a.a().c());
        builder.androidVersion(com.oppo.camera.sticker.c.a.a().e());
        builder.otaVersion(com.oppo.camera.sticker.c.a.a().d());
        builder.locale(com.oppo.camera.sticker.c.a.a().f());
        builder.localDataVersion(Long.valueOf(d.a(this.f3663a)));
        builder.compatibleApp(1L);
        return StickerRequest.ADAPTER.encode(builder.build());
    }

    /* access modifiers changed from: private */
    public void a(StickerResponse stickerResponse, long j) {
        StickerResponse stickerResponse2 = stickerResponse;
        long j2 = j;
        if (stickerResponse2 == null) {
            e.d("StickerDataRequest", "dealStickerResponseData, response is null!");
        } else if (stickerResponse2.resultCode.intValue() == 8000) {
            long a2 = d.a(this.f3663a);
            long longValue = stickerResponse2.dataVersion.longValue();
            e.b("StickerDataRequest", "dealStickerResponseData, localDataVersion: " + a2 + ", responseVersion: " + longValue);
            if (longValue > a2) {
                b.b(this.f3663a);
                d.b(this.f3663a, ((long) stickerResponse2.checkInterval.intValue()) * 60000);
                String str = stickerResponse2.fileServerHost;
                if (TextUtils.isEmpty(str)) {
                    e.d("StickerDataRequest", "dealStickerResponseData, hort url is empty!");
                    return;
                }
                List<StickerCategory> list = stickerResponse2.category;
                if (list == null) {
                    e.d("StickerDataRequest", "dealStickerResponseData, responseStickerCategoryList is null!");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (StickerCategory next : list) {
                    StickerCategoryItemWrapper a3 = a(next, str, j2);
                    arrayList.add(a3);
                    List<Sticker> list2 = next.sticker;
                    if (list2 == null) {
                        e.d("StickerDataRequest", "dealStickerResponseData, stickerList is null!");
                    } else {
                        for (Sticker a4 : list2) {
                            arrayList2.add(a(a4, a3, str, j));
                            a3 = a3;
                        }
                    }
                }
                boolean a5 = com.oppo.camera.sticker.a.a.a(this.f3663a, (List<StickerCategoryItemWrapper>) arrayList);
                boolean a6 = b.a(this.f3663a, (List<StickerItemWrapper>) arrayList2);
                if (!a5 || !a6) {
                    e.d("StickerDataRequest", "dealStickerResponseData db fail! updateCategoryResult: " + a5 + ", updateItemResult: " + a6);
                } else {
                    d.a(this.f3663a, longValue);
                    d.c(this.f3663a, j2);
                }
                b.c(this.f3663a);
            } else {
                e.b("StickerDataRequest", "dealStickerResponseData, data version already new. do not update!");
            }
            a(this.f3663a);
            b(this.f3663a);
        } else {
            e.d("StickerDataRequest", "dealStickerResponseData error! resultCode: " + stickerResponse2.resultCode + ", resultDesc: " + stickerResponse2.resultDesc);
        }
    }

    private StickerItemWrapper a(Sticker sticker, StickerCategoryItemWrapper stickerCategoryItemWrapper, String str, long j) {
        StickerItemWrapper stickerItemWrapper = new StickerItemWrapper();
        stickerItemWrapper.setStickerId(sticker.id.longValue());
        stickerItemWrapper.setStickerUUID(sticker.uuid);
        stickerItemWrapper.setStickerName(sticker.name);
        if (!TextUtils.isEmpty(sticker.filePath)) {
            stickerItemWrapper.setFileDownloadUrl(str + sticker.filePath);
        }
        stickerItemWrapper.setFileMd5(sticker.fileMd5);
        if (!TextUtils.isEmpty(sticker.thumbnailPath)) {
            stickerItemWrapper.setThumbnailUrl(str + sticker.thumbnailPath);
        }
        stickerItemWrapper.setThumbnailMd5(sticker.thumbnailMd5);
        if (!TextUtils.isEmpty(sticker.logoPath)) {
            stickerItemWrapper.setLogoUrl(str + sticker.logoPath);
        }
        stickerItemWrapper.setLogoMd5(sticker.logoMd5);
        stickerItemWrapper.setVersion(sticker.version.longValue());
        stickerItemWrapper.setLastRequestTime(j);
        stickerItemWrapper.setCategoryId(stickerCategoryItemWrapper.getReadableId());
        stickerItemWrapper.setCategoryPosition(stickerCategoryItemWrapper.getPosition());
        stickerItemWrapper.setPosition(sticker.position.intValue());
        stickerItemWrapper.setAttribute(sticker.compatibleApp.longValue());
        stickerItemWrapper.setHasMusic(sticker.hasMusic.booleanValue());
        stickerItemWrapper.setIsBuildIn(false);
        stickerItemWrapper.setMaterialType(sticker.materialType.intValue());
        if (sticker.isNew != null) {
            stickerItemWrapper.setStickerNew(sticker.isNew.booleanValue());
        }
        return stickerItemWrapper;
    }

    private StickerCategoryItemWrapper a(StickerCategory stickerCategory, String str, long j) {
        StickerCategoryItemWrapper stickerCategoryItemWrapper = new StickerCategoryItemWrapper();
        stickerCategoryItemWrapper.setCategoryName(stickerCategory.name);
        if (!TextUtils.isEmpty(stickerCategory.iconPath)) {
            stickerCategoryItemWrapper.setIconUrl(str + stickerCategory.iconPath);
        }
        stickerCategoryItemWrapper.setIconMd5(stickerCategory.iconMd5);
        if (!TextUtils.isEmpty(stickerCategory.highlightIconPath)) {
            stickerCategoryItemWrapper.setIconHighlightUrl(str + stickerCategory.highlightIconPath);
        }
        stickerCategoryItemWrapper.setIconHighlightMd5(stickerCategory.highlightIconMd5);
        stickerCategoryItemWrapper.setLastRequestTime(j);
        stickerCategoryItemWrapper.setReadableId(stickerCategory.readableId);
        stickerCategoryItemWrapper.setPosition(stickerCategory.position.intValue());
        if (stickerCategory.isNew != null) {
            stickerCategoryItemWrapper.setCategoryNew(stickerCategory.isNew.booleanValue());
        }
        return stickerCategoryItemWrapper;
    }

    private void a(Context context) {
        Intent intent = new Intent(context, ThumbDownloadService.class);
        intent.setAction("com.coloros.providers.sticker.download.category.thumbnail");
        try {
            context.startService(intent);
        } catch (IllegalStateException e) {
            e.d("StickerDataRequest", "startDownloadCategoryThumbnail, e: " + e);
        }
    }

    private void b(Context context) {
        Intent intent = new Intent(context, ThumbDownloadService.class);
        intent.setAction("com.coloros.providers.sticker.download.sticker.thumbnail");
        try {
            context.startService(intent);
        } catch (IllegalStateException e) {
            e.d("StickerDataRequest", "startDownloadStickerThumbnail, e: " + e);
        }
    }
}
