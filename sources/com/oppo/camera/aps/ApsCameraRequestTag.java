package com.oppo.camera.aps;

import com.oppo.camera.aps.adapter.ApsAdapterDecision;

public class ApsCameraRequestTag {
    public ApsAdapterDecision.DecisionResult mCaptureDecisionResult = null;
    public Object mTag = null;
    public boolean mbFrontCamera = false;
    public boolean mbInThirdApp = false;
    public boolean mbPIAI = false;
    public boolean mbQcom = true;
}
