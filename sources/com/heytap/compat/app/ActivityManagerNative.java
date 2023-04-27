package com.heytap.compat.app;

import android.app.IProcessObserver;
import android.content.pm.IPackageDataObserver;
import android.os.RemoteException;
import com.heytap.compat.a.a.a;
import java.util.HashMap;
import java.util.Map;

public class ActivityManagerNative {

    /* renamed from: a  reason: collision with root package name */
    private static Map<a, IProcessObserver.Stub> f2563a = new HashMap();

    private static class PackageDataObserver extends IPackageDataObserver.Stub {
        private a mObserverNative;

        public PackageDataObserver(a aVar) {
            this.mObserverNative = aVar;
        }

        public void onRemoveCompleted(String str, boolean z) throws RemoteException {
            a aVar = this.mObserverNative;
            if (aVar != null) {
                aVar.a(str, z);
            }
        }
    }

    private static class ProcessObserver extends IProcessObserver.Stub {
        private a mObserver;

        public ProcessObserver(a aVar) {
            this.mObserver = aVar;
        }

        public void onForegroundActivitiesChanged(int i, int i2, boolean z) throws RemoteException {
            a aVar = this.mObserver;
            if (aVar != null) {
                aVar.a(i, i2, z);
            }
        }

        public void onForegroundServicesChanged(int i, int i2, int i3) throws RemoteException {
            a aVar = this.mObserver;
            if (aVar != null) {
                aVar.a(i, i2, i3);
            }
        }

        public void onProcessDied(int i, int i2) throws RemoteException {
            a aVar = this.mObserver;
            if (aVar != null) {
                aVar.a(i, i2);
            }
        }
    }
}
