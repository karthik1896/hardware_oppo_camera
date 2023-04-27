package com.oppo.camera.a;

import android.graphics.PointF;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.media.ExifInterface;
import android.util.Size;
import com.oppo.camera.aps.adapter.ApsParameters;
import com.oppo.camera.aps.constant.ParameterKeys;
import com.oppo.camera.aps.service.ThumbnailCategory;
import com.oppo.camera.e;
import com.oppo.camera.statistics.model.CaptureMsgData;
import com.oppo.camera.statistics.model.FocusAimMsgData;
import com.oppo.camera.util.Util;
import com.oppo.camera.z;
import java.io.File;
import java.util.Arrays;

/* compiled from: CaptureMsgDataReportUtil */
public class a {
    public static CaptureMsgData a(CaptureMsgData captureMsgData, ThumbnailCategory thumbnailCategory) {
        if (captureMsgData == null || thumbnailCategory == null) {
            e.a("CaptureMsgDataReportUtil", "packageFromThumbnail, captureMsgData or category is null");
            return null;
        }
        captureMsgData.mHeight = String.valueOf(thumbnailCategory.mImageItemInfo.get(ParameterKeys.KEY_IMAGE_HEIGHT));
        captureMsgData.mWidth = String.valueOf(thumbnailCategory.mImageItemInfo.get(ParameterKeys.KEY_IMAGE_WIDTH));
        if (((Boolean) thumbnailCategory.mImageItemInfo.get(ApsParameters.KEY_BURST_SHOT)).booleanValue()) {
            captureMsgData.mBurstCount = ((Integer) thumbnailCategory.mImageItemInfo.get(ApsParameters.KEY_BURST_COUNT)).intValue();
        }
        if (thumbnailCategory.mMetaItemInfo.get(ParameterKeys.KEY_CUSTOM_BEAUTY_PARAM) != null) {
            captureMsgData.parseFaceBeauty((int[]) thumbnailCategory.mMetaItemInfo.get(ParameterKeys.KEY_CUSTOM_BEAUTY_PARAM));
        }
        captureMsgData.mFilePath = a(thumbnailCategory);
        return captureMsgData;
    }

    public static String a(String str) {
        e.a("CaptureMsgDataReportUtil", "getFlashTriggerStatus, flashMode: " + str);
        return "torch".equals(str) ? FocusAimMsgData.KEY_MULTI_VIDEO_SWITCH_SCREEN_FOCUS_TYPE : "16";
    }

