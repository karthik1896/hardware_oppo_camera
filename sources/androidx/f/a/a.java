package androidx.f.a;

/* compiled from: SimpleSQLiteQuery */
public final class a implements e {

    /* renamed from: a  reason: collision with root package name */
    private final String f809a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f810b;

    public a(String str, Object[] objArr) {
        this.f809a = str;
        this.f810b = objArr;
    }

    public a(String str) {
        this(str, (Object[]) null);
    }

    public String b() {
        return this.f809a;
    }

    public void a(d dVar) {
        a(dVar, this.f810b);
    }

    public static void a(d dVar, Object[] objArr) {
        if (objArr != null) {
            int length = objArr.length;
            int i = 0;
            while (i < length) {
                Object obj = objArr[i];
                i++;
                a(dVar, i, obj);
            }
        }
    }

    private static void a(d dVar, int i, Object obj) {
        if (obj == null) {
            dVar.a(i);
        } else if (obj instanceof byte[]) {
            dVar.a(i, (byte[]) obj);
        } else if (obj instanceof Float) {
            dVar.a(i, (double) ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            dVar.a(i, ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            dVar.a(i, ((Long) obj).longValue());
        } else if (obj instanceof Integer) {
            dVar.a(i, (long) ((Integer) obj).intValue());
        } else if (obj instanceof Short) {
            dVar.a(i, (long) ((Short) obj).shortValue());
        } else if (obj instanceof Byte) {
            dVar.a(i, (long) ((Byte) obj).byteValue());
        } else if (obj instanceof String) {
            dVar.a(i, (String) obj);
        } else if (obj instanceof Boolean) {
            dVar.a(i, ((Boolean) obj).booleanValue() ? 1 : 0);
        } else {
            throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i + " Supported types: null, byte[], float, double, long, int, short, byte," + " string");
        }
    }
}
