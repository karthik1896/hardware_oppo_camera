package com.heytap.epona;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.heytap.epona.e;

/* compiled from: IRemoteTransfer */
public interface d extends IInterface {
    Response a(Request request) throws RemoteException;

    void a(Request request, e eVar) throws RemoteException;

    /* compiled from: IRemoteTransfer */
    public static abstract class a extends Binder implements d {
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.heytap.epona.IRemoteTransfer");
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.epona.IRemoteTransfer");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
                return new C0069a(iBinder);
            }
            return (d) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Request request = null;
            if (i == 1) {
                parcel.enforceInterface("com.heytap.epona.IRemoteTransfer");
                if (parcel.readInt() != 0) {
                    request = Request.CREATOR.createFromParcel(parcel);
                }
                Response a2 = a(request);
                parcel2.writeNoException();
                if (a2 != null) {
                    parcel2.writeInt(1);
                    a2.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.heytap.epona.IRemoteTransfer");
                if (parcel.readInt() != 0) {
                    request = Request.CREATOR.createFromParcel(parcel);
                }
                a(request, e.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.heytap.epona.IRemoteTransfer");
                return true;
            }
        }

        /* renamed from: com.heytap.epona.d$a$a  reason: collision with other inner class name */
        /* compiled from: IRemoteTransfer */
        private static class C0069a implements d {

            /* renamed from: a  reason: collision with root package name */
            public static d f2593a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f2594b;

            C0069a(IBinder iBinder) {
                this.f2594b = iBinder;
            }

            public IBinder asBinder() {
                return this.f2594b;
            }

            public Response a(Request request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.epona.IRemoteTransfer");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f2594b.transact(1, obtain, obtain2, 0) && a.a() != null) {
                        return a.a().a(request);
                    }
                    obtain2.readException();
                    Response createFromParcel = obtain2.readInt() != 0 ? Response.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(Request request, e eVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.epona.IRemoteTransfer");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(eVar != null ? eVar.asBinder() : null);
                    if (this.f2594b.transact(2, obtain, obtain2, 0) || a.a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    a.a().a(request, eVar);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static d a() {
            return C0069a.f2593a;
        }
    }
}
