package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import androidx.lifecycle.e;

/* compiled from: ReportFragment */
public class p extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private a f929a;

    /* compiled from: ReportFragment */
    interface a {
        void a();

        void b();

        void c();
    }

    public static void a(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new p(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    private void b(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            aVar.c();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(this.f929a);
        a(e.a.ON_CREATE);
    }

    public void onStart() {
        super.onStart();
        b(this.f929a);
        a(e.a.ON_START);
    }

    public void onResume() {
        super.onResume();
        c(this.f929a);
        a(e.a.ON_RESUME);
    }

    public void onPause() {
        super.onPause();
        a(e.a.ON_PAUSE);
    }

    public void onStop() {
        super.onStop();
        a(e.a.ON_STOP);
    }

    public void onDestroy() {
        super.onDestroy();
        a(e.a.ON_DESTROY);
        this.f929a = null;
    }

    private void a(e.a aVar) {
        Activity activity = getActivity();
        if (activity instanceof j) {
            ((j) activity).a().a(aVar);
        } else if (activity instanceof h) {
            e lifecycle = ((h) activity).getLifecycle();
            if (lifecycle instanceof i) {
                ((i) lifecycle).a(aVar);
            }
        }
    }
}
