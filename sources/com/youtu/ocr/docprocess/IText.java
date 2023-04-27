package com.youtu.ocr.docprocess;

import android.graphics.Point;

public interface IText {

    public static class DetectResult {
        public boolean hasResult;
        public Point[] pointArr;

        public DetectResult() {
        }

        public DetectResult(boolean z) {
            this.hasResult = z;
        }

        public DetectResult(boolean z, Point[] pointArr2) {
            this.hasResult = z;
            this.pointArr = pointArr2;
        }

        public void setHasResult(boolean z) {
            this.hasResult = z;
        }

        public void setPointArr(Point[] pointArr2) {
            this.pointArr = pointArr2;
        }

        public boolean getHasResult() {
            return this.hasResult;
        }

        public Point[] getPointArr() {
            return this.pointArr;
        }

        public void clearPointArr() {
            int i = 0;
            while (true) {
                Point[] pointArr2 = this.pointArr;
                if (i < pointArr2.length) {
                    pointArr2[i].x = -1;
                    pointArr2[i].y = -1;
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
