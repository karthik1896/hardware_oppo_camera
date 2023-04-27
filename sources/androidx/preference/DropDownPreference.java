package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DropDownPreference extends ListPreference {

    /* renamed from: a  reason: collision with root package name */
    private final Context f966a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayAdapter f967b;
    private Spinner c;
    private final AdapterView.OnItemSelectedListener d;

    public DropDownPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.dropdownPreferenceStyle);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DropDownPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.d = new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= 0) {
                    String charSequence = DropDownPreference.this.m()[i].toString();
                    if (!charSequence.equals(DropDownPreference.this.o()) && DropDownPreference.this.b((Object) charSequence)) {
                        DropDownPreference.this.a(charSequence);
                    }
                }
            }
        };
        this.f966a = context;
        this.f967b = h();
        T();
    }

    /* access modifiers changed from: protected */
    public void g() {
        this.c.performClick();
    }

    public void a(CharSequence[] charSequenceArr) {
        super.a(charSequenceArr);
        T();
    }

    /* access modifiers changed from: protected */
    public ArrayAdapter h() {
        return new ArrayAdapter(this.f966a, 17367049);
    }

    private void T() {
        this.f967b.clear();
        if (l() != null) {
            for (CharSequence charSequence : l()) {
                this.f967b.add(charSequence.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void i() {
        super.i();
        ArrayAdapter arrayAdapter = this.f967b;
        if (arrayAdapter != null) {
            arrayAdapter.notifyDataSetChanged();
        }
    }

    public void a(l lVar) {
        this.c = (Spinner) lVar.itemView.findViewById(R.id.spinner);
        this.c.setAdapter(this.f967b);
        this.c.setOnItemSelectedListener(this.d);
        this.c.setSelection(f(o()));
        super.a(lVar);
    }

    private int f(String str) {
        CharSequence[] m = m();
        if (str == null || m == null) {
            return -1;
        }
        for (int length = m.length - 1; length >= 0; length--) {
            if (m[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }
}
