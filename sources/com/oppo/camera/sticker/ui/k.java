package com.oppo.camera.sticker.ui;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.RelativeLayout;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.sticker.data.StickerItem;
import com.oppo.camera.sticker.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: StickerRecycleBinAdapter */
public class k extends CursorAdapter implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, StickerItem> f3738a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private a f3739b = null;

    /* compiled from: StickerRecycleBinAdapter */
    public interface a {
        void a(k kVar);
    }

    public k(Context context, Cursor cursor, boolean z) {
        super(context, cursor, z);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.editor_sticker_recycle_bin_item_layout, viewGroup, false);
        relativeLayout.setTag(new b(relativeLayout));
        return relativeLayout;
    }

    public void bindView(View view, Context context, Cursor cursor) {
        b bVar = (b) view.getTag();
        StickerItem a2 = g.a(cursor);
        e.a("StickerRecycleBinAdapter", "bindView, item: " + a2);
        bVar.f3740a.setNormalDrawableUri(a2.getThumbnailFileUri());
        view.setTag(R.id.sticker_recycle_bin_item_tag, a2);
        view.setOnClickListener(this);
        if (this.f3738a.containsKey(a2.getStickerUUID())) {
            bVar.f3741b.setChecked(true);
        } else {
            bVar.f3741b.setChecked(false);
        }
    }

    public void a() {
        for (StickerItem next : g()) {
            this.f3738a.put(next.getStickerUUID(), next);
        }
        a aVar = this.f3739b;
        if (aVar != null) {
            aVar.a(this);
        }
        notifyDataSetChanged();
    }

    public void b() {
        this.f3738a.clear();
        a aVar = this.f3739b;
        if (aVar != null) {
            aVar.a(this);
        }
        notifyDataSetChanged();
    }

    public boolean c() {
        return getCount() != 0 && getCount() == this.f3738a.size();
    }

    public int d() {
        return this.f3738a.size();
    }

    public Map<String, StickerItem> e() {
        return this.f3738a;
    }

    public int getCount() {
        Cursor cursor = getCursor();
        if (cursor != null && !cursor.isClosed()) {
            return cursor.getCount();
        }
        e.d("StickerRecycleBinAdapter", "getCount, cursor is null or closed! cursor: " + cursor);
        return 0;
    }

    public Object getItem(int i) {
        Cursor cursor = getCursor();
        if (cursor == null || i >= cursor.getCount()) {
            return null;
        }
        cursor.moveToPosition(i);
        return g.a(cursor);
    }

    public void f() {
        this.f3738a.clear();
        if (getCursor() != null) {
            getCursor().close();
        }
    }

    public void a(StickerItem stickerItem) {
        if (stickerItem != null && !TextUtils.isEmpty(stickerItem.getStickerUUID())) {
            if (this.f3738a.size() > 0 && this.f3738a.remove(stickerItem.getStickerUUID()) != null) {
                e.b("StickerRecycleBinAdapter", "onStickerDelete, remove a selected sticker item!");
                a aVar = this.f3739b;
                if (aVar != null) {
                    aVar.a(this);
                }
            }
            notifyDataSetChanged();
        }
    }

    public void onClick(View view) {
        Object tag = view.getTag(R.id.sticker_recycle_bin_item_tag);
        if (tag instanceof StickerItem) {
            StickerItem stickerItem = (StickerItem) tag;
            if (this.f3738a.containsKey(stickerItem.getStickerUUID())) {
                this.f3738a.remove(stickerItem.getStickerUUID());
            } else {
                this.f3738a.put(stickerItem.getStickerUUID(), stickerItem);
            }
            a aVar = this.f3739b;
            if (aVar != null) {
                aVar.a(this);
            }
            notifyDataSetChanged();
        }
    }

    public void a(a aVar) {
        this.f3739b = aVar;
    }

    private List<StickerItem> g() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = getCursor();
        if (cursor == null || !cursor.moveToFirst()) {
            return arrayList;
        }
        do {
            arrayList.add(g.a(cursor));
        } while (cursor.moveToNext());
        return arrayList;
    }

    /* compiled from: StickerRecycleBinAdapter */
    private static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public StickerRecycleBinThumbnailView f3740a = null;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public CheckBox f3741b = null;

        public b(View view) {
            this.f3740a = (StickerRecycleBinThumbnailView) view.findViewById(R.id.sticker_thumbnail);
            this.f3741b = (CheckBox) view.findViewById(R.id.sticker_check_box);
        }
    }
}
