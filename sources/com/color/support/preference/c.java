package com.color.support.preference;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.b;
import com.color.support.dialog.panel.c;

/* compiled from: ColorListPreferenceDialogFragment */
public class c extends androidx.preference.c {

    /* renamed from: b  reason: collision with root package name */
    private ColorListPreference f1999b;
    private CharSequence c;
    private CharSequence d;
    private CharSequence e;
    private CharSequence f;
    private BitmapDrawable g;
    private CharSequence[] h;

    public static c b(String str) {
        c cVar = new c();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        cVar.setArguments(bundle);
        return cVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f1999b = (ColorListPreference) b();
            this.c = this.f1999b.a();
            this.d = this.f1999b.d();
            this.e = this.f1999b.e();
            this.f = this.f1999b.b();
            this.h = this.f1999b.T();
            Drawable c2 = this.f1999b.c();
            if (c2 == null || (c2 instanceof BitmapDrawable)) {
                this.g = (BitmapDrawable) c2;
                return;
            }
            Bitmap createBitmap = Bitmap.createBitmap(c2.getIntrinsicWidth(), c2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            c2.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            c2.draw(canvas);
            this.g = new BitmapDrawable(getResources(), createBitmap);
            return;
        }
        this.c = bundle.getCharSequence("PreferenceDialogFragment.title");
        this.d = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
        this.e = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
        this.f = bundle.getCharSequence("PreferenceDialogFragment.message");
        this.h = bundle.getCharSequenceArray("PreferenceDialogFragment.summaries");
        Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
        if (bitmap != null) {
            this.g = new BitmapDrawable(getResources(), bitmap);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        c.a a2 = new c.a(getActivity()).setTitle(this.c).a(this.h);
        a((b.a) a2);
        a2.b();
        return a2.a();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        CharSequence[] charSequenceArr = this.h;
        if (charSequenceArr != null) {
            bundle.putCharSequenceArray("PreferenceDialogFragment.summaries", charSequenceArr);
        }
    }
}
