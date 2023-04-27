package com.sensetime.stmobile.model;

public class STCondition {
    private int preState;
    private int preStateModuleId;
    private int triggerCount;
    private STTriggerEvent[] triggers;

    public int getPreStateModuleId() {
        return this.preStateModuleId;
    }

    public void setPreStateModuleId(int i) {
        this.preStateModuleId = i;
    }

    public int getPreState() {
        return this.preState;
    }

    public void setPreState(int i) {
        this.preState = i;
    }

    public STTriggerEvent[] getTriggers() {
        return this.triggers;
    }

    public void setTriggers(STTriggerEvent[] sTTriggerEventArr) {
        this.triggers = sTTriggerEventArr;
    }

    public int getTriggerCount() {
        return this.triggerCount;
    }

    public void setTriggerCount(int i) {
        this.triggerCount = i;
    }
}
