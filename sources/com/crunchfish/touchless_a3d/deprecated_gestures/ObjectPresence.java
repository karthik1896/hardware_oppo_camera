package com.crunchfish.touchless_a3d.deprecated_gestures;

import android.util.Log;

public abstract class ObjectPresence implements Gesture {
    static final String LOG_TAG = "crunchfish";
    private Action mAction;
    private int mHeight;
    private int mObjectId;
    private int mPrevX;
    private int mPrevY;
    private int mPrevZ;
    private long mTimestamp;
    private int mWidth;
    private int mX;
    private int mY;
    private int mZ;

    public enum Action {
        START,
        MOVEMENT,
        END
    }

    protected ObjectPresence() {
    }

    public static <T extends ObjectPresence> T create(Class<T> cls, long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        try {
            T t = (ObjectPresence) cls.newInstance();
            t.mTimestamp = j;
            t.mObjectId = i;
            t.mAction = Action.values()[i2];
            t.mX = i3;
            t.mY = i4;
            t.mZ = i5;
            t.mPrevX = i6;
            t.mPrevY = i7;
            t.mPrevZ = i8;
            t.mWidth = i9;
            t.mHeight = i10;
            return t;
        } catch (InstantiationException e) {
            Log.e(LOG_TAG, String.format("Failed creating instance of class %s", new Object[]{cls.getName()}), e);
            return null;
        } catch (IllegalAccessException e2) {
            Log.e(LOG_TAG, String.format("Failed accessing constructor of class %s", new Object[]{cls.getName()}), e2);
            return null;
        }
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public int getObjectId() {
        return this.mObjectId;
    }

    public Action getAction() {
        return this.mAction;
    }

    public int getCenterX() {
        return this.mX;
    }

    public int getCenterY() {
        return this.mY;
    }

    public int getZ() {
        return this.mZ;
    }

    public int getPrevCenterX() {
        return this.mPrevX;
    }

    public int getPrevCenterY() {
        return this.mPrevY;
    }

    public int getPrevZ() {
        return this.mPrevZ;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }
}
