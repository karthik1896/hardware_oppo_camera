package com.oppo.camera.ui.preview.a;

import android.content.Context;
import android.graphics.RectF;
import android.util.Size;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e;
import com.oppo.camera.gl.h;
import com.oppo.camera.gl.i;
import com.oppo.camera.gl.s;
import com.oppo.camera.sticker.b;
import com.oppo.camera.sticker.c;
import com.oppo.camera.sticker.d;
import com.oppo.camera.sticker.data.MultiStickerExtendedInfo;
import com.oppo.camera.sticker.data.StickerItem;
import com.oppo.camera.sticker.g;
import com.oppo.camera.ui.preview.a.s;
import com.oppo.camera.util.Util;
import com.sensetime.stmobile.STGLRender;
import com.sensetime.stmobile.STMobileHardwareBufferNative;
import com.sensetime.stmobile.STMobileHumanActionNative;
import com.sensetime.stmobile.STSoundPlayManager;
import com.sensetime.stmobile.model.STHumanAction;
import com.sensetime.stmobile.model.STStickerInputParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: StickerTexturePreview */
public class q extends s {
    private boolean A = true;
    private boolean B = false;
    private float C = 1.0f;
    private final Object D = new Object();
    /* access modifiers changed from: private */
    public final Object E = new Object();
    private d F = null;
    private ConcurrentHashMap<b, List<MultiStickerExtendedInfo>> G = null;
    private CopyOnWriteArrayList<b> H = new CopyOnWriteArrayList<>();
    private STMobileHumanActionNative I = null;
    private STMobileHardwareBufferNative J = null;
    private STGLRender K = null;
    private byte[] L = null;

    /* renamed from: a  reason: collision with root package name */
    private int f4422a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f4423b = 0;
    private int c = 0;
    private int i = 0;
    private int j = 0;
    private boolean k = false;
    private volatile int l = 0;
    private int m = 0;
    private ArrayList<s> n = new ArrayList<>();
    private s o = null;
    private s p = null;
    private s q = null;
    private boolean r = false;
    private boolean s = false;
    /* access modifiers changed from: private */
    public volatile boolean t = false;
    private u u = null;
    private STSoundPlayManager v = null;
    private ArrayList<Long> w = null;
    private ArrayList<Long> x = null;
    private Map<Long, Integer> y = null;
    private Map<Long, Integer> z = null;

    public void a(long j2) {
    }

    public void a(Size size, boolean z2) {
    }

    public boolean a() {
        return false;
    }

    public int d() {
        return 8;
    }

    public q(Context context) {
        super(context);
    }

    public void a(u uVar) {
        this.u = uVar;
    }

    public void e() {
        e.a("StickerTexturePreview", "destroyEngine");
    }

    public s f() {
        return this.q;
    }

    public s g() {
        return this.p;
    }

    public void b(int i2) {
        this.l = i2;
        int i3 = this.l;
        if (i3 == 0) {
            this.m = 0;
        } else if (i3 == 90) {
            this.m = 1;
        } else if (i3 == 180) {
            this.m = 2;
        } else if (i3 == 270) {
            this.m = 3;
        }
    }

    private void w() {
        if (this.z == null) {
            this.z = new HashMap();
            this.z.put(2L, Integer.valueOf(R.string.sticker_hint_blink));
            this.z.put(4L, Integer.valueOf(R.string.sticker_hint_open_month));
            this.z.put(8L, Integer.valueOf(R.string.sticker_hint_shake_head));
            this.z.put(16L, Integer.valueOf(R.string.sticker_hint_node_head));
            this.z.put(32L, Integer.valueOf(R.string.sticker_hint_pick_eyebrow));
        }
        if (this.y == null) {
            this.y = new HashMap();
            this.y.put(4096L, Integer.valueOf(R.string.sticker_hint_show_palm));
            this.y.put(16384L, Integer.valueOf(R.string.sticker_hint_heart_shape_two_hand));
            this.y.put(32768L, Integer.valueOf(R.string.sticker_hint_hold_up_hand));
            this.y.put(131072L, Integer.valueOf(R.string.sticker_hint_congratulate));
            this.y.put(262144L, Integer.valueOf(R.string.sticker_hint_heart_shape_one_hand));
            this.y.put(2048L, Integer.valueOf(R.string.sticker_hint_thumb_up));
            this.y.put(512L, Integer.valueOf(R.string.sticker_hint_ok));
            this.y.put(1024L, Integer.valueOf(R.string.sticker_hint_yeah));
            this.y.put(8192L, Integer.valueOf(R.string.sticker_hint_pistol));
            this.y.put(1048576L, Integer.valueOf(R.string.sticker_hint_index_finger));
        }
    }

