package com.heytap.compat.e;

import android.hardware.display.DisplayManagerGlobal;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.view.IWindowManager;
import android.view.WindowManager;
import android.view.WindowManagerGlobal;
import com.heytap.compat.d.a.b;
import com.heytap.reflect.RefClass;
import com.heytap.reflect.RefMethod;
import com.heytap.reflect.RefObject;

/* compiled from: WindowManagerNative */
public class a {

    /* renamed from: com.heytap.compat.e.a$a  reason: collision with other inner class name */
    /* compiled from: WindowManagerNative */
    private static class C0065a {
        public static RefObject<Integer> DEFAULT_STATUS_BAR;
        public static RefObject<Integer> DISABLE_STATUS_BAR;
        public static RefObject<Integer> ENABLE_STATUS_BAR;
        public static RefObject<Integer> IGNORE_HOME_KEY;
        public static RefObject<Integer> IGNORE_HOME_MENU_KEY;
        public static RefObject<Integer> IGNORE_MENU_KEY;
        public static RefObject<Integer> UNSET_ANY_KEY;
        public static RefMethod<Integer> getInitialDisplayDensity;
        public static RefObject<Integer> ignoreHomeMenuKey;
        public static RefObject<Integer> isDisableStatusBar;

        private C0065a() {
        }

        static {
            RefClass.load(C0065a.class, (Class<?>) IWindowManager.class);
            RefClass.load(C0065a.class, (Class<?>) WindowManager.LayoutParams.class);
        }
    }

    public static boolean a(int i) throws com.heytap.compat.d.a.a, RemoteException {
        if (b.b()) {
            return IWindowManager.Stub.asInterface(ServiceManager.getService("window")).hasNavigationBar(i);
        }
        if (b.g()) {
            if (a(DisplayManagerGlobal.getInstance().getDisplayIds(), i)) {
                try {
                    return ((Boolean) IWindowManager.class.getDeclaredMethod("hasNavigationBar", new Class[0]).invoke(WindowManagerGlobal.getWindowManagerService(), new Object[0])).booleanValue();
                } catch (Exception e) {
                    Log.e("WindowManagerNative", e.toString());
                }
            }
            return false;
        }
        throw new com.heytap.compat.d.a.a("Not supported before L");
    }

    private static boolean a(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static int b(int i) throws com.heytap.compat.d.a.a, RemoteException {
        if (b.g()) {
            IWindowManager asInterface = IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
            return C0065a.getInitialDisplayDensity.call(asInterface, Integer.valueOf(i)).intValue();
        }
        throw new com.heytap.compat.d.a.a("Not supported before L");
    }
}
