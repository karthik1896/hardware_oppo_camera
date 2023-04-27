package com.sensetime.stmobile.model;

public class STTriggerEvent {
    private boolean isAppear;
    private int moduleId;
    private long trigger;
    private int triggerType;

    public int getTriggerType() {
        return this.triggerType;
    }

    public void setTriggerType(int i) {
        this.triggerType = i;
    }

    public long getTrigger() {
        return this.trigger;
    }

    public void setTrigger(long j) {
        this.trigger = j;
    }

    public int getModuleId() {
        return this.moduleId;
    }

    public void setModuleId(int i) {
        this.moduleId = i;
    }

    public boolean isAppear() {
        return this.isAppear;
    }

    public void setAppear(boolean z) {
        this.isAppear = z;
    }
}
