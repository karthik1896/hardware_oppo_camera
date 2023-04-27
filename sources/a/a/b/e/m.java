package a.a.b.e;

import com.google.gson.Gson;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public static Gson f71a = new Gson();

    public static <T> T a(String str, Class<T> cls) {
        return f71a.fromJson(str, cls);
    }

    public static String a(Object obj) {
        return f71a.toJson(obj);
    }
}
