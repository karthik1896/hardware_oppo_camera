package mirror.android.app;

import com.heytap.reflect.RefClass;
import com.heytap.reflect.RefStaticObject;

public class NotificationManager {
    public static Class<?> TYPE = RefClass.load((Class<?>) NotificationManager.class, "android.app.NotificationManager");
    public static RefStaticObject sService;
}
