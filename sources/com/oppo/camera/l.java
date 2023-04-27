package com.oppo.camera;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import com.oppo.a.a.a;
import com.oppo.camera.util.Util;

/* compiled from: GalleryPreCodeClient */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private boolean f3122a = false;

    /* renamed from: b  reason: collision with root package name */
    private Intent f3123b = null;
    /* access modifiers changed from: private */
    public a c = null;
    private ServiceConnection d = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            e.a("GalleryPreCodeClient", "onServiceConnected");
            a unused = l.this.c = a.C0077a.a(iBinder);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            e.a("GalleryPreCodeClient", "onServiceDisconnected");
            synchronized (this) {
                a unused = l.this.c = null;
            }
        }
    };

    public void a(Context context) {
        this.f3123b = new Intent();
        this.f3123b.setComponent(new ComponentName("com.coloros.gallery3d", "com.oppo.gallery3d.predecode.PreTileDecodeService"));
        try {
            this.f3122a = context.bindService(this.f3123b, this.d, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        e.a("GalleryPreCodeClient", "bindPreDecodeService context: " + context + "mbBinded: " + this.f3122a + ", mIntent: " + this.f3123b);
    }

    public void b(Context context) {
        e.a("GalleryPreCodeClient", "unBindPreDecodeService context: " + context + ", mbBinded: " + this.f3122a);
        if (this.f3122a) {
            try {
                context.unbindService(this.d);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f3122a = false;
        }
    }

    public void a(Context context, Uri uri, String str, long j, boolean z) {
        if (this.c == null) {
            e.a("GalleryPreCodeClient", "call, null == preDecodeService");
        } else if (j == -1) {
            e.a("GalleryPreCodeClient", "call, date == -1 not support pre encode!");
        } else if (uri == null) {
            e.a("GalleryPreCodeClient", "call, null == image_uri ");
        } else if (context == null) {
            e.a("GalleryPreCodeClient", "call, null == mContext ");
        } else {
            if (Util.e(context).totalMem <= 1073741824) {
                if (Util.i(context) <= 262144000) {
                    e.a("GalleryPreCodeClient", "call, AvailMemory < 250M, will cause lmk and kill com.oppo.gallery3d.provider.AlbumsProvider.");
                    return;
                }
            } else if (Util.i(context) <= 367001600) {
                e.a("GalleryPreCodeClient", "call, AvailMemory < 350M, will cause lmk and kill com.oppo.gallery3d.provider.AlbumsProvider.");
                return;
            }
            e.a("GalleryPreCodeClient", "call, image_uri: " + uri.toString() + ", image_path: " + str + ", image_date: " + j);
            try {
                synchronized (this) {
                    if (this.c != null) {
                        this.c.a(uri.toString(), str, j, z);
                    }
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
