package a.a.b.e;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c {
    public static Object a(Object obj) {
        return obj instanceof JsonObject ? a((JsonObject) obj) : obj instanceof JsonArray ? a((JsonArray) obj) : obj;
    }

    public static List<Object> a(JsonArray jsonArray) {
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it = jsonArray.iterator();
        while (it.hasNext()) {
            arrayList.add(a((Object) it.next()));
        }
        return arrayList;
    }

    public static Map<String, Object> a(JsonObject jsonObject) {
        HashMap hashMap = new HashMap();
        if (jsonObject != null) {
            for (Map.Entry next : jsonObject.entrySet()) {
                hashMap.put(next.getKey(), a(next.getValue()));
            }
        }
        return hashMap;
    }

    public static Map<String, Object> a(String str) {
        return a((JsonObject) m.a(str, JsonObject.class));
    }
}
