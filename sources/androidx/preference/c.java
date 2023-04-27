package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.b;

/* compiled from: ListPreferenceDialogFragmentCompat */
public class c extends f {

    /* renamed from: a  reason: collision with root package name */
    int f999a;

    /* renamed from: b  reason: collision with root package name */
    private CharSequence[] f1000b;
    private CharSequence[] c;

    public static c a(String str) {
        c cVar = new c();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        cVar.setArguments(bundle);
        return cVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            ListPreference c2 = c();
            if (c2.l() == null || c2.m() == null) {
                throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
            }
            this.f999a = c2.b(c2.o());
            this.f1000b = c2.l();
            this.c = c2.m();
            return;
        }
        this.f999a = bundle.getInt("ListPreferenceDialogFragment.index", 0);
        this.f1000b = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
        this.c = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.f999a);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.f1000b);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.c);
    }

    private ListPreference c() {
        return (ListPreference) b();
    }

    /* access modifiers changed from: protected */
    public void a(b.a aVar) {
        super.a(aVar);
        aVar.setSingleChoiceItems(this.f1000b, this.f999a, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                c cVar = c.this;
                cVar.f999a = i;
                cVar.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
            }
        });
        aVar.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
    }

    public void a(boolean z) {
        int i;
        if (z && (i = this.f999a) >= 0) {
            String charSequence = this.c[i].toString();
            ListPreference c2 = c();
            if (c2.b((Object) charSequence)) {
                c2.a(charSequence);
            }
        }
    }
}
