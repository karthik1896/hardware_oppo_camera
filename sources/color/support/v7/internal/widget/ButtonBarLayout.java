package color.support.v7.internal.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import color.support.v7.appcompat.R;

public class ButtonBarLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f1500a;

    /* renamed from: b  reason: collision with root package name */
    private Button f1501b;
    private Button c;
    private Button d;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;
    private View j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private boolean u;

    public ButtonBarLayout(Context context) {
        super(context, (AttributeSet) null);
    }

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ButtonBarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        this.f1500a = context;
        this.k = this.f1500a.getResources().getDimensionPixelSize(R.dimen.color_alert_dialog_button_horizontal_padding);
        this.l = this.f1500a.getResources().getDimensionPixelSize(R.dimen.color_alert_dialog_button_vertical_padding);
        this.n = this.f1500a.getResources().getDimensionPixelSize(R.dimen.color_delete_alert_dialog_divider_height);
        this.o = this.f1500a.getResources().getDimensionPixelSize(R.dimen.color_delete_alert_dialog_button_height);
        this.p = this.f1500a.getResources().getDimensionPixelSize(R.dimen.alert_dialog_item_padding_offset);
        this.m = this.f1500a.getResources().getDimensionPixelSize(R.dimen.alert_dialog_list_item_padding_top);
        this.q = this.f1500a.getResources().getDimensionPixelSize(R.dimen.color_alert_dialog_vertical_button_divider_horizontal_margin);
        this.r = this.f1500a.getResources().getDimensionPixelSize(R.dimen.color_alert_dialog_vertical_button_divider_vertical_margin);
        this.s = this.f1500a.getResources().getDimensionPixelSize(R.dimen.color_alert_dialog_horizontal_button_divider_vertical_margin);
        this.t = this.f1500a.getResources().getDimensionPixelSize(R.dimen.color_alert_dialog_button_height);
    }

    public void setForceVertical(boolean z) {
        this.u = z;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        a();
        if (this.u || a(getMeasuredWidth())) {
            if (!r()) {
                b();
            }
            n();
            o();
            p();
            super.onMeasure(i2, i3);
            return;
        }
        if (r()) {
            h();
        }
        q();
        super.onMeasure(i2, i3);
    }

    private void a() {
        if (this.f1501b == null || this.c == null || this.d == null || this.e == null || this.f == null || this.g == null || this.h == null || this.i == null || this.j == null) {
            this.f1501b = (Button) findViewById(16908313);
            this.c = (Button) findViewById(16908314);
            this.d = (Button) findViewById(16908315);
            this.e = findViewById(R.id.color_dialog_button_divider_1);
            this.f = findViewById(R.id.color_dialog_button_divider_2);
            this.g = (View) getParent();
            this.h = this.g.findViewById(R.id.topPanel);
            this.i = this.g.findViewById(R.id.contentPanel);
            this.j = this.g.findViewById(R.id.customPanel);
        }
    }

    private boolean a(int i2) {
        int buttonCount = getButtonCount();
        if (buttonCount == 0) {
            return false;
        }
        int i3 = ((i2 - ((buttonCount - 1) * this.n)) / buttonCount) - (this.k * 2);
        int a2 = a(this.f1501b);
        int a3 = a(this.c);
        int a4 = a(this.d);
        if (a2 > i3 || a3 > i3 || a4 > i3) {
            return true;
        }
        return false;
    }

    private int a(Button button) {
        float measureText;
        if (button == null || button.getVisibility() != 0) {
            return 0;
        }
        if (Build.VERSION.SDK_INT < 28 || !button.isAllCaps()) {
            measureText = button.getPaint().measureText(button.getText().toString());
        } else {
            measureText = button.getPaint().measureText(button.getText().toString().toUpperCase());
        }
        return (int) measureText;
    }

    private void b() {
        setOrientation(1);
        setMinimumHeight(0);
        e();
        g();
        d();
        f();
        c();
    }

    private void c() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1501b.getLayoutParams();
        layoutParams.weight = 0.0f;
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.f1501b.setLayoutParams(layoutParams);
        Button button = this.f1501b;
        int i2 = this.l;
        int i3 = this.m;
        button.setPaddingRelative(i2, this.p + i3, i2, i3);
        this.f1501b.setMinHeight(this.o + this.p);
    }

    private void d() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.weight = 0.0f;
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.c.setLayoutParams(layoutParams);
        Button button = this.c;
        int i2 = this.l;
        int i3 = this.m;
        button.setPaddingRelative(i2, i3, i2, this.p + i3);
        this.c.setMinHeight(this.o + this.p);
        bringChildToFront(this.c);
    }

    private void e() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.weight = 0.0f;
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.d.setLayoutParams(layoutParams);
        Button button = this.d;
        int i2 = this.l;
        int i3 = this.m;
        button.setPaddingRelative(i2, i3, i2, i3);
        this.d.setMinHeight(this.o);
        bringChildToFront(this.d);
    }

    private void f() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = this.n;
        layoutParams.setMarginStart(this.q);
        layoutParams.setMarginEnd(this.q);
        layoutParams.topMargin = this.r;
        layoutParams.bottomMargin = 0;
        this.e.setLayoutParams(layoutParams);
    }

    private void g() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = this.n;
        layoutParams.setMarginStart(this.q);
        layoutParams.setMarginEnd(this.q);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        this.f.setLayoutParams(layoutParams);
        bringChildToFront(this.f);
    }

    private void h() {
        setOrientation(0);
        setMinimumHeight(this.t);
        l();
        k();
        m();
        i();
        j();
    }

    private void i() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1501b.getLayoutParams();
        layoutParams.weight = 1.0f;
        layoutParams.width = 0;
        layoutParams.height = -1;
        this.f1501b.setLayoutParams(layoutParams);
        Button button = this.f1501b;
        int i2 = this.k;
        button.setPaddingRelative(i2, 0, i2, 0);
        this.f1501b.setMinHeight(0);
        bringChildToFront(this.f1501b);
    }

    private void j() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        layoutParams.weight = 1.0f;
        layoutParams.width = 0;
        layoutParams.height = -1;
        this.c.setLayoutParams(layoutParams);
        Button button = this.c;
        int i2 = this.k;
        button.setPaddingRelative(i2, 0, i2, 0);
        this.c.setMinHeight(0);
    }

    private void k() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.weight = 1.0f;
        layoutParams.width = 0;
        layoutParams.height = -1;
        this.d.setLayoutParams(layoutParams);
        Button button = this.d;
        int i2 = this.k;
        button.setPaddingRelative(i2, 0, i2, 0);
        this.d.setMinHeight(0);
        bringChildToFront(this.d);
    }

    private void l() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.getLayoutParams();
        layoutParams.width = this.n;
        layoutParams.height = -1;
        layoutParams.setMarginStart(0);
        layoutParams.setMarginEnd(0);
        int i2 = this.s;
        layoutParams.topMargin = i2;
        layoutParams.bottomMargin = i2;
        this.e.setLayoutParams(layoutParams);
        bringChildToFront(this.e);
    }

    private void m() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams.width = this.n;
        layoutParams.height = -1;
        layoutParams.setMarginStart(0);
        layoutParams.setMarginEnd(0);
        int i2 = this.s;
        layoutParams.topMargin = i2;
        layoutParams.bottomMargin = i2;
        this.f.setLayoutParams(layoutParams);
        bringChildToFront(this.f);
    }

    private void n() {
        if (this.u) {
            if (a((View) this.c)) {
                if (a((View) this.f1501b) || a((View) this.d) || a(this.h) || a(this.i) || a(this.j)) {
                    Button button = this.c;
                    int i2 = this.l;
                    int i3 = this.m;
                    button.setPaddingRelative(i2, i3, i2, i3);
                    this.c.setMinHeight(this.o);
                } else {
                    Button button2 = this.c;
                    int i4 = this.l;
                    int i5 = this.m;
                    button2.setPaddingRelative(i4, this.p + i5, i4, i5);
                    this.c.setMinHeight(this.o + this.p);
                }
            }
            if (a((View) this.d)) {
                if (a((View) this.c)) {
                    if (a((View) this.f1501b) || a(this.h) || a(this.i) || a(this.j)) {
                        Button button3 = this.d;
                        int i6 = this.l;
                        int i7 = this.m;
                        button3.setPaddingRelative(i6, i7, i6, this.p + i7);
                        this.d.setMinHeight(this.o + this.p);
                    } else {
                        Button button4 = this.d;
                        int i8 = this.l;
                        int i9 = this.m;
                        int i10 = this.p;
                        button4.setPaddingRelative(i8, i9 + i10, i8, i9 + i10);
                        this.d.setMinHeight(this.o + (this.p * 2));
                    }
                } else if (a((View) this.f1501b) || a(this.h) || a(this.i) || a(this.j)) {
                    Button button5 = this.d;
                    int i11 = this.l;
                    int i12 = this.m;
                    button5.setPaddingRelative(i11, i12, i11, i12);
                    this.d.setMinHeight(this.o);
                } else {
                    Button button6 = this.d;
                    int i13 = this.l;
                    int i14 = this.m;
                    button6.setPaddingRelative(i13, this.p + i14, i13, i14);
                    this.d.setMinHeight(this.o + this.p);
                }
            }
            if (!a((View) this.f1501b)) {
                return;
            }
            if (a(this.h) || a(this.i) || a(this.j)) {
                if (a((View) this.c)) {
                    if (a((View) this.d)) {
                        Button button7 = this.f1501b;
                        int i15 = this.l;
                        int i16 = this.m;
                        button7.setPaddingRelative(i15, i16, i15, i16);
                        this.f1501b.setMinHeight(this.o);
                        return;
                    }
                    Button button8 = this.f1501b;
                    int i17 = this.l;
                    int i18 = this.m;
                    button8.setPaddingRelative(i17, i18, i17, this.p + i18);
                    this.f1501b.setMinHeight(this.o + this.p);
                } else if (a((View) this.d)) {
                    Button button9 = this.f1501b;
                    int i19 = this.l;
                    int i20 = this.m;
                    button9.setPaddingRelative(i19, i20, i19, this.p + i20);
                    this.f1501b.setMinHeight(this.o + this.p);
                } else {
                    Button button10 = this.f1501b;
                    int i21 = this.l;
                    int i22 = this.m;
                    button10.setPaddingRelative(i21, i22, i21, i22);
                    this.f1501b.setMinHeight(this.o);
                }
            } else if (a((View) this.c)) {
                if (a((View) this.d)) {
                    Button button11 = this.f1501b;
                    int i23 = this.l;
                    int i24 = this.m;
                    button11.setPaddingRelative(i23, this.p + i24, i23, i24);
                    this.f1501b.setMinHeight(this.o + this.p);
                    return;
                }
                Button button12 = this.f1501b;
                int i25 = this.l;
                int i26 = this.m;
                int i27 = this.p;
                button12.setPaddingRelative(i25, i26 + i27, i25, i26 + i27);
                this.f1501b.setMinHeight(this.o + (this.p * 2));
            } else if (a((View) this.d)) {
                Button button13 = this.f1501b;
                int i28 = this.l;
                int i29 = this.m;
                int i30 = this.p;
                button13.setPaddingRelative(i28, i29 + i30, i28, i29 + i30);
                this.f1501b.setMinHeight(this.o + (this.p * 2));
            } else {
                Button button14 = this.f1501b;
                int i31 = this.l;
                int i32 = this.m;
                button14.setPaddingRelative(i31, this.p + i32, i31, i32);
                this.f1501b.setMinHeight(this.o + this.p);
            }
        } else {
            if (a((View) this.f1501b)) {
                if (a((View) this.d) || a((View) this.c)) {
                    Button button15 = this.f1501b;
                    int i33 = this.l;
                    int i34 = this.m;
                    button15.setPaddingRelative(i33, i34, i33, i34);
                    this.f1501b.setMinHeight(this.o);
                } else {
                    Button button16 = this.f1501b;
                    int i35 = this.l;
                    int i36 = this.m;
                    button16.setPaddingRelative(i35, i36, i35, this.p + i36);
                    this.f1501b.setMinHeight(this.o + this.p);
                }
            }
            if (a((View) this.d)) {
                if (a((View) this.f1501b)) {
                    if (a((View) this.c)) {
                        Button button17 = this.d;
                        int i37 = this.l;
                        int i38 = this.m;
                        button17.setPaddingRelative(i37, i38, i37, i38);
                        this.d.setMinHeight(this.o);
                    } else {
                        Button button18 = this.d;
                        int i39 = this.l;
                        int i40 = this.m;
                        button18.setPaddingRelative(i39, i40, i39, this.p + i40);
                        this.d.setMinHeight(this.o + this.p);
                    }
                } else if (a((View) this.c)) {
                    Button button19 = this.d;
                    int i41 = this.l;
                    int i42 = this.m;
                    button19.setPaddingRelative(i41, i42, i41, i42);
                    this.d.setMinHeight(this.o);
                } else {
                    Button button20 = this.d;
                    int i43 = this.l;
                    int i44 = this.m;
                    button20.setPaddingRelative(i43, i44, i43, this.p + i44);
                    this.d.setMinHeight(this.o + this.p);
                }
            }
            if (a((View) this.c)) {
                Button button21 = this.c;
                int i45 = this.l;
                int i46 = this.m;
                button21.setPaddingRelative(i45, i46, i45, this.p + i46);
                this.c.setMinHeight(this.o + this.p);
            }
        }
    }

    private void o() {
        Button button;
        if (this.u && !a(this.h) && !a(this.i) && !a(this.j)) {
            if (getButtonCount() == 1) {
                if (a((View) this.f1501b)) {
                    button = this.f1501b;
                } else {
                    button = a((View) this.d) ? this.d : this.c;
                }
                button.setBackgroundResource(R.drawable.color_alert_bottom_dialog_corner_button_background);
            } else if (getButtonCount() == 2) {
                (a((View) this.f1501b) ? this.f1501b : this.d).setBackgroundResource(R.drawable.color_alert_bottom_dialog_corner_button_background);
            } else if (getButtonCount() == 3) {
                this.f1501b.setBackgroundResource(R.drawable.color_alert_bottom_dialog_corner_button_background);
            }
        }
    }

    private void p() {
        if (this.u) {
            if (getButtonCount() == 0) {
                this.e.setVisibility(8);
                this.f.setVisibility(8);
            } else if (!a((View) this.c)) {
                this.e.setVisibility(8);
                this.f.setVisibility(8);
            } else if (a((View) this.d) || a((View) this.f1501b) || a(this.h) || a(this.i) || a(this.j)) {
                this.e.setVisibility(8);
                this.f.setVisibility(0);
            } else {
                this.e.setVisibility(8);
                this.f.setVisibility(8);
            }
        } else if (getButtonCount() != 0) {
            this.e.setVisibility(4);
            this.f.setVisibility(8);
        } else {
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        }
    }

    private void q() {
        if (getButtonCount() == 2) {
            if (a((View) this.f1501b)) {
                this.e.setVisibility(8);
                this.f.setVisibility(0);
                return;
            }
            this.e.setVisibility(0);
            this.f.setVisibility(8);
        } else if (getButtonCount() == 3) {
            this.e.setVisibility(0);
            this.f.setVisibility(0);
        } else {
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        }
    }

    private int getButtonCount() {
        int i2 = a((View) this.f1501b) ? 1 : 0;
        if (a((View) this.c)) {
            i2++;
        }
        return a((View) this.d) ? i2 + 1 : i2;
    }

    private boolean r() {
        return getOrientation() == 1;
    }

    private boolean a(View view) {
        return view.getVisibility() == 0;
    }
}
