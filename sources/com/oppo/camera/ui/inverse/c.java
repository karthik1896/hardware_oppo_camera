package com.oppo.camera.ui.inverse;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.ui.inverse.b;
import com.oppo.camera.ui.inverse.c;
import com.oppo.camera.ui.inverse.d;
import java.util.Map;

/* compiled from: InverseManager */
public enum c {
    INS;
    
    private static final int ANIMATION_DURATION = 200;
    private static final int AUTO_INVERSE_DELAY = 500;
    private static final float BRIGHTNESS_MAX = 100.0f;
    private static final int MSG_INVERSE_DELAY = 1;
    private static final int MSG_POST_INVERSE = 2;
    private static final int SEND_MSG_CD = 3000;
    /* access modifiers changed from: private */
    public static final String TAG = null;
    private ValueAnimator mAnimator;
    private float mBrightness;
    private float mCurrentHighBrightnessValue;
    private long mDelayInverseTs;
    private b mHandler;
    private Interpolator mInterpolator;
    private int mInverseColor;
    /* access modifiers changed from: private */
    public Map<Integer, Boolean> mInverseMap;
    /* access modifiers changed from: private */
    public d mInverseViewHolder;
    /* access modifiers changed from: private */
    public final Object mLock;
    private int mThreshold;
    private int mThresholdRecover;
    private float mVideoBrightness;
    /* access modifiers changed from: private */
    public volatile boolean mbAnimationRunning;
    private Boolean mbDelayInverseColor;
    /* access modifiers changed from: private */
    public boolean mbExecuteDelayMsg;

    /* compiled from: InverseManager */
    public interface a {
        void call();
    }

    /* renamed from: com.oppo.camera.ui.inverse.c$c  reason: collision with other inner class name */
    /* compiled from: InverseManager */
    public interface C0101c {
        void call(InverseMaskView inverseMaskView);
    }

    static {
        TAG = c.class.getSimpleName();
    }

    public void init(Context context, int i, boolean z, int i2, int i3, int i4, int i5, int i6) {
        String str = TAG;
        e.b(str, "init, context.hashCode(): " + context.hashCode() + ", cameraEntryType: " + i);
        if (1 == i && i4 > 0 && !z) {
            this.mInverseMap.put(Integer.valueOf(context.hashCode()), false);
            this.mInverseColor = i6;
            this.mBrightness = ((float) i2) / BRIGHTNESS_MAX;
            this.mVideoBrightness = ((float) i3) / BRIGHTNESS_MAX;
            this.mThreshold = i4;
            this.mThresholdRecover = i5;
            this.mInterpolator = AnimationUtils.loadInterpolator(context, R.anim.inverse_interpolator);
        }
        if (this.mHandler == null) {
            this.mHandler = new b();
        }
        String str2 = TAG;
        e.b(str2, "init, X" + context.hashCode() + ", cameraEntryType: " + i + ", mInverseViewMap.size(): " + this.mInverseViewHolder.a());
    }

    public int getInverseColor() {
        return this.mInverseColor;
    }

    public float getBrightness() {
        return this.mBrightness;
    }

    public float getVideoBrightness() {
        return this.mVideoBrightness;
    }

    public float getCurrentHighBrightnessValue() {
        return this.mCurrentHighBrightnessValue;
    }

    public void setCurrentHighBrightnessValue(float f) {
        this.mCurrentHighBrightnessValue = f;
    }

    public int getThreshold() {
        return this.mThreshold;
    }

    public int getThresholdRecover() {
        return this.mThresholdRecover;
    }

