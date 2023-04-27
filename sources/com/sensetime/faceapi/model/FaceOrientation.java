package com.sensetime.faceapi.model;

public enum FaceOrientation {
    UP(1),
    LEFT(2),
    DOWN(4),
    RIGHT(8),
    UNKNOWN(15);
    
    private static FaceOrientation[] sFaceOrientations;
    final int nativeInt;

    static {
        FaceOrientation faceOrientation;
        FaceOrientation faceOrientation2;
        FaceOrientation faceOrientation3;
        FaceOrientation faceOrientation4;
        FaceOrientation faceOrientation5;
        sFaceOrientations = new FaceOrientation[]{null, faceOrientation, faceOrientation2, null, faceOrientation3, null, null, null, faceOrientation4, null, null, null, null, null, null, faceOrientation5};
    }

    private FaceOrientation(int i) {
        this.nativeInt = i;
    }

    public int getValue() {
        return this.nativeInt;
    }

    public static FaceOrientation nativeToOrientation(int i) {
        return sFaceOrientations[i];
    }
}
