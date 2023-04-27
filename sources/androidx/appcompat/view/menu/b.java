package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ad;
import androidx.appcompat.widget.at;

/* compiled from: ActionMenuItemView */
public class b extends AppCompatTextView implements View.OnClickListener, o.a, ActionMenuView.a {

    /* renamed from: a  reason: collision with root package name */
    j f245a;

    /* renamed from: b  reason: collision with root package name */
    h.b f246b;
    C0006b c;
    private CharSequence e;
    private Drawable f;
    private ad g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private int l;

    /* renamed from: androidx.appcompat.view.menu.b$b  reason: collision with other inner class name */
    /* compiled from: ActionMenuItemView */
    public static abstract class C0006b {
        public abstract q a();
    }

    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public b(Context context) {
        this(context, (AttributeSet) null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Resources resources = context.getResources();
        this.h = d();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, i2, 0);
        this.j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.l = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.k = -1;
        setSaveEnabled(false);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.h = d();
        e();
    }

    private boolean d() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        return i2 >= 480 || (i2 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        this.k = i2;
        super.setPadding(i2, i3, i4, i5);
    }

    public j getItemData() {
        return this.f245a;
    }

    public void initialize(j jVar, int i2) {
        this.f245a = jVar;
        setIcon(jVar.getIcon());
        setTitle(jVar.a((o.a) this));
        setId(jVar.getItemId());
        setVisibility(jVar.isVisible() ? 0 : 8);
        setEnabled(jVar.isEnabled());
        if (jVar.hasSubMenu() && this.g == null) {
            this.g = new a();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ad adVar;
        if (!this.f245a.hasSubMenu() || (adVar = this.g) == null || !adVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void onClick(View view) {
        h.b bVar = this.f246b;
        if (bVar != null) {
            bVar.a(this.f245a);
        }
    }

    public void setItemInvoker(h.b bVar) {
        this.f246b = bVar;
    }

    public void setPopupCallback(C0006b bVar) {
        this.c = bVar;
    }

    public void setExpandedFormat(boolean z) {
        if (this.i != z) {
            this.i = z;
            j jVar = this.f245a;
            if (jVar != null) {
                jVar.h();
            }
        }
    }

    private void e() {
        CharSequence charSequence;
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.e);
        if (this.f != null && (!this.f245a.m() || (!this.h && !this.i))) {
            z = false;
        }
        boolean z3 = z2 & z;
        CharSequence charSequence2 = null;
        setText(z3 ? this.e : null);
        CharSequence contentDescription = this.f245a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            if (z3) {
                charSequence = null;
            } else {
                charSequence = this.f245a.getTitle();
            }
            setContentDescription(charSequence);
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f245a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z3) {
                charSequence2 = this.f245a.getTitle();
            }
            at.a(this, charSequence2);
            return;
        }
        at.a(this, tooltipText);
    }

    public void setIcon(Drawable drawable) {
        this.f = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = this.l;
            if (intrinsicWidth > i2) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i2) / ((float) intrinsicWidth)));
                intrinsicWidth = i2;
            }
            int i3 = this.l;
            if (intrinsicHeight > i3) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i3) / ((float) intrinsicHeight)));
                intrinsicHeight = i3;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        e();
    }

    public boolean a() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.e = charSequence;
        e();
    }

    public boolean b() {
        return a() && this.f245a.getIcon() == null;
    }

    public boolean c() {
        return a();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        boolean a2 = a();
        if (a2 && (i4 = this.k) >= 0) {
            super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.j) : this.j;
        if (mode != 1073741824 && this.j > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i3);
        }
        if (!a2 && this.f != null) {
            super.setPadding((getMeasuredWidth() - this.f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    /* compiled from: ActionMenuItemView */
    private class a extends ad {
        public a() {
            super(b.this);
        }

        public q a() {
            if (b.this.c != null) {
                return b.this.c.a();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public boolean b() {
            q a2;
            if (b.this.f246b == null || !b.this.f246b.a(b.this.f245a) || (a2 = a()) == null || !a2.c()) {
                return false;
            }
            return true;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable) null);
    }
}
