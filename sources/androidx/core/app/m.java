package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TaskStackBuilder */
public final class m implements Iterable<Intent> {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Intent> f603a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final Context f604b;

    /* compiled from: TaskStackBuilder */
    public interface a {
        Intent f();
    }

    private m(Context context) {
        this.f604b = context;
    }

    public static m a(Context context) {
        return new m(context);
    }

    public m a(Intent intent) {
        this.f603a.add(intent);
        return this;
    }

    public m a(Activity activity) {
        Intent f = activity instanceof a ? ((a) activity).f() : null;
        if (f == null) {
            f = f.a(activity);
        }
        if (f != null) {
            ComponentName component = f.getComponent();
            if (component == null) {
                component = f.resolveActivity(this.f604b.getPackageManager());
            }
            a(component);
            a(f);
        }
        return this;
    }

    public m a(ComponentName componentName) {
        int size = this.f603a.size();
        try {
            Intent a2 = f.a(this.f604b, componentName);
            while (a2 != null) {
                this.f603a.add(size, a2);
                a2 = f.a(this.f604b, a2.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f603a.iterator();
    }

    public void a() {
        a((Bundle) null);
    }

    public void a(Bundle bundle) {
        if (!this.f603a.isEmpty()) {
            ArrayList<Intent> arrayList = this.f603a;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!androidx.core.content.a.a(this.f604b, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(268435456);
                this.f604b.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
