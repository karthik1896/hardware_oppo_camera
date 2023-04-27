package co.polarr.renderer.entities;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrushItem {
    public static final float MAX_MOSAIC_SIZE = 3.0f;
    public boolean blend = false;
    public float[] channel = {1.0f, 0.0f, 0.0f, 0.0f};
    public boolean erase = false;
    public float flow = 0.5f;
    public double hardness = 0.0d;
    public boolean interpolate = true;
    public String mode = "paint";
    public float mosaicSize = 1.0f;
    public String pointId;
    public List<Float> points = new ArrayList();
    public float[] prevPoint;
    public float randomize = 0.0f;
    public float size = 0.5f;
    public float spacing = 0.25f;
    public String texture = "stroke_1";
    public List<PointF> touchPoints = new ArrayList();

    public BrushItem copy() {
        BrushItem brushItem = new BrushItem();
        brushItem.points.addAll(this.points);
        brushItem.touchPoints.addAll(this.touchPoints);
        float[] fArr = this.prevPoint;
        if (fArr != null) {
            brushItem.prevPoint = Arrays.copyOf(fArr, fArr.length);
        }
        float[] fArr2 = this.channel;
        brushItem.channel = Arrays.copyOf(fArr2, fArr2.length);
        brushItem.pointId = this.pointId;
        brushItem.size = this.size;
        brushItem.mosaicSize = this.mosaicSize;
        brushItem.spacing = this.spacing;
        brushItem.randomize = this.randomize;
        brushItem.flow = this.flow;
        brushItem.hardness = this.hardness;
        brushItem.erase = this.erase;
        brushItem.interpolate = this.interpolate;
        brushItem.mode = this.mode;
        brushItem.texture = this.texture;
        brushItem.blend = this.blend;
        return brushItem;
    }
}
