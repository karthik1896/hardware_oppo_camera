package com.oppo.camera.ui.menu.b;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.oppo.camera.R;
import com.oppo.camera.ui.menu.b.f;
import java.util.List;

/* compiled from: HeadlineGLSurfaceView */
public class c extends GLSurfaceView {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Object f4073a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Object f4074b = new Object();
    /* access modifiers changed from: private */
    public f c = null;
    private GestureDetector d = null;
    /* access modifiers changed from: private */
    public int e = 0;
    private ValueAnimator f = null;
    private PathInterpolator g = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    /* access modifiers changed from: private */
    public int h = 0;
    /* access modifiers changed from: private */
    public int i = -1;
    private int j = 0;
    /* access modifiers changed from: private */
    public e k = null;
    /* access modifiers changed from: private */
    public a l = null;
    /* access modifiers changed from: private */
    public String[] m = null;
    /* access modifiers changed from: private */
    public boolean n = false;
    /* access modifiers changed from: private */
    public boolean o = true;
    private boolean p = false;

    /* compiled from: HeadlineGLSurfaceView */
    public interface e {
        boolean U();

        boolean V();

        boolean W();

        boolean X();

        void l(int i);

        boolean m(int i);
    }

    public c(Context context) {
        super(context);
        this.l = new a(context);
        this.l.setForceDarkAllowed(false);
    }

