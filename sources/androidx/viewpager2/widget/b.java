package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/* compiled from: CompositeOnPageChangeCallback */
final class b extends ViewPager2.e {

    /* renamed from: a  reason: collision with root package name */
    private final List<ViewPager2.e> f1388a;

    b(int i) {
        this.f1388a = new ArrayList(i);
    }

    /* access modifiers changed from: package-private */
    public void a(ViewPager2.e eVar) {
        this.f1388a.add(eVar);
    }

    /* access modifiers changed from: package-private */
    public void b(ViewPager2.e eVar) {
        this.f1388a.remove(eVar);
    }

    public void onPageScrolled(int i, float f, int i2) {
        try {
            for (ViewPager2.e onPageScrolled : this.f1388a) {
                onPageScrolled.onPageScrolled(i, f, i2);
            }
        } catch (ConcurrentModificationException e) {
            a(e);
        }
    }

    public void onPageSelected(int i) {
        try {
            for (ViewPager2.e onPageSelected : this.f1388a) {
                onPageSelected.onPageSelected(i);
            }
        } catch (ConcurrentModificationException e) {
            a(e);
        }
    }

    public void onPageScrollStateChanged(int i) {
        try {
            for (ViewPager2.e onPageScrollStateChanged : this.f1388a) {
                onPageScrollStateChanged.onPageScrollStateChanged(i);
            }
        } catch (ConcurrentModificationException e) {
            a(e);
        }
    }

    private void a(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
