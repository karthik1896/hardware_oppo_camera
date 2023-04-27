package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* compiled from: InvalidationLiveDataContainer */
class e {

    /* renamed from: a  reason: collision with root package name */
    final Set<LiveData> f1185a = Collections.newSetFromMap(new IdentityHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final i f1186b;

    e(i iVar) {
        this.f1186b = iVar;
    }
}
