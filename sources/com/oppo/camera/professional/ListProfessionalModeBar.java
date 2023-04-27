package com.oppo.camera.professional;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.e.f;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.professional.g;
import java.util.Locale;

public class ListProfessionalModeBar extends LinearLayout implements g.c {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f3514a = (!ListProfessionalModeBar.class.desiredAssertionStatus());

    /* renamed from: b  reason: collision with root package name */
    private ListModeBarAdapter f3515b = null;
    private int c = 0;
    private int d = -1;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private Rect h = null;
    private Activity i = null;
    private OnItemClickListener j = null;
    private ModeBarStateListener k = null;
    private boolean l = false;
    private ModePressState m = ModePressState.NO_PRESSED;
    private h n = null;

    public interface ModeBarStateListener {
        void b_(int i);
    }

    public enum ModePressState {
        NO_PRESSED,
        ISO_PRESSED,
        SHUTTER_PRESSED,
        WB_PRESSED,
        AF_PRESSED,
        EV_PRESSED
    }

    public interface OnItemClickListener {
        void a(View view, View view2, int i, long j);
    }

    public ListProfessionalModeBar(Activity activity, int i2) {
        super(activity);
        this.i = activity;
        this.c = i2;
        setGravity(17);
        setOrientation(0);
    }

    private void a(int i2, int i3, boolean z) {
        View childAt;
        int a2 = a(i2, i3);
        if (a2 != this.d && a2 != -1 && this.e > 0 && a2 < this.f3515b.getCount() && (childAt = getChildAt(a2)) != null) {
            childAt.setPressed(z);
            if (!z && this.n.i(a2) && 4 != a2) {
                this.f3515b.a(childAt, 0, false);
            }
        }
    }

    public void a() {
        setItemPressed(false);
        this.d = -1;
    }

    public int getSelectedPosition() {
        return this.d;
    }

