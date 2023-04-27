package com.oppo.camera.ui.preview.a;

import android.content.Context;
import co.polarr.renderer.PolarrRender;
import co.polarr.renderer.entities.DrawingItem;
import com.oppo.camera.e;
import com.oppo.camera.gl.i;
import java.util.List;

/* compiled from: PolarrFilterSdk */
public class m extends a {

    /* renamed from: a  reason: collision with root package name */
    private PolarrRender f4412a = null;

    public void a(Context context, int i, int i2, boolean z) {
        if (z || this.f4412a == null) {
            b(context, i, i2);
        }
    }

    public void a(Context context, int i, int i2) {
        if (this.f4412a == null) {
            e.a("PolarrFilterSdk", "initFilterEngine mPolarrRender");
            this.f4412a = new PolarrRender();
            i.i();
            this.f4412a.initRender(context.getResources(), i, i2, true, 1);
            i.i();
            e.a("PolarrFilterSdk", "initFilterEngine mPolarrRender X");
        }
    }

    public void a(int i, int i2) {
        if (this.f4412a != null) {
            e.a("PolarrFilterSdk", "updateSize, inputWidth: " + i + ", inputHeight: " + i2);
            this.f4412a.updateSize(i, i2);
        }
    }

    public boolean a() {
        return this.f4412a != null;
    }

    public void a(int i) {
        this.f4412a.setOutputTexture(i);
    }

    public void b(int i) {
        this.f4412a.setInputTexture(i);
    }

    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        PolarrRender.setupVignetteParams(f, f2, f3, f4, f5, f6);
    }

    public void a(String str) {
        this.f4412a.fastUpdateFilter(str);
    }

    public void b() {
        this.f4412a.updateInputTexture();
    }

    public void c() {
        this.f4412a.drawFrameWithVignette();
    }

    public void d() {
        this.f4412a.drawFrame();
    }

    public void e() {
        e.a("PolarrFilterSdk", "destroyEngine, mPolarrRender: " + this.f4412a);
        PolarrRender polarrRender = this.f4412a;
        if (polarrRender != null) {
            polarrRender.release();
            i.i();
            this.f4412a = null;
        }
    }

    public void f() {
        PolarrRender polarrRender = this.f4412a;
        if (polarrRender != null) {
            polarrRender.clearThumbCache();
            e.a("PolarrFilterSdk", "clearThumbCache");
        }
    }

    public void a(List<DrawingItem> list, int i, int i2, float f, float f2) {
        this.f4412a.setInputTexture(i);
        this.f4412a.drawFiltersFrame(list, i2, true, 0.23f, f, 0.0f);
    }

    private void b(Context context, int i, int i2) {
        e.a("PolarrFilterSdk", "initPolarrRender, version: " + PolarrRender.Version());
        e.a("initPolarrRender");
        PolarrRender polarrRender = this.f4412a;
        if (polarrRender != null) {
            polarrRender.release();
        }
        this.f4412a = new PolarrRender();
        this.f4412a.initRender(context.getResources(), i, i2, true, 0);
        e.b("initPolarrRender");
        e.a("PolarrFilterSdk", "initPolarrRender X");
    }
}
