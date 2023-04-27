package co.polarr.renderer.entities;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class DrawingItem {
    public String filterId;
    public float intensity = 1.0f;
    public Bitmap overlayBitmap;
    public int overlayLeft;
    public int overlayTop;
    public Rect rect;
    public Bitmap thumbBitmap;

    public String toString() {
        return String.format("rect=%s::filterId=%s", new Object[]{this.rect, this.filterId});
    }
}
