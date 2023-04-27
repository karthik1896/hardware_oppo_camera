package com.oppo.camera.tiltshift;

import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Size;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.oppo.camera.R;
import com.oppo.camera.e.b;
import com.oppo.camera.k;
import com.oppo.camera.ui.e;

public class TiltShiftManager {
    private static final long DELAY_RESET_ADJUSTING_STATE_DURATION = 300;
    private static final float INIT_TILT_SHIFT_RADIUS = 300.0f;
    private static final int MSG_RESET_ADJUSTING_STATE = 1;
    private static final String TAG = "TiltShiftManager";
    private Activity mActivity = null;
    private b mCameraInterface = null;
    private CameraTiltShiftListener mCameraTiltShiftListener = null;
    private e mCameraUIInterface = null;
    private double mCurrentTiltShiftCenterX = 1.0d;
    private double mCurrentTiltShiftCenterY = 1.0d;
    private double mCurrentTiltShiftDegree = 0.0d;
    private float mCurrentTiltShiftRadius = INIT_TILT_SHIFT_RADIUS;
    private double mCurrentTiltShiftRotation = 0.0d;
    private Mode mGestureMode = Mode.NONE;
    private Handler mMainHandler = null;
    private float mMaxTiltShiftRadiusRatio = 0.5f;
    private float mMinTiltShiftRadiusRatio = 0.1f;
    private PointF mPoint1 = null;
    private PointF mPoint2 = null;
    private PointF mPoint3 = null;
    private PointF mPoint4 = null;
    private k mPreferences = null;
    private Rect mPreviewArea = null;
    private int mPreviewAreaBottom = 0;
    private int mPreviewAreaHeight = 0;
    private int mPreviewAreaLeft = 0;
    private int mPreviewAreaRight = 0;
    private int mPreviewAreaTop = 0;
    private int mPreviewAreaWidth = 0;
    private int mPreviewHeight = 0;
    private ViewGroup mPreviewLayout = null;
    private Size mPreviewSize = null;
    private int mPreviewWidth = 0;
    private TiltShiftParam mTiltShiftParam = new TiltShiftParam();
    private float mTouchDegree = 0.0f;
    private float mTouchDownX = 0.0f;
    private float mTouchDownY = 0.0f;
    private float mTouchRotation = 0.0f;
    private float mTouchScale = 1.0f;
    private float mTouchSpacing = 0.0f;
    private float mTouchTiltShiftDegree = 0.0f;
    private float mTouchTiltShiftRadius = 0.0f;
    private double mTouchTiltShiftX = 0.0d;
    private double mTouchTiltShiftY = 0.0d;
    private float mTouchTranslationX = 0.0f;
    private float mTouchTranslationY = 0.0f;
    private boolean mbCircle = false;
    private boolean mbCurrentTiltShiftAdjusting = false;

    public interface CameraTiltShiftListener {
        boolean getSupportTiltShif();

        boolean getTiltShifGestureEnabled();

        boolean isEffectMenuAnimRunning();

        void setTiltShiftParams(TiltShiftParam tiltShiftParam);
    }

    enum Mode {
        NONE,
        SCALE,
        MOVE,
        ROTATE
    }

    public TiltShiftManager(Activity activity, k kVar, b bVar, e eVar) {
        this.mActivity = activity;
        this.mPreferences = kVar;
        this.mCameraInterface = bVar;
        this.mCameraUIInterface = eVar;
        this.mPreviewLayout = (ViewGroup) this.mActivity.findViewById(R.id.frame_layout);
        initMainHandler();
    }

