package androidx.fragment.app;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.g.r;
import androidx.core.g.v;
import androidx.fragment.app.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: FragmentTransition */
class l {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f875a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b  reason: collision with root package name */
    private static final n f876b = (Build.VERSION.SDK_INT >= 21 ? new m() : null);
    private static final n c = a();

    private static n a() {
        try {
            return (n) Class.forName("androidx.transition.e").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static void a(i iVar, ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (iVar.m >= 1) {
            SparseArray sparseArray = new SparseArray();
            for (int i3 = i; i3 < i2; i3++) {
                a aVar = arrayList.get(i3);
                if (arrayList2.get(i3).booleanValue()) {
                    b(aVar, (SparseArray<a>) sparseArray, z);
                } else {
                    a(aVar, (SparseArray<a>) sparseArray, z);
                }
            }
            if (sparseArray.size() != 0) {
                View view = new View(iVar.n.j());
                int size = sparseArray.size();
                for (int i4 = 0; i4 < size; i4++) {
                    int keyAt = sparseArray.keyAt(i4);
                    ArrayMap<String, String> a2 = a(keyAt, arrayList, arrayList2, i, i2);
                    a aVar2 = (a) sparseArray.valueAt(i4);
                    if (z) {
                        a(iVar, keyAt, aVar2, view, a2);
                    } else {
                        b(iVar, keyAt, aVar2, view, a2);
                    }
                }
            }
        }
    }

    private static ArrayMap<String, String> a(int i, ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            a aVar = arrayList.get(i4);
            if (aVar.b(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                if (aVar.r != null) {
                    int size = aVar.r.size();
                    if (booleanValue) {
                        arrayList3 = aVar.r;
                        arrayList4 = aVar.s;
                    } else {
                        ArrayList arrayList5 = aVar.r;
                        arrayList3 = aVar.s;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = (String) arrayList4.get(i5);
                        String str2 = (String) arrayList3.get(i5);
                        String remove = arrayMap.remove(str2);
                        if (remove != null) {
                            arrayMap.put(str, remove);
                        } else {
                            arrayMap.put(str, str2);
                        }
                    }
                }
            }
        }
        return arrayMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        r11 = r4.f884a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(androidx.fragment.app.i r17, int r18, androidx.fragment.app.l.a r19, android.view.View r20, androidx.collection.ArrayMap<java.lang.String, java.lang.String> r21) {
        /*
            r0 = r17
            r4 = r19
            r9 = r20
            androidx.fragment.app.d r1 = r0.o
            boolean r1 = r1.a()
            if (r1 == 0) goto L_0x0019
            androidx.fragment.app.d r0 = r0.o
            r1 = r18
            android.view.View r0 = r0.a(r1)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            r10 = r0
            if (r10 != 0) goto L_0x001e
            return
        L_0x001e:
            androidx.fragment.app.Fragment r11 = r4.f884a
            androidx.fragment.app.Fragment r12 = r4.d
            androidx.fragment.app.n r13 = a((androidx.fragment.app.Fragment) r12, (androidx.fragment.app.Fragment) r11)
            if (r13 != 0) goto L_0x0029
            return
        L_0x0029:
            boolean r14 = r4.f885b
            boolean r0 = r4.e
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.lang.Object r7 = a((androidx.fragment.app.n) r13, (androidx.fragment.app.Fragment) r11, (boolean) r14)
            java.lang.Object r6 = b((androidx.fragment.app.n) r13, (androidx.fragment.app.Fragment) r12, (boolean) r0)
            r0 = r13
            r1 = r10
            r2 = r20
            r3 = r21
            r4 = r19
            r5 = r8
            r17 = r6
            r6 = r15
            r18 = r7
            r16 = r10
            r10 = r8
            r8 = r17
            java.lang.Object r8 = a((androidx.fragment.app.n) r0, (android.view.ViewGroup) r1, (android.view.View) r2, (androidx.collection.ArrayMap<java.lang.String, java.lang.String>) r3, (androidx.fragment.app.l.a) r4, (java.util.ArrayList<android.view.View>) r5, (java.util.ArrayList<android.view.View>) r6, (java.lang.Object) r7, (java.lang.Object) r8)
            r6 = r18
            if (r6 != 0) goto L_0x0061
            if (r8 != 0) goto L_0x0061
            r7 = r17
            if (r7 != 0) goto L_0x0063
            return
        L_0x0061:
            r7 = r17
        L_0x0063:
            java.util.ArrayList r5 = a((androidx.fragment.app.n) r13, (java.lang.Object) r7, (androidx.fragment.app.Fragment) r12, (java.util.ArrayList<android.view.View>) r10, (android.view.View) r9)
            java.util.ArrayList r9 = a((androidx.fragment.app.n) r13, (java.lang.Object) r6, (androidx.fragment.app.Fragment) r11, (java.util.ArrayList<android.view.View>) r15, (android.view.View) r9)
            r0 = 4
            a((java.util.ArrayList<android.view.View>) r9, (int) r0)
            r0 = r13
            r1 = r6
            r2 = r7
            r3 = r8
            r4 = r11
            r11 = r5
            r5 = r14
            java.lang.Object r14 = a((androidx.fragment.app.n) r0, (java.lang.Object) r1, (java.lang.Object) r2, (java.lang.Object) r3, (androidx.fragment.app.Fragment) r4, (boolean) r5)
            if (r14 == 0) goto L_0x00a4
            a((androidx.fragment.app.n) r13, (java.lang.Object) r7, (androidx.fragment.app.Fragment) r12, (java.util.ArrayList<android.view.View>) r11)
            java.util.ArrayList r12 = r13.a((java.util.ArrayList<android.view.View>) r15)
            r0 = r13
            r1 = r14
            r2 = r6
            r3 = r9
            r4 = r7
            r5 = r11
            r6 = r8
            r7 = r15
            r0.a(r1, r2, r3, r4, r5, r6, r7)
            r0 = r16
            r13.a((android.view.ViewGroup) r0, (java.lang.Object) r14)
            r1 = r13
            r2 = r0
            r3 = r10
            r4 = r15
            r5 = r12
            r6 = r21
            r1.a(r2, r3, r4, r5, r6)
            r0 = 0
            a((java.util.ArrayList<android.view.View>) r9, (int) r0)
            r13.a((java.lang.Object) r8, (java.util.ArrayList<android.view.View>) r10, (java.util.ArrayList<android.view.View>) r15)
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.l.a(androidx.fragment.app.i, int, androidx.fragment.app.l$a, android.view.View, androidx.collection.ArrayMap):void");
    }

    private static void a(n nVar, Object obj, Fragment fragment, final ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            nVar.b(obj, fragment.getView(), arrayList);
            r.a(fragment.mContainer, new Runnable() {
                public void run() {
                    l.a((ArrayList<View>) arrayList, 4);
                }
            });
        }
    }

    private static void b(i iVar, int i, a aVar, View view, ArrayMap<String, String> arrayMap) {
        Fragment fragment;
        Fragment fragment2;
        n a2;
        Object obj;
        i iVar2 = iVar;
        a aVar2 = aVar;
        View view2 = view;
        ArrayMap<String, String> arrayMap2 = arrayMap;
        ViewGroup viewGroup = iVar2.o.a() ? (ViewGroup) iVar2.o.a(i) : null;
        if (viewGroup != null && (a2 = a(fragment2, fragment)) != null) {
            boolean z = aVar2.f885b;
            boolean z2 = aVar2.e;
            Object a3 = a(a2, (fragment = aVar2.f884a), z);
            Object b2 = b(a2, (fragment2 = aVar2.d), z2);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = arrayList;
            Object obj2 = b2;
            n nVar = a2;
            Object b3 = b(a2, viewGroup, view, arrayMap, aVar, arrayList, arrayList2, a3, obj2);
            Object obj3 = a3;
            if (obj3 == null && b3 == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = obj2;
            }
            ArrayList<View> a4 = a(nVar, obj, fragment2, (ArrayList<View>) arrayList3, view2);
            Object obj4 = (a4 == null || a4.isEmpty()) ? null : obj;
            nVar.b(obj3, view2);
            Object a5 = a(nVar, obj3, obj4, b3, fragment, aVar2.f885b);
            if (a5 != null) {
                ArrayList arrayList4 = new ArrayList();
                n nVar2 = nVar;
                nVar2.a(a5, obj3, arrayList4, obj4, a4, b3, arrayList2);
                a(nVar2, viewGroup, fragment, view, (ArrayList<View>) arrayList2, obj3, (ArrayList<View>) arrayList4, obj4, a4);
                ArrayList arrayList5 = arrayList2;
                nVar.a((View) viewGroup, (ArrayList<View>) arrayList5, (Map<String, String>) arrayMap2);
                nVar.a(viewGroup, a5);
                nVar.a(viewGroup, (ArrayList<View>) arrayList5, (Map<String, String>) arrayMap2);
            }
        }
    }

    private static void a(n nVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        final Object obj3 = obj;
        final n nVar2 = nVar;
        final View view2 = view;
        final Fragment fragment2 = fragment;
        final ArrayList<View> arrayList4 = arrayList;
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<View> arrayList6 = arrayList3;
        final Object obj4 = obj2;
        ViewGroup viewGroup2 = viewGroup;
        r.a(viewGroup, new Runnable() {
            public void run() {
                Object obj = obj3;
                if (obj != null) {
                    nVar2.c(obj, view2);
                    arrayList5.addAll(l.a(nVar2, obj3, fragment2, (ArrayList<View>) arrayList4, view2));
                }
                if (arrayList6 != null) {
                    if (obj4 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view2);
                        nVar2.b(obj4, (ArrayList<View>) arrayList6, (ArrayList<View>) arrayList);
                    }
                    arrayList6.clear();
                    arrayList6.add(view2);
                }
            }
        });
    }

    private static n a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        n nVar = f876b;
        if (nVar != null && a(nVar, (List<Object>) arrayList)) {
            return f876b;
        }
        n nVar2 = c;
        if (nVar2 != null && a(nVar2, (List<Object>) arrayList)) {
            return c;
        }
        if (f876b == null && c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    private static boolean a(n nVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!nVar.a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static Object a(n nVar, Fragment fragment, Fragment fragment2, boolean z) {
        Object obj;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            obj = fragment2.getSharedElementReturnTransition();
        } else {
            obj = fragment.getSharedElementEnterTransition();
        }
        return nVar.c(nVar.b(obj));
    }

    private static Object a(n nVar, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReenterTransition();
        } else {
            obj = fragment.getEnterTransition();
        }
        return nVar.b(obj);
    }

    private static Object b(n nVar, Fragment fragment, boolean z) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z) {
            obj = fragment.getReturnTransition();
        } else {
            obj = fragment.getExitTransition();
        }
        return nVar.b(obj);
    }

    private static Object a(n nVar, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, a aVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Object obj4;
        final Rect rect;
        final View view2;
        n nVar2 = nVar;
        View view3 = view;
        ArrayMap<String, String> arrayMap2 = arrayMap;
        a aVar2 = aVar;
        ArrayList<View> arrayList3 = arrayList;
        ArrayList<View> arrayList4 = arrayList2;
        Object obj5 = obj;
        Fragment fragment = aVar2.f884a;
        Fragment fragment2 = aVar2.d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = aVar2.f885b;
        if (arrayMap.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = a(nVar, fragment, fragment2, z);
        }
        ArrayMap<String, View> b2 = b(nVar, arrayMap2, obj3, aVar2);
        ArrayMap<String, View> a2 = a(nVar, arrayMap2, obj3, aVar2);
        if (arrayMap.isEmpty()) {
            if (b2 != null) {
                b2.clear();
            }
            if (a2 != null) {
                a2.clear();
            }
            obj4 = null;
        } else {
            a(arrayList3, b2, (Collection<String>) arrayMap.keySet());
            a(arrayList4, a2, arrayMap.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        a(fragment, fragment2, z, b2, true);
        if (obj4 != null) {
            arrayList4.add(view3);
            nVar.a(obj4, view3, arrayList3);
            a(nVar, obj4, obj2, b2, aVar2.e, aVar2.f);
            Rect rect2 = new Rect();
            View a3 = a(a2, aVar2, obj5, z);
            if (a3 != null) {
                nVar.a(obj5, rect2);
            }
            rect = rect2;
            view2 = a3;
        } else {
            view2 = null;
            rect = null;
        }
        final Fragment fragment3 = fragment;
        final Fragment fragment4 = fragment2;
        final boolean z2 = z;
        final ArrayMap<String, View> arrayMap3 = a2;
        final n nVar3 = nVar;
        r.a(viewGroup, new Runnable() {
            public void run() {
                l.a(fragment3, fragment4, z2, (ArrayMap<String, View>) arrayMap3, false);
                View view = view2;
                if (view != null) {
                    nVar3.a(view, rect);
                }
            }
        });
        return obj4;
    }

    private static void a(ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, Collection<String> collection) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View valueAt = arrayMap.valueAt(size);
            if (collection.contains(v.q(valueAt))) {
                arrayList.add(valueAt);
            }
        }
    }

    private static Object b(n nVar, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, a aVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        ArrayMap<String, String> arrayMap2;
        Object obj3;
        Object obj4;
        Rect rect;
        n nVar2 = nVar;
        a aVar2 = aVar;
        ArrayList<View> arrayList3 = arrayList;
        Object obj5 = obj;
        Fragment fragment = aVar2.f884a;
        Fragment fragment2 = aVar2.d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = aVar2.f885b;
        if (arrayMap.isEmpty()) {
            arrayMap2 = arrayMap;
            obj3 = null;
        } else {
            obj3 = a(nVar2, fragment, fragment2, z);
            arrayMap2 = arrayMap;
        }
        ArrayMap<String, View> b2 = b(nVar2, arrayMap2, obj3, aVar2);
        if (arrayMap.isEmpty()) {
            obj4 = null;
        } else {
            arrayList3.addAll(b2.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        a(fragment, fragment2, z, b2, true);
        if (obj4 != null) {
            rect = new Rect();
            nVar2.a(obj4, view, arrayList3);
            a(nVar, obj4, obj2, b2, aVar2.e, aVar2.f);
            if (obj5 != null) {
                nVar2.a(obj5, rect);
            }
        } else {
            rect = null;
        }
        final n nVar3 = nVar;
        final ArrayMap<String, String> arrayMap3 = arrayMap;
        final Object obj6 = obj4;
        final a aVar3 = aVar;
        AnonymousClass4 r13 = r0;
        final ArrayList<View> arrayList4 = arrayList2;
        final View view2 = view;
        final Fragment fragment3 = fragment;
        final Fragment fragment4 = fragment2;
        final boolean z2 = z;
        final ArrayList<View> arrayList5 = arrayList;
        final Object obj7 = obj;
        final Rect rect2 = rect;
        AnonymousClass4 r0 = new Runnable() {
            public void run() {
                ArrayMap<String, View> a2 = l.a(nVar3, (ArrayMap<String, String>) arrayMap3, obj6, aVar3);
                if (a2 != null) {
                    arrayList4.addAll(a2.values());
                    arrayList4.add(view2);
                }
                l.a(fragment3, fragment4, z2, a2, false);
                Object obj = obj6;
                if (obj != null) {
                    nVar3.a(obj, (ArrayList<View>) arrayList5, (ArrayList<View>) arrayList4);
                    View a3 = l.a(a2, aVar3, obj7, z2);
                    if (a3 != null) {
                        nVar3.a(a3, rect2);
                    }
                }
            }
        };
        r.a(viewGroup, r13);
        return obj4;
    }

    private static ArrayMap<String, View> b(n nVar, ArrayMap<String, String> arrayMap, Object obj, a aVar) {
        androidx.core.app.l lVar;
        ArrayList arrayList;
        if (arrayMap.isEmpty() || obj == null) {
            arrayMap.clear();
            return null;
        }
        Fragment fragment = aVar.d;
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        nVar.a((Map<String, View>) arrayMap2, fragment.requireView());
        a aVar2 = aVar.f;
        if (aVar.e) {
            lVar = fragment.getEnterTransitionCallback();
            arrayList = aVar2.s;
        } else {
            lVar = fragment.getExitTransitionCallback();
            arrayList = aVar2.r;
        }
        arrayMap2.retainAll(arrayList);
        if (lVar != null) {
            lVar.a(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view = arrayMap2.get(str);
                if (view == null) {
                    arrayMap.remove(str);
                } else if (!str.equals(v.q(view))) {
                    arrayMap.put(v.q(view), arrayMap.remove(str));
                }
            }
        } else {
            arrayMap.retainAll(arrayMap2.keySet());
        }
        return arrayMap2;
    }

    static ArrayMap<String, View> a(n nVar, ArrayMap<String, String> arrayMap, Object obj, a aVar) {
        androidx.core.app.l lVar;
        ArrayList arrayList;
        String a2;
        Fragment fragment = aVar.f884a;
        View view = fragment.getView();
        if (arrayMap.isEmpty() || obj == null || view == null) {
            arrayMap.clear();
            return null;
        }
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        nVar.a((Map<String, View>) arrayMap2, view);
        a aVar2 = aVar.c;
        if (aVar.f885b) {
            lVar = fragment.getExitTransitionCallback();
            arrayList = aVar2.r;
        } else {
            lVar = fragment.getEnterTransitionCallback();
            arrayList = aVar2.s;
        }
        if (arrayList != null) {
            arrayMap2.retainAll(arrayList);
            arrayMap2.retainAll(arrayMap.values());
        }
        if (lVar != null) {
            lVar.a(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = (String) arrayList.get(size);
                View view2 = arrayMap2.get(str);
                if (view2 == null) {
                    String a3 = a(arrayMap, str);
                    if (a3 != null) {
                        arrayMap.remove(a3);
                    }
                } else if (!str.equals(v.q(view2)) && (a2 = a(arrayMap, str)) != null) {
                    arrayMap.put(a2, v.q(view2));
                }
            }
        } else {
            a(arrayMap, arrayMap2);
        }
        return arrayMap2;
    }

    private static String a(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(arrayMap.valueAt(i))) {
                return arrayMap.keyAt(i);
            }
        }
        return null;
    }

    static View a(ArrayMap<String, View> arrayMap, a aVar, Object obj, boolean z) {
        String str;
        a aVar2 = aVar.c;
        if (obj == null || arrayMap == null || aVar2.r == null || aVar2.r.isEmpty()) {
            return null;
        }
        if (z) {
            str = (String) aVar2.r.get(0);
        } else {
            str = (String) aVar2.s.get(0);
        }
        return arrayMap.get(str);
    }

    private static void a(n nVar, Object obj, Object obj2, ArrayMap<String, View> arrayMap, boolean z, a aVar) {
        String str;
        if (aVar.r != null && !aVar.r.isEmpty()) {
            if (z) {
                str = (String) aVar.s.get(0);
            } else {
                str = (String) aVar.r.get(0);
            }
            View view = arrayMap.get(str);
            nVar.a(obj, view);
            if (obj2 != null) {
                nVar.a(obj2, view);
            }
        }
    }

    private static void a(ArrayMap<String, String> arrayMap, ArrayMap<String, View> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey(arrayMap.valueAt(size))) {
                arrayMap.removeAt(size);
            }
        }
    }

    static void a(Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap, boolean z2) {
        androidx.core.app.l lVar;
        int i;
        if (z) {
            lVar = fragment2.getEnterTransitionCallback();
        } else {
            lVar = fragment.getEnterTransitionCallback();
        }
        if (lVar != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (arrayMap == null) {
                i = 0;
            } else {
                i = arrayMap.size();
            }
            for (int i2 = 0; i2 < i; i2++) {
                arrayList2.add(arrayMap.keyAt(i2));
                arrayList.add(arrayMap.valueAt(i2));
            }
            if (z2) {
                lVar.a(arrayList2, arrayList, (List<View>) null);
            } else {
                lVar.b(arrayList2, arrayList, (List<View>) null);
            }
        }
    }

    static ArrayList<View> a(n nVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            nVar.a(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        nVar.a(obj, arrayList2);
        return arrayList2;
    }

    static void a(ArrayList<View> arrayList, int i) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i);
            }
        }
    }

    private static Object a(n nVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else {
            z2 = z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return nVar.a(obj2, obj, obj3);
        }
        return nVar.b(obj2, obj, obj3);
    }

    public static void a(a aVar, SparseArray<a> sparseArray, boolean z) {
        int size = aVar.d.size();
        for (int i = 0; i < size; i++) {
            a(aVar, (k.a) aVar.d.get(i), sparseArray, false, z);
        }
    }

    public static void b(a aVar, SparseArray<a> sparseArray, boolean z) {
        if (aVar.f839a.o.a()) {
            for (int size = aVar.d.size() - 1; size >= 0; size--) {
                a(aVar, (k.a) aVar.d.get(size), sparseArray, true, z);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0041, code lost:
        if (r10.mAdded != false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0079, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0095, code lost:
        if (r10.mHidden == false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0097, code lost:
        r1 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00eb A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:95:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(androidx.fragment.app.a r16, androidx.fragment.app.k.a r17, android.util.SparseArray<androidx.fragment.app.l.a> r18, boolean r19, boolean r20) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            androidx.fragment.app.Fragment r10 = r1.f874b
            if (r10 != 0) goto L_0x000d
            return
        L_0x000d:
            int r11 = r10.mContainerId
            if (r11 != 0) goto L_0x0012
            return
        L_0x0012:
            if (r3 == 0) goto L_0x001b
            int[] r4 = f875a
            int r1 = r1.f873a
            r1 = r4[r1]
            goto L_0x001d
        L_0x001b:
            int r1 = r1.f873a
        L_0x001d:
            r4 = 0
            r5 = 1
            if (r1 == r5) goto L_0x008a
            r6 = 3
            if (r1 == r6) goto L_0x0060
            r6 = 4
            if (r1 == r6) goto L_0x0048
            r6 = 5
            if (r1 == r6) goto L_0x0035
            r6 = 6
            if (r1 == r6) goto L_0x0060
            r6 = 7
            if (r1 == r6) goto L_0x008a
            r1 = r4
            r12 = r1
            r13 = r12
            goto L_0x009e
        L_0x0035:
            if (r20 == 0) goto L_0x0044
            boolean r1 = r10.mHiddenChanged
            if (r1 == 0) goto L_0x0099
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x0099
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x0099
            goto L_0x0097
        L_0x0044:
            boolean r1 = r10.mHidden
            goto L_0x009a
        L_0x0048:
            if (r20 == 0) goto L_0x0057
            boolean r1 = r10.mHiddenChanged
            if (r1 == 0) goto L_0x007b
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x007b
            boolean r1 = r10.mHidden
            if (r1 == 0) goto L_0x007b
        L_0x0056:
            goto L_0x0079
        L_0x0057:
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x007b
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x007b
            goto L_0x0056
        L_0x0060:
            if (r20 == 0) goto L_0x007d
            boolean r1 = r10.mAdded
            if (r1 != 0) goto L_0x007b
            android.view.View r1 = r10.mView
            if (r1 == 0) goto L_0x007b
            android.view.View r1 = r10.mView
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x007b
            float r1 = r10.mPostponedAlpha
            r6 = 0
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x007b
        L_0x0079:
            r1 = r5
            goto L_0x0086
        L_0x007b:
            r1 = r4
            goto L_0x0086
        L_0x007d:
            boolean r1 = r10.mAdded
            if (r1 == 0) goto L_0x007b
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x007b
            goto L_0x0079
        L_0x0086:
            r13 = r1
            r1 = r4
            r12 = r5
            goto L_0x009e
        L_0x008a:
            if (r20 == 0) goto L_0x008f
            boolean r1 = r10.mIsNewlyAdded
            goto L_0x009a
        L_0x008f:
            boolean r1 = r10.mAdded
            if (r1 != 0) goto L_0x0099
            boolean r1 = r10.mHidden
            if (r1 != 0) goto L_0x0099
        L_0x0097:
            r1 = r5
            goto L_0x009a
        L_0x0099:
            r1 = r4
        L_0x009a:
            r12 = r4
            r13 = r12
            r4 = r1
            r1 = r5
        L_0x009e:
            java.lang.Object r6 = r2.get(r11)
            androidx.fragment.app.l$a r6 = (androidx.fragment.app.l.a) r6
            if (r4 == 0) goto L_0x00b0
            androidx.fragment.app.l$a r6 = a((androidx.fragment.app.l.a) r6, (android.util.SparseArray<androidx.fragment.app.l.a>) r2, (int) r11)
            r6.f884a = r10
            r6.f885b = r3
            r6.c = r0
        L_0x00b0:
            r14 = r6
            r15 = 0
            if (r20 != 0) goto L_0x00d7
            if (r1 == 0) goto L_0x00d7
            if (r14 == 0) goto L_0x00be
            androidx.fragment.app.Fragment r1 = r14.d
            if (r1 != r10) goto L_0x00be
            r14.d = r15
        L_0x00be:
            androidx.fragment.app.i r4 = r0.f839a
            int r1 = r10.mState
            if (r1 >= r5) goto L_0x00d7
            int r1 = r4.m
            if (r1 < r5) goto L_0x00d7
            boolean r1 = r0.t
            if (r1 != 0) goto L_0x00d7
            r4.k(r10)
            r6 = 1
            r7 = 0
            r8 = 0
            r9 = 0
            r5 = r10
            r4.a((androidx.fragment.app.Fragment) r5, (int) r6, (int) r7, (int) r8, (boolean) r9)
        L_0x00d7:
            if (r13 == 0) goto L_0x00e9
            if (r14 == 0) goto L_0x00df
            androidx.fragment.app.Fragment r1 = r14.d
            if (r1 != 0) goto L_0x00e9
        L_0x00df:
            androidx.fragment.app.l$a r14 = a((androidx.fragment.app.l.a) r14, (android.util.SparseArray<androidx.fragment.app.l.a>) r2, (int) r11)
            r14.d = r10
            r14.e = r3
            r14.f = r0
        L_0x00e9:
            if (r20 != 0) goto L_0x00f5
            if (r12 == 0) goto L_0x00f5
            if (r14 == 0) goto L_0x00f5
            androidx.fragment.app.Fragment r0 = r14.f884a
            if (r0 != r10) goto L_0x00f5
            r14.f884a = r15
        L_0x00f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.l.a(androidx.fragment.app.a, androidx.fragment.app.k$a, android.util.SparseArray, boolean, boolean):void");
    }

    private static a a(a aVar, SparseArray<a> sparseArray, int i) {
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        sparseArray.put(i, aVar2);
        return aVar2;
    }

    /* compiled from: FragmentTransition */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f884a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f885b;
        public a c;
        public Fragment d;
        public boolean e;
        public a f;

        a() {
        }
    }
}
