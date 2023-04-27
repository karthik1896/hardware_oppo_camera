package com.oppo.camera.ui.menu.levelcontrol;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.oppo.camera.R;

/* compiled from: CameraCustomListPreferenceSummaryAdapter */
public class b extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4131a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4132b;
    private Context c;
    private int d;
    private CharSequence[] e;
    private CharSequence[] f;

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return true;
    }

    public b(Context context, boolean z, boolean z2, int i, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2) {
        this.f4131a = z;
        this.f4132b = z2;
        this.c = context;
        this.d = i;
        this.e = charSequenceArr;
        this.f = charSequenceArr2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        boolean z = false;
        if (view == null) {
            aVar = new a();
            view2 = LayoutInflater.from(this.c).inflate(R.layout.oppo_preference_select_layout, viewGroup, false);
            aVar.f4133a = (TextView) view2.findViewById(R.id.pref_title);
            aVar.f4134b = (TextView) view2.findViewById(R.id.pref_summary);
            aVar.c = (CheckBox) view2.findViewById(R.id.pref_checkbox);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        CharSequence a2 = getItem(i);
        CharSequence b2 = b(i);
        aVar.f4133a.setText(a2);
        if (TextUtils.isEmpty(b2)) {
            aVar.f4134b.setVisibility(8);
        } else {
            aVar.f4134b.setVisibility(0);
            aVar.f4134b.setText(b2);
        }
        CheckBox checkBox = aVar.c;
        if (this.d == i) {
            z = true;
        }
        checkBox.setChecked(z);
        a(i, view2);
        return view2;
    }

    private void a(int i, View view) {
        int dimensionPixelSize = this.c.getResources().getDimensionPixelSize(R.dimen.alert_dialog_item_padding_offset);
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        if (getCount() > 1) {
            if (i == getCount() - 1) {
                view.setMinimumHeight(view.getMinimumHeight() + dimensionPixelSize);
                view.setPadding(paddingLeft, 0, paddingRight, dimensionPixelSize + 0);
            }
            if (!this.f4131a && !this.f4132b && i == 0) {
                view.setMinimumHeight(view.getMinimumHeight() + dimensionPixelSize);
                view.setPadding(paddingLeft, dimensionPixelSize + 0, paddingRight, 0);
            }
        }
    }

    public int getCount() {
        CharSequence[] charSequenceArr = this.e;
        if (charSequenceArr == null) {
            return 0;
        }
        return charSequenceArr.length;
    }

    /* renamed from: a */
    public CharSequence getItem(int i) {
        CharSequence[] charSequenceArr = this.e;
        if (charSequenceArr == null) {
            return null;
        }
        return charSequenceArr[i];
    }

    private CharSequence b(int i) {
        CharSequence[] charSequenceArr = this.f;
        if (charSequenceArr != null && i < charSequenceArr.length) {
            return charSequenceArr[i];
        }
        return null;
    }

    /* compiled from: CameraCustomListPreferenceSummaryAdapter */
    private final class a {

        /* renamed from: a  reason: collision with root package name */
        TextView f4133a;

        /* renamed from: b  reason: collision with root package name */
        TextView f4134b;
        CheckBox c;

        private a() {
        }
    }
}
