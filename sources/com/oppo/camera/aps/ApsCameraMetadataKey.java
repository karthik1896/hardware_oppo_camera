package com.oppo.camera.aps;

import android.hardware.camera2.CaptureResult;

public class ApsCameraMetadataKey {
    public static final CaptureResult.Key<byte[]> KEY_APS_RESULT_DATA = new CaptureResult.Key<>("com.oplus.aps.result.data", byte[].class);
    public static final CaptureResult.Key<int[]> KEY_MASTER_PIPELINE = new CaptureResult.Key<>("com.oplus.aps.sat.snapshot.master.pipeline", int[].class);
    public static final CaptureResult.Key<int[]> KEY_SAT_SNAPSHOT_MASTER_PIPELINE = new CaptureResult.Key<>("com.oplus.aps.sat.snapshot.master.pipeline", int[].class);
    public static final CaptureResult.Key<int[]> KEY_SENSOR_MASK = new CaptureResult.Key<>("com.oplus.aps.sat.snapshot.sensors.mask", int[].class);
    public static final CaptureResult.Key<int[]> KEY_UPSCALE_INPUT_SIZE = new CaptureResult.Key<>("com.oplus.upscale.input.size", int[].class);
    public static final CaptureResult.Key<int[]> KEY_UPSCALE_OUTPUT_SIZE = new CaptureResult.Key<>("com.oplus.upscale.output.size", int[].class);
}
