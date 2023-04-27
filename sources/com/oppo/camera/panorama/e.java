package com.oppo.camera.panorama;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;
import com.arcsoft.camera.burstpmk.BurstPMKEngine;

/* compiled from: PanoRenderScriptUtil */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private RenderScript f3478a = null;

    /* renamed from: b  reason: collision with root package name */
    private ScriptIntrinsicYuvToRGB f3479b = null;
    private Type.Builder c = null;
    private Type.Builder d = null;
    private Allocation e = null;
    private Allocation f = null;

    private void a(Context context) {
        this.f3478a = RenderScript.create(context);
        RenderScript renderScript = this.f3478a;
        this.f3479b = ScriptIntrinsicYuvToRGB.create(renderScript, Element.U8_4(renderScript));
    }

    private Bitmap a(byte[] bArr, int i, int i2) {
        if (bArr == null || this.f3478a == null || this.f3479b == null) {
            return null;
        }
        if (this.c == null || this.d == null) {
            RenderScript renderScript = this.f3478a;
            this.c = new Type.Builder(renderScript, Element.U8(renderScript)).setX(bArr.length);
            this.e = Allocation.createTyped(this.f3478a, this.c.create(), 1);
            RenderScript renderScript2 = this.f3478a;
            this.d = new Type.Builder(renderScript2, Element.RGBA_8888(renderScript2)).setX(i).setY(i2);
            this.f = Allocation.createTyped(this.f3478a, this.d.create(), 1);
        }
        this.e.copyFrom(bArr);
        this.f3479b.setInput(this.e);
        this.f3479b.forEach(this.f);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.f.copyTo(createBitmap);
        return createBitmap;
    }

    private void a() {
        Allocation allocation = this.e;
        if (allocation != null) {
            allocation.destroy();
            this.e = null;
        }
        Allocation allocation2 = this.f;
        if (allocation2 != null) {
            allocation2.destroy();
            this.f = null;
        }
        ScriptIntrinsicYuvToRGB scriptIntrinsicYuvToRGB = this.f3479b;
        if (scriptIntrinsicYuvToRGB != null) {
            scriptIntrinsicYuvToRGB.destroy();
            this.f3479b = null;
        }
        RenderScript renderScript = this.f3478a;
        if (renderScript != null) {
            renderScript.destroy();
            this.f3478a = null;
        }
        this.c = null;
        this.d = null;
    }

    public static Bitmap a(Context context, byte[] bArr, int i, int i2, int i3, int i4) {
        Bitmap bitmap;
        e eVar = new e();
        eVar.a(context);
        if (i == i3 && i2 == i4) {
            bitmap = eVar.a(bArr, i3, i4);
        } else {
            bitmap = eVar.a(BurstPMKEngine.ResizeData(i, i2, bArr, i3, i4, 0), i3, i4);
        }
        eVar.a();
        return bitmap;
    }

    public static Bitmap a(Context context, byte[] bArr, int i, int i2) {
        return a(context, bArr, i, i2, i, i2);
    }
}
