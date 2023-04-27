package com.oppo.camera.ui.modepanel;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.oppo.camera.R;
import com.oppo.camera.ui.RotateMoreItem;
import com.oppo.camera.util.Util;
import java.util.ArrayList;

/* compiled from: MoreModeAdapter */
public class e extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    private Activity f4303a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f4304b = null;
    /* access modifiers changed from: private */
    public a c = null;
    private int d = 0;
    private int e;

    /* compiled from: MoreModeAdapter */
    public interface a {
        void a(int i);
    }

    public e(Activity activity, int i) {
        this.f4303a = activity;
        this.e = i;
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f4304b == null) {
            this.f4304b = new ArrayList<>();
        }
        this.f4304b.clear();
        this.f4304b.addAll(arrayList);
        this.d = this.e;
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    public void a(int i) {
        int i2 = this.e;
        if (i2 != i) {
            this.d = i2;
            this.e = i;
            notifyDataSetChanged();
        }
    }

    public void b(int i) {
        this.d = i;
        this.e = i;
    }

    /* renamed from: a */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(this.f4303a).inflate(R.layout.more_mode_item, viewGroup, false));
    }

    /* renamed from: a */
    public void onBindViewHolder(b bVar, int i) {
        if (bVar != null && bVar.f4306b != null) {
            bVar.f4306b.setImage(Util.a(this.f4303a.getBaseContext(), this.f4304b.get(i).c()));
            if (-1 == this.f4304b.get(i).d()) {
                bVar.f4306b.setSubscriptHint((Bitmap) null);
            } else if (!bVar.f4306b.a()) {
                boolean z = true;
                if (1 != this.f4303a.getApplicationContext().getResources().getConfiguration().getLayoutDirection()) {
                    z = false;
                }
                bVar.f4306b.setSubscriptHintRTL(z);
                bVar.f4306b.setSubscriptHint(BitmapFactory.decodeResource(this.f4303a.getResources(), this.f4304b.get(i).d()));
            }
            bVar.f4306b.setText(this.f4304b.get(i).a());
            bVar.f4306b.a(this.d, this.e);
        }
    }

    public int getItemCount() {
        ArrayList<a> arrayList = this.f4304b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* compiled from: MoreModeAdapter */
    protected class b extends RecyclerView.w implements View.OnClickListener {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public RotateMoreItem f4306b;

        public b(View view) {
            super(view);
            this.f4306b = (RotateMoreItem) view.findViewById(R.id.more_item);
            view.setOnClickListener(this);
        }

        public void onClick(View view) {
            e.this.c.a(((a) e.this.f4304b.get(getPosition())).b());
        }
    }
}