    public static CaptureMsgData a(CaptureMsgData captureMsgData, z.a aVar) {
        if (captureMsgData == null || aVar == null) {
            e.a("CaptureMsgDataReportUtil", "packageFromThumbnail, captureMsgData or picture is null");
            return null;
        }
        ExifInterface a2 = Util.a(aVar.e);
        if (a2 == null) {
            return captureMsgData;
        }
        captureMsgData.mFlashTrigger = a2.getAttribute("Flash");
        return captureMsgData;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074 A[SYNTHETIC, Splitter:B:24:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a1 A[SYNTHETIC, Splitter:B:36:0x00a1] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x029a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.oppo.camera.statistics.model.CaptureMsgData a(com.oppo.camera.statistics.model.CaptureMsgData r8, android.hardware.camera2.TotalCaptureResult r9, android.hardware.camera2.CaptureRequest r10, com.oppo.camera.t.a r11, android.util.Size r12, int r13, long r14) {
        /*
            java.lang.String r0 = "value: "
            java.lang.String r1 = "packageFromCaptureResult, key:"
            r2 = 0
            java.lang.String r3 = "CaptureMsgDataReportUtil"
            if (r8 == 0) goto L_0x03d0
            if (r9 == 0) goto L_0x03d0
            if (r10 != 0) goto L_0x000f
            goto L_0x03d0
        L_0x000f:
            java.lang.String r4 = "com.oplus.mmcamera.professional.support"
            boolean r4 = com.oppo.camera.aps.config.CameraConfig.getConfigBooleanValue(r4)     // Catch:{ Exception -> 0x005e }
            if (r4 == 0) goto L_0x0026
            r4 = -1
            if (r4 == r13) goto L_0x0026
            r4 = -1
            int r4 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r4 != 0) goto L_0x0021
            goto L_0x0026
        L_0x0021:
            r8.mISO = r13     // Catch:{ Exception -> 0x005e }
            r8.mEXP = r14     // Catch:{ Exception -> 0x005e }
            goto L_0x0051
        L_0x0026:
            android.hardware.camera2.CaptureResult$Key r13 = android.hardware.camera2.CaptureResult.SENSOR_SENSITIVITY     // Catch:{ Exception -> 0x005e }
            java.lang.Object r13 = r9.get(r13)     // Catch:{ Exception -> 0x005e }
            java.lang.Integer r13 = (java.lang.Integer) r13     // Catch:{ Exception -> 0x005e }
            int r13 = r13.intValue()     // Catch:{ Exception -> 0x005e }
            android.hardware.camera2.CaptureResult$Key r14 = android.hardware.camera2.CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST     // Catch:{ Exception -> 0x005e }
            java.lang.Object r14 = r9.get(r14)     // Catch:{ Exception -> 0x005e }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ Exception -> 0x005e }
            int r14 = r14.intValue()     // Catch:{ Exception -> 0x005e }
            int r13 = r13 * r14
            int r13 = r13 / 100
            r8.mISO = r13     // Catch:{ Exception -> 0x005e }
            android.hardware.camera2.CaptureResult$Key r13 = android.hardware.camera2.CaptureResult.SENSOR_EXPOSURE_TIME     // Catch:{ Exception -> 0x005e }
            java.lang.Object r13 = r9.get(r13)     // Catch:{ Exception -> 0x005e }
            java.lang.Long r13 = (java.lang.Long) r13     // Catch:{ Exception -> 0x005e }
            long r13 = r13.longValue()     // Catch:{ Exception -> 0x005e }
            r8.mEXP = r13     // Catch:{ Exception -> 0x005e }
        L_0x0051:
            android.hardware.camera2.CaptureResult$Key r13 = android.hardware.camera2.CaptureResult.LENS_FOCAL_LENGTH     // Catch:{ Exception -> 0x005e }
            java.lang.Object r13 = r9.get(r13)     // Catch:{ Exception -> 0x005e }
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ Exception -> 0x005e }
            r8.mFocalLength = r13     // Catch:{ Exception -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r13 = move-exception
            r13.printStackTrace()
        L_0x0062:
            boolean r13 = com.oppo.camera.util.Util.p()
            if (r13 == 0) goto L_0x006d
            android.hardware.camera2.CaptureResult$Key<int[]> r13 = com.oppo.camera.f.c.N
            android.hardware.camera2.CaptureResult$Key<float[]> r14 = com.oppo.camera.f.c.O
            goto L_0x0071
        L_0x006d:
            android.hardware.camera2.CaptureResult$Key<int[]> r13 = com.oppo.camera.f.c.aa
            android.hardware.camera2.CaptureResult$Key<int[]> r14 = com.oppo.camera.f.c.Q
        L_0x0071:
            r15 = 0
            if (r13 == 0) goto L_0x009d
            java.lang.Object r13 = r9.get(r13)     // Catch:{ Exception -> 0x0099 }
            int[] r13 = (int[]) r13     // Catch:{ Exception -> 0x0099 }
            int[] r13 = (int[]) r13     // Catch:{ Exception -> 0x0099 }
            if (r13 == 0) goto L_0x0084
            int r4 = r13.length     // Catch:{ Exception -> 0x0099 }
            if (r4 <= 0) goto L_0x0084
            r13 = r13[r15]     // Catch:{ Exception -> 0x0099 }
            goto L_0x009e
        L_0x0084:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0099 }
            r4.<init>()     // Catch:{ Exception -> 0x0099 }
            java.lang.String r5 = "packageFromCaptureResult,  cct value: "
            r4.append(r5)     // Catch:{ Exception -> 0x0099 }
            r4.append(r13)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r13 = r4.toString()     // Catch:{ Exception -> 0x0099 }
            com.oppo.camera.e.a(r3, r13)     // Catch:{ Exception -> 0x0099 }
            goto L_0x009d
        L_0x0099:
            r13 = move-exception
            r13.printStackTrace()
        L_0x009d:
            r13 = r15
        L_0x009e:
            r4 = 0
            if (r14 == 0) goto L_0x0132
            boolean r5 = com.oppo.camera.util.Util.p()     // Catch:{ Exception -> 0x012e }
            if (r5 == 0) goto L_0x00fc
            java.lang.Object r14 = r9.get(r14)     // Catch:{ Exception -> 0x012e }
            float[] r14 = (float[]) r14     // Catch:{ Exception -> 0x012e }
            float[] r14 = (float[]) r14     // Catch:{ Exception -> 0x012e }
            if (r14 == 0) goto L_0x00b9
            int r5 = r14.length     // Catch:{ Exception -> 0x012e }
            if (r5 <= 0) goto L_0x00b9
            r14 = r14[r15]     // Catch:{ Exception -> 0x012e }
        L_0x00b6:
            r4 = r14
            goto L_0x0132
        L_0x00b9:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e }
            r5.<init>()     // Catch:{ Exception -> 0x012e }
            java.lang.String r6 = "onPreviewCaptureResult, lux value: "
            r5.append(r6)     // Catch:{ Exception -> 0x012e }
            java.lang.String r14 = java.util.Arrays.toString(r14)     // Catch:{ Exception -> 0x012e }
            r5.append(r14)     // Catch:{ Exception -> 0x012e }
            java.lang.String r14 = r5.toString()     // Catch:{ Exception -> 0x012e }
            com.oppo.camera.e.a(r3, r14)     // Catch:{ Exception -> 0x012e }
            android.hardware.camera2.CaptureResult$Key<float[]> r14 = com.oppo.camera.f.c.P     // Catch:{ Exception -> 0x012e }
            java.lang.Object r14 = r9.get(r14)     // Catch:{ Exception -> 0x012e }
            float[] r14 = (float[]) r14     // Catch:{ Exception -> 0x012e }
            float[] r14 = (float[]) r14     // Catch:{ Exception -> 0x012e }
            if (r14 == 0) goto L_0x00e3
            int r5 = r14.length     // Catch:{ Exception -> 0x012e }
            if (r5 <= 0) goto L_0x00e3
            r14 = r14[r15]     // Catch:{ Exception -> 0x012e }
            goto L_0x00b6
        L_0x00e3:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e }
            r5.<init>()     // Catch:{ Exception -> 0x012e }
            java.lang.String r6 = "onPreviewCaptureResult, luxForData value: "
            r5.append(r6)     // Catch:{ Exception -> 0x012e }
            java.lang.String r14 = java.util.Arrays.toString(r14)     // Catch:{ Exception -> 0x012e }
            r5.append(r14)     // Catch:{ Exception -> 0x012e }
            java.lang.String r14 = r5.toString()     // Catch:{ Exception -> 0x012e }
            com.oppo.camera.e.a(r3, r14)     // Catch:{ Exception -> 0x012e }
            goto L_0x0132
        L_0x00fc:
            java.lang.Object r5 = r9.get(r14)     // Catch:{ Exception -> 0x012e }
            int[] r5 = (int[]) r5     // Catch:{ Exception -> 0x012e }
            int[] r5 = (int[]) r5     // Catch:{ Exception -> 0x012e }
            if (r5 == 0) goto L_0x010d
            int r6 = r5.length     // Catch:{ Exception -> 0x012e }
            if (r6 <= 0) goto L_0x010d
            r14 = r5[r15]     // Catch:{ Exception -> 0x012e }
            float r4 = (float) r14     // Catch:{ Exception -> 0x012e }
            goto L_0x0132
        L_0x010d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e }
            r6.<init>()     // Catch:{ Exception -> 0x012e }
            java.lang.String r7 = "onPreviewCaptureResult, key: "
            r6.append(r7)     // Catch:{ Exception -> 0x012e }
            r6.append(r14)     // Catch:{ Exception -> 0x012e }
            java.lang.String r14 = ", luxIntValues: "
            r6.append(r14)     // Catch:{ Exception -> 0x012e }
            java.lang.String r14 = java.util.Arrays.toString(r5)     // Catch:{ Exception -> 0x012e }
            r6.append(r14)     // Catch:{ Exception -> 0x012e }
            java.lang.String r14 = r6.toString()     // Catch:{ Exception -> 0x012e }
            com.oppo.camera.e.a(r3, r14)     // Catch:{ Exception -> 0x012e }
            goto L_0x0132
        L_0x012e:
            r14 = move-exception
            r14.printStackTrace()
        L_0x0132:
            java.lang.String r13 = java.lang.String.valueOf(r13)
            r8.mCCT = r13
            java.lang.String r13 = java.lang.String.valueOf(r4)
            r8.mLux = r13
            android.hardware.camera2.CaptureResult$Key<java.lang.Integer> r13 = com.oppo.camera.f.c.bl
            java.lang.String r13 = a((android.hardware.camera2.TotalCaptureResult) r9, (android.hardware.camera2.CaptureResult.Key<java.lang.Integer>) r13, (boolean) r15)
            r8.mIsLaserDirty = r13
            java.lang.String r13 = r8.mIsLaserDirty
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            java.lang.String r14 = "*"
            r4 = 1
            if (r13 != 0) goto L_0x0280
            android.hardware.camera2.CaptureResult$Key<float[]> r13 = com.oppo.camera.f.c.bb
            java.lang.String r13 = a((android.hardware.camera2.TotalCaptureResult) r9, (android.hardware.camera2.CaptureResult.Key<float[]>) r13, (int) r15)
            r8.mSgwBGRatio = r13
            android.hardware.camera2.CaptureResult$Key<float[]> r13 = com.oppo.camera.f.c.ba
            java.lang.String r13 = a((android.hardware.camera2.TotalCaptureResult) r9, (android.hardware.camera2.CaptureResult.Key<float[]>) r13, (int) r15)
            r8.mSgwRGRatio = r13
            android.hardware.camera2.CaptureResult$Key<float[]> r13 = com.oppo.camera.f.c.be
            java.lang.String r13 = a((android.hardware.camera2.TotalCaptureResult) r9, (android.hardware.camera2.CaptureResult.Key<float[]>) r13, (int) r15)
            r8.mDrcGain = r13
            android.hardware.camera2.CaptureResult$Key<int[]> r13 = com.oppo.camera.f.c.bh
            java.lang.String r13 = a((android.hardware.camera2.TotalCaptureResult) r9, (android.hardware.camera2.CaptureResult.Key<int[]>) r13)
            r8.mIsAisNeed = r13
            android.hardware.camera2.CaptureResult$Key<int[]> r13 = com.oppo.camera.f.c.bg
            java.lang.String r13 = a((android.hardware.camera2.TotalCaptureResult) r9, (android.hardware.camera2.CaptureResult.Key<int[]>) r13)
            r8.mAisMotionType = r13
            android.hardware.camera2.CaptureResult$Key<int[]> r13 = com.oppo.camera.f.c.bi
            java.lang.String r13 = a((android.hardware.camera2.TotalCaptureResult) r9, (android.hardware.camera2.CaptureResult.Key<int[]>) r13)
            r8.mFocusROIType = r13
            android.hardware.camera2.CaptureResult$Key<float[]> r13 = com.oppo.camera.f.c.bf
            java.lang.String r13 = a((android.hardware.camera2.TotalCaptureResult) r9, (android.hardware.camera2.CaptureResult.Key<float[]>) r13, (int) r15)
            r8.mGyroSqrt = r13
            android.hardware.camera2.CaptureResult$Key r13 = android.hardware.camera2.CaptureResult.CONTROL_AF_STATE
            java.lang.String r13 = a((android.hardware.camera2.TotalCaptureResult) r9, (android.hardware.camera2.CaptureResult.Key<java.lang.Integer>) r13, (boolean) r4)
            r8.mFocusState = r13
            android.hardware.camera2.CaptureResult$Key r13 = android.hardware.camera2.CaptureResult.CONTROL_AE_STATE
            java.lang.String r13 = a((android.hardware.camera2.TotalCaptureResult) r9, (android.hardware.camera2.CaptureResult.Key<java.lang.Integer>) r13, (boolean) r4)
            r8.mAecSettle = r13
            android.hardware.camera2.CaptureResult$Key r13 = android.hardware.camera2.CaptureResult.STATISTICS_SCENE_FLICKER
            java.lang.String r13 = a((android.hardware.camera2.TotalCaptureResult) r9, (android.hardware.camera2.CaptureResult.Key<java.lang.Integer>) r13, (boolean) r4)
            r8.mFlickerDetectResult = r13
            android.hardware.camera2.CaptureResult$Key<int[]> r13 = com.oppo.camera.f.c.bj
            java.lang.String r13 = a((android.hardware.camera2.TotalCaptureResult) r9, (android.hardware.camera2.CaptureResult.Key<int[]>) r13)
            r8.mFocusMethodType = r13
            android.hardware.camera2.CaptureResult$Key<float[]> r13 = com.oppo.camera.f.c.bd
            java.lang.String r13 = a((android.hardware.camera2.TotalCaptureResult) r9, (android.hardware.camera2.CaptureResult.Key<float[]>) r13, (int) r15)
            r8.mSensorCCT = r13
            android.hardware.camera2.CaptureResult$Key<int[]> r13 = com.oppo.camera.f.c.bk
            java.lang.String r13 = a((android.hardware.camera2.TotalCaptureResult) r9, (android.hardware.camera2.CaptureResult.Key<int[]>) r13)
            r8.mFocusTimeCost = r13
            android.hardware.camera2.CaptureResult$Key<float[]> r13 = com.oppo.camera.f.c.bm
            java.lang.String r13 = a((android.hardware.camera2.TotalCaptureResult) r9, (android.hardware.camera2.CaptureResult.Key<float[]>) r13, (int) r4)
            r8.mSharpnessStd = r13
            android.hardware.camera2.CaptureResult$Key r13 = android.hardware.camera2.CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION     // Catch:{ Exception -> 0x01d8 }
            java.lang.Object r13 = r9.get(r13)     // Catch:{ Exception -> 0x01d8 }
            java.lang.Integer r13 = (java.lang.Integer) r13     // Catch:{ Exception -> 0x01d8 }
            if (r13 == 0) goto L_0x01d2
            int r13 = r13.intValue()     // Catch:{ Exception -> 0x01d8 }
            r8.mTouchEVValue = r13     // Catch:{ Exception -> 0x01d8 }
            goto L_0x01dc
        L_0x01d2:
            java.lang.String r13 = "packageFromCaptureResult,  mTouchEVValue is null"
            com.oppo.camera.e.a(r3, r13)     // Catch:{ Exception -> 0x01d8 }
            goto L_0x01dc
        L_0x01d8:
            r13 = move-exception
            r13.printStackTrace()
        L_0x01dc:
            android.hardware.camera2.CaptureResult$Key<float[]> r13 = com.oppo.camera.f.c.bc     // Catch:{ Exception -> 0x0219 }
            java.lang.Object r13 = r9.get(r13)     // Catch:{ Exception -> 0x0219 }
            float[] r13 = (float[]) r13     // Catch:{ Exception -> 0x0219 }
            if (r13 == 0) goto L_0x01fa
            int r5 = r13.length     // Catch:{ Exception -> 0x0219 }
            if (r5 <= r4) goto L_0x01fa
            r5 = r13[r15]     // Catch:{ Exception -> 0x0219 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0219 }
            r8.mFinalAWBDecision_rg = r5     // Catch:{ Exception -> 0x0219 }
            r13 = r13[r4]     // Catch:{ Exception -> 0x0219 }
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ Exception -> 0x0219 }
            r8.mFinalAWBDecision_bg = r13     // Catch:{ Exception -> 0x0219 }
            goto L_0x021d
        L_0x01fa:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0219 }
            r5.<init>()     // Catch:{ Exception -> 0x0219 }
            r5.append(r1)     // Catch:{ Exception -> 0x0219 }
            android.hardware.camera2.CaptureResult$Key<float[]> r6 = com.oppo.camera.f.c.bc     // Catch:{ Exception -> 0x0219 }
            r5.append(r6)     // Catch:{ Exception -> 0x0219 }
            r5.append(r0)     // Catch:{ Exception -> 0x0219 }
            java.lang.String r13 = java.util.Arrays.toString(r13)     // Catch:{ Exception -> 0x0219 }
            r5.append(r13)     // Catch:{ Exception -> 0x0219 }
            java.lang.String r13 = r5.toString()     // Catch:{ Exception -> 0x0219 }
            com.oppo.camera.e.a(r3, r13)     // Catch:{ Exception -> 0x0219 }
            goto L_0x021d
        L_0x0219:
            r13 = move-exception
            r13.printStackTrace()
        L_0x021d:
            android.hardware.camera2.CaptureResult$Key r13 = android.hardware.camera2.CaptureResult.CONTROL_AF_REGIONS     // Catch:{ Exception -> 0x027c }
            java.lang.Object r13 = r9.get(r13)     // Catch:{ Exception -> 0x027c }
            android.hardware.camera2.params.MeteringRectangle[] r13 = (android.hardware.camera2.params.MeteringRectangle[]) r13     // Catch:{ Exception -> 0x027c }
            if (r13 == 0) goto L_0x025d
            int r5 = r13.length     // Catch:{ Exception -> 0x027c }
            if (r5 <= 0) goto L_0x025d
            r13 = r13[r15]     // Catch:{ Exception -> 0x027c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x027c }
            r0.<init>()     // Catch:{ Exception -> 0x027c }
            int r1 = r13.getX()     // Catch:{ Exception -> 0x027c }
            r0.append(r1)     // Catch:{ Exception -> 0x027c }
            r0.append(r14)     // Catch:{ Exception -> 0x027c }
            int r1 = r13.getY()     // Catch:{ Exception -> 0x027c }
            r0.append(r1)     // Catch:{ Exception -> 0x027c }
            r0.append(r14)     // Catch:{ Exception -> 0x027c }
            int r1 = r13.getWidth()     // Catch:{ Exception -> 0x027c }
            r0.append(r1)     // Catch:{ Exception -> 0x027c }
            r0.append(r14)     // Catch:{ Exception -> 0x027c }
            int r13 = r13.getHeight()     // Catch:{ Exception -> 0x027c }
            r0.append(r13)     // Catch:{ Exception -> 0x027c }
            java.lang.String r13 = r0.toString()     // Catch:{ Exception -> 0x027c }
            r8.mFocusRegion = r13     // Catch:{ Exception -> 0x027c }
            goto L_0x0280
        L_0x025d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x027c }
            r5.<init>()     // Catch:{ Exception -> 0x027c }
            r5.append(r1)     // Catch:{ Exception -> 0x027c }
            android.hardware.camera2.CaptureResult$Key r1 = android.hardware.camera2.CaptureResult.CONTROL_AF_REGIONS     // Catch:{ Exception -> 0x027c }
            r5.append(r1)     // Catch:{ Exception -> 0x027c }
            r5.append(r0)     // Catch:{ Exception -> 0x027c }
            java.lang.String r13 = java.util.Arrays.toString(r13)     // Catch:{ Exception -> 0x027c }
            r5.append(r13)     // Catch:{ Exception -> 0x027c }
            java.lang.String r13 = r5.toString()     // Catch:{ Exception -> 0x027c }
            com.oppo.camera.e.a(r3, r13)     // Catch:{ Exception -> 0x027c }
            goto L_0x0280
        L_0x027c:
            r13 = move-exception
            r13.printStackTrace()
        L_0x0280:
            android.hardware.camera2.CaptureResult$Key r13 = android.hardware.camera2.CaptureResult.LENS_FOCUS_DISTANCE
            java.lang.Object r13 = r9.get(r13)
            java.lang.String r13 = java.lang.String.valueOf(r13)
            r8.mFocusDistance = r13
            java.lang.Object r10 = r10.getTag()
            com.oppo.camera.f.d r10 = (com.oppo.camera.f.d) r10
            if (r10 != 0) goto L_0x029a
            java.lang.String r8 = "packageFromCaptureResult, requestTag is null"
            com.oppo.camera.e.a(r3, r8)
            return r2
        L_0x029a:
            int[] r13 = r10.H
            if (r13 == 0) goto L_0x02be
            int[] r13 = r10.H
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = r15
        L_0x02a6:
            int r2 = r13.length
            if (r1 >= r2) goto L_0x02b8
            r2 = r13[r1]
            r0.append(r2)
            int r2 = r13.length
            int r2 = r2 - r4
            if (r1 == r2) goto L_0x02b5
            r0.append(r14)
        L_0x02b5:
            int r1 = r1 + 1
            goto L_0x02a6
        L_0x02b8:
            java.lang.String r13 = r0.toString()
            r8.mHdrEVList = r13
        L_0x02be:
            java.lang.String r13 = r10.u
            r8.mCaptureMode = r13
            int r13 = r10.w
            r8.mCameraId = r13
            int r13 = r10.F
            r8.mOrientation = r13
            java.lang.String r13 = r10.D
            r8.mTouchXYValue = r13
            java.lang.String r13 = r10.E
            r8.mIsWideAngle = r13
            java.lang.String r13 = r10.x
            r8.mHdrMode = r13
            boolean r13 = r10.y
            java.lang.String r13 = java.lang.String.valueOf(r13)
            r8.mbHdrTrigger = r13
            boolean r13 = r10.B
            java.lang.String r13 = java.lang.String.valueOf(r13)
            r8.mAeAfLock = r13
            java.lang.String r13 = r10.A
            r8.mShutterType = r13
            java.lang.String r13 = r10.u
            java.lang.String r14 = "portrait"
            boolean r13 = r14.equals(r13)
            if (r13 == 0) goto L_0x02f9
            java.lang.String r13 = r10.n
            r8.mPortraitNewStyleType = r13
            goto L_0x033b
        L_0x02f9:
            java.lang.String r13 = r10.u
            java.lang.String r14 = "common"
            boolean r13 = r14.equals(r13)
            if (r13 == 0) goto L_0x0313
            java.lang.String r13 = r10.n
            r8.mFilterType = r13
            boolean r13 = r10.O
            if (r13 == 0) goto L_0x030e
            java.lang.String r13 = "on"
            goto L_0x0310
        L_0x030e:
            java.lang.String r13 = "off"
        L_0x0310:
            r8.mSCPEnable = r13
            goto L_0x033b
        L_0x0313:
            java.lang.String r13 = r10.u
            java.lang.String r14 = "microscope"
            boolean r13 = r14.equals(r13)
            if (r13 != 0) goto L_0x0337
            java.lang.String r13 = r10.u
            java.lang.String r14 = "microscopeVideo"
            boolean r13 = r14.equals(r13)
            if (r13 == 0) goto L_0x0328
            goto L_0x0337
        L_0x0328:
            java.lang.String r13 = r10.u
            java.lang.String r14 = "night"
            boolean r13 = r14.equals(r13)
            if (r13 == 0) goto L_0x033b
            java.lang.String r13 = r10.n
            r8.mNightStyleType = r13
            goto L_0x033b
        L_0x0337:
            java.lang.String r13 = r10.n
            r8.mAncFilterType = r13
        L_0x033b:
            boolean r13 = r10.e
            if (r13 == 0) goto L_0x0342
            r13 = 102(0x66, float:1.43E-43)
            goto L_0x0343
        L_0x0342:
            r13 = r15
        L_0x0343:
            r8.mSmooth = r13
            int r13 = r10.N
            r8.mAiScene = r13
            boolean r13 = r10.h
            if (r13 != 0) goto L_0x0365
            boolean r13 = r10.j
            if (r13 != 0) goto L_0x0365
            java.lang.String[] r13 = r10.G
            java.lang.String r14 = "aps_algo_bokeh"
            boolean r13 = com.oppo.camera.util.Util.a((java.lang.String[]) r13, (java.lang.String) r14)
            if (r13 != 0) goto L_0x0365
            java.lang.String[] r13 = r10.G
            java.lang.String r14 = "aps_algo_front_bokeh"
            boolean r13 = com.oppo.camera.util.Util.a((java.lang.String[]) r13, (java.lang.String) r14)
            if (r13 == 0) goto L_0x0369
        L_0x0365:
            int r10 = r10.T
            r8.mBlurLevel = r10
        L_0x0369:
            if (r11 == 0) goto L_0x0371
            java.lang.String r10 = a((com.oppo.camera.t.a) r11, (android.util.Size) r12)
            r8.mTextSize = r10
        L_0x0371:
            boolean r10 = com.oppo.camera.util.Util.p()
            if (r10 != 0) goto L_0x03cf
            android.hardware.camera2.CaptureResult$Key<int[]> r10 = com.oppo.camera.f.c.Y
            java.lang.Object r10 = com.oppo.camera.f.c.a(r9, r10)
            if (r10 == 0) goto L_0x03a4
            boolean r11 = r10 instanceof int[]
            if (r11 == 0) goto L_0x03a4
            int[] r10 = (int[]) r10
            int[] r10 = (int[]) r10
            int r11 = r10.length
            if (r11 <= 0) goto L_0x03a4
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "packageFromCaptureResult, beautyLevel: "
            r11.append(r12)
            r12 = r10[r15]
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            com.oppo.camera.e.a(r3, r11)
            r10 = r10[r15]
            r8.mSmooth = r10
        L_0x03a4:
            android.hardware.camera2.CaptureResult$Key<int[]> r10 = com.oppo.camera.f.c.Z
            java.lang.Object r9 = com.oppo.camera.f.c.a(r9, r10)
            if (r9 == 0) goto L_0x03cf
            boolean r10 = r9 instanceof int[]
            if (r10 == 0) goto L_0x03cf
            int[] r9 = (int[]) r9
            int[] r9 = (int[]) r9
            int r10 = r9.length
            if (r10 <= 0) goto L_0x03cf
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "packageFromCaptureResult, customBeautyParam.length: "
            r10.append(r11)
            int r11 = r9.length
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            com.oppo.camera.e.a(r3, r10)
            r8.parseFaceBeauty(r9)
        L_0x03cf:
            return r8
        L_0x03d0:
            java.lang.String r8 = "packageFromCaptureResult, captureMsgData or captureResult or request is null"
            com.oppo.camera.e.a(r3, r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.a.a.a(com.oppo.camera.statistics.model.CaptureMsgData, android.hardware.camera2.TotalCaptureResult, android.hardware.camera2.CaptureRequest, com.oppo.camera.t.a, android.util.Size, int, long):com.oppo.camera.statistics.model.CaptureMsgData");
    }

    private static String a(TotalCaptureResult totalCaptureResult, CaptureResult.Key<Integer> key, boolean z) {
        try {
            return String.valueOf(totalCaptureResult.get(key));
        } catch (Exception e) {
            if (z) {
                e.printStackTrace();
            }
            return "";
        }
    }

    private static String a(TotalCaptureResult totalCaptureResult, CaptureResult.Key<float[]> key, int i) {
        try {
            float[] fArr = (float[]) totalCaptureResult.get(key);
            if (fArr != null && fArr.length > i) {
                return String.valueOf(fArr[i]);
            }
            e.a("CaptureMsgDataReportUtil", "packageFromCaptureResult,  key:" + key + " value: " + Arrays.toString(fArr));
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String a(TotalCaptureResult totalCaptureResult, CaptureResult.Key<int[]> key) {
        try {
            int[] iArr = (int[]) totalCaptureResult.get(key);
            if (iArr != null && iArr.length > 0) {
                return String.valueOf(iArr[0]);
            }
            e.a("CaptureMsgDataReportUtil", "packageFromCaptureResult, key: " + key + " value: " + Arrays.toString(iArr));
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(ThumbnailCategory thumbnailCategory) {
        String str;
        if (thumbnailCategory == null || thumbnailCategory.mMetaItemInfo == null || thumbnailCategory.mImageItemInfo == null || thumbnailCategory.mThumbnailItem == null) {
            return null;
        }
        if (thumbnailCategory.mThumbnailItem.mJpegName == null && ((Long) thumbnailCategory.mImageItemInfo.get(ApsParameters.KEY_BURST_SHOT_FLAG_ID)).longValue() == -1) {
            return null;
        }
        String str2 = ("heic_8bits".equalsIgnoreCase(thumbnailCategory.mThumbnailItem.mPictureFormat) || "heic_10bits".equalsIgnoreCase(thumbnailCategory.mThumbnailItem.mPictureFormat)) ? ".heic" : ".jpg";
        if ("off".equals(z.r)) {
            str = z.l;
        } else {
            str = z.g;
        }
        if (((Long) thumbnailCategory.mImageItemInfo.get(ApsParameters.KEY_BURST_SHOT_FLAG_ID)).longValue() > -1) {
            return (String) thumbnailCategory.mImageItemInfo.get(ApsParameters.KEY_CSHOT_PATH);
        }
        return str + File.separator + thumbnailCategory.mThumbnailItem.mJpegName + str2;
    }

    public static String a(z.a aVar) {
        String str;
        String str2;
        String str3;
        if (aVar == null || aVar.n == 0) {
            return null;
        }
        if ("off".equals(z.r)) {
            str = z.l;
        } else {
            str = z.g;
        }
        String str4 = aVar.j;
        if ("raw".equalsIgnoreCase(str4)) {
            str2 = ".dng";
        } else {
            str2 = ("heic_8bits".equalsIgnoreCase(str4) || "heic_10bits".equalsIgnoreCase(str4)) ? ".heic" : ".jpg";
        }
        if (aVar.p <= -1 || aVar.h == null) {
            str3 = Util.d(aVar.n);
        } else {
            str3 = aVar.h;
        }
        if (aVar.o > -1) {
            return aVar.m;
        }
        return str + File.separator + str3 + str2;
    }

    private static String a(com.oppo.camera.t.a aVar, Size size) {
        if (aVar == null || !aVar.c() || size == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (PointF pointF : aVar.b()) {
            sb.append((int) (pointF.x * ((float) size.getWidth())));
            sb.append("x");
            sb.append((int) (pointF.y * ((float) size.getHeight())));
            sb.append("-");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}
