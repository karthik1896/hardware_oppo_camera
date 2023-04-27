package com.oppo.camera.sticker.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.a;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.sticker.data.StickerItem;
import com.oppo.camera.ui.preview.a.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: StickerPageAdapter */
public class j extends a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<StickerGridViewLayout> f3734a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f3735b = 0;
    private int c = 0;
    private Activity d = null;
    private i e = null;
    private c f = null;

    public boolean a(View view, Object obj) {
        return view == obj;
    }

    public j(Activity activity, int i, StickerItem stickerItem, i iVar, c cVar) {
        this.f3735b = i;
        this.d = activity;
        this.e = iVar;
        this.f = cVar;
        a(stickerItem, true);
    }

    public void c(int i) {
        this.c = i;
    }

    public int d() {
        return this.c;
    }

    public void d(int i) {
        this.f3735b = i;
        ArrayList<StickerGridViewLayout> arrayList = this.f3734a;
        if (arrayList != null) {
            Iterator<StickerGridViewLayout> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().setOrientation(this.f3735b);
            }
        }
    }

    public void a(boolean z) {
        ArrayList<StickerGridViewLayout> arrayList = this.f3734a;
        if (arrayList != null) {
            Iterator<StickerGridViewLayout> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().setGridViewEnable(z);
            }
        }
    }

    public void a(String str, int i, int i2, Drawable drawable, boolean z, StickerItem stickerItem) {
        ArrayList<StickerGridViewLayout> arrayList = this.f3734a;
        if (arrayList != null && !arrayList.isEmpty()) {
            final StickerGridViewLayout b2 = b(str);
            Activity activity = this.d;
            if (activity != null && b2 != null) {
                final int i3 = i;
                final int i4 = i2;
                final Drawable drawable2 = drawable;
                final boolean z2 = z;
                final StickerItem stickerItem2 = stickerItem;
                activity.runOnUiThread(new Runnable() {
                    public void run() {
                        b2.a(i3, i4, drawable2, z2, stickerItem2);
                    }
                });
            }
        }
    }

    public int a() {
        ArrayList<StickerGridViewLayout> arrayList = this.f3734a;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public Object a(ViewGroup viewGroup, int i) {
        StickerGridViewLayout stickerGridViewLayout = this.f3734a.get(i);
        if (stickerGridViewLayout != null) {
            if (viewGroup.indexOfChild(stickerGridViewLayout) == -1) {
                viewGroup.addView(this.f3734a.get(i));
            }
            stickerGridViewLayout.setStickerMenuListener(this.e);
            stickerGridViewLayout.setImageDownloader(this.f);
        }
        return stickerGridViewLayout;
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        StickerGridViewLayout stickerGridViewLayout = this.f3734a.get(i);
        if (stickerGridViewLayout != null && viewGroup.indexOfChild(stickerGridViewLayout) != -1) {
            viewGroup.removeView(stickerGridViewLayout);
        }
    }

    public void a(String str) {
        StickerGridViewLayout b2;
        ArrayList<StickerGridViewLayout> arrayList = this.f3734a;
        if (arrayList != null && !arrayList.isEmpty() && (b2 = b(str)) != null) {
            b2.a();
        }
    }

    public void a(String str, boolean z) {
        StickerGridViewLayout b2;
        ArrayList<StickerGridViewLayout> arrayList = this.f3734a;
        if (!(arrayList == null || arrayList.isEmpty() || (b2 = b(str)) == null)) {
            b2.a();
        }
        if (z) {
            c();
        }
    }

    public void a(StickerItem stickerItem, boolean z) {
        e.a("makeGridView");
        l.c b2 = l.b((Context) this.d).b();
        CopyOnWriteArrayList<l.a> b3 = b2.b();
        if (b3 != null && b3.size() > 0) {
            if (this.f3734a == null) {
                this.f3734a = new ArrayList<>();
            }
            Iterator<l.a> it = b3.iterator();
            while (it.hasNext()) {
                l.a next = it.next();
                ArrayList arrayList = new ArrayList();
                Iterator<StickerItem> it2 = next.a().iterator();
                while (it2.hasNext()) {
                    StickerItem next2 = it2.next();
                    HashMap hashMap = new HashMap();
                    hashMap.put("state_icon", Integer.valueOf(next2.getDownloadState()));
                    hashMap.put("sticker_item", next2);
                    arrayList.add(hashMap);
                }
                StickerGridViewLayout b4 = b(next.b());
                String str = null;
                if (b4 == null) {
                    int i = -1;
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    StickerGridViewLayout stickerGridViewLayout = (StickerGridViewLayout) LayoutInflater.from(this.d).inflate(R.layout.sticker_menu_grid_item, (ViewGroup) null);
                    stickerGridViewLayout.setLayoutParams(layoutParams);
                    stickerGridViewLayout.setTag(next.b());
                    Integer e2 = b2.e(next.b());
                    if (e2 != null) {
                        i = e2.intValue();
                    }
                    if (i < 0 || i >= this.f3734a.size()) {
                        this.f3734a.add(stickerGridViewLayout);
                    } else {
                        this.f3734a.add(i, stickerGridViewLayout);
                    }
                    b4 = stickerGridViewLayout;
                }
                if (stickerItem != null) {
                    str = stickerItem.getCategoryId();
                }
                b4.a(arrayList, this.f3735b, next.b().equals(str));
            }
            if (z) {
                c();
            }
        }
        e.b("makeGridView");
    }

    private StickerGridViewLayout b(String str) {
        ArrayList<StickerGridViewLayout> arrayList = this.f3734a;
        if (!(arrayList == null || arrayList.isEmpty() || str == null)) {
            Integer e2 = l.b((Context) this.d).b().e(str);
            int intValue = e2 != null ? e2.intValue() : -1;
            if (intValue >= 0 && intValue < this.f3734a.size()) {
                return this.f3734a.get(intValue);
            }
        }
        return null;
    }
}
