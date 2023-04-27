package com.color.support.preference;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.b;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.g;
import androidx.recyclerview.widget.RecyclerView;
import color.support.v7.appcompat.R;

/* compiled from: ColorPreferenceFragment */
public class e extends g {
    public void a(Bundle bundle, String str) {
    }

    public RecyclerView a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RecyclerView recyclerView = (RecyclerView) layoutInflater.inflate(R.layout.color_preference_recyclerview, viewGroup, false);
        recyclerView.setLayoutManager(f());
        return recyclerView;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        a((Drawable) null);
        a(0);
        return onCreateView;
    }

    public void b(Preference preference) {
        b bVar;
        if (getFragmentManager().a("androidx.preference.PreferenceFragment.DIALOG") == null) {
            if (preference instanceof ColorActivityDialogPreference) {
                bVar = a.b(preference.B());
            } else if (preference instanceof ColorEditTextPreference) {
                bVar = b.b(preference.B());
            } else if (preference instanceof ColorMultiSelectListPreference) {
                bVar = d.b(preference.B());
            } else if (preference instanceof ListPreference) {
                bVar = c.b(preference.B());
            } else {
                super.b(preference);
                return;
            }
            bVar.setTargetFragment(this, 0);
            bVar.show(getFragmentManager(), "androidx.preference.PreferenceFragment.DIALOG");
        }
    }
}
