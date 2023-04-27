package com.oppo.camera.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.oppo.camera.R;
import com.oppo.camera.ac;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ZoomClickChangeView */
public class p extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4319a = "p";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f4320b;
    private DecimalFormat c;
    private Animation d;
    private Animation e;
    /* access modifiers changed from: private */
    public boolean f;
    private float g;
    private float h;
    private List<Float> i;
    private List<TextView> j;
    private ValueAnimator k;

    /* compiled from: ZoomClickChangeView */
    public interface a {
        void a(float f);

        boolean a();

        void b(float f);

        boolean b();

        void c();
    }

    public p(Context context) {
        this(context, (AttributeSet) null);
    }

    public p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public p(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4320b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = false;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = null;
        this.j = null;
        this.k = null;
        a(context);
    }

    private void a(Context context) {
        setOrientation(0);
        setGravity(17);
        this.c = new DecimalFormat("#.#");
        setClickable(true);
    }

    public void setListener(a aVar) {
        this.f4320b = aVar;
    }

    public void a(float f2, List<Float> list) {
        ArrayList<Float> arrayList = new ArrayList<>(list);
        this.g = f2;
        this.i = arrayList;
        removeAllViews();
        this.j = new ArrayList();
        for (Float floatValue : arrayList) {
            float floatValue2 = floatValue.floatValue();
            TextView textView = new TextView(getContext());
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.zoom_mark_button_size);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.zoom_mark_button_margin);
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.zoom_mark_button_margin);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(17);
            textView.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen.zoom_mark_button_text_size));
            textView.setTextColor(-1);
            textView.setBackground(getResources().getDrawable(R.drawable.zoom_mark_button_background));
            textView.setText(a(floatValue2));
            textView.setPadding(0, 0, 2, 0);
            textView.setOnClickListener(new View.OnClickListener(floatValue2) {
                private final /* synthetic */ float f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    p.this.a(this.f$1, view);
                }
            });
            addView(textView);
            textView.setSelected(a(floatValue2, f2));
            this.j.add(textView);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(float f2, View view) {
        a aVar = this.f4320b;
        if (aVar != null && !aVar.a() && this.f4320b.b() && !this.f && Float.compare(this.g, f2) != 0) {
            this.h = f2;
            this.f4320b.b(f2);
            ValueAnimator valueAnimator = this.k;
            if (valueAnimator == null) {
                this.k = ValueAnimator.ofFloat(new float[]{this.g, f2});
                this.k.setDuration(300);
                this.k.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.anim.zoom_interpolator_in));
                this.k.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        p.this.a(valueAnimator);
                    }
                });
                this.k.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationStart(Animator animator) {
                    }

                    public void onAnimationCancel(Animator animator) {
                        if (p.this.f4320b != null) {
                            p.this.f4320b.c();
                        }
                    }

                    public void onAnimationEnd(Animator animator) {
                        if (p.this.f4320b != null) {
                            p.this.f4320b.c();
                        }
                    }
                });
            } else {
                if (valueAnimator.isRunning()) {
                    this.k.cancel();
                }
                this.k.setFloatValues(new float[]{this.g, f2});
            }
            this.k.start();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (0.6f > floatValue) {
            floatValue = 0.6f;
        }
        this.f4320b.a(floatValue);
    }

    public String a(float f2) {
        return this.c.format((double) f2) + "X";
    }

    public void a(int i2, boolean z) {
        Animation animation;
        if (z) {
            setVisibility(i2);
            if (i2 == 0) {
                if (this.d == null) {
                    this.d = AnimationUtils.loadAnimation(getContext(), R.anim.zoom_button_in);
                    this.d.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                            boolean unused = p.this.f = true;
                        }

                        public void onAnimationEnd(Animation animation) {
                            boolean unused = p.this.f = false;
                        }
                    });
                }
                animation = this.d;
            } else {
                if (this.e == null) {
                    this.e = AnimationUtils.loadAnimation(getContext(), R.anim.zoom_button_out);
                    this.e.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                            boolean unused = p.this.f = true;
                        }

                        public void onAnimationEnd(Animation animation) {
                            boolean unused = p.this.f = false;
                        }
                    });
                }
                animation = this.e;
            }
            startAnimation(animation);
            return;
        }
        setVisibility(i2);
    }

    public void a(float f2, boolean z) {
        this.g = f2;
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            this.j.get(i2).setSelected(z && a(this.i.get(i2).floatValue(), f2));
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            this.j.get(i2).setEnabled(z);
        }
    }

    private boolean a(float f2, float f3) {
        boolean b2 = b(f2, f3);
        if (b2) {
            float f4 = this.h;
            if (f4 > 0.0f) {
                boolean b3 = b(f2, f4);
                if (b3) {
                    this.h = 0.0f;
                }
                return b3;
            }
        }
        return b2;
    }

    private boolean b(float f2, float f3) {
        return f2 == ac.c(f3);
    }
}
