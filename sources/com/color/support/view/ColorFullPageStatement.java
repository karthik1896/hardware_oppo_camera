package com.color.support.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import color.support.v7.appcompat.R;
import com.color.support.d.b;
import com.color.support.widget.ColorButton;
import com.color.support.widget.MaxHeightScrollView;

public class ColorFullPageStatement extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f2004a;

    /* renamed from: b  reason: collision with root package name */
    private ColorButton f2005b;
    private TextView c;
    private LayoutInflater d;
    private Context e;
    /* access modifiers changed from: private */
    public a f;
    private MaxHeightScrollView g;
    private MaxHeightScrollView h;
    private ImageView i;

    public interface a {
        void a();

        void b();
    }

    public ColorFullPageStatement(Context context) {
        this(context, (AttributeSet) null);
    }

    public ColorFullPageStatement(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorFullPageStatement(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ColorFullPageStatement(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.e = context;
        a();
        TypedArray obtainStyledAttributes = this.e.obtainStyledAttributes(attributeSet, R.styleable.ColorFullPageStatement);
        String string = obtainStyledAttributes.getString(R.styleable.ColorFullPageStatement_exitButtonText);
        String string2 = obtainStyledAttributes.getString(R.styleable.ColorFullPageStatement_bottomButtonText);
        this.f2004a.setText(obtainStyledAttributes.getString(R.styleable.ColorFullPageStatement_appStatement));
        if (string2 != null) {
            this.f2005b.setText(string2);
        }
        if (string != null) {
            this.c.setText(string);
        }
        obtainStyledAttributes.recycle();
    }

    private void a() {
        this.d = (LayoutInflater) this.e.getSystemService("layout_inflater");
        View inflate = this.d.inflate(R.layout.color_full_page_statement, this);
        this.f2004a = (TextView) inflate.findViewById(R.id.txt_statement);
        this.f2005b = (ColorButton) inflate.findViewById(R.id.btn_confirm);
        this.g = (MaxHeightScrollView) inflate.findViewById(R.id.text_field1);
        this.h = (MaxHeightScrollView) inflate.findViewById(R.id.scroll_text);
        this.c = (TextView) inflate.findViewById(R.id.txt_exit);
        this.i = (ImageView) inflate.findViewById(R.id.img_privacy_icon);
        this.g.setNestedScrollingEnabled(true);
        b.a(this.f2004a, 2);
        this.f2005b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ColorFullPageStatement.this.f != null) {
                    ColorFullPageStatement.this.f.a();
                }
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ColorFullPageStatement.this.f != null) {
                    ColorFullPageStatement.this.f.b();
                }
            }
        });
    }

    public MaxHeightScrollView getScrollTextView() {
        return this.h;
    }

    public TextView getAppStatement() {
        return this.f2004a;
    }

    public void setAppStatement(CharSequence charSequence) {
        this.f2004a.setText(charSequence);
    }

    public void setButtonText(CharSequence charSequence) {
        this.f2005b.setText(charSequence);
    }

    public void setExitButtonText(CharSequence charSequence) {
        this.c.setText(charSequence);
    }

    public void setButtonListener(a aVar) {
        this.f = aVar;
    }

    public void setContainer(View view) {
        this.g.addView(view);
    }

    public void setStatementMaxHeight(int i2) {
        this.h.setMaxHeight(i2);
    }
}
