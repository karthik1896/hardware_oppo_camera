package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.R;
import androidx.appcompat.a.a.a;
import androidx.core.g.u;

/* compiled from: AppCompatMultiAutoCompleteTextView */
public class n extends MultiAutoCompleteTextView implements u {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f454a = {16843126};

    /* renamed from: b  reason: collision with root package name */
    private final e f455b;
    private final v c;

    public n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public n(Context context, AttributeSet attributeSet, int i) {
        super(ao.a(context), attributeSet, i);
        ar a2 = ar.a(getContext(), attributeSet, f454a, i, 0);
        if (a2.g(0)) {
            setDropDownBackgroundDrawable(a2.a(0));
        }
        a2.b();
        this.f455b = new e(this);
        this.f455b.a(attributeSet, i);
        this.c = new v(this);
        this.c.a(attributeSet, i);
        this.c.b();
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(a.b(getContext(), i));
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f455b;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f455b;
        if (eVar != null) {
            eVar.a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f455b;
        if (eVar != null) {
            eVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f455b;
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f455b;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f455b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f455b;
        if (eVar != null) {
            eVar.c();
        }
        v vVar = this.c;
        if (vVar != null) {
            vVar.b();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        v vVar = this.c;
        if (vVar != null) {
            vVar.a(context, i);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return k.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
