package com.sensetime.stmobile.model;

public class STStickerInputParams {
    float[] cameraQuaternion;
    int customEvent;
    boolean isFrontCamera;
    int quaternionLength;

    public STStickerInputParams(float[] fArr, boolean z, int i) {
        if (fArr != null) {
            this.cameraQuaternion = fArr;
            this.quaternionLength = fArr.length;
        } else {
            this.cameraQuaternion = null;
            this.quaternionLength = 0;
        }
        this.isFrontCamera = z;
        this.customEvent = i;
    }
}
