package com.oppo.camera.sticker.ui;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.oppo.camera.R;
import com.oppo.camera.e;

public class FooterGridView extends GridView {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f3675a = false;

    /* renamed from: b  reason: collision with root package name */
    private Paint f3676b = null;
    private boolean c = true;

    public FooterGridView(Context context) {
        super(context);
    }

    public FooterGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FooterGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);
        if (this.c) {
            int width = getWidth();
            int height = getHeight();
            if (this.f3676b == null) {
                LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, (float) height, getResources().getColor(R.color.sticker_gradient_start_color), getResources().getColor(R.color.sticker_gradient_end_color), Shader.TileMode.CLAMP);
                this.f3676b = new Paint();
                this.f3676b.setShader(linearGradient);
            }
            canvas.drawRect(0.0f, 0.0f, (float) width, (float) height, this.f3676b);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        e.a("FooterGridView", "onMeasure");
        this.f3675a = true;
        super.onMeasure(i, i2);
        ListAdapter adapter = getAdapter();
        if (adapter != null && (adapter instanceof a)) {
            a aVar = (a) adapter;
            aVar.a(getNumColumns());
            aVar.b(getRowHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        e.a("FooterGridView", "onLayout");
        this.f3675a = false;
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        a aVar = new a(baseAdapter);
        int numColumns = getNumColumns();
        if (numColumns > 1) {
            aVar.a(numColumns);
        }
        super.setAdapter(aVar);
    }

    public void setDrawForeground(boolean z) {
        this.c = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getRowHeight() {
        /*
            r4 = this;
            android.widget.ListAdapter r0 = r4.getAdapter()
            r1 = 0
            if (r0 == 0) goto L_0x001c
            boolean r2 = r0 instanceof com.oppo.camera.sticker.ui.FooterGridView.a
            if (r2 == 0) goto L_0x001c
            com.oppo.camera.sticker.ui.FooterGridView$a r0 = (com.oppo.camera.sticker.ui.FooterGridView.a) r0
            android.widget.ListAdapter r2 = r0.getWrappedAdapter()
            if (r2 == 0) goto L_0x001c
            android.widget.ListAdapter r0 = r0.getWrappedAdapter()
            int r0 = r0.getCount()
            goto L_0x001d
        L_0x001c:
            r0 = r1
        L_0x001d:
            if (r0 <= 0) goto L_0x004e
            android.widget.ListAdapter r2 = r4.getAdapter()
            int r0 = r0 + -1
            r3 = 0
            android.view.View r0 = r2.getView(r0, r3, r4)
            if (r0 == 0) goto L_0x004e
            android.view.ViewGroup$LayoutParams r2 = r0.getLayoutParams()
            android.widget.AbsListView$LayoutParams r2 = (android.widget.AbsListView.LayoutParams) r2
            if (r2 != 0) goto L_0x003d
            android.view.ViewGroup$LayoutParams r2 = r4.generateDefaultLayoutParams()
            android.widget.AbsListView$LayoutParams r2 = (android.widget.AbsListView.LayoutParams) r2
            r0.setLayoutParams(r2)
        L_0x003d:
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r1)
            int r2 = r2.height
            int r2 = getChildMeasureSpec(r3, r1, r2)
            r0.measure(r1, r2)
            int r1 = r0.getMeasuredHeight()
        L_0x004e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.ui.FooterGridView.getRowHeight():int");
    }

    private class a implements Filterable, WrapperListAdapter {

        /* renamed from: b  reason: collision with root package name */
        private final DataSetObservable f3678b = new DataSetObservable();
        private BaseAdapter c = null;
        private int d = 1;
        private int e = 0;

        public a(BaseAdapter baseAdapter) {
            this.c = baseAdapter;
        }

        public void a(int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Number of columns must be 1 or more");
            } else if (this.d != i) {
                this.d = i;
                a();
            }
        }

        public void b(int i) {
            this.e = i;
        }

        public void a() {
            this.f3678b.notifyChanged();
        }

        public boolean isEmpty() {
            BaseAdapter baseAdapter = this.c;
            if (baseAdapter != null) {
                return baseAdapter.isEmpty();
            }
            return true;
        }

        public int getCount() {
            BaseAdapter baseAdapter = this.c;
            if (baseAdapter == null || baseAdapter.getCount() <= 0) {
                return 0;
            }
            return this.c.getCount() + (this.d * 2);
        }

        public boolean areAllItemsEnabled() {
            BaseAdapter baseAdapter = this.c;
            if (baseAdapter != null) {
                return baseAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public boolean isEnabled(int i) {
            BaseAdapter baseAdapter = this.c;
            if (baseAdapter == null || i >= baseAdapter.getCount()) {
                return false;
            }
            return this.c.isEnabled(i);
        }

        public Object getItem(int i) {
            BaseAdapter baseAdapter = this.c;
            if (baseAdapter == null || i >= baseAdapter.getCount()) {
                return null;
            }
            return this.c.getItem(i);
        }

        public long getItemId(int i) {
            BaseAdapter baseAdapter = this.c;
            if (baseAdapter != null) {
                return baseAdapter.getItemId(i);
            }
            return -1;
        }

        public boolean hasStableIds() {
            BaseAdapter baseAdapter = this.c;
            if (baseAdapter != null) {
                return baseAdapter.hasStableIds();
            }
            return false;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            BaseAdapter baseAdapter = this.c;
            if (baseAdapter == null) {
                return null;
            }
            if (i < baseAdapter.getCount()) {
                BaseAdapter baseAdapter2 = this.c;
                if (baseAdapter2 instanceof a) {
                    ((a) baseAdapter2).a(FooterGridView.this.f3675a);
                }
                return this.c.getView(i, view, viewGroup);
            }
            if (view == null) {
                view = new View(viewGroup.getContext());
            }
            view.setMinimumHeight(this.e);
            view.setVisibility(4);
            return view;
        }

        public int getItemViewType(int i) {
            BaseAdapter baseAdapter = this.c;
            if (baseAdapter == null) {
                return -1;
            }
            if (i < baseAdapter.getCount()) {
                return this.c.getItemViewType(i);
            }
            return -2;
        }

        public int getViewTypeCount() {
            BaseAdapter baseAdapter = this.c;
            if (baseAdapter != null) {
                return baseAdapter.getViewTypeCount();
            }
            return 0;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.f3678b.registerObserver(dataSetObserver);
            BaseAdapter baseAdapter = this.c;
            if (baseAdapter != null) {
                baseAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.f3678b.unregisterObserver(dataSetObserver);
            BaseAdapter baseAdapter = this.c;
            if (baseAdapter != null) {
                baseAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public Filter getFilter() {
            BaseAdapter baseAdapter = this.c;
            if (baseAdapter instanceof Filterable) {
                return ((Filterable) baseAdapter).getFilter();
            }
            return null;
        }

        public ListAdapter getWrappedAdapter() {
            return this.c;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        e.a("FooterGridView", "onTouchEvent, action: " + motionEvent.getAction() + ", coord: " + motionEvent.getX() + "x" + motionEvent.getY());
        if (!isEnabled()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }
}
