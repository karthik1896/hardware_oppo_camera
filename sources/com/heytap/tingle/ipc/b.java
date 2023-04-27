package com.heytap.tingle.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IMaster */
public interface b extends IInterface {
    int a() throws RemoteException;

    /* compiled from: IMaster */
    public static abstract class a extends Binder implements b {
        public IBinder asBinder() {
            return this;
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.tingle.ipc.IMaster");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new C0073a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 4) {
                parcel.enforceInterface("com.heytap.tingle.ipc.IMaster");
                int a2 = a();
                parcel2.writeNoException();
                parcel2.writeInt(a2);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.heytap.tingle.ipc.IMaster");
                return true;
            }
        }

        /* renamed from: com.heytap.tingle.ipc.b$a$a  reason: collision with other inner class name */
        /* compiled from: IMaster */
        private static class C0073a implements b {

            /* renamed from: a  reason: collision with root package name */
            public static b f2655a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f2656b;

            C0073a(IBinder iBinder) {
                this.f2656b = iBinder;
            }

            public IBinder asBinder() {
                return this.f2656b;
            }

            public int a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.tingle.ipc.IMaster");
                    if (!this.f2656b.transact(4, obtain, obtain2, 0) && a.b() != null) {
                        return a.b().a();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static b b() {
            return C0073a.f2655a;
        }
    }
}
