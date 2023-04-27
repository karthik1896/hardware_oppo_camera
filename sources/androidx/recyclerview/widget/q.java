package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: ScrollbarHelper */
class q {
    static int a(RecyclerView.t tVar, n nVar, View view, View view2, RecyclerView.i iVar, boolean z, boolean z2) {
        int i;
        if (iVar.getChildCount() == 0 || tVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(iVar.getPosition(view), iVar.getPosition(view2));
        int max = Math.max(iVar.getPosition(view), iVar.getPosition(view2));
        if (z2) {
            i = Math.max(0, (tVar.e() - max) - 1);
        } else {
            i = Math.max(0, min);
        }
        if (!z) {
            return i;
        }
        return Math.round((((float) i) * (((float) Math.abs(nVar.b(view2) - nVar.a(view))) / ((float) (Math.abs(iVar.getPosition(view) - iVar.getPosition(view2)) + 1)))) + ((float) (nVar.d() - nVar.a(view))));
    }

    static int a(RecyclerView.t tVar, n nVar, View view, View view2, RecyclerView.i iVar, boolean z) {
        if (iVar.getChildCount() == 0 || tVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(iVar.getPosition(view) - iVar.getPosition(view2)) + 1;
        }
        return Math.min(nVar.g(), nVar.b(view2) - nVar.a(view));
    }

    static int b(RecyclerView.t tVar, n nVar, View view, View view2, RecyclerView.i iVar, boolean z) {
        if (iVar.getChildCount() == 0 || tVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return tVar.e();
        }
        return (int) ((((float) (nVar.b(view2) - nVar.a(view))) / ((float) (Math.abs(iVar.getPosition(view) - iVar.getPosition(view2)) + 1))) * ((float) tVar.e()));
    }
}
