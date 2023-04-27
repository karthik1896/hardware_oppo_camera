package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.a.a.a;
import androidx.core.content.a.f;

/* compiled from: TintTypedArray */
public class ar {

    /* renamed from: a  reason: collision with root package name */
    private final Context f417a;

    /* renamed from: b  reason: collision with root package name */
    private final TypedArray f418b;
    private TypedValue c;

    public static ar a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new ar(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static ar a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new ar(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public static ar a(Context context, int i, int[] iArr) {
        return new ar(context, context.obtainStyledAttributes(i, iArr));
    }

    private ar(Context context, TypedArray typedArray) {
        this.f417a = context;
        this.f418b = typedArray;
    }

    public Drawable a(int i) {
        int resourceId;
        if (!this.f418b.hasValue(i) || (resourceId = this.f418b.getResourceId(i, 0)) == 0) {
            return this.f418b.getDrawable(i);
        }
        return a.b(this.f417a, resourceId);
    }

    public Drawable b(int i) {
        int resourceId;
        if (!this.f418b.hasValue(i) || (resourceId = this.f418b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return i.b().a(this.f417a, resourceId, true);
    }

    public Typeface a(int i, int i2, f.a aVar) {
        int resourceId = this.f418b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.c == null) {
            this.c = new TypedValue();
        }
        return f.a(this.f417a, resourceId, this.c, i2, aVar);
    }

    public int a() {
        return this.f418b.length();
    }

    public CharSequence c(int i) {
        return this.f418b.getText(i);
    }

    public String d(int i) {
        return this.f418b.getString(i);
    }

    public boolean a(int i, boolean z) {
        return this.f418b.getBoolean(i, z);
    }

    public int a(int i, int i2) {
        return this.f418b.getInt(i, i2);
    }

    public float a(int i, float f) {
        return this.f418b.getFloat(i, f);
    }

    public int b(int i, int i2) {
        return this.f418b.getColor(i, i2);
    }

    public ColorStateList e(int i) {
        int resourceId;
        ColorStateList a2;
        if (!this.f418b.hasValue(i) || (resourceId = this.f418b.getResourceId(i, 0)) == 0 || (a2 = a.a(this.f417a, resourceId)) == null) {
            return this.f418b.getColorStateList(i);
        }
        return a2;
    }

    public int c(int i, int i2) {
        return this.f418b.getInteger(i, i2);
    }

    public float b(int i, float f) {
        return this.f418b.getDimension(i, f);
    }

    public int d(int i, int i2) {
        return this.f418b.getDimensionPixelOffset(i, i2);
    }

    public int e(int i, int i2) {
        return this.f418b.getDimensionPixelSize(i, i2);
    }

    public int f(int i, int i2) {
        return this.f418b.getLayoutDimension(i, i2);
    }

    public int g(int i, int i2) {
        return this.f418b.getResourceId(i, i2);
    }

    public CharSequence[] f(int i) {
        return this.f418b.getTextArray(i);
    }

    public boolean g(int i) {
        return this.f418b.hasValue(i);
    }

    public void b() {
        this.f418b.recycle();
    }
}
