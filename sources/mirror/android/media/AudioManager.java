package mirror.android.media;

import android.media.IAudioService;
import com.heytap.reflect.RefClass;
import com.heytap.reflect.RefStaticMethod;
import com.heytap.reflect.RefStaticObject;

public class AudioManager {
    public static Class<?> TYPE = RefClass.load((Class<?>) AudioManager.class, "android.media.AudioManager");
    public static RefStaticMethod<IAudioService> getService;
    public static RefStaticObject sService;
}
