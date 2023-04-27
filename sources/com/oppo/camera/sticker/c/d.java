package com.oppo.camera.sticker.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* compiled from: PrefUtils */
public class d {
    public static long a(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("local_data_version", 0);
    }

    public static long b(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("check_interval_in_minute", 0);
    }

    public static long c(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("last_request_time", 0);
    }

    public static void a(Context context, long j) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong("local_data_version", j);
        edit.apply();
    }

    public static void b(Context context, long j) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong("check_interval_in_minute", j);
        edit.apply();
    }

    public static void c(Context context, long j) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong("last_request_time", j);
        edit.apply();
    }

    public static void a(Context context, boolean z) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("test_environment", z);
        edit.apply();
        a(context, 0);
        c(context, 0);
    }

    public static boolean d(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("test_environment", false);
    }

    public static void b(Context context, boolean z) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("trace_debug", z);
        edit.apply();
    }

    public static boolean e(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("trace_debug", false);
    }

    public static void a(Context context, int i) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("auditing_mode", i);
        edit.apply();
        a(context, 0);
        c(context, 0);
    }

    public static int f(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("auditing_mode", 3);
    }

    public static void c(Context context, boolean z) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("dump_retention", z);
        edit.apply();
    }

    public static boolean g(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("dump_retention", false);
    }
}
