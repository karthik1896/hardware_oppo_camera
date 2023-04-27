package com.sensetime.faceapi.model;

import android.graphics.PointF;
import android.graphics.Rect;

public class FaceInfo {
    public float eyeDist;
    public PointF[] facePoints;
    public Rect faceRect;
    public int id;
    public float pitch;
    public float roll;
    public float score;
    public float yaw;

    public FaceInfo clone() {
        FaceInfo faceInfo = new FaceInfo();
        faceInfo.faceRect = new Rect();
        faceInfo.facePoints = new PointF[this.facePoints.length];
        faceInfo.faceRect.set(this.faceRect);
        int i = 0;
        while (true) {
            PointF[] pointFArr = faceInfo.facePoints;
            if (i < pointFArr.length) {
                pointFArr[i] = new PointF();
                faceInfo.facePoints[i].set(this.facePoints[i]);
                i++;
            } else {
                faceInfo.id = this.id;
                faceInfo.score = this.score;
                faceInfo.yaw = this.yaw;
                faceInfo.pitch = this.pitch;
                faceInfo.roll = this.roll;
                faceInfo.eyeDist = this.eyeDist;
                return faceInfo;
            }
        }
    }

    public String toString() {
        return "FaceInfo(" + this.faceRect + ", " + this.score + ")";
    }
}
