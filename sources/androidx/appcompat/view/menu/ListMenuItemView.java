package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.widget.ar;
import androidx.core.g.v;

public class ListMenuItemView extends LinearLayout implements AbsListView.SelectionBoundsAdjuster, o.a {

    /* renamed from: a  reason: collision with root package name */
    private j f241a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f242b;
    private RadioButton c;
    private TextView d;
    private CheckBox e;
    private TextView f;
    private ImageView g;
    private ImageView h;
    private LinearLayout i;
    private Drawable j;
    private int k;
    private Context l;
    private boolean m;
    private Drawable n;
    private boolean o;
    private int p;
    private LayoutInflater q;
    private boolean r;

    public boolean prefersCondensedTitle() {
        return false;
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        ar a2 = ar.a(getContext(), attributeSet, R.styleable.MenuView, i2, 0);
        this.j = a2.a(R.styleable.MenuView_android_itemBackground);
        this.k = a2.g(R.styleable.MenuView_android_itemTextAppearance, -1);
        this.m = a2.a(R.styleable.MenuView_preserveIconSpacing, false);
        this.l = context;
        this.n = a2.a(R.styleable.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, new int[]{16843049}, R.attr.dropDownListViewStyle, 0);
        this.o = obtainStyledAttributes.hasValue(0);
        a2.b();
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        v.a((View) this, this.j);
        this.d = (TextView) findViewById(R.id.title);
        int i2 = this.k;
        if (i2 != -1) {
            this.d.setTextAppearance(this.l, i2);
        }
        this.f = (TextView) findViewById(R.id.shortcut);
        this.g = (ImageView) findViewById(R.id.submenuarrow);
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setImageDrawable(this.n);
        }
        this.h = (ImageView) findViewById(R.id.group_divider);
        this.i = (LinearLayout) findViewById(R.id.content);
    }

    public void initialize(j jVar, int i2) {
        this.f241a = jVar;
        this.p = i2;
        setVisibility(jVar.isVisible() ? 0 : 8);
        setTitle(jVar.a((o.a) this));
        setCheckable(jVar.isCheckable());
        a(jVar.f(), jVar.d());
        setIcon(jVar.getIcon());
        setEnabled(jVar.isEnabled());
        setSubMenuArrowVisible(jVar.hasSubMenu());
        setContentDescription(jVar.getContentDescription());
    }

    private void a(View view) {
        a(view, -1);
    }

    private void a(View view, int i2) {
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            linearLayout.addView(view, i2);
        } else {
            addView(view, i2);
        }
    }

    public void setForceShowIcon(boolean z) {
        this.r = z;
        this.m = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.d.setText(charSequence);
            if (this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
            }
        } else if (this.d.getVisibility() != 8) {
            this.d.setVisibility(8);
        }
    }

    public j getItemData() {
        return this.f241a;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.c != null || this.e != null) {
            if (this.f241a.g()) {
                if (this.c == null) {
                    b();
                }
                compoundButton2 = this.c;
                compoundButton = this.e;
            } else {
                if (this.e == null) {
                    c();
                }
                compoundButton2 = this.e;
                compoundButton = this.c;
            }
            if (z) {
                compoundButton2.setChecked(this.f241a.isChecked());
                if (compoundButton2.getVisibility() != 0) {
                    compoundButton2.setVisibility(0);
                }
                if (compoundButton != null && compoundButton.getVisibility() != 8) {
                    compoundButton.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.e;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.c;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f241a.g()) {
            if (this.c == null) {
                b();
            }
            compoundButton = this.c;
        } else {
            if (this.e == null) {
                c();
            }
            compoundButton = this.e;
        }
        compoundButton.setChecked(z);
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void a(boolean z, char c2) {
        int i2 = (!z || !this.f241a.f()) ? 8 : 0;
        if (i2 == 0) {
            this.f.setText(this.f241a.e());
        }
        if (this.f.getVisibility() != i2) {
            this.f.setVisibility(i2);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f241a.i() || this.r;
        if (!z && !this.m) {
            return;
        }
        if (this.f242b != null || drawable != null || this.m) {
            if (this.f242b == null) {
                a();
            }
            if (drawable != null || this.m) {
                ImageView imageView = this.f242b;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f242b.getVisibility() != 0) {
                    this.f242b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f242b.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.f242b != null && this.m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f242b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i2, i3);
    }

    private void a() {
        this.f242b = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, this, false);
        a((View) this.f242b, 0);
    }

    private void b() {
        this.c = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false);
        a(this.c);
    }

    private void c() {
        this.e = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false);
        a(this.e);
    }

    private LayoutInflater getInflater() {
        if (this.q == null) {
            this.q = LayoutInflater.from(getContext());
        }
        return this.q;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setVisibility((this.o || !z) ? 8 : 0);
        }
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.h;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.h.getLayoutParams();
            rect.top += this.h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }
}
