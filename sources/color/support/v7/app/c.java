package color.support.v7.app;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import color.support.v7.appcompat.R;
import com.color.support.widget.OppoCheckBox;
import java.util.HashSet;

/* compiled from: ChoiceListAdapter */
class c extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f1489a;

    /* renamed from: b  reason: collision with root package name */
    private CharSequence[] f1490b;
    private CharSequence[] c;
    private int d;
    private boolean e;
    private HashSet<Integer> f;

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return i;
    }

    public c(Context context, int i, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, boolean[] zArr, boolean z) {
        this.e = false;
        this.f1489a = context;
        this.d = i;
        this.f1490b = charSequenceArr;
        this.c = charSequenceArr2;
        this.e = z;
        this.f = new HashSet<>();
        if (zArr != null) {
            a(zArr);
        }
    }

    public c(Context context, int i, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2) {
        this(context, i, charSequenceArr, charSequenceArr2, (boolean[]) null, false);
    }

    public CharSequence a(int i) {
        CharSequence[] charSequenceArr = this.c;
        if (charSequenceArr != null && i < charSequenceArr.length) {
            return charSequenceArr[i];
        }
        return null;
    }

    private void a(boolean[] zArr) {
        for (int i = 0; i < zArr.length; i++) {
            if (zArr[i]) {
                this.f.add(Integer.valueOf(i));
            }
        }
    }

    public int getCount() {
        CharSequence[] charSequenceArr = this.f1490b;
        if (charSequenceArr == null) {
            return 0;
        }
        return charSequenceArr.length;
    }

    /* renamed from: b */
    public CharSequence getItem(int i) {
        CharSequence[] charSequenceArr = this.f1490b;
        if (charSequenceArr == null) {
            return null;
        }
        return charSequenceArr[i];
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (view == null) {
            aVar = new a();
            view2 = LayoutInflater.from(this.f1489a).inflate(this.d, viewGroup, false);
            aVar.f1492b = (TextView) view2.findViewById(16908308);
            aVar.f1491a = (TextView) view2.findViewById(R.id.summary_text2);
            if (this.e) {
                aVar.c = (OppoCheckBox) view2.findViewById(R.id.checkbox);
            } else {
                aVar.d = (RadioButton) view2.findViewById(R.id.radio_button);
            }
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        if (this.e) {
            aVar.c.setState(this.f.contains(Integer.valueOf(i)) ? 2 : 0);
        }
        CharSequence b2 = getItem(i);
        CharSequence a2 = a(i);
        aVar.f1492b.setText(b2);
        if (TextUtils.isEmpty(a2)) {
            aVar.f1491a.setVisibility(8);
        } else {
            aVar.f1491a.setVisibility(0);
            aVar.f1491a.setText(a2);
        }
        return view2;
    }

    /* access modifiers changed from: package-private */
    public void a(int i, int i2, ListView listView) {
        int firstVisiblePosition = i2 - listView.getFirstVisiblePosition();
        if (firstVisiblePosition >= 0) {
            ((a) listView.getChildAt(firstVisiblePosition).getTag()).c.setState(i);
            if (i == 2) {
                this.f.add(Integer.valueOf(i2));
            } else {
                this.f.remove(Integer.valueOf(i2));
            }
        }
    }

    /* compiled from: ChoiceListAdapter */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        TextView f1491a;

        /* renamed from: b  reason: collision with root package name */
        TextView f1492b;
        OppoCheckBox c;
        RadioButton d;

        a() {
        }
    }
}
