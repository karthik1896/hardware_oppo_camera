package com.crunchfish.touchless_a3d.gesture;

import java.util.ArrayList;
import java.util.Iterator;

public class Gesture {
    private ArrayList<Listener> mListeners = new ArrayList<>();
    private long mNativeObj = 0;

    public interface Listener {
        void onEvent(Event event);
    }

    private native long cCreateGesture(String str);

    public Gesture(String str) {
        this.mNativeObj = cCreateGesture(str);
        if (this.mNativeObj == 0) {
            throw new IllegalArgumentException("Could not parse json argument");
        }
    }

    public void registerListener(Listener listener) {
        this.mListeners.add(listener);
    }

    public void unregisterListener(Listener listener) {
        this.mListeners.remove(listener);
    }

    /* access modifiers changed from: package-private */
    public void dispatchEvent(Event event) {
        Iterator<Listener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onEvent(event);
        }
    }

    private long getNativeObject() {
        return this.mNativeObj;
    }
}
