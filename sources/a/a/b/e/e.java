package a.a.b.e;

import android.util.Log;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final List<c> f50a = new CopyOnWriteArrayList();

    /* renamed from: b  reason: collision with root package name */
    public static final c f51b = new a();

    public class a extends c {
        public void a(int i, String str, String str2, Throwable th) {
            throw new AssertionError("Missing override for log method.");
        }

        public void a(String str, Object... objArr) {
            List a2 = e.f50a;
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                ((c) a2.get(i)).a(str, objArr);
            }
        }
    }

    public static class b extends c {

        /* renamed from: a  reason: collision with root package name */
        public static final Pattern f52a = Pattern.compile("\\$\\d+$");

        /* renamed from: b  reason: collision with root package name */
        public static final b f53b = new b();

        public final String a() {
            String a2 = super.a();
            if (a2 != null) {
                return a2;
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length > 6) {
                return a(stackTrace[6]);
            }
            throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
        }

        public String a(StackTraceElement stackTraceElement) {
            String className = stackTraceElement.getClassName();
            Matcher matcher = f52a.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            return className.substring(className.lastIndexOf(46) + 1);
        }

        public void a(int i, String str, String str2, Throwable th) {
            int min;
            if (str2.length() >= 4000) {
                int i2 = 0;
                int length = str2.length();
                while (i2 < length) {
                    int indexOf = str2.indexOf(10, i2);
                    if (indexOf == -1) {
                        indexOf = length;
                    }
                    while (true) {
                        min = Math.min(indexOf, i2 + 4000);
                        String substring = str2.substring(i2, min);
                        if (i == 7) {
                            Log.wtf(str, substring);
                        } else {
                            Log.println(i, str, substring);
                        }
                        if (min >= indexOf) {
                            break;
                        }
                        i2 = min;
                    }
                    i2 = min + 1;
                }
            } else if (i == 7) {
                Log.wtf(str, str2);
            } else {
                Log.println(i, str, str2);
            }
        }
    }

    public static abstract class c {
        public final ThreadLocal<String> c = new ThreadLocal<>();

        public String a() {
            String str = this.c.get();
            if (str != null) {
                this.c.remove();
            }
            return str;
        }

        public abstract void a(int i, String str, String str2, Throwable th);

        public final void a(int i, Throwable th, String str, Object... objArr) {
            if (str != null && str.length() == 0) {
                str = null;
            }
            if (str != null) {
                if (objArr.length > 0) {
                    str = String.format(str, objArr);
                }
                if (th != null) {
                    str = str + "\n" + Log.getStackTraceString(th);
                }
            } else if (th != null) {
                str = Log.getStackTraceString(th);
            } else {
                return;
            }
            a(i, a(), str, th);
        }

        public void a(String str, Object... objArr) {
            a(3, (Throwable) null, str, objArr);
        }
    }

    public static void a(c cVar) {
        synchronized (e.class) {
            if (cVar != null) {
                try {
                    if (cVar == f51b) {
                        throw new IllegalArgumentException("Cannot plant MyLogger into itself.");
                    } else if (!f50a.contains(cVar)) {
                        f50a.add(cVar);
                    }
                } catch (Throwable th) {
                    Class<e> cls = e.class;
                    throw th;
                }
            } else {
                throw new NullPointerException("tree == null");
            }
        }
    }

    public static void a(String str, Object... objArr) {
        f51b.a(str, objArr);
    }
}
