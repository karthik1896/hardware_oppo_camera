package com.oppo.camera.ui.menu;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.RelativeLayout;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.ui.menu.setting.CameraMenuOption;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.List;

public class BasicOptionItemList extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    protected int f4040a = 0;

    /* renamed from: b  reason: collision with root package name */
    protected int f4041b = 0;
    protected int c = 0;
    protected int d = 0;
    protected int e = 0;
    protected int f = 0;
    protected int g = 0;
    protected int h = 0;
    protected int i = 0;
    protected int j = 0;
    protected int k = -1;
    protected int l = 0;
    protected Context m = null;
    protected List<CameraMenuOption> n = null;
    protected ItemClickListener o = null;
    protected OptionItemListListener p = null;
    protected OnPopUpFadeOutAnimationStartListener q;
    protected ViewGroup r = null;
    protected AnimationSet s = null;
    protected AnimationSet t = null;
    protected AnimationSet u = null;
    protected Animation.AnimationListener v = new PopUpFadeInAnimationListener();
    protected Animation.AnimationListener w = new PopUpFadeOutAnimationListener();
    /* access modifiers changed from: private */
    public boolean x = false;

    public interface OnPopUpFadeOutAnimationStartListener {
        void onPopUpFadeOutAnimationStart();
    }

    public interface OptionItemListListener {
        String a();

        void a(CameraMenuOption cameraMenuOption, int i);
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setOptionItemIcon(Bitmap bitmap) {
    }

    public BasicOptionItemList(Context context) {
        super(context);
        this.m = context;
        this.n = new ArrayList();
        this.o = new ItemClickListener();
        this.f4040a = this.m.getResources().getDimensionPixelSize(R.dimen.menu_setting_width);
        this.e = this.m.getResources().getDimensionPixelSize(R.dimen.itemlist_less_than_three_items_margin_left);
        this.f = this.m.getResources().getDimensionPixelSize(R.dimen.itemlist_less_than_two_items_margin_left);
        this.g = this.m.getResources().getDimensionPixelSize(R.dimen.itemlist_more_than_three_items_margin_left);
        this.h = this.m.getResources().getDimensionPixelSize(R.dimen.itemlist_less_than_three_items_padding_right);
        this.i = this.m.getResources().getDimensionPixelSize(R.dimen.itemlist_more_than_three_items_padding_right);
        this.j = this.m.getResources().getDimensionPixelSize(R.dimen.itemlist_min_items_margin);
        this.x = false;
    }

    public void a(View view, int i2, int i3) {
        if (view != null) {
            this.r = (ViewGroup) view.getRootView().findViewById(R.id.camera);
        }
    }

    public void a() {
        List<CameraMenuOption> list = this.n;
        if (list != null) {
            if (list.size() == 3 && getItemsMeasureWidth() <= ((Util.E() - this.e) - this.h) - (this.j * (this.n.size() - 1))) {
                this.f4041b = this.e;
                this.d = this.h;
            } else if (this.n.size() != 2 || getItemsMeasureWidth() > ((Util.E() - this.f) - this.h) - (this.j * (this.n.size() - 1))) {
                this.f4041b = this.g;
                this.d = this.i;
            } else {
                this.f4041b = this.f;
                this.d = this.h;
            }
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams != null) {
            layoutParams.leftMargin = this.f4041b;
            setLayoutParams(layoutParams);
        }
    }

    public boolean a(CameraMenuOption cameraMenuOption) {
        List<CameraMenuOption> list;
        if (cameraMenuOption == null || (list = this.n) == null || list.contains(cameraMenuOption)) {
            return false;
        }
        cameraMenuOption.a((CameraMenuOption.OnItemClickListener) this.o);
        this.n.add(cameraMenuOption);
        cameraMenuOption.a((ViewGroup) this);
        return true;
    }

    public void setDrawShadow(boolean z) {
        List<CameraMenuOption> list = this.n;
        if (list != null) {
            for (CameraMenuOption b2 : list) {
                b2.b(z);
            }
        }
    }

    public boolean a(CameraMenuOption cameraMenuOption, int i2) {
        if (cameraMenuOption == null || this.n.contains(cameraMenuOption)) {
            return false;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 >= this.n.size()) {
            i2 = this.n.size();
        }
        this.n.add(i2, cameraMenuOption);
        cameraMenuOption.a((CameraMenuOption.OnItemClickListener) this.o);
        cameraMenuOption.a((ViewGroup) this);
        return true;
    }

    public void a(int i2) {
        if (i2 < 0 || i2 >= this.n.size()) {
            e.a("BasicOptionItemList", "removeOptionItem(), exception: the index is error, index: " + i2);
            return;
        }
        this.n.remove(i2);
        this.n.get(i2).l();
    }

    public CameraMenuOption b(int i2) {
        if (i2 >= 0 && i2 < this.n.size()) {
            return this.n.get(i2);
        }
        e.a("BasicOptionItemList", "getOptionItem(), exception: the index is error, index: " + i2);
        return null;
    }

    public void a(boolean z, boolean z2) {
        List<CameraMenuOption> list = this.n;
        if (list != null && list.size() >= 1) {
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                this.n.get(i2).a(z, z2);
            }
        }
    }

    public void setSelectItemIndex(int i2) {
        if (i2 >= 0 && i2 != this.k) {
            this.k = i2;
        }
    }

    public void setOptionItemListListener(OptionItemListListener optionItemListListener) {
        this.p = optionItemListListener;
    }

    public void setOnPopUpFadeOutAnimationStartListener(OnPopUpFadeOutAnimationStartListener onPopUpFadeOutAnimationStartListener) {
        this.q = onPopUpFadeOutAnimationStartListener;
    }

    public void a(int i2, boolean z) {
        if (this.l != i2) {
            this.l = i2;
            List<CameraMenuOption> list = this.n;
            if (list != null && !list.isEmpty()) {
                for (CameraMenuOption next : this.n) {
                    if (next != null) {
                        next.a(i2, z);
                    }
                }
            }
        }
    }

    public void c() {
        a();
        setVisibility(0);
        clearAnimation();
        if (this.s == null) {
            b();
        }
        AnimationSet animationSet = this.s;
        if (animationSet != null) {
            startAnimation(animationSet);
        }
    }

    public void d() {
        if (isShown()) {
            clearAnimation();
            if (this.u == null) {
                b();
            }
            AnimationSet animationSet = this.u;
            if (animationSet != null) {
                startAnimation(animationSet);
                this.x = true;
            }
        }
    }

    public void e() {
        clearAnimation();
        setVisibility(8);
        f.d(this.p.a());
        this.x = false;
    }

    public boolean getPopUpWindowState() {
        return isShown();
    }

    public int getItemsMeasureWidth() {
        List<CameraMenuOption> list = this.n;
        int i2 = 0;
        if (list != null && list.size() > 0) {
            for (CameraMenuOption next : this.n) {
                if (next != null) {
                    i2 += next.x();
                }
            }
        }
        return i2;
    }

    public int getItemsMeasureHeight() {
        int y;
        List<CameraMenuOption> list = this.n;
        int i2 = 0;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        for (CameraMenuOption next : this.n) {
            if (next != null && i2 < (y = next.y())) {
                i2 = y;
            }
        }
        return i2 * this.n.size();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        List<CameraMenuOption> list = this.n;
        if (list != null && list.size() > 0) {
            int i6 = 0;
            for (CameraMenuOption next : this.n) {
                if (next != null) {
                    int x2 = next.x();
                    int y = next.y() + i6;
                    next.a(0, i6, x2, y);
                    i6 = y;
                }
            }
        }
    }

    public void f() {
        if (isShown()) {
            clearAnimation();
            setVisibility(8);
        }
        this.x = false;
    }

    public void g() {
        e.a("BasicOptionItemList", "release()");
        if (this.n != null) {
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                CameraMenuOption cameraMenuOption = this.n.get(i2);
                if (cameraMenuOption != null) {
                    cameraMenuOption.l();
                }
            }
            this.n.clear();
            this.n = null;
        }
        removeAllViews();
        ViewGroup viewGroup = this.r;
        if (viewGroup != null) {
            viewGroup.removeView(this);
            this.r = null;
        }
        this.m = null;
        this.p = null;
        this.o = null;
        this.v = null;
        this.w = null;
    }

    private class ItemClickListener implements CameraMenuOption.OnItemClickListener {
        private ItemClickListener() {
        }

        public void a(CameraMenuOption cameraMenuOption) {
            if (BasicOptionItemList.this.n != null && BasicOptionItemList.this.n.size() > 0 && BasicOptionItemList.this.p != null) {
                int indexOf = BasicOptionItemList.this.n.indexOf(cameraMenuOption);
                e.a("BasicOptionItemList", "onItemClick, index: " + indexOf);
                BasicOptionItemList.this.p.a(cameraMenuOption, indexOf);
            }
        }
    }

    protected final class PopUpFadeInAnimationListener implements Animation.AnimationListener {
        public void onAnimationRepeat(Animation animation) {
        }

        protected PopUpFadeInAnimationListener() {
        }

        public void onAnimationEnd(Animation animation) {
            BasicOptionItemList.this.a(true, false);
            if (BasicOptionItemList.this.isShown()) {
                if (BasicOptionItemList.this.p != null) {
                    f.b(BasicOptionItemList.this.p.a());
                }
                if (BasicOptionItemList.this.t != null && !BasicOptionItemList.this.x) {
                    BasicOptionItemList basicOptionItemList = BasicOptionItemList.this;
                    basicOptionItemList.startAnimation(basicOptionItemList.t);
                }
            }
        }

        public void onAnimationStart(Animation animation) {
            BasicOptionItemList.this.a(false, false);
            if (BasicOptionItemList.this.p != null && !BasicOptionItemList.this.x) {
                f.a(BasicOptionItemList.this.p.a());
            }
        }
    }

    protected final class PopUpFadeOutAnimationListener implements Animation.AnimationListener {
        public void onAnimationRepeat(Animation animation) {
        }

        protected PopUpFadeOutAnimationListener() {
        }

        public void onAnimationEnd(Animation animation) {
            BasicOptionItemList.this.a(true, false);
            BasicOptionItemList.this.setVisibility(8);
            boolean unused = BasicOptionItemList.this.x = false;
            if (BasicOptionItemList.this.p != null) {
                f.d(BasicOptionItemList.this.p.a());
            }
        }

        public void onAnimationStart(Animation animation) {
            BasicOptionItemList.this.a(false, false);
            boolean unused = BasicOptionItemList.this.x = true;
            if (BasicOptionItemList.this.p != null) {
                f.c(BasicOptionItemList.this.p.a());
            }
            if (BasicOptionItemList.this.q != null) {
                BasicOptionItemList.this.q.onPopUpFadeOutAnimationStart();
            }
        }
    }
}
