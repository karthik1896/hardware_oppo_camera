package color.support.v7.app;

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
import androidx.appcompat.app.b;
import color.support.v7.app.ColorAlertController;
import color.support.v7.appcompat.R;

/* compiled from: AlertDialog */
public class b extends androidx.appcompat.app.b implements DialogInterface {

    /* renamed from: b  reason: collision with root package name */
    final a f1486b;

    protected b(Context context) {
        this(context, 0);
    }

    protected b(Context context, int i) {
        super(context, b(context, i));
        this.f1486b = new ColorAlertController(getContext(), this, getWindow());
    }

    static int b(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorAlertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView a() {
        return this.f1486b.c();
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1486b.a(charSequence);
    }

    public void a(CharSequence charSequence) {
        this.f1486b.b(charSequence);
    }

    public void a(View view) {
        this.f1486b.c(view);
    }

    public void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.f1486b.a(i, charSequence, onClickListener, (Message) null, (Drawable) null);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.f1486b.a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f1486b.a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f1486b.b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* compiled from: AlertDialog */
    public static class a extends b.a {

        /* renamed from: a  reason: collision with root package name */
        private final ColorAlertController.b f1487a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1488b;

        public a(Context context) {
            this(context, b.b(context, 0));
        }

        public a(Context context, int i) {
            super(context, i);
            this.f1487a = new ColorAlertController.b(new ContextThemeWrapper(context, b.b(context, i)));
            this.f1488b = i;
        }

        public Context getContext() {
            return this.f1487a.f1471a;
        }

        /* renamed from: a */
        public a setTitle(int i) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.f = bVar.f1471a.getText(i);
            return this;
        }

        /* renamed from: a */
        public a setTitle(CharSequence charSequence) {
            this.f1487a.f = charSequence;
            return this;
        }

        /* renamed from: a */
        public a setCustomTitle(View view) {
            this.f1487a.g = view;
            return this;
        }

        /* renamed from: b */
        public a setMessage(int i) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.h = bVar.f1471a.getText(i);
            return this;
        }

        /* renamed from: b */
        public a setMessage(CharSequence charSequence) {
            this.f1487a.h = charSequence;
            return this;
        }

        /* renamed from: c */
        public a setIcon(int i) {
            this.f1487a.c = i;
            return this;
        }

        /* renamed from: a */
        public a setIcon(Drawable drawable) {
            this.f1487a.d = drawable;
            return this;
        }

        /* renamed from: d */
        public a setIconAttribute(int i) {
            TypedValue typedValue = new TypedValue();
            this.f1487a.f1471a.getTheme().resolveAttribute(i, typedValue, true);
            this.f1487a.c = typedValue.resourceId;
            return this;
        }

