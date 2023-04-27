package com.oppo.camera.sticker;

import android.graphics.RectF;
import android.util.Size;
import com.oppo.camera.sticker.data.MultiStickerExtendedInfo;
import com.oppo.camera.util.Util;
import java.util.List;
import java.util.Map;

/* compiled from: STStickerContainer */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f3638a = 131568;

    /* renamed from: b  reason: collision with root package name */
    public static int f3639b = 852416;

    public static String a(MultiStickerExtendedInfo multiStickerExtendedInfo, int i) {
        String fileContentUri4x3 = multiStickerExtendedInfo.getFileContentUri4x3();
        if (1 == i) {
            return multiStickerExtendedInfo.getFileContentUri16x9();
        }
        if (i == 0) {
            return multiStickerExtendedInfo.getFileContentUri4x3();
        }
        return 2 == i ? multiStickerExtendedInfo.getFileContentUri1x1() : fileContentUri4x3;
    }

    public static long a(Map<b, List<MultiStickerExtendedInfo>> map) {
        long j = 0;
        for (b b2 : map.keySet()) {
            j |= b2.b();
        }
        return j;
    }

    public static RectF a(MultiStickerExtendedInfo multiStickerExtendedInfo, int i, int i2) {
        String[] strArr;
        Size size;
        int b2 = Util.b(i2, i);
        if (b2 == 0) {
            String[] split = multiStickerExtendedInfo.getBaseSize4x3().split("x");
            strArr = multiStickerExtendedInfo.getDisplayRect4x3().split(",");
            size = new Size(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        } else if (2 == b2) {
            String[] split2 = multiStickerExtendedInfo.getBaseSize1x1().split("x");
            strArr = multiStickerExtendedInfo.getDisplayRect1x1().split(",");
            size = new Size(Integer.parseInt(split2[0]), Integer.parseInt(split2[1]));
        } else {
            String[] split3 = multiStickerExtendedInfo.getBaseSize16x9().split("x");
            strArr = multiStickerExtendedInfo.getDisplayRect16x9().split(",");
            size = new Size(Integer.parseInt(split3[0]), Integer.parseInt(split3[1]));
        }
        if (strArr == null) {
            return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        }
        float width = ((float) i2) / ((float) (size.getWidth() == 0 ? i2 : size.getWidth()));
        float height = ((float) i) / ((float) (size.getHeight() == 0 ? i : size.getHeight()));
        int round = Math.round(((float) Integer.parseInt(strArr[0])) * width);
        int round2 = Math.round(((float) Integer.parseInt(strArr[1])) * height);
        return new RectF((float) round, (float) round2, (float) (round + Math.round(((float) Integer.parseInt(strArr[2])) * width)), (float) (round2 + Math.round(((float) Integer.parseInt(strArr[3])) * height)));
    }

    public static RectF a(int i, int i2, RectF rectF) {
        int i3;
        double d = (double) i2;
        double d2 = (double) i;
        double abs = Math.abs(d / d2);
        double height = ((double) rectF.height()) / ((double) rectF.width());
        double d3 = abs - height;
        int i4 = 0;
        if (d3 > 0.0d) {
            i3 = (i2 - ((int) Math.round(d2 * height))) / 2;
        } else if (d3 < 0.0d) {
            i4 = (i - ((int) Math.round(d / height))) / 2;
            i3 = 0;
        } else {
            i3 = 0;
        }
        return new RectF((float) i4, (float) i3, (float) (i - i4), (float) (i2 - i3));
    }
}
