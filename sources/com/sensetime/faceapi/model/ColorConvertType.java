package com.sensetime.faceapi.model;

public enum ColorConvertType {
    NV212BGRA(1),
    NV212RGBA(2),
    RGBA2NV21(3),
    NV122BGRA(5),
    BGRA2RGBA(14),
    RGBA2NV12(20),
    NV122RGBA(21),
    RGBA2BGRA(101),
    NV212BGR(1001);
    
    final int nativeInt;

    private ColorConvertType(int i) {
        this.nativeInt = i;
    }

    public int getValue() {
        return this.nativeInt;
    }
}