    public void a(int i2, int i3, e eVar) {
        com.oppo.camera.e.a("HeadlineGLSurfaceView", "initialize, width: " + i2 + ", height: " + i3 + ", listener: " + eVar);
        this.e = i2;
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 8, 8);
        getHolder().setFormat(-3);
        setZOrderOnTop(true);
        this.c = new f(getContext(), i2, i3, new b());
        setRenderer(this.c);
        setRenderMode(0);
        com.oppo.camera.ui.inverse.c.INS.registerInverse(getContext(), this.c);
        this.d = new GestureDetector(getContext(), new a());
        this.k = eVar;
    }

    public View getHeadlineBackground() {
        return this.l;
    }

    public void a(int... iArr) {
        f fVar = this.c;
        if (fVar != null) {
            fVar.b(iArr);
        }
    }

    public void b(int... iArr) {
        f fVar = this.c;
        if (fVar != null) {
            fVar.a(iArr);
        }
    }

    public void a(List<Integer> list) {
        com.oppo.camera.e.a("HeadlineGLSurfaceView", "updateTextAndIndex, textIdList: " + list);
        if (list == null || list.size() <= 0) {
            com.oppo.camera.e.e("HeadlineGLSurfaceView", "updateText, the parameter is illegal");
            return;
        }
        synchronized (this.f4074b) {
            this.m = b(list);
        }
        if (this.c != null) {
            synchronized (this.f4073a) {
                this.j = this.m.length - 1;
                this.h = this.c.b(this.m);
            }
        }
    }

    public void a(List<Integer> list, int i2) {
        com.oppo.camera.e.a("HeadlineGLSurfaceView", "updateText, textIdList: " + list + ", currentIndex: " + i2);
        if (list == null || list.size() <= 0 || i2 < 0 || i2 >= list.size()) {
            com.oppo.camera.e.e("HeadlineGLSurfaceView", "updateText, the parameter is illegal");
            return;
        }
        synchronized (this.f4074b) {
            this.m = b(list);
        }
        synchronized (this.f4073a) {
            this.j = this.m.length - 1;
            setCurrentIndex(i2);
        }
        f fVar = this.c;
        if (fVar != null) {
            fVar.a(this.m);
            this.c.a(i2, true);
        }
    }

    private String[] b(List<Integer> list) {
        String[] strArr = new String[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            strArr[i2] = getContext().getString(list.get(i2).intValue());
        }
        return strArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f4074b
            monitor-enter(r0)
            java.lang.String[] r1 = r4.m     // Catch:{ all -> 0x002f }
            r2 = 0
            if (r1 != 0) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return r2
        L_0x000a:
            int r1 = r4.h     // Catch:{ all -> 0x002f }
            if (r1 < 0) goto L_0x002d
            int r1 = r4.h     // Catch:{ all -> 0x002f }
            java.lang.String[] r3 = r4.m     // Catch:{ all -> 0x002f }
            int r3 = r3.length     // Catch:{ all -> 0x002f }
            if (r1 < r3) goto L_0x0016
            goto L_0x002d
        L_0x0016:
            java.lang.String[] r1 = r4.m     // Catch:{ all -> 0x002f }
            int r2 = r4.h     // Catch:{ all -> 0x002f }
            r1 = r1[r2]     // Catch:{ all -> 0x002f }
            android.content.Context r2 = r4.getContext()     // Catch:{ all -> 0x002f }
            r3 = 2131755380(0x7f100174, float:1.9141638E38)
            java.lang.String r2 = r2.getString(r3)     // Catch:{ all -> 0x002f }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x002f }
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return r1
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return r2
        L_0x002f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.menu.b.c.a():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        r0 = r3.c;
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        if (r0 == null) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        r0.c(0);
        r1 = r3.c.b(r3.h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0045, code lost:
        if (r1 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
        r0 = r3.k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
        r0.l(r3.h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r3 = this;
            java.lang.String r0 = "HeadlineGLSurfaceView"
            java.lang.String r1 = "slideNextItem"
            com.oppo.camera.e.a(r0, r1)
            com.oppo.camera.ui.menu.b.c$e r0 = r3.k
            if (r0 == 0) goto L_0x0054
            int r1 = r3.h
            boolean r0 = r0.m(r1)
            if (r0 != 0) goto L_0x0014
            goto L_0x0054
        L_0x0014:
            java.lang.Object r0 = r3.f4073a
            monitor-enter(r0)
            int r1 = r3.h     // Catch:{ all -> 0x0051 }
            int r1 = r1 + 1
            int r2 = r3.j     // Catch:{ all -> 0x0051 }
            if (r1 <= r2) goto L_0x002d
            int r1 = r3.j     // Catch:{ all -> 0x0051 }
            r3.setCurrentIndex(r1)     // Catch:{ all -> 0x0051 }
            java.lang.String r1 = "HeadlineGLSurfaceView"
            java.lang.String r2 = "slideNextItem, current index is max, can not slide"
            com.oppo.camera.e.e(r1, r2)     // Catch:{ all -> 0x0051 }
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return
        L_0x002d:
            int r1 = r3.h     // Catch:{ all -> 0x0051 }
            int r1 = r1 + 1
            r3.setCurrentIndex(r1)     // Catch:{ all -> 0x0051 }
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            com.oppo.camera.ui.menu.b.f r0 = r3.c
            r1 = 0
            if (r0 == 0) goto L_0x0045
            r0.c((int) r1)
            com.oppo.camera.ui.menu.b.f r0 = r3.c
            int r1 = r3.h
            boolean r1 = r0.b((int) r1)
        L_0x0045:
            if (r1 == 0) goto L_0x0050
            com.oppo.camera.ui.menu.b.c$e r0 = r3.k
            if (r0 == 0) goto L_0x0050
            int r1 = r3.h
            r0.l(r1)
        L_0x0050:
            return
        L_0x0051:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            throw r1
        L_0x0054:
            java.lang.String r0 = "HeadlineGLSurfaceView"
            java.lang.String r1 = "slideNextItem, can not slide"
            com.oppo.camera.e.e(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.menu.b.c.b():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        r0 = r3.c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        if (r0 == null) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        r0.c(0);
        r2 = r3.c.b(r3.h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        if (r2 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        r0 = r3.k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        r0.l(r3.h);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c() {
        /*
            r3 = this;
            java.lang.String r0 = "HeadlineGLSurfaceView"
            java.lang.String r1 = "slidePreviousItem"
            com.oppo.camera.e.a(r0, r1)
            com.oppo.camera.ui.menu.b.c$e r0 = r3.k
            if (r0 == 0) goto L_0x0050
            int r1 = r3.h
            boolean r0 = r0.m(r1)
            if (r0 != 0) goto L_0x0014
            goto L_0x0050
        L_0x0014:
            java.lang.Object r0 = r3.f4073a
            monitor-enter(r0)
            int r1 = r3.h     // Catch:{ all -> 0x004d }
            int r1 = r1 + -1
            r2 = 0
            if (r1 >= 0) goto L_0x002a
            r3.setCurrentIndex(r2)     // Catch:{ all -> 0x004d }
            java.lang.String r1 = "HeadlineGLSurfaceView"
            java.lang.String r2 = "slidePreviousItem, current index is min, can not slide"
            com.oppo.camera.e.e(r1, r2)     // Catch:{ all -> 0x004d }
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            return
        L_0x002a:
            int r1 = r3.h     // Catch:{ all -> 0x004d }
            int r1 = r1 + -1
            r3.setCurrentIndex(r1)     // Catch:{ all -> 0x004d }
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            com.oppo.camera.ui.menu.b.f r0 = r3.c
            if (r0 == 0) goto L_0x0041
            r0.c((int) r2)
            com.oppo.camera.ui.menu.b.f r0 = r3.c
            int r1 = r3.h
            boolean r2 = r0.b((int) r1)
        L_0x0041:
            if (r2 == 0) goto L_0x004c
            com.oppo.camera.ui.menu.b.c$e r0 = r3.k
            if (r0 == 0) goto L_0x004c
            int r1 = r3.h
            r0.l(r1)
        L_0x004c:
            return
        L_0x004d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            throw r1
        L_0x0050:
            java.lang.String r0 = "HeadlineGLSurfaceView"
            java.lang.String r1 = "slidePreviousItem, can not slide"
            com.oppo.camera.e.e(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.menu.b.c.c():void");
    }

    public void a(boolean z) {
        if (this.c != null) {
            synchronized (this.f4073a) {
                if (this.m[this.h].equals(getContext().getString(R.string.camera_mode_more))) {
                    setCurrentIndex(this.c.a());
                }
            }
            setVisibility(z ? 0 : 4);
            com.oppo.camera.e.a("HeadlineGLSurfaceView", "backToLastHeadlineIndex, last index: " + this.h);
            this.c.a(this.h, false);
        }
    }

    public boolean d() {
        return this.p;
    }

    public void setMultiFinger(boolean z) {
        this.p = z;
    }

    /* compiled from: HeadlineGLSurfaceView */
    private class b implements f.a {
        private b() {
        }

        public void a(int i, boolean z) {
            if ((i == 0 || i == 1) && c.this.getRenderMode() != i) {
                c.this.setRenderMode(i);
            }
            if (z) {
                c.this.requestRender();
            }
        }

        public c a() {
            return c.this;
        }

        public void a(int i, int i2, float f) {
            if (c.this.l != null) {
                c.this.l.a(i, i2);
                c.this.l.setAlpha(f);
            }
        }
    }

    /* compiled from: HeadlineGLSurfaceView */
    private class a extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: b  reason: collision with root package name */
        private float f4078b;
        private int c;

        private a() {
            this.f4078b = 0.0f;
            this.c = 0;
        }

        public boolean onDown(MotionEvent motionEvent) {
            com.oppo.camera.e.a("HeadlineGLSurfaceView", "DefaultGestureDetector, onDown");
            this.f4078b = 0.0f;
            boolean unused = c.this.n = false;
            int unused2 = c.this.i = -1;
            this.c = motionEvent.getPointerId(motionEvent.getActionIndex());
            if (c.this.c != null) {
                c.this.c.c();
            }
            return super.onDown(motionEvent);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (!c.this.o) {
                com.oppo.camera.e.b("HeadlineGLSurfaceView", "DefaultGestureDetector, onSingleTapUp, can't response TouchEvent.");
                return false;
            } else if (c.this.k != null && (c.this.k.V() || c.this.k.W())) {
                com.oppo.camera.e.a("HeadlineGLSurfaceView", "DefaultGestureDetector, onSingleTapUp, so return when isCapturingOrVideoRecording or isNoneSatUltraWideAngleChanging");
                return false;
            } else if (c.this.e() || c.this.getVisibility() != 0) {
                com.oppo.camera.e.a("HeadlineGLSurfaceView", "DefaultGestureDetector, onSingleTapUp, can't response TouchEvent , isAnimationRunning or View is not visible");
                return false;
            } else {
                float rawX = motionEvent.getRawX();
                com.oppo.camera.e.a("HeadlineGLSurfaceView", "DefaultGestureDetector, onSingleTapUp, x: " + rawX);
                if (c.this.e <= 0 || Float.compare(rawX, 0.0f) < 0 || Float.compare(rawX, (float) c.this.e) > 0 || c.this.c == null) {
                    return super.onSingleTapUp(motionEvent);
                }
                int a2 = c.this.c.a(rawX - ((float) (c.this.e / 2)));
                boolean unused = c.this.n = false;
                synchronized (c.this.f4073a) {
                    if (a2 >= 0) {
                        try {
                            c.this.setCurrentIndex(a2);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (a2 >= 0 && c.this.k != null) {
                        c.this.k.l(c.this.h);
                    }
                }
                return true;
            }
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.f4078b += f / 1.2f;
            if (this.c != motionEvent2.getPointerId(motionEvent2.getActionIndex())) {
                com.oppo.camera.e.b("HeadlineGLSurfaceView", "DefaultGestureDetector, onScroll, Not the same event.");
                return true;
            } else if (!c.this.o) {
                com.oppo.camera.e.b("HeadlineGLSurfaceView", "DefaultGestureDetector, onScroll, can't response TouchEvent.");
                return false;
            } else if (c.this.k == null || !c.this.k.V()) {
                com.oppo.camera.e.a("HeadlineGLSurfaceView", "DefaultGestureDetector, onScroll, mOffSetDistance: " + this.f4078b);
                if (c.this.k != null && !c.this.k.X()) {
                    com.oppo.camera.e.a("HeadlineGLSurfaceView", "DefaultGestureDetector, onScroll return");
                    return false;
                } else if (c.this.e <= 0 || Float.compare(Math.abs(this.f4078b), (float) c.this.e) > 0 || c.this.c == null) {
                    return super.onScroll(motionEvent, motionEvent2, f, f2);
                } else {
                    c cVar = c.this;
                    int unused = cVar.i = cVar.c.b(this.f4078b);
                    boolean unused2 = c.this.n = true;
                    return true;
                }
            } else {
                com.oppo.camera.e.a("HeadlineGLSurfaceView", "DefaultGestureDetector, onScroll, so return when isCapturingOrVideoRecording");
                return false;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        e eVar;
        e eVar2 = this.k;
        boolean z = false;
        if (eVar2 == null) {
            return false;
        }
        if (eVar2.U()) {
            com.oppo.camera.e.a("HeadlineGLSurfaceView", "onTouchEvent, return when isTimerSnapShotRunning");
            return true;
        }
        if (motionEvent.getAction() == 0) {
            this.p = false;
            this.o = this.k.m(this.h);
            com.oppo.camera.e.a("HeadlineGLSurfaceView", "onTouchEvent, mbCanResponseTouch: " + this.o);
        }
        GestureDetector gestureDetector = this.d;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.n && (eVar = this.k) != null && !eVar.V()) {
            if (motionEvent.getPointerCount() >= 2) {
                z = true;
            }
            this.p = z;
            i();
        }
        return true;
    }

    public void onResume() {
        com.oppo.camera.e.a("HeadlineGLSurfaceView", "onResume");
        super.onResume();
        if (this.c != null && getVisibility() == 0) {
            this.c.a(this.h, true);
        }
    }

    public void onPause() {
        com.oppo.camera.e.a("HeadlineGLSurfaceView", "onPause");
        super.onPause();
        this.n = false;
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f.cancel();
            this.f = null;
        }
        a(1.0f);
    }

    public boolean e() {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    public boolean f() {
        return getVisibility() == 0;
    }

    public void setVisibility(int i2) {
        com.oppo.camera.e.a("HeadlineGLSurfaceView", "setVisibility, visibility: " + i2);
        super.setVisibility(i2);
        a aVar = this.l;
        if (aVar != null) {
            aVar.setVisibility(i2);
        }
    }

    public void a(int i2, boolean z, boolean z2) {
        ValueAnimator valueAnimator;
        com.oppo.camera.e.a("HeadlineGLSurfaceView", "setVisibility, visibility: " + i2 + ", isAnim: " + z);
        if (getVisibility() != i2 || ((valueAnimator = this.f) != null && valueAnimator.isRunning())) {
            ValueAnimator valueAnimator2 = this.f;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.f.cancel();
                this.f = null;
            }
            if (!z) {
                a(1.0f);
                setVisibility(i2);
            } else if (i2 == 0) {
                a(i2, 160, 0, (TimeInterpolator) this.g, z2);
            } else {
                a(i2, 80, 0, (TimeInterpolator) this.g, z2);
            }
        }
    }

    private Animation b(boolean z) {
        Animation animation;
        if (z) {
            animation = AnimationUtils.loadAnimation(getContext(), R.anim.headline_vertical_in);
        } else {
            animation = AnimationUtils.loadAnimation(getContext(), R.anim.headline_vertical_out);
        }
        startAnimation(animation);
        this.l.startAnimation(animation);
        return animation;
    }

    public void a(int i2, long j2, long j3, TimeInterpolator timeInterpolator, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("setVisibilityWithAnimator, visibility: ");
        int i3 = i2;
        sb.append(i2);
        sb.append(", duration: ");
        sb.append(j2);
        sb.append(", startDelay: ");
        long j4 = j3;
        sb.append(j4);
        sb.append(", interpolator: ");
        TimeInterpolator timeInterpolator2 = timeInterpolator;
        sb.append(timeInterpolator2);
        com.oppo.camera.e.a("HeadlineGLSurfaceView", sb.toString());
        a(i2, j2, j4, timeInterpolator2, (Animator.AnimatorListener) null, z);
    }

    public void a(int i2, long j2, long j3, TimeInterpolator timeInterpolator, Animator.AnimatorListener animatorListener, boolean z) {
        int i3 = i2;
        StringBuilder sb = new StringBuilder();
        sb.append("setVisibilityWithAnimator, visibility: ");
        sb.append(i2);
        sb.append(", duration: ");
        long j4 = j2;
        sb.append(j2);
        sb.append(", startDelay: ");
        long j5 = j3;
        sb.append(j3);
        sb.append(", interpolator: ");
        sb.append(timeInterpolator);
        sb.append(", listener: ");
        sb.append(animatorListener);
        com.oppo.camera.e.a("HeadlineGLSurfaceView", sb.toString());
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f.cancel();
            this.f = null;
        }
        if (i3 == 0) {
            a(j2, j3, timeInterpolator, animatorListener, z);
        } else {
            b(j2, j3, timeInterpolator, animatorListener, z);
        }
    }

    private void a(long j2, long j3, TimeInterpolator timeInterpolator, Animator.AnimatorListener animatorListener, boolean z) {
        Interpolator interpolator;
        long j4;
        TimeInterpolator timeInterpolator2 = timeInterpolator == null ? this.g : timeInterpolator;
        long j5 = j2 <= 0 ? 160 : j2;
        if (z) {
            Animation b2 = b(true);
            j5 = b2.getDuration();
            long startOffset = b2.getStartOffset();
            interpolator = b2.getInterpolator();
            j4 = startOffset;
        } else {
            j4 = j3;
            interpolator = timeInterpolator2;
        }
        this.f = a(0.0f, 1.0f, j5, j4, interpolator, (Animator.AnimatorListener) new d(animatorListener));
        a(0.0f);
        a aVar = this.l;
        if (aVar != null) {
            aVar.setAlpha(0.0f);
        }
        setVisibility(0);
        setEnabled(false);
        this.f.start();
    }

    private void b(long j2, long j3, TimeInterpolator timeInterpolator, Animator.AnimatorListener animatorListener, boolean z) {
        Interpolator interpolator;
        long j4;
        TimeInterpolator timeInterpolator2 = timeInterpolator == null ? this.g : timeInterpolator;
        long j5 = j2 <= 0 ? 80 : j2;
        if (z) {
            Animation b2 = b(false);
            j5 = b2.getDuration();
            long startOffset = b2.getStartOffset();
            interpolator = b2.getInterpolator();
            j4 = startOffset;
        } else {
            j4 = j3;
            interpolator = timeInterpolator2;
        }
        this.f = a(1.0f, 0.0f, j5, j4, interpolator, (Animator.AnimatorListener) new C0102c(animatorListener));
        a(1.0f);
        a aVar = this.l;
        if (aVar != null) {
            aVar.setAlpha(1.0f);
        }
        setEnabled(false);
        this.f.start();
    }

    /* access modifiers changed from: private */
    public void a(float f2) {
        com.oppo.camera.e.a("HeadlineGLSurfaceView", "updateAlpha, alpha: " + f2);
        f fVar = this.c;
        if (fVar != null) {
            fVar.c(f2);
        }
    }

    /* access modifiers changed from: private */
    public void setCurrentIndex(int i2) {
        if (i2 < 0 || i2 > this.j) {
            com.oppo.camera.e.e("HeadlineGLSurfaceView", "setCurrentIndex, index is wrong, index: " + i2);
            return;
        }
        if (i2 != this.h) {
            this.h = i2;
            if (this.l != null) {
                post(new Runnable() {
                    public void run() {
                        synchronized (c.this.f4074b) {
                            c.this.l.setContentDescription(c.this.m[c.this.h]);
                        }
                    }
                });
            }
        }
        com.oppo.camera.e.a("HeadlineGLSurfaceView", "setCurrentIndex, mCurrentIndex: " + this.h);
    }

    /* compiled from: HeadlineGLSurfaceView */
    private class d implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        private Animator.AnimatorListener f4083b = null;

        public d(Animator.AnimatorListener animatorListener) {
            this.f4083b = animatorListener;
        }

        public void onAnimationStart(Animator animator) {
            com.oppo.camera.e.a("HeadlineGLSurfaceView", "DefaultShowAnimatorListener, onAnimationStart");
            Animator.AnimatorListener animatorListener = this.f4083b;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animator);
            }
        }

        public void onAnimationEnd(Animator animator) {
            com.oppo.camera.e.a("HeadlineGLSurfaceView", "DefaultShowAnimatorListener, onAnimationEnd");
            c.this.a(1.0f);
            c.this.setEnabled(true);
            Animator.AnimatorListener animatorListener = this.f4083b;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        public void onAnimationCancel(Animator animator) {
            com.oppo.camera.e.a("HeadlineGLSurfaceView", "DefaultShowAnimatorListener, onAnimationCancel");
            c.this.a(1.0f);
            c.this.setEnabled(true);
            Animator.AnimatorListener animatorListener = this.f4083b;
            if (animatorListener != null) {
                animatorListener.onAnimationCancel(animator);
            }
        }

        public void onAnimationRepeat(Animator animator) {
            Animator.AnimatorListener animatorListener = this.f4083b;
            if (animatorListener != null) {
                animatorListener.onAnimationRepeat(animator);
            }
        }
    }

    /* renamed from: com.oppo.camera.ui.menu.b.c$c  reason: collision with other inner class name */
    /* compiled from: HeadlineGLSurfaceView */
    private class C0102c implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        private Animator.AnimatorListener f4081b = null;

        public C0102c(Animator.AnimatorListener animatorListener) {
            this.f4081b = animatorListener;
        }

        public void onAnimationStart(Animator animator) {
            com.oppo.camera.e.a("HeadlineGLSurfaceView", "DefaultHideAnimatorListener, onAnimationStart");
            Animator.AnimatorListener animatorListener = this.f4081b;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animator);
            }
        }

        public void onAnimationEnd(Animator animator) {
            com.oppo.camera.e.a("HeadlineGLSurfaceView", "DefaultHideAnimatorListener, onAnimationEnd");
            c.this.setVisibility(4);
            c.this.a(1.0f);
            c.this.setEnabled(true);
            Animator.AnimatorListener animatorListener = this.f4081b;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        public void onAnimationCancel(Animator animator) {
            com.oppo.camera.e.a("HeadlineGLSurfaceView", "DefaultHideAnimatorListener, onAnimationCancel");
            c.this.setVisibility(4);
            c.this.a(1.0f);
            c.this.setEnabled(true);
            Animator.AnimatorListener animatorListener = this.f4081b;
            if (animatorListener != null) {
                animatorListener.onAnimationCancel(animator);
            }
        }

        public void onAnimationRepeat(Animator animator) {
            Animator.AnimatorListener animatorListener = this.f4081b;
            if (animatorListener != null) {
                animatorListener.onAnimationRepeat(animator);
            }
        }
    }

    private ValueAnimator a(float f2, float f3, long j2, long j3, TimeInterpolator timeInterpolator, Animator.AnimatorListener animatorListener) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f2, f3});
        ofFloat.setDuration(j2);
        ofFloat.setStartDelay(j3);
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (c.this.c != null) {
                    c.this.c.c(floatValue);
                    c.this.requestRender();
                }
            }
        });
        ofFloat.addListener(animatorListener);
        return ofFloat;
    }

    public boolean g() {
        return this.n;
    }

    private void i() {
        com.oppo.camera.e.a("HeadlineGLSurfaceView", "performOnUp");
        if (this.i != -1) {
            synchronized (this.f4073a) {
                if (!(this.k == null || this.h == this.i)) {
                    this.h = this.i;
                    if (this.c != null) {
                        this.c.a(this.h);
                    }
                    this.k.l(this.h);
                }
            }
            this.n = false;
        }
    }

    public void h() {
        f fVar = this.c;
        if (fVar != null) {
            fVar.b();
        }
    }
}
