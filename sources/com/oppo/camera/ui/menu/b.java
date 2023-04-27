package com.oppo.camera.ui.menu;

import java.util.ArrayList;
import java.util.List;

/* compiled from: OptionItemConfig */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f4065a;

    /* renamed from: b  reason: collision with root package name */
    private List<String> f4066b;

    public b() {
        this.f4065a = null;
        this.f4066b = null;
        this.f4066b = new ArrayList();
    }

    public String a() {
        return this.f4065a;
    }

    public void a(String str) {
        this.f4065a = str;
    }

    public void b(String str) {
        if (!this.f4066b.contains(str)) {
            this.f4066b.add(str);
        }
    }

    public List<String> b() {
        return this.f4066b;
    }
}
