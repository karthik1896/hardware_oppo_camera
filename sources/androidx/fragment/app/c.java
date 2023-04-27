package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.b;
import androidx.activity.d;
import androidx.collection.SparseArrayCompat;
import androidx.core.app.a;
import androidx.lifecycle.e;
import androidx.lifecycle.i;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import com.meicam.sdk.NvsMediaFileConvertor;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: FragmentActivity */
public class c extends b implements a.C0013a, a.c {
    final e a_ = e.a((g<?>) new a());
    final i b_ = new i(this);
    boolean c_;
    boolean d;
    boolean e = true;
    boolean f;
    boolean g;
    boolean h;
    int i;
    SparseArrayCompat<String> j;

    public void a(Fragment fragment) {
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.a_.b();
        int i4 = i2 >> 16;
        if (i4 != 0) {
            int i5 = i4 - 1;
            String str = this.j.get(i5);
            this.j.remove(i5);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a2 = this.a_.a(str);
            if (a2 == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
                return;
            }
            a2.onActivityResult(i2 & NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN, i3, intent);
            return;
        }
        a.b a3 = androidx.core.app.a.a();
        if (a3 == null || !a3.a(this, i2, i3, intent)) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.a_.a(z);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.a_.b(z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.a_.b();
        this.a_.a(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.a_.a((Fragment) null);
        if (bundle != null) {
            this.a_.a(bundle.getParcelable("android:support:fragments"));
            if (bundle.containsKey("android:support:next_request_index")) {
                this.i = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.j = new SparseArrayCompat<>(intArray.length);
                    for (int i2 = 0; i2 < intArray.length; i2++) {
                        this.j.put(intArray[i2], stringArray[i2]);
                    }
                }
            }
        }
        if (this.j == null) {
            this.j = new SparseArrayCompat<>();
            this.i = 0;
        }
        super.onCreate(bundle);
        this.b_.a(e.a.ON_CREATE);
        this.a_.d();
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 == 0) {
            return super.onCreatePanelMenu(i2, menu) | this.a_.a(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i2, menu);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a2 = a(view, str, context, attributeSet);
        return a2 == null ? super.onCreateView(view, str, context, attributeSet) : a2;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View a2 = a((View) null, str, context, attributeSet);
        return a2 == null ? super.onCreateView(str, context, attributeSet) : a2;
    }

    /* access modifiers changed from: package-private */
    public final View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.a_.a(view, str, context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.a_.j();
        this.b_.a(e.a.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.a_.k();
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.a_.a(menuItem);
        }
        if (i2 != 6) {
            return false;
        }
        return this.a_.b(menuItem);
    }

    public void onPanelClosed(int i2, Menu menu) {
        if (i2 == 0) {
            this.a_.b(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.d = false;
        this.a_.h();
        this.b_.a(e.a.ON_PAUSE);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.a_.b();
    }

    public void onStateNotSaved() {
        this.a_.b();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.d = true;
        this.a_.b();
        this.a_.l();
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        i();
    }

    /* access modifiers changed from: protected */
    public void i() {
        this.b_.a(e.a.ON_RESUME);
        this.a_.g();
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        if (i2 == 0) {
            return a(view, menu) | this.a_.a(menu);
        }
        return super.onPreparePanel(i2, view, menu);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public boolean a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        e();
        this.b_.a(e.a.ON_STOP);
        Parcelable c = this.a_.c();
        if (c != null) {
            bundle.putParcelable("android:support:fragments", c);
        }
        if (this.j.size() > 0) {
            bundle.putInt("android:support:next_request_index", this.i);
            int[] iArr = new int[this.j.size()];
            String[] strArr = new String[this.j.size()];
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                iArr[i2] = this.j.keyAt(i2);
                strArr[i2] = this.j.valueAt(i2);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.e = false;
        if (!this.c_) {
            this.c_ = true;
            this.a_.e();
        }
        this.a_.b();
        this.a_.l();
        this.b_.a(e.a.ON_START);
        this.a_.f();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.e = true;
        e();
        this.a_.i();
        this.b_.a(e.a.ON_STOP);
    }

    @Deprecated
    public void d() {
        invalidateOptionsMenu();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.c_);
        printWriter.print(" mResumed=");
        printWriter.print(this.d);
        printWriter.print(" mStopped=");
        printWriter.print(this.e);
        if (getApplication() != null) {
            androidx.loader.a.a.a(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.a_.a().a(str, fileDescriptor, printWriter, strArr);
    }

    public h j() {
        return this.a_.a();
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        if (!this.h && i2 != -1) {
            c(i2);
        }
        super.startActivityForResult(intent, i2);
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (!this.h && i2 != -1) {
            c(i2);
        }
        super.startActivityForResult(intent, i2, bundle);
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        if (!this.g && i2 != -1) {
            c(i2);
        }
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (!this.g && i2 != -1) {
            c(i2);
        }
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }

    static void c(int i2) {
        if ((i2 & -65536) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    public final void b(int i2) {
        if (!this.f && i2 != -1) {
            c(i2);
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.a_.b();
        int i3 = (i2 >> 16) & NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = this.j.get(i4);
            this.j.remove(i4);
            if (str == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment a2 = this.a_.a(str);
            if (a2 == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
                return;
            }
            a2.onRequestPermissionsResult(i2 & NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN, strArr, iArr);
        }
    }

    public void a(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        this.h = true;
        if (i2 == -1) {
            try {
                androidx.core.app.a.a(this, intent, -1, bundle);
            } finally {
                this.h = false;
            }
        } else {
            c(i2);
            androidx.core.app.a.a(this, intent, ((b(fragment) + 1) << 16) + (i2 & NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN), bundle);
            this.h = false;
        }
    }

    public void a(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        int i6 = i2;
        this.g = true;
        if (i6 == -1) {
            try {
                androidx.core.app.a.a(this, intentSender, i2, intent, i3, i4, i5, bundle);
            } finally {
                this.g = false;
            }
        } else {
            c(i2);
            androidx.core.app.a.a(this, intentSender, ((b(fragment) + 1) << 16) + (i6 & NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN), intent, i3, i4, i5, bundle);
            this.g = false;
        }
    }

    private int b(Fragment fragment) {
        if (this.j.size() < 65534) {
            while (this.j.indexOfKey(this.i) >= 0) {
                this.i = (this.i + 1) % 65534;
            }
            int i2 = this.i;
            this.j.put(i2, fragment.mWho);
            this.i = (this.i + 1) % 65534;
            return i2;
        }
        throw new IllegalStateException("Too many pending Fragment activity results.");
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void a(Fragment fragment, String[] strArr, int i2) {
        if (i2 == -1) {
            androidx.core.app.a.a(this, strArr, i2);
            return;
        }
        c(i2);
        try {
            this.f = true;
            androidx.core.app.a.a(this, strArr, ((b(fragment) + 1) << 16) + (i2 & NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN));
            this.f = false;
        } catch (Throwable th) {
            this.f = false;
            throw th;
        }
    }

    /* compiled from: FragmentActivity */
    class a extends g<c> implements d, t {
        public a() {
            super(c.this);
        }

        public e getLifecycle() {
            return c.this.b_;
        }

        public s getViewModelStore() {
            return c.this.getViewModelStore();
        }

        public OnBackPressedDispatcher b() {
            return c.this.b();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            c.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        public boolean a(Fragment fragment) {
            return !c.this.isFinishing();
        }

        public LayoutInflater c() {
            return c.this.getLayoutInflater().cloneInContext(c.this);
        }

        /* renamed from: d */
        public c h() {
            return c.this;
        }

        public void e() {
            c.this.d();
        }

        public void a(Fragment fragment, Intent intent, int i, Bundle bundle) {
            c.this.a(fragment, intent, i, bundle);
        }

        public void a(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
            c.this.a(fragment, intentSender, i, intent, i2, i3, i4, bundle);
        }

        public void a(Fragment fragment, String[] strArr, int i) {
            c.this.a(fragment, strArr, i);
        }

        public boolean a(String str) {
            return androidx.core.app.a.a(c.this, str);
        }

        public boolean f() {
            return c.this.getWindow() != null;
        }

        public int g() {
            Window window = c.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        public void b(Fragment fragment) {
            c.this.a(fragment);
        }

        public View a(int i) {
            return c.this.findViewById(i);
        }

        public boolean a() {
            Window window = c.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    private void e() {
        do {
        } while (a(j(), e.b.CREATED));
    }

    private static boolean a(h hVar, e.b bVar) {
        boolean z = false;
        for (Fragment next : hVar.d()) {
            if (next != null) {
                if (next.getLifecycle().a().isAtLeast(e.b.STARTED)) {
                    next.mLifecycleRegistry.b(bVar);
                    z = true;
                }
                if (next.getHost() != null) {
                    z |= a(next.getChildFragmentManager(), bVar);
                }
            }
        }
        return z;
    }
}
