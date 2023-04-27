package com.arcsoft.camera.burstpmk;

import android.graphics.Point;
import android.graphics.Rect;

public class ProcessResult {
    public int direction = -1;
    public int format = -1;
    public int height = 0;
    public byte[] imageData = null;
    public Point outputOffset = null;
    public int[] pitchs = null;
    public int progress = 0;
    public byte[] rotatedImageData = null;
    public byte[] smallImageData;
    public byte[] smallPreviewData = null;
    public int smallPreviewH = 0;
    public int smallPreviewW = 0;
    public Rect updateRect = null;
    public Rect updateSmallImageRect = null;
    public int width = 0;
}
