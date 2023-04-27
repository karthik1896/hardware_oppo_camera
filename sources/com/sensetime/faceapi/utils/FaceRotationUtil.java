package com.sensetime.faceapi.utils;

import android.graphics.PointF;
import android.graphics.Rect;
import com.sensetime.faceapi.model.FaceInfo;

public class FaceRotationUtil {
    public static void rotateFaceInfos(FaceInfo[] faceInfoArr, int i, int i2, boolean z, int i3) {
        if (faceInfoArr != null && faceInfoArr.length != 0) {
            for (FaceInfo rotateFaceInfo : faceInfoArr) {
                rotateFaceInfo(rotateFaceInfo, i, i2, z, i3);
            }
        }
    }

    public static void rotateFaceInfo(FaceInfo faceInfo, int i, int i2, boolean z, int i3) {
        if (faceInfo != null) {
            rotateFaceRect(faceInfo.faceRect, i, i2, z, i3);
            PointF[] pointFArr = faceInfo.facePoints;
            for (PointF rotatePoints : pointFArr) {
                rotatePoints(rotatePoints, i, i2, z, i3);
            }
        }
    }

    public static Rect rotateFaceRect(Rect rect, int i, int i2, boolean z, int i3) {
        if (i3 != 0) {
            if (i3 == 90) {
                int i4 = rect.left;
                rect.left = i2 - rect.bottom;
                rect.bottom = rect.right;
                rect.right = i2 - rect.top;
                rect.top = i4;
                if (z) {
                    int i5 = rect.top;
                    rect.top = i - rect.bottom;
                    rect.bottom = i - i5;
                }
            } else if (i3 == 180) {
                rect.top = i2 - rect.top;
                rect.bottom = i2 - rect.bottom;
                if (!z) {
                    rect.left = i - rect.left;
                    rect.right = i - rect.right;
                }
            } else if (i3 == 270) {
                int i6 = rect.left;
                rect.left = i2 - rect.bottom;
                rect.bottom = rect.right;
                rect.right = i2 - rect.top;
                rect.top = i6;
                int i7 = rect.left;
                rect.left = i2 - rect.right;
                rect.right = i2 - i7;
                if (!z) {
                    int i8 = rect.top;
                    rect.top = i - rect.bottom;
                    rect.bottom = i - i8;
                }
            }
        } else if (z) {
            rect.left = i - rect.left;
            rect.right = i - rect.right;
        }
        return rect;
    }

    public static PointF rotatePoints(PointF pointF, int i, int i2, boolean z, int i3) {
        if (i3 != 0) {
            if (i3 == 90) {
                float f = pointF.x;
                pointF.x = ((float) i2) - pointF.y;
                pointF.y = f;
                if (z) {
                    pointF.y = ((float) i) - pointF.y;
                }
            } else if (i3 == 180) {
                pointF.y = ((float) i2) - pointF.y;
                if (!z) {
                    pointF.x = ((float) i) - pointF.x;
                }
            } else if (i3 == 270) {
                float f2 = pointF.y;
                pointF.y = pointF.x;
                pointF.x = f2;
                if (!z) {
                    pointF.y = ((float) i) - pointF.y;
                }
            }
        } else if (z) {
            pointF.x = ((float) i) - pointF.x;
        }
        return pointF;
    }
}