    public void release(Context context) {
        String str = TAG;
        e.b(str, "release, context.hashCode(): " + context.hashCode());
        this.mInverseViewHolder.a(context);
        this.mInverseMap.remove(Integer.valueOf(context.hashCode()));
        this.mbDelayInverseColor = null;
        e.b(TAG, "release X");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0028, code lost:
        r0 = r6.mbDelayInverseColor;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean setInverseDelay(android.content.Context r7, boolean r8, boolean r9, com.oppo.camera.ui.inverse.c.a r10) {
        /*
            r6 = this;
            java.util.Map<java.lang.Integer, java.lang.Boolean> r0 = r6.mInverseMap
            int r1 = r7.hashCode()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            boolean r0 = r0.containsKey(r1)
            r1 = 0
            if (r0 == 0) goto L_0x0075
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r6.mDelayInverseTs
            long r2 = r2 - r4
            r4 = 3000(0xbb8, double:1.482E-320)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x001f
            goto L_0x0075
        L_0x001f:
            com.oppo.camera.ui.inverse.c$b r0 = r6.mHandler
            r2 = 1
            boolean r0 = r0.hasMessages(r2)
            if (r0 == 0) goto L_0x0037
            java.lang.Boolean r0 = r6.mbDelayInverseColor
            if (r0 == 0) goto L_0x0035
            boolean r0 = r0.booleanValue()
            if (r0 == r8) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r0 = r1
            goto L_0x0042
        L_0x0035:
            r0 = r2
            goto L_0x0042
        L_0x0037:
            int r0 = r7.hashCode()
            boolean r0 = r6.isInverseColor(r0)
            if (r0 == r8) goto L_0x0033
            goto L_0x0035
        L_0x0042:
            if (r0 == 0) goto L_0x0074
            com.oppo.camera.ui.inverse.c$b r3 = r6.mHandler
            r3.removeMessages(r2)
            com.oppo.camera.ui.inverse.c$b r3 = r6.mHandler
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r8)
            r4[r1] = r5
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            r4[r2] = r9
            r9 = 2
            r4[r9] = r10
            android.os.Message r9 = r3.obtainMessage(r2, r4)
            int r7 = r7.hashCode()
            r9.arg1 = r7
            com.oppo.camera.ui.inverse.c$b r7 = r6.mHandler
            r1 = 500(0x1f4, double:2.47E-321)
            r7.sendMessageDelayed(r9, r1)
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r8)
            r6.mbDelayInverseColor = r7
        L_0x0074:
            return r0
        L_0x0075:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.inverse.c.setInverseDelay(android.content.Context, boolean, boolean, com.oppo.camera.ui.inverse.c$a):boolean");
    }

    public void setInverseColor(Context context, boolean z, boolean z2) {
        setInverseColor(context.hashCode(), z, z2);
    }

    public boolean isInverseColor(int i) {
        Boolean bool = this.mInverseMap.get(Integer.valueOf(i));
        return bool != null && bool.booleanValue();
    }

    public void setInverseColor(final int i, final boolean z, boolean z2) {
        String str = TAG;
        e.b(str, "setInverseColor, contextHash: " + i + ", inverseColor: " + z + ", showAnimation: " + z2);
        if (!this.mInverseMap.containsKey(Integer.valueOf(i))) {
            String str2 = TAG;
            e.b(str2, "setInverseColor, return, contextHash: " + i);
            return;
        }
        this.mHandler.removeMessages(1);
        this.mbDelayInverseColor = null;
        this.mDelayInverseTs = System.currentTimeMillis();
        if (isInverseColor(i) == z) {
            String str3 = TAG;
            e.b(str3, "setInverseColor, color return, contextHash: " + i);
            return;
        }
        if (this.mbAnimationRunning) {
            String str4 = TAG;
            e.b(str4, "setInverseColor, animation running, contextHash: " + i);
            this.mAnimator.cancel();
        }
        this.mInverseMap.put(Integer.valueOf(i), Boolean.valueOf(z));
        if (z2) {
            this.mAnimator = null;
            if (z) {
                this.mAnimator = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            } else {
                this.mAnimator = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            }
            this.mAnimator.setInterpolator(this.mInterpolator);
            this.mAnimator.setDuration(200);
            this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(i, z) {
                private final /* synthetic */ int f$1;
                private final /* synthetic */ boolean f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    c.this.lambda$setInverseColor$1$c(this.f$1, this.f$2, valueAnimator);
                }
            });
            this.mAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    boolean unused = c.this.mbAnimationRunning = false;
                }

                public void onAnimationEnd(Animator animator) {
                    boolean unused = c.this.mbAnimationRunning = false;
                }

                public void onAnimationStart(Animator animator) {
                    synchronized (c.this.mLock) {
                        String access$200 = c.TAG;
                        e.b(access$200, "setInverseColor, onAnimationStart, mbAnimationRunning: " + c.this.mbAnimationRunning);
                        if (c.this.mbAnimationRunning) {
                            c.this.mInverseViewHolder.a((d.a) new d.a(i, z) {
                                private final /* synthetic */ int f$0;
                                private final /* synthetic */ boolean f$1;

                                {
                                    this.f$0 = r1;
                                    this.f$1 = r2;
                                }

                                public final boolean call(Object obj, b bVar) {
                                    return c.AnonymousClass1.a(this.f$0, this.f$1, obj, bVar);
                                }
                            });
                            String access$2002 = c.TAG;
                            e.b(access$2002, "setInverseColor, onAnimationStart X, mbAnimationRunning: " + c.this.mbAnimationRunning);
                        }
                    }
                }

                /* access modifiers changed from: private */
                public static /* synthetic */ boolean a(int i, boolean z, Object obj, b bVar) {
                    if (bVar.e != b.a.common || i != bVar.f4025a) {
                        return false;
                    }
                    try {
                        ((a) obj).setInverseColor(z);
                        return false;
                    } catch (Exception e) {
                        e.printStackTrace();
                        e.b(c.TAG, e.getMessage());
                        return false;
                    }
                }
            });
            this.mbAnimationRunning = true;
            this.mAnimator.start();
        } else {
            synchronized (this.mLock) {
                String str5 = TAG;
                e.b(str5, "setInverseColor, no animation, mbAnimationRunning: " + this.mbAnimationRunning);
                this.mInverseViewHolder.a((d.a) new d.a(i, z) {
                    private final /* synthetic */ int f$1;
                    private final /* synthetic */ boolean f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final boolean call(Object obj, b bVar) {
                        return c.this.lambda$setInverseColor$2$c(this.f$1, this.f$2, obj, bVar);
                    }
                });
                String str6 = TAG;
                e.b(str6, "setInverseColor, no animation X, mbAnimationRunning: " + this.mbAnimationRunning);
            }
        }
        String str7 = TAG;
        e.b(str7, "setInverseColor X, contextHash: " + i);
    }

    /* renamed from: com.oppo.camera.ui.inverse.c$2  reason: invalid class name */
    /* compiled from: InverseManager */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4029a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.oppo.camera.ui.inverse.b$a[] r0 = com.oppo.camera.ui.inverse.b.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4029a = r0
                int[] r0 = f4029a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.oppo.camera.ui.inverse.b$a r1 = com.oppo.camera.ui.inverse.b.a.common     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f4029a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.oppo.camera.ui.inverse.b$a r1 = com.oppo.camera.ui.inverse.b.a.background     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f4029a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.oppo.camera.ui.inverse.b$a r1 = com.oppo.camera.ui.inverse.b.a.mask     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f4029a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.oppo.camera.ui.inverse.b$a r1 = com.oppo.camera.ui.inverse.b.a.preview     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.inverse.c.AnonymousClass2.<clinit>():void");
        }
    }

    private int getColorWithAlpha(int i, float f) {
        return Color.argb((int) (((float) Color.alpha(i)) * f), Color.red(i), Color.green(i), Color.blue(i));
    }

    private int inverse(int i, float f, boolean z) {
        float f2;
        int i2;
        float f3;
        if (Color.alpha(i) != 0) {
            f3 = 204.0f * f;
            i2 = Color.alpha(i);
        } else if (z) {
            f2 = 0.0f;
            float f4 = 1.0f - f;
            return Color.argb((int) f2, (int) ((((float) Color.red(this.mInverseColor)) * f) + (((float) Color.red(i)) * f4)), (int) ((((float) Color.green(this.mInverseColor)) * f) + (((float) Color.green(i)) * f4)), (int) ((((float) Color.blue(this.mInverseColor)) * f) + (((float) Color.blue(i)) * f4)));
        } else {
            f3 = 204.0f * f;
            i2 = Color.alpha(i);
        }
        f2 = (((float) i2) * (1.0f - f)) + f3;
        float f42 = 1.0f - f;
        return Color.argb((int) f2, (int) ((((float) Color.red(this.mInverseColor)) * f) + (((float) Color.red(i)) * f42)), (int) ((((float) Color.green(this.mInverseColor)) * f) + (((float) Color.green(i)) * f42)), (int) ((((float) Color.blue(this.mInverseColor)) * f) + (((float) Color.blue(i)) * f42)));
    }

    public void registerBackgroundInverse(Context context, View view, boolean z) {
        if (this.mInverseMap.containsKey(Integer.valueOf(context.hashCode())) && !this.mInverseViewHolder.c(view)) {
            Drawable background = view.getBackground();
            if (background instanceof ColorDrawable) {
                b bVar = new b(b.a.background);
                bVar.f4025a = context.hashCode();
                bVar.f4026b = ((ColorDrawable) background).getColor();
                bVar.c = z;
                this.mInverseViewHolder.a(view, bVar);
                view.setBackgroundColor(bVar.f4026b);
            } else {
                b bVar2 = new b(b.a.background);
                bVar2.f4025a = context.hashCode();
                this.mInverseViewHolder.a(view, bVar2);
            }
            String str = TAG;
            e.b(str, "registerBackgroundInverse, context.hashCode(): " + context.hashCode() + ", mInverseViewMap: " + this.mInverseViewHolder.a());
        }
    }

    public int getBackgroundColor(View view, int i) {
        b b2 = this.mInverseViewHolder.b(view);
        if (b2 == null) {
            return i;
        }
        b2.f4026b = i;
        return (isInverseAble(view.getContext()) && this.mbAnimationRunning) || isInverseColor(view.getContext().hashCode()) ? inverse(i, b2.d, b2.c) : i;
    }

    public void registerInverse(Context context, a aVar) {
        if (this.mInverseMap.containsKey(Integer.valueOf(context.hashCode())) && !this.mInverseViewHolder.c(aVar)) {
            b bVar = new b(b.a.common);
            bVar.f4025a = context.hashCode();
            this.mInverseViewHolder.a(aVar, bVar);
            aVar.setInverseColor(isInverseColor(context.hashCode()));
            String str = TAG;
            e.b(str, "registerInverse, context.hashCode(): " + context.hashCode() + ", mInverseViewMap: " + this.mInverseViewHolder.a());
        }
    }

    public void unRegisterInverse(Context context, a aVar) {
        if (this.mInverseMap.containsKey(Integer.valueOf(context.hashCode())) && this.mInverseViewHolder.c(aVar)) {
            this.mInverseViewHolder.a((Object) aVar);
        }
    }

    public void setInverseMaskView(Context context, InverseMaskView inverseMaskView) {
        if (this.mInverseMap.containsKey(Integer.valueOf(context.hashCode())) && !this.mInverseViewHolder.c(inverseMaskView)) {
            b bVar = new b(b.a.mask);
            bVar.f4025a = context.hashCode();
            this.mInverseViewHolder.a(inverseMaskView, bVar);
            inverseMaskView.setInverseColor(isInverseColor(context.hashCode()));
        }
    }

    public void setCameraPreviewUI(Context context, com.oppo.camera.ui.preview.d dVar) {
        if (this.mInverseMap.containsKey(Integer.valueOf(context.hashCode())) && !this.mInverseViewHolder.c(dVar)) {
            b bVar = new b(b.a.preview);
            bVar.f4025a = context.hashCode();
            this.mInverseViewHolder.a(dVar, bVar);
            dVar.a(isInverseColor(context.hashCode()), getColorWithAlpha(this.mInverseColor, 1.0f));
        }
    }

    public void setMaskAlpha(Context context, float f) {
        withMask(context, new C0101c(f) {
            private final /* synthetic */ float f$0;

            {
                this.f$0 = r1;
            }

            public final void call(InverseMaskView inverseMaskView) {
                inverseMaskView.setMaskAlpha(this.f$0);
            }
        });
    }

    public void setMaskAlpha(Context context, boolean z, boolean z2) {
        withMask(context, new C0101c(z, z2) {
            private final /* synthetic */ boolean f$0;
            private final /* synthetic */ boolean f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void call(InverseMaskView inverseMaskView) {
                inverseMaskView.a(this.f$0, this.f$1);
            }
        });
    }

    public void startMaskScaleAnimation(Context context) {
        withMask(context, new C0101c(context) {
            private final /* synthetic */ Context f$1;

            {
                this.f$1 = r2;
            }

            public final void call(InverseMaskView inverseMaskView) {
                c.this.lambda$startMaskScaleAnimation$5$c(this.f$1, inverseMaskView);
            }
        });
    }

    public void setPositionRatio(Context context, float f, boolean z) {
        withMask(context, new C0101c(f, z) {
            private final /* synthetic */ float f$0;
            private final /* synthetic */ boolean f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void call(InverseMaskView inverseMaskView) {
                inverseMaskView.a(this.f$0, this.f$1);
            }
        });
    }

    public void withMask(Context context, C0101c cVar) {
        if (context != null && this.mInverseMap.containsKey(Integer.valueOf(context.hashCode()))) {
            this.mInverseViewHolder.a((d.a) new d.a(context, cVar) {
                private final /* synthetic */ Context f$0;
                private final /* synthetic */ c.C0101c f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final boolean call(Object obj, b bVar) {
                    return c.lambda$withMask$7(this.f$0, this.f$1, obj, bVar);
                }
            });
        }
    }

    public boolean isInverseAble(Context context) {
        return this.mInverseMap.containsKey(Integer.valueOf(context.hashCode()));
    }

    public void setExecuteDelayMsg(boolean z) {
        this.mbExecuteDelayMsg = z;
    }

    public void clear() {
        this.mInverseViewHolder.a((Context) null);
    }

    public void removeMessages() {
        b bVar = this.mHandler;
        if (bVar != null) {
            bVar.removeMessages(1);
        }
    }

    public void postInverseColor(int i, boolean z, boolean z2) {
        Message obtainMessage = this.mHandler.obtainMessage(2, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    /* compiled from: InverseManager */
    public class b extends Handler {
        public b() {
        }

        public void handleMessage(Message message) {
            int i = message.arg1;
            if (c.this.mInverseMap.containsKey(Integer.valueOf(i)) && c.this.mbExecuteDelayMsg) {
                if (1 == message.what) {
                    Object[] objArr = (Object[]) message.obj;
                    c.this.setInverseColor(i, ((Boolean) objArr[0]).booleanValue(), ((Boolean) objArr[1]).booleanValue());
                    a aVar = (a) objArr[2];
                    if (aVar != null) {
                        aVar.call();
                    }
                } else if (2 == message.what) {
                    Object[] objArr2 = (Object[]) message.obj;
                    c.this.setInverseColor(i, ((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue());
                }
            }
        }
    }
}
