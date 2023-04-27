package co.polarr.renderer.entities;

import a.a.b.e.m;
import java.util.HashMap;

public class TextItem {
    public String align;
    public float angle;
    public float blendMix;
    public float blendMode;

    /* renamed from: color  reason: collision with root package name */
    public float[] f1430color;
    public boolean disabled;
    public String fontFamily;
    public String fontName;
    public float fontSize;
    public String fontStyle;
    public String fontWeight;
    public float letterSpacing;
    public float lineHeight;
    public String mode;
    public float opacity;
    public float orientation;
    public float[] position;
    public float[] scale;
    public float shadowBlur;
    public float[] shadowColor;
    public float[] shadowOffset;
    public float shadowOpacity;
    public float strokeSize;
    public String text;
    public String type;
    public float wrap;

    public static TextItem fromDecodedHashMap(HashMap<String, Object> hashMap) {
        return fromJSON(m.a(hashMap));
    }

    public static TextItem fromJSON(String str) {
        return (TextItem) m.a(str, TextItem.class);
    }
}
