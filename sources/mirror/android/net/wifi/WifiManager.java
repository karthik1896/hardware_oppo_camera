package mirror.android.net.wifi;

import android.net.wifi.IWifiManager;
import com.heytap.reflect.RefClass;
import com.heytap.reflect.RefObject;

public class WifiManager {
    public static Class<?> TYPE = RefClass.load((Class<?>) WifiManager.class, "android.net.wifi.WifiManager");
    public static RefObject<IWifiManager> mService;
}
