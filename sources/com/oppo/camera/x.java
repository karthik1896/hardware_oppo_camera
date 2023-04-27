package com.oppo.camera;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* compiled from: SensorManagerClient */
public class x {

    /* renamed from: a  reason: collision with root package name */
    private Context f3170a = null;

    /* renamed from: b  reason: collision with root package name */
    private SensorManager f3171b = null;
    private Sensor c = null;
    private Sensor d = null;
    private SensorEventListener e = null;
    private SensorEventListener f = null;
    /* access modifiers changed from: private */
    public c g = null;
    /* access modifiers changed from: private */
    public float[] h = new float[3];

    /* compiled from: SensorManagerClient */
    public interface c {
        void a();

        void b();
    }

    public void a(c cVar) {
        this.g = cVar;
    }

    public x(Context context) {
        this.f3170a = context;
    }

    public boolean a() {
        return this.c != null;
    }

    public void b() {
        this.f3171b = null;
    }

    public void a(int i) {
        if ((i & 1) != 0) {
            d();
        }
        if ((i & 4) != 0) {
            e();
        }
    }

    public void b(int i) {
        if ((i & 1) != 0) {
            g();
        }
        if ((i & 4) != 0) {
            f();
        }
    }

    private void d() {
        e.a("SensorManagerClient", "registerGyroSensor");
        if (this.e == null) {
            try {
                if (this.f3171b == null) {
                    this.f3171b = (SensorManager) this.f3170a.getSystemService("sensor");
                }
                if (this.c == null) {
                    this.c = this.f3171b.getDefaultSensor(4);
                }
                this.e = new b();
                this.f3171b.registerListener(this.e, this.c, 3);
            } catch (Exception e2) {
                e.a("SensorManagerClient", "registerGproSensor, Exception: " + e2.toString());
            }
        }
    }

    private void e() {
        e.a("SensorManagerClient", "registerAccelerometerListener");
        if (this.f == null) {
            try {
                if (this.f3171b == null) {
                    this.f3171b = (SensorManager) this.f3170a.getSystemService("sensor");
                }
                if (this.d == null) {
                    this.d = this.f3171b.getDefaultSensor(1);
                }
                this.f = new a();
                this.f3171b.registerListener(this.f, this.d, 3);
            } catch (Exception e2) {
                e.e("SensorManagerClient", "registerAccelerometerListener, Exception: " + e2.toString());
            }
        }
    }

    private void f() {
        SensorManager sensorManager;
        e.a("SensorManagerClient", "unregisterAccelerometerListener");
        SensorEventListener sensorEventListener = this.f;
        if (!(sensorEventListener == null || (sensorManager = this.f3171b) == null)) {
            sensorManager.unregisterListener(sensorEventListener);
            this.f = null;
        }
        this.d = null;
    }

    private void g() {
        SensorManager sensorManager;
        e.a("SensorManagerClient", "unregisterGyroSensor");
        SensorEventListener sensorEventListener = this.e;
        if (!(sensorEventListener == null || (sensorManager = this.f3171b) == null)) {
            sensorManager.unregisterListener(sensorEventListener);
            this.e = null;
        }
        this.c = null;
    }

    /* compiled from: SensorManagerClient */
    private class a implements SensorEventListener {
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        private a() {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            if (1 == sensorEvent.sensor.getType()) {
                x.this.h[0] = sensorEvent.values[0];
                x.this.h[1] = sensorEvent.values[1];
                x.this.h[2] = sensorEvent.values[2];
            }
        }
    }

    /* compiled from: SensorManagerClient */
    private class b implements SensorEventListener {

        /* renamed from: a  reason: collision with root package name */
        int f3173a;

        /* renamed from: b  reason: collision with root package name */
        float f3174b;

        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        private b() {
            this.f3173a = 0;
            this.f3174b = 0.0f;
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            boolean z = false;
            float abs = Math.abs(sensorEvent.values[0]) + Math.abs(sensorEvent.values[1]) + Math.abs(sensorEvent.values[2]);
            int i = this.f3173a;
            if (i % 5 == 0) {
                this.f3174b = abs;
                this.f3173a = 1;
            } else {
                this.f3174b += abs;
                this.f3173a = i + 1;
            }
            float f = this.f3174b;
            if (1.6f <= f) {
                a();
            } else if (0.8f <= f) {
                b();
            }
            if (this.f3174b >= t.a()) {
                z = true;
            }
            t.a(z);
        }

        public void a() {
            if (x.this.g != null) {
                x.this.g.a();
            }
        }

        public void b() {
            if (x.this.g != null) {
                x.this.g.b();
            }
        }
    }

    public float[] c() {
        return this.h;
    }
}
