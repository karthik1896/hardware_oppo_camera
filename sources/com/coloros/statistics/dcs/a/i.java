package com.coloros.statistics.dcs.a;

import android.content.Context;
import com.coloros.statistics.dcs.b.h;
import com.coloros.statistics.dcs.b.j;
import com.coloros.statistics.dcs.b.m;
import com.coloros.statistics.dcs.c.b;
import com.coloros.statistics.dcs.e.d;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: StaticPeriodDataRecord */
public class i extends c {
    public static void a(Context context, h hVar) {
        b.a(context, (m) hVar);
    }

    public static void a(Context context, j jVar) {
        b.a(context, (m) jVar);
    }

    public static JSONArray a(List<com.coloros.statistics.dcs.b.i> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            try {
                for (com.coloros.statistics.dcs.b.i next : list) {
                    if (next != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("setting_key", next.a());
                        jSONObject.put("http_post_key", next.b());
                        jSONObject.put("method_name", next.c());
                        jSONObject.put("default_value", next.d());
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Exception e) {
                d.a("NearMeStatistics", (Throwable) e);
            }
        }
        return jSONArray;
    }
}
