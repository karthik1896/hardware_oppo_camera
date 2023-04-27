package com.color.support.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.l;
import color.support.v7.appcompat.R;

public class ColorSpannablePreference extends Preference {

    /* renamed from: a  reason: collision with root package name */
    private CharSequence f1962a;

    public ColorSpannablePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColorPreference, i, i2);
        this.f1962a = obtainStyledAttributes.getText(R.styleable.ColorPreference_colorAssignment);
        obtainStyledAttributes.recycle();
    }

    public void a(l lVar) {
        super.a(lVar);
        final TextView textView = (TextView) lVar.a(16908304);
        if (textView != null) {
            textView.setHighlightColor(J().getResources().getColor(17170445));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int actionMasked = motionEvent.getActionMasked();
                    int selectionStart = textView.getSelectionStart();
                    int selectionEnd = textView.getSelectionEnd();
                    int offsetForPosition = textView.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
                    boolean z = selectionStart == selectionEnd || offsetForPosition <= selectionStart || offsetForPosition >= selectionEnd;
                    if (actionMasked != 0) {
                        if (actionMasked == 1 || actionMasked == 3) {
                            textView.setPressed(false);
                            textView.postInvalidateDelayed(70);
                        }
                    } else if (z) {
                        return false;
                    } else {
                        textView.setPressed(true);
                        textView.invalidate();
                    }
                    return false;
                }
            });
        }
        TextView textView2 = (TextView) lVar.a(R.id.assignment);
        if (textView2 != null) {
            CharSequence b2 = b();
            if (!TextUtils.isEmpty(b2)) {
                textView2.setText(b2);
                textView2.setVisibility(0);
                return;
            }
            textView2.setVisibility(8);
        }
    }

    public CharSequence b() {
        return this.f1962a;
    }
}
