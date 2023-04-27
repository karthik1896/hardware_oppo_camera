package a.a.b.b;

import a.a.b.d;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import java.io.File;
import java.util.Map;

public abstract class b {
    public static final String WATERMARK_PATH = "/watermark.png";

    /* renamed from: a  reason: collision with root package name */
    public final d f7a;

    /* renamed from: b  reason: collision with root package name */
    public g f8b;
    public int c;
    public int d;
    public Bitmap e;

    public b(g gVar) {
        this.f8b = gVar;
        b().currentRender = gVar;
        b().context = a();
        b().assetManager = a().getAssets();
        b().resources = a().getResources();
        b().glRenderView = this;
        try {
            this.e = d();
            if (this.e == null) {
                this.e = BitmapFactory.decodeStream(a().getAssets().open("editor/img/sample_images/logo-large.png"));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f7a = new d();
    }

    public abstract Context a();

    public void a(int i) {
        GLES20.glGetError();
        if (this.f7a.m() != i) {
            this.f7a.b(i);
            this.f7a.c(this.c, this.d);
            this.f7a.w();
        }
    }

    public void a(int[] iArr) {
        GLES20.glGetError();
        if (!this.f7a.a(iArr)) {
            this.f7a.c(this.c, this.d);
            this.f7a.w();
        }
    }

    public final co.polarr.renderer.entities.Context b() {
        return a.f6a;
    }

    public Resources c() {
        return a().getResources();
    }

    public final Bitmap d() {
        try {
            File file = new File(a().getFilesDir().getPath() + WATERMARK_PATH);
            if (file.exists()) {
                return BitmapFactory.decodeFile(file.getPath());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public void e() {
        this.f7a.a(a().getResources(), 512, 512, (Map<String, Object>) null);
        this.f7a.g(false);
    }

    public void f() {
        g gVar = this.f8b;
        if (gVar != null) {
            gVar.c();
        }
    }
}
