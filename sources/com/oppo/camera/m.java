package com.oppo.camera;

import android.content.Context;
import android.graphics.Rect;
import android.os.AsyncTask;
import com.crunchfish.touchless_a3d.TouchlessA3D;
import com.crunchfish.touchless_a3d.exception.LicenseNotValidException;
import com.crunchfish.touchless_a3d.exception.LicenseServerUnavailableException;
import com.crunchfish.touchless_a3d.gesture.Event;
import com.crunchfish.touchless_a3d.gesture.Gesture;
import com.crunchfish.touchless_a3d.gesture.Pose;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: GestureEngineManager */
public class m implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f3125a = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Gesture.Listener f3126b = new Gesture.Listener() {
        public void onEvent(Event event) {
            Pose pose;
            e.a("GestureEngineManager", "GestureListener, onEvent, text: " + event.getText());
            if (m.this.n != null && m.this.a(event, "open_hand") && (pose = (Pose) event.getIdentifiable("the_hand")) != null) {
                m.this.n.a(pose.getBoundingArea());
            }
        }
    };
    /* access modifiers changed from: private */
    public TouchlessA3D c;
    /* access modifiers changed from: private */
    public Gesture d;
    private Object e = new Object();
    private boolean f = false;
    private boolean g = false;
    /* access modifiers changed from: private */
    public Context h;
    private AsyncTask i = null;
    private AsyncTask j = null;
    private HashMap<Integer, TouchlessA3D.Rotate> k = new HashMap<>();
    private HashMap<Integer, TouchlessA3D.Rotate> l = new HashMap<>();
    private HashMap<Integer, HashMap<Integer, TouchlessA3D.Rotate>> m = new HashMap<>();
    /* access modifiers changed from: private */
    public c n;

    /* compiled from: GestureEngineManager */
    public interface c {
        void a(Rect rect);
    }

    public m() {
        this.k.put(-1, TouchlessA3D.Rotate.ROTATE_270);
        this.k.put(0, TouchlessA3D.Rotate.ROTATE_270);
        this.k.put(90, TouchlessA3D.Rotate.ROTATE_180);
        this.k.put(180, TouchlessA3D.Rotate.ROTATE_90);
        this.k.put(270, TouchlessA3D.Rotate.DO_NOT_ROTATE);
        this.l.put(-1, TouchlessA3D.Rotate.ROTATE_90);
        this.l.put(0, TouchlessA3D.Rotate.ROTATE_90);
        this.l.put(90, TouchlessA3D.Rotate.ROTATE_180);
        this.l.put(180, TouchlessA3D.Rotate.ROTATE_270);
        this.l.put(270, TouchlessA3D.Rotate.DO_NOT_ROTATE);
        this.m.put(0, this.l);
        this.m.put(1, this.k);
    }

    public void a(Context context, int i2, int i3) {
        this.f = true;
        this.i = new a(context, i2, i3).executeOnExecutor(this.f3125a, new Void[0]);
    }

    /* access modifiers changed from: private */
    public boolean a(Event event, String str) {
        return event.getText().equals(str);
    }

    public void a(c cVar) {
        this.n = cVar;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public boolean a() {
        return this.g;
    }

    public void a(byte[] bArr, int i2, int i3) {
        synchronized (this.e) {
            if (this.c != null) {
                this.c.handleImage(System.currentTimeMillis(), bArr, (TouchlessA3D.Rotate) this.m.get(Integer.valueOf(i2)).get(Integer.valueOf(i3)));
            }
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        synchronized (this.e) {
            if (this.d != null) {
                this.d.unregisterListener(this.f3126b);
            }
            if (this.c != null) {
                this.c.unregisterGesture(this.d);
                this.c.close();
                e.a("GestureEngineManager", "gesture detect engine has released");
            }
            this.d = null;
            this.c = null;
        }
    }

    public void close() {
        this.f = false;
        this.n = null;
        this.j = new b().executeOnExecutor(this.f3125a, new Void[0]);
    }

    public boolean b() {
        return this.f;
    }

    public void c() {
        AsyncTask asyncTask = this.i;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.i = null;
        }
        AsyncTask asyncTask2 = this.j;
        if (asyncTask2 != null) {
            asyncTask2.cancel(true);
            this.j = null;
        }
    }

    public void d() {
        HashMap<Integer, HashMap<Integer, TouchlessA3D.Rotate>> hashMap = this.m;
        if (hashMap != null) {
            hashMap.clear();
            this.m = null;
        }
        HashMap<Integer, TouchlessA3D.Rotate> hashMap2 = this.l;
        if (hashMap2 != null) {
            hashMap2.clear();
            this.l = null;
        }
        HashMap<Integer, TouchlessA3D.Rotate> hashMap3 = this.k;
        if (hashMap3 != null) {
            hashMap3.clear();
            this.k = null;
        }
        this.h = null;
        this.n = null;
    }

    /* compiled from: GestureEngineManager */
    private class b extends AsyncTask<Void, Void, Void> {
        private b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            m.this.e();
            return null;
        }
    }

    /* compiled from: GestureEngineManager */
    private class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: b  reason: collision with root package name */
        private final int f3129b;
        private final int c;
        private boolean d = true;

        public a(Context context, int i, int i2) {
            Context unused = m.this.h = context;
            this.f3129b = i;
            this.c = i2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            m.this.e();
            if (m.this.h == null) {
                return null;
            }
            try {
                TouchlessA3D unused = m.this.c = new TouchlessA3D(this.f3129b, this.c, m.this.h);
                m.this.c.setParameter(TouchlessA3D.Parameters.EXTENDED_RANGE, 1);
                e.a("GestureEngineManager", "gesture detect engine has be inited mImageWidth:" + this.f3129b + " mImageHeight:" + this.c);
                try {
                    Gesture unused2 = m.this.d = a("hand_wink.json");
                    if (m.this.d != null) {
                        m.this.d.registerListener(m.this.f3126b);
                        m.this.c.registerGesture(m.this.d);
                    }
                    return null;
                } catch (IOException e) {
                    e.e("GestureEngineManager", "GestureEngineLoadTask IOException: " + e);
                    return null;
                }
            } catch (LicenseNotValidException e2) {
                e.e("GestureEngineManager", "GestureEngineLoadTask LicenseNotValidException: " + e2);
                this.d = false;
                return null;
            } catch (LicenseServerUnavailableException e3) {
                e.e("GestureEngineManager", "GestureEngineLoadTask LicenseServerUnavailableException: " + e3);
                this.d = false;
                return null;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
            if (r8 != null) goto L_0x001f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
            r8.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
            if (r8 == null) goto L_0x0049;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
            if (r1 == null) goto L_0x0056;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0055, code lost:
            return new com.crunchfish.touchless_a3d.gesture.Gesture(new java.lang.String(r1));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0056, code lost:
            return null;
         */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x005a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private com.crunchfish.touchless_a3d.gesture.Gesture a(java.lang.String r8) throws java.io.IOException {
            /*
                r7 = this;
                r0 = 0
                com.oppo.camera.m r1 = com.oppo.camera.m.this     // Catch:{ Exception -> 0x002d, all -> 0x0028 }
                android.content.Context r1 = r1.h     // Catch:{ Exception -> 0x002d, all -> 0x0028 }
                android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ Exception -> 0x002d, all -> 0x0028 }
                java.io.InputStream r8 = r1.open(r8)     // Catch:{ Exception -> 0x002d, all -> 0x0028 }
                int r1 = r8.available()     // Catch:{ Exception -> 0x0025 }
                byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x0025 }
                int r2 = r8.read(r1)     // Catch:{ Exception -> 0x0023 }
                r3 = -1
                if (r3 != r2) goto L_0x001d
                r1 = r0
            L_0x001d:
                if (r8 == 0) goto L_0x0049
            L_0x001f:
                r8.close()
                goto L_0x0049
            L_0x0023:
                r2 = move-exception
                goto L_0x0030
            L_0x0025:
                r2 = move-exception
                r1 = r0
                goto L_0x0030
            L_0x0028:
                r8 = move-exception
                r6 = r0
                r0 = r8
                r8 = r6
                goto L_0x0058
            L_0x002d:
                r2 = move-exception
                r8 = r0
                r1 = r8
            L_0x0030:
                java.lang.String r3 = "GestureEngineManager"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
                r4.<init>()     // Catch:{ all -> 0x0057 }
                java.lang.String r5 = "readGestureJson Exception: "
                r4.append(r5)     // Catch:{ all -> 0x0057 }
                r4.append(r2)     // Catch:{ all -> 0x0057 }
                java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0057 }
                com.oppo.camera.e.e(r3, r2)     // Catch:{ all -> 0x0057 }
                if (r8 == 0) goto L_0x0049
                goto L_0x001f
            L_0x0049:
                if (r1 == 0) goto L_0x0056
                com.crunchfish.touchless_a3d.gesture.Gesture r8 = new com.crunchfish.touchless_a3d.gesture.Gesture
                java.lang.String r0 = new java.lang.String
                r0.<init>(r1)
                r8.<init>(r0)
                return r8
            L_0x0056:
                return r0
            L_0x0057:
                r0 = move-exception
            L_0x0058:
                if (r8 == 0) goto L_0x005d
                r8.close()
            L_0x005d:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.m.a.a(java.lang.String):com.crunchfish.touchless_a3d.gesture.Gesture");
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            if (!this.d) {
                e.e("GestureEngineManager", "Gesture engine init fail");
            }
        }
    }
}
