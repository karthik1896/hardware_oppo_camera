package com.anc.humansdk;

public enum NNRuntime {
    RUNTIME_UNKNOW(0),
    RUNTIME_SNPE(1),
    RUNTIME_AIA(2),
    RUNTIME_OPENCL(3),
    RUNTIME_APU(4),
    RUNTIME_RANGE(5);
    
    private int value;

    private NNRuntime(int i) {
        this.value = i;
    }

    public int value() {
        return this.value;
    }
}
