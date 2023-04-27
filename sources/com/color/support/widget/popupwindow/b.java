package com.color.support.widget.popupwindow;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import color.support.v7.appcompat.R;
import com.color.support.widget.ColorHintRedDot;
import java.util.List;

/* compiled from: DefaultAdapter */
public class b extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f2257a;

    /* renamed from: b  reason: collision with root package name */
    private List<c> f2258b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g = this.f2257a.getResources().getDimensionPixelSize(R.dimen.color_popup_list_window_item_title_margin_with_no_icon);
    private int h = this.f2257a.getResources().getDimensionPixelSize(R.dimen.color_popup_list_window_item_title_margin_left);
    private int i = this.f2257a.getResources().getDimensionPixelSize(R.dimen.color_popup_list_window_item_title_margin_right);
    private ColorStateList j = this.f2257a.getResources().getColorStateList(R.color.color_popup_list_window_text_color_selector);
    private float k = ((float) this.f2257a.getResources().getDimensionPixelSize(R.dimen.color_popup_list_window_item_title_text_size));
    private float l = this.f2257a.getResources().getConfiguration().fontScale;
    private View.AccessibilityDelegate m = new View.AccessibilityDelegate() {
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("");
        }
    };

    public long getItemId(int i2) {
        return (long) i2;
    }

    public b(Context context, List<c> list) {
        this.f2257a = context;
        this.f2258b = list;
        Resources resources = context.getResources();
        this.c = resources.getDimensionPixelSize(R.dimen.color_popup_list_padding_vertical);
        this.d = resources.getDimensionPixelSize(R.dimen.color_popup_list_window_item_padding_top_and_bottom);
        this.e = resources.getDimensionPixelSize(R.dimen.color_popup_list_window_item_min_height);
        this.f = resources.getDimensionPixelOffset(R.dimen.color_popup_list_window_content_min_width_with_checkbox);
    }

    public int getCount() {
        return this.f2258b.size();
    }

    public Object getItem(int i2) {
        return this.f2258b.get(i2);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            a aVar2 = new a();
            View inflate = LayoutInflater.from(this.f2257a).inflate(R.layout.color_popup_list_window_item, viewGroup, false);
            aVar2.f2260a = (ImageView) inflate.findViewById(R.id.popup_list_window_item_icon);
            aVar2.f2261b = (TextView) inflate.findViewById(R.id.popup_list_window_item_title);
            aVar2.e = (LinearLayout) inflate.findViewById(R.id.content);
            aVar2.d = (ColorHintRedDot) inflate.findViewById(R.id.red_dot);
            aVar2.c = (CheckBox) inflate.findViewById(R.id.checkbox);
            if (aVar2.c != null) {
                aVar2.c.setAccessibilityDelegate(this.m);
            }
            inflate.setTag(aVar2);
            View view2 = inflate;
            aVar = aVar2;
            view = view2;
        } else {
            aVar = (a) view.getTag();
        }
        if (getCount() == 1) {
            view.setMinimumHeight(this.e + (this.c * 2));
            int i3 = this.d;
            int i4 = this.c;
            view.setPadding(0, i3 + i4, 0, i3 + i4);
        } else if (i2 == 0) {
            view.setMinimumHeight(this.e + this.c);
            int i5 = this.d;
            view.setPadding(0, this.c + i5, 0, i5);
        } else if (i2 == getCount() - 1) {
            view.setMinimumHeight(this.e + this.c);
            int i6 = this.d;
            view.setPadding(0, i6, 0, this.c + i6);
        } else {
            view.setMinimumHeight(this.e);
            int i7 = this.d;
            view.setPadding(0, i7, 0, i7);
        }
        boolean d2 = this.f2258b.get(i2).d();
        view.setEnabled(d2);
        a(this.f2258b.get(i2), aVar.d);
        a(aVar.f2260a, aVar.f2261b, this.f2258b.get(i2), d2);
        a(aVar.f2261b, this.f2258b.get(i2), d2);
        a((LinearLayout) view, aVar.c, this.f2258b.get(i2), d2);
        return view;
    }

    private void a(ImageView imageView, TextView textView, c cVar, boolean z) {
        Drawable drawable;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        if (cVar.a() == 0 && cVar.b() == null) {
            imageView.setVisibility(8);
            layoutParams.setMarginStart(this.g);
            if (cVar.g() != -1 || cVar.e()) {
                layoutParams.setMarginEnd(0);
            } else {
                layoutParams.setMarginEnd(this.g);
            }
        } else {
            imageView.setVisibility(0);
            layoutParams.setMarginStart(this.h);
            if (cVar.g() != -1 || cVar.e()) {
                layoutParams.setMarginEnd(0);
            } else {
                layoutParams.setMarginEnd(this.i);
            }
            imageView.setEnabled(z);
            if (cVar.b() == null) {
                drawable = this.f2257a.getResources().getDrawable(cVar.a());
            } else {
                drawable = cVar.b();
            }
            imageView.setImageDrawable(drawable);
        }
        textView.setLayoutParams(layoutParams);
    }

    private void a(TextView textView, c cVar, boolean z) {
        textView.setEnabled(z);
        textView.setText(cVar.c());
        textView.setTextColor(this.j);
        textView.setTextSize(0, com.color.support.d.b.a(this.k, this.l, 5));
    }

    private void a(LinearLayout linearLayout, CheckBox checkBox, c cVar, boolean z) {
        if (cVar.e()) {
            int minimumWidth = linearLayout.getMinimumWidth();
            int i2 = this.f;
            if (minimumWidth != i2) {
                linearLayout.setMinimumWidth(i2);
            }
            checkBox.setVisibility(0);
            checkBox.setChecked(cVar.f());
            checkBox.setEnabled(z);
            return;
        }
        if (linearLayout.getMinimumWidth() == this.f) {
            linearLayout.setMinimumWidth(0);
        }
        checkBox.setVisibility(8);
    }

    private void a(c cVar, ColorHintRedDot colorHintRedDot) {
        colorHintRedDot.setPointNumber(cVar.g());
        int g2 = cVar.g();
        if (g2 == -1) {
            colorHintRedDot.setPointMode(0);
        } else if (g2 != 0) {
            colorHintRedDot.setPointMode(2);
            colorHintRedDot.setVisibility(0);
        } else {
            colorHintRedDot.setPointMode(1);
            colorHintRedDot.setVisibility(0);
        }
    }

    /* compiled from: DefaultAdapter */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        ImageView f2260a;

        /* renamed from: b  reason: collision with root package name */
        TextView f2261b;
        CheckBox c;
        ColorHintRedDot d;
        LinearLayout e;

        a() {
        }
    }
}
