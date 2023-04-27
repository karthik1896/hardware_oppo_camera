package com.oppo.camera.h;

import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.exif.OppoExifTag;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: OppoExif */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentHashMap<String, Integer> f3341a = new ConcurrentHashMap<>();

    private static void a() {
        f3341a.put("beauty", 2);
        f3341a.put(ApsConstant.CAPTURE_MODE_PANORAMA, 4);
        f3341a.put(ApsConstant.REC_MODE_FAST_VIDEO, 8);
        f3341a.put("portrait", 16);
        f3341a.put(ApsConstant.CAPTURE_MODE_PROFESSIONAL, 256);
        f3341a.put(ApsConstant.CAPTURE_MODE_STICKER, 512);
        f3341a.put(ApsConstant.CAPTURE_MODE_NIGHT, 2048);
        f3341a.put(ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION, Integer.valueOf(OppoExifTag.EXIF_TAG_SUPER_HIGH_RESOLUTION));
        f3341a.put(ApsConstant.CAPTURE_MODE_ID_PHOTO, 16384);
        f3341a.put(ApsConstant.REC_MODE_DOUBLE_EXPOSURE, 32768);
    }

    public static int a(String str, int i) {
        if (f3341a.isEmpty()) {
            a();
        }
        return (str == null || f3341a.get(str) == null) ? i : f3341a.get(str).intValue() | i;
    }

    public static String b(String str, int i) {
        return OppoExifTag.EXIF_TAG_PREFIX.concat(String.valueOf(a(str, i)));
    }
}
