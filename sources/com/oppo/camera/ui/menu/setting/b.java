package com.oppo.camera.ui.menu.setting;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import androidx.fragment.app.c;
import color.support.v7.app.b;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.i;
import com.oppo.camera.statistics.model.EnterExitDcsMsgData;
import com.oppo.camera.util.Util;
import java.util.Arrays;
import java.util.List;

/* compiled from: BaseLocationPreferenceFragment */
public abstract class b extends c {
    private color.support.v7.app.b g = null;
    private color.support.v7.app.b h = null;
    private color.support.v7.app.b i = null;
    private color.support.v7.app.b j = null;
    private BroadcastReceiver k = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            b.this.l();
        }
    };
    private DialogInterface.OnClickListener l = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == -2) {
                dialogInterface.dismiss();
                i.a((Activity) b.this.getActivity(), b.this.k(), (List<String>) Arrays.asList(new String[]{"android.permission.ACCESS_FINE_LOCATION"}), "cancel");
            } else if (i == -1) {
                b.this.startActivityForResult(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", b.this.getActivity().getPackageName(), (String) null)), 2);
                dialogInterface.dismiss();
                i.a((Activity) b.this.getActivity(), b.this.k(), (List<String>) Arrays.asList(new String[]{"android.permission.ACCESS_FINE_LOCATION"}), EnterExitDcsMsgData.RESULT_SETTING);
            }
        }
    };
    private DialogInterface.OnClickListener m = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == -2) {
                b.this.j();
            } else if (i == -1) {
                try {
                    b.this.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };
    private DialogInterface.OnClickListener n = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == -2) {
                b.this.j();
                dialogInterface.dismiss();
                i.a((Activity) b.this.getActivity(), EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK, "cancel");
            } else if (i == -1) {
                b bVar = b.this;
                bVar.b(bVar.getActivity(), "pref_allow_network_access", true);
                if (b.this.h()) {
                    b.this.i();
                }
                dialogInterface.dismiss();
                i.a((Activity) b.this.getActivity(), EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK, EnterExitDcsMsgData.RESULT_AGREE);
            }
        }
    };

    /* access modifiers changed from: protected */
    public void i() {
    }

    /* access modifiers changed from: protected */
    public void j() {
    }

    /* access modifiers changed from: protected */
    public int k() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void l() {
    }

    public void a(Bundle bundle, String str) {
        super.a(bundle, str);
        u();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            a(bundle);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        b(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        v();
    }

    public void onDestroyView() {
        super.onDestroyView();
        color.support.v7.app.b bVar = this.g;
        if (bVar != null && bVar.isShowing()) {
            this.g.dismiss();
        }
        this.g = null;
        color.support.v7.app.b bVar2 = this.i;
        if (bVar2 != null && bVar2.isShowing()) {
            this.i.dismiss();
        }
        this.i = null;
        color.support.v7.app.b bVar3 = this.j;
        if (bVar3 != null && bVar3.isShowing()) {
            this.j.dismiss();
        }
        this.j = null;
        color.support.v7.app.b bVar4 = this.h;
        if (bVar4 != null && bVar4.isShowing()) {
            this.h.dismiss();
        }
        this.h = null;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 1) {
            if (i2 == 2) {
                if (!t()) {
                    j();
                } else if (h()) {
                    i();
                }
            }
        } else if (!Util.p(getActivity())) {
            j();
        } else if (h()) {
            i();
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        e.a("BaseLocationPreferenceFragment", "onRequestPermissionsResult, requestCode: " + i2 + ", permissions: " + Arrays.toString(strArr) + ", grantResults: " + Arrays.toString(iArr));
        if (i2 == 3 || i2 == 4) {
            if (!a(strArr, iArr)) {
                j();
                a(this.l);
            } else if (h()) {
                i();
            }
            i.a((Activity) getActivity(), i2, strArr, iArr);
        } else if (i2 == 5) {
            b(getActivity(), "key_export_permission_requested", true);
            if (a(strArr, iArr)) {
                i();
            } else {
                j();
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        if (r()) {
            return false;
        }
        if (com.oppo.camera.w.b.g()) {
            if (t()) {
                return true;
            }
            if (!a(getActivity(), "key_export_permission_requested", false) || shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION")) {
                requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 5);
                e.a("BaseLocationPreferenceFragment", "checkBeforeOpenLocation, request code: 5");
            } else {
                s();
            }
            return false;
        } else if (!t()) {
            int k2 = k();
            requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, k2);
            e.a("BaseLocationPreferenceFragment", "checkBeforeOpenLocation, request code: " + k2);
            return false;
        } else if (a(getActivity(), "pref_allow_network_access", false)) {
            return true;
        } else {
            b(this.n);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(Bundle bundle) {
        if (bundle.getBoolean("key_location_service_dialog_show", false)) {
            r();
            return true;
        }
        if (com.oppo.camera.w.b.h()) {
            if (bundle.getBoolean("key_location_guide_dialog_show", false)) {
                s();
                return true;
            }
        } else if (bundle.getBoolean("key_permission_dialog_show", false)) {
            a(this.l);
            return true;
        } else if (bundle.getBoolean("key_network_dialog_show", false)) {
            b(this.n);
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void b(Bundle bundle) {
        color.support.v7.app.b bVar = this.g;
        bundle.putBoolean("key_location_service_dialog_show", bVar != null && bVar.isShowing());
        com.oppo.camera.w.b.a(bundle, this.i, this.h, this.j);
    }

    private boolean r() {
        if (getActivity() == null || Util.p(getActivity())) {
            return false;
        }
        color.support.v7.app.b bVar = this.g;
        if (bVar != null && bVar.isShowing()) {
            this.g.dismiss();
        }
        this.g = new b.a(getActivity(), R.style.DialogAlert).setTitle((int) R.string.camera_location_content).setPositiveButton((int) R.string.camera_location_setting, this.m).setNegativeButton((int) R.string.camera_location_cancle, this.m).create();
        if (getActivity().isFinishing()) {
            return true;
        }
        this.g.show();
        return true;
    }

    private void a(DialogInterface.OnClickListener onClickListener) {
        e.a("BaseLocationPreferenceFragment", "showPermissionDialog");
        c activity = getActivity();
        if (activity == null) {
            e.e("BaseLocationPreferenceFragment", "showPermissionDialog, return");
            return;
        }
        color.support.v7.app.b bVar = this.h;
        if (bVar != null && bVar.isShowing()) {
            this.h.dismiss();
        }
        String string = getString(R.string.camera_permission_dialog_title, getString(R.string.camera_permission_name_location));
        this.h = new b.a(activity).setOnKeyListener((DialogInterface.OnKeyListener) new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return true;
                }
                b.this.getActivity().finish();
                return true;
            }
        }).setTitle((CharSequence) string).setMessage((CharSequence) getString(R.string.camera_permission_description_location)).setPositiveButton((int) R.string.camera_permission_dialog_ok, onClickListener).setNegativeButton((int) R.string.camera_permission_dialog_cancel, onClickListener).setCancelable(false).create();
        if (!activity.isFinishing()) {
            this.h.show();
        }
    }

    private void s() {
        e.a("BaseLocationPreferenceFragment", "showLocationGuideDialog");
        c activity = getActivity();
        if (activity == null) {
            e.e("BaseLocationPreferenceFragment", "showLocationGuideDialog, return");
            return;
        }
        color.support.v7.app.b bVar = this.i;
        if (bVar != null && bVar.isShowing()) {
            this.i.dismiss();
        }
        String string = getString(R.string.color_runtime_access_fine_location);
        this.i = new b.a(activity).setOnKeyListener((DialogInterface.OnKeyListener) new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return true;
                }
                b.this.j();
                dialogInterface.dismiss();
                return true;
            }
        }).setTitle((CharSequence) getString(R.string.color_runtime_warning_dialog_title, getString(R.string.camera_app_name))).setMessage((CharSequence) getString(R.string.color_runtime_warning_dialog_disc, getString(R.string.camera_app_name), string)).setPositiveButton((int) R.string.color_runtime_warning_dialog_ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                b.this.startActivityForResult(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", b.this.getActivity().getPackageName(), (String) null)), 2);
                dialogInterface.dismiss();
            }
        }).setNegativeButton((int) R.string.camera_location_cancle, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                b.this.j();
                dialogInterface.dismiss();
            }
        }).setCancelable(false).create();
        if (!activity.isFinishing()) {
            this.i.show();
        }
    }

    private void b(DialogInterface.OnClickListener onClickListener) {
        e.a("BaseLocationPreferenceFragment", "showNetDialog");
        final c activity = getActivity();
        if (activity == null) {
            e.e("BaseLocationPreferenceFragment", "showNetDialog, return");
            return;
        }
        color.support.v7.app.b bVar = this.j;
        if (bVar != null && bVar.isShowing()) {
            this.j.dismiss();
        }
        this.j = new b.a(activity).setOnKeyListener((DialogInterface.OnKeyListener) new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (4 != i) {
                    return true;
                }
                activity.finish();
                return true;
            }
        }).setTitle((int) R.string.camera_network_dialog_description).setPositiveButton((int) R.string.camera_network_dialog_ok, onClickListener).setNegativeButton((int) R.string.camera_network_dialog_cancel, onClickListener).setCancelable(false).create();
        if (!activity.isFinishing()) {
            this.j.show();
        }
    }

    private boolean t() {
        if (getActivity() == null || getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
            return false;
        }
        return true;
    }

    private boolean a(String[] strArr, int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if ("android.permission.ACCESS_FINE_LOCATION".equalsIgnoreCase(strArr[i2]) && iArr[i2] == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean a(Context context, String str, boolean z) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void b(Context context, String str, boolean z) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z).apply();
    }

    private void u() {
        if (getActivity() != null) {
            getActivity().registerReceiver(this.k, new IntentFilter("android.location.MODE_CHANGED"));
        }
    }

    private void v() {
        if (getActivity() != null) {
            getActivity().unregisterReceiver(this.k);
        }
    }
}
