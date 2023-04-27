package com.sensetime.stmobile;

import android.content.Context;
import android.content.res.AssetManager;
import com.sensetime.stmobile.model.STHumanAction;
import com.sensetime.stmobile.model.STStickerInputParams;

public class STMobileStickerNative {
    public static final int ST_MOBILE_BROW_JUMP = 32;
    public static final int ST_MOBILE_EYE_BLINK = 2;
    public static final int ST_MOBILE_HEAD_PITCH = 16;
    public static final int ST_MOBILE_HEAD_YAW = 8;
    public static final int ST_MOBILE_MOUTH_AH = 4;
    private static final String TAG = "STMobileStickerNative";
    private static ItemCallback mCallback;
    private STSoundPlay mSoundPlay;
    private long nativeStickerHandle;

    public interface ItemCallback {
        void processTextureCallback(String str, RenderStatus renderStatus);
    }

    private native int createInstanceNative();

    private native void destroyInstanceNative();

    public native int addSticker(String str);

    public native int addStickerFromAssetsFile(String str, AssetManager assetManager);

    public native int addStickerFromBuffer(byte[] bArr, int i);

    public native int changeSticker(String str);

    public native int changeStickerFromAssetsFile(String str, AssetManager assetManager);

    public native int changeStickerFromBuffer(byte[] bArr, int i);

    public native int createSticker(int i);

    public native long getTriggerAction();

    public native int processTexture(int i, STHumanAction sTHumanAction, int i2, int i3, int i4, int i5, int i6, boolean z, STStickerInputParams sTStickerInputParams, int i7);

    public native int processTextureAndOutputBuffer(int i, STHumanAction sTHumanAction, int i2, int i3, int i4, int i5, int i6, boolean z, STStickerInputParams sTStickerInputParams, int i7, int i8, byte[] bArr);

    public native void removeAllStickers();

    public native int removeSticker(int i);

    public native int setMaxMemory(int i);

    public native int setSoundPlayDone(String str);

    public native int setWaitingMaterialLoaded(boolean z);

    enum RenderStatus {
        ST_MATERIAL_BEGIN_RENDER(0),
        ST_MATERIAL_RENDERING(1),
        ST_MATERIAL_NO_RENDERING(2);
        
        private final int status;

        private RenderStatus(int i) {
            this.status = i;
        }

        public int getStatus() {
            return this.status;
        }

        public static RenderStatus fromStatus(int i) {
            for (RenderStatus renderStatus : values()) {
                if (renderStatus.getStatus() == i) {
                    return renderStatus;
                }
            }
            return null;
        }
    }

    public static void setCallback(ItemCallback itemCallback) {
        mCallback = itemCallback;
    }

    public static void item_callback(String str, int i) {
        ItemCallback itemCallback = mCallback;
        if (itemCallback != null) {
            itemCallback.processTextureCallback(str, RenderStatus.fromStatus(i));
        }
    }

    static {
        System.loadLibrary("st_sticker");
        System.loadLibrary("st_sticker_jni");
    }

    public int createInstance(Context context) {
        STSoundPlay sTSoundPlay;
        if (context != null) {
            STSoundPlay.createInstance(context);
            this.mSoundPlay = STSoundPlay.getInstance();
        }
        int createInstanceNative = createInstanceNative();
        if (createInstanceNative == 0 && (sTSoundPlay = this.mSoundPlay) != null) {
            sTSoundPlay.setStickHandle(this);
        }
        return createInstanceNative;
    }

    public void destroyInstance() {
        destroyInstanceNative();
    }

    public int processTextureForceClear(int i, STHumanAction sTHumanAction, int i2, int i3, int i4, int i5, int i6, boolean z, STStickerInputParams sTStickerInputParams, int i7) {
        return processTexture(i, sTHumanAction, i2, i3, i4, i5, i6, z, sTStickerInputParams, i7);
    }
}
