package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.a.a.j;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.util.Arrays;

/* compiled from: ConstraintHelper */
public abstract class b extends View {

    /* renamed from: a  reason: collision with root package name */
    protected int[] f552a = new int[32];

    /* renamed from: b  reason: collision with root package name */
    protected int f553b;
    protected Context c;
    protected j d;
    protected boolean e = false;
    private String f;

    public void b(ConstraintLayout constraintLayout) {
    }

    public void c(ConstraintLayout constraintLayout) {
    }

    public void onDraw(Canvas canvas) {
    }

    public b(Context context) {
        super(context);
        this.c = context;
        a((AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    this.f = obtainStyledAttributes.getString(index);
                    setIds(this.f);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f552a, this.f553b);
    }

    public void setReferencedIds(int[] iArr) {
        this.f553b = 0;
        for (int tag : iArr) {
            setTag(tag, (Object) null);
        }
    }

    public void setTag(int i, Object obj) {
        int i2 = this.f553b + 1;
        int[] iArr = this.f552a;
        if (i2 > iArr.length) {
            this.f552a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f552a;
        int i3 = this.f553b;
        iArr2[i3] = i;
        this.f553b = i3 + 1;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.e) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void a() {
        if (this.d != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.a) {
                ((ConstraintLayout.a) layoutParams).al = this.d;
            }
        }
    }

    private void a(String str) {
        int i;
        Object a2;
        if (str != null && this.c != null) {
            String trim = str.trim();
            try {
                i = R.id.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = this.c.getResources().getIdentifier(trim, "id", this.c.getPackageName());
            }
            if (i == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout) && (a2 = ((ConstraintLayout) getParent()).a(0, (Object) trim)) != null && (a2 instanceof Integer)) {
                i = ((Integer) a2).intValue();
            }
            if (i != 0) {
                setTag(i, (Object) null);
                return;
            }
            Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
        }
    }

    private void setIds(String str) {
        if (str != null) {
            int i = 0;
            while (true) {
                int indexOf = str.indexOf(44, i);
                if (indexOf == -1) {
                    a(str.substring(i));
                    return;
                } else {
                    a(str.substring(i, indexOf));
                    i = indexOf + 1;
                }
            }
        }
    }

    public void a(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.f);
        }
        j jVar = this.d;
        if (jVar != null) {
            jVar.J();
            for (int i = 0; i < this.f553b; i++) {
                View a2 = constraintLayout.a(this.f552a[i]);
                if (a2 != null) {
                    this.d.b(constraintLayout.a(a2));
                }
            }
        }
    }
}
