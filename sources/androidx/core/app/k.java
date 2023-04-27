package androidx.core.app;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.util.Set;

/* compiled from: RemoteInput */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final String f601a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f602b;
    private final CharSequence[] c;
    private final boolean d;
    private final int e;
    private final Bundle f;
    private final Set<String> g;

    public String a() {
        return this.f601a;
    }

    public CharSequence b() {
        return this.f602b;
    }

    public CharSequence[] c() {
        return this.c;
    }

    public Set<String> d() {
        return this.g;
    }

    public boolean e() {
        return this.d;
    }

    public int f() {
        return this.e;
    }

    public Bundle g() {
        return this.f;
    }

    static RemoteInput[] a(k[] kVarArr) {
        if (kVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[kVarArr.length];
        for (int i = 0; i < kVarArr.length; i++) {
            remoteInputArr[i] = a(kVarArr[i]);
        }
        return remoteInputArr;
    }

    static RemoteInput a(k kVar) {
        RemoteInput.Builder addExtras = new RemoteInput.Builder(kVar.a()).setLabel(kVar.b()).setChoices(kVar.c()).setAllowFreeFormInput(kVar.e()).addExtras(kVar.g());
        if (Build.VERSION.SDK_INT >= 29) {
            addExtras.setEditChoicesBeforeSending(kVar.f());
        }
        return addExtras.build();
    }
}
