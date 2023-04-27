package com.coloros.statistics.dcs.a;

import android.content.Context;
import android.text.TextUtils;
import com.coloros.statistics.dcs.b.l;
import com.coloros.statistics.dcs.b.m;
import com.coloros.statistics.dcs.c.b;
import com.coloros.statistics.dcs.d.a;
import com.coloros.statistics.dcs.e.d;
import com.coloros.statistics.dcs.e.e;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: OnEventAgent */
public class g {
    public static void a(Context context, String str, String str2) {
        a.a(context, str, str2, e.b());
    }

    public static void b(Context context, String str, String str2) {
        a(context, str, str2, e.b());
    }

    public static void a(Context context, int i, int i2, Map<String, String> map, Map<String, String> map2) {
        a(context, i, i2, e.a(), map, map2);
    }

    public static void a(Context context, int i, int i2, String str, String str2, String str3, Map<String, String> map) {
        a(context, i, i2, e.a(), str, str2, str3, map);
    }

    public static void a(Context context, String str, Map<String, String> map, String str2) {
        long b2 = e.b();
        a.a(context, str, a(str, map, e.a(b2), b2).toString(), str2);
    }

    public static void c(Context context, String str, String str2) {
        b(context, str, str2, e.b());
    }

    public static void a(Context context, String str, String str2, long j) {
        try {
            long c = a.c(context, str, str2);
            String a2 = e.a(c);
            long j2 = j - c;
            if (j2 <= 604800000) {
                if (j2 >= 0) {
                    a(context, "event", a(str, str2, 1, a2, j2));
                    a.a(context, str, str2, 0);
                    return;
                }
            }
            a.a(context, str, str2, 0);
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    public static void b(Context context, String str, String str2, long j) {
        try {
            String d = a.d(context, str, str2);
            if (!TextUtils.isEmpty(d)) {
                JSONObject jSONObject = new JSONObject(d);
                long j2 = j - jSONObject.getLong("duration");
                if (j2 > 604800000 || j2 < 0) {
                    a.a(context, str, "", str2);
                    return;
                }
                jSONObject.put("duration", j2);
                a(context, "ekv", jSONObject);
                a.a(context, str, "", str2);
            }
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    private static void a(Context context, String str, JSONObject jSONObject) {
        b.a(context, (m) new com.coloros.statistics.dcs.b.a(str, jSONObject.toString()));
    }

    public static void a(Context context, int i, int i2, String str, Map<String, String> map, Map<String, String> map2) {
        a(context, i, a(i2, str, map, map2));
    }

    public static void a(Context context, int i, int i2, String str, String str2, String str3, String str4, Map<String, String> map) {
        b(context, i, a(i2, str, str2, str3, str4, map));
    }

    private static void a(Context context, int i, JSONObject jSONObject) {
        b.a(context, (m) new com.coloros.statistics.dcs.b.e(i, jSONObject.toString()));
    }

    private static void b(Context context, int i, JSONObject jSONObject) {
        b.a(context, (m) new l(i, jSONObject.toString()));
    }

    public static JSONObject a(String str, String str2, int i, String str3, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("eventID", str);
            jSONObject.put("eventCount", i);
            jSONObject.put("eventTime", str3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("eventTag", str2);
            }
            if (j != 0) {
                jSONObject.put("duration", j);
            }
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
        return jSONObject;
    }

    public static JSONObject a(String str, Map<String, String> map, String str2, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("eventID", str);
            jSONObject.put("eventTime", str2);
            if (j > 0) {
                jSONObject.put("duration", j);
            }
            if (map != null && map.size() > 0) {
                for (String next : map.keySet()) {
                    jSONObject.put(next, map.get(next));
                }
            }
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
        return jSONObject;
    }

    public static JSONObject a(int i, String str, Map<String, String> map, Map<String, String> map2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("statID", i);
            jSONObject.put("clientTime", str);
            b(jSONObject, map);
            a(jSONObject, map2);
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
        return jSONObject;
    }

    public static JSONObject a(int i, String str, String str2, String str3, String str4, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("statID", i);
            jSONObject.put("clientTime", str);
            jSONObject.put("setID", str2);
            jSONObject.put("setValue", str3);
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("remark", str4);
            }
            a(jSONObject, map);
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
        return jSONObject;
    }

    private static void a(JSONObject jSONObject, Map<String, String> map) {
        if (map != null && map.size() != 0) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                for (String next : map.keySet()) {
                    jSONObject2.put(next, map.get(next));
                }
                String replaceAll = jSONObject2.toString().replaceAll("\"", "");
                jSONObject.put("eventInfo", replaceAll.substring(1, replaceAll.length() - 1));
            } catch (Exception e) {
                d.a("NearMeStatistics", (Throwable) e);
            }
        }
    }

    private static void b(JSONObject jSONObject, Map<String, String> map) {
        if (map != null && map.size() != 0) {
            try {
                for (String next : map.keySet()) {
                    jSONObject.put(next, map.get(next));
                }
            } catch (Exception e) {
                d.a("NearMeStatistics", (Throwable) e);
            }
        }
    }
}
