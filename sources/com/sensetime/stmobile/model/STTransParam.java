package com.sensetime.stmobile.model;

public class STTransParam {
    private int delayFrame;
    private int fadeFrame;
    private int lastingFrame;
    private int playloop;

    public int getFadeFrame() {
        return this.fadeFrame;
    }

    public void setFadeFrame(int i) {
        this.fadeFrame = i;
    }

    public int getDelayFrame() {
        return this.delayFrame;
    }

    public void setDelayFrame(int i) {
        this.delayFrame = i;
    }

    public int getLastingFrame() {
        return this.lastingFrame;
    }

    public void setLastingFrame(int i) {
        this.lastingFrame = i;
    }

    public int getPlayloop() {
        return this.playloop;
    }

    public void setPlayloop(int i) {
        this.playloop = i;
    }
}
