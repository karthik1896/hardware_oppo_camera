package com.color.support.preference;

import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.b;
import com.color.support.dialog.panel.c;

/* compiled from: ColorMultiSelectListPreferenceDialogFragment */
public class d extends androidx.preference.d {
    private CharSequence[] e;
    private CharSequence f;

    public static d b(String str) {
        d dVar = new d();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        dVar.setArguments(bundle);
        return dVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ColorMultiSelectListPreference colorMultiSelectListPreference = (ColorMultiSelectListPreference) b();
        this.f = colorMultiSelectListPreference.a();
        this.e = colorMultiSelectListPreference.p();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        final c.a a2 = new c.a(getActivity()).setTitle(this.f).a(this.e);
        a((b.a) a2);
        final c b2 = a2.b();
        a2.a((c.b) new c.b() {
            public void a() {
                d.this.onClick(a2.a(), -1);
                b2.a();
            }

            public void b() {
                d.this.onClick(a2.a(), -2);
                b2.a();
            }
        });
        return a2.a();
    }
}
