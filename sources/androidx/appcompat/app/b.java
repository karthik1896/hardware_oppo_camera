package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;

/* compiled from: AlertDialog */
public class b extends f implements DialogInterface {

    /* renamed from: a  reason: collision with root package name */
    final AlertController f173a = new AlertController(getContext(), this, getWindow());

    protected b(Context context, int i) {
        super(context, a(context, i));
    }

    static int a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView a() {
        return this.f173a.b();
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f173a.a(charSequence);
    }

    public void a(CharSequence charSequence) {
        this.f173a.b(charSequence);
    }

    public void a(View view) {
        this.f173a.c(view);
    }

    public void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f173a.a(i, charSequence, onClickListener, (Message) null, (Drawable) null);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f173a.a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f173a.a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f173a.b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* compiled from: AlertDialog */
    public static class a {
        private final AlertController.a P;
        private final int mTheme;

        public a(Context context) {
            this(context, b.a(context, 0));
        }

        public a(Context context, int i) {
            this.P = new AlertController.a(new ContextThemeWrapper(context, b.a(context, i)));
            this.mTheme = i;
        }

        public Context getContext() {
            return this.P.f135a;
        }

        public a setTitle(int i) {
            AlertController.a aVar = this.P;
            aVar.f = aVar.f135a.getText(i);
            return this;
        }

        public a setTitle(CharSequence charSequence) {
            this.P.f = charSequence;
            return this;
        }

        public a setCustomTitle(View view) {
            this.P.g = view;
            return this;
        }

        public a setMessage(int i) {
            AlertController.a aVar = this.P;
            aVar.h = aVar.f135a.getText(i);
            return this;
        }

        public a setMessage(CharSequence charSequence) {
            this.P.h = charSequence;
            return this;
        }

        public a setIcon(int i) {
            this.P.c = i;
            return this;
        }

        public a setIcon(Drawable drawable) {
            this.P.d = drawable;
            return this;
        }

        public a setIconAttribute(int i) {
            TypedValue typedValue = new TypedValue();
            this.P.f135a.getTheme().resolveAttribute(i, typedValue, true);
            this.P.c = typedValue.resourceId;
            return this;
        }

        public a setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.P;
            aVar.i = aVar.f135a.getText(i);
            this.P.k = onClickListener;
            return this;
        }

        public a setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.P;
            aVar.i = charSequence;
            aVar.k = onClickListener;
            return this;
        }

        public a setPositiveButtonIcon(Drawable drawable) {
            this.P.j = drawable;
            return this;
        }

        public a setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.P;
            aVar.l = aVar.f135a.getText(i);
            this.P.n = onClickListener;
            return this;
        }

        public a setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.P;
            aVar.l = charSequence;
            aVar.n = onClickListener;
            return this;
        }

        public a setNegativeButtonIcon(Drawable drawable) {
            this.P.m = drawable;
            return this;
        }

        public a setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.P;
            aVar.o = aVar.f135a.getText(i);
            this.P.q = onClickListener;
            return this;
        }

        public a setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.P;
            aVar.o = charSequence;
            aVar.q = onClickListener;
            return this;
        }

        public a setNeutralButtonIcon(Drawable drawable) {
            this.P.p = drawable;
            return this;
        }

        public a setCancelable(boolean z) {
            this.P.r = z;
            return this;
        }

        public a setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.P.s = onCancelListener;
            return this;
        }

        public a setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.P.t = onDismissListener;
            return this;
        }

        public a setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.P.u = onKeyListener;
            return this;
        }

        public a setItems(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.P;
            aVar.v = aVar.f135a.getResources().getTextArray(i);
            this.P.x = onClickListener;
            return this;
        }

        public a setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.P;
            aVar.v = charSequenceArr;
            aVar.x = onClickListener;
            return this;
        }

        public a setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.P;
            aVar.w = listAdapter;
            aVar.x = onClickListener;
            return this;
        }

        public a setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            AlertController.a aVar = this.P;
            aVar.K = cursor;
            aVar.L = str;
            aVar.x = onClickListener;
            return this;
        }

        public a setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.a aVar = this.P;
            aVar.v = aVar.f135a.getResources().getTextArray(i);
            AlertController.a aVar2 = this.P;
            aVar2.J = onMultiChoiceClickListener;
            aVar2.F = zArr;
            aVar2.G = true;
            return this;
        }

        public a setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.a aVar = this.P;
            aVar.v = charSequenceArr;
            aVar.J = onMultiChoiceClickListener;
            aVar.F = zArr;
            aVar.G = true;
            return this;
        }

        public a setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.a aVar = this.P;
            aVar.K = cursor;
            aVar.J = onMultiChoiceClickListener;
            aVar.M = str;
            aVar.L = str2;
            aVar.G = true;
            return this;
        }

        public a setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.P;
            aVar.v = aVar.f135a.getResources().getTextArray(i);
            AlertController.a aVar2 = this.P;
            aVar2.x = onClickListener;
            aVar2.I = i2;
            aVar2.H = true;
            return this;
        }

        public a setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.P;
            aVar.K = cursor;
            aVar.x = onClickListener;
            aVar.I = i;
            aVar.L = str;
            aVar.H = true;
            return this;
        }

        public a setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.P;
            aVar.v = charSequenceArr;
            aVar.x = onClickListener;
            aVar.I = i;
            aVar.H = true;
            return this;
        }

        public a setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.P;
            aVar.w = listAdapter;
            aVar.x = onClickListener;
            aVar.I = i;
            aVar.H = true;
            return this;
        }

        public a setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.P.O = onItemSelectedListener;
            return this;
        }

        public a setView(int i) {
            AlertController.a aVar = this.P;
            aVar.z = null;
            aVar.y = i;
            aVar.E = false;
            return this;
        }

        public a setView(View view) {
            AlertController.a aVar = this.P;
            aVar.z = view;
            aVar.y = 0;
            aVar.E = false;
            return this;
        }

        @Deprecated
        public a setView(View view, int i, int i2, int i3, int i4) {
            AlertController.a aVar = this.P;
            aVar.z = view;
            aVar.y = 0;
            aVar.E = true;
            aVar.A = i;
            aVar.B = i2;
            aVar.C = i3;
            aVar.D = i4;
            return this;
        }

        @Deprecated
        public a setInverseBackgroundForced(boolean z) {
            this.P.N = z;
            return this;
        }

        public a setRecycleOnMeasureEnabled(boolean z) {
            this.P.Q = z;
            return this;
        }

        public b create() {
            b bVar = new b(this.P.f135a, this.mTheme);
            this.P.a(bVar.f173a);
            bVar.setCancelable(this.P.r);
            if (this.P.r) {
                bVar.setCanceledOnTouchOutside(true);
            }
            bVar.setOnCancelListener(this.P.s);
            bVar.setOnDismissListener(this.P.t);
            if (this.P.u != null) {
                bVar.setOnKeyListener(this.P.u);
            }
            return bVar;
        }

        public b show() {
            b create = create();
            create.show();
            return create;
        }
    }
}