    private void initMainHandler() {
        this.mMainHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    TiltShiftManager.this.resetAjustingState();
                }
            }
        };
    }

    public void setCameraTiltShiftListener(CameraTiltShiftListener cameraTiltShiftListener) {
        this.mCameraTiltShiftListener = cameraTiltShiftListener;
    }

    public void onPause() {
        Handler handler = this.mMainHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void initialize(Size size, Rect rect) {
        com.oppo.camera.e.a(TAG, "initialize, previewSize: " + size + ", previewArea: " + rect);
        this.mPreviewSize = size;
        this.mPreviewArea = rect;
        Rect rect2 = this.mPreviewArea;
        if (rect2 != null) {
            this.mPreviewAreaTop = rect2.top;
            this.mPreviewAreaLeft = this.mPreviewArea.left;
            this.mPreviewAreaRight = this.mPreviewArea.right;
            this.mPreviewAreaBottom = this.mPreviewArea.bottom;
            this.mPreviewAreaWidth = this.mPreviewArea.width();
            this.mPreviewAreaHeight = this.mPreviewArea.height();
        }
        initTiftShiftPoint();
        this.mTiltShiftParam.setPreviewSize(this.mPreviewSize);
    }

    private void initTiftShiftPoint() {
        int i = this.mPreviewAreaRight;
        int i2 = this.mPreviewAreaLeft;
        this.mCurrentTiltShiftCenterX = (double) ((i - i2) / 2);
        int i3 = this.mPreviewAreaBottom;
        int i4 = this.mPreviewAreaTop;
        this.mCurrentTiltShiftCenterY = (double) ((i3 - i4) / 2);
        this.mPreviewWidth = i - i2;
        this.mPreviewHeight = i3 - i4;
        this.mCurrentTiltShiftDegree = 0.0d;
        this.mCurrentTiltShiftRotation = Math.toRadians(this.mCurrentTiltShiftDegree);
        this.mCurrentTiltShiftRadius = INIT_TILT_SHIFT_RADIUS;
        com.oppo.camera.e.a(TAG, "initTiftShiftPoint, mCurrentTiltShiftCenterX: " + this.mCurrentTiltShiftCenterX + ", mCurrentTiltShiftCenterY: " + this.mCurrentTiltShiftCenterY);
        calculateTiftShiftPoint();
    }

    private void reCalculateTiftShiftCenter() {
        this.mCurrentTiltShiftCenterX = (double) ((((this.mPoint1.x + this.mPoint2.x) + this.mPoint3.x) + this.mPoint4.x) / 4.0f);
        this.mCurrentTiltShiftCenterY = (double) ((((this.mPoint1.y + this.mPoint2.y) + this.mPoint3.y) + this.mPoint4.y) / 4.0f);
        calculateTiftShiftPoint();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x015e, code lost:
        if (r1 < 360.0d) goto L_0x0160;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void calculateTiftShiftPoint() {
        /*
            r24 = this;
            r0 = r24
            android.graphics.PointF r1 = new android.graphics.PointF
            r1.<init>()
            r0.mPoint1 = r1
            android.graphics.PointF r1 = new android.graphics.PointF
            r1.<init>()
            r0.mPoint2 = r1
            android.graphics.PointF r1 = new android.graphics.PointF
            r1.<init>()
            r0.mPoint3 = r1
            android.graphics.PointF r1 = new android.graphics.PointF
            r1.<init>()
            r0.mPoint4 = r1
            double r1 = r0.mCurrentTiltShiftDegree
            double r1 = java.lang.Math.toRadians(r1)
            r0.mCurrentTiltShiftRotation = r1
            double r1 = r0.mCurrentTiltShiftRotation
            double r3 = java.lang.Math.tan(r1)
            double r3 = java.lang.Math.abs(r3)
            double r5 = java.lang.Math.sin(r1)
            double r5 = java.lang.Math.abs(r5)
            double r1 = java.lang.Math.cos(r1)
            double r1 = java.lang.Math.abs(r1)
            r7 = 0
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            r10 = 4643457506423603200(0x4070e00000000000, double:270.0)
            r14 = 0
            if (r9 != 0) goto L_0x007c
            android.graphics.PointF r1 = r0.mPoint1
            r1.x = r14
            double r2 = r0.mCurrentTiltShiftCenterY
            float r4 = r0.mCurrentTiltShiftRadius
            double r5 = (double) r4
            double r5 = r2 - r5
            float r5 = (float) r5
            r1.y = r5
            android.graphics.PointF r1 = r0.mPoint2
            int r5 = r0.mPreviewAreaWidth
            float r6 = (float) r5
            r1.x = r6
            double r12 = (double) r4
            double r12 = r2 - r12
            float r6 = (float) r12
            r1.y = r6
            android.graphics.PointF r1 = r0.mPoint3
            r1.x = r14
            double r12 = (double) r4
            double r12 = r12 + r2
            float r6 = (float) r12
            r1.y = r6
            android.graphics.PointF r1 = r0.mPoint4
            float r5 = (float) r5
            r1.x = r5
            double r4 = (double) r4
            double r2 = r2 + r4
            float r2 = (float) r2
            r1.y = r2
            goto L_0x01c9
        L_0x007c:
            int r9 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x00af
            android.graphics.PointF r1 = r0.mPoint1
            double r2 = r0.mCurrentTiltShiftCenterX
            float r4 = r0.mCurrentTiltShiftRadius
            double r5 = (double) r4
            double r5 = r5 + r2
            float r5 = (float) r5
            r1.x = r5
            r1.y = r14
            android.graphics.PointF r1 = r0.mPoint2
            double r5 = (double) r4
            double r5 = r5 + r2
            float r5 = (float) r5
            r1.x = r5
            int r5 = r0.mPreviewAreaHeight
            float r6 = (float) r5
            r1.y = r6
            android.graphics.PointF r1 = r0.mPoint3
            double r12 = (double) r4
            double r12 = r2 - r12
            float r6 = (float) r12
            r1.x = r6
            r1.y = r14
            android.graphics.PointF r1 = r0.mPoint4
            double r12 = (double) r4
            double r2 = r2 - r12
            float r2 = (float) r2
            r1.x = r2
            float r2 = (float) r5
            r1.y = r2
            goto L_0x01c9
        L_0x00af:
            double r12 = r0.mCurrentTiltShiftDegree
            int r9 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            r16 = 4636033603912859648(0x4056800000000000, double:90.0)
            if (r9 <= 0) goto L_0x00be
            int r9 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r9 < 0) goto L_0x00cd
        L_0x00be:
            double r12 = r0.mCurrentTiltShiftDegree
            r18 = 4640537203540230144(0x4066800000000000, double:180.0)
            int r9 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1))
            if (r9 <= 0) goto L_0x013e
            int r9 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r9 >= 0) goto L_0x013e
        L_0x00cd:
            android.graphics.PointF r9 = r0.mPoint1
            double r12 = r0.mCurrentTiltShiftCenterX
            double r7 = r0.mCurrentTiltShiftCenterY
            double r16 = r7 / r3
            double r16 = r12 - r16
            float r14 = r0.mCurrentTiltShiftRadius
            double r10 = (double) r14
            double r10 = r10 / r5
            double r10 = r16 + r10
            float r10 = (float) r10
            r9.x = r10
            double r10 = r12 * r3
            double r10 = r7 - r10
            r20 = r5
            double r5 = (double) r14
            double r5 = r5 / r1
            double r10 = r10 - r5
            float r5 = (float) r10
            r9.y = r5
            android.graphics.PointF r5 = r0.mPoint2
            int r6 = r0.mPreviewHeight
            double r9 = (double) r6
            double r9 = r9 - r7
            double r9 = r9 / r3
            double r9 = r9 + r12
            r22 = r1
            double r1 = (double) r14
            double r1 = r1 / r20
            double r9 = r9 + r1
            float r1 = (float) r9
            r5.x = r1
            int r1 = r0.mPreviewWidth
            double r9 = (double) r1
            double r9 = r9 - r12
            double r9 = r9 * r3
            double r9 = r9 + r7
            r11 = r1
            double r1 = (double) r14
            double r1 = r1 / r22
            double r9 = r9 - r1
            float r1 = (float) r9
            r5.y = r1
            android.graphics.PointF r1 = r0.mPoint3
            double r9 = r7 / r3
            double r9 = r12 - r9
            r2 = r6
            double r5 = (double) r14
            double r5 = r5 / r20
            double r9 = r9 - r5
            float r5 = (float) r9
            r1.x = r5
            double r5 = r12 * r3
            double r5 = r7 - r5
            double r9 = (double) r14
            double r9 = r9 / r22
            double r5 = r5 + r9
            float r5 = (float) r5
            r1.y = r5
            android.graphics.PointF r1 = r0.mPoint4
            double r5 = (double) r2
            double r5 = r5 - r7
            double r5 = r5 / r3
            double r5 = r5 + r12
            double r9 = (double) r14
            double r9 = r9 / r20
            double r5 = r5 - r9
            float r2 = (float) r5
            r1.x = r2
            double r5 = (double) r11
            double r5 = r5 - r12
            double r5 = r5 * r3
            double r7 = r7 + r5
            double r2 = (double) r14
            double r2 = r2 / r22
            double r7 = r7 + r2
            float r2 = (float) r7
            r1.y = r2
            goto L_0x01c9
        L_0x013e:
            r22 = r1
            r20 = r5
            double r1 = r0.mCurrentTiltShiftDegree
            int r5 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r5 <= 0) goto L_0x014c
            int r1 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r1 < 0) goto L_0x0160
        L_0x014c:
            double r1 = r0.mCurrentTiltShiftDegree
            r5 = 4643457506423603200(0x4070e00000000000, double:270.0)
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x01c9
            r5 = 4645040803167600640(0x4076800000000000, double:360.0)
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x01c9
        L_0x0160:
            android.graphics.PointF r1 = r0.mPoint1
            double r5 = r0.mCurrentTiltShiftCenterX
            int r2 = r0.mPreviewHeight
            double r7 = (double) r2
            double r9 = r0.mCurrentTiltShiftCenterY
            double r7 = r7 - r9
            double r7 = r7 / r3
            double r7 = r5 - r7
            float r11 = r0.mCurrentTiltShiftRadius
            double r12 = (double) r11
            double r12 = r12 / r20
            double r7 = r7 - r12
            float r7 = (float) r7
            r1.x = r7
            double r7 = r5 * r3
            double r7 = r7 + r9
            double r12 = (double) r11
            double r12 = r12 / r22
            double r7 = r7 - r12
            float r7 = (float) r7
            r1.y = r7
            android.graphics.PointF r1 = r0.mPoint2
            double r7 = r9 / r3
            double r7 = r7 + r5
            double r12 = (double) r11
            double r12 = r12 / r20
            double r7 = r7 - r12
            float r7 = (float) r7
            r1.x = r7
            int r7 = r0.mPreviewWidth
            double r12 = (double) r7
            double r12 = r12 - r5
            double r12 = r12 * r3
            double r12 = r9 - r12
            double r14 = (double) r11
            double r14 = r14 / r22
            double r12 = r12 - r14
            float r8 = (float) r12
            r1.y = r8
            android.graphics.PointF r1 = r0.mPoint3
            double r12 = (double) r2
            double r12 = r12 - r9
            double r12 = r12 / r3
            double r12 = r5 - r12
            double r14 = (double) r11
            double r14 = r14 / r20
            double r12 = r12 + r14
            float r2 = (float) r12
            r1.x = r2
            double r12 = r5 * r3
            double r12 = r12 + r9
            double r14 = (double) r11
            double r14 = r14 / r22
            double r12 = r12 + r14
            float r2 = (float) r12
            r1.y = r2
            android.graphics.PointF r1 = r0.mPoint4
            double r12 = r9 / r3
            double r12 = r12 + r5
            double r14 = (double) r11
            double r14 = r14 / r20
            double r12 = r12 + r14
            float r2 = (float) r12
            r1.x = r2
            double r7 = (double) r7
            double r7 = r7 - r5
            double r7 = r7 * r3
            double r9 = r9 - r7
            double r2 = (double) r11
            double r2 = r2 / r22
            double r9 = r9 + r2
            float r2 = (float) r9
            r1.y = r2
        L_0x01c9:
            android.graphics.PointF r1 = r0.mPoint1
            r0.clampInPreviewArea(r1)
            android.graphics.PointF r1 = r0.mPoint2
            r0.clampInPreviewArea(r1)
            android.graphics.PointF r1 = r0.mPoint3
            r0.clampInPreviewArea(r1)
            android.graphics.PointF r1 = r0.mPoint4
            r0.clampInPreviewArea(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "calculateTiftShiftPoint, mCurrentTiltShiftRotation: "
            r1.append(r2)
            double r2 = r0.mCurrentTiltShiftRotation
            r1.append(r2)
            java.lang.String r2 = ", mCurrentTiltShiftRadius: "
            r1.append(r2)
            float r2 = r0.mCurrentTiltShiftRadius
            r1.append(r2)
            java.lang.String r2 = ", mCurrentTiltShiftDegree: "
            r1.append(r2)
            double r2 = r0.mCurrentTiltShiftDegree
            r1.append(r2)
            java.lang.String r2 = ", point1: "
            r1.append(r2)
            android.graphics.PointF r2 = r0.mPoint1
            r1.append(r2)
            java.lang.String r2 = ", point2: "
            r1.append(r2)
            android.graphics.PointF r2 = r0.mPoint2
            r1.append(r2)
            java.lang.String r2 = ", point3: "
            r1.append(r2)
            android.graphics.PointF r2 = r0.mPoint3
            r1.append(r2)
            java.lang.String r2 = ", point4: "
            r1.append(r2)
            android.graphics.PointF r2 = r0.mPoint4
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "TiltShiftManager"
            com.oppo.camera.e.a(r2, r1)
            com.oppo.camera.tiltshift.TiltShiftManager$CameraTiltShiftListener r1 = r0.mCameraTiltShiftListener
            if (r1 == 0) goto L_0x029e
            android.util.Size r1 = r0.mPreviewSize
            int r1 = r1.getHeight()
            float r1 = (float) r1
            int r2 = r0.mPreviewAreaWidth
            float r2 = (float) r2
            float r1 = r1 / r2
            double r2 = r0.mCurrentTiltShiftCenterX
            float r2 = (float) r2
            float r2 = r2 * r1
            double r3 = r0.mCurrentTiltShiftCenterY
            float r3 = (float) r3
            float r3 = r3 * r1
            float r4 = r0.mCurrentTiltShiftRadius
            float r4 = r4 * r1
            double r5 = r0.mCurrentTiltShiftDegree
            r7 = 4643457506423603200(0x4070e00000000000, double:270.0)
            double r5 = r5 + r7
            r7 = 4645040803167600640(0x4076800000000000, double:360.0)
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x025d
            double r5 = r5 - r7
        L_0x025d:
            r9 = 0
            int r1 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r1 >= 0) goto L_0x0264
            double r5 = r5 + r7
        L_0x0264:
            double r5 = -r5
            double r5 = java.lang.Math.toRadians(r5)
            float r1 = (float) r5
            com.oppo.camera.e.b r5 = r0.mCameraInterface
            boolean r5 = r5.ag()
            if (r5 == 0) goto L_0x0275
            r5 = 0
            r0.mbCurrentTiltShiftAdjusting = r5
        L_0x0275:
            com.oppo.camera.tiltshift.TiltShiftParam r5 = r0.mTiltShiftParam
            r5.setCenterX(r3)
            com.oppo.camera.tiltshift.TiltShiftParam r3 = r0.mTiltShiftParam
            r3.setCenterY(r2)
            com.oppo.camera.tiltshift.TiltShiftParam r2 = r0.mTiltShiftParam
            r2.setInnerDistance(r4)
            com.oppo.camera.tiltshift.TiltShiftParam r2 = r0.mTiltShiftParam
            r2.setAngle(r1)
            com.oppo.camera.tiltshift.TiltShiftParam r1 = r0.mTiltShiftParam
            boolean r2 = r0.mbCircle
            r1.setCircle(r2)
            com.oppo.camera.tiltshift.TiltShiftParam r1 = r0.mTiltShiftParam
            boolean r2 = r0.mbCurrentTiltShiftAdjusting
            r1.setAdjusting(r2)
            com.oppo.camera.tiltshift.TiltShiftManager$CameraTiltShiftListener r1 = r0.mCameraTiltShiftListener
            com.oppo.camera.tiltshift.TiltShiftParam r2 = r0.mTiltShiftParam
            r1.setTiltShiftParams(r2)
        L_0x029e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.tiltshift.TiltShiftManager.calculateTiftShiftPoint():void");
    }

    public TiltShiftParam getTiltShiftCaptureParam() {
        TiltShiftParam tiltShiftParam = new TiltShiftParam(this.mTiltShiftParam);
        float[] transformedCaptureCenterPoints = getTransformedCaptureCenterPoints(new float[]{this.mTiltShiftParam.getCenterY(), this.mTiltShiftParam.getCenterX()});
        tiltShiftParam.setCenterX(transformedCaptureCenterPoints[0]);
        tiltShiftParam.setCenterY(transformedCaptureCenterPoints[1]);
        tiltShiftParam.setAngle(getCaptureDegree());
        return tiltShiftParam;
    }

    private float getCaptureDegree() {
        double d = this.mCurrentTiltShiftDegree;
        return (float) (d <= 90.0d ? d + 90.0d : d - 90.0d);
    }

    private float[] getTransformedCaptureCenterPoints(float[] fArr) {
        int min = Math.min(this.mPreviewSize.getHeight(), this.mPreviewSize.getWidth());
        int max = Math.max(this.mPreviewSize.getHeight(), this.mPreviewSize.getWidth());
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        matrix.postTranslate((float) (max / 2), (float) ((-min) / 2));
        matrix.postScale(-1.0f, 1.0f);
        float[] fArr2 = new float[2];
        matrix.mapPoints(fArr2, fArr);
        return fArr2;
    }

    public void switchTiltShiftType(boolean z) {
        this.mbCircle = z;
        this.mbCurrentTiltShiftAdjusting = true;
        initTiftShiftPoint();
        this.mMainHandler.sendEmptyMessageDelayed(1, DELAY_RESET_ADJUSTING_STATE_DURATION);
    }

    public void resetAjustingState() {
        this.mbCurrentTiltShiftAdjusting = false;
        calculateTiftShiftPoint();
    }

    public void resetTiltShiftParams() {
        this.mbCurrentTiltShiftAdjusting = false;
        if (this.mPreviewArea != null) {
            int i = this.mPreviewAreaRight;
            int i2 = this.mPreviewAreaLeft;
            this.mCurrentTiltShiftCenterX = (double) ((i - i2) / 2);
            int i3 = this.mPreviewAreaBottom;
            int i4 = this.mPreviewAreaTop;
            this.mCurrentTiltShiftCenterY = (double) ((i3 - i4) / 2);
            this.mPreviewWidth = i - i2;
            this.mPreviewHeight = i3 - i4;
        }
        this.mCurrentTiltShiftRotation = Math.toRadians(0.0d);
        this.mCurrentTiltShiftRadius = INIT_TILT_SHIFT_RADIUS;
    }

    private void clampInPreviewArea(PointF pointF) {
        if (pointF.x < 0.0f) {
            pointF.x = 0.0f;
        }
        if (pointF.y < 0.0f) {
            pointF.y = 0.0f;
        }
        float f = pointF.x;
        int i = this.mPreviewWidth;
        if (f > ((float) i)) {
            pointF.x = (float) i;
        }
        float f2 = pointF.y;
        int i2 = this.mPreviewHeight;
        if (f2 > ((float) i2)) {
            pointF.y = (float) i2;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (needDispatchTouchEvent()) {
            return operateTouchEvent(motionEvent);
        }
        return false;
    }

    public void setPreviewSize(int i, int i2) {
        com.oppo.camera.e.a(TAG, "setPreviewSize, previewWidth: " + i + ", previewHeight: " + i2);
        if (this.mPreviewWidth != i || this.mPreviewHeight != i2) {
            this.mPreviewWidth = i;
            this.mPreviewHeight = i2;
        }
    }

    public void onDestroy() {
        com.oppo.camera.e.a(TAG, "onDestroy");
        resetTiltShiftParams();
        this.mActivity = null;
        this.mPreferences = null;
        this.mCameraInterface = null;
        this.mCameraTiltShiftListener = null;
    }

    public boolean isPointInTiltShift(float f, float f2) {
        if (this.mPreviewArea == null) {
            return false;
        }
        float f3 = f - ((float) this.mPreviewAreaLeft);
        float f4 = f2 - ((float) this.mPreviewAreaTop);
        if (this.mbCircle) {
            return isPointInTiltShiftCircle(f3, f4);
        }
        return isPointInTiltShiftRect(f3, f4);
    }

    private boolean isPointInTiltShiftCircle(float f, float f2) {
        double d = (double) f;
        double d2 = this.mCurrentTiltShiftCenterX;
        double d3 = (d - d2) * (d - d2);
        double d4 = (double) f2;
        double d5 = this.mCurrentTiltShiftCenterY;
        return Math.sqrt(d3 + ((d4 - d5) * (d4 - d5))) <= ((double) this.mCurrentTiltShiftRadius);
    }

    private boolean isPointInTiltShiftRect(float f, float f2) {
        PointF pointF = this.mPoint1;
        PointF pointF2 = this.mPoint3;
        PointF pointF3 = this.mPoint4;
        PointF pointF4 = this.mPoint2;
        float f3 = ((pointF2.x - pointF.x) * (f2 - pointF.y)) - ((pointF2.y - pointF.y) * (f - pointF.x));
        float f4 = ((pointF3.x - pointF2.x) * (f2 - pointF2.y)) - ((pointF3.y - pointF2.y) * (f - pointF2.x));
        float f5 = ((pointF4.x - pointF3.x) * (f2 - pointF3.y)) - ((pointF4.y - pointF3.y) * (f - pointF3.x));
        float f6 = ((pointF.x - pointF4.x) * (f2 - pointF4.y)) - ((pointF.y - pointF4.y) * (f - pointF4.x));
        if ((f3 <= 0.0f || f4 <= 0.0f || f5 <= 0.0f || f6 <= 0.0f) && (f3 >= 0.0f || f4 >= 0.0f || f5 >= 0.0f || f6 >= 0.0f)) {
            com.oppo.camera.e.c(TAG, "isPointInTiltShiftRect false");
            return false;
        }
        com.oppo.camera.e.c(TAG, "isPointInTiltShiftRect true");
        return true;
    }

    private boolean isPointInPreviewRect(int i, int i2) {
        if (new Rect(this.mPreviewLayout.getLeft(), this.mPreviewLayout.getTop(), this.mPreviewLayout.getRight(), this.mPreviewLayout.getBottom()).contains(i, i2)) {
            return getTouchEnable(i, i2);
        }
        return false;
    }

    private boolean getTouchEnable(int i, int i2) {
        return i2 >= this.mCameraUIInterface.Z() && i2 <= this.mCameraUIInterface.aa();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        if (r0 != 6) goto L_0x0162;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean operateTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "operateTouchEvent, event.getAction: "
            r0.append(r1)
            int r1 = r7.getAction()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "TiltShiftManager"
            com.oppo.camera.e.b(r1, r0)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0127
            if (r0 == r2) goto L_0x0115
            r4 = 2
            if (r0 == r4) goto L_0x0051
            r1 = 3
            if (r0 == r1) goto L_0x0115
            r1 = 5
            if (r0 == r1) goto L_0x0034
            r7 = 6
            if (r0 == r7) goto L_0x0115
            goto L_0x0162
        L_0x0034:
            r6.mbCurrentTiltShiftAdjusting = r2
            com.oppo.camera.tiltshift.TiltShiftManager$Mode r0 = com.oppo.camera.tiltshift.TiltShiftManager.Mode.ROTATE
            r6.mGestureMode = r0
            float r0 = r6.mCurrentTiltShiftRadius
            r6.mTouchTiltShiftRadius = r0
            double r0 = r6.mCurrentTiltShiftDegree
            float r0 = (float) r0
            r6.mTouchTiltShiftDegree = r0
            float r0 = r6.getSpacing(r7)
            r6.mTouchSpacing = r0
            float r7 = r6.getDegree(r7)
            r6.mTouchDegree = r7
            goto L_0x0162
        L_0x0051:
            com.oppo.camera.tiltshift.TiltShiftManager$Mode r0 = r6.mGestureMode
            com.oppo.camera.tiltshift.TiltShiftManager$Mode r2 = com.oppo.camera.tiltshift.TiltShiftManager.Mode.MOVE
            if (r0 != r2) goto L_0x0099
            float r0 = r7.getRawX()
            float r1 = r6.mTouchDownX
            float r0 = r0 - r1
            r6.mTouchTranslationX = r0
            float r7 = r7.getRawY()
            float r0 = r6.mTouchDownY
            float r7 = r7 - r0
            r6.mTouchTranslationY = r7
            double r0 = r6.mTouchTiltShiftX
            float r7 = r6.mTouchTranslationX
            double r4 = (double) r7
            double r0 = r0 + r4
            int r7 = r6.mPreviewAreaLeft
            double r4 = (double) r7
            double r0 = r0 + r4
            int r7 = (int) r0
            double r0 = r6.mTouchTiltShiftY
            float r2 = r6.mTouchTranslationY
            double r4 = (double) r2
            double r0 = r0 + r4
            int r2 = r6.mPreviewAreaTop
            double r4 = (double) r2
            double r0 = r0 + r4
            int r0 = (int) r0
            boolean r7 = r6.getTouchEnable(r7, r0)
            if (r7 == 0) goto L_0x0098
            double r0 = r6.mTouchTiltShiftX
            float r7 = r6.mTouchTranslationX
            double r4 = (double) r7
            double r0 = r0 + r4
            r6.mCurrentTiltShiftCenterX = r0
            double r0 = r6.mTouchTiltShiftY
            float r7 = r6.mTouchTranslationY
            double r4 = (double) r7
            double r0 = r0 + r4
            r6.mCurrentTiltShiftCenterY = r0
            r6.calculateTiftShiftPoint()
        L_0x0098:
            return r3
        L_0x0099:
            com.oppo.camera.tiltshift.TiltShiftManager$Mode r0 = r6.mGestureMode
            com.oppo.camera.tiltshift.TiltShiftManager$Mode r2 = com.oppo.camera.tiltshift.TiltShiftManager.Mode.ROTATE
            if (r0 != r2) goto L_0x0162
            float r0 = r6.getSpacing(r7)
            float r2 = r6.mTouchSpacing
            float r0 = r0 / r2
            r6.mTouchScale = r0
            float r0 = r6.mTouchTiltShiftRadius
            float r2 = r6.mTouchScale
            float r0 = r0 * r2
            r6.mCurrentTiltShiftRadius = r0
            float r7 = r6.getDegree(r7)
            boolean r0 = r6.mbCircle
            if (r0 != 0) goto L_0x00c0
            float r0 = r6.mTouchTiltShiftDegree
            float r0 = r0 + r7
            float r7 = r6.mTouchDegree
            float r0 = r0 - r7
            r6.mTouchRotation = r0
            goto L_0x00c4
        L_0x00c0:
            float r7 = r6.mTouchTiltShiftDegree
            r6.mTouchRotation = r7
        L_0x00c4:
            float r7 = r6.mTouchRotation
            r0 = 0
            int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            r2 = 1135869952(0x43b40000, float:360.0)
            if (r0 >= 0) goto L_0x00d0
            float r7 = r7 + r2
            r6.mTouchRotation = r7
        L_0x00d0:
            float r7 = r6.mTouchRotation
            int r0 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x00d9
            float r7 = r7 - r2
            r6.mTouchRotation = r7
        L_0x00d9:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "operateTouchEvent, rotation: "
            r7.append(r0)
            float r0 = r6.mTouchRotation
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            com.oppo.camera.e.b(r1, r7)
            float r7 = r6.mTouchRotation
            double r0 = (double) r7
            r6.mCurrentTiltShiftDegree = r0
            float r7 = r6.mCurrentTiltShiftRadius
            int r0 = r6.mPreviewAreaWidth
            float r1 = (float) r0
            float r2 = r6.mMaxTiltShiftRadiusRatio
            float r1 = r1 * r2
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x0105
            float r7 = (float) r0
            float r7 = r7 * r2
            r6.mCurrentTiltShiftRadius = r7
            goto L_0x0111
        L_0x0105:
            float r1 = (float) r0
            float r2 = r6.mMinTiltShiftRadiusRatio
            float r1 = r1 * r2
            int r7 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r7 >= 0) goto L_0x0111
            float r7 = (float) r0
            float r7 = r7 * r2
            r6.mCurrentTiltShiftRadius = r7
        L_0x0111:
            r6.calculateTiftShiftPoint()
            return r3
        L_0x0115:
            com.oppo.camera.tiltshift.TiltShiftManager$Mode r7 = com.oppo.camera.tiltshift.TiltShiftManager.Mode.NONE
            r6.mGestureMode = r7
            r6.mbCurrentTiltShiftAdjusting = r3
            boolean r7 = r6.mbCircle
            if (r7 != 0) goto L_0x0123
            r6.reCalculateTiftShiftCenter()
            goto L_0x0162
        L_0x0123:
            r6.calculateTiftShiftPoint()
            goto L_0x0162
        L_0x0127:
            float r0 = r7.getRawX()
            r6.mTouchDownX = r0
            float r7 = r7.getRawY()
            r6.mTouchDownY = r7
            float r7 = r6.mTouchDownX
            int r7 = (int) r7
            float r0 = r6.mTouchDownY
            int r0 = (int) r0
            boolean r7 = r6.isPointInPreviewRect(r7, r0)
            if (r7 == 0) goto L_0x0153
            r6.mbCurrentTiltShiftAdjusting = r2
            float r7 = r6.mTouchDownX
            int r7 = (int) r7
            float r7 = (float) r7
            float r0 = r6.mTouchDownY
            int r0 = (int) r0
            float r0 = (float) r0
            boolean r7 = r6.isPointInTiltShift(r7, r0)
            if (r7 == 0) goto L_0x0153
            com.oppo.camera.tiltshift.TiltShiftManager$Mode r7 = com.oppo.camera.tiltshift.TiltShiftManager.Mode.MOVE
            r6.mGestureMode = r7
        L_0x0153:
            float r7 = r6.mCurrentTiltShiftRadius
            r6.mTouchTiltShiftRadius = r7
            double r0 = r6.mCurrentTiltShiftCenterX
            r6.mTouchTiltShiftX = r0
            double r0 = r6.mCurrentTiltShiftCenterY
            r6.mTouchTiltShiftY = r0
            r6.calculateTiftShiftPoint()
        L_0x0162:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.tiltshift.TiltShiftManager.operateTouchEvent(android.view.MotionEvent):boolean");
    }

    private boolean isSupportTiltShif() {
        CameraTiltShiftListener cameraTiltShiftListener = this.mCameraTiltShiftListener;
        if (cameraTiltShiftListener != null) {
            return cameraTiltShiftListener.getSupportTiltShif();
        }
        return false;
    }

    private boolean getTiltShiftGestureEnabled() {
        return "off".equals(this.mPreferences.getString("pref_subsetting_key", "off"));
    }

    private boolean needDispatchTouchEvent() {
        CameraTiltShiftListener cameraTiltShiftListener = this.mCameraTiltShiftListener;
        return cameraTiltShiftListener != null && cameraTiltShiftListener.getTiltShifGestureEnabled() && !this.mCameraTiltShiftListener.isEffectMenuAnimRunning() && isSupportTiltShif() && getTiltShiftGestureEnabled();
    }

    private float getSpacing(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    private float getDegree(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2((double) (motionEvent.getY(0) - motionEvent.getY(1)), (double) (motionEvent.getX(0) - motionEvent.getX(1))));
    }
}
