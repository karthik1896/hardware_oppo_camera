package com.heytap.shield.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: ServiceMap */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static List<Object> f2625a = new CopyOnWriteArrayList();

    /* renamed from: b  reason: collision with root package name */
    private static Map<String, String> f2626b = new ConcurrentHashMap();
    private static List<String> c = new ArrayList(Arrays.asList(new String[]{"android.app.IActivityManager", "android.content.pm.IPackageManager", "android.view.IWindowManager"}));

    public static void a() {
        for (String bVar : c) {
            f2625a.add(new b(bVar));
        }
        f2626b.put("android.view.IWindowSession", "IWindowSession");
        f2626b.put("android.view.IWindowManager", "IWindowSession");
        f2626b.put("android.content.pm.IPackageInstaller", "PackageInstaller.Session");
        f2626b.put("android.content.pm.IPackageInstallerSession", "PackageInstaller.Session");
    }
}
