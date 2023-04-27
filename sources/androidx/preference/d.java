package androidx.preference;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: MultiSelectListPreferenceDialogFragmentCompat */
public class d extends f {

    /* renamed from: a  reason: collision with root package name */
    Set<String> f1002a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    boolean f1003b;
    CharSequence[] c;
    CharSequence[] d;

    public static d a(String str) {
        d dVar = new d();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        dVar.setArguments(bundle);
        return dVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            MultiSelectListPreference c2 = c();
            if (c2.h() == null || c2.l() == null) {
                throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
            }
            this.f1002a.clear();
            this.f1002a.addAll(c2.m());
            this.f1003b = false;
            this.c = c2.h();
            this.d = c2.l();
            return;
        }
        this.f1002a.clear();
        this.f1002a.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
        this.f1003b = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
        this.c = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
        this.d = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList(this.f1002a));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.f1003b);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.c);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.d);
    }

    private MultiSelectListPreference c() {
        return (MultiSelectListPreference) b();
    }

    /* access modifiers changed from: protected */
    public void a(b.a aVar) {
        super.a(aVar);
        int length = this.d.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = this.f1002a.contains(this.d[i].toString());
        }
        aVar.setMultiChoiceItems(this.c, zArr, (DialogInterface.OnMultiChoiceClickListener) new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialogInterface, int i, boolean z) {
                if (z) {
                    d dVar = d.this;
                    dVar.f1003b = d.this.f1002a.add(d.this.d[i].toString()) | dVar.f1003b;
                    return;
                }
                d dVar2 = d.this;
                dVar2.f1003b = d.this.f1002a.remove(d.this.d[i].toString()) | dVar2.f1003b;
            }
        });
    }

    public void a(boolean z) {
        if (z && this.f1003b) {
            MultiSelectListPreference c2 = c();
            if (c2.b((Object) this.f1002a)) {
                c2.a(this.f1002a);
            }
        }
        this.f1003b = false;
    }
}
