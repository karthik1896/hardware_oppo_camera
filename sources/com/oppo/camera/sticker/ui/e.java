package com.oppo.camera.sticker.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.oppo.camera.R;
import com.oppo.camera.sticker.ui.h;
import com.oppo.camera.ui.RotateImageView;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: StickerCategoryAdapter */
public class e extends RecyclerView.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<h.b> f3701a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private HashMap<Integer, RecyclerView.w> f3702b = new HashMap<>();
    /* access modifiers changed from: private */
    public int c = -1;
    private g d = null;
    private int e;
    private Context f = null;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;

    public e(Context context, g gVar, int i2) {
        this.d = gVar;
        this.f = context;
        this.j = this.f.getResources().getDimensionPixelSize(R.dimen.sticker_gridview_redpoint_radius);
        this.i = this.f.getResources().getDimensionPixelSize(R.dimen.sticker_type_view_redpoint_margin_top);
        this.h = this.f.getResources().getDimensionPixelSize(R.dimen.sticker_type_thumbnail_display_size);
        this.e = i2;
        this.g = this.f.getResources().getDimensionPixelSize(R.dimen.sticker_type_view_item_size);
    }

    public void a(ArrayList<h.b> arrayList) {
        this.f3701a.clear();
        if (arrayList != null && arrayList.size() > 0) {
            this.f3701a.addAll(arrayList.subList(1, arrayList.size()));
        }
    }

    public h.b a(int i2) {
        return this.f3701a.get(i2);
    }

    public void b(int i2) {
        com.oppo.camera.e.a("StickerCategoryAdapter", "setSelectIndex, index: " + i2);
        RecyclerView.w wVar = this.f3702b.get(Integer.valueOf(this.c));
        RecyclerView.w wVar2 = this.f3702b.get(Integer.valueOf(i2));
        if (wVar != null) {
            ((a) wVar).f3703a.setImageDrawable(a(this.c, false));
        }
        if (wVar2 != null && i2 >= 0) {
            ((a) wVar2).f3703a.setImageDrawable(a(i2, true));
        }
        this.c = i2;
    }

    public void c(int i2) {
        this.e = i2;
        notifyDataSetChanged();
    }

    public RecyclerView.w onCreateViewHolder(ViewGroup viewGroup, int i2) {
        RotateImageView rotateImageView = new RotateImageView(this.f);
        int i3 = this.g;
        rotateImageView.setLayoutParams(new RelativeLayout.LayoutParams(i3, i3));
        a aVar = new a(rotateImageView, this.d);
        rotateImageView.a(this.e, true);
        return aVar;
    }

    public void onBindViewHolder(RecyclerView.w wVar, int i2) {
        this.f3702b.put(Integer.valueOf(i2), wVar);
        a aVar = (a) wVar;
        RotateImageView rotateImageView = aVar.f3703a;
        if (i2 == this.c) {
            rotateImageView.setImageDrawable(a(i2, true));
        } else {
            rotateImageView.setImageDrawable(a(i2, false));
        }
        rotateImageView.setOnClickListener(aVar);
        rotateImageView.a(this.e, true);
        rotateImageView.setTag(Integer.valueOf(i2));
        rotateImageView.setContentDescription(this.f.getResources().getString(R.string.camera_description_sticker_category_item) + i2);
    }

    private Drawable a(int i2, boolean z) {
        if (i2 >= this.f3701a.size()) {
            return null;
        }
        Drawable drawable = this.f3701a.get(i2).f3729b;
        if (z) {
            drawable = this.f3701a.get(i2).f3728a;
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable});
        int i3 = this.h;
        layerDrawable.setLayerSize(0, i3, i3);
        return this.f3701a.get(i2).d ? a((Drawable) layerDrawable) : layerDrawable;
    }

    private LayerDrawable a(Drawable drawable) {
        Drawable[] drawableArr = {drawable, this.f.getResources().getDrawable(R.drawable.sticker_red_point)};
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        int intrinsicWidth = drawableArr[0].getIntrinsicWidth();
        int intrinsicWidth2 = drawableArr[1].getIntrinsicWidth();
        int i2 = this.g;
        int i3 = (i2 - intrinsicWidth) / 2;
        int i4 = i3 + 0;
        int i5 = i2 - (intrinsicWidth + i3);
        int i6 = this.j;
        int i7 = i2 - ((intrinsicWidth2 / 2) + i6);
        int i8 = i6 - this.i;
        int i9 = i7 + intrinsicWidth2;
        int i10 = i7 - 0;
        int i11 = i8 + 0;
        int i12 = i2 - i9;
        int i13 = i2 - (intrinsicWidth2 + i8);
        if (i4 < 0 || i4 < 0 || i5 > 0 || i5 > 0) {
            com.oppo.camera.e.e("StickerCategoryAdapter", "downloadSuccess, drawable0 out of thumbnail display!");
        }
        LayerDrawable layerDrawable2 = layerDrawable;
        layerDrawable2.setLayerInset(0, i4, i4, i5, i5);
        layerDrawable2.setLayerInset(1, i10, i11, i12, i13);
        return layerDrawable;
    }

    public int getItemCount() {
        return this.f3701a.size();
    }

    /* compiled from: StickerCategoryAdapter */
    public class a extends RecyclerView.w implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public RotateImageView f3703a;
        private g c;

        public a(View view, g gVar) {
            super(view);
            this.f3703a = (RotateImageView) view;
            this.f3703a.setOnClickListener(this);
            this.c = gVar;
        }

        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            com.oppo.camera.e.b("StickerCategoryAdapter", "onClick, clickIndex: " + intValue + ", mSelectedIndexInAdapter: " + e.this.c);
            if (e.this.c != intValue) {
                e.this.b(intValue);
                this.c.a(e.this.c + 1, e.this.c, ((h.b) e.this.f3701a.get(e.this.c)).c, false);
            }
        }
    }
}
