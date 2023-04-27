package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.b;

/* compiled from: AppCompatDialogFragment */
public class g extends b {
    public Dialog onCreateDialog(Bundle bundle) {
        return new f(getContext(), getTheme());
    }

    public void setupDialog(Dialog dialog, int i) {
        if (dialog instanceof f) {
            f fVar = (f) dialog;
            if (!(i == 1 || i == 2)) {
                if (i == 3) {
                    dialog.getWindow().addFlags(24);
                } else {
                    return;
                }
            }
            fVar.supportRequestWindowFeature(1);
            return;
        }
        super.setupDialog(dialog, i);
    }
}
