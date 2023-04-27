package com.oppo.a.a;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* compiled from: IPreDecode */
public interface a extends IInterface {
    Bitmap a(ParcelFileDescriptor parcelFileDescriptor, int i, int i2) throws RemoteException;

    Bitmap a(String str, int i, int i2) throws RemoteException;

    Bitmap a(String str, String str2, long j, int i) throws RemoteException;

    void a(String str, String str2, long j, boolean z) throws RemoteException;

    /* renamed from: com.oppo.a.a.a$a  reason: collision with other inner class name */
    /* compiled from: IPreDecode */
    public static abstract class C0077a extends Binder implements a {
        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.oppo.gallery3d.predecode.IPreDecode");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new C0078a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.oppo.gallery3d.predecode.IPreDecode");
                a(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt() != 0);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.oppo.gallery3d.predecode.IPreDecode");
                Bitmap a2 = a(parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt());
                parcel2.writeNoException();
                if (a2 != null) {
                    parcel2.writeInt(1);
                    a2.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("com.oppo.gallery3d.predecode.IPreDecode");
                Bitmap a3 = a(parcel.readString(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                if (a3 != null) {
                    parcel2.writeInt(1);
                    a3.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i == 4) {
                parcel.enforceInterface("com.oppo.gallery3d.predecode.IPreDecode");
                Bitmap a4 = a(parcel.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                if (a4 != null) {
                    parcel2.writeInt(1);
                    a4.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.oppo.gallery3d.predecode.IPreDecode");
                return true;
            }
        }

        /* renamed from: com.oppo.a.a.a$a$a  reason: collision with other inner class name */
        /* compiled from: IPreDecode */
        private static class C0078a implements a {

            /* renamed from: a  reason: collision with root package name */
            public static a f2715a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f2716b;

            C0078a(IBinder iBinder) {
                this.f2716b = iBinder;
            }

            public IBinder asBinder() {
                return this.f2716b;
            }

            public void a(String str, String str2, long j, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.oppo.gallery3d.predecode.IPreDecode");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j);
                    obtain.writeInt(z ? 1 : 0);
                    if (this.f2716b.transact(1, obtain, (Parcel) null, 1) || C0077a.a() == null) {
                        obtain.recycle();
                    } else {
                        C0077a.a().a(str, str2, j, z);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public Bitmap a(String str, String str2, long j, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.oppo.gallery3d.predecode.IPreDecode");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    if (!this.f2716b.transact(2, obtain, obtain2, 0) && C0077a.a() != null) {
                        return C0077a.a().a(str, str2, j, i);
                    }
                    obtain2.readException();
                    Bitmap bitmap = obtain2.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bitmap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bitmap a(String str, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.oppo.gallery3d.predecode.IPreDecode");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.f2716b.transact(3, obtain, obtain2, 0) && C0077a.a() != null) {
                        return C0077a.a().a(str, i, i2);
                    }
                    obtain2.readException();
                    Bitmap bitmap = obtain2.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bitmap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bitmap a(ParcelFileDescriptor parcelFileDescriptor, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.oppo.gallery3d.predecode.IPreDecode");
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.f2716b.transact(4, obtain, obtain2, 0) && C0077a.a() != null) {
                        return C0077a.a().a(parcelFileDescriptor, i, i2);
                    }
                    obtain2.readException();
                    Bitmap bitmap = obtain2.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bitmap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static a a() {
            return C0078a.f2715a;
        }
    }
}
