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

/* compiled from: VideoSoundSettingSummaryAdapter */
public class l extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4155a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4156b;
    private Context c;
    private int d;
    private boolean e;
    private CharSequence[] f;
    private CharSequence[] g;

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return true;
    }

    public l(Context context, boolean z, boolean z2, int i, boolean z3, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2) {
        this.f4155a = z;
        this.f4156b = z2;
        this.c = context;
        this.d = i;
        this.e = z3;
        this.f = charSequenceArr;
        this.g = charSequenceArr2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        boolean z = false;
        if (view == null) {
            aVar = new a();
            view2 = LayoutInflater.from(this.c).inflate(R.layout.oppo_preference_select_layout, viewGroup, false);
            aVar.f4157a = (TextView) view2.findViewById(R.id.pref_title);
            aVar.f4158b = (TextView) view2.findViewById(R.id.pref_summary);
            aVar.c = (CheckBox) view2.findViewById(R.id.pref_checkbox);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        CharSequence b2 = getItem(i);
        CharSequence c2 = c(i);
        aVar.f4157a.setText(b2);
        if (TextUtils.isEmpty(c2)) {
            aVar.f4158b.setVisibility(8);
        } else {
            aVar.f4158b.setVisibility(0);
            aVar.f4158b.setText(c2);
        }
        CheckBox checkBox = aVar.c;
        if (this.d == i) {
            z = true;
        }
        checkBox.setChecked(z);
        if (isEnabled(i)) {
            aVar.f4157a.setTextColor(this.c.getResources().getColor(R.color.setting_pref_title_color));
            aVar.f4158b.setTextColor(this.c.getResources().getColor(R.color.setting_pref_summary_color));
        } else {
            aVar.f4157a.setTextColor(this.c.getResources().getColor(R.color.setting_pref_text_disable_color));
            aVar.f4158b.setTextColor(this.c.getResources().getColor(R.color.setting_pref_text_disable_color));
        }
        return view2;
    }

    public void a(int i) {
        this.d = i;
        notifyDataSetChanged();
    }

    public boolean isEnabled(int i) {
        return !this.e || 2 != i;
    }

    public int getCount() {
        CharSequence[] charSequenceArr = this.f;
        if (charSequenceArr == null) {
            return 0;
        }
        return charSequenceArr.length;
    }

    /* renamed from: b */
    public CharSequence getItem(int i) {
        CharSequence[] charSequenceArr = this.f;
        if (charSequenceArr == null) {
            return null;
        }
        return charSequenceArr[i];
    }

    private CharSequence c(int i) {
        CharSequence[] charSequenceArr = this.g;
        if (charSequenceArr != null && i < charSequenceArr.length) {
            return charSequenceArr[i];
        }
        return null;
    }

    /* compiled from: VideoSoundSettingSummaryAdapter */
    private final class a {

        /* renamed from: a  reason: collision with root package name */
        TextView f4157a;

        /* renamed from: b  reason: collision with root package name */
        TextView f4158b;
        CheckBox c;

        private a() {
        }
    }
}
