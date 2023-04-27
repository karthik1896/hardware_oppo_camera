package com.meicam.effect.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.meicam.sdk.NvsAssetPackageManager;
import com.meicam.sdk.NvsRational;
import com.meicam.sdk.NvsSystemVariableManager;
import com.meicam.sdk.NvsTimeUtil;
import com.meicam.sdk.NvsUtils;
import java.util.List;

public class NvsEffectSdkContext {
    public static final int DEBUG_LEVEL_DEBUG = 3;
    public static final int DEBUG_LEVEL_ERROR = 1;
    public static final int DEBUG_LEVEL_NONE = 0;
    public static final int DEBUG_LEVEL_WARNING = 2;
    public static final int HUMAN_DETECTION_DATA_TYPE_FAKE_FACE = 0;
    public static final int HUMAN_DETECTION_FEATURE_FACE_ACTION = 2;
    public static final int HUMAN_DETECTION_FEATURE_FACE_LANDMARK = 1;
    private static final String TAG = "Meicam";
    private static AssetManager m_assetManager = null;
    private static Thread m_checkExpirationThread = null;
    private static ClassLoader m_classLoader = null;
    private static Context m_context = null;
    private static int m_debugLevel = 3;
    private static boolean m_faceDetectionLibLoaded = false;
    private static boolean m_initializedOnce = false;
    private static NvsEffectSdkContext m_instance = null;
    private static boolean m_saveDebugMessagesToFile = false;
    private NvsAssetPackageManager m_assetPackageManager;

    public static class SdkVersion {
        public int majorVersion;
        public int minorVersion;
        public int revisionNumber;
    }

    public static class VerifyLicenseResult {
        public boolean needCheckExpiration;
        public boolean success;
    }

    private static native void nativeClose();

    private static native void nativeCloseHumanDetection();

    private native NvsEffectRenderCore nativeCreateEffectRenderCore();

    private native NvsVideoEffect nativeCreateVideoEffect(String str, NvsRational nvsRational);

    private native void nativeDetectPackageName(Context context);

    private static native boolean nativeFunctionalityAuthorised(String str);

    private native List<String> nativeGetAllBuiltinVideoFxNames();

    private native long nativeGetAssetPackageManager();

    private native SdkVersion nativeGetSdkVersion();

    private static native int nativeHasARModule();

    private static native boolean nativeInit(String str, int i);

    private static native boolean nativeInitHumanDetection(Context context, String str, String str2, int i);

    private static native boolean nativeInitJNI(Context context);

    private native boolean nativeIsEffectSdkAuthorised();

    private static native void nativeSetAssetManager(AssetManager assetManager);

    private static native void nativeSetDebugLevel(int i);

    private static native void nativeSetSaveDebugMessagesToFile(boolean z);

    private static native boolean nativeSetupHumanDetectionData(int i, String str);

    private static native VerifyLicenseResult nativeVerifySdkLicenseFile(Context context, String str, boolean z);

    public static void setDebugLevel(int i) {
        NvsUtils.checkFunctionInMainThread();
        if (i != m_debugLevel) {
            m_debugLevel = i;
            if (m_instance != null) {
                nativeSetDebugLevel(m_debugLevel);
            }
        }
    }

    public static void setSaveDebugMessagesToFile(boolean z) {
        NvsUtils.checkFunctionInMainThread();
        if (z != m_saveDebugMessagesToFile) {
            m_saveDebugMessagesToFile = z;
            if (m_instance != null) {
                nativeSetSaveDebugMessagesToFile(m_saveDebugMessagesToFile);
            }
        }
    }

    public static Context getContext() {
        NvsUtils.checkFunctionInMainThread();
        return m_context;
    }

    public static ClassLoader getClassLoader() {
        NvsUtils.checkFunctionInMainThread();
        return m_classLoader;
    }

    public boolean isSdkAuthorised() {
        NvsUtils.checkFunctionInMainThread();
        return nativeIsEffectSdkAuthorised();
    }

    public static NvsEffectSdkContext init(Context context, String str, int i) {
        boolean z;
        NvsUtils.checkFunctionInMainThread();
        NvsEffectSdkContext nvsEffectSdkContext = m_instance;
        if (nvsEffectSdkContext != null) {
            return nvsEffectSdkContext;
        }
        String str2 = ("HOME=" + context.getFilesDir().getAbsolutePath()) + "\tTMPDIR=" + context.getFilesDir().getAbsolutePath();
        try {
            m_assetManager = context.getAssets();
            m_context = context.getApplicationContext();
            m_classLoader = m_context.getClassLoader();
            boolean z2 = false;
            if (!m_initializedOnce) {
                tryLoadFaceDetectionLibrary();
                try {
                    Class.forName("com.meicam.sdk.NvsStreamingContext");
                    z = false;
                } catch (Exception unused) {
                    z = true;
                }
                String str3 = "NvStreamingSdkCore";
                if (z) {
                    str3 = "NvEffectSdkCore";
                }
                loadNativeLibrary(str3);
            }
            if (nativeInitJNI(m_context)) {
                nativeSetAssetManager(m_assetManager);
                nativeSetDebugLevel(m_debugLevel);
                nativeSetSaveDebugMessagesToFile(m_saveDebugMessagesToFile);
                if (NvsSystemVariableManager.getSystemVariableInt(context, "isExpired") == 1) {
                    z2 = true;
                }
                VerifyLicenseResult verifyLicenseResult = new VerifyLicenseResult();
                if (!m_initializedOnce) {
                    verifyLicenseResult = nativeVerifySdkLicenseFile(context, str, z2);
                }
                if (verifyLicenseResult.needCheckExpiration) {
                    String systemVariableString = NvsSystemVariableManager.getSystemVariableString(context, "lastTime");
                    if (!TextUtils.isEmpty(systemVariableString) && NvsTimeUtil.getHourRange(systemVariableString, NvsTimeUtil.getCurrentTime()) >= 0) {
                    }
                }
                if (!nativeInit(str2, i)) {
                    return null;
                }
                m_instance = new NvsEffectSdkContext(context);
                m_initializedOnce = true;
                return m_instance;
            }
            throw new Exception("nativeInitJNI() failed!");
        } catch (Exception e) {
            Log.e(TAG, "" + e.getMessage());
            e.printStackTrace();
            m_context = null;
            m_classLoader = null;
            m_assetManager = null;
            return null;
        }
    }

