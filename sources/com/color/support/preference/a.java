package com.color.support.preference;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.app.f;
import androidx.core.g.v;
import androidx.preference.c;
import color.support.design.widget.ColorAppBarLayout;
import color.support.v7.appcompat.R;
import color.support.v7.widget.Toolbar;
import com.color.support.d.d;
import com.color.support.d.g;
import com.oppo.exif.OppoExifTag;

/* compiled from: ColorActivityDialogFragment */
public class a extends c {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public f f1983b;
    /* access modifiers changed from: private */
    public int c;

    public static a b(String str) {
        a aVar = new a();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        aVar.setArguments(bundle);
        return aVar;
    }

    private ColorActivityDialogPreference c() {
        return (ColorActivityDialogPreference) b();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int i;
        this.c = c().b(c().o());
        final AnonymousClass1 r13 = new f(getActivity(), R.style.Theme_ColorSupport_ActivityDialog) {
            public boolean onMenuItemSelected(int i, MenuItem menuItem) {
                if (menuItem.getItemId() != 16908332) {
                    return super.onMenuItemSelected(i, menuItem);
                }
                dismiss();
                return true;
            }
        };
        this.f1983b = r13;
        if (r13.getWindow() != null) {
            Window window = r13.getWindow();
            View decorView = window.getDecorView();
            if (Build.VERSION.SDK_INT >= 21) {
                decorView.setSystemUiVisibility(1024);
                window.setStatusBarColor(0);
                window.setNavigationBarColor(getResources().getColor(R.color.color_dialog_fragment_navigation_bar_color));
            }
            int systemUiVisibility = decorView.getSystemUiVisibility();
            int a2 = g.a();
            boolean z = getResources().getBoolean(R.bool.list_status_white_enabled);
            if (a2 >= 6 || a2 == 0) {
                window.addFlags(Integer.MIN_VALUE);
                if (d.a(r13.getContext())) {
                    i = systemUiVisibility & -8193 & -17;
                } else {
                    i = Build.VERSION.SDK_INT >= 23 ? !z ? systemUiVisibility | OppoExifTag.EXIF_TAG_SUPER_HIGH_RESOLUTION : systemUiVisibility | 256 : systemUiVisibility | 16;
                }
                decorView.setSystemUiVisibility(i);
            }
        }
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.color_preference_listview, (ViewGroup) null);
        Toolbar toolbar = (Toolbar) inflate.findViewById(R.id.toolbar);
        toolbar.setTitle(c().a());
        toolbar.setNavigationIcon(androidx.core.content.a.a(toolbar.getContext(), R.drawable.color_back_arrow));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a.this.f1983b.dismiss();
            }
        });
        final ColorAppBarLayout colorAppBarLayout = (ColorAppBarLayout) inflate.findViewById(R.id.abl);
        final ListView listView = (ListView) inflate.findViewById(R.id.color_preference_listview);
        View findViewById = inflate.findViewById(R.id.divider_line);
        if (getResources().getBoolean(R.bool.is_dialog_preference_immersive)) {
            findViewById.setVisibility(8);
        }
        v.c((View) listView, true);
        View c2 = c(colorAppBarLayout.getContext());
        colorAppBarLayout.addView(c2, 0, c2.getLayoutParams());
        colorAppBarLayout.post(new Runnable() {
            public void run() {
                int measuredHeight = colorAppBarLayout.getMeasuredHeight() + a.this.getResources().getDimensionPixelSize(R.dimen.support_preference_listview_margin_top);
                View view = new View(colorAppBarLayout.getContext());
                view.setVisibility(4);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, measuredHeight));
                listView.addHeaderView(view);
            }
        });
        final ListView listView2 = listView;
        listView.setAdapter(new C0056a(getActivity(), R.layout.color_preference_listview_item, R.id.checkedtextview, c().l()) {
            public View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                if (i == a.this.c) {
                    ListView listView = listView2;
                    listView.setItemChecked(listView.getHeaderViewsCount() + i, true);
                }
                View findViewById = view2.findViewById(R.id.coloritemdiver);
                int count = getCount();
                if (findViewById != null) {
                    if (count == 1 || i == count - 1) {
                        findViewById.setVisibility(8);
                    } else {
                        findViewById.setBackgroundResource(R.drawable.color_divider_preference_default);
                    }
                }
                return view2;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int unused = a.this.c = i - listView.getHeaderViewsCount();
                a.this.onClick((DialogInterface) null, -1);
                r13.dismiss();
            }
        });
        listView.setChoiceMode(1);
        r13.setContentView(inflate);
        return r13;
    }

    private View c(Context context) {
        int b2 = b(context);
        ImageView imageView = new ImageView(context);
        imageView.setBackground(getResources().getDrawable(R.drawable.color_list_statusbar_bg));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, b2));
        return imageView;
    }

    /* renamed from: com.color.support.preference.a$a  reason: collision with other inner class name */
    /* compiled from: ColorActivityDialogFragment */
    private static class C0056a extends ArrayAdapter<CharSequence> {
        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }

        C0056a(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }
    }

    public static int b(Context context) {
        int identifier = context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            try {
                return context.getApplicationContext().getResources().getDimensionPixelSize(identifier);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public void a(boolean z) {
        ColorActivityDialogPreference c2 = c();
        if (z && this.c >= 0) {
            String charSequence = c().m()[this.c].toString();
            if (c2.b((Object) charSequence)) {
                c2.a(charSequence);
            }
        }
    }
}
