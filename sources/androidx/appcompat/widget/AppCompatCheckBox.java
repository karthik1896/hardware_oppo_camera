package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.appcompat.R;
import androidx.appcompat.a.a.a;
import androidx.core.g.u;
import androidx.core.widget.j;

public class AppCompatCheckBox extends CheckBox implements u, j {
    private final e mBackgroundTintHelper;
    private final h mCompoundButtonHelper;
    private final v mTextHelper;

    public AppCompatCheckBox(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(ao.a(context), attributeSet, i);
        this.mCompoundButtonHelper = new h(this);
        this.mCompoundButtonHelper.a(attributeSet, i);
        this.mBackgroundTintHelper = new e(this);
        this.mBackgroundTintHelper.a(attributeSet, i);
        this.mTextHelper = new v(this);
        this.mTextHelper.a(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        h hVar = this.mCompoundButtonHelper;
        if (hVar != null) {
            hVar.c();
        }
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(a.b(getContext(), i));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        h hVar = this.mCompoundButtonHelper;
        return hVar != null ? hVar.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        h hVar = this.mCompoundButtonHelper;
        if (hVar != null) {
            hVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        h hVar = this.mCompoundButtonHelper;
        if (hVar != null) {
            return hVar.a();
        }
        return null;
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        h hVar = this.mCompoundButtonHelper;
        if (hVar != null) {
            hVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        h hVar = this.mCompoundButtonHelper;
        if (hVar != null) {
            return hVar.b();
        }
        return null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.c();
        }
        v vVar = this.mTextHelper;
        if (vVar != null) {
            vVar.b();
        }
    }
}
