package com.oppo.camera.professional;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Size;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.oppo.camera.R;
import com.oppo.camera.aa;
import com.oppo.camera.e;
import com.oppo.camera.f.j;
import com.oppo.camera.professional.LevelPanel;
import com.oppo.exif.OppoExifInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* compiled from: PanelContainer */
public class g extends RelativeLayout implements h {

    /* renamed from: a  reason: collision with root package name */
    protected com.oppo.camera.e.b f3528a = null;

    /* renamed from: b  reason: collision with root package name */
    protected j f3529b = null;
    protected List<LevelPanel> c = new ArrayList();
    private final RelativeLayout.LayoutParams d = new RelativeLayout.LayoutParams(-2, -2);
    private boolean e = true;
    private Activity f = null;
    /* access modifiers changed from: private */
    public c g = null;
    /* access modifiers changed from: private */
    public b h = null;
    private a i = new a();
    /* access modifiers changed from: private */
    public boolean j = false;

    /* compiled from: PanelContainer */
    public interface b {
        void a(int i, String str, boolean z);
    }

    /* compiled from: PanelContainer */
    public interface c {
        void a(int i, String str, boolean z);

        void c(int i);
    }

    public void clearAnimation() {
    }

    public g(Context context, com.oppo.camera.e.b bVar) {
        super(context);
        this.f = (Activity) context;
        this.f3528a = bVar;
        this.d.addRule(14);
    }

    /* access modifiers changed from: private */
    public String j(int i2) {
        return new String[]{"pref_professional_iso_key", "pref_professional_exposure_time_key", "pref_professional_whitebalance_key", "pref_professional_focus_mode_key", "pref_professional_exposure_compensation_key"}[i2];
    }

    public String a(int i2) {
        return this.f.getString(new int[]{R.string.camera_iso_default_value, R.string.camera_exposure_time_default_value, R.string.camera_whitebalance_default_value, R.string.camera_focus_mode_default_value, R.string.camera_exposure_compensation_default_value}[i2]);
    }

    public void setSettleListener(c cVar) {
        this.g = cVar;
    }

    public void setMotionListener(b bVar) {
        this.h = bVar;
    }

    public void a(int i2, int i3, int i4, Handler handler) {
        a(this.d, 0, false, a(i2, i3, i4), 1, handler);
    }

    public void a(long j2, long j3, List<Size> list, Handler handler) {
        a(this.d, 1, false, a(j2, j3, list), 1, handler);
    }

    public void a(int[] iArr, Handler handler) {
        a(this.d, 2, false, a(iArr), 1, handler);
    }

    public void a(float f2, float f3, Handler handler) {
        a(this.d, 3, false, a(f2, f3), 1, handler);
    }

    public void a(int i2, int i3, float f2, Handler handler) {
        a(this.d, 4, false, a(i2, i3, f2), 2, handler);
    }

    public void a(j jVar, Handler handler, a aVar) {
        long j2;
        a(jVar.u(), jVar.v(), jVar.w(), handler);
        if (aVar == null || aVar.f3532a <= 0) {
            j2 = jVar.x();
        } else {
            j2 = aVar.f3532a;
        }
        a(j2, jVar.y(), jVar.a(256), handler);
        a(jVar.B(), handler);
        a(jVar.n(), jVar.m(), handler);
        a(jVar.p(), jVar.q(), jVar.r(), handler);
        e();
    }

    private int a(n nVar) {
        return nVar.e();
    }

    public String getFocusValue() {
        if (g(3)) {
            return a(3);
        }
        return this.c.get(3).a(this.f3528a.r());
    }

