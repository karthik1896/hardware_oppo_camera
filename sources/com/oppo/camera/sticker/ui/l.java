package com.oppo.camera.sticker.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckedTextView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.Toolbar;
import color.support.v7.app.b;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.sticker.data.StickerItem;
import com.oppo.camera.sticker.g;
import com.oppo.camera.sticker.h;
import com.oppo.camera.sticker.ui.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: StickerRecycleBinDialog */
public class l extends Dialog implements Toolbar.c, k.a {

    /* renamed from: a  reason: collision with root package name */
    private FooterGridView f3742a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public k f3743b = null;
    /* access modifiers changed from: private */
    public a c = null;
    private Context d = null;
    private color.support.v7.widget.Toolbar e = null;
    /* access modifiers changed from: private */
    public b f = null;

    /* compiled from: StickerRecycleBinDialog */
    public interface a {
        void a();

        void a(int i, boolean z);

        void b(int i, boolean z);
    }

    public l(Context context) {
        super(context, R.style.StickerRecycleDialogStyle);
        this.d = context;
    }

    public boolean a(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.sticker_cancel) {
            dismiss();
            return true;
        } else if (itemId != R.id.sticker_select_all) {
            return true;
        } else {
            if (f()) {
                this.f3743b.b();
                return true;
            }
            this.f3743b.a();
            this.c.a();
            return true;
        }
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(getContext().getColor(R.color.sticker_recycle_bin_background_color));
        getWindow().setUiOptions(1);
        setContentView(R.layout.editor_sticker_recycle_bin_layout);
        getWindow().setNavigationBarColor(0);
        d();
    }

    private void d() {
        this.e = (color.support.v7.widget.Toolbar) findViewById(R.id.sticker_recycle_toolbar);
        color.support.v7.widget.Toolbar toolbar = this.e;
        if (toolbar != null) {
            toolbar.showOverflowMenu();
            this.e.setIsTitleCenterStyle(true);
            this.e.setDividerColor(getContext().getColor(R.color.sticker_recycle_bin_split_bar_color));
            this.e.setBottomDividerBackground(getContext().getColor(R.color.sticker_recycle_bin_background_color));
            this.e.inflateMenu(R.menu.sticker_menu);
            this.e.setTitle((int) R.string.sticker_recycle_bin_title_select);
            this.e.setTitleTextColor(getContext().getColor(R.color.sticker_recycle_bin_title_text_color));
            this.e.setOnMenuItemClickListener(this);
        }
        this.f3742a = (FooterGridView) findViewById(R.id.sticker_recycle_bin_grid_view);
        this.f3743b = new k(getContext(), g.a(getContext(), 1), true);
        this.f3743b.a((k.a) this);
        FooterGridView footerGridView = this.f3742a;
        if (footerGridView != null) {
            footerGridView.setDrawForeground(false);
            this.f3742a.setAdapter(this.f3743b);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(getContext()).inflate(R.menu.sticker_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void a() {
        int i;
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R.id.delete_sticker);
        if (checkedTextView != null) {
            checkedTextView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    l.this.g();
                }
            });
            k kVar = this.f3743b;
            if (kVar == null || kVar.d() != 0) {
                checkedTextView.setClickable(true);
                checkedTextView.setChecked(true);
                checkedTextView.setTextColor(-1);
            } else {
                checkedTextView.setClickable(false);
                checkedTextView.setChecked(false);
                checkedTextView.setTextColor(getContext().getColor(R.color.sticker_recycle_bin_unchecked_color));
            }
        }
        androidx.appcompat.view.menu.b bVar = (androidx.appcompat.view.menu.b) this.e.findViewById(R.id.sticker_select_all);
        androidx.appcompat.view.menu.b bVar2 = (androidx.appcompat.view.menu.b) this.e.findViewById(R.id.sticker_cancel);
        if (bVar2 != null) {
            bVar2.setTextColor(getContext().getColor(R.color.sticker_recycle_bin_title_text_color));
        }
        if (bVar != null) {
            j itemData = bVar.getItemData();
            if (f()) {
                if (itemData != null) {
                    itemData.setTitle((int) R.string.sticker_recycle_bin_unselect_all);
                } else {
                    bVar.setTitle(getContext().getString(R.string.sticker_recycle_bin_unselect_all));
                }
            } else if (itemData != null) {
                itemData.setTitle((int) R.string.sticker_recycle_bin_select_all);
            } else {
                bVar.setTitle(getContext().getString(R.string.sticker_recycle_bin_select_all));
            }
            bVar.setClickable(e());
            if (e()) {
                i = getContext().getColor(R.color.sticker_recycle_bin_title_text_color);
            } else {
                i = getContext().getColor(R.color.sticker_recycle_bin_unchecked_color);
            }
            bVar.setTextColor(i);
        }
    }

    private boolean e() {
        k kVar = this.f3743b;
        return kVar != null && kVar.getCount() > 0;
    }

    private boolean f() {
        k kVar = this.f3743b;
        return kVar != null && kVar.c();
    }

    public void b() {
        b bVar = this.f;
        if (bVar == null || !bVar.isShowing()) {
            this.f = null;
        } else {
            this.f.cancel();
            this.f = null;
            g();
        }
        a();
    }

    /* access modifiers changed from: private */
    public void g() {
        if (this.f == null) {
            this.f = new b.a(getContext()).f(1).setNeutralButton((int) R.string.sticker_recycle_bin_delete_sticker, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    l.this.h();
                    b unused = l.this.f = null;
                }
            }).setNegativeButton((int) R.string.sticker_recycle_bin_cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (!(l.this.f3743b == null || l.this.c == null)) {
                        l.this.c.b(l.this.f3743b.e().size(), l.this.f3743b.c());
                    }
                    b unused = l.this.f = null;
                }
            }).create();
        }
        if (!this.f.isShowing()) {
            this.f.show();
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        k kVar = this.f3743b;
        if (kVar != null) {
            Map<String, StickerItem> e2 = kVar.e();
            if (e2.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (StickerItem add : e2.values()) {
                    arrayList.add(add);
                }
                h.a(this.d).a((List<StickerItem>) arrayList);
                a aVar = this.c;
                if (aVar != null) {
                    aVar.a(arrayList.size(), this.f3743b.c());
                    return;
                }
                return;
            }
            e.d("StickerRecycleBinDialog", "deleteSelectedStickers, size is 0!");
        }
    }

    public void dismiss() {
        b bVar = this.f;
        if (bVar != null) {
            bVar.dismiss();
        }
        k kVar = this.f3743b;
        if (kVar != null) {
            kVar.f();
        }
        b bVar2 = this.f;
        if (bVar2 != null) {
            bVar2.cancel();
            this.f = null;
        }
        super.dismiss();
    }

    public void a(k kVar) {
        if (kVar != null) {
            int d2 = kVar.d();
            String string = getContext().getString(R.string.sticker_recycle_bin_title_select);
            if (d2 > 0) {
                string = getContext().getResources().getQuantityString(R.plurals.sticker_recycle_bin_title_has_selected, d2, new Object[]{Integer.valueOf(d2)});
            }
            this.e.setTitle((CharSequence) string);
            a();
        }
    }

    public void a(StickerItem stickerItem) {
        if (stickerItem != null && isShowing()) {
            k kVar = this.f3743b;
            if (kVar != null && kVar.getCount() == 0) {
                dismiss();
            }
            k kVar2 = this.f3743b;
            if (kVar2 != null) {
                kVar2.a(stickerItem);
            }
        }
    }

    public void c() {
        b bVar = this.f;
        if (bVar != null) {
            bVar.cancel();
            this.f = null;
        }
    }
}
