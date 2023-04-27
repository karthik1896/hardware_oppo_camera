package com.oppo.camera.l;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import color.support.v7.widget.c;
import color.support.v7.widget.pageindicator.ColorPageIndicator;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.doubleexposure.DoubleExposureVideoView;
import com.oppo.camera.e;
import com.oppo.camera.k;
import com.oppo.camera.statistics.model.DoubleExposureMsgData;

/* compiled from: CommonBottomGuide */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f3403a = {R.string.camera_id_photo_mode_tips_background, R.string.camera_id_photo_mode_tips_distance, R.string.camera_id_photo_mode_tips_align};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f3404b = {R.drawable.id_photo_tips_background, R.drawable.id_photo_tips_distance, R.drawable.id_photo_tips_align};
    private static final int[] c = {R.string.camera_double_exposure_guide_hint, R.string.camera_double_exposure_guide_hint_secord, R.string.camera_double_exposure_guide_hint_third};
    private static final Uri[] d = new Uri[3];
    /* access modifiers changed from: private */
    public static String e = "CommonBottomGuide";
    /* access modifiers changed from: private */
    public k f = null;
    /* access modifiers changed from: private */
    public Dialog g = null;
    private Dialog h = null;
    private Dialog i = null;
    private Dialog j = null;
    /* access modifiers changed from: private */
    public com.color.support.dialog.panel.b k = null;
    /* access modifiers changed from: private */
    public ViewPager2 l = null;
    /* access modifiers changed from: private */
    public ColorPageIndicator m = null;
    /* access modifiers changed from: private */
    public VideoView n = null;
    /* access modifiers changed from: private */
    public DoubleExposureVideoView o = null;
    /* access modifiers changed from: private */
    public ImageView p = null;
    private Thread q = null;
    /* access modifiers changed from: private */
    public c.a r = null;
    /* access modifiers changed from: private */
    public Handler s = null;
    /* access modifiers changed from: private */
    public long t = 0;
    /* access modifiers changed from: private */
    public int u = 0;
    /* access modifiers changed from: private */
    public boolean v = false;

    public a(k kVar, c.a aVar) {
        this.f = kVar;
        this.r = aVar;
        if (this.s == null) {
            this.s = new Handler(Looper.getMainLooper());
        }
    }

    public void a(Activity activity) {
        Dialog dialog = this.i;
        if (dialog == null || !dialog.isShowing()) {
            a(activity, 3);
        } else {
            a(3, false);
        }
    }

    public void a(Activity activity, int i2) {
        if (i2 == 1) {
            f(activity);
        } else if (i2 == 2) {
            d(activity);
        } else if (i2 == 3) {
            c(activity);
        } else if (i2 == 4) {
            e(activity);
        } else if (i2 == 5) {
            g(activity);
        }
        String str = e;
        e.b(str, "showCommonBottomGuide, type: " + i2);
    }

    public void a(int i2, boolean z) {
        k kVar;
        k kVar2;
        if (i2 == 1) {
            Dialog dialog = this.g;
            if (dialog != null) {
                b(dialog);
                if (z && (kVar = this.f) != null) {
                    kVar.edit().putBoolean("key_bottom_guide_type_fast_video", false).apply();
                }
            }
        } else if (i2 == 2) {
            Dialog dialog2 = this.h;
            if (dialog2 != null) {
                b(dialog2);
                if (z && (kVar2 = this.f) != null) {
                    kVar2.edit().putBoolean("key_bottom_guide_type_night_tripod", false).apply();
                }
            }
        } else if (i2 == 3) {
            b(this.i);
        } else if (i2 == 4) {
            b(this.j);
        } else if (i2 == 5) {
            b((Dialog) this.k);
        }
        String str = e;
        e.b(str, "showCommonBottomGuide, type: " + i2 + ", remove: " + z);
    }

    public void a() {
        b(this.g);
        b(this.h);
        b(this.i);
        b(this.j);
        b((Dialog) this.k);
    }

    private void b(Dialog dialog) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    private boolean i() {
        return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_PROFESSIONAL_SUPER_RAW);
    }

    @SuppressLint({"WrongConstant"})
    private void c(Activity activity) {
        this.i = a(activity, (int) R.layout.common_bottom_guide_professional_parameter_layout, (int) R.string.professional_mode_guide_title, -1);
        a((TextView) this.i.findViewById(R.id.tvIsoTitle));
        a((TextView) this.i.findViewById(R.id.tvShutterTitle));
        a((TextView) this.i.findViewById(R.id.tvWhiteBalanceTitle));
        a((TextView) this.i.findViewById(R.id.tvWhiteAmfTitle));
        a((TextView) this.i.findViewById(R.id.tvWhiteEvfTitle));
        if (i()) {
            a((TextView) this.i.findViewById(R.id.tvRawTitle));
        }
        int i2 = i() ? 0 : 8;
        this.i.findViewById(R.id.tvRawTitle).setVisibility(i2);
        this.i.findViewById(R.id.tvRawDescription).setVisibility(i2);
        if (!this.i.isShowing()) {
            try {
                a(this.i);
            } catch (WindowManager.BadTokenException e2) {
                if (this.i.isShowing()) {
                    this.i.dismiss();
                    this.i = null;
                }
                String str = e;
                e.d(str, "showProfessionalParameterBottomGuide, exception: " + e2.getMessage());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        r0 = r6.getText().toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.widget.TextView r6) {
        /*
            r5 = this;
            java.util.Locale r0 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x004b }
            int r0 = androidx.core.e.f.a(r0)     // Catch:{ Exception -> 0x004b }
            r1 = 1
            if (r1 != r0) goto L_0x0069
            if (r6 == 0) goto L_0x0069
            java.lang.CharSequence r0 = r6.getText()     // Catch:{ Exception -> 0x004b }
            if (r0 == 0) goto L_0x0069
            java.lang.CharSequence r0 = r6.getText()     // Catch:{ Exception -> 0x004b }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x004b }
            r2 = 40
            int r2 = r0.indexOf(r2)     // Catch:{ Exception -> 0x004b }
            if (r2 <= 0) goto L_0x0069
            int r3 = r0.length()     // Catch:{ Exception -> 0x004b }
            if (r2 >= r3) goto L_0x0069
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x004b }
            r3.<init>()     // Catch:{ Exception -> 0x004b }
            r4 = 0
            java.lang.String r4 = r0.substring(r4, r2)     // Catch:{ Exception -> 0x004b }
            java.lang.String r0 = r0.substring(r2)     // Catch:{ Exception -> 0x004b }
            r3.append(r4)     // Catch:{ Exception -> 0x004b }
            r3.append(r0)     // Catch:{ Exception -> 0x004b }
            androidx.core.e.a r0 = androidx.core.e.a.a((boolean) r1)     // Catch:{ Exception -> 0x004b }
            androidx.core.e.d r1 = androidx.core.e.e.e     // Catch:{ Exception -> 0x004b }
            java.lang.CharSequence r0 = r0.a(r3, r1)     // Catch:{ Exception -> 0x004b }
            r6.setText(r0)     // Catch:{ Exception -> 0x004b }
            goto L_0x0069
        L_0x004b:
            r6 = move-exception
            r6.printStackTrace()
            java.lang.String r0 = e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = " setRtlProfessionalTitleText error : "
            r1.append(r2)
            java.lang.String r6 = r6.toString()
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            com.oppo.camera.e.e(r0, r6)
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.l.a.a(android.widget.TextView):void");
    }

    private void d(Activity activity) {
        if (this.h == null) {
            this.h = a(activity, (int) R.layout.common_bottom_guide_night_tripod_layout, (int) R.string.tripod_night_guide_title, (int) R.string.night_tripod_guide_description_new);
            this.h.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.f != null) {
                        a.this.f.edit().putBoolean("key_bottom_guide_type_night_tripod", false).apply();
                    }
                }
            });
        }
        if (!this.h.isShowing()) {
            try {
                a(this.h);
            } catch (WindowManager.BadTokenException e2) {
                if (this.h.isShowing()) {
                    this.h.dismiss();
                }
                String str = e;
                e.d(str, "showNightTripodBottomGuide, exception: " + e2.getMessage());
            }
        }
    }

    private void e(Activity activity) {
        if (this.j == null) {
            this.j = a(activity, (int) R.layout.common_bottom_guide_id_photo_layout, f3403a, f3404b);
            this.j.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    a.this.a(dialogInterface);
                }
            });
        }
        if (!this.j.isShowing()) {
            try {
                a(this.j);
            } catch (WindowManager.BadTokenException e2) {
                if (this.j.isShowing()) {
                    this.j.dismiss();
                    this.j = null;
                }
                e.c(e, "showIdPhotoBottomGuide, exception!", e2);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        k kVar = this.f;
        if (kVar != null) {
            kVar.edit().putBoolean("key_bottom_guide_type_id_photo", true).apply();
        }
        this.j = null;
    }

    private void f(final Activity activity) {
        this.g = a(activity, (int) R.layout.common_bottom_guide_fast_video_layout, (int) R.string.camera_video_hyper_lapse_title, (int) R.string.hyper_lapse_guide_description);
        this.n = (VideoView) this.g.findViewById(R.id.videoView);
        this.n.getHolder().setFormat(-2);
        this.p = (ImageView) this.g.findViewById(R.id.iv_video_thumb);
        Uri parse = Uri.parse("android.resource://" + activity.getPackageName() + "/" + R.raw.fastvideo_guide);
        final long currentTimeMillis = System.currentTimeMillis();
        final AnonymousClass7 r2 = new Runnable() {
            public void run() {
                if (a.this.n != null) {
                    a.this.n.start();
                    a.this.n.requestFocus();
                }
            }
        };
        AnonymousClass8 r6 = new Runnable() {
            public void run() {
                try {
                    if (!a.this.g.isShowing()) {
                        a.this.a(a.this.g);
                    }
                } catch (WindowManager.BadTokenException e) {
                    if (a.this.g.isShowing()) {
                        a.this.g.dismiss();
                    }
                    String h = a.e;
                    e.d(h, "showFastVideoBottomGuide, exception: " + e.getMessage());
                }
            }
        };
        AnonymousClass9 r3 = new ViewOutlineProvider() {
            public void getOutline(View view, Outline outline) {
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                outline.setRoundRect(new Rect(0, 0, rect.right - rect.left, rect.bottom - rect.top), view.getContext().getResources().getDimension(R.dimen.common_bottom_guide_background_radius));
            }
        };
        this.p.setClipToOutline(true);
        this.p.setOutlineProvider(r3);
        this.n.setEnabled(false);
        this.n.setZOrderOnTop(false);
        this.n.setVideoURI(parse);
        this.n.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                e.b(a.e, "videoView onPrepared");
                mediaPlayer.setLooping(true);
                long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                if (330 <= currentTimeMillis) {
                    a.this.s.post(r2);
                } else {
                    a.this.s.postDelayed(r2, 330 - currentTimeMillis);
                }
            }
        });
        this.n.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                if (3 != i || a.this.p == null) {
                    return true;
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(a.this.p, "alpha", new float[]{1.0f, 0.0f});
                ofFloat.setDuration(100);
                ofFloat.setRepeatCount(0);
                ofFloat.start();
                return true;
            }
        });
        this.n.setClipToOutline(true);
        this.n.setOutlineProvider(r3);
        this.n.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                String h = a.e;
                e.e(h, "videoView onError, what: " + i + ", extra: " + i2);
                return false;
            }
        });
        this.g.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.p != null) {
                    a.this.p.setAlpha(1.0f);
                    ImageView unused = a.this.p = null;
                }
                if (a.this.n != null) {
                    a.this.n.pause();
                    a.this.n.setBackgroundColor(androidx.core.content.a.c(activity, R.color.camera_white));
                    a.this.n.setOnPreparedListener((MediaPlayer.OnPreparedListener) null);
                    a.this.n.setOnCompletionListener((MediaPlayer.OnCompletionListener) null);
                    a.this.n.setOnErrorListener((MediaPlayer.OnErrorListener) null);
                    if (a.this.s != null) {
                        a.this.s.removeCallbacksAndMessages((Object) null);
                    }
                    Dialog unused2 = a.this.g = null;
                }
                if (a.this.f != null) {
                    a.this.f.edit().putBoolean("key_bottom_guide_type_fast_video", false).apply();
                }
                if (a.this.r != null) {
                    a.this.r.a();
                }
            }
        });
        a(this.p, activity, parse, this.s, r6);
    }

    private void g(Activity activity) {
        ViewPager2 viewPager2;
        this.t = SystemClock.uptimeMillis();
        this.v = true;
        com.color.support.dialog.panel.b bVar = this.k;
        if (bVar == null) {
            this.k.setContentView(h(activity));
            this.k.setCancelable(true);
            this.k.setCanceledOnTouchOutside(true);
            Window window = this.k.getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.height = -2;
                attributes.gravity = 80;
                window.setAttributes(attributes);
            }
            this.l.setOffscreenPageLimit(3);
            this.k.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.f != null) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append(a.this.l.getCurrentItem());
                        stringBuffer.append(":");
                        stringBuffer.append(SystemClock.uptimeMillis() - a.this.t);
                        stringBuffer.append(":");
                        stringBuffer.append(a.this.v ? DoubleExposureMsgData.KEY_VIDEO_EXIT_TYPE_VALUE_GLIDE : DoubleExposureMsgData.KEY_VIDEO_EXIT_TYPE_VALUE_CLICK);
                        a.this.f.edit().putString("key_double_exposure_guid_page_and_duration", stringBuffer.toString()).apply();
                    }
                    if (a.this.f != null) {
                        a.this.f.edit().putBoolean("key_bottom_guide_double_exposure", false).apply();
                    }
                    if (a.this.o != null) {
                        a.this.o.b();
                    }
                    long unused = a.this.t = 0;
                }
            });
            this.k.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    DoubleExposureVideoView doubleExposureVideoView = (DoubleExposureVideoView) a.this.l.getChildAt(0).findViewById(R.id.videoView);
                    if (doubleExposureVideoView != null) {
                        doubleExposureVideoView.a();
                    }
                }
            });
        } else if (!bVar.isShowing() && (viewPager2 = this.l) != null) {
            try {
                viewPager2.a(0, false);
                this.m.setCurrentPosition(0);
                a((Dialog) this.k);
            } catch (WindowManager.BadTokenException e2) {
                if (this.k.isShowing()) {
                    this.k.dismiss();
                }
                e2.printStackTrace();
                String str = e;
                e.d(str, "showDoubleExposureBottomGuide, exception: " + e2.getMessage());
            }
        }
    }

    private View h(Activity activity) {
        Uri[] uriArr = d;
        uriArr[0] = Uri.parse("android.resource://" + activity.getPackageName() + "/" + R.raw.double_exposure_guide1);
        Uri[] uriArr2 = d;
        uriArr2[1] = Uri.parse("android.resource://" + activity.getPackageName() + "/" + R.raw.double_exposure_guide2);
        Uri[] uriArr3 = d;
        uriArr3[2] = Uri.parse("android.resource://" + activity.getPackageName() + "/" + R.raw.double_exposure_guide3);
        final b bVar = new b(activity, c, d);
        this.k = new com.color.support.dialog.panel.b(activity, R.style.CommonBottomGuideDialog);
        this.k.c(false);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.common_bottom_guide_double_exposure_layout, (ViewGroup) null);
        this.l = (ViewPager2) inflate.findViewById(R.id.guide_content_container);
        this.l.setAdapter(bVar);
        this.m = (ColorPageIndicator) inflate.findViewById(R.id.guide_content_indicator);
        this.m.setDotsCount(bVar.getItemCount());
        this.l.a((ViewPager2.e) new ViewPager2.e() {
            public void onPageScrolled(int i, float f, int i2) {
                super.onPageScrolled(i, f, i2);
                a.this.m.a(i, f, i2);
            }

            public void onPageSelected(int i) {
                super.onPageSelected(i);
                a aVar = a.this;
                DoubleExposureVideoView unused = aVar.o = aVar.a(aVar.l, i);
                if (a.this.o != null) {
                    a.this.o.a();
                }
                a aVar2 = a.this;
                DoubleExposureVideoView a2 = aVar2.a(aVar2.l, bVar.a());
                if (a2 != null) {
                    a2.b();
                }
                bVar.a(i);
                a.this.m.a(i);
                if (a.this.f != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(i);
                    stringBuffer.append(":");
                    stringBuffer.append(SystemClock.uptimeMillis() - a.this.t);
                    stringBuffer.append(":");
                    stringBuffer.append(DoubleExposureMsgData.KEY_VIDEO_EXIT_TYPE_VALUE_CHANGE);
                    a.this.f.edit().putString("key_double_exposure_guid_page_and_duration", stringBuffer.toString()).apply();
                }
            }

            public void onPageScrollStateChanged(int i) {
                super.onPageScrollStateChanged(i);
                a.this.m.b(i);
            }
        });
        this.m.setOnDotClickListener(new ColorPageIndicator.a() {
            public final void onClick(int i) {
                a.this.a(i);
            }
        });
        bVar.a((DoubleExposureVideoView.a) new DoubleExposureVideoView.a() {
            public void a(Bitmap bitmap) {
                if (!a.this.k.isShowing()) {
                    try {
                        bVar.a(bitmap);
                        a.this.a((Dialog) a.this.k);
                    } catch (WindowManager.BadTokenException e) {
                        if (a.this.k.isShowing()) {
                            a.this.k.dismiss();
                        }
                        String h = a.e;
                        e.d(h, "showDoubleExposureBottomGuide, exception: " + e.getMessage());
                    }
                }
            }

            public void a() {
                e.e(a.e, "VideoViewPagerAdapter onLoadVideoThumbFail ");
            }
        });
        this.k.a((View.OnTouchListener) new View.OnTouchListener() {

            /* renamed from: b  reason: collision with root package name */
            private float f3419b = 0.0f;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.f3419b = motionEvent.getY();
                    int unused = a.this.u = 0;
                } else if (2 == motionEvent.getAction()) {
                    int unused2 = a.this.u = (int) (motionEvent.getY() - this.f3419b);
                } else if (1 == motionEvent.getAction() && 100 > a.this.u) {
                    boolean unused3 = a.this.v = false;
                }
                return false;
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2) {
        this.l.setCurrentItem(i2);
    }

    /* access modifiers changed from: private */
    public DoubleExposureVideoView a(ViewPager2 viewPager2, int i2) {
        View childAt;
        ViewGroup viewGroup = viewPager2.getChildCount() > 0 ? (ViewGroup) viewPager2.getChildAt(0) : null;
        if (viewGroup == null || i2 > viewGroup.getChildCount() || (childAt = viewGroup.getChildAt(i2)) == null) {
            return null;
        }
        return (DoubleExposureVideoView) childAt.findViewById(R.id.videoView);
    }

    private void a(ImageView imageView, Activity activity, Uri uri, Handler handler, Runnable runnable) {
        this.q = new Thread(new C0088a(activity, handler, uri, imageView, runnable));
        this.q.start();
    }

    @SuppressLint({"WrongConstant"})
    private Dialog a(Activity activity, int i2, int i3, int i4) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.common_bottom_guide_layout, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.bottom_guide_cv);
        ((TextView) inflate.findViewById(R.id.bottom_guide_title)).setText(i3);
        TextView textView = (TextView) inflate.findViewById(R.id.bottom_guide_description);
        if (-1 != i4) {
            textView.setVisibility(0);
            textView.setText(i4);
        } else {
            textView.setVisibility(8);
        }
        linearLayout.addView(LayoutInflater.from(activity).inflate(i2, linearLayout, false));
        com.color.support.dialog.panel.b bVar = new com.color.support.dialog.panel.b(activity, R.style.CommonBottomGuideDialog);
        bVar.setContentView(inflate);
        bVar.setCancelable(true);
        bVar.setCanceledOnTouchOutside(true);
        Window window = bVar.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
        return bVar;
    }

    @SuppressLint({"WrongConstant"})
    private Dialog a(Activity activity, int i2, int[] iArr, int[] iArr2) {
        b bVar = new b(iArr, iArr2);
        com.color.support.dialog.panel.b bVar2 = new com.color.support.dialog.panel.b(activity, R.style.CommonBottomGuideDialog);
        View inflate = LayoutInflater.from(activity).inflate(i2, (ViewGroup) null);
        ViewPager2 viewPager2 = (ViewPager2) inflate.findViewById(R.id.guide_content_container);
        viewPager2.setAdapter(bVar);
        final ColorPageIndicator colorPageIndicator = (ColorPageIndicator) inflate.findViewById(R.id.guide_content_indicator);
        colorPageIndicator.setDotsCount(bVar.getItemCount());
        viewPager2.a((ViewPager2.e) new ViewPager2.e() {
            public void onPageScrolled(int i, float f, int i2) {
                super.onPageScrolled(i, f, i2);
                colorPageIndicator.a(i, f, i2);
            }

            public void onPageSelected(int i) {
                super.onPageSelected(i);
                colorPageIndicator.a(i);
            }

            public void onPageScrollStateChanged(int i) {
                super.onPageScrollStateChanged(i);
                colorPageIndicator.b(i);
            }
        });
        colorPageIndicator.setOnDotClickListener(new ColorPageIndicator.a() {
            public final void onClick(int i) {
                ViewPager2.this.setCurrentItem(i);
            }
        });
        bVar2.setContentView(inflate);
        bVar2.setCancelable(true);
        bVar2.setCanceledOnTouchOutside(true);
        Window window = bVar2.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
        return bVar2;
    }

    public void a(Dialog dialog) {
        Window window = dialog.getWindow();
        window.setFlags(8, 8);
        dialog.show();
        window.getDecorView().setSystemUiVisibility(1284);
        window.clearFlags(8);
    }

    public void b() {
        a(this.g, 0);
        a(this.h, 0);
        a(this.i, 0);
        a(this.j, 0);
        this.r = null;
        c();
    }

    public boolean c() {
        boolean z;
        Dialog dialog = this.g;
        if (dialog == null || !dialog.isShowing()) {
            z = false;
        } else {
            this.g.dismiss();
            z = true;
        }
        Dialog dialog2 = this.h;
        if (dialog2 != null && dialog2.isShowing()) {
            this.h.dismiss();
            z = true;
        }
        Dialog dialog3 = this.i;
        if (dialog3 != null && dialog3.isShowing()) {
            this.i.dismiss();
            this.i = null;
            z = true;
        }
        Dialog dialog4 = this.j;
        if (dialog4 != null && dialog4.isShowing()) {
            this.j.dismiss();
            this.j = null;
            z = true;
        }
        e.b(e, "hideAllPopupWindow, isHide: " + z);
        return z;
    }

    private void a(Dialog dialog, int i2) {
        if (dialog != null) {
            dialog.getWindow().getDecorView().setAlpha((float) i2);
        }
    }

    public boolean d() {
        Dialog dialog = this.g;
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    public void b(Activity activity) {
        Dialog dialog = this.g;
        if (dialog != null && dialog.isShowing()) {
            this.g.dismiss();
            this.g = null;
            a(activity, 1);
        }
        Dialog dialog2 = this.h;
        if (dialog2 != null && dialog2.isShowing()) {
            this.h.dismiss();
            this.h = null;
            a(activity, 2);
        }
        Dialog dialog3 = this.i;
        if (dialog3 != null && dialog3.isShowing()) {
            this.i.dismiss();
            this.i = null;
            a(activity, 3);
        }
        Dialog dialog4 = this.j;
        if (dialog4 != null && dialog4.isShowing()) {
            this.j.dismiss();
            this.j = null;
            a(activity, 4);
        }
        com.color.support.dialog.panel.b bVar = this.k;
        if (bVar == null || !bVar.isShowing()) {
            this.k = null;
            return;
        }
        this.k.dismiss();
        this.k = null;
        a(activity, 5);
    }

    public void e() {
        com.color.support.dialog.panel.b bVar;
        VideoView videoView;
        Dialog dialog = this.g;
        if (!(dialog == null || !dialog.isShowing() || (videoView = this.n) == null)) {
            videoView.start();
            this.n.requestFocus();
        }
        if (this.o != null && (bVar = this.k) != null && bVar.isShowing()) {
            this.o.a();
        }
    }

    public void f() {
        com.color.support.dialog.panel.b bVar;
        VideoView videoView = this.n;
        if (videoView != null) {
            videoView.pause();
        }
        if (this.o != null && (bVar = this.k) != null && bVar.isShowing()) {
            this.o.b();
        }
    }

    public void g() {
        Handler handler = this.s;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        Thread thread = this.q;
        if (thread != null && thread.isAlive()) {
            this.q.interrupt();
            this.q = null;
        }
        this.r = null;
        this.n = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.f = null;
        this.k = null;
        this.o = null;
    }

    /* renamed from: com.oppo.camera.l.a$a  reason: collision with other inner class name */
    /* compiled from: CommonBottomGuide */
    private static class C0088a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Context f3425a;

        /* renamed from: b  reason: collision with root package name */
        private Handler f3426b;
        private Uri c;
        /* access modifiers changed from: private */
        public ImageView d;
        private Runnable e;

        public C0088a(Context context, Handler handler, Uri uri, ImageView imageView, Runnable runnable) {
            this.f3425a = context;
            this.f3426b = handler;
            this.c = uri;
            this.d = imageView;
            this.e = runnable;
        }

        public void run() {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.f3425a, this.c);
            try {
                final Bitmap frameAtIndex = mediaMetadataRetriever.getFrameAtIndex(2);
                if (!(frameAtIndex == null || this.f3426b == null)) {
                    this.f3426b.post(new Runnable() {
                        public void run() {
                            if (C0088a.this.d != null) {
                                C0088a.this.d.setVisibility(0);
                                C0088a.this.d.setImageBitmap(frameAtIndex);
                            }
                        }
                    });
                    this.f3426b.post(this.e);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                String h = a.e;
                e.e(h, "LoadThumbTask error " + e2.toString());
            } catch (Throwable th) {
                mediaMetadataRetriever.close();
                throw th;
            }
            mediaMetadataRetriever.close();
        }
    }

    /* compiled from: CommonBottomGuide */
    public static class b extends RecyclerView.a<C0089a> {

        /* renamed from: a  reason: collision with root package name */
        private int[] f3429a = null;

        /* renamed from: b  reason: collision with root package name */
        private int[] f3430b = null;

        public b(int[] iArr, int[] iArr2) {
            this.f3429a = iArr;
            this.f3430b = iArr2;
        }

        /* renamed from: a */
        public C0089a onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C0089a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.panel_guides_pager_item, viewGroup, false));
        }

        /* renamed from: a */
        public void onBindViewHolder(C0089a aVar, int i) {
            Resources resources = aVar.a().getContext().getResources();
            aVar.a().setImageResource(this.f3430b[i]);
            aVar.a().setContentDescription(resources.getString(this.f3429a[i]));
            aVar.b().setText(this.f3429a[i]);
        }

        public int getItemCount() {
            return this.f3429a.length;
        }

        /* renamed from: com.oppo.camera.l.a$b$a  reason: collision with other inner class name */
        /* compiled from: CommonBottomGuide */
        public final class C0089a extends RecyclerView.w {

            /* renamed from: b  reason: collision with root package name */
            private final ImageView f3432b;
            private final AppCompatTextView c;
            private final LinearLayoutCompat d;

            public final ImageView a() {
                return this.f3432b;
            }

            public final AppCompatTextView b() {
                return this.c;
            }

            public C0089a(View view) {
                super(view);
                this.f3432b = (ImageView) view.findViewById(R.id.pager_item_im);
                this.c = (AppCompatTextView) view.findViewById(R.id.guide_tips_tv);
                this.d = (LinearLayoutCompat) view.findViewById(R.id.guide_tips_container);
            }
        }
    }
}
