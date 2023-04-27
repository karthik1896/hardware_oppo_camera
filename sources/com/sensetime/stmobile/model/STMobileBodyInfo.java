package com.sensetime.stmobile.model;

public class STMobileBodyInfo {
    public long bodyAction;
    public float bodyActionScore;
    public STPoint[] contourPoints;
    public int contourPointsCount;
    public float[] contourPointsScore;
    public int id;
    public STPoint[] keyPoints;
    public int keyPointsCount;
    public float[] keyPointsScore;

    public STPoint[] getKeyPoints() {
        return this.keyPoints;
    }

    public float[] getKeyPointsScore() {
        return this.keyPointsScore;
    }

    public STPoint[] getContourPoints() {
        return this.contourPoints;
    }

    public float[] getContourPointsScore() {
        return this.contourPointsScore;
    }
}
