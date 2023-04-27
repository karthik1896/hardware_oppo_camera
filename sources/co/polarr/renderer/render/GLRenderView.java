package co.polarr.renderer.render;

import a.a.b.b.b;
import a.a.b.b.g;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class GLRenderView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public b f1431a;

    /* renamed from: b  reason: collision with root package name */
    public GLSurfaceView f1432b;

    public class porender_YuvEf extends b {
        public porender_YuvEf(g gVar) {
            super(gVar);
        }

        public Context a() {
            return GLRenderView.this.getContext();
        }
    }

    public GLRenderView(Context context) {
        super(context);
        a();
    }

    public GLRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public GLRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public void a() {
        if (this.f1431a == null) {
            Context context = getContext();
            this.f1432b = new GLSurfaceView(context);
            g gVar = new g(context, getResources(), this.f1432b);
            this.f1431a = new porender_YuvEf(gVar);
            this.f1432b.setEGLContextClientVersion(2);
            this.f1432b.setRenderer(gVar);
            addView(this.f1432b, -1, -1);
        }
    }

    public b getRenderDelegate() {
        return this.f1431a;
    }
}
