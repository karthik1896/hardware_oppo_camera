package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;
import androidx.versionedparcelable.c;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f570a = (IconCompat) aVar.b(remoteActionCompat.f570a, 1);
        remoteActionCompat.f571b = aVar.b(remoteActionCompat.f571b, 2);
        remoteActionCompat.c = aVar.b(remoteActionCompat.c, 3);
        remoteActionCompat.d = (PendingIntent) aVar.b(remoteActionCompat.d, 4);
        remoteActionCompat.e = aVar.b(remoteActionCompat.e, 5);
        remoteActionCompat.f = aVar.b(remoteActionCompat.f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.a(false, false);
        aVar.a((c) remoteActionCompat.f570a, 1);
        aVar.a(remoteActionCompat.f571b, 2);
        aVar.a(remoteActionCompat.c, 3);
        aVar.a((Parcelable) remoteActionCompat.d, 4);
        aVar.a(remoteActionCompat.e, 5);
        aVar.a(remoteActionCompat.f, 6);
    }
}
