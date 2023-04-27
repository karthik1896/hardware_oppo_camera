package com.sensetime.faceapi.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.sensetime.faceapi.model.FaceOrientation;

public class AccelerometerManager {
    private static AccelerometerManager instance;
    private AccelerometerSensorListener mAccListener;
    private boolean mHasStarted = false;
    private SensorManager mSensorManager;

    private AccelerometerManager() {
    }

    public static AccelerometerManager getInstance() {
        if (instance == null) {
            instance = new AccelerometerManager();
        }
        return instance;
    }

    public static void start(Context context) {
        getInstance().registerListener(context);
    }

    public static void stop() {
        getInstance().unregisterListener();
    }

    public static FaceOrientation getFaceOrientation(boolean z) {
        return getFaceOrientation(getDir(z));
    }

    public static FaceOrientation getFaceOrientation(int i) {
        if (i == 0) {
            return FaceOrientation.UP;
        }
        if (i == 1) {
            return FaceOrientation.LEFT;
        }
        if (i == 2) {
            return FaceOrientation.DOWN;
        }
        if (i != 3) {
            return FaceOrientation.UNKNOWN;
        }
        return FaceOrientation.RIGHT;
    }

    public static int getDegree(boolean z) {
        return getDir(z) * 90;
    }

    public static int getDegree() {
        return getDir() * 90;
    }

    public static int getDir(boolean z) {
        return getInstance().getDirection(z);
    }

    public static int getDir() {
        return getDir(false);
    }

    private int getDirection(boolean z) {
        AccelerometerSensorListener accelerometerSensorListener = this.mAccListener;
        if (accelerometerSensorListener == null) {
            return -1;
        }
        int access$000 = accelerometerSensorListener.dir;
        return (!z || (access$000 & 1) != 1) ? access$000 : access$000 ^ 2;
    }

    private void registerListener(Context context) {
        if (!this.mHasStarted) {
            this.mHasStarted = true;
            this.mSensorManager = (SensorManager) context.getApplicationContext().getSystemService("sensor");
            Sensor defaultSensor = this.mSensorManager.getDefaultSensor(1);
            if (defaultSensor != null) {
                this.mAccListener = new AccelerometerSensorListener();
                this.mSensorManager.registerListener(this.mAccListener, defaultSensor, 3);
            }
        }
    }

    private void unregisterListener() {
        SensorManager sensorManager;
        if (this.mHasStarted && (sensorManager = this.mSensorManager) != null) {
            this.mHasStarted = false;
            sensorManager.unregisterListener(this.mAccListener);
        }
    }

    private class AccelerometerSensorListener implements SensorEventListener {
        /* access modifiers changed from: private */
        public int dir;

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        private AccelerometerSensorListener() {
            this.dir = -1;
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 1) {
                float f = sensorEvent.values[0];
                float f2 = sensorEvent.values[1];
                if (Math.abs(f) <= 0.5f && Math.abs(f2) <= 0.5f) {
                    return;
                }
                if (Math.abs(f) > Math.abs(f2)) {
                    if (f > 0.0f) {
                        this.dir = 0;
                    } else {
                        this.dir = 2;
                    }
                } else if (f2 > 0.0f) {
                    this.dir = 1;
                } else {
                    this.dir = 3;
                }
            }
        }
    }
}