        /* renamed from: a */
        public a setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.i = bVar.f1471a.getText(i);
            this.f1487a.k = onClickListener;
            return this;
        }

        /* renamed from: a */
        public a setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.i = charSequence;
            bVar.k = onClickListener;
            return this;
        }

        /* renamed from: b */
        public a setPositiveButtonIcon(Drawable drawable) {
            this.f1487a.j = drawable;
            return this;
        }

        /* renamed from: b */
        public a setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.l = bVar.f1471a.getText(i);
            this.f1487a.n = onClickListener;
            return this;
        }

        /* renamed from: b */
        public a setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.l = charSequence;
            bVar.n = onClickListener;
            return this;
        }

        /* renamed from: c */
        public a setNegativeButtonIcon(Drawable drawable) {
            this.f1487a.m = drawable;
            return this;
        }

        /* renamed from: c */
        public a setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.o = bVar.f1471a.getText(i);
            this.f1487a.q = onClickListener;
            return this;
        }

        /* renamed from: c */
        public a setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.o = charSequence;
            bVar.q = onClickListener;
            return this;
        }

        /* renamed from: d */
        public a setNeutralButtonIcon(Drawable drawable) {
            this.f1487a.p = drawable;
            return this;
        }

        /* renamed from: a */
        public a setCancelable(boolean z) {
            this.f1487a.r = z;
            return this;
        }

        /* renamed from: a */
        public a setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.f1487a.t = onCancelListener;
            return this;
        }

        /* renamed from: a */
        public a setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.f1487a.u = onDismissListener;
            return this;
        }

        /* renamed from: a */
        public a setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.f1487a.v = onKeyListener;
            return this;
        }

        /* renamed from: d */
        public a setItems(int i, DialogInterface.OnClickListener onClickListener) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.w = bVar.f1471a.getResources().getTextArray(i);
            this.f1487a.A = onClickListener;
            return this;
        }

        /* renamed from: a */
        public a setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.w = charSequenceArr;
            bVar.A = onClickListener;
            return this;
        }

        /* renamed from: a */
        public a setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.z = listAdapter;
            bVar.A = onClickListener;
            return this;
        }

        /* renamed from: a */
        public a setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.N = cursor;
            bVar.O = str;
            bVar.A = onClickListener;
            return this;
        }

        /* renamed from: a */
        public a setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.w = bVar.f1471a.getResources().getTextArray(i);
            ColorAlertController.b bVar2 = this.f1487a;
            bVar2.M = onMultiChoiceClickListener;
            bVar2.I = zArr;
            bVar2.J = true;
            return this;
        }

        /* renamed from: a */
        public a setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.w = charSequenceArr;
            bVar.M = onMultiChoiceClickListener;
            bVar.I = zArr;
            bVar.J = true;
            return this;
        }

        /* renamed from: a */
        public a setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.N = cursor;
            bVar.M = onMultiChoiceClickListener;
            bVar.P = str;
            bVar.O = str2;
            bVar.J = true;
            return this;
        }

        /* renamed from: a */
        public a setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.w = bVar.f1471a.getResources().getTextArray(i);
            ColorAlertController.b bVar2 = this.f1487a;
            bVar2.A = onClickListener;
            bVar2.L = i2;
            bVar2.K = true;
            return this;
        }

        /* renamed from: a */
        public a setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.N = cursor;
            bVar.A = onClickListener;
            bVar.L = i;
            bVar.O = str;
            bVar.K = true;
            return this;
        }

        /* renamed from: a */
        public a setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.w = charSequenceArr;
            bVar.A = onClickListener;
            bVar.L = i;
            bVar.K = true;
            return this;
        }

        /* renamed from: a */
        public a setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.z = listAdapter;
            bVar.A = onClickListener;
            bVar.L = i;
            bVar.K = true;
            return this;
        }

        /* renamed from: a */
        public a setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.f1487a.R = onItemSelectedListener;
            return this;
        }

        /* renamed from: e */
        public a setView(int i) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.C = null;
            bVar.B = i;
            bVar.H = false;
            return this;
        }

        /* renamed from: b */
        public a setView(View view) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.C = view;
            bVar.B = 0;
            bVar.H = false;
            return this;
        }

        @Deprecated
        /* renamed from: a */
        public a setView(View view, int i, int i2, int i3, int i4) {
            ColorAlertController.b bVar = this.f1487a;
            bVar.C = view;
            bVar.B = 0;
            bVar.H = true;
            bVar.D = i;
            bVar.E = i2;
            bVar.F = i3;
            bVar.G = i4;
            return this;
        }

        @Deprecated
        /* renamed from: b */
        public a setInverseBackgroundForced(boolean z) {
            this.f1487a.Q = z;
            return this;
        }

        /* renamed from: c */
        public a setRecycleOnMeasureEnabled(boolean z) {
            this.f1487a.T = z;
            return this;
        }

        public a f(int i) {
            this.f1487a.U = i;
            return this;
        }

        /* renamed from: a */
        public b create() {
            b bVar = new b(this.f1487a.f1471a, this.f1488b);
            this.f1487a.a(bVar.f1486b);
            bVar.setCancelable(this.f1487a.r);
            if (this.f1487a.r) {
                bVar.setCanceledOnTouchOutside(true);
            }
            bVar.setOnCancelListener(this.f1487a.t);
            bVar.setOnDismissListener(this.f1487a.u);
            if (this.f1487a.v != null) {
                bVar.setOnKeyListener(this.f1487a.v);
            }
            return bVar;
        }

        /* renamed from: b */
        public b show() {
            b a2 = create();
            a2.show();
            return a2;
        }
    }
}
