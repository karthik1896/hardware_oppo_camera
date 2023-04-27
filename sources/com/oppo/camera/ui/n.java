package com.oppo.camera.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.f;
import androidx.fragment.app.b;
import androidx.fragment.app.c;
import com.color.support.view.ColorFullPageStatement;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.util.i;

/* compiled from: StatementDialogFragment */
public class n extends b {

    /* renamed from: a  reason: collision with root package name */
    private ColorFullPageStatement f4315a = null;

    /* renamed from: b  reason: collision with root package name */
    private a f4316b = null;

    /* compiled from: StatementDialogFragment */
    public interface a {
        void a();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        e.e("StatementDialogFragment", "onCreateDialog");
        c activity = getActivity();
        if (activity == null) {
            return null;
        }
        f fVar = new f(activity, R.style.StatementAndGuideTheme);
        fVar.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return false;
                }
                c activity = n.this.getActivity();
                if (activity == null) {
                    return true;
                }
                activity.finish();
                return true;
            }
        });
        com.oppo.camera.util.f.a((Dialog) fVar);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.statement_dialog_layout, (ViewGroup) null);
        this.f4315a = (ColorFullPageStatement) inflate.findViewById(R.id.full_statement_page);
        View a2 = a((Context) activity);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.rootView);
        if (!(linearLayout == null || a2 == null)) {
            linearLayout.addView(a2, 0, a2.getLayoutParams());
        }
        this.f4316b.a();
        inflate.setForceDarkAllowed(true);
        fVar.setContentView(inflate);
        setShowsDialog(false);
        return fVar;
    }

    private View a(Context context) {
        if (context == null) {
            return null;
        }
        int a2 = i.a(context);
        ImageView imageView = new ImageView(context);
        imageView.setBackground(context.getResources().getDrawable(R.drawable.color_list_statusbar_bg));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, a2));
        return imageView;
    }

    public ColorFullPageStatement a() {
        return this.f4315a;
    }

    public void a(a aVar) {
        this.f4316b = aVar;
    }
}
