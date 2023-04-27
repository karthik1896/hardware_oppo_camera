package mirror.android.app;

import com.heytap.reflect.RefClass;
import com.heytap.reflect.RefStaticObject;

public class ActivityThread {
    public static Class<?> TYPE = RefClass.load((Class<?>) ActivityThread.class, "android.app.ActivityThread");
    public static RefStaticObject<Object> sPackageManager;
}
