package com.oppo.camera;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import color.support.v7.app.b;
import com.oppo.camera.sticker.c.d;

public class DebugBroadcastReceiver extends BroadcastReceiver {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f2739a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f2740b = null;
    private DialogInterface.OnClickListener c = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialogInterface, int i) {
            if (!TextUtils.isEmpty(DebugBroadcastReceiver.this.f2739a)) {
                char c = 65535;
                if (i == -1) {
                    e.b("DebugBroadcastReceiver", "onClick, mCurrCode: " + DebugBroadcastReceiver.this.f2739a);
                    String a2 = DebugBroadcastReceiver.this.f2739a;
                    switch (a2.hashCode()) {
                        case -1863506190:
                            if (a2.equals("*#2785*368*324#")) {
                                c = 4;
                                break;
                            }
                            break;
                        case -1863384050:
                            if (a2.equals("*#2785*368*757#")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1073678413:
                            if (a2.equals("*#2785*82757#")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 159749497:
                            if (a2.equals("*#2785*757#")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 457016094:
                            if (a2.equals("*#2872*324*66#")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 656404788:
                            if (a2.equals("*#2785*6787#")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 658131736:
                            if (a2.equals("*#2785*8378#")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 930056739:
                            if (a2.equals("*#2785*324*51#")) {
                                c = 8;
                                break;
                            }
                            break;
                        case 930056770:
                            if (a2.equals("*#2785*324*52#")) {
                                c = 9;
                                break;
                            }
                            break;
                        case 1282594674:
                            if (a2.equals("*#2872*324*633#")) {
                                c = 7;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            d.a(DebugBroadcastReceiver.this.f2740b, 1);
                            return;
                        case 1:
                            d.a(DebugBroadcastReceiver.this.f2740b, 2);
                            return;
                        case 2:
                            d.a(DebugBroadcastReceiver.this.f2740b, 5);
                            return;
                        case 3:
                            d.a(DebugBroadcastReceiver.this.f2740b, 3);
                            return;
                        case 4:
                            d.a(DebugBroadcastReceiver.this.f2740b, true);
                            return;
                        case 5:
                            d.a(DebugBroadcastReceiver.this.f2740b, false);
                            return;
                        case 6:
                            d.b(DebugBroadcastReceiver.this.f2740b, true);
                            return;
                        case 7:
                            d.b(DebugBroadcastReceiver.this.f2740b, false);
                            return;
                        case 8:
                            d.c(DebugBroadcastReceiver.this.f2740b, true);
                            return;
                        case 9:
                            d.c(DebugBroadcastReceiver.this.f2740b, false);
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    };

    public void onReceive(Context context, Intent intent) {
        if (intent != null && "com.oppo.engineermode.EngineerModeMain".equals(intent.getAction())) {
            String str = null;
            try {
                str = intent.getStringExtra("order");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(str) && a(str)) {
                this.f2740b = context;
                a(context, str);
            }
        }
    }

    private boolean a(String str) {
        return "*#2785*6787#".equals(str) || "*#2785*8378#".equals(str) || "*#2785*82757#".equals(str) || "*#2785*757#".equals(str) || "*#2785*368*324#".equals(str) || "*#2785*368*757#".equals(str) || "*#2872*324*66#".equals(str) || "*#2872*324*633#".equals(str) || "*#2785*324*51#".equals(str) || "*#2785*324*52#".equals(str);
    }

    private void a(Context context, String str) {
        this.f2739a = str;
        b.a aVar = new b.a(context, 2131821193);
        aVar.setTitle((int) R.string.audit_mode_warning_title);
        aVar.setMessage((CharSequence) b(context, str));
        aVar.setCancelable(false);
        aVar.setPositiveButton(17039370, this.c);
        if (!b(str)) {
            aVar.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        }
        b a2 = aVar.create();
        a2.getWindow().setType(2038);
        a2.show();
    }

    private boolean b(String str) {
        return "*#2785*368*757#".equals(str) || "*#2785*757#".equals(str) || "*#2872*324*633#".equals(str) || "*#2785*324*52#".equals(str);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b(android.content.Context r5, java.lang.String r6) {
        /*
            r4 = this;
            int r0 = r6.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1863506190: goto L_0x0067;
                case -1863384050: goto L_0x005d;
                case -1073678413: goto L_0x0053;
                case 159749497: goto L_0x0049;
                case 457016094: goto L_0x003f;
                case 656404788: goto L_0x0035;
                case 658131736: goto L_0x002b;
                case 930056739: goto L_0x0020;
                case 930056770: goto L_0x0015;
                case 1282594674: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0071
        L_0x000b:
            java.lang.String r0 = "*#2872*324*633#"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0071
            r0 = 7
            goto L_0x0072
        L_0x0015:
            java.lang.String r0 = "*#2785*324*52#"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0071
            r0 = 9
            goto L_0x0072
        L_0x0020:
            java.lang.String r0 = "*#2785*324*51#"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0071
            r0 = 8
            goto L_0x0072
        L_0x002b:
            java.lang.String r0 = "*#2785*8378#"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0071
            r0 = r1
            goto L_0x0072
        L_0x0035:
            java.lang.String r0 = "*#2785*6787#"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0071
            r0 = r2
            goto L_0x0072
        L_0x003f:
            java.lang.String r0 = "*#2872*324*66#"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0071
            r0 = 6
            goto L_0x0072
        L_0x0049:
            java.lang.String r0 = "*#2785*757#"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0071
            r0 = 5
            goto L_0x0072
        L_0x0053:
            java.lang.String r0 = "*#2785*82757#"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0071
            r0 = 2
            goto L_0x0072
        L_0x005d:
            java.lang.String r0 = "*#2785*368*757#"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0071
            r0 = 4
            goto L_0x0072
        L_0x0067:
            java.lang.String r0 = "*#2785*368*324#"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0071
            r0 = 3
            goto L_0x0072
        L_0x0071:
            r0 = -1
        L_0x0072:
            switch(r0) {
                case 0: goto L_0x00d6;
                case 1: goto L_0x00ce;
                case 2: goto L_0x00c6;
                case 3: goto L_0x00be;
                case 4: goto L_0x00b6;
                case 5: goto L_0x00ae;
                case 6: goto L_0x00a6;
                case 7: goto L_0x009e;
                case 8: goto L_0x0096;
                case 9: goto L_0x008e;
                default: goto L_0x0075;
            }
        L_0x0075:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "getDialogContent, do not support this mode, mode: "
            r0.append(r3)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r0 = "DebugBroadcastReceiver"
            com.oppo.camera.e.b(r0, r6)
            java.lang.String r6 = ""
            goto L_0x00dd
        L_0x008e:
            r6 = 2131755959(0x7f1003b7, float:1.9142812E38)
            java.lang.String r5 = r5.getString(r6)
            return r5
        L_0x0096:
            r6 = 2131755960(0x7f1003b8, float:1.9142814E38)
            java.lang.String r5 = r5.getString(r6)
            return r5
        L_0x009e:
            r6 = 2131756134(0x7f100466, float:1.9143167E38)
            java.lang.String r5 = r5.getString(r6)
            return r5
        L_0x00a6:
            r6 = 2131756135(0x7f100467, float:1.9143169E38)
            java.lang.String r6 = r5.getString(r6)
            goto L_0x00dd
        L_0x00ae:
            r6 = 2131756079(0x7f10042f, float:1.9143055E38)
            java.lang.String r5 = r5.getString(r6)
            return r5
        L_0x00b6:
            r6 = 2131756128(0x7f100460, float:1.9143155E38)
            java.lang.String r5 = r5.getString(r6)
            return r5
        L_0x00be:
            r6 = 2131756127(0x7f10045f, float:1.9143153E38)
            java.lang.String r6 = r5.getString(r6)
            goto L_0x00dd
        L_0x00c6:
            r6 = 2131756133(0x7f100465, float:1.9143165E38)
            java.lang.String r6 = r5.getString(r6)
            goto L_0x00dd
        L_0x00ce:
            r6 = 2131756132(0x7f100464, float:1.9143163E38)
            java.lang.String r6 = r5.getString(r6)
            goto L_0x00dd
        L_0x00d6:
            r6 = 2131756042(0x7f10040a, float:1.914298E38)
            java.lang.String r6 = r5.getString(r6)
        L_0x00dd:
            r0 = 2131755038(0x7f10001e, float:1.9140944E38)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r2] = r6
            java.lang.String r5 = r5.getString(r0, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.DebugBroadcastReceiver.b(android.content.Context, java.lang.String):java.lang.String");
    }
}
