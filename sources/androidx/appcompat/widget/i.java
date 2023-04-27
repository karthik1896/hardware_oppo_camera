package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R;
import androidx.appcompat.a.a.a;
import androidx.appcompat.widget.ah;
import androidx.core.graphics.d;

/* compiled from: AppCompatDrawableManager */
public final class i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final PorterDuff.Mode f448a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private static i f449b;
    private ah c;

    public static synchronized void a() {
        synchronized (i.class) {
            if (f449b == null) {
                f449b = new i();
                f449b.c = ah.a();
                f449b.c.a((ah.e) new ah.e() {

                    /* renamed from: a  reason: collision with root package name */
                    private final int[] f450a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

                    /* renamed from: b  reason: collision with root package name */
                    private final int[] f451b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
                    private final int[] c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light};
                    private final int[] d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
                    private final int[] e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
                    private final int[] f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

                    private ColorStateList a(Context context) {
                        return b(context, am.a(context, R.attr.colorButtonNormal));
                    }

                    private ColorStateList b(Context context) {
                        return b(context, 0);
                    }

                    private ColorStateList c(Context context) {
                        return b(context, am.a(context, R.attr.colorAccent));
                    }

                    private ColorStateList b(Context context, int i) {
                        int a2 = am.a(context, R.attr.colorControlHighlight);
                        int c2 = am.c(context, R.attr.colorButtonNormal);
                        return new ColorStateList(new int[][]{am.f410a, am.d, am.f411b, am.h}, new int[]{c2, d.a(a2, i), d.a(a2, i), i});
                    }

                    private ColorStateList d(Context context) {
                        int[][] iArr = new int[3][];
                        int[] iArr2 = new int[3];
                        ColorStateList b2 = am.b(context, R.attr.colorSwitchThumbNormal);
                        if (b2 == null || !b2.isStateful()) {
                            iArr[0] = am.f410a;
                            iArr2[0] = am.c(context, R.attr.colorSwitchThumbNormal);
                            iArr[1] = am.e;
                            iArr2[1] = am.a(context, R.attr.colorControlActivated);
                            iArr[2] = am.h;
                            iArr2[2] = am.a(context, R.attr.colorSwitchThumbNormal);
                        } else {
                            iArr[0] = am.f410a;
                            iArr2[0] = b2.getColorForState(iArr[0], 0);
                            iArr[1] = am.e;
                            iArr2[1] = am.a(context, R.attr.colorControlActivated);
                            iArr[2] = am.h;
                            iArr2[2] = b2.getDefaultColor();
                        }
                        return new ColorStateList(iArr, iArr2);
                    }

                    public Drawable a(ah ahVar, Context context, int i) {
                        if (i != R.drawable.abc_cab_background_top_material) {
                            return null;
                        }
                        return new LayerDrawable(new Drawable[]{ahVar.a(context, R.drawable.abc_cab_background_internal_bg), ahVar.a(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
                    }

                    private void a(Drawable drawable, int i, PorterDuff.Mode mode) {
                        if (aa.c(drawable)) {
                            drawable = drawable.mutate();
                        }
                        if (mode == null) {
                            mode = i.f448a;
                        }
                        drawable.setColorFilter(i.a(i, mode));
                    }

                    public boolean a(Context context, int i, Drawable drawable) {
                        if (i == R.drawable.abc_seekbar_track_material) {
                            LayerDrawable layerDrawable = (LayerDrawable) drawable;
                            a(layerDrawable.findDrawableByLayerId(16908288), am.a(context, R.attr.colorControlNormal), i.f448a);
                            a(layerDrawable.findDrawableByLayerId(16908303), am.a(context, R.attr.colorControlNormal), i.f448a);
                            a(layerDrawable.findDrawableByLayerId(16908301), am.a(context, R.attr.colorControlActivated), i.f448a);
                            return true;
                        } else if (i != R.drawable.abc_ratingbar_material && i != R.drawable.abc_ratingbar_indicator_material && i != R.drawable.abc_ratingbar_small_material) {
                            return false;
                        } else {
                            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                            a(layerDrawable2.findDrawableByLayerId(16908288), am.c(context, R.attr.colorControlNormal), i.f448a);
                            a(layerDrawable2.findDrawableByLayerId(16908303), am.a(context, R.attr.colorControlActivated), i.f448a);
                            a(layerDrawable2.findDrawableByLayerId(16908301), am.a(context, R.attr.colorControlActivated), i.f448a);
                            return true;
                        }
                    }

                    private boolean a(int[] iArr, int i) {
                        for (int i2 : iArr) {
                            if (i2 == i) {
                                return true;
                            }
                        }
                        return false;
                    }

                    public ColorStateList a(Context context, int i) {
                        if (i == R.drawable.abc_edit_text_material) {
                            return a.a(context, R.color.abc_tint_edittext);
                        }
                        if (i == R.drawable.abc_switch_track_mtrl_alpha) {
                            return a.a(context, R.color.abc_tint_switch_track);
                        }
                        if (i == R.drawable.abc_switch_thumb_material) {
                            return d(context);
                        }
                        if (i == R.drawable.abc_btn_default_mtrl_shape) {
                            return a(context);
                        }
                        if (i == R.drawable.abc_btn_borderless_material) {
                            return b(context);
                        }
                        if (i == R.drawable.abc_btn_colored_material) {
                            return c(context);
                        }
                        if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                            return a.a(context, R.color.abc_tint_spinner);
                        }
                        if (a(this.f451b, i)) {
                            return am.b(context, R.attr.colorControlNormal);
                        }
                        if (a(this.e, i)) {
                            return a.a(context, R.color.abc_tint_default);
                        }
                        if (a(this.f, i)) {
                            return a.a(context, R.color.abc_tint_btn_checkable);
                        }
                        if (i == R.drawable.abc_seekbar_thumb_material) {
                            return a.a(context, R.color.abc_tint_seek_thumb);
                        }
                        return null;
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
                    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065 A[RETURN] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public boolean b(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
                        /*
                            r6 = this;
                            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.i.f448a
                            int[] r1 = r6.f450a
                            boolean r1 = r6.a((int[]) r1, (int) r8)
                            r2 = 16842801(0x1010031, float:2.3693695E-38)
                            r3 = -1
                            r4 = 0
                            r5 = 1
                            if (r1 == 0) goto L_0x0018
                            int r2 = androidx.appcompat.R.attr.colorControlNormal
                        L_0x0014:
                            r1 = r0
                            r0 = r3
                        L_0x0016:
                            r8 = r5
                            goto L_0x0048
                        L_0x0018:
                            int[] r1 = r6.c
                            boolean r1 = r6.a((int[]) r1, (int) r8)
                            if (r1 == 0) goto L_0x0023
                            int r2 = androidx.appcompat.R.attr.colorControlActivated
                            goto L_0x0014
                        L_0x0023:
                            int[] r1 = r6.d
                            boolean r1 = r6.a((int[]) r1, (int) r8)
                            if (r1 == 0) goto L_0x002e
                            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                            goto L_0x0014
                        L_0x002e:
                            int r1 = androidx.appcompat.R.drawable.abc_list_divider_mtrl_alpha
                            if (r8 != r1) goto L_0x003f
                            r2 = 16842800(0x1010030, float:2.3693693E-38)
                            r8 = 1109603123(0x42233333, float:40.8)
                            int r8 = java.lang.Math.round(r8)
                            r1 = r0
                            r0 = r8
                            goto L_0x0016
                        L_0x003f:
                            int r1 = androidx.appcompat.R.drawable.abc_dialog_material_background
                            if (r8 != r1) goto L_0x0044
                            goto L_0x0014
                        L_0x0044:
                            r1 = r0
                            r0 = r3
                            r8 = r4
                            r2 = r8
                        L_0x0048:
                            if (r8 == 0) goto L_0x0065
                            boolean r8 = androidx.appcompat.widget.aa.c(r9)
                            if (r8 == 0) goto L_0x0054
                            android.graphics.drawable.Drawable r9 = r9.mutate()
                        L_0x0054:
                            int r7 = androidx.appcompat.widget.am.a(r7, r2)
                            android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.i.a((int) r7, (android.graphics.PorterDuff.Mode) r1)
                            r9.setColorFilter(r7)
                            if (r0 == r3) goto L_0x0064
                            r9.setAlpha(r0)
                        L_0x0064:
                            return r5
                        L_0x0065:
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i.AnonymousClass1.b(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
                    }

                    public PorterDuff.Mode a(int i) {
                        if (i == R.drawable.abc_switch_thumb_material) {
                            return PorterDuff.Mode.MULTIPLY;
                        }
                        return null;
                    }
                });
            }
        }
    }

    public static synchronized i b() {
        i iVar;
        synchronized (i.class) {
            if (f449b == null) {
                a();
            }
            iVar = f449b;
        }
        return iVar;
    }

    public synchronized Drawable a(Context context, int i) {
        return this.c.a(context, i);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable a(Context context, int i, boolean z) {
        return this.c.a(context, i, z);
    }

    public synchronized void a(Context context) {
        this.c.a(context);
    }

    /* access modifiers changed from: package-private */
    public synchronized ColorStateList b(Context context, int i) {
        return this.c.b(context, i);
    }

    static void a(Drawable drawable, ap apVar, int[] iArr) {
        ah.a(drawable, apVar, iArr);
    }

    public static synchronized PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (i.class) {
            a2 = ah.a(i, mode);
        }
        return a2;
    }
}
