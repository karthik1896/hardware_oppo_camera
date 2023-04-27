package com.arcsoft.camera.burstpmk;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;

public class ArcRenderScriptUtil {
    private Allocation mInAllocation;
    private Allocation mOutAllocation;
    private RenderScript mRS;
    private Type.Builder mRgbaType;
    private ScriptIntrinsicYuvToRGB mYuvToRgbIntrinsic;
    private Type.Builder mYuvType;

    private void create(Context context) {
        this.mRS = RenderScript.create(context);
        RenderScript renderScript = this.mRS;
        this.mYuvToRgbIntrinsic = ScriptIntrinsicYuvToRGB.create(renderScript, Element.U8_4(renderScript));
    }

    private Bitmap yuv420spToARGB(byte[] bArr, int i, int i2) {
        if (bArr == null || this.mRS == null || this.mYuvToRgbIntrinsic == null) {
            return null;
        }
        System.currentTimeMillis();
        if (this.mYuvType == null || this.mRgbaType == null) {
            RenderScript renderScript = this.mRS;
            this.mYuvType = new Type.Builder(renderScript, Element.U8(renderScript)).setX(bArr.length);
            this.mInAllocation = Allocation.createTyped(this.mRS, this.mYuvType.create(), 1);
            RenderScript renderScript2 = this.mRS;
            this.mRgbaType = new Type.Builder(renderScript2, Element.RGBA_8888(renderScript2)).setX(i).setY(i2);
            this.mOutAllocation = Allocation.createTyped(this.mRS, this.mRgbaType.create(), 1);
        }
        System.currentTimeMillis();
        this.mInAllocation.copyFrom(bArr);
        System.currentTimeMillis();
        this.mYuvToRgbIntrinsic.setInput(this.mInAllocation);
        System.currentTimeMillis();
        this.mYuvToRgbIntrinsic.forEach(this.mOutAllocation);
        System.currentTimeMillis();
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        System.currentTimeMillis();
        this.mOutAllocation.copyTo(createBitmap);
        return createBitmap;
    }

    private void destory() {
        Allocation allocation = this.mInAllocation;
        if (allocation != null) {
            allocation.destroy();
            this.mInAllocation = null;
        }
        Allocation allocation2 = this.mOutAllocation;
        if (allocation2 != null) {
            allocation2.destroy();
            this.mOutAllocation = null;
        }
        ScriptIntrinsicYuvToRGB scriptIntrinsicYuvToRGB = this.mYuvToRgbIntrinsic;
        if (scriptIntrinsicYuvToRGB != null) {
            scriptIntrinsicYuvToRGB.destroy();
            this.mYuvToRgbIntrinsic = null;
        }
        RenderScript renderScript = this.mRS;
        if (renderScript != null) {
            renderScript.destroy();
            this.mRS = null;
        }
        this.mYuvType = null;
        this.mRgbaType = null;
    }

    public static Bitmap YUV420_TO_ARGB_WITH_DOWNSCALE(Context context, byte[] bArr, int i, int i2, int i3, int i4) {
        Bitmap bitmap;
        System.currentTimeMillis();
        ArcRenderScriptUtil arcRenderScriptUtil = new ArcRenderScriptUtil();
        arcRenderScriptUtil.create(context);
        if (i == i3 && i2 == i4) {
            System.currentTimeMillis();
            bitmap = arcRenderScriptUtil.yuv420spToARGB(bArr, i3, i4);
        } else {
            System.currentTimeMillis();
            byte[] ResizeData = BurstPMKEngine.ResizeData(i, i2, bArr, i3, i4, 0);
            System.currentTimeMillis();
            bitmap = arcRenderScriptUtil.yuv420spToARGB(ResizeData, i3, i4);
        }
        arcRenderScriptUtil.destory();
        return bitmap;
    }

    public static Bitmap YUV420_TO_ARGB(Context context, byte[] bArr, int i, int i2) {
        return YUV420_TO_ARGB_WITH_DOWNSCALE(context, bArr, i, i2, i, i2);
    }
}
