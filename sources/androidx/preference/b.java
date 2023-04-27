package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ExpandButton */
final class b extends Preference {

    /* renamed from: a  reason: collision with root package name */
    private long f998a;

    b(Context context, List<Preference> list, long j) {
        super(context);
        b();
        a(list);
        this.f998a = j + 1000000;
    }

    private void b() {
        a(R.layout.expand_button);
        d(R.drawable.ic_arrow_down_24dp);
        c(R.string.expand_button_title);
        b(999);
    }

    private void a(List<Preference> list) {
        ArrayList arrayList = new ArrayList();
        CharSequence charSequence = null;
        for (Preference next : list) {
            CharSequence x = next.x();
            boolean z = next instanceof PreferenceGroup;
            if (z && !TextUtils.isEmpty(x)) {
                arrayList.add((PreferenceGroup) next);
            }
            if (arrayList.contains(next.Q())) {
                if (z) {
                    arrayList.add((PreferenceGroup) next);
                }
            } else if (!TextUtils.isEmpty(x)) {
                if (charSequence == null) {
                    charSequence = x;
                } else {
                    charSequence = J().getString(R.string.summary_collapsed_preference_list, new Object[]{charSequence, x});
                }
            }
        }
        a(charSequence);
    }

    public void a(l lVar) {
        super.a(lVar);
        lVar.a(false);
    }

    /* access modifiers changed from: package-private */
    public long c_() {
        return this.f998a;
    }
}
