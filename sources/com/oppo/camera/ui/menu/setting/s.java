package com.oppo.camera.ui.menu.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e;
import com.oppo.camera.k;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.MenuClickMsgData;
import com.oppo.camera.ui.FixedListView;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CameraVideoRatioSettingFragment */
public class s extends Fragment {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f4254a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f4255b = 0;
    /* access modifiers changed from: private */
    public int c = 0;
    private int d = 2;
    /* access modifiers changed from: private */
    public int e = 0;
    private int f = 0;
    private String g = null;
    /* access modifiers changed from: private */
    public k h = null;
    private LinearLayout i = null;
    private FixedListView j = null;
    private View k = null;
    /* access modifiers changed from: private */
    public List<String> l = null;
    /* access modifiers changed from: private */
    public a m = null;
    /* access modifiers changed from: private */
    public boolean n = false;
    /* access modifiers changed from: private */
    public boolean o = false;
    /* access modifiers changed from: private */
    public boolean p = false;
    /* access modifiers changed from: private */
    public boolean q = false;

    public void onCreate(Bundle bundle) {
        Bundle arguments;
        super.onCreate(bundle);
        this.h = new k(getActivity().getApplicationContext());
        if ("oppo.intent.action.APP_VIDEO_RATIO_SETTING".equals(getActivity().getIntent().getAction()) && (arguments = getArguments()) != null) {
            this.c = arguments.getInt("pref_camera_id_key");
            this.g = arguments.getString("pref_camera_mode_key", (String) null);
            this.d = arguments.getInt("camera_enter_type");
            this.e = arguments.getInt("camera_property_camera_id");
        }
        CameraConfig.initialize();
        this.n = !com.oppo.camera.f.a.c(this.c) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_720_60_FPS);
        this.o = !com.oppo.camera.f.a.c(this.c) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_1080_60_FPS);
        this.p = !com.oppo.camera.f.a.c(this.c) && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_4K_60_FPS);
        this.f = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_VIDEO_SAT_MASK);
        List<String> supportedList = CameraConfig.getSupportedList("pref_video_size_key", this.c);
        if (supportedList != null) {
            for (String equals : supportedList) {
                if ("video_size_4kuhd".equals(equals)) {
                    this.q = true;
                }
            }
        } else {
            this.q = false;
        }
        e.b("VideoRatioSettingAct", "onCreate, mCameraId: " + this.c + ", mbSupport720pFps60: " + this.n + ", mbSupport1080pFps60: " + this.o + ", mbSupport4kFps60: " + this.p + ", mbSupportVideoRatio4K: " + this.q + ", mVidSatMask: " + this.f);
        this.h.a((Context) getActivity(), this.c);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.video_resolution_main, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.i = (LinearLayout) getView().findViewById(R.id.text_video_frame);
        this.j = (FixedListView) getView().findViewById(R.id.list_video_frame);
        this.k = getView().findViewById(R.id.view_line_second);
        String string = this.h.getString("pref_video_size_key", CameraConfig.getOptionKeyDefaultValue("pref_video_size_key", this.c));
        d(string);
        a(view);
        b(string);
        b(view);
    }

    public void onDestroy() {
        super.onDestroy();
        this.i = null;
        this.k = null;
        this.j = null;
        k kVar = this.h;
        if (kVar != null) {
            kVar.a(getActivity().getApplicationContext());
            this.h = null;
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        b(str);
        a aVar = this.m;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    private void b(String str) {
        boolean c2 = c(str);
        a(this.h.getString("pref_video_fps_key", getString(R.string.camera_video_default_fps)), c2);
        a(c2);
    }

    private boolean c(String str) {
        if ("video_size_720p".equals(str)) {
            return this.n;
        }
        if ("video_size_1080p".equals(str)) {
            return this.o;
        }
        if ("video_size_4kuhd".equals(str)) {
            return this.p;
        }
        return false;
    }

    private void a(boolean z) {
        List<String> list = this.l;
        if (list == null) {
            this.l = new ArrayList();
        } else {
            list.clear();
        }
        if (z) {
            this.l.add(getString(R.string.camera_video_fps_60));
            this.l.add(getString(R.string.camera_video_fps_30));
        } else {
            this.l.add(getString(R.string.camera_video_fps_30));
        }
        if (2 > this.l.size()) {
            this.k.setVisibility(8);
            this.j.setVisibility(8);
            this.i.setVisibility(8);
            return;
        }
        this.i.setVisibility(0);
        this.j.setVisibility(0);
        this.k.setVisibility(0);
    }

    private void a(View view) {
        final FixedListView fixedListView = (FixedListView) view.findViewById(R.id.list_video_resolution);
        fixedListView.setNestedScrollingEnabled(true);
        ArrayList arrayList = new ArrayList();
        if (this.q) {
            arrayList.add(getString(R.string.camera_video_size_4kuhd));
            arrayList.add(getString(R.string.camera_video_size_1080p));
            arrayList.add(getString(R.string.camera_video_size_720p));
        } else {
            arrayList.add(getString(R.string.camera_video_size_1080p));
            arrayList.add(getString(R.string.camera_video_size_720p));
        }
        final FixedListView fixedListView2 = fixedListView;
        final AnonymousClass1 r0 = new a(getActivity(), R.layout.oppo_preference_select_layout, R.id.pref_title, arrayList) {
            public View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                CheckBox checkBox = (CheckBox) view2.findViewById(R.id.pref_checkbox);
                TextView textView = (TextView) view2.findViewById(R.id.pref_summary);
                if (!Util.R()) {
                    textView.setVisibility(8);
                } else if (!s.this.q || i != 0 || s.this.a(2)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(s.this.getResources().getString(R.string.camera_video_size_4kuhd_summary_realme));
                    textView.setVisibility(0);
                }
                if (i == s.this.f4254a) {
                    FixedListView fixedListView = fixedListView2;
                    fixedListView.setItemChecked(fixedListView.getHeaderViewsCount() + i, true);
                    checkBox.setChecked(true);
                } else {
                    checkBox.setChecked(false);
                }
                if (!isEnabled(i)) {
                    ((TextView) view2.findViewById(R.id.pref_title)).setTextColor(s.this.getResources().getColor(R.color.setting_pref_text_disable_color));
                }
                return view2;
            }
        };
        fixedListView.setAdapter(r0);
        fixedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int unused = s.this.f4254a = i - fixedListView.getHeaderViewsCount();
                String c2 = s.this.b(i);
                String string = s.this.h.getString("pref_video_fps_key", s.this.getString(R.string.camera_video_default_fps));
                boolean c3 = com.oppo.camera.f.a.c(s.this.c);
                SharedPreferences.Editor edit = s.this.h.edit();
                edit.putString("pref_video_size_key", c2);
                edit.putString("pref_lasted_video_size", "");
                edit.putBoolean("pref_lasted_video_save_status", false);
                String[] configStringArrayValue = CameraConfig.getConfigStringArrayValue(ConfigDataBase.KEY_AI_VIDEO_ENHANCE_FRONT_RESOLUTION);
                String[] configStringArrayValue2 = CameraConfig.getConfigStringArrayValue(ConfigDataBase.KEY_AI_VIDEO_ENHANCE_REAR_RESOLUTION);
                if (c3) {
                    if (configStringArrayValue == null) {
                        if ("video_size_4kuhd".equals(c2)) {
                            edit.putString("key_ai_enhancement_video", "off");
                        }
                    } else if (configStringArrayValue.length > 0 && !Util.b(configStringArrayValue, c2)) {
                        edit.putString("key_ai_enhancement_video", "off");
                    }
                } else if (configStringArrayValue2 == null) {
                    if ("video_size_4kuhd".equals(c2)) {
                        edit.putString("key_ai_enhancement_video", "off");
                    }
                } else if (configStringArrayValue2.length > 0 && !Util.b(configStringArrayValue2, c2)) {
                    edit.putString("key_ai_enhancement_video", "off");
                }
                if ("video_size_4kuhd".equals(c2)) {
                    edit.putString("pref_none_sat_ultra_wide_angle_key", "off");
                    edit.remove("pref_video_blur_menu_state");
                    edit.remove("pref_video_blur_menu_index");
                    edit.remove("pref_video_blur_menu");
                }
                if (!"video_size_1080p".equals(c2) && !c3) {
                    edit.putString("pref_video_super_eis_key", "off");
                    edit.putBoolean("pref_super_eis_wide_key", false).apply();
                }
                if ((!s.this.p && "video_size_4kuhd".equals(c2)) || ((!s.this.o && "video_size_1080p".equals(c2)) || (!s.this.n && "video_size_720p".equals(c2)))) {
                    edit.putString("pref_lasted_video_fps", "");
                    edit.putBoolean("pref_lasted_video_save_status", false);
                    if (!String.valueOf(30).equals(string)) {
                        edit.putString("pref_video_fps_key", String.valueOf(30));
                        String.valueOf(30);
                    }
                }
                edit.apply();
                r0.notifyDataSetChanged();
                s.this.a(c2);
                s.this.a(c2, (String) null);
            }
        });
        fixedListView.setChoiceMode(1);
    }

    /* access modifiers changed from: private */
    public boolean a(int i2) {
        return (i2 & CameraConfig.getConfigIntValue(ConfigDataBase.KEY_VIDEO_SAT_MASK)) != 0;
    }

    private void b(View view) {
        final FixedListView fixedListView = (FixedListView) view.findViewById(R.id.list_video_frame);
        fixedListView.setNestedScrollingEnabled(true);
        final FixedListView fixedListView2 = fixedListView;
        this.m = new a(getActivity(), R.layout.oppo_preference_select_layout, R.id.pref_title, this.l) {
            public View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                CheckBox checkBox = (CheckBox) view2.findViewById(R.id.pref_checkbox);
                TextView textView = (TextView) view2.findViewById(R.id.pref_summary);
                if (!Util.R()) {
                    textView.setVisibility(8);
                } else if ((s.this.n || s.this.o || s.this.p) && i == 0 && !s.this.a(1)) {
                    textView.setText(s.this.getResources().getString(R.string.camera_video_fps_60_summary_realme));
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                if (i == s.this.f4255b) {
                    FixedListView fixedListView = fixedListView2;
                    fixedListView.setItemChecked(fixedListView.getHeaderViewsCount() + i, true);
                    checkBox.setChecked(true);
                } else {
                    checkBox.setChecked(false);
                }
                if (!isEnabled(i)) {
                    ((TextView) view2.findViewById(R.id.pref_title)).setTextColor(s.this.getResources().getColor(R.color.setting_pref_text_disable_color));
                }
                return view2;
            }
        };
        fixedListView.setAdapter(this.m);
        fixedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int unused = s.this.f4255b = i - fixedListView.getHeaderViewsCount();
                s sVar = s.this;
                boolean z = true;
                String a2 = sVar.a(i, sVar.l.size() > 1);
                SharedPreferences.Editor edit = s.this.h.edit();
                e.a("VideoRatioSettingAct", "onItemClick, fpsType: " + a2);
                edit.putString("pref_video_fps_key", a2);
                edit.putString("pref_lasted_video_fps", "");
                boolean equals = String.valueOf(60).equals(a2);
                if (!"on".equals(s.this.h.getString("key_ai_enhancement_video", "off")) || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ALLMIGHTY_VIDEO) || com.oppo.camera.f.a.c(s.this.e)) {
                    z = false;
                }
                if (equals) {
                    if (!z) {
                        edit.putString("pref_none_sat_ultra_wide_angle_key", "off");
                    }
                    edit.putString("key_ai_enhancement_video", "off");
                    edit.remove("pref_video_blur_menu_state");
                    edit.remove("pref_video_blur_menu_index");
                    edit.remove("pref_video_blur_menu");
                }
                if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_SUPER_EIS_WIDE_60_FPS)) {
                    boolean z2 = s.this.h.getBoolean("pref_super_eis_wide_key", false);
                    if ((z2 && equals) || (!z2 && !equals)) {
                        edit.putString("pref_video_super_eis_key", "off");
                        edit.putBoolean("pref_super_eis_wide_key", false).apply();
                    }
                } else if (!equals) {
                    edit.putString("pref_video_super_eis_key", "off");
                    edit.putBoolean("pref_super_eis_wide_key", false).apply();
                }
                edit.apply();
                s.this.m.notifyDataSetChanged();
                s.this.a((String) null, a2);
            }
        });
        fixedListView.setChoiceMode(1);
    }

    /* compiled from: CameraVideoRatioSettingFragment */
    private class a extends ArrayAdapter {
        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }

        a(Context context, int i, int i2, List list) {
            super(context, i, i2, list);
        }

        public boolean isEnabled(int i) {
            return super.isEnabled(i);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        a("pref_video_ratio_key", (Object) sb.toString());
    }

    private void d(String str) {
        if (str == null) {
            str = "video_size_1080p";
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        int i2 = 2;
        if (hashCode != -1756797675) {
            if (hashCode != 1368252031) {
                if (hashCode == 1372840608 && str.equals("video_size_4kuhd")) {
                    c2 = 0;
                }
            } else if (str.equals("video_size_1080p")) {
                c2 = 1;
            }
        } else if (str.equals("video_size_720p")) {
            c2 = 2;
        }
        if (c2 == 0) {
            this.f4254a = 0;
        } else if (c2 == 1) {
            this.f4254a = this.q ? 1 : 0;
        } else if (c2 != 2) {
            this.f4254a = this.q ? 1 : 0;
        } else {
            if (!this.q) {
                i2 = 1;
            }
            this.f4254a = i2;
        }
    }

    private void a(String str, boolean z) {
        int intValue = Integer.valueOf(str).intValue();
        if (intValue == 30) {
            this.f4255b = z ? 1 : 0;
        } else if (intValue != 60) {
            this.f4255b = z;
        } else {
            this.f4255b = 0;
        }
    }

    /* access modifiers changed from: private */
    public String b(int i2) {
        if (i2 != 0) {
            if (i2 == 1) {
                return this.q ? "video_size_1080p" : "video_size_720p";
            }
            if (i2 != 2) {
                return CameraConfig.getOptionKeyDefaultValue("pref_video_size_key", this.c);
            }
            return "video_size_720p";
        } else if (this.q) {
            return "video_size_4kuhd";
        } else {
            return "video_size_1080p";
        }
    }

    /* access modifiers changed from: private */
    public String a(int i2, boolean z) {
        if (i2 == 0) {
            return z ? String.valueOf(60) : String.valueOf(30);
        }
        if (i2 != 1) {
            return getString(R.string.camera_video_default_fps);
        }
        return String.valueOf(30);
    }

    private void a(String str, Object obj) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(getActivity());
        menuClickMsgData.mCaptureMode = this.g;
        menuClickMsgData.mCameraEnterType = String.valueOf(this.d);
        int i2 = this.e;
        menuClickMsgData.mCameraId = i2;
        menuClickMsgData.mRearOrFront = com.oppo.camera.f.a.c(i2) ? DcsMsgData.FRONT : DcsMsgData.REAR;
        menuClickMsgData.buildSettingMenuItem(str, obj);
        menuClickMsgData.report();
    }
}
