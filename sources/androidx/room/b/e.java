package androidx.room.b;

import android.database.Cursor;
import android.os.Build;
import com.meicam.sdk.NvsFxDescription;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* compiled from: TableInfo */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f1173a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, a> f1174b;
    public final Set<b> c;
    public final Set<d> d;

    public e(String str, Map<String, a> map, Set<b> set, Set<d> set2) {
        Set<d> set3;
        this.f1173a = str;
        this.f1174b = Collections.unmodifiableMap(map);
        this.c = Collections.unmodifiableSet(set);
        if (set2 == null) {
            set3 = null;
        } else {
            set3 = Collections.unmodifiableSet(set2);
        }
        this.d = set3;
    }

    public boolean equals(Object obj) {
        Set<d> set;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        String str = this.f1173a;
        if (str == null ? eVar.f1173a != null : !str.equals(eVar.f1173a)) {
            return false;
        }
        Map<String, a> map = this.f1174b;
        if (map == null ? eVar.f1174b != null : !map.equals(eVar.f1174b)) {
            return false;
        }
        Set<b> set2 = this.c;
        if (set2 == null ? eVar.c != null : !set2.equals(eVar.c)) {
            return false;
        }
        Set<d> set3 = this.d;
        if (set3 == null || (set = eVar.d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        String str = this.f1173a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, a> map = this.f1174b;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set<b> set = this.c;
        if (set != null) {
            i = set.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "TableInfo{name='" + this.f1173a + '\'' + ", columns=" + this.f1174b + ", foreignKeys=" + this.c + ", indices=" + this.d + '}';
    }

    public static e a(androidx.f.a.b bVar, String str) {
        return new e(str, c(bVar, str), b(bVar, str), d(bVar, str));
    }

    private static Set<b> b(androidx.f.a.b bVar, String str) {
        HashSet hashSet = new HashSet();
        Cursor b2 = bVar.b("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = b2.getColumnIndex("id");
            int columnIndex2 = b2.getColumnIndex("seq");
            int columnIndex3 = b2.getColumnIndex("table");
            int columnIndex4 = b2.getColumnIndex("on_delete");
            int columnIndex5 = b2.getColumnIndex("on_update");
            List<c> a2 = a(b2);
            int count = b2.getCount();
            for (int i = 0; i < count; i++) {
                b2.moveToPosition(i);
                if (b2.getInt(columnIndex2) == 0) {
                    int i2 = b2.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (c next : a2) {
                        if (next.f1179a == i2) {
                            arrayList.add(next.c);
                            arrayList2.add(next.d);
                        }
                    }
                    hashSet.add(new b(b2.getString(columnIndex3), b2.getString(columnIndex4), b2.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            return hashSet;
        } finally {
            b2.close();
        }
    }

    private static List<c> a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < count; i++) {
            cursor.moveToPosition(i);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static Map<String, a> c(androidx.f.a.b bVar, String str) {
        Cursor b2 = bVar.b("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (b2.getColumnCount() > 0) {
                int columnIndex = b2.getColumnIndex("name");
                int columnIndex2 = b2.getColumnIndex("type");
                int columnIndex3 = b2.getColumnIndex("notnull");
                int columnIndex4 = b2.getColumnIndex("pk");
                int columnIndex5 = b2.getColumnIndex("dflt_value");
                while (b2.moveToNext()) {
                    String string = b2.getString(columnIndex);
                    hashMap.put(string, new a(string, b2.getString(columnIndex2), b2.getInt(columnIndex3) != 0, b2.getInt(columnIndex4), b2.getString(columnIndex5), 2));
                }
            }
            return hashMap;
        } finally {
            b2.close();
        }
    }

    private static Set<d> d(androidx.f.a.b bVar, String str) {
        Cursor b2 = bVar.b("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = b2.getColumnIndex("name");
            int columnIndex2 = b2.getColumnIndex("origin");
            int columnIndex3 = b2.getColumnIndex("unique");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    HashSet hashSet = new HashSet();
                    while (b2.moveToNext()) {
                        if ("c".equals(b2.getString(columnIndex2))) {
                            String string = b2.getString(columnIndex);
                            boolean z = true;
                            if (b2.getInt(columnIndex3) != 1) {
                                z = false;
                            }
                            d a2 = a(bVar, string, z);
                            if (a2 == null) {
                                b2.close();
                                return null;
                            }
                            hashSet.add(a2);
                        }
                    }
                    b2.close();
                    return hashSet;
                }
            }
            return null;
        } finally {
            b2.close();
        }
    }

    private static d a(androidx.f.a.b bVar, String str, boolean z) {
        Cursor b2 = bVar.b("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = b2.getColumnIndex("seqno");
            int columnIndex2 = b2.getColumnIndex("cid");
            int columnIndex3 = b2.getColumnIndex("name");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    TreeMap treeMap = new TreeMap();
                    while (b2.moveToNext()) {
                        if (b2.getInt(columnIndex2) >= 0) {
                            int i = b2.getInt(columnIndex);
                            treeMap.put(Integer.valueOf(i), b2.getString(columnIndex3));
                        }
                    }
                    ArrayList arrayList = new ArrayList(treeMap.size());
                    arrayList.addAll(treeMap.values());
                    d dVar = new d(str, z, arrayList);
                    b2.close();
                    return dVar;
                }
            }
            return null;
        } finally {
            b2.close();
        }
    }

    /* compiled from: TableInfo */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f1175a;

        /* renamed from: b  reason: collision with root package name */
        public final String f1176b;
        public final int c;
        public final boolean d;
        public final int e;
        public final String f;
        private final int g;

        public a(String str, String str2, boolean z, int i, String str3, int i2) {
            this.f1175a = str;
            this.f1176b = str2;
            this.d = z;
            this.e = i;
            this.c = a(str2);
            this.f = str3;
            this.g = i2;
        }

        private static int a(String str) {
            if (str == null) {
                return 5;
            }
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains(NvsFxDescription.ParamInfoObject.PARAM_TYPE_INT)) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            return (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (Build.VERSION.SDK_INT >= 20) {
                if (this.e != aVar.e) {
                    return false;
                }
            } else if (a() != aVar.a()) {
                return false;
            }
            if (!this.f1175a.equals(aVar.f1175a) || this.d != aVar.d) {
                return false;
            }
            if (this.g == 1 && aVar.g == 2 && (str3 = this.f) != null && !str3.equals(aVar.f)) {
                return false;
            }
            if (this.g == 2 && aVar.g == 1 && (str2 = aVar.f) != null && !str2.equals(this.f)) {
                return false;
            }
            int i = this.g;
            if (i != 0 && i == aVar.g && ((str = this.f) == null ? aVar.f != null : !str.equals(aVar.f))) {
                return false;
            }
            if (this.c == aVar.c) {
                return true;
            }
            return false;
        }

        public boolean a() {
            return this.e > 0;
        }

        public int hashCode() {
            return (((((this.f1175a.hashCode() * 31) + this.c) * 31) + (this.d ? 1231 : 1237)) * 31) + this.e;
        }

        public String toString() {
            return "Column{name='" + this.f1175a + '\'' + ", type='" + this.f1176b + '\'' + ", affinity='" + this.c + '\'' + ", notNull=" + this.d + ", primaryKeyPosition=" + this.e + ", defaultValue='" + this.f + '\'' + '}';
        }
    }

    /* compiled from: TableInfo */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f1177a;

        /* renamed from: b  reason: collision with root package name */
        public final String f1178b;
        public final String c;
        public final List<String> d;
        public final List<String> e;

        public b(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.f1177a = str;
            this.f1178b = str2;
            this.c = str3;
            this.d = Collections.unmodifiableList(list);
            this.e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f1177a.equals(bVar.f1177a) && this.f1178b.equals(bVar.f1178b) && this.c.equals(bVar.c) && this.d.equals(bVar.d)) {
                return this.e.equals(bVar.e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f1177a.hashCode() * 31) + this.f1178b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.f1177a + '\'' + ", onDelete='" + this.f1178b + '\'' + ", onUpdate='" + this.c + '\'' + ", columnNames=" + this.d + ", referenceColumnNames=" + this.e + '}';
        }
    }

    /* compiled from: TableInfo */
    static class c implements Comparable<c> {

        /* renamed from: a  reason: collision with root package name */
        final int f1179a;

        /* renamed from: b  reason: collision with root package name */
        final int f1180b;
        final String c;
        final String d;

        c(int i, int i2, String str, String str2) {
            this.f1179a = i;
            this.f1180b = i2;
            this.c = str;
            this.d = str2;
        }

        /* renamed from: a */
        public int compareTo(c cVar) {
            int i = this.f1179a - cVar.f1179a;
            return i == 0 ? this.f1180b - cVar.f1180b : i;
        }
    }

    /* compiled from: TableInfo */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f1181a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f1182b;
        public final List<String> c;

        public d(String str, boolean z, List<String> list) {
            this.f1181a = str;
            this.f1182b = z;
            this.c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f1182b != dVar.f1182b || !this.c.equals(dVar.c)) {
                return false;
            }
            if (this.f1181a.startsWith("index_")) {
                return dVar.f1181a.startsWith("index_");
            }
            return this.f1181a.equals(dVar.f1181a);
        }

        public int hashCode() {
            int i;
            if (this.f1181a.startsWith("index_")) {
                i = "index_".hashCode();
            } else {
                i = this.f1181a.hashCode();
            }
            return (((i * 31) + (this.f1182b ? 1 : 0)) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.f1181a + '\'' + ", unique=" + this.f1182b + ", columns=" + this.c + '}';
        }
    }
}
