package color.support.v7.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.RelativeLayout;

public class CheckableLayout extends RelativeLayout implements Checkable {

    /* renamed from: a  reason: collision with root package name */
    private Checkable f1445a;

    public CheckableLayout(Context context) {
        super(context);
    }

    public CheckableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CheckableLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof Checkable) {
                    this.f1445a = (Checkable) childAt;
                    return;
                }
            }
        }
    }

    public void setChecked(boolean z) {
        Checkable checkable = this.f1445a;
        if (checkable != null) {
            checkable.setChecked(z);
        }
    }

    public boolean isChecked() {
        Checkable checkable = this.f1445a;
        return checkable != null && checkable.isChecked();
    }

    public void toggle() {
        Checkable checkable = this.f1445a;
        if (checkable != null) {
            checkable.toggle();
        }
    }
}
