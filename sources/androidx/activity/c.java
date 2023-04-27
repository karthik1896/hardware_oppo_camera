package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: OnBackPressedCallback */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private boolean f115a;

    /* renamed from: b  reason: collision with root package name */
    private CopyOnWriteArrayList<a> f116b = new CopyOnWriteArrayList<>();

    public abstract void c();

    public c(boolean z) {
        this.f115a = z;
    }

    public final void a(boolean z) {
        this.f115a = z;
    }

    public final boolean a() {
        return this.f115a;
    }

    public final void b() {
        Iterator<a> it = this.f116b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f116b.add(aVar);
    }

    /* access modifiers changed from: package-private */
    public void b(a aVar) {
        this.f116b.remove(aVar);
    }
}
