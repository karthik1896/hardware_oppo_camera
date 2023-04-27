package com.color.support.dialog.panel;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import color.support.v7.appcompat.R;
import com.color.support.widget.OppoCheckBox;
import java.util.HashSet;

/* compiled from: ColorBottomSheetChoiceListAdapter */
class a extends RecyclerView.a<b> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f1902a;

    /* renamed from: b  reason: collision with root package name */
    private CharSequence[] f1903b;
    private CharSequence[] c;
    private int d;
    /* access modifiers changed from: private */
    public boolean e;
    /* access modifiers changed from: private */
    public HashSet<Integer> f;
    /* access modifiers changed from: private */
    public C0055a g;
    /* access modifiers changed from: private */
    public int h;

    /* renamed from: com.color.support.dialog.panel.a$a  reason: collision with other inner class name */
    /* compiled from: ColorBottomSheetChoiceListAdapter */
    public interface C0055a {
        void a(View view, int i, int i2);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public a(Context context, int i, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, int i2, boolean[] zArr, boolean z) {
        this.h = -1;
        this.f1902a = context;
        this.d = i;
        this.f1903b = charSequenceArr;
        this.c = charSequenceArr2;
        this.e = z;
        this.f = new HashSet<>();
        this.h = i2;
        if (zArr != null) {
            a(zArr);
        }
    }

    public a(Context context, int i, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, int i2) {
        this(context, i, charSequenceArr, charSequenceArr2, i2, (boolean[]) null, false);
    }

    public CharSequence a(int i) {
        CharSequence[] charSequenceArr = this.c;
        if (charSequenceArr == null || i >= charSequenceArr.length) {
            return null;
        }
        return charSequenceArr[i];
    }

    public CharSequence b(int i) {
        CharSequence[] charSequenceArr = this.f1903b;
        if (charSequenceArr == null || i >= charSequenceArr.length) {
            return null;
        }
        return charSequenceArr[i];
    }

    public void a(C0055a aVar) {
        this.g = aVar;
    }

    private void a(boolean[] zArr) {
        for (int i = 0; i < zArr.length; i++) {
            if (zArr[i]) {
                this.f.add(Integer.valueOf(i));
            }
        }
    }

    public int getItemCount() {
        CharSequence[] charSequenceArr = this.f1903b;
        if (charSequenceArr == null) {
            return 0;
        }
        return charSequenceArr.length;
    }

    /* renamed from: a */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(this.f1902a).inflate(this.d, viewGroup, false));
    }

    /* renamed from: a */
    public void onBindViewHolder(final b bVar, final int i) {
        if (this.e) {
            bVar.c.setState(this.f.contains(Integer.valueOf(i)) ? 2 : 0);
        } else {
            bVar.d.setChecked(this.h == i);
        }
        CharSequence b2 = b(i);
        CharSequence a2 = a(i);
        bVar.f1907b.setText(b2);
        if (TextUtils.isEmpty(a2)) {
            bVar.f1906a.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.f1907b.getLayoutParams();
            layoutParams.addRule(15);
            bVar.f1907b.setLayoutParams(layoutParams);
        } else {
            bVar.f1906a.setVisibility(0);
            bVar.f1906a.setText(a2);
        }
        if (this.g != null) {
            bVar.e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    boolean z = false;
                    if (a.this.e) {
                        if (bVar.c.getState() != 2) {
                            a.this.f.add(Integer.valueOf(i));
                        } else {
                            a.this.f.remove(Integer.valueOf(i));
                        }
                        if (a.this.f.contains(Integer.valueOf(i))) {
                            z = true;
                        }
                        bVar.c.setState(z ? 1 : 0);
                    } else if (i == a.this.h) {
                        a.this.g.a(view, i, 0);
                        return;
                    } else {
                        boolean isChecked = bVar.d.isChecked();
                        z = !isChecked;
                        bVar.d.setChecked(!isChecked);
                        a aVar = a.this;
                        aVar.notifyItemChanged(aVar.h);
                        int unused = a.this.h = i;
                    }
                    a.this.g.a(view, i, z ? 1 : 0);
                }
            });
        }
    }

    /* compiled from: ColorBottomSheetChoiceListAdapter */
    class b extends RecyclerView.w {

        /* renamed from: a  reason: collision with root package name */
        TextView f1906a;

        /* renamed from: b  reason: collision with root package name */
        TextView f1907b;
        OppoCheckBox c;
        RadioButton d;
        View e;

        public b(View view) {
            super(view);
            this.f1907b = (TextView) view.findViewById(16908308);
            this.f1906a = (TextView) view.findViewById(R.id.summary_text2);
            if (a.this.e) {
                this.c = (OppoCheckBox) view.findViewById(R.id.checkbox);
            } else {
                this.d = (RadioButton) view.findViewById(R.id.radio_button);
            }
            view.setBackground(a.this.f1902a.getDrawable(R.drawable.oppo_list_selector_background));
            this.e = view;
        }
    }
}