    public static NvsEffectSdkContext init(Activity activity, String str, int i) {
        NvsUtils.checkFunctionInMainThread();
        return init((Context) activity, str, i);
    }

    public static NvsEffectSdkContext init(Activity activity, String str) {
        NvsUtils.checkFunctionInMainThread();
        return init(activity, str, 0);
    }

    public static void close() {
        NvsUtils.checkFunctionInMainThread();
        NvsEffectSdkContext nvsEffectSdkContext = m_instance;
        if (nvsEffectSdkContext != null) {
            NvsAssetPackageManager assetPackageManager = nvsEffectSdkContext.getAssetPackageManager();
            if (assetPackageManager != null) {
                assetPackageManager.setCallbackInterface((NvsAssetPackageManager.AssetPackageManagerCallback) null);
            }
            m_instance = null;
            m_context = null;
            nativeSetAssetManager((AssetManager) null);
            m_assetManager = null;
            m_classLoader = null;
            nativeClose();
        }
    }

    public static NvsEffectSdkContext getInstance() {
        NvsUtils.checkFunctionInMainThread();
        return m_instance;
    }

    public static int hasARModule() {
        NvsUtils.checkFunctionInMainThread();
        return nativeHasARModule();
    }

    public static boolean initHumanDetection(Context context, String str, String str2, int i) {
        NvsUtils.checkFunctionInMainThread();
        tryLoadFaceDetectionLibrary();
        if (!m_faceDetectionLibLoaded) {
            return false;
        }
        return nativeInitHumanDetection(context, str, str2, i);
    }

    public static void closeHumanDetection() {
        NvsUtils.checkFunctionInMainThread();
        nativeCloseHumanDetection();
    }

    public static boolean setupHumanDetectionData(int i, String str) {
        return nativeSetupHumanDetectionData(i, str);
    }

    private NvsEffectSdkContext(Context context) {
        this.m_assetPackageManager = null;
        this.m_assetPackageManager = new NvsAssetPackageManager(true);
        this.m_assetPackageManager.setInternalObject(nativeGetAssetPackageManager());
        nativeDetectPackageName(context);
    }

    public SdkVersion getSdkVersion() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetSdkVersion();
    }

    public NvsAssetPackageManager getAssetPackageManager() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_assetPackageManager;
    }

    public List<String> getAllBuiltinVideoFxNames() {
        NvsUtils.checkFunctionInMainThread();
        return nativeGetAllBuiltinVideoFxNames();
    }

    public NvsVideoEffect createVideoEffect(String str, NvsRational nvsRational) {
        NvsUtils.checkFunctionInMainThread();
        return nativeCreateVideoEffect(str, nvsRational);
    }

    public NvsEffectRenderCore createEffectRenderCore() {
        NvsUtils.checkFunctionInMainThread();
        return nativeCreateEffectRenderCore();
    }

    private boolean checkCameraPermission() {
        if (Build.VERSION.SDK_INT < 23) {
        }
        return true;
    }

    private boolean checkInternetPermission() {
        if (Build.VERSION.SDK_INT < 23 || m_context.checkSelfPermission("android.permission.INTERNET") == 0) {
            return true;
        }
        Log.e(TAG, "INTERNET permission has not been granted!");
        return false;
    }

    private static void loadNativeLibrary(String str) throws SecurityException, UnsatisfiedLinkError, NullPointerException {
        System.loadLibrary(str);
    }

    private static boolean tryLoadNativeLibrary(String str) throws SecurityException, UnsatisfiedLinkError, NullPointerException {
        try {
            System.loadLibrary(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void tryLoadFaceDetectionLibrary() {
        boolean z;
        boolean z2;
        if (!m_faceDetectionLibLoaded) {
            boolean z3 = false;
            try {
                Class.forName("com.meicam.effect.sdk.NvsBEFFaceEffectDetector");
                z = true;
            } catch (Exception unused) {
                z = false;
            }
            if (!z || tryLoadNativeLibrary("effect")) {
                try {
                    Class.forName("com.meicam.effect.sdk.NvsMGFaceEffectDetector");
                    z2 = true;
                } catch (Exception unused2) {
                    z2 = false;
                }
                if (!z2 || (tryLoadNativeLibrary("megface-new") && tryLoadNativeLibrary("MegviiFacepp"))) {
                    try {
                        Class.forName("com.meicam.effect.sdk.NvsSTFaceEffectDetector");
                        z3 = true;
                    } catch (Exception unused3) {
                    }
                    if (!z3 || tryLoadNativeLibrary("st_mobile")) {
                        m_faceDetectionLibLoaded = true;
                    }
                }
            }
        }
    }

    public static boolean functionalityAuthorised(String str) {
        NvsUtils.checkFunctionInMainThread();
        return nativeFunctionalityAuthorised(str);
    }
}
