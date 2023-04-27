package com.crunchfish.touchless_a3d;

import android.content.Context;
import android.util.SparseArray;
import com.crunchfish.touchless_a3d.active_area.ActiveArea;
import com.crunchfish.touchless_a3d.deprecated_gestures.Gesture;
import com.crunchfish.touchless_a3d.exception.DeadInstanceException;
import com.crunchfish.touchless_a3d.exception.LicenseNotValidException;
import com.crunchfish.touchless_a3d.exception.LicenseServerUnavailableException;
import com.crunchfish.touchless_a3d.gesture.Event;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TouchlessA3D implements Closeable {
    private Set<ActiveArea.Listener> mActiveAreaListeners;
    private SparseArray<List<Gesture.Listener>> mListeners;
    private final ReentrantReadWriteLock mNativeLock;
    private long mNativeObj;

    public enum Rotate {
        DO_NOT_ROTATE,
        ROTATE_90,
        ROTATE_180,
        ROTATE_270
    }

    private static native long cAlloc(TouchlessA3D touchlessA3D, int i, int i2, int i3, int i4, Context context);

    private static native void cFree(long j);

    private static native int cGetParameter(long j, int i);

    private static native void cHandleImage(long j, long j2, byte[] bArr, int i, ArrayList<Gesture> arrayList, ArrayList<Event> arrayList2, ActiveArea activeArea);

    private static native void cRegisterActiveAreaListener(long j);

    private static native void cRegisterGesture(long j, com.crunchfish.touchless_a3d.gesture.Gesture gesture);

    private static native void cRegisterListener(long j, int i);

    private static native void cSetParameter(long j, int i, int i2);

    private static native void cUnregisterActiveAreaListener(long j);

    private static native void cUnregisterGesture(long j, com.crunchfish.touchless_a3d.gesture.Gesture gesture);

    private static native void cUnregisterListener(long j, int i);

    static {
        System.loadLibrary("touchless_a3d");
        System.loadLibrary("touchless_a3d_jni");
    }

    public class Parameters {
        public static final int EXTENDED_RANGE = 1002;

        public Parameters() {
        }
    }

    public TouchlessA3D(int i, int i2, Context context) throws LicenseNotValidException, LicenseServerUnavailableException {
        this(i, i2, i, 0, context);
    }

    public TouchlessA3D(int i, int i2, int i3, Context context) throws LicenseNotValidException, LicenseServerUnavailableException {
        this(i, i2, i3, 0, context);
    }

    public TouchlessA3D(int i, int i2, int i3, int i4, Context context) throws LicenseNotValidException, LicenseServerUnavailableException {
        this.mNativeObj = 0;
        this.mNativeLock = new ReentrantReadWriteLock();
        this.mListeners = new SparseArray<>();
        this.mActiveAreaListeners = new HashSet();
        this.mNativeObj = cAlloc(this, i, i2, i3, i4, context);
    }

    private void freeNativeObject() {
        this.mNativeLock.writeLock().lock();
        try {
            if (0 != this.mNativeObj) {
                cFree(this.mNativeObj);
                this.mNativeObj = 0;
            }
        } finally {
            this.mNativeLock.writeLock().unlock();
        }
    }

    public void close() {
        freeNativeObject();
    }

    public void finalize() {
        freeNativeObject();
    }

    public void setParameter(int i, int i2) {
        this.mNativeLock.readLock().lock();
        try {
            if (0 != this.mNativeObj) {
                cSetParameter(this.mNativeObj, i, i2);
                return;
            }
            throw new DeadInstanceException();
        } finally {
            this.mNativeLock.readLock().unlock();
        }
    }

    public int getParameter(int i) {
        this.mNativeLock.readLock().lock();
        try {
            if (0 != this.mNativeObj) {
                return cGetParameter(this.mNativeObj, i);
            }
            throw new DeadInstanceException();
        } finally {
            this.mNativeLock.readLock().unlock();
        }
    }

    public void registerGestureListener(int i, Gesture.Listener listener) {
        List list = this.mListeners.get(i);
        if (list == null) {
            list = new ArrayList();
            this.mListeners.put(i, list);
            this.mNativeLock.readLock().lock();
            try {
                if (0 != this.mNativeObj) {
                    cRegisterListener(this.mNativeObj, i);
                } else {
                    throw new DeadInstanceException();
                }
            } finally {
                this.mNativeLock.readLock().unlock();
            }
        }
        list.add(listener);
    }

    public void unregisterGestureListener(int i, Gesture.Listener listener) {
        List list = this.mListeners.get(i);
        if (list != null) {
            list.remove(listener);
            if (list.isEmpty()) {
                this.mListeners.remove(i);
                this.mNativeLock.readLock().lock();
                try {
                    if (0 != this.mNativeObj) {
                        cUnregisterListener(this.mNativeObj, i);
                        return;
                    }
                    throw new DeadInstanceException();
                } finally {
                    this.mNativeLock.readLock().unlock();
                }
            }
        }
    }

    public void registerGesture(com.crunchfish.touchless_a3d.gesture.Gesture gesture) {
        this.mNativeLock.readLock().lock();
        try {
            if (0 != this.mNativeObj) {
                cRegisterGesture(this.mNativeObj, gesture);
                return;
            }
            throw new DeadInstanceException();
        } finally {
            this.mNativeLock.readLock().unlock();
        }
    }

    public void unregisterGesture(com.crunchfish.touchless_a3d.gesture.Gesture gesture) {
        this.mNativeLock.readLock().lock();
        try {
            if (0 != this.mNativeObj) {
                cUnregisterGesture(this.mNativeObj, gesture);
                return;
            }
            throw new DeadInstanceException();
        } finally {
            this.mNativeLock.readLock().unlock();
        }
    }

    public void registerActiveAreaListener(ActiveArea.Listener listener) {
        synchronized (this.mActiveAreaListeners) {
            boolean isEmpty = this.mActiveAreaListeners.isEmpty();
            this.mActiveAreaListeners.add(listener);
            if (isEmpty) {
                this.mNativeLock.readLock().lock();
                try {
                    if (0 != this.mNativeObj) {
                        cRegisterActiveAreaListener(this.mNativeObj);
                    } else {
                        throw new DeadInstanceException();
                    }
                } finally {
                    this.mNativeLock.readLock().unlock();
                }
            }
        }
    }

    public void unregisterActiveAreaListener(ActiveArea.Listener listener) {
        synchronized (this.mActiveAreaListeners) {
            this.mActiveAreaListeners.remove(listener);
            if (this.mActiveAreaListeners.isEmpty()) {
                this.mNativeLock.readLock().lock();
                try {
                    if (0 != this.mNativeObj) {
                        cUnregisterActiveAreaListener(this.mNativeObj);
                    } else {
                        throw new DeadInstanceException();
                    }
                } finally {
                    this.mNativeLock.readLock().unlock();
                }
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void handleImage(long j, byte[] bArr, Rotate rotate) {
        ArrayList<ActiveArea.Listener> arrayList;
        ActiveArea activeArea = new ActiveArea();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        this.mNativeLock.readLock().lock();
        try {
            if (0 != this.mNativeObj) {
                cHandleImage(this.mNativeObj, j, bArr, rotate.ordinal(), arrayList2, arrayList3, activeArea);
                this.mNativeLock.readLock().unlock();
                synchronized (this.mActiveAreaListeners) {
                    arrayList = new ArrayList<>(this.mActiveAreaListeners);
                }
                for (ActiveArea.Listener onActiveArea : arrayList) {
                    onActiveArea.onActiveArea(activeArea);
                }
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    Gesture gesture = (Gesture) it.next();
                    Iterator it2 = new ArrayList(this.mListeners.get(gesture.getType())).iterator();
                    while (it2.hasNext()) {
                        ((Gesture.Listener) it2.next()).onGesture(gesture);
                    }
                }
                Iterator it3 = arrayList3.iterator();
                while (it3.hasNext()) {
                    ((Event) it3.next()).dispatch();
                }
                return;
            }
            throw new DeadInstanceException();
        } catch (Throwable th) {
            this.mNativeLock.readLock().unlock();
            throw th;
        }
    }

    public void handleImage(long j, byte[] bArr) {
        handleImage(j, bArr, Rotate.DO_NOT_ROTATE);
    }
}
