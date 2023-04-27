package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.a;
import androidx.core.f.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentHostCallback */
public abstract class g<E> extends d {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f845a;

    /* renamed from: b  reason: collision with root package name */
    final i f846b;
    private final Context c;
    private final Handler d;
    private final int e;

    public View a(int i) {
        return null;
    }

    public void a(Fragment fragment, String[] strArr, int i) {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean a() {
        return true;
    }

    public boolean a(Fragment fragment) {
        return true;
    }

    public boolean a(String str) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void b(Fragment fragment) {
    }

    public void e() {
    }

    public boolean f() {
        return true;
    }

    public abstract E h();

    g(c cVar) {
        this(cVar, cVar, new Handler(), 0);
    }

    g(Activity activity, Context context, Handler handler, int i) {
        this.f846b = new i();
        this.f845a = activity;
        this.c = (Context) f.a(context, (Object) "context == null");
        this.d = (Handler) f.a(handler, (Object) "handler == null");
        this.e = i;
    }

    public LayoutInflater c() {
        return LayoutInflater.from(this.c);
    }

    public void a(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            this.c.startActivity(intent);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    public void a(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (i == -1) {
            a.a(this.f845a, intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
    }

    public int g() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public Activity i() {
        return this.f845a;
    }

    /* access modifiers changed from: package-private */
    public Context j() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public Handler k() {
        return this.d;
    }
}