    private void x() {
        if (!this.s && this.r && this.t) {
            e.a("initGLRes");
            e.a("StickerTexturePreview", "initGLRes");
            synchronized (this.E) {
                B();
            }
            this.v = new STSoundPlayManager(this.h);
            synchronized (this.E) {
                this.s = true;
            }
            e.b("initGLRes");
        }
    }

    public void l() {
        STSoundPlayManager sTSoundPlayManager = this.v;
        if (sTSoundPlayManager != null) {
            sTSoundPlayManager.pauseSound();
        }
    }

    public void m() {
        STSoundPlayManager sTSoundPlayManager = this.v;
        if (sTSoundPlayManager != null) {
            sTSoundPlayManager.resumeSound();
        }
    }

    private void y() {
        STSoundPlayManager sTSoundPlayManager = this.v;
        if (sTSoundPlayManager != null) {
            sTSoundPlayManager.release();
            this.v = null;
        }
    }

    public void a(int i2, int i3) {
        e.a("StickerTexturePreview", "setSize, height: " + i2 + ", width: " + i3 + ", mCameraId: " + this.d);
        if (i3 > 0 && i2 > 0) {
            this.f4422a = i2;
            this.f4423b = i3;
            this.c = this.e ? 320 : 480;
            int i4 = this.f4422a;
            int i5 = this.f4423b;
            if (i4 >= i5) {
                int i6 = this.c;
                this.C = ((float) i4) / ((float) i6);
                this.i = i6;
                this.j = (i5 * i6) / i4;
                return;
            }
            int i7 = this.c;
            this.C = ((float) i5) / ((float) i7);
            this.j = i7;
            this.i = (i4 * i7) / i5;
        }
    }

    public void n() {
        if (this.g != null) {
            this.g.a();
        }
    }

