package com.crunchfish.touchless_a3d.deprecated_gestures;

public interface Gesture {

    public interface Listener {
        void onGesture(Gesture gesture);
    }

    long getTimestamp();

    int getType();
}
