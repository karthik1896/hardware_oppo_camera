package co.polarr.renderer.entities;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

public class MagicEraserPath {
    public List<PointF> points;
    public float radius;

    public MagicEraserPath copy() {
        MagicEraserPath magicEraserPath = new MagicEraserPath();
        List<PointF> list = this.points;
        if (list != null) {
            magicEraserPath.points = new ArrayList(list);
        }
        magicEraserPath.radius = this.radius;
        return magicEraserPath;
    }

    public String toString() {
        return "points=" + this.points.toString() + "::radius=" + this.radius;
    }
}
