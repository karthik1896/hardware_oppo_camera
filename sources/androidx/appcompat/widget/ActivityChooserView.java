package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import com.sensetime.stmobile.STMobileHumanActionNative;

public class ActivityChooserView extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    final a f314a;

    /* renamed from: b  reason: collision with root package name */
    final FrameLayout f315b;
    final FrameLayout c;
    androidx.core.g.b d;
    final DataSetObserver e;
    PopupWindow.OnDismissListener f;
    boolean g;
    int h;
    private final b i;
    private final View j;
    private final ImageView k;
    private final int l;
    private final ViewTreeObserver.OnGlobalLayoutListener m;
    private ae n;
    private boolean o;
    private int p;

    public void setActivityChooserModel(c cVar) {
        this.f314a.a(cVar);
        if (c()) {
            b();
            a();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.k.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i2) {
        this.k.setContentDescription(getContext().getString(i2));
    }

    public void setProvider(androidx.core.g.b bVar) {
        this.d = bVar;
    }

    public boolean a() {
        if (c() || !this.o) {
            return false;
        }
        this.g = false;
        a(this.h);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (this.f314a.d() != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.m);
            boolean z = this.c.getVisibility() == 0;
            int c2 = this.f314a.c();
            if (i2 == Integer.MAX_VALUE || c2 <= i2 + (z ? 1 : 0)) {
                this.f314a.a(false);
                this.f314a.a(i2);
            } else {
                this.f314a.a(true);
                this.f314a.a(i2 - 1);
            }
            ae listPopupWindow = getListPopupWindow();
            if (!listPopupWindow.c()) {
                if (this.g || !z) {
                    this.f314a.a(true, z);
                } else {
                    this.f314a.a(false, false);
                }
                listPopupWindow.h(Math.min(this.f314a.a(), this.l));
                listPopupWindow.a_();
                androidx.core.g.b bVar = this.d;
                if (bVar != null) {
                    bVar.a(true);
                }
                listPopupWindow.b_().setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
                listPopupWindow.b_().setSelector(new ColorDrawable(0));
                return;
            }
            return;
        }
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    public boolean b() {
        if (!c()) {
            return true;
        }
        getListPopupWindow().b();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.m);
        return true;
    }

    public boolean c() {
        return getListPopupWindow().c();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c d2 = this.f314a.d();
        if (d2 != null) {
            d2.registerObserver(this.e);
        }
        this.o = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c d2 = this.f314a.d();
        if (d2 != null) {
            d2.unregisterObserver(this.e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.m);
        }
        if (c()) {
            b();
        }
        this.o = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        View view = this.j;
        if (this.c.getVisibility() != 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 1073741824);
        }
        measureChild(view, i2, i3);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.j.layout(0, 0, i4 - i2, i5 - i3);
        if (!c()) {
            b();
        }
    }

    public c getDataModel() {
        return this.f314a.d();
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f = onDismissListener;
    }

    public void setInitialActivityCount(int i2) {
        this.h = i2;
    }

    public void setDefaultActionButtonContentDescription(int i2) {
        this.p = i2;
    }

    /* access modifiers changed from: package-private */
    public ae getListPopupWindow() {
        if (this.n == null) {
            this.n = new ae(getContext());
            this.n.a((ListAdapter) this.f314a);
            this.n.b((View) this);
            this.n.a(true);
            this.n.a((AdapterView.OnItemClickListener) this.i);
            this.n.a((PopupWindow.OnDismissListener) this.i);
        }
        return this.n;
    }

    private class b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActivityChooserView f319a;

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int itemViewType = ((a) adapterView.getAdapter()).getItemViewType(i);
            if (itemViewType == 0) {
                this.f319a.b();
                if (!this.f319a.g) {
                    if (!this.f319a.f314a.e()) {
                        i++;
                    }
                    Intent b2 = this.f319a.f314a.d().b(i);
                    if (b2 != null) {
                        b2.addFlags(STMobileHumanActionNative.ST_MOBILE_ENABLE_INPUT_CUSTOM);
                        this.f319a.getContext().startActivity(b2);
                    }
                } else if (i > 0) {
                    this.f319a.f314a.d().c(i);
                }
            } else if (itemViewType == 1) {
                this.f319a.a(Integer.MAX_VALUE);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onClick(View view) {
            if (view == this.f319a.c) {
                this.f319a.b();
                Intent b2 = this.f319a.f314a.d().b(this.f319a.f314a.d().a(this.f319a.f314a.b()));
                if (b2 != null) {
                    b2.addFlags(STMobileHumanActionNative.ST_MOBILE_ENABLE_INPUT_CUSTOM);
                    this.f319a.getContext().startActivity(b2);
                }
            } else if (view == this.f319a.f315b) {
                ActivityChooserView activityChooserView = this.f319a;
                activityChooserView.g = false;
                activityChooserView.a(activityChooserView.h);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            if (view == this.f319a.c) {
                if (this.f319a.f314a.getCount() > 0) {
                    ActivityChooserView activityChooserView = this.f319a;
                    activityChooserView.g = true;
                    activityChooserView.a(activityChooserView.h);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        public void onDismiss() {
            a();
            if (this.f319a.d != null) {
                this.f319a.d.a(false);
            }
        }

        private void a() {
            if (this.f319a.f != null) {
                this.f319a.f.onDismiss();
            }
        }
    }

    private class a extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ActivityChooserView f317a;

        /* renamed from: b  reason: collision with root package name */
        private c f318b;
        private int c;
        private boolean d;
        private boolean e;
        private boolean f;

        public long getItemId(int i) {
            return (long) i;
        }

        public int getViewTypeCount() {
            return 3;
        }

        public void a(c cVar) {
            c d2 = this.f317a.f314a.d();
            if (d2 != null && this.f317a.isShown()) {
                d2.unregisterObserver(this.f317a.e);
            }
            this.f318b = cVar;
            if (cVar != null && this.f317a.isShown()) {
                cVar.registerObserver(this.f317a.e);
            }
            notifyDataSetChanged();
        }

        public int getItemViewType(int i) {
            return (!this.f || i != getCount() - 1) ? 0 : 1;
        }

        public int getCount() {
            int a2 = this.f318b.a();
            if (!this.d && this.f318b.b() != null) {
                a2--;
            }
            int min = Math.min(a2, this.c);
            return this.f ? min + 1 : min;
        }

        public Object getItem(int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                if (!this.d && this.f318b.b() != null) {
                    i++;
                }
                return this.f318b.a(i);
            } else if (itemViewType == 1) {
                return null;
            } else {
                throw new IllegalArgumentException();
            }
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                if (view == null || view.getId() != R.id.list_item) {
                    view = LayoutInflater.from(this.f317a.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                PackageManager packageManager = this.f317a.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                ((ImageView) view.findViewById(R.id.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(R.id.title)).setText(resolveInfo.loadLabel(packageManager));
                if (!this.d || i != 0 || !this.e) {
                    view.setActivated(false);
                } else {
                    view.setActivated(true);
                }
                return view;
            } else if (itemViewType != 1) {
                throw new IllegalArgumentException();
            } else if (view != null && view.getId() == 1) {
                return view;
            } else {
                View inflate = LayoutInflater.from(this.f317a.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                inflate.setId(1);
                ((TextView) inflate.findViewById(R.id.title)).setText(this.f317a.getContext().getString(R.string.abc_activity_chooser_view_see_all));
                return inflate;
            }
        }

        public int a() {
            int i = this.c;
            this.c = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            int i2 = 0;
            View view = null;
            for (int i3 = 0; i3 < count; i3++) {
                view = getView(i3, view, (ViewGroup) null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i2 = Math.max(i2, view.getMeasuredWidth());
            }
            this.c = i;
            return i2;
        }

        public void a(int i) {
            if (this.c != i) {
                this.c = i;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo b() {
            return this.f318b.b();
        }

        public void a(boolean z) {
            if (this.f != z) {
                this.f = z;
                notifyDataSetChanged();
            }
        }

        public int c() {
            return this.f318b.a();
        }

        public c d() {
            return this.f318b;
        }

        public void a(boolean z, boolean z2) {
            if (this.d != z || this.e != z2) {
                this.d = z;
                this.e = z2;
                notifyDataSetChanged();
            }
        }

        public boolean e() {
            return this.d;
        }
    }

    public static class InnerLayout extends LinearLayout {

        /* renamed from: a  reason: collision with root package name */
        private static final int[] f316a = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            ar a2 = ar.a(context, attributeSet, f316a);
            setBackgroundDrawable(a2.a(0));
            a2.b();
        }
    }
}
