package com.crunchfish.touchless_a3d.active_area;

import android.graphics.Rect;
import android.graphics.Region;

public final class ActiveArea {
    private static final int COORDINATES_PER_CORNER = 2;
    private static final int COORDINATES_PER_RECTANGLE = 4;
    private static final int CORNERS_PER_RECTANGLE = 2;
    private final Region mRegion = new Region();

    public interface Listener {
        void onActiveArea(ActiveArea activeArea);
    }

    private void addSubAreas(int[] iArr) throws IllegalArgumentException {
        if (iArr.length % 4 == 0) {
            for (int i = 0; i < iArr.length; i += 4) {
                addSubArea(iArr[i], iArr[i + 1], iArr[i + 2], iArr[i + 3]);
            }
            return;
        }
        throw new IllegalArgumentException("Missing coordinates from array");
    }

    private void addSubArea(int i, int i2, int i3, int i4) {
        this.mRegion.union(new Rect(i, i2, i3 + 1, i4 + 1));
    }

    public Region getRegion() {
        return this.mRegion;
    }
}
