package a.a.b;

import a.a.b.a.a.a;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Object> f83a = new HashMap();

    static {
        a(f83a);
    }

    public static a a(List<? extends a> list, Class cls) {
        for (a aVar : list) {
            if (aVar.getClass() == cls) {
                return aVar;
            }
        }
        return null;
    }

    public static Object a(String str, Object obj, Map<String, Object> map) {
        if (obj != null && !map.containsKey(str)) {
            map.put(str, obj);
        }
        return map.get(str);
    }

    public static Object a(String str, Map<String, Object> map) {
        return a(str, (Object) null, map);
    }

    /* JADX WARNING: type inference failed for: r5v5, types: [a.a.b.a.a.a] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object a(java.util.List<? extends a.a.b.a.a.a> r5, java.lang.String r6, java.lang.Object r7) {
        /*
            java.util.Map<java.lang.String, java.lang.String> r0 = a.a.b.a.bl.r
            boolean r0 = r0.containsKey(r6)
            if (r0 == 0) goto L_0x0019
            if (r7 == 0) goto L_0x0019
            if (r5 == 0) goto L_0x0019
            java.lang.Class<a.a.b.a.bl> r0 = a.a.b.a.bl.class
            a.a.b.a.a.a r0 = a((java.util.List<? extends a.a.b.a.a.a>) r5, (java.lang.Class) r0)
            a.a.b.a.bl r0 = (a.a.b.a.bl) r0
            if (r0 == 0) goto L_0x0019
            r0.a((java.lang.String) r6, (java.lang.Object) r7)
        L_0x0019:
            java.util.List<java.lang.String> r0 = a.a.b.a.bm.r
            boolean r0 = r0.contains(r6)
            if (r0 == 0) goto L_0x0053
            if (r7 == 0) goto L_0x0053
            r0 = 0
            if (r5 == 0) goto L_0x002f
            java.lang.Class<a.a.b.a.bm> r0 = a.a.b.a.bm.class
            a.a.b.a.a.a r5 = a((java.util.List<? extends a.a.b.a.a.a>) r5, (java.lang.Class) r0)
            r0 = r5
            a.a.b.a.bm r0 = (a.a.b.a.bm) r0
        L_0x002f:
            boolean r5 = r7 instanceof java.lang.Object[]
            if (r5 == 0) goto L_0x004e
            java.lang.Object[] r7 = (java.lang.Object[]) r7
            int r5 = r7.length
            float[][] r5 = new float[r5][]
            int r1 = r7.length
            r2 = 0
            r3 = r2
        L_0x003b:
            if (r2 >= r1) goto L_0x0048
            r4 = r7[r2]
            float[] r4 = (float[]) r4
            r5[r3] = r4
            int r2 = r2 + 1
            int r3 = r3 + 1
            goto L_0x003b
        L_0x0048:
            if (r0 == 0) goto L_0x0054
            r0.a(r6, r5)
            goto L_0x0054
        L_0x004e:
            if (r0 == 0) goto L_0x0053
            r0.a(r6, r7)
        L_0x0053:
            r5 = r7
        L_0x0054:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.b.f.a(java.util.List, java.lang.String, java.lang.Object):java.lang.Object");
    }

    public static void a(Map<String, Object> map) {
        map.clear();
        map.put("local_adjustments", new ArrayList());
        Float valueOf = Float.valueOf(0.0f);
        map.put("rotation", valueOf);
        map.put("rotate90", valueOf);
        map.put("flip_y", false);
        map.put("flip_x", false);
        map.put("crop", new float[]{0.0f, 0.0f, 1.0f, 1.0f});
        map.put("distortion_mesh", (Object) null);
        map.put("distortion_amount", valueOf);
        map.put("fringing", valueOf);
        map.put("distortion_horizontal", valueOf);
        map.put("distortion_vertical", valueOf);
        map.put("blur_opacity", Float.valueOf(1.0f));
        map.put("color_denoise", valueOf);
        map.put("luminance_denoise", valueOf);
        map.put("dehaze", valueOf);
        map.put("grid_size", new float[]{0.0f, 0.0f});
        map.put(CameraStatisticsUtil.PORTRAIT_BLUR, valueOf);
        map.put("diffuse", valueOf);
        map.put("temperature", valueOf);
        map.put("tint", valueOf);
        map.put("exposure", valueOf);
        map.put("gamma", valueOf);
        map.put("contrast", valueOf);
        map.put("highlights", valueOf);
        map.put("shadows", valueOf);
        map.put("whites", valueOf);
        map.put("blacks", valueOf);
        map.put("clarity", valueOf);
        map.put("saturation", valueOf);
        map.put("vibrance", valueOf);
        map.put("curves_red", new float[][]{new float[]{0.0f, 0.0f}, new float[]{255.0f, 255.0f}});
        map.put("curves_green", new float[][]{new float[]{0.0f, 0.0f}, new float[]{255.0f, 255.0f}});
        map.put("curves_blue", new float[][]{new float[]{0.0f, 0.0f}, new float[]{255.0f, 255.0f}});
        map.put("curves_all", new float[][]{new float[]{0.0f, 0.0f}, new float[]{255.0f, 255.0f}});
        map.put("hue_red", valueOf);
        map.put("hue_orange", valueOf);
        map.put("hue_yellow", valueOf);
        map.put("hue_green", valueOf);
        map.put("hue_aqua", valueOf);
        map.put("hue_blue", valueOf);
        map.put("hue_purple", valueOf);
        map.put("hue_magenta", valueOf);
        map.put("saturation_red", valueOf);
        map.put("saturation_orange", valueOf);
        map.put("saturation_yellow", valueOf);
        map.put("saturation_green", valueOf);
        map.put("saturation_aqua", valueOf);
        map.put("saturation_blue", valueOf);
        map.put("saturation_purple", valueOf);
        map.put("saturation_magenta", valueOf);
        map.put("luminance_red", valueOf);
        map.put("luminance_orange", valueOf);
        map.put("luminance_yellow", valueOf);
        map.put("luminance_green", valueOf);
        map.put("luminance_aqua", valueOf);
        map.put("luminance_blue", valueOf);
        map.put("luminance_purple", valueOf);
        map.put("luminance_magenta", valueOf);
        map.put("highlights_hue", valueOf);
        map.put("highlights_saturation", valueOf);
        map.put("shadows_hue", valueOf);
        map.put("shadows_saturation", valueOf);
        map.put("balance", valueOf);
        map.put("sharpen", valueOf);
        map.put("grain_amount", valueOf);
        map.put("grain_size", Float.valueOf(0.25f));
        map.put("mosaic_size", valueOf);
        map.put("vignette_amount", valueOf);
        Float valueOf2 = Float.valueOf(0.9f);
        map.put("vignette_feather", valueOf2);
        map.put("vignette_highlights", Float.valueOf(0.5f));
        map.put("vignette_roundness", Float.valueOf(-0.3f));
        map.put("vignette_size", valueOf2);
        map.put("text", new ArrayList());
        map.put("textInvertedColor", new float[]{1.0f, 1.0f, 1.0f, 1.0f});
        map.put("textInverted", false);
        map.put("faces", new ArrayList());
        map.put("face_features", new ArrayList());
        map.put("spots", new ArrayList());
    }
}
