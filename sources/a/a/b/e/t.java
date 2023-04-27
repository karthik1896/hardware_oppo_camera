package a.a.b.e;

import a.a.b.a.a.a;
import a.a.b.a.ab;
import a.a.b.a.ac;
import a.a.b.a.ak;
import a.a.b.a.am;
import a.a.b.a.au;
import a.a.b.a.b;
import a.a.b.a.bh;
import a.a.b.a.bk;
import a.a.b.a.bl;
import a.a.b.a.bm;
import a.a.b.a.bn;
import a.a.b.a.bp;
import a.a.b.a.bq;
import a.a.b.a.c;
import a.a.b.a.d;
import a.a.b.a.j;
import a.a.b.a.q;
import a.a.b.a.u;
import a.a.b.a.x;
import a.a.b.f;
import android.content.res.Resources;
import co.polarr.renderer.entities.Adjustment;
import co.polarr.renderer.entities.BrushItem;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.FaceItem;
import co.polarr.renderer.entities.HistoryItem;
import co.polarr.renderer.entities.HistoryStroeItem;
import co.polarr.renderer.entities.SpotItem;
import co.polarr.renderer.entities.TextItem;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONObject;

public class t {

    /* renamed from: a  reason: collision with root package name */
    public static final List<HistoryItem> f77a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public static int f78b = 0;
    public static l c;
    public static String d;
    public static t e = null;
    public Map<String, JSONObject> f = new HashMap();

