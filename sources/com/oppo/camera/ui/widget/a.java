package com.oppo.camera.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.ui.RotateMoreItem;
import com.oppo.camera.util.Util;

/* compiled from: MultiCameraTypeSelectLayout */
public class a extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private RotateMoreItem f4585a = null;

    /* renamed from: b  reason: collision with root package name */
    private RotateMoreItem f4586b = null;
    private RotateMoreItem c = null;
    private int d = 0;
    private int e = 0;
    private int f = 1;
    private C0107a g = null;

    /* renamed from: com.oppo.camera.ui.widget.a$a  reason: collision with other inner class name */
    /* compiled from: MultiCameraTypeSelectLayout */
    public interface C0107a {
        void a(int i);
    }

    public void b() {
    }

    public a(Context context) {
        super(context);
        c();
    }

    private void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.multi_video_type_select_layout, this, true);
        setClipChildren(false);
        this.f4585a = (RotateMoreItem) findViewById(R.id.view_half_half);
        this.f4585a.setText(getResources().getString(R.string.camera_mode_multi_video_type_pip_rect_half));
        this.f4586b = (RotateMoreItem) findViewById(R.id.view_pip_cir);
        this.f4586b.setText(getResources().getString(R.string.camera_mode_multi_video_type_pip_cir));
        this.c = (RotateMoreItem) findViewById(R.id.view_pip_rec);
        this.c.setText(getResources().getString(R.string.camera_mode_multi_video_type_pip_rect));
        e();
    }

    public void a(int i, boolean z) {
        int i2 = this.e;
        if (i2 != i) {
            this.d = i2;
            this.e = i;
            this.f4585a.a(this.d, this.e);
            this.f4586b.a(this.d, this.e);
            this.c.a(this.d, this.e);
        }
    }

    public void a() {
        b();
    }

    public void a(View view) {
        switch (view.getId()) {
            case R.id.view_half_half:
                e();
                this.f4585a.setImage(Util.a(getContext(), (int) R.drawable.multi_video_type_top_bottom_selected));
                this.f4585a.setTextColor(Util.s(getContext()));
                a(0);
                d();
                return;
            case R.id.view_pip_cir:
                e();
                this.f4586b.setImage(Util.a(getContext(), (int) R.drawable.multi_video_type_pip_cir_selected));
                this.f4586b.setTextColor(Util.s(getContext()));
                a(1);
                d();
                return;
            case R.id.view_pip_rec:
                e();
                this.c.setImage(Util.a(getContext(), (int) R.drawable.multi_video_type_pip_rect_selected));
                this.c.setTextColor(Util.s(getContext()));
                a(2);
                d();
                return;
            default:
                return;
        }
    }

    private void d() {
        this.f4585a.postInvalidate();
        this.f4586b.postInvalidate();
        this.c.postInvalidate();
    }

    private void a(int i) {
        e.b("MultiCameraTypeSelectLayout", "changeType, mSelectedType: " + this.f + ", type: " + i);
        if (this.f != i) {
            this.f = i;
            C0107a aVar = this.g;
            if (aVar != null) {
                aVar.a(this.f);
            }
        }
    }

    private void e() {
        this.f4585a.setImage(Util.a(getContext(), (int) R.drawable.multi_video_type_top_bottom_normal));
        this.f4586b.setImage(Util.a(getContext(), (int) R.drawable.multi_video_type_pip_cir_normal));
        this.c.setImage(Util.a(getContext(), (int) R.drawable.multi_video_type_pip_rect_normal));
        int c2 = androidx.core.content.a.c(getContext(), R.color.colorWhite);
        this.f4585a.setTextColor(c2);
        this.f4586b.setTextColor(c2);
        this.c.setTextColor(c2);
    }

    public void setOnTypeChangeListener(C0107a aVar) {
        this.g = aVar;
    }

    public void setType(int i) {
        e();
        this.f = i;
        if (i == 0) {
            this.f4585a.setImage(Util.a(getContext(), (int) R.drawable.multi_video_type_top_bottom_selected));
            this.f4585a.setTextColor(Util.s(getContext()));
            d();
        } else if (i == 1) {
            this.f4586b.setImage(Util.a(getContext(), (int) R.drawable.multi_video_type_pip_cir_selected));
            this.f4586b.setTextColor(Util.s(getContext()));
            d();
        } else if (i == 2) {
            this.c.setImage(Util.a(getContext(), (int) R.drawable.multi_video_type_pip_rect_selected));
            this.c.setTextColor(Util.s(getContext()));
            d();
        }
    }
}
