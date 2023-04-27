package com.oppo.camera.e;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.media.CamcorderProfile;
import android.media.ImageReader;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import com.oppo.camera.R;
import com.oppo.camera.aps.adapter.ApsAdapterDecision;
import com.oppo.camera.aps.adapter.ApsCaptureResult;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.CameraFunction;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.aps.constant.ParameterKeys;
import com.oppo.camera.aps.service.ThumbnailItem;
import com.oppo.camera.e;
import com.oppo.camera.e.r;
import com.oppo.camera.f.d;
import com.oppo.camera.f.f;
import com.oppo.camera.f.j;
import com.oppo.camera.j.b;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.statistics.model.CaptureMsgData;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.FocusAimMsgData;
import com.oppo.camera.statistics.model.MenuClickMsgData;
import com.oppo.camera.statistics.model.StickerMsgData;
import com.oppo.camera.statistics.model.VideoRecordMsgData;
import com.oppo.camera.sticker.data.StickerCategoryItem;
import com.oppo.camera.sticker.data.StickerItem;
import com.oppo.camera.sticker.ui.c;
import com.oppo.camera.sticker.ui.h;
import com.oppo.camera.sticker.ui.i;
import com.oppo.camera.sticker.ui.l;
import com.oppo.camera.ui.menu.BasicOptionItemList;
import com.oppo.camera.ui.menu.levelcontrol.f;
import com.oppo.camera.ui.preview.a.g;
import com.oppo.camera.ui.preview.a.k;
import com.oppo.camera.ui.preview.a.n;
import com.oppo.camera.ui.preview.a.p;
import com.oppo.camera.ui.preview.a.s;
import com.oppo.camera.util.Util;
import com.oppo.camera.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: StickerMode */
public class r extends u {
    private final Object aT = new Object();
    /* access modifiers changed from: private */
    public h aU = null;
    /* access modifiers changed from: private */
    public l aV = null;
    private p aW = new a();
    private Float aX = null;
    private Float aY = null;
    private Integer aZ = null;
    private Integer ba = null;
    private Long bb = null;
    private ImageReader bc = null;
    private ImageReader bd = null;
    private int be = 0;
    private int bf = 0;
    private String bg = null;
    private HashMap<String, Long> bh = null;
    private HashMap<String, Integer> bi = null;
    private c bj = null;
    private ThumbnailItem bk = null;
    private int bl = 0;
    private int bm = 0;
    private long bn = 0;
    /* access modifiers changed from: private */
    public long bo = 0;
    private boolean bp = false;
    private k bq = new k() {
        public void a(f fVar) {
        }

        public void a(final ArrayList<h.b> arrayList, final int i, StickerItem stickerItem, final boolean z) {
            e.a("StickerMode", "updateAdapter, stickerItem: " + stickerItem + ", updateCategoryIndex: " + z + ", stickerCategoryIndex: " + i);
            if (r.this.aU != null && r.this.Z != null && arrayList.size() > 0) {
                r.this.aU.a(stickerItem, true);
                r.this.aU.a(stickerItem);
                r.this.Z.runOnUiThread(new Runnable() {
                    public void run() {
                        if (r.this.aU != null) {
                            r.this.aU.a((ArrayList<h.b>) arrayList, i, z);
                        }
                    }
                });
            }
        }
    };
    private i br = new i() {
        public void d() {
        }

        public void a(boolean z) {
            e.a("StickerMode", "beforeEnterAnimator");
            r.this.Y.d(false, false);
            r.this.Y.a(true, false);
            r.this.Y.a(4, false);
            r.this.Y.a(true, true, false, false);
            r.this.Y.l(z);
            if (r.this.X != null) {
                r.this.X.a((Animation.AnimationListener) null);
            }
            if (r.this.p("key_bubble_sticker")) {
                r.this.Y.c(3, true);
            }
            r.this.I(false);
        }

        public void a() {
            e.a("StickerMode", "afterEnterAnimator");
            r.this.Y.e(true, true);
            CameraStatisticsUtil.onCommon(r.this.Z, CameraStatisticsUtil.EVENT_MENU_CLICK, CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_MODE_CLICK_STICKER_MENU, "1"), false);
            r.this.J(true);
        }

        public void b() {
            r.this.Y.f(true, true);
            if (r.this.X != null && !r.this.Y.s()) {
                r.this.X.D();
            }
            r.this.Y.d(false, false);
        }

        public void c() {
            if (!r.this.bC()) {
                r.this.Y.d(true, true);
            }
            if (r.this.X != null && !r.this.Y.s()) {
                r.this.X.d(true);
            }
            r.this.J(false);
            r.this.Y.an();
        }

        public void b(boolean z) {
            if (z) {
                r.this.Y.e(0);
            } else {
                r.this.Y.f(true, true);
                if (r.this.X != null && !r.this.Y.s()) {
                    r.this.X.D();
                    r.this.X.d(true);
                }
            }
            r.this.Y.d(true, true);
            r.this.Y.an();
        }

        public boolean a(StickerItem stickerItem, int i) {
            return r.this.a(stickerItem, i);
        }

        public boolean a(View view, StickerItem stickerItem, int i) {
            return r.this.a(view, stickerItem, i);
        }

        public void a(String str) {
            r.this.a(CameraStatisticsUtil.STICKER_MENU_CATERGORY_FLING, str);
        }

        public void b(String str) {
            r.this.a(CameraStatisticsUtil.STICKER_MENU_CATERGORY_CLICK, str);
            r.this.A(str);
        }

        public StickerItem e() {
            if (r.this.ab != null) {
                return r.this.ab.j();
            }
            return null;
        }

        public void f() {
            if (r.this.aU != null) {
                StickerItem stickerItem = null;
                if (r.this.ab != null) {
                    stickerItem = r.this.ab.j();
                }
                if (stickerItem != null) {
                    com.oppo.camera.ui.preview.a.l b2 = com.oppo.camera.ui.preview.a.l.b((Context) r.this.Z);
                    String stickerUUID = stickerItem.getStickerUUID();
                    boolean a2 = b2.a(stickerUUID);
                    if (r.this.ab != null) {
                        if (a2) {
                            r.this.ab.c();
                        } else {
                            r.this.ab.b();
                        }
                    }
                    b2.a(stickerUUID, !a2);
                    r.this.aU.b(stickerUUID);
                    return;
                }
                e.e("StickerMode", "onMusicButtonClick, non selected stickerItem!");
            }
        }

        public boolean g() {
            if (r.this.X == null) {
                return false;
            }
            if (!r.this.X.z() && !r.this.X.C() && !r.this.X.B() && !r.this.Y.t() && !r.this.v && r.this.dP()) {
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("canItemClick, !mCameraInterface.isDoubleFinger: ");
            sb.append(!r.this.X.z());
            sb.append(", !mCameraInterface.getCaptureModeChangeState: ");
            sb.append(!r.this.X.C());
            sb.append(", !mCameraUIInterface.isAnimationRunning: ");
            sb.append(!r.this.Y.t());
            sb.append(", isVideoRecordStopped: ");
            sb.append(r.this.dP());
            sb.append(", !mbInCapturing: ");
            sb.append(!r.this.v);
            sb.append(", !mCameraInterface.getSwitchingCameraState: ");
            sb.append(true ^ r.this.X.B());
            e.e("StickerMode", sb.toString());
            return false;
        }
    };

    public int C() {
        return 1;
    }

    public boolean F() {
        return false;
    }

    public String a() {
        return ApsConstant.CAPTURE_MODE_STICKER;
    }

    public boolean a(int i, MotionEvent motionEvent) {
        return false;
    }

    /* access modifiers changed from: protected */
    public int aB() {
        return 4;
    }

    public boolean aM() {
        return true;
    }

    public int aQ() {
        return 35;
    }

    public boolean aa() {
        return false;
    }

    public String ad() {
        return "16_9";
    }

    public String b() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String bY() {
        return "pref_sticker_facebeauty_level_menu";
    }

    public int c() {
        return 32782;
    }

    public String cg() {
        return "key_sticker_filter_index";
    }

    public String ch() {
        return "pref_filter_menu";
    }

    /* access modifiers changed from: protected */
    public String dq() {
        return "pref_camera_line_photo";
    }

    /* access modifiers changed from: protected */
    public boolean en() {
        return true;
    }

    public boolean g() {
        return true;
    }

    public boolean h() {
        return false;
    }

    static /* synthetic */ int b(r rVar) {
        int i = rVar.bf;
        rVar.bf = i + 1;
        return i;
    }

    public r(Activity activity, b bVar, com.oppo.camera.ui.e eVar, n nVar) {
        super(activity, bVar, eVar, nVar);
        com.oppo.camera.ui.preview.a.l.b((Context) this.Z).a(this.aW);
    }

    public boolean aP() {
        return cz();
    }

    /* access modifiers changed from: protected */
    public long aK() {
        return (long) CameraConfig.getConfigIntValue(ConfigDataBase.KEY_HAL_MEMORY_STICKER);
    }

