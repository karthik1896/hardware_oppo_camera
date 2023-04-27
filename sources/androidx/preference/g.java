package androidx.preference;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import androidx.preference.DialogPreference;
import androidx.preference.j;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: PreferenceFragmentCompat */
public abstract class g extends Fragment implements DialogPreference.a, j.a, j.b, j.c {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f1007a;

    /* renamed from: b  reason: collision with root package name */
    private final a f1008b = new a();
    private j c;
    private boolean d;
    private boolean e;
    private int f = R.layout.preference_list_fragment;
    private Runnable g;
    private Handler h = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                g.this.b();
            }
        }
    };
    private final Runnable i = new Runnable() {
        public void run() {
            g.this.f1007a.focusableViewAvailable(g.this.f1007a);
        }
    };

    /* compiled from: PreferenceFragmentCompat */
    public interface b {
        boolean a(g gVar, Preference preference);
    }

    /* compiled from: PreferenceFragmentCompat */
    public interface c {
        boolean a(g gVar, Preference preference);
    }

    /* compiled from: PreferenceFragmentCompat */
    public interface d {
        boolean a(g gVar, PreferenceScreen preferenceScreen);
    }

    public abstract void a(Bundle bundle, String str);

    /* access modifiers changed from: protected */
    public void c() {
    }

    /* access modifiers changed from: protected */
    public void d() {
    }

    public Fragment g() {
        return null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(R.attr.preferenceTheme, typedValue, true);
        int i2 = typedValue.resourceId;
        if (i2 == 0) {
            i2 = R.style.PreferenceThemeOverlay;
        }
        getActivity().getTheme().applyStyle(i2, false);
        this.c = new j(getContext());
        this.c.a((j.b) this);
        a(bundle, getArguments() != null ? getArguments().getString("androidx.preference.PreferenceFragmentCompat.PREFERENCE_ROOT") : null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.PreferenceFragmentCompat, R.attr.preferenceFragmentCompatStyle, 0);
        this.f = obtainStyledAttributes.getResourceId(R.styleable.PreferenceFragmentCompat_android_layout, this.f);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.PreferenceFragmentCompat_android_divider);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PreferenceFragmentCompat_android_dividerHeight, -1);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.PreferenceFragmentCompat_allowDividerAfterLastItem, true);
        obtainStyledAttributes.recycle();
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(getContext());
        View inflate = cloneInContext.inflate(this.f, viewGroup, false);
        View findViewById = inflate.findViewById(16908351);
        if (findViewById instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById;
            RecyclerView a2 = a(cloneInContext, viewGroup2, bundle);
            if (a2 != null) {
                this.f1007a = a2;
                a2.addItemDecoration(this.f1008b);
                a(drawable);
                if (dimensionPixelSize != -1) {
                    a(dimensionPixelSize);
                }
                this.f1008b.a(z);
                if (this.f1007a.getParent() == null) {
                    viewGroup2.addView(this.f1007a);
                }
                this.h.post(this.i);
                return inflate;
            }
            throw new RuntimeException("Could not create RecyclerView");
        }
        throw new IllegalStateException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
    }

    public void a(Drawable drawable) {
        this.f1008b.a(drawable);
    }

    public void a(int i2) {
        this.f1008b.a(i2);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Bundle bundle2;
        PreferenceScreen a2;
        super.onViewCreated(view, bundle);
        if (!(bundle == null || (bundle2 = bundle.getBundle("android:preferences")) == null || (a2 = a()) == null)) {
            a2.c(bundle2);
        }
        if (this.d) {
            b();
            Runnable runnable = this.g;
            if (runnable != null) {
                runnable.run();
                this.g = null;
            }
        }
        this.e = true;
    }

    public void onStart() {
        super.onStart();
        this.c.a((j.c) this);
        this.c.a((j.a) this);
    }

    public void onStop() {
        super.onStop();
        this.c.a((j.c) null);
        this.c.a((j.a) null);
    }

    public void onDestroyView() {
        this.h.removeCallbacks(this.i);
        this.h.removeMessages(1);
        if (this.d) {
            j();
        }
        this.f1007a = null;
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PreferenceScreen a2 = a();
        if (a2 != null) {
            Bundle bundle2 = new Bundle();
            a2.a(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    public PreferenceScreen a() {
        return this.c.d();
    }

    public void a(PreferenceScreen preferenceScreen) {
        if (this.c.a(preferenceScreen) && preferenceScreen != null) {
            d();
            this.d = true;
            if (this.e) {
                i();
            }
        }
    }

    public void b(int i2) {
        h();
        a(this.c.a(getContext(), i2, a()));
    }

    public boolean a(Preference preference) {
        if (preference.r() == null) {
            return false;
        }
        boolean a2 = g() instanceof c ? ((c) g()).a(this, preference) : false;
        if (!a2 && (getActivity() instanceof c)) {
            a2 = ((c) getActivity()).a(this, preference);
        }
        if (a2) {
            return true;
        }
        Log.w("PreferenceFragment", "onPreferenceStartFragment is not implemented in the parent activity - attempting to use a fallback implementation. You should implement this method so that you can configure the new fragment that will be displayed, and set a transition between the fragments.");
        h j = requireActivity().j();
        Bundle t = preference.t();
        Fragment c2 = j.f().c(requireActivity().getClassLoader(), preference.r());
        c2.setArguments(t);
        c2.setTargetFragment(this, 0);
        j.a().a(((View) getView().getParent()).getId(), c2).a((String) null).b();
        return true;
    }

    public void b(PreferenceScreen preferenceScreen) {
        if (!(g() instanceof d ? ((d) g()).a(this, preferenceScreen) : false) && (getActivity() instanceof d)) {
            ((d) getActivity()).a(this, preferenceScreen);
        }
    }

    public <T extends Preference> T a(CharSequence charSequence) {
        j jVar = this.c;
        if (jVar == null) {
            return null;
        }
        return jVar.a(charSequence);
    }

    private void h() {
        if (this.c == null) {
            throw new RuntimeException("This should be called after super.onCreate.");
        }
    }

    private void i() {
        if (!this.h.hasMessages(1)) {
            this.h.obtainMessage(1).sendToTarget();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        PreferenceScreen a2 = a();
        if (a2 != null) {
            e().setAdapter(c(a2));
            a2.N();
        }
        c();
    }

    private void j() {
        e().setAdapter((RecyclerView.a) null);
        PreferenceScreen a2 = a();
        if (a2 != null) {
            a2.O();
        }
        d();
    }

    public final RecyclerView e() {
        return this.f1007a;
    }

    public RecyclerView a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView;
        if (getContext().getPackageManager().hasSystemFeature("android.hardware.type.automotive") && (recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler_view)) != null) {
            return recyclerView;
        }
        RecyclerView recyclerView2 = (RecyclerView) layoutInflater.inflate(R.layout.preference_recyclerview, viewGroup, false);
        recyclerView2.setLayoutManager(f());
        recyclerView2.setAccessibilityDelegateCompat(new k(recyclerView2));
        return recyclerView2;
    }

    public RecyclerView.i f() {
        return new LinearLayoutManager(getContext());
    }

    /* access modifiers changed from: protected */
    public RecyclerView.a c(PreferenceScreen preferenceScreen) {
        return new h(preferenceScreen);
    }

    public void b(Preference preference) {
        androidx.fragment.app.b bVar;
        boolean a2 = g() instanceof b ? ((b) g()).a(this, preference) : false;
        if (!a2 && (getActivity() instanceof b)) {
            a2 = ((b) getActivity()).a(this, preference);
        }
        if (!a2 && getFragmentManager().a("androidx.preference.PreferenceFragment.DIALOG") == null) {
            if (preference instanceof EditTextPreference) {
                bVar = a.a(preference.B());
            } else if (preference instanceof ListPreference) {
                bVar = c.a(preference.B());
            } else if (preference instanceof MultiSelectListPreference) {
                bVar = d.a(preference.B());
            } else {
                throw new IllegalArgumentException("Cannot display dialog for an unknown Preference type: " + preference.getClass().getSimpleName() + ". Make sure to implement onPreferenceDisplayDialog() to handle displaying a custom dialog for this Preference.");
            }
            bVar.setTargetFragment(this, 0);
            bVar.show(getFragmentManager(), "androidx.preference.PreferenceFragment.DIALOG");
        }
    }

    /* compiled from: PreferenceFragmentCompat */
    private class a extends RecyclerView.h {

        /* renamed from: b  reason: collision with root package name */
        private Drawable f1012b;
        private int c;
        private boolean d = true;

        a() {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.t tVar) {
            if (this.f1012b != null) {
                int childCount = recyclerView.getChildCount();
                int width = recyclerView.getWidth();
                for (int i = 0; i < childCount; i++) {
                    View childAt = recyclerView.getChildAt(i);
                    if (a(childAt, recyclerView)) {
                        int y = ((int) childAt.getY()) + childAt.getHeight();
                        this.f1012b.setBounds(0, y, width, this.c + y);
                        this.f1012b.draw(canvas);
                    }
                }
            }
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t tVar) {
            if (a(view, recyclerView)) {
                rect.bottom = this.c;
            }
        }

        private boolean a(View view, RecyclerView recyclerView) {
            RecyclerView.w childViewHolder = recyclerView.getChildViewHolder(view);
            if (!((childViewHolder instanceof l) && ((l) childViewHolder).b())) {
                return false;
            }
            boolean z = this.d;
            int indexOfChild = recyclerView.indexOfChild(view);
            if (indexOfChild >= recyclerView.getChildCount() - 1) {
                return z;
            }
            RecyclerView.w childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(indexOfChild + 1));
            return (childViewHolder2 instanceof l) && ((l) childViewHolder2).a();
        }

        public void a(Drawable drawable) {
            if (drawable != null) {
                this.c = drawable.getIntrinsicHeight();
            } else {
                this.c = 0;
            }
            this.f1012b = drawable;
            g.this.f1007a.invalidateItemDecorations();
        }

        public void a(int i) {
            this.c = i;
            g.this.f1007a.invalidateItemDecorations();
        }

        public void a(boolean z) {
            this.d = z;
        }
    }
}
