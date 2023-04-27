package co.polarr.renderer.render;

import android.graphics.Bitmap;

public interface OnExportCallback {
    void onExport(Bitmap bitmap, byte[] bArr);

    void onExportSize(long j);
}
