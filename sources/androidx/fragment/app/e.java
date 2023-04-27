package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.core.f.f;
import androidx.lifecycle.t;

/* compiled from: FragmentController */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final g<?> f843a;

    public static e a(g<?> gVar) {
        return new e((g) f.a(gVar, (Object) "callbacks == null"));
    }

    private e(g<?> gVar) {
        this.f843a = gVar;
    }

    public h a() {
        return this.f843a.f846b;
    }

    public Fragment a(String str) {
        return this.f843a.f846b.b(str);
    }

    public void a(Fragment fragment) {
        i iVar = this.f843a.f846b;
        g<?> gVar = this.f843a;
        iVar.a((g) gVar, (d) gVar, fragment);
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f843a.f846b.onCreateView(view, str, context, attributeSet);
    }

    public void b() {
        this.f843a.f846b.p();
    }

    public Parcelable c() {
        return this.f843a.f846b.o();
    }

    public void a(Parcelable parcelable) {
        g<?> gVar = this.f843a;
        if (gVar instanceof t) {
            gVar.f846b.a(parcelable);
            return;
        }
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    public void d() {
        this.f843a.f846b.q();
    }

    public void e() {
        this.f843a.f846b.r();
    }

    public void f() {
        this.f843a.f846b.s();
    }

    public void g() {
        this.f843a.f846b.t();
    }

    public void h() {
        this.f843a.f846b.u();
    }

    public void i() {
        this.f843a.f846b.v();
    }

    public void j() {
        this.f843a.f846b.x();
    }

    public void a(boolean z) {
        this.f843a.f846b.a(z);
    }

    public void b(boolean z) {
        this.f843a.f846b.b(z);
    }

    public void a(Configuration configuration) {
        this.f843a.f846b.a(configuration);
    }

    public void k() {
        this.f843a.f846b.y();
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        return this.f843a.f846b.a(menu, menuInflater);
    }

    public boolean a(Menu menu) {
        return this.f843a.f846b.a(menu);
    }

    public boolean a(MenuItem menuItem) {
        return this.f843a.f846b.a(menuItem);
    }

    public boolean b(MenuItem menuItem) {
        return this.f843a.f846b.b(menuItem);
    }

    public void b(Menu menu) {
        this.f843a.f846b.b(menu);
    }

    public boolean l() {
        return this.f843a.f846b.l();
    }
}
