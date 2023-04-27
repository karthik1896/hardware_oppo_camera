package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.appcompat.a.a.a;
import androidx.core.widget.i;

/* compiled from: AppCompatCheckedTextView */
public class g extends CheckedTextView {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f444a = {16843016};

    /* renamed from: b  reason: collision with root package name */
    private final v f445b;

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(ao.a(context), attributeSet, i);
        this.f445b = new v(this);
        this.f445b.a(attributeSet, i);
        this.f445b.b();
        ar a2 = ar.a(getContext(), attributeSet, f444a, i, 0);
        setCheckMarkDrawable(a2.a(0));
        a2.b();
    }

    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(a.b(getContext(), i));
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        v vVar = this.f445b;
        if (vVar != null) {
            vVar.a(context, i);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        v vVar = this.f445b;
        if (vVar != null) {
            vVar.b();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return k.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a((TextView) this, callback));
    }
}
