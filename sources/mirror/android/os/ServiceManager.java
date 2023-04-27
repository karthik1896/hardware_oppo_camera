package mirror.android.os;

import android.os.IBinder;
import com.heytap.reflect.RefClass;
import com.heytap.reflect.RefStaticMethod;
import com.heytap.reflect.RefStaticObject;
import java.util.Map;

public class ServiceManager {
    public static Class<?> TYPE = RefClass.load((Class<?>) ServiceManager.class, "android.os.ServiceManager");
    public static RefStaticMethod<IBinder> getService;
    public static RefStaticObject<Map<String, IBinder>> sCache;
}
