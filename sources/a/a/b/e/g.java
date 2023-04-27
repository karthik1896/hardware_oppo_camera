package a.a.b.e;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class g {
    public static Object a(Object obj) {
        int length = Array.getLength(obj);
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length);
        System.arraycopy(obj, 0, newInstance, 0, length);
        return newInstance;
    }

    public static <E> Collection<E> a(Collection<E> collection) {
        Collection<E> linkedList = collection instanceof LinkedList ? new LinkedList<>() : collection instanceof SortedSet ? new TreeSet<>() : collection instanceof Set ? new HashSet<>() : new ArrayList<>();
        for (E b2 : collection) {
            linkedList.add(b(b2));
        }
        return linkedList;
    }

    public static <K, V> Map<K, V> a(Map<K, V> map) {
        Map<K, V> linkedHashMap = map instanceof LinkedHashMap ? new LinkedHashMap<>() : map instanceof TreeMap ? new TreeMap<>() : new HashMap<>();
        for (Map.Entry next : map.entrySet()) {
            linkedHashMap.put(b(next.getKey()), b(next.getValue()));
        }
        return linkedHashMap;
    }

    public static <E> E[] a(E[] eArr) {
        E[] eArr2 = (Object[]) Array.newInstance(eArr.getClass().getComponentType(), eArr.length);
        for (int i = 0; i < eArr.length; i++) {
            eArr2[i] = b(eArr[i]);
        }
        return eArr2;
    }

    public static <X> X b(X x) {
        return x == null ? x : x instanceof Map ? a((Map) x) : x instanceof Collection ? a((Collection) x) : x instanceof Object[] ? a((E[]) (Object[]) x) : x.getClass().isArray() ? a((Object) x) : x;
    }
}
