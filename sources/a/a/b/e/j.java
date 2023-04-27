package a.a.b.e;

import android.util.Log;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.FaceItem;
import com.oppo.camera.statistics.model.VideoRecordMsgData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, Object> f62a;

    /* renamed from: b  reason: collision with root package name */
    public static float f63b;
    public static float c;
    public static List<Map<String, Float>> d = new ArrayList();
    public static double[][] e = {new double[]{0.0331364d, 0.01992545d, 0.08380849d, 0.09557166d, 0.07298126d, 0.03792458d, 0.04305392d, 0.02882145d, 0.01573583d, 0.01385134d, 0.00569127d, 0.00417534d, 0.00582043d, 0.0086545d, 0.01163098d, 0.01299133d, 0.0248475d, 0.06363079d, 0.24632536d, 0.70301386d, 0.24735266d, 0.07361127d, 0.07628536d, 0.02761788d, 0.01512251d, 0.01604775d, 0.0023393d, 0.00309395d, 0.00412106d, 0.01805549d, 0.01069489d, 0.00766626d}, new double[]{0.09675281d, 0.27825167d, 0.653409d, 0.41969027d, 0.21404159d, 0.08441013d, 0.06580049d, 0.02822568d, 0.02530089d, 0.01460864d, 0.00802394d, 0.00664085d, 0.01136586d, 0.01154654d, 0.01275021d, 0.01409827d, 0.01252299d, 0.01453823d, 0.02515221d, 0.06523832d, 0.07022616d, 0.02762985d, 0.06598905d, 0.03268747d, 0.01554089d, 0.0197331d, 0.01101111d, 0.01268491d, 0.02955288d, 0.02914473d, 0.05982897d, 0.06413545d}, new double[]{0.10811736d, 0.1265484d, 0.32327649d, 0.44368175d, 0.21146834d, 0.07346794d, 0.04971323d, 0.01947073d, 0.01137532d, 0.01684467d, 0.00591782d, 0.00573072d, 0.00944886d, 0.04406d, 0.02686923d, 0.01672436d, 0.02762703d, 0.05314293d, 0.26482908d, 0.45195357d, 0.19299336d, 0.05496212d, 0.04965363d, 0.01321306d, 0.00547539d, 0.00719016d, 0.00208538d, 0.00231648d, 0.00323186d, 0.02300674d, 0.01301213d, 0.02582975d}};
    public static double[][] f = {new double[]{0.0041788d, 0.00557892d, 0.0044435d, 0.00925186d, 0.01913907d, 0.03713632d, 0.05344205d, 0.05742504d, 0.05839612d, 0.06107821d, 0.06292261d, 0.05419394d, 0.06247317d, 0.09105285d, 0.12097054d, 0.15363787d, 0.19601352d, 0.20619361d, 0.16863594d, 0.15479943d, 0.21203069d, 0.21778631d, 0.15114921d, 0.16286908d, 0.21800627d, 0.21615846d, 0.23419033d, 0.22906403d, 0.12154924d, 0.0814586d, 0.05694871d, 0.05786665d}, new double[]{0.05446824d, 0.17224377d, 0.31069933d, 0.35199578d, 0.3508968d, 0.33859766d, 0.31530336d, 0.24568689d, 0.22143204d, 0.2030469d, 0.19449985d, 0.160829d, 0.12220577d, 0.11939965d, 0.11130775d, 0.09771909d, 0.07921471d, 0.06970743d, 0.06262596d, 0.0464595d, 0.04654344d, 0.03666532d, 0.03412365d, 0.02425745d, 0.01928775d, 0.01701981d, 0.01406101d, 0.01404811d, 0.01518498d, 0.00908417d, 0.00835578d, 0.01859804d}, new double[]{0.04695111d, 0.13995524d, 0.14752417d, 0.15715454d, 0.14578397d, 0.13774806d, 0.15010116d, 0.16458158d, 0.15179318d, 0.15737774d, 0.13467559d, 0.11804802d, 0.11569722d, 0.11220254d, 0.11578959d, 0.14344311d, 0.18489562d, 0.20980991d, 0.25869857d, 0.20798753d, 0.17737389d, 0.15313746d, 0.17457229d, 0.19509731d, 0.13561732d, 0.1094832d, 0.10584359d, 0.15597961d, 0.08940942d, 0.04416464d, 0.01776901d, 0.01752359d}};
    public static final Map<String, Object> g = new HashMap();

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f64a;

        /* renamed from: b  reason: collision with root package name */
        public int f65b;
        public int[] c;
        public byte[] d;

        public b() {
        }
    }

    static {
        Map<String, Object> a2 = c.a("{\"local_adjustments\":[{\"type\":\"luminance\",\"target\":0,\"range\":1,\"smoothness\":1,\"adjustments\":{\"exposure\":0.1973684210526314,\"gamma\":0,\"temperature\":0,\"tint\":0,\"saturation\":0,\"vibrance\":0.24999999999999997,\"contrast\":0.24999999999999997,\"balance\":-1},\"showOverlay\":false}]}");
        if (a2 != null) {
            for (String next : a2.keySet()) {
                a2.put(next, t.a(next, a2.get(next)));
            }
        }
        f62a = a2;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        hashMap2.put("exposure", Float.valueOf(0.17f));
        hashMap2.put("contrast", Float.valueOf(0.36f));
        hashMap2.put("highlights", Float.valueOf(-0.5f));
        hashMap2.put("shadows", Float.valueOf(0.2f));
        hashMap2.put("vibrance", Float.valueOf(0.25f));
        hashMap2.put("hue_orange", Float.valueOf(-0.05f));
        hashMap2.put("saturation_orange", Float.valueOf(-0.05f));
        hashMap2.put("luminance_orange", Float.valueOf(0.14f));
        hashMap2.put("hue_yellow", Float.valueOf(-0.08f));
        hashMap2.put("clarity", Float.valueOf(-0.17f));
        hashMap3.put("exposure", Float.valueOf(0.17f));
        hashMap3.put("contrast", Float.valueOf(0.22f));
        hashMap3.put("highlights", Float.valueOf(-0.5f));
        hashMap3.put("shadows", Float.valueOf(0.24f));
        hashMap3.put("vibrance", Float.valueOf(0.3f));
        hashMap3.put("saturation_red", Float.valueOf(-0.02f));
        hashMap3.put("hue_orange", Float.valueOf(-0.05f));
        hashMap3.put("saturation_orange", Float.valueOf(-0.03f));
        hashMap3.put("luminance_orange", Float.valueOf(0.26f));
        hashMap3.put("luminance_yellow", Float.valueOf(0.1f));
        hashMap3.put("hue_yellow", Float.valueOf(-0.08f));
        hashMap3.put("luminance_green", Float.valueOf(0.17f));
        hashMap3.put("saturation_aqua", Float.valueOf(0.2f));
        hashMap3.put("luminance_aqua", Float.valueOf(-0.2f));
        hashMap3.put("saturation_blue", Float.valueOf(0.2f));
        hashMap3.put("luminance_blue", Float.valueOf(-0.2f));
        hashMap3.put("clarity", Float.valueOf(-0.17f));
        d.add(hashMap);
        d.add(hashMap2);
        d.add(hashMap3);
        g.put("method", "rgb");
        g.put("to_log", Float.valueOf(1.0f));
        g.put("size", Float.valueOf(50.0f));
        g.put("sample_step", Float.valueOf(5.0f));
        g.put("histogram_grid", Float.valueOf(10.0f));
        g.put("num_trial", Float.valueOf(50.0f));
        g.put("num_gen", Float.valueOf(6.0f));
        g.put("num_spec", Float.valueOf(20.0f));
        g.put("tolerance", Float.valueOf(100.0f));
        g.put("change_max", Float.valueOf(0.3f));
    }

    public static float a(float f2, float f3, float f4) {
        return (f2 - f4) * f3;
    }

    public static float a(float[] fArr) {
        float f2 = 0.0f;
        for (float f3 : fArr) {
            f2 += f3;
        }
        return f2 / ((float) fArr.length);
    }

    public static float a(float[] fArr, double[] dArr) {
        if (fArr == null || dArr == null || fArr.length == 0 || dArr.length == 0 || fArr.length != dArr.length) {
            return 1.0f;
        }
        float f2 = 0.0f;
        for (int i = 0; i < fArr.length; i++) {
            f2 = (float) (((double) f2) + Math.pow(((double) fArr[i]) - dArr[i], 2.0d));
        }
        return ((float) Math.sqrt((double) f2)) / 2.0f;
    }

    public static int a(int i, int i2, int i3, int i4, String str) {
        if (str == null) {
            str = "load";
        }
        return "load".equals(str) ? ((i2 * i3) + i) * 4 : ((((i4 - 1) - i2) * i3) + i) * 4;
    }

    public static HashMap<String, float[]> a(b bVar, int[] iArr) {
        HashMap<String, float[]> hashMap = new HashMap<>();
        HashMap<String, float[]> c2 = c(bVar);
        float[] a2 = a(c2.get("lum"), 1.0f, iArr[2]);
        float[] a3 = a(c2.get("sat"), 1.0f, iArr[1]);
        float[] a4 = a(c2.get("hue"), 1.0f, iArr[0]);
        hashMap.put("lum_hist", a2);
        hashMap.put("sat_hist", a3);
        hashMap.put("hue_hist", a4);
        return hashMap;
    }

    public static Map<String, Float> a(int i, int i2, byte[] bArr) {
        b bVar = new b();
        bVar.f64a = i;
        bVar.f65b = i2;
        bVar.d = bArr;
        return b(bVar);
    }

    public static Map<String, Float> a(int i, int i2, byte[] bArr, Map<String, Object> map) {
        Map<String, Float> a2 = a(i, i2, bArr);
        for (String next : a2.keySet()) {
            if (map.containsKey(next)) {
                map.put(next, a2.get(next));
            }
        }
        return a2;
    }

    public static Map<String, Float> a(int i, int i2, byte[] bArr, Map<String, Object> map, boolean z) {
        Map<String, Float> a2 = a(i, i2, bArr, z);
        for (String next : a2.keySet()) {
            if (map.containsKey(next)) {
                map.put(next, a2.get(next));
            }
        }
        return a2;
    }

    public static Map<String, Float> a(int i, int i2, byte[] bArr, boolean z) {
        b bVar = new b();
        bVar.f64a = i;
        bVar.f65b = i2;
        bVar.d = bArr;
        return a(bVar, z);
    }

    public static Map<String, Float> a(int i, int i2, int[] iArr) {
        b bVar = new b();
        bVar.f64a = i;
        bVar.f65b = i2;
        bVar.c = iArr;
        return a(bVar);
    }

    public static Map<String, Float> a(b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("method", "lum_hist");
        Float valueOf = Float.valueOf(1.0f);
        hashMap.put("to_log", valueOf);
        Float valueOf2 = Float.valueOf(50.0f);
        hashMap.put("size", valueOf2);
        Float valueOf3 = Float.valueOf(5.0f);
        hashMap.put("sample_step", valueOf3);
        Float valueOf4 = Float.valueOf(20.0f);
        hashMap.put("histogram_grid", valueOf4);
        Map<String, Float> a2 = a(a(bVar, (Map<String, Object>) hashMap), 0.0f, 0.0f, 0.0f);
        hashMap.put("method", "sat_hist");
        hashMap.put("to_log", valueOf);
        hashMap.put("size", valueOf2);
        hashMap.put("sample_step", valueOf3);
        hashMap.put("histogram_grid", valueOf4);
        Map<String, Float> c2 = c(a(bVar, (Map<String, Object>) hashMap));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("clarity", Float.valueOf(Math.min(0.3f, a2.get("highlights").floatValue())));
        HashMap hashMap3 = new HashMap();
        hashMap3.put("dehaze", Float.valueOf(Math.max(0.0f, Math.min((a2.get("highlights").floatValue() * 0.9f) + (a2.get("exposure").floatValue() * 0.4f), 1.0f))));
        Map<String, Float> a3 = a(a2, c2, (Map<String, Float>) hashMap2, (Map<String, Float>) hashMap3);
        if (a3.get("exposure").floatValue() + a3.get("highlights").floatValue() >= 0.9f) {
            a3.put("gamma", Float.valueOf((-a3.get("exposure").floatValue()) * 0.35f));
        }
        return a3;
    }

    public static Map<String, Float> a(b bVar, boolean z) {
        float f2;
        HashMap<String, float[]> a2 = a(bVar, new int[]{32, 32, 256});
        float[] fArr = a2.get("lum_hist");
        float[] a3 = a(fArr, 32);
        float[] fArr2 = a2.get("sat_hist");
        float[] e2 = e(a2.get("hue_hist"));
        float[] e3 = e(a3);
        int i = 0;
        float f3 = 2.0f;
        for (int i2 = 0; i2 < 3; i2++) {
            float a4 = (a(e2, e[i2]) * 0.3f) + (a(e3, f[i2]) * 0.7f);
            if (a4 < f3) {
                i = i2;
                f3 = a4;
            }
        }
        float d2 = d(fArr2);
        float d3 = d(a3);
        Log.d("auto ave lum sat", d3 + ", " + d2);
        f63b = d2;
        c = d3;
        if (d3 < 0.2f) {
            i = 1;
        } else if (d3 > 0.35f && i != 0) {
            i = 2;
        }
        int i3 = i == 0 ? 2 : i;
        HashMap hashMap = new HashMap(d.get(i3));
        Log.d("auto filter", "" + new String[]{"bright", "dark", VideoRecordMsgData.END_TYPE_NORMAL}[i]);
        float[] b2 = b(fArr);
        float f4 = b2[1];
        float f5 = b2[0];
        Log.d("auto bounds", f5 + ", " + f4);
        if (f4 < 255.0f) {
            float max = Math.max(-0.1f, Math.min(Math.max((float) (((double) ((((255.0f - f4) * 0.6f) / 100.0f) * 0.4f)) + (((double) (((Math.max(0.0f, f5 - 5.0f) * 0.6f) / 100.0f) * 0.4f)) * 0.2d)), 0.16f - d3) * 0.5f, 0.1f));
            Log.d("auto exposure", "" + max);
            f2 = Math.max(0.0f, max - 0.02f);
            a((Map<String, Float>) hashMap, "exposure", max);
        } else {
            f2 = 0.0f;
        }
        if (f5 > 9.0f || f2 > 0.0f) {
            float f6 = ((((-Math.max(0.0f, f5 - 5.0f)) * 0.6f) / 100.0f) - f2) * 0.4f;
            Log.d("auto gamma", "" + f6);
            if (hashMap.containsKey("gamma")) {
                f6 = Math.min(((Float) hashMap.get("gamma")).floatValue(), f6);
            }
            hashMap.put("gamma", Float.valueOf(Math.max(-0.5f, Math.min(f6, 0.5f))));
        }
        int i4 = 2;
        if (i3 == 2) {
            if (d3 < 0.5f && d2 < 0.23f) {
                float min = Math.min((0.5f - d3) * 0.4f, 0.07f);
                a((Map<String, Float>) hashMap, "temperature", min);
                Log.d("auto temperature", "" + min);
            }
            i4 = 2;
        }
        if (i3 == i4 && d2 > 0.4f && d3 > 0.25f) {
            float f7 = (d2 - 0.4f) * 0.3f;
            a((Map<String, Float>) hashMap, "vibrance", f7);
            Log.d("auto vibrance", "" + f7);
        }
        float f8 = (d2 - 0.2f) * 0.2f;
        if (i3 == 1) {
            f8 = (-(d2 - 0.3f)) * 0.2f;
        }
        a((Map<String, Float>) hashMap, "contrast", f8);
        a((Map<String, Float>) hashMap, "clarity", (-f8) * 0.5f);
        Log.d("auto contrast", "" + f8);
        float f9 = -(d3 - 0.4f);
        float f10 = f9 * 0.4f;
        a((Map<String, Float>) hashMap, "highlights", f10);
        Log.d("auto highlights", "" + f10);
        float f11 = (f9 * 0.3f) - (f2 * 0.5f);
        a((Map<String, Float>) hashMap, "shadows", f11);
        Log.d("auto shadows", "" + f11);
        if (!z) {
            Iterator it = new HashSet(hashMap.keySet()).iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str.contains("orange") || str.contains("yellow") || str.contains("red") || str.contains("clarity")) {
                    hashMap.remove(str);
                }
            }
            if (i3 == 2 && d2 > 0.25f) {
                hashMap.put("saturation_orange", Float.valueOf(0.05f));
                hashMap.put("luminance_orange", Float.valueOf(-0.15f));
                hashMap.put("saturation_yellow", Float.valueOf(0.05f));
                hashMap.put("luminance_yellow", Float.valueOf(-0.15f));
                hashMap.put("saturation_red", Float.valueOf(0.1f));
                hashMap.put("luminance_red", Float.valueOf(-0.2f));
                if (((double) d2) > 0.32d) {
                    a((Map<String, Float>) hashMap, "exposure", Math.max(0.32f - d2, -0.1f));
                }
            }
        }
        Log.d("auto adjustments", hashMap.toString());
        return hashMap;
    }

    public static Map<String, Float> a(Map<String, Float> map, Map<String, Float> map2, Map<String, Float> map3, Map<String, Float> map4) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.putAll(map2);
        hashMap.putAll(map3);
        hashMap.putAll(map4);
        return hashMap;
    }

    public static Map<String, Float> a(float[] fArr, float f2, float f3, float f4) {
        float f5;
        float f6;
        float f7;
        float f8;
        float[] fArr2 = fArr;
        float max = Math.max(f2, 0.6f);
        float max2 = Math.max(f3, 0.8f);
        float max3 = Math.max(f4, 0.3f);
        float length = (float) fArr2.length;
        int i = 0;
        float f9 = 0.0f;
        for (int i2 = 0; ((float) i2) < length; i2++) {
            f9 = (float) (((double) f9) + (((((double) i2) + 0.5d) / (((double) length) - 1.0d)) * ((double) fArr2[i2])));
        }
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        while (true) {
            float f14 = (float) i;
            if (f14 >= length) {
                break;
            }
            float f15 = (f14 + 0.5f) / (length - 1.0f);
            double d2 = (double) (f15 - 1.0f);
            float exp = (float) Math.exp(d2 * -4.0d * d2);
            f12 += fArr2[i] * exp * f15;
            f13 += exp * fArr2[i];
            double d3 = (double) f15;
            float exp2 = (float) Math.exp(-4.0d * d3 * d3);
            f10 += fArr2[i] * exp2 * f15;
            f11 += exp2 * fArr2[i];
            i++;
        }
        float f16 = f10 / f11;
        float f17 = f12 / f13;
        if (f9 > max) {
            f5 = max - f9;
            f6 = f9 - 0.0f;
        } else {
            f5 = max - f9;
            f6 = 1.0f - f9;
        }
        float f18 = f5 / f6;
        if (f17 > max2) {
            f7 = max2 - f17;
            f8 = f17 - 0.0f;
        } else {
            f7 = max2 - f17;
            f8 = 1.0f - f17;
        }
        float f19 = f7 / f8;
        float f20 = f16 > max3 ? (max3 - f16) / (f16 - 0.0f) : (max3 - f16) / (1.0f - f16);
        HashMap hashMap = new HashMap();
        hashMap.put("exposure", Float.valueOf(f18));
        hashMap.put("exposure_mean", Float.valueOf(f9));
        hashMap.put("highlights", Float.valueOf(f19));
        hashMap.put("highlights_mean", Float.valueOf(f17));
        hashMap.put("shadows", Float.valueOf(f20));
        hashMap.put("shadows_mean", Float.valueOf(f16));
        return hashMap;
    }

    public static void a(int i, int i2, int[] iArr, FaceItem faceItem, Context.FaceFeaturesState faceFeaturesState, float f2, boolean z) {
        float min = Math.min(1.0f, Math.max(0.0f, f2)) * 2.0f;
        Map<String, Float> a2 = a(i, i2, iArr);
        float[] fArr = {a2.get("exposure_mean").floatValue(), a2.get("highlights_mean").floatValue(), a2.get("shadows_mean").floatValue(), a2.get("saturation_mean").floatValue()};
        float a3 = a(fArr);
        faceItem.adjustments.skin_smoothness = a(fArr[2], 0.3f, a3) + 0.55f;
        faceItem.adjustments.skin_tone = a(fArr[0], 0.3f, a3) + 0.2f;
        faceItem.adjustments.skin_highlights = a(fArr[2], 0.1f, a3) + 0.3f;
        faceItem.adjustments.skin_shadows = a(fArr[2], 0.1f, a3) - 0.1f;
        faceItem.adjustments.eyes_contrast = a(fArr[2], 0.1f, a3) + 0.5f;
        faceItem.adjustments.eyes_brightness = a(fArr[2], 0.1f, a3) + 0.2f;
        faceItem.adjustments.lips_saturation = a(fArr[3], 0.3f, a3) + 0.2f;
        faceItem.adjustments.lips_brightness = a(fArr[3], 0.1f, a3) + 0.1f;
        Context.FaceState faceState = faceItem.adjustments;
        faceState.skin_smoothness *= min;
        faceState.skin_tone *= min;
        faceState.skin_highlights *= min;
        faceState.skin_shadows *= min;
        faceState.eyes_contrast *= min;
        faceState.eyes_brightness *= min;
        faceState.lips_saturation *= min;
        faceState.lips_brightness *= min;
        if (faceFeaturesState != null) {
            faceFeaturesState.face_width = -0.15f * min;
            float f3 = min * 0.1f;
            faceFeaturesState.eye_size = new float[]{f3, f3};
        }
    }

    public static void a(Map<String, Float> map, String str, float f2) {
        float f3;
        float f4;
        if (map.containsKey(str)) {
            f2 += map.get(str).floatValue();
        }
        if (str.equals("shadows")) {
            f4 = -1.5f;
            f3 = 1.5f;
        } else {
            f4 = -1.0f;
            f3 = 1.0f;
        }
        map.put(str, Float.valueOf(Math.max(f4, Math.min(f2, f3))));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static float[] a(a.a.b.e.j.b r4, java.util.Map<java.lang.String, java.lang.Object> r5) {
        /*
            java.lang.String r0 = "method"
            java.lang.Object r1 = r5.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x0013
            java.util.Map<java.lang.String, java.lang.Object> r1 = g
            java.lang.Object r0 = r1.get(r0)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
        L_0x0013:
            java.lang.String r0 = "sample_step"
            boolean r2 = r5.containsKey(r0)
            if (r2 == 0) goto L_0x0020
            java.lang.Object r0 = r5.get(r0)
            goto L_0x0026
        L_0x0020:
            java.util.Map<java.lang.String, java.lang.Object> r2 = g
            java.lang.Object r0 = r2.get(r0)
        L_0x0026:
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            java.lang.String r2 = "histogram_grid"
            boolean r3 = r5.containsKey(r2)
            if (r3 == 0) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            java.util.Map<java.lang.String, java.lang.Object> r5 = g
        L_0x0037:
            java.lang.Object r5 = r5.get(r2)
            java.lang.Float r5 = (java.lang.Float) r5
            float r5 = r5.floatValue()
            java.lang.String r2 = "sat_hist"
            boolean r2 = r2.equals(r1)
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r2 == 0) goto L_0x0056
            int r0 = (int) r0
            java.lang.Float[] r4 = c(r4, r0)
        L_0x0050:
            int r5 = (int) r5
            float[] r4 = a((java.lang.Float[]) r4, (float) r3, (int) r5)
            return r4
        L_0x0056:
            java.lang.String r2 = "lum_hist"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x0064
            int r0 = (int) r0
            java.lang.Float[] r4 = b(r4, r0)
            goto L_0x0050
        L_0x0064:
            java.lang.String r2 = "hue_hist"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0072
            int r0 = (int) r0
            java.lang.Float[] r4 = a((a.a.b.e.j.b) r4, (int) r0)
            goto L_0x0050
        L_0x0072:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.b.e.j.a(a.a.b.e.j$b, java.util.Map):float[]");
    }

    public static float[] a(float[] fArr, float f2, int i) {
        float max = Math.max(f2, 1.0f);
        float[] fArr2 = new float[i];
        float length = 1.0f / ((float) fArr.length);
        for (float f3 : fArr) {
            int min = (int) Math.min(Math.floor((double) ((f3 * ((float) i)) / max)), (double) (i - 1));
            fArr2[min] = fArr2[min] + length;
        }
        return fArr2;
    }

    public static float[] a(float[] fArr, int i) {
        int length = fArr.length / i;
        float[] fArr2 = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < length; i3++) {
                fArr2[i2] = fArr2[i2] + fArr[(i2 * length) + i3];
            }
        }
        return fArr2;
    }

    public static float[] a(Float[] fArr, float f2, int i) {
        float max = Math.max(f2, 1.0f);
        float[] fArr2 = new float[i];
        float length = 1.0f / ((float) fArr.length);
        for (Float floatValue : fArr) {
            int min = (int) Math.min(Math.floor((double) ((floatValue.floatValue() * ((float) i)) / max)), (double) (i - 1));
            fArr2[min] = fArr2[min] + length;
        }
        return fArr2;
    }

    public static Float[] a(b bVar, int i) {
        b bVar2 = bVar;
        int i2 = bVar2.f65b;
        int i3 = bVar2.f64a;
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (true) {
            int i5 = i4 + i;
            if (i5 >= i2) {
                return (Float[]) arrayList.toArray(new Float[arrayList.size()]);
            }
            int i6 = 0;
            while (true) {
                int i7 = i6 + i;
                if (i7 >= i3) {
                    break;
                }
                int a2 = a(i6, i4, i3, i2, (String) null);
                int[] iArr = bVar2.c;
                float f2 = ((float) iArr[a2]) / 255.0f;
                float f3 = ((float) iArr[a2 + 1]) / 255.0f;
                float f4 = ((float) iArr[a2 + 2]) / 255.0f;
                float min = Math.min(f2, Math.min(f3, f4));
                float max = Math.max(f2, Math.max(f3, f4));
                float f5 = max - min;
                float f6 = 0.0f;
                if (((double) Math.abs(f5)) > 1.0E-6d) {
                    if (f2 == max) {
                        f6 = (((f3 - f4) / f5) / 6.0f) + ((float) (f3 < f4 ? 1 : 0));
                    } else {
                        f6 = f3 == max ? (((f4 - f2) / f5) + 2.0f) / 6.0f : (((f2 - f3) / f5) + 4.0f) / 6.0f;
                    }
                }
                arrayList.add(Float.valueOf(f6));
                i6 = i7;
            }
            i4 = i5;
        }
    }

    public static Map<String, Float> b(b bVar) {
        int i;
        double d2;
        double d3;
        double d4;
        float f2;
        float f3;
        HashMap<String, float[]> a2 = a(bVar, new int[]{360, 32, 32});
        float[] fArr = a2.get("lum_hist");
        float[] fArr2 = a2.get("sat_hist");
        float[] fArr3 = a2.get("hue_hist");
        int i2 = 0;
        float f4 = 0.0f;
        while (true) {
            if (i2 >= 25) {
                break;
            }
            f4 += fArr3[i2];
            i2++;
        }
        for (int i3 = 345; i3 < 360; i3++) {
            f4 += fArr3[i3];
        }
        float f5 = 0.0f;
        for (i = 25; i < 70; i++) {
            f5 += fArr3[i];
        }
        float f6 = f4 / (f5 + f4);
        Log.d("face ave redRatio", f6 + "");
        float d5 = d(fArr2);
        float d6 = d(fArr);
        Log.d("face ave lum", d6 + "");
        Log.d("face ave sat", "" + d5);
        HashMap hashMap = new HashMap();
        if (d6 <= 0.44f) {
            d3 = (double) d5;
            d4 = 0.44d - ((double) d6);
            d2 = 0.699999988079071d;
        } else {
            d3 = (double) d5;
            d4 = 0.44d - ((double) d6);
            d2 = 0.30000001192092896d;
        }
        float f7 = (0.25f - ((float) (d3 + (d4 * d2)))) * 0.7f;
        float max = Math.max(0.0f, Math.min(0.03f, (-f7) * 0.3f));
        float f8 = (f6 - 0.5f) * 0.1f;
        Log.d("face delta hue", "" + f8);
        float f9 = max + f8;
        float max2 = Math.max(-0.25f, Math.min(0.3f, ((0.44f - d6) * 3.0f) + Math.max(0.0f, f8)));
        float min = f7 + Math.min(0.05f, (1.0f - f6) * 0.1f);
        Log.d("face lum adjust0", "" + max2);
        float f10 = d6 - c;
        if (f10 < 0.04f && max2 < 0.0f) {
            max2 += Math.min(Math.abs(max2), 0.04f - f10);
        }
        float f11 = (0.7f - f63b) - d5;
        if (f10 >= 0.15f || f11 <= 0.0f || max2 >= 0.0f) {
            f2 = max2;
        } else {
            float min2 = Math.min(0.0f, max2 + Math.min(Math.max(0.0f, f11), 0.15f));
            Log.d("face delta sat", "" + f11);
            StringBuilder sb = new StringBuilder();
            sb.append("");
            f2 = min2;
            sb.append(0.04d - ((double) f10));
            Log.d("face delta lum", sb.toString());
            float f12 = (0.04f - f10) + f11;
            min -= Math.max(0.0f, Math.min(f12, 0.2f)) * 0.3f;
            f9 -= Math.max(0.0f, Math.min(f12, 0.2f)) * 0.25f;
        }
        float max3 = Math.max(-0.15f, Math.min(0.02f, min));
        float max4 = Math.max(-0.05f, Math.min(0.05f, f9));
        if (d6 < 0.2f) {
            f3 = 0.5f;
            f2 *= 0.5f;
            max3 *= 0.5f;
        } else {
            f3 = 0.5f;
        }
        float f13 = f2;
        a((Map<String, Float>) hashMap, "saturation_orange", max3);
        a((Map<String, Float>) hashMap, "saturation_red", 0.4f * max3);
        a((Map<String, Float>) hashMap, "luminance_orange", f13);
        a((Map<String, Float>) hashMap, "luminance_yellow", f13 * f3);
        a((Map<String, Float>) hashMap, "hue_yellow", max4);
        a((Map<String, Float>) hashMap, "hue_orange", max4);
        if (f13 < 0.0f) {
            a((Map<String, Float>) hashMap, "highlights", f13);
        }
        Log.d("face lum adjust", "" + f13);
        Log.d("face sat adjust", "" + max3);
        Log.d("face hue adjust", "" + max4);
        Log.d("face adjustments:", hashMap.toString());
        return hashMap;
    }

    public static float[] b(float[] fArr) {
        float f2;
        float f3;
        float f4 = 0.0f;
        int i = 0;
        float f5 = 0.0f;
        while (true) {
            if (i >= fArr.length) {
                f2 = 0.0f;
                break;
            }
            f5 += fArr[i];
            if (f5 >= 0.007f) {
                f2 = (float) i;
                break;
            }
            i++;
        }
        float min = Math.min(f2, 75.0f);
        int length = fArr.length - 1;
        while (true) {
            if (length < 0) {
                f3 = 255.0f;
                break;
            }
            f4 += fArr[length];
            if (f4 >= 0.007f) {
                f3 = (float) length;
                break;
            }
            length--;
        }
        return new float[]{min, Math.max(f3, 190.0f)};
    }

    public static Float[] b(b bVar, int i) {
        int i2 = bVar.f65b;
        int i3 = bVar.f64a;
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (true) {
            int i5 = i4 + i;
            if (i5 >= i2) {
                return (Float[]) arrayList.toArray(new Float[arrayList.size()]);
            }
            int i6 = 0;
            while (true) {
                int i7 = i6 + i;
                if (i7 >= i3) {
                    break;
                }
                int a2 = a(i6, i4, i3, i2, (String) null);
                int[] iArr = bVar.c;
                float f2 = ((float) iArr[a2]) / 255.0f;
                float f3 = ((float) iArr[a2 + 1]) / 255.0f;
                float f4 = ((float) iArr[a2 + 2]) / 255.0f;
                arrayList.add(Float.valueOf((Math.max(f2, Math.max(f3, f4)) + Math.min(f2, Math.min(f3, f4))) / 2.0f));
                i6 = i7;
            }
            i4 = i5;
        }
    }

    public static HashMap<String, float[]> c(b bVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        b bVar2 = bVar;
        int i = bVar2.f65b * bVar2.f64a;
        float[] fArr = new float[i];
        float[] fArr2 = new float[i];
        float[] fArr3 = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 4;
            byte[] bArr = bVar2.d;
            if (bArr != null) {
                f3 = ((float) a.a.b.b.a.a(bArr[i3])) / 255.0f;
                f2 = ((float) a.a.b.b.a.a(bVar2.d[i3 + 1])) / 255.0f;
                f4 = ((float) a.a.b.b.a.a(bVar2.d[i3 + 2])) / 255.0f;
            } else {
                int[] iArr = bVar2.c;
                f4 = ((float) iArr[i3 + 2]) / 255.0f;
                f3 = ((float) iArr[i3]) / 255.0f;
                f2 = ((float) iArr[i3 + 1]) / 255.0f;
            }
            float min = Math.min(f3, Math.min(f2, f4));
            float max = Math.max(f3, Math.max(f2, f4));
            float f7 = max + min;
            float f8 = f7 / 2.0f;
            float f9 = max - min;
            fArr[i2] = f8;
            float f10 = f8;
            if (((double) Math.abs(f9)) > 1.0E-6d) {
                if (((double) f10) >= 0.5d) {
                    f7 = (2.0f - max) - min;
                }
                f5 = f9 / (f7 + 1.0E-6f);
            } else {
                f5 = 0.0f;
            }
            fArr2[i2] = f5;
            if (((double) Math.abs(f9)) <= 1.0E-6d) {
                f6 = 0.0f;
            } else if (f3 == max) {
                f6 = (((f2 - f4) / f9) / 6.0f) + ((float) (f2 < f4 ? 1 : 0));
            } else {
                f6 = f2 == max ? (((f4 - f3) / f9) + 2.0f) / 6.0f : (((f3 - f2) / f9) + 4.0f) / 6.0f;
            }
            fArr3[i2] = f6;
        }
        HashMap<String, float[]> hashMap = new HashMap<>();
        hashMap.put("lum", fArr);
        hashMap.put("sat", fArr2);
        hashMap.put("hue", fArr3);
        return hashMap;
    }

    public static Map<String, Float> c(float[] fArr) {
        float f2;
        float f3;
        float length = (float) fArr.length;
        float f4 = 0.0f;
        float f5 = 0.0f;
        for (int i = 0; ((float) i) < length; i++) {
            f5 = (float) (((double) f5) + (((((double) i) + 0.5d) / (((double) length) - 1.0d)) * ((double) fArr[i])));
        }
        if (f5 > 0.5f) {
            f2 = 0.5f - f5;
            f3 = f5 - 0.0f;
        } else {
            f2 = 0.5f - f5;
            f3 = 1.0f - f5;
        }
        float f6 = f2 / f3;
        if (f6 > 0.25f) {
            f4 = (-f6) * 0.7f;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("vibrance", Float.valueOf(f6));
        hashMap.put("saturation_orange", Float.valueOf(f4));
        hashMap.put("vibrance_mean", Float.valueOf(f5));
        hashMap.put("saturation_mean", Float.valueOf(f5));
        return hashMap;
    }

    public static Float[] c(b bVar, int i) {
        b bVar2 = bVar;
        int i2 = bVar2.f65b;
        int i3 = bVar2.f64a;
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (true) {
            int i5 = i4 + i;
            if (i5 >= i2) {
                return (Float[]) arrayList.toArray(new Float[arrayList.size()]);
            }
            int i6 = 0;
            while (true) {
                int i7 = i6 + i;
                if (i7 >= i3) {
                    break;
                }
                int a2 = a(i6, i4, i3, i2, (String) null);
                int[] iArr = bVar2.c;
                float f2 = ((float) iArr[a2]) / 255.0f;
                float f3 = ((float) iArr[a2 + 1]) / 255.0f;
                float f4 = ((float) iArr[a2 + 2]) / 255.0f;
                float min = Math.min(f2, Math.min(f3, f4));
                float max = Math.max(f2, Math.max(f3, f4));
                float f5 = max - min;
                float f6 = max + min;
                float f7 = f6 / 2.0f;
                float f8 = 0.0f;
                int i8 = i4;
                if (((double) Math.abs(f5)) > 1.0E-6d) {
                    f8 = ((double) f7) < 0.5d ? f5 / (f6 + 1.0E-6f) : f5 / (((2.0f - max) - min) + 1.0E-6f);
                }
                arrayList.add(Float.valueOf(f8));
                i6 = i7;
                i4 = i8;
            }
            i4 = i5;
        }
    }

    public static float d(float[] fArr) {
        float length = 1.0f / ((float) fArr.length);
        float f2 = 0.0f;
        for (int i = 0; i < fArr.length; i++) {
            f2 = (float) (((double) f2) + (((double) fArr[i]) * (((double) i) + 0.5d) * ((double) length)));
        }
        return f2;
    }

    public static float[] e(float[] fArr) {
        float f2 = 0.0f;
        for (float f3 : fArr) {
            f2 += f3 * f3;
        }
        float sqrt = (float) Math.sqrt((double) f2);
        float[] fArr2 = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = fArr[i] / sqrt;
        }
        return fArr2;
    }
}
