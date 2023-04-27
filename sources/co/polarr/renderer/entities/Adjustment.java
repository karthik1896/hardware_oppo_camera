package co.polarr.renderer.entities;

import a.a.b.e.m;
import co.polarr.renderer.entities.Context;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adjustment {
    public Context.LocalState adjustments = new Context.LocalState();
    public float angle;
    public List<BrushItem> brush = new ArrayList();
    public float brush_hardness;
    public String brush_mode = "paint";
    public float brush_opacity;
    public float brush_radius;
    public float[] channel;
    public boolean disabled;
    public float[] endPoint;
    public float feather;
    public boolean invert;
    public int paintTextureId = 0;
    public float[] position;
    public float range;
    public boolean reflect;
    public float[] selectedColor;
    public boolean showOverlay;
    public float[] size;
    public float smoothness;
    public float[] startPoint;
    public float target;
    public float threshold;
    public String type;
    public boolean useRadius;

    public static Adjustment fromDecodedHashMap(HashMap<String, Object> hashMap) {
        return fromJSON(m.a(hashMap));
    }

    public static Adjustment fromJSON(String str) {
        return (Adjustment) m.a(str, Adjustment.class);
    }

    public static Map<String, Object> getAdjustmentHashMap(Context.LocalState localState) {
        return (Map) m.a(m.a(localState), Map.class);
    }

    public void updateStates(HashMap<String, Object> hashMap) {
        if (hashMap.containsKey("brush_radius")) {
            Object obj = hashMap.get("brush_radius");
            if (obj instanceof BigDecimal) {
                this.brush_radius = ((BigDecimal) obj).floatValue();
            }
        }
        if (hashMap.containsKey("brush_opacity")) {
            Object obj2 = hashMap.get("brush_opacity");
            if (obj2 instanceof BigDecimal) {
                this.brush_opacity = ((BigDecimal) obj2).floatValue();
            }
        }
        if (hashMap.containsKey("brush_hardness")) {
            Object obj3 = hashMap.get("brush_hardness");
            if (obj3 instanceof BigDecimal) {
                this.brush_hardness = ((BigDecimal) obj3).floatValue();
            }
        }
        if (hashMap.containsKey("feather")) {
            Object obj4 = hashMap.get("feather");
            if (obj4 instanceof BigDecimal) {
                this.feather = ((BigDecimal) obj4).floatValue();
            }
        }
        if (hashMap.containsKey("angle")) {
            Object obj5 = hashMap.get("angle");
            if (obj5 instanceof BigDecimal) {
                this.angle = ((BigDecimal) obj5).floatValue();
            }
        }
        if (hashMap.containsKey("threshold")) {
            Object obj6 = hashMap.get("threshold");
            if (obj6 instanceof BigDecimal) {
                this.threshold = ((BigDecimal) obj6).floatValue();
            }
        }
        if (hashMap.containsKey("selectedColor")) {
            Object obj7 = hashMap.get("selectedColor");
            if (obj7 instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) obj7;
                if (arrayList.size() == 3 && (arrayList.get(0) instanceof BigDecimal)) {
                    this.selectedColor = new float[3];
                    this.selectedColor[0] = ((BigDecimal) arrayList.get(0)).floatValue();
                    this.selectedColor[1] = ((BigDecimal) arrayList.get(1)).floatValue();
                    this.selectedColor[2] = ((BigDecimal) arrayList.get(2)).floatValue();
                }
            }
        }
        if (hashMap.containsKey("invert")) {
            this.invert = ((Boolean) hashMap.get("invert")).booleanValue();
        }
        if (hashMap.containsKey("showOverlay")) {
            this.showOverlay = ((Boolean) hashMap.get("showOverlay")).booleanValue();
        }
        if (hashMap.containsKey("disabled")) {
            this.disabled = ((Boolean) hashMap.get("disabled")).booleanValue();
        }
        if (hashMap.containsKey("useRadius")) {
            this.useRadius = ((Boolean) hashMap.get("useRadius")).booleanValue();
        }
        if (hashMap.containsKey("reflect")) {
            this.reflect = ((Boolean) hashMap.get("reflect")).booleanValue();
        }
    }
}
