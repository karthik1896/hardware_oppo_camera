package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* compiled from: PageTransformerAdapter */
final class d extends ViewPager2.e {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayoutManager f1391a;

    /* renamed from: b  reason: collision with root package name */
    private ViewPager2.g f1392b;

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageSelected(int i) {
    }

    d(LinearLayoutManager linearLayoutManager) {
        this.f1391a = linearLayoutManager;
    }

    /* access modifiers changed from: package-private */
    public ViewPager2.g a() {
        return this.f1392b;
    }

    /* access modifiers changed from: package-private */
    public void a(ViewPager2.g gVar) {
        this.f1392b = gVar;
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.f1392b != null) {
            float f2 = -f;
            int i3 = 0;
            while (i3 < this.f1391a.getChildCount()) {
                View childAt = this.f1391a.getChildAt(i3);
                if (childAt != null) {
                    this.f1392b.a(childAt, ((float) (this.f1391a.getPosition(childAt) - i)) + f2);
                    i3++;
                } else {
                    throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[]{Integer.valueOf(i3), Integer.valueOf(this.f1391a.getChildCount())}));
                }
            }
        }
    }
}
