package com.color.support.dialog.panel;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.b;
import androidx.recyclerview.widget.ColorRecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import color.support.v7.appcompat.R;
import color.support.v7.widget.Toolbar;
import com.color.support.dialog.panel.a;

/* compiled from: ColorListBottomSheetDialog */
public class c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public b f1925a;

    /* compiled from: ColorListBottomSheetDialog */
    public interface b {
        void a();

        void b();
    }

    /* compiled from: ColorListBottomSheetDialog */
    public static class a extends b.a {

        /* renamed from: a  reason: collision with root package name */
        public boolean[] f1926a;

        /* renamed from: b  reason: collision with root package name */
        public int f1927b = -1;
        public b c;
        public DialogInterface.OnMultiChoiceClickListener d;
        public DialogInterface.OnClickListener e;
        /* access modifiers changed from: private */
        public c f = new c();
        private View g;
        private CharSequence h;
        private Context i;
        private CharSequence[] j;
        private CharSequence[] k;
        /* access modifiers changed from: private */
        public boolean l = false;
        private boolean m;
        private int n;

        public a(Context context) {
            super(context);
            a(context);
        }

        private void a(Context context) {
            this.i = context;
            this.g = LayoutInflater.from(this.i).inflate(R.layout.color_list_bottom_sheet_dialog_layout, (ViewGroup) null);
        }

        public Dialog a() {
            return this.f.f1925a;
        }

        /* renamed from: a */
        public a setTitle(CharSequence charSequence) {
            this.h = charSequence;
            return this;
        }

        /* renamed from: a */
        public a setTitle(int i2) {
            this.h = this.i.getString(i2);
            return this;
        }

        public a a(CharSequence[] charSequenceArr) {
            this.k = charSequenceArr;
            return this;
        }

        /* renamed from: a */
        public a setMultiChoiceItems(int i2, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.j = this.i.getResources().getTextArray(i2);
            this.f1926a = zArr;
            this.l = true;
            this.d = onMultiChoiceClickListener;
            return this;
        }

        /* renamed from: a */
        public a setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            this.j = charSequenceArr;
            this.f1926a = zArr;
            this.l = true;
            this.d = onMultiChoiceClickListener;
            return this;
        }

        /* renamed from: a */
        public a setSingleChoiceItems(int i2, int i3, DialogInterface.OnClickListener onClickListener) {
            this.j = this.i.getResources().getTextArray(i2);
            this.e = onClickListener;
            this.f1927b = i3;
            this.l = false;
            return this;
        }

        /* renamed from: a */
        public a setSingleChoiceItems(CharSequence[] charSequenceArr, int i2, DialogInterface.OnClickListener onClickListener) {
            this.j = charSequenceArr;
            this.e = onClickListener;
            this.f1927b = i2;
            this.l = false;
            return this;
        }

        public a a(b bVar) {
            this.c = bVar;
            return this;
        }

        public c b() {
            a aVar;
            b unused = this.f.f1925a = new b(this.i, R.style.DefaultBottomSheetDialog);
            this.f.f1925a.setContentView(this.g);
            this.f.f1925a.a(this.m);
            this.f.f1925a.a(this.n);
            ColorRecyclerView colorRecyclerView = (ColorRecyclerView) this.f.f1925a.findViewById(R.id.select_dialog_listview);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.i);
            linearLayoutManager.setOrientation(1);
            colorRecyclerView.setLayoutManager(linearLayoutManager);
            colorRecyclerView.setItemAnimator((RecyclerView.f) null);
            Toolbar toolbar = (Toolbar) this.f.f1925a.findViewById(R.id.toolbar);
            toolbar.setTitle(this.h);
            toolbar.setIsTitleCenterStyle(true);
            if (this.l) {
                toolbar.inflateMenu(R.menu.edit_text_preference_dialog_menu);
                MenuItem findItem = toolbar.getMenu().findItem(R.id.menu_save);
                toolbar.getMenu().findItem(R.id.menu_cancel).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (a.this.c == null) {
                            return true;
                        }
                        a.this.c.b();
                        return true;
                    }
                });
                findItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (a.this.c == null) {
                            return true;
                        }
                        a.this.c.a();
                        return true;
                    }
                });
                aVar = new a(this.i, R.layout.oppo_select_dialog_multichoice, this.j, this.k, -1, this.f1926a, true);
            } else {
                aVar = new a(this.i, R.layout.oppo_select_dialog_singlechoice, this.j, this.k, this.f1927b);
            }
            colorRecyclerView.setAdapter(aVar);
            aVar.a((a.C0055a) new a.C0055a() {
                public void a(View view, int i, int i2) {
                    if (a.this.l) {
                        if (a.this.d != null) {
                            a.this.d.onClick(a.this.f.f1925a, i, i2 == 2);
                        }
                    } else if (a.this.e != null) {
                        a.this.e.onClick(a.this.f.f1925a, i);
                    }
                }
            });
            return this.f;
        }
    }

    public void a() {
        b bVar = this.f1925a;
        if (bVar != null) {
            bVar.dismiss();
        }
    }
}