    public ArrayList<HashMap<String, Object>> getMainModeBarData() {
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            HashMap hashMap = new HashMap();
            hashMap.put("mainTitle", Integer.valueOf(a(this.c.get(i2).getSubModeBarData())));
            hashMap.put("main_item_key", this.c.get(i2).a(this.f3528a.r()));
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    public void a(boolean z) {
        List<LevelPanel> list = this.c;
        if (list != null && list.size() != 0) {
            n subModeBarData = this.c.get(3).getSubModeBarData();
            if (z) {
                subModeBarData.b((int) R.drawable.profession_af_selector);
            } else {
                subModeBarData.b((int) R.drawable.profession_mf_selector);
            }
        }
    }

    public void a(j jVar, a aVar) {
        List<LevelPanel> list = this.c;
        if (list != null && list.size() != 0) {
            d(jVar);
            b(jVar, aVar);
            c(jVar);
            b(jVar);
            a(jVar);
        }
    }

    private void a(j jVar) {
        if (c(4).size() == 0) {
            a(this.c.get(4).getSubModeBarData(), jVar.p(), jVar.q(), jVar.r());
            this.c.get(4).b();
            if (this.g != null) {
                this.g.a(4, this.c.get(4).a(this.f3528a.r()), g(4));
            }
        }
    }

    private void b(j jVar) {
        if (c(3).size() == 0) {
            a(this.c.get(3).getSubModeBarData(), jVar.n(), jVar.m());
            this.c.get(3).b();
            if (this.g != null) {
                this.g.a(3, this.c.get(3).a(this.f3528a.r()), g(3));
            }
        }
    }

    private void c(j jVar) {
        if (c(2).size() == 0) {
            a(this.c.get(2).getSubModeBarData(), jVar.B());
            this.c.get(2).b();
            if (this.g != null) {
                this.g.a(2, this.c.get(2).a(this.f3528a.r()), g(2));
            }
        }
    }

    public void a(j jVar, long j2) {
        n subModeBarData = this.c.get(1).getSubModeBarData();
        subModeBarData.c().clear();
        subModeBarData.b().clear();
        subModeBarData.e(R.array.professional_exposure_time_values);
        subModeBarData.f(R.array.professional_exposure_time_names);
        a(subModeBarData, j2, jVar.y(), jVar.a(256));
        this.c.get(1).b();
        if (this.g != null) {
            this.g.a(1, this.c.get(1).a(this.f3528a.r()), g(1));
        }
    }

    private void b(j jVar, a aVar) {
        long j2;
        n subModeBarData = this.c.get(1).getSubModeBarData();
        subModeBarData.c().clear();
        subModeBarData.b().clear();
        subModeBarData.e(R.array.professional_exposure_time_values);
        subModeBarData.f(R.array.professional_exposure_time_names);
        if (aVar == null || aVar.f3532a <= 0) {
            j2 = jVar.x();
        } else {
            j2 = aVar.f3532a;
        }
        a(subModeBarData, j2, jVar.y(), jVar.a(256));
        this.c.get(1).b();
        if (this.g != null) {
            this.g.a(1, this.c.get(1).a(this.f3528a.r()), g(1));
        }
    }

    private void d(j jVar) {
        a(this.c.get(0).getSubModeBarData(), jVar.u(), jVar.v(), jVar.w());
        this.c.get(0).b();
        if (this.g != null) {
            this.g.a(0, this.c.get(0).a(this.f3528a.r()), g(0));
        }
    }

    public ArrayList<String> b(int i2) {
        return this.c.get(i2).getParameterValueList();
    }

    public ArrayList<String> c(int i2) {
        return i2 < this.c.size() ? this.c.get(i2).getParameterNamesList() : new ArrayList<>();
    }

    public void scrollTo(int i2, int i3) {
        this.c.get(i2).a(i3, this.f);
    }

    public void a(int i2, int i3) {
        this.c.get(i2).b(i3, this.f);
    }

    public void a(int i2, int i3, String str) {
        this.c.get(i2).a(i3, this.f, str);
    }

    public void a() {
        for (LevelPanel next : this.c) {
            next.b(next.b(this.f3528a.r()));
        }
    }

    public boolean b(int i2, int i3) {
        return this.c.get(i2).a(i3);
    }

    public String d(int i2) {
        return this.f3528a.r().getString(j(i2), a(i2));
    }

    public void a(int i2, String str, int i3) {
        if (i2 < this.c.size()) {
            ArrayList<String> parameterValueList = this.c.get(i2).getParameterValueList();
            if (i3 < parameterValueList.size()) {
                SharedPreferences.Editor edit = this.f3528a.r().edit();
                edit.putString(str, parameterValueList.get(i3));
                edit.putInt(str + "_manual", i3);
                edit.apply();
            }
        }
    }

    public void b() {
        List<LevelPanel> list = this.c;
        if (list != null && list.size() != 0) {
            SharedPreferences.Editor edit = this.f3528a.r().edit();
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                edit.putInt(j(i2) + "_manual", -1);
                edit.putBoolean(j(i2) + "_manual_state", false);
                edit.putString(j(i2), a(i2));
            }
            edit.apply();
        }
    }

