package com.oppo.camera.j;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.widget.ListView;
import com.oppo.camera.R;

/* compiled from: FilmSubMenuPanel */
public class q extends ListView {

    /* renamed from: a  reason: collision with root package name */
    private n f3388a = null;

    public q(Context context) {
        super(context);
        setDivider((Drawable) null);
        setBackground(context.getResources().getDrawable(R.drawable.film_submenu_panel_bg));
        setDividerHeight(context.getResources().getDimensionPixelSize(R.dimen.movie_submenu_item_margin));
        setPadding(0, context.getResources().getDimensionPixelSize(R.dimen.movie_submenu_panel_padding_top), 0, context.getResources().getDimensionPixelSize(R.dimen.movie_submenu_panel_padding_bottom));
    }

    public boolean a() {
        Animation animation = getAnimation();
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }
}
