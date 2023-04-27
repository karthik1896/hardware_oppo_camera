package com.google.android.apps.lens.library.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto;
import java.util.ArrayList;
import java.util.List;

public class LensSdkParamsReader {
    public static final String AGSA_AUTHORITY = "com.google.android.googlequicksearchbox.GsaPublicContentProvider";
    private static final LensSdkParamsProto.LensSdkParams DEFAULT_PARAMS = new LensSdkParamsProto.LensSdkParams();
    public static final String LENS_AR_STICKERS_ACTIVITY = "com.google.vr.apps.ornament.app.MainActivity";
    public static final String LENS_AR_STICKERS_PACKAGE = "com.google.ar.lens";
    public static final String LENS_AVAILABILITY_PROVIDER_URI = String.format("content://%s/publicvalue/lens_oem_availability", new Object[]{AGSA_AUTHORITY});
    private static final String LENS_SDK_VERSION = "0.1.0";
    private static final int MIN_AR_CORE_VERSION = 24;
    private static final String TAG = "LensSdkParamsReader";
    /* access modifiers changed from: private */
    public final List<LensSdkParamsCallback> callbacks;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public LensSdkParamsProto.LensSdkParams lensSdkParams;
    /* access modifiers changed from: private */
    public boolean lensSdkParamsReady;
    private final PackageManager packageManager;

    public interface LensSdkParamsCallback {
        void onLensSdkParamsAvailable(LensSdkParamsProto.LensSdkParams lensSdkParams);
    }

    static {
        LensSdkParamsProto.LensSdkParams lensSdkParams2 = DEFAULT_PARAMS;
        lensSdkParams2.lensSdkVersion = LENS_SDK_VERSION;
        lensSdkParams2.agsaVersionName = "";
        lensSdkParams2.lensAvailabilityStatus = -1;
        lensSdkParams2.arStickersAvailabilityStatus = -1;
    }

    public LensSdkParamsReader(Context context2) {
        this(context2, context2.getPackageManager());
    }

    LensSdkParamsReader(Context context2, PackageManager packageManager2) {
        this.callbacks = new ArrayList();
        this.context = context2;
        this.packageManager = packageManager2;
        updateParams();
    }

    public String getLensSdkVersion() {
        return this.lensSdkParams.lensSdkVersion;
    }

    public String getAgsaVersionName() {
        return this.lensSdkParams.agsaVersionName;
    }

    public int getArStickersAvailability() {
        return this.lensSdkParams.arStickersAvailabilityStatus;
    }

    public void getParams(LensSdkParamsCallback lensSdkParamsCallback) {
        if (this.lensSdkParamsReady) {
            lensSdkParamsCallback.onLensSdkParamsAvailable(this.lensSdkParams);
        } else {
            this.callbacks.add(lensSdkParamsCallback);
        }
    }

    private void updateParams() {
        this.lensSdkParamsReady = false;
        this.lensSdkParams = DEFAULT_PARAMS.clone();
        try {
            PackageInfo packageInfo = this.packageManager.getPackageInfo("com.google.android.googlequicksearchbox", 0);
            if (packageInfo != null) {
                this.lensSdkParams.agsaVersionName = packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(TAG, "Unable to find agsa package: com.google.android.googlequicksearchbox");
        }
        this.lensSdkParams.arStickersAvailabilityStatus = 1;
        if (Build.VERSION.SDK_INT >= 24) {
            Intent intent = new Intent();
            intent.setClassName(LENS_AR_STICKERS_PACKAGE, LENS_AR_STICKERS_ACTIVITY);
            if (this.packageManager.resolveActivity(intent, 0) != null) {
                this.lensSdkParams.arStickersAvailabilityStatus = 0;
            }
        }
        new QueryGsaTask().execute(new Void[0]);
    }

    private class QueryGsaTask extends AsyncTask<Void, Void, Integer> {
        private QueryGsaTask() {
        }

        /* access modifiers changed from: protected */
        public Integer doInBackground(Void... voidArr) {
            Cursor cursor = null;
            try {
                cursor = LensSdkParamsReader.this.context.getContentResolver().query(Uri.parse(LensSdkParamsReader.LENS_AVAILABILITY_PROVIDER_URI), (String[]) null, (String) null, (String[]) null, (String) null);
                if (cursor != null) {
                    if (cursor.getCount() != 0) {
                        cursor.moveToFirst();
                        int parseInt = Integer.parseInt(cursor.getString(0));
                        if (parseInt > 6) {
                            parseInt = 6;
                        }
                        Integer valueOf = Integer.valueOf(parseInt);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return valueOf;
                    }
                }
                return 4;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Integer num) {
            String valueOf = String.valueOf(num);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
            sb.append("Lens availability result:");
            sb.append(valueOf);
            Log.i(LensSdkParamsReader.TAG, sb.toString());
            LensSdkParamsReader.this.lensSdkParams.lensAvailabilityStatus = num.intValue();
            boolean unused = LensSdkParamsReader.this.lensSdkParamsReady = true;
            for (LensSdkParamsCallback onLensSdkParamsAvailable : LensSdkParamsReader.this.callbacks) {
                onLensSdkParamsAvailable.onLensSdkParamsAvailable(LensSdkParamsReader.this.lensSdkParams);
            }
            LensSdkParamsReader.this.callbacks.clear();
        }
    }
}
