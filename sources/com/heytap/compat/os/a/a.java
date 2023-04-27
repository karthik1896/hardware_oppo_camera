package com.heytap.compat.os.a;

import android.os.storage.DiskInfo;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.os.storage.VolumeInfo;
import com.color.inner.os.storage.StorageEventListenerWrapper;
import com.heytap.compat.d.a.b;
import com.heytap.reflect.MethodName;
import com.heytap.reflect.RefClass;
import com.heytap.reflect.RefMethod;
import java.util.HashMap;
import java.util.List;

/* compiled from: StorageManagerNative */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<Object, StorageEventListenerWrapper> f2571a = new HashMap<>();

    /* renamed from: com.heytap.compat.os.a.a$a  reason: collision with other inner class name */
    /* compiled from: StorageManagerNative */
    private static class C0067a {

        /* renamed from: a  reason: collision with root package name */
        private static Class<?> f2572a = RefClass.load(C0067a.class, (Class<?>) StorageManager.class);

        /* renamed from: b  reason: collision with root package name */
        private static Class<?> f2573b = RefClass.load(C0067a.class, (Class<?>) VolumeInfo.class);
        private static Class<?> c = RefClass.load(C0067a.class, (Class<?>) DiskInfo.class);
        private static RefMethod<Object> getDisk;
        /* access modifiers changed from: private */
        @MethodName(name = "getVolumeList", params = {int.class, int.class})
        public static RefMethod<StorageVolume[]> getVolumeList;
        private static RefMethod<String[]> getVolumePaths;
        private static RefMethod<String> getVolumeState;
        private static RefMethod<List<Object>> getVolumes;
        private static RefMethod<Boolean> isFileEncryptedNativeOnly;
        private static RefMethod<Boolean> isSd;
        private static RefMethod<Void> registerListener;

        private C0067a() {
        }
    }

    public static StorageVolume[] a(int i, int i2) throws com.heytap.compat.d.a.a {
        if (b.f()) {
            return (StorageVolume[]) C0067a.getVolumeList.call((Object) null, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new com.heytap.compat.d.a.a("not supported before M");
    }
}
