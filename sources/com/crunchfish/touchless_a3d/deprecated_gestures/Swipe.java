package com.crunchfish.touchless_a3d.deprecated_gestures;

import android.annotation.SuppressLint;

public class Swipe implements Gesture {
    public static final int TYPE = 6;
    private Direction mDirection;
    private long mTimestamp;

    @SuppressLint({"RtlHardcoded"})
    public enum Direction {
        LEFT,
        RIGHT
    }

    public int getType() {
        return 6;
    }

    public Swipe(long j, int i) {
        this.mTimestamp = j;
        this.mDirection = Direction.values()[i];
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public Direction getDirection() {
        return this.mDirection;
    }
}
