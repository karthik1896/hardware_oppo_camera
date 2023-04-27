package com.oppo.camera.perf;

/* compiled from: CameraPerformance */
public class a {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r2) {
        /*
            int r0 = r2.hashCode()
            switch(r0) {
                case -1617888575: goto L_0x0044;
                case -1013464554: goto L_0x003a;
                case -785871842: goto L_0x0030;
                case 552585030: goto L_0x0026;
                case 793950546: goto L_0x001c;
                case 1432307344: goto L_0x0012;
                case 2129173454: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x004e
        L_0x0008:
            java.lang.String r0 = "switch_mode"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 2
            goto L_0x004f
        L_0x0012:
            java.lang.String r0 = "switch_camera"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 0
            goto L_0x004f
        L_0x001c:
            java.lang.String r0 = "start_video_record"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 3
            goto L_0x004f
        L_0x0026:
            java.lang.String r0 = "capture"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 1
            goto L_0x004f
        L_0x0030:
            java.lang.String r0 = "picture_save"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 5
            goto L_0x004f
        L_0x003a:
            java.lang.String r0 = "continuous_capture"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 6
            goto L_0x004f
        L_0x0044:
            java.lang.String r0 = "video_save"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 4
            goto L_0x004f
        L_0x004e:
            r2 = -1
        L_0x004f:
            switch(r2) {
                case 0: goto L_0x0083;
                case 1: goto L_0x007b;
                case 2: goto L_0x0073;
                case 3: goto L_0x006b;
                case 4: goto L_0x0063;
                case 5: goto L_0x005b;
                case 6: goto L_0x0053;
                default: goto L_0x0052;
            }
        L_0x0052:
            goto L_0x008a
        L_0x0053:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.ContinuousCapturePerformance.setContinuousCaptureStartTime(r0)
            goto L_0x008a
        L_0x005b:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.PictureSavePerformance.setPictureSaveStartTime(r0)
            goto L_0x008a
        L_0x0063:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.VideoSavePerformance.setVideoSaveStartTime(r0)
            goto L_0x008a
        L_0x006b:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.VideoRecordPerformance.setStartVideoRecordStartTime(r0)
            goto L_0x008a
        L_0x0073:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.SwitchModePerformance.setSwitchModeStartTime(r0)
            goto L_0x008a
        L_0x007b:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.CapturePerformance.addClickShutterTime(r0)
            goto L_0x008a
        L_0x0083:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.SwitchCameraPerformance.setSwitchCameraStartTime(r0)
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.perf.a.a(java.lang.String):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.lang.String r2) {
        /*
            int r0 = r2.hashCode()
            switch(r0) {
                case -1617888575: goto L_0x0044;
                case -1013464554: goto L_0x003a;
                case -785871842: goto L_0x0030;
                case 552585030: goto L_0x0026;
                case 793950546: goto L_0x001c;
                case 1432307344: goto L_0x0012;
                case 2129173454: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x004e
        L_0x0008:
            java.lang.String r0 = "switch_mode"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 2
            goto L_0x004f
        L_0x0012:
            java.lang.String r0 = "switch_camera"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 0
            goto L_0x004f
        L_0x001c:
            java.lang.String r0 = "start_video_record"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 3
            goto L_0x004f
        L_0x0026:
            java.lang.String r0 = "capture"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 1
            goto L_0x004f
        L_0x0030:
            java.lang.String r0 = "picture_save"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 5
            goto L_0x004f
        L_0x003a:
            java.lang.String r0 = "continuous_capture"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 6
            goto L_0x004f
        L_0x0044:
            java.lang.String r0 = "video_save"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 4
            goto L_0x004f
        L_0x004e:
            r2 = -1
        L_0x004f:
            switch(r2) {
                case 0: goto L_0x0083;
                case 1: goto L_0x007b;
                case 2: goto L_0x0073;
                case 3: goto L_0x006b;
                case 4: goto L_0x0063;
                case 5: goto L_0x005b;
                case 6: goto L_0x0053;
                default: goto L_0x0052;
            }
        L_0x0052:
            goto L_0x008a
        L_0x0053:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.ContinuousCapturePerformance.setContinuousCaptureEndTime(r0)
            goto L_0x008a
        L_0x005b:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.PictureSavePerformance.setPictureSaveEndTime(r0)
            goto L_0x008a
        L_0x0063:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.VideoSavePerformance.setVideoSaveEndTime(r0)
            goto L_0x008a
        L_0x006b:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.VideoRecordPerformance.setStartVideoRecordEndTime(r0)
            goto L_0x008a
        L_0x0073:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.SwitchModePerformance.setSwitchModeEndTime(r0)
            goto L_0x008a
        L_0x007b:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.CapturePerformance.addShowThumbnailTime(r0)
            goto L_0x008a
        L_0x0083:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.SwitchCameraPerformance.setSwitchCameraEndTime(r0)
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.perf.a.b(java.lang.String):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(java.lang.String r2) {
        /*
            int r0 = r2.hashCode()
            switch(r0) {
                case -1175081685: goto L_0x0071;
                case -998425709: goto L_0x0066;
                case -461923437: goto L_0x005c;
                case -412737700: goto L_0x0052;
                case -305521569: goto L_0x0048;
                case 70174929: goto L_0x003e;
                case 733765678: goto L_0x0034;
                case 809707499: goto L_0x0029;
                case 1198940624: goto L_0x001f;
                case 1247754916: goto L_0x0014;
                case 1756176183: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x007b
        L_0x0009:
            java.lang.String r0 = "launch_camera_opened"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x007b
            r2 = 2
            goto L_0x007c
        L_0x0014:
            java.lang.String r0 = "camera_exit_onstop_end"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x007b
            r2 = 10
            goto L_0x007c
        L_0x001f:
            java.lang.String r0 = "launch_on_create"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x007b
            r2 = 0
            goto L_0x007c
        L_0x0029:
            java.lang.String r0 = "camera_exit_onstop_start"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x007b
            r2 = 9
            goto L_0x007c
        L_0x0034:
            java.lang.String r0 = "launch_open_camera"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x007b
            r2 = 1
            goto L_0x007c
        L_0x003e:
            java.lang.String r0 = "launch_first_frame_draw"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x007b
            r2 = 7
            goto L_0x007c
        L_0x0048:
            java.lang.String r0 = "launch_create_session"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x007b
            r2 = 3
            goto L_0x007c
        L_0x0052:
            java.lang.String r0 = "launch_first_frame_available"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x007b
            r2 = 6
            goto L_0x007c
        L_0x005c:
            java.lang.String r0 = "launch_session_configured"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x007b
            r2 = 4
            goto L_0x007c
        L_0x0066:
            java.lang.String r0 = "camera_exit_onpause_start"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x007b
            r2 = 8
            goto L_0x007c
        L_0x0071:
            java.lang.String r0 = "launch_request_repeating"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x007b
            r2 = 5
            goto L_0x007c
        L_0x007b:
            r2 = -1
        L_0x007c:
            switch(r2) {
                case 0: goto L_0x00d0;
                case 1: goto L_0x00c8;
                case 2: goto L_0x00c0;
                case 3: goto L_0x00b8;
                case 4: goto L_0x00b0;
                case 5: goto L_0x00a8;
                case 6: goto L_0x00a0;
                case 7: goto L_0x0098;
                case 8: goto L_0x0090;
                case 9: goto L_0x0088;
                case 10: goto L_0x0080;
                default: goto L_0x007f;
            }
        L_0x007f:
            goto L_0x00d7
        L_0x0080:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.CameraExitPerformance.setsOnStopEndTime(r0)
            goto L_0x00d7
        L_0x0088:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.CameraExitPerformance.setOnStopStartTime(r0)
            goto L_0x00d7
        L_0x0090:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.CameraExitPerformance.setOnPauseStartTime(r0)
            goto L_0x00d7
        L_0x0098:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.LaunchPerformance.setFirstFrameDrawTime(r0)
            goto L_0x00d7
        L_0x00a0:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.LaunchPerformance.setFirstFrameAvailableTime(r0)
            goto L_0x00d7
        L_0x00a8:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.LaunchPerformance.setRequestRepeatingTime(r0)
            goto L_0x00d7
        L_0x00b0:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.LaunchPerformance.setSessionConfiguredTime(r0)
            goto L_0x00d7
        L_0x00b8:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.LaunchPerformance.setCreateSessionTime(r0)
            goto L_0x00d7
        L_0x00c0:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.LaunchPerformance.setCameraOpenedTime(r0)
            goto L_0x00d7
        L_0x00c8:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.LaunchPerformance.setOpenCameraTime(r0)
            goto L_0x00d7
        L_0x00d0:
            long r0 = java.lang.System.currentTimeMillis()
            com.oppo.camera.perf.LaunchPerformance.setOnCreateTime(r0)
        L_0x00d7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.perf.a.c(java.lang.String):void");
    }
}
