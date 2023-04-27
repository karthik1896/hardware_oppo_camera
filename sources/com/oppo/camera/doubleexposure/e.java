package com.oppo.camera.doubleexposure;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.oppo.camera.R;
import com.oppo.camera.ui.widget.RoundRingImageView;
import java.util.List;

/* compiled from: EffectMenuAdapter */
public class e extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f2815a = null;

    /* renamed from: b  reason: collision with root package name */
    private List<f> f2816b = null;
    /* access modifiers changed from: private */
    public f c = null;
    /* access modifiers changed from: private */
    public b d = null;

    /* compiled from: EffectMenuAdapter */
    public interface b {
        void a(f fVar);
    }

    public e(Context context, List<f> list) {
        this.f2815a = context;
        this.f2816b = list;
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    /* renamed from: a */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        a aVar = new a(LayoutInflater.from(this.f2815a).inflate(R.layout.item_effect_menu, (ViewGroup) null, false));
        aVar.setIsRecyclable(false);
        return aVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i) {
        final f fVar = this.f2816b.get(i);
        aVar.f2819a.setBitmap(BitmapFactory.decodeResource(this.f2815a.getResources(), fVar.b()));
        aVar.f2819a.setParam(fVar);
        if (fVar.d()) {
            this.c = fVar;
        }
        aVar.f2819a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!fVar.d()) {
                    fVar.a(true);
                    if (e.this.c != null) {
                        e.this.c.a(false);
                    }
                    f unused = e.this.c = fVar;
                    e.this.notifyDataSetChanged();
                    if (e.this.d != null) {
                        e.this.d.a(fVar);
                    }
                }
            }
        });
    }

    public int getItemCount() {
        List<f> list = this.f2816b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* compiled from: EffectMenuAdapter */
    public static class a extends RecyclerView.w {

        /* renamed from: a  reason: collision with root package name */
        RoundRingImageView f2819a;

        public a(View view) {
            super(view);
            this.f2819a = (RoundRingImageView) view.findViewById(R.id.bgIv);
        }
    }
}
