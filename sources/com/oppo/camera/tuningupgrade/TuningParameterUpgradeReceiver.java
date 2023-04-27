package com.oppo.camera.tuningupgrade;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.oppo.camera.e;
import com.oppo.camera.statistics.CameraStatisticsUtil;

public class TuningParameterUpgradeReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String str;
        String str2;
        String str3 = "";
        if ("com.coloros.sau.DATARES_UPDATE".equalsIgnoreCase(intent.getAction())) {
            try {
                str2 = intent.getStringExtra("code");
                try {
                    str = intent.getStringExtra(CameraStatisticsUtil.RUS_FILE_VERSION);
                    try {
                        str3 = intent.getStringExtra("from");
                    } catch (Exception e) {
                        e = e;
                        e.a("TuningParameterUpgradeReceiver", "onReceive, error: " + e.toString());
                        e.b("TuningParameterUpgradeReceiver", "onReceive, package: " + intent.getPackage() + ", code: " + str2 + ", version: " + str + ", from: " + str3);
                        Intent intent2 = new Intent(context, TuningParameterUpgradeService.class);
                        intent2.setAction("com.oppo.camera.TUNING_UPGRADE");
                        intent2.putExtra("from", str3);
                        intent2.putExtra(CameraStatisticsUtil.RUS_FILE_VERSION, str);
                        intent2.putExtra("code", str2);
                        context.startService(intent2);
                    }
                } catch (Exception e2) {
                    e = e2;
                    str = str3;
                    e.a("TuningParameterUpgradeReceiver", "onReceive, error: " + e.toString());
                    e.b("TuningParameterUpgradeReceiver", "onReceive, package: " + intent.getPackage() + ", code: " + str2 + ", version: " + str + ", from: " + str3);
                    Intent intent22 = new Intent(context, TuningParameterUpgradeService.class);
                    intent22.setAction("com.oppo.camera.TUNING_UPGRADE");
                    intent22.putExtra("from", str3);
                    intent22.putExtra(CameraStatisticsUtil.RUS_FILE_VERSION, str);
                    intent22.putExtra("code", str2);
                    context.startService(intent22);
                }
            } catch (Exception e3) {
                e = e3;
                str2 = str3;
                str = str2;
                e.a("TuningParameterUpgradeReceiver", "onReceive, error: " + e.toString());
                e.b("TuningParameterUpgradeReceiver", "onReceive, package: " + intent.getPackage() + ", code: " + str2 + ", version: " + str + ", from: " + str3);
                Intent intent222 = new Intent(context, TuningParameterUpgradeService.class);
                intent222.setAction("com.oppo.camera.TUNING_UPGRADE");
                intent222.putExtra("from", str3);
                intent222.putExtra(CameraStatisticsUtil.RUS_FILE_VERSION, str);
                intent222.putExtra("code", str2);
                context.startService(intent222);
            }
            e.b("TuningParameterUpgradeReceiver", "onReceive, package: " + intent.getPackage() + ", code: " + str2 + ", version: " + str + ", from: " + str3);
            Intent intent2222 = new Intent(context, TuningParameterUpgradeService.class);
            intent2222.setAction("com.oppo.camera.TUNING_UPGRADE");
            intent2222.putExtra("from", str3);
            intent2222.putExtra(CameraStatisticsUtil.RUS_FILE_VERSION, str);
            intent2222.putExtra("code", str2);
            context.startService(intent2222);
        }
    }
}
