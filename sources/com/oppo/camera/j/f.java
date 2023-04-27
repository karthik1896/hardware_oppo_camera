package com.oppo.camera.j;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.oppo.camera.R;
import com.oppo.camera.ui.RotateImageView;

/* compiled from: FilmMenuLayout */
public class f extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private BaseAdapter f3357a;

    /* renamed from: b  reason: collision with root package name */
    private a f3358b;

    /* compiled from: FilmMenuLayout */
    public interface a {
        void b(View view, View view2, int i);
    }

    public f(Context context) {
        this(context, (BaseAdapter) null);
    }

    public f(Context context, BaseAdapter baseAdapter) {
        super(context);
        this.f3357a = null;
        this.f3358b = null;
        setLayoutDirection(0);
        setOrientation(0);
        setAdapter(baseAdapter);
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        if (baseAdapter != null) {
            removeAllViews();
            this.f3357a = baseAdapter;
            int count = this.f3357a.getCount();
            for (int i = 0; i < count; i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.movie_mode_menu_width), getContext().getResources().getDimensionPixelSize(R.dimen.movie_mode_menu_height));
                View view = this.f3357a.getView(i, getMenuView(), this);
                view.setOnClickListener(this);
                addView(view, layoutParams);
            }
        }
    }

    private View getMenuView() {
        RotateImageView rotateImageView = new RotateImageView(getContext());
        rotateImageView.a(270, false);
        return rotateImageView;
    }

    public void setMenuItemClickListener(a aVar) {
        this.f3358b = aVar;
    }

    public void onClick(View view) {
        if (this.f3358b != null) {
            this.f3358b.b(this, view, indexOfChild(view));
        }
    }
}
