package com.heytap.epona;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ITransferCallback */
public interface e extends IInterface {
    void a(Response response) throws RemoteException;

    /* compiled from: ITransferCallback */
    public static abstract class a extends Binder implements e {
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.heytap.epona.ITransferCallback");
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.epona.ITransferCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof e)) {
                return new C0071a(iBinder);
            }
            return (e) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.heytap.epona.ITransferCallback");
                a(parcel.readInt() != 0 ? Response.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.heytap.epona.ITransferCallback");
                return true;
            }
        }

        /* renamed from: com.heytap.epona.e$a$a  reason: collision with other inner class name */
        /* compiled from: ITransferCallback */
        private static class C0071a implements e {

            /* renamed from: a  reason: collision with root package name */
            public static e f2598a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f2599b;

            C0071a(IBinder iBinder) {
                this.f2599b = iBinder;
            }

            public IBinder asBinder() {
                return this.f2599b;
            }

            public void a(Response response) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.epona.ITransferCallback");
                    if (response != null) {
                        obtain.writeInt(1);
                        response.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f2599b.transact(1, obtain, obtain2, 0) || a.a() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    a.a().a(response);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static e a() {
            return C0071a.f2598a;
        }
    }
}
