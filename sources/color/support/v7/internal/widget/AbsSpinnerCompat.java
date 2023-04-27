package color.support.v7.internal.widget;

import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import color.support.v7.internal.widget.a;

abstract class AbsSpinnerCompat extends a<SpinnerAdapter> {
    private DataSetObserver E;

    /* renamed from: a  reason: collision with root package name */
    SpinnerAdapter f1496a;

    /* renamed from: b  reason: collision with root package name */
    int f1497b;
    int c;
    int d;
    int e;
    int f;
    int g;
    final Rect h;
    final a i;

    /* access modifiers changed from: package-private */
    public abstract void a(int i2, boolean z);

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        SpinnerAdapter spinnerAdapter2 = this.f1496a;
        if (spinnerAdapter2 != null) {
            spinnerAdapter2.unregisterDataSetObserver(this.E);
            a();
        }
        this.f1496a = spinnerAdapter;
        int i2 = -1;
        this.B = -1;
        this.C = Long.MIN_VALUE;
        if (this.f1496a != null) {
            this.A = this.z;
            this.z = this.f1496a.getCount();
            d();
            this.E = new a.C0047a();
            this.f1496a.registerDataSetObserver(this.E);
            if (this.z > 0) {
                i2 = 0;
            }
            setSelectedPositionInt(i2);
            setNextSelectedPositionInt(i2);
            if (this.z == 0) {
                g();
            }
        } else {
            d();
            a();
            g();
        }
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.u = false;
        this.o = false;
        removeAllViewsInLayout();
        this.B = -1;
        this.C = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        invalidate();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            int r0 = android.view.View.MeasureSpec.getMode(r8)
            int r1 = r7.getPaddingLeft()
            int r2 = r7.getPaddingTop()
            int r3 = r7.getPaddingRight()
            int r4 = r7.getPaddingBottom()
            android.graphics.Rect r5 = r7.h
            int r6 = r7.d
            if (r1 <= r6) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r1 = r6
        L_0x001c:
            r5.left = r1
            android.graphics.Rect r1 = r7.h
            int r5 = r7.e
            if (r2 <= r5) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = r5
        L_0x0026:
            r1.top = r2
            android.graphics.Rect r1 = r7.h
            int r2 = r7.f
            if (r3 <= r2) goto L_0x002f
            r2 = r3
        L_0x002f:
            r1.right = r2
            android.graphics.Rect r1 = r7.h
            int r2 = r7.g
            if (r4 <= r2) goto L_0x0038
            r2 = r4
        L_0x0038:
            r1.bottom = r2
            boolean r1 = r7.u
            if (r1 == 0) goto L_0x0041
            r7.f()
        L_0x0041:
            int r1 = r7.getSelectedItemPosition()
            r2 = 1
            r3 = 0
            if (r1 < 0) goto L_0x009c
            android.widget.SpinnerAdapter r4 = r7.f1496a
            if (r4 == 0) goto L_0x009c
            int r4 = r4.getCount()
            if (r1 >= r4) goto L_0x009c
            color.support.v7.internal.widget.AbsSpinnerCompat$a r4 = r7.i
            android.view.View r4 = r4.a(r1)
            if (r4 != 0) goto L_0x0062
            android.widget.SpinnerAdapter r4 = r7.f1496a
            r5 = 0
            android.view.View r4 = r4.getView(r1, r5, r7)
        L_0x0062:
            if (r4 == 0) goto L_0x009c
            color.support.v7.internal.widget.AbsSpinnerCompat$a r5 = r7.i
            r5.a(r1, r4)
            android.view.ViewGroup$LayoutParams r1 = r4.getLayoutParams()
            if (r1 != 0) goto L_0x007a
            r7.D = r2
            android.view.ViewGroup$LayoutParams r1 = r7.generateDefaultLayoutParams()
            r4.setLayoutParams(r1)
            r7.D = r3
        L_0x007a:
            r7.measureChild(r4, r8, r9)
            int r1 = r7.a(r4)
            android.graphics.Rect r2 = r7.h
            int r2 = r2.top
            int r1 = r1 + r2
            android.graphics.Rect r2 = r7.h
            int r2 = r2.bottom
            int r1 = r1 + r2
            int r2 = r7.b(r4)
            android.graphics.Rect r4 = r7.h
            int r4 = r4.left
            int r2 = r2 + r4
            android.graphics.Rect r4 = r7.h
            int r4 = r4.right
            int r2 = r2 + r4
            r4 = r2
            r2 = r3
            goto L_0x009e
        L_0x009c:
            r1 = r3
            r4 = r1
        L_0x009e:
            if (r2 == 0) goto L_0x00b5
            android.graphics.Rect r1 = r7.h
            int r1 = r1.top
            android.graphics.Rect r2 = r7.h
            int r2 = r2.bottom
            int r1 = r1 + r2
            if (r0 != 0) goto L_0x00b5
            android.graphics.Rect r0 = r7.h
            int r0 = r0.left
            android.graphics.Rect r2 = r7.h
            int r2 = r2.right
            int r4 = r0 + r2
        L_0x00b5:
            int r0 = r7.getSuggestedMinimumHeight()
            int r0 = java.lang.Math.max(r1, r0)
            int r1 = r7.getSuggestedMinimumWidth()
            int r1 = java.lang.Math.max(r4, r1)
            int r0 = androidx.core.g.v.a((int) r0, (int) r9, (int) r3)
            int r1 = androidx.core.g.v.a((int) r1, (int) r8, (int) r3)
            r7.setMeasuredDimension(r1, r0)
            r7.f1497b = r9
            r7.c = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: color.support.v7.internal.widget.AbsSpinnerCompat.onMeasure(int, int):void");
    }

    /* access modifiers changed from: package-private */
    public int a(View view) {
        return view.getMeasuredHeight();
    }

    /* access modifiers changed from: package-private */
    public int b(View view) {
        return view.getMeasuredWidth();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int childCount = getChildCount();
        a aVar = this.i;
        int i2 = this.j;
        for (int i3 = 0; i3 < childCount; i3++) {
            aVar.a(i2 + i3, getChildAt(i3));
        }
    }

    public void setSelection(int i2) {
        setNextSelectedPositionInt(i2);
        requestLayout();
        invalidate();
    }

    public View getSelectedView() {
        if (this.z <= 0 || this.x < 0) {
            return null;
        }
        return getChildAt(this.x - this.j);
    }

    public void requestLayout() {
        if (!this.D) {
            super.requestLayout();
        }
    }

    public SpinnerAdapter getAdapter() {
        return this.f1496a;
    }

    public int getCount() {
        return this.z;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int position;
        long selectedId;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.selectedId = parcel.readLong();
            this.position = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.selectedId);
            parcel.writeInt(this.position);
        }

        public String toString() {
            return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " position=" + this.position + "}";
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.selectedId = getSelectedItemId();
        if (savedState.selectedId >= 0) {
            savedState.position = getSelectedItemPosition();
        } else {
            savedState.position = -1;
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.selectedId >= 0) {
            this.u = true;
            this.o = true;
            this.m = savedState.selectedId;
            this.l = savedState.position;
            this.p = 0;
            requestLayout();
        }
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AbsSpinnerCompat f1498a;

        /* renamed from: b  reason: collision with root package name */
        private final SparseArray<View> f1499b;

        public void a(int i, View view) {
            this.f1499b.put(i, view);
        }

        /* access modifiers changed from: package-private */
        public View a(int i) {
            View view = this.f1499b.get(i);
            if (view != null) {
                this.f1499b.delete(i);
            }
            return view;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            SparseArray<View> sparseArray = this.f1499b;
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                View valueAt = sparseArray.valueAt(i);
                if (valueAt != null) {
                    this.f1498a.removeDetachedView(valueAt, true);
                }
            }
            sparseArray.clear();
        }
    }
}
