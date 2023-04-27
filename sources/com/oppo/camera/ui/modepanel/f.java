package com.oppo.camera.ui.modepanel;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.a.a.g;
import com.a.a.h;
import com.a.a.j;
import com.oppo.camera.R;
import com.oppo.camera.ui.modepanel.e;
import java.util.ArrayList;

/* compiled from: MoreUIControl */
public class f implements e.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Activity f4307a;

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f4308b;
    private int c;
    private b d;
    /* access modifiers changed from: private */
    public View e = null;
    private RelativeLayout.LayoutParams f;
    /* access modifiers changed from: private */
    public NonFlingRecycleView g = null;
    private e h = null;
    /* access modifiers changed from: private */
    public b i = null;
    /* access modifiers changed from: private */
    public GestureDetector j = null;
    private GestureDetector k = null;
    private boolean l = false;
    /* access modifiers changed from: private */
    public int m;
    /* access modifiers changed from: private */
    public int n;
    private int o = 0;
    private com.a.a.f p;
    /* access modifiers changed from: private */
    public com.a.a.f q;

    /* compiled from: MoreUIControl */
    public interface b {
        void a();

        void a(int i);

        void b();

        void c();
    }

    public f(Activity activity, ViewGroup viewGroup, int i2) {
        this.f4307a = activity;
        this.f4308b = viewGroup;
        this.c = i2;
        this.d = new b(this.f4307a);
        this.m = this.f4307a.getResources().getDimensionPixelSize(R.dimen.more_item_side_spacing);
        this.n = this.f4307a.getResources().getDimensionPixelSize(R.dimen.anim_position);
    }

    private void h(int i2) {
        if (this.e == null || this.f == null) {
            com.oppo.camera.e.a("MoreUIControl", "initMoreModeView");
            this.e = this.f4307a.getLayoutInflater().inflate(R.layout.more_mode_layout, (ViewGroup) null);
            this.e.setVisibility(8);
            this.f = new RelativeLayout.LayoutParams(-1, -1);
            this.h = new e(this.f4307a, this.c);
            this.h.a(this.d.d(i2));
            this.h.a((e.a) this);
            this.h.a(this.c);
            this.g = (NonFlingRecycleView) this.e.findViewById(R.id.more_mode_view);
            this.g.setLayoutManager(new a(this.f4307a, 3));
            this.g.addItemDecoration(new c());
            this.g.addOnItemTouchListener(new RecyclerView.m() {
                public void a(boolean z) {
                }

                public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
                }

                public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
                    if (f.this.j == null) {
                        f fVar = f.this;
                        GestureDetector unused = fVar.j = new GestureDetector(fVar.f4307a, new d());
                    }
                    if (!f.this.k()) {
                        return f.this.j.onTouchEvent(motionEvent);
                    }
                    return true;
                }
            });
            i(this.h.getItemCount());
            this.g.setAdapter(this.h);
            this.e.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return f.this.a(view, motionEvent);
                }
            });
            j();
            this.f4308b.addView(this.e, 2, this.f);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (this.k == null) {
            this.k = new GestureDetector(this.f4307a, new e());
        }
        this.k.onTouchEvent(motionEvent);
        return true;
    }

    /* access modifiers changed from: private */
    public void f() {
        com.a.a.f fVar = this.p;
        if (fVar != null) {
            fVar.a((double) this.n);
        }
    }

    private void g() {
        com.a.a.f fVar = this.p;
        if (fVar != null) {
            fVar.b(0.0d);
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        com.a.a.f fVar = this.q;
        if (fVar != null) {
            fVar.a(0.0d);
        }
    }

    private void i() {
        com.a.a.f fVar = this.q;
        if (fVar != null) {
            fVar.b((double) this.n);
        }
    }

    /* access modifiers changed from: private */
    public void b(float f2) {
        this.g.setTranslationX(f2);
        this.e.setAlpha(1.0f - (f2 / ((float) this.n)));
    }

    private void j() {
        if (this.p == null || this.q == null) {
            g b2 = g.b(5.0d, 10.0d);
            this.p = j.c().b().a(b2).a((double) this.n).a((h) new com.a.a.e() {
                public void a(com.a.a.f fVar) {
                    f.this.b((float) fVar.c());
                }

                public void c(com.a.a.f fVar) {
                    super.c(fVar);
                    f.this.h();
                }
            });
            this.q = j.c().b().a(b2).a(0.0d).a((h) new com.a.a.e() {
                public void a(com.a.a.f fVar) {
                    float c = (float) fVar.c();
                    f.this.b(c);
                    if (((float) f.this.n) == c) {
                        com.oppo.camera.e.a("MoreUIControl", "initSpring, mAnimExit, onSpringUpdate, Set the mMoreView status to Gone.");
                        if (f.this.q != null && !f.this.q.i()) {
                            f.this.q.j();
                        }
                        f.this.e.setVisibility(8);
                    }
                }

                public void c(com.a.a.f fVar) {
                    super.c(fVar);
                    f.this.f();
                }
            });
        }
    }

    public void b(int i2) {
        this.d.a(i2);
        a();
    }

    public void c(int i2) {
        this.d.b(i2);
        a();
    }

    public void a() {
        if (d()) {
            com.oppo.camera.e.a("MoreUIControl", "onMoreModeDataChange, mCameraId: " + this.o);
            this.h.a(this.d.d(this.o));
            this.h.notifyDataSetChanged();
            i(this.h.getItemCount());
        }
    }

    public void a(boolean z) {
        this.l = z;
    }

    public boolean b() {
        com.a.a.f fVar = this.p;
        if (fVar == null || this.q == null) {
            return false;
        }
        if (!fVar.i() || !this.q.i()) {
            return true;
        }
        return false;
    }

    public boolean c() {
        com.a.a.f fVar = this.p;
        return fVar != null && !fVar.i();
    }

    public void d(int i2) {
        this.o = i2;
        h(i2);
        if (d()) {
            com.a.a.f fVar = this.q;
            if (fVar == null || fVar.i()) {
                com.oppo.camera.e.a("MoreUIControl", "showMoreView, MoreMode has been shown");
                return;
            }
            com.oppo.camera.e.a("MoreUIControl", "showMoreView, MoreMode is executing the end animation");
            this.q.j();
            this.e.setVisibility(8);
        }
        this.h.b(this.c);
        this.e.setVisibility(0);
        g();
        h();
        if (this.l) {
            this.l = false;
            this.h.a(this.d.d(i2));
            this.h.notifyDataSetChanged();
            i(this.h.getItemCount());
        }
    }

    public boolean b(boolean z) {
        if (!d()) {
            return false;
        }
        com.a.a.f fVar = this.p;
        if (fVar != null && !fVar.i()) {
            com.oppo.camera.e.a("MoreUIControl", "hideMoreView, MoreMode is executing the enter animation");
            this.p.j();
        }
        com.oppo.camera.e.e("MoreUIControl", "hideMoreView");
        if (z) {
            i();
            return true;
        }
        f();
        this.e.setVisibility(8);
        return true;
    }

    public void e(int i2) {
        Drawable background;
        View view = this.e;
        if (view != null && (background = view.getBackground()) != null) {
            background.setAlpha(i2);
            this.e.setBackground(background);
        }
    }

    public void a(float f2) {
        View view = this.e;
        if (view != null) {
            view.setAlpha(f2);
        }
    }

    public boolean d() {
        View view;
        ViewGroup viewGroup = this.f4308b;
        if (viewGroup == null || (view = this.e) == null || viewGroup.indexOfChild(view) == -1 || this.e.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void f(int i2) {
        this.c = i2;
        e eVar = this.h;
        if (eVar != null) {
            eVar.a(i2);
        }
    }

    public void a(b bVar) {
        this.i = bVar;
    }

    public void e() {
        com.a.a.f fVar = this.p;
        if (fVar != null) {
            fVar.a();
            this.p = null;
        }
        com.a.a.f fVar2 = this.q;
        if (fVar2 != null) {
            fVar2.a();
            this.q = null;
        }
    }

    public void a(int i2) {
        com.oppo.camera.e.a("MoreUIControl", "onClick, more itemId: " + i2);
        b bVar = this.i;
        if (bVar != null) {
            bVar.a(i2);
        }
    }

    /* access modifiers changed from: private */
    public boolean k() {
        com.a.a.f fVar = this.q;
        if (fVar != null) {
            return !fVar.i();
        }
        return false;
    }

    /* compiled from: MoreUIControl */
    private class d extends GestureDetector.SimpleOnGestureListener {
        private d() {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (f.this.i == null || f.this.g.findChildViewUnder(motionEvent.getX(), motionEvent.getY()) != null) {
                return false;
            }
            com.oppo.camera.e.a("MoreUIControl", "MoreMenuGestureListener, onSingleTapUp, no item clicked,go back to last index");
            f.this.i.c();
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (f.this.i == null || Math.abs(motionEvent.getY() - motionEvent2.getY()) >= Math.abs(motionEvent.getX() - motionEvent2.getX())) {
                return false;
            }
            if (Float.compare(motionEvent2.getX() - motionEvent.getX(), 100.0f) > 0 || (Float.compare(f, 200.0f) > 0 && motionEvent2.getX() - motionEvent.getX() > 0.0f)) {
                com.oppo.camera.e.a("MoreUIControl", "MoreMenuGestureListener, onFling, slide to previous mode");
                f.this.i.a();
                return true;
            } else if (Float.compare(motionEvent.getX() - motionEvent2.getX(), 100.0f) <= 0 && (Float.compare(f, 200.0f) <= 0 || motionEvent.getX() - motionEvent2.getX() <= 0.0f)) {
                return false;
            } else {
                com.oppo.camera.e.a("MoreUIControl", "MoreMenuGestureListener, onFling, slide to next mode");
                f.this.i.b();
                return true;
            }
        }
    }

    public void a(int i2, int i3) {
        b(i2, i3);
    }

    public void g(int i2) {
        b(i2, -1);
    }

    private void b(int i2, int i3) {
        ArrayList<a> d2 = this.d.d(this.o);
        int i4 = 0;
        while (i4 < d2.size()) {
            a aVar = d2.get(i4);
            if (aVar == null || i2 != aVar.b()) {
                i4++;
            } else {
                aVar.a(i3);
                e eVar = this.h;
                if (eVar != null && this.g != null) {
                    eVar.a(d2);
                    this.g.setAdapter(this.h);
                    i(d2.size());
                    return;
                }
                return;
            }
        }
    }

    /* compiled from: MoreUIControl */
    private class e extends GestureDetector.SimpleOnGestureListener {
        private e() {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (f.this.i == null) {
                return false;
            }
            com.oppo.camera.e.a("MoreUIControl", "MoreViewGestureListener, onSingleTapUp, go back to last index");
            f.this.i.c();
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (f.this.i == null || Math.abs(motionEvent.getY() - motionEvent2.getY()) >= Math.abs(motionEvent.getX() - motionEvent2.getX())) {
                return false;
            }
            if (Float.compare(motionEvent2.getX() - motionEvent.getX(), 100.0f) > 0 || (Float.compare(f, 200.0f) > 0 && motionEvent2.getX() - motionEvent.getX() > 0.0f)) {
                com.oppo.camera.e.a("MoreUIControl", "MoreViewGestureListener, onFling, slide to previous mode");
                f.this.i.a();
                return true;
            } else if (Float.compare(motionEvent.getX() - motionEvent2.getX(), 100.0f) <= 0 && (Float.compare(f, 200.0f) <= 0 || motionEvent.getX() - motionEvent2.getX() <= 0.0f)) {
                return false;
            } else {
                com.oppo.camera.e.a("MoreUIControl", "MoreViewGestureListener, onFling, slide to next mode");
                f.this.i.b();
                return true;
            }
        }
    }

    /* compiled from: MoreUIControl */
    private class a extends GridLayoutManager {
        public a(Context context, int i2) {
            super(context, i2);
        }

        public void onMeasure(RecyclerView.p pVar, RecyclerView.t tVar, int i2, int i3) {
            View c;
            super.onMeasure(pVar, tVar, i2, i3);
            int measuredWidth = f.this.g.getMeasuredWidth();
            int measuredHeight = f.this.g.getMeasuredHeight();
            int e = tVar.e();
            int i4 = 0;
            for (int i5 = 0; i5 < e; i5++) {
                if (i4 < measuredHeight && i5 % a() == 0 && (c = pVar.c(i5)) != null) {
                    RecyclerView.j jVar = (RecyclerView.j) c.getLayoutParams();
                    c.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), jVar.width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), jVar.height));
                    i4 += c.getMeasuredHeight() + jVar.bottomMargin + jVar.topMargin;
                }
            }
            setMeasuredDimension(measuredWidth, Math.min(measuredHeight, i4));
        }
    }

    /* compiled from: MoreUIControl */
    private class c extends RecyclerView.h {
        private c() {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t tVar) {
            super.getItemOffsets(rect, view, recyclerView, tVar);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view) % 3;
            rect.left = (f.this.m * childAdapterPosition) / 3;
            rect.right = f.this.m - (((childAdapterPosition + 1) * f.this.m) / 3);
        }
    }

    private void i(int i2) {
        int i3;
        if (i2 <= 6) {
            i3 = this.f4307a.getResources().getDimensionPixelSize(R.dimen.more_recycle_row2_margin_screen_top);
        } else if (i2 > 6 && i2 <= 9) {
            i3 = this.f4307a.getResources().getDimensionPixelSize(R.dimen.more_recycle_row3_margin_screen_top);
        } else if (i2 <= 9 || i2 > 12) {
            i3 = (i2 <= 12 || i2 > 15) ? 0 : this.f4307a.getResources().getDimensionPixelSize(R.dimen.more_recycle_row5_margin_screen_top);
        } else {
            i3 = this.f4307a.getResources().getDimensionPixelSize(R.dimen.more_recycle_row4_margin_screen_top);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.g.getLayoutParams();
        layoutParams.topMargin = i3;
        this.g.setLayoutParams(layoutParams);
    }
}
