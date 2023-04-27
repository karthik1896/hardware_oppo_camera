package com.oppo.camera.aps.service;

import com.oppo.camera.aps.ApsCameraRequestTag;
import com.oppo.camera.aps.adapter.ApsResult;

public interface OnCaptureHeciDataListener {
    boolean onHeicReceived(ApsResult apsResult, ApsCameraRequestTag apsCameraRequestTag);
}
