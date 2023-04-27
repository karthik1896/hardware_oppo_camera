package mirror.android.app;

import com.heytap.reflect.RefClass;
import com.heytap.reflect.RefStaticObject;

public class ActivityManager {
    public static RefStaticObject IActivityManagerSingleton;
    public static Class<?> TYPE = RefClass.load((Class<?>) ActivityManager.class, "android.app.ActivityManager");
}
