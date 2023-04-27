package color.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ax;
import androidx.core.g.v;
import color.support.v7.appcompat.R;
import com.color.support.d.e;
import com.color.support.widget.popupwindow.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: ColorActionMenuViewV6 */
public class a extends ActionMenuView {
    private int A;
    public com.color.support.widget.popupwindow.a c;
    /* access modifiers changed from: private */
    public h d;
    private List<Class<?>> e;
    private int f;
    private int g;
    /* access modifiers changed from: private */
    public ArrayList h;
    /* access modifiers changed from: private */
    public j i;
    private int j;
    private boolean k;
    private int l;
    /* access modifiers changed from: private */
    public HashMap<Integer, Integer> m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private e v;
    /* access modifiers changed from: private */
    public PopupWindow.OnDismissListener w;
    /* access modifiers changed from: private */
    public View x;
    private String y;
    private String z;

    public a(Context context) {
        this(context, (AttributeSet) null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = null;
        this.e = new ArrayList();
        this.k = true;
        this.l = 0;
        this.l = getResources().getDimensionPixelSize(R.dimen.color_actionbar_menuview_padding);
        this.j = getResources().getDimensionPixelSize(R.dimen.color_action_menu_item_min_width);
        this.g = getResources().getDimensionPixelSize(R.dimen.color_action_menu_text_extra_padding);
        this.f = getResources().getDimensionPixelSize(R.dimen.color_actionbar_menuitemview_item_spacing);
        this.m = new HashMap<>();
        this.p = getResources().getDimensionPixelSize(R.dimen.color_toolbar_menu_red_dot_horizontal_offset);
        this.q = getResources().getDimensionPixelSize(R.dimen.color_toolbar_menu_red_dot_vertical_offset);
        this.r = getResources().getDimensionPixelSize(R.dimen.color_toolbar_menu_red_dot_with_number_vertical_offset);
        this.s = getResources().getDimensionPixelSize(R.dimen.color_toolbar_menu_red_dot_with_number_horizontal_offset);
        this.t = getResources().getDimensionPixelSize(R.dimen.color_toolbar_menu_red_dot_with_big_number_horizontal_offset);
        this.u = getResources().getDimensionPixelSize(R.dimen.color_toolbar_menu_icon_top_padding);
        this.y = getResources().getString(R.string.abc_action_menu_overflow_description);
        this.z = getResources().getString(R.string.red_dot_description);
        this.A = R.plurals.red_dot_with_number_description;
        this.v = new e(getContext(), (AttributeSet) null, R.styleable.ColorHintRedDot, 0, R.style.Widget_ColorSupport_ColorHintRedDot_Small);
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        view.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                return true;
            }
        });
        view.setHapticFeedbackEnabled(false);
        if (((ActionMenuView.c) layoutParams).f311a) {
            this.x = view;
            this.x.setBackgroundResource(R.drawable.color_toolbar_menu_bg);
            layoutParams.height = -1;
            this.x.setMinimumWidth(this.j);
            this.x.setOnTouchListener((View.OnTouchListener) null);
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (a.this.c == null) {
                        a aVar = a.this;
                        aVar.c = new com.color.support.widget.popupwindow.a(aVar.getContext());
                        a.this.c.setInputMethodMode(2);
                        a.this.c.a(true);
                        a.this.c.setOnDismissListener(a.this.w);
                        ArrayList unused = a.this.h = new ArrayList();
                    }
                    a.this.h.clear();
                    if (a.this.d != null) {
                        for (int i = 0; i < a.this.d.getNonActionItems().size(); i++) {
                            a aVar2 = a.this;
                            j unused2 = aVar2.i = aVar2.d.getNonActionItems().get(i);
                            a.this.h.add(new c(a.this.i.getIcon(), a.this.i.getTitle() != null ? a.this.i.getTitle().toString() : "", a.this.i.isCheckable(), a.this.i.isChecked(), a.this.m.containsKey(Integer.valueOf(a.this.i.getItemId())) ? ((Integer) a.this.m.get(Integer.valueOf(a.this.i.getItemId()))).intValue() : -1, a.this.i.isEnabled()));
                        }
                        a.this.c.a((List<c>) a.this.h);
                        a.this.c.a((AdapterView.OnItemClickListener) new AdapterView.OnItemClickListener() {
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                                a.this.d.performItemAction(a.this.d.getNonActionItems().get(i), 0);
                                a.this.c.dismiss();
                            }
                        });
                    }
                    a.this.c.a(a.this.x);
                }
            });
        }
        super.addView(view, i2, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.d == null) {
            super.onMeasure(i2, i3);
            return;
        }
        this.k = true;
        if ((getParent() instanceof Toolbar) && ((Toolbar) getParent()).getIsTitleCenterStyle()) {
            this.k = false;
        }
        setPadding(0, getPaddingTop(), 0, getPaddingBottom());
        boolean z2 = v.g(this) == 1;
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int i4 = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            i4 += b(getChildAt(i5), i2, i4, i3, 0);
        }
        if (this.k) {
            int childCount = getChildCount();
            if (childCount > 0) {
                int i6 = -1;
                int i7 = 0;
                for (int i8 = 0; i8 < childCount; i8++) {
                    if (getChildAt(i8).getVisibility() != 8) {
                        i7++;
                        i6 = i8;
                    }
                }
                int i9 = i4 + ((i7 - 1) * this.f);
                if (i6 != -1) {
                    View childAt = getChildAt(i6);
                    if ((childAt instanceof TextView) && !TextUtils.isEmpty(((TextView) childAt).getText())) {
                        i9 += this.g;
                    }
                }
                size = i9;
            } else {
                size = 0;
            }
            if (z2) {
                setPadding(getPaddingLeft(), getPaddingTop(), 0, getPaddingBottom());
            }
        }
        setMeasuredDimension(size, size2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            if (getChildAt(i8).getVisibility() != 8) {
                i7++;
            }
        }
        if (i7 > 5) {
            super.onLayout(z2, i2, i3, i4, i5);
            return;
        }
        boolean a2 = ax.a(this);
        int i9 = (i5 - i3) / 2;
        if (this.k) {
            if (a2) {
                int width = getWidth() - getPaddingRight();
                while (i6 < childCount) {
                    View childAt = getChildAt(i6);
                    ActionMenuView.c cVar = (ActionMenuView.c) childAt.getLayoutParams();
                    if (childAt.getVisibility() != 8) {
                        int i10 = width - cVar.rightMargin;
                        int measuredWidth = childAt.getMeasuredWidth();
                        int measuredHeight = childAt.getMeasuredHeight();
                        int i11 = i9 - (measuredHeight / 2);
                        childAt.layout(i10 - measuredWidth, i11, i10, measuredHeight + i11);
                        width = i10 - ((measuredWidth + cVar.leftMargin) + this.f);
                    }
                    i6++;
                }
                return;
            }
            int paddingLeft = getPaddingLeft();
            while (i6 < childCount) {
                View childAt2 = getChildAt(i6);
                ActionMenuView.c cVar2 = (ActionMenuView.c) childAt2.getLayoutParams();
                if (childAt2.getVisibility() != 8) {
                    int i12 = paddingLeft + cVar2.leftMargin;
                    int measuredWidth2 = childAt2.getMeasuredWidth();
                    int measuredHeight2 = childAt2.getMeasuredHeight();
                    int i13 = i9 - (measuredHeight2 / 2);
                    childAt2.layout(i12, i13, i12 + measuredWidth2, measuredHeight2 + i13);
                    paddingLeft = i12 + measuredWidth2 + cVar2.rightMargin + this.f;
                }
                i6++;
            }
        } else if (a2) {
            int paddingLeft2 = getPaddingLeft();
            boolean z3 = true;
            for (int i14 = childCount - 1; i14 >= 0; i14--) {
                View childAt3 = getChildAt(i14);
                ActionMenuView.c cVar3 = (ActionMenuView.c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8) {
                    paddingLeft2 += cVar3.leftMargin;
                    if (z3) {
                        if ((childAt3 instanceof TextView) && !TextUtils.isEmpty(((TextView) childAt3).getText())) {
                            paddingLeft2 += this.g;
                        }
                        z3 = false;
                    }
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i15 = i9 - (measuredHeight3 / 2);
                    if (i14 != 0 || i7 <= 1) {
                        childAt3.layout(paddingLeft2, i15, paddingLeft2 + measuredWidth3, measuredHeight3 + i15);
                        paddingLeft2 += measuredWidth3 + cVar3.rightMargin + this.f;
                    } else {
                        int width2 = ((getWidth() - getPaddingRight()) - cVar3.rightMargin) - measuredWidth3;
                        if ((childAt3 instanceof TextView) && !TextUtils.isEmpty(((TextView) childAt3).getText())) {
                            width2 -= this.l;
                        }
                        childAt3.layout(width2, i15, measuredWidth3 + width2, measuredHeight3 + i15);
                    }
                }
            }
        } else {
            int width3 = getWidth() - getPaddingRight();
            boolean z4 = true;
            for (int i16 = childCount - 1; i16 >= 0; i16--) {
                View childAt4 = getChildAt(i16);
                ActionMenuView.c cVar4 = (ActionMenuView.c) childAt4.getLayoutParams();
                if (childAt4.getVisibility() != 8) {
                    width3 -= cVar4.rightMargin;
                    if (z4) {
                        if ((childAt4 instanceof TextView) && !TextUtils.isEmpty(((TextView) childAt4).getText())) {
                            width3 -= this.g;
                        }
                        z4 = false;
                    }
                    int measuredWidth4 = childAt4.getMeasuredWidth();
                    int measuredHeight4 = childAt4.getMeasuredHeight();
                    int i17 = i9 - (measuredHeight4 / 2);
                    if (i16 != 0 || i7 <= 1) {
                        childAt4.layout(width3 - measuredWidth4, i17, width3, measuredHeight4 + i17);
                        width3 -= (measuredWidth4 + cVar4.leftMargin) + this.f;
                    } else {
                        int paddingLeft3 = getPaddingLeft() + cVar4.leftMargin;
                        if ((childAt4 instanceof TextView) && !TextUtils.isEmpty(((TextView) childAt4).getText())) {
                            paddingLeft3 += this.l;
                        }
                        childAt4.layout(paddingLeft3, i17, measuredWidth4 + paddingLeft3, measuredHeight4 + i17);
                    }
                }
            }
        }
    }

    public void setOverflowReserved(boolean z2) {
        super.setOverflowReserved(z2);
        com.color.support.widget.popupwindow.a aVar = this.c;
        if (aVar != null && aVar.isShowing()) {
            this.h.clear();
            if (this.d.getNonActionItems().size() == 0) {
                ((BaseAdapter) this.c.b().getAdapter()).notifyDataSetChanged();
                this.c.dismiss();
                return;
            }
            for (int i2 = 0; i2 < this.d.getNonActionItems().size(); i2++) {
                this.i = this.d.getNonActionItems().get(i2);
                this.h.add(new c(this.i.getIcon(), this.i.getTitle() != null ? this.i.getTitle().toString() : "", this.i.isCheckable(), this.i.isChecked(), this.m.containsKey(Integer.valueOf(this.i.getItemId())) ? this.m.get(Integer.valueOf(this.i.getItemId())).intValue() : -1, this.i.isEnabled()));
            }
            ((BaseAdapter) this.c.b().getAdapter()).notifyDataSetChanged();
            this.c.a();
            com.color.support.widget.popupwindow.a aVar2 = this.c;
            aVar2.update(aVar2.getWidth(), this.c.getHeight());
        }
    }

    public Menu getMenu() {
        this.d = (h) super.getMenu();
        return this.d;
    }

    public void initialize(h hVar) {
        this.d = hVar;
        super.initialize(hVar);
    }

    private int b(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        view.measure(getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + i6 + i3, marginLayoutParams.width), getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + i6;
    }

    public void j() {
        this.o = 0;
        this.n = 0;
        this.m.clear();
    }

    private String b(int i2) {
        if (i2 == -1) {
            return "";
        }
        if (i2 == 0) {
            return this.z;
        }
        return getResources().getQuantityString(this.A, i2, new Object[]{Integer.valueOf(i2)});
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (this.m.containsKey(Integer.valueOf(childAt.getId()))) {
                a(childAt, this.m.get(Integer.valueOf(childAt.getId())).intValue(), canvas);
            }
            if (((ActionMenuView.c) childAt.getLayoutParams()).f311a) {
                int i3 = this.n == 0 ? -1 : this.o;
                a(childAt, i3, canvas);
                childAt.setContentDescription(this.y + "," + b(i3));
            }
        }
    }

    private void a(View view, int i2, Canvas canvas) {
        int i3;
        int i4;
        float f2;
        float f3;
        int i5 = i2 != -1 ? i2 != 0 ? 2 : 1 : 0;
        if (view != null) {
            int a2 = this.v.a(i5, i2);
            int a3 = this.v.a(i5);
            if (i5 == 1) {
                i4 = this.p;
                i3 = this.q;
            } else if (i2 < 100) {
                i4 = this.s;
                i3 = this.r;
            } else {
                i4 = this.t;
                i3 = this.r;
            }
            RectF rectF = new RectF();
            if (k()) {
                f2 = (view.getX() + ((float) i4)) - ((float) this.l);
                f3 = f2 - ((float) a2);
            } else {
                f3 = ((view.getX() + ((float) view.getWidth())) - ((float) i4)) + ((float) this.l);
                f2 = ((float) a2) + f3;
            }
            float f4 = (float) (this.u - i3);
            rectF.left = f3;
            rectF.top = f4;
            rectF.right = f2;
            rectF.bottom = ((float) a3) + f4;
            this.v.a(canvas, i5, i2, rectF);
        }
    }

    private boolean k() {
        return v.g(this) == 1;
    }

    public void setPopupWindowOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.w = onDismissListener;
    }

    public boolean e() {
        if (this.c == null) {
            return false;
        }
        this.h.clear();
        for (int i2 = 0; i2 < this.d.getNonActionItems().size(); i2++) {
            this.i = this.d.getNonActionItems().get(i2);
            this.h.add(new c(this.i.getIcon(), this.i.getTitle() != null ? this.i.getTitle().toString() : "", this.i.isCheckable(), this.i.isChecked(), this.m.containsKey(Integer.valueOf(this.i.getItemId())) ? this.m.get(Integer.valueOf(this.i.getItemId())).intValue() : -1, this.i.isEnabled()));
        }
        ((BaseAdapter) this.c.b().getAdapter()).notifyDataSetChanged();
        this.c.a(this.x);
        return true;
    }
}
