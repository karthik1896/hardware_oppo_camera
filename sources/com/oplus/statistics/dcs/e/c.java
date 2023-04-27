package com.oplus.statistics.dcs.e;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: CastUtil */
public class c {
    public static JSONObject a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null && !map.isEmpty()) {
            try {
                for (String next : map.keySet()) {
                    jSONObject.put(next, map.get(next));
                }
            } catch (Exception e) {
                d.a("NearMeStatistics", (Throwable) e);
            }
        }
        return jSONObject;
    }
}
