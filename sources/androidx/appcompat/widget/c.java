package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ActivityChooserModel */
class c extends DataSetObservable {

    /* renamed from: a  reason: collision with root package name */
    static final String f435a = "c";
    private static final Object e = new Object();
    private static final Map<String, c> f = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final Context f436b;
    final String c;
    boolean d;
    private final Object g;
    private final List<a> h;
    private final List<C0008c> i;
    private Intent j;
    private b k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;
    private d p;

    /* compiled from: ActivityChooserModel */
    public interface b {
        void a(Intent intent, List<a> list, List<C0008c> list2);
    }

    /* compiled from: ActivityChooserModel */
    public interface d {
        boolean a(c cVar, Intent intent);
    }

    public int a() {
        int size;
        synchronized (this.g) {
            d();
            size = this.h.size();
        }
        return size;
    }

    public ResolveInfo a(int i2) {
        ResolveInfo resolveInfo;
        synchronized (this.g) {
            d();
            resolveInfo = this.h.get(i2).f437a;
        }
        return resolveInfo;
    }

    public int a(ResolveInfo resolveInfo) {
        synchronized (this.g) {
            d();
            List<a> list = this.h;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2).f437a == resolveInfo) {
                    return i2;
                }
            }
            return -1;
        }
    }

    public Intent b(int i2) {
        synchronized (this.g) {
            if (this.j == null) {
                return null;
            }
            d();
            a aVar = this.h.get(i2);
            ComponentName componentName = new ComponentName(aVar.f437a.activityInfo.packageName, aVar.f437a.activityInfo.name);
            Intent intent = new Intent(this.j);
            intent.setComponent(componentName);
            if (this.p != null) {
                if (this.p.a(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new C0008c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo b() {
        synchronized (this.g) {
            d();
            if (this.h.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = this.h.get(0).f437a;
            return resolveInfo;
        }
    }

    public void c(int i2) {
        synchronized (this.g) {
            d();
            a aVar = this.h.get(i2);
            a aVar2 = this.h.get(0);
            a(new C0008c(new ComponentName(aVar.f437a.activityInfo.packageName, aVar.f437a.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.f438b - aVar.f438b) + 5.0f : 1.0f));
        }
    }

    private void c() {
        if (!this.m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.n) {
            this.n = false;
            if (!TextUtils.isEmpty(this.c)) {
                new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.i), this.c});
            }
        }
    }

    private void d() {
        boolean f2 = f() | g();
        h();
        if (f2) {
            e();
            notifyChanged();
        }
    }

    private boolean e() {
        if (this.k == null || this.j == null || this.h.isEmpty() || this.i.isEmpty()) {
            return false;
        }
        this.k.a(this.j, this.h, Collections.unmodifiableList(this.i));
        return true;
    }

    private boolean f() {
        if (!this.o || this.j == null) {
            return false;
        }
        this.o = false;
        this.h.clear();
        List<ResolveInfo> queryIntentActivities = this.f436b.getPackageManager().queryIntentActivities(this.j, 0);
        int size = queryIntentActivities.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.h.add(new a(queryIntentActivities.get(i2)));
        }
        return true;
    }

    private boolean g() {
        if (!this.d || !this.n || TextUtils.isEmpty(this.c)) {
            return false;
        }
        this.d = false;
        this.m = true;
        i();
        return true;
    }

    private boolean a(C0008c cVar) {
        boolean add = this.i.add(cVar);
        if (add) {
            this.n = true;
            h();
            c();
            e();
            notifyChanged();
        }
        return add;
    }

    private void h() {
        int size = this.i.size() - this.l;
        if (size > 0) {
            this.n = true;
            for (int i2 = 0; i2 < size; i2++) {
                C0008c remove = this.i.remove(0);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.c$c  reason: collision with other inner class name */
    /* compiled from: ActivityChooserModel */
    public static final class C0008c {

        /* renamed from: a  reason: collision with root package name */
        public final ComponentName f439a;

        /* renamed from: b  reason: collision with root package name */
        public final long f440b;
        public final float c;

        public C0008c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public C0008c(ComponentName componentName, long j, float f) {
            this.f439a = componentName;
            this.f440b = j;
            this.c = f;
        }

        public int hashCode() {
            ComponentName componentName = this.f439a;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j = this.f440b;
            return ((((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + Float.floatToIntBits(this.c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0008c cVar = (C0008c) obj;
            ComponentName componentName = this.f439a;
            if (componentName == null) {
                if (cVar.f439a != null) {
                    return false;
                }
            } else if (!componentName.equals(cVar.f439a)) {
                return false;
            }
            return this.f440b == cVar.f440b && Float.floatToIntBits(this.c) == Float.floatToIntBits(cVar.c);
        }

        public String toString() {
            return "[" + "; activity:" + this.f439a + "; time:" + this.f440b + "; weight:" + new BigDecimal((double) this.c) + "]";
        }
    }

    /* compiled from: ActivityChooserModel */
    public static final class a implements Comparable<a> {

        /* renamed from: a  reason: collision with root package name */
        public final ResolveInfo f437a;

        /* renamed from: b  reason: collision with root package name */
        public float f438b;

        public a(ResolveInfo resolveInfo) {
            this.f437a = resolveInfo;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f438b) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.f438b) == Float.floatToIntBits(((a) obj).f438b);
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            return Float.floatToIntBits(aVar.f438b) - Float.floatToIntBits(this.f438b);
        }

        public String toString() {
            return "[" + "resolveInfo:" + this.f437a.toString() + "; weight:" + new BigDecimal((double) this.f438b) + "]";
        }
    }

    private void i() {
        try {
            FileInputStream openFileInput = this.f436b.openFileInput(this.c);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i2 = 0;
                while (i2 != 1 && i2 != 2) {
                    i2 = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List<C0008c> list = this.i;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            if (openFileInput == null) {
                                return;
                            }
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new C0008c(newPullParser.getAttributeValue((String) null, "activity"), Long.parseLong(newPullParser.getAttributeValue((String) null, "time")), Float.parseFloat(newPullParser.getAttributeValue((String) null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    try {
                        openFileInput.close();
                    } catch (IOException unused) {
                    }
                } else {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
            } catch (XmlPullParserException e2) {
                String str = f435a;
                Log.e(str, "Error reading historical recrod file: " + this.c, e2);
                if (openFileInput == null) {
                }
            } catch (IOException e3) {
                String str2 = f435a;
                Log.e(str2, "Error reading historical recrod file: " + this.c, e3);
                if (openFileInput == null) {
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        }
    }

    /* compiled from: ActivityChooserModel */
    private final class e extends AsyncTask<Object, Void, Void> {
        e() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x006d, code lost:
            if (r15 != null) goto L_0x006f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r15.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0092, code lost:
            if (r15 == null) goto L_0x00d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b2, code lost:
            if (r15 == null) goto L_0x00d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d2, code lost:
            if (r15 == null) goto L_0x00d5;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(java.lang.Object... r15) {
            /*
                r14 = this;
                java.lang.String r0 = "historical-record"
                java.lang.String r1 = "historical-records"
                java.lang.String r2 = "Error writing historical record file: "
                r3 = 0
                r4 = r15[r3]
                java.util.List r4 = (java.util.List) r4
                r5 = 1
                r15 = r15[r5]
                java.lang.String r15 = (java.lang.String) r15
                r6 = 0
                androidx.appcompat.widget.c r7 = androidx.appcompat.widget.c.this     // Catch:{ FileNotFoundException -> 0x00e0 }
                android.content.Context r7 = r7.f436b     // Catch:{ FileNotFoundException -> 0x00e0 }
                java.io.FileOutputStream r15 = r7.openFileOutput(r15, r3)     // Catch:{ FileNotFoundException -> 0x00e0 }
                org.xmlpull.v1.XmlSerializer r7 = android.util.Xml.newSerializer()
                r7.setOutput(r15, r6)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r8 = "UTF-8"
                java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.startDocument(r8, r9)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.startTag(r6, r1)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                int r8 = r4.size()     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r9 = r3
            L_0x0031:
                if (r9 >= r8) goto L_0x0063
                java.lang.Object r10 = r4.remove(r3)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                androidx.appcompat.widget.c$c r10 = (androidx.appcompat.widget.c.C0008c) r10     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.startTag(r6, r0)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r11 = "activity"
                android.content.ComponentName r12 = r10.f439a     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r12 = r12.flattenToString()     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.attribute(r6, r11, r12)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r11 = "time"
                long r12 = r10.f440b     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.attribute(r6, r11, r12)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r11 = "weight"
                float r10 = r10.c     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.attribute(r6, r11, r10)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.endTag(r6, r0)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                int r9 = r9 + 1
                goto L_0x0031
            L_0x0063:
                r7.endTag(r6, r1)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.endDocument()     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                androidx.appcompat.widget.c r0 = androidx.appcompat.widget.c.this
                r0.d = r5
                if (r15 == 0) goto L_0x00d5
            L_0x006f:
                r15.close()     // Catch:{ IOException -> 0x00d5 }
                goto L_0x00d5
            L_0x0073:
                r0 = move-exception
                goto L_0x00d6
            L_0x0075:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.c.f435a     // Catch:{ all -> 0x0073 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
                r3.<init>()     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.c r2 = androidx.appcompat.widget.c.this     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r2.c     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0073 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.c r0 = androidx.appcompat.widget.c.this
                r0.d = r5
                if (r15 == 0) goto L_0x00d5
                goto L_0x006f
            L_0x0095:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.c.f435a     // Catch:{ all -> 0x0073 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
                r3.<init>()     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.c r2 = androidx.appcompat.widget.c.this     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r2.c     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0073 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.c r0 = androidx.appcompat.widget.c.this
                r0.d = r5
                if (r15 == 0) goto L_0x00d5
                goto L_0x006f
            L_0x00b5:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.c.f435a     // Catch:{ all -> 0x0073 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
                r3.<init>()     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.c r2 = androidx.appcompat.widget.c.this     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r2.c     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0073 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.c r0 = androidx.appcompat.widget.c.this
                r0.d = r5
                if (r15 == 0) goto L_0x00d5
                goto L_0x006f
            L_0x00d5:
                return r6
            L_0x00d6:
                androidx.appcompat.widget.c r1 = androidx.appcompat.widget.c.this
                r1.d = r5
                if (r15 == 0) goto L_0x00df
                r15.close()     // Catch:{ IOException -> 0x00df }
            L_0x00df:
                throw r0
            L_0x00e0:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.c.f435a
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r2)
                r3.append(r15)
                java.lang.String r15 = r3.toString()
                android.util.Log.e(r1, r15, r0)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.c.e.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }
}
