package com.oppo.camera.soloop;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.RemoteException;
import android.view.OplusWindowManager;
import color.support.v7.app.b;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.e;
import com.oppo.camera.f.a;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.SwitchCameraMsgData;
import com.oppo.camera.ui.f;
import com.oppo.camera.util.Util;

/* compiled from: SoloopManager */
public class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public color.support.v7.app.b f3613a;

    /* renamed from: b  reason: collision with root package name */
    private Context f3614b = null;
    private a c = null;

    public b(Context context) {
        this.f3614b = context;
        this.c = new a(context);
    }

    public void a() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(int i, boolean z) {
        Context context = this.f3614b;
        if (context != null) {
            try {
                if (Util.a(context, "com.coloros.videoeditor", 12400)) {
                    b(i, z);
                } else {
                    a(z);
                }
            } catch (Exception e) {
                e.e("SoloopManager", "openSoloop error, reason: " + e.getMessage());
            }
        }
    }

    public void a(final boolean z) {
        if (this.f3613a == null) {
            this.f3613a = new b.a(this.f3614b, 2131821193).setTitle((int) R.string.soloop_dialog_alert).setPositiveButton((int) R.string.soloop_dialog_install, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    b.this.b(z);
                }
            }).setNegativeButton((int) R.string.soloop_dialog_cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    b.this.f3613a.dismiss();
                    color.support.v7.app.b unused = b.this.f3613a = null;
                }
            }).create();
            this.f3613a.setCancelable(false);
        }
        if (!this.f3613a.isShowing()) {
            this.f3613a.show();
        }
    }

    private void b(int i, boolean z) {
        Intent intent = new Intent("coloros.intent.action.SOLOOP_TEMPLATE_CAMERA");
        intent.putExtra("template_camera_mode", AlgoSwitchConfig.APS_PIPELINE_VIDEO);
        intent.putExtra("template_camera_id", i);
        if (z) {
            intent.addFlags(268468224);
        }
        c(z);
        this.f3614b.startActivity(intent);
    }

    /* access modifiers changed from: private */
    public void b(boolean z) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.coloros.videoeditor"));
        if (z) {
            intent.addFlags(268468224);
        }
        c(z);
        this.f3614b.startActivity(intent);
    }

    public void b() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.b();
            this.c = null;
        }
        color.support.v7.app.b bVar = this.f3613a;
        if (bVar != null) {
            bVar.dismiss();
            this.f3613a = null;
        }
        this.f3614b = null;
    }

    private void c(boolean z) {
        if (z) {
            try {
                new OplusWindowManager().requestKeyguard("unlockOrShowSecurity");
            } catch (RemoteException e) {
                e.e("SoloopManager", "OplusWindowManager exception: " + e.getMessage());
            } catch (Exception e2) {
                e.e("SoloopManager", "OplusWindowManager error: " + e2.getMessage());
            }
        }
    }

    public void a(Context context, f fVar, int i) {
        SwitchCameraMsgData switchCameraMsgData = new SwitchCameraMsgData(context);
        switchCameraMsgData.mCameraId = fVar.v();
        switchCameraMsgData.mCaptureMode = fVar.P();
        switchCameraMsgData.mOrientation = i;
        switchCameraMsgData.mCaptureType = ApsConstant.REC_MODE_COMMON.equals(fVar.P()) ? 1 : 0;
        switchCameraMsgData.mCameraEnterType = String.valueOf(fVar.aw().y());
        switchCameraMsgData.mToCaptureMode = ApsConstant.REC_MODE_SOLOOP;
        switchCameraMsgData.mOperType = "1";
        switchCameraMsgData.mRearOrFront = a.c(fVar.u()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
        switchCameraMsgData.report();
    }
}
