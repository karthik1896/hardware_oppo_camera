package com.oppo.camera.d;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.oppo.camera.R;

/* compiled from: Beauty3DTools */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f2799a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2800b = false;
    private Context c = null;
    private SparseArray<Integer> d = new SparseArray<>();
    private SparseArray<Integer> e = new SparseArray<>();
    private SparseArray<Integer> f = new SparseArray<>();
    private SparseArray<Integer> g = new SparseArray<>();
    private SparseArray<Integer> h = new SparseArray<>();
    private SparseArray<Integer> i = new SparseArray<>();

    public int a(float f2, int i2, float f3, int i3) {
        int i4 = i3 - ((int) ((((f2 - f3) * 2.0f) / ((float) i2)) * ((float) 90)));
        if (i4 >= 90) {
            return 90;
        }
        if (i4 < -90) {
            return -90;
        }
        return i4;
    }

    private c() {
    }

    public static c a() {
        if (f2799a == null) {
            f2799a = new c();
        }
        return f2799a;
    }

    public void a(Activity activity) {
        if (!this.f2800b) {
            this.c = activity.getApplicationContext();
            b();
            this.f2800b = true;
        }
    }

    public Integer a(int i2) {
        return this.e.get(i2);
    }

    public Integer b(int i2) {
        return this.d.get(i2);
    }

    public Integer c(int i2) {
        return this.f.get(i2);
    }

    public Integer d(int i2) {
        return this.g.get(i2);
    }

    public Integer e(int i2) {
        return this.h.get(i2);
    }

    public Integer f(int i2) {
        return this.i.get(i2);
    }

    private void b() {
        this.d.put(0, Integer.valueOf(R.string.beauty3d_standard_nose));
        this.d.put(1, Integer.valueOf(R.string.beauty3d_width_nose));
        this.d.put(2, Integer.valueOf(R.string.beauty3d_narrow_nose));
        this.e.put(0, Integer.valueOf(R.string.beauty3d_standard_eye));
        this.e.put(1, Integer.valueOf(R.string.beauty3d_small_eye));
        this.f.put(0, Integer.valueOf(R.string.beauty3d_standard_chin));
        this.f.put(1, Integer.valueOf(R.string.beauty3d_long_chin));
        this.f.put(2, Integer.valueOf(R.string.beauty3d_short_chin));
        this.g.put(0, Integer.valueOf(R.string.beauty3d_goose_face));
        this.g.put(1, Integer.valueOf(R.string.beauty3d_square_face));
        this.g.put(2, Integer.valueOf(R.string.beauty3d_long_face));
        this.g.put(3, Integer.valueOf(R.string.beauty3d_round_face));
        this.h.put(0, Integer.valueOf(R.string.beauty3d_standard_cheekbone));
        this.h.put(1, Integer.valueOf(R.string.beauty3d_high_cheekbone));
        this.i.put(5, Integer.valueOf(R.string.beauty3d_pelease_remove_glasses));
        this.i.put(6, Integer.valueOf(R.string.beauty3d_face_change));
        this.i.put(7, Integer.valueOf(R.string.beauty3d_keep_face_in_cicle));
        this.i.put(8, Integer.valueOf(R.string.beauty3d_no_face));
        SparseArray<Integer> sparseArray = this.i;
        Integer valueOf = Integer.valueOf(R.string.beauty3d_orientatin_error_keep_vertical);
        sparseArray.put(9, valueOf);
        this.i.put(22, valueOf);
        this.i.put(10, Integer.valueOf(R.string.beauty3d_keep_face_forward));
        this.i.put(11, Integer.valueOf(R.string.beauty3d_turn_to_left));
        this.i.put(12, Integer.valueOf(R.string.beauty3d_turn_to_right));
        this.i.put(13, Integer.valueOf(R.string.beauty3d_turn_to_up));
        this.i.put(14, Integer.valueOf(R.string.beauty3d_wait_scan_complete));
        this.i.put(15, Integer.valueOf(R.string.beauty3d_no_show_teeth));
        this.i.put(16, Integer.valueOf(R.string.beauty3d_face_blurred));
        this.i.put(17, Integer.valueOf(R.string.beauty3d_face_closer));
        this.i.put(18, Integer.valueOf(R.string.beauty3d_continue_turn_to_left));
        this.i.put(19, Integer.valueOf(R.string.beauty3d_continue_turn_to_right));
        this.i.put(21, Integer.valueOf(R.string.beauty3d_over_max_frame_exit));
        this.i.put(22, Integer.valueOf(R.string.beauty3d_program_error_exit));
        this.i.put(20, Integer.valueOf(R.string.beauty3d_save_face_failed));
    }
}