    public int a(String str) {
        SharedPreferences r = this.f3528a.r();
        return r.getInt(str + "_manual", -1);
    }

    public String a(int i2, String str) {
        int a2 = a(str);
        if (a2 < 0) {
            return null;
        }
        ArrayList<String> parameterNamesList = this.c.get(i2).getParameterNamesList();
        if (a2 > parameterNamesList.size() - 1) {
            return null;
        }
        return parameterNamesList.get(a2);
    }

    private void a(n nVar, int i2, int i3, float f2) {
        e.a("PanelContainer", "generateExposureCompensationValues, minIndex: " + i2 + ", maxValue: " + i3 + ", step: " + f2);
        if ((i2 == -1 && i3 == -1) || i2 > i3 || Float.compare(f2, 0.0f) == 0) {
            e.e("PanelContainer", "generateExposureCompensationValues, return, minIndex: " + i2 + ", maxIndex: " + i3);
            return;
        }
        ArrayList<String> b2 = nVar.b();
        ArrayList<String> c2 = nVar.c();
        b2.clear();
        c2.clear();
        while (i2 <= i3) {
            b2.add(String.valueOf(i2));
            c2.add(a(i2, f2));
            i2++;
        }
    }

    public String a(int i2, float f2) {
        float f3 = ((float) i2) * f2;
        if (f3 > 0.0f) {
            return "+" + String.format(Locale.US, "%.2f", new Object[]{Float.valueOf(f3)});
        }
        return String.format(Locale.US, "%.2f", new Object[]{Float.valueOf(f3)});
    }

