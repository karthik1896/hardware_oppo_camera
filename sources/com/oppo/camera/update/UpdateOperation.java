package com.oppo.camera.update;

public class UpdateOperation {
    private String mKey;
    private String mOperation;
    private String mValue;

    public String getOperation() {
        return this.mOperation;
    }

    public void setOperation(String str) {
        this.mOperation = str;
    }

    public String getKey() {
        return this.mKey;
    }

    public void setKey(String str) {
        this.mKey = str;
    }

    public String getValue() {
        return this.mValue;
    }

    public void setValue(String str) {
        this.mValue = str;
    }
}
