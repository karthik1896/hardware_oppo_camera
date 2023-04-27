package com.oppo.camera.sticker.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.sticker.data.StickerCategoryItem;
import com.oppo.camera.sticker.data.StickerItem;
import com.oppo.camera.util.Util;
import java.util.List;
import java.util.Map;

public class StickerGridViewLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f3681a;

    /* renamed from: b  reason: collision with root package name */
    private FooterGridView f3682b;
    /* access modifiers changed from: private */
    public a c;
    private c d;
    private Context e;
    /* access modifiers changed from: private */
    public i f;
    private int g;

    public StickerGridViewLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public StickerGridViewLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public StickerGridViewLayout(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, -1, -1);
    }

    public StickerGridViewLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3681a = null;
        this.f3682b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0;
        this.e = context;
    }

    public void setOrientation(int i) {
        this.g = i;
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void setStickerMenuListener(i iVar) {
        this.f = iVar;
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(iVar);
        }
    }

    public void setImageDownloader(c cVar) {
        this.d = cVar;
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(cVar);
        }
    }

    public void a(List<Map<String, Object>> list, int i, boolean z) {
        e.a("StickerGridViewLayout", "setDataList, stickerItemList.size: " + list.size() + ", needNotify: " + z + ", getTag: " + ((String) getTag()));
        this.g = i;
        a aVar = this.c;
        if (aVar != null) {
            aVar.a((String) getTag());
            this.c.a(list);
            this.c.a(this.f);
            this.c.a(this.g);
            if (z) {
                this.c.notifyDataSetChanged();
            }
            if (this.f3681a != null && StickerCategoryItem.isMyCategory((String) getTag())) {
                this.f3681a.setVisibility(this.c.getCount() <= 0 ? 0 : 4);
            }
        }
    }

    public void a(int i, int i2, Drawable drawable, boolean z, StickerItem stickerItem) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(i, i2, drawable, z, stickerItem);
        }
    }

    public void a() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void setTag(Object obj) {
        super.setTag(obj);
        if (StickerCategoryItem.isMyCategory((String) getTag()) && this.f3681a == null) {
            this.f3681a = new TextView(this.e);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(10);
            layoutParams.topMargin = this.e.getResources().getDimensionPixelSize(R.dimen.sticker_tips_margin_top);
            if (StickerCategoryItem.isMyCategory((String) getTag())) {
                this.f3681a.setText(R.string.sticker_tips_none);
            }
            this.f3681a.setTextColor(this.e.getColor(R.color.camera_white));
            this.f3681a.setTextSize(0, this.e.getResources().getDimension(R.dimen.camera_text_size_smaller));
            this.f3681a.setTypeface(Util.j(getContext()));
            this.f3681a.setVisibility(8);
            addView(this.f3681a, layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f3682b = (FooterGridView) findViewById(R.id.sticker_grid_view);
        this.c = new a(this.e, this.d, this.g);
        this.f3682b.setAdapter(this.c);
        this.f3682b.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (StickerGridViewLayout.this.f == null || !StickerGridViewLayout.this.f.g() || StickerGridViewLayout.this.c == null) {
                    e.a("StickerGridViewLayout", "onItemClick, return");
                    return;
                }
                StickerItem b2 = StickerGridViewLayout.this.c.b(i);
                if (b2 != null && !StickerGridViewLayout.this.f.a(b2, i)) {
                    StickerGridViewLayout.this.c.notifyDataSetChanged();
                }
            }
        });
        this.f3682b.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                e.b("StickerGridViewLayout", "onItemLongClick, position: " + i + ", id: " + j);
                if (StickerGridViewLayout.this.f == null || !StickerGridViewLayout.this.f.g()) {
                    e.a("StickerGridViewLayout", "onItemLongClick, return");
                    return false;
                }
                StickerItem b2 = StickerGridViewLayout.this.c.b(i);
                if (b2 == null || StickerGridViewLayout.this.f.a(view, b2, i)) {
                    return true;
                }
                return false;
            }
        });
    }

    public void setGridViewEnable(boolean z) {
        FooterGridView footerGridView = this.f3682b;
        if (footerGridView != null) {
            footerGridView.setClickable(z);
            this.f3682b.setEnabled(z);
        }
    }
}
