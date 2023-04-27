package com.color.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.SearchView;
import java.lang.reflect.Field;

public class ColorSearchView extends SearchView {
    private SearchView.SearchAutoComplete k;
    private boolean l = true;

    public ColorSearchView(Context context) {
        super(context);
    }

    public ColorSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ColorSearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SearchView.SearchAutoComplete getSearchAutoComplete() {
        SearchView.SearchAutoComplete searchAutoComplete = this.k;
        if (searchAutoComplete != null) {
            return searchAutoComplete;
        }
        try {
            Field declaredField = Class.forName("androidx.appcompat.widget.SearchView").getDeclaredField("mSearchSrcTextView");
            declaredField.setAccessible(true);
            this.k = (SearchView.SearchAutoComplete) declaredField.get(this);
            return this.k;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
