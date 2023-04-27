package com.oppo.camera.sticker.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.sticker.data.StickerCategoryItem;
import com.oppo.camera.sticker.data.StickerItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: GridAdapter */
public class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private i f3687a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f3688b = 0;
    private c c = null;
    private List<Map<String, Object>> d = null;
    private LayoutInflater e = null;
    private Context f = null;
    private String g = null;
    private Drawable h = null;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private boolean m = false;

    public long getItemId(int i2) {
        return (long) i2;
    }

    public a(Context context, c cVar, int i2) {
        this.c = cVar;
        this.d = new ArrayList();
        this.f = context;
        this.e = LayoutInflater.from(context);
        this.f3688b = i2;
        this.k = this.f.getResources().getDimensionPixelSize(R.dimen.sticker_gridview_image_width);
        this.j = this.f.getResources().getDimensionPixelSize(R.dimen.sticker_gridview_highlight_width);
        this.i = this.f.getResources().getDimensionPixelSize(R.dimen.sticker_gridview_item_size);
        this.l = this.f.getResources().getDimensionPixelSize(R.dimen.sticker_gridview_image_padding);
    }

    public void a(String str) {
        this.g = str;
    }

    public int getCount() {
        if (StickerCategoryItem.isMyCategory(this.g)) {
            List<Map<String, Object>> list = this.d;
            if (list == null) {
                return 0;
            }
            int size = list.size();
            if (size > 1) {
                return size;
            }
            e.b("GridAdapter", "getCount, myCategory only has the recycle bin sticker");
            return 0;
        }
        List<Map<String, Object>> list2 = this.d;
        if (list2 != null) {
            return list2.size();
        }
        return 0;
    }

    public Object getItem(int i2) {
        return this.d.get(i2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: com.oppo.camera.sticker.ui.b} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r8, android.view.View r9, android.view.ViewGroup r10) {
        /*
            r7 = this;
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "GridAdapter_getView_"
            r10.append(r0)
            r10.append(r8)
            java.lang.String r1 = "_"
            r10.append(r1)
            boolean r2 = r7.m
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            com.oppo.camera.e.a((java.lang.String) r10)
            r10 = 0
            if (r9 != 0) goto L_0x0064
            android.view.LayoutInflater r9 = r7.e
            r2 = 2131493116(0x7f0c00fc, float:1.8609703E38)
            android.view.View r9 = r9.inflate(r2, r10)
            int r2 = r7.i
            int r3 = r7.k
            int r4 = r7.j
            int r3 = java.lang.Math.max(r3, r4)
            int r2 = java.lang.Math.max(r2, r3)
            android.widget.AbsListView$LayoutParams r3 = new android.widget.AbsListView$LayoutParams
            r3.<init>(r2, r2)
            r9.setLayoutParams(r3)
            r2 = 2131296642(0x7f090182, float:1.8211206E38)
            android.view.View r2 = r9.findViewById(r2)
            com.oppo.camera.ui.LoaddingProgress r2 = (com.oppo.camera.ui.LoaddingProgress) r2
            r3 = 2131296886(0x7f090276, float:1.8211701E38)
            android.view.View r3 = r9.findViewById(r3)
            com.oppo.camera.ui.RotateImageView r3 = (com.oppo.camera.ui.RotateImageView) r3
            r4 = 2131296587(0x7f09014b, float:1.8211095E38)
            android.view.View r4 = r9.findViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            com.oppo.camera.sticker.ui.b r5 = new com.oppo.camera.sticker.ui.b
            r5.<init>(r2, r3, r4)
            r9.setTag(r5)
            goto L_0x006b
        L_0x0064:
            java.lang.Object r2 = r9.getTag()
            r5 = r2
            com.oppo.camera.sticker.ui.b r5 = (com.oppo.camera.sticker.ui.b) r5
        L_0x006b:
            boolean r2 = r7.m
            if (r2 == 0) goto L_0x008a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            r10.append(r8)
            r10.append(r1)
            boolean r8 = r7.m
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            com.oppo.camera.e.b(r8)
            return r9
        L_0x008a:
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> r2 = r7.d
            java.lang.Object r2 = r2.get(r8)
            java.util.Map r2 = (java.util.Map) r2
            java.lang.String r3 = "state_icon"
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> r3 = r7.d
            java.lang.Object r3 = r3.get(r8)
            java.util.Map r3 = (java.util.Map) r3
            java.lang.String r4 = "sticker_item"
            java.lang.Object r3 = r3.get(r4)
            com.oppo.camera.sticker.data.StickerItem r3 = (com.oppo.camera.sticker.data.StickerItem) r3
            android.graphics.drawable.Drawable r4 = r7.h
            if (r4 != 0) goto L_0x00c1
            android.content.Context r4 = r7.f
            android.content.res.Resources r4 = r4.getResources()
            r6 = 2131231969(0x7f0804e1, float:1.8080034E38)
            android.graphics.drawable.Drawable r10 = r4.getDrawable(r6, r10)
            r7.h = r10
        L_0x00c1:
            com.oppo.camera.sticker.ui.c r10 = r7.c
            if (r10 == 0) goto L_0x00f0
            com.oppo.camera.sticker.ui.d r10 = new com.oppo.camera.sticker.ui.d
            r10.<init>()
            r10.a((com.oppo.camera.sticker.ui.b) r5)
            java.lang.String r4 = r3.getStickerUUID()
            r10.a((java.lang.String) r4)
            boolean r4 = r3.isStickerNew()
            r10.a((boolean) r4)
            boolean r4 = r3.hasMusic()
            r10.b(r4)
            r10.a((int) r2)
            com.oppo.camera.sticker.ui.c r2 = r7.c
            java.lang.String r4 = r3.getThumbnailFileUri()
            java.lang.String r6 = "parse_url"
            r2.a((java.lang.String) r4, (java.lang.String) r6, (com.oppo.camera.sticker.ui.d) r10)
        L_0x00f0:
            java.lang.String r10 = r3.getStickerUUID()
            r7.a(r5, r10)
            com.oppo.camera.ui.RotateImageView r10 = r5.f3690b
            if (r10 == 0) goto L_0x011b
            com.oppo.camera.ui.RotateImageView r10 = r5.f3690b
            int r2 = r7.f3688b
            r3 = 1
            r10.a(r2, r3)
            java.lang.String r10 = r7.g
            boolean r10 = com.oppo.camera.sticker.data.StickerCategoryItem.isMyCategory(r10)
            if (r10 == 0) goto L_0x0114
            if (r8 != 0) goto L_0x0114
            com.oppo.camera.ui.RotateImageView r10 = r5.f3690b
            r2 = 0
            r10.setPadding(r2, r2, r2, r2)
            goto L_0x011b
        L_0x0114:
            com.oppo.camera.ui.RotateImageView r10 = r5.f3690b
            int r2 = r7.l
            r10.setPadding(r2, r2, r2, r2)
        L_0x011b:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            r10.append(r8)
            r10.append(r1)
            boolean r8 = r7.m
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            com.oppo.camera.e.b(r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.ui.a.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public void a(boolean z) {
        this.m = z;
    }

    public void a(i iVar) {
        this.f3687a = iVar;
    }

    public void a(List<Map<String, Object>> list) {
        List<Map<String, Object>> list2 = this.d;
        if (list2 != null) {
            list2.clear();
            this.d.addAll(list);
        }
    }

    public void a(int i2, int i3, Drawable drawable, boolean z, StickerItem stickerItem) {
        List<Map<String, Object>> list = this.d;
        if (list != null && i2 < list.size() && i2 >= 0) {
            this.d.get(i2).put("state_icon", Integer.valueOf(i3));
            this.d.get(i2).put("sticker_item", stickerItem);
            if (z) {
                notifyDataSetChanged();
            }
        }
    }

    public void a(c cVar) {
        this.c = cVar;
    }

    public void a(int i2) {
        if (this.f3688b != i2) {
            this.f3688b = i2;
            notifyDataSetChanged();
        }
    }

    public StickerItem b(int i2) {
        List<Map<String, Object>> list = this.d;
        if (list == null || i2 >= list.size()) {
            return null;
        }
        return (StickerItem) this.d.get(i2).get("sticker_item");
    }

    private void a(b bVar, String str) {
        i iVar;
        if (bVar.c != null && (iVar = this.f3687a) != null) {
            if (iVar.e() == null || !str.equals(this.f3687a.e().getStickerUUID())) {
                bVar.c.setVisibility(8);
            } else {
                bVar.c.setVisibility(0);
            }
        }
    }
}
