package com.sensetime.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.oppo.camera.e;
import java.util.ArrayList;
import java.util.Iterator;

public class ShakeDetectorUtils implements SensorEventListener {
    private static final String TAG = "ShakeDetectorUtils";
    private static ShakeDetectorUtils sInstance;
    private int mIntervalTime = 20;
    private long mLastDetectTime;
    private float mLastX;
    private float mLastY;
    private float mLastZ;
    private ArrayList<OnShakeListener> mListeners;
    private SensorManager mSensorManager;
    private boolean mShaking;
    private float mThreshold = 0.08f;

    public interface OnShakeListener {
        void onShake(boolean z);
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    private ShakeDetectorUtils(Context context) {
        this.mSensorManager = (SensorManager) context.getSystemService("sensor");
        this.mListeners = new ArrayList<>();
    }

    public static ShakeDetectorUtils getInstance(Context context) {
        synchronized (ShakeDetectorUtils.class) {
            if (sInstance != null) {
                ShakeDetectorUtils shakeDetectorUtils = sInstance;
                return shakeDetectorUtils;
            }
            if (sInstance == null) {
                sInstance = new ShakeDetectorUtils(context);
            }
            ShakeDetectorUtils shakeDetectorUtils2 = sInstance;
            return shakeDetectorUtils2;
        }
    }

    public void start() {
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager == null) {
            e.e(TAG, "start, mSensorManager is null");
            return;
        }
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        if (defaultSensor != null) {
            this.mSensorManager.registerListener(this, defaultSensor, 1);
        } else {
            e.e(TAG, "start, sensor is null");
        }
    }

    public void stop() {
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }

    public ShakeDetectorUtils registerOnShakeListener(OnShakeListener onShakeListener) {
        if (!this.mListeners.contains(onShakeListener)) {
            this.mListeners.add(onShakeListener);
        }
        return this;
    }

    public ShakeDetectorUtils unregisterOnShakeListener(OnShakeListener onShakeListener) {
        this.mListeners.remove(onShakeListener);
        return this;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.mLastDetectTime;
        if (j >= ((long) this.mIntervalTime)) {
            this.mLastDetectTime = currentTimeMillis;
            boolean z = false;
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            float f4 = f - this.mLastX;
            float f5 = f2 - this.mLastY;
            float f6 = f3 - this.mLastZ;
            this.mLastX = f;
            this.mLastY = f2;
            this.mLastZ = f3;
            if (((float) Math.sqrt((double) (((f4 * f4) + (f5 * f5)) + (f6 * f6)))) / ((float) j) > this.mThreshold) {
                z = true;
            }
            this.mShaking = z;
            notifyListeners(this.mShaking);
        }
    }

    private void notifyListeners(boolean z) {
        Iterator<OnShakeListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onShake(z);
        }
    }

    public boolean isShaking() {
        return this.mShaking;
    }

    public void setThreshold(float f) {
        this.mThreshold = f;
    }

    public float getThreshold() {
        return this.mThreshold;
    }
}
