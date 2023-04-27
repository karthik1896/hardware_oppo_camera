package com.google.lens.sdk;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.google.android.apps.lens.library.base.LensSdkParamsReader;
import com.google.android.apps.lens.library.base.LensServiceBridge;
import com.google.android.apps.lens.library.base.proto.nano.LensSdkParamsProto;

public class LensApi {
    static final String LENS_BITMAP_URI_KEY = "LensBitmapUriKey";
    static final String LENS_DEEPLINKING_STRING = "googleapp://lens";
    static final Uri LENS_DEEPLINKING_URI = Uri.parse(LENS_DEEPLINKING_STRING);
    private static final String TAG = "LensApi";
    private final Context context;
    private final LensSdkParamsReader paramsReader;
    private final LensServiceBridge serviceBridge;

    public interface LensAvailabilityCallback {
        void onAvailabilityStatusFetched(@LensAvailabilityStatus int i);
    }

    public @interface LensAvailabilityStatus {
        public static final int LENS_READY = 0;
        public static final int LENS_UNAVAILABLE = 1;
        public static final int LENS_UNAVAILABLE_DEVICE_INCOMPATIBLE = 3;
        public static final int LENS_UNAVAILABLE_DEVICE_LOCKED = 5;
        public static final int LENS_UNAVAILABLE_LOCALE_NOT_SUPPORTED = 2;
        public static final int LENS_UNAVAILABLE_UNKNOWN_ERROR_CODE = 6;
    }

    public @interface LensFeature {
        public static final int LENS_AR_STICKERS = 1;
        public static final int LENS_CORE = 0;
    }

    private static final class LensSdkParamsCallback implements LensSdkParamsReader.LensSdkParamsCallback {
        private final LensAvailabilityCallback lensAvailabilityCallback;

        LensSdkParamsCallback(LensAvailabilityCallback lensAvailabilityCallback2) {
            this.lensAvailabilityCallback = lensAvailabilityCallback2;
        }

        public void onLensSdkParamsAvailable(LensSdkParamsProto.LensSdkParams lensSdkParams) {
            this.lensAvailabilityCallback.onAvailabilityStatusFetched(LensApi.mapInternalLensAvailabilityToExternal(lensSdkParams.lensAvailabilityStatus));
        }
    }

    public LensApi(Context context2) {
        this.context = context2;
        this.paramsReader = new LensSdkParamsReader(context2);
        this.serviceBridge = new LensServiceBridge(context2);
    }

    public void onResume() {
        this.serviceBridge.bindService();
    }

    public void onPause() {
        this.serviceBridge.unbindService();
    }

    public void launchLensActivity(final Activity activity) {
        KeyguardManager keyguardManager = (KeyguardManager) activity.getSystemService("keyguard");
        if (!keyguardManager.isKeyguardLocked()) {
            startLensActivity(activity);
        } else if (Build.VERSION.SDK_INT >= 26) {
            keyguardManager.requestDismissKeyguard(activity, new KeyguardManager.KeyguardDismissCallback() {
                public void onDismissSucceeded() {
                    Log.d(LensApi.TAG, "Keyguard successfully dismissed");
                    LensApi.this.startLensActivity(activity);
                }

                public void onDismissError() {
                    Log.e(LensApi.TAG, "Error dismissing keyguard");
                }

                public void onDismissCancelled() {
                    Log.d(LensApi.TAG, "Keyguard dismiss cancelled");
                }
            });
        } else {
            int i = Build.VERSION.SDK_INT;
            StringBuilder sb = new StringBuilder(64);
            sb.append("Cannot start Lens when device is locked with Android ");
            sb.append(i);
            Log.e(TAG, sb.toString());
        }
    }

    public void launchLensActivity(Activity activity, @LensFeature int i) {
        if (i == 0) {
            launchLensActivity(activity);
        } else if (i != 1) {
            StringBuilder sb = new StringBuilder(34);
            sb.append("Invalid lens activity: ");
            sb.append(i);
            Log.w(TAG, sb.toString());
        } else if (this.paramsReader.getArStickersAvailability() == 0) {
            Intent intent = new Intent();
            intent.setClassName(LensSdkParamsReader.LENS_AR_STICKERS_PACKAGE, LensSdkParamsReader.LENS_AR_STICKERS_ACTIVITY);
            activity.startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public void startLensActivity(Activity activity) {
        if (this.serviceBridge.prewarmLensActivity()) {
            Log.i(TAG, "Lens is pre-warmed.");
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(LENS_DEEPLINKING_STRING));
        activity.startActivityForResult(intent, 0);
    }

    public void launchLensActivityWithBitmapUri(Activity activity, Uri uri) {
        if (uri == null) {
            Log.e(TAG, "Image URI is null!");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(appendBitmapUri(LENS_DEEPLINKING_URI, uri));
        activity.startActivityForResult(intent, 0);
    }

    public void checkLensAvailability(LensAvailabilityCallback lensAvailabilityCallback) {
        if (!((KeyguardManager) this.context.getSystemService("keyguard")).isKeyguardLocked() || Build.VERSION.SDK_INT >= 26) {
            this.paramsReader.getParams(new LensSdkParamsCallback(lensAvailabilityCallback));
        } else {
            lensAvailabilityCallback.onAvailabilityStatusFetched(5);
        }
    }

    public void checkArStickersAvailability(LensAvailabilityCallback lensAvailabilityCallback) {
        lensAvailabilityCallback.onAvailabilityStatusFetched(mapInternalLensAvailabilityToExternal(this.paramsReader.getArStickersAvailability()));
    }

    private Uri appendBitmapUri(Uri uri, Uri uri2) {
        return (uri == null || uri2 == null) ? uri : uri.buildUpon().appendQueryParameter(LENS_BITMAP_URI_KEY, uri2.toString()).build();
    }

    /* access modifiers changed from: private */
    @LensAvailabilityStatus
    public static int mapInternalLensAvailabilityToExternal(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 5 || i == 6) {
            return i;
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append("Internal error code: ");
        sb.append(i);
        Log.d(TAG, sb.toString());
        return 1;
    }
}
