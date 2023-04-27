package com.coloros.statistics.dcs;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.coloros.statistics.dcs.a.b;
import com.coloros.statistics.dcs.a.e;
import com.coloros.statistics.dcs.a.g;
import com.coloros.statistics.dcs.a.h;
import com.coloros.statistics.dcs.a.i;
import com.coloros.statistics.dcs.b.c;
import com.coloros.statistics.dcs.b.j;
import com.coloros.statistics.dcs.e.d;
import com.coloros.statistics.dcs.e.f;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* compiled from: NearMeStatistics */
public class a {
    private static final String CLIENT_START = "ClientStart";
    private static final Pattern EVENTID_PATTERN = Pattern.compile("^[a-zA-Z0-9\\_\\-]{1,64}$");
    private static final String EVENT_COUNT = "eventCount";
    private static final String EVENT_DURATION = "duration";
    private static final String EVENT_ID = "eventid";
    public static final int FLAG_SEND_TO_ATOM = 2;
    public static final int FLAG_SEND_TO_DCS = 1;
    private static final String KV_EVENT = "KVEvent";
    private static final int MAX_EVENT_COUNT = 10000;
    private static final int MIN_EVENT_COUNT = 1;
    private static b mExceptionHandler;
    private static Context sApplicationContext;
    private static h sPageVisitAgent = new h();
    private static ExecutorService sSingleThreadExecutor = Executors.newSingleThreadExecutor();

    @Deprecated
    public static void onUserAction(Context context, int i) {
    }

    @Deprecated
    public static void onUserAction(Context context, int i, int i2) {
    }

    public static void init(Context context) {
        if (context == null) {
            d.c("NearMeStatistics", "SDK init failed! context is null.");
            return;
        }
        sApplicationContext = context.getApplicationContext();
        ((Application) sApplicationContext).registerActivityLifecycleCallbacks(com.coloros.statistics.dcs.c.a.a());
    }

    public static void setSessionTimeOut(Context context, int i) {
        d.a("NearMeStatistics", "setSession timeout is " + i);
        if (i > 0) {
            try {
                com.coloros.statistics.dcs.d.a.b(context, i);
            } catch (Exception e) {
                d.a("NearMeStatistics", (Throwable) e);
            }
        }
    }

