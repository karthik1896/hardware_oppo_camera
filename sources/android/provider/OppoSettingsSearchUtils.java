package android.provider;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.text.TextUtils;
import android.widget.ListAdapter;
import android.widget.ListView;

public class OppoSettingsSearchUtils {
    public static final String ARGS_COLOR_CATEGORY = ":settings:fragment_args_color_category";
    public static final String ARGS_COLOR_PREFERENCE = ":settings:fragment_args_color_preferece";
    public static final String ARGS_HIGHT_LIGHT_TIME = ":settings:fragment_args_light_time";
    public static final String ARGS_KEY = ":settings:fragment_args_key";
    public static final String ARGS_WAIT_TIME = ":settings:fragment_args_wait_time";
    private static final int DELAY_TIME = 150;
    public static final int HIGHT_LIGHT_COLOR_PREFERENCE_DEFAULT = -1776412;
    public static final int HIGH_LIGHT_TIME_DEFAULT = 1000;
    private static final int LAST_TIME = 500;
    public static final String RAW_RENAME_EXTRA_KEY = "_settings_extra_key";
    private static final int START_TIME = 100;
    private static final int STOP_TIME = 250;
    public static final int WAIT_TIME_DEFAULT = 300;

    public static void highlightListView(final ListView listView, final int i, final boolean z, Intent intent) {
        if (listView != null && intent != null && !TextUtils.isEmpty(intent.getStringExtra(ARGS_KEY)) && listView != null) {
            listView.post(new Runnable() {
                public void run() {
                    int i = i;
                    if (i >= 0) {
                        listView.setSelection(i);
                        OppoSettingsSearchUtils.showHightlight(listView, i, OppoSettingsSearchUtils.HIGHT_LIGHT_COLOR_PREFERENCE_DEFAULT, z);
                    }
                }
            });
        }
    }

    public static void highlightPreference(PreferenceScreen preferenceScreen, ListView listView, Bundle bundle) {
        if (preferenceScreen != null && listView != null && bundle != null) {
            String string = bundle.getString(ARGS_KEY);
            if (!TextUtils.isEmpty(string)) {
                calculateHightlight(preferenceScreen, listView, string, (int) HIGHT_LIGHT_COLOR_PREFERENCE_DEFAULT);
            }
        }
    }

    public static void highlightPreference(ListView listView, Bundle bundle) {
        if (listView != null && bundle != null) {
            String string = bundle.getString(ARGS_KEY);
            if (!TextUtils.isEmpty(string)) {
                calculateHightlight(listView, string, (int) HIGHT_LIGHT_COLOR_PREFERENCE_DEFAULT, false);
            }
        }
    }

    private static void calculateHightlight(final ListView listView, final String str, final int i, final boolean z) {
        if (listView != null) {
            listView.post(new Runnable() {
                public void run() {
                    int access$100 = OppoSettingsSearchUtils.canUseListViewForHighLighting(listView, str);
                    if (access$100 > 1) {
                        listView.setSelection(access$100);
                    }
                    if (access$100 >= 0) {
                        OppoSettingsSearchUtils.showHightlight(listView, access$100, i, z);
                    }
                }
            });
        }
    }

    private static void calculateHightlight(PreferenceScreen preferenceScreen, ListView listView, String str, int i) {
        Preference findPreference = preferenceScreen.findPreference(str);
        if (findPreference != null) {
            calculateHightlight(listView, str, i, findPreference instanceof PreferenceCategory);
        }
    }

    /* access modifiers changed from: private */
    public static void showHightlight(final ListView listView, final int i, final int i2, boolean z) {
        if (!z) {
            listView.postDelayed(new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
                    r0 = r0.getChildAt(r0);
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r5 = this;
                        int r0 = r1
                        android.widget.ListView r1 = r0
                        int r1 = r1.getFirstVisiblePosition()
                        int r0 = r0 - r1
                        if (r0 < 0) goto L_0x0036
                        android.widget.ListView r1 = r0
                        int r1 = r1.getChildCount()
                        if (r0 >= r1) goto L_0x0036
                        android.widget.ListView r1 = r0
                        android.view.View r0 = r1.getChildAt(r0)
                        if (r0 != 0) goto L_0x001c
                        return
                    L_0x001c:
                        android.graphics.drawable.Drawable r1 = r0.getBackground()
                        int r2 = r2
                        android.graphics.drawable.AnimationDrawable r2 = android.provider.OppoSettingsSearchUtils.getAnimationDrawable(r2, r1)
                        r0.setBackgroundDrawable(r2)
                        r2.start()
                        android.provider.OppoSettingsSearchUtils$3$1 r2 = new android.provider.OppoSettingsSearchUtils$3$1
                        r2.<init>(r0, r1)
                        r3 = 1000(0x3e8, double:4.94E-321)
                        r0.postDelayed(r2, r3)
                    L_0x0036:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: android.provider.OppoSettingsSearchUtils.AnonymousClass3.run():void");
                }
            }, 300);
        }
    }

    /* access modifiers changed from: private */
    public static AnimationDrawable getAnimationDrawable(int i, Drawable drawable) {
        double d;
        int i2 = i;
        Drawable drawable2 = drawable;
        AnimationDrawable animationDrawable = new AnimationDrawable();
        int i3 = 0;
        while (true) {
            d = 0.0d;
            if (i3 >= 6) {
                break;
            }
            ColorDrawable colorDrawable = new ColorDrawable(i);
            colorDrawable.setAlpha((int) (((((double) i3) + 0.0d) * 255.0d) / ((double) 6)));
            if (drawable2 != null) {
                animationDrawable.addFrame(new LayerDrawable(new Drawable[]{drawable2, colorDrawable}), 16);
            } else {
                animationDrawable.addFrame(colorDrawable, 16);
            }
            i3++;
        }
        animationDrawable.addFrame(new ColorDrawable(i), 250);
        int i4 = 0;
        while (i4 < 31) {
            double d2 = ((((double) (31 - i4)) - d) * 255.0d) / ((double) 31);
            ColorDrawable colorDrawable2 = new ColorDrawable(i);
            colorDrawable2.setAlpha((int) d2);
            if (drawable2 != null) {
                animationDrawable.addFrame(new LayerDrawable(new Drawable[]{drawable2, colorDrawable2}), 16);
            } else {
                animationDrawable.addFrame(colorDrawable2, 16);
            }
            i4++;
            d = 0.0d;
        }
        if (drawable2 != null) {
            animationDrawable.addFrame(drawable2, 150);
        }
        return animationDrawable;
    }

    /* access modifiers changed from: private */
    public static int canUseListViewForHighLighting(ListView listView, String str) {
        String key;
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            int count = adapter.getCount();
            for (int i = 0; i < count; i++) {
                Object item = adapter.getItem(i);
                if ((item instanceof Preference) && (key = ((Preference) item).getKey()) != null && key.equals(str)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
