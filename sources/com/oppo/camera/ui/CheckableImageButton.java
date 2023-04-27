package com.oppo.camera.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.oppo.camera.R;

public class CheckableImageButton extends ImageView implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private boolean f3788a = false;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f3789b = null;
    private Drawable c = null;
    private a d = null;
    private b e = null;

    public interface a {
        void a(CheckableImageButton checkableImageButton, boolean z);
    }

    public interface b {
        void a(View view);
    }

    public CheckableImageButton(Context context) {
        super(context);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    /* JADX INFO: finally extract failed */
    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CheckableImageButton);
        try {
            this.f3788a = obtainStyledAttributes.getBoolean(0, false);
            int resourceId = obtainStyledAttributes.getResourceId(1, 0);
            int resourceId2 = obtainStyledAttributes.getResourceId(2, 0);
            this.f3789b = context.getResources().getDrawable(resourceId);
            this.c = context.getResources().getDrawable(resourceId2);
            obtainStyledAttributes.recycle();
            a();
            setOnClickListener(this);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void setChecked(boolean z) {
        this.f3788a = z;
        a();
    }

    public void onClick(View view) {
        setChecked(!this.f3788a);
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(this, this.f3788a);
        }
        b bVar = this.e;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public void setOnCheckedChangeListener(a aVar) {
        this.d = aVar;
    }

    public void setOnClickListener(b bVar) {
        this.e = bVar;
    }

    private void a() {
        setImageDrawable(this.f3788a ? this.f3789b : this.c);
    }
}
