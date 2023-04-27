package mirror.android.view;

import android.os.IInterface;
import com.heytap.reflect.RefClass;
import com.heytap.reflect.RefStaticObject;

public class WindowManagerGlobal {
    public static Class<?> TYPE = RefClass.load((Class<?>) WindowManagerGlobal.class, "android.view.WindowManagerGlobal");
    public static RefStaticObject<IInterface> sWindowManagerService;
    public static RefStaticObject<IInterface> sWindowSession;
}
