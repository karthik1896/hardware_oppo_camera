package co.polarr.renderer;

import a.a.b.e;
import a.a.b.e.a;
import a.a.b.e.m;
import a.a.b.f;
import android.content.res.AssetManager;
import android.content.res.Resources;
import co.polarr.renderer.entities.Adjustment;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.Cube;
import co.polarr.renderer.entities.FilterItem;
import co.polarr.renderer.entities.FilterPackage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FilterPackageUtil {
    public static final String BOWU_2020 = "bowu-2.1.cube.rgb.bin";
    public static final String CUBE_BASE = "cubes/";
    public static final String CUBE_EXT = ".cube";
    public static final String DUAL_LUT_PIX_A = "DL_A";
    public static final String DUAL_LUT_PIX_B = "DL_B";
    public static final String FILTER_FILE = "filters_johnny_32.json";
    public static final String F_BACK_1 = "B1si_XbZz";
    public static final String F_BACK_2 = "B1nmcmWbG";
    public static final String F_BACK_3 = "ByW7g4bbf";
    public static final String F_BACK_4 = "EyxRbD2UCe";
    public static final String F_BACK_5 = "rkx5u4Zbf";
    public static final String F_COMMON_1 = "SkpZ8ebbz";
    public static final String F_COMMON_2 = "Syt2KeZZf";
    public static final String F_COMMON_3 = "r1JaFSZZG";
    public static final String F_COMMON_4 = "BycYf7WWz";
    public static final String F_COMMON_5 = "ByYo3If";
    public static final String F_COMMON_6 = "rJ5g5vPWG";
    public static final String F_CUBE_2018_0 = "f_japan_strong.cube.rgb.bin";
    public static final String F_CUBE_2018_11 = "f_contrast_gray_face_dark";
    public static final String F_CUBE_2018_6 = "f_fuji_strong.cube.rgb.bin";
    public static final String F_CUBE_2018_7 = "f_candy_water_weak.cube.rgb.bin";
    public static final String F_CUBE_2018_8 = "f_bin_hideaki";
    public static final String F_DEFAULT = "default";
    public static final String F_FRONT_1 = "BJJAwoigM";
    public static final String F_FRONT_2 = "rkMhq4ZWf";
    public static final String F_FRONT_3 = "B1aMqioxf";
    public static final String F_FRONT_4 = "BJyKIwqxz";
    public static final String F_FRONT_5 = "r1PrfoolG";
    public static final String F_MODE_1 = "Sy4uLSTgf";
    public static final String F_MODE_2 = "rJxJtmaez";
    public static final String F_MODE_3 = "B1VLf4peM";
    public static final String F_MODE_4 = "SJ3mbr6ef";
    public static final String G_GR3HC_2020 = "DL_A_OPPO-G-GR3HC-2.2-softcut.CUBE.rgb.bin";
    public static final String G_GR3SLIDE_2020 = "OPPO-G-GR3Slide-1.1.CUBE.rgb.bin";
    public static final String G_SSX04_2020 = "OPPO-G-SSX04-1.1.CUBE.rgb.bin";
    public static final String JIARI_2020 = "jiari-2.0.cube.rgb.bin";
    public static final String LUT_BASE = "luts/";
    public static final String LVTU_2020 = "lvtu-2.0.cube.rgb.bin";
    public static final String MEIWEI_2020 = "meiwei-2.2.cube.rgb.bin";
    public static final String PORTRAIT4_1 = "p4_1.cube.rgb.bin";
    public static final String PORTRAIT4_1B = "p4_1b.cube.rgb.bin";
    public static final String PORTRAIT4_1C = "p4_1c.cube.rgb.bin";
    public static final String PORTRAIT4_2 = "p4_2.cube.rgb.bin";
    public static final String PORTRAIT4_3 = "p4_3.cube.rgb.bin";
    public static final String PORTRAIT4_4 = "p4_4.cube.rgb.bin";
    public static final String QIURI_2020 = "qiuri-2.0.cube.rgb.bin";
    public static final String REALME_BLACK_GOLD_2020 = "realme-black-gold-1.1-RGB.CUBE.rgb.bin";
    public static final String REALME_CYBERPUNK_2020 = "realme-cyberpunk-RGB.CUBE.rgb.bin";
    public static final String REALME_INFRA_2020 = "realme-infra-RGB.CUBE.rgb.bin";
    public static final String RED_RED_2020 = "red-red.cube.rgb.bin";
    public static final String SENLIN_2020 = "senlin-2.0.cube.rgb.bin";
    public static final String SKY_BLUE_2020 = "sky-blue.cube.rgb.bin";
    public static final String TREE_GREEN_2020 = "tree-green.cube.rgb.bin";
    public static final String YUANQI_2020 = "yuanqi-2.2s.cube.rgb.bin";

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f1413a = {F_DEFAULT, F_COMMON_1, F_COMMON_2, F_COMMON_3, F_COMMON_4, F_COMMON_5, F_COMMON_6, F_FRONT_1, F_FRONT_2, F_FRONT_3, F_FRONT_4, F_FRONT_5, F_BACK_1, F_BACK_2, F_BACK_3, F_BACK_4, F_BACK_5, F_MODE_1, F_MODE_2, F_MODE_3, F_MODE_4, F_CUBE_2018_0, F_CUBE_2018_6, F_CUBE_2018_7, F_CUBE_2018_8, F_CUBE_2018_11, PORTRAIT4_1, PORTRAIT4_1B, PORTRAIT4_1C, PORTRAIT4_2, PORTRAIT4_3, PORTRAIT4_4, BOWU_2020, JIARI_2020, LVTU_2020, MEIWEI_2020, QIURI_2020, SENLIN_2020, YUANQI_2020, SKY_BLUE_2020, TREE_GREEN_2020, RED_RED_2020, G_SSX04_2020, G_GR3SLIDE_2020, G_GR3HC_2020, REALME_BLACK_GOLD_2020, REALME_CYBERPUNK_2020, REALME_INFRA_2020};

    /* renamed from: b  reason: collision with root package name */
    public static String f1414b = "videofilter_lut/";
    public static String c = null;
    public static FilterPackage d;
    public static Map<String, Cube> e = new HashMap();

    public class porender_YuvEf extends LinkedHashMap<String, String> {
        public porender_YuvEf() {
            put("F_COMMON_1", FilterPackageUtil.F_COMMON_1);
            put("F_COMMON_3", FilterPackageUtil.F_COMMON_3);
            put("F_COMMON_4", FilterPackageUtil.F_COMMON_4);
            put("F_COMMON_5", FilterPackageUtil.F_COMMON_5);
            put("F_BACK_2", FilterPackageUtil.F_BACK_2);
            put("F_BACK_3", FilterPackageUtil.F_BACK_3);
            put("BOWU_2020", FilterPackageUtil.BOWU_2020);
            put("JIARI_2020", FilterPackageUtil.JIARI_2020);
            put("LVTU_2020", FilterPackageUtil.LVTU_2020);
            put("MEIWEI_2020", FilterPackageUtil.MEIWEI_2020);
            put("QIURI_2020", FilterPackageUtil.QIURI_2020);
            put("SENLIN_2020", FilterPackageUtil.SENLIN_2020);
            put("YUANQI_2020", FilterPackageUtil.YUANQI_2020);
            put("G_SSX04_2020", FilterPackageUtil.G_SSX04_2020);
            put("G_GR3SLIDE_2020", FilterPackageUtil.G_GR3SLIDE_2020);
            put("G_GR3HC_2020", FilterPackageUtil.G_GR3HC_2020);
            put("REALME_BLACK_GOLD_2020", FilterPackageUtil.REALME_BLACK_GOLD_2020);
            put("REALME_CYBERPUNK_2020", FilterPackageUtil.REALME_CYBERPUNK_2020);
            put("REALME_INFRA_2020", FilterPackageUtil.REALME_INFRA_2020);
        }
    }

    static {
        new porender_YuvEf();
    }

    public static List<FilterPackage> GetAllFilters(Resources resources) {
        e.a().c();
        return e.a().b();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00ee, code lost:
        r1 = 0.7f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f7, code lost:
        r1 = r0;
        r3 = 0.44f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0100, code lost:
        r3 = 0.32f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x010c, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x010d, code lost:
        r3 = 0.5f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x010e, code lost:
        r3 = r3 * 2.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0113, code lost:
        if (r8 >= 0.5f) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0115, code lost:
        r3 = (r3 * r8) * 2.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0118, code lost:
        r3 = r3 + ((((r1 * 2.0f) - r3) * (r8 - 0.5f)) * 2.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0124, code lost:
        return a(r7.state, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.Object> GetFilterStates(co.polarr.renderer.entities.FilterItem r7, float r8) {
        /*
            java.lang.String r0 = r7.id
            int r1 = r0.hashCode()
            switch(r1) {
                case -1773019996: goto L_0x00ae;
                case -1749294812: goto L_0x00a3;
                case -1635938711: goto L_0x0098;
                case -1328964886: goto L_0x008d;
                case -1326443198: goto L_0x0082;
                case -1273000971: goto L_0x0078;
                case -976907733: goto L_0x006d;
                case -592986300: goto L_0x0063;
                case 16036088: goto L_0x0059;
                case 312500946: goto L_0x004f;
                case 954171616: goto L_0x0043;
                case 981542261: goto L_0x0037;
                case 1054891211: goto L_0x002c;
                case 1706212476: goto L_0x0021;
                case 1995379619: goto L_0x0016;
                case 2106819752: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x00b9
        L_0x000b:
            java.lang.String r1 = "Syt2KeZZf"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b9
            r0 = 1
            goto L_0x00ba
        L_0x0016:
            java.lang.String r1 = "ByYo3If"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b9
            r0 = 4
            goto L_0x00ba
        L_0x0021:
            java.lang.String r1 = "BycYf7WWz"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b9
            r0 = 3
            goto L_0x00ba
        L_0x002c:
            java.lang.String r1 = "SkpZ8ebbz"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b9
            r0 = 0
            goto L_0x00ba
        L_0x0037:
            java.lang.String r1 = "EyxRbD2UCe"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b9
            r0 = 14
            goto L_0x00ba
        L_0x0043:
            java.lang.String r1 = "r1PrfoolG"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b9
            r0 = 10
            goto L_0x00ba
        L_0x004f:
            java.lang.String r1 = "rkMhq4ZWf"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b9
            r0 = 7
            goto L_0x00ba
        L_0x0059:
            java.lang.String r1 = "BJJAwoigM"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b9
            r0 = 6
            goto L_0x00ba
        L_0x0063:
            java.lang.String r1 = "r1JaFSZZG"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b9
            r0 = 2
            goto L_0x00ba
        L_0x006d:
            java.lang.String r1 = "BJyKIwqxz"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b9
            r0 = 9
            goto L_0x00ba
        L_0x0078:
            java.lang.String r1 = "rJ5g5vPWG"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b9
            r0 = 5
            goto L_0x00ba
        L_0x0082:
            java.lang.String r1 = "ByW7g4bbf"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b9
            r0 = 13
            goto L_0x00ba
        L_0x008d:
            java.lang.String r1 = "B1aMqioxf"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b9
            r0 = 8
            goto L_0x00ba
        L_0x0098:
            java.lang.String r1 = "rkx5u4Zbf"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b9
            r0 = 15
            goto L_0x00ba
        L_0x00a3:
            java.lang.String r1 = "B1si_XbZz"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b9
            r0 = 11
            goto L_0x00ba
        L_0x00ae:
            java.lang.String r1 = "B1nmcmWbG"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b9
            r0 = 12
            goto L_0x00ba
        L_0x00b9:
            r0 = -1
        L_0x00ba:
            r1 = 1065353216(0x3f800000, float:1.0)
            r2 = 1058977874(0x3f1eb852, float:0.62)
            r3 = 1057132380(0x3f028f5c, float:0.51)
            r4 = 1060320051(0x3f333333, float:0.7)
            r5 = 1057971241(0x3f0f5c29, float:0.56)
            r6 = 1056964608(0x3f000000, float:0.5)
            switch(r0) {
                case 0: goto L_0x010a;
                case 1: goto L_0x0104;
                case 2: goto L_0x00fc;
                case 3: goto L_0x00f4;
                case 4: goto L_0x010d;
                case 5: goto L_0x00f2;
                case 6: goto L_0x00f0;
                case 7: goto L_0x00ed;
                case 8: goto L_0x00e6;
                case 9: goto L_0x00e1;
                case 10: goto L_0x00dd;
                case 11: goto L_0x010d;
                case 12: goto L_0x00db;
                case 13: goto L_0x00d7;
                case 14: goto L_0x00d2;
                case 15: goto L_0x00ce;
                default: goto L_0x00cd;
            }
        L_0x00cd:
            goto L_0x010d
        L_0x00ce:
            r0 = 1059145646(0x3f2147ae, float:0.63)
            goto L_0x00f7
        L_0x00d2:
            r3 = 1050589266(0x3e9eb852, float:0.31)
            r1 = r5
            goto L_0x010e
        L_0x00d7:
            r0 = 1059648963(0x3f28f5c3, float:0.66)
            goto L_0x010c
        L_0x00db:
            r3 = r4
            goto L_0x010e
        L_0x00dd:
            r1 = 1059481190(0x3f266666, float:0.65)
            goto L_0x010e
        L_0x00e1:
            r0 = 1057635697(0x3f0a3d71, float:0.54)
            r3 = r0
            goto L_0x00ee
        L_0x00e6:
            r3 = 1058642330(0x3f19999a, float:0.6)
            r1 = 1061997773(0x3f4ccccd, float:0.8)
            goto L_0x010e
        L_0x00ed:
            r3 = r5
        L_0x00ee:
            r1 = r4
            goto L_0x010e
        L_0x00f0:
            r1 = r2
            goto L_0x0100
        L_0x00f2:
            r1 = r2
            goto L_0x010d
        L_0x00f4:
            r0 = 1058306785(0x3f147ae1, float:0.58)
        L_0x00f7:
            r1 = r0
            r3 = 1054951342(0x3ee147ae, float:0.44)
            goto L_0x010e
        L_0x00fc:
            r0 = 1056293519(0x3ef5c28f, float:0.48)
            r1 = r0
        L_0x0100:
            r3 = 1050924810(0x3ea3d70a, float:0.32)
            goto L_0x010e
        L_0x0104:
            r0 = 1049247089(0x3e8a3d71, float:0.27)
            r1 = r3
            r3 = r0
            goto L_0x010e
        L_0x010a:
            r0 = 1061158912(0x3f400000, float:0.75)
        L_0x010c:
            r1 = r0
        L_0x010d:
            r3 = r6
        L_0x010e:
            r0 = 1073741824(0x40000000, float:2.0)
            float r3 = r3 * r0
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x0118
            float r3 = r3 * r8
            float r3 = r3 * r0
            goto L_0x011e
        L_0x0118:
            float r1 = r1 * r0
            float r1 = r1 - r3
            float r8 = r8 - r6
            float r1 = r1 * r8
            float r1 = r1 * r0
            float r3 = r3 + r1
        L_0x011e:
            java.util.Map<java.lang.String, java.lang.Object> r7 = r7.state
            java.util.Map r7 = a((java.util.Map<java.lang.String, java.lang.Object>) r7, (float) r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: co.polarr.renderer.FilterPackageUtil.GetFilterStates(co.polarr.renderer.entities.FilterItem, float):java.util.Map");
    }

    public static Map<String, Object> GetRefStates(Map<String, Object> map, float f) {
        return a(map, Math.min(1.0f, Math.max(0.0f, f)) * 2.0f);
    }

    public static Cube a(String str) {
        try {
            if (c == null) {
                return null;
            }
            Cube fromRaw = Cube.fromRaw(new FileInputStream(new File(c, str)), str);
            e.put(fromRaw.filterID, fromRaw);
            return fromRaw;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Map<String, Object> a(Map<String, Object> map, float f) {
        ArrayList arrayList;
        float f2;
        float f3;
        float f4;
        Map<String, Object> map2 = map;
        float f5 = f;
        HashMap hashMap = new HashMap();
        float f6 = 1.0f;
        if (f5 == 1.0f) {
            hashMap.putAll(map2);
            return hashMap;
        }
        Map<String, Object> map3 = f.f83a;
        for (String next : map.keySet()) {
            Object obj = map2.get(next);
            if (obj instanceof Float) {
                if (map3.containsKey(next)) {
                    Float f7 = (Float) obj;
                    float floatValue = f7.floatValue();
                    if (map3.get(next) instanceof Float) {
                        floatValue = ((Float) map3.get(next)).floatValue();
                    }
                    float a2 = a.a(f5, floatValue, f7.floatValue());
                    if ("shadows".equals(next)) {
                        f4 = Math.min(a2, 1.5f);
                        f3 = -1.5f;
                    } else {
                        f4 = Math.min(a2, f6);
                        f3 = -1.0f;
                    }
                    f2 = Math.max(f4, f3);
                } else if ("lookup_intensity".equals(next)) {
                    f2 = a.a(f5, 0.0f, ((Float) obj).floatValue());
                }
                obj = Float.valueOf(f2);
            } else {
                char c2 = 65535;
                int i = 0;
                switch (next.hashCode()) {
                    case -1917275032:
                        if (next.equals("curves_green")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -1829931962:
                        if (next.equals("curves_all")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1829915850:
                        if (next.equals("curves_red")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -893285803:
                        if (next.equals("curves_blue")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -366660142:
                        if (next.equals("local_adjustments")) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
                if (c2 == 0 || c2 == 1 || c2 == 2 || c2 == 3) {
                    if (obj instanceof float[][]) {
                        float[][] fArr = (float[][]) obj;
                        float[][] fArr2 = new float[fArr.length][];
                        for (int i2 = 0; i2 < fArr.length; i2++) {
                            float[] fArr3 = fArr[i2];
                            float[] copyOf = Arrays.copyOf(fArr3, fArr3.length);
                            fArr2[i2] = copyOf;
                            copyOf[1] = a.a(f5, fArr3[0], fArr3[1]);
                            copyOf[1] = (float) a.a((double) copyOf[1], 0.0d, 255.0d);
                        }
                        hashMap.put(next, fArr2);
                        f6 = 1.0f;
                        map2 = map;
                    }
                } else if (c2 == 4 && (obj instanceof ArrayList) && (arrayList = (ArrayList) obj) != null && !arrayList.isEmpty() && (arrayList.get(0) instanceof Adjustment)) {
                    ArrayList arrayList2 = new ArrayList();
                    int i3 = 0;
                    while (i3 < arrayList.size()) {
                        Adjustment adjustment = (Adjustment) arrayList.get(i3);
                        Adjustment adjustment2 = (Adjustment) m.a(m.a(adjustment), Adjustment.class);
                        Context.LocalState localState = new Context.LocalState();
                        Field[] fields = Context.LocalState.class.getFields();
                        int length = fields.length;
                        while (i < length) {
                            Field field = fields[i];
                            int i4 = length;
                            if (field.getType() == Float.TYPE) {
                                try {
                                    field.setFloat(adjustment2.adjustments, a.a(f5, field.getFloat(localState), field.getFloat(adjustment.adjustments)));
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            i++;
                            Map<String, Object> map4 = map;
                            length = i4;
                        }
                        arrayList2.add(adjustment2);
                        i3++;
                        i = 0;
                        Map<String, Object> map5 = map;
                    }
                    hashMap.put(next, arrayList2);
                    f6 = 1.0f;
                    map2 = map;
                }
            }
            hashMap.put(next, obj);
            f6 = 1.0f;
            map2 = map;
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r1.state;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r1, java.lang.String r2) {
        /*
            a.a.b.e r0 = a.a.b.e.a()
            co.polarr.renderer.entities.FilterItem r1 = r0.a(r1)
            if (r1 == 0) goto L_0x0027
            java.util.Map<java.lang.String, java.lang.Object> r0 = r1.state
            if (r0 == 0) goto L_0x0027
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x0027
            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.state
            java.lang.Object r1 = r1.get(r2)
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x0027
            r1 = 1
            goto L_0x0028
        L_0x0027:
            r1 = 0
        L_0x0028:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: co.polarr.renderer.FilterPackageUtil.a(java.lang.String, java.lang.String):boolean");
    }

    public static String[] a(AssetManager assetManager, String str) {
        try {
            if (!str.startsWith(DUAL_LUT_PIX_A)) {
                return null;
            }
            String replaceFirst = str.replaceFirst(DUAL_LUT_PIX_A, DUAL_LUT_PIX_B);
            InputStream open = assetManager.open(LUT_BASE + replaceFirst);
            if (open.available() <= 0) {
                return null;
            }
            open.close();
            return new String[]{str, replaceFirst};
        } catch (FileNotFoundException unused) {
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Cube b(AssetManager assetManager, String str) {
        if (e.containsKey(str)) {
            return e.get(str);
        }
        if (str == null) {
            return null;
        }
        try {
            Cube a2 = a(str);
            if (a2 != null) {
                return a2;
            }
            return Cube.fromRaw(assetManager.open(LUT_BASE + str), str);
        } catch (FileNotFoundException unused) {
            return c(assetManager, str);
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean b(String str) {
        int i = 0;
        while (true) {
            String[] strArr = f1413a;
            if (i >= strArr.length) {
                return false;
            }
            if (strArr[i].equals(str)) {
                return true;
            }
            i++;
        }
    }

    public static Cube c(AssetManager assetManager, String str) {
        try {
            Cube fromRaw = Cube.fromRaw(assetManager.open(f1414b + str), str);
            if (fromRaw != null) {
                e.put(fromRaw.filterID, fromRaw);
            }
            return fromRaw;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static FilterPackage getLoadedLuts() {
        FilterPackage filterPackage;
        synchronized (FilterPackageUtil.class) {
            try {
                if (d == null || d.filters == null) {
                    d = new FilterPackage();
                    d.filters = new ArrayList();
                }
                filterPackage = d;
            } catch (Throwable th) {
                Class<FilterPackageUtil> cls = FilterPackageUtil.class;
                throw th;
            }
        }
        return filterPackage;
    }

    public static String loadLutBinary(InputStream inputStream, String str) {
        String str2;
        synchronized (FilterPackageUtil.class) {
            try {
                Cube fromInputStream = Cube.fromInputStream(inputStream, str);
                FilterItem filterItem = new FilterItem();
                filterItem.id = fromInputStream.filterID;
                filterItem.name = "" + filterItem.id;
                getLoadedLuts().filters.add(filterItem);
                e.put(str, fromInputStream);
                str2 = fromInputStream.filterID;
            } catch (Exception unused) {
                Class<FilterPackageUtil> cls = FilterPackageUtil.class;
                return null;
            } catch (Throwable th) {
                Class<FilterPackageUtil> cls2 = FilterPackageUtil.class;
                throw th;
            }
        }
        return str2;
    }

    public static void setLutAssetsPath(String str) {
        f1414b = str;
    }

    public static void setStaticLUTPath(String str) {
        c = str;
    }
}
