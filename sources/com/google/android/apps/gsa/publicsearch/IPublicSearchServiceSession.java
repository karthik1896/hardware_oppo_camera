package com.google.android.apps.gsa.publicsearch;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.aidl.BaseProxy;
import com.google.android.aidl.BaseStub;
import com.google.android.aidl.Codecs;

public interface IPublicSearchServiceSession extends IInterface {
    void onGenericClientEvent(byte[] bArr) throws RemoteException;

    void onGenericClientEventWithSystemParcelable(byte[] bArr, SystemParcelableWrapper systemParcelableWrapper) throws RemoteException;

    public static abstract class Stub extends BaseStub implements IPublicSearchServiceSession {
        private static final String DESCRIPTOR = "com.google.android.apps.gsa.publicsearch.IPublicSearchServiceSession";
        static final int TRANSACTION_onGenericClientEvent = 1;
        static final int TRANSACTION_onGenericClientEventWithSystemParcelable = 2;

        public Stub() {
            super(DESCRIPTOR);
        }

        public static IPublicSearchServiceSession asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface instanceof IPublicSearchServiceSession) {
                return (IPublicSearchServiceSession) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        /* access modifiers changed from: protected */
        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                onGenericClientEvent(parcel.createByteArray());
            } else if (i != 2) {
                return false;
            } else {
                onGenericClientEventWithSystemParcelable(parcel.createByteArray(), (SystemParcelableWrapper) Codecs.createParcelable(parcel, SystemParcelableWrapper.CREATOR));
            }
            return true;
        }

        public static class Proxy extends BaseProxy implements IPublicSearchServiceSession {
            Proxy(IBinder iBinder) {
                super(iBinder, Stub.DESCRIPTOR);
            }

            public void onGenericClientEvent(byte[] bArr) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeByteArray(bArr);
                transactOneway(1, obtainAndWriteInterfaceToken);
            }

            public void onGenericClientEventWithSystemParcelable(byte[] bArr, SystemParcelableWrapper systemParcelableWrapper) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeByteArray(bArr);
                Codecs.writeParcelable(obtainAndWriteInterfaceToken, systemParcelableWrapper);
                transactOneway(2, obtainAndWriteInterfaceToken);
            }
        }
    }
}