    public boolean h() {
        StickerItem j2 = this.u.j();
        if (!this.r || j2 == null) {
            e.e("StickerTexturePreview", "updateMaterialInfos, mbTextureInited: " + this.r + ", item: " + j2);
            return false;
        }
        e.a("Sticker.onPreviewEffectChanged");
        z();
        this.B = true;
        HashMap<String, List<MultiStickerExtendedInfo>> a2 = a(j2.getStickerName());
        HashMap<String, b> a3 = a(a2);
        ConcurrentHashMap<b, List<MultiStickerExtendedInfo>> concurrentHashMap = this.G;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        } else {
            this.G = new ConcurrentHashMap<>();
        }
        if (a3 != null) {
            for (String next : a3.keySet()) {
                this.G.put(a3.get(next), a2.get(next));
            }
        }
        e.b("Sticker.onPreviewEffectChanged");
        return true;
    }

    private HashMap<String, List<MultiStickerExtendedInfo>> a(String str) {
        StickerItem j2 = this.u.j();
        if (j2 == null) {
            e.e("StickerTexturePreview", "getExtendedInfoMap, item is null");
            return null;
        }
        List<MultiStickerExtendedInfo> a2 = g.a(this.h, j2);
        HashMap<String, List<MultiStickerExtendedInfo>> hashMap = new HashMap<>();
        if (a2 == null || a2.size() <= 0) {
            hashMap.put(str, new ArrayList());
        } else {
            for (MultiStickerExtendedInfo next : a2) {
                if (next != null) {
                    if (hashMap.containsKey(next.getStickerName())) {
                        hashMap.get(next.getStickerName()).add(next);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(next);
                        hashMap.put(next.getStickerName(), arrayList);
                    }
                }
            }
        }
        return hashMap;
    }

    private HashMap<String, b> a(HashMap<String, List<MultiStickerExtendedInfo>> hashMap) {
        String str;
        s sVar;
        StickerItem j2 = this.u.j();
        if (j2 == null || hashMap == null) {
            e.e("StickerTexturePreview", "getMaterialInfoMap, item: " + j2 + ", extendedInfoMap: " + hashMap);
            return null;
        }
        String fileContentUri = j2.getFileContentUri();
        HashMap<String, b> hashMap2 = new HashMap<>();
        synchronized (this.E) {
            String str2 = fileContentUri;
            int i2 = 0;
            int i3 = 0;
            for (String next : hashMap.keySet()) {
                List list = hashMap.get(next);
                if (i2 >= this.H.size()) {
                    e.e("StickerTexturePreview", "getMaterialInfoMap, Just support " + this.H.size() + " materials.");
                } else {
                    int i4 = i2 + 1;
                    b bVar = this.H.get(i2);
                    if (list == null || list.size() <= 0) {
                        str = str2;
                        sVar = this.p;
                    } else {
                        if (((MultiStickerExtendedInfo) list.get(0)).getPositionType() == 0) {
                            sVar = this.o;
                        } else if (((MultiStickerExtendedInfo) list.get(0)).getPositionType() == 2) {
                            sVar = this.p;
                        } else {
                            sVar = this.n.get(i3);
                            i3++;
                        }
                        str = c.a((MultiStickerExtendedInfo) list.get(0), Util.b(this.f4423b, this.f4422a));
                    }
                    bVar.a((float) (this.f4422a / sVar.e()));
                    bVar.a(sVar);
                    a(bVar, str);
                    hashMap2.put(next, bVar);
                    str2 = str;
                    i2 = i4;
                }
            }
        }
        return hashMap2;
    }

    private void a(b bVar, String str) {
        e.a("StickerTexturePreview", "changeStickerNative, sticker: " + str);
        l.b(this.h);
        byte[] a2 = l.a(this.h, str);
        if (a2 != null) {
            bVar.a().changeStickerFromBuffer(a2, a2.length);
        } else {
            e.e("StickerTexturePreview", "changeStickerNative failed, bytes: " + a2);
        }
        n();
        b(bVar.a().getTriggerAction());
        a(bVar, str, bVar.a().getTriggerAction());
    }

    private void z() {
        StickerItem j2 = this.u.j();
        if (j2 != null) {
            l b2 = l.b(this.h);
            STSoundPlayManager sTSoundPlayManager = this.v;
            if (sTSoundPlayManager != null) {
                sTSoundPlayManager.setPauseState(b2.a(j2.getStickerUUID()));
                return;
            }
            return;
        }
        e.e("StickerTexturePreview", "checkStickerMusicPauseState, non selected sticker!");
    }

    private void A() {
        if (this.H != null) {
            e.e("StickerTexturePreview", "destroyStInstance");
            Iterator<b> it = this.H.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null) {
                    next.a().destroyInstance();
                }
            }
            this.H.clear();
        }
    }

    private void B() {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = this.H;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() == 0) {
            e.e("StickerTexturePreview", "createStInstance");
            for (int i2 = 0; i2 < 5; i2++) {
                b bVar = new b();
                bVar.a().createInstance(Util.f());
                this.H.add(bVar);
            }
        }
    }

    public void c() {
        Util.a((Runnable) new Runnable() {
            public void run() {
                e.a("Sticker.initHumanAction");
                synchronized (q.this.E) {
                    q.this.p();
                    boolean unused = q.this.t = true;
                }
                e.b("Sticker.initHumanAction");
            }
        });
    }

    public void i() {
        e.a("StickerTexturePreview", "newTextures");
        e.a("Sticker.newTextures");
        for (int i2 = 0; i2 < 4; i2++) {
            this.n.add(new s(this.f4422a / 2, this.f4423b / 2, true));
        }
        this.o = new s(this.f4422a, this.f4423b, true);
        this.p = new s(this.f4422a, this.f4423b, true);
        this.q = new s(this.f4422a, this.f4423b, true);
        this.r = true;
        e.b("Sticker.newTextures");
    }

    public void a(h hVar) {
        x();
        e.a("Sticker.prepareTextures");
        ArrayList<s> arrayList = this.n;
        if (arrayList != null) {
            Iterator<s> it = arrayList.iterator();
            while (it.hasNext()) {
                s next = it.next();
                if (next != null && !next.k()) {
                    next.c(hVar);
                    e.a("StickerTexturePreview", "prepareTextures, texture id: " + next.d());
                }
            }
        }
        s sVar = this.o;
        if (sVar != null && !sVar.k()) {
            this.o.c(hVar);
            e.a("StickerTexturePreview", "prepareTextures, texture id: " + this.o.d());
        }
        s sVar2 = this.p;
        if (sVar2 != null && !sVar2.k()) {
            this.p.c(hVar);
            e.a("StickerTexturePreview", "prepareTextures, texture id: " + this.p.d());
        }
        s sVar3 = this.q;
        if (sVar3 != null && !sVar3.k()) {
            this.q.c(hVar);
            e.a("StickerTexturePreview", "prepareTextures, texture id: " + this.q.d());
        }
        e.b("Sticker.prepareTextures");
    }

    public void j() {
        e.a("StickerTexturePreview", "recycleTextures, mbGLInit: " + this.s + ", mbTextureInited: " + this.r);
        if (this.s) {
            e.a("Sticker.eglInit");
            synchronized (this.E) {
                if (this.I != null) {
                    this.I.reset();
                }
            }
            this.k = false;
            y();
            Map<Long, Integer> map = this.y;
            if (map != null) {
                map.clear();
                this.y = null;
            }
            Map<Long, Integer> map2 = this.z;
            if (map2 != null) {
                map2.clear();
                this.z = null;
            }
            n();
            this.s = false;
            e.b("Sticker.eglInit");
        }
        if (this.r) {
            e.a("Sticker.recycleTextures");
            ArrayList<s> arrayList = this.n;
            if (arrayList != null) {
                Iterator<s> it = arrayList.iterator();
                while (it.hasNext()) {
                    s next = it.next();
                    if (next != null) {
                        e.a("StickerTexturePreview", "recycleTextures, texture id: " + next.d());
                        next.l();
                    }
                }
                this.n.clear();
            }
            if (this.o != null) {
                e.a("StickerTexturePreview", "recycleTextures, texture id: " + this.o.d());
                this.o.l();
                this.o = null;
            }
            if (this.p != null) {
                e.a("StickerTexturePreview", "recycleTextures, texture id: " + this.p.d());
                this.p.l();
                this.p = null;
            }
            if (this.q != null) {
                e.a("StickerTexturePreview", "recycleTextures, texture id: " + this.q.d());
                this.q.l();
                this.q = null;
            }
            STMobileHardwareBufferNative sTMobileHardwareBufferNative = this.J;
            if (sTMobileHardwareBufferNative != null) {
                sTMobileHardwareBufferNative.release();
                this.J = null;
                this.L = null;
                STGLRender sTGLRender = this.K;
                if (sTGLRender != null) {
                    sTGLRender.destroy();
                    this.K = null;
                }
            }
            this.r = false;
            e.b("Sticker.recycleTextures");
        }
    }

    private void a(b bVar, String str, long j2) {
        if (str == null) {
            j2 = 0;
        }
        bVar.a(j2);
    }

    private void a(STHumanAction sTHumanAction) {
        for (b next : this.G.keySet()) {
            next.b(sTHumanAction);
            next.a(sTHumanAction);
            b(next.b(this.C));
        }
    }

    private int a(s sVar) {
        e.a("processNoFrontTexture");
        int i2 = -1;
        for (b next : this.G.keySet()) {
            List list = this.G.get(next);
            if (list == null || list.size() == 0 || ((MultiStickerExtendedInfo) list.get(0)).getPositionType() != 0) {
                i.i();
                i2 = next.a().processTexture(sVar.d(), next.b(this.C), this.m, next.c().e(), next.c().f(), 0, 0, false, (STStickerInputParams) null, next.c().d());
                i.i();
                if (Util.a()) {
                    Util.a(next.c(), "NONFORE");
                }
            }
        }
        e.b("processNoFrontTexture");
        return i2;
    }

    private void a(h hVar, s sVar) {
        if (b(sVar)) {
            a(hVar, sVar, -16777216);
        }
        for (b next : this.G.keySet()) {
            List<MultiStickerExtendedInfo> list = this.G.get(next);
            if (list != null && list.size() > 0) {
                for (MultiStickerExtendedInfo multiStickerExtendedInfo : list) {
                    if (!next.c().equals(sVar)) {
                        RectF a2 = c.a(multiStickerExtendedInfo, sVar.e(), sVar.f());
                        h hVar2 = hVar;
                        a(hVar2, next.c(), sVar, c.a(next.c().e(), next.c().f(), a2), a2);
                        if (Util.a()) {
                            Util.a(sVar, "OUTPUT");
                        }
                    }
                }
            }
        }
    }

    private int a(int i2, s sVar) {
        int i3 = i2;
        for (b next : this.G.keySet()) {
            List list = this.G.get(next);
            if (list != null && list.size() > 0 && ((MultiStickerExtendedInfo) list.get(0)).getPositionType() == 0) {
                i.i();
                i3 = next.a().processTexture(next.c().d(), next.b(this.C), this.m, next.c().e(), next.c().f(), 0, 0, false, (STStickerInputParams) null, sVar.d());
                i.i();
                if (Util.a()) {
                    Util.a(sVar, "FORE");
                }
            }
            s sVar2 = sVar;
        }
        return i3;
    }

    private s C() {
        for (b next : this.G.keySet()) {
            List list = this.G.get(next);
            if (list != null && list.size() > 0 && ((MultiStickerExtendedInfo) list.get(0)).getPositionType() == 0) {
                return next.c();
            }
        }
        return null;
    }

    private boolean b(s sVar) {
        boolean z2 = false;
        boolean z3 = false;
        for (b next : this.G.keySet()) {
            List<MultiStickerExtendedInfo> list = this.G.get(next);
            if (list != null && list.size() > 0) {
                for (MultiStickerExtendedInfo multiStickerExtendedInfo : list) {
                    if (!next.c().equals(sVar)) {
                        z3 = true;
                    }
                }
                if (((MultiStickerExtendedInfo) list.get(0)).getPositionType() == 2) {
                    z2 = true;
                }
            }
        }
        if (z2 || !z3) {
            return false;
        }
        return true;
    }

    public boolean a(int i2) {
        if (this.u != null && c_(i2) && this.r && this.u.m() && this.u.n() && !l.b(this.u.j())) {
            return true;
        }
        return false;
    }

    public boolean a(s.a aVar) {
        if (aVar == null) {
            e.e("StickerTexturePreview", "process, frameInfo: " + aVar);
            return false;
        }
        int i2 = -1;
        if (this.u != null && aVar.c != null) {
            if (!this.k) {
                if (!this.s || !h()) {
                    a(aVar.f4427a, this.q, this.p);
                    e.e("StickerTexturePreview", "process, non selected sticker!");
                    return false;
                }
                this.k = true;
            }
            if (this.J == null) {
                this.J = new STMobileHardwareBufferNative();
                this.J.init(this.i, this.j, 0, 1);
                this.L = new byte[(this.i * this.j * 4)];
                if (this.K == null) {
                    this.K = new STGLRender();
                    this.K.init(this.f4422a, this.f4423b);
                }
            }
            f(aVar.c.d());
            synchronized (this.D) {
                i2 = a(aVar.c);
                com.oppo.camera.gl.s C2 = C();
                if (C2 != null) {
                    a(aVar.f4427a, C2);
                    i2 = a(i2, this.p);
                } else {
                    a(aVar.f4427a, this.p);
                }
            }
            com.oppo.camera.util.d.a("process");
        } else if (this.u == null) {
            e.a("StickerTexturePreview", "process, mRequest is null");
        }
        if (i2 != 0) {
            e.e("StickerTexturePreview", "process, result: " + i2);
        }
        if (i2 == 0) {
            return true;
        }
        return false;
    }

    private void f(int i2) {
        STHumanAction humanActionDetect;
        e.a("doHumanActionDetect");
        int textureId = this.J.getTextureId();
        this.K.copyTexture(this.K.resizeTexture(i2, this.i, this.j, 0), textureId, this.i, this.j);
        this.J.downloadRgbaImage(this.i, this.j, this.L);
        synchronized (this.E) {
            p();
            humanActionDetect = this.I.humanActionDetect(this.L, 6, c.a(this.G), this.m, this.i, this.j);
        }
        a(humanActionDetect);
        e.b("doHumanActionDetect");
    }

    private void a(h hVar, com.oppo.camera.gl.s sVar, com.oppo.camera.gl.s sVar2) {
        hVar.a(sVar2);
        hVar.a((com.oppo.camera.gl.c) sVar, 0, 0, sVar2.e(), sVar2.f());
        hVar.h();
    }

    private void a(h hVar, com.oppo.camera.gl.s sVar, com.oppo.camera.gl.s sVar2, RectF rectF, RectF rectF2) {
        hVar.a(sVar2);
        hVar.a((com.oppo.camera.gl.c) sVar, rectF, rectF2);
        hVar.h();
    }

    private void a(h hVar, com.oppo.camera.gl.s sVar, int i2) {
        hVar.a(sVar);
        hVar.a(0.0f, 0.0f, (float) sVar.g(), (float) sVar.h(), i2);
        hVar.h();
    }

    public void o() {
        e.a("StickerTexturePreview", "destroyHumanAction");
        STMobileHumanActionNative sTMobileHumanActionNative = this.I;
        if (sTMobileHumanActionNative != null) {
            sTMobileHumanActionNative.reset();
            this.I.destroyInstance();
            this.I.destroyInstanceImage();
            this.I = null;
        }
        this.t = false;
    }

    public void p() {
        if (this.I == null) {
            e.a("StickerTexturePreview", "initNativeInstance");
            this.I = new STMobileHumanActionNative();
            if (this.I.createInstanceFromAssetFile("M_SenseME_Action_5.2.12.model", c.f3638a, Util.f().getAssets()) == 0) {
                this.I.setParam(2, 0.3f);
                this.I.setParam(1, 320.0f);
                this.I.setParam(20, 0.2f);
                this.I.setParam(3, (float) CameraConfig.getConfigIntValue(ConfigDataBase.KEY_STICKER_SUPPORT_MAX_FACE_NUM));
            }
            if (this.I.createInstanceImage("M_SenseME_Action_5.2.12.model", c.f3639b, Util.f().getAssets()) == 0) {
                this.I.setParamImage(2, 0.1f);
                this.I.setParamImage(1, 640.0f);
            }
        }
    }

    public void b() {
        A();
        synchronized (this.E) {
            if (this.G != null) {
                this.G.clear();
                this.G = null;
            }
            o();
        }
    }

    private void b(long j2) {
        if (this.w == null) {
            this.w = new ArrayList<>();
        }
        this.w.clear();
        if (this.x == null) {
            this.x = new ArrayList<>();
        }
        this.x.clear();
        w();
        Set<Long> keySet = this.z.keySet();
        Set<Long> keySet2 = this.y.keySet();
        if (keySet != null) {
            for (Long longValue : keySet) {
                long longValue2 = longValue.longValue();
                if (j2 >= 0 && (j2 & longValue2) > 0) {
                    this.w.add(Long.valueOf(longValue2));
                }
            }
        }
        if (keySet2 != null) {
            for (Long longValue3 : keySet2) {
                long longValue4 = longValue3.longValue();
                if (j2 >= 0 && (j2 & longValue4) > 0) {
                    this.x.add(Long.valueOf(longValue4));
                }
            }
        }
        for (int i2 = 0; i2 < this.w.size(); i2++) {
            if (this.g != null) {
                this.A = false;
                this.g.a(this.h.getResources().getString(this.z.get(this.w.get(i2)).intValue()));
                return;
            }
        }
        for (int i3 = 0; i3 < this.x.size(); i3++) {
            if (this.g != null) {
                this.A = false;
                this.g.a(this.h.getResources().getString(this.y.get(this.x.get(i3)).intValue()));
                return;
            }
        }
    }

    private void b(STHumanAction sTHumanAction) {
        ArrayList<Long> arrayList;
        ArrayList<Long> arrayList2;
        if (sTHumanAction != null && !this.A) {
            if (sTHumanAction.faceCount > 0 && (arrayList2 = this.w) != null && arrayList2.size() > 0) {
                for (int i2 = 0; i2 < sTHumanAction.faceCount; i2++) {
                    long j2 = sTHumanAction.faces[i2].faceAction;
                    for (int i3 = 0; i3 < this.w.size(); i3++) {
                        if ((this.w.get(i3).longValue() & j2) > 0) {
                            this.A = true;
                            n();
                            return;
                        }
                    }
                }
            }
            if (sTHumanAction.handCount > 0 && (arrayList = this.x) != null && arrayList.size() > 0) {
                for (int i4 = 0; i4 < sTHumanAction.handCount; i4++) {
                    long j3 = sTHumanAction.hands[i4].handAction;
                    for (int i5 = 0; i5 < this.x.size(); i5++) {
                        if ((this.x.get(i5).longValue() & j3) > 0) {
                            this.A = true;
                            n();
                            return;
                        }
                    }
                }
            }
        }
    }
}