    private void a(n nVar, int[] iArr) {
        ArrayList<String> b2 = nVar.b();
        ArrayList<String> c2 = nVar.c();
        if (iArr == null || iArr.length < 2) {
            e.e("PanelContainer", "generateWhiteBalanceValues, return, range: " + iArr);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("generateWhiteBalanceValues, min: ");
        sb.append(iArr[0]);
        sb.append(", max: ");
        sb.append(iArr[1]);
        e.b("PanelContainer", sb.toString());
        int i2 = iArr[0];
        int i3 = (iArr[1] - i2) / 100;
        if (i3 <= 0) {
            e.e("PanelContainer", "generateWhiteBalanceValues, return, valueNum: " + i3);
            return;
        }
        b2.clear();
        c2.clear();
        for (int i4 = 0; i4 <= i3; i4++) {
            int i5 = (100 * i4) + i2;
            b2.add(Integer.toString(i5));
            c2.add(i5 + OppoExifInterface.GpsSpeedRef.KILOMETERS);
        }
    }

    public boolean c() {
        for (LevelPanel visibility : this.c) {
            if (visibility.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public long a(List<Size> list) {
        long j2 = 0;
        for (Size next : list) {
            if (((long) next.getWidth()) * ((long) next.getHeight()) > j2) {
                j2 = ((long) next.getWidth()) * ((long) next.getHeight());
            }
        }
        e.a("PanelContainer", "getMaxPictureSize, max: " + j2);
        return j2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.oppo.camera.professional.n r19, long r20, long r22, java.util.List<android.util.Size> r24) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            r3 = r22
            java.util.ArrayList r5 = r19.b()
            java.util.ArrayList r6 = r19.c()
            r7 = 1
            if (r6 == 0) goto L_0x0050
            int r8 = r6.size()
            if (r8 <= 0) goto L_0x0050
            if (r5 == 0) goto L_0x0050
            int r8 = r5.size()
            if (r8 <= 0) goto L_0x0050
            r8 = 1065353216(0x3f800000, float:1.0)
            r9 = r24
            long r9 = r0.a((java.util.List<android.util.Size>) r9)
            float r9 = (float) r9
            java.lang.String r10 = "8000000"
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            long r10 = r10.longValue()
            float r10 = (float) r10
            float r9 = r9 / r10
            float r8 = r8 - r9
            float r8 = java.lang.Math.abs(r8)
            r9 = 1036831949(0x3dcccccd, float:0.1)
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 > 0) goto L_0x0050
            int r8 = r6.size()
            int r8 = r8 - r7
            r6.remove(r8)
            int r8 = r5.size()
            int r8 = r8 - r7
            r5.remove(r8)
        L_0x0050:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "generateShutterValues, max: "
            r8.append(r9)
            r8.append(r1)
            java.lang.String r9 = ", min: "
            r8.append(r9)
            r8.append(r3)
            java.lang.String r9 = ", before filtering, parameterNamesList: "
            r8.append(r9)
            r8.append(r6)
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "PanelContainer"
            com.oppo.camera.e.b(r9, r8)
            if (r6 == 0) goto L_0x0146
            if (r5 == 0) goto L_0x0146
            java.util.Iterator r8 = r6.iterator()
            r10 = -1
        L_0x0080:
            boolean r12 = r8.hasNext()
            java.lang.String r13 = "s"
            if (r12 == 0) goto L_0x00d9
            java.lang.Object r12 = r8.next()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.String r14 = "/"
            java.lang.String[] r12 = r12.split(r14)
            int r14 = r12.length
            r15 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            r17 = 0
            if (r14 <= r7) goto L_0x00b4
            r10 = r12[r17]
            double r10 = java.lang.Double.parseDouble(r10)
            r12 = r12[r7]
            java.lang.String[] r12 = r12.split(r13)
            r12 = r12[r17]
            double r12 = java.lang.Double.parseDouble(r12)
            double r10 = r10 / r12
        L_0x00b1:
            double r10 = r10 * r15
            long r10 = (long) r10
            goto L_0x00c4
        L_0x00b4:
            int r14 = r12.length
            if (r14 != r7) goto L_0x00c4
            r10 = r12[r17]
            java.lang.String[] r10 = r10.split(r13)
            r10 = r10[r17]
            double r10 = java.lang.Double.parseDouble(r10)
            goto L_0x00b1
        L_0x00c4:
            int r12 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r12 < 0) goto L_0x00d5
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 <= 0) goto L_0x00cd
            goto L_0x00d5
        L_0x00cd:
            java.lang.String r12 = java.lang.String.valueOf(r10)
            r5.add(r12)
            goto L_0x0080
        L_0x00d5:
            r8.remove()
            goto L_0x0080
        L_0x00d9:
            int r3 = r5.size()
            int r3 = r3 - r7
            java.lang.Object r3 = r5.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            long r3 = java.lang.Long.parseLong(r3)
            r7 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            long r3 = r3 / r7
            long r7 = r1 / r7
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 >= 0) goto L_0x010b
            java.lang.String r1 = java.lang.String.valueOf(r20)
            r5.add(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r7)
            r1.append(r13)
            java.lang.String r1 = r1.toString()
            r6.add(r1)
        L_0x010b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "generateShutterValues, after filtering, parameterValuesList: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = ", parameterNamesList: "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            com.oppo.camera.e.b(r9, r1)
            java.lang.String r1 = "pref_professional_exposure_time_key"
            int r1 = r0.a((java.lang.String) r1)
            int r2 = r5.size()
            if (r1 < r2) goto L_0x0146
            com.oppo.camera.e.b r1 = r0.f3528a
            android.content.SharedPreferences r1 = r1.r()
            android.content.SharedPreferences$Editor r1 = r1.edit()
            java.lang.String r2 = "pref_professional_exposure_time_key_manual"
            android.content.SharedPreferences$Editor r1 = r1.remove(r2)
            r1.apply()
        L_0x0146:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.professional.g.a(com.oppo.camera.professional.n, long, long, java.util.List):void");
    }

    private void a(n nVar, float f2, float f3) {
        if (f2 < f3) {
            float f4 = f3;
            f3 = f2;
            f2 = f4;
        }
        if (((float) Float.compare(f2, 0.0f)) <= 0.0f || Float.compare(f2, f3) == 0) {
            e.e("PanelContainer", "generateFocusValues, return, minFocusDistance: " + f2);
            return;
        }
        float f5 = (f2 - f3) / 50.0f;
        e.a("PanelContainer", "generateFocusValues, farFocusDistance: " + f3 + ", minFocusDistance: " + f2);
        ArrayList<String> b2 = nVar.b();
        ArrayList<String> c2 = nVar.c();
        b2.clear();
        c2.clear();
        for (int i2 = 0; i2 <= 50; i2++) {
            float f6 = (float) i2;
            b2.add(Float.toString(f2 - (f5 * f6)));
            c2.add(String.format(Locale.US, "%.2f", new Object[]{Float.valueOf(f6 * 0.02f)}));
        }
    }

    private void a(n nVar, int i2, int i3, int i4) {
        if (i3 > i2) {
            i2 = i3;
        }
        ArrayList<String> b2 = nVar.b();
        ArrayList<String> c2 = nVar.c();
        if (i2 <= 0 || i4 <= 0 || i2 == i4) {
            e.e("PanelContainer", "generateIsoValues, return null, maxISOValue: " + i2 + ", minISOValue: " + i4 + ", maxISOValue: " + i2);
            return;
        }
        b2.clear();
        c2.clear();
        while (i4 <= i2) {
            b2.add(Integer.toString(i4));
            c2.add(Integer.toString(i4));
            i4 += 100;
        }
    }

    private n a(int[] iArr) {
        n d2 = new n(this.f).a((int) R.string.camera_whitebalance_professional_title).b((int) R.drawable.profession_wb_selector).c(R.id.awb_controller).a("awb_mode_key").b("pref_professional_whitebalance_key").d(R.string.camera_whitebalance_default_value);
        a(d2, iArr);
        return d2;
    }

    private n a(int i2, int i3, float f2) {
        n d2 = new n(this.f).a((int) R.string.camera_exposure_compensation_professional_title).b((int) R.drawable.profession_ev_selector).c(R.id.exposure_controller).a("iso_mode_key").b("pref_professional_exposure_compensation_key").d(R.string.camera_exposure_compensation_default_value);
        a(d2, i2, i3, f2);
        return d2;
    }

    private n a(int i2, int i3, int i4) {
        n d2 = new n(this.f).a((int) R.string.camera_iso_professional_title).b((int) R.drawable.profession_iso_selector).c(R.id.iso_controller).a("exposure_mode_key").b("pref_professional_iso_key").d(R.string.camera_iso_default_value);
        a(d2, i2, i3, i4);
        return d2;
    }

    private n a(long j2, long j3, List<Size> list) {
        n f2 = new n(this.f).a((int) R.string.camera_exposure_time_title).b((int) R.drawable.profession_shutter_selector).c(R.id.shutter_controller).a("shutter_mode_key").b("pref_professional_exposure_time_key").d(R.string.camera_exposure_time_default_value).e(R.array.professional_exposure_time_values).f(R.array.professional_exposure_time_names);
        a(f2, j2, j3, list);
        return f2;
    }

    private n a(float f2, float f3) {
        n d2 = new n(this.f).a((int) R.string.camera_focus_mode_title).b((int) R.drawable.profession_af_selector).c(R.id.manual_focus_controller).a("manual_focus_mode_key").b("pref_professional_focus_mode_key").d(R.string.camera_focus_mode_default_value);
        a(d2, f2, f3);
        return d2;
    }

    public void e(int i2) {
        if (!g(i2)) {
            setAuto(i2);
        }
        if (3 == i2) {
            this.g.c(i2);
        }
    }

    public void a(boolean z, int i2) {
        if (z) {
            setAuto(i2);
            if (3 == i2) {
                this.g.c(i2);
                return;
            }
            return;
        }
        setManual(i2);
    }

    public void d() {
        for (LevelPanel removeView : this.c) {
            removeView(removeView);
        }
        this.c.clear();
    }

    public void a(RelativeLayout.LayoutParams layoutParams, final int i2, boolean z, n nVar, int i3, Handler handler) {
        if (this.c.size() > i2) {
            e.e("PanelContainer", "addControllerPanel, return, size: " + this.c.size());
            return;
        }
        final LevelPanel levelPanel = new LevelPanel(this.f, true, handler, z, nVar, this.f3528a.r());
        levelPanel.setLayoutParams(layoutParams);
        levelPanel.setAlign(i3);
        addView(levelPanel);
        levelPanel.setValueChangeListener(new LevelPanel.ValueChangeListener() {
            public void onManualValueChange(int i) {
                g.this.k(i);
                g gVar = g.this;
                int i2 = i2;
                gVar.a(i2, gVar.j(i2), i);
                g.this.g.a(i2, levelPanel.a(g.this.f3528a.r()), false);
                if (4 == i2) {
                    g.this.e(0);
                    g.this.e(1);
                }
                if (3 == i2) {
                    g.this.g.c(i2);
                }
            }

            public void onAutoValueChange(int i) {
                g.this.g.a(i2, levelPanel.a(g.this.f3528a.r()), true);
            }

            public void onBarScrolling(boolean z) {
                if (g.this.j && !z) {
                    g.this.h.a(i2, levelPanel.a(g.this.f3528a.r()), false);
                }
                boolean unused = g.this.j = z;
            }

            public void onActionUp() {
                if (!g.this.j) {
                    g.this.h.a(i2, levelPanel.a(g.this.f3528a.r()), false);
                }
            }
        });
        this.c.add(levelPanel);
    }

    /* access modifiers changed from: private */
    public void k(int i2) {
        aa W;
        if (!this.e || (W = this.f3528a.W()) == null) {
            return;
        }
        if (i2 % 10 == 0) {
            W.f();
        } else {
            W.d();
        }
    }

    public void b(boolean z) {
        this.e = z;
    }

    public void f(int i2) {
        a(i2, (Animation) null);
    }

    public void a(int i2, Animation animation) {
        e();
        this.c.get(i2).setVisibility(0);
        if (animation != null) {
            this.c.get(i2).startAnimation(animation);
        }
    }

    public boolean g(int i2) {
        if (i2 < 0 || i2 > this.c.size() - 1) {
            return false;
        }
        SharedPreferences r = this.f3528a.r();
        boolean z = r.getBoolean(j(i2) + "_manual_state", false);
        if (!d(i2).equals(a(i2)) || z) {
            return false;
        }
        return true;
    }

    public void setPreference(int i2) {
        SharedPreferences.Editor edit = this.f3528a.r().edit();
        edit.putString(j(i2), a(i2));
        edit.putBoolean(j(i2) + "_manual_state", false);
        edit.apply();
    }

    public void setPanelsBarAuto(int i2) {
        this.c.get(i2).setBarAuto(true);
    }

    public void setAuto(int i2) {
        setPreference(i2);
        setPanelsBarAuto(i2);
    }

    public void setManual(int i2) {
        SharedPreferences.Editor edit = this.f3528a.r().edit();
        edit.putBoolean(j(i2) + "_manual_state", true);
        edit.apply();
        int a2 = a(j(i2));
        if (a2 >= 0) {
            a(i2, a2, a(i2, j(i2)));
        } else {
            int currentIndex = this.c.get(i2).getCurrentIndex();
            a(i2, currentIndex, this.c.get(i2).getParameterNamesList().get(currentIndex));
        }
        this.c.get(i2).setBarAuto(false);
    }

    public boolean h(int i2) {
        if (g(i2)) {
            this.c.get(i2).setBarAuto(true);
            return true;
        }
        this.c.get(i2).setBarAuto(false);
        return false;
    }

    public void e() {
        setAllPopupInvisibility((Animation) null);
    }

    public void setAllPopupInvisibility(Animation animation) {
        for (LevelPanel next : this.c) {
            if (next.getVisibility() != 0 || animation == null) {
                next.setVisibility(4);
                next.clearAnimation();
            } else {
                next.setVisibility(4);
                next.startAnimation(animation);
            }
        }
    }

    public void f() {
        for (LevelPanel valueChangeListener : this.c) {
            valueChangeListener.setValueChangeListener((LevelPanel.ValueChangeListener) null);
        }
        this.f = null;
    }

    public boolean i(int i2) {
        return g(i2);
    }

    public boolean g() {
        return this.j;
    }

    public void h() {
        this.j = false;
    }

    public a getConfigData() {
        return this.i;
    }

    /* compiled from: PanelContainer */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f3532a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f3533b = 0;

        public a() {
        }
    }
}
