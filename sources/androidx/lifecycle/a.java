package androidx.lifecycle;

import androidx.lifecycle.e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ClassesInfoCache */
class a {

    /* renamed from: a  reason: collision with root package name */
    static a f914a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class, C0030a> f915b = new HashMap();
    private final Map<Class, Boolean> c = new HashMap();

    a() {
    }

    /* access modifiers changed from: package-private */
    public boolean a(Class cls) {
        Boolean bool = this.c.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] c2 = c(cls);
        for (Method annotation : c2) {
            if (((o) annotation.getAnnotation(o.class)) != null) {
                a(cls, c2);
                return true;
            }
        }
        this.c.put(cls, false);
        return false;
    }

    private Method[] c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    /* access modifiers changed from: package-private */
    public C0030a b(Class cls) {
        C0030a aVar = this.f915b.get(cls);
        if (aVar != null) {
            return aVar;
        }
        return a(cls, (Method[]) null);
    }

    private void a(Map<b, e.a> map, b bVar, e.a aVar, Class cls) {
        e.a aVar2 = map.get(bVar);
        if (aVar2 != null && aVar != aVar2) {
            Method method = bVar.f919b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
        } else if (aVar2 == null) {
            map.put(bVar, aVar);
        }
    }

    private C0030a a(Class cls, Method[] methodArr) {
        int i;
        C0030a b2;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (b2 = b(superclass)) == null)) {
            hashMap.putAll(b2.f917b);
        }
        for (Class b3 : cls.getInterfaces()) {
            for (Map.Entry next : b(b3).f917b.entrySet()) {
                a(hashMap, (b) next.getKey(), (e.a) next.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = c(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            o oVar = (o) method.getAnnotation(o.class);
            if (oVar != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(h.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                e.a a2 = oVar.a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(e.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (a2 == e.a.ON_ANY) {
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    a(hashMap, new b(i, method), a2, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0030a aVar = new C0030a(hashMap);
        this.f915b.put(cls, aVar);
        this.c.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    /* renamed from: androidx.lifecycle.a$a  reason: collision with other inner class name */
    /* compiled from: ClassesInfoCache */
    static class C0030a {

        /* renamed from: a  reason: collision with root package name */
        final Map<e.a, List<b>> f916a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map<b, e.a> f917b;

        C0030a(Map<b, e.a> map) {
            this.f917b = map;
            for (Map.Entry next : map.entrySet()) {
                e.a aVar = (e.a) next.getValue();
                List list = this.f916a.get(aVar);
                if (list == null) {
                    list = new ArrayList();
                    this.f916a.put(aVar, list);
                }
                list.add(next.getKey());
            }
        }

        /* access modifiers changed from: package-private */
        public void a(h hVar, e.a aVar, Object obj) {
            a(this.f916a.get(aVar), hVar, aVar, obj);
            a(this.f916a.get(e.a.ON_ANY), hVar, aVar, obj);
        }

        private static void a(List<b> list, h hVar, e.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(hVar, aVar, obj);
                }
            }
        }
    }

    /* compiled from: ClassesInfoCache */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        final int f918a;

        /* renamed from: b  reason: collision with root package name */
        final Method f919b;

        b(int i, Method method) {
            this.f918a = i;
            this.f919b = method;
            this.f919b.setAccessible(true);
        }

        /* access modifiers changed from: package-private */
        public void a(h hVar, e.a aVar, Object obj) {
            try {
                int i = this.f918a;
                if (i == 0) {
                    this.f919b.invoke(obj, new Object[0]);
                } else if (i == 1) {
                    this.f919b.invoke(obj, new Object[]{hVar});
                } else if (i == 2) {
                    this.f919b.invoke(obj, new Object[]{hVar, aVar});
                }
            } catch (InvocationTargetException e) {
                throw new RuntimeException("Failed to call observer method", e.getCause());
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f918a != bVar.f918a || !this.f919b.getName().equals(bVar.f919b.getName())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f918a * 31) + this.f919b.getName().hashCode();
        }
    }
}
