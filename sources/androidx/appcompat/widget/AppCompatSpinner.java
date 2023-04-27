package androidx.appcompat.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.R;
import androidx.appcompat.app.b;
import androidx.core.g.u;
import androidx.core.g.v;

public class AppCompatSpinner extends Spinner implements u {
    private static final int[] c = {16843505};

    /* renamed from: a  reason: collision with root package name */
    int f320a;

    /* renamed from: b  reason: collision with root package name */
    final Rect f321b;
    private final e d;
    private final Context e;
    private ad f;
    private SpinnerAdapter g;
    private final boolean h;
    private d i;

    interface d {
        CharSequence a();

        void a(int i);

        void a(int i, int i2);

        void a(Drawable drawable);

        void a(ListAdapter listAdapter);

        void a(CharSequence charSequence);

        void b();

        void b(int i);

        void c(int i);

        boolean c();

        Drawable d();

        int e();

        int f();
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(context, attributeSet, i2, i3, (Resources.Theme) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        if (r11 != null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
        if (r11 != null) goto L_0x004a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppCompatSpinner(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
            r6 = this;
            r6.<init>(r7, r8, r9)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r6.f321b = r0
            int[] r0 = androidx.appcompat.R.styleable.Spinner
            r1 = 0
            androidx.appcompat.widget.ar r0 = androidx.appcompat.widget.ar.a(r7, r8, r0, r9, r1)
            androidx.appcompat.widget.e r2 = new androidx.appcompat.widget.e
            r2.<init>(r6)
            r6.d = r2
            if (r11 == 0) goto L_0x0022
            androidx.appcompat.view.d r2 = new androidx.appcompat.view.d
            r2.<init>((android.content.Context) r7, (android.content.res.Resources.Theme) r11)
            r6.e = r2
            goto L_0x0034
        L_0x0022:
            int r11 = androidx.appcompat.R.styleable.Spinner_popupTheme
            int r11 = r0.g(r11, r1)
            if (r11 == 0) goto L_0x0032
            androidx.appcompat.view.d r2 = new androidx.appcompat.view.d
            r2.<init>((android.content.Context) r7, (int) r11)
            r6.e = r2
            goto L_0x0034
        L_0x0032:
            r6.e = r7
        L_0x0034:
            r11 = -1
            r2 = 0
            if (r10 != r11) goto L_0x0066
            int[] r11 = c     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            android.content.res.TypedArray r11 = r7.obtainStyledAttributes(r8, r11, r9, r1)     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            boolean r3 = r11.hasValue(r1)     // Catch:{ Exception -> 0x004e }
            if (r3 == 0) goto L_0x0048
            int r10 = r11.getInt(r1, r1)     // Catch:{ Exception -> 0x004e }
        L_0x0048:
            if (r11 == 0) goto L_0x0066
        L_0x004a:
            r11.recycle()
            goto L_0x0066
        L_0x004e:
            r3 = move-exception
            goto L_0x0055
        L_0x0050:
            r7 = move-exception
            r11 = r2
            goto L_0x0060
        L_0x0053:
            r3 = move-exception
            r11 = r2
        L_0x0055:
            java.lang.String r4 = "AppCompatSpinner"
            java.lang.String r5 = "Could not read android:spinnerMode"
            android.util.Log.i(r4, r5, r3)     // Catch:{ all -> 0x005f }
            if (r11 == 0) goto L_0x0066
            goto L_0x004a
        L_0x005f:
            r7 = move-exception
        L_0x0060:
            if (r11 == 0) goto L_0x0065
            r11.recycle()
        L_0x0065:
            throw r7
        L_0x0066:
            r11 = 1
            if (r10 == 0) goto L_0x00a3
            if (r10 == r11) goto L_0x006c
            goto L_0x00b5
        L_0x006c:
            androidx.appcompat.widget.AppCompatSpinner$c r10 = new androidx.appcompat.widget.AppCompatSpinner$c
            android.content.Context r3 = r6.e
            r10.<init>(r3, r8, r9)
            android.content.Context r3 = r6.e
            int[] r4 = androidx.appcompat.R.styleable.Spinner
            androidx.appcompat.widget.ar r1 = androidx.appcompat.widget.ar.a(r3, r8, r4, r9, r1)
            int r3 = androidx.appcompat.R.styleable.Spinner_android_dropDownWidth
            r4 = -2
            int r3 = r1.f(r3, r4)
            r6.f320a = r3
            int r3 = androidx.appcompat.R.styleable.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r3 = r1.a(r3)
            r10.a((android.graphics.drawable.Drawable) r3)
            int r3 = androidx.appcompat.R.styleable.Spinner_android_prompt
            java.lang.String r3 = r0.d(r3)
            r10.a((java.lang.CharSequence) r3)
            r1.b()
            r6.i = r10
            androidx.appcompat.widget.AppCompatSpinner$1 r1 = new androidx.appcompat.widget.AppCompatSpinner$1
            r1.<init>(r6, r10)
            r6.f = r1
            goto L_0x00b5
        L_0x00a3:
            androidx.appcompat.widget.AppCompatSpinner$a r10 = new androidx.appcompat.widget.AppCompatSpinner$a
            r10.<init>()
            r6.i = r10
            androidx.appcompat.widget.AppCompatSpinner$d r10 = r6.i
            int r1 = androidx.appcompat.R.styleable.Spinner_android_prompt
            java.lang.String r1 = r0.d(r1)
            r10.a((java.lang.CharSequence) r1)
        L_0x00b5:
            int r10 = androidx.appcompat.R.styleable.Spinner_android_entries
            java.lang.CharSequence[] r10 = r0.f(r10)
            if (r10 == 0) goto L_0x00cd
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter
            r3 = 17367048(0x1090008, float:2.5162948E-38)
            r1.<init>(r7, r3, r10)
            int r7 = androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
            r1.setDropDownViewResource(r7)
            r6.setAdapter((android.widget.SpinnerAdapter) r1)
        L_0x00cd:
            r0.b()
            r6.h = r11
            android.widget.SpinnerAdapter r7 = r6.g
            if (r7 == 0) goto L_0x00db
            r6.setAdapter((android.widget.SpinnerAdapter) r7)
            r6.g = r2
        L_0x00db:
            androidx.appcompat.widget.e r7 = r6.d
            r7.a(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    public Context getPopupContext() {
        return this.e;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        d dVar = this.i;
        if (dVar != null) {
            dVar.a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(androidx.appcompat.a.a.a.b(getPopupContext(), i2));
    }

    public Drawable getPopupBackground() {
        d dVar = this.i;
        if (dVar != null) {
            return dVar.d();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    public void setDropDownVerticalOffset(int i2) {
        d dVar = this.i;
        if (dVar != null) {
            dVar.a(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i2);
        }
    }

    public int getDropDownVerticalOffset() {
        d dVar = this.i;
        if (dVar != null) {
            return dVar.e();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public void setDropDownHorizontalOffset(int i2) {
        d dVar = this.i;
        if (dVar != null) {
            dVar.c(i2);
            this.i.b(i2);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i2);
        }
    }

    public int getDropDownHorizontalOffset() {
        d dVar = this.i;
        if (dVar != null) {
            return dVar.f();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public void setDropDownWidth(int i2) {
        if (this.i != null) {
            this.f320a = i2;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i2);
        }
    }

    public int getDropDownWidth() {
        if (this.i != null) {
            return this.f320a;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.h) {
            this.g = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.i != null) {
            Context context = this.e;
            if (context == null) {
                context = getContext();
            }
            this.i.a((ListAdapter) new b(spinnerAdapter, context.getTheme()));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.i;
        if (dVar != null && dVar.c()) {
            this.i.b();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ad adVar = this.f;
        if (adVar == null || !adVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.i != null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        d dVar = this.i;
        if (dVar == null) {
            return super.performClick();
        }
        if (dVar.c()) {
            return true;
        }
        a();
        return true;
    }

    public void setPrompt(CharSequence charSequence) {
        d dVar = this.i;
        if (dVar != null) {
            dVar.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        d dVar = this.i;
        return dVar != null ? dVar.a() : super.getPrompt();
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.d;
        if (eVar != null) {
            eVar.a(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.d;
        if (eVar != null) {
            eVar.a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.d;
        if (eVar != null) {
            eVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.d;
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.d;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.d;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.d;
        if (eVar != null) {
            eVar.c();
        }
    }

    /* access modifiers changed from: package-private */
    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int i3 = 0;
        View view = null;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i3;
        }
        drawable.getPadding(this.f321b);
        return i3 + this.f321b.left + this.f321b.right;
    }

    /* access modifiers changed from: package-private */
    public final d getInternalPopup() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.i.a(getTextDirection(), getTextAlignment());
        } else {
            this.i.a(-1, -1);
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        d dVar = this.i;
        savedState.mShowDropdown = dVar != null && dVar.c();
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.mShowDropdown && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (!AppCompatSpinner.this.getInternalPopup().c()) {
                        AppCompatSpinner.this.a();
                    }
                    ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                    if (viewTreeObserver == null) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 16) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            });
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean mShowDropdown;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.mShowDropdown = parcel.readByte() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.mShowDropdown ? (byte) 1 : 0);
        }
    }

    private static class b implements ListAdapter, SpinnerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private SpinnerAdapter f327a;

        /* renamed from: b  reason: collision with root package name */
        private ListAdapter f328b;

        public int getItemViewType(int i) {
            return 0;
        }

        public int getViewTypeCount() {
            return 1;
        }

        public b(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f327a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f328b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof an) {
                an anVar = (an) spinnerAdapter;
                if (anVar.a() == null) {
                    anVar.a(theme);
                }
            }
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f327a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.f327a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.f327a;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f327a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f327a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f327a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f327a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f328b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f328b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    class a implements DialogInterface.OnClickListener, d {

        /* renamed from: a  reason: collision with root package name */
        androidx.appcompat.app.b f325a;
        private ListAdapter c;
        private CharSequence d;

        public Drawable d() {
            return null;
        }

        public int e() {
            return 0;
        }

        public int f() {
            return 0;
        }

        a() {
        }

        public void b() {
            androidx.appcompat.app.b bVar = this.f325a;
            if (bVar != null) {
                bVar.dismiss();
                this.f325a = null;
            }
        }

        public boolean c() {
            androidx.appcompat.app.b bVar = this.f325a;
            if (bVar != null) {
                return bVar.isShowing();
            }
            return false;
        }

        public void a(ListAdapter listAdapter) {
            this.c = listAdapter;
        }

        public void a(CharSequence charSequence) {
            this.d = charSequence;
        }

        public CharSequence a() {
            return this.d;
        }

        public void a(int i, int i2) {
            if (this.c != null) {
                b.a aVar = new b.a(AppCompatSpinner.this.getPopupContext());
                CharSequence charSequence = this.d;
                if (charSequence != null) {
                    aVar.setTitle(charSequence);
                }
                this.f325a = aVar.setSingleChoiceItems(this.c, AppCompatSpinner.this.getSelectedItemPosition(), (DialogInterface.OnClickListener) this).create();
                ListView a2 = this.f325a.a();
                if (Build.VERSION.SDK_INT >= 17) {
                    a2.setTextDirection(i);
                    a2.setTextAlignment(i2);
                }
                this.f325a.show();
            }
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            AppCompatSpinner.this.setSelection(i);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick((View) null, i, this.c.getItemId(i));
            }
            b();
        }

        public void a(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        public void a(int i) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        public void b(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        public void c(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }
    }

    class c extends ae implements d {

        /* renamed from: a  reason: collision with root package name */
        ListAdapter f329a;
        private CharSequence h;
        private final Rect i = new Rect();
        private int j;

        public c(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            b((View) AppCompatSpinner.this);
            a(true);
            d(0);
            a((AdapterView.OnItemClickListener) new AdapterView.OnItemClickListener(AppCompatSpinner.this) {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppCompatSpinner.this.setSelection(i);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        AppCompatSpinner.this.performItemClick(view, i, c.this.f329a.getItemId(i));
                    }
                    c.this.b();
                }
            });
        }

        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.f329a = listAdapter;
        }

        public CharSequence a() {
            return this.h;
        }

        public void a(CharSequence charSequence) {
            this.h = charSequence;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            int i2;
            Drawable d = d();
            int i3 = 0;
            if (d != null) {
                d.getPadding(AppCompatSpinner.this.f321b);
                i3 = ax.a(AppCompatSpinner.this) ? AppCompatSpinner.this.f321b.right : -AppCompatSpinner.this.f321b.left;
            } else {
                Rect rect = AppCompatSpinner.this.f321b;
                AppCompatSpinner.this.f321b.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            if (AppCompatSpinner.this.f320a == -2) {
                int a2 = AppCompatSpinner.this.a((SpinnerAdapter) this.f329a, d());
                int i4 = (AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.f321b.left) - AppCompatSpinner.this.f321b.right;
                if (a2 > i4) {
                    a2 = i4;
                }
                h(Math.max(a2, (width - paddingLeft) - paddingRight));
            } else if (AppCompatSpinner.this.f320a == -1) {
                h((width - paddingLeft) - paddingRight);
            } else {
                h(AppCompatSpinner.this.f320a);
            }
            if (ax.a(AppCompatSpinner.this)) {
                i2 = i3 + (((width - paddingRight) - k()) - h());
            } else {
                i2 = i3 + paddingLeft + h();
            }
            b(i2);
        }

        public void a(int i2, int i3) {
            ViewTreeObserver viewTreeObserver;
            boolean c = c();
            g();
            i(2);
            super.a_();
            ListView b_ = b_();
            b_.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                b_.setTextDirection(i2);
                b_.setTextAlignment(i3);
            }
            j(AppCompatSpinner.this.getSelectedItemPosition());
            if (!c && (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) != null) {
                final AnonymousClass2 r6 = new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        c cVar = c.this;
                        if (!cVar.a((View) AppCompatSpinner.this)) {
                            c.this.b();
                            return;
                        }
                        c.this.g();
                        c.super.a_();
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener(r6);
                a((PopupWindow.OnDismissListener) new PopupWindow.OnDismissListener() {
                    public void onDismiss() {
                        ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.removeGlobalOnLayoutListener(r6);
                        }
                    }
                });
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(View view) {
            return v.D(view) && view.getGlobalVisibleRect(this.i);
        }

        public void c(int i2) {
            this.j = i2;
        }

        public int h() {
            return this.j;
        }
    }
}
