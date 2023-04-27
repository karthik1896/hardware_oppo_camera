package androidx.preference;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.b;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.b;
import androidx.fragment.app.c;
import androidx.preference.DialogPreference;

/* compiled from: PreferenceDialogFragmentCompat */
public abstract class f extends b implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private DialogPreference f1005a;

    /* renamed from: b  reason: collision with root package name */
    private CharSequence f1006b;
    private CharSequence c;
    private CharSequence d;
    private CharSequence e;
    private int f;
    private BitmapDrawable g;
    private int h;

    /* access modifiers changed from: protected */
    public void a(b.a aVar) {
    }

    public abstract void a(boolean z);

    /* access modifiers changed from: protected */
    public boolean a() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fragment targetFragment = getTargetFragment();
        if (targetFragment instanceof DialogPreference.a) {
            DialogPreference.a aVar = (DialogPreference.a) targetFragment;
            String string = getArguments().getString("key");
            if (bundle == null) {
                this.f1005a = (DialogPreference) aVar.a(string);
                this.f1006b = this.f1005a.a();
                this.c = this.f1005a.d();
                this.d = this.f1005a.e();
                this.e = this.f1005a.b();
                this.f = this.f1005a.f();
                Drawable c2 = this.f1005a.c();
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
            this.f1006b = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.c = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.d = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.e = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.f = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.g = new BitmapDrawable(getResources(), bitmap);
                return;
            }
            return;
        }
        throw new IllegalStateException("Target fragment must implement TargetFragment interface");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.f1006b);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.c);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.d);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.e);
        bundle.putInt("PreferenceDialogFragment.layout", this.f);
        BitmapDrawable bitmapDrawable = this.g;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        c activity = getActivity();
        this.h = -2;
        b.a negativeButton = new b.a(activity).setTitle(this.f1006b).setIcon((Drawable) this.g).setPositiveButton(this.c, (DialogInterface.OnClickListener) this).setNegativeButton(this.d, (DialogInterface.OnClickListener) this);
        View a2 = a((Context) activity);
        if (a2 != null) {
            a(a2);
            negativeButton.setView(a2);
        } else {
            negativeButton.setMessage(this.e);
        }
        a(negativeButton);
        androidx.appcompat.app.b create = negativeButton.create();
        if (a()) {
            a((Dialog) create);
        }
        return create;
    }

    public DialogPreference b() {
        if (this.f1005a == null) {
            this.f1005a = (DialogPreference) ((DialogPreference.a) getTargetFragment()).a(getArguments().getString("key"));
        }
        return this.f1005a;
    }

    private void a(Dialog dialog) {
        dialog.getWindow().setSoftInputMode(5);
    }

    /* access modifiers changed from: protected */
    public View a(Context context) {
        int i = this.f;
        if (i == 0) {
            return null;
        }
        return LayoutInflater.from(context).inflate(i, (ViewGroup) null);
    }

    /* access modifiers changed from: protected */
    public void a(View view) {
        View findViewById = view.findViewById(16908299);
        if (findViewById != null) {
            CharSequence charSequence = this.e;
            int i = 8;
            if (!TextUtils.isEmpty(charSequence)) {
                if (findViewById instanceof TextView) {
                    ((TextView) findViewById).setText(charSequence);
                }
                i = 0;
            }
            if (findViewById.getVisibility() != i) {
                findViewById.setVisibility(i);
            }
        }
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.h = i;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        a(this.h == -1);
    }
}
