package com.sensetime.stmobile.model;

public class STHumanAction {
    public float backGroundScore;
    public int bodyCount;
    public STMobileBodyInfo[] bodys;
    public float cameraMotionScore;
    public int faceCount;
    public STMobileFaceInfo[] faces;
    public STImage hair;
    public float hairScore;
    public int handCount;
    public STMobileHandInfo[] hands;
    public STImage image;

    public static native STHumanAction humanActionMirror(int i, STHumanAction sTHumanAction);

    public static native STHumanAction humanActionResize(float f, STHumanAction sTHumanAction);

    public static native STHumanAction humanActionRotate(int i, int i2, int i3, boolean z, STHumanAction sTHumanAction);

    public STMobile106[] getMobileFaces() {
        int i = this.faceCount;
        if (i == 0) {
            return null;
        }
        STMobile106[] sTMobile106Arr = new STMobile106[i];
        for (int i2 = 0; i2 < this.faceCount; i2++) {
            sTMobile106Arr[i2] = this.faces[i2].face106;
        }
        return sTMobile106Arr;
    }

    public boolean replaceMobile106(STMobile106[] sTMobile106Arr) {
        if (sTMobile106Arr == null || sTMobile106Arr.length == 0 || this.faces == null || this.faceCount != sTMobile106Arr.length) {
            return false;
        }
        for (int i = 0; i < sTMobile106Arr.length; i++) {
            this.faces[i].face106 = sTMobile106Arr[i];
        }
        return true;
    }

    public STMobileFaceInfo[] getFaceInfos() {
        if (this.faceCount == 0) {
            return null;
        }
        return this.faces;
    }

    public STMobileHandInfo[] getHandInfos() {
        if (this.handCount == 0) {
            return null;
        }
        return this.hands;
    }

    public STImage getImage() {
        return this.image;
    }

    public STImage getHair() {
        return this.hair;
    }

    public static STHumanAction humanActionRotateAndMirror(STHumanAction sTHumanAction, int i, int i2, int i3, int i4) {
        if (sTHumanAction == null) {
            return null;
        }
        if (i3 != 1 && i3 != 0) {
            return sTHumanAction;
        }
        if (i4 != 90 && i4 != 270) {
            return sTHumanAction;
        }
        if (i3 == 1 && i4 == 90) {
            return humanActionMirror(i, humanActionRotate(i2, i, 1, false, sTHumanAction));
        }
        if (i3 == 1 && i4 == 270) {
            return humanActionMirror(i, humanActionRotate(i2, i, 3, false, sTHumanAction));
        }
        if (i3 == 0 && i4 == 270) {
            return humanActionRotate(i2, i, 3, false, sTHumanAction);
        }
        return (i3 == 0 && i4 == 90) ? humanActionRotate(i2, i, 1, false, sTHumanAction) : sTHumanAction;
    }
}
