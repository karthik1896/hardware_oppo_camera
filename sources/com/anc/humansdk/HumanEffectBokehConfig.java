package com.anc.humansdk;

import android.content.res.AssetManager;
import android.os.Build;

public class HumanEffectBokehConfig {
    public AssetManager assetsMgr;
    public String cachePath;
    public boolean isRealTime;
    public byte[] modelData;
    public String modelPath;
    public String nativeLibPath;
    public int runtime;

    public static HumanEffectBokehConfig Instance() {
        return new HumanEffectBokehConfig();
    }

    public HumanEffectBokehConfig setRealTime(boolean z) {
        this.isRealTime = z;
        return this;
    }

    public HumanEffectBokehConfig setModelPath(String str) {
        this.modelPath = str;
        return this;
    }

    public HumanEffectBokehConfig setModelData(byte[] bArr) {
        this.modelData = bArr;
        return this;
    }

    public HumanEffectBokehConfig setCachePath(String str) {
        this.cachePath = str;
        return this;
    }

    public HumanEffectBokehConfig setNativeLibPath(String str) {
        this.nativeLibPath = str;
        return this;
    }

    public int getRuntime() {
        return this.runtime;
    }

    public HumanEffectBokehConfig setRuntime(int i) {
        this.runtime = i;
        return this;
    }

    public HumanEffectBokehConfig setAssetsMgr(AssetManager assetManager) {
        this.assetsMgr = assetManager;
        return this;
    }

    public void InferenceRuntime() {
        if (Build.HARDWARE.trim().toLowerCase().matches("qcom")) {
            this.runtime = NNRuntime.RUNTIME_SNPE.value();
        } else {
            this.runtime = NNRuntime.RUNTIME_AIA.value();
        }
    }

    public String toString() {
        return String.format("realtime %b, runtime %d", new Object[]{Boolean.valueOf(this.isRealTime), Integer.valueOf(this.runtime)});
    }
}
