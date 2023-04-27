package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.g.u;
import androidx.core.widget.l;

public class AppCompatImageView extends ImageView implements u, l {
    private final e mBackgroundTintHelper;
    private final m mImageHelper;

    public AppCompatImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(ao.a(context), attributeSet, i);
        this.mBackgroundTintHelper = new e(this);
        this.mBackgroundTintHelper.a(attributeSet, i);
        this.mImageHelper = new m(this);
        this.mImageHelper.a(attributeSet, i);
    }

    public void setImageResource(int i) {
        m mVar = this.mImageHelper;
        if (mVar != null) {
            mVar.a(i);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m mVar = this.mImageHelper;
        if (mVar != null) {
            mVar.d();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        m mVar = this.mImageHelper;
        if (mVar != null) {
            mVar.d();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m mVar = this.mImageHelper;
        if (mVar != null) {
            mVar.d();
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a(drawable);
        }
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

    public void setSupportImageTintList(ColorStateList colorStateList) {
        m mVar = this.mImageHelper;
        if (mVar != null) {
            mVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportImageTintList() {
        m mVar = this.mImageHelper;
        if (mVar != null) {
            return mVar.b();
        }
        return null;
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        m mVar = this.mImageHelper;
        if (mVar != null) {
            mVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        m mVar = this.mImageHelper;
        if (mVar != null) {
            return mVar.c();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.c();
        }
        m mVar = this.mImageHelper;
        if (mVar != null) {
            mVar.d();
        }
    }

    public boolean hasOverlappingRendering() {
        return this.mImageHelper.a() && super.hasOverlappingRendering();
    }
}
