package color.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import color.support.v7.appcompat.R;

/* compiled from: ColorPopupWindow */
public class e extends c {

    /* renamed from: a  reason: collision with root package name */
    private b f1581a;

    /* renamed from: b  reason: collision with root package name */
    private a f1582b;
    private boolean c;

    /* compiled from: ColorPopupWindow */
    public interface a {
        void a(e eVar);

        void b(e eVar);
    }

    /* compiled from: ColorPopupWindow */
    public interface b {
        void a(WindowManager.LayoutParams layoutParams);
    }

    public e(Context context) {
        this(context, (AttributeSet) null);
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.popupWindowStyle);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f1581a = null;
        this.f1582b = null;
        this.c = false;
    }

    public e() {
        this((View) null, 0, 0);
    }

    public e(View view, int i, int i2) {
        this(view, i, i2, false);
    }

    public e(View view, int i, int i2, boolean z) {
        super(view, i, i2, z);
        this.f1581a = null;
        this.f1582b = null;
        this.c = false;
    }

    public void dismiss() {
        if (!this.c) {
            this.c = true;
            a aVar = this.f1582b;
            if (aVar != null) {
                aVar.a(this);
            } else {
                b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(WindowManager.LayoutParams layoutParams) {
        b bVar = this.f1581a;
        if (bVar != null) {
            bVar.a(layoutParams);
        }
        super.a(layoutParams);
    }

    public void a(b bVar) {
        this.f1581a = bVar;
    }

    public void b() {
        super.dismiss();
        this.c = false;
        a aVar = this.f1582b;
        if (aVar != null) {
            aVar.b(this);
        }
    }
}
