package com.color.support.dialog.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/* compiled from: ColorSpinnerDialog */
public class b extends color.support.v7.app.b {
    protected View c;
    protected TextView d;
    protected int e;
    protected int f;
    protected CharSequence g;
    protected boolean h;

    public void a(int i) {
    }

    public void b(int i) {
    }

    public b(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        int i = this.e;
        if (i > 0) {
            b(i);
        }
        int i2 = this.f;
        if (i2 > 0) {
            a(i2);
        }
        CharSequence charSequence = this.g;
        if (charSequence != null) {
            a(charSequence);
        }
        super.onCreate(bundle);
    }

    public void onStart() {
        super.onStart();
        this.h = true;
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.h = false;
    }

    public void a(CharSequence charSequence) {
        if (this.c != null) {
            this.d.setText(charSequence);
        } else {
            this.g = charSequence;
        }
    }
}
