package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: OrientationHelper */
public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    protected final RecyclerView.i f1146a;

    /* renamed from: b  reason: collision with root package name */
    final Rect f1147b;
    private int c;

    public abstract int a(View view);

    public abstract void a(int i);

    public abstract int b(View view);

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    private n(RecyclerView.i iVar) {
        this.c = Integer.MIN_VALUE;
        this.f1147b = new Rect();
        this.f1146a = iVar;
    }

    public RecyclerView.i a() {
        return this.f1146a;
    }

    public void b() {
        this.c = g();
    }

    public int c() {
        if (Integer.MIN_VALUE == this.c) {
            return 0;
        }
        return g() - this.c;
    }

    public static n a(RecyclerView.i iVar, int i) {
        if (i == 0) {
            return a(iVar);
        }
        if (i == 1) {
            return b(iVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static n a(RecyclerView.i iVar) {
        return new n(iVar) {
            public int e() {
                return this.f1146a.getWidth() - this.f1146a.getPaddingRight();
            }

            public int f() {
                return this.f1146a.getWidth();
            }

            public void a(int i) {
                this.f1146a.offsetChildrenHorizontal(i);
            }

            public int d() {
                return this.f1146a.getPaddingLeft();
            }

            public int e(View view) {
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                return this.f1146a.getDecoratedMeasuredWidth(view) + jVar.leftMargin + jVar.rightMargin;
            }

            public int f(View view) {
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                return this.f1146a.getDecoratedMeasuredHeight(view) + jVar.topMargin + jVar.bottomMargin;
            }

            public int b(View view) {
                return this.f1146a.getDecoratedRight(view) + ((RecyclerView.j) view.getLayoutParams()).rightMargin;
            }

            public int a(View view) {
                return this.f1146a.getDecoratedLeft(view) - ((RecyclerView.j) view.getLayoutParams()).leftMargin;
            }

            public int c(View view) {
                this.f1146a.getTransformedBoundingBox(view, true, this.f1147b);
                return this.f1147b.right;
            }

            public int d(View view) {
                this.f1146a.getTransformedBoundingBox(view, true, this.f1147b);
                return this.f1147b.left;
            }

            public int g() {
                return (this.f1146a.getWidth() - this.f1146a.getPaddingLeft()) - this.f1146a.getPaddingRight();
            }

            public int h() {
                return this.f1146a.getPaddingRight();
            }

            public int i() {
                return this.f1146a.getWidthMode();
            }

            public int j() {
                return this.f1146a.getHeightMode();
            }
        };
    }

    public static n b(RecyclerView.i iVar) {
        return new n(iVar) {
            public int e() {
                return this.f1146a.getHeight() - this.f1146a.getPaddingBottom();
            }

            public int f() {
                return this.f1146a.getHeight();
            }

            public void a(int i) {
                this.f1146a.offsetChildrenVertical(i);
            }

            public int d() {
                return this.f1146a.getPaddingTop();
            }

            public int e(View view) {
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                return this.f1146a.getDecoratedMeasuredHeight(view) + jVar.topMargin + jVar.bottomMargin;
            }

            public int f(View view) {
                RecyclerView.j jVar = (RecyclerView.j) view.getLayoutParams();
                return this.f1146a.getDecoratedMeasuredWidth(view) + jVar.leftMargin + jVar.rightMargin;
            }

            public int b(View view) {
                return this.f1146a.getDecoratedBottom(view) + ((RecyclerView.j) view.getLayoutParams()).bottomMargin;
            }

            public int a(View view) {
                return this.f1146a.getDecoratedTop(view) - ((RecyclerView.j) view.getLayoutParams()).topMargin;
            }

            public int c(View view) {
                this.f1146a.getTransformedBoundingBox(view, true, this.f1147b);
                return this.f1147b.bottom;
            }

            public int d(View view) {
                this.f1146a.getTransformedBoundingBox(view, true, this.f1147b);
                return this.f1147b.top;
            }

            public int g() {
                return (this.f1146a.getHeight() - this.f1146a.getPaddingTop()) - this.f1146a.getPaddingBottom();
            }

            public int h() {
                return this.f1146a.getPaddingBottom();
            }

            public int i() {
                return this.f1146a.getHeightMode();
            }

            public int j() {
                return this.f1146a.getWidthMode();
            }
        };
    }
}
