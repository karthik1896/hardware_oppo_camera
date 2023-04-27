package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* compiled from: PathProperty */
class h<T> extends Property<T, Float> {

    /* renamed from: a  reason: collision with root package name */
    private final Property<T, PointF> f1286a;

    /* renamed from: b  reason: collision with root package name */
    private final PathMeasure f1287b;
    private final float c;
    private final float[] d = new float[2];
    private final PointF e = new PointF();
    private float f;

    h(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f1286a = property;
        this.f1287b = new PathMeasure(path, false);
        this.c = this.f1287b.getLength();
    }

    /* renamed from: a */
    public Float get(T t) {
        return Float.valueOf(this.f);
    }

    /* renamed from: a */
    public void set(T t, Float f2) {
        this.f = f2.floatValue();
        this.f1287b.getPosTan(this.c * f2.floatValue(), this.d, (float[]) null);
        PointF pointF = this.e;
        float[] fArr = this.d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f1286a.set(t, pointF);
    }
}
