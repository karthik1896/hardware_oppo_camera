package mirror.android.app;

import android.content.pm.PackageManager;
import com.heytap.reflect.RefClass;
import com.heytap.reflect.RefObject;

public class ContextImpl {
    public static Class<?> TYPE = RefClass.load((Class<?>) ContextImpl.class, "android.app.ContextImpl");
    public static RefObject<PackageManager> mPackageManager;
    public static RefObject<Object[]> mServiceCache;
}
