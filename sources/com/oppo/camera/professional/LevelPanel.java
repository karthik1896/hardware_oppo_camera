package com.oppo.camera.professional;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.anc.humanvideo.BuildConfig;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.ui.CommonComponent.ScaleBar;
import com.oppo.camera.ui.menu.OppoTextView;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class LevelPanel extends RelativeLayout implements ScaleBar.ScaleBarValueChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private static String f3504a = "LevelPanel";

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<String, String> f3505b = new HashMap<>();
    private String c = "[一-龥]";
    private int d = 0;
    private Context e;
    /* access modifiers changed from: private */
    public ValueChangeListener f = null;
    private ArrayList<OppoTextView> g = new ArrayList<>();
    private boolean h = false;
    /* access modifiers changed from: private */
    public n i = null;
    private SharedPreferences j = null;
    private Pattern k = Pattern.compile(this.c);
    /* access modifiers changed from: private */
    public l l = null;
    private boolean m = true;
    /* access modifiers changed from: private */
    public ScaleBar n = null;
    private boolean o = true;

    public interface ValueChangeListener {
        void onActionUp();

        void onAutoValueChange(int i);

        void onBarScrolling(boolean z);

        void onManualValueChange(int i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public LevelPanel(Context context, boolean z, Handler handler, boolean z2, n nVar, SharedPreferences sharedPreferences) {
        super(context);
        this.e = context;
        this.j = sharedPreferences;
        this.i = nVar;
        this.o = z;
        this.h = z2;
        a(handler);
    }

    public n getSubModeBarData() {
        return this.i;
    }

    public String getDefaultValue() {
        return this.i.d();
    }

    public ArrayList<String> getParameterValueList() {
        return this.i.b();
    }

    public ArrayList<String> getParameterNamesList() {
        return this.i.c();
    }

    public static void a(String str, String str2) {
        f3505b.put(str, str2);
    }

    public static void a() {
        f3505b.put("pref_professional_whitebalance_key", "2000");
        f3505b.put("pref_professional_iso_key", BuildConfig.BUILD_NUMBER);
        f3505b.put("pref_professional_exposure_compensation_key", "0.00");
        f3505b.put("pref_professional_exposure_time_key", "1/50s");
        f3505b.put("pref_professional_focus_mode_key", "0.00");
    }

    public static void setAutoValueMap(HashMap<String, String> hashMap) {
        f3505b.clear();
        f3505b = hashMap;
    }

    /* access modifiers changed from: private */
    public String a(String str) {
        return f3505b.get(str);
    }

    private String a(n nVar, String str) {
        if (nVar == null) {
            return null;
        }
        if (nVar.b().indexOf(str) < 0) {
            return "";
        }
        return nVar.c().get(nVar.b().indexOf(str));
    }

    public String a(SharedPreferences sharedPreferences) {
        String str;
        String str2;
        String a2 = this.i.a();
        String string = sharedPreferences.getString(a2, this.i.d());
        if (string.equals(this.i.d()) && !"pref_professional_exposure_compensation_key".equals(a2)) {
            return a(a2);
        }
        String a3 = a(this.i, string);
        if (!"".equals(a3)) {
            return a3;
        }
        if ("pref_professional_exposure_compensation_key".equals(a2)) {
            str2 = getDefaultValue();
            str = a(this.i, str2);
        } else {
            str2 = this.i.d();
            str = a(a2);
        }
        if (!(this.i.b() == null || this.i.b().size() == 0 || !b(a2, str2))) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(a2, str2);
            edit.apply();
        }
        return str;
    }

    private boolean b(String str, String str2) {
        if (!"pref_professional_exposure_time_key".equals(str)) {
            return true;
        }
        if (TextUtils.isEmpty(str2) || this.e.getString(R.string.camera_exposure_time_default_value).equals(str2)) {
            return false;
        }
        return true;
    }

    public int getCurrentIndex() {
        return this.n.getCurrentIndex();
    }

    public boolean a(int i2) {
        return this.n.getCurrentIndex() == i2;
    }

    public void setValueChangeListener(ValueChangeListener valueChangeListener) {
        this.f = valueChangeListener;
    }

    public void a(final int i2, Activity activity) {
        if (this.n.getCurrentIndex() != i2 || i2 == 0) {
            this.n.setCurrentIndex(i2);
            if (activity != null) {
                activity.runOnUiThread(new Runnable() {
                    public void run() {
                        LevelPanel.this.n.scrollTo(i2);
                        l c = LevelPanel.this.l;
                        LevelPanel levelPanel = LevelPanel.this;
                        c.setText(levelPanel.a(levelPanel.i.a()));
                        if (LevelPanel.this.f != null) {
                            LevelPanel.this.f.onAutoValueChange(i2);
                        }
                    }
                });
            }
        }
    }

    public void b(final int i2, Activity activity) {
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    LevelPanel.this.l.setText(LevelPanel.this.i.c().get(i2));
                }
            });
        }
    }

    public void a(final int i2, Activity activity, final String str) {
        this.n.setCurrentIndex(i2);
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    LevelPanel.this.n.scrollTo(i2);
                    if (str != null) {
                        LevelPanel.this.l.setText(str);
                    } else {
                        LevelPanel.this.l.setText(LevelPanel.this.i.c().get(i2));
                    }
                    if (LevelPanel.this.f != null) {
                        LevelPanel.this.f.onManualValueChange(i2);
                    }
                }
            });
        }
    }

    public void setBarAuto(boolean z) {
        this.o = z;
        ScaleBar scaleBar = this.n;
        if (scaleBar != null) {
            scaleBar.setAuto(this.o);
        }
    }

    public void setAlign(int i2) {
        ScaleBar scaleBar = this.n;
        if (scaleBar != null) {
            scaleBar.setAlign(i2);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.m) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void invalidate() {
        super.invalidate();
        ScaleBar scaleBar = this.n;
        if (scaleBar != null) {
            scaleBar.invalidate();
        }
    }

    public void b() {
        n nVar;
        l lVar = this.l;
        if (lVar != null) {
            lVar.setText(a(this.j));
        }
        ScaleBar scaleBar = this.n;
        if (scaleBar != null && (nVar = this.i) != null) {
            scaleBar.setLevelNum(nVar.c().size());
        }
    }

    private void a(Handler handler) {
        Resources resources = this.e.getApplicationContext().getResources();
        this.l = new l(this.e);
        this.l.setHeight(resources.getDimensionPixelSize(R.dimen.main_mode_bar_item_text_height));
        int i2 = 1;
        this.l.setVerticalDraw(true);
        this.l.setIncludeFontPadding(false);
        this.l.setTextSize(0, (float) resources.getDimensionPixelSize(R.dimen.main_mode_bar_item_text_size));
        this.l.setTypeface(Util.j(this.e));
        this.l.setGravity(17);
        this.l.setTextColor(resources.getColor(R.color.main_item_title_text_color));
        this.l.setText(a(this.j));
        this.l.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        layoutParams.topMargin = resources.getDimensionPixelSize(R.dimen.professional_mode_text_top_margin);
        layoutParams.bottomMargin = resources.getDimensionPixelSize(R.dimen.professional_mode_text_bottom_margin);
        this.l.setLayoutParams(layoutParams);
        addView(this.l);
        this.n = new ScaleBar(this.e, this.i.c().size(), handler);
        int E = Util.E();
        if (this.h) {
            i2 = 2;
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(E / i2, -2);
        layoutParams2.addRule(3, this.l.getId());
        this.n.setScaleBarValueChangeListener(this);
        this.n.setAuto(this.o);
        addView(this.n, layoutParams2);
    }

    public int b(SharedPreferences sharedPreferences) {
        String a2 = this.i.a();
        ArrayList<String> b2 = this.i.b();
        String d2 = this.i.d();
        if (sharedPreferences != null) {
            d2 = sharedPreferences.getString(a2, this.i.d());
        }
        return b2.indexOf(d2);
    }

    public void b(int i2) {
        ScaleBar scaleBar = this.n;
        if (scaleBar != null) {
            scaleBar.initDataIndex(i2);
        }
    }

    public void onValueChange(int i2) {
        String str = f3504a;
        e.a(str, "onValueChange, value: " + i2);
        ValueChangeListener valueChangeListener = this.f;
        if (valueChangeListener != null) {
            valueChangeListener.onManualValueChange(i2);
            this.l.setText(a(this.j));
        }
    }

    public void onBarMoving() {
        if (this.o) {
            setBarAuto(false);
        }
    }

    public void onBarScrolling(boolean z) {
        ValueChangeListener valueChangeListener = this.f;
        if (valueChangeListener != null) {
            valueChangeListener.onBarScrolling(z);
        }
    }

    public void onActionUp() {
        ValueChangeListener valueChangeListener = this.f;
        if (valueChangeListener != null) {
            valueChangeListener.onActionUp();
        }
    }
}
