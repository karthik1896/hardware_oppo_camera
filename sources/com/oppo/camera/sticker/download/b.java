package com.oppo.camera.sticker.download;

import android.content.ContentValues;
import android.content.Context;
import com.android.providers.downloads.DownloadInfoData;
import com.crunchfish.touchless_a3d.TouchlessA3D;
import com.oppo.camera.e;
import com.oppo.camera.sticker.data.StickerItem;
import com.oppo.camera.sticker.data.StickerItemWrapper;
import com.oppo.camera.sticker.h;
import java.util.List;

/* compiled from: DownloadStatesCallbackImpl */
public class b implements com.oplus.a.a.b {

    /* renamed from: a  reason: collision with root package name */
    private Context f3652a = null;

    public b(Context context) {
        this.f3652a = context;
    }

    public void a(List<DownloadInfoData> list) {
        if (list == null || list.isEmpty()) {
            e.d("DownloadStateCallbackImpl", "onDownloadInserted, dataList is empty!");
            return;
        }
        for (DownloadInfoData a2 : list) {
            a(a2, false);
        }
    }

    public void b(List<DownloadInfoData> list) {
        if (list == null || list.isEmpty()) {
            e.d("DownloadStateCallbackImpl", "onDownloadUpdated, dataList is empty!");
            return;
        }
        for (DownloadInfoData a2 : list) {
            a(a2, false);
        }
    }

    public void c(List<DownloadInfoData> list) {
        if (list == null || list.isEmpty()) {
            e.d("DownloadStateCallbackImpl", "onDownloadDeleted, dataList is empty!");
            return;
        }
        for (DownloadInfoData a2 : list) {
            a(a2, true);
        }
    }

    public void d(List<DownloadInfoData> list) {
        if (list == null || list.isEmpty()) {
            e.d("DownloadStateCallbackImpl", "onDownloadTimeout, dataList is empty!");
            return;
        }
        for (DownloadInfoData a2 : list) {
            a(a2, true);
        }
    }

    private void a(DownloadInfoData downloadInfoData, boolean z) {
        if (downloadInfoData == null) {
            e.d("DownloadStateCallbackImpl", "handleDownloadStateChanged, downloadInfo is null!");
            return;
        }
        StickerItemWrapper a2 = com.oppo.camera.sticker.a.b.a(this.f3652a, "download_uuid", downloadInfoData.mUuid);
        if (a2 == null) {
            e.d("DownloadStateCallbackImpl", "handleDownloadStateChanged, can't find the sticker item with download uuid.");
        } else if (z) {
            e(a2, downloadInfoData);
        } else {
            int i = downloadInfoData.mStatus;
            if (i == 1) {
                a(a2, downloadInfoData);
            } else if (i == 2) {
                b(a2, downloadInfoData);
            } else if (i == 4) {
                c(a2, downloadInfoData);
            } else if (i == 8) {
                d(a2, downloadInfoData);
            } else if (i != 16) {
                e.d("DownloadStateCallbackImpl", "handleDownloadStateChanged, unsupported download status!");
            } else {
                a(a2, downloadInfoData, false);
            }
        }
    }

