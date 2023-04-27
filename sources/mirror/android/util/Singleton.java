package mirror.android.util;

import com.heytap.reflect.RefClass;
import com.heytap.reflect.RefObject;

public class Singleton {
    public static Class<?> TYPE = RefClass.load((Class<?>) Singleton.class, "android.util.Singleton");
    public static RefObject mInstance;
}
