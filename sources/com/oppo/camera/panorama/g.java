package com.oppo.camera.panorama;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Image;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.arcsoft.camera.burstpmk.ArcBurstPMKDef;
import com.arcsoft.camera.burstpmk.BurstPMKEngine;
import com.arcsoft.camera.burstpmk.BurstPMKInitParameter;
import com.arcsoft.camera.burstpmk.ProcessResult;
import com.oppo.camera.Camera;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;
import java.nio.ByteBuffer;

/* compiled from: RearPanoramaEngine */
public class g implements BurstPMKEngine.PMKListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public BurstPMKEngine f3498a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public BurstPMKInitParameter f3499b = null;
    private final int c = 2050;
    /* access modifiers changed from: private */
    public int d = 1;
    /* access modifiers changed from: private */
    public int e = 0;
    /* access modifiers changed from: private */
    public int f = 0;
    /* access modifiers changed from: private */
    public int g = 0;
    /* access modifiers changed from: private */
    public Handler h = null;
    private a i = null;
    private SensorManager j = null;
    private Sensor k = null;
    private Image l = null;
    private SensorEventListener m = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            int type = sensorEvent.sensor.getType();
            if (4 == type && g.this.f3498a != null) {
                g.this.f3498a.PushSensorDataIn(type, sensorEvent.values, sensorEvent.timestamp);
            }
        }
    };

    /* compiled from: RearPanoramaEngine */
    public interface a {
        void a(ProcessResult processResult);

        void b(ProcessResult processResult);

        void fC();
    }

    public g(Context context, int i2, int i3, a aVar) {
        this.e = i2;
        this.f = i3;
        this.g = Util.d(this.e, CameraConfig.getConfigIntValue(ConfigDataBase.KEY_ALIGNED_BITS));
        this.i = aVar;
        HandlerThread handlerThread = new HandlerThread("com/arcsoft/rearpanorama");
        handlerThread.start();
        if (this.h == null) {
            this.h = new Handler(handlerThread.getLooper()) {
                public void handleMessage(Message message) {
                    int i = message.what;
                    if (i == 1) {
                        int i2 = message.arg1;
                        g gVar = g.this;
                        BurstPMKEngine unused = gVar.f3498a = new BurstPMKEngine(gVar, gVar.h.getLooper(), ArcBurstPMKDef.DEFAUT_JNI_LIB_NAME);
                        g gVar2 = g.this;
                        BurstPMKInitParameter unused2 = gVar2.f3499b = BurstPMKInitParameter.getDefaultInitParams(gVar2.e, g.this.f, 2050, g.this.d);
                        if (3 == i2) {
                            g.this.f3499b.deviceDirection = 3;
                        } else if (2 == i2) {
                            g.this.f3499b.deviceDirection = 2;
                        }
                        g.this.f3498a.Init(g.this.f3499b);
                    } else if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i == 5) {
                                    Image image = (Image) message.obj;
                                    if (g.this.f3498a != null) {
                                        int Process = g.this.f3498a.Process(new ByteBuffer[]{image.getPlanes()[0].getBuffer(), image.getPlanes()[2].getBuffer()}, g.this.g);
                                        if (Util.b()) {
                                            byte[] a2 = Util.a(image, 17);
                                            Util.a(a2, "dump_rear", System.currentTimeMillis() + "_" + g.this.e + "x" + g.this.f);
                                        }
                                        if (28682 == Process) {
                                            removeMessages(3);
                                            sendEmptyMessage(3);
                                        }
                                    }
                                    image.close();
                                }
                            } else if (g.this.f3498a != null && 28682 == g.this.f3498a.Process((ByteBuffer[]) message.obj, g.this.g)) {
                                removeMessages(3);
                                sendEmptyMessage(3);
                            }
                        } else if (g.this.f3498a != null) {
                            g.this.f3498a.StopProcessing();
                        }
                    } else if (g.this.f3498a != null) {
                        g.this.f3498a.Uninit();
                    }
                }
            };
        }
        this.j = (SensorManager) context.getSystemService("sensor");
        this.k = this.j.getDefaultSensor(4);
    }

    public void a(int i2) {
        Sensor sensor;
        e.a("RearPanoramaEngine", "init, direction: " + i2);
        Handler handler = this.h;
        if (handler != null) {
            handler.removeMessages(1);
            Message obtainMessage = this.h.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.arg1 = i2;
            this.h.sendMessage(obtainMessage);
            SensorManager sensorManager = this.j;
            if (sensorManager != null && (sensor = this.k) != null) {
                sensorManager.registerListener(this.m, sensor, 10000, this.h);
            }
        }
    }

    public void a() {
        e.a("RearPanoramaEngine", "uninit");
        Handler handler = this.h;
        if (handler != null) {
            handler.removeMessages(2);
            this.h.sendEmptyMessage(2);
        }
        SensorManager sensorManager = this.j;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.m);
        }
    }

    public void b() {
        e.a("RearPanoramaEngine", "destroy");
        Handler handler = this.h;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.h = null;
        }
    }

    public void a(ByteBuffer[] byteBufferArr) {
        if (this.h != null) {
            if (Camera.l || Camera.m) {
                this.h.removeMessages(4);
            }
            this.h.obtainMessage(4, byteBufferArr).sendToTarget();
        }
    }

    public void a(Image image) {
        Handler handler = this.h;
        if (handler != null) {
            Image image2 = this.l;
            if (image2 != null && handler.hasMessages(5, image2)) {
                this.h.removeMessages(5, this.l);
                e.d("RearPanoramaEngine", "onSendImage, skip image process! timestamp:" + this.l.getTimestamp());
                this.l.close();
            }
            this.h.obtainMessage(5, image).sendToTarget();
            this.l = image;
            return;
        }
        image.close();
    }

    public void c() {
        e.a("RearPanoramaEngine", "stopProcessing");
        Handler handler = this.h;
        if (handler != null) {
            Image image = this.l;
            if (image != null && handler.hasMessages(5, image)) {
                this.h.removeMessages(5, this.l);
                this.l.close();
            }
            this.h.removeMessages(4);
            this.h.removeMessages(3);
            this.h.sendEmptyMessage(3);
        }
    }

    public int onPMKNotify(int i2, Object obj) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            e.a("RearPanoramaEngine", "onPMKNotify, onCaptureSuccess");
            this.i.a((ProcessResult) obj);
            return 0;
        } else if (i2 == 3) {
            e.a("RearPanoramaEngine", "onPMKNotify, onCaptureFailed");
            this.i.fC();
            return 0;
        } else if (i2 != 4) {
            return 0;
        } else {
            this.i.b((ProcessResult) obj);
            return 0;
        }
    }
}