    public static void setSsoID(Context context, String str) {
        d.a("NearMeStatistics", "setSsoid ssoid is " + str);
        if (TextUtils.isEmpty(str) || str.equals("null")) {
            str = "0";
        }
        try {
            com.coloros.statistics.dcs.d.a.c(context, str);
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    public static void onCommon(Context context, String str, String str2, Map<String, String> map) {
        c cVar = new c();
        cVar.d("");
        cVar.b(str);
        cVar.a(str2);
        cVar.a(map);
        onCommon(context, cVar, 1);
    }

    @Deprecated
    public static void onCommon(Context context, String str, String str2, Map<String, String> map, boolean z) {
        c cVar = new c();
        cVar.d("");
        cVar.b(str);
        cVar.a(str2);
        cVar.a(map);
        onCommon(context, cVar, 1);
    }

    public static void onCommon(Context context, String str, String str2, Map<String, String> map, int i) {
        c cVar = new c();
        cVar.d("");
        cVar.b(str);
        cVar.a(str2);
        cVar.a(map);
        onCommon(context, cVar, i);
    }

    public static void onCommon(Context context, String str, String str2, String str3, Map<String, String> map) {
        c cVar = new c();
        cVar.d(str);
        cVar.b(str2);
        cVar.a(str3);
        cVar.a(map);
        onCommon(context, cVar, 1);
    }

    public static void onCommon(Context context, String str, String str2, String str3, Map<String, String> map, boolean z) {
        c cVar = new c();
        cVar.d(str);
        cVar.b(str2);
        cVar.a(str3);
        cVar.a(map);
        onCommon(context, cVar, 1);
    }

    public static void onCommon(Context context, c cVar) {
        onCommon(context, cVar, 1);
    }

    public static void onCommon(final Context context, final c cVar, int i) {
        try {
            d.a("NearMeStatistics", "onCommon logTag is " + cVar.f() + ",eventID:" + cVar.a() + ",logmap:" + cVar.g() + ",flagSendTo:" + i);
            if (!TextUtils.isEmpty(cVar.f())) {
                if ((i & 1) == 1) {
                    sSingleThreadExecutor.execute(new Runnable() {
                        public void run() {
                            com.coloros.statistics.dcs.a.d.a(context, cVar);
                        }
                    });
                }
                if ((i & 2) == 2) {
                    sSingleThreadExecutor.execute(new Runnable() {
                        public void run() {
                            b.a(context, cVar);
                        }
                    });
                    return;
                }
                return;
            }
            d.c("Send data failed! logTag is null.");
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    public static void onStaticDataUpdate(Context context, String str, String str2, Map<String, String> map) {
        com.coloros.statistics.dcs.b.h hVar = new com.coloros.statistics.dcs.b.h();
        hVar.b(str);
        hVar.a(str2);
        hVar.a(map);
        onStaticDataUpdate(context, hVar);
    }

    public static void onStaticDataUpdate(final Context context, final com.coloros.statistics.dcs.b.h hVar) {
        try {
            d.a("NearMeStatistics", "onStaticDataUpdate logTag:" + hVar.f() + ", eventID:" + hVar.a() + ", logmap:" + hVar.g());
            if (!TextUtils.isEmpty(hVar.f())) {
                sSingleThreadExecutor.execute(new Runnable() {
                    public void run() {
                        i.a(context, hVar);
                    }
                });
            } else {
                d.c("Send data failed! logTag is null.");
            }
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    public static void onSettingKeyUpdate(Context context, String str, String str2, List<com.coloros.statistics.dcs.b.i> list) {
        j jVar = new j();
        jVar.b(str);
        jVar.a(str2);
        jVar.a(list);
        onSettingKeyUpdate(context, jVar);
    }

    public static void onSettingKeyUpdate(final Context context, final j jVar) {
        try {
            d.a("NearMeStatistics", "onSettingKeyUpdate logTag:" + jVar.f() + ", eventID:" + jVar.a() + ", keys:" + jVar.g());
            if (!TextUtils.isEmpty(jVar.f())) {
                sSingleThreadExecutor.execute(new Runnable() {
                    public void run() {
                        i.a(context, jVar);
                    }
                });
            } else {
                d.c("Send data failed! logTag is null.");
            }
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    public static boolean isSupportStaticData(Context context) {
        return f.a(context);
    }

    @Deprecated
    public static void onSpecialAppStart(Context context, int i) {
        d.a("NearMeStatistics", "onSpecialAppStart appCode:" + i);
        onCommon(context, CLIENT_START, CLIENT_START, (Map<String, String>) null, false);
    }

    public static void removeSsoID(Context context) {
        try {
            d.a("NearMeStatistics", "removeSsoID");
            com.coloros.statistics.dcs.d.a.i(context);
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    @Deprecated
    public static void onEvent(Context context, String str, String str2, int i, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put(EVENT_DURATION, String.valueOf(j));
        hashMap.put(EVENT_COUNT, String.valueOf(i));
        if (str2 == null) {
            hashMap.put(EVENT_ID, "");
        } else {
            hashMap.put(EVENT_ID, str2);
        }
        onCommon(context, KV_EVENT, str, hashMap);
    }

    @Deprecated
    public static void onEvent(Context context, String str, int i) {
        onEvent(context, str, "", i, 0);
    }

    @Deprecated
    public static void onEvent(Context context, String str, String str2, int i) {
        onEvent(context, str, str2, i, 0);
    }

    @Deprecated
    public static void onEvent(Context context, String str, String str2) {
        onEvent(context, str, str2, 1, 0);
    }

    @Deprecated
    public static void onEvent(Context context, String str) {
        onEvent(context, str, "", 1, 0);
    }

    @Deprecated
    public static void onEventStart(final Context context, final String str, final String str2) {
        try {
            d.a("NearMeStatistics", "onEventStart eventID:" + str + ",eventTag:" + str2);
            if (formatCheck(str, str2, 1)) {
                sSingleThreadExecutor.execute(new Runnable() {
                    public void run() {
                        g.a(context, str, str2);
                    }
                });
            }
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    @Deprecated
    public static void onEventStart(final Context context, final String str) {
        try {
            d.a("NearMeStatistics", "onEventStart eventID:" + str);
            if (formatCheck(str, "", 1)) {
                sSingleThreadExecutor.execute(new Runnable() {
                    public void run() {
                        g.a(context, str, "");
                    }
                });
            }
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    @Deprecated
    public static void onEventEnd(final Context context, final String str, final String str2) {
        try {
            d.a("NearMeStatistics", "onEventEnd eventID:" + str + ",eventTag:" + str2);
            if (formatCheck(str, str2, 1)) {
                sSingleThreadExecutor.execute(new Runnable() {
                    public void run() {
                        g.b(context, str, str2);
                    }
                });
            }
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    @Deprecated
    public static void onEventEnd(final Context context, final String str) {
        try {
            d.a("NearMeStatistics", "onEventEnd eventID:" + str);
            if (formatCheck(str, "", 1)) {
                sSingleThreadExecutor.execute(new Runnable() {
                    public void run() {
                        g.b(context, str, "");
                    }
                });
            }
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    @Deprecated
    public static void onKVEvent(Context context, String str, Map<String, String> map, long j) {
        if (map != null) {
            if (j > 0) {
                map.put(EVENT_DURATION, String.valueOf(j));
            } else {
                map.put(EVENT_DURATION, "0");
            }
            if (!map.containsKey(EVENT_COUNT)) {
                map.put(EVENT_COUNT, "0");
            }
            onCommon(context, KV_EVENT, str, map, false);
            return;
        }
        HashMap hashMap = new HashMap();
        if (j > 0) {
            hashMap.put(EVENT_DURATION, String.valueOf(j));
        } else {
            hashMap.put(EVENT_DURATION, "0");
        }
        hashMap.put(EVENT_COUNT, "0");
        onCommon(context, KV_EVENT, str, (Map<String, String>) hashMap, false);
    }

    @Deprecated
    public static void onKVEvent(Context context, String str, Map<String, String> map) {
        if (map != null) {
            if (!map.containsKey(EVENT_DURATION)) {
                map.put(EVENT_DURATION, "0");
            }
            if (!map.containsKey(EVENT_COUNT)) {
                map.put(EVENT_COUNT, "0");
            }
        }
        onCommon(context, KV_EVENT, str, map, false);
    }

    @Deprecated
    public static void onDynamicEvent(Context context, int i, int i2, Map<String, String> map, Map<String, String> map2) {
        try {
            d.a("NearMeStatistics", "onDynamicEvent uploadMode:" + i + ",statId:" + i2);
            final Context context2 = context;
            final int i3 = i;
            final int i4 = i2;
            final Map<String, String> map3 = map;
            final Map<String, String> map4 = map2;
            sSingleThreadExecutor.execute(new Runnable() {
                public void run() {
                    g.a(context2, i3, i4, (Map<String, String>) map3, (Map<String, String>) map4);
                }
            });
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    @Deprecated
    public static void onStaticEvent(Context context, int i, int i2, String str, String str2, String str3, Map<String, String> map) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("onStaticEvent uploadMode:");
            int i3 = i;
            sb.append(i);
            sb.append(",statId:");
            int i4 = i2;
            sb.append(i2);
            sb.append(",setId:");
            String str4 = str;
            sb.append(str);
            sb.append(",setValue:");
            String str5 = str2;
            sb.append(str2);
            sb.append(",remark:");
            sb.append(str3);
            d.a("NearMeStatistics", sb.toString());
            final Context context2 = context;
            final int i5 = i;
            final int i6 = i2;
            final String str6 = str;
            final String str7 = str2;
            final String str8 = str3;
            final Map<String, String> map2 = map;
            sSingleThreadExecutor.execute(new Runnable() {
                public void run() {
                    g.a(context2, i5, i6, str6, str7, str8, map2);
                }
            });
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    public static void onKVEventStart(final Context context, final String str, final Map<String, String> map, final String str2) {
        try {
            d.a("NearMeStatistics", "onKVEventStart eventID:" + str + ",eventTag:" + str2 + ",eventMap:" + map);
            if (formatCheck(str, str2, 1)) {
                sSingleThreadExecutor.execute(new Runnable() {
                    public void run() {
                        g.a(context, str, (Map<String, String>) map, str2);
                    }
                });
            }
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    public static void onKVEventEnd(final Context context, final String str, final String str2) {
        try {
            d.a("NearMeStatistics", "onKVEventEnd eventID:" + str + ",eventTag:" + str2);
            if (formatCheck(str, str2, 1)) {
                sSingleThreadExecutor.execute(new Runnable() {
                    public void run() {
                        g.c(context, str, str2);
                    }
                });
            }
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    public static void onKVEventStart(final Context context, final String str, final Map<String, String> map) {
        try {
            d.a("NearMeStatistics", "onKVEventStart eventID:" + str + ",eventMap:" + map);
            if (formatCheck(str, "", 1)) {
                sSingleThreadExecutor.execute(new Runnable() {
                    public void run() {
                        g.a(context, str, (Map<String, String>) map, "");
                    }
                });
            }
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    public static void onKVEventEnd(final Context context, final String str) {
        try {
            d.a("NearMeStatistics", "onKVEventEnd eventID:" + str);
            if (formatCheck(str, "", 1)) {
                sSingleThreadExecutor.execute(new Runnable() {
                    public void run() {
                        g.c(context, str, "");
                    }
                });
            }
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    public static void onPause(Context context) {
        try {
            d.a("NearMeStatistics", "onPause...");
            sPageVisitAgent.a(context);
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    public static void onResume(Context context) {
        try {
            d.a("NearMeStatistics", "onResume...");
            sPageVisitAgent.b(context);
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    public static void onError(Context context) {
        try {
            d.a("NearMeStatistics", "onError...");
            if (mExceptionHandler == null) {
                mExceptionHandler = new b(context);
                mExceptionHandler.a();
            }
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    public static void onDebug(boolean z) {
        try {
            d.a(z);
            d.a("NearMeStatistics", "onDebug (no context) sdk and dcs isDebug:" + z);
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    public static void onDebug(final Context context, final boolean z) {
        try {
            d.a(z);
            d.a("NearMeStatistics", "packageName:" + context.getPackageName() + ",isDebug:" + z + ",isDebugMode:" + d.f2557a);
            if (d.f2557a) {
                sSingleThreadExecutor.execute(new Runnable() {
                    public void run() {
                        e.a(context, z);
                    }
                });
            }
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
        }
    }

    private static boolean formatCheck(String str, String str2, int i) {
        if (str == null) {
            d.d("NearMeStatistics", "EventID is null!");
            return false;
        } else if (!EVENTID_PATTERN.matcher(str).find()) {
            d.d("NearMeStatistics", "EventID format error!");
            return false;
        } else if (str2 == null) {
            d.d("NearMeStatistics", "EventTag format error!");
            return false;
        } else if (i <= MAX_EVENT_COUNT && i >= 1) {
            return true;
        } else {
            d.d("NearMeStatistics", "EventCount format error!");
            return false;
        }
    }
}