    public ModePressState getModePressState() {
        return this.m;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        View childAt;
        View childAt2;
        View childAt3;
        View childAt4;
        e.e("ListProfessionalModeBar", "onTouchEvent, isEnabled: " + isEnabled());
        if (!isEnabled()) {
            a(this.f, this.g, false);
            if (isClickable() || isLongClickable()) {
                return true;
            }
            return false;
        } else if (motionEvent.getPointerCount() > 1) {
            a(this.f, this.g, false);
            return true;
        } else {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f = (int) motionEvent.getX();
                this.g = (int) motionEvent.getY();
                int a2 = a(this.f, this.g);
                if (a2 == -1 || this.e <= 0 || a2 >= this.f3515b.getCount() || (childAt = getChildAt(a2)) == null || !((m) childAt).f3578a) {
                    return true;
                }
                childAt.setPressed(true);
                if (this.n.i(a2) && 4 != a2) {
                    this.f3515b.a(childAt, 0, true);
                }
            } else if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int y = (int) motionEvent.getY();
                    if (Math.abs(((int) motionEvent.getX()) - this.f) > 10 || Math.abs(y - this.g) > 10) {
                        this.l = true;
                        int a3 = a(this.f, this.g);
                        if (a3 == this.d || a3 == -1 || this.e <= 0 || a3 >= this.f3515b.getCount() || (childAt3 = getChildAt(a3)) == null || !((m) childAt3).f3578a) {
                            return true;
                        }
                        childAt3.setPressed(false);
                        if (this.n.i(a3) && 4 != a3) {
                            this.f3515b.a(childAt3, 0, false);
                        }
                    }
                } else if (actionMasked == 3) {
                    if (this.l) {
                        this.l = false;
                    }
                    int a4 = a(this.f, this.g);
                    if (!(a4 == this.d || a4 == -1 || this.e <= 0 || a4 >= this.f3515b.getCount() || (childAt4 = getChildAt(a4)) == null)) {
                        m mVar = (m) childAt4;
                        if (!mVar.f3578a) {
                            return true;
                        }
                        if ((mVar.getChildAt(0) instanceof b) || (mVar.getChildAt(0) instanceof c)) {
                            childAt4.setPressed(false);
                            if (this.n.i(a4) && 4 != a4) {
                                this.f3515b.a(childAt4, 0, false);
                            }
                        }
                    }
                } else if (actionMasked != 5) {
                }
            } else if (this.l) {
                this.l = false;
                int a5 = a(this.f, this.g);
                if (a5 == this.d || a5 == -1 || this.e <= 0 || a5 >= this.f3515b.getCount() || (childAt2 = getChildAt(a5)) == null || !((m) childAt2).f3578a) {
                    return true;
                }
                childAt2.setPressed(false);
                if (this.n.i(a5) && 4 != a5) {
                    this.f3515b.a(childAt2, 0, false);
                }
            } else if (!b((int) motionEvent.getX(), (int) motionEvent.getY())) {
                b(this.f, this.g);
            }
            return true;
        }
    }

    private void setModePressedState(int i2) {
        if (-1 == i2) {
            e.e("ListProfessionalModeBar", "setModePressedState, invalid position");
        } else if (this.e <= 0 || i2 >= this.f3515b.getCount()) {
        } else {
            if (i2 == this.d) {
                this.m = ModePressState.NO_PRESSED;
            } else if (i2 == 0) {
                this.m = ModePressState.ISO_PRESSED;
            } else if (i2 == 1) {
                this.m = ModePressState.SHUTTER_PRESSED;
            } else if (i2 == 2) {
                this.m = ModePressState.WB_PRESSED;
            } else if (i2 == 3) {
                this.m = ModePressState.AF_PRESSED;
            } else if (i2 != 4) {
                e.e("ListProfessionalModeBar", "setModePressedState, default invalid position");
            } else {
                this.m = ModePressState.EV_PRESSED;
            }
        }
    }

    private boolean b(int i2, int i3) {
        int a2 = a(i2, i3);
        if (a2 == -1 || this.e <= 0 || a2 >= this.f3515b.getCount()) {
            return false;
        }
        View childAt = getChildAt(a2);
        if (childAt != null) {
            if (!((m) childAt).f3578a) {
                return true;
            }
            setPressed(false);
            childAt.setPressed(true);
        }
        setModePressedState(a2);
        int i4 = this.d;
        if (a2 != i4) {
            setPreviousAutoImage(i4);
        }
        this.d = a2;
        a(childAt, a2, this.f3515b.getItemId(a2));
        return true;
    }

    public int a(int i2, int i3) {
        Rect rect = this.h;
        if (rect == null) {
            this.h = new Rect();
            rect = this.h;
        }
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (f3514a || childAt != null) {
                if (childAt.getVisibility() == 0) {
                    childAt.getHitRect(rect);
                    if (rect.contains(i2, i3)) {
                        return childCount;
                    }
                }
                childCount--;
            } else {
                throw new AssertionError();
            }
        }
        e.e("ListProfessionalModeBar", "error frame is " + rect);
        return -1;
    }

    public boolean isSelected() {
        return -1 != this.d;
    }

    public boolean a(View view, int i2, long j2) {
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
            this.j.a(this, view, i2, j2);
        }
        return true;
    }

    private View f(int i2) {
        m mVar = new m(this.i, this.c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        mVar.setGravity(17);
        mVar.setLayoutParams(layoutParams);
        c cVar = new c(this.i);
        if (3 == i2 || 4 == i2) {
            cVar.a(false);
        }
        cVar.setId(102);
        cVar.setLayoutParams(layoutParams);
        mVar.addView(cVar);
        Resources resources = this.i.getApplicationContext().getResources();
        ImageView imageView = new ImageView(this.i);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(resources.getDimensionPixelSize(R.dimen.main_mode_bar_item_bottom_width), resources.getDimensionPixelSize(R.dimen.main_mode_bar_item_bottom_height));
        layoutParams2.addRule(12);
        layoutParams2.addRule(14);
        imageView.setLayoutParams(layoutParams2);
        imageView.setBackground(this.i.getDrawable(R.drawable.profession_mode_bar_bottom_divider_bg));
        mVar.addView(imageView);
        return mVar;
    }

    public void setAdapter(ListModeBarAdapter listModeBarAdapter) {
        this.f3515b = listModeBarAdapter;
        this.f3515b.a(new int[]{100, 101, 102});
        this.e = this.f3515b.getCount();
        b();
        requestLayout();
    }

    public ListModeBarAdapter getAdapter() {
        return this.f3515b;
    }

    public void a(int i2) {
        int i3 = this.d + i2;
        if (i3 <= getItemCount() - 1) {
            View childAt = getChildAt(i3);
            if (isSelected() && childAt != null) {
                if (!((m) childAt).f3578a) {
                    a(i2 + 1);
                    return;
                }
                setPressed(false);
                a(i3, true);
                int i4 = this.d;
                a(childAt, i4, this.f3515b.getItemId(i4));
            }
        }
    }

    public void b(int i2) {
        int i3 = this.d - i2;
        if (i3 >= 0) {
            View childAt = getChildAt(i3);
            if (isSelected() && childAt != null) {
                if (!((m) childAt).f3578a) {
                    b(i2 + 1);
                    return;
                }
                setPressed(false);
                a(i3, true);
                int i4 = this.d;
                a(childAt, i4, this.f3515b.getItemId(i4));
            }
        }
    }

    public int getItemCount() {
        return this.e;
    }

    public void a(int i2, boolean z) {
        int i3 = this.d;
        if (i2 != i3) {
            setPreviousAutoImage(i3);
        }
        this.d = i2;
        if (getChildAt(i2) != null) {
            getChildAt(i2).setPressed(z);
        }
    }

    public void setItemPressed(boolean z) {
        View childAt;
        int i2 = this.d;
        if (-1 != i2 && (childAt = getChildAt(i2)) != null) {
            childAt.setPressed(z);
            if (!z) {
                setPreviousAutoImage(this.d);
            }
        }
    }

    private void setPreviousAutoImage(int i2) {
        View childAt;
        if (-1 != i2 && 4 != i2 && (childAt = getChildAt(i2)) != null) {
            if (this.n.i(i2)) {
                this.f3515b.a(childAt, 0, false);
            } else {
                this.f3515b.a(childAt, 8, false);
            }
        }
    }

    public void removeAllViews() {
        int childCount = getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            if (f3514a || childAt != null) {
                childAt.clearAnimation();
                i2++;
            } else {
                throw new AssertionError();
            }
        }
        super.removeAllViews();
    }

    private void b() {
        int dimensionPixelSize = this.i.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.main_mode_bar_item_margin_side);
        int dimensionPixelSize2 = this.i.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.main_mode_bar_item_margin_another);
        boolean z = 1 == f.a(Locale.getDefault());
        for (int i2 = 0; i2 < this.e; i2++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            if ((i2 == 0 && !z) || (z && i2 == this.e - 1)) {
                layoutParams.leftMargin = dimensionPixelSize;
            } else if ((i2 != 0 || !z) && (z || i2 != this.e - 1)) {
                layoutParams.leftMargin = dimensionPixelSize2;
            } else {
                layoutParams.leftMargin = dimensionPixelSize2;
                layoutParams.rightMargin = dimensionPixelSize;
            }
            addView(this.f3515b.getView(i2, f(i2), this), layoutParams);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.j = onItemClickListener;
    }

    public void setModeBarStateListener(ModeBarStateListener modeBarStateListener) {
        this.k = modeBarStateListener;
    }

    public void a(int i2, String str, boolean z) {
        View childAt = getChildAt(i2);
        if (childAt != null) {
            this.f3515b.a(childAt, str);
            if (!z) {
                this.f3515b.a(childAt, 8, false);
            } else if (this.d == i2) {
                this.f3515b.a(childAt, 0, true);
            } else {
                this.f3515b.a(childAt, 0, false);
            }
        }
    }

    public void c(int i2) {
        ModeBarStateListener modeBarStateListener = this.k;
        if (modeBarStateListener != null) {
            modeBarStateListener.b_(i2);
        }
    }

    public void d(int i2) {
        View childAt = getChildAt(i2);
        if (childAt != null) {
            this.f3515b.a(i2, childAt);
        }
    }

    public void a(int i2, String str) {
        View childAt = getChildAt(i2);
        if (childAt != null) {
            this.f3515b.a(childAt, str);
        }
    }

    public String e(int i2) {
        View childAt = getChildAt(i2);
        ListModeBarAdapter listModeBarAdapter = this.f3515b;
        if (listModeBarAdapter == null || childAt == null) {
            return null;
        }
        return listModeBarAdapter.a(childAt);
    }

    public void setPanelInterface(h hVar) {
        this.n = hVar;
    }
}