    /* access modifiers changed from: protected */
    public void eh() {
        f(false, true);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        e.a("StickerMode", "onResume");
        super.a(z);
        this.bn = System.currentTimeMillis();
        this.ab.f();
        this.aU.a(z, Y());
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STICKER)) {
            fR();
        }
    }

    /* access modifiers changed from: private */
    public int G(int i) {
        if (3 == i) {
            return this.Z.getResources().getDimensionPixelSize(R.dimen.bubble_type_sticker_offset_x);
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public int H(int i) {
        if (i == 3) {
            return this.Z.getResources().getDimensionPixelSize(R.dimen.bubble_type_sticker_offset_y);
        }
        if (i != 4) {
            return 0;
        }
        return this.Z.getResources().getDimensionPixelSize(R.dimen.bubble_type_short_video_offset_y);
    }

    public void ed() {
        super.ed();
        if (this.X.P()) {
            this.Y.B();
        }
    }

    public void an() {
        e.b("StickerMode", "closeImageReader");
        ImageReader imageReader = this.bc;
        if (imageReader != null) {
            imageReader.close();
            this.bc = null;
        }
        ImageReader imageReader2 = this.bd;
        if (imageReader2 != null) {
            imageReader2.close();
            this.bd = null;
        }
    }

    /* access modifiers changed from: protected */
    public void p() {
        e.a("StickerMode", "onPause");
        l lVar = this.aV;
        if (lVar != null && lVar.isShowing()) {
            this.aV.dismiss();
        }
        this.aU.c();
        this.Y.u();
        dd();
        if (p("key_bubble_sticker")) {
            this.Y.c(3, true);
        }
        if (p("key_bubble_short_video")) {
            this.Y.c(4, true);
        }
        if (this.ab != null) {
            this.ab.d(0);
        }
        super.p();
    }

    /* access modifiers changed from: protected */
    public void r() {
        if (p("key_bubble_sticker")) {
            this.Y.c(3, true);
        }
        if (p("key_bubble_short_video")) {
            this.Y.c(4, true);
        }
        c cVar = this.bj;
        if (cVar != null) {
            cVar.a();
            c.b();
        }
        h hVar = this.aU;
        if (hVar != null) {
            hVar.d();
            this.aU = null;
        }
        l lVar = this.aV;
        if (lVar != null) {
            lVar.c();
            this.aV = null;
        }
        com.oppo.camera.ui.preview.a.l.b((Context) this.Z).e();
        super.r();
    }

    public void e(int i) {
        this.k = i;
        this.aU.b(this.k);
    }

    /* access modifiers changed from: private */
    public boolean a(final StickerItem stickerItem, boolean z) {
        if (stickerItem == null || this.X.P() || this.W == null) {
            e.e("StickerMode", "onStickerItemChange, item: " + stickerItem + ", isBlurAnimRunning: " + this.X.P() + ", mOneCamera: " + this.W);
            return false;
        }
        e.b("StickerMode", "onStickerItemChange, item: " + stickerItem);
        if (f("pref_sticker_process_key")) {
            if (this.ab == null || (this.ab.b(stickerItem) && !z)) {
                this.Z.runOnUiThread(new Runnable() {
                    public void run() {
                        if (r.this.aU != null) {
                            r.this.aU.c(false);
                        }
                    }
                });
                b(stickerItem);
                a(stickerItem, StickerCategoryItem.MY_CATEGORY_ID.equals(stickerItem.getCategoryId()), "cancel");
            } else {
                StickerItem j = this.ab.j();
                if (j != null) {
                    c(CameraStatisticsUtil.STICKER_MENU_ITEM_USETIME, j.getStickerUUID());
                }
                this.ab.a(stickerItem);
                if (com.oppo.camera.ui.preview.a.l.b(stickerItem)) {
                    this.Z.runOnUiThread(new Runnable() {
                        public void run() {
                            if (r.this.Y != null) {
                                r.this.Y.h(false, false);
                                if (r.this.A && !r.this.dV()) {
                                    if (r.this.Y.C()) {
                                        r.this.Y.a(true, true, false, !r.this.t);
                                        r.this.Y.a(0, true);
                                        r.this.g(true, false);
                                        return;
                                    }
                                    r.this.Y.a(true, true, false, !r.this.t);
                                }
                            }
                        }
                    });
                    if (this.A) {
                        dd();
                    }
                } else {
                    this.Z.runOnUiThread(new Runnable() {
                        public void run() {
                            if (r.this.A && !r.this.dV() && !r.this.y) {
                                r.this.Y.r(true);
                                r.this.Y.t(true);
                            }
                        }
                    });
                    if (this.A) {
                        dd();
                    }
                }
                SharedPreferences.Editor edit = this.aa.edit();
                edit.putString("pref_current_sticker_uuid", stickerItem.getStickerUUID());
                edit.apply();
                if (this.aU != null) {
                    if (!(j == null || j.getCategoryId() == null || j.getCategoryId().equals(stickerItem.getCategoryId()))) {
                        this.aU.a(j.getCategoryId());
                    }
                    if (stickerItem.hasMusic()) {
                        this.aU.c(stickerItem.getStickerUUID());
                        if (this.ab != null) {
                            this.ab.c();
                        }
                    } else {
                        this.aU.i();
                        this.ab.b();
                    }
                    if (stickerItem.getDownloadTime() == 0 && !StickerCategoryItem.MY_CATEGORY_ID.equals(stickerItem.getCategoryId()) && !stickerItem.isRecycleBin()) {
                        com.oppo.camera.sticker.h.a((Context) this.Z).a(stickerItem);
                    }
                }
                a(CameraStatisticsUtil.STICKER_MENU_ITEM_SELECTED, stickerItem.getStickerUUID());
                this.Y.a().a((Runnable) new Runnable() {
                    public void run() {
                        e.a("StickerMode", "onStickerItemChange, success, categoryId: " + stickerItem.getCategoryId());
                        r.this.ab.d();
                    }
                });
                this.Z.runOnUiThread(new Runnable() {
                    public void run() {
                        if (r.this.aU != null) {
                            r.this.aU.c(true);
                        }
                    }
                });
                a(stickerItem, StickerCategoryItem.MY_CATEGORY_ID.equals(stickerItem.getCategoryId()), StickerMsgData.STICKER_OPER_SELECT);
            }
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    if (r.this.Z == null) {
                        e.e("StickerMode", "onStickerItemChange, mActivity is null, so return");
                    } else if (!r.this.A) {
                        e.d("StickerMode", "onStickerItemChange, already exited from sticker mode, so return");
                    } else if (com.oppo.camera.ui.menu.f.c()) {
                        com.oppo.camera.ui.menu.f.d();
                        BasicOptionItemList b2 = com.oppo.camera.ui.menu.f.b();
                        if (b2 != null) {
                            b2.setOnPopUpFadeOutAnimationStartListener(new BasicOptionItemList.OnPopUpFadeOutAnimationStartListener(stickerItem) {
                                private final /* synthetic */ StickerItem f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void onPopUpFadeOutAnimationStart() {
                                    r.AnonymousClass16.this.a(this.f$1);
                                }
                            });
                        }
                    } else {
                        r.this.a(stickerItem);
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void a(StickerItem stickerItem) {
                    r.this.a(stickerItem);
                }
            });
            return true;
        }
        e.a("StickerMode", "onStickerItemChange, failed index categoryId: " + stickerItem.getCategoryId());
        return true;
    }

    /* access modifiers changed from: private */
    public void a(StickerItem stickerItem) {
        this.Y.i(f("pref_camera_assistant_line_key"));
        this.Y.j();
        this.Y.h("pref_filter_menu");
        if (com.oppo.camera.ui.preview.a.l.b(stickerItem) && this.Y.s()) {
            this.Y.g(true, false);
        }
    }

    /* access modifiers changed from: private */
    public void fN() {
        this.Z.runOnUiThread(new Runnable() {
            public void run() {
                if (com.oppo.camera.ui.menu.f.c()) {
                    com.oppo.camera.ui.menu.f.d();
                }
                r.this.Y.i(r.this.f("pref_camera_assistant_line_key"));
                r.this.Y.j();
                r.this.Y.h("pref_filter_menu");
                if (com.oppo.camera.ui.preview.a.l.b(com.oppo.camera.ui.preview.a.l.b((Context) r.this.Z).a(r.this.aa)) && r.this.Y.s()) {
                    r.this.Y.g(true, true);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(StickerItem stickerItem) {
        SharedPreferences.Editor edit = this.aa.edit();
        edit.putString("pref_current_sticker_uuid", "unselected_uuid");
        edit.apply();
        if (this.ab != null) {
            StickerItem j = this.ab.j();
            if (j != null) {
                c(CameraStatisticsUtil.STICKER_MENU_ITEM_USETIME, j.getStickerUUID());
            }
            this.ab.a((StickerItem) null);
        }
        if (com.oppo.camera.ui.preview.a.l.b(stickerItem)) {
            dd();
            this.W.a((f.c) null);
        }
        if (stickerItem != null) {
            if (stickerItem.hasMusic()) {
                this.aU.i();
                if (this.ab != null) {
                    this.ab.b();
                }
            }
            a(CameraStatisticsUtil.STICKER_MENU_ITEM_UNSELECTED, stickerItem.getStickerUUID());
        }
        this.Y.a().a((Runnable) new Runnable() {
            public void run() {
                e.a("StickerMode", "unselectedStickerItem");
                if (r.this.ab != null) {
                    r.this.ab.d();
                }
            }
        });
    }

    public boolean bL() {
        e.a("StickerMode", "updateViewByEnterCameraType, mStickerMenu: " + this.aU);
        if (this.aU == null) {
            return false;
        }
        if (!b.a()) {
            this.aU.d(false);
            return true;
        }
        b.a((ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.a((ValueAnimator.AnimatorUpdateListener) null);
                r.this.aU.d(false);
            }
        });
        return true;
    }

    public void f(boolean z) {
        e.a("StickerMode", "onAfterStartPreview");
        if (!this.Y.s()) {
            this.aU.a(true);
            this.aU.b(true);
        }
        super.f(z);
    }

    public void j(boolean z) {
        super.j(z);
        H(true);
    }

    public void d(int i) {
        super.d(i);
    }

    public void cZ() {
        this.Y.f("pref_video_size_key");
    }

    private void fR() {
        boolean z = false;
        if (com.oppo.camera.w.b.g() || this.aa.getBoolean("pref_allow_network_access", false)) {
            z = true;
        }
        e.a("StickerMode", "initStickerMediator, allowNetworkAccess: " + z);
        com.oppo.camera.ui.preview.a.l.b((Context) this.Z).a((Context) this.Z);
        com.oppo.camera.ui.preview.a.l.b((Context) this.Z).a(2, true);
        com.oppo.camera.ui.preview.a.l.b((Context) this.Z).a(this.aW);
        if (z) {
            com.oppo.camera.ui.preview.a.l.b((Context) this.Z).f();
        }
    }

    /* access modifiers changed from: protected */
    public void s() {
        e.a("StickerMode", "onInitCameraMode");
        this.bn = System.currentTimeMillis();
        com.oppo.camera.ui.preview.a.l.b((Context) this.Z).a((Context) this.Z);
        boolean z = false;
        if (this.aa.getBoolean("pref_allow_network_access", false)) {
            com.oppo.camera.ui.preview.a.l.b((Context) this.Z).f();
        }
        this.ab.f();
        if (this.aU == null) {
            this.bj = new c(this.Z, R.drawable.sticker_undownload);
            if (com.oppo.camera.ui.preview.a.l.b((Context) this.Z).a(this.aa) != null) {
                z = true;
            }
            this.aU = new h(this.Z, this.k, z);
            this.aU.a(this.br);
            this.aU.a(this.bj);
        }
        this.aU.b();
        this.aU.f();
        this.aU.b(this.k);
        this.Y.c(this.Z.getString(R.string.camera_description_common_shutter_button));
        this.Y.b("pref_camera_photo_ratio_key", "full");
    }

    /* access modifiers changed from: protected */
    public void t() {
        e.a("StickerMode", "onDeinitCameraMode");
        super.t();
        this.Y.v();
        this.Y.a(0);
        if (this.aU.h()) {
            this.aU.b(true, false, true);
        }
        this.aU.g();
        this.Y.u();
        this.Y.a("pref_camera_photo_ratio_key", "full");
        a(0, false);
        if (this.ab != null) {
            this.ab.h(0);
        }
        if (p("key_bubble_sticker")) {
            this.Y.c(3, false);
        }
        if (p("key_bubble_short_video")) {
            this.Y.c(4, false);
        }
    }

    /* access modifiers changed from: protected */
    public void u() {
        super.u();
        e.a("StickerMode.onBeforePreview");
        StickerItem a2 = com.oppo.camera.ui.preview.a.l.b((Context) this.Z).a(this.aa);
        if (a2 != null) {
            c(CameraStatisticsUtil.STICKER_MENU_ITEM_USETIME, a2.getStickerUUID());
        }
        if (this.ab != null) {
            this.ab.a(a2);
        } else {
            e.e("StickerMode", "updateStickerIndex, mPreferences: " + this.aa);
        }
        dd();
        e.b("StickerMode.onBeforePreview");
    }

    public boolean cj() {
        StickerItem j = this.ab != null ? this.ab.j() : null;
        if (j == null) {
            j = com.oppo.camera.ui.preview.a.l.b((Context) this.Z).a(this.aa);
        }
        return f("pref_omoji_process_key") && com.oppo.camera.ui.preview.a.l.b(j);
    }

    public boolean cd() {
        return com.oppo.camera.ui.preview.a.l.c(this.ab != null ? this.ab.j() : null);
    }

    public boolean W() {
        h hVar = this.aU;
        if (hVar != null) {
            return hVar.j();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public String[] de() {
        return com.oppo.camera.ui.e.d_;
    }

    /* access modifiers changed from: protected */
    public int[] dg() {
        return f2785b;
    }

    public int cf() {
        int i = this.aa.getInt(cg(), g.f4385a);
        if (Y()) {
            i = g.f4385a;
        }
        return Util.a(i, 0, g(this.n).size() - 1);
    }

    /* access modifiers changed from: protected */
    public List<Integer> f(int i) {
        return com.oppo.camera.f.a.c(i) ? g.e : g.f;
    }

    /* access modifiers changed from: protected */
    public List<String> g(int i) {
        return com.oppo.camera.f.a.c(i) ? g.f4386b : g.c;
    }

    /* access modifiers changed from: protected */
    public boolean fI() {
        return "H265".equals(this.aa.getString("pref_video_codec_key", this.Z.getString(R.string.camera_video_codec_default_value)));
    }

    /* access modifiers changed from: protected */
    public void ba() {
        Object obj;
        h hVar;
        e.a("StickerMode", "startShortVideoRecording");
        if (this.X.z() || !dP() || (hVar = this.aU) == null || hVar.j()) {
            StringBuilder sb = new StringBuilder();
            sb.append("startShortVideoRecording, isDoubleFinger: ");
            sb.append(this.X.z());
            sb.append(", isVideoRecordStopped: ");
            sb.append(dP());
            sb.append(", isAnimation: ");
            h hVar2 = this.aU;
            Object obj2 = "null";
            if (hVar2 == null) {
                obj = obj2;
            } else {
                obj = Boolean.valueOf(hVar2.j());
            }
            sb.append(obj);
            sb.append(", MenuOpen: ");
            h hVar3 = this.aU;
            if (hVar3 != null) {
                obj2 = Boolean.valueOf(hVar3.h());
            }
            sb.append(obj2);
            e.a("StickerMode", sb.toString());
            return;
        }
        this.au.removeMessages(10);
        try {
            this.ax = fS();
        } catch (Exception e) {
            this.ax = null;
            e.a("StickerMode", "startShortVideoRecording, CamcorderProfile.get fail! ", (Throwable) e);
        }
        if (this.ax != null) {
            Size e2 = e(this.W.e());
            e.a("StickerMode", "startShortVideoRecording, preview width: " + e2.getWidth() + ", preview heigth: " + e2.getHeight());
            if (Util.p() || (e2.getWidth() <= 1920 && e2.getHeight() <= 1088)) {
                this.ax.videoFrameWidth = e2.getWidth();
                this.ax.videoFrameHeight = e2.getHeight();
            } else {
                this.ax.videoFrameWidth = 1920;
                this.ax.videoFrameHeight = 912;
            }
        }
        dI();
    }

    private CamcorderProfile fS() {
        try {
            if (Util.p()) {
                return CamcorderProfile.get(this.n, 5);
            }
            if (com.oppo.camera.f.e.c(this.n, 5)) {
                return com.oppo.camera.f.e.a(this.n, 5);
            }
            return com.oppo.camera.f.e.a(this.n, 4);
        } catch (Exception e) {
            e.printStackTrace();
            e.e("StickerMode", "getCamcorderProfile, get CamcorderProfile fail");
            return null;
        }
    }

    public Range<Integer> e() {
        Range<Integer>[] z = com.oppo.camera.f.a.a(this.n).z();
        if (z == null || z.length == 0) {
            return super.e();
        }
        int i = -1;
        int i2 = 300;
        for (int i3 = 0; i3 < z.length; i3++) {
            if (i2 > z[i3].getLower().intValue() && z[i3].getUpper().intValue() == 30) {
                i2 = z[i3].getLower().intValue();
                i = i3;
            }
        }
        if (i >= 0) {
            return z[i];
        }
        return super.e();
    }

    /* access modifiers changed from: protected */
    public void bb() {
        e.a("StickerMode", "stopShortVideoRecording, isVideoRecordStarted: " + dN());
        if (dN()) {
            dI();
            return;
        }
        this.au.removeMessages(10);
        this.au.sendEmptyMessage(10);
    }

    public boolean f(String str) {
        if ("pref_video_size_key".equals(str) || "pref_support_recording_capture".equals(str) || "key_filter_index".equals(str) || "pref_camera_vivid_effect_key".equals(str) || "pref_burst_shot_key".equals(str) || "pref_camera_hdr_mode_key".equals(str) || "pref_video_filter_menu".equals(str) || CameraFunction.FILTER_VIGNETTE.equals(str) || "pref_save_jpg_after_pause_key".equals(str)) {
            return false;
        }
        if ("pref_filter_menu".equals(str)) {
            return f("pref_filter_process_key");
        }
        if (CameraFunction.NEED_PREVIEW_STREAM.equals(str)) {
            return true;
        }
        if ("pref_expand_popbar_key".equals(str)) {
            return this.Y.s();
        }
        if ("pref_camera_videoflashmode_key".equals(str)) {
            return !this.t;
        }
        if ("pref_zoom_key".equals(str)) {
            if (this.t || dO() || Y()) {
                return false;
            }
            return true;
        } else if ("pref_support_thumbnail".equals(str)) {
            return !Y();
        } else {
            if ("pref_dual_camera".equals(str)) {
                return false;
            }
            if ("key_short_video".equals(str)) {
                return true;
            }
            if ("pref_filter_process_key".equals(str)) {
                return AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_FILTER);
            }
            if ("pref_sticker_process_key".equals(str)) {
                return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STICKER);
            }
            if ("pref_omoji_process_key".equals(str)) {
                return f("pref_sticker_process_key");
            }
            if ("pref_support_switch_camera".equals(str)) {
                return super.f(str);
            }
            if ("pref_support_capture_preview".equals(str)) {
                if (this.X == null || !this.X.j()) {
                    return false;
                }
                return true;
            } else if ("pref_auto_night_scence_key".equals(str)) {
                if (this.X == null) {
                    return false;
                }
                return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_COMMON_AUTO_NIGHT_SCENCE);
            } else if ("pref_camera_torch_mode_key".equals(str)) {
                if (!f(CameraFunction.TORCH_SOFT_LIGHT) || Y()) {
                    return false;
                }
                return true;
            } else if (CameraFunction.FACE_BEAUTY_PROCESS.equals(str)) {
                if (!AlgoSwitchConfig.getSupportCaptureAlgo(a(), this.n, ParameterKeys.ALGO_NAME_FACE_BEAUTY) || cj()) {
                    return false;
                }
                return true;
            } else if (CameraFunction.TORCH_SOFT_LIGHT.equals(str)) {
                if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TORCH_SOFT_LIGHT) || !this.t) {
                    return false;
                }
                return true;
            } else if (CameraFunction.FACE_BEAUTY_CUSTOM.equals(str)) {
                if (!f(CameraFunction.FACE_BEAUTY_PROCESS) || !this.t) {
                    return false;
                }
                return true;
            } else if (CameraFunction.FACE_BEAUTY_COMMON.equals(str)) {
                if (!f(CameraFunction.FACE_BEAUTY_PROCESS) || this.t) {
                    return false;
                }
                return true;
            } else if ("pref_camera_assistant_line_key".equals(str) || "pref_assist_gradienter".equals(str)) {
                if (Y() || cj() || cd() || dO()) {
                    return false;
                }
                return true;
            } else if ("pref_camera_line_video".equals(str)) {
                return false;
            } else {
                if ("pref_time_lapse_key".equals(str) || "pref_camera_tap_shutter_key".equals(str)) {
                    return !Y();
                }
                if ("pref_camera_gesture_shutter_key".equals(str)) {
                    if (!this.t || Y()) {
                        return false;
                    }
                    return true;
                } else if (CameraFunction.FACE_SLENDER_PROCESS.equals(str)) {
                    if ((this.t || CameraConfig.getConfigIntValue(ConfigDataBase.KEY_FACE_BEAUTY_VERSION_CODE) >= 6) && !Z()) {
                        return true;
                    }
                    return false;
                } else if ("pref_filter_menu".equals(str) && (cj() || Y())) {
                    return false;
                } else {
                    if ("key_support_show_no_face".equals(str)) {
                        if (!this.A || !cj() || Y()) {
                            return false;
                        }
                        return true;
                    } else if ("pref_camera_photo_ratio_key".equals(str)) {
                        return true;
                    } else {
                        if (CameraFunction.SAT_CAMERA.equalsIgnoreCase(str)) {
                            return false;
                        }
                        if ("key_support_share_edit_thumb".equals(str)) {
                            return !dV();
                        }
                        return super.f(str);
                    }
                }
            }
        }
    }

    public DcsMsgData b(DcsMsgData dcsMsgData) {
        if (dcsMsgData == null) {
            return null;
        }
        if (dcsMsgData instanceof CaptureMsgData) {
            return c(dcsMsgData);
        }
        if (dcsMsgData instanceof VideoRecordMsgData) {
            return d(dcsMsgData);
        }
        return null;
    }

    private DcsMsgData c(DcsMsgData dcsMsgData) {
        StickerItem j;
        if (dcsMsgData == null || !(dcsMsgData instanceof CaptureMsgData)) {
            return null;
        }
        CaptureMsgData captureMsgData = (CaptureMsgData) dcsMsgData;
        captureMsgData.mCaptureMode = ApsConstant.CAPTURE_MODE_STICKER;
        captureMsgData.mCaptureType = 2;
        captureMsgData.mTouchXYValue = this.X.Y();
        captureMsgData.mMemoryValue = String.valueOf(Util.i((Context) this.Z) / 1024);
        if (f("pref_filter_process_key")) {
            captureMsgData.mFilterType = g.a(cf(), this.n);
        }
        if (f("pref_sticker_process_key") && (j = this.ab.j()) != null) {
            captureMsgData.mStickerName = j.getStickerName();
            captureMsgData.mStickerType = String.valueOf(j.getMaterialType());
            captureMsgData.mStickerUuid = j.getStickerUUID();
            captureMsgData.mProtocolVersion = String.valueOf(j.getProtocolVersion());
        }
        int[] dh = dh();
        int i = 102;
        if (f(CameraFunction.FACE_BEAUTY_CUSTOM)) {
            int length = de().length;
            if (!cb()) {
                i = 0;
            }
            captureMsgData.mSmooth = i;
            if (dh != null && length == dh.length) {
                captureMsgData.parseFaceBeauty(dh);
            }
        } else if (f(CameraFunction.FACE_BEAUTY_COMMON)) {
            if (!cb()) {
                i = 0;
            }
            captureMsgData.mSmooth = i;
            if (dh != null) {
                captureMsgData.mSmoothDermabrasion = dh()[0];
            }
        }
        if ("full".equals(captureMsgData.mPicSizeType)) {
            captureMsgData.mPicSizeType = "16_9";
        }
        return (CaptureMsgData) super.b((DcsMsgData) captureMsgData);
    }

    private DcsMsgData d(DcsMsgData dcsMsgData) {
        if (dcsMsgData == null || !(dcsMsgData instanceof VideoRecordMsgData)) {
            return null;
        }
        VideoRecordMsgData videoRecordMsgData = (VideoRecordMsgData) dcsMsgData;
        videoRecordMsgData.mLux = String.valueOf(this.aD);
        videoRecordMsgData.mCct = String.valueOf(this.aE);
        videoRecordMsgData.mIso = String.valueOf(this.aF);
        videoRecordMsgData.mExp = String.valueOf(this.aG);
        StickerItem j = this.ab.j();
        if (j == null) {
            return null;
        }
        videoRecordMsgData.mStickerName = j.getStickerName();
        videoRecordMsgData.mStickerType = String.valueOf(j.getMaterialType());
        videoRecordMsgData.mStickerUuid = j.getStickerUUID();
        videoRecordMsgData.mProtocolVersion = String.valueOf(j.getProtocolVersion());
        return (VideoRecordMsgData) super.b((DcsMsgData) videoRecordMsgData);
    }

    public DcsMsgData b(DcsMsgData dcsMsgData, z.a aVar) {
        CaptureMsgData captureMsgData;
        if (dcsMsgData == null || !(dcsMsgData instanceof CaptureMsgData)) {
            captureMsgData = null;
        } else {
            captureMsgData = (CaptureMsgData) dcsMsgData;
            Size a2 = z.a(Util.a(aVar.e));
            if (a2 != null) {
                captureMsgData.mWidth = String.valueOf(a2.getWidth());
                captureMsgData.mHeight = String.valueOf(a2.getHeight());
            }
            if (TextUtils.isEmpty(captureMsgData.mFlashMode)) {
                captureMsgData.mFlashMode = "off";
            }
            captureMsgData.mFlashTrigger = com.oppo.camera.a.a.a(bu());
        }
        return (CaptureMsgData) super.b((DcsMsgData) captureMsgData, aVar);
    }

    public boolean d(String str) {
        if ("pref_camera_photo_ratio_key".equals(str) || "pref_camera_timer_shutter_key".equals(str) || "pref_setting_key".equals(str)) {
            return true;
        }
        if ("pref_camera_timer_shutter_key".equals(str) || "pref_video_size_key".equals(str)) {
            return false;
        }
        if ("pref_camera_hdr_mode_key".equals(str) || "pref_camera_vivid_effect_key".equals(str)) {
            return f(str);
        }
        if ((!"pref_filter_menu".equals(str) || (!cj() && !Y())) && !"pref_video_filter_menu".equals(str)) {
            return super.d(str);
        }
        return false;
    }

    public boolean i(String str) {
        if ("pref_camera_timer_shutter_key".equals(str) || "pref_camera_photo_ratio_key".equals(str)) {
            return true;
        }
        return super.i(str);
    }

    /* access modifiers changed from: protected */
    public boolean a(d dVar) {
        e.a("StickerMode", "onBeforeSnapping");
        if (cj()) {
            s i = this.ab.i(16);
            if (i.a(16) && !i.a()) {
                return false;
            }
        }
        this.Z.runOnUiThread(new Runnable() {
            public void run() {
                if (r.this.y) {
                    e.a("StickerMode", "onBeforeSnapping, return after pause");
                    return;
                }
                r.this.aU.a(false);
                r.this.aU.b(false);
            }
        });
        return true;
    }

    public void bh() {
        f(false, true);
        if (this.Y.C()) {
            this.Y.b(false, false, false);
        }
        this.Y.D(true);
        this.X.a((Animation.AnimationListener) null);
        this.X.d(false);
        this.Y.j(4);
        if (p("key_bubble_sticker")) {
            this.Y.c(3, false);
        }
        if (p("key_bubble_short_video")) {
            this.Y.c(4, true);
        }
        if (!q("key_bubble_short_video")) {
            b("key_bubble_short_video", false);
        }
        super.bh();
    }

    public void bj() {
        this.Y.ae();
        if (this.aU.h()) {
            g(true, true);
            this.Y.j(0);
            return;
        }
        g(true, false);
        this.X.D();
        this.X.d(true);
        this.Y.j(0);
        this.Y.r(true);
        if (p("key_bubble_sticker")) {
            this.Y.a((View) this.aU.a(), 3, G(3), H(3));
        }
        super.bj();
    }

    /* access modifiers changed from: protected */
    public void e_() {
        if (this.Y != null) {
            this.Y.k(60000);
            com.oppo.camera.ui.control.c cVar = new com.oppo.camera.ui.control.c();
            cVar.a(13);
            this.Y.a(cVar);
        }
        super.e_();
    }

    /* access modifiers changed from: protected */
    public void f_() {
        this.Y.a(o());
        super.f_();
    }

    /* access modifiers changed from: protected */
    public boolean v() {
        return !dP();
    }

    public boolean r(String str) {
        if ("type_video".equals(str)) {
            return false;
        }
        if ("type_preview_frame".equals(str)) {
            if (2 != AlgoSwitchConfig.getApsVersion()) {
                return false;
            }
            if (f("pref_omoji_process_key") || f("pref_camera_gesture_shutter_key")) {
                return true;
            }
            return false;
        } else if ("type_still_capture_yuv_main".equals(str) || "type_still_capture_yuv_sub".equals(str) || "type_still_capture_yuv_third".equals(str)) {
            return false;
        } else {
            if ("type_still_capture_jpeg".equals(str)) {
                return !AlgoSwitchConfig.getSupportApsCapture();
            }
            return super.r(str);
        }
    }

    /* access modifiers changed from: protected */
    public void a(d dVar, CaptureRequest.Builder builder, HashMap<String, f.C0084f> hashMap, int i) {
        if (d.a.PREVIEW == dVar.a() && ((cO() || cj()) && hashMap.containsKey("type_preview_frame"))) {
            builder.addTarget(hashMap.get("type_preview_frame").a());
        }
        super.a(dVar, builder, hashMap, i);
    }

    public d b(ApsAdapterDecision.DecisionResult decisionResult) {
        d b2 = super.b(decisionResult);
        b2.P = true;
        b2.R = true;
        b2.Q = cj();
        return b2;
    }

    public void n(int i) {
        if (this.ab != null) {
            this.ab.a(p(i));
            this.ab.c(false);
        }
        super.n(i);
        I(i);
    }

    public boolean d(MotionEvent motionEvent) {
        if (this.ab != null) {
            return false;
        }
        this.Y.i().getHitRect(new Rect());
        return super.d(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z, boolean z2, boolean z3) {
        super.a(z, z2, z3);
        if (z2) {
            this.X.c(0);
            this.X.i();
        }
    }

    public void a(ThumbnailItem thumbnailItem) {
        synchronized (this.aT) {
            this.bk = thumbnailItem;
            if (thumbnailItem.mRequestHash == ((long) this.bl)) {
                fT();
            }
        }
    }

    private void fT() {
        e.a("StickerMode", "savePictureUseThumb");
        if (this.aj != null) {
            this.aj.setCapturing(false);
        }
        final z.a aVar = new z.a();
        aVar.c = this.bk.mUri;
        aVar.x = true;
        aVar.h = this.bk.mJpegName;
        aVar.f3177a = this.bk.mResolver;
        aVar.n = this.bk.mDate;
        aVar.F = this.bk.mbLockScreen;
        aVar.k = ApsConstant.CAPTURE_MODE_STICKER;
        aVar.u = this.n;
        aVar.E = false;
        aVar.j = eq() != null ? eq() : "jpeg";
        aVar.e = a(aVar, this.bk.mOriginBitmap, !this.bk.mbMirror, this.t, this.k, this.bk.mTimeStamp);
        com.oppo.camera.n.b.a().c(aVar);
        if (this.Z != null && !this.y) {
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    r.this.a((byte[]) null, 0, 0, Util.a(256), false, false, 0);
                    if (r.this.X != null) {
                        r.this.X.b(aVar);
                    }
                }
            });
        }
    }

    public void a(TotalCaptureResult totalCaptureResult) {
        super.a(totalCaptureResult);
        if (this.bp) {
            synchronized (this.aT) {
                this.aX = (Float) totalCaptureResult.get(CaptureResult.LENS_FOCAL_LENGTH);
                this.aY = (Float) totalCaptureResult.get(CaptureResult.LENS_APERTURE);
                this.aZ = (Integer) totalCaptureResult.get(CaptureResult.SENSOR_SENSITIVITY);
                this.ba = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_MODE);
                this.bb = (Long) totalCaptureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
            }
            this.bp = false;
        }
    }

    public void eV() {
        this.bp = true;
    }

    public void a(ApsCaptureResult apsCaptureResult, CaptureRequest captureRequest) {
        super.a(apsCaptureResult, captureRequest);
        synchronized (this.aT) {
            this.aX = apsCaptureResult.mFocalLength;
            this.aY = apsCaptureResult.mLensAperture;
            this.aZ = apsCaptureResult.mSensorSensitivity;
            this.ba = apsCaptureResult.mAwbMode;
            this.bb = apsCaptureResult.mSensorExposureTime;
            e.a("StickerMode", "onCaptureCompleted, mCurrentFocalLength: " + this.aX + ", mCurrentAperture: " + this.aY + ", mCurrentISO: " + this.aZ + ", mCurrentWhiteBalanceMode: " + this.ba + ", mCurrentExposureTime: " + this.bb);
        }
        ThumbnailItem thumbnailItem = this.bk;
        if (thumbnailItem == null || thumbnailItem.mRequestHash != ((long) captureRequest.getTag().hashCode())) {
            this.bl = captureRequest.getTag().hashCode();
        } else {
            fT();
        }
        if (this.Z != null) {
            this.Z.runOnUiThread(new Runnable() {
                public void run() {
                    if (!r.this.z) {
                        r.this.a((byte[]) null, false);
                    }
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0060, code lost:
        r13 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0061, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0065, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0066, code lost:
        r7 = r14;
        r14 = r13;
        r13 = r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(com.oppo.camera.z.a r9, android.graphics.Bitmap r10, boolean r11, boolean r12, int r13, long r14) {
        /*
            r8 = this;
            if (r12 != 0) goto L_0x0009
            r11 = 0
            android.graphics.Bitmap r11 = com.oppo.camera.util.Util.a((android.graphics.Bitmap) r10, (int) r13, (boolean) r11)
        L_0x0007:
            r1 = r11
            goto L_0x001d
        L_0x0009:
            r12 = 90
            if (r13 == r12) goto L_0x0012
            r12 = 270(0x10e, float:3.78E-43)
            if (r13 == r12) goto L_0x0012
            goto L_0x0018
        L_0x0012:
            if (r11 == 0) goto L_0x0018
            int r13 = r13 + 180
            int r13 = r13 % 360
        L_0x0018:
            android.graphics.Bitmap r11 = com.oppo.camera.util.Util.a((android.graphics.Bitmap) r10, (int) r13, (boolean) r11)
            goto L_0x0007
        L_0x001d:
            java.lang.String r11 = r8.eq()
            r12 = 0
            if (r11 == 0) goto L_0x004c
            com.oppo.exif.OppoExifInterface r4 = new com.oppo.exif.OppoExifInterface
            r4.<init>()
            long r10 = r9.n
            r8.a((com.oppo.exif.OppoExifInterface) r4, (long) r10)
            com.oppo.camera.m.b r10 = new com.oppo.camera.m.b
            java.lang.String r11 = r8.eq()
            java.lang.String r13 = "heic_8bits"
            boolean r11 = r13.equals(r11)
            r10.<init>(r11)
            r2 = 0
            r3 = 100
            android.content.ContentResolver r5 = r9.f3177a
            android.net.Uri r6 = r9.c
            r0 = r10
            r0.a(r1, r2, r3, r4, r5, r6)
            r10.a()
            return r12
        L_0x004c:
            java.io.ByteArrayOutputStream r11 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0078 }
            r11.<init>()     // Catch:{ IOException -> 0x0078 }
            android.graphics.Bitmap$CompressFormat r13 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Throwable -> 0x0063, all -> 0x0060 }
            r14 = 100
            r1.compress(r13, r14, r11)     // Catch:{ Throwable -> 0x0063, all -> 0x0060 }
            byte[] r12 = r11.toByteArray()     // Catch:{ Throwable -> 0x0063, all -> 0x0060 }
            r11.close()     // Catch:{ IOException -> 0x0078 }
            goto L_0x007c
        L_0x0060:
            r13 = move-exception
            r14 = r12
            goto L_0x0069
        L_0x0063:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r14 = move-exception
            r7 = r14
            r14 = r13
            r13 = r7
        L_0x0069:
            if (r14 == 0) goto L_0x0074
            r11.close()     // Catch:{ Throwable -> 0x006f }
            goto L_0x0077
        L_0x006f:
            r11 = move-exception
            r14.addSuppressed(r11)     // Catch:{ IOException -> 0x0078 }
            goto L_0x0077
        L_0x0074:
            r11.close()     // Catch:{ IOException -> 0x0078 }
        L_0x0077:
            throw r13     // Catch:{ IOException -> 0x0078 }
        L_0x0078:
            r11 = move-exception
            r11.printStackTrace()
        L_0x007c:
            boolean r11 = r1.isRecycled()
            if (r11 != 0) goto L_0x0085
            r1.recycle()
        L_0x0085:
            boolean r11 = r10.isRecycled()
            if (r11 != 0) goto L_0x008e
            r10.recycle()
        L_0x008e:
            long r9 = r9.n
            byte[] r9 = r8.a((byte[]) r12, (long) r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.r.a(com.oppo.camera.z$a, android.graphics.Bitmap, boolean, boolean, int, long):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052 A[SYNTHETIC, Splitter:B:17:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072 A[SYNTHETIC, Splitter:B:26:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] a(byte[] r6, long r7) {
        /*
            r5 = this;
            java.lang.String r0 = "addExif, close exif stream, exception: "
            java.lang.String r1 = "StickerMode"
            com.oppo.exif.OppoExifInterface r2 = new com.oppo.exif.OppoExifInterface
            r2.<init>()
            r3 = 0
            r5.a((com.oppo.exif.OppoExifInterface) r2, (long) r7)     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            r7.<init>()     // Catch:{ Exception -> 0x0036, all -> 0x0033 }
            r2.writeExif((byte[]) r6, (java.io.OutputStream) r7)     // Catch:{ Exception -> 0x0031 }
            byte[] r8 = r7.toByteArray()     // Catch:{ Exception -> 0x0031 }
            r7.close()     // Catch:{ Exception -> 0x001d }
            goto L_0x006a
        L_0x001d:
            r7 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            com.oppo.camera.e.e(r1, r7)
            goto L_0x006a
        L_0x0031:
            r8 = move-exception
            goto L_0x0038
        L_0x0033:
            r6 = move-exception
            r7 = r3
            goto L_0x0070
        L_0x0036:
            r8 = move-exception
            r7 = r3
        L_0x0038:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006f }
            r2.<init>()     // Catch:{ all -> 0x006f }
            java.lang.String r4 = "addExif, processExif failed, exception: "
            r2.append(r4)     // Catch:{ all -> 0x006f }
            java.lang.String r4 = r8.getMessage()     // Catch:{ all -> 0x006f }
            r2.append(r4)     // Catch:{ all -> 0x006f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x006f }
            com.oppo.camera.e.d(r1, r2, r8)     // Catch:{ all -> 0x006f }
            if (r7 == 0) goto L_0x0069
            r7.close()     // Catch:{ Exception -> 0x0056 }
            goto L_0x0069
        L_0x0056:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r0)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.oppo.camera.e.e(r1, r7)
        L_0x0069:
            r8 = r3
        L_0x006a:
            if (r8 != 0) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r6 = r8
        L_0x006e:
            return r6
        L_0x006f:
            r6 = move-exception
        L_0x0070:
            if (r7 == 0) goto L_0x0089
            r7.close()     // Catch:{ Exception -> 0x0076 }
            goto L_0x0089
        L_0x0076:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r0)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.oppo.camera.e.e(r1, r7)
        L_0x0089:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.r.a(byte[], long):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x010a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.oppo.exif.OppoExifInterface r8, long r9) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x000a
            java.lang.String r8 = "StickerMode"
            java.lang.String r9 = "buildExif, exifInterface is null"
            com.oppo.camera.e.e(r8, r9)
            return
        L_0x000a:
            java.lang.Object r0 = r7.aT
            monitor-enter(r0)
            java.lang.Float r1 = r7.aX     // Catch:{ all -> 0x019b }
            if (r1 == 0) goto L_0x002b
            int r1 = com.oppo.exif.OppoExifInterface.TAG_FOCAL_LENGTH     // Catch:{ all -> 0x019b }
            com.oppo.exif.OppoRational r2 = new com.oppo.exif.OppoRational     // Catch:{ all -> 0x019b }
            java.lang.Float r3 = r7.aX     // Catch:{ all -> 0x019b }
            float r3 = r3.floatValue()     // Catch:{ all -> 0x019b }
            r4 = 1120403456(0x42c80000, float:100.0)
            float r3 = r3 * r4
            long r3 = (long) r3     // Catch:{ all -> 0x019b }
            r5 = 100
            r2.<init>(r3, r5)     // Catch:{ all -> 0x019b }
            com.oppo.exif.OppoExifTag r1 = r8.buildTag(r1, r2)     // Catch:{ all -> 0x019b }
            r8.setTag(r1)     // Catch:{ all -> 0x019b }
        L_0x002b:
            java.lang.Float r1 = r7.aY     // Catch:{ all -> 0x019b }
            if (r1 == 0) goto L_0x0049
            int r1 = com.oppo.exif.OppoExifInterface.TAG_F_NUMBER     // Catch:{ all -> 0x019b }
            com.oppo.exif.OppoRational r2 = new com.oppo.exif.OppoRational     // Catch:{ all -> 0x019b }
            java.lang.Float r3 = r7.aY     // Catch:{ all -> 0x019b }
            float r3 = r3.floatValue()     // Catch:{ all -> 0x019b }
            r4 = 1092616192(0x41200000, float:10.0)
            float r3 = r3 * r4
            long r3 = (long) r3     // Catch:{ all -> 0x019b }
            r5 = 10
            r2.<init>(r3, r5)     // Catch:{ all -> 0x019b }
            com.oppo.exif.OppoExifTag r1 = r8.buildTag(r1, r2)     // Catch:{ all -> 0x019b }
            r8.setTag(r1)     // Catch:{ all -> 0x019b }
        L_0x0049:
            java.lang.Integer r1 = r7.aZ     // Catch:{ all -> 0x019b }
            if (r1 == 0) goto L_0x0060
            int r1 = com.oppo.exif.OppoExifInterface.TAG_ISO_SPEED_RATINGS     // Catch:{ all -> 0x019b }
            java.lang.Integer r2 = r7.aZ     // Catch:{ all -> 0x019b }
            short r2 = r2.shortValue()     // Catch:{ all -> 0x019b }
            java.lang.Short r2 = java.lang.Short.valueOf(r2)     // Catch:{ all -> 0x019b }
            com.oppo.exif.OppoExifTag r1 = r8.buildTag(r1, r2)     // Catch:{ all -> 0x019b }
            r8.setTag(r1)     // Catch:{ all -> 0x019b }
        L_0x0060:
            boolean r1 = r7.cC()     // Catch:{ all -> 0x019b }
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0081
            boolean r1 = r7.cF()     // Catch:{ all -> 0x019b }
            if (r1 != 0) goto L_0x0081
            boolean r1 = r7.cD()     // Catch:{ all -> 0x019b }
            if (r1 != 0) goto L_0x007a
            boolean r1 = r7.cE()     // Catch:{ all -> 0x019b }
            if (r1 == 0) goto L_0x007f
        L_0x007a:
            boolean r1 = r7.E     // Catch:{ all -> 0x019b }
            if (r1 == 0) goto L_0x007f
            goto L_0x0081
        L_0x007f:
            r1 = r2
            goto L_0x0082
        L_0x0081:
            r1 = r3
        L_0x0082:
            int r4 = com.oppo.exif.OppoExifInterface.TAG_FLASH     // Catch:{ all -> 0x019b }
            java.lang.Short r1 = java.lang.Short.valueOf(r1)     // Catch:{ all -> 0x019b }
            com.oppo.exif.OppoExifTag r1 = r8.buildTag(r4, r1)     // Catch:{ all -> 0x019b }
            r8.setTag(r1)     // Catch:{ all -> 0x019b }
            java.lang.Integer r1 = r7.ba     // Catch:{ all -> 0x019b }
            if (r1 == 0) goto L_0x00aa
            java.lang.Integer r1 = r7.ba     // Catch:{ all -> 0x019b }
            int r1 = r1.intValue()     // Catch:{ all -> 0x019b }
            if (r1 != r3) goto L_0x009c
            goto L_0x009d
        L_0x009c:
            r2 = r3
        L_0x009d:
            int r1 = com.oppo.exif.OppoExifInterface.TAG_WHITE_BALANCE     // Catch:{ all -> 0x019b }
            java.lang.Short r2 = java.lang.Short.valueOf(r2)     // Catch:{ all -> 0x019b }
            com.oppo.exif.OppoExifTag r1 = r8.buildTag(r1, r2)     // Catch:{ all -> 0x019b }
            r8.setTag(r1)     // Catch:{ all -> 0x019b }
        L_0x00aa:
            java.lang.Long r1 = r7.bb     // Catch:{ all -> 0x019b }
            if (r1 == 0) goto L_0x00c5
            int r1 = com.oppo.exif.OppoExifInterface.TAG_EXPOSURE_TIME     // Catch:{ all -> 0x019b }
            com.oppo.exif.OppoRational r2 = new com.oppo.exif.OppoRational     // Catch:{ all -> 0x019b }
            java.lang.Long r3 = r7.bb     // Catch:{ all -> 0x019b }
            long r3 = r3.longValue()     // Catch:{ all -> 0x019b }
            r5 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            r2.<init>(r3, r5)     // Catch:{ all -> 0x019b }
            com.oppo.exif.OppoExifTag r1 = r8.buildTag(r1, r2)     // Catch:{ all -> 0x019b }
            r8.setTag(r1)     // Catch:{ all -> 0x019b }
        L_0x00c5:
            com.oppo.camera.e.b r1 = r7.X     // Catch:{ all -> 0x019b }
            if (r1 == 0) goto L_0x00dc
            com.oppo.camera.e.b r1 = r7.X     // Catch:{ all -> 0x019b }
            android.location.Location r1 = r1.v()     // Catch:{ all -> 0x019b }
            if (r1 == 0) goto L_0x00dc
            double r2 = r1.getLatitude()     // Catch:{ all -> 0x019b }
            double r4 = r1.getLongitude()     // Catch:{ all -> 0x019b }
            r8.addGpsTags(r2, r4)     // Catch:{ all -> 0x019b }
        L_0x00dc:
            int r1 = com.oppo.exif.OppoExifInterface.TAG_USER_COMMENT     // Catch:{ all -> 0x019b }
            java.lang.String r2 = "oppo_"
            java.lang.String r3 = "sticker"
            int r4 = r7.n     // Catch:{ all -> 0x019b }
            int r3 = com.oppo.camera.h.b.a(r3, r4)     // Catch:{ all -> 0x019b }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x019b }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ all -> 0x019b }
            com.oppo.exif.OppoExifTag r1 = r8.buildTag(r1, r2)     // Catch:{ all -> 0x019b }
            r8.setTag(r1)     // Catch:{ all -> 0x019b }
            int r1 = com.oppo.exif.OppoExifInterface.TAG_MODEL     // Catch:{ all -> 0x019b }
            java.lang.String r2 = com.oppo.camera.util.Util.n()     // Catch:{ all -> 0x019b }
            com.oppo.exif.OppoExifTag r1 = r8.buildTag(r1, r2)     // Catch:{ all -> 0x019b }
            r8.setTag(r1)     // Catch:{ all -> 0x019b }
            r1 = 0
            int r1 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r1 == 0) goto L_0x0199
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x019b }
            java.lang.String r2 = "yyyy:MM:dd HH:mm:ss"
            java.util.Locale r3 = java.util.Locale.US     // Catch:{ all -> 0x019b }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x019b }
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x019b }
            java.lang.String r3 = "yyyy:MM:dd"
            java.util.Locale r4 = java.util.Locale.US     // Catch:{ all -> 0x019b }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x019b }
            java.util.Calendar r3 = java.util.Calendar.getInstance()     // Catch:{ all -> 0x019b }
            java.util.TimeZone r3 = r3.getTimeZone()     // Catch:{ all -> 0x019b }
            r1.setTimeZone(r3)     // Catch:{ all -> 0x019b }
            java.lang.String r3 = "UTC"
            java.util.TimeZone r3 = java.util.TimeZone.getTimeZone(r3)     // Catch:{ all -> 0x019b }
            r2.setTimeZone(r3)     // Catch:{ all -> 0x019b }
            int r3 = com.oppo.exif.OppoExifInterface.TAG_DATE_TIME     // Catch:{ all -> 0x019b }
            java.lang.Long r4 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x019b }
            java.lang.String r4 = r1.format(r4)     // Catch:{ all -> 0x019b }
            com.oppo.exif.OppoExifTag r3 = r8.buildTag(r3, r4)     // Catch:{ all -> 0x019b }
            r8.setTag(r3)     // Catch:{ all -> 0x019b }
            int r3 = com.oppo.exif.OppoExifInterface.TAG_DATE_TIME_ORIGINAL     // Catch:{ all -> 0x019b }
            java.lang.Long r4 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x019b }
            java.lang.String r1 = r1.format(r4)     // Catch:{ all -> 0x019b }
            com.oppo.exif.OppoExifTag r1 = r8.buildTag(r3, r1)     // Catch:{ all -> 0x019b }
            r8.setTag(r1)     // Catch:{ all -> 0x019b }
            java.time.Instant r1 = java.time.Instant.ofEpochMilli(r9)     // Catch:{ all -> 0x019b }
            java.time.ZoneId r3 = java.time.ZoneId.systemDefault()     // Catch:{ all -> 0x019b }
            java.time.ZonedDateTime r1 = java.time.ZonedDateTime.ofInstant(r1, r3)     // Catch:{ all -> 0x019b }
            java.lang.String r3 = "SSS"
            java.time.format.DateTimeFormatter r3 = java.time.format.DateTimeFormatter.ofPattern(r3)     // Catch:{ all -> 0x019b }
            java.lang.String r3 = r3.format(r1)     // Catch:{ all -> 0x019b }
            int r4 = com.oppo.exif.OppoExifInterface.TAG_SUB_SEC_TIME_ORIGINAL     // Catch:{ all -> 0x019b }
            com.oppo.exif.OppoExifTag r3 = r8.buildTag(r4, r3)     // Catch:{ all -> 0x019b }
            r8.setTag(r3)     // Catch:{ all -> 0x019b }
            java.lang.String r3 = "XXX"
            java.time.format.DateTimeFormatter r3 = java.time.format.DateTimeFormatter.ofPattern(r3)     // Catch:{ all -> 0x019b }
            java.lang.String r1 = r3.format(r1)     // Catch:{ all -> 0x019b }
            int r3 = com.oppo.exif.OppoExifInterface.TAG_OFFSET_TIME_ORIGINAL     // Catch:{ all -> 0x019b }
            r4 = 2
            com.oppo.exif.OppoExifTag r1 = r8.buildTag(r3, r4, r1)     // Catch:{ all -> 0x019b }
            r8.setTag(r1)     // Catch:{ all -> 0x019b }
            r8.addGpsDateTimeStampTag(r9)     // Catch:{ all -> 0x019b }
            int r1 = com.oppo.exif.OppoExifInterface.TAG_GPS_DATE_STAMP     // Catch:{ all -> 0x019b }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x019b }
            java.lang.String r9 = r2.format(r9)     // Catch:{ all -> 0x019b }
            com.oppo.exif.OppoExifTag r9 = r8.buildTag(r1, r9)     // Catch:{ all -> 0x019b }
            r8.setTag(r9)     // Catch:{ all -> 0x019b }
        L_0x0199:
            monitor-exit(r0)     // Catch:{ all -> 0x019b }
            return
        L_0x019b:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x019b }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.e.r.a(com.oppo.exif.OppoExifInterface, long):void");
    }

    /* access modifiers changed from: protected */
    public void b(byte[] bArr, boolean z) {
        e.a("StickerMode", "onBeforePictureTaken");
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, boolean z) {
        e.a("StickerMode", "onAfterPictureTaken");
        if (this.X != null) {
            if (this.X.j()) {
                this.X.n();
                this.Y.d(true, false);
            }
            if (!this.Y.s()) {
                this.aU.a(true);
                this.aU.b(true);
            }
            if (!q("key_bubble_short_video") && !Y()) {
                b("key_bubble_short_video", true);
                this.Y.a((View) null, 4, G(4), H(4));
            }
        }
    }

    public Size d(j jVar) {
        Size size;
        String string = this.aa.getString("pref_camera_photo_ratio_key", this.Z.getString(R.string.camera_photo_ratio_default_value));
        List<Size> a2 = jVar.a(aQ());
        if ("full".equals(string)) {
            size = Util.a(a2, "5000000", 0);
        } else {
            size = Util.a(a2, "5000000", Util.a(string));
        }
        if (size != null) {
            return size;
        }
        return super.d(jVar);
    }

    public Size e(j jVar) {
        Size size;
        Size d = d(jVar);
        List<Size> a2 = jVar.a();
        int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_STICKER_TARGET_PREVIEW_HEIGHT);
        if ("standard".equals(Util.a(d, this.n))) {
            size = Util.a(configIntValue, a2, 1.3333333333333333d);
        } else if ("16_9".equals(Util.a(d, this.n))) {
            size = Util.a(configIntValue, a2, 1.7777777777777777d);
        } else {
            size = "square".equals(Util.a(d, this.n)) ? Util.a(configIntValue, a2, 1.0d) : null;
        }
        if (size != null) {
            return size;
        }
        return super.e(jVar);
    }

    public boolean ea() {
        if (!Util.p()) {
            return super.ea();
        }
        if (this.z) {
            return false;
        }
        if ((this.t && cb()) || this.X.C()) {
            return true;
        }
        if (1 == this.X.h() || 2 == this.X.h()) {
            return false;
        }
        return true;
    }

    public boolean br() {
        if ((this.X == null || this.X.j()) && !Util.p()) {
            return super.br();
        }
        return true;
    }

    public com.oppo.camera.ui.control.c o() {
        String str = "button_shape_ring_none";
        if (this.aa != null) {
            String string = this.aa.getString("pref_camera_timer_shutter_key", this.Z.getString(R.string.camera_shutter_mode_default_value));
            if (FocusAimMsgData.KEY_INTELLIGENCE_VIEW_FOCUS_TYPE.equals(string)) {
                str = "button_shape_countdown_ten_seconds";
            } else if ("3".equals(string)) {
                str = "button_shape_countdown_three_seconds";
            }
        }
        return new com.oppo.camera.ui.control.c(1, "button_color_inside_none", str, 0);
    }

    public void c(boolean z) {
        com.oppo.camera.ui.control.c o = o();
        o.b(0);
        this.Y.a(o);
    }

    public boolean e(String str) {
        if (!"pref_face_detection_key".equals(str) || !dO()) {
            return super.e(str);
        }
        return false;
    }

    public void cx() {
        StringBuilder sb = new StringBuilder();
        int i = this.bm;
        if (i > 0) {
            String format = CameraStatisticsUtil.format(CameraStatisticsUtil.OMOJI_HUMAN_GENERATE_GIF, String.valueOf(i));
            this.bm = 0;
            sb.append(format);
        }
        int i2 = this.be;
        if (i2 > 0) {
            String format2 = CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_RECYCLEBIN_CLICK, String.valueOf(i2));
            this.be = 0;
            sb.append(format2);
        }
        int i3 = this.bf;
        if (i3 > 0) {
            String format3 = CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_RECYCLEBIN_DELETEALL, String.valueOf(i3));
            this.bf = 0;
            sb.append(format3);
        }
        a(this.bi, sb);
        b(this.bh, sb);
        this.bg = null;
        if (sb.length() > 0) {
            CameraStatisticsUtil.onCommon(this.Z, CameraStatisticsUtil.EVENT_MENU_CLICK, sb.toString(), false);
        }
        this.bn = System.currentTimeMillis() - this.bn;
        long j = this.bn;
        if (j > 0) {
            CameraStatisticsUtil.onCommon(this.Z, CameraStatisticsUtil.EVENT_ENTER_STICKER, CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_MODE_USE_TIME, String.valueOf(j)), false);
        }
        this.bn = 0;
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        if (this.bi == null) {
            this.bi = new HashMap<>();
        }
        String str3 = str + "_" + str2;
        if (this.bi.containsKey(str3)) {
            HashMap<String, Integer> hashMap = this.bi;
            hashMap.put(str3, Integer.valueOf(hashMap.get(str3).intValue() + 1));
            return;
        }
        this.bi.put(str3, 1);
    }

    private void a(HashMap<String, Integer> hashMap, StringBuilder sb) {
        if (hashMap != null) {
            for (String next : hashMap.keySet()) {
                sb.append(CameraStatisticsUtil.format(next, String.valueOf(hashMap.get(next))));
            }
            if (hashMap != null) {
                hashMap.clear();
            }
        }
    }

    private void c(String str, String str2) {
        String[] split;
        if (this.bh == null) {
            this.bh = new HashMap<>();
        }
        String str3 = this.bg;
        if (!(str3 == null || (split = str3.split("\\.")) == null || split.length <= 1)) {
            String str4 = str + "_" + split[0];
            long currentTimeMillis = System.currentTimeMillis() - Long.parseLong(split[1]);
            if (this.bh.containsKey(str4)) {
                HashMap<String, Long> hashMap = this.bh;
                hashMap.put(str4, Long.valueOf(hashMap.get(str4).longValue() + currentTimeMillis));
            } else {
                this.bh.put(str4, Long.valueOf(currentTimeMillis));
            }
        }
        this.bg = str2 + "." + System.currentTimeMillis();
    }

    private void b(HashMap<String, Long> hashMap, StringBuilder sb) {
        if (hashMap != null) {
            for (String next : hashMap.keySet()) {
                sb.append(CameraStatisticsUtil.format(next, String.valueOf(hashMap.get(next))));
            }
            if (hashMap != null) {
                hashMap.clear();
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean a(StickerItem stickerItem, int i) {
        if (this.X == null) {
            return false;
        }
        if (stickerItem == null || this.X.P() || W()) {
            e.e("StickerMode", "onStickerItemClick, item: " + stickerItem + ", isBlurAnimRunning: " + this.X.P() + ", isAnyModeAnimationRunning: " + W());
            return false;
        } else if (stickerItem.isRecycleBin()) {
            e.b("StickerMode", "onStickerItemClick, recycle_bin_sticker_id");
            l lVar = this.aV;
            if (lVar == null || !lVar.isShowing()) {
                this.be++;
                this.aV = new l(this.Z);
                this.aV.show();
                this.aV.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialogInterface) {
                        e.b("StickerMode", "onStickerItemClick, onDismiss");
                        com.oppo.camera.ui.preview.a.l.b((Context) r.this.Z).a(1, true);
                    }
                });
                this.aV.a((l.a) new l.a() {
                    public void a() {
                        r.b(r.this);
                    }

                    public void a(int i, boolean z) {
                        r.this.a(i, z, StickerMsgData.STICKER_OPER_DELETE);
                    }

                    public void b(int i, boolean z) {
                        r.this.a(i, z, "cancel");
                    }
                });
            }
            return true;
        } else if (com.oppo.camera.ui.preview.a.l.b((Context) this.Z).a(this.Z, stickerItem)) {
            return true;
        } else {
            a(stickerItem, false);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean a(View view, StickerItem stickerItem, int i) {
        if (stickerItem == null) {
            e.d("StickerMode", "onStickwerItemLongClick, item: " + stickerItem);
        }
        return false;
    }

    public void dx() {
        super.dx();
        l lVar = this.aV;
        if (lVar != null) {
            lVar.b();
        }
        com.oppo.camera.ui.preview.a.l.b((Context) this.Z).a(this.Z);
    }

    /* access modifiers changed from: private */
    public void I(boolean z) {
        e.a("StickerMode", "updateStickerImageResource");
        com.oppo.camera.ui.preview.a.l.b((Context) this.Z).a(this.bq, com.oppo.camera.ui.preview.a.l.b((Context) this.Z).a(this.aa), z);
    }

    /* access modifiers changed from: private */
    public void c(StickerItem stickerItem) {
        if (this.ab != null && stickerItem != null && com.oppo.camera.ui.preview.a.l.b((Context) this.Z).b().d(stickerItem.getStickerUUID()) && this.ab.b(stickerItem)) {
            this.ab.d();
        }
    }

    private void f(boolean z, boolean z2) {
        e.a("StickerMode", "hideStickerMenu, includePanle: " + z2);
        this.aU.a(4, z, z2);
        this.aU.a(false);
    }

    /* access modifiers changed from: private */
    public void g(boolean z, boolean z2) {
        e.a("StickerMode", "showStickerMenu, needAnim: " + z + ", includePanel: " + z2);
        if (!dO()) {
            this.aU.a(0, z, z2);
            this.aU.a(true);
        }
        if (p("key_bubble_sticker")) {
            this.aU.a((h.a) new h.a() {
                public void a() {
                    if (r.this.p("key_bubble_sticker")) {
                        r.this.Y.a((View) r.this.aU.a(), 3, r.this.G(3), r.this.H(3));
                    }
                }
            });
        }
    }

    public void c(int i, boolean z) {
        super.c(i, z);
        if (i != 1) {
            if (i == 3) {
                this.aU.a((!z || !this.v) ? z : false);
                if (z) {
                    g(true, true);
                    if (p("key_bubble_sticker")) {
                        this.Y.a((View) this.aU.a(), 3, G(3), H(3));
                        return;
                    }
                    return;
                }
                if (this.aU.h()) {
                    this.aU.b(true, true, false);
                } else {
                    f(false, true);
                }
                if (p("key_bubble_sticker")) {
                    this.Y.c(3, false);
                }
            }
        } else if (z) {
            g(true, false);
        } else {
            f(true, true);
        }
    }

    public void bM() {
        if (p("key_bubble_sticker")) {
            this.Y.c(3, false);
        }
        f(true, false);
    }

    public void bN() {
        if (!this.X.x()) {
            if (p("key_bubble_sticker")) {
                this.Y.a((View) this.aU.a(), 3, G(3), H(3));
            }
            if (!this.Y.s()) {
                g(true, false);
            }
        }
    }

    public void dW() {
        if (p("key_bubble_sticker")) {
            this.Y.c(3, false);
        }
        if (p("key_bubble_short_video")) {
            this.Y.c(4, false);
        }
    }

    public void dX() {
        if (p("key_bubble_sticker") && this.aU != null) {
            this.Y.a((View) this.aU.a(), 3, G(3), H(3));
        }
        if (p("key_bubble_short_video")) {
            this.Y.a((View) null, 4, G(4), H(4));
        }
    }

    public void dT() {
        String bP = bP();
        if (dV()) {
            this.Y.a(this.Z.getString(R.string.camera_mode_sticker));
            this.aU.e(true);
        } else {
            f(false, true);
        }
        if (p("key_bubble_sticker")) {
            this.Y.c(3, false);
        }
        if ("beauty".equals(bP)) {
            CameraStatisticsUtil.onCommon(this.Z, CameraStatisticsUtil.EVENT_MENU_CLICK, CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_MODE_CLICK_SMOOTH_MENU, "1"), false);
        } else if ("filter".equals(bP)) {
            CameraStatisticsUtil.onCommon(this.Z, CameraStatisticsUtil.EVENT_MENU_CLICK, CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_MODE_CLICK_FILTER_MENU, "1"), false);
        }
        this.Y.an();
    }

    public void s(boolean z) {
        g(true, false);
        if (p("key_bubble_sticker") && this.aU != null) {
            this.Y.a((View) this.aU.a(), 3, G(3), H(3));
        }
    }

    public boolean dU() {
        return !this.aU.h();
    }

    public boolean dV() {
        h hVar = this.aU;
        if (hVar == null) {
            return false;
        }
        return hVar.h();
    }

    public boolean fL() {
        if (!dP() || this.aU.j() || this.Y.t()) {
            return true;
        }
        if (!dV()) {
            return false;
        }
        this.Y.a(this.Z.getString(R.string.camera_mode_sticker));
        this.Y.a(0, true);
        this.aU.e(false);
        this.Y.r(true);
        return true;
    }

    public boolean au() {
        e.a("StickerMode", "onBackPressed");
        super.au();
        return fL();
    }

    public boolean b(MotionEvent motionEvent) {
        e.a("StickerMode", "onSingleTapUp");
        Rect rect = new Rect();
        this.Y.i().getHitRect(rect);
        if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return false;
        }
        if (fL()) {
            return true;
        }
        return Y();
    }

    public boolean a(MotionEvent motionEvent) {
        return super.a(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void eg() {
        super.eg();
        CameraStatisticsUtil.onCommon(this.Z, CameraStatisticsUtil.EVENT_MENU_CLICK, CameraStatisticsUtil.format(CameraStatisticsUtil.STICKER_MODE_SWITCH_CAMERA, "1"), false);
    }

    /* compiled from: StickerMode */
    private class a implements p {
        private a() {
        }

        public void a(StickerItem stickerItem) {
            if (!r.this.z) {
                e.b("StickerMode", "onStickerDownloadStarted, item: " + stickerItem.toString());
                Integer c = com.oppo.camera.ui.preview.a.l.b((Context) r.this.Z).b().c(stickerItem.getStickerUUID());
                if (c != null) {
                    r.this.aU.a(stickerItem.getCategoryId(), c.intValue(), stickerItem.getDownloadState(), stickerItem.getThumbnailFileUri(), !r.this.y, stickerItem);
                }
                long unused = r.this.bo = System.currentTimeMillis();
            }
        }

        public void b(final StickerItem stickerItem) {
            if (!r.this.z) {
                if (!r.this.dO() && !r.this.X.P() && !r.this.bC()) {
                    boolean unused = r.this.a(stickerItem, true);
                    r.this.Z.runOnUiThread(new Runnable() {
                        public void run() {
                            if (r.this.aV != null && r.this.aV.isShowing()) {
                                r.this.aV.a();
                            }
                        }
                    });
                    if (r.this.Y != null) {
                        r.this.Y.a().a((Runnable) new Runnable() {
                            public void run() {
                                r.this.c(stickerItem);
                            }
                        });
                    }
                }
                r.this.I(false);
                r.this.a(stickerItem, System.currentTimeMillis() - r.this.bo, StickerMsgData.STICKER_OPER_DOWNLOAD, "0");
            }
        }

        public void a(StickerItem stickerItem, int i) {
            if (!r.this.z) {
                Integer c = com.oppo.camera.ui.preview.a.l.b((Context) r.this.Z).b().c(stickerItem.getStickerUUID());
                if (c != null) {
                    r.this.aU.a(stickerItem.getCategoryId(), c.intValue(), 16, stickerItem.getThumbnailFileUri(), !r.this.y, stickerItem);
                }
                r.this.a(stickerItem, -1, StickerMsgData.STICKER_OPER_DOWNLOAD, "1");
            }
        }

        public void c(final StickerItem stickerItem) {
            if (!r.this.z) {
                r.this.Z.runOnUiThread(new Runnable() {
                    public void run() {
                        if (stickerItem != null) {
                            if (!(r.this.ab == null || r.this.ab.j() == null || !TextUtils.equals(stickerItem.getStickerUUID(), r.this.ab.j().getStickerUUID()))) {
                                r.this.aU.c(false);
                                r.this.b(stickerItem);
                                if (com.oppo.camera.ui.preview.a.l.b(stickerItem)) {
                                    r.this.fN();
                                }
                            }
                            r.this.a(CameraStatisticsUtil.STICKER_RECYCLEBIN_ITEM_DELETE, stickerItem.getStickerUUID());
                        }
                        if (r.this.aV != null && r.this.aV.isShowing()) {
                            r.this.aV.a(stickerItem);
                        }
                    }
                });
                r.this.I(false);
            }
        }

        public void d(StickerItem stickerItem) {
            if (!r.this.z) {
                r.this.I(false);
            }
        }

        public void a(int i) {
            if (r.this.z || i == 0) {
                return;
            }
            if (i == 1) {
                r.this.I(false);
            } else if (i == 2) {
                if (r.this.X.P()) {
                    r.this.I(false);
                } else {
                    r.this.I(true);
                }
            }
        }

        public void a() {
            if (!r.this.z) {
                r.this.I(false);
            }
        }
    }

    public boolean bn() {
        if (Y()) {
            return false;
        }
        return super.bn();
    }

    public void eH() {
        if (this.Y != null) {
            this.Y.b("pref_camera_photo_ratio_key", "full");
        }
    }

    public void a(int i, int i2, boolean z) {
        super.a(i, i2, z);
        b(i, i2, z);
    }

    /* access modifiers changed from: private */
    public void J(boolean z) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.Z);
        menuClickMsgData.buildEvent(false);
        menuClickMsgData.mFuncKeyId = 34;
        menuClickMsgData.mCaptureType = 2;
        e((DcsMsgData) menuClickMsgData);
        if (z) {
            menuClickMsgData.mFuncKeyResult = 1;
        } else {
            menuClickMsgData.mFuncKeyResult = 2;
        }
        menuClickMsgData.report();
    }

    /* access modifiers changed from: private */
    public void A(String str) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.Z);
        menuClickMsgData.buildEvent(true);
        menuClickMsgData.mFuncKeyId = 34;
        e((DcsMsgData) menuClickMsgData);
        menuClickMsgData.mItemValue = str;
        menuClickMsgData.report();
    }

    private void b(int i, int i2, boolean z) {
        if (z) {
            MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.Z);
            menuClickMsgData.buildEvent(true);
            menuClickMsgData.mFuncKeyId = 2;
            if (this.t) {
                menuClickMsgData.mItem = MenuClickMsgData.KEY_COMMON_CUSTOM_BEAUTY[i];
            }
            menuClickMsgData.mItemValue = String.valueOf(i2);
            e((DcsMsgData) menuClickMsgData);
            menuClickMsgData.report();
        }
    }

    private void I(int i) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.Z);
        menuClickMsgData.buildEvent(true);
        menuClickMsgData.mFuncKeyId = 4;
        menuClickMsgData.mItemValue = g.a(i, this.n);
        e((DcsMsgData) menuClickMsgData);
        menuClickMsgData.report();
    }

    private void a(StickerItem stickerItem, boolean z, String str) {
        StickerMsgData stickerMsgData = new StickerMsgData(this.Z);
        stickerMsgData.buildEvent(StickerMsgData.EVENT_STICKER_SELECT);
        e((DcsMsgData) stickerMsgData);
        stickerMsgData.mStickerName = stickerItem.getStickerName();
        stickerMsgData.mStickerType = String.valueOf(stickerItem.getMaterialType());
        stickerMsgData.mStickerUuid = stickerItem.getStickerUUID();
        stickerMsgData.mProtocolVersion = String.valueOf(stickerItem.getProtocolVersion());
        if (z) {
            stickerMsgData.mMyDownload = String.valueOf(true);
        } else {
            stickerMsgData.mMyDownload = String.valueOf(false);
        }
        if (StickerMsgData.STICKER_OPER_SELECT.equals(str)) {
            stickerMsgData.mOperType = StickerMsgData.STICKER_OPER_SELECT;
        } else if ("cancel".equals(str)) {
            stickerMsgData.mOperType = "cancel";
        }
        stickerMsgData.report();
    }

    /* access modifiers changed from: private */
    public void a(StickerItem stickerItem, long j, String str, String str2) {
        StickerMsgData stickerMsgData = new StickerMsgData(this.Z);
        stickerMsgData.buildEvent("sticker_download");
        e((DcsMsgData) stickerMsgData);
        stickerMsgData.mStickerName = stickerItem.getStickerName();
        stickerMsgData.mStickerType = String.valueOf(stickerItem.getMaterialType());
        stickerMsgData.mStickerUuid = stickerItem.getStickerUUID();
        stickerMsgData.mProtocolVersion = String.valueOf(stickerItem.getProtocolVersion());
        stickerMsgData.mStickerDownloadCostTime = j;
        stickerMsgData.mZoomValue = String.valueOf(this.X.ad());
        if (StickerMsgData.STICKER_OPER_DOWNLOAD.equals(str)) {
            stickerMsgData.mOperType = StickerMsgData.STICKER_OPER_DOWNLOAD;
        } else if ("cancel".equals(str)) {
            stickerMsgData.mOperType = "cancel";
        }
        if (str2 != null) {
            stickerMsgData.mDownloadResult = str2;
        }
        stickerMsgData.report();
    }

    /* access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        StickerMsgData stickerMsgData = new StickerMsgData(this.Z);
        stickerMsgData.buildEvent(StickerMsgData.EVENT_STICKER_DELETE);
        e((DcsMsgData) stickerMsgData);
        stickerMsgData.mSelectCount = i;
        if (z) {
            stickerMsgData.mSelectAll = "true";
        } else {
            stickerMsgData.mSelectAll = "false";
        }
        if (StickerMsgData.STICKER_OPER_DELETE.equals(str)) {
            stickerMsgData.mOperType = StickerMsgData.STICKER_OPER_DELETE;
        } else if ("cancel".equals(str)) {
            stickerMsgData.mOperType = "cancel";
        }
        stickerMsgData.report();
    }

    private void e(DcsMsgData dcsMsgData) {
        if (this.X.j()) {
            dcsMsgData.mCameraEnterType = String.valueOf(1);
        } else if (this.X.m()) {
            dcsMsgData.mCameraEnterType = String.valueOf(3);
        } else {
            dcsMsgData.mCameraEnterType = String.valueOf(2);
        }
        dcsMsgData.mCaptureMode = a();
        dcsMsgData.mCameraId = this.X.aq();
        dcsMsgData.mOrientation = this.k;
        dcsMsgData.mRearOrFront = com.oppo.camera.f.a.c(this.X.aq()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
    }

    public boolean eY() {
        l lVar = this.aV;
        return (lVar == null || !lVar.isShowing()) && super.eY();
    }

    /* access modifiers changed from: protected */
    public boolean bf() {
        return Util.p();
    }
}
