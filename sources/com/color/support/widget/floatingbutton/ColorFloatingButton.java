package com.color.support.widget.floatingbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.g.v;
import androidx.dynamicanimation.a.e;
import androidx.recyclerview.widget.RecyclerView;
import color.support.v7.appcompat.R;
import com.color.support.d.k;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ColorFloatingButton extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2169a = "ColorFloatingButton";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public float f2170b;
    /* access modifiers changed from: private */
    public final InstanceState c;
    private List<a> d;
    private Drawable e;
    /* access modifiers changed from: private */
    public ShapeableImageView f;
    private float g;
    private int h;
    private int i;
    /* access modifiers changed from: private */
    public Runnable j;
    /* access modifiers changed from: private */
    public ValueAnimator k;
    private PathInterpolator l;
    private PathInterpolator m;
    private PathInterpolator n;
    private PathInterpolator o;
    private PathInterpolator p;
    private PathInterpolator q;
    private PathInterpolator r;
    private b s;
    private a t;
    /* access modifiers changed from: private */
    public a u;
    private a v;

    public interface a {
        boolean a(ColorFloatingButtonItem colorFloatingButtonItem);
    }

    public interface b {
        void a(boolean z);

        boolean a();
    }

    /* access modifiers changed from: private */
    public void a(FloatingActionButton.OnVisibilityChangedListener onVisibilityChangedListener) {
        if (c()) {
            b();
            v.n(this.f).c(0.0f).a(0).c();
        }
    }

    public Collection<a> a(Collection<ColorFloatingButtonItem> collection) {
        ArrayList arrayList = new ArrayList();
        for (ColorFloatingButtonItem a2 : collection) {
            arrayList.add(a(a2));
        }
        return arrayList;
    }

    public a a(ColorFloatingButtonItem colorFloatingButtonItem) {
        return a(colorFloatingButtonItem, this.d.size());
    }

    public a a(ColorFloatingButtonItem colorFloatingButtonItem, int i2) {
        return a(colorFloatingButtonItem, i2, true);
    }

    public a a(ColorFloatingButtonItem colorFloatingButtonItem, int i2, boolean z) {
        a c2 = c(colorFloatingButtonItem.getColorFloatingButtonItemLocation());
        if (c2 != null) {
            return a(c2.getColorFloatingButtonItem(), colorFloatingButtonItem);
        }
        a createFabWithLabelView = colorFloatingButtonItem.createFabWithLabelView(getContext());
        int i3 = 1;
        if (getOrientation() == 1) {
            i3 = 0;
        }
        createFabWithLabelView.setOrientation(i3);
        createFabWithLabelView.setOnActionSelectedListener(this.v);
        int b2 = b(i2);
        if (i2 == 0) {
            createFabWithLabelView.setPaddingRelative(getPaddingStart(), getPaddingTop(), getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.color_floating_button_item_first_bottom_margin));
            addView(createFabWithLabelView, b2);
        } else {
            createFabWithLabelView.setPaddingRelative(getPaddingStart(), getPaddingTop(), getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.color_floating_button_item_normal_bottom_margin));
            addView(createFabWithLabelView, b2);
        }
        this.d.add(i2, createFabWithLabelView);
        a(createFabWithLabelView, 0, i2, 300, false);
        return createFabWithLabelView;
    }

    public a a(ColorFloatingButtonItem colorFloatingButtonItem, ColorFloatingButtonItem colorFloatingButtonItem2) {
        a c2;
        int indexOf;
        if (colorFloatingButtonItem == null || (c2 = c(colorFloatingButtonItem.getColorFloatingButtonItemLocation())) == null || (indexOf = this.d.indexOf(c2)) < 0) {
            return null;
        }
        a(c(colorFloatingButtonItem2.getColorFloatingButtonItemLocation()), (Iterator<a>) null, false);
        a(c(colorFloatingButtonItem.getColorFloatingButtonItemLocation()), (Iterator<a>) null, false);
        return a(colorFloatingButtonItem2, indexOf, false);
    }

    private ColorFloatingButtonItem a(a aVar, Iterator<a> it, boolean z) {
        if (aVar == null) {
            return null;
        }
        ColorFloatingButtonItem colorFloatingButtonItem = aVar.getColorFloatingButtonItem();
        if (it != null) {
            it.remove();
        } else {
            this.d.remove(aVar);
        }
        removeView(aVar);
        return colorFloatingButtonItem;
    }

    public ArrayList<ColorFloatingButtonItem> getActionItems() {
        ArrayList<ColorFloatingButtonItem> arrayList = new ArrayList<>(this.d.size());
        for (a colorFloatingButtonItem : this.d) {
            arrayList.add(colorFloatingButtonItem.getColorFloatingButtonItem());
        }
        return arrayList;
    }

    public void setOnActionSelectedListener(a aVar) {
        this.t = aVar;
        if (aVar != null) {
            this.u = this.t;
        }
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            this.d.get(i2).setOnActionSelectedListener(this.v);
        }
    }

    public void setOnChangeListener(b bVar) {
        this.s = bVar;
    }

    public void a() {
        a(true, true, 300, false);
    }

    public void b() {
        a(false, true, 300, false);
    }

    public void a(boolean z, int i2, boolean z2) {
        a(false, z, i2, z2);
    }

    public boolean c() {
        return this.c.mColorFloatingButtonMenuIsOpen;
    }

    public boolean d() {
        return this.c.mColorFloatingButtonAnimationIsRun;
    }

    public ShapeableImageView getMainColorFloatingButton() {
        return this.f;
    }

    public void setMainFabDrawable(Drawable drawable) {
        this.e = drawable;
        a(false, false);
    }

    public ColorStateList getMainColorFloatingButtonBackgroundColor() {
        return this.c.mMainColorFloatingButtonBackgroundColor;
    }

    public void setMainColorFloatingButtonBackgroundColor(ColorStateList colorStateList) {
        ColorStateList unused = this.c.mMainColorFloatingButtonBackgroundColor = colorStateList;
        j();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setColorFloatingButtonExpandEnable(boolean z) {
        if (z) {
            this.f.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        ColorFloatingButton.this.g();
                        return false;
                    } else if (motionEvent.getAction() == 1) {
                        ColorFloatingButton.this.h();
                        return false;
                    } else if (motionEvent.getAction() != 3) {
                        return false;
                    } else {
                        ColorFloatingButton.this.h();
                        return false;
                    }
                }
            });
        } else {
            this.f.setOnTouchListener((View.OnTouchListener) null);
        }
        this.f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ColorFloatingButton.this.f();
            }
        });
    }

    /* access modifiers changed from: private */
    public void f() {
        if (c()) {
            b bVar = this.s;
            if (bVar == null || !bVar.a()) {
                b();
                return;
            }
            return;
        }
        a();
    }

    /* access modifiers changed from: private */
    public void g() {
        clearAnimation();
        i();
        ScaleAnimation a2 = k.a(this.f);
        this.k = k.a();
        this.k.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = ColorFloatingButton.this.f2170b = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (ColorFloatingButton.this.f2170b >= 0.98f) {
                    float unused2 = ColorFloatingButton.this.f2170b = 0.98f;
                }
            }
        });
        a2.setAnimationListener(new com.color.support.widget.slideselect.a() {
            public void onAnimationStart(Animation animation) {
                ColorFloatingButton.this.k.start();
            }
        });
        this.f.startAnimation(a2);
    }

    /* access modifiers changed from: private */
    public void h() {
        clearAnimation();
        i();
        ShapeableImageView shapeableImageView = this.f;
        shapeableImageView.startAnimation(k.a(shapeableImageView, this.f2170b));
    }

    private void i() {
        ValueAnimator valueAnimator = this.k;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.k.cancel();
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        ArrayList unused = this.c.mColorFloatingButtonItems = getActionItems();
        bundle.putParcelable(InstanceState.class.getName(), this.c);
        bundle.putParcelable("superState", super.onSaveInstanceState());
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            InstanceState instanceState = (InstanceState) bundle.getParcelable(InstanceState.class.getName());
            if (!(instanceState == null || instanceState.mColorFloatingButtonItems == null || instanceState.mColorFloatingButtonItems.isEmpty())) {
                setMainColorFloatingButtonBackgroundColor(instanceState.mMainColorFloatingButtonBackgroundColor);
                a((Collection<ColorFloatingButtonItem>) instanceState.mColorFloatingButtonItems);
                a(instanceState.mColorFloatingButtonMenuIsOpen, false, 300, false);
            }
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        getMainColorFloatingButton().setEnabled(z);
    }

    private int b(int i2) {
        return this.d.size() - i2;
    }

    private void a(boolean z, boolean z2, int i2, boolean z3) {
        if (z && this.d.isEmpty()) {
            z = false;
            b bVar = this.s;
            if (bVar != null) {
                bVar.a();
            }
        }
        if (c() != z) {
            if (!d()) {
                b(z, z2, i2, z3);
                a(z2, z3);
                j();
            }
            b bVar2 = this.s;
            if (bVar2 != null) {
                bVar2.a(z);
            }
        }
    }

    private void a(boolean z, boolean z2) {
        if (c()) {
            a((View) this.f, 45.0f, z2);
            return;
        }
        a(z2).start();
        Drawable drawable = this.e;
        if (drawable != null) {
            this.f.setImageDrawable(drawable);
        }
    }

    private void j() {
        ColorStateList mainColorFloatingButtonBackgroundColor = getMainColorFloatingButtonBackgroundColor();
        if (mainColorFloatingButtonBackgroundColor != ColorStateList.valueOf(Integer.MIN_VALUE)) {
            this.f.setBackgroundTintList(mainColorFloatingButtonBackgroundColor);
        } else {
            this.f.setBackgroundTintList(getResources().getColorStateList(R.color.color_floating_button_label_background_color));
        }
    }

    private a c(int i2) {
        for (a next : this.d) {
            if (next.getId() == i2) {
                return next;
            }
        }
        return null;
    }

    private a d(int i2) {
        if (i2 < this.d.size()) {
            return this.d.get(i2);
        }
        return null;
    }

    private void b(boolean z, boolean z2, int i2, boolean z3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        int size = this.d.size();
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = (size - 1) - i3;
                a aVar = this.d.get(i4);
                if (this.h != 0) {
                    if (b(getContext(), (float) ((i4 * 72) + 88)) + marginLayoutParams.bottomMargin + this.f.getHeight() > this.h + this.i) {
                        aVar.setVisibility(8);
                        if (z2) {
                            a(aVar, i3 * 50, i4, 8);
                        }
                    } else {
                        aVar.setVisibility(0);
                        if (z2) {
                            a(aVar, i3 * 50, i4, 0);
                        }
                    }
                } else if (z2) {
                    a(aVar, i3 * 50, i4, 0);
                }
            }
            boolean unused = this.c.mColorFloatingButtonMenuIsOpen = true;
            return;
        }
        for (int i5 = 0; i5 < size; i5++) {
            a aVar2 = this.d.get(i5);
            if (z2) {
                a(aVar2, i5 * 50, i5, i2, z3);
            }
        }
        boolean unused2 = this.c.mColorFloatingButtonMenuIsOpen = false;
    }

    public void a(int i2) {
        v.n(this.f).b();
        this.f.setVisibility(0);
        this.f.animate().translationY(0.0f).setInterpolator(this.m).setDuration((long) i2).setListener(new Animator.AnimatorListener() {
            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                boolean unused = ColorFloatingButton.this.c.mColorFloatingButtonAnimationIsRun = true;
                ColorFloatingButton colorFloatingButton = ColorFloatingButton.this;
                colorFloatingButton.removeCallbacks(colorFloatingButton.j);
            }

            public void onAnimationEnd(Animator animator) {
                boolean unused = ColorFloatingButton.this.c.mColorFloatingButtonAnimationIsRun = false;
            }

            public void onAnimationCancel(Animator animator) {
                ColorFloatingButton colorFloatingButton = ColorFloatingButton.this;
                colorFloatingButton.removeCallbacks(colorFloatingButton.j);
            }
        });
    }

    public ObjectAnimator e() {
        v.n(this.f).b();
        int i2 = c() ? 150 : 140;
        int i3 = ((ViewGroup.MarginLayoutParams) getLayoutParams()).bottomMargin;
        ShapeableImageView shapeableImageView = this.f;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(shapeableImageView, "translationY", new float[]{(float) (i3 + shapeableImageView.getHeight())});
        ofFloat.setInterpolator(this.l);
        ofFloat.setDuration((long) i2);
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                boolean unused = ColorFloatingButton.this.c.mColorFloatingButtonAnimationIsRun = true;
                ColorFloatingButton colorFloatingButton = ColorFloatingButton.this;
                colorFloatingButton.postDelayed(colorFloatingButton.j, 5000);
            }

            public void onAnimationEnd(Animator animator) {
                ColorFloatingButton.this.f.setVisibility(0);
                boolean unused = ColorFloatingButton.this.c.mColorFloatingButtonAnimationIsRun = false;
            }

            public void onAnimationCancel(Animator animator) {
                ColorFloatingButton colorFloatingButton = ColorFloatingButton.this;
                colorFloatingButton.removeCallbacks(colorFloatingButton.j);
                ColorFloatingButton.this.f.setVisibility(8);
            }
        });
        return ofFloat;
    }

    private void a(a aVar, int i2, int i3, int i4) {
        AnimatorSet animatorSet = new AnimatorSet();
        a aVar2 = aVar;
        final e eVar = new e(aVar, androidx.dynamicanimation.a.b.f794b, 0.0f);
        eVar.e().a(500.0f);
        eVar.e().b(0.8f);
        eVar.a(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.getChildColorFloatingButton(), "scaleX", new float[]{0.6f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.getChildColorFloatingButton(), "scaleY", new float[]{0.6f, 1.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(aVar.getColorFloatingButtonLabelBackground(), "scaleX", new float[]{0.6f, 1.0f});
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(aVar.getColorFloatingButtonLabelBackground(), "scaleY", new float[]{0.6f, 1.0f});
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(aVar.getChildColorFloatingButton(), "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(aVar.getColorFloatingButtonLabelBackground(), "alpha", new float[]{0.0f, 1.0f});
        ofFloat6.setInterpolator(this.n);
        ofFloat6.setDuration(350);
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat5, ofFloat3, ofFloat4});
        animatorSet.setInterpolator(this.n);
        animatorSet.setDuration(300);
        animatorSet.setStartDelay((long) i2);
        if (aVar.getColorFloatingButtonLabelText().getText() != "") {
            if (k()) {
                aVar.getColorFloatingButtonLabelBackground().setPivotX(0.0f);
                aVar.getColorFloatingButtonLabelBackground().setPivotY(0.0f);
            } else {
                aVar.getColorFloatingButtonLabelBackground().setPivotX((float) aVar.getColorFloatingButtonLabelBackground().getWidth());
                aVar.getColorFloatingButtonLabelBackground().setPivotY(0.0f);
            }
        }
        final int i5 = i3;
        final ObjectAnimator objectAnimator = ofFloat6;
        final a aVar3 = aVar;
        final int i6 = i4;
        animatorSet.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                if (ColorFloatingButton.this.f(i5)) {
                    boolean unused = ColorFloatingButton.this.c.mColorFloatingButtonAnimationIsRun = true;
                    ColorFloatingButton.this.setOnActionSelectedListener((a) null);
                }
                objectAnimator.start();
                eVar.e(0.0f);
                aVar3.setVisibility(i6);
            }

            public void onAnimationEnd(Animator animator) {
                if (ColorFloatingButton.this.e(i5)) {
                    boolean unused = ColorFloatingButton.this.c.mColorFloatingButtonAnimationIsRun = false;
                    ColorFloatingButton colorFloatingButton = ColorFloatingButton.this;
                    colorFloatingButton.setOnActionSelectedListener(colorFloatingButton.u);
                }
            }
        });
        animatorSet.start();
    }

    private void a(a aVar, int i2, int i3, int i4, boolean z) {
        int i5;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        if (z) {
            i5 = marginLayoutParams.bottomMargin + this.f.getHeight() + b(getContext(), (float) ((i3 * 72) + 88));
        } else {
            i5 = b(getContext(), (float) ((i3 * 72) + 88));
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar, "translationY", new float[]{(float) i5});
        ofFloat.setStartDelay((long) i2);
        ofFloat.setDuration((long) i4);
        ofFloat.setInterpolator(this.o);
        if (aVar.getColorFloatingButtonLabelText().getText() != "") {
            if (k()) {
                aVar.getColorFloatingButtonLabelBackground().setPivotX(0.0f);
                aVar.getColorFloatingButtonLabelBackground().setPivotY((float) aVar.getColorFloatingButtonLabelBackground().getHeight());
            } else {
                aVar.getColorFloatingButtonLabelBackground().setPivotX((float) aVar.getColorFloatingButtonLabelBackground().getWidth());
                aVar.getColorFloatingButtonLabelBackground().setPivotY((float) aVar.getColorFloatingButtonLabelBackground().getHeight());
            }
        }
        final int i6 = i3;
        final boolean z2 = z;
        final a aVar2 = aVar;
        final int i7 = i4;
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                if (ColorFloatingButton.this.e(i6)) {
                    boolean unused = ColorFloatingButton.this.c.mColorFloatingButtonAnimationIsRun = true;
                    ColorFloatingButton.this.setOnActionSelectedListener((a) null);
                }
                if (z2) {
                    ColorFloatingButton.this.a(aVar2, i6, i7, true);
                } else {
                    ColorFloatingButton.this.a(aVar2, i6, i7, false);
                }
            }

            public void onAnimationEnd(Animator animator) {
                aVar2.setTranslationY((float) ColorFloatingButton.b(ColorFloatingButton.this.getContext(), (float) ((i6 * 72) + 88)));
                aVar2.getChildColorFloatingButton().setPivotX(((float) aVar2.getChildColorFloatingButton().getWidth()) / 2.0f);
                aVar2.getChildColorFloatingButton().setPivotY(((float) aVar2.getChildColorFloatingButton().getHeight()) / 2.0f);
                a aVar = aVar2;
                aVar.setPivotX((float) aVar.getWidth());
                a aVar2 = aVar2;
                aVar2.setPivotY((float) aVar2.getHeight());
                if (ColorFloatingButton.this.f(i6)) {
                    boolean unused = ColorFloatingButton.this.c.mColorFloatingButtonAnimationIsRun = false;
                }
            }
        });
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    public void a(a aVar, int i2, int i3, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.getChildColorFloatingButton(), "scaleX", new float[]{1.0f, 0.6f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar.getChildColorFloatingButton(), "scaleY", new float[]{1.0f, 0.6f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(aVar.getColorFloatingButtonLabelBackground(), "scaleX", new float[]{1.0f, 0.6f});
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(aVar.getColorFloatingButtonLabelBackground(), "scaleY", new float[]{1.0f, 0.6f});
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(aVar.getChildColorFloatingButton(), "alpha", new float[]{1.0f, 0.0f});
        final ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(aVar.getColorFloatingButtonLabelBackground(), "alpha", new float[]{1.0f, 0.0f});
        ofFloat6.setInterpolator(this.p);
        ofFloat6.setDuration(200);
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat5, ofFloat4, ofFloat3});
        animatorSet.setInterpolator(this.o);
        animatorSet.setDuration((long) i3);
        animatorSet.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                ofFloat6.start();
            }
        });
        animatorSet.start();
    }

    /* access modifiers changed from: private */
    public boolean e(int i2) {
        a d2 = d(i2);
        if (d2 == null || indexOfChild(d2) != this.d.size() - 1) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean f(int i2) {
        a d2 = d(i2);
        if (d2 == null || indexOfChild(d2) != 0) {
            return false;
        }
        return true;
    }

    public void a(View view, float f2, boolean z) {
        this.g = f2;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f, "rotation", new float[]{0.0f, f2});
        ofFloat.setInterpolator(this.q);
        ofFloat.setDuration(z ? 250 : 300);
        ofFloat.start();
    }

    public ObjectAnimator a(boolean z) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f, "rotation", new float[]{this.g, 0.0f});
        ofFloat.setInterpolator(this.r);
        ofFloat.setDuration(z ? 250 : 300);
        return ofFloat;
    }

    private boolean k() {
        return getLayoutDirection() == 1;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    private static class InstanceState implements Parcelable {
        public static final Parcelable.Creator<InstanceState> CREATOR = new Parcelable.Creator<InstanceState>() {
            /* renamed from: a */
            public InstanceState createFromParcel(Parcel parcel) {
                return new InstanceState(parcel);
            }

            /* renamed from: a */
            public InstanceState[] newArray(int i) {
                return new InstanceState[i];
            }
        };
        /* access modifiers changed from: private */
        public boolean mColorFloatingButtonAnimationIsRun = false;
        /* access modifiers changed from: private */
        public ArrayList<ColorFloatingButtonItem> mColorFloatingButtonItems = new ArrayList<>();
        /* access modifiers changed from: private */
        public boolean mColorFloatingButtonMenuIsOpen = false;
        /* access modifiers changed from: private */
        public ColorStateList mMainColorFloatingButtonBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
        private boolean mUseReverseAnimationOnClose = false;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeByte(this.mColorFloatingButtonMenuIsOpen ? (byte) 1 : 0);
            parcel.writeByte(this.mColorFloatingButtonAnimationIsRun ? (byte) 1 : 0);
            parcel.writeByte(this.mUseReverseAnimationOnClose ? (byte) 1 : 0);
            parcel.writeTypedList(this.mColorFloatingButtonItems);
        }

        public InstanceState() {
        }

        protected InstanceState(Parcel parcel) {
            boolean z = false;
            this.mColorFloatingButtonMenuIsOpen = parcel.readByte() != 0;
            this.mColorFloatingButtonAnimationIsRun = parcel.readByte() != 0;
            this.mUseReverseAnimationOnClose = parcel.readByte() != 0 ? true : z;
            this.mColorFloatingButtonItems = parcel.createTypedArrayList(ColorFloatingButtonItem.CREATOR);
        }
    }

    public static class ColorFloatingButtonBehavior extends CoordinatorLayout.b<View> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f2183a;

        /* renamed from: b  reason: collision with root package name */
        private FloatingActionButton.OnVisibilityChangedListener f2184b;
        private boolean c;

        public ColorFloatingButtonBehavior() {
            this.c = true;
        }

        public ColorFloatingButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
            this.c = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        private static boolean c(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.e) {
                return ((CoordinatorLayout.e) layoutParams).b() instanceof BottomSheetBehavior;
            }
            return false;
        }

        public void onAttachedToLayoutParams(CoordinatorLayout.e eVar) {
            if (eVar.h == 0) {
                eVar.h = 80;
            }
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view2, view);
                return false;
            } else if (!c(view2)) {
                return false;
            } else {
                b(view2, view);
                return false;
            }
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            List<View> dependencies = coordinatorLayout.getDependencies(view);
            int size = dependencies.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = dependencies.get(i2);
                if (!(view2 instanceof AppBarLayout)) {
                    if (c(view2) && b(view2, view)) {
                        break;
                    }
                } else if (a(coordinatorLayout, (AppBarLayout) view2, view)) {
                    break;
                }
            }
            coordinatorLayout.onLayoutChild(view, i);
            return true;
        }

        /* access modifiers changed from: protected */
        public void a(View view) {
            if (view instanceof FloatingActionButton) {
                ((FloatingActionButton) view).show(this.f2184b);
            } else if (view instanceof ColorFloatingButton) {
                view.setVisibility(0);
            } else {
                view.setVisibility(0);
            }
        }

        /* access modifiers changed from: protected */
        public void b(View view) {
            if (view instanceof FloatingActionButton) {
                ((FloatingActionButton) view).hide(this.f2184b);
            } else if (view instanceof ColorFloatingButton) {
                ((ColorFloatingButton) view).a(this.f2184b);
            } else {
                view.setVisibility(4);
            }
        }

        private boolean a(View view, View view2) {
            CoordinatorLayout.e eVar = (CoordinatorLayout.e) view2.getLayoutParams();
            if (this.c && eVar.a() == view.getId() && view2.getVisibility() == 0) {
                return true;
            }
            return false;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view) {
            if (!a(appBarLayout, view)) {
                return false;
            }
            if (this.f2183a == null) {
                this.f2183a = new Rect();
            }
            Rect rect = this.f2183a;
            b.b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= a(appBarLayout)) {
                view.setVisibility(8);
                return true;
            }
            view.setVisibility(0);
            return true;
        }

        private int a(AppBarLayout appBarLayout) {
            int m = v.m(appBarLayout);
            if (m != 0) {
                return m * 2;
            }
            int childCount = appBarLayout.getChildCount();
            if (childCount >= 1) {
                return v.m(appBarLayout.getChildAt(childCount - 1)) * 2;
            }
            return 0;
        }

        private boolean b(View view, View view2) {
            if (!a(view, view2)) {
                return false;
            }
            if (view.getTop() < (view2.getHeight() / 2) + ((CoordinatorLayout.e) view2.getLayoutParams()).topMargin) {
                b(view2);
                return true;
            }
            a(view2);
            return true;
        }
    }

    public static class ScrollViewBehavior extends ColorFloatingButtonBehavior {

        /* renamed from: a  reason: collision with root package name */
        ObjectAnimator f2185a = new ObjectAnimator();

        /* renamed from: b  reason: collision with root package name */
        private boolean f2186b = false;

        public ScrollViewBehavior() {
        }

        public ScrollViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, final View view, View view2, View view3, int i, int i2) {
            if (view3 instanceof RecyclerView) {
                RecyclerView recyclerView = (RecyclerView) view3;
                int itemCount = recyclerView.getAdapter().getItemCount();
                if (!(recyclerView.getChildCount() == 0 || itemCount == 0 || this.f2186b)) {
                    recyclerView.addOnScrollListener(new RecyclerView.n() {
                        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                            super.onScrollStateChanged(recyclerView, i);
                        }

                        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                            super.onScrolled(recyclerView, i, i2);
                            View view = view;
                            if (view instanceof ColorFloatingButton) {
                                ScrollViewBehavior.this.a((ColorFloatingButton) view, i2);
                            }
                        }
                    });
                    this.f2186b = true;
                }
                return false;
            }
            if (view3 instanceof AbsListView) {
                AbsListView absListView = (AbsListView) view3;
                int count = absListView.getCount();
                int childCount = absListView.getChildCount();
                View childAt = absListView.getChildAt(0);
                int top = view3.getTop() - view3.getPaddingTop();
                int bottom = view3.getBottom() - view3.getPaddingBottom();
                View childAt2 = absListView.getChildAt(childCount - 1);
                if (childCount > 0 && count > 0) {
                    if (absListView.getFirstVisiblePosition() != 0 || childAt.getTop() < (-top)) {
                        return childAt2 == null || absListView.getLastVisiblePosition() != count - 1 || childAt2.getBottom() > bottom;
                    }
                    return false;
                }
            }
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
            super.onNestedPreScroll(coordinatorLayout, view, view2, i, i2, iArr, i3);
            if (view instanceof ColorFloatingButton) {
                a((ColorFloatingButton) view, i2);
            }
        }

        /* access modifiers changed from: private */
        public void a(ColorFloatingButton colorFloatingButton, int i) {
            if (i <= 10 || colorFloatingButton.getVisibility() != 0) {
                if (i < -10) {
                    colorFloatingButton.a(200);
                }
            } else if (colorFloatingButton.c() && !this.f2185a.isRunning()) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f2185a = colorFloatingButton.e();
                animatorSet.playTogether(new Animator[]{this.f2185a, colorFloatingButton.a(true)});
                animatorSet.setDuration(150);
                colorFloatingButton.a(true, 250, true);
                animatorSet.start();
            } else if (!this.f2185a.isRunning()) {
                this.f2185a = colorFloatingButton.e();
                this.f2185a.start();
            }
        }
    }

    /* access modifiers changed from: private */
    public static int b(Context context, float f2) {
        return Math.round(TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics()));
    }
}
