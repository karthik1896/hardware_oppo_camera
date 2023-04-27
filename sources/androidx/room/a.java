package androidx.room;

import android.content.Context;
import androidx.f.a.c;
import androidx.room.i;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: DatabaseConfiguration */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final c.C0029c f1169a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f1170b;
    public final String c;
    public final i.d d;
    public final List<i.b> e;
    public final boolean f;
    public final i.c g;
    public final Executor h;
    public final Executor i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final String m;
    public final File n;
    private final Set<Integer> o;

    public a(Context context, String str, c.C0029c cVar, i.d dVar, List<i.b> list, boolean z, i.c cVar2, Executor executor, Executor executor2, boolean z2, boolean z3, boolean z4, Set<Integer> set, String str2, File file) {
        this.f1169a = cVar;
        this.f1170b = context;
        this.c = str;
        this.d = dVar;
        this.e = list;
        this.f = z;
        this.g = cVar2;
        this.h = executor;
        this.i = executor2;
        this.j = z2;
        this.k = z3;
        this.l = z4;
        this.o = set;
        this.m = str2;
        this.n = file;
    }

    public boolean a(int i2, int i3) {
        Set<Integer> set;
        if ((i2 > i3) && this.l) {
            return false;
        }
        if (!this.k || ((set = this.o) != null && set.contains(Integer.valueOf(i2)))) {
            return false;
        }
        return true;
    }
}
