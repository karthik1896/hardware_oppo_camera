package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.b;
import androidx.core.g.d;

/* compiled from: AppCompatDialog */
public class f extends Dialog implements d {
    private e mDelegate;
    private final d.a mKeyDispatcher;

    public void onSupportActionModeFinished(b bVar) {
    }

    public void onSupportActionModeStarted(b bVar) {
    }

    public b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    public f(Context context) {
        this(context, 0);
    }

    public f(Context context, int i) {
        super(context, getThemeResId(context, i));
        this.mKeyDispatcher = new d.a() {
            public boolean a(KeyEvent keyEvent) {
                return f.this.superDispatchKeyEvent(keyEvent);
            }
        };
        e delegate = getDelegate();
        delegate.a(getThemeResId(context, i));
        delegate.a((Bundle) null);
    }

    protected f(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mKeyDispatcher = new d.a() {
            public boolean a(KeyEvent keyEvent) {
                return f.this.superDispatchKeyEvent(keyEvent);
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        getDelegate().h();
        super.onCreate(bundle);
        getDelegate().a(bundle);
    }

    public a getSupportActionBar() {
        return getDelegate().a();
    }

    public void setContentView(int i) {
        getDelegate().c(i);
    }

    public void setContentView(View view) {
        getDelegate().a(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().a(view, layoutParams);
    }

    public <T extends View> T findViewById(int i) {
        return getDelegate().b(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().a(charSequence);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        getDelegate().a((CharSequence) getContext().getString(i));
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().b(view, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        getDelegate().d();
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().d(i);
    }

    public void invalidateOptionsMenu() {
        getDelegate().f();
    }

    public e getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = e.a((Dialog) this, (d) this);
        }
        return this.mDelegate;
    }

    private static int getThemeResId(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* access modifiers changed from: package-private */
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return d.a(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }
}
