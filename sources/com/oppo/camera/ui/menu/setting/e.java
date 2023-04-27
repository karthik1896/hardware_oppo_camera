package com.oppo.camera.ui.menu.setting;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ListAdapter;
import androidx.appcompat.app.b;
import androidx.preference.f;
import color.support.v7.app.b;

/* compiled from: CameraCustomListPreferenceFragment */
public class e extends f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f4216a = 0;

    /* renamed from: b  reason: collision with root package name */
    private CharSequence[] f4217b = null;
    private CharSequence[] c = null;
    private CharSequence[] d = null;

    public static e a(String str) {
        e eVar = new e();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        eVar.setArguments(bundle);
        return eVar;
    }

    /* access modifiers changed from: protected */
    public void a(b.a aVar) {
        super.a(aVar);
        aVar.setSingleChoiceItems((ListAdapter) new com.oppo.camera.ui.menu.levelcontrol.b(getActivity(), true, true, this.f4216a, this.f4217b, this.d), this.f4216a, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                int unused = e.this.f4216a = i;
                e.this.onClick(dialogInterface, -1);
                dialogInterface.dismiss();
            }
        });
    }

    private CameraCustomListPreference c() {
        return (CameraCustomListPreference) b();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            CameraCustomListPreference c2 = c();
            if (c2.l() == null || c2.m() == null) {
                throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
            }
            this.f4216a = c2.b(c2.o());
            this.f4217b = c2.l();
            this.c = c2.m();
            this.d = c2.U();
            return;
        }
        this.f4216a = bundle.getInt("CameraCustomListPreferenceFragment.index", 0);
        this.f4217b = bundle.getCharSequenceArray("CameraCustomListPreferenceFragment.entries");
        this.c = bundle.getCharSequenceArray("CameraCustomListPreferenceFragment.entryValues");
        this.d = bundle.getCharSequenceArray("CameraCustomListPreferenceFragment.entrySummary");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("CameraCustomListPreferenceFragment.index", this.f4216a);
        bundle.putCharSequenceArray("CameraCustomListPreferenceFragment.entries", this.f4217b);
        bundle.putCharSequenceArray("CameraCustomListPreferenceFragment.entryValues", this.c);
        bundle.putCharSequenceArray("CameraCustomListPreferenceFragment.entrySummary", this.d);
    }

    public void a(boolean z) {
        int i;
        if (z && (i = this.f4216a) >= 0) {
            String charSequence = this.c[i].toString();
            CameraCustomListPreference c2 = c();
            if (c2.b((Object) charSequence)) {
                c2.a(charSequence);
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        b.a b2 = new b.a(getActivity()).f(1).setTitle(b().a()).setIcon(b().c()).setMessage(b().b());
        a((b.a) b2);
        return b2.create();
    }
}