    public static int a(byte[] bArr) {
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    public static t a(Resources resources) {
        t tVar;
        synchronized (t.class) {
            try {
                if (e == null) {
                    e = new t();
                    e.b(resources);
                }
                tVar = e;
            } catch (Throwable th) {
                Class<t> cls = t.class;
                throw th;
            }
        }
        return tVar;
    }

    public static Object a(String str, Object obj) {
        float floatValue;
        TextItem textItem;
        FaceItem faceItem;
        ArrayList arrayList;
        Adjustment adjustment;
        TextItem textItem2;
        FaceItem faceItem2;
        Adjustment adjustment2;
        if (obj == null) {
            return null;
        }
        if (obj instanceof ArrayList) {
            if (str.equals("text") || str.equals("zPrevText")) {
                ArrayList arrayList2 = new ArrayList();
                Iterator it = ((ArrayList) obj).iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof HashMap) {
                        textItem2 = TextItem.fromDecodedHashMap((HashMap) next);
                    } else if (next instanceof TextItem) {
                        textItem2 = (TextItem) next;
                    }
                    arrayList2.add(textItem2);
                }
                return arrayList2;
            } else if (str.equals("faces") || str.equals("prevFaces")) {
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = ((ArrayList) obj).iterator();
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    if (next2 instanceof HashMap) {
                        faceItem2 = FaceItem.fromDecodedHashMap((HashMap) next2);
                    } else if (next2 instanceof FaceItem) {
                        faceItem2 = (FaceItem) next2;
                    }
                    arrayList3.add(faceItem2);
                }
                return arrayList3;
            } else if (str.equals("face_features")) {
                ArrayList arrayList4 = new ArrayList();
                Iterator it3 = ((ArrayList) obj).iterator();
                while (it3.hasNext()) {
                    Object next3 = it3.next();
                    arrayList4.add(next3 instanceof Context.FaceFeaturesState ? (Context.FaceFeaturesState) next3 : m.a(m.a(next3), Context.FaceFeaturesState.class));
                }
                return arrayList4;
            } else if (str.equals("spots") || str.equals("zPrevSpots")) {
                ArrayList arrayList5 = new ArrayList();
                Iterator it4 = ((ArrayList) obj).iterator();
                while (it4.hasNext()) {
                    Object next4 = it4.next();
                    arrayList5.add(next4 instanceof SpotItem ? (SpotItem) next4 : m.a(m.a(next4), SpotItem.class));
                }
                return arrayList5;
            } else if (str.equals("prevBrushes")) {
                ArrayList arrayList6 = new ArrayList();
                Iterator it5 = ((ArrayList) obj).iterator();
                while (it5.hasNext()) {
                    Object next5 = it5.next();
                    arrayList6.add(next5 instanceof BrushItem ? (BrushItem) next5 : m.a(m.a(next5), BrushItem.class));
                }
                return arrayList6;
            } else if (str.equals("local_adjustments")) {
                ArrayList arrayList7 = new ArrayList();
                Iterator it6 = ((ArrayList) obj).iterator();
                while (it6.hasNext()) {
                    Object next6 = it6.next();
                    if (next6 instanceof HashMap) {
                        adjustment2 = Adjustment.fromDecodedHashMap((HashMap) next6);
                    } else if (next6 instanceof Adjustment) {
                        adjustment2 = (Adjustment) next6;
                    }
                    arrayList7.add(adjustment2);
                }
                return arrayList7;
            } else {
                ArrayList arrayList8 = (ArrayList) obj;
                arrayList = new ArrayList();
                float[] fArr = new float[arrayList8.size()];
                Iterator it7 = arrayList8.iterator();
                boolean z = false;
                int i = 0;
                while (it7.hasNext()) {
                    Object next7 = it7.next();
                    if (next7 instanceof ArrayList) {
                        z = true;
                    }
                    Object a2 = a(str, next7);
                    if (!z && (a2 instanceof Float)) {
                        fArr[i] = ((Float) a2).floatValue();
                        i++;
                    } else {
                        arrayList.add(a2);
                    }
                }
                if (!z || arrayList.isEmpty()) {
                    return fArr;
                }
                if (!(arrayList.get(0) instanceof float[])) {
                    return arrayList.toArray();
                }
            }
        } else if (obj instanceof JsonArray) {
            if (str.equals("text") || str.equals("zPrevText")) {
                ArrayList arrayList9 = new ArrayList();
                Iterator it8 = ((JsonArray) obj).iterator();
                while (it8.hasNext()) {
                    Object next8 = it8.next();
                    if (next8 instanceof HashMap) {
                        textItem = TextItem.fromDecodedHashMap((HashMap) next8);
                    } else {
                        if (next8 instanceof JSONObject) {
                            next8 = m.a(m.a(next8), TextItem.class);
                        } else if (!(next8 instanceof TextItem)) {
                        }
                        textItem = (TextItem) next8;
                    }
                    arrayList9.add(textItem);
                }
                return arrayList9;
            } else if (str.equals("faces") || str.equals("prevFaces")) {
                ArrayList arrayList10 = new ArrayList();
                Iterator it9 = ((JsonArray) obj).iterator();
                while (it9.hasNext()) {
                    Object next9 = it9.next();
                    if (next9 instanceof HashMap) {
                        faceItem = FaceItem.fromDecodedHashMap((HashMap) next9);
                    } else {
                        if (next9 instanceof JSONObject) {
                            next9 = m.a(m.a(next9), FaceItem.class);
                        } else if (!(next9 instanceof FaceItem)) {
                        }
                        faceItem = (FaceItem) next9;
                    }
                    arrayList10.add(faceItem);
                }
                return arrayList10;
            } else if (str.equals("face_features")) {
                ArrayList arrayList11 = new ArrayList();
                Iterator<JsonElement> it10 = ((JsonArray) obj).iterator();
                while (it10.hasNext()) {
                    JsonElement next10 = it10.next();
                    arrayList11.add(next10 instanceof Context.FaceFeaturesState ? (Context.FaceFeaturesState) next10 : m.a(m.a(next10), Context.FaceFeaturesState.class));
                }
                return arrayList11;
            } else if (str.equals("spots") || str.equals("zPrevSpots")) {
                ArrayList arrayList12 = new ArrayList();
                Iterator<JsonElement> it11 = ((JsonArray) obj).iterator();
                while (it11.hasNext()) {
                    JsonElement next11 = it11.next();
                    arrayList12.add(next11 instanceof SpotItem ? (SpotItem) next11 : m.a(m.a(next11), SpotItem.class));
                }
                return arrayList12;
            } else if (str.equals("prevBrushes")) {
                ArrayList arrayList13 = new ArrayList();
                Iterator<JsonElement> it12 = ((JsonArray) obj).iterator();
                while (it12.hasNext()) {
                    JsonElement next12 = it12.next();
                    arrayList13.add(next12 instanceof BrushItem ? (BrushItem) next12 : m.a(m.a(next12), BrushItem.class));
                }
                return arrayList13;
            } else if (str.equals("local_adjustments")) {
                ArrayList arrayList14 = new ArrayList();
                Iterator it13 = ((JsonArray) obj).iterator();
                while (it13.hasNext()) {
                    Object next13 = it13.next();
                    if (next13 instanceof HashMap) {
                        adjustment = Adjustment.fromDecodedHashMap((HashMap) next13);
                    } else {
                        if (next13 instanceof JSONObject) {
                            next13 = m.a(m.a(next13), Adjustment.class);
                        } else if (!(next13 instanceof Adjustment)) {
                        }
                        adjustment = (Adjustment) next13;
                    }
                    arrayList14.add(adjustment);
                }
                return arrayList14;
            } else {
                JsonArray jsonArray = (JsonArray) obj;
                arrayList = new ArrayList();
                float[] fArr2 = new float[jsonArray.size()];
                Iterator<JsonElement> it14 = jsonArray.iterator();
                boolean z2 = false;
                int i2 = 0;
                while (it14.hasNext()) {
                    JsonElement next14 = it14.next();
                    if (next14 instanceof JsonArray) {
                        z2 = true;
                    }
                    Object a3 = a(str, (Object) next14);
                    if (!z2 && (a3 instanceof Float)) {
                        fArr2[i2] = ((Float) a3).floatValue();
                        i2++;
                    } else {
                        arrayList.add(a3);
                    }
                }
                if (!z2 || arrayList.isEmpty()) {
                    return fArr2;
                }
                if (!(arrayList.get(0) instanceof float[])) {
                    return arrayList.toArray();
                }
            }
        } else if ((obj instanceof Boolean) || (obj instanceof HashMap) || (obj instanceof float[]) || (obj instanceof float[][])) {
            return obj;
        } else {
            if ("mosaic_pattern".equals(str) && (obj instanceof String)) {
                return obj;
            }
            Float valueOf = Float.valueOf(0.0f);
            if (obj instanceof BigDecimal) {
                floatValue = ((BigDecimal) obj).floatValue();
            } else if (obj instanceof Integer) {
                floatValue = (float) ((Integer) obj).intValue();
            } else if (obj instanceof Float) {
                return (Float) obj;
            } else {
                if (!(obj instanceof Double)) {
                    return valueOf;
                }
                floatValue = ((Double) obj).floatValue();
            }
            return Float.valueOf(floatValue);
        }
        return arrayList.toArray(new float[arrayList.size()][]);
    }

    public static String a(String str) {
        return str + ".glsl";
    }

    public static List<a> a(Resources resources, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new j(resources, context));
        arrayList.add(new c(resources, context));
        arrayList.add(new x(resources, context));
        arrayList.add(new u(resources, context));
        arrayList.add(new bh(resources, context));
        arrayList.add(new bn(resources, context));
        arrayList.add(new bq(resources, context));
        arrayList.add(new bp(resources, context));
        arrayList.add(new ac(resources, context));
        arrayList.add(new am(resources, context));
        arrayList.add(new q(resources, context));
        arrayList.add(new d(resources, context));
        arrayList.add(new bm(resources, context));
        arrayList.add(new ak(resources, context));
        arrayList.add(new bl(resources, context));
        arrayList.add(new b(resources, context));
        arrayList.add(new bk(resources, context));
        arrayList.add(new au(resources, context));
        arrayList.add(new ab(resources, context));
        return arrayList;
    }

    public static void a(String str, List<FaceItem> list, List<Context.FaceFeaturesState> list2) {
        l lVar;
        List<HistoryItem> list3;
        f78b = 0;
        f77a.clear();
        HashMap hashMap = new HashMap();
        f.a(hashMap);
        if (list != null) {
            hashMap.put("faces", list);
        }
        if (list2 != null) {
            hashMap.put("face_features", list2);
        }
        HistoryItem historyItem = new HistoryItem("labels.original", hashMap, "");
        d = str;
        String str2 = d;
        List<HistoryItem> list4 = null;
        if (!(str2 == null || (lVar = c) == null)) {
            HistoryStroeItem a2 = lVar.a(str2);
            if (!(a2 == null || (list3 = a2.historyItemList) == null)) {
                f78b = a2.historyIndex;
                list4 = list3;
            }
            if (list4 != null && !list4.isEmpty()) {
                if (list4.get(0).message.equals("labels.original")) {
                    list4.remove(list4.get(0));
                }
                for (HistoryItem next : list4) {
                    Map<String, Object> a3 = c.a(m.a(next.state));
                    if (a3.containsKey("screen")) {
                        a3.remove("screen");
                    }
                    next.state = a3;
                    HashMap hashMap2 = new HashMap();
                    for (String next2 : next.state.keySet()) {
                        hashMap2.put(next2, a(next2, next.state.get(next2)));
                    }
                    next.state = hashMap2;
                }
            }
        }
        if (list4 != null) {
            f77a.addAll(list4);
        }
        f77a.add(0, historyItem);
        f78b = Math.min(f78b, f77a.size() - 1);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES");
        instance.init(2, secretKeySpec);
        return instance.doFinal(bArr2);
    }

    public static List<a.a.b.a.a.b> b(Resources resources, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new x(resources, context));
        arrayList.add(new bh(resources, context));
        arrayList.add(new bn(resources, context));
        arrayList.add(new ac(resources, context));
        arrayList.add(new am(resources, context));
        arrayList.add(new q(resources, context));
        arrayList.add(new d(resources, context));
        arrayList.add(new b(resources, context));
        arrayList.add(new bk(resources, context));
        return arrayList;
    }

    public static byte[] b(byte[] bArr) {
        int i = 0;
        byte b2 = bArr[0];
        byte[] bArr2 = new byte[((bArr.length - b2) - 1)];
        byte[] bArr3 = new byte[b2];
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < b2) {
            if (i3 < bArr2.length) {
                bArr2[i3] = (byte) bArr[i4];
                i3++;
                i4++;
            }
            bArr3[i2] = (byte) bArr[i4];
            i2++;
            i4++;
        }
        int length = bArr2.length;
        int i5 = i3;
        while (i < length - i3) {
            bArr2[i5] = (byte) bArr[i4];
            i++;
            i5++;
            i4++;
        }
        return a(bArr3, bArr2);
    }

    public String a(Resources resources, String str) {
        if (!this.f.containsKey(str)) {
            return null;
        }
        JSONObject jSONObject = this.f.get(str);
        try {
            InputStream open = resources.getAssets().open("res.dat");
            byte[] bArr = new byte[jSONObject.getInt("length")];
            open.skip((long) jSONObject.getInt("start"));
            open.read(bArr);
            open.close();
            return new String(b(bArr), "utf-8").replaceAll("\\r\\n", "\n");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void a() {
        this.f.clear();
    }

    public void b(Resources resources) {
        if (this.f.isEmpty()) {
            try {
                InputStream open = resources.getAssets().open("res.dat");
                byte[] bArr = new byte[4];
                open.read(bArr);
                int a2 = a(bArr);
                byte[] bArr2 = new byte[a2];
                open.read(bArr2);
                JSONArray jSONArray = new JSONArray(new String(b(bArr2), "utf-8"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("filename");
                    jSONObject.put("start", jSONObject.getInt("start") + a2 + 4);
                    this.f.put(string, jSONObject);
                }
                open.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
