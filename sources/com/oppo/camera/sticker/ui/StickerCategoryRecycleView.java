package com.oppo.camera.sticker.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.oppo.camera.R;

public class StickerCategoryRecycleView extends RecyclerView {

    /* renamed from: a  reason: collision with root package name */
    private Rect f3679a;

    /* renamed from: b  reason: collision with root package name */
    private String f3680b;
    private float c;
    private LinearLayoutManager d;
    private g e;
    private Context f;
    private int g;
    private int h;
    private int i;

    public StickerCategoryRecycleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public StickerCategoryRecycleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public StickerCategoryRecycleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3679a = new Rect();
        this.f3680b = "NONE";
        this.c = 0.0f;
        this.d = null;
        this.e = null;
        this.f = null;
        this.f = context;
        this.g = this.f.getResources().getDimensionPixelSize(R.dimen.sticker_type_view_item_size);
        this.h = this.f.getResources().getDimensionPixelSize(R.dimen.sticker_view_padding);
        this.i = this.f.getResources().getDimensionPixelSize(R.dimen.sticker_recycle_list_padding);
    }

    public void setStickerCategoryInterface(g gVar) {
        this.e = gVar;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        g gVar = this.e;
        if (gVar == null || gVar.a()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.d == null) {
            this.d = (LinearLayoutManager) getLayoutManager();
        }
        if (motionEvent.getAction() == 0) {
            this.c = motionEvent.getX();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
