package com.oppo.camera.ui.modepanel;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;

/* compiled from: ModeTitle */
public class d implements View.OnClickListener {
    private static Typeface f;

    /* renamed from: a  reason: collision with root package name */
    private Activity f4301a = null;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f4302b = null;
    private TextView c = null;
    private a d = null;
    private int e = 8;

    /* compiled from: ModeTitle */
    public interface a {
        void a();
    }

    public d(Activity activity, ViewGroup viewGroup) {
        this.f4301a = activity;
        a(viewGroup);
    }

    private void a(ViewGroup viewGroup) {
        this.f4301a.getLayoutInflater().inflate(R.layout.mode_title, viewGroup);
        this.f4302b = (RelativeLayout) this.f4301a.findViewById(R.id.mode_title_layout);
        this.c = (TextView) this.f4302b.findViewById(R.id.mode_name);
        this.c.setTypeface(c(), 1);
        this.f4302b.setOnClickListener(this);
    }

    public void onClick(View view) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(String str) {
        this.c.setText(str);
        this.f4302b.setContentDescription(str);
    }

    public String a() {
        TextView textView = this.c;
        return (textView == null || textView.getText() == null) ? "" : (String) this.c.getText();
    }

    public boolean b() {
        return this.e == 0;
    }

    public void a(int i, Animation animation) {
        e.a("ModeTitle", "setVisibility, visibility: " + i);
        if (this.e != i) {
            this.e = i;
            if (i == 0) {
                a(animation);
            } else {
                b(animation);
            }
        }
    }

    public void a(int i, boolean z) {
        e.a("ModeTitle", "setVisibility, visibility: " + i);
        if (this.e != i) {
            this.e = i;
            if (!z) {
                this.f4302b.setVisibility(i);
            } else if (i == 0) {
                a((Animation) null);
            } else {
                b((Animation) null);
            }
        }
    }

    public void a(boolean z) {
        e.a("ModeTitle", "setEnable, enable: " + z);
        RelativeLayout relativeLayout = this.f4302b;
        if (relativeLayout != null) {
            relativeLayout.setEnabled(z);
        }
    }

    private Typeface c() {
        Typeface typeface = f;
        if (typeface != null) {
            return typeface;
        }
        f = Util.a((Context) this.f4301a, true);
        return f;
    }

    private void a(Animation animation) {
        if (animation == null) {
            animation = AnimationUtils.loadAnimation(this.f4301a, R.anim.mode_title_in);
        }
        this.f4302b.setVisibility(0);
        this.f4302b.clearAnimation();
        this.f4302b.startAnimation(animation);
        this.f4302b.setEnabled(true);
    }

    private void b(Animation animation) {
        if (animation == null) {
            animation = AnimationUtils.loadAnimation(this.f4301a, R.anim.mode_title_out);
        }
        this.f4302b.setVisibility(8);
        this.f4302b.clearAnimation();
        this.f4302b.startAnimation(animation);
        this.f4302b.setEnabled(false);
    }

    public void a(a aVar) {
        this.d = aVar;
    }
}
