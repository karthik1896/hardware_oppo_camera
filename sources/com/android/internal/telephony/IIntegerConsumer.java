package com.android.internal.telephony;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IIntegerConsumer extends IInterface {

    public static class Default implements IIntegerConsumer {
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IIntegerConsumer {
        private static final String DESCRIPTOR = "com.android.internal.telephony.IIntegerConsumer";

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IIntegerConsumer asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IIntegerConsumer)) {
                return new Proxy(iBinder);
            }
            return (IIntegerConsumer) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }

        private static class Proxy implements IIntegerConsumer {
            public static IIntegerConsumer sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }
        }

        public static boolean setDefaultImpl(IIntegerConsumer iIntegerConsumer) {
            if (Proxy.sDefaultImpl != null || iIntegerConsumer == null) {
                return false;
            }
            Proxy.sDefaultImpl = iIntegerConsumer;
            return true;
        }

        public static IIntegerConsumer getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
