package co.polarr.renderer;

import android.graphics.Bitmap;
import java.util.List;

public interface RenderCallback {
    void onRenderBitmap(List<Bitmap> list);
}
