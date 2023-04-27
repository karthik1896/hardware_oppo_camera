package com.oppo.camera.ui.preview.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import co.polarr.renderer.entities.DrawingItem;
import com.anc.sdk.AncFilterApi;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e;
import com.oppo.camera.gl.i;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: AncFilterSdk */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, byte[]> f4362a;

    /* renamed from: b  reason: collision with root package name */
    private static ExecutorService f4363b;
    private AncFilterApi c = null;
    private AncFilterApi.FilterInfo d = null;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private String i = null;
    private i j = null;

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
    }

    public void b() {
    }

    public void c() {
    }

    public void a(Context context, int i2, int i3, boolean z) {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MICROSCOPE_SUPPORT) && this.c == null) {
            e.a("initAncRender");
            this.c = new AncFilterApi();
            e.a("AncFilterSdk", "initAncRender, version: " + this.c.getVersion());
            int init = this.c.init(true);
            if (init != 0) {
                e.e("AncFilterSdk", "init, error: " + init);
            }
            this.d = new AncFilterApi.FilterInfo();
            this.g = i2;
            this.h = i3;
            e.b("initAncRender");
            e.a("AncFilterSdk", "initAncRender X");
        }
    }

    public void a(Context context, int i2, int i3) {
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MICROSCOPE_SUPPORT) && this.c == null) {
            e.a("AncFilterSdk", "initFilterEngine mAncFilterSdk");
            this.c = new AncFilterApi();
            i.i();
            int init = this.c.init(true);
            if (init != 0) {
                e.e("AncFilterSdk", "init, error: " + init);
            }
            this.j = new i(context);
            this.d = new AncFilterApi.FilterInfo();
            e.a("AncFilterSdk", "initFilterEngine mAncFilterSdk X");
        }
    }

    public boolean a() {
        return this.c != null;
    }

    public void a(int i2) {
        this.f = i2;
    }

    public void b(int i2) {
        this.e = i2;
    }

    public void a(String str) {
        this.i = str;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d() {
        /*
            r13 = this;
            java.lang.String r0 = r13.i
            int r1 = r0.hashCode()
            r2 = 7
            r3 = 6
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            r9 = 0
            switch(r1) {
                case -1978298558: goto L_0x0058;
                case -1825445326: goto L_0x004e;
                case -1272582559: goto L_0x0044;
                case 145143744: goto L_0x003a;
                case 642547229: goto L_0x0030;
                case 1186887835: goto L_0x0026;
                case 1264920692: goto L_0x001c;
                case 1579491898: goto L_0x0012;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x0062
        L_0x0012:
            java.lang.String r1 = "anc_filtert_polyspin"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0062
            r0 = r5
            goto L_0x0063
        L_0x001c:
            java.lang.String r1 = "anc_filtert_hexagon"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0062
            r0 = r8
            goto L_0x0063
        L_0x0026:
            java.lang.String r1 = "anc_filtert_kaleidoscope"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0062
            r0 = r9
            goto L_0x0063
        L_0x0030:
            java.lang.String r1 = "anc_filtert_spiral"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0062
            r0 = r7
            goto L_0x0063
        L_0x003a:
            java.lang.String r1 = "anc_filtert_cell_greenorange"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0062
            r0 = r3
            goto L_0x0063
        L_0x0044:
            java.lang.String r1 = "anc_filtert_cell_bluepink"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0062
            r0 = r2
            goto L_0x0063
        L_0x004e:
            java.lang.String r1 = "anc_filtert_concentric_circles"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0062
            r0 = r6
            goto L_0x0063
        L_0x0058:
            java.lang.String r1 = "anc_filtert_cell_gradientcolor"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0062
            r0 = r4
            goto L_0x0063
        L_0x0062:
            r0 = -1
        L_0x0063:
            r1 = 864(0x360, float:1.211E-42)
            r10 = 1152(0x480, float:1.614E-42)
            java.lang.String r11 = "curve_0.png"
            r12 = 512(0x200, float:7.175E-43)
            switch(r0) {
                case 0: goto L_0x00e1;
                case 1: goto L_0x00dc;
                case 2: goto L_0x00d7;
                case 3: goto L_0x00d2;
                case 4: goto L_0x00cd;
                case 5: goto L_0x00ae;
                case 6: goto L_0x008f;
                case 7: goto L_0x0070;
                default: goto L_0x006e;
            }
        L_0x006e:
            goto L_0x00e5
        L_0x0070:
            com.anc.sdk.AncFilterApi$FilterInfo r0 = r13.d
            r0.filterIndex = r2
            byte[] r2 = r13.b((java.lang.String) r11)
            r0.lutBuffer = r2
            com.anc.sdk.AncFilterApi$FilterInfo r0 = r13.d
            r0.lutWidth = r12
            r0.lutHeight = r12
            java.lang.String r2 = "blue_pink_3.png"
            byte[] r2 = r13.b((java.lang.String) r2)
            r0.baseImageBuffer = r2
            com.anc.sdk.AncFilterApi$FilterInfo r0 = r13.d
            r0.baseImageWidth = r10
            r0.baseImageHeight = r1
            goto L_0x00e5
        L_0x008f:
            com.anc.sdk.AncFilterApi$FilterInfo r0 = r13.d
            r0.filterIndex = r3
            byte[] r2 = r13.b((java.lang.String) r11)
            r0.lutBuffer = r2
            com.anc.sdk.AncFilterApi$FilterInfo r0 = r13.d
            r0.lutWidth = r12
            r0.lutHeight = r12
            java.lang.String r2 = "green_orange_2.png"
            byte[] r2 = r13.b((java.lang.String) r2)
            r0.baseImageBuffer = r2
            com.anc.sdk.AncFilterApi$FilterInfo r0 = r13.d
            r0.baseImageWidth = r10
            r0.baseImageHeight = r1
            goto L_0x00e5
        L_0x00ae:
            com.anc.sdk.AncFilterApi$FilterInfo r0 = r13.d
            r0.filterIndex = r4
            byte[] r2 = r13.b((java.lang.String) r11)
            r0.lutBuffer = r2
            com.anc.sdk.AncFilterApi$FilterInfo r0 = r13.d
            r0.lutWidth = r12
            r0.lutHeight = r12
            java.lang.String r2 = "yellow_green_1.png"
            byte[] r2 = r13.b((java.lang.String) r2)
            r0.baseImageBuffer = r2
            com.anc.sdk.AncFilterApi$FilterInfo r0 = r13.d
            r0.baseImageWidth = r10
            r0.baseImageHeight = r1
            goto L_0x00e5
        L_0x00cd:
            com.anc.sdk.AncFilterApi$FilterInfo r0 = r13.d
            r0.filterIndex = r5
            goto L_0x00e5
        L_0x00d2:
            com.anc.sdk.AncFilterApi$FilterInfo r0 = r13.d
            r0.filterIndex = r6
            goto L_0x00e5
        L_0x00d7:
            com.anc.sdk.AncFilterApi$FilterInfo r0 = r13.d
            r0.filterIndex = r7
            goto L_0x00e5
        L_0x00dc:
            com.anc.sdk.AncFilterApi$FilterInfo r0 = r13.d
            r0.filterIndex = r8
            goto L_0x00e5
        L_0x00e1:
            com.anc.sdk.AncFilterApi$FilterInfo r0 = r13.d
            r0.filterIndex = r9
        L_0x00e5:
            com.anc.sdk.AncFilterApi r0 = r13.c
            com.anc.sdk.AncFilterApi$FilterInfo r1 = r13.d
            r0.setFilterInfo(r1)
            com.anc.sdk.AncFilterApi r2 = r13.c
            int r3 = r13.e
            int r4 = r13.f
            r5 = 0
            r6 = 1
            r7 = 0
            int r8 = r13.g
            int r9 = r13.h
            r10 = 0
            int r0 = r2.process(r3, r4, r5, r6, r7, r8, r9, r10)
            if (r0 == 0) goto L_0x0116
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "drawFrame, error: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "AncFilterSdk"
            com.oppo.camera.e.e(r1, r0)
        L_0x0116:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.a.b.d():void");
    }

    private byte[] b(String str) {
        if (f4362a == null) {
            f4362a = new ConcurrentHashMap();
        }
        if (f4363b == null) {
            f4363b = Executors.newSingleThreadExecutor();
        }
        if (!f4362a.containsKey(str)) {
            f4363b.submit(new Runnable(str) {
                private final /* synthetic */ String f$0;

                {
                    this.f$0 = r1;
                }

                public final void run() {
                    b.c(this.f$0);
                }
            });
        }
        return f4362a.get(str);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c(String str) {
        if (!f4362a.containsKey(str)) {
            Bitmap decodeFile = BitmapFactory.decodeFile("/odm/etc/camera/micFilter/" + str);
            ByteBuffer allocate = ByteBuffer.allocate(decodeFile.getByteCount());
            decodeFile.copyPixelsToBuffer(allocate);
            f4362a.put(str, allocate.array());
            e.b("AncFilterSdk", "getLutBuffer, load: " + str);
        }
    }

    public void e() {
        e.a("AncFilterSdk", "destroyEngine, mAncFilterApi: " + this.c);
        AncFilterApi ancFilterApi = this.c;
        if (ancFilterApi != null) {
            ancFilterApi.release();
            i.i();
            this.c = null;
            this.d = null;
        }
        i iVar = this.j;
        if (iVar != null) {
            iVar.a();
            this.j = null;
        }
        Map<String, byte[]> map = f4362a;
        if (map != null) {
            map.clear();
        }
    }

    public void a(List<DrawingItem> list, int i2, int i3, float f2, float f3) {
        this.j.a(this, list, i2, i3, f3);
    }

    public void a(int i2, int i3) {
        this.g = i2;
        this.h = i3;
    }
}
