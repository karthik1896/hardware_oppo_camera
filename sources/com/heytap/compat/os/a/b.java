package com.heytap.compat.os.a;

import android.os.storage.StorageVolume;
import com.color.inner.os.storage.StorageVolumeWrapper;
import com.heytap.reflect.RefClass;
import com.heytap.reflect.RefMethod;

/* compiled from: StorageVolumeNative */
public class b {

    /* compiled from: StorageVolumeNative */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Class<?> f2574a = RefClass.load(a.class, (Class<?>) StorageVolume.class);
        /* access modifiers changed from: private */
        public static RefMethod<Integer> getReadOnlyType;

        private a() {
        }
    }

    public static String a(StorageVolume storageVolume) throws com.heytap.compat.d.a.a {
        if (com.heytap.compat.d.a.b.b()) {
            return StorageVolumeWrapper.getPath(storageVolume);
        }
        if (com.heytap.compat.d.a.b.f()) {
            return storageVolume.getPath();
        }
        throw new com.heytap.compat.d.a.a();
    }

    public static int b(StorageVolume storageVolume) throws com.heytap.compat.d.a.a {
        if (com.heytap.compat.d.a.b.b()) {
            return StorageVolumeWrapper.getReadOnlyType(storageVolume);
        }
        if (com.heytap.compat.d.a.b.c()) {
            return ((Integer) a.getReadOnlyType.call(storageVolume, new Object[0])).intValue();
        }
        throw new com.heytap.compat.d.a.a();
    }
}
