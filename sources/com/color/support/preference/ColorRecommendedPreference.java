package com.color.support.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.l;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import color.support.v7.appcompat.R;
import java.util.ArrayList;
import java.util.List;

public class ColorRecommendedPreference extends Preference {

    /* renamed from: a  reason: collision with root package name */
    private List<c> f1951a;

    /* renamed from: b  reason: collision with root package name */
    private float f1952b;
    private int c;
    private f d;
    private String e;

    public interface a {
        void a(View view);
    }

    public ColorRecommendedPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.colorRecommendedPreferenceStyle);
    }

    public ColorRecommendedPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ColorRecommendedPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        a(R.layout.color_recommended_preference_layout);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorRecommendedPreference, i, 0);
        this.f1952b = obtainStyledAttributes.getDimension(R.styleable.ColorRecommendedPreference_recommendedCardBgRadius, J().getResources().getDimension(R.dimen.recommended_preference_list_card_radius));
        this.c = obtainStyledAttributes.getColor(R.styleable.ColorRecommendedPreference_recommendedCardBgColor, J().getResources().getColor(R.color.bottom_recommended_recycler_view_bg));
        this.d = new f(this.f1952b, this.c);
        this.e = obtainStyledAttributes.getString(R.styleable.ColorRecommendedPreference_recommendedHeaderTitle);
        if (this.e == null) {
            this.e = J().getResources().getString(R.string.bottom_recommended_header_title);
        }
        obtainStyledAttributes.recycle();
    }

    public void a(l lVar) {
        super.a(lVar);
        RecyclerView recyclerView = (RecyclerView) lVar.itemView;
        recyclerView.setBackground(this.d);
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            recyclerView.setHasFixedSize(true);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setLayoutManager(new LinearLayoutManager(J()));
            recyclerView.setAdapter(new b(J(), this.f1951a, this.e));
            return;
        }
        ((b) adapter).a(this.f1951a, this.e);
    }

    private static class b extends RecyclerView.a<d> {

        /* renamed from: a  reason: collision with root package name */
        private Context f1953a;

        /* renamed from: b  reason: collision with root package name */
        private List<c> f1954b = new ArrayList();

        public int getItemViewType(int i) {
            return i == 0 ? 0 : 1;
        }

        public b(Context context, List<c> list, String str) {
            this.f1953a = context;
            a(list, str);
        }

        public void a(List<c> list, String str) {
            this.f1954b.clear();
            if (list != null) {
                this.f1954b.addAll(list);
                this.f1954b.add(0, new c(str));
            }
            notifyDataSetChanged();
        }

        /* renamed from: a */
        public d onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recommended_head_textview, viewGroup, false));
            }
            return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recommended_common_textview, viewGroup, false));
        }

        /* renamed from: a */
        public void onBindViewHolder(d dVar, int i) {
            final c cVar = this.f1954b.get(i);
            TextView a2 = dVar.f1959a;
            a2.setText(cVar.f1957a);
            if (i > 0) {
                a2.setBackground(this.f1953a.getDrawable(R.drawable.recommended_text_ripple_bg));
                a2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (cVar.f1958b != null) {
                            cVar.f1958b.a(view);
                        }
                    }
                });
            }
        }

        public int getItemCount() {
            return this.f1954b.size();
        }
    }

    public static class c {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f1957a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public a f1958b;

        public c(String str) {
            this.f1957a = str;
        }
    }

    private static class d extends RecyclerView.w {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public TextView f1959a;

        public d(View view) {
            super(view);
            this.f1959a = (TextView) view;
        }
    }
}
