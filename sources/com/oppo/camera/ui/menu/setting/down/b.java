package com.oppo.camera.ui.menu.setting.down;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.oppo.camera.R;
import com.oppo.camera.ui.inverse.c;
import com.oppo.camera.ui.menu.setting.CameraDrawerSettingMenuPanel;
import com.oppo.camera.ui.menu.setting.down.DrawerLayout;

/* compiled from: DrawerScrollLayout */
public class b extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private DrawerLayout f4213a = null;

    /* renamed from: b  reason: collision with root package name */
    private View f4214b = null;
    private a c = null;
    private float d = 0.0f;
    private int e = 0;
    private boolean f = false;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    /* access modifiers changed from: private */
    public a j = null;
    private Rect k = null;
    private Rect l = null;

    /* compiled from: DrawerScrollLayout */
    public interface a {
        void a(int i);

        void d();
    }

    public b(Context context, AttributeSet attributeSet, DrawerLayout drawerLayout) {
        super(context, attributeSet);
        this.f4213a = drawerLayout;
        a(context, attributeSet);
        setBackgroundColor(Color.argb(0, 0, 0, 0));
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DrawerLayout, 0, 0);
        obtainStyledAttributes.recycle();
        this.c = new a(context, attributeSet, this);
        this.c.setId(R.id.drawer_layout_anchor_view);
        this.c.setVisibility(4);
        c.INS.registerInverse(context, this.c);
        this.c.setLayoutParams(new ViewGroup.LayoutParams((int) obtainStyledAttributes.getDimension(4, 0.0f), (int) obtainStyledAttributes.getDimension(1, 0.0f)));
        addView(this.c);
        this.c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (b.this.j != null) {
                    b.this.j.d();
                }
            }
        });
    }

    public void setBackgroundColor(int i2) {
        super.setBackgroundColor(c.INS.getBackgroundColor(this, i2));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        this.g = 0;
        this.f4214b = getChildAt(0);
        a(this.f4214b, i2, i3);
        if (this.f4214b.getMeasuredHeight() == 0 || a(this.f4214b)) {
            setBackgroundColor(Color.argb(0, 0, 0, 0));
            setMeasuredDimension(this.e, 0);
            return;
        }
        a(this.c, i2, i3);
        int i4 = this.g;
        this.d = (((float) i4) / 3.0f) * 2.0f;
        setMeasuredDimension(this.e, i4);
    }

    private boolean a(View view) {
        if (view instanceof CameraDrawerSettingMenuPanel) {
            CameraDrawerSettingMenuPanel cameraDrawerSettingMenuPanel = (CameraDrawerSettingMenuPanel) view;
            if (cameraDrawerSettingMenuPanel.getChildCount() > 0) {
                for (int i2 = 0; i2 < cameraDrawerSettingMenuPanel.getChildCount(); i2++) {
                    if (cameraDrawerSettingMenuPanel.getChildAt(i2).getVisibility() == 0) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.f) {
            int i6 = this.h;
            int i7 = (i6 - this.g) / 2;
            if (i7 >= 0) {
                this.f4214b.layout(i2, ((i6 - this.c.getMeasuredHeight()) - this.f4214b.getMeasuredHeight()) - i7, this.f4214b.getMeasuredWidth(), (this.h - this.c.getMeasuredHeight()) - i7);
            }
        } else {
            this.f4214b.layout(i2, (this.h - this.c.getMeasuredHeight()) - this.f4214b.getMeasuredHeight(), this.f4214b.getMeasuredWidth(), this.h - this.c.getMeasuredHeight());
        }
        int i8 = ((i4 - i2) / 2) + i2;
        int measuredWidth = this.c.getMeasuredWidth() / 2;
        a aVar = this.c;
        aVar.layout(i8 - measuredWidth, this.h - aVar.getMeasuredHeight(), i8 + measuredWidth, this.h);
    }

    public void a(int i2, float f2, boolean z, boolean z2) {
        this.f = z;
        this.h = i2;
        if (z2) {
            this.c.a(f2);
        }
        DrawerLayout.c cVar = (DrawerLayout.c) getLayoutParams();
        if (cVar != null) {
            layout(cVar.f4202a, cVar.f4203b, cVar.c, cVar.f4203b + i2);
        }
        float f3 = ((float) i2) / this.d;
        if (1.0f < f3) {
            f3 = 1.0f;
        }
        int a2 = a(f3);
        a aVar = this.j;
        if (aVar != null) {
            aVar.a(a2);
        }
    }

    public void a(int i2, float f2) {
        this.f = false;
        this.h = i2;
        this.c.b(f2);
        DrawerLayout.c cVar = (DrawerLayout.c) getLayoutParams();
        if (cVar != null) {
            layout(cVar.f4202a, cVar.f4203b, cVar.c, cVar.f4203b + i2);
        }
        float f3 = 1.0f;
        if (1.0f >= f2) {
            f3 = f2;
        }
        int a2 = a(f3);
        a aVar = this.j;
        if (aVar != null) {
            aVar.a(a2);
        }
    }

    public void a(int i2) {
        if (this.c != null) {
            if (this.l == null) {
                this.l = new Rect();
            }
            this.c.getHitRect(this.l);
            this.c.layout(this.l.left, i2, this.l.right, this.c.getMeasuredHeight() + i2);
        }
    }

    public a getArrowView() {
        return this.c;
    }

    public int a(float f2) {
        int i2;
        float f3 = this.d;
        if (((float) this.h) < f3 || 0.0f >= f3) {
            i2 = this.h <= this.i ? Color.argb(0, 0, 0, 0) : Color.argb(0.3f * f2, 0.0f, 0.0f, 0.0f);
        } else {
            i2 = Color.argb(0.3f, 0.0f, 0.0f, 0.0f);
        }
        this.f4214b.setAlpha(f2);
        setBackgroundColor(i2);
        return i2;
    }

    private void a(View view, int i2, int i3) {
        measureChild(view, i2, i3);
        this.e = Math.max(this.e, view.getMeasuredWidth());
        this.g += view.getMeasuredHeight();
    }

    public int getMinScroll() {
        this.i = getMeasuredHeight() == 0 ? 0 : this.c.getMeasuredHeight();
        return this.i;
    }

    public void a() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void b() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.b();
        }
    }

    public boolean a(float f2, float f3) {
        if (this.c == null) {
            return false;
        }
        if (this.k == null) {
            this.k = new Rect();
            this.c.getHitRect(this.k);
        }
        return this.k.contains((int) f2, (int) f3);
    }

    public DrawerLayout getmDrawerLayout() {
        return this.f4213a;
    }

    public int getMaxScroll() {
        return this.g;
    }

    public boolean c() {
        return this.f;
    }

    public void setOnRollLayoutListener(a aVar) {
        this.j = aVar;
    }

    public void d() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void b(int i2) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(i2);
        }
    }
}
