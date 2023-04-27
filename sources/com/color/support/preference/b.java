package com.color.support.preference;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.c;
import androidx.preference.a;
import color.support.v7.appcompat.R;
import color.support.v7.widget.Toolbar;
import com.color.support.widget.ColorEditText;

/* compiled from: ColorEditTextPreferenceDialogFragment */
public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private ColorEditText f1992a;

    public static b b(String str) {
        b bVar = new b();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        bVar.setArguments(bundle);
        return bVar;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        c activity = getActivity();
        final com.color.support.dialog.panel.b bVar = new com.color.support.dialog.panel.b(getActivity(), R.style.DefaultBottomSheetDialog);
        View a2 = a((Context) activity);
        this.f1992a = (ColorEditText) a2.findViewById(16908291);
        Toolbar toolbar = (Toolbar) a2.findViewById(R.id.normal_bottom_sheet_toolbar);
        toolbar.setTitle(b().a());
        toolbar.setIsTitleCenterStyle(true);
        toolbar.inflateMenu(R.menu.edit_text_preference_dialog_menu);
        MenuItem findItem = toolbar.getMenu().findItem(R.id.menu_cancel);
        final MenuItem findItem2 = toolbar.getMenu().findItem(R.id.menu_save);
        findItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                b.this.onClick(bVar, -2);
                bVar.dismiss();
                return true;
            }
        });
        findItem2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                b.this.onClick(bVar, -1);
                bVar.dismiss();
                return true;
            }
        });
        this.f1992a.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                findItem2.setEnabled(!TextUtils.isEmpty(editable));
            }
        });
        if (a2 != null) {
            a(a2);
            bVar.setContentView(a2);
        }
        return bVar;
    }

    public void onResume() {
        super.onResume();
        ColorEditText colorEditText = this.f1992a;
        if (colorEditText != null) {
            colorEditText.setFocusable(true);
            this.f1992a.requestFocus();
            if (getDialog() != null) {
                getDialog().getWindow().setSoftInputMode(5);
            }
        }
    }
}
