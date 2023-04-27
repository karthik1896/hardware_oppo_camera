package com.heytap.epona.d;

import java.util.HashMap;
import java.util.Map;

/* compiled from: CallEvent */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2592a;

    public String a() {
        return "call_info";
    }

    public String b() {
        return "call_way";
    }

    public a(boolean z) {
        this.f2592a = z;
    }

    public Map<String, String> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("call", this.f2592a ? "SyncCall" : "AsyncCall");
        return hashMap;
    }
}
