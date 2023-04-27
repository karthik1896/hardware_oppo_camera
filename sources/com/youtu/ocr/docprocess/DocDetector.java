package com.youtu.ocr.docprocess;

import android.graphics.Point;
import com.google.gson.Gson;
import com.oppo.camera.aps.constant.ApsConstant;
import com.youtu.ocr.docprocess.IText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DocDetector implements IText {

    /* renamed from: a  reason: collision with root package name */
    public static final DocDetector f4642a = new DocDetector();

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f4643b = (!DocDetector.class.desiredAssertionStatus());
    private static int c = 10;
    private static a f = new a(c, 1);
    private int d = 25;
    private List<IText.DetectResult> e = new ArrayList(c);

    public native String FindQuadByTextureNative(boolean z);

    public native boolean SetOESTextureIDNative(int i, int i2, int i3, int i4);

    public native String detectTextByByteNative(byte[] bArr, int i, int i2, int i3);

    public native boolean xnnInitedByByte(byte[] bArr);

    public native boolean xnnInitedByByteGPU(byte[] bArr, String str);

    public native void xnnReleaseGLSource();

    static {
        System.loadLibrary("YTCommon");
        System.loadLibrary(ApsConstant.CAPTURE_MODE_COMMON);
    }

    public IText.DetectResult a(byte[] bArr, int i, int i2, int i3) {
        IText.DetectResult detectResult = new IText.DetectResult();
        Gson gson = new Gson();
        String replace = detectTextByByteNative(bArr, i, i2, i3).replace("\\", "");
        if (replace.equals("")) {
            detectResult.setHasResult(false);
            return detectResult;
        }
        IText.DetectResult detectResult2 = (IText.DetectResult) gson.fromJson(replace, IText.DetectResult.class);
        if (!detectResult2.hasResult) {
            this.e.clear();
        } else if (this.e.size() > 0) {
            ArrayList arrayList = new ArrayList();
            int i4 = detectResult2.pointArr[0].x;
            List<IText.DetectResult> list = this.e;
            arrayList.add(Integer.valueOf(Math.abs(i4 - list.get(list.size() - 1).pointArr[0].x)));
            int i5 = detectResult2.pointArr[0].y;
            List<IText.DetectResult> list2 = this.e;
            arrayList.add(Integer.valueOf(Math.abs(i5 - list2.get(list2.size() - 1).pointArr[0].y)));
            int i6 = detectResult2.pointArr[1].x;
            List<IText.DetectResult> list3 = this.e;
            arrayList.add(Integer.valueOf(Math.abs(i6 - list3.get(list3.size() - 1).pointArr[1].x)));
            int i7 = detectResult2.pointArr[1].y;
            List<IText.DetectResult> list4 = this.e;
            arrayList.add(Integer.valueOf(Math.abs(i7 - list4.get(list4.size() - 1).pointArr[1].y)));
            int i8 = detectResult2.pointArr[2].x;
            List<IText.DetectResult> list5 = this.e;
            arrayList.add(Integer.valueOf(Math.abs(i8 - list5.get(list5.size() - 1).pointArr[2].x)));
            int i9 = detectResult2.pointArr[2].y;
            List<IText.DetectResult> list6 = this.e;
            arrayList.add(Integer.valueOf(Math.abs(i9 - list6.get(list6.size() - 1).pointArr[2].y)));
            int i10 = detectResult2.pointArr[3].x;
            List<IText.DetectResult> list7 = this.e;
            arrayList.add(Integer.valueOf(Math.abs(i10 - list7.get(list7.size() - 1).pointArr[3].x)));
            int i11 = detectResult2.pointArr[3].y;
            List<IText.DetectResult> list8 = this.e;
            arrayList.add(Integer.valueOf(Math.abs(i11 - list8.get(list8.size() - 1).pointArr[3].y)));
            if (((Integer) Collections.max(arrayList)).intValue() > this.d) {
                this.e.clear();
            }
        }
        if (detectResult2.hasResult) {
            if (this.e.size() < c) {
                this.e.add(detectResult2);
            } else {
                this.e.remove(0);
                this.e.add(detectResult2);
            }
        }
        return a(detectResult2);
    }

    public boolean a(int i, int i2, int i3, int i4) {
        return SetOESTextureIDNative(i, i2, i3, i4);
    }

    public IText.DetectResult a(boolean z) {
        IText.DetectResult detectResult = new IText.DetectResult();
        Gson gson = new Gson();
        String FindQuadByTextureNative = FindQuadByTextureNative(z);
        if (FindQuadByTextureNative.equals("")) {
            detectResult.setHasResult(false);
            return detectResult;
        }
        IText.DetectResult detectResult2 = (IText.DetectResult) gson.fromJson(FindQuadByTextureNative, IText.DetectResult.class);
        if (!detectResult2.hasResult) {
            this.e.clear();
        } else if (this.e.size() > 0) {
            ArrayList arrayList = new ArrayList();
            int i = detectResult2.pointArr[0].x;
            List<IText.DetectResult> list = this.e;
            arrayList.add(Integer.valueOf(Math.abs(i - list.get(list.size() - 1).pointArr[0].x)));
            int i2 = detectResult2.pointArr[0].y;
            List<IText.DetectResult> list2 = this.e;
            arrayList.add(Integer.valueOf(Math.abs(i2 - list2.get(list2.size() - 1).pointArr[0].y)));
            int i3 = detectResult2.pointArr[1].x;
            List<IText.DetectResult> list3 = this.e;
            arrayList.add(Integer.valueOf(Math.abs(i3 - list3.get(list3.size() - 1).pointArr[1].x)));
            int i4 = detectResult2.pointArr[1].y;
            List<IText.DetectResult> list4 = this.e;
            arrayList.add(Integer.valueOf(Math.abs(i4 - list4.get(list4.size() - 1).pointArr[1].y)));
            int i5 = detectResult2.pointArr[2].x;
            List<IText.DetectResult> list5 = this.e;
            arrayList.add(Integer.valueOf(Math.abs(i5 - list5.get(list5.size() - 1).pointArr[2].x)));
            int i6 = detectResult2.pointArr[2].y;
            List<IText.DetectResult> list6 = this.e;
            arrayList.add(Integer.valueOf(Math.abs(i6 - list6.get(list6.size() - 1).pointArr[2].y)));
            int i7 = detectResult2.pointArr[3].x;
            List<IText.DetectResult> list7 = this.e;
            arrayList.add(Integer.valueOf(Math.abs(i7 - list7.get(list7.size() - 1).pointArr[3].x)));
            int i8 = detectResult2.pointArr[3].y;
            List<IText.DetectResult> list8 = this.e;
            arrayList.add(Integer.valueOf(Math.abs(i8 - list8.get(list8.size() - 1).pointArr[3].y)));
            if (((Integer) Collections.max(arrayList)).intValue() > this.d) {
                this.e.clear();
            }
        }
        if (detectResult2.hasResult) {
            if (this.e.size() < c) {
                this.e.add(detectResult2);
            } else {
                this.e.remove(0);
                this.e.add(detectResult2);
            }
        }
        return a(detectResult2);
    }

    private IText.DetectResult a(IText.DetectResult detectResult) {
        DocDetector docDetector = this;
        if (docDetector.e.size() < c) {
            return detectResult;
        }
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        double d6 = 0.0d;
        double d7 = 0.0d;
        double d8 = 0.0d;
        double d9 = 0.0d;
        int i = 0;
        while (true) {
            double d10 = d7;
            if (i < c) {
                if (!docDetector.e.get(i).getHasResult()) {
                    d7 = d10;
                } else {
                    double d11 = d9 + (((double) docDetector.e.get(i).pointArr[0].x) * f.a()[i]);
                    d2 += ((double) docDetector.e.get(i).pointArr[0].y) * f.a()[i];
                    d3 += ((double) docDetector.e.get(i).pointArr[1].x) * f.a()[i];
                    d4 += ((double) docDetector.e.get(i).pointArr[1].y) * f.a()[i];
                    d5 += ((double) docDetector.e.get(i).pointArr[2].x) * f.a()[i];
                    double d12 = d11;
                    double d13 = ((double) docDetector.e.get(i).pointArr[3].x) * f.a()[i];
                    double d14 = d6 + (((double) docDetector.e.get(i).pointArr[2].y) * f.a()[i]);
                    d8 += ((double) docDetector.e.get(i).pointArr[3].y) * f.a()[i];
                    d6 = d14;
                    d7 = d13 + d10;
                    d9 = d12;
                }
                i++;
                docDetector = this;
            } else {
                return new IText.DetectResult(true, new Point[]{new Point((int) d9, (int) d2), new Point((int) d3, (int) d4), new Point((int) d5, (int) d6), new Point((int) d10, (int) d8)});
            }
        }
    }
}
