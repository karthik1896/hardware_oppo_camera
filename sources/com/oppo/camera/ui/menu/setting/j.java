package com.oppo.camera.ui.menu.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.oppo.camera.e;
import com.oppo.camera.k;
import com.oppo.camera.ui.f;
import com.oppo.camera.ui.inverse.c;
import com.oppo.camera.ui.menu.a;
import com.oppo.camera.ui.menu.i;
import com.oppo.camera.ui.widget.d;

/* compiled from: CameraMenuOptionSecondLevel */
public class j extends CameraMenuOption implements View.OnClickListener {
    /* access modifiers changed from: private */
    public i o = null;
    /* access modifiers changed from: private */
    public d p = null;

    /* access modifiers changed from: protected */
    public boolean p() {
        return true;
    }

    public j(k kVar, Context context, f fVar, int i) {
        super(kVar, context, (a) null, (i) null, fVar, i, (String) null);
    }

    public void b() {
        this.o = new i(this.j, this.m);
        c.INS.registerInverse(this.j, this.o);
        this.o.setOnClickListener(this);
    }

    public void a(View view) {
        this.o = (i) view;
    }

    public View F() {
        return this.o;
    }

    public void onClick(View view) {
        if (this.l != null) {
            this.l.a(this);
        }
    }

    public void t() {
        d dVar = this.p;
        if (dVar != null) {
            if (dVar.isShowing()) {
                this.p.dismiss();
            }
            this.p = null;
        }
    }

    public void a(String str, String str2, String str3, final int i, final int i2) {
        if (str2 != null && !str2.isEmpty()) {
            if (this.p != null) {
                t();
            }
            if (this.o != null) {
                this.p = new d(this.j);
                this.p.a(true);
                this.p.a((CharSequence) str2);
                this.p.setTouchInterceptor(new View.OnTouchListener(str, str3) {
                    private final /* synthetic */ String f$1;
                    private final /* synthetic */ String f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return j.this.a(this.f$1, this.f$2, view, motionEvent);
                    }
                });
                if (!this.p.isShowing()) {
                    this.o.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        public void onGlobalLayout() {
                            if (j.this.C() == 0) {
                                j.this.o.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                                try {
                                    j.this.p.a(i, i2);
                                    j.this.p.a((View) j.this.o, 4);
                                } catch (WindowManager.BadTokenException e) {
                                    e.d("CameraMenuOptionSecondLevel", "showSubMenuOptionTipsBubble, exception: " + e.getMessage());
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean a(String str, String str2, View view, MotionEvent motionEvent) {
        t();
        if (!(this.f4163a == null || str == null)) {
            SharedPreferences.Editor edit = this.f4163a.edit();
            edit.putBoolean(str + "_" + str2, false);
            edit.apply();
        }
        return false;
    }

    public int x() {
        i iVar = this.o;
        if (iVar != null) {
            return iVar.getViewWidth();
        }
        return super.x();
    }

    public void b(boolean z) {
        i iVar = this.o;
        if (iVar != null) {
            iVar.setShadow(z);
        }
    }

    public int y() {
        i iVar = this.o;
        if (iVar != null) {
            return iVar.getViewHeight();
        }
        return super.y();
    }

    public void h(String str) {
        i iVar = this.o;
        if (iVar != null) {
            iVar.setItemText(str);
            this.o.setContentDescription(str);
        }
    }

    public void a(Drawable drawable, boolean z) {
        i iVar = this.o;
        if (iVar != null) {
            iVar.a(drawable, z);
        }
    }

    public void a(int i, boolean z) {
        i iVar = this.o;
        if (iVar != null) {
            iVar.a(i, z);
        }
        super.a(i, z);
    }

    /* access modifiers changed from: protected */
    public void w() {
        i iVar = this.o;
        if (iVar != null) {
            iVar.a();
            super.w();
            a((View) null);
        }
    }

    public void c(boolean z) {
        i iVar = this.o;
        if (iVar != null) {
            iVar.setSelected(z);
        }
    }
}
