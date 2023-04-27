package com.oppo.camera.ui.menu.a;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.oppo.camera.R;
import com.oppo.camera.ui.inverse.InverseImageView;
import com.oppo.camera.ui.inverse.InverseTextView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FaceBeautyAdapter */
abstract class c extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private int f4049a;

    /* renamed from: b  reason: collision with root package name */
    private Rect f4050b;
    private Context c;
    private List<b> d;
    /* access modifiers changed from: private */
    public b e;

    /* compiled from: FaceBeautyAdapter */
    interface b {
        void a(View view, int i);

        boolean a();
    }

    public abstract int a(int i);

    public c(Context context) {
        this.f4049a = -1;
        this.f4050b = new Rect();
        this.c = null;
        this.d = null;
        this.e = null;
        this.d = new ArrayList();
        this.c = context;
    }

    public void a(b bVar) {
        this.e = bVar;
    }

    public void a(List<b> list) {
        this.f4049a = -1;
        if (!this.d.isEmpty()) {
            this.d.clear();
            notifyDataSetChanged();
        }
        this.d.addAll(list);
        notifyDataSetChanged();
    }

    public void b(int i) {
        int i2 = this.f4049a;
        if (i2 != i) {
            this.f4049a = i;
            if (i2 >= 0) {
                notifyItemChanged(i2);
            }
            if (i >= 0) {
                notifyItemChanged(i);
            }
        }
    }

    /* renamed from: a */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.c).inflate(a(i), viewGroup, false));
    }

    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        b c2 = c(i);
        if (c2 != null) {
            boolean z = i == this.f4049a;
            InverseTextView inverseTextView = (InverseTextView) aVar.a(R.id.tv_face_beauty_custom_item);
            if (inverseTextView != null && c2.a() > 0) {
                String string = this.c.getString(c2.a());
                inverseTextView.getPaint().getTextBounds(string, 0, string.length(), this.f4050b);
                inverseTextView.setText(string);
                com.oppo.camera.ui.inverse.c.INS.registerInverse(this.c, inverseTextView);
                inverseTextView.setSelected(z);
                inverseTextView.setTextColor(this.c.getColorStateList(R.color.face_beauty_text_color));
                if (inverseTextView.getTextSize() < ((float) this.f4050b.height())) {
                    inverseTextView.setMaxLines(1);
                } else {
                    inverseTextView.setMaxLines(3);
                }
            }
            InverseImageView inverseImageView = (InverseImageView) aVar.a(R.id.iv_face_beauty_custom_item);
            com.oppo.camera.ui.inverse.c.INS.registerInverse(this.c, inverseImageView);
            if (inverseImageView != null && c2.b() > 0) {
                inverseImageView.setSelected(z);
                inverseImageView.setImageResource(c2.b());
            }
        }
    }

    public int getItemCount() {
        List<b> list = this.d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public b c(int i) {
        if (i < 0 || i > getItemCount()) {
            return null;
        }
        return this.d.get(i);
    }

    public int a() {
        return this.f4049a;
    }

    /* compiled from: FaceBeautyAdapter */
    public class a extends RecyclerView.w implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        private SparseArray<View> f4052b = new SparseArray<>();

        public a(View view) {
            super(view);
            view.setOnClickListener(this);
        }

        public final View a(int i) {
            View view = this.f4052b.get(i);
            if (view != null) {
                return view;
            }
            View findViewById = this.itemView.findViewById(i);
            this.f4052b.put(i, findViewById);
            return findViewById;
        }

        public void onClick(View view) {
            if (c.this.e != null && c.this.e.a()) {
                c.this.e.a(view, getPosition());
            }
        }
    }
}
