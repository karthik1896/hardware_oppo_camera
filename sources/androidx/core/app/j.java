package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.h;
import com.android.providers.downloads.Downloads;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: NotificationCompatJellybean */
class j {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f599a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Field f600b;
    private static boolean c;
    private static final Object d = new Object();

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle a(Notification notification) {
        synchronized (f599a) {
            if (c) {
                return null;
            }
            try {
                if (f600b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f600b = declaredField;
                }
                Bundle bundle = (Bundle) f600b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f600b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                c = true;
                return null;
            }
        }
    }

    public static Bundle a(Notification.Builder builder, h.a aVar) {
        builder.addAction(aVar.a(), aVar.c(), aVar.d());
        Bundle bundle = new Bundle(aVar.e());
        if (aVar.g() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", a(aVar.g()));
        }
        if (aVar.j() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", a(aVar.j()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.f());
        return bundle;
    }

    static Bundle a(h.a aVar) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putInt("icon", aVar.a());
        bundle2.putCharSequence(Downloads.Impl.COLUMN_TITLE, aVar.c());
        bundle2.putParcelable("actionIntent", aVar.d());
        if (aVar.e() != null) {
            bundle = new Bundle(aVar.e());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.f());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", a(aVar.g()));
        bundle2.putBoolean("showsUserInterface", aVar.k());
        bundle2.putInt("semanticAction", aVar.h());
        return bundle2;
    }

    private static Bundle a(k kVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", kVar.a());
        bundle.putCharSequence("label", kVar.b());
        bundle.putCharSequenceArray("choices", kVar.c());
        bundle.putBoolean("allowFreeFormInput", kVar.e());
        bundle.putBundle("extras", kVar.g());
        Set<String> d2 = kVar.d();
        if (d2 != null && !d2.isEmpty()) {
            ArrayList arrayList = new ArrayList(d2.size());
            for (String add : d2) {
                arrayList.add(add);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    private static Bundle[] a(k[] kVarArr) {
        if (kVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[kVarArr.length];
        for (int i = 0; i < kVarArr.length; i++) {
            bundleArr[i] = a(kVarArr[i]);
        }
        return bundleArr;
    }
}
