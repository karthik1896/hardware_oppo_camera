package com.oppo.camera.e.a;

import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.e;

/* compiled from: MultiCameraDecision */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f3179a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f3180b = 1;
    private int c = 1;
    private int d = 0;
    private int e = 0;
    private int f = 1;
    private String g = "";
    private String h = "";
    private String i = "";
    private int j = -1;
    private int k = -1;
    private int l = -1;
    private int m = -1;
    private boolean n = false;

    public a() {
    }

    public a(int i2, int i3, int i4) {
        this.f3179a = i2;
        this.f3180b = i3;
        this.c = i4;
    }

    public int a() {
        return this.e;
    }

    public String b() {
        return this.g;
    }

    public a a(String str) {
        this.g = str;
        e.b("MultiCameraDecision", "setBeforeModeName, beforeModeName: " + str);
        return this;
    }

    public String c() {
        return this.h;
    }

    public a b(String str) {
        this.h = str;
        e.b("MultiCameraDecision", "setAfterModeName, afterModeName: " + str);
        return this;
    }

    public a a(int i2) {
        this.j = i2;
        return this;
    }

    public a b(int i2) {
        this.k = i2;
        return this;
    }

    public a c(int i2) {
        this.l = i2;
        return this;
    }

    public a d(int i2) {
        this.m = i2;
        return this;
    }

    public a d() {
        int i2 = this.d;
        if (i2 == 0) {
            this.j = 0;
            this.l = 1;
        } else if (i2 != 1) {
        }
        return this;
    }

    public a e() {
        int i2 = this.d;
        if (i2 == 0) {
            this.j = 0;
            this.l = 1;
        } else if (i2 != 1) {
        }
        return this;
    }

    public boolean f() {
        if ((!ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(this.g) || (this.j == this.k && -1 == this.l)) && !ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(this.h)) {
            return false;
        }
        return true;
    }

    public void g() {
        if (ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(this.g) && !this.g.equals(this.h)) {
            this.g = this.h;
        }
    }

    public a a(boolean z) {
        this.n = z;
        return this;
    }

    public String h() {
        return this.i;
    }

    public void c(String str) {
        this.i = str;
        e.b("MultiCameraDecision", "setCurrentModeName, currentModeName: " + str);
    }

    public void i() {
        this.g = null;
        this.i = null;
        this.h = null;
    }

    public String toString() {
        return "MultiCameraDecision{mFirstCameraType=" + this.f3179a + ", mSecondCameraType=" + this.f3180b + ", mBottomCameraType=" + this.c + ", mMultiCameraType=" + this.d + ", mMainLogicId=" + this.e + ", mSubLogicId=" + this.f + ", mBeforeModeName='" + this.g + '\'' + ", mAfterModeName='" + this.h + '\'' + ", mCurrentModeName='" + this.i + '\'' + ", mMainBeforeLogicId=" + this.j + ", mMainAfterLogicId=" + this.k + ", mSubBeforeLogicId=" + this.l + ", mSubAfterLogicId=" + this.m + '}';
    }
}
