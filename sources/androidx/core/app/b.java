package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: ActivityRecreator */
final class b {

    /* renamed from: a  reason: collision with root package name */
    protected static final Class<?> f575a = d();

    /* renamed from: b  reason: collision with root package name */
    protected static final Field f576b = b();
    protected static final Field c = c();
    protected static final Method d = a(f575a);
    protected static final Method e = b(f575a);
    protected static final Method f = c(f575a);
    private static final Handler g = new Handler(Looper.getMainLooper());

    static boolean a(Activity activity) {
        Object obj;
        final Application application;
        final a aVar;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (a() && f == null) {
            return false;
        } else {
            if (e == null && d == null) {
                return false;
            }
            try {
                final Object obj2 = c.get(activity);
                if (obj2 == null || (obj = f576b.get(activity)) == null) {
                    return false;
                }
                application = activity.getApplication();
                aVar = new a(activity);
                application.registerActivityLifecycleCallbacks(aVar);
                g.post(new Runnable() {
                    public void run() {
                        aVar.f583a = obj2;
                    }
                });
                if (a()) {
                    f.invoke(obj, new Object[]{obj2, null, null, 0, false, null, null, false, false});
                } else {
                    activity.recreate();
                }
                g.post(new Runnable() {
                    public void run() {
                        application.unregisterActivityLifecycleCallbacks(aVar);
                    }
                });
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    /* compiled from: ActivityRecreator */
    private static final class a implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        Object f583a;

        /* renamed from: b  reason: collision with root package name */
        private Activity f584b;
        private boolean c = false;
        private boolean d = false;
        private boolean e = false;

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStopped(Activity activity) {
        }

        a(Activity activity) {
            this.f584b = activity;
        }

        public void onActivityStarted(Activity activity) {
            if (this.f584b == activity) {
                this.c = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.d && !this.e && !this.c && b.a(this.f583a, activity)) {
                this.e = true;
                this.f583a = null;
            }
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.f584b == activity) {
                this.f584b = null;
                this.d = true;
            }
        }
    }

    protected static boolean a(Object obj, Activity activity) {
        try {
            final Object obj2 = c.get(activity);
            if (obj2 != obj) {
                return false;
            }
            final Object obj3 = f576b.get(activity);
            g.postAtFrontOfQueue(new Runnable() {
                public void run() {
                    try {
                        if (b.d != null) {
                            b.d.invoke(obj3, new Object[]{obj2, false, "AppCompat recreation"});
                            return;
                        }
                        b.e.invoke(obj3, new Object[]{obj2, false});
                    } catch (RuntimeException e) {
                        if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                            throw e;
                        }
                    } catch (Throwable th) {
                        Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    }
                }
            });
            return true;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    private static Method a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27;
    }

    private static Method c(Class<?> cls) {
        if (a() && cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, List.class, List.class, Integer.TYPE, Boolean.TYPE, Configuration.class, Configuration.class, Boolean.TYPE, Boolean.TYPE});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field c() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> d() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }
}
