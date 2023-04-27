package com.oppo.camera.util;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.OplusBaseConfiguration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.HardwareBuffer;
import android.hardware.camera2.CaptureResult;
import android.hardware.display.DisplayManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.ExifInterface;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaScannerConnection;
import android.media.MicrophoneInfo;
import android.net.Uri;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.LocaleList;
import android.os.Looper;
import android.os.OplusSystemProperties;
import android.os.RemoteException;
import android.provider.Settings;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.Display;
import android.view.OplusWindowManager;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import color.support.v7.app.b;
import com.color.support.d.o;
import com.color.support.d.p;
import com.heytap.compat.os.UserHandleNative;
import com.meicam.sdk.NvsMediaFileConvertor;
import com.oplus.content.OplusFeatureConfigManager;
import com.oplus.os.OplusUsbEnvironment;
import com.oplus.util.OplusFontUtils;
import com.oplus.util.OplusTypeCastingHelper;
import com.oppo.camera.R;
import com.oppo.camera.aps.ApsCameraRequestTag;
import com.oppo.camera.aps.adapter.ImageCategory;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.aps.constant.ParameterKeys;
import com.oppo.camera.e;
import com.oppo.camera.e.v;
import com.oppo.camera.f.c;
import com.oppo.camera.f.d;
import com.oppo.camera.gl.s;
import com.oppo.camera.jni.FormatConverter;
import com.oppo.camera.q.a;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.statistics.model.EnterExitDcsMsgData;
import com.sensetime.stmobile.STMobileHumanActionNative;
import com.sensetime.stmobile.sticker_module_types.STStickerMakeupParamType;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class Util {
    private static Object A = new Object();
    private static LocationManager B = null;
    /* access modifiers changed from: private */
    public static Context C = null;
    private static Handler D = null;
    /* access modifiers changed from: private */
    public static b E = null;
    private static Thread F = null;
    /* access modifiers changed from: private */
    public static RenderScript G = null;
    /* access modifiers changed from: private */
    public static ScriptIntrinsicBlur H = null;
    private static HashMap<String, Boolean> I = null;
    private static HandlerThread J = null;
    private static Handler K = null;
    private static Display L = null;
    private static ArrayMap<Integer, Integer> M = new ArrayMap<>();
    private static int N = 0;
    private static int O = 0;
    private static int P = 0;
    private static int Q = 0;
    private static int R = 0;
    private static int S = 0;
    private static int T = 0;
    private static int U = 0;
    private static int V = 0;
    private static int W = 0;
    private static int X = 0;
    private static int Y = 120000;
    private static double Z = 0.8d;

    /* renamed from: a  reason: collision with root package name */
    public static int f4603a = 480;
    private static boolean aa = false;
    private static boolean ab = false;
    private static boolean ac = false;
    private static Boolean ad = null;
    private static DecimalFormat ae = null;
    private static boolean af = false;

    /* renamed from: b  reason: collision with root package name */
    public static int f4604b = 0;
    public static float c = 0.0f;
    public static int d = 20;
    public static String e = null;
    public static int f = 4;
    public static int g = 8;
    private static Field h = null;
    private static float i = 1.0f;
    private static a j = null;
    private static boolean k = false;
    private static boolean l = false;
    private static boolean m = false;
    private static boolean n = false;
    private static boolean o = false;
    private static boolean p = false;
    private static boolean q = false;
    private static boolean r = false;
    private static boolean s = false;
    private static String t;
    private static String u;
    private static Typeface v;
    private static String w;
    private static String x;
    private static String y;
    /* access modifiers changed from: private */
    public static Object z = new Object();

    public static boolean R() {
        return true;
    }

    public static float a(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    public static int a(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    public static String a(int i2) {
        if (i2 == 17) {
            return "yuv420sp";
        }
        if (i2 == 32) {
            return "raw";
        }
        if (i2 == 256) {
            return "jpeg";
        }
        switch (i2) {
            case 35:
                return "yuv420sp";
            case 36:
            case 37:
            case 38:
                return "raw";
            default:
                return null;
        }
    }

    public static String a(boolean z2) {
        return z2 ? ApsConstant.REC_MODE_COMMON : ApsConstant.CAPTURE_MODE_COMMON;
    }

    public static boolean a(Uri uri, String str, int i2, int i3) {
        return uri != null && str != null && i2 < 0 && i3 < 0;
    }

    public static boolean c(int i2) {
        return i2 == 1 || i2 == 5;
    }

    public static int d(int i2) {
        switch (i2) {
            case R.string.camera_pi_off_hint:
                return R.string.camera_pi_off_hint_realme;
            case R.string.camera_pi_on_hint:
                return R.string.camera_pi_on_hint_realme;
            case R.string.camera_pi_title:
                return R.string.camera_pi_title_realme;
            case R.string.camera_scene_ultra_dark_mode_tips:
                return R.string.camera_scene_ultra_dark_mode_tips_realme;
            case R.string.camera_super_eis_pro:
                return R.string.camera_super_eis_max_realme;
            case R.string.camera_switch_main:
                return R.string.camera_switch_main_realme;
            case R.string.camera_switch_ultra_wide:
                return R.string.camera_switch_ultra_wide_realme;
            case R.string.camera_switch_ultra_wide_micro_lens:
                return R.string.camera_switch_ultra_wide_micro_lens_realme;
            case R.string.ultra_wide_micro_lens_toast:
                return R.string.ultra_wide_micro_lens_toast_realme;
            default:
                return i2;
        }
    }

    public static boolean e(int i2) {
        return i2 == 2;
    }

    public static native boolean nativeGetYuvDataWithoutPadding(HardwareBuffer hardwareBuffer, ByteBuffer byteBuffer, int i2);

    static {
        System.loadLibrary("preview_show");
        M.put(720, 420);
        M.put(1080, 480);
        M.put(1440, 640);
    }

    public static void a(Context context) {
        e.a("Util", "attachBaseContext, context: " + context);
        C = context;
    }

    public static void b(Context context) {
        C = context;
        k = h("oplus.software.video.wnr_support");
        af = "JP".equals(i("ro.vendor.oplus.regionmark"));
    }

    public static synchronized void c(Context context) {
        synchronized (Util.class) {
            e.a("Util", "initialize, sbInit: " + ac);
            if (!ac) {
                V();
                com.oppo.camera.q.a.a(context, (a.C0092a) null);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                e.a("Util", "displaycontent, getDefaultDisplay().getHeight(): " + windowManager.getDefaultDisplay().getHeight() + " wm.getDefaultDisplay().getWidth(): " + windowManager.getDefaultDisplay().getWidth() + " metrics.density: " + displayMetrics.density + " metrics.densityDpi: " + displayMetrics.densityDpi);
                i = displayMetrics.density;
                D = new Handler(context.getMainLooper());
                d(context);
                m(C);
                g();
                ac = true;
                A(context);
                L();
            }
            d();
            e.a("Util", "initialize X");
        }
    }

    private static void A(Context context) {
        try {
            Iterator<MicrophoneInfo> it = ((AudioManager) context.getSystemService("audio")).getMicrophones().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (15 == it.next().getType()) {
                        r = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (!r) {
            e.e("Util", "checkMicrophoneDevice, No Microphone Device!");
        }
    }

    public static boolean a() {
        return m;
    }

    public static boolean b() {
        return n;
    }

    public static boolean c() {
        return o;
    }

    public static synchronized void d(Context context) {
        synchronized (Util.class) {
            boolean q2 = q(context);
            if (L.getDisplayId() != 0 || !q2) {
                try {
                    f4603a = com.heytap.compat.e.a.b(0);
                } catch (RemoteException | com.heytap.compat.d.a.a e2) {
                    e2.printStackTrace();
                }
            } else {
                f4603a = M.get(Integer.valueOf(L.getMode().getPhysicalWidth())).intValue();
            }
            e.b("Util", "initializeDefaultDisplay, acquire sDefaultDensity: " + f4603a);
        }
    }

    public static void d() {
        if (J == null) {
            J = new HandlerThread("WorkerThread");
            J.start();
        }
        if (K == null) {
            K = new Handler(J.getLooper());
        }
    }

    public static void a(Runnable runnable) {
        Handler handler = K;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public static void b(Runnable runnable) {
        Handler handler = K;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public static void e() {
        Handler handler = K;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            K = null;
        }
        HandlerThread handlerThread = J;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            J = null;
        }
    }

    public static Context f() {
        return C;
    }

    public static void g() {
        if (F != null) {
            e.b("Util", "initRenderScript, sRSInitThread not null, so return");
            return;
        }
        F = new Thread(new Runnable() {
            public void run() {
                e.b("Util", "intRenderScript");
                if (Util.C != null) {
                    synchronized (Util.z) {
                        RenderScript unused = Util.G = RenderScript.create(Util.C);
                        ScriptIntrinsicBlur unused2 = Util.H = ScriptIntrinsicBlur.create(Util.G, Element.U8_4(Util.G));
                    }
                    e.b("Util", "intRenderScript X");
                }
            }
        });
        F.start();
    }

    public static Bitmap a(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postScale(-1.0f, 1.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static void h() {
        Thread thread = F;
        if (thread != null) {
            try {
                thread.join();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        synchronized (z) {
            if (H != null) {
                H.destroy();
                H = null;
            }
            if (G != null) {
                try {
                    G.destroy();
                    G = null;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    e.e("Util", "finishRSInitThread, renderScript destroy, exception: " + e3.getMessage());
                }
            }
        }
        e.b("Util", "finishRSInitThread X");
    }

    public static int a(float f2) {
        return Math.round(i * f2);
    }

    public static float i() {
        return i;
    }

    public static Bitmap a(Bitmap bitmap, int i2) {
        return a(bitmap, i2, false);
    }

    public static Bitmap a(Bitmap bitmap, int i2, boolean z2) {
        if ((i2 == 0 && !z2) || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        if (z2) {
            matrix.postScale(-1.0f, 1.0f);
            i2 = (i2 + 360) % 360;
            if (i2 == 0 || i2 == 180) {
                matrix.postTranslate((float) bitmap.getWidth(), 0.0f);
            } else if (i2 == 90 || i2 == 270) {
                matrix.postTranslate((float) bitmap.getHeight(), 0.0f);
            } else {
                throw new IllegalArgumentException("Invalid degrees: " + i2);
            }
        }
        if (i2 != 0) {
            matrix.postRotate((float) i2, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        }
        try {
            Bitmap a2 = a(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap == a2) {
                return bitmap;
            }
            bitmap.recycle();
            return a2;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return bitmap;
        }
    }

    public static int a(BitmapFactory.Options options, int i2, int i3) {
        int b2 = b(options, i2, i3);
        if (b2 > 8) {
            return 8 * ((b2 + 7) / 8);
        }
        int i4 = 1;
        while (i4 < b2) {
            i4 <<= 1;
        }
        return i4;
    }

    private static int b(BitmapFactory.Options options, int i2, int i3) {
        int i4;
        int i5;
        double d2 = (double) options.outWidth;
        double d3 = (double) options.outHeight;
        if (i3 < 0) {
            i4 = 1;
        } else {
            i4 = (int) Math.ceil(Math.sqrt((d2 * d3) / ((double) i3)));
        }
        if (i2 < 0) {
            i5 = 128;
        } else {
            double d4 = (double) i2;
            i5 = (int) Math.min(Math.floor(d2 / d4), Math.floor(d3 / d4));
        }
        if (i5 < i4) {
            return i4;
        }
        if (i3 >= 0 || i2 >= 0) {
            return i2 < 0 ? i4 : i5;
        }
        return 1;
    }

    public static Bitmap a(byte[] bArr, int i2) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (!options.mCancel && options.outWidth != -1) {
                if (options.outHeight != -1) {
                    options.inSampleSize = a(options, -1, i2);
                    options.inJustDecodeBounds = false;
                    options.inDither = false;
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                }
            }
            return null;
        } catch (OutOfMemoryError e2) {
            e.d("Util", "Got oom exception ", e2);
            return null;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean j() {
        b bVar = E;
        return bVar != null && bVar.isShowing();
    }

    public static void a(final Activity activity, final int i2) {
        e.e("Util", "showErrorAndFinish, Some Error occurs, Error id: " + i2 + ", activty: " + activity);
        if (activity != null) {
            D.post(new Runnable() {
                public void run() {
                    AnonymousClass1 r0 = new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            activity.finish();
                        }
                    };
                    if (Util.E != null) {
                        Util.E.cancel();
                        b unused = Util.E = null;
                    }
                    b unused2 = Util.E = new b.a(activity).setCancelable(false).setIconAttribute(16843605).setTitle(i2).setNeutralButton((int) R.string.camera_button_ok, (DialogInterface.OnClickListener) r0).show();
                }
            });
        }
    }

    public static void k() {
        Handler handler = D;
        if (handler != null && E != null) {
            handler.post(new Runnable() {
                public void run() {
                    e.a("Util", "cancleOpenCameraFailDialog(), sOpenCameraFailDialog: " + Util.E);
                    if (Util.E != null) {
                        Util.E.cancel();
                        b unused = Util.E = null;
                    }
                }
            });
        }
    }

    public static int a(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 0) {
            return 0;
        }
        if (rotation == 1) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : 270;
        }
        return 180;
    }

    public static int a(int i2, int i3) {
        boolean z2 = true;
        if (i3 != -1) {
            int abs = Math.abs(i2 - i3);
            if (Math.min(abs, 360 - abs) < 65) {
                z2 = false;
            }
        }
        return z2 ? (((i2 + 30) / 90) * 90) % 360 : i3;
    }

    public static Size a(List<Size> list, double d2) {
        return a(list, d2, 0);
    }

    public static Size a(List<Size> list, double d2, int i2) {
        Size size = null;
        if (list == null) {
            return null;
        }
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MAX_VALUE;
        for (Size next : list) {
            if (Math.abs((((double) next.getWidth()) / ((double) next.getHeight())) - d2) <= (538982489 == i2 ? 0.002d : 0.01d)) {
                int abs = Math.abs(next.getHeight() - N);
                if (abs < i4) {
                    i4 = Math.abs(next.getHeight() - N);
                } else if (abs == i4) {
                    if (next.getHeight() <= N) {
                    }
                }
                size = next;
            }
        }
        if (size == null) {
            for (Size next2 : list) {
                if (Math.abs(next2.getHeight() - N) < i3) {
                    i3 = Math.abs(next2.getHeight() - N);
                    size = next2;
                }
            }
        }
        if (size != null) {
            e.a("Util", "getOptimalPreviewSize, screen: " + N + "x" + O + ", targetRatio: " + d2 + ", optimalSize: " + size.getHeight() + "x" + size.getWidth());
        } else {
            e.e("Util", "getOptimalPreviewSize, optimalSize is null");
        }
        return size;
    }

    public static boolean a(Size size, double d2) {
        return Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - d2) < 0.05d;
    }

    public static Size b(List<Size> list, double d2) {
        Size size = null;
        if (list == null) {
            return null;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MAX_VALUE;
        for (Size next : list) {
            if (Math.abs((((double) next.getWidth()) / ((double) next.getHeight())) - d2) <= 0.01d) {
                int abs = Math.abs(next.getWidth() - O);
                if (abs < i3) {
                    i3 = Math.abs(next.getWidth() - O);
                } else if (abs == i3) {
                    if (next.getWidth() <= O) {
                    }
                }
                size = next;
            }
        }
        if (size == null) {
            for (Size next2 : list) {
                if (Math.abs(next2.getWidth() - O) < i2) {
                    i2 = Math.abs(next2.getWidth() - O);
                    size = next2;
                }
            }
        }
        if (size != null) {
            e.a("Util", "getOptimalPreviewSizeByWidth, screen: " + N + "x" + O + ", targetRatio: " + d2 + ", optimalSize: " + size.getHeight() + "x" + size.getWidth());
        } else {
            e.e("Util", "getOptimalPreviewSizeByWidth, optimalSize is null");
        }
        return size;
    }

    public static Size a(List<Size> list, int i2, int i3) {
        if (list != null && !list.isEmpty()) {
            return (Size) list.stream().filter($$Lambda$bdDB5qtJ9up3KI34bjHEph1ELg.INSTANCE).filter(new Predicate(i2, i3) {
                private final /* synthetic */ int f$0;
                private final /* synthetic */ int f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final boolean test(Object obj) {
                    return Util.a(this.f$0, this.f$1, (Size) obj);
                }
            }).min($$Lambda$Util$QwUzA1ArcgAHRJGQKo9DclKKNI.INSTANCE).orElse((Object) null);
        }
        e.d("Util", "getOptimalBigSizeByTargetSize, size is empty");
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean a(int i2, int i3, Size size) {
        return 0.05d >= Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - (((double) i2) / ((double) i3))) && size.getWidth() >= i2 && size.getHeight() >= i3;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int b(Size size, Size size2) {
        return (size.getHeight() + size.getWidth()) - (size2.getWidth() + size2.getHeight());
    }

    public static Size c(List<Size> list, double d2) {
        return b(list, d2, -1);
    }

    public static Size b(List<Size> list, double d2, int i2) {
        return a(list, d2, i2, -1);
    }

    public static Size a(List<Size> list, double d2, int i2, int i3) {
        Size size = null;
        if (!(list == null || list.size() == 0)) {
            for (Size next : list) {
                if (Math.abs((((double) next.getWidth()) / ((double) next.getHeight())) - d2) <= 0.01d && ((-1 == i2 || next.getHeight() <= i2) && ((-1 == i3 || next.getWidth() <= i3) && (size == null || size.getHeight() < next.getHeight())))) {
                    size = next;
                }
            }
            if (size != null) {
                e.a("Util", "getMaxSizeByRatio, size: " + size.getHeight() + "x" + size.getWidth() + ", targetRatio: " + d2);
            } else {
                e.e("Util", "getMaxSizeByRatio, optimalSize is null");
            }
        }
        return size;
    }

    public static Size d(List<Size> list, double d2) {
        return c(list, d2, -1);
    }

    public static Size c(List<Size> list, double d2, int i2) {
        Size size = null;
        if (!(list == null || list.size() == 0)) {
            for (Size next : list) {
                if (Math.abs((((double) next.getWidth()) / ((double) next.getHeight())) - d2) <= 0.05d && ((-1 == i2 || next.getHeight() <= i2) && (size == null || size.getHeight() < next.getHeight()))) {
                    size = next;
                }
            }
            if (size != null) {
                e.a("Util", "getImpreciseMaxSizeByRatio, size: " + size.getHeight() + "x" + size.getWidth() + ", targetRatio: " + d2);
            } else {
                e.e("Util", "getImpreciseMaxSizeByRatio, optimalSize is null");
            }
        }
        return size;
    }

    public static Size a(int i2, List<Size> list, double d2) {
        int i3 = Integer.MAX_VALUE;
        Size size = null;
        for (Size next : list) {
            if (Math.abs((((double) next.getWidth()) / ((double) next.getHeight())) - d2) <= 0.01d && Math.abs(next.getHeight() - i2) < i3) {
                i3 = Math.abs(next.getHeight() - i2);
                size = next;
            }
        }
        return size;
    }

    public static int a(String str) {
        if ("standard".equals(str) || "standard_high".equals(str)) {
            return 0;
        }
        if ("full".equals(str)) {
            return H();
        }
        if ("square".equals(str)) {
            return 2;
        }
        return "16_9".equals(str) ? 1 : -1;
    }

    public static String a(Size size, int i2) {
        if (size == null) {
            return "full";
        }
        Size sizeConfigValue = CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE, i2);
        if (sizeConfigValue != null && sizeConfigValue.getWidth() == size.getWidth() && sizeConfigValue.getHeight() == size.getHeight()) {
            return "standard_high";
        }
        if (Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - 1.3333333333333333d) < 0.01d) {
            return "standard";
        }
        if (Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - 1.0d) < 0.01d) {
            return "square";
        }
        return Math.abs((((double) size.getWidth()) / ((double) size.getHeight())) - 1.7777777777777777d) < 0.01d ? "16_9" : "full";
    }

    public static Size a(List<Size> list, String str, int i2) {
        Size size = null;
        if (list == null || list.size() == 0 || str == null) {
            e.e("Util", "getMinDiffPictureSize error!");
            return null;
        }
        long j2 = Long.MAX_VALUE;
        for (Size next : list) {
            if (b(next.getWidth(), next.getHeight()) == i2 && j2 > Math.abs(Long.valueOf(str).longValue() - ((long) (next.getWidth() * next.getHeight())))) {
                j2 = Math.abs(Long.valueOf(str).longValue() - ((long) (next.getWidth() * next.getHeight())));
                size = next;
            }
        }
        return size;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:23|24|25|(3:26|27|(8:29|(2:31|(1:33)(1:(4:35|(2:37|38)|(2:40|41)|42)))|44|45|46|(2:48|49)|(2:51|52)|53))) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        com.oppo.camera.e.e("Util", "isUriValid, IOException: " + r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r2 = r13.query(r12, (java.lang.String[]) null, (java.lang.String) null, (java.lang.String[]) null, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0067, code lost:
        if (r2 != null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0069, code lost:
        r2.moveToFirst();
        r12 = r2.getString(r2.getColumnIndex(com.android.providers.downloads.Downloads.Impl._DATA));
        r13 = r2.getInt(r2.getColumnIndex("is_pending"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0086, code lost:
        if (r12.contains("_tmp") == false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008e, code lost:
        if (r12.contains("dng") != false) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0091, code lost:
        if (1 == r13) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0093, code lost:
        com.oppo.camera.e.e("Util", "isUriValid, but from IS_PENDING file!");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0098, code lost:
        if (r2 != null) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009d, code lost:
        if (r4 != null) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a2, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        com.oppo.camera.e.e("Util", "isUriValid, but from tmp file!");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a8, code lost:
        if (r2 != null) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ad, code lost:
        if (r4 != null) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b2, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b3, code lost:
        if (r2 != null) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00b9, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00bb, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        com.oppo.camera.e.d("Util", "isUriValid, get cursor failed!", r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00c1, code lost:
        if (r2 == null) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00c4, code lost:
        if (r4 == null) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00ca, code lost:
        if (r2 != null) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00cf, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00d0, code lost:
        r12 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0049 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.net.Uri r12, android.content.ContentResolver r13) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "isUriValid, uri: "
            r0.append(r1)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "Util"
            com.oppo.camera.e.a(r1, r0)
            r0 = 0
            if (r12 != 0) goto L_0x001a
            return r0
        L_0x001a:
            r2 = 0
            r3 = 1
            java.lang.String r4 = "r"
            android.os.ParcelFileDescriptor r4 = r13.openFileDescriptor(r12, r4)     // Catch:{ Exception -> 0x0048, all -> 0x0044 }
            if (r4 != 0) goto L_0x003e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0049 }
            r5.<init>()     // Catch:{ Exception -> 0x0049 }
            java.lang.String r6 = "isUriValid, Fail to open uri: "
            r5.append(r6)     // Catch:{ Exception -> 0x0049 }
            r5.append(r12)     // Catch:{ Exception -> 0x0049 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0049 }
            com.oppo.camera.e.e(r1, r5)     // Catch:{ Exception -> 0x0049 }
            if (r4 == 0) goto L_0x003d
            r4.close()     // Catch:{ Exception -> 0x003d }
        L_0x003d:
            return r0
        L_0x003e:
            if (r4 == 0) goto L_0x0043
            r4.close()     // Catch:{ Exception -> 0x0043 }
        L_0x0043:
            return r3
        L_0x0044:
            r12 = move-exception
            r4 = r2
            goto L_0x00d1
        L_0x0048:
            r4 = r2
        L_0x0049:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d0 }
            r5.<init>()     // Catch:{ all -> 0x00d0 }
            java.lang.String r6 = "isUriValid, IOException: "
            r5.append(r6)     // Catch:{ all -> 0x00d0 }
            r5.append(r12)     // Catch:{ all -> 0x00d0 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00d0 }
            com.oppo.camera.e.e(r1, r5)     // Catch:{ all -> 0x00d0 }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r6 = r13
            r7 = r12
            android.database.Cursor r2 = r6.query(r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x00bb }
            if (r2 == 0) goto L_0x00b3
            r2.moveToFirst()     // Catch:{ Exception -> 0x00bb }
            java.lang.String r12 = "_data"
            int r12 = r2.getColumnIndex(r12)     // Catch:{ Exception -> 0x00bb }
            java.lang.String r12 = r2.getString(r12)     // Catch:{ Exception -> 0x00bb }
            java.lang.String r13 = "is_pending"
            int r13 = r2.getColumnIndex(r13)     // Catch:{ Exception -> 0x00bb }
            int r13 = r2.getInt(r13)     // Catch:{ Exception -> 0x00bb }
            java.lang.String r5 = "_tmp"
            boolean r5 = r12.contains(r5)     // Catch:{ Exception -> 0x00bb }
            if (r5 != 0) goto L_0x00a3
            java.lang.String r5 = "dng"
            boolean r12 = r12.contains(r5)     // Catch:{ Exception -> 0x00bb }
            if (r12 == 0) goto L_0x0091
            goto L_0x00a3
        L_0x0091:
            if (r3 != r13) goto L_0x00b3
            java.lang.String r12 = "isUriValid, but from IS_PENDING file!"
            com.oppo.camera.e.e(r1, r12)     // Catch:{ Exception -> 0x00bb }
            if (r2 == 0) goto L_0x009d
            r2.close()     // Catch:{ all -> 0x00d0 }
        L_0x009d:
            if (r4 == 0) goto L_0x00a2
            r4.close()     // Catch:{ Exception -> 0x00a2 }
        L_0x00a2:
            return r3
        L_0x00a3:
            java.lang.String r12 = "isUriValid, but from tmp file!"
            com.oppo.camera.e.e(r1, r12)     // Catch:{ Exception -> 0x00bb }
            if (r2 == 0) goto L_0x00ad
            r2.close()     // Catch:{ all -> 0x00d0 }
        L_0x00ad:
            if (r4 == 0) goto L_0x00b2
            r4.close()     // Catch:{ Exception -> 0x00b2 }
        L_0x00b2:
            return r3
        L_0x00b3:
            if (r2 == 0) goto L_0x00c4
        L_0x00b5:
            r2.close()     // Catch:{ all -> 0x00d0 }
            goto L_0x00c4
        L_0x00b9:
            r12 = move-exception
            goto L_0x00ca
        L_0x00bb:
            r12 = move-exception
            java.lang.String r13 = "isUriValid, get cursor failed!"
            com.oppo.camera.e.d(r1, r13, r12)     // Catch:{ all -> 0x00b9 }
            if (r2 == 0) goto L_0x00c4
            goto L_0x00b5
        L_0x00c4:
            if (r4 == 0) goto L_0x00c9
            r4.close()     // Catch:{ Exception -> 0x00c9 }
        L_0x00c9:
            return r0
        L_0x00ca:
            if (r2 == 0) goto L_0x00cf
            r2.close()     // Catch:{ all -> 0x00d0 }
        L_0x00cf:
            throw r12     // Catch:{ all -> 0x00d0 }
        L_0x00d0:
            r12 = move-exception
        L_0x00d1:
            if (r4 == 0) goto L_0x00d6
            r4.close()     // Catch:{ Exception -> 0x00d6 }
        L_0x00d6:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.util.Util.a(android.net.Uri, android.content.ContentResolver):boolean");
    }

    public static synchronized String a(long j2) {
        String a2;
        synchronized (Util.class) {
            a2 = a(j2, false);
        }
        return a2;
    }

    public static synchronized String a(long j2, boolean z2) {
        String a2;
        synchronized (Util.class) {
            if (j == null) {
                j = new a(C.getString(R.string.camera_image_file_name_format));
            }
            a2 = j.a(j2, z2);
        }
        return a2;
    }

    public static byte[] b(long j2) {
        return (c(j2) + 0).getBytes();
    }

    public static String c(long j2) {
        try {
            return ZonedDateTime.ofInstant(Instant.ofEpochMilli(j2), ZoneId.systemDefault()).getOffset().getId();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "Z";
        }
    }

    public static synchronized String d(long j2) {
        String a2;
        synchronized (Util.class) {
            if (j == null) {
                j = new a(C.getString(R.string.camera_image_file_name_format));
            }
            a2 = j.a(j2);
        }
        return a2;
    }

    public static void a(Bitmap bitmap, File file) {
        OutputStream a2;
        Throwable th;
        try {
            a2 = com.oppo.camera.q.a.a(file.getAbsolutePath(), com.oppo.camera.q.a.d);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, a2);
            a2.flush();
            if (a2 != null) {
                a2.close();
                return;
            }
            return;
        } catch (IOException e2) {
            e2.printStackTrace();
            return;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public static synchronized void l() {
        synchronized (Util.class) {
            if (j != null) {
                j.a();
            }
        }
    }

    public static void a(Context context, String str) {
        if (str != null) {
            MediaScannerConnection.scanFile(context, new String[]{str}, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
        }
    }

    public static void a(Context context, Uri uri, String str) {
        e.a("Util", "broadcastNewPicture, uri: " + uri);
        context.sendBroadcast(new Intent("android.hardware.action.NEW_PICTURE", uri));
        context.sendBroadcast(new Intent("com.android.camera.NEW_PICTURE", uri));
        a(context, uri, "com.oppo.camera.NEW_PICTURE", "com.coloros.gallery3d");
        a(context, uri, "com.oppo.camera.NEW_PICTURE", "com.heytap.cloud");
        if (str != null) {
            MediaScannerConnection.scanFile(context, new String[]{str}, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
        }
        e.a("Util", "++broadcastNewPicture, uri: " + uri);
    }

    public static void a(Context context, Uri uri, String str, String str2) {
        Intent intent = new Intent(str, uri);
        intent.setPackage(str2);
        context.sendBroadcast(intent);
    }

    public static void a(final View view, final int i2, int i3, Interpolator interpolator, Animator.AnimatorListener animatorListener) {
        if (view != null && i3 >= 0) {
            if (i3 == 0) {
                view.setBackgroundColor(i2);
                return;
            }
            view.animate().cancel();
            Drawable background = view.getBackground();
            final int alpha = background != null ? background.getAlpha() : 0;
            final int alpha2 = Color.alpha(i2) - alpha;
            if (alpha2 != 0) {
                view.animate().setInterpolator(interpolator).setListener(animatorListener).setUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Float f = (Float) valueAnimator.getAnimatedValue();
                        View view = view;
                        if (view != null) {
                            view.setBackgroundColor(Color.argb(alpha + ((int) (((float) alpha2) * f.floatValue())), Color.red(i2), Color.green(i2), Color.blue(i2)));
                        }
                    }
                }).setDuration((long) i3).start();
            }
        }
    }

    public static void a(View view, int i2, Animation.AnimationListener animationListener, long j2) {
        a(view, i2, animationListener, j2, 0, (Interpolator) null);
    }

    public static void a(View view, int i2, Animation.AnimationListener animationListener, long j2, long j3, Interpolator interpolator) {
        AlphaAnimation alphaAnimation;
        if (view != null && view.getVisibility() != i2) {
            if (8 != i2 || 4 != view.getVisibility()) {
                if (4 != i2 || 8 != view.getVisibility()) {
                    if (i2 == 0) {
                        alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    } else {
                        alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                    }
                    if (animationListener == null) {
                        view.setVisibility(i2);
                    }
                    if (interpolator != null) {
                        alphaAnimation.setInterpolator(interpolator);
                    }
                    alphaAnimation.setAnimationListener(animationListener);
                    alphaAnimation.setDuration(j2);
                    alphaAnimation.setStartOffset(j3);
                    view.clearAnimation();
                    view.startAnimation(alphaAnimation);
                }
            }
        }
    }

    public static void a(View view, float f2, float f3, long j2, Animation.AnimationListener animationListener, Interpolator interpolator) {
        if (view != null && view.getVisibility() != 0) {
            view.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
            alphaAnimation.setAnimationListener(animationListener);
            alphaAnimation.setDuration(j2);
            if (interpolator != null) {
                alphaAnimation.setInterpolator(interpolator);
            }
            view.startAnimation(alphaAnimation);
        }
    }

    public static void a(View view) {
        a(view, 400);
    }

    public static void a(View view, int i2) {
        if (view != null) {
            a(view, 0.0f, 1.0f, (long) i2, (Animation.AnimationListener) null, (Interpolator) null);
            view.setEnabled(true);
        }
    }

    public static void b(View view) {
        b(view, 400);
    }

    public static void b(View view, int i2) {
        a(view, i2, 0, (Interpolator) null);
    }

    public static void a(View view, int i2, int i3, Interpolator interpolator) {
        if (view != null && view.getVisibility() == 0) {
            view.setEnabled(false);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration((long) i2);
            alphaAnimation.setStartOffset((long) i3);
            if (interpolator != null) {
                alphaAnimation.setInterpolator(interpolator);
            }
            view.startAnimation(alphaAnimation);
            view.setVisibility(8);
        }
    }

    public static Bitmap b(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postScale(-1.0f, 1.0f);
        matrix.postTranslate((float) bitmap.getWidth(), 0.0f);
        try {
            Bitmap a2 = a(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap == a2) {
                return bitmap;
            }
            bitmap.recycle();
            return a2;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return bitmap;
        }
    }

    public static void m() {
        synchronized (A) {
            if (I != null) {
                I.clear();
                I = null;
            }
        }
    }

    public static byte[] a(byte[] bArr, int i2, int i3, int i4) {
        if (bArr == null) {
            e.e("Util", "cutYUV420SP, Error: data is null!");
            return null;
        }
        int i5 = i2 * i3;
        if (((float) bArr.length) < ((float) i5) * 1.5f) {
            e.e("Util", "cutYUV420SP, Error, width: " + i2 + ", height: " + i3 + ", data.length: " + bArr.length);
            return null;
        }
        int i6 = (i2 - (i2 % i4)) / i4;
        int i7 = (i3 - (i3 % i4)) / i4;
        if (i7 % 2 != 0) {
            i7++;
        }
        byte[] bArr2 = new byte[(((i6 * i7) * 3) / 2)];
        int i8 = 0;
        int i9 = 0;
        while (i8 < i7) {
            int i10 = i9;
            for (int i11 = 0; i11 < i6; i11++) {
                bArr2[i10] = bArr[(i8 * i4 * i2) + (i11 * i4)];
                i10++;
            }
            i8++;
            i9 = i10;
        }
        int i12 = 0;
        while (i12 < i7 / 2) {
            int i13 = i9;
            for (int i14 = 0; i14 < i6 / 2; i14++) {
                int i15 = (i12 * i4 * i2) + i5;
                int i16 = i14 * 2 * i4;
                bArr2[i13] = bArr[i15 + i16];
                int i17 = i13 + 1;
                bArr2[i17] = bArr[i15 + i16 + 1];
                i13 = i17 + 1;
            }
            i12++;
            i9 = i13;
        }
        return bArr2;
    }

    public static int[] a(byte[] bArr, int i2, int i3) {
        int i4 = i2;
        int i5 = i3;
        e.a("Util", "decodeYUV420SP, width: " + i4 + ", height: " + i5);
        int i6 = i4 * i5;
        int[] iArr = new int[i6];
        int i7 = 0;
        int i8 = 0;
        while (i7 < i5) {
            int i9 = 0;
            int i10 = 0;
            int i11 = ((i7 >> 1) * i4) + i6;
            int i12 = i8;
            int i13 = 0;
            while (i13 < i4) {
                int i14 = (bArr[i12] & 255) - 16;
                if (i14 < 0) {
                    i14 = 0;
                }
                if ((i13 & 1) == 0) {
                    int i15 = i11 + 1;
                    int i16 = i15 + 1;
                    i9 = (bArr[i15] & 255) - 128;
                    int i17 = i16;
                    i10 = (bArr[i11] & 255) - 128;
                    i11 = i17;
                }
                int i18 = (i14 + 10) * 1192;
                int i19 = (i10 * 1634) + i18;
                int i20 = (i18 - (i10 * 833)) - (i9 * 400);
                int i21 = i18 + (i9 * 2066);
                int i22 = 262143;
                if (i19 < 0) {
                    i19 = 0;
                } else if (i19 > 262143) {
                    i19 = 262143;
                }
                if (i20 < 0) {
                    i20 = 0;
                } else if (i20 > 262143) {
                    i20 = 262143;
                }
                if (i21 < 0) {
                    i22 = 0;
                } else if (i21 <= 262143) {
                    i22 = i21;
                }
                iArr[i12] = -16777216 | ((i19 << 6) & 16711680) | ((i20 >> 2) & 65280) | ((i22 >> 10) & 255);
                i13++;
                i12++;
            }
            i7++;
            i8 = i12;
        }
        e.a("Util", "decodeYUV420SP X");
        return iArr;
    }

    public static Bitmap a(byte[] bArr, int i2, int i3, int i4, int i5, boolean z2) {
        e.a("Util", "yuvToBitmap, width: " + i2 + ", height: " + i3 + ", orientation: " + i4 + ", scale: " + i5 + ", mirror: " + z2);
        int i6 = i3 / i5;
        if (i6 % 2 != 0) {
            i6++;
        }
        byte[] a2 = a(bArr, i2, i3, i5);
        if (a2 == null) {
            return null;
        }
        int i7 = i2 / i5;
        Bitmap a3 = a(a(a(a2, i7, i6), i7, i6, Bitmap.Config.ARGB_8888), i4, z2);
        e.a("Util", "yuvToBitmap X, bitmap width: " + a3.getWidth() + ", height: " + a3.getHeight());
        return a3;
    }

    public static Bitmap a(Bitmap bitmap, float f2) {
        Bitmap a2;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        synchronized (z) {
            if (G == null) {
                G = RenderScript.create(C);
            }
            if (H == null) {
                H = ScriptIntrinsicBlur.create(G, Element.U8_4(G));
            }
            System.currentTimeMillis();
            H.setRadius(f2);
            a2 = a(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Allocation createFromBitmap = Allocation.createFromBitmap(G, bitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(G, a2);
            H.setInput(createFromBitmap);
            H.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(a2);
            createFromBitmap.destroy();
            createFromBitmap2.destroy();
        }
        return a2;
    }

    public static void a(s sVar, String str) {
        String absolutePath = C.getExternalFilesDir(str).getAbsolutePath();
        if (new File(absolutePath).exists() || com.oppo.camera.q.a.f(absolutePath)) {
            String str2 = a(System.currentTimeMillis()) + ".png";
            File file = new File(absolutePath, str2);
            e.e("Util", "dumpAndSaveTexture, fileName: " + str2);
            a(b(sVar.d(), sVar.g(), sVar.h()), file);
            return;
        }
        e.e("Util", "dumpAndSaveTexture, mkdirs fail");
    }

    public static void a(int i2, int i3, int i4, String str) {
        String absolutePath = C.getExternalFilesDir(str).getAbsolutePath();
        if (new File(absolutePath).exists() || com.oppo.camera.q.a.f(absolutePath)) {
            String str2 = a(System.currentTimeMillis()) + ".png";
            File file = new File(absolutePath, str2);
            e.e("Util", "dumpAndSaveTexture, fileName: " + str2);
            a(b(i2, i3, i4), file);
            return;
        }
        e.e("Util", "dumpAndSaveTexture, mkdirs fail");
    }

    public static Bitmap b(int i2, int i3, int i4) {
        int[] iArr = new int[1];
        Bitmap a2 = a(i3, i4, Bitmap.Config.ARGB_8888);
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
        new FormatConverter().glReadPixelsToBitmap(a2, i3, i4, 6408, 5121);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        return a2;
    }

    private static String ar() {
        String i2 = i("ro.vendor.oplus.market.enname");
        return TextUtils.equals(i2, "") ? i("ro.vendor.oplus.market.name") : i2;
    }

    public static String n() {
        String str = t;
        if (str != null) {
            return str;
        }
        t = ar();
        if (!TextUtils.isEmpty(t)) {
            return t;
        }
        t = i("ro.oppo.market.enname");
        if (TextUtils.equals(t, "")) {
            t = i("ro.oppo.market.name");
            if (TextUtils.equals(t, "")) {
                t = Build.MODEL;
            }
        }
        return t;
    }

    public static ActivityManager.MemoryInfo e(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        try {
            activityManager.getMemoryInfo(memoryInfo);
        } catch (Exception unused) {
        }
        e.e("Util", "getMemoryInfo, mi.totalMem" + memoryInfo.totalMem + ", mi.availMem: " + memoryInfo.availMem);
        return memoryInfo;
    }

    public static boolean f(Context context) {
        return STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1 >= e(context).totalMem;
    }

    public static boolean g(Context context) {
        return 3221225472L >= e(context).totalMem;
    }

    public static void h(Context context) {
        if (g(context)) {
            d = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_LOW_MEMORY_MAX_BURST_SHOT_NUM);
        } else {
            d = 20;
        }
    }

    public static long i(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        try {
            activityManager.getMemoryInfo(memoryInfo);
        } catch (Exception unused) {
        }
        e.e("Util", "getAvailMemory, mi.availMem: " + memoryInfo.availMem);
        return memoryInfo.availMem;
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Typeface j(Context context) {
        if (v == null) {
            v = a(context, false);
        }
        return v;
    }

    public static Typeface a(Context context, boolean z2) {
        Typeface typeface;
        Typeface typeface2 = Typeface.DEFAULT;
        OplusBaseConfiguration oplusBaseConfiguration = (OplusBaseConfiguration) OplusTypeCastingHelper.typeCasting(OplusBaseConfiguration.class, context.getResources().getConfiguration());
        int i2 = (oplusBaseConfiguration.mOplusExtraConfiguration.mFontVariationSettings & 61440) >> 12;
        int i3 = oplusBaseConfiguration.mOplusExtraConfiguration.mFontVariationSettings & 4095;
        if (OplusFontUtils.isFlipFontUsed) {
            return typeface2;
        }
        int i4 = STStickerMakeupParamType.ST_STICKER_PARAM_MAKEUP_FLOAT_SCALE;
        if (i2 != 0) {
            try {
                Typeface.Builder fontVariationSettings = new Typeface.Builder("sys-sans-en").setFontVariationSettings("'wght' " + i3);
                if (!z2) {
                    i4 = 400;
                }
                typeface = fontVariationSettings.setWeight(i4).build();
            } catch (Exception e2) {
                e2.printStackTrace();
                return typeface2;
            }
        } else {
            Typeface.Builder builder = new Typeface.Builder("sys-sans-en");
            if (!z2) {
                i4 = 400;
            }
            typeface = builder.setWeight(i4).build();
        }
        return typeface;
    }

    public static Typeface b(boolean z2) {
        Typeface typeface = Typeface.DEFAULT;
        if (z2) {
            try {
                return Typeface.create("sys-sans-en", 1);
            } catch (RuntimeException unused) {
                e.d("Util", "getSansEnTypeface, Create Typeface from /system/fonts/SysSans-En-Medium.otf failed!");
                return Typeface.DEFAULT_BOLD;
            }
        } else {
            try {
                return Typeface.create("sys-sans-en", 0);
            } catch (RuntimeException unused2) {
                e.d("Util", "getSansEnTypeface, Create Typeface from /system/fonts/SysSans-En-Regular.otf failed!");
                return Typeface.DEFAULT;
            }
        }
    }

    public static void o() {
        v = null;
        w = null;
        x = null;
        y = null;
    }

    public static String a(byte[] bArr, String str, String str2) {
        e.a("Util", "saveBytesToFile, bytes: " + bArr + ", customDir: " + str + ", fileName: " + str2);
        if (bArr == null || bArr.length == 0) {
            e.e("Util", "saveBytesToJpeg, bytes is empty");
            return null;
        }
        String absolutePath = new File(C.getExternalFilesDir(str).getAbsolutePath(), str2).getAbsolutePath();
        if (com.oppo.camera.q.a.b(absolutePath, com.oppo.camera.q.a.c, bArr)) {
            return absolutePath;
        }
        return null;
    }

    public static byte[] a(File file) {
        return com.oppo.camera.q.a.d(file.getAbsolutePath());
    }

    public static boolean p() {
        return s;
    }

    public static void c(boolean z2) {
        s = z2;
    }

    public static boolean k(Context context) {
        try {
            Display a2 = com.heytap.compat.a.a.a(context);
            if (a2 == null || !com.heytap.compat.e.a.a(a2.getDisplayId())) {
                return false;
            }
            return true;
        } catch (RemoteException | com.heytap.compat.d.a.a e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(Object[] objArr) {
        return objArr == null || objArr.length <= 0;
    }

    public static boolean q() {
        return k;
    }

    public static boolean a(Size size) {
        return b(b(size.getWidth(), size.getHeight()));
    }

    public static int b(int i2, int i3) {
        if (!(i2 == 0 || i3 == 0)) {
            double d2 = ((double) i2) / ((double) i3);
            if (Math.abs(d2 - 1.3333333333333333d) < 0.01d) {
                return 0;
            }
            if (Math.abs(d2 - 1.7777777777777777d) < 0.01d) {
                return 1;
            }
            if (Math.abs(d2 - 1.0d) < 0.01d) {
                return 2;
            }
            if (Math.abs(d2 - 1.5d) < 0.01d) {
                return 3;
            }
            if (Math.abs(d2 - 1.2222222222222223d) < 0.01d) {
                return 4;
            }
            if (Math.abs(d2 - G()) < 0.01d) {
                return 5;
            }
        }
        return -1;
    }

    public static boolean b(int i2) {
        return (i2 == 1 && !l) || i2 == 5;
    }

    public static boolean b(Size size) {
        return c(b(size.getWidth(), size.getHeight()));
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f4613a;

        /* renamed from: b  reason: collision with root package name */
        private SimpleDateFormat f4614b = new SimpleDateFormat(this.f4613a, Locale.US);
        private long c;
        private int d;

        public a(String str) {
            this.f4613a = str;
        }

        public void a() {
            String str = this.f4613a;
            if (str != null) {
                this.f4614b = new SimpleDateFormat(str, Locale.US);
            }
        }

        public String a(long j, boolean z) {
            String str;
            String format = this.f4614b.format(new Date(j));
            if (z) {
                if (j / 1000 != this.c / 1000) {
                    this.c = j;
                    this.d = 0;
                }
                if (this.d < 10) {
                    str = format + "_BURST00" + this.d;
                } else {
                    str = format + "_BURST0" + this.d;
                }
                if (this.d == 0) {
                    str = str + "_COVER";
                }
                String str2 = str;
                this.d++;
                return str2;
            } else if (j / 1000 == this.c / 1000) {
                this.d++;
                if (this.d < 10) {
                    return format + "_0" + this.d;
                }
                return format + "_" + this.d;
            } else {
                this.c = j;
                this.d = 0;
                return format;
            }
        }

        public String a(long j) {
            return this.f4614b.format(new Date(j));
        }
    }

    public static float b(byte[] bArr, int i2) {
        if (bArr == null) {
            return 0.0f;
        }
        return Float.intBitsToFloat((int) ((((long) bArr[i2 + 3]) << 24) | ((long) (((int) (((long) (((int) (((long) (bArr[i2 + 0] & 255)) | (((long) bArr[i2 + 1]) << 8))) & NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN)) | (((long) bArr[i2 + 2]) << 16))) & 16777215))));
    }

    public static int b(byte[] bArr, int i2, int i3) {
        if (i2 < 0 || bArr == null) {
            e.e("Util", "parseDataByteToInt, from index or data is error!");
            return 0;
        } else if (bArr.length < i3) {
            e.e("Util", "parseDataByteToInt, to index is error!");
            return 0;
        } else {
            StringBuffer stringBuffer = new StringBuffer("");
            while (i2 <= i3) {
                StringBuffer stringBuffer2 = new StringBuffer(Integer.toBinaryString(bArr[i2]));
                if (stringBuffer2.length() > 8) {
                    stringBuffer2 = new StringBuffer(stringBuffer2.substring(stringBuffer2.length() - 8));
                } else if (stringBuffer2.length() < 8) {
                    while (stringBuffer2.length() < 8) {
                        StringBuffer stringBuffer3 = new StringBuffer("0");
                        stringBuffer3.append(stringBuffer2);
                        stringBuffer2 = stringBuffer3;
                    }
                }
                stringBuffer2.append(stringBuffer);
                i2++;
                stringBuffer = stringBuffer2;
            }
            return new BigInteger(stringBuffer.toString(), 2).intValue();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001a, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001b, code lost:
        r4 = r3;
        r3 = r2;
        r2 = r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.media.ExifInterface a(byte[] r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x002d }
            r1.<init>(r5)     // Catch:{ IOException -> 0x002d }
            android.media.ExifInterface r2 = new android.media.ExifInterface     // Catch:{ Throwable -> 0x0018, all -> 0x0015 }
            r2.<init>(r1)     // Catch:{ Throwable -> 0x0018, all -> 0x0015 }
            r1.close()     // Catch:{ IOException -> 0x0012 }
            goto L_0x004a
        L_0x0012:
            r0 = move-exception
            r1 = r0
            goto L_0x002f
        L_0x0015:
            r2 = move-exception
            r3 = r0
            goto L_0x001e
        L_0x0018:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001a }
        L_0x001a:
            r3 = move-exception
            r4 = r3
            r3 = r2
            r2 = r4
        L_0x001e:
            if (r3 == 0) goto L_0x0029
            r1.close()     // Catch:{ Throwable -> 0x0024 }
            goto L_0x002c
        L_0x0024:
            r1 = move-exception
            r3.addSuppressed(r1)     // Catch:{ IOException -> 0x002d }
            goto L_0x002c
        L_0x0029:
            r1.close()     // Catch:{ IOException -> 0x002d }
        L_0x002c:
            throw r2     // Catch:{ IOException -> 0x002d }
        L_0x002d:
            r1 = move-exception
            r2 = r0
        L_0x002f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "getExif error, jpeg: "
            r0.append(r3)
            if (r5 != 0) goto L_0x003d
            r5 = -1
            goto L_0x003e
        L_0x003d:
            int r5 = r5.length
        L_0x003e:
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "Util"
            com.oppo.camera.e.d(r0, r5, r1)
        L_0x004a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.util.Util.a(byte[]):android.media.ExifInterface");
    }

    public static ExifInterface b(String str) {
        try {
            return new ExifInterface(str);
        } catch (IOException e2) {
            e.d("Util", "getExif error, path: " + str, e2);
            return null;
        }
    }

    public static Location a(ExifInterface exifInterface) {
        if (exifInterface == null) {
            return null;
        }
        float[] fArr = new float[2];
        if (!exifInterface.getLatLong(fArr)) {
            return null;
        }
        Location location = new Location(EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK);
        location.setLatitude((double) fArr[0]);
        location.setLongitude((double) fArr[1]);
        return location;
    }

    public static void r() {
        Display defaultDisplay = ((WindowManager) C.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        O = Math.max(point.x, point.y);
        N = Math.min(point.x, point.y);
    }

    public static void l(Context context) {
        Resources resources = C.getResources();
        r();
        double d2 = ((double) O) / ((double) N);
        if (d2 > 1.7777777777777777d) {
            l = true;
        }
        P = resources.getDimensionPixelSize(R.dimen.top_bar_layout_height);
        Q = resources.getDimensionPixelSize(R.dimen.menu_panel_layout_height);
        R = (C() - Q) - resources.getDimensionPixelSize(R.dimen.preview_layout_4_3_height);
        if (k(context)) {
            X = s();
        }
        U = resources.getDimensionPixelSize(R.dimen.head_line_height);
        if (l) {
            S = resources.getDimensionPixelSize(R.dimen.control_panel_button_height);
            int i2 = Q;
            T = i2;
            V = i2;
            W = X;
        } else {
            S = resources.getDimensionPixelSize(R.dimen.control_panel_button_height);
            T = resources.getDimensionPixelSize(R.dimen.menu_tool_item_size);
        }
        e.b("Util", "initMenuControlPanelHeight, sbLongScreen: " + l + ", sSettingMenuPanelHeight: " + Q + ", sControlPanelHeight: " + R + ", sControlPanelButtonHeight: " + S + ", sSettingMenuItemHeight: " + T + ", sPreviewMarginTop: " + V + ", sHeadLineHeight: " + U + ", sNavigationBarHeight: " + X + ", ratio: " + d2);
    }

    public static int s() {
        int identifier = C.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return C.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int t() {
        int i2 = R;
        return (((O - N) - i2) - P) / 2;
    }

    public static int u() {
        return Q;
    }

    public static int v() {
        return P;
    }

    public static int w() {
        return R;
    }

    public static int x() {
        return S;
    }

    public static int y() {
        return T;
    }

    public static int z() {
        return V;
    }

    public static int A() {
        return W;
    }

    public static int B() {
        return U;
    }

    public static int C() {
        return O;
    }

    public static int D() {
        return C() - X;
    }

    public static int E() {
        return N;
    }

    public static boolean F() {
        return l;
    }

    public static double G() {
        return ((double) O) / ((double) N);
    }

    public static int H() {
        return Math.abs((((double) O) / ((double) N)) - 1.7777777777777777d) < 0.01d ? 1 : 5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0066, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0067, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0068, code lost:
        if (r2 <= 8) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006a, code lost:
        r3 = a(r11, r1, 4, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0071, code lost:
        if (r3 == 1229531648) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0076, code lost:
        if (r3 == 1296891946) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0078, code lost:
        com.oppo.camera.e.e("Util", "getOrientation, Invalid byte order");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007d, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x007e, code lost:
        if (r3 != 1229531648) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0080, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0082, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0083, code lost:
        r4 = a(r11, r1 + 4, 4, r3) + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008c, code lost:
        if (r4 < 10) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x008e, code lost:
        if (r4 <= r2) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0091, code lost:
        r1 = r1 + r4;
        r2 = r2 - r4;
        r4 = a(r11, r1 - 2, 2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0099, code lost:
        r9 = r4 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x009b, code lost:
        if (r4 <= 0) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x009f, code lost:
        if (r2 < 12) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a7, code lost:
        if (a(r11, r1, 2, r3) != 274) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a9, code lost:
        r11 = a(r11, r1 + 8, 2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ae, code lost:
        if (r11 == 1) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00b1, code lost:
        if (r11 == 3) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00b4, code lost:
        if (r11 == 6) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00b6, code lost:
        if (r11 == 8) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00b8, code lost:
        com.oppo.camera.e.c("Util", "getOrientation, Unsupported orientation");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00bd, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00be, code lost:
        return 270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00c1, code lost:
        return 90;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00c4, code lost:
        return 180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00c7, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c8, code lost:
        r1 = r1 + 12;
        r2 = r2 - 12;
        r4 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00ce, code lost:
        com.oppo.camera.e.e("Util", "getOrientation, Invalid offset");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00d3, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00d4, code lost:
        com.oppo.camera.e.c("Util", "getOrientation, Orientation not found");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00d9, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int b(byte[] r11) {
        /*
            r0 = 0
            if (r11 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = r0
        L_0x0005:
            int r2 = r1 + 3
            int r3 = r11.length
            r4 = 4
            java.lang.String r5 = "Util"
            r6 = 1
            r7 = 8
            r8 = 2
            if (r2 >= r3) goto L_0x0067
            int r2 = r1 + 1
            byte r1 = r11[r1]
            r3 = 255(0xff, float:3.57E-43)
            r1 = r1 & r3
            if (r1 != r3) goto L_0x0066
            byte r1 = r11[r2]
            r1 = r1 & r3
            if (r1 != r3) goto L_0x0020
            goto L_0x0064
        L_0x0020:
            int r2 = r2 + 1
            r3 = 216(0xd8, float:3.03E-43)
            if (r1 == r3) goto L_0x0064
            if (r1 != r6) goto L_0x0029
            goto L_0x0064
        L_0x0029:
            r3 = 217(0xd9, float:3.04E-43)
            if (r1 == r3) goto L_0x0066
            r3 = 218(0xda, float:3.05E-43)
            if (r1 != r3) goto L_0x0032
            goto L_0x0066
        L_0x0032:
            int r3 = a((byte[]) r11, (int) r2, (int) r8, (boolean) r0)
            if (r3 < r8) goto L_0x005e
            int r9 = r2 + r3
            int r10 = r11.length
            if (r9 <= r10) goto L_0x003e
            goto L_0x005e
        L_0x003e:
            r10 = 225(0xe1, float:3.15E-43)
            if (r1 != r10) goto L_0x005c
            if (r3 < r7) goto L_0x005c
            int r1 = r2 + 2
            int r1 = a((byte[]) r11, (int) r1, (int) r4, (boolean) r0)
            r10 = 1165519206(0x45786966, float:3974.5874)
            if (r1 != r10) goto L_0x005c
            int r1 = r2 + 6
            int r1 = a((byte[]) r11, (int) r1, (int) r8, (boolean) r0)
            if (r1 != 0) goto L_0x005c
            int r1 = r2 + 8
            int r2 = r3 + -8
            goto L_0x0068
        L_0x005c:
            r1 = r9
            goto L_0x0005
        L_0x005e:
            java.lang.String r11 = "getOrientation, Invalid length"
            com.oppo.camera.e.e(r5, r11)
            return r0
        L_0x0064:
            r1 = r2
            goto L_0x0005
        L_0x0066:
            r1 = r2
        L_0x0067:
            r2 = r0
        L_0x0068:
            if (r2 <= r7) goto L_0x00d4
            int r3 = a((byte[]) r11, (int) r1, (int) r4, (boolean) r0)
            r9 = 1229531648(0x49492a00, float:823968.0)
            if (r3 == r9) goto L_0x007e
            r10 = 1296891946(0x4d4d002a, float:2.14958752E8)
            if (r3 == r10) goto L_0x007e
            java.lang.String r11 = "getOrientation, Invalid byte order"
            com.oppo.camera.e.e(r5, r11)
            return r0
        L_0x007e:
            if (r3 != r9) goto L_0x0082
            r3 = r6
            goto L_0x0083
        L_0x0082:
            r3 = r0
        L_0x0083:
            int r9 = r1 + 4
            int r4 = a((byte[]) r11, (int) r9, (int) r4, (boolean) r3)
            int r4 = r4 + r8
            r9 = 10
            if (r4 < r9) goto L_0x00ce
            if (r4 <= r2) goto L_0x0091
            goto L_0x00ce
        L_0x0091:
            int r1 = r1 + r4
            int r2 = r2 - r4
            int r4 = r1 + -2
            int r4 = a((byte[]) r11, (int) r4, (int) r8, (boolean) r3)
        L_0x0099:
            int r9 = r4 + -1
            if (r4 <= 0) goto L_0x00d4
            r4 = 12
            if (r2 < r4) goto L_0x00d4
            int r4 = a((byte[]) r11, (int) r1, (int) r8, (boolean) r3)
            r10 = 274(0x112, float:3.84E-43)
            if (r4 != r10) goto L_0x00c8
            int r1 = r1 + r7
            int r11 = a((byte[]) r11, (int) r1, (int) r8, (boolean) r3)
            if (r11 == r6) goto L_0x00c7
            r1 = 3
            if (r11 == r1) goto L_0x00c4
            r1 = 6
            if (r11 == r1) goto L_0x00c1
            if (r11 == r7) goto L_0x00be
            java.lang.String r11 = "getOrientation, Unsupported orientation"
            com.oppo.camera.e.c(r5, r11)
            return r0
        L_0x00be:
            r11 = 270(0x10e, float:3.78E-43)
            return r11
        L_0x00c1:
            r11 = 90
            return r11
        L_0x00c4:
            r11 = 180(0xb4, float:2.52E-43)
            return r11
        L_0x00c7:
            return r0
        L_0x00c8:
            int r1 = r1 + 12
            int r2 = r2 + -12
            r4 = r9
            goto L_0x0099
        L_0x00ce:
            java.lang.String r11 = "getOrientation, Invalid offset"
            com.oppo.camera.e.e(r5, r11)
            return r0
        L_0x00d4:
            java.lang.String r11 = "getOrientation, Orientation not found"
            com.oppo.camera.e.c(r5, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.util.Util.b(byte[]):int");
    }

    private static int a(byte[] bArr, int i2, int i3, boolean z2) {
        int i4;
        if (z2) {
            i2 += i3 - 1;
            i4 = -1;
        } else {
            i4 = 1;
        }
        byte b2 = 0;
        while (true) {
            int i5 = i3 - 1;
            if (i3 <= 0) {
                return b2;
            }
            b2 = (bArr[i2] & 255) | (b2 << 8);
            i2 += i4;
            i3 = i5;
        }
    }

    public static byte[] c(String str) {
        e.a("Util", "getThumbnail, filepath: " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            if (exifInterface.hasThumbnail()) {
                return exifInterface.getThumbnail();
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int a(int i2, int i3, int i4, int i5) {
        double min = Math.min(((double) i2) / ((double) i4), ((double) i3) / ((double) i5));
        float f2 = 1.0f;
        while (true) {
            float f3 = 2.0f * f2;
            if (((double) f3) > min) {
                return (int) f2;
            }
            f2 = f3;
        }
    }

    public static int I() {
        return X;
    }

    public static boolean J() {
        int i2 = Settings.Secure.getInt(C.getContentResolver(), "hide_navigationbar_enable", 0);
        return (2 == i2 || 3 == i2) ? false : true;
    }

    public static Address a(Context context, Location location) {
        e.a("Util", "getAddressFromLocation");
        Address address = null;
        if (!(location == null || context == null)) {
            try {
                List<Address> fromLocation = new Geocoder(context).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                if (fromLocation != null && fromLocation.size() > 0) {
                    address = fromLocation.get(0);
                }
            } catch (Exception e2) {
                e.e("Util", "getAddressFromLocation, Error: " + e2.getMessage().toString());
            }
            if (address != null) {
                address.setLatitude(location.getLatitude());
                address.setLongitude(location.getLongitude());
            }
        }
        return address;
    }

    public static boolean K() {
        try {
            return UserHandleNative.myUserId() == 0;
        } catch (com.heytap.compat.d.a.a e2) {
            e.e("Util", "getCurrentUser Exception " + e2);
            return true;
        }
    }

    public static void L() {
        aa = ActivityManager.isUserAMonkey();
        try {
            ab = com.heytap.compat.os.b.a("oplus.autotest.monkeyRunning", false);
        } catch (com.heytap.compat.d.a.a e2) {
            e2.printStackTrace();
        }
    }

    public static boolean M() {
        return aa || ab;
    }

    public static boolean N() {
        return aa;
    }

    public static boolean O() {
        return ab;
    }

    public static boolean P() {
        return c("sys.oplus.otest.monkey.enable", false);
    }

    public static boolean Q() {
        return h("oplus.software.display.screen_heteromorphism");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0035 A[SYNTHETIC, Splitter:B:19:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0040 A[SYNTHETIC, Splitter:B:26:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String d(java.lang.String r6) {
        /*
            java.lang.String r0 = "getAssertData, close stream failed!"
            java.lang.String r1 = "Util"
            r2 = 0
            android.content.Context r3 = C     // Catch:{ IOException -> 0x002e, all -> 0x0029 }
            android.content.res.AssetManager r3 = r3.getAssets()     // Catch:{ IOException -> 0x002e, all -> 0x0029 }
            java.io.InputStream r6 = r3.open(r6)     // Catch:{ IOException -> 0x002e, all -> 0x0029 }
            int r3 = r6.available()     // Catch:{ IOException -> 0x0027 }
            byte[] r3 = new byte[r3]     // Catch:{ IOException -> 0x0027 }
            r6.read(r3)     // Catch:{ IOException -> 0x0027 }
            java.lang.String r4 = new java.lang.String     // Catch:{ IOException -> 0x0027 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0027 }
            if (r6 == 0) goto L_0x0026
            r6.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0026
        L_0x0023:
            com.oppo.camera.e.e(r1, r0)
        L_0x0026:
            return r4
        L_0x0027:
            r3 = move-exception
            goto L_0x0030
        L_0x0029:
            r6 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
            goto L_0x003e
        L_0x002e:
            r3 = move-exception
            r6 = r2
        L_0x0030:
            r3.printStackTrace()     // Catch:{ all -> 0x003d }
            if (r6 == 0) goto L_0x003c
            r6.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x003c
        L_0x0039:
            com.oppo.camera.e.e(r1, r0)
        L_0x003c:
            return r2
        L_0x003d:
            r2 = move-exception
        L_0x003e:
            if (r6 == 0) goto L_0x0047
            r6.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0047
        L_0x0044:
            com.oppo.camera.e.e(r1, r0)
        L_0x0047:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.util.Util.d(java.lang.String):java.lang.String");
    }

    public static boolean S() {
        return af;
    }

    public static boolean T() {
        return af;
    }

    public static boolean c(int i2, int i3) {
        return Q() && i2 != i3 && (i2 == 1 || i3 == 1);
    }

    public static byte[] a(Image image, int i2) {
        return a(image, i2, (byte[]) null);
    }

    public static byte[] a(Image image, int i2, byte[] bArr) {
        if (image == null || image.getFormat() != 35) {
            e.e("Util", "getYuvDataWithoutPadding, only support YUV_420_888");
            return null;
        }
        int width = image.getWidth();
        int height = image.getHeight();
        int format = image.getFormat();
        Rect cropRect = image.getCropRect();
        int width2 = ((cropRect.width() * cropRect.height()) * ImageFormat.getBitsPerPixel(format)) / 8;
        if (bArr == null || (bArr != null && bArr.length < width2)) {
            bArr = new byte[width2];
        }
        Image.Plane[] planes = image.getPlanes();
        int i3 = 0;
        ByteBuffer buffer = planes[0].getBuffer();
        ByteBuffer buffer2 = planes[1].getBuffer();
        if (17 == i2) {
            buffer2 = planes[2].getBuffer();
        }
        if (image.getPlanes()[0].getRowStride() != image.getWidth()) {
            int rowStride = image.getPlanes()[0].getRowStride() - width;
            int i4 = 0;
            int i5 = 0;
            while (i4 < height) {
                buffer.get(bArr, i5, width);
                if (i4 != height - 1) {
                    buffer.position(buffer.position() + rowStride);
                }
                i4++;
                i5 += width;
            }
            while (true) {
                int i6 = height / 2;
                if (i3 >= i6) {
                    break;
                }
                if (i3 != i6 - 1) {
                    buffer2.get(bArr, i5, width);
                    buffer2.position(buffer2.position() + rowStride);
                } else {
                    buffer2.get(bArr, i5, width - 1);
                }
                i3++;
                i5 += width;
            }
        } else {
            buffer.get(bArr, 0, buffer.remaining());
            buffer2.get(bArr, buffer.position(), buffer2.remaining());
        }
        return bArr;
    }

    public static boolean a(List<Size> list, Size size) {
        if (!(list == null || size == null)) {
            for (Size next : list) {
                if (next != null && size.getWidth() == next.getWidth() && size.getHeight() == next.getHeight()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static float f(int i2) {
        return (float) C.getResources().getDimensionPixelSize(i2);
    }

    public static boolean a(final View view, final int i2, int i3, boolean z2, boolean z3, final Animation.AnimationListener animationListener) {
        if (view == null) {
            e.a("Util", "setViewVisibilityWithAnimation, view: " + view);
            return false;
        }
        int c2 = c(view);
        if (c2 == i2) {
            e.a("Util", "setViewVisibilityWithAnimation, viewVisibilityOrAnimationTo is same as visibility (" + i2 + ")");
            return false;
        } else if ((8 == i2 && 4 == c2) || (4 == i2 && 8 == c2)) {
            e.a("Util", "setViewVisibilityWithAnimation, visibility: " + i2 + ", viewVisibilityOrAnimationTo: " + c2);
            return false;
        } else {
            if (view.getAnimation() != null && !view.getAnimation().hasEnded()) {
                if (z2) {
                    view.clearAnimation();
                } else {
                    e.a("Util", "setViewVisibilityWithAnimation, view had animation but not cancel");
                    return false;
                }
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), i3);
            if (loadAnimation == null) {
                e.a("Util", "setViewVisibilityWithAnimation, animation: " + loadAnimation);
                return false;
            }
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationStart(Animation animation) {
                    Animation.AnimationListener animationListener = animationListener;
                    if (animationListener != null) {
                        animationListener.onAnimationStart(animation);
                        return;
                    }
                    int i = i2;
                    if (i == 0) {
                        view.setVisibility(i);
                    }
                }

                public void onAnimationEnd(Animation animation) {
                    Animation.AnimationListener animationListener = animationListener;
                    if (animationListener != null) {
                        animationListener.onAnimationEnd(animation);
                        return;
                    }
                    int i = i2;
                    if (i != 0) {
                        view.setVisibility(i);
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                    Animation.AnimationListener animationListener = animationListener;
                    if (animationListener != null) {
                        animationListener.onAnimationRepeat(animation);
                    }
                }
            });
            view.setTag(R.id.view_tag_key_animation_visibility, Integer.valueOf(i2));
            view.startAnimation(loadAnimation);
            return true;
        }
    }

    private static int c(View view) {
        Animation animation = view.getAnimation();
        if (animation == null || (animation.hasStarted() && animation.hasEnded())) {
            return view.getVisibility();
        }
        Object tag = view.getTag(R.id.view_tag_key_animation_visibility);
        e.a("Util", "getViewVisibilityOrAnimationTo, visibilityObj: " + tag);
        return tag == null ? view.getVisibility() : ((Integer) tag).intValue();
    }

    public static Context m(Context context) {
        if (Build.VERSION.SDK_INT > 23) {
            Configuration configuration = context.getResources().getConfiguration();
            if (f4604b == 0) {
                f4604b = configuration.densityDpi;
            }
            configuration.densityDpi = f4603a;
            e.b("Util", "setDefaultDisplay, config sDefaultDensity: " + f4603a + ", sysDensityDpi: " + f4604b);
            context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
        }
        return context;
    }

    public static Context n(Context context) {
        if (Build.VERSION.SDK_INT > 23) {
            Configuration configuration = context.getResources().getConfiguration();
            if (f4604b != 0) {
                e.b("Util", "followSystemDisplay, densityDpi: " + configuration.densityDpi + " -> " + f4604b);
                configuration.densityDpi = f4604b;
            }
            if (0.0f != c) {
                e.b("Util", "followSystemDisplay, fontScale: " + configuration.fontScale + " -> " + c);
                configuration.fontScale = c;
            }
            context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
        }
        return context;
    }

    public static Bitmap a(int i2, int i3, Bitmap.Config config) {
        return c(Bitmap.createBitmap(i2, i3, config));
    }

    public static Bitmap a(Bitmap bitmap, int i2, int i3, int i4, int i5, Matrix matrix, boolean z2) {
        return c(Bitmap.createBitmap(bitmap, i2, i3, i4, i5, matrix, z2));
    }

    public static Bitmap a(int[] iArr, int i2, int i3, Bitmap.Config config) {
        return c(Bitmap.createBitmap(iArr, i2, i3, config));
    }

    private static Bitmap c(Bitmap bitmap) {
        bitmap.setDensity(f4603a);
        return bitmap;
    }

    public static BitmapDrawable a(Context context, Bitmap bitmap) {
        context.getResources().getDisplayMetrics().densityDpi = f4603a;
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public static Bitmap b(Bitmap bitmap, float f2) {
        if (f2 <= 0.0f || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f2);
        try {
            return a(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static double a(Context context, Size size) {
        if (size != null) {
            return (double) (((float) (size.getWidth() * size.getHeight())) / 1000000.0f);
        }
        return 0.0d;
    }

    public static boolean U() {
        return r;
    }

    public static synchronized boolean V() {
        synchronized (Util.class) {
            if (ad != null) {
                boolean booleanValue = ad.booleanValue();
                return booleanValue;
            }
            List<String> supportedList = CameraConfig.getSupportedList("pref_video_size_key", 0);
            if (supportedList != null) {
                if (supportedList.contains("video_size_4kuhd")) {
                    ad = Boolean.valueOf(e(3840, 2160));
                } else if (supportedList.contains("video_size_1080p")) {
                    ad = Boolean.valueOf(e(1920, 1080));
                } else if (supportedList.contains("video_size_720p")) {
                    ad = Boolean.valueOf(e(1280, 720));
                }
            }
            if (ad == null) {
                ad = false;
            }
            boolean booleanValue2 = ad.booleanValue();
            return booleanValue2;
        }
    }

    private static boolean e(int i2, int i3) {
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
        boolean z2 = false;
        if (codecInfos != null) {
            boolean z3 = false;
            for (MediaCodecInfo mediaCodecInfo : codecInfos) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                if (supportedTypes != null && mediaCodecInfo.isEncoder()) {
                    int length = supportedTypes.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            break;
                        }
                        String str = supportedTypes[i4];
                        if ("video/hevc".equals(str) && (capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str)) != null && capabilitiesForType.getVideoCapabilities() != null && capabilitiesForType.getVideoCapabilities().isSizeSupported(i2, i3)) {
                            z3 = true;
                            break;
                        }
                        i4++;
                    }
                }
            }
            z2 = z3;
        }
        e.a("Util", "isSupportH265Encoder, width: " + i2 + ", height: " + i3 + ", support: " + z2);
        return z2;
    }

    public static boolean W() {
        if (AlgoSwitchConfig.getSupportCaptureAlgo(ApsConstant.CAPTURE_MODE_NIGHT, 1, ParameterKeys.ALGO_NAME_FRONT_PORTRAIT_SUPERNIGHT) || CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_YUV_NIGHT)) {
            return true;
        }
        return false;
    }

    public static boolean X() {
        return AlgoSwitchConfig.getSupportCaptureAlgo(ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION, 1, ParameterKeys.ALGO_NAME_SUPERPHOTO);
    }

    public static boolean o(Context context) {
        boolean z2 = false;
        if (context == null) {
            return false;
        }
        try {
            z2 = context.getPackageManager().getPackageInfo("com.coloros.gallery3d", 128).applicationInfo.metaData.getBoolean("isSupportAIIDPhoto");
            e.c("Util", "isGallerySupportIdPhoto, support: " + z2);
            return z2;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return z2;
        }
    }

    public static boolean p(Context context) {
        if (B == null) {
            B = (LocationManager) context.getApplicationContext().getSystemService(CameraStatisticsUtil.PORTRAIT_LOCATION);
        }
        boolean isLocationEnabled = B.isLocationEnabled();
        boolean isProviderEnabled = B.isProviderEnabled(EnterExitDcsMsgData.STATEMENT_TYPE_NETWORK);
        e.b("Util", "getLocationAvailable, locationAvailable: " + isLocationEnabled + ", netAvailable: " + isProviderEnabled);
        return isLocationEnabled || isProviderEnabled;
    }

    public static String Y() {
        if (w == null) {
            try {
                w = com.heytap.compat.os.b.a("ro.oppo.version");
            } catch (com.heytap.compat.d.a.a e2) {
                e2.printStackTrace();
            }
        }
        return w;
    }

    public static String Z() {
        if (x == null) {
            try {
                x = com.heytap.compat.os.b.a("persist.sys.oppo.region");
            } catch (com.heytap.compat.d.a.a e2) {
                e2.printStackTrace();
            }
        }
        return x;
    }

    public static String aa() {
        if (y == null) {
            try {
                y = com.heytap.compat.os.b.a("persist.sys.locale");
            } catch (com.heytap.compat.d.a.a e2) {
                e2.printStackTrace();
            }
        }
        return y;
    }

    public static boolean a(String[] strArr, String str) {
        if (strArr != null) {
            for (String str2 : strArr) {
                if (str2 != null && str2.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static byte[] e(long j2) {
        byte[] bArr = new byte[g];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = new Long(255 & j2).byteValue();
            j2 >>= g;
        }
        return bArr;
    }

    public static byte[] g(int i2) {
        byte[] bArr = new byte[f];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr[i3] = new Integer(i2 & 255).byteValue();
            i2 >>= g;
        }
        return bArr;
    }

    private static boolean b(String str, String str2) {
        String[] configStringArrayValue;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (configStringArrayValue = CameraConfig.getConfigStringArrayValue(str2)) == null || configStringArrayValue.length <= 0) {
            return false;
        }
        for (String equals : configStringArrayValue) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str, boolean z2) {
        return b(str, z2 ? ConfigDataBase.KEY_NONE_SAT_FRONT_MODE : ConfigDataBase.KEY_NONE_SAT_REAR_MODE);
    }

    public static boolean b(String str, boolean z2) {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_WIDE_ANGLE_SUPPORT) && a(str, z2);
    }

    public static boolean e(String str) {
        return b(str, ConfigDataBase.KEY_PROFESSIONAL_RAW_CAMERA_TYPE_SUPPORT);
    }

    public static int[] a(int[] iArr) {
        if (iArr == null || iArr.length != 8) {
            return iArr;
        }
        return new int[]{iArr[0], iArr[1], iArr[5], iArr[4], iArr[2], iArr[3], iArr[6], iArr[7]};
    }

    public static Handler ab() {
        if (D == null) {
            D = new Handler(Looper.getMainLooper());
        }
        return D;
    }

    public static int b(int... iArr) {
        if (iArr == null) {
            return 0;
        }
        int i2 = 1;
        for (int i3 : iArr) {
            i2 = ((i2 << 5) - i2) ^ i3;
        }
        return i2;
    }

    public static boolean b(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
        } catch (Exception e2) {
            e.d("Util", "isPackageExist, packageName: " + str + ", e: ", e2);
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            return true;
        }
        return false;
    }

    public static <K, V> boolean a(Map<K, V> map) {
        return map == null || map.size() <= 0;
    }

    public static <K, V> boolean b(Map<K, V> map) {
        return !a(map);
    }

    public static void h(int i2) {
        if (com.oppo.camera.f.a.c(i2) && ad()) {
            e.b("Util", "broadcastFrontCameraOpened");
            a((Runnable) new Runnable() {
                public void run() {
                    Util.C.sendBroadcast(new Intent("oppo.intent.action.start.PINHOLE"));
                }
            });
        }
    }

    public static void i(int i2) {
        if (com.oppo.camera.f.a.c(i2) && ad()) {
            e.b("Util", "broadcastFrontCameraClosed");
            a((Runnable) new Runnable() {
                public void run() {
                    Util.C.sendBroadcast(new Intent("oppo.intent.action.stop.PINHOLE"));
                }
            });
        }
    }

    public static String ac() {
        try {
            return com.heytap.compat.os.b.a("ro.oppo.screenhole.positon", "");
        } catch (com.heytap.compat.d.a.a e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean ad() {
        return !TextUtils.isEmpty(ac());
    }

    public static Rect f(String str) {
        if (ad()) {
            try {
                String[] split = str.split(":");
                String[] split2 = split[0].split(",");
                String[] split3 = split[1].split(",");
                return new Rect(Integer.parseInt(split2[0]), Integer.parseInt(split2[1]), Integer.parseInt(split3[0]), Integer.parseInt(split3[1]));
            } catch (Exception unused) {
                e.e("Util", "getScreenHolePosition, hole position is incorrect");
            }
        }
        return null;
    }

    public static int d(int i2, int i3) {
        return (((i2 + i3) - 1) / i3) * i3;
    }

    public static String ae() {
        return String.valueOf(Y);
    }

    public static String af() {
        return String.valueOf(Z);
    }

    public static boolean a(Uri uri) {
        return uri != null && !uri.toString().contains("/video/media");
    }

    public static boolean a(Set set, Set set2) {
        if (set == null || set.isEmpty()) {
            if (set2 == null || set2.isEmpty()) {
                return true;
            }
            return false;
        } else if (set2 == null || set2.isEmpty()) {
            return false;
        } else {
            if (set.size() < set2.size()) {
                Set set3 = set2;
                set2 = set;
                set = set3;
            }
            HashSet hashSet = new HashSet();
            hashSet.addAll(set);
            hashSet.removeAll(set2);
            return hashSet.isEmpty();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0065 A[SYNTHETIC, Splitter:B:28:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006a A[Catch:{ IOException -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0085 A[SYNTHETIC, Splitter:B:36:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008d A[Catch:{ IOException -> 0x0089 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int ag() {
        /*
            java.lang.String r0 = "Util"
            java.lang.String r1 = "getTotalRam"
            com.oppo.camera.e.b(r0, r1)
            java.lang.String r1 = "/proc/meminfo"
            r2 = 0
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ Exception -> 0x005c, all -> 0x0058 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x005c, all -> 0x0058 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            r5 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r4, r5)     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            java.lang.String r5 = r1.readLine()     // Catch:{ Exception -> 0x004e }
            if (r5 == 0) goto L_0x0026
            java.lang.String r2 = "\\s+"
            java.lang.String[] r2 = r5.split(r2)     // Catch:{ Exception -> 0x004e }
            r5 = 1
            r2 = r2[r5]     // Catch:{ Exception -> 0x004e }
        L_0x0026:
            if (r2 == 0) goto L_0x0042
            java.lang.Float r5 = new java.lang.Float     // Catch:{ Exception -> 0x004e }
            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ Exception -> 0x004e }
            float r2 = r2.floatValue()     // Catch:{ Exception -> 0x004e }
            r6 = 1233125376(0x49800000, float:1048576.0)
            float r2 = r2 / r6
            r5.<init>(r2)     // Catch:{ Exception -> 0x004e }
            double r5 = r5.doubleValue()     // Catch:{ Exception -> 0x004e }
            double r2 = java.lang.Math.ceil(r5)     // Catch:{ Exception -> 0x004e }
            int r2 = (int) r2
            r3 = r2
        L_0x0042:
            r1.close()     // Catch:{ IOException -> 0x0049 }
            r4.close()     // Catch:{ IOException -> 0x0049 }
            goto L_0x006d
        L_0x0049:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x006d
        L_0x004e:
            r2 = move-exception
            goto L_0x0060
        L_0x0050:
            r0 = move-exception
            r1 = r2
            goto L_0x0083
        L_0x0053:
            r1 = move-exception
            r7 = r2
            r2 = r1
            r1 = r7
            goto L_0x0060
        L_0x0058:
            r0 = move-exception
            r1 = r2
            r4 = r1
            goto L_0x0083
        L_0x005c:
            r1 = move-exception
            r4 = r2
            r2 = r1
            r1 = r4
        L_0x0060:
            r2.printStackTrace()     // Catch:{ all -> 0x0082 }
            if (r1 == 0) goto L_0x0068
            r1.close()     // Catch:{ IOException -> 0x0049 }
        L_0x0068:
            if (r4 == 0) goto L_0x006d
            r4.close()     // Catch:{ IOException -> 0x0049 }
        L_0x006d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getTotalRam X, totalRam: "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.oppo.camera.e.b(r0, r1)
            return r3
        L_0x0082:
            r0 = move-exception
        L_0x0083:
            if (r1 == 0) goto L_0x008b
            r1.close()     // Catch:{ IOException -> 0x0089 }
            goto L_0x008b
        L_0x0089:
            r1 = move-exception
            goto L_0x0091
        L_0x008b:
            if (r4 == 0) goto L_0x0094
            r4.close()     // Catch:{ IOException -> 0x0089 }
            goto L_0x0094
        L_0x0091:
            r1.printStackTrace()
        L_0x0094:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.util.Util.ag():int");
    }

    public static void ah() {
        if (ae == null) {
            ae = new DecimalFormat();
        }
    }

    public static void ai() {
        ae = null;
    }

    public static String j(int i2) {
        DecimalFormat decimalFormat = ae;
        if (decimalFormat == null) {
            return String.valueOf(i2);
        }
        return decimalFormat.format((long) i2);
    }

    public static Image a(ImageReader imageReader) {
        try {
            return imageReader.acquireNextImage();
        } catch (IllegalStateException e2) {
            e.c("Util", "acquireNextImage, error message: " + e2.getMessage());
            return null;
        }
    }

    public static ApsCameraRequestTag a(d dVar, ImageCategory.MetaItemInfo metaItemInfo) {
        ApsCameraRequestTag apsCameraRequestTag = new ApsCameraRequestTag();
        if (!(metaItemInfo == null || metaItemInfo.get(ParameterKeys.KEY_CAMERA_ID) == null)) {
            apsCameraRequestTag.mbFrontCamera = com.oppo.camera.f.a.c(Integer.valueOf((String) metaItemInfo.get(ParameterKeys.KEY_CAMERA_ID)).intValue());
        }
        if (dVar != null) {
            apsCameraRequestTag.mbInThirdApp = dVar.s;
            apsCameraRequestTag.mCaptureDecisionResult = dVar.M;
        }
        apsCameraRequestTag.mbQcom = p();
        apsCameraRequestTag.mbPIAI = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PI_AI);
        apsCameraRequestTag.mTag = dVar;
        return apsCameraRequestTag;
    }

    public static int aj() {
        if (J()) {
            return I();
        }
        return 0;
    }

    public static int ak() {
        double a2 = a((Context) null, CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_HIGH_PICTURE_SIZE));
        e.a("Util", "getHighPictureSize, highPictureSize: " + a2);
        if (Math.abs(a2 - 48.0d) < 1.0d) {
            return 48;
        }
        if (Math.abs(a2 - 64.0d) < 1.0d) {
            return 64;
        }
        return Math.abs(a2 - 108.0d) < 1.0d ? 108 : -1;
    }

    public static boolean q(Context context) {
        L = ((DisplayManager) context.getSystemService("display")).getDisplay(0);
        Display.Mode[] supportedModes = L.getSupportedModes();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < supportedModes.length; i2++) {
            if (-1 == arrayList.indexOf(Integer.valueOf(supportedModes[i2].getPhysicalWidth()))) {
                arrayList.add(Integer.valueOf(supportedModes[i2].getPhysicalWidth()));
                e.a("Util", "supportResolutionSwitch, getPhysicalWidth: " + supportedModes[i2].getPhysicalWidth());
            }
        }
        if (1 != arrayList.size() && 1 < arrayList.size()) {
            return true;
        }
        return false;
    }

    public static boolean r(Context context) {
        if (q || context.checkCallingOrSelfPermission("android.permission.CAMERA") == 0) {
            q = true;
            return true;
        }
        e.e("Util", "checkCameraPermission not granted");
        return false;
    }

    public static float a(CaptureResult captureResult) {
        CaptureResult.Key key = c.O;
        if (key == null) {
            return 0.0f;
        }
        try {
            float[] fArr = (float[]) captureResult.get(key);
            if (fArr == null || fArr.length <= 0) {
                return 0.0f;
            }
            return fArr[0];
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    public static float k(int i2) {
        return (float) ((5.0d / Math.log10((double) v.f2936a)) * Math.log10((double) i2));
    }

    public static String g(String str) {
        if (str.startsWith("http://") || str.startsWith("https://")) {
            return str;
        }
        if (str.startsWith("HTTP://")) {
            return "http" + str.substring(4);
        } else if (str.startsWith("HTTPS://")) {
            return "https" + str.substring(5);
        } else {
            return "http://" + str;
        }
    }

    public static float a(float f2, float f3) {
        return new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Float.toString(f3))).floatValue();
    }

    public static Bitmap a(Context context, int i2) {
        Drawable a2 = androidx.core.content.a.a(context, i2);
        Bitmap createBitmap = Bitmap.createBitmap(a2.getIntrinsicWidth(), a2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        a2.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        a2.draw(canvas);
        c(createBitmap);
        return createBitmap;
    }

    public static boolean h(String str) {
        try {
            return OplusFeatureConfigManager.getInstance().hasFeature(str);
        } catch (NoSuchMethodError unused) {
            e.e("Util", "checkOplusConfigFeature fail, return default value");
            return false;
        }
    }

    public static String i(String str) {
        try {
            return OplusSystemProperties.get(str, "");
        } catch (Throwable unused) {
            e.e("Util", "getSystemProperties fail, return default value");
            return "";
        }
    }

    public static boolean c(String str, boolean z2) {
        try {
            return OplusSystemProperties.getBoolean(str, z2);
        } catch (Exception unused) {
            e.e("Util", "getSystemProperties fail, return default value");
            return z2;
        }
    }

    public static int s(Context context) {
        return com.color.support.d.c.a(context, R.attr.colorTintControlNormal, context.getColor(R.color.color_primary_light_yellow));
    }

    public static Drawable b(Context context, int i2) {
        return a(context, context.getDrawable(i2));
    }

    public static Drawable a(Context context, Drawable drawable) {
        return (drawable == null || !o.a().b(context)) ? drawable : p.a(drawable, s(context));
    }

    public static Bitmap b(Context context, Bitmap bitmap) {
        return (bitmap == null || !o.a().b(context)) ? bitmap : p.a(bitmap, s(context));
    }

    public static boolean a(Activity activity, List<String> list) {
        for (String next : list) {
            if (activity.checkSelfPermission(next) != 0) {
                e.a("Util", "checkRuntimePermission, ungrant permission: " + next);
                return false;
            }
        }
        return true;
    }

    public static boolean a(ImageReader imageReader, int i2) {
        if (imageReader == null) {
            e.e("Util", "checkImageOverflow, reader is null.");
            return true;
        }
        try {
            Field declaredField = imageReader.getClass().getDeclaredField("mAcquiredImages");
            declaredField.setAccessible(true);
            List list = (List) declaredField.get(imageReader);
            if (list == null || list.size() >= i2) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            e.d("Util", "checkImageOverflow, get acquired images error.", e2);
        }
        return true;
    }

    public static int j(String str) {
        try {
            return ((Integer) Class.forName("android.view.KeyEvent").getField(str).get((Object) null)).intValue();
        } catch (Exception e2) {
            e.e("Util", "getFingerKeyCode, exception: " + e2);
            return -1;
        }
    }

    public static boolean t(Context context) {
        return b(context, "com.heytap.market");
    }

    public static boolean c(Context context, String str) {
        return context.getPackageManager().getLaunchIntentForPackage(str) != null;
    }

    public static void u(final Context context) {
        com.oppo.camera.v.c.a().a(new Runnable() {
            public void run() {
                if (context == null) {
                    e.e("Util", "notifyAthena, activity is recycled, return.");
                    return;
                }
                try {
                    Intent intent = new Intent("oppo.intent.action.REQUEST_APP_CLEAN_RUNNING");
                    intent.setPackage("com.coloros.athena");
                    intent.putExtra(CameraStatisticsUtil.CALLER_PACKAGE, context.getPackageName());
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("com.coloros.gallery3d");
                    arrayList.add("com.oppo.gallery3d");
                    arrayList.add("com.oppo.gallery3d.provider.GalleryOpenProvider");
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList(CameraStatisticsUtil.FILTER_APP_LIST, arrayList);
                    intent.putExtras(bundle);
                    context.startService(intent);
                    e.d("Util", "notifyAthena, started service, action: oppo.intent.action.REQUEST_APP_CLEAN_RUNNING");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "notifyAthena");
    }

    public static boolean a(Context context, String str, int i2) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null && ((long) i2) <= packageInfo.getLongVersionCode()) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean v(Context context) {
        String str;
        boolean z2;
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SHOW_SOLOOP_SAME)) {
            e.e("Util", "isSoloopSupported, project config is off.");
            return false;
        }
        SharedPreferences sharedPreferences = C.getSharedPreferences("rom_update_info", 0);
        if (sharedPreferences != null) {
            str = sharedPreferences.getString("soloop_switch", "on");
            e.d("Util", "isSoloopSupported, soloopSwitch: " + str);
        } else {
            str = "on";
        }
        if (!TextUtils.equals(str, "on")) {
            e.e("Util", "isSoloopSupported, rus switch is off.");
            return false;
        }
        SharedPreferences sharedPreferences2 = C.getSharedPreferences("soloop_info", 0);
        if (sharedPreferences2 != null) {
            z2 = sharedPreferences2.getBoolean("key_market_soloop_support_jump", false);
            e.d("Util", "isSoloopSupported, isMarketSoloopSupportJump: " + z2);
        } else {
            z2 = false;
        }
        boolean a2 = a(context, "com.coloros.videoeditor", 12400);
        if (z2 || a2) {
            return true;
        }
        return false;
    }

    public static String w(Context context) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = LocaleList.getDefault().get(0);
        } else {
            locale = Locale.getDefault();
        }
        if (locale == null) {
            return "";
        }
        return locale.getLanguage() + "-" + locale.getCountry();
    }

    public static boolean al() {
        try {
            return !"0".equals(com.heytap.compat.os.b.a("vendor.camera.mem.debug.enable", "0"));
        } catch (com.heytap.compat.d.a.a e2) {
            e.d("Util", "debugApsMem error.", e2);
            return false;
        }
    }

    public static File x(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = new File(OplusUsbEnvironment.getInternalSdDirectory(context).getAbsolutePath() + File.separator + "Android" + File.separator + "data" + File.separator + context.getPackageName() + File.separator + "cache");
            if (!externalCacheDir.exists() && !externalCacheDir.mkdirs()) {
                e.e("Util", "getExternalCacheDir, cacheDir.mkdirs fail");
            }
        }
        return externalCacheDir;
    }

    public static Size a(Size[] sizeArr) {
        return (Size) Arrays.stream(sizeArr).filter($$Lambda$bdDB5qtJ9up3KI34bjHEph1ELg.INSTANCE).max($$Lambda$Util$CxHrSK9DOqNj3ZJxulYqBVJV8.INSTANCE).orElse((Object) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int a(Size size, Size size2) {
        return (size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight());
    }

    public static int f(long j2) {
        String format = new SimpleDateFormat("yyyyMMdd").format(new Date(j2));
        if (TextUtils.isEmpty(format)) {
            return 0;
        }
        return Integer.parseInt(format);
    }

    public static String y(Context context) {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TORCH_SOFT_LIGHT)) {
            return "off";
        }
        return context.getResources().getString(R.string.camera_torch_mode_default_value);
    }

    public static void a(String str, String str2) {
        String[] list;
        e.a("Util", "copySourceToTarget, sourcePath: " + str + " , targetPath: " + str2);
        if (!TextUtils.isEmpty(str) && (list = new File(str).list()) != null && list.length > 0) {
            for (String str3 : list) {
                try {
                    a((InputStream) new FileInputStream(str + File.separator + str3), str2 + File.separator + str3);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        e.a("Util", "copySourceToTarget X");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0038 A[Catch:{ IOException -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003d A[Catch:{ IOException -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x004b A[Catch:{ IOException -> 0x0054 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0050 A[Catch:{ IOException -> 0x0054 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.io.InputStream r3, java.lang.String r4) {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x002f }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x002f }
            r2.<init>(r4)     // Catch:{ Exception -> 0x002f }
            r1.<init>(r2)     // Catch:{ Exception -> 0x002f }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
        L_0x000f:
            r0 = -1
            int r2 = r3.read(r4)     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            if (r0 == r2) goto L_0x001b
            r0 = 0
            r1.write(r4, r0, r2)     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            goto L_0x000f
        L_0x001b:
            r1.flush()     // Catch:{ IOException -> 0x0041 }
            if (r3 == 0) goto L_0x0023
            r3.close()     // Catch:{ IOException -> 0x0041 }
        L_0x0023:
            r1.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0045
        L_0x0027:
            r4 = move-exception
            r0 = r1
            goto L_0x0046
        L_0x002a:
            r4 = move-exception
            r0 = r1
            goto L_0x0030
        L_0x002d:
            r4 = move-exception
            goto L_0x0046
        L_0x002f:
            r4 = move-exception
        L_0x0030:
            r4.printStackTrace()     // Catch:{ all -> 0x002d }
            r0.flush()     // Catch:{ IOException -> 0x0041 }
            if (r3 == 0) goto L_0x003b
            r3.close()     // Catch:{ IOException -> 0x0041 }
        L_0x003b:
            if (r0 == 0) goto L_0x0045
            r0.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0045:
            return
        L_0x0046:
            r0.flush()     // Catch:{ IOException -> 0x0054 }
            if (r3 == 0) goto L_0x004e
            r3.close()     // Catch:{ IOException -> 0x0054 }
        L_0x004e:
            if (r0 == 0) goto L_0x0058
            r0.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0058:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.util.Util.a(java.io.InputStream, java.lang.String):void");
    }

    public static boolean b(String[] strArr, String str) {
        if (strArr == null) {
            return false;
        }
        for (String equals : strArr) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean am() {
        e.a("Util", "requestKeyguard");
        try {
            new OplusWindowManager().requestKeyguard("unlockOrShowSecurity");
            return true;
        } catch (RemoteException | NoSuchMethodError e2) {
            e.e("Util", "requestKeyguard: " + e2.toString());
            return false;
        }
    }

    public static boolean z(Context context) {
        boolean z2 = false;
        if (context == null) {
            return false;
        }
        try {
            z2 = context.getPackageManager().getPackageInfo("com.coloros.gallery3d", 128).applicationInfo.metaData.getBoolean("isSupportDoubleExposure");
            e.c("Util", "isGallerySupportDoubleExposure, support: " + z2);
            return z2;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return z2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0032 A[SYNTHETIC, Splitter:B:18:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003e A[SYNTHETIC, Splitter:B:27:0x003e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] k(java.lang.String r5) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 102400(0x19000, float:1.43493E-40)
            byte[] r1 = new byte[r1]
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x003b, all -> 0x002e }
            r3.<init>(r5)     // Catch:{ IOException -> 0x003b, all -> 0x002e }
        L_0x0010:
            int r5 = r3.read(r1)     // Catch:{ IOException -> 0x003c, all -> 0x002c }
            r4 = -1
            if (r5 == r4) goto L_0x001c
            r4 = 0
            r0.write(r1, r4, r5)     // Catch:{ IOException -> 0x003c, all -> 0x002c }
            goto L_0x0010
        L_0x001c:
            r0.close()     // Catch:{ IOException -> 0x003c, all -> 0x002c }
            r3.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0027:
            byte[] r5 = r0.toByteArray()
            return r5
        L_0x002c:
            r5 = move-exception
            goto L_0x0030
        L_0x002e:
            r5 = move-exception
            r3 = r2
        L_0x0030:
            if (r3 == 0) goto L_0x003a
            r3.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r0 = move-exception
            r0.printStackTrace()
        L_0x003a:
            throw r5
        L_0x003b:
            r3 = r2
        L_0x003c:
            if (r3 == 0) goto L_0x0046
            r3.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0046:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.util.Util.k(java.lang.String):byte[]");
    }
}
