package com.oppo.camera.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.oppo.camera.R;
import com.oppo.camera.ui.menu.OppoTextView;
import java.util.ArrayList;

/* compiled from: FilmSubMenuAdapter */
public class n extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f3378a = null;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<o> f3379b = null;
    private LayoutInflater c = null;

    public long getItemId(int i) {
        return 0;
    }

    public n(Context context, ArrayList<o> arrayList) {
        this.f3378a = context;
        this.c = LayoutInflater.from(context);
        if (arrayList == null) {
            this.f3379b = new ArrayList<>();
        } else {
            this.f3379b = arrayList;
        }
    }

    public int getCount() {
        return this.f3379b.size();
    }

    /* renamed from: a */
    public o getItem(int i) {
        return this.f3379b.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        final o a2 = getItem(i);
        FrameLayout frameLayout = (FrameLayout) this.c.inflate(R.layout.film_submenu_item, (ViewGroup) null);
        ((TextView) frameLayout.findViewById(R.id.submenu_item_title)).setText(a2.b());
        ArrayList<p> d = a2.d();
        int size = d.size();
        int a3 = a2.a();
        int c2 = a2.c();
        if (c2 == 0) {
            int i2 = size - 1;
            for (int i3 = i2; i3 >= 0; i3--) {
                final p pVar = d.get(i3);
                ImageView imageView = new ImageView(this.f3378a);
                int dimensionPixelSize = this.f3378a.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_width);
                int dimensionPixelSize2 = this.f3378a.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_height);
                int dimensionPixelSize3 = this.f3378a.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_space);
                int dimensionPixelSize4 = this.f3378a.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_last_space);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
                layoutParams.gravity = 8388629;
                int i4 = i2 - i3;
                layoutParams.setMarginEnd((dimensionPixelSize * i4) + (i4 * dimensionPixelSize3) + dimensionPixelSize4);
                int dimensionPixelSize5 = this.f3378a.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_padding_left_right);
                int dimensionPixelSize6 = this.f3378a.getResources().getDimensionPixelSize(R.dimen.drawer_item_icon_padding_top_bottom);
                imageView.setPadding(dimensionPixelSize5, dimensionPixelSize6, dimensionPixelSize5, dimensionPixelSize6);
                if (i3 == a3) {
                    imageView.setBackgroundResource(pVar.e());
                    imageView.setImageResource(pVar.b());
                } else {
                    imageView.setBackgroundResource(pVar.d());
                    imageView.setImageResource(pVar.a());
                }
                imageView.setTag(Integer.valueOf(i3));
                imageView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        int c2 = pVar.c();
                        if (a2.a() != c2) {
                            a2.a(c2);
                            a2.e().a(c2);
                        }
                    }
                });
                frameLayout.addView(imageView, layoutParams);
            }
        } else if (c2 == 1) {
            int i5 = size - 1;
            int i6 = i5;
            while (i6 >= 0) {
                final p pVar2 = d.get(i6);
                OppoTextView oppoTextView = new OppoTextView(this.f3378a);
                oppoTextView.setTextSize(0, (float) this.f3378a.getResources().getDimensionPixelSize(R.dimen.drawer_item_text_size));
                int dimensionPixelSize7 = this.f3378a.getResources().getDimensionPixelSize(R.dimen.drawer_item_text_width);
                int dimensionPixelSize8 = this.f3378a.getResources().getDimensionPixelSize(R.dimen.drawer_item_text_height);
                int dimensionPixelSize9 = this.f3378a.getResources().getDimensionPixelSize(R.dimen.drawer_item_text_space);
                int dimensionPixelSize10 = this.f3378a.getResources().getDimensionPixelSize(R.dimen.drawer_text_last_space);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dimensionPixelSize7, dimensionPixelSize8);
                layoutParams2.gravity = 8388629;
                int i7 = i5 - i6;
                layoutParams2.setMarginEnd((dimensionPixelSize7 * i7) + (i7 * dimensionPixelSize9) + dimensionPixelSize10);
                oppoTextView.setGravity(17);
                oppoTextView.setText(i6 == 0 ? R.string.camera_flash_mode_off : R.string.camera_flash_mode_on);
                if (i6 == a3) {
                    oppoTextView.setTextColor(-16777216);
                    oppoTextView.setBackground(this.f3378a.getDrawable(R.drawable.drawer_item_tv_background));
                } else {
                    oppoTextView.setTextColor(this.f3378a.getColor(R.color.camera_white));
                    oppoTextView.setBackground(this.f3378a.getDrawable(R.drawable.drawer_item_tv_background_grey));
                }
                oppoTextView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        pVar2.c();
                        int c2 = pVar2.c();
                        if (a2.a() != c2) {
                            a2.a(c2);
                            a2.e().a(c2);
                        }
                    }
                });
                frameLayout.addView(oppoTextView, layoutParams2);
                i6--;
            }
        }
        return frameLayout;
    }
}
