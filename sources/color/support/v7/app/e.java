package color.support.v7.app;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import color.support.v7.appcompat.R;

/* compiled from: SummaryAdapter */
public class e extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private static final int f1493a = R.layout.color_alert_dialog_summary_item;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1494b;
    private boolean c;
    private Context d;
    private CharSequence[] e;
    private CharSequence[] f;

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return true;
    }

    public e(Context context, boolean z, boolean z2, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2) {
        this.f1494b = z;
        this.c = z2;
        this.d = context;
        this.e = charSequenceArr;
        this.f = charSequenceArr2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.d).inflate(f1493a, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.summary_text2);
        CharSequence a2 = getItem(i);
        CharSequence b2 = b(i);
        ((TextView) inflate.findViewById(16908308)).setText(a2);
        if (TextUtils.isEmpty(b2)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(b2);
        }
        a(i, inflate);
        return inflate;
    }

    private void a(int i, View view) {
        int dimensionPixelSize = this.d.getResources().getDimensionPixelSize(R.dimen.alert_dialog_item_padding_offset);
        int paddingTop = view.getPaddingTop();
        int paddingLeft = view.getPaddingLeft();
        int paddingBottom = view.getPaddingBottom();
        int paddingRight = view.getPaddingRight();
        if (getCount() > 1) {
            if (i == getCount() - 1) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom + dimensionPixelSize);
                view.setMinimumHeight(view.getMinimumHeight() + dimensionPixelSize);
            } else if (!this.f1494b && !this.c) {
                if (i == 0) {
                    view.setPadding(paddingLeft, paddingTop + dimensionPixelSize, paddingRight, paddingBottom);
                    view.setMinimumHeight(view.getMinimumHeight() + dimensionPixelSize);
                    return;
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
        } else if (getCount() != 1) {
        } else {
            if (this.f1494b || this.c) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom + dimensionPixelSize);
                view.setMinimumHeight(view.getMinimumHeight() + dimensionPixelSize);
                return;
            }
            view.setPadding(paddingLeft, paddingTop + dimensionPixelSize, paddingRight, paddingBottom + dimensionPixelSize);
            view.setMinimumHeight(view.getMinimumHeight() + (dimensionPixelSize * 2));
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

    public CharSequence b(int i) {
        CharSequence[] charSequenceArr = this.f;
        if (charSequenceArr != null && i < charSequenceArr.length) {
            return charSequenceArr[i];
        }
        return null;
    }
}
