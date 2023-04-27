package com.oppo.camera.tuningupgrade;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.preference.j;
import com.oppo.camera.e;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class TuningParameterUpgradeService extends IntentService {
    public TuningParameterUpgradeService() {
        super("TuningParameterUpgradeService");
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (intent != null && "com.oppo.camera.TUNING_UPGRADE".equalsIgnoreCase(intent.getAction())) {
            String str = "/data/oppo/common/sau_res/res/" + intent.getStringExtra("code") + File.separator;
            String stringExtra = intent.getStringExtra(CameraStatisticsUtil.RUS_FILE_VERSION);
            String stringExtra2 = intent.getStringExtra("from");
            e.b("TuningParameterUpgradeService", "onHandleIntent, call from broadcast version: " + stringExtra + ", from: " + stringExtra2 + ", oldPath: " + str);
            SharedPreferences.Editor edit = j.a((Context) this).edit();
            edit.putInt("copy_tuning_file_state", 1);
            edit.apply();
            if (!"TuningParameterUpgradeService".equals(stringExtra2) && !"MyApplication".equals(stringExtra2)) {
                boolean a2 = a(str, "/data/vendor/camera_update/");
                b("/data/vendor/camera_update/updateFlag", "1");
                e.b("TuningParameterUpgradeService", "onHandleIntent, copy result: " + a2);
            } else if ("MyApplication".equals(stringExtra2)) {
                a();
            }
            edit.putInt("copy_tuning_file_state", 2);
            edit.apply();
        }
    }

    private void a() {
        try {
            File file = new File("/data/vendor/camera_update/");
            if (file.exists()) {
                if (file.isDirectory()) {
                    String[] list = file.list();
                    if (list != null) {
                        boolean z = true;
                        if (1 <= list.length) {
                            boolean z2 = false;
                            if (!Arrays.asList(list).contains("updateFlag") || !Arrays.asList(list).contains("updateInfo")) {
                                z = false;
                            }
                            if (z) {
                                String a2 = a("/data/vendor/camera_update/updateFlag");
                                e.b("TuningParameterUpgradeService", "onHandleIntent, flag: " + a2);
                                if ("0".equals(a2)) {
                                    z2 = a("/data/oppo/common/sau_res/res/camera_tuning_upgrade", "/data/vendor/camera_update/");
                                    b("/data/vendor/camera_update/updateFlag", "1");
                                }
                            }
                            e.b("TuningParameterUpgradeService", "onHandleIntent, checkresult: " + z + ", copyres: " + z2 + ", file: " + Arrays.toString(list));
                            return;
                        }
                    }
                    e.b("TuningParameterUpgradeService", "onHandleIntent, no update files");
                    return;
                }
            }
            e.b("TuningParameterUpgradeService", "onHandleIntent, no update dir");
        } catch (Exception e) {
            e.d("TuningParameterUpgradeService", "onHandleIntent ", e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:321:0x068f A[SYNTHETIC, Splitter:B:321:0x068f] */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x0698 A[Catch:{ Exception -> 0x0693 }] */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x06a0 A[Catch:{ Exception -> 0x0693 }] */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x06b4 A[SYNTHETIC, Splitter:B:333:0x06b4] */
    /* JADX WARNING: Removed duplicated region for block: B:338:0x06bd A[Catch:{ Exception -> 0x06b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x06c5 A[Catch:{ Exception -> 0x06b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:370:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:375:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0197 A[SYNTHETIC, Splitter:B:61:0x0197] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01e4 A[SYNTHETIC, Splitter:B:68:0x01e4] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01ef A[SYNTHETIC, Splitter:B:74:0x01ef] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0239 A[SYNTHETIC, Splitter:B:81:0x0239] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0266 A[SYNTHETIC, Splitter:B:97:0x0266] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.String r28, java.lang.String r29) {
        /*
            r27 = this;
            r1 = r27
            r2 = r28
            r3 = r29
            java.lang.String r4 = "updateFlag"
            java.lang.String r5 = "updateInfo"
            java.lang.String r6 = "copyFiles, finally exception occurred"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "copyTunningFiles, path info oldPath: "
            r7.append(r8)
            r7.append(r2)
            java.lang.String r8 = ", newPath: "
            r7.append(r8)
            r7.append(r3)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "TuningParameterUpgradeService"
            com.oppo.camera.e.b(r8, r7)
            boolean r7 = android.text.TextUtils.isEmpty(r28)
            r9 = 0
            if (r7 != 0) goto L_0x06d0
            boolean r7 = android.text.TextUtils.isEmpty(r29)
            if (r7 == 0) goto L_0x0039
            goto L_0x06d0
        L_0x0039:
            java.io.File r10 = new java.io.File     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            r10.<init>(r3)     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            java.io.File r11 = new java.io.File     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            r11.<init>(r2)     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            boolean r12 = r10.exists()     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            if (r12 != 0) goto L_0x006e
            boolean r12 = r10.mkdirs()     // Catch:{ Exception -> 0x0069, all -> 0x0064 }
            if (r12 != 0) goto L_0x006e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0069, all -> 0x0064 }
            r2.<init>()     // Catch:{ Exception -> 0x0069, all -> 0x0064 }
            java.lang.String r4 = "copyTunningFiles, cannot create dir in new newPath: "
            r2.append(r4)     // Catch:{ Exception -> 0x0069, all -> 0x0064 }
            r2.append(r3)     // Catch:{ Exception -> 0x0069, all -> 0x0064 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0069, all -> 0x0064 }
            com.oppo.camera.e.e(r8, r2)     // Catch:{ Exception -> 0x0069, all -> 0x0064 }
            return r9
        L_0x0064:
            r0 = move-exception
            r2 = r0
            r4 = r6
            goto L_0x067a
        L_0x0069:
            r0 = move-exception
            r2 = r0
            r4 = r6
            goto L_0x0683
        L_0x006e:
            boolean r12 = r11.exists()     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            if (r12 == 0) goto L_0x0658
            java.lang.String r12 = r11.getName()     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            if (r12 != 0) goto L_0x0658
            java.lang.String r12 = r11.getName()     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            java.lang.String r13 = "camera_tuning_upgrade"
            boolean r12 = r12.contains(r13)     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            if (r12 != 0) goto L_0x008c
            goto L_0x0658
        L_0x008c:
            java.lang.String r12 = java.io.File.separator     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            boolean r12 = r3.endsWith(r12)     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            if (r12 == 0) goto L_0x0095
            goto L_0x00a6
        L_0x0095:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            r12.<init>()     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            r12.append(r3)     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            java.lang.String r3 = java.io.File.separator     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            r12.append(r3)     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            java.lang.String r3 = r12.toString()     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
        L_0x00a6:
            java.lang.String r12 = java.io.File.separator     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            boolean r12 = r2.endsWith(r12)     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            if (r12 == 0) goto L_0x00af
            goto L_0x00c0
        L_0x00af:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            r12.<init>()     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            r12.append(r2)     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            java.lang.String r2 = java.io.File.separator     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            r12.append(r2)     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            java.lang.String r2 = r12.toString()     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
        L_0x00c0:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            r12.<init>()     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            r12.append(r3)     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            r12.append(r5)     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            r13.<init>()     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            r13.append(r3)     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            r13.append(r4)     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            java.lang.String[] r11 = r11.list()     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            java.lang.String[] r14 = r10.list()     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            java.util.concurrent.atomic.AtomicBoolean r15 = new java.util.concurrent.atomic.AtomicBoolean     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            r7 = 1
            r15.<init>(r7)     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            java.util.concurrent.atomic.AtomicBoolean r7 = new java.util.concurrent.atomic.AtomicBoolean     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            r7.<init>(r9)     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            r29 = r15
            java.util.concurrent.atomic.AtomicBoolean r15 = new java.util.concurrent.atomic.AtomicBoolean     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            r15.<init>(r9)     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            java.util.concurrent.atomic.AtomicReference r9 = new java.util.concurrent.atomic.AtomicReference     // Catch:{ Exception -> 0x0680, all -> 0x0677 }
            r18 = r6
            r6 = 0
            r9.<init>(r6)     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            r16 = r2
            java.util.concurrent.atomic.AtomicReference r2 = new java.util.concurrent.atomic.AtomicReference     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            if (r14 == 0) goto L_0x0142
            int r6 = r14.length     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            if (r6 <= 0) goto L_0x0142
            int r6 = r14.length     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            r20 = r11
            r11 = 0
        L_0x0110:
            if (r11 >= r6) goto L_0x0144
            r21 = r6
            r6 = r14[r11]     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            boolean r22 = r5.equals(r6)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            if (r22 == 0) goto L_0x0123
            r22 = r5
            r5 = 1
            r7.set(r5)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            goto L_0x0125
        L_0x0123:
            r22 = r5
        L_0x0125:
            boolean r5 = r4.equals(r6)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            if (r5 == 0) goto L_0x012f
            r5 = 1
            r15.set(r5)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
        L_0x012f:
            int r11 = r11 + 1
            r6 = r21
            r5 = r22
            goto L_0x0110
        L_0x0136:
            r0 = move-exception
            r2 = r0
            r4 = r18
            goto L_0x067a
        L_0x013c:
            r0 = move-exception
            r2 = r0
            r4 = r18
            goto L_0x0683
        L_0x0142:
            r20 = r11
        L_0x0144:
            com.oppo.camera.tuningupgrade.-$$Lambda$TuningParameterUpgradeService$p7skbTOR-WL0TdDQMBcI2OSZN7w r4 = new com.oppo.camera.tuningupgrade.-$$Lambda$TuningParameterUpgradeService$p7skbTOR-WL0TdDQMBcI2OSZN7w     // Catch:{ Exception -> 0x064c, all -> 0x0648 }
            r4.<init>(r7, r9, r15, r2)     // Catch:{ Exception -> 0x064c, all -> 0x0648 }
            java.lang.String[] r4 = r10.list(r4)     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            r5.<init>()     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            java.lang.String r6 = "copyTunningFiles, copy info; hasInfoFile: "
            r5.append(r6)     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            boolean r6 = r7.get()     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            r5.append(r6)     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            java.lang.String r6 = ", tempFile: "
            r5.append(r6)     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            java.lang.Object r6 = r9.get()     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            r5.append(r6)     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            java.lang.String r6 = ", hasUpdateFlagFile: "
            r5.append(r6)     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            boolean r6 = r15.get()     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            r5.append(r6)     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            java.lang.String r6 = ", updateFlagTempFile: "
            r5.append(r6)     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            java.lang.Object r6 = r2.get()     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            r5.append(r6)     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            com.oppo.camera.e.b(r8, r5)     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            java.lang.Object r5 = r2.get()     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            java.lang.String r6 = "0"
            java.lang.String r10 = "reserve"
            if (r5 == 0) goto L_0x01de
            java.lang.Object r5 = r2.get()     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            boolean r5 = r5.contains(r10)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            if (r5 == 0) goto L_0x01de
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            r11.<init>()     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            r11.append(r3)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            r11.append(r2)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            java.lang.String r2 = r11.toString()     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            r2.<init>(r13)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            boolean r2 = r5.renameTo(r2)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            r1.b(r13, r6)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            r5.<init>()     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            java.lang.String r6 = "copyTunningFiles, rename updateFlag res: "
            r5.append(r6)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            r5.append(r2)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            com.oppo.camera.e.b(r8, r2)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            goto L_0x01e7
        L_0x01de:
            boolean r2 = r15.get()     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            if (r2 == 0) goto L_0x01e7
            r1.b(r13, r6)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
        L_0x01e7:
            java.lang.Object r2 = r9.get()     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            java.lang.String r5 = "updateApplicableTime"
            if (r2 == 0) goto L_0x0233
            java.lang.Object r2 = r9.get()     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            boolean r2 = r2.contains(r10)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            if (r2 == 0) goto L_0x0233
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            r6.<init>()     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            r6.append(r3)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            java.lang.Object r7 = r9.get()     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            r6.append(r7)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            r6.<init>(r12)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            boolean r2 = r2.renameTo(r6)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            r6.<init>()     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            java.lang.String r7 = "copyTunningFiles, rename updateInfo res: "
            r6.append(r7)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            r6.append(r2)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            com.oppo.camera.e.b(r8, r2)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            goto L_0x0262
        L_0x0233:
            boolean r2 = r7.get()     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            if (r2 == 0) goto L_0x0262
            java.lang.String r2 = r1.a((java.lang.String) r12)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            if (r20 == 0) goto L_0x025c
            r6 = r20
            int r7 = r6.length     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            if (r7 <= 0) goto L_0x025e
            int r7 = r6.length     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            r9 = r2
            r2 = 0
        L_0x0247:
            if (r2 >= r7) goto L_0x025a
            r11 = r6[r2]     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            boolean r13 = r5.equals(r11)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            if (r13 != 0) goto L_0x0257
            java.lang.String r13 = ""
            java.lang.String r9 = r9.replace(r11, r13)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
        L_0x0257:
            int r2 = r2 + 1
            goto L_0x0247
        L_0x025a:
            r2 = r9
            goto L_0x025e
        L_0x025c:
            r6 = r20
        L_0x025e:
            r1.b(r12, r2)     // Catch:{ Exception -> 0x013c, all -> 0x0136 }
            goto L_0x0264
        L_0x0262:
            r6 = r20
        L_0x0264:
            if (r6 == 0) goto L_0x0646
            int r2 = r6.length     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            if (r2 <= 0) goto L_0x0646
            if (r4 == 0) goto L_0x0646
            int r2 = r4.length     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            if (r2 <= 0) goto L_0x0646
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            r2.<init>()     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            java.lang.String r7 = "copyTunningFiles, before; oldFiles: "
            r2.append(r7)     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            java.lang.String r7 = java.util.Arrays.toString(r6)     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            r2.append(r7)     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            java.lang.String r7 = ", newFiles: "
            r2.append(r7)     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            java.lang.String r7 = java.util.Arrays.toString(r4)     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            r2.append(r7)     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            com.oppo.camera.e.b(r8, r2)     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            r2 = 1
            r7.<init>(r12, r2)     // Catch:{ Exception -> 0x0654, all -> 0x0650 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x063b, all -> 0x062f }
            r2.<init>()     // Catch:{ Exception -> 0x063b, all -> 0x062f }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x063b, all -> 0x062f }
            java.util.List r11 = java.util.Arrays.asList(r4)     // Catch:{ Exception -> 0x063b, all -> 0x062f }
            r9.<init>(r11)     // Catch:{ Exception -> 0x063b, all -> 0x062f }
            r11 = 0
            r12 = 0
            r13 = 0
            r19 = 0
        L_0x02ab:
            int r14 = r6.length     // Catch:{ Exception -> 0x0622, all -> 0x0619 }
            if (r11 >= r14) goto L_0x0559
            r14 = r6[r11]     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            java.io.File r15 = new java.io.File     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            r20 = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            r6.<init>()     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            r21 = r12
            r12 = r16
            r6.append(r12)     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            r6.append(r14)     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            r15.<init>(r6)     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            boolean r6 = r15.isDirectory()     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            if (r6 == 0) goto L_0x02f3
            java.lang.String r6 = r15.getAbsolutePath()     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
            r1.a(r6, r3)     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
            r22 = r3
            r23 = r4
            r26 = r7
            r24 = r9
            r25 = r10
            r16 = r12
        L_0x02e3:
            r9 = r29
            goto L_0x0527
        L_0x02e7:
            r0 = move-exception
            r2 = r0
            r26 = r7
            goto L_0x054d
        L_0x02ed:
            r0 = move-exception
            r2 = r0
            r26 = r7
            goto L_0x0555
        L_0x02f3:
            boolean r6 = r15.exists()     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            if (r6 != 0) goto L_0x031e
            java.lang.String r2 = "copyTunningFiles, oldFile does not exist."
            com.oppo.camera.e.e(r8, r2)     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
            if (r19 == 0) goto L_0x0309
            r19.close()     // Catch:{ Exception -> 0x0304 }
            goto L_0x0309
        L_0x0304:
            r0 = move-exception
            r2 = r0
            r6 = r18
            goto L_0x0319
        L_0x0309:
            if (r13 == 0) goto L_0x0311
            r13.flush()     // Catch:{ Exception -> 0x0304 }
            r13.close()     // Catch:{ Exception -> 0x0304 }
        L_0x0311:
            r7.flush()     // Catch:{ Exception -> 0x0304 }
            r7.close()     // Catch:{ Exception -> 0x0304 }
        L_0x0317:
            r2 = 0
            goto L_0x031d
        L_0x0319:
            com.oppo.camera.e.d(r8, r6, r2)
            goto L_0x0317
        L_0x031d:
            return r2
        L_0x031e:
            r6 = r18
            boolean r16 = r15.isFile()     // Catch:{ Exception -> 0x0542, all -> 0x053b }
            if (r16 != 0) goto L_0x0357
            java.lang.String r2 = "copyTunningFiles, oldFile is not a file."
            com.oppo.camera.e.e(r8, r2)     // Catch:{ Exception -> 0x0350, all -> 0x0349 }
            if (r19 == 0) goto L_0x0334
            r19.close()     // Catch:{ Exception -> 0x0331 }
            goto L_0x0334
        L_0x0331:
            r0 = move-exception
            r2 = r0
            goto L_0x0344
        L_0x0334:
            if (r13 == 0) goto L_0x033c
            r13.flush()     // Catch:{ Exception -> 0x0331 }
            r13.close()     // Catch:{ Exception -> 0x0331 }
        L_0x033c:
            r7.flush()     // Catch:{ Exception -> 0x0331 }
            r7.close()     // Catch:{ Exception -> 0x0331 }
        L_0x0342:
            r2 = 0
            goto L_0x0348
        L_0x0344:
            com.oppo.camera.e.d(r8, r6, r2)
            goto L_0x0342
        L_0x0348:
            return r2
        L_0x0349:
            r0 = move-exception
            r2 = r0
            r4 = r6
            r26 = r7
            goto L_0x06b2
        L_0x0350:
            r0 = move-exception
            r2 = r0
            r4 = r6
            r26 = r7
            goto L_0x0629
        L_0x0357:
            boolean r16 = r15.canRead()     // Catch:{ Exception -> 0x0542, all -> 0x053b }
            if (r16 != 0) goto L_0x0380
            java.lang.String r2 = "copyTunningFiles, oldFile cannot read."
            com.oppo.camera.e.e(r8, r2)     // Catch:{ Exception -> 0x0350, all -> 0x0349 }
            if (r19 == 0) goto L_0x036b
            r19.close()     // Catch:{ Exception -> 0x0368 }
            goto L_0x036b
        L_0x0368:
            r0 = move-exception
            r2 = r0
            goto L_0x037b
        L_0x036b:
            if (r13 == 0) goto L_0x0373
            r13.flush()     // Catch:{ Exception -> 0x0368 }
            r13.close()     // Catch:{ Exception -> 0x0368 }
        L_0x0373:
            r7.flush()     // Catch:{ Exception -> 0x0368 }
            r7.close()     // Catch:{ Exception -> 0x0368 }
        L_0x0379:
            r2 = 0
            goto L_0x037f
        L_0x037b:
            com.oppo.camera.e.d(r8, r6, r2)
            goto L_0x0379
        L_0x037f:
            return r2
        L_0x0380:
            r16 = r12
            int r12 = r4.length     // Catch:{ Exception -> 0x0542, all -> 0x053b }
            if (r11 >= r12) goto L_0x0519
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0542, all -> 0x053b }
            r12.<init>()     // Catch:{ Exception -> 0x0542, all -> 0x053b }
            r12.append(r3)     // Catch:{ Exception -> 0x0542, all -> 0x053b }
            r18 = r6
            r6 = r4[r11]     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            r12.append(r6)     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            java.lang.String r6 = r12.toString()     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            java.util.Iterator r12 = r9.iterator()     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
        L_0x039c:
            boolean r22 = r12.hasNext()     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            if (r22 == 0) goto L_0x03c6
            java.lang.Object r22 = r12.next()     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
            r23 = r4
            r4 = r22
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
            boolean r22 = r4.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
            if (r22 == 0) goto L_0x03c3
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
            r6.<init>()     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
            r6.append(r3)     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
            r6.append(r4)     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
            r4 = 1
            goto L_0x03c9
        L_0x03c3:
            r4 = r23
            goto L_0x039c
        L_0x03c6:
            r23 = r4
            r4 = 0
        L_0x03c9:
            if (r4 != 0) goto L_0x03f3
            java.util.Iterator r4 = r9.iterator()     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
        L_0x03cf:
            boolean r12 = r4.hasNext()     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
            if (r12 == 0) goto L_0x03f3
            java.lang.Object r12 = r4.next()     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
            boolean r22 = r12.contains(r10)     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
            if (r22 == 0) goto L_0x03cf
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
            r6.<init>()     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
            r6.append(r3)     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
            r6.append(r12)     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
            r4.remove()     // Catch:{ Exception -> 0x02ed, all -> 0x02e7 }
        L_0x03f3:
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            r12.<init>()     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            r12.append(r3)     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            r12.append(r14)     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            r4.<init>(r12)     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            java.io.File r12 = new java.io.File     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            r12.<init>(r6)     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            boolean r12 = r12.renameTo(r4)     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            r22 = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            r3.<init>()     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            r24 = r9
            java.lang.String r9 = "copyTunningFiles, rename result: "
            r3.append(r9)     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            r3.append(r12)     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            java.lang.String r9 = ", originNewFile: "
            r3.append(r9)     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            r3.append(r6)     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            java.lang.String r6 = ", renameFile: "
            r3.append(r6)     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            java.lang.String r6 = r4.getAbsolutePath()     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            r3.append(r6)     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            com.oppo.camera.e.b(r8, r3)     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            r3.<init>(r15)     // Catch:{ Exception -> 0x0551, all -> 0x0549 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x050e, all -> 0x0507 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x050e, all -> 0x0507 }
            r9 = 1024(0x400, float:1.435E-42)
            byte[] r9 = new byte[r9]     // Catch:{ Exception -> 0x04ff, all -> 0x04f6 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04ff, all -> 0x04f6 }
            r12.<init>()     // Catch:{ Exception -> 0x04ff, all -> 0x04f6 }
            r25 = r10
            r13 = 0
        L_0x0452:
            r10 = -1
            if (r10 == r13) goto L_0x0473
            r10 = 0
            r6.write(r9, r10, r13)     // Catch:{ Exception -> 0x04ff, all -> 0x04f6 }
            boolean r17 = r5.equals(r14)     // Catch:{ Exception -> 0x04ff, all -> 0x04f6 }
            if (r17 == 0) goto L_0x046a
            r26 = r7
            java.lang.String r7 = new java.lang.String     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            r7.<init>(r9, r10, r13)     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            r12.append(r7)     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            goto L_0x046c
        L_0x046a:
            r26 = r7
        L_0x046c:
            int r13 = r3.read(r9)     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            r7 = r26
            goto L_0x0452
        L_0x0473:
            r26 = r7
            boolean r7 = r5.equals(r14)     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            if (r7 != 0) goto L_0x04c9
            r2.add(r14)     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            boolean r7 = r29.get()     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            if (r7 == 0) goto L_0x04c6
            java.lang.String r7 = r1.a((java.io.File) r15)     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            java.lang.String r9 = r1.a((java.io.File) r4)     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            boolean r7 = r7.equals(r9)     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            r9 = r29
            r9.set(r7)     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            r7.<init>()     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            java.lang.String r10 = "copyTunningFiles check list:"
            r7.append(r10)     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            r7.append(r11)     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            java.lang.String r10 = ", src:"
            r7.append(r10)     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            r7.append(r15)     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            java.lang.String r10 = " ,dst:"
            r7.append(r10)     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            r7.append(r4)     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            java.lang.String r4 = ", md5 check: "
            r7.append(r4)     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            boolean r4 = r9.get()     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            r7.append(r4)     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            java.lang.String r4 = r7.toString()     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            com.oppo.camera.e.b(r8, r4)     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            goto L_0x04e5
        L_0x04c6:
            r9 = r29
            goto L_0x04e5
        L_0x04c9:
            r9 = r29
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            r4.<init>()     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            java.lang.String r7 = "copyTunningFiles, version final string: "
            r4.append(r7)     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            r4.append(r12)     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            com.oppo.camera.e.b(r8, r4)     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            r21 = r12
        L_0x04e5:
            r3.close()     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            r6.flush()     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            r6.close()     // Catch:{ Exception -> 0x04f4, all -> 0x04f2 }
            r19 = r3
            r13 = r6
            goto L_0x0527
        L_0x04f2:
            r0 = move-exception
            goto L_0x04f9
        L_0x04f4:
            r0 = move-exception
            goto L_0x0502
        L_0x04f6:
            r0 = move-exception
            r26 = r7
        L_0x04f9:
            r2 = r0
            r19 = r3
            r13 = r6
            goto L_0x054d
        L_0x04ff:
            r0 = move-exception
            r26 = r7
        L_0x0502:
            r2 = r0
            r7 = r3
            r19 = r6
            goto L_0x0515
        L_0x0507:
            r0 = move-exception
            r26 = r7
            r2 = r0
            r19 = r3
            goto L_0x054d
        L_0x050e:
            r0 = move-exception
            r26 = r7
            r2 = r0
            r7 = r3
            r19 = r13
        L_0x0515:
            r4 = r18
            goto L_0x0688
        L_0x0519:
            r22 = r3
            r23 = r4
            r18 = r6
            r26 = r7
            r24 = r9
            r25 = r10
            goto L_0x02e3
        L_0x0527:
            r12 = r21
            int r11 = r11 + 1
            r29 = r9
            r6 = r20
            r3 = r22
            r4 = r23
            r9 = r24
            r10 = r25
            r7 = r26
            goto L_0x02ab
        L_0x053b:
            r0 = move-exception
            r26 = r7
            r2 = r0
            r4 = r6
            goto L_0x06b2
        L_0x0542:
            r0 = move-exception
            r26 = r7
            r2 = r0
            r4 = r6
            goto L_0x0629
        L_0x0549:
            r0 = move-exception
            r26 = r7
        L_0x054c:
            r2 = r0
        L_0x054d:
            r4 = r18
            goto L_0x06b2
        L_0x0551:
            r0 = move-exception
            r26 = r7
        L_0x0554:
            r2 = r0
        L_0x0555:
            r4 = r18
            goto L_0x0629
        L_0x0559:
            r9 = r29
            r26 = r7
            r21 = r12
            boolean r3 = r9.get()     // Catch:{ Exception -> 0x0612, all -> 0x060a }
            if (r3 == 0) goto L_0x05e8
            if (r21 == 0) goto L_0x05e8
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05e3, all -> 0x05de }
            r3.<init>()     // Catch:{ Exception -> 0x05e3, all -> 0x05de }
            java.lang.String r4 = "version:"
            r3.append(r4)     // Catch:{ Exception -> 0x05e3, all -> 0x05de }
            r12 = r21
            r3.append(r12)     // Catch:{ Exception -> 0x05e3, all -> 0x05de }
            java.lang.String r4 = ";bin:"
            r3.append(r4)     // Catch:{ Exception -> 0x05e3, all -> 0x05de }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x05e3, all -> 0x05de }
        L_0x057f:
            boolean r4 = r2.hasNext()     // Catch:{ Exception -> 0x05e3, all -> 0x05de }
            if (r4 == 0) goto L_0x0598
            java.lang.Object r4 = r2.next()     // Catch:{ Exception -> 0x0596, all -> 0x0594 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0596, all -> 0x0594 }
            r3.append(r4)     // Catch:{ Exception -> 0x0596, all -> 0x0594 }
            java.lang.String r4 = ","
            r3.append(r4)     // Catch:{ Exception -> 0x0596, all -> 0x0594 }
            goto L_0x057f
        L_0x0594:
            r0 = move-exception
            goto L_0x054c
        L_0x0596:
            r0 = move-exception
            goto L_0x0554
        L_0x0598:
            int r2 = r3.length()     // Catch:{ Exception -> 0x05e3, all -> 0x05de }
            r4 = 1
            int r2 = r2 - r4
            int r4 = r3.length()     // Catch:{ Exception -> 0x05e3, all -> 0x05de }
            java.lang.String r5 = ";state:0\n"
            r3.replace(r2, r4, r5)     // Catch:{ Exception -> 0x05e3, all -> 0x05de }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05e3, all -> 0x05de }
            r2.<init>()     // Catch:{ Exception -> 0x05e3, all -> 0x05de }
            java.lang.String r4 = "copyTunningFiles, final content: "
            r2.append(r4)     // Catch:{ Exception -> 0x05e3, all -> 0x05de }
            java.lang.String r4 = r3.toString()     // Catch:{ Exception -> 0x05e3, all -> 0x05de }
            r2.append(r4)     // Catch:{ Exception -> 0x05e3, all -> 0x05de }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x05e3, all -> 0x05de }
            com.oppo.camera.e.b(r8, r2)     // Catch:{ Exception -> 0x05e3, all -> 0x05de }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x05e3, all -> 0x05de }
            byte[] r2 = r2.getBytes()     // Catch:{ Exception -> 0x05e3, all -> 0x05de }
            r3 = r26
            r3.write(r2)     // Catch:{ Exception -> 0x05d8, all -> 0x05d2 }
            java.lang.String r2 = "copyTunningFiles, done"
            com.oppo.camera.e.b(r8, r2)     // Catch:{ Exception -> 0x05d8, all -> 0x05d2 }
            goto L_0x05ea
        L_0x05d2:
            r0 = move-exception
            r2 = r0
            r26 = r3
            goto L_0x054d
        L_0x05d8:
            r0 = move-exception
            r2 = r0
            r26 = r3
            goto L_0x0555
        L_0x05de:
            r0 = move-exception
            r3 = r26
            goto L_0x054c
        L_0x05e3:
            r0 = move-exception
            r3 = r26
            goto L_0x0554
        L_0x05e8:
            r3 = r26
        L_0x05ea:
            if (r19 == 0) goto L_0x05f5
            r19.close()     // Catch:{ Exception -> 0x05f0 }
            goto L_0x05f5
        L_0x05f0:
            r0 = move-exception
            r2 = r0
            r4 = r18
            goto L_0x0605
        L_0x05f5:
            if (r13 == 0) goto L_0x05fd
            r13.flush()     // Catch:{ Exception -> 0x05f0 }
            r13.close()     // Catch:{ Exception -> 0x05f0 }
        L_0x05fd:
            r3.flush()     // Catch:{ Exception -> 0x05f0 }
            r3.close()     // Catch:{ Exception -> 0x05f0 }
        L_0x0603:
            r2 = 1
            goto L_0x0609
        L_0x0605:
            com.oppo.camera.e.d(r8, r4, r2)
            goto L_0x0603
        L_0x0609:
            return r2
        L_0x060a:
            r0 = move-exception
            r4 = r18
            r3 = r26
            r2 = r0
            goto L_0x06b2
        L_0x0612:
            r0 = move-exception
            r4 = r18
            r3 = r26
            r2 = r0
            goto L_0x0629
        L_0x0619:
            r0 = move-exception
            r3 = r7
            r4 = r18
            r2 = r0
            r26 = r3
            goto L_0x06b2
        L_0x0622:
            r0 = move-exception
            r3 = r7
            r4 = r18
            r2 = r0
            r26 = r3
        L_0x0629:
            r7 = r19
            r19 = r13
            goto L_0x0688
        L_0x062f:
            r0 = move-exception
            r3 = r7
            r4 = r18
            r2 = r0
            r26 = r3
            r13 = 0
            r19 = 0
            goto L_0x06b2
        L_0x063b:
            r0 = move-exception
            r3 = r7
            r4 = r18
            r2 = r0
            r26 = r3
            r7 = 0
            r19 = 0
            goto L_0x0688
        L_0x0646:
            r2 = 0
            return r2
        L_0x0648:
            r0 = move-exception
            r4 = r18
            goto L_0x0679
        L_0x064c:
            r0 = move-exception
            r4 = r18
            goto L_0x0682
        L_0x0650:
            r0 = move-exception
            r4 = r18
            goto L_0x0679
        L_0x0654:
            r0 = move-exception
            r4 = r18
            goto L_0x0682
        L_0x0658:
            r4 = r6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0675, all -> 0x0673 }
            r2.<init>()     // Catch:{ Exception -> 0x0675, all -> 0x0673 }
            java.lang.String r3 = "copyTunningFiles, cannot get sau dir, getName: "
            r2.append(r3)     // Catch:{ Exception -> 0x0675, all -> 0x0673 }
            java.lang.String r3 = r11.getName()     // Catch:{ Exception -> 0x0675, all -> 0x0673 }
            r2.append(r3)     // Catch:{ Exception -> 0x0675, all -> 0x0673 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0675, all -> 0x0673 }
            com.oppo.camera.e.e(r8, r2)     // Catch:{ Exception -> 0x0675, all -> 0x0673 }
            r2 = 0
            return r2
        L_0x0673:
            r0 = move-exception
            goto L_0x0679
        L_0x0675:
            r0 = move-exception
            goto L_0x0682
        L_0x0677:
            r0 = move-exception
            r4 = r6
        L_0x0679:
            r2 = r0
        L_0x067a:
            r13 = 0
            r19 = 0
            r26 = 0
            goto L_0x06b2
        L_0x0680:
            r0 = move-exception
            r4 = r6
        L_0x0682:
            r2 = r0
        L_0x0683:
            r7 = 0
            r19 = 0
            r26 = 0
        L_0x0688:
            java.lang.String r3 = "copyFiles, exception occurred"
            com.oppo.camera.e.d(r8, r3, r2)     // Catch:{ all -> 0x06ac }
            if (r7 == 0) goto L_0x0696
            r7.close()     // Catch:{ Exception -> 0x0693 }
            goto L_0x0696
        L_0x0693:
            r0 = move-exception
            r2 = r0
            goto L_0x06a7
        L_0x0696:
            if (r19 == 0) goto L_0x069e
            r19.flush()     // Catch:{ Exception -> 0x0693 }
            r19.close()     // Catch:{ Exception -> 0x0693 }
        L_0x069e:
            if (r26 == 0) goto L_0x06aa
            r26.flush()     // Catch:{ Exception -> 0x0693 }
            r26.close()     // Catch:{ Exception -> 0x0693 }
            goto L_0x06aa
        L_0x06a7:
            com.oppo.camera.e.d(r8, r4, r2)
        L_0x06aa:
            r2 = 0
            return r2
        L_0x06ac:
            r0 = move-exception
            r2 = r0
            r13 = r19
            r19 = r7
        L_0x06b2:
            if (r19 == 0) goto L_0x06bb
            r19.close()     // Catch:{ Exception -> 0x06b8 }
            goto L_0x06bb
        L_0x06b8:
            r0 = move-exception
            r3 = r0
            goto L_0x06cc
        L_0x06bb:
            if (r13 == 0) goto L_0x06c3
            r13.flush()     // Catch:{ Exception -> 0x06b8 }
            r13.close()     // Catch:{ Exception -> 0x06b8 }
        L_0x06c3:
            if (r26 == 0) goto L_0x06cf
            r26.flush()     // Catch:{ Exception -> 0x06b8 }
            r26.close()     // Catch:{ Exception -> 0x06b8 }
            goto L_0x06cf
        L_0x06cc:
            com.oppo.camera.e.d(r8, r4, r3)
        L_0x06cf:
            throw r2
        L_0x06d0:
            r2 = r9
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.tuningupgrade.TuningParameterUpgradeService.a(java.lang.String, java.lang.String):boolean");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean a(AtomicBoolean atomicBoolean, AtomicReference atomicReference, AtomicBoolean atomicBoolean2, AtomicReference atomicReference2, File file, String str) {
        if (str.contains("updateInfo") || str.contains("updateFlag")) {
            return false;
        }
        if (!atomicBoolean.get() && atomicReference.get() == null && str.contains("reserve")) {
            atomicReference.set(str);
            return false;
        } else if (atomicBoolean2.get() || atomicReference2.get() != null || !str.contains("reserve")) {
            return true;
        } else {
            atomicReference2.set(str);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x005f A[SYNTHETIC, Splitter:B:41:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x007c A[SYNTHETIC, Splitter:B:57:0x007c] */
    /* JADX WARNING: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "clearAndWritFile: "
            java.lang.String r1 = "TuningParameterUpgradeService"
            java.lang.String r2 = "clearAndWritFile"
            com.oppo.camera.e.b(r1, r2)
            java.io.File r2 = new java.io.File
            r2.<init>(r6)
            r6 = 0
            boolean r3 = r2.exists()     // Catch:{ IOException -> 0x0059 }
            if (r3 == 0) goto L_0x0051
            boolean r3 = r2.isDirectory()     // Catch:{ IOException -> 0x0059 }
            if (r3 == 0) goto L_0x001c
            goto L_0x0051
        L_0x001c:
            java.io.FileWriter r3 = new java.io.FileWriter     // Catch:{ IOException -> 0x0059 }
            r4 = 0
            r3.<init>(r2, r4)     // Catch:{ IOException -> 0x0059 }
            java.lang.String r6 = ""
            r3.write(r6)     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            r3.write(r7)     // Catch:{ IOException -> 0x004d, all -> 0x0049 }
            r3.flush()     // Catch:{ IOException -> 0x0038 }
            r3.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0079
        L_0x0031:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x0079
        L_0x0036:
            r6 = move-exception
            goto L_0x0040
        L_0x0038:
            r6 = move-exception
            com.oppo.camera.e.d(r1, r0, r6)     // Catch:{ all -> 0x0036 }
            r3.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0079
        L_0x0040:
            r3.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0048:
            throw r6
        L_0x0049:
            r6 = move-exception
            r7 = r6
            r6 = r3
            goto L_0x007a
        L_0x004d:
            r6 = move-exception
            r7 = r6
            r6 = r3
            goto L_0x005a
        L_0x0051:
            java.lang.String r7 = "clearAndWritFile, file not exit"
            com.oppo.camera.e.b(r1, r7)     // Catch:{ IOException -> 0x0059 }
            return
        L_0x0057:
            r7 = move-exception
            goto L_0x007a
        L_0x0059:
            r7 = move-exception
        L_0x005a:
            com.oppo.camera.e.d(r1, r0, r7)     // Catch:{ all -> 0x0057 }
            if (r6 == 0) goto L_0x0079
            r6.flush()     // Catch:{ IOException -> 0x0068 }
            r6.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0079
        L_0x0066:
            r7 = move-exception
            goto L_0x0070
        L_0x0068:
            r7 = move-exception
            com.oppo.camera.e.d(r1, r0, r7)     // Catch:{ all -> 0x0066 }
            r6.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0079
        L_0x0070:
            r6.close()     // Catch:{ IOException -> 0x0074 }
            goto L_0x0078
        L_0x0074:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0078:
            throw r7
        L_0x0079:
            return
        L_0x007a:
            if (r6 == 0) goto L_0x009b
            r6.flush()     // Catch:{ IOException -> 0x008a }
            r6.close()     // Catch:{ IOException -> 0x0083 }
            goto L_0x009b
        L_0x0083:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x009b
        L_0x0088:
            r7 = move-exception
            goto L_0x0092
        L_0x008a:
            r2 = move-exception
            com.oppo.camera.e.d(r1, r0, r2)     // Catch:{ all -> 0x0088 }
            r6.close()     // Catch:{ IOException -> 0x0083 }
            goto L_0x009b
        L_0x0092:
            r6.close()     // Catch:{ IOException -> 0x0096 }
            goto L_0x009a
        L_0x0096:
            r6 = move-exception
            r6.printStackTrace()
        L_0x009a:
            throw r7
        L_0x009b:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.tuningupgrade.TuningParameterUpgradeService.b(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046 A[SYNTHETIC, Splitter:B:24:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004d A[SYNTHETIC, Splitter:B:29:0x004d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.lang.String r5) {
        /*
            r4 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            boolean r5 = r0.exists()
            java.lang.String r1 = ""
            if (r5 == 0) goto L_0x0056
            boolean r5 = r0.isDirectory()
            if (r5 == 0) goto L_0x0014
            goto L_0x0056
        L_0x0014:
            r5 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x003e, all -> 0x003a }
            r2.<init>(r0)     // Catch:{ Exception -> 0x003e, all -> 0x003a }
            int r5 = r2.available()     // Catch:{ Exception -> 0x0038 }
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0038 }
            int r0 = r2.read(r5)     // Catch:{ Exception -> 0x0038 }
            r3 = -1
            if (r0 == r3) goto L_0x002f
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x0038 }
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x0038 }
            r0.<init>(r5, r3)     // Catch:{ Exception -> 0x0038 }
            r1 = r0
        L_0x002f:
            r2.close()     // Catch:{ IOException -> 0x0033 }
            goto L_0x0049
        L_0x0033:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x0049
        L_0x0038:
            r5 = move-exception
            goto L_0x0041
        L_0x003a:
            r0 = move-exception
            r2 = r5
            r5 = r0
            goto L_0x004b
        L_0x003e:
            r0 = move-exception
            r2 = r5
            r5 = r0
        L_0x0041:
            r5.printStackTrace()     // Catch:{ all -> 0x004a }
            if (r2 == 0) goto L_0x0049
            r2.close()     // Catch:{ IOException -> 0x0033 }
        L_0x0049:
            return r1
        L_0x004a:
            r5 = move-exception
        L_0x004b:
            if (r2 == 0) goto L_0x0055
            r2.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0055:
            throw r5
        L_0x0056:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.tuningupgrade.TuningParameterUpgradeService.a(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004e A[SYNTHETIC, Splitter:B:26:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0054 A[SYNTHETIC, Splitter:B:30:0x0054] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.io.File r10) {
        /*
            r9 = this;
            java.lang.String r0 = "getFileMD5:"
            java.lang.String r1 = "TuningParameterUpgradeService"
            boolean r2 = r10.exists()
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x005d
            boolean r2 = r10.isDirectory()
            if (r2 == 0) goto L_0x0013
            goto L_0x005d
        L_0x0013:
            r2 = 0
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r4]
            java.lang.String r6 = "MD5"
            java.security.MessageDigest r6 = java.security.MessageDigest.getInstance(r6)     // Catch:{ Exception -> 0x0048 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0048 }
            r7.<init>(r10)     // Catch:{ Exception -> 0x0048 }
        L_0x0023:
            r10 = 0
            int r2 = r7.read(r5, r10, r4)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            r8 = -1
            if (r2 == r8) goto L_0x002f
            r6.update(r5, r10, r2)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            goto L_0x0023
        L_0x002f:
            byte[] r10 = r6.digest()     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            java.lang.String r3 = r9.a((byte[]) r10)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            r7.close()     // Catch:{ IOException -> 0x003b }
            goto L_0x0051
        L_0x003b:
            r10 = move-exception
            com.oppo.camera.e.d(r1, r0, r10)
            goto L_0x0051
        L_0x0040:
            r10 = move-exception
            r2 = r7
            goto L_0x0052
        L_0x0043:
            r10 = move-exception
            r2 = r7
            goto L_0x0049
        L_0x0046:
            r10 = move-exception
            goto L_0x0052
        L_0x0048:
            r10 = move-exception
        L_0x0049:
            com.oppo.camera.e.d(r1, r0, r10)     // Catch:{ all -> 0x0046 }
            if (r2 == 0) goto L_0x0051
            r2.close()     // Catch:{ IOException -> 0x003b }
        L_0x0051:
            return r3
        L_0x0052:
            if (r2 == 0) goto L_0x005c
            r2.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x005c
        L_0x0058:
            r2 = move-exception
            com.oppo.camera.e.d(r1, r0, r2)
        L_0x005c:
            throw r10
        L_0x005d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.tuningupgrade.TuningParameterUpgradeService.a(java.io.File):java.lang.String");
    }

    private String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (2 > hexString.length()) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
