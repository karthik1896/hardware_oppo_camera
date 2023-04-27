package co.polarr.renderer.textureview;

import a.a.b.b.b;
import a.a.b.b.g;
import a.a.b.d.d;
import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;

public class GLTextureView extends TextureView {

    /* renamed from: a  reason: collision with root package name */
    public b f1433a;

    /* renamed from: b  reason: collision with root package name */
    public d f1434b;

    public class porender_YuvEf extends b {
        public porender_YuvEf(g gVar) {
            super(gVar);
        }

        public Context a() {
            return GLTextureView.this.getContext();
        }
    }

    public GLTextureView(Context context) {
        super(context);
        a();
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public GLTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public void a() {
        this.f1434b = new d();
        this.f1434b.start();
        setSurfaceTextureListener(this.f1434b);
        b();
    }

    public void b() {
        if (this.f1433a == null) {
            g gVar = new g(getContext(), getResources(), this.f1434b);
            this.f1434b.a(gVar);
            this.f1433a = new porender_YuvEf(gVar);
        }
    }

    public b getRenderDelegate() {
        return this.f1433a;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1434b.b();
    }
}