    private void a(StickerItemWrapper stickerItemWrapper, DownloadInfoData downloadInfoData) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_new", false);
        contentValues.put("download_state", Integer.valueOf(downloadInfoData.mStatus));
        com.oppo.camera.sticker.a.b.a(this.f3652a, "uuid", stickerItemWrapper.getStickerUUID(), contentValues);
        stickerItemWrapper.setStickerNew(false);
        stickerItemWrapper.setDownloadState(downloadInfoData.mStatus);
    }

    private void b(StickerItemWrapper stickerItemWrapper, DownloadInfoData downloadInfoData) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("download_state", Integer.valueOf(downloadInfoData.mStatus));
        com.oppo.camera.sticker.a.b.a(this.f3652a, "uuid", stickerItemWrapper.getStickerUUID(), contentValues);
        stickerItemWrapper.setStickerNew(false);
        stickerItemWrapper.setDownloadState(downloadInfoData.mStatus);
    }

    private void c(StickerItemWrapper stickerItemWrapper, DownloadInfoData downloadInfoData) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("download_state", Integer.valueOf(downloadInfoData.mStatus));
        int a2 = com.oppo.camera.sticker.a.b.a(this.f3652a, "uuid", stickerItemWrapper.getStickerUUID(), contentValues);
        e.b("DownloadStateCallbackImpl", "handleDownloadPaused, count: " + a2 + ", stickerItem: " + stickerItemWrapper);
        stickerItemWrapper.setDownloadState(downloadInfoData.mStatus);
        h.a(this.f3652a).b(stickerItemWrapper, a(downloadInfoData));
    }

    private void d(StickerItemWrapper stickerItemWrapper, DownloadInfoData downloadInfoData) {
        if (!stickerItemWrapper.isDownloaded() || stickerItemWrapper.needUpdate()) {
            boolean a2 = c.a(this.f3652a, stickerItemWrapper, downloadInfoData.mFileName);
            e.b("DownloadStateCallbackImpl", "handleDownloadSuccess, result: " + a2 + "stickerItem: " + stickerItemWrapper);
            if (a2) {
                h.a(this.f3652a).b((StickerItem) stickerItemWrapper);
                return;
            }
            e.d("DownloadStateCallbackImpl", "handleDownloadSuccess, installSticker sticker fail! stickerItem: " + stickerItemWrapper);
            a(stickerItemWrapper, downloadInfoData, true);
            return;
        }
        e.d("DownloadStateCallbackImpl", "handleDownloadSuccess, downloaded are not need update");
    }

    private int a(DownloadInfoData downloadInfoData) {
        int i = (int) downloadInfoData.mReason;
        if (i == 1011) {
            return -49;
        }
        if (i == 1012) {
            return -50;
        }
        switch (i) {
            case 1:
                return -26;
            case 2:
                return -25;
            case 3:
                return -24;
            case 4:
                break;
            case 5:
                return -21;
            case 6:
                return -23;
            case 7:
                return -22;
            default:
                switch (i) {
                    case 1000:
                        return -40;
                    case 1001:
                        return -41;
                    case TouchlessA3D.Parameters.EXTENDED_RANGE:
                        return -42;
                    default:
                        switch (i) {
                            case 1004:
                                return -43;
                            case 1005:
                                return -44;
                            case 1006:
                                return -45;
                            case 1007:
                                return -46;
                            case 1008:
                                return -47;
                            case 1009:
                                return -48;
                            default:
                                e.d("DownloadStateCallbackImpl", "getDownloadErrorCode, unknown error!");
                                if (downloadInfoData.mStatus != 4) {
                                    return -40;
                                }
                                break;
                        }
                }
        }
        return -20;
    }

    private void a(StickerItemWrapper stickerItemWrapper, DownloadInfoData downloadInfoData, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("download_state", 16);
        com.oppo.camera.sticker.a.b.a(this.f3652a, "uuid", stickerItemWrapper.getStickerUUID(), contentValues);
        e.d("DownloadStateCallbackImpl", "handleDownloadFail, isCopyFileError: " + z + ", stickerItem: " + stickerItemWrapper);
        stickerItemWrapper.setDownloadState(16);
        if (z) {
            h.a(this.f3652a).a((StickerItem) stickerItemWrapper, -51);
        } else {
            h.a(this.f3652a).a((StickerItem) stickerItemWrapper, a(downloadInfoData));
        }
    }

    private void e(StickerItemWrapper stickerItemWrapper, DownloadInfoData downloadInfoData) {
        if (stickerItemWrapper.getDownloadState() == 8) {
            e.d("DownloadStateCallbackImpl", "handleDownloadDelete, sticker is download successful! stickerItem: " + stickerItemWrapper);
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("download_state", 0);
        int a2 = com.oppo.camera.sticker.a.b.a(this.f3652a, "uuid", stickerItemWrapper.getStickerUUID(), contentValues);
        e.b("DownloadStateCallbackImpl", "handleDownloadDelete, count: " + a2 + ", stickerItem: " + stickerItemWrapper);
        stickerItemWrapper.setDownloadState(0);
    }
}
