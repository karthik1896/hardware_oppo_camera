package com.oppo.camera.r;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.text.TextUtils;
import com.android.providers.downloads.Downloads;
import com.b.a;
import com.b.b;
import com.oppo.camera.ui.control.c;
import com.oppo.camera.z;

/* compiled from: SLVFps960Mode */
public class e extends a {
    /* access modifiers changed from: private */
    public boolean d = false;
    /* access modifiers changed from: private */
    public a e;
    private String f;
    /* access modifiers changed from: private */
    public String g;
    /* access modifiers changed from: private */
    public final b h = new b() {

        /* renamed from: b  reason: collision with root package name */
        private boolean f3587b = false;

        public void a(int i) {
            if (i != 1) {
                String str = null;
                if (i != 2) {
                    if (i == 3) {
                        if (e.this.e != null) {
                            str = e.this.g;
                        }
                        this.f3587b = true;
                        e.this.c.b(str);
                        com.oppo.camera.e.e("SLVFps960Mode", "onCompileStatusChange, compile failed!");
                    }
                } else if (!this.f3587b) {
                    if (e.this.e != null) {
                        str = e.this.g;
                    }
                    com.oppo.camera.e.b("SLVFps960Mode", "onCompileStatusChange mbStopped: " + e.this.d);
                    if (e.this.d) {
                        boolean unused = e.this.d = false;
                        e.this.c.b(str);
                    } else {
                        e.this.c.a(str);
                    }
                    com.oppo.camera.e.b("SLVFps960Mode", "onCompileStatusChange, STATUS_COMPILE_FINISHED CostTime: " + (System.currentTimeMillis() - e.this.e.c()));
                } else {
                    com.oppo.camera.e.b("SLVFps960Mode", "onCompileStatusChange, compile finished, but already failed!");
                }
            } else {
                this.f3587b = false;
            }
        }
    };

    /* access modifiers changed from: package-private */
    public int a() {
        return 960;
    }

    public boolean b() {
        return true;
    }

    public int c() {
        return 2250;
    }

    public e(Activity activity, com.oppo.camera.ui.e eVar) {
        super(activity, eVar);
        f();
        com.oppo.camera.e.b("SLVFps960Mode", "SLVFps960Mode, new MeicamVideoEngine");
    }

    private void f() {
        this.f3584a.runOnUiThread(new Runnable() {
            public void run() {
                if (e.this.e == null) {
                    e eVar = e.this;
                    a unused = eVar.e = new a(eVar.f3584a, e.this.h);
                }
            }
        });
    }

    public void d() {
        this.d = true;
        a aVar = this.e;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void e() {
        this.f3584a.runOnUiThread(new Runnable() {
            public void run() {
                if (e.this.e != null) {
                    e.this.e.b();
                    a unused = e.this.e = null;
                    com.oppo.camera.e.b("SLVFps960Mode", "exit, releaseMeicamVideoEngine");
                }
            }
        });
        super.e();
    }

    public c a(int i) {
        if (i == 2) {
            return new c(3, "button_color_inside_none", "button_shape_dial_still", 1);
        }
        return super.a(i);
    }

    public boolean a(int i, Uri uri, ContentValues contentValues, String str) {
        boolean z = false;
        this.d = false;
        if (!(this.e == null || TextUtils.isEmpty(this.f) || uri == null || contentValues == null)) {
            String replace = String.valueOf(contentValues.get("_display_name")).replace("VID", "Slow");
            ContentValues contentValues2 = new ContentValues(7);
            contentValues2.put(Downloads.Impl.COLUMN_TITLE, str);
            contentValues2.put("_display_name", replace);
            contentValues2.put("mime_type", String.valueOf(contentValues.get("mime_type")));
            contentValues2.put("relative_path", z.d((z.a) null));
            contentValues2.put("is_pending", 1);
            this.g = com.oppo.camera.util.storage.a.a(this.f3584a, this.f3584a.getContentResolver(), contentValues2).toString();
            this.e.a(i);
            z = this.e.a(uri.toString(), this.g, 960 / Integer.parseInt(this.f));
        }
        if (!z) {
            this.c.b((String) null);
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public String a(String str) {
        this.f = str;
        return "slow_motion_platform_" + str + "_960";
    }
}
