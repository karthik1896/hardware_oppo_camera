package com.oppo.camera.ui.menu;

import com.oppo.camera.e;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: PopUpWindowManager */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static BasicOptionItemList f4094a = null;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f4095b = false;
    private static ArrayList<e> c;

    public static void a(BasicOptionItemList basicOptionItemList) {
        e.a("PopUpWindowManager", "showPopUpWindow");
        if (basicOptionItemList != null) {
            BasicOptionItemList basicOptionItemList2 = f4094a;
            if (basicOptionItemList2 != null && basicOptionItemList2.getPopUpWindowState()) {
                f4095b = true;
                f4094a.e();
            }
            f4094a = basicOptionItemList;
            f4094a.c();
        }
    }

    public static boolean a() {
        BasicOptionItemList basicOptionItemList = f4094a;
        if (basicOptionItemList == null) {
            return false;
        }
        if (basicOptionItemList.getPopUpWindowState() || f4095b) {
            return true;
        }
        return false;
    }

    public static BasicOptionItemList b() {
        return f4094a;
    }

    public static boolean c() {
        BasicOptionItemList basicOptionItemList = f4094a;
        if (basicOptionItemList != null) {
            return basicOptionItemList.getPopUpWindowState();
        }
        return false;
    }

    public static void d() {
        e.a("PopUpWindowManager", "hidePopUpWindow");
        BasicOptionItemList basicOptionItemList = f4094a;
        if (basicOptionItemList != null && basicOptionItemList.isShown()) {
            f4094a.d();
        }
    }

    public static void e() {
        f4094a = null;
    }

    public static void a(String str) {
        e.a("PopUpWindowManager", "showPopUpWindowBegin, key: " + str);
        f4095b = true;
        ArrayList<e> arrayList = c;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next != null) {
                    next.a(str);
                }
            }
        }
    }

    public static void b(String str) {
        e.a("PopUpWindowManager", "showPopUpWindowEnd, key: " + str);
        f4095b = true;
        ArrayList<e> arrayList = c;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next != null) {
                    next.b(str);
                }
            }
        }
    }

    public static void c(String str) {
        e.a("PopUpWindowManager", "hidePopUpWindowBegin, key: " + str);
        ArrayList<e> arrayList = c;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next != null) {
                    next.c(str);
                }
            }
        }
        f4095b = false;
    }

    public static void d(String str) {
        e.a("PopUpWindowManager", "hidePopUpWindowEnd, key: " + str);
        ArrayList<e> arrayList = c;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next != null) {
                    next.d(str);
                }
            }
        }
        f4095b = false;
    }

    public static void a(e eVar) {
        if (eVar != null) {
            if (c == null) {
                c = new ArrayList<>();
            }
            if (!c.contains(eVar)) {
                c.add(eVar);
            }
        }
    }

    public static void b(e eVar) {
        ArrayList<e> arrayList;
        if (eVar != null && (arrayList = c) != null && arrayList.contains(eVar)) {
            c.remove(eVar);
        }
    }

    public static void f() {
        e.a("PopUpWindowManager", "clearListener");
        f4095b = false;
        ArrayList<e> arrayList = c;
        if (arrayList != null) {
            arrayList.clear();
            c = null;
        }
    }
}
