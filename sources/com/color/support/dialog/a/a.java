package com.color.support.dialog.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import color.support.v7.appcompat.R;

/* compiled from: ColorRotatingSpinnerDialog */
public class a extends b {
    private boolean i = false;
    /* access modifiers changed from: private */
    public DialogInterface.OnCancelListener j;
    private LinearLayout k;
    private ViewGroup l;
    private TextView m;
    /* access modifiers changed from: private */
    public boolean n = true;

    public a(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.color_progress_dialog_rotating, (ViewGroup) null);
        this.k = (LinearLayout) inflate.findViewById(R.id.body);
        Resources resources = getContext().getResources();
        if (this.i) {
            this.k.setPadding(0, resources.getDimensionPixelSize(R.dimen.color_loading_dialog_padding_top), 0, resources.getDimensionPixelSize(R.dimen.color_loading_cancelable_dialog_padding_bottom));
        } else {
            this.k.setPadding(0, resources.getDimensionPixelSize(R.dimen.color_loading_dialog_padding_top), 0, resources.getDimensionPixelSize(R.dimen.color_loading_dialog_padding_bottom));
        }
        a(inflate);
        if (this.i) {
            a(-1, getContext().getString(17039360), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (a.this.j != null) {
                        a.this.j.onCancel(dialogInterface);
                    }
                }
            });
        }
        super.onCreate(bundle);
    }

    public void show() {
        super.show();
        if (this.l == null) {
            this.l = (ViewGroup) findViewById(R.id.parentPanel);
        }
        ViewGroup viewGroup = this.l;
        if (viewGroup != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            layoutParams.width = -2;
            this.l.setLayoutParams(layoutParams);
            this.l.setMinimumWidth(getContext().getResources().getDimensionPixelSize(R.dimen.color_loading_dialog_min_width) + this.l.getPaddingLeft() + this.l.getPaddingRight());
            this.l.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                }
            });
            FrameLayout frameLayout = (FrameLayout) this.l.getParent();
            if (frameLayout != null) {
                frameLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (a.this.n && a.this.isShowing()) {
                            a.this.dismiss();
                        }
                    }
                });
            }
        }
        if (this.m == null) {
            this.m = (TextView) findViewById(R.id.alertTitle);
        }
        TextView textView = this.m;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                }
            });
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        this.n = z;
    }
}
