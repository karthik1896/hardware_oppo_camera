package com.heytap.epona.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import com.heytap.epona.Response;
import com.heytap.epona.a;
import com.heytap.epona.c;
import com.heytap.epona.e.a;
import com.heytap.epona.f;

/* compiled from: LaunchComponentInterceptor */
public class d implements f {
    public void a(f.a aVar) {
        String componentName = aVar.a().getComponentName();
        if (a(componentName)) {
            a.a("LaunchComponentInterceptor", "RemoteTransfer with componentName = %s found. Proceed", componentName);
            aVar.d();
            return;
        }
        a.C0068a b2 = aVar.b();
        ApplicationInfo b3 = b(componentName);
        if (b3 == null) {
            com.heytap.epona.e.a.a("LaunchComponentInterceptor", "find component:%s failed", componentName);
            b2.onReceive(Response.defaultErrorResponse());
        } else if (a(b(b3))) {
            com.heytap.epona.e.a.a("LaunchComponentInterceptor", "launch component:%s success", componentName);
            aVar.d();
        } else {
            com.heytap.epona.e.a.a("LaunchComponentInterceptor", "launch component:%s failed", componentName);
            b2.onReceive(Response.defaultErrorResponse());
        }
    }

    private boolean a(String str) {
        return com.heytap.epona.b.b.a.b().a(str) != null;
    }

    private ApplicationInfo b(String str) {
        Context c = c.c();
        if (c == null) {
            return null;
        }
        for (ApplicationInfo next : c.getPackageManager().getInstalledApplications(128)) {
            String[] a2 = a(next);
            int length = a2.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (a2[i].trim().equals(str)) {
                        return next;
                    }
                    i++;
                }
            }
        }
        return null;
    }

    private String[] a(ApplicationInfo applicationInfo) {
        String string;
        String[] strArr = new String[0];
        Bundle bundle = applicationInfo.metaData;
        if (bundle == null || (string = bundle.getString("epona_components")) == null) {
            return strArr;
        }
        return string.split("\\|");
    }

    private Uri b(ApplicationInfo applicationInfo) {
        String str = applicationInfo.packageName;
        return Uri.parse("content://" + str + ".epona");
    }

    private boolean a(Uri uri) {
        Context c = c.c();
        if (c == null) {
            return false;
        }
        try {
            return c.getContentResolver().call(uri, "launchComponent", (String) null, (Bundle) null).getBoolean("KEY_LAUNCH_SUCCESS");
        } catch (Exception unused) {
            return false;
        }
    }
}
