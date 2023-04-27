package com.oppo.camera.ui.menu.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.k;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.MenuClickMsgData;
import com.oppo.camera.ui.FixedListView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CameraCodeSettingFragment */
public class d extends Fragment {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f4188a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f4189b = 0;
    private int c = 0;
    private String d = null;
    private int e = -1;
    private int f = -1;
    /* access modifiers changed from: private */
    public k g = null;

    public void onCreate(Bundle bundle) {
        Bundle arguments;
        super.onCreate(bundle);
        this.g = new k(getActivity().getApplicationContext());
        if ("oppo.intent.action.APP_CODE_SETTING".equals(getActivity().getIntent().getAction()) && (arguments = getArguments()) != null) {
            this.c = arguments.getInt("pref_camera_id_key");
            this.d = arguments.getString("pref_camera_mode_key", (String) null);
            this.e = arguments.getInt("camera_enter_type");
            this.f = arguments.getInt("camera_property_camera_id");
        }
        this.g.a((Context) getActivity(), this.c);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.camera_setting_codec, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a(view);
        b(view);
    }

    public void onDestroy() {
        super.onDestroy();
        k kVar = this.g;
        if (kVar != null) {
            kVar.a(getActivity().getApplicationContext());
            this.g = null;
        }
    }

    private void a(View view) {
        this.f4188a = "JPEG".equals(this.g.getString("pref_photo_codec_key", "JPEG")) ? 1 : 0;
        final FixedListView fixedListView = (FixedListView) view.findViewById(R.id.list_photo_codec);
        fixedListView.setNestedScrollingEnabled(true);
        final ArrayList arrayList = new ArrayList();
        arrayList.add("HEIF");
        arrayList.add("JPEG");
        final ArrayList arrayList2 = new ArrayList();
        arrayList2.add(getString(R.string.camera_photo_codec_heif_effect_summary));
        arrayList2.add(getString(R.string.camera_photo_codec_jpeg_effect_summary));
        final FixedListView fixedListView2 = fixedListView;
        final AnonymousClass1 r2 = new a(getActivity(), R.layout.oppo_preference_select_layout, R.id.pref_title, arrayList) {
            public View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                CheckBox checkBox = (CheckBox) view2.findViewById(R.id.pref_checkbox);
                TextView textView = (TextView) view2.findViewById(R.id.pref_summary);
                textView.setText((CharSequence) arrayList2.get(i));
                textView.setVisibility(0);
                if (i == d.this.f4188a) {
                    fixedListView2.setItemChecked(d.this.f4188a + fixedListView2.getHeaderViewsCount(), true);
                    checkBox.setChecked(true);
                } else {
                    checkBox.setChecked(false);
                }
                if (!isEnabled(i)) {
                    ((TextView) view2.findViewById(R.id.pref_title)).setTextColor(d.this.getResources().getColor(R.color.setting_pref_text_disable_color));
                }
                return view2;
            }
        };
        fixedListView.setAdapter(r2);
        fixedListView.setChoiceMode(1);
        fixedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int unused = d.this.f4188a = i - fixedListView.getHeaderViewsCount();
                SharedPreferences.Editor edit = d.this.g.edit();
                edit.putString("pref_photo_codec_key", (String) arrayList.get(d.this.f4188a));
                edit.apply();
                d dVar = d.this;
                dVar.a("pref_photo_codec_key", arrayList.get(dVar.f4188a));
                r2.notifyDataSetChanged();
            }
        });
    }

    private void b(View view) {
        this.f4189b = "H265".equals(this.g.getString("pref_video_codec_key", "H264")) ^ true ? 1 : 0;
        final FixedListView fixedListView = (FixedListView) view.findViewById(R.id.list_video_codec);
        fixedListView.setNestedScrollingEnabled(true);
        ArrayList arrayList = new ArrayList();
        arrayList.add("H.265");
        arrayList.add("H.264");
        final FixedListView fixedListView2 = fixedListView;
        final AnonymousClass3 r2 = new a(getActivity(), R.layout.oppo_preference_select_layout, R.id.pref_title, arrayList) {
            public View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                CheckBox checkBox = (CheckBox) view2.findViewById(R.id.pref_checkbox);
                TextView textView = (TextView) view2.findViewById(R.id.pref_summary);
                textView.setVisibility(0);
                textView.setText(i == 0 ? R.string.camera_video_codec_high_effect_summary : R.string.camera_video_codec_well_compatibility_summary);
                if (i == d.this.f4189b) {
                    FixedListView fixedListView = fixedListView2;
                    fixedListView.setItemChecked(fixedListView.getHeaderViewsCount() + i, true);
                    checkBox.setChecked(true);
                } else {
                    checkBox.setChecked(false);
                }
                if (!isEnabled(i)) {
                    ((TextView) view2.findViewById(R.id.pref_title)).setTextColor(d.this.getResources().getColor(R.color.setting_pref_text_disable_color));
                }
                return view2;
            }
        };
        fixedListView.setAdapter(r2);
        fixedListView.setChoiceMode(1);
        fixedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int unused = d.this.f4189b = i - fixedListView.getHeaderViewsCount();
                SharedPreferences.Editor edit = d.this.g.edit();
                String str = "H265";
                edit.putString("pref_video_codec_key", d.this.f4189b == 0 ? str : "H264");
                if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_VIDEO_3HDR) && d.this.f4189b != 0) {
                    edit.putString("key_video_hdr", "off");
                }
                edit.apply();
                d dVar = d.this;
                if (dVar.f4189b != 0) {
                    str = "H264";
                }
                dVar.a("pref_video_codec_key", (Object) str);
                r2.notifyDataSetChanged();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a(String str, Object obj) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(getContext());
        menuClickMsgData.mCaptureMode = this.d;
        menuClickMsgData.mCaptureType = a(str);
        menuClickMsgData.mCameraEnterType = String.valueOf(this.e);
        int i = this.f;
        menuClickMsgData.mCameraId = i;
        menuClickMsgData.mRearOrFront = com.oppo.camera.f.a.c(i) ? DcsMsgData.FRONT : DcsMsgData.REAR;
        menuClickMsgData.buildSettingMenuItem(str, obj);
        menuClickMsgData.report();
    }

    private int a(String str) {
        if ("pref_sound_types_key_rear".equals(str) || "pref_sound_types_key_front".equals(str) || "pref_camera_video_slogan_key".equals(str) || "pref_video_slogan_device_key".equals(str) || "pref_video_slogan_customize_key".equals(str) || "pref_video_slogan_location_key".equals(str) || "pref_video_slogan_key".equals(str) || "pref_video_slogan_time_key".equals(str)) {
            return 1;
        }
        if (!"pref_help_and_feedback_key".equals(str)) {
            return 0;
        }
        if (ApsConstant.REC_MODE_COMMON.equals(this.d) || ApsConstant.REC_MODE_FAST_VIDEO.equals(this.d) || ApsConstant.REC_MODE_SLOW_VIDEO.equals(this.d)) {
            return 1;
        }
        return 0;
    }

    /* compiled from: CameraCodeSettingFragment */
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
    }
}
