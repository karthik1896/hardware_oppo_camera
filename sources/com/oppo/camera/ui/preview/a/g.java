package com.oppo.camera.ui.preview.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Size;
import co.polarr.renderer.FilterPackageUtil;
import co.polarr.renderer.PolarrRender;
import co.polarr.renderer.entities.DrawingItem;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.ui.menu.levelcontrol.f;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: FilterHelper */
public class g {
    private static int A = -1;
    private static int B = -1;
    private static int C = -1;
    private static int D = -1;
    private static int E = -1;
    private static int F = 0;
    private static int G = 0;
    private static int H;
    private static float I = 0.0f;
    private static float J = 0.0f;
    private static float K = 0.0f;
    private static Bitmap L = null;
    private static Bitmap M = null;
    private static Paint N = null;
    private static Rect O = new Rect();
    private static Paint.FontMetricsInt P = null;
    private static float Q = 0.0f;
    private static int R = 0;
    private static int S = 0;
    private static int T = 0;
    private static int U = 0;
    private static int V = 0;
    private static int W = 0;
    private static int X = 0;

    /* renamed from: a  reason: collision with root package name */
    public static int f4385a;

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f4386b = new ArrayList();
    public static List<String> c = new ArrayList();
    public static List<String> d = new ArrayList();
    public static List<Integer> e = new ArrayList();
    public static List<Integer> f = new ArrayList();
    public static List<Integer> g = new ArrayList();
    public static List<String> h = new ArrayList();
    public static List<String> i = new ArrayList();
    public static List<Integer> j = new ArrayList();
    public static List<Integer> k = new ArrayList();
    public static List<String> l = new ArrayList();
    public static List<Integer> m = new ArrayList();
    public static List<String> n = new ArrayList();
    public static List<Integer> o = new ArrayList();
    public static List<String> p = new ArrayList();
    public static List<Integer> q = new ArrayList();
    private static boolean r = false;
    private static boolean s = false;
    private static int t = -1;
    private static int u = -1;
    private static int v = -1;
    private static int w = -1;
    private static int x = -1;
    private static int y = -1;
    private static int z = -1;

