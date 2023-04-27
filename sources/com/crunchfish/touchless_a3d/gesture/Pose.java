package com.crunchfish.touchless_a3d.gesture;

import android.graphics.Rect;
import com.crunchfish.touchless_a3d.gesture.Identifiable;

public class Pose extends Identifiable {
    private final int mObjectType;
    private final Rect mRect;

    Pose(String str, int i, int i2, int i3, int i4, int i5) {
        super(Identifiable.Type.POSE, str);
        this.mObjectType = i;
        this.mRect = new Rect(i2, i3, i4, i5);
    }

    public int getPoseType() {
        return this.mObjectType;
    }

    public Rect getBoundingArea() {
        return this.mRect;
    }

    public String toString() {
        return "Pose{id='" + getId() + "', objectType=" + this.mObjectType + ", bounds={" + this.mRect.toShortString() + "}}";
    }
}
