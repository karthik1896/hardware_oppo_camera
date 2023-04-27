package co.polarr.renderer.entities;

import a.a.b.e.m;
import co.polarr.renderer.entities.Context;
import java.util.HashMap;

public class FaceItem {
    public Context.FaceState adjustments = new Context.FaceState();
    public float[] boundaries;
    public float[][] markers;

    public static FaceItem fromDecodedHashMap(HashMap<String, Object> hashMap) {
        return fromJSON(m.a(hashMap));
    }

    public static FaceItem fromJSON(String str) {
        return (FaceItem) m.a(str, FaceItem.class);
    }
}