    static {
        H = 0;
        FilterPackageUtil.setStaticLUTPath("/odm/etc/camera/filters_lut/");
        PolarrRender.SetStaticResPath("/odm/etc/camera/filters_res/");
        f4386b.add(FilterPackageUtil.F_DEFAULT);
        f4386b.add(FilterPackageUtil.F_COMMON_1);
        f4386b.add(FilterPackageUtil.F_COMMON_3);
        f4386b.add(FilterPackageUtil.YUANQI_2020);
        f4386b.add(FilterPackageUtil.BOWU_2020);
        f4386b.add(FilterPackageUtil.JIARI_2020);
        f4386b.add(FilterPackageUtil.LVTU_2020);
        f4386b.add(FilterPackageUtil.MEIWEI_2020);
        f4386b.add(FilterPackageUtil.F_BACK_4);
        f4386b.add(FilterPackageUtil.SENLIN_2020);
        f4386b.add(FilterPackageUtil.F_BACK_3);
        f4386b.add(FilterPackageUtil.F_COMMON_4);
        f4386b.add(FilterPackageUtil.QIURI_2020);
        f4386b.add(FilterPackageUtil.F_COMMON_6);
        f4386b.add(FilterPackageUtil.F_BACK_2);
        f4386b.add(FilterPackageUtil.F_COMMON_5);
        c.add(FilterPackageUtil.F_DEFAULT);
        c.add(FilterPackageUtil.F_COMMON_1);
        c.add(FilterPackageUtil.F_COMMON_3);
        c.add(FilterPackageUtil.YUANQI_2020);
        c.add(FilterPackageUtil.BOWU_2020);
        c.add(FilterPackageUtil.JIARI_2020);
        c.add(FilterPackageUtil.LVTU_2020);
        c.add(FilterPackageUtil.MEIWEI_2020);
        c.add(FilterPackageUtil.F_BACK_4);
        c.add(FilterPackageUtil.SENLIN_2020);
        c.add(FilterPackageUtil.F_BACK_3);
        c.add(FilterPackageUtil.F_COMMON_4);
        c.add(FilterPackageUtil.QIURI_2020);
        c.add(FilterPackageUtil.F_COMMON_6);
        c.add(FilterPackageUtil.F_BACK_2);
        c.add(FilterPackageUtil.F_COMMON_5);
        d.add(FilterPackageUtil.F_DEFAULT);
        d.add("anc_filtert_kaleidoscope");
        d.add("anc_filtert_hexagon");
        d.add("anc_filtert_spiral");
        d.add("anc_filtert_concentric_circles");
        d.add("anc_filtert_polyspin");
        d.add("anc_filtert_cell_gradientcolor");
        d.add("anc_filtert_cell_greenorange");
        d.add("anc_filtert_cell_bluepink");
        List<Integer> list = g;
        Integer valueOf = Integer.valueOf(R.string.camera_filter_none);
        list.add(valueOf);
        g.add(Integer.valueOf(R.string.camera_filter_anc_1));
        g.add(Integer.valueOf(R.string.camera_filter_anc_2));
        g.add(Integer.valueOf(R.string.camera_filter_anc_3));
        g.add(Integer.valueOf(R.string.camera_filter_anc_4));
        g.add(Integer.valueOf(R.string.camera_filter_anc_5));
        g.add(Integer.valueOf(R.string.camera_filter_anc_6));
        g.add(Integer.valueOf(R.string.camera_filter_anc_7));
        g.add(Integer.valueOf(R.string.camera_filter_anc_8));
        e.add(valueOf);
        e.add(Integer.valueOf(R.string.camera_filter_qingxin));
        e.add(Integer.valueOf(R.string.camera_filter_tongtou));
        e.add(Integer.valueOf(R.string.camera_filter_nuanyang));
        e.add(Integer.valueOf(R.string.camera_filter_bowu));
        e.add(Integer.valueOf(R.string.camera_filter_tianye));
        e.add(Integer.valueOf(R.string.camera_filter_lvtu));
        e.add(Integer.valueOf(R.string.camera_filter_meiwei));
        e.add(Integer.valueOf(R.string.camera_filter_lengdiao));
        e.add(Integer.valueOf(R.string.camera_filter_feilin));
        e.add(Integer.valueOf(R.string.camera_filter_chengshi));
        e.add(Integer.valueOf(R.string.camera_filter_fugu));
        e.add(Integer.valueOf(R.string.camera_filter_qiuri));
        e.add(Integer.valueOf(R.string.camera_filter_huidiao));
        e.add(Integer.valueOf(R.string.camera_filter_tuise));
        e.add(Integer.valueOf(R.string.camera_filter_heibai));
        f.add(valueOf);
        f.add(Integer.valueOf(R.string.camera_filter_qingxin));
        f.add(Integer.valueOf(R.string.camera_filter_tongtou));
        f.add(Integer.valueOf(R.string.camera_filter_nuanyang));
        f.add(Integer.valueOf(R.string.camera_filter_bowu));
        f.add(Integer.valueOf(R.string.camera_filter_tianye));
        f.add(Integer.valueOf(R.string.camera_filter_lvtu));
        f.add(Integer.valueOf(R.string.camera_filter_meiwei));
        f.add(Integer.valueOf(R.string.camera_filter_lengdiao));
        f.add(Integer.valueOf(R.string.camera_filter_feilin));
        f.add(Integer.valueOf(R.string.camera_filter_chengshi));
        f.add(Integer.valueOf(R.string.camera_filter_fugu));
        f.add(Integer.valueOf(R.string.camera_filter_qiuri));
        f.add(Integer.valueOf(R.string.camera_filter_huidiao));
        f.add(Integer.valueOf(R.string.camera_filter_tuise));
        f.add(Integer.valueOf(R.string.camera_filter_heibai));
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_STREAMER_SUPPORT)) {
            i.add("portrait_streamer");
            k.add(Integer.valueOf(R.string.camera_filter_streamer));
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_NEON_SUPPORT)) {
            i.add("neon-2020.cube.rgb.bin");
            k.add(Integer.valueOf(R.string.camera_neon_portrait));
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_RETENTION_SUPPORT)) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_PORTRAIT_FRONT_RETENTION_SUPPORT)) {
                h.add("portrait_retention");
                j.add(Integer.valueOf(R.string.camera_filter_retention));
            }
            i.add("portrait_retention");
            k.add(Integer.valueOf(R.string.camera_filter_retention));
        }
        h.add(FilterPackageUtil.F_DEFAULT);
        h.add(FilterPackageUtil.F_CUBE_2018_6);
        h.add(FilterPackageUtil.F_CUBE_2018_11);
        h.add(FilterPackageUtil.F_CUBE_2018_0);
        h.add(FilterPackageUtil.F_CUBE_2018_7);
        h.add(FilterPackageUtil.F_CUBE_2018_8);
        h.add(FilterPackageUtil.QIURI_2020);
        i.add(FilterPackageUtil.F_DEFAULT);
        i.add(FilterPackageUtil.F_CUBE_2018_6);
        i.add(FilterPackageUtil.F_CUBE_2018_11);
        i.add(FilterPackageUtil.F_CUBE_2018_0);
        i.add(FilterPackageUtil.F_CUBE_2018_7);
        i.add(FilterPackageUtil.F_CUBE_2018_8);
        i.add(FilterPackageUtil.QIURI_2020);
        H = i.size();
        j.add(valueOf);
        j.add(Integer.valueOf(R.string.camera_protrait_filter_jiaopian));
        j.add(Integer.valueOf(R.string.camera_protrait_filter_heibai));
        j.add(Integer.valueOf(R.string.camera_protrait_filter_rixi));
        j.add(Integer.valueOf(R.string.camera_protrait_filter_tianmei));
        j.add(Integer.valueOf(R.string.camera_protrait_filter_shiguang));
        j.add(Integer.valueOf(R.string.camera_protrait_filter_fashi));
        k.add(valueOf);
        k.add(Integer.valueOf(R.string.camera_protrait_filter_jiaopian));
        k.add(Integer.valueOf(R.string.camera_protrait_filter_heibai));
        k.add(Integer.valueOf(R.string.camera_protrait_filter_rixi));
        k.add(Integer.valueOf(R.string.camera_protrait_filter_tianmei));
        k.add(Integer.valueOf(R.string.camera_protrait_filter_shiguang));
        k.add(Integer.valueOf(R.string.camera_protrait_filter_fashi));
        a();
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_RETENTION_SUPPORT)) {
            l.add("oppo_video_filter_portrait_retention");
            n.add("oppo_video_filter_portrait_retention");
            m.add(Integer.valueOf(R.string.camera_filter_retention));
            o.add(Integer.valueOf(R.string.camera_filter_retention));
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_COLOR_EXTRACTION_SUPPORT)) {
            l.add(FilterPackageUtil.RED_RED_2020);
            l.add(FilterPackageUtil.TREE_GREEN_2020);
            l.add(FilterPackageUtil.SKY_BLUE_2020);
            m.add(Integer.valueOf(R.string.video_filter_red));
            m.add(Integer.valueOf(R.string.video_filter_green));
            m.add(Integer.valueOf(R.string.video_filter_blue));
        }
        l.add(FilterPackageUtil.F_DEFAULT);
        l.add("oppo_video_filter_natal");
        l.add("oppo_video_filter_solar");
        l.add("oppo_video_filter_highlight");
        l.add("oppo_video_filter_strong");
        l.add("oppo_video_filter_olympus");
        l.add("oppo_video_filter_plain");
        l.add("oppo_video_filter_ins");
        m.add(valueOf);
        m.add(Integer.valueOf(R.string.camera_video_filter_rouhe));
        m.add(Integer.valueOf(R.string.camera_video_filter_wuhou));
        m.add(Integer.valueOf(R.string.camera_video_filter_qingjiaopian));
        m.add(Integer.valueOf(R.string.camera_video_filter_nongyu));
        m.add(Integer.valueOf(R.string.camera_video_filter_chuncui));
        m.add(Integer.valueOf(R.string.camera_video_filter_suse));
        m.add(Integer.valueOf(R.string.camera_video_filter_huaijiu));
        n.add(FilterPackageUtil.F_DEFAULT);
        n.add("oppo_video_filter_natal");
        n.add("oppo_video_filter_solar");
        n.add("oppo_video_filter_highlight");
        n.add("oppo_video_filter_strong");
        n.add("oppo_video_filter_olympus");
        n.add("oppo_video_filter_plain");
        n.add("oppo_video_filter_ins");
        o.add(valueOf);
        o.add(Integer.valueOf(R.string.camera_video_filter_rouhe));
        o.add(Integer.valueOf(R.string.camera_video_filter_wuhou));
        o.add(Integer.valueOf(R.string.camera_video_filter_qingjiaopian));
        o.add(Integer.valueOf(R.string.camera_video_filter_nongyu));
        o.add(Integer.valueOf(R.string.camera_video_filter_chuncui));
        o.add(Integer.valueOf(R.string.camera_video_filter_suse));
        o.add(Integer.valueOf(R.string.camera_video_filter_huaijiu));
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_RETENTION_SUPPORT)) {
            l.add("oppo_video_filter_black_and_white");
            m.add(Integer.valueOf(R.string.camera_video_filter_danse));
            n.add("oppo_video_filter_black_and_white");
            o.add(Integer.valueOf(R.string.camera_video_filter_danse));
        } else {
            l.add("oppo_video_filter_west");
            l.add("oppo_video_filter_show");
            l.add("oppo_video_filter_black_and_white");
            m.add(Integer.valueOf(R.string.camera_video_filter_xibu));
            m.add(Integer.valueOf(R.string.camera_video_filter_muguang));
            m.add(Integer.valueOf(R.string.camera_video_filter_danse));
            n.add("oppo_video_filter_west");
            n.add("oppo_video_filter_show");
            n.add("oppo_video_filter_black_and_white");
            o.add(Integer.valueOf(R.string.camera_video_filter_xibu));
            o.add(Integer.valueOf(R.string.camera_video_filter_muguang));
            o.add(Integer.valueOf(R.string.camera_video_filter_danse));
        }
        q();
        o();
    }

    private static void o() {
        List<String> configStringListValue = CameraConfig.getConfigStringListValue(ConfigDataBase.KEY_NIGHT_FILTER_TYPE_LIST);
        if (configStringListValue != null) {
            p.add(FilterPackageUtil.F_DEFAULT);
            q.add(Integer.valueOf(R.string.camera_filter_none));
            for (String next : configStringListValue) {
                char c2 = 65535;
                switch (next.hashCode()) {
                    case -1369240359:
                        if (next.equals("interstellar_space.bin")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -1316395217:
                        if (next.equals(FilterPackageUtil.REALME_BLACK_GOLD_2020)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 330539305:
                        if (next.equals("bright_coloured.bin")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 717125879:
                        if (next.equals(FilterPackageUtil.REALME_CYBERPUNK_2020)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 777381561:
                        if (next.equals("black_gold.bin")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1572815266:
                        if (next.equals(FilterPackageUtil.REALME_INFRA_2020)) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    p.add(FilterPackageUtil.REALME_BLACK_GOLD_2020);
                    q.add(Integer.valueOf(R.string.night_filter_modern_gold_realme));
                    c.add(FilterPackageUtil.REALME_BLACK_GOLD_2020);
                    f.add(Integer.valueOf(R.string.night_filter_modern_gold_realme));
                } else if (c2 == 1) {
                    p.add(FilterPackageUtil.REALME_CYBERPUNK_2020);
                    q.add(Integer.valueOf(R.string.night_filter_cyberpunk_realme));
                    c.add(FilterPackageUtil.REALME_CYBERPUNK_2020);
                    f.add(Integer.valueOf(R.string.night_filter_cyberpunk_realme));
                } else if (c2 == 2) {
                    p.add(FilterPackageUtil.REALME_INFRA_2020);
                    q.add(Integer.valueOf(R.string.night_filter_flamingo_realme));
                    c.add(FilterPackageUtil.REALME_INFRA_2020);
                    f.add(Integer.valueOf(R.string.night_filter_flamingo_realme));
                } else if (c2 == 3) {
                    p.add("black_gold.bin");
                    q.add(Integer.valueOf(R.string.night_filter_black_gold));
                } else if (c2 == 4) {
                    p.add("interstellar_space.bin");
                    q.add(Integer.valueOf(R.string.night_filter_interstellar_space));
                } else if (c2 == 5) {
                    p.add("bright_coloured.bin");
                    q.add(Integer.valueOf(R.string.night_filter_bright_coloured));
                }
            }
        }
    }

    public static void a() {
        int e2 = com.oppo.camera.f.a.e(15);
        if (!r && e2 != 0) {
            r = true;
            F = e2;
            t = H;
            i.add(t, FilterPackageUtil.PORTRAIT4_1);
            k.add(t, Integer.valueOf(R.string.camera_protrait_filter_xiaoxiang));
        }
        int e3 = com.oppo.camera.f.a.e(16);
        if (!s && e3 != 0) {
            s = true;
            G = e3;
            int i2 = t;
            u = -1 != i2 ? i2 + 1 : H;
            i.add(u, FilterPackageUtil.PORTRAIT4_3);
            k.add(u, Integer.valueOf(R.string.camera_protrait_filter_louguang));
        }
        p();
    }

    private static void p() {
        A = h.indexOf("portrait_retention");
        v = i.indexOf("portrait_streamer");
        z = i.indexOf("portrait_retention");
        w = i.indexOf("neon-2020.cube.rgb.bin");
        C = h.indexOf(FilterPackageUtil.F_DEFAULT);
        B = i.indexOf(FilterPackageUtil.F_DEFAULT);
    }

    private static void q() {
        y = n.indexOf("oppo_video_filter_portrait_retention");
        x = l.indexOf("oppo_video_filter_portrait_retention");
        E = n.indexOf(FilterPackageUtil.F_DEFAULT);
        D = l.indexOf(FilterPackageUtil.F_DEFAULT);
    }

    public static int b() {
        return t;
    }

    public static int c() {
        return u;
    }

    public static int d() {
        return v;
    }

    public static int e() {
        return w;
    }

    public static int f() {
        return z;
    }

    public static int g() {
        return A;
    }

    public static int h() {
        return B;
    }

    public static int i() {
        return C;
    }

    public static int j() {
        return D;
    }

    public static int k() {
        return E;
    }

    public static int l() {
        return F;
    }

    public static int m() {
        return G;
    }

    public static void a(Resources resources, String str, int i2, boolean z2, boolean z3, List<String> list, List<Integer> list2, k kVar, Size size) {
        Resources resources2 = resources;
        if (Float.compare(I, 0.0f) == 0) {
            I = (float) resources.getDimensionPixelOffset(R.dimen.menu_effect_filter_elements_height);
        }
        if (Float.compare(J, 0.0f) == 0) {
            J = (float) resources.getDimensionPixelOffset(R.dimen.menu_effect_filter_elements_gap);
        }
        if (Float.compare(K, 0.0f) == 0) {
            K = (float) resources.getDimensionPixelOffset(R.dimen.menu_effect_filter_elements_highlight_height);
        }
        if (Float.compare((float) R, 0.0f) == 0) {
            R = resources.getDimensionPixelOffset(R.dimen.menu_effect_filter_bitmap_bottom_padding);
        }
        if (Float.compare((float) S, 0.0f) == 0) {
            S = resources.getDimensionPixelOffset(R.dimen.menu_effect_filter_text_sides_padding);
        }
        if (Float.compare((float) T, 0.0f) == 0) {
            T = resources.getDimensionPixelOffset(R.dimen.menu_effect_filter_text_updown_padding);
        }
        if (Float.compare((float) U, 0.0f) == 0) {
            U = resources.getDimensionPixelOffset(R.dimen.menu_effect_filter_row_offset);
        }
        if (L == null) {
            L = BitmapFactory.decodeResource(resources, R.drawable.filter_highlight);
        }
        if (M == null) {
            M = BitmapFactory.decodeResource(resources, R.drawable.filter_highlight_inverse);
        }
        if (N == null) {
            N = new Paint();
            N.setColor(resources.getColor(R.color.color_white_with_full_percent_transparency));
            N.setAntiAlias(true);
            N.setShadowLayer((float) resources.getDimensionPixelSize(R.dimen.menu_effect_filter_text_shadow_radius), 0.0f, 0.0f, resources.getColor(R.color.color_black_with_70_percent_transparency));
            N.setTextSize((float) resources.getDimensionPixelSize(R.dimen.menu_effect_filter_text_size));
        }
        if (P == null) {
            P = N.getFontMetricsInt();
        }
        V = P.bottom - P.top;
        W = P.ascent;
        N.setTypeface(Typeface.DEFAULT);
        N.getTextBounds("...", 0, 3, O);
        X = O.width();
        float f2 = I;
        Q = f2 - ((float) (S * 2));
        float width = (f2 * ((float) size.getWidth())) / ((float) size.getHeight());
        float floor = (float) (Math.floor((double) ((width - I) / 2.0f)) / ((double) width));
        String str2 = str;
        f fVar = new f(str);
        fVar.b((List<Bitmap>) null);
        fVar.a(L);
        fVar.b(M);
        int i3 = i2;
        fVar.f(i2);
        fVar.a(60.0f);
        fVar.b(I);
        fVar.c(J);
        fVar.d(K);
        fVar.e(floor);
        fVar.a(z2);
        fVar.b(z3);
        fVar.c(true);
        Resources resources3 = resources;
        f fVar2 = fVar;
        List<String> list3 = list;
        List<Integer> list4 = list2;
        a(resources3, fVar2, list3, list4, z2, z3, (int) J, (int) width, (int) I);
        kVar.a(fVar);
    }

    public static void n() {
        T = 0;
        U = 0;
    }

    public static void a(f fVar, int i2, int i3) {
        if (fVar != null) {
            float f2 = I;
            float f3 = (((float) i2) * f2) / ((float) i3);
            fVar.e((float) (Math.floor((double) ((f3 - f2) / 2.0f)) / ((double) f3)));
            a(fVar.a(), fVar.k(), (int) J, (int) f3, (int) I);
        }
    }

    private static void a(Resources resources, f fVar, List<String> list, List<Integer> list2, boolean z2, boolean z3, int i2, int i3, int i4) {
        Resources resources2 = resources;
        f fVar2 = fVar;
        List<String> list3 = list;
        List<Integer> list4 = list2;
        boolean z4 = z2;
        boolean z5 = z3;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        int size = list.size();
        if (z5) {
            int i5 = size - 1;
            for (int i6 = i5; i6 >= 0; i6--) {
                int i7 = i5 - i6;
                int i8 = i7 / 1;
                DrawingItem drawingItem = new DrawingItem();
                int i9 = (i7 % 1) * (i3 + i2);
                int i10 = i8 * (i4 + i2);
                a(drawingItem, new Rect(i9, i10, i9 + i3, i10 + i4), z4, z5, resources2.getString(list4.get(i6).intValue()));
                a(resources, fVar, drawingItem, z2, i6, list3.get(i6));
                copyOnWriteArrayList.add(drawingItem);
            }
        } else {
            for (int i11 = 0; i11 < size; i11++) {
                DrawingItem drawingItem2 = new DrawingItem();
                int i12 = (i11 % 1) * (i3 + i2);
                int i13 = (i11 / 1) * (i4 + i2);
                a(drawingItem2, new Rect(i12, i13, i12 + i3, i13 + i4), z4, z5, resources2.getString(list4.get(i11).intValue()));
                a(resources, fVar, drawingItem2, z2, i11, list3.get(i11));
                copyOnWriteArrayList.add(drawingItem2);
            }
        }
        fVar2.a((List<DrawingItem>) copyOnWriteArrayList);
        fVar2.a(copyOnWriteArrayList.size());
    }

    private static void a(DrawingItem drawingItem, Rect rect, boolean z2, boolean z3, String str) {
        drawingItem.rect = rect;
        drawingItem.overlayBitmap = a(str, z2, z3);
        drawingItem.overlayTop = (rect.height() - drawingItem.overlayBitmap.getHeight()) / 2;
        if (z2) {
            if (z3) {
                drawingItem.overlayLeft = ((rect.width() - rect.height()) / 2) + R;
            } else {
                drawingItem.overlayLeft = (((rect.width() + rect.height()) / 2) - drawingItem.overlayBitmap.getWidth()) - R;
            }
        } else if (z3) {
            drawingItem.overlayLeft = (((rect.width() + rect.height()) / 2) - drawingItem.overlayBitmap.getWidth()) - R;
        } else {
            drawingItem.overlayLeft = ((rect.width() - rect.height()) / 2) + R;
        }
    }

    private static Bitmap a(String str, boolean z2, boolean z3) {
        Bitmap bitmap;
        N.getTextBounds(str, 0, str.length(), O);
        if (((float) O.width()) <= Q) {
            bitmap = Bitmap.createBitmap(O.width() + (S * 2), V + (T * 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            canvas.drawText(str, (float) S, (float) ((-W) + T), N);
            canvas.save();
        } else {
            int width = O.width();
            List<a> a2 = a(str);
            if (a2.size() == 1) {
                a aVar = a2.get(0);
                bitmap = Bitmap.createBitmap(aVar.f4388b + (S * 2), V + (T * 2), Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmap);
                canvas2.drawText(aVar.f4387a, (float) S, (float) ((-W) + T), N);
                canvas2.save();
            } else if (a2.size() == 2) {
                a aVar2 = a2.get(0);
                a aVar3 = a2.get(1);
                if (width < aVar2.f4388b + aVar3.f4388b) {
                    a a3 = a(str, width, "...");
                    bitmap = Bitmap.createBitmap(a3.f4388b + (S * 2), V + (T * 2), Bitmap.Config.ARGB_8888);
                    Canvas canvas3 = new Canvas(bitmap);
                    canvas3.drawText(a3.f4387a, (float) S, (float) ((-W) + T), N);
                    canvas3.save();
                } else {
                    int max = Math.max(aVar2.f4388b, aVar3.f4388b);
                    bitmap = Bitmap.createBitmap((S * 2) + max, (V * 2) + (T * 2) + U, Bitmap.Config.ARGB_8888);
                    Canvas canvas4 = new Canvas(bitmap);
                    canvas4.drawText(aVar2.f4387a, (float) (S + ((max - aVar2.f4388b) / 2)), (float) ((-W) + T), N);
                    canvas4.drawText(aVar3.f4387a, (float) (S + ((max - aVar3.f4388b) / 2)), (float) ((-W) + V + T + U), N);
                    canvas4.save();
                }
            } else {
                bitmap = null;
            }
        }
        Bitmap bitmap2 = bitmap;
        Matrix matrix = new Matrix();
        matrix.postRotate(z3 ? 270.0f : 90.0f);
        if (z2) {
            matrix.postScale(-1.0f, 1.0f);
        }
        return Util.a(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
    }

    private static List<a> a(String str) {
        int width;
        ArrayList arrayList = new ArrayList();
        String[] split = str.split(" ");
        int length = split.length;
        if (1 == length) {
            N.getTextBounds(str, 0, str.length(), O);
            a a2 = a(str, O.width(), "");
            arrayList.add(a2);
            String substring = str.substring(a2.f4387a.length());
            N.getTextBounds(substring, 0, substring.length(), O);
            if (((float) O.width()) <= Q) {
                a aVar = new a();
                aVar.f4387a = substring;
                aVar.f4388b = O.width();
                arrayList.add(aVar);
            } else {
                arrayList.add(a(substring, O.width(), "..."));
            }
            return arrayList;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(split[0]);
        N.getTextBounds(sb.toString(), 0, sb.length(), O);
        if (((float) O.width()) > Q) {
            arrayList.add(a(sb.toString(), O.width(), "..."));
            return arrayList;
        }
        StringBuilder sb2 = new StringBuilder();
        int i2 = 0;
        do {
            if (i2 != 0) {
                sb2.append(" ");
            }
            sb2.append(split[i2]);
            width = O.width();
            i2++;
            sb.append(" ");
            sb.append(split[i2]);
            N.getTextBounds(sb.toString(), 0, sb.length(), O);
        } while (((float) O.width()) <= Q);
        a aVar2 = new a();
        aVar2.f4387a = sb2.toString();
        aVar2.f4388b = width;
        arrayList.add(aVar2);
        sb.delete(0, sb.length());
        for (int i3 = i2; i3 < length; i3++) {
            if (i3 != i2) {
                sb.append(" ");
            }
            sb.append(split[i3]);
        }
        N.getTextBounds(sb.toString(), 0, sb.length(), O);
        if (((float) O.width()) <= Q) {
            a aVar3 = new a();
            aVar3.f4387a = sb.toString();
            aVar3.f4388b = O.width();
            arrayList.add(aVar3);
        } else {
            arrayList.add(a(sb.toString(), O.width(), "..."));
        }
        return arrayList;
    }

    private static a a(String str, int i2, String str2) {
        int length = (str.length() * (((int) Q) - X)) / i2;
        String str3 = str.substring(0, length) + str2;
        N.getTextBounds(str3, 0, str3.length(), O);
        a aVar = new a();
        aVar.f4387a = str3;
        aVar.f4388b = O.width();
        if (((float) O.width()) <= Q) {
            do {
                aVar.f4387a = str3;
                aVar.f4388b = O.width();
                length++;
                str3 = str.substring(0, length) + str2;
                N.getTextBounds(str3, 0, str3.length(), O);
            } while (((float) O.width()) <= Q);
        } else {
            do {
                length--;
                String str4 = str.substring(0, length) + str2;
                N.getTextBounds(str4, 0, str4.length(), O);
                aVar.f4387a = str4;
                aVar.f4388b = O.width();
            } while (((float) O.width()) > Q);
        }
        return aVar;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.content.res.Resources r2, com.oppo.camera.ui.menu.levelcontrol.f r3, co.polarr.renderer.entities.DrawingItem r4, boolean r5, int r6, java.lang.String r7) {
        /*
            int r0 = r7.hashCode()
            switch(r0) {
                case -1635943362: goto L_0x0044;
                case -928591791: goto L_0x003a;
                case -404148440: goto L_0x0030;
                case 205787002: goto L_0x0026;
                case 895928230: goto L_0x001c;
                case 1207726869: goto L_0x0012;
                case 1560871751: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x004e
        L_0x0008:
            java.lang.String r0 = "tree-green.cube.rgb.bin"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x004e
            r0 = 3
            goto L_0x004f
        L_0x0012:
            java.lang.String r0 = "sky-blue.cube.rgb.bin"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x004e
            r0 = 4
            goto L_0x004f
        L_0x001c:
            java.lang.String r0 = "red-red.cube.rgb.bin"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x004e
            r0 = 2
            goto L_0x004f
        L_0x0026:
            java.lang.String r0 = "portrait_retention"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x004e
            r0 = 0
            goto L_0x004f
        L_0x0030:
            java.lang.String r0 = "neon-2020.cube.rgb.bin"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x004e
            r0 = 6
            goto L_0x004f
        L_0x003a:
            java.lang.String r0 = "portrait_streamer"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x004e
            r0 = 1
            goto L_0x004f
        L_0x0044:
            java.lang.String r0 = "oppo_video_filter_portrait_retention"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x004e
            r0 = 5
            goto L_0x004f
        L_0x004e:
            r0 = -1
        L_0x004f:
            java.lang.String r1 = "default"
            switch(r0) {
                case 0: goto L_0x00f6;
                case 1: goto L_0x00dc;
                case 2: goto L_0x00c2;
                case 3: goto L_0x00a8;
                case 4: goto L_0x008e;
                case 5: goto L_0x0073;
                case 6: goto L_0x0058;
                default: goto L_0x0054;
            }
        L_0x0054:
            r4.filterId = r7
            goto L_0x010f
        L_0x0058:
            r4.filterId = r1
            r0 = 2131231674(0x7f0803ba, float:1.8079436E38)
            if (r5 == 0) goto L_0x0068
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r2, r0)
            android.graphics.Bitmap r2 = com.oppo.camera.util.Util.a((android.graphics.Bitmap) r2)
            goto L_0x006c
        L_0x0068:
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r2, r0)
        L_0x006c:
            r4.thumbBitmap = r2
            r3.a(r7, r6)
            goto L_0x010f
        L_0x0073:
            r4.filterId = r1
            r0 = 2131231667(0x7f0803b3, float:1.8079421E38)
            if (r5 == 0) goto L_0x0083
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r2, r0)
            android.graphics.Bitmap r2 = com.oppo.camera.util.Util.a((android.graphics.Bitmap) r2)
            goto L_0x0087
        L_0x0083:
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r2, r0)
        L_0x0087:
            r4.thumbBitmap = r2
            r3.a(r7, r6)
            goto L_0x010f
        L_0x008e:
            r4.filterId = r1
            r0 = 2131231664(0x7f0803b0, float:1.8079415E38)
            if (r5 == 0) goto L_0x009e
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r2, r0)
            android.graphics.Bitmap r2 = com.oppo.camera.util.Util.a((android.graphics.Bitmap) r2)
            goto L_0x00a2
        L_0x009e:
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r2, r0)
        L_0x00a2:
            r4.thumbBitmap = r2
            r3.a(r7, r6)
            goto L_0x010f
        L_0x00a8:
            r4.filterId = r1
            r0 = 2131231665(0x7f0803b1, float:1.8079417E38)
            if (r5 == 0) goto L_0x00b8
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r2, r0)
            android.graphics.Bitmap r2 = com.oppo.camera.util.Util.a((android.graphics.Bitmap) r2)
            goto L_0x00bc
        L_0x00b8:
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r2, r0)
        L_0x00bc:
            r4.thumbBitmap = r2
            r3.a(r7, r6)
            goto L_0x010f
        L_0x00c2:
            r4.filterId = r1
            r0 = 2131231666(0x7f0803b2, float:1.807942E38)
            if (r5 == 0) goto L_0x00d2
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r2, r0)
            android.graphics.Bitmap r2 = com.oppo.camera.util.Util.a((android.graphics.Bitmap) r2)
            goto L_0x00d6
        L_0x00d2:
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r2, r0)
        L_0x00d6:
            r4.thumbBitmap = r2
            r3.a(r7, r6)
            goto L_0x010f
        L_0x00dc:
            r4.filterId = r1
            r0 = 2131231676(0x7f0803bc, float:1.807944E38)
            if (r5 == 0) goto L_0x00ec
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r2, r0)
            android.graphics.Bitmap r2 = com.oppo.camera.util.Util.a((android.graphics.Bitmap) r2)
            goto L_0x00f0
        L_0x00ec:
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r2, r0)
        L_0x00f0:
            r4.thumbBitmap = r2
            r3.a(r7, r6)
            goto L_0x010f
        L_0x00f6:
            r4.filterId = r1
            r0 = 2131231675(0x7f0803bb, float:1.8079438E38)
            if (r5 == 0) goto L_0x0106
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r2, r0)
            android.graphics.Bitmap r2 = com.oppo.camera.util.Util.a((android.graphics.Bitmap) r2)
            goto L_0x010a
        L_0x0106:
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r2, r0)
        L_0x010a:
            r4.thumbBitmap = r2
            r3.a(r7, r6)
        L_0x010f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.a.g.a(android.content.res.Resources, com.oppo.camera.ui.menu.levelcontrol.f, co.polarr.renderer.entities.DrawingItem, boolean, int, java.lang.String):void");
    }

    private static void a(List<DrawingItem> list, boolean z2, int i2, int i3, int i4) {
        if (list != null) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                DrawingItem drawingItem = list.get(i5);
                int i6 = (i5 % 1) * (i3 + i2);
                int i7 = (i5 / 1) * (i4 + i2);
                Rect rect = new Rect(i6, i7, i6 + i3, i7 + i4);
                drawingItem.rect = rect;
                if (drawingItem.overlayBitmap != null) {
                    if (z2) {
                        drawingItem.overlayLeft = (((rect.width() + rect.height()) / 2) - drawingItem.overlayBitmap.getWidth()) - R;
                    } else {
                        drawingItem.overlayLeft = ((rect.width() - rect.height()) / 2) + R;
                    }
                }
            }
        }
    }

    public static String a(int i2, int i3) {
        List<String> list = com.oppo.camera.f.a.c(i3) ? f4386b : c;
        return (i2 < 0 || i2 > list.size()) ? "" : list.get(i2);
    }

    public static String a(int i2) {
        return (i2 < 0 || i2 > d.size()) ? "" : d.get(i2);
    }

    public static String b(int i2, int i3) {
        List<String> list = com.oppo.camera.f.a.c(i3) ? h : i;
        return (i2 < 0 || i2 > list.size()) ? "" : list.get(i2);
    }

    public static String c(int i2, int i3) {
        List<String> list = com.oppo.camera.f.a.c(i3) ? n : l;
        return (i2 < 0 || i2 > list.size()) ? "" : list.get(i2);
    }

    public static int a(boolean z2) {
        return z2 ? y : x;
    }

    public static String d(int i2, int i3) {
        return (i2 < 0 || i2 > p.size() + -1) ? "" : p.get(i2);
    }

    /* compiled from: FilterHelper */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f4387a = null;

        /* renamed from: b  reason: collision with root package name */
        public int f4388b = 0;

        a() {
        }
    }
}
