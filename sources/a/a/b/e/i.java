package a.a.b.e;

import android.content.Context;
import android.graphics.Typeface;
import android.util.LruCache;
import co.polarr.renderer.entities.FontItem;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, FontItem> f60a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, FontItem> f61b = new HashMap();
    public static final LruCache<FontItem, Typeface> c = new LruCache<>(5);
    public static final LruCache<String, Typeface> d = new LruCache<>(20);

    static {
        f60a.put("Abril Fatface", new FontItem("Abril Fatface", "AbrilFatface-Regular.ttf"));
        f60a.put("Amatica SC", new FontItem("Amatica SC", "AmaticaSC-Regular.ttf"));
        f60a.put("Audiowide", new FontItem("Audiowide", "Audiowide-Regular.ttf"));
        f60a.put("Bangers", new FontItem("'Bangers'", "Bangers.ttf"));
        f60a.put("BioRhyme", new FontItem("BioRhyme", "BioRhyme-Regular.ttf"));
        f60a.put("Cinzel", new FontItem("Cinzel", "Cinzel-Regular.ttf"));
        f60a.put("GUERRILLA", new FontItem("GUERRILLA", "GUERRILLA-Normal.otf"));
        f60a.put("Intro Inline", new FontItem("Intro Inline", "Intro Inline.otf"));
        f60a.put("Intro", new FontItem("Intro", "Intro.otf"));
        f60a.put("Monoton", new FontItem("Monoton", "Monoton-Regular.ttf"));
        f60a.put("Pahnto", new FontItem("Pahnto", "pahnto.ttf"));
        f60a.put("Panton B", new FontItem("Panton", 900, "Panton-BlackCaps.otf"));
        f60a.put("Panton B I", new FontItem("Panton", 900, "italic", "Panton-BlackitalicCaps.otf"));
        f60a.put("Panton L", new FontItem("Panton", 300, "Panton-LightCaps.otf"));
        f60a.put("Panton L I", new FontItem("Panton", 300, "italic", "Panton-LightitalicCaps.otf"));
        f60a.put("Sensa Brush", new FontItem("Sensa Brush", "SensaBrush-Fill.otf"));
        f60a.put("Special Elite", new FontItem("Special Elite", "SpecialElite.ttf"));
        f60a.put("Sprite Graffiti", new FontItem("Sprite Graffiti", "Sprite Graffiti.otf"));
        f60a.put("Sunday", new FontItem("Sunday", "Sunday-Regular.otf"));
        f60a.put("Unkempt", new FontItem("Unkempt", "Unkempt-Regular.ttf"));
        f61b.put("Artwork", new FontItem("Artwork", "PolarrArtwork.otf"));
        f61b.put("Amatica SC", new FontItem("Amatica SC", "AmaticaSC-Regular.ttf"));
        f61b.put("Audiowide", new FontItem("Audiowide", "Audiowide-Regular.ttf"));
        f61b.put("Bangers", new FontItem("'Bangers'", "Bangers.ttf"));
        f61b.put("BioRhyme", new FontItem("BioRhyme", "BioRhyme-Regular.ttf"));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:36|37) */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r3.delete();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00d9 */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface a(android.content.Context r3, android.content.res.AssetManager r4, co.polarr.renderer.entities.TextItem r5, int r6) {
        /*
            java.lang.String r0 = r5.type
            java.lang.String r1 = "Artwork"
            boolean r0 = r1.equalsIgnoreCase(r0)
            java.lang.String r2 = "editor/fonts/"
            if (r0 == 0) goto L_0x0042
            java.util.Map<java.lang.String, co.polarr.renderer.entities.FontItem> r3 = f61b
            java.lang.Object r3 = r3.get(r1)
            co.polarr.renderer.entities.FontItem r3 = (co.polarr.renderer.entities.FontItem) r3
            android.util.LruCache<co.polarr.renderer.entities.FontItem, android.graphics.Typeface> r0 = c
            java.lang.Object r0 = r0.get(r3)
            android.graphics.Typeface r0 = (android.graphics.Typeface) r0
            if (r0 != 0) goto L_0x00ec
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0034 }
            r0.<init>()     // Catch:{ Exception -> 0x0034 }
            r0.append(r2)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r1 = r3.src     // Catch:{ Exception -> 0x0034 }
            r0.append(r1)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0034 }
            android.graphics.Typeface r4 = android.graphics.Typeface.createFromAsset(r4, r0)     // Catch:{ Exception -> 0x0034 }
            goto L_0x003a
        L_0x0034:
            java.lang.String r4 = r5.fontFamily
            android.graphics.Typeface r4 = android.graphics.Typeface.create(r4, r6)
        L_0x003a:
            r0 = r4
            android.util.LruCache<co.polarr.renderer.entities.FontItem, android.graphics.Typeface> r4 = c
            r4.put(r3, r0)
            goto L_0x00ec
        L_0x0042:
            java.util.Map<java.lang.String, co.polarr.renderer.entities.FontItem> r0 = f60a
            java.lang.String r1 = r5.fontName
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x0083
            java.util.Map<java.lang.String, co.polarr.renderer.entities.FontItem> r3 = f60a
            java.lang.String r0 = r5.fontName
            java.lang.Object r3 = r3.get(r0)
            co.polarr.renderer.entities.FontItem r3 = (co.polarr.renderer.entities.FontItem) r3
            android.util.LruCache<co.polarr.renderer.entities.FontItem, android.graphics.Typeface> r0 = c
            java.lang.Object r0 = r0.get(r3)
            android.graphics.Typeface r0 = (android.graphics.Typeface) r0
            if (r0 != 0) goto L_0x00ec
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0076 }
            r0.<init>()     // Catch:{ Exception -> 0x0076 }
            r0.append(r2)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r1 = r3.src     // Catch:{ Exception -> 0x0076 }
            r0.append(r1)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0076 }
            android.graphics.Typeface r4 = android.graphics.Typeface.createFromAsset(r4, r0)     // Catch:{ Exception -> 0x0076 }
            goto L_0x007c
        L_0x0076:
            java.lang.String r4 = r5.fontFamily
            android.graphics.Typeface r4 = android.graphics.Typeface.create(r4, r6)
        L_0x007c:
            android.util.LruCache<co.polarr.renderer.entities.FontItem, android.graphics.Typeface> r5 = c
            r5.put(r3, r4)
            r0 = r4
            goto L_0x00ec
        L_0x0083:
            java.util.Map<java.lang.String, co.polarr.renderer.entities.FontItem> r0 = f61b
            java.lang.String r1 = r5.fontName
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x00b7
            java.util.Map<java.lang.String, co.polarr.renderer.entities.FontItem> r3 = f61b
            java.lang.String r0 = r5.fontName
            java.lang.Object r3 = r3.get(r0)
            co.polarr.renderer.entities.FontItem r3 = (co.polarr.renderer.entities.FontItem) r3
            android.util.LruCache<co.polarr.renderer.entities.FontItem, android.graphics.Typeface> r0 = c
            java.lang.Object r0 = r0.get(r3)
            android.graphics.Typeface r0 = (android.graphics.Typeface) r0
            if (r0 != 0) goto L_0x00ec
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0076 }
            r0.<init>()     // Catch:{ Exception -> 0x0076 }
            r0.append(r2)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r1 = r3.src     // Catch:{ Exception -> 0x0076 }
            r0.append(r1)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0076 }
            android.graphics.Typeface r4 = android.graphics.Typeface.createFromAsset(r4, r0)     // Catch:{ Exception -> 0x0076 }
            goto L_0x007c
        L_0x00b7:
            android.util.LruCache<java.lang.String, android.graphics.Typeface> r4 = d     // Catch:{ Exception -> 0x00c2 }
            java.lang.String r0 = r5.fontName     // Catch:{ Exception -> 0x00c2 }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ Exception -> 0x00c2 }
            android.graphics.Typeface r4 = (android.graphics.Typeface) r4     // Catch:{ Exception -> 0x00c2 }
            goto L_0x00c7
        L_0x00c2:
            r4 = move-exception
            r4.printStackTrace()
            r4 = 0
        L_0x00c7:
            r0 = r4
            if (r0 != 0) goto L_0x00ec
            java.lang.String r4 = r5.fontName
            if (r4 == 0) goto L_0x00ec
            java.io.File r3 = a(r3, r4)
            if (r3 == 0) goto L_0x00dc
            android.graphics.Typeface r3 = android.graphics.Typeface.createFromFile(r3)     // Catch:{ Exception -> 0x00d9 }
            goto L_0x00e2
        L_0x00d9:
            r3.delete()     // Catch:{ Exception -> 0x00dc }
        L_0x00dc:
            java.lang.String r3 = r5.fontFamily
            android.graphics.Typeface r3 = android.graphics.Typeface.create(r3, r6)
        L_0x00e2:
            r0 = r3
            if (r0 == 0) goto L_0x00ec
            android.util.LruCache<java.lang.String, android.graphics.Typeface> r3 = d
            java.lang.String r4 = r5.fontName
            r3.put(r4, r0)
        L_0x00ec:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.b.e.i.a(android.content.Context, android.content.res.AssetManager, co.polarr.renderer.entities.TextItem, int):android.graphics.Typeface");
    }

    public static File a(Context context, String str) {
        return null;
    }
}
