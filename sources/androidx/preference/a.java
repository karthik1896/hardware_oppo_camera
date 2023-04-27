package androidx.preference;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/* compiled from: EditTextPreferenceDialogFragmentCompat */
public class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private EditText f996a;

    /* renamed from: b  reason: collision with root package name */
    private CharSequence f997b;

    /* access modifiers changed from: protected */
    public boolean a() {
        return true;
    }

    public static a a(String str) {
        a aVar = new a();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f997b = c().h();
        } else {
            this.f997b = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.f997b);
    }

    /* access modifiers changed from: protected */
    public void a(View view) {
        super.a(view);
        this.f996a = (EditText) view.findViewById(16908291);
        EditText editText = this.f996a;
        if (editText != null) {
            editText.requestFocus();
            this.f996a.setText(this.f997b);
            EditText editText2 = this.f996a;
            editText2.setSelection(editText2.getText().length());
            if (c().l() != null) {
                c().l().a(this.f996a);
                return;
            }
            return;
        }
        throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
    }

    private EditTextPreference c() {
        return (EditTextPreference) b();
    }

    public void a(boolean z) {
        if (z) {
            String obj = this.f996a.getText().toString();
            EditTextPreference c = c();
            if (c.b((Object) obj)) {
                c.a(obj);
            }
        }
    }
}
