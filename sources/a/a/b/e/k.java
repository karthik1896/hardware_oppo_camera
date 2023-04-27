package a.a.b.e;

import a.a.b.a.t;
import a.a.b.b.d;
import a.a.b.b.f;
import a.a.b.b.g;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.FaceItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, List<FaceItem>> f66a = new HashMap();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public b f67a;

        /* renamed from: b  reason: collision with root package name */
        public float[] f68b;
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public float[][] f69a;

        /* renamed from: b  reason: collision with root package name */
        public float[][] f70b;
        public float[][] c;
        public float[][] d;
        public float[][] e;
        public float[][] f;
        public float[][] g;
        public float[][] h;
        public float[][] i;
        public float[][] j;
        public float[][] k;
        public float[][] l;
        public float[][] m;
        public float[] n;
        public float[][] o;
        public float[] p;
        public float[] q;
        public float[] r;
        public float[] s;
        public float[] t;
        public float[][] u;
        public float[][] v;
    }

    static {
        ArrayList arrayList = new ArrayList();
        FaceItem faceItem = new FaceItem();
        faceItem.markers = new float[][]{new float[]{0.43973213f, 0.48983365f}, new float[]{0.44515306f, 0.5485213f}, new float[]{0.453125f, 0.60489833f}, new float[]{0.46269134f, 0.6621996f}, new float[]{0.47895408f, 0.715342f}, new float[]{0.5041454f, 0.7610906f}, new float[]{0.53348213f, 0.8012939f}, new float[]{0.5660077f, 0.83687615f}, new float[]{0.6029974f, 0.8461183f}, new float[]{0.63998723f, 0.8359519f}, new float[]{0.674426f, 0.79990757f}, new float[]{0.70471936f, 0.7560074f}, new float[]{0.7279974f, 0.7051756f}, new float[]{0.7413903f, 0.6478743f}, new float[]{0.7471301f, 0.58641404f}, new float[]{0.75127554f, 0.5254159f}, new float[]{0.75191325f, 0.46395564f}, new float[]{0.46205357f, 0.43715343f}, new float[]{0.48086736f, 0.41913125f}, new float[]{0.50510204f, 0.41451016f}, new float[]{0.53061223f, 0.42144176f}, new float[]{0.55452806f, 0.435305f}, new float[]{0.6176658f, 0.4292976f}, new float[]{0.64285713f, 0.4108133f}, new float[]{0.6686862f, 0.40064695f}, new float[]{0.69547194f, 0.4029575f}, new float[]{0.71811223f, 0.42051756f}, new float[]{0.5883291f, 0.4801294f}, new float[]{0.58896685f, 0.5207948f}, new float[]{0.58992344f, 0.5623845f}, new float[]{0.5905612f, 0.6044362f}, new float[]{0.5682398f, 0.62569314f}, new float[]{0.58003825f, 0.63308686f}, new float[]{0.59247446f, 0.6390943f}, new float[]{0.60491073f, 0.6321627f}, new float[]{0.61734694f, 0.625231f}, new float[]{0.49330357f, 0.48567468f}, new float[]{0.5098852f, 0.4690388f}, new float[]{0.5315689f, 0.4690388f}, new float[]{0.54751277f, 0.49121997f}, new float[]{0.52965564f, 0.49815157f}, new float[]{0.5089286f, 0.49815157f}, new float[]{0.63297194f, 0.4861368f}, new float[]{0.64859694f, 0.46349353f}, new float[]{0.67091835f, 0.46025878f}, new float[]{0.68813777f, 0.47550833f}, new float[]{0.67315054f, 0.48983365f}, new float[]{0.65242344f, 0.49214417f}, new float[]{0.5385842f, 0.6991682f}, new float[]{0.5567602f, 0.68207026f}, new float[]{0.5778061f, 0.67467654f}, new float[]{0.59470665f, 0.6802218f}, new float[]{0.61065054f, 0.6742144f}, new float[]{0.6345663f, 0.681146f}, new float[]{0.65720665f, 0.6968577f}, new float[]{0.6377551f, 0.73937154f}, new float[]{0.61383927f, 0.7569316f}, new float[]{0.59598213f, 0.7592421f}, new float[]{0.5784439f, 0.7569316f}, new float[]{0.5567602f, 0.73983365f}, new float[]{0.54846936f, 0.70194083f}, new float[]{0.578125f, 0.694085f}, new float[]{0.59502554f, 0.6963956f}, new float[]{0.61160713f, 0.6945471f}, new float[]{0.6470026f, 0.70009243f}, new float[]{0.6122449f, 0.72643256f}, new float[]{0.59502554f, 0.7292052f}, new float[]{0.5784439f, 0.72643256f}};
        faceItem.boundaries = new float[]{0.41390306f, 0.3133087f, 0.35586736f, 0.51571167f};
        ArrayList arrayList2 = arrayList;
        arrayList2.add(faceItem);
        FaceItem faceItem2 = new FaceItem();
        faceItem2.markers = new float[][]{new float[]{0.16007653f, 0.6012015f}, new float[]{0.16677296f, 0.6603512f}, new float[]{0.17506377f, 0.71626616f}, new float[]{0.18622449f, 0.7703327f}, new float[]{0.20535715f, 0.81654346f}, new float[]{0.23405612f, 0.8521257f}, new float[]{0.2688138f, 0.87939f}, new float[]{0.3067602f, 0.8983364f}, new float[]{0.3421556f, 0.90110904f}, new float[]{0.3721301f, 0.8886322f}, new float[]{0.39445153f, 0.8539741f}, new float[]{0.41358417f, 0.8137708f}, new float[]{0.4276148f, 0.76756006f}, new float[]{0.43686223f, 0.7185767f}, new float[]{0.44228315f, 0.66774493f}, new float[]{0.44579083f, 0.61737525f}, new float[]{0.44387755f, 0.56654346f}, new float[]{0.20376275f, 0.5272643f}, new float[]{0.2244898f, 0.5064695f}, new float[]{0.2484056f, 0.4944547f}, new float[]{0.2755102f, 0.4930684f}, new float[]{0.30038264f, 0.5046211f}, new float[]{0.36033162f, 0.504159f}, new float[]{0.3791454f, 0.48983365f}, new float[]{0.40019134f, 0.48798522f}, new float[]{0.41996172f, 0.49491683f}, new float[]{0.4343112f, 0.5124769f}, new float[]{0.33545917f, 0.55221814f}, new float[]{0.34024236f, 0.58687615f}, new float[]{0.34598213f, 0.6229205f}, new float[]{0.35140306f, 0.6589649f}, new float[]{0.31855866f, 0.6866913f}, new float[]{0.3322704f, 0.6922366f}, new float[]{0.34598213f, 0.69778186f}, new float[]{0.3565051f, 0.6917745f}, new float[]{0.36575255f, 0.6829944f}, new float[]{0.23660715f, 0.564695f}, new float[]{0.2528699f, 0.5457486f}, new float[]{0.27295917f, 0.5457486f}, new float[]{0.28922194f, 0.56561923f}, new float[]{0.27168366f, 0.5716266f}, new float[]{0.2528699f, 0.5720887f}, new float[]{0.3622449f, 0.56146026f}, new float[]{0.37850764f, 0.5397412f}, new float[]{0.39795917f, 0.5383549f}, new float[]{0.41167092f, 0.5554529f}, new float[]{0.39923468f, 0.56561923f}, new float[]{0.38042092f, 0.56608135f}, new float[]{0.27519134f, 0.7592421f}, new float[]{0.30165815f, 0.7389094f}, new float[]{0.32748723f, 0.7292052f}, new float[]{0.34406888f, 0.73243994f}, new float[]{0.35841838f, 0.7268946f}, new float[]{0.37436223f, 0.7319778f}, new float[]{0.38679847f, 0.7504621f}, new float[]{0.37531888f, 0.7823475f}, new float[]{0.35969388f, 0.7966728f}, new float[]{0.34375f, 0.79990757f}, new float[]{0.32716838f, 0.79944545f}, new float[]{0.30165815f, 0.79020333f}, new float[]{0.2844388f, 0.75970423f}, new float[]{0.32780612f, 0.74676526f}, new float[]{0.34406888f, 0.7472274f}, new float[]{0.35841838f, 0.7453789f}, new float[]{0.3778699f, 0.7527726f}, new float[]{0.3577806f, 0.7712569f}, new float[]{0.34311223f, 0.7754159f}, new float[]{0.3268495f, 0.7763401f}};
        faceItem2.boundaries = new float[]{0.16581632f, 0.42791128f, 0.31887755f, 0.4621072f};
        ArrayList arrayList3 = arrayList2;
        arrayList3.add(faceItem2);
        f66a.put("sample_faces.jpg", arrayList3);
    }

    public static f a(Resources resources, Context context, int i, Bitmap bitmap, float f) {
        f fVar;
        f[] fVarArr = context.faceMasks;
        if (fVarArr[i] == null) {
            int[] iArr = new int[1];
            int length = iArr.length;
            d dVar = context.imageTexture;
            s.a(length, iArr, 0, 6408, dVar.f12b, dVar.c);
            int i2 = iArr[0];
            d dVar2 = context.imageTexture;
            fVar = f.a(s.b(i2, 6408, dVar2.f12b, dVar2.c));
            context.faceMasks[i] = fVar;
        } else {
            fVar = fVarArr[i];
        }
        s.b((d) fVar, bitmap.getWidth(), bitmap.getHeight());
        GLES20.glBindTexture(3553, fVar.f11a);
        GLUtils.texImage2D(3553, 0, 6408, bitmap, 0);
        a(resources, context, (d) fVar, f);
        return fVar;
    }

    public static b a(float[][] fArr, boolean z, float[] fArr2) {
        if (fArr2 == null) {
            fArr2 = new float[]{1.0f, 1.0f};
        }
        if (z) {
            float[][] fArr3 = new float[fArr.length][];
            for (int i = 0; i < fArr.length; i++) {
                fArr3[i] = new float[]{(fArr[i][0] * 2.0f) - 1.0f, (fArr[i][1] * 2.0f) - 1.0f};
            }
            fArr = fArr3;
        }
        b bVar = new b();
        bVar.f69a = (float[][]) Arrays.copyOfRange(fArr, 0, 17);
        float[][] fArr4 = (float[][]) Arrays.copyOfRange(fArr, 17, 22);
        float[][] fArr5 = (float[][]) Arrays.copyOfRange(fArr, 22, 27);
        bVar.f70b = (float[][]) Arrays.copyOfRange(fArr, 27, 31);
        bVar.c = (float[][]) Arrays.copyOfRange(fArr, 31, 36);
        bVar.d = (float[][]) Arrays.copyOfRange(fArr, 36, 42);
        bVar.e = (float[][]) Arrays.copyOfRange(fArr, 42, 48);
        bVar.f = (float[][]) Arrays.copyOfRange(fArr, 48, 55);
        bVar.g = (float[][]) Arrays.copyOfRange(fArr, 60, 66);
        bVar.h = (float[][]) Arrays.copyOfRange(fArr, 54, 61);
        bVar.i = (float[][]) Arrays.copyOfRange(fArr, 65, 68);
        float[][] fArr6 = bVar.c;
        bVar.l = new float[(fArr6.length + 1)][];
        System.arraycopy(fArr6, 0, bVar.l, 0, fArr6.length);
        System.arraycopy(bVar.f70b, 0, bVar.l, bVar.c.length, 1);
        float[][] fArr7 = bVar.g;
        bVar.k = new float[(fArr7.length + bVar.i.length)][];
        System.arraycopy(fArr7, 0, bVar.k, 0, fArr7.length);
        float[][] fArr8 = bVar.i;
        System.arraycopy(fArr8, 0, bVar.k, bVar.g.length, fArr8.length);
        float[][] fArr9 = bVar.f;
        bVar.j = new float[(fArr9.length + bVar.h.length)][];
        System.arraycopy(fArr9, 0, bVar.j, 0, fArr9.length);
        float[][] fArr10 = bVar.h;
        System.arraycopy(fArr10, 0, bVar.j, bVar.f.length, fArr10.length);
        bVar.m = bVar.j;
        float[][] fArr11 = bVar.f70b;
        double d = (double) ((float) (-Math.atan2((double) (fArr11[0][0] - fArr11[3][0]), (double) (fArr11[0][1] - fArr11[3][1]))));
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        bVar.n = new float[]{cos, sin};
        float[][] fArr12 = bVar.f69a;
        float[] a2 = a(fArr12[0], fArr12[16]);
        bVar.t = a(a.a(bVar.d), sin, cos);
        bVar.s = a(a.a(bVar.e), sin, cos);
        float[][] fArr13 = bVar.k;
        bVar.r = a(a(fArr13[2], fArr13[6]), sin, cos);
        bVar.q = a(a2, sin, cos);
        bVar.p = a(bVar.f70b[0], sin, cos);
        bVar.o = new float[][]{a(bVar.f[0], sin, cos), a(bVar.f[6], sin, cos)};
        float[][] fArr14 = new float[5][];
        float[] fArr15 = {0.0f, 0.0f};
        float f = z ? 30.0f : -30.0f;
        a.d(fArr15, a2, fArr2);
        for (int i2 = 1; i2 < 6; i2++) {
            float[] fArr16 = {0.0f, 0.0f};
            a.d(fArr16, bVar.f69a[16], fArr2);
            a.e(fArr16, fArr16, fArr15);
            float[] a3 = a.a(fArr16, ((float) i2) * f);
            a.b(a3, a3, fArr15);
            a.c(a3, a3, fArr2);
            fArr14[i2 - 1] = a3;
        }
        float[][] fArr17 = bVar.f69a;
        bVar.u = new float[(fArr17.length + fArr14.length)][];
        System.arraycopy(fArr17, 0, bVar.u, 0, fArr17.length);
        System.arraycopy(fArr14, 0, bVar.u, bVar.f69a.length, fArr14.length);
        bVar.v = new float[(fArr14.length + 2)][];
        System.arraycopy(bVar.f69a, 16, bVar.v, 0, 1);
        System.arraycopy(fArr14, 0, bVar.v, 1, fArr14.length);
        System.arraycopy(bVar.f69a, 0, bVar.v, fArr14.length + 1, 1);
        return bVar;
    }

    public static List<a> a(List<FaceItem> list, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        for (FaceItem next : list) {
            a aVar = new a();
            float[][] fArr = next.markers;
            if (fArr != null) {
                float[][] fArr2 = new float[fArr.length][];
                for (int i3 = 0; i3 < fArr2.length; i3++) {
                    float[][] fArr3 = next.markers;
                    fArr2[i3] = new float[]{fArr3[i3][0] * ((float) i), fArr3[i3][1] * ((float) i2)};
                }
                aVar.f67a = a(fArr2, false, new float[]{1.0f, 1.0f});
            }
            float[] fArr4 = next.boundaries;
            if (fArr4 != null) {
                float f = (float) i;
                float f2 = (float) i2;
                aVar.f68b = new float[]{fArr4[0] * f, fArr4[1] * f2, fArr4[2] * f, fArr4[3] * f2};
            }
            arrayList.add(aVar);
        }
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(float r18, float r19, java.util.List<co.polarr.renderer.entities.FaceItem> r20, android.content.res.Resources r21, co.polarr.renderer.entities.Context r22) {
        /*
            r0 = r20
            r1 = r22
            r2 = 1140850688(0x44000000, float:512.0)
            float r3 = r2 / r18
            float r2 = r2 / r19
            float r2 = java.lang.Math.max(r3, r2)
            float r3 = r18 * r2
            int r3 = (int) r3
            r4 = 0
            int r3 = r3 >> r4
            float r2 = r2 * r19
            int r2 = (int) r2
            int r2 = r2 >> r4
            java.util.List r5 = a((java.util.List<co.polarr.renderer.entities.FaceItem>) r0, (int) r3, (int) r2)
            a.a.b.b.f[] r6 = r1.faceMasks
            if (r6 != 0) goto L_0x0028
            int r6 = r20.size()
            a.a.b.b.f[] r6 = new a.a.b.b.f[r6]
        L_0x0025:
            r1.faceMasks = r6
            goto L_0x003c
        L_0x0028:
            int r6 = r6.length
            int r7 = r20.size()
            if (r6 >= r7) goto L_0x003c
            int r6 = r20.size()
            a.a.b.b.f[] r6 = new a.a.b.b.f[r6]
            a.a.b.b.f[] r7 = r1.faceMasks
            int r8 = r7.length
            java.lang.System.arraycopy(r7, r4, r6, r4, r8)
            goto L_0x0025
        L_0x003c:
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createBitmap(r3, r2, r6)
            android.graphics.Canvas r7 = new android.graphics.Canvas
            r7.<init>(r6)
            r8 = r4
        L_0x0048:
            int r9 = r5.size()
            if (r8 >= r9) goto L_0x01da
            java.lang.Object r9 = r5.get(r8)
            a.a.b.e.k$a r9 = (a.a.b.e.k.a) r9
            r10 = 2
            float[] r11 = new float[r10]
            java.lang.Object r12 = r0.get(r8)
            co.polarr.renderer.entities.FaceItem r12 = (co.polarr.renderer.entities.FaceItem) r12
            float[] r12 = r12.boundaries
            r12 = r12[r10]
            r11[r4] = r12
            java.lang.Object r12 = r0.get(r8)
            co.polarr.renderer.entities.FaceItem r12 = (co.polarr.renderer.entities.FaceItem) r12
            float[] r12 = r12.boundaries
            r13 = 3
            r12 = r12[r13]
            r13 = 1
            r11[r13] = r12
            float r11 = a.a.b.e.a.b((float[]) r11)
            android.graphics.Paint r12 = new android.graphics.Paint
            r12.<init>(r13)
            r14 = 255(0xff, float:3.57E-43)
            int r14 = android.graphics.Color.argb(r4, r14, r14, r14)
            r7.drawColor(r14)
            a.a.b.e.k$b r14 = r9.f67a
            r15 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            if (r14 == 0) goto L_0x00b3
            float[][] r14 = r14.u
            a((android.graphics.Canvas) r7, (android.graphics.Paint) r12, (float[][]) r14, (int) r15, (boolean) r4)
            a.a.b.e.k$b r14 = r9.f67a
            float[][] r14 = r14.j
            r15 = -65536(0xffffffffffff0000, float:NaN)
            a((android.graphics.Canvas) r7, (android.graphics.Paint) r12, (float[][]) r14, (int) r15, (boolean) r4)
            a.a.b.e.k$b r14 = r9.f67a
            float[][] r14 = r14.k
            r15 = -16711936(0xffffffffff00ff00, float:-1.7146522E38)
            a((android.graphics.Canvas) r7, (android.graphics.Paint) r12, (float[][]) r14, (int) r15, (boolean) r4)
            a.a.b.e.k$b r14 = r9.f67a
            float[][] r14 = r14.d
            r15 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            a((android.graphics.Canvas) r7, (android.graphics.Paint) r12, (float[][]) r14, (int) r15, (boolean) r4)
            a.a.b.e.k$b r14 = r9.f67a
            float[][] r14 = r14.e
            a((android.graphics.Canvas) r7, (android.graphics.Paint) r12, (float[][]) r14, (int) r15, (boolean) r4)
            goto L_0x00ba
        L_0x00b3:
            float[] r14 = r9.f68b
            if (r14 == 0) goto L_0x00ba
            a((android.graphics.Canvas) r7, (android.graphics.Paint) r12, (float[]) r14, (int) r15)
        L_0x00ba:
            a.a.b.b.f[] r12 = r1.faceMasks
            r12 = r12[r8]
            if (r12 != 0) goto L_0x00c6
            a.a.b.e.k$b r9 = r9.f67a
            if (r9 == 0) goto L_0x00c6
            r9 = r13
            goto L_0x00c7
        L_0x00c6:
            r9 = r4
        L_0x00c7:
            r12 = 1028443341(0x3d4ccccd, float:0.05)
            float r12 = r12 * r11
            r14 = r21
            a.a.b.b.f r12 = a((android.content.res.Resources) r14, (co.polarr.renderer.entities.Context) r1, (int) r8, (android.graphics.Bitmap) r6, (float) r12)
            if (r9 == 0) goto L_0x01ce
            float[][] r9 = r1.distortionVertices
            int r15 = r9.length
            a.a.b.b.f$a r13 = new a.a.b.b.f$a
            r13.<init>()
            int[] r4 = new int[r15]
            r13.f13a = r4
            int[] r4 = new int[r15]
            r13.f14b = r4
            int[] r4 = new int[r15]
            r13.c = r4
            int[] r4 = new int[r15]
            r13.d = r4
            int[] r4 = new int[r15]
            r13.e = r4
            int[] r4 = new int[r15]
            r13.f = r4
            java.lang.Object r4 = r0.get(r8)
            co.polarr.renderer.entities.FaceItem r4 = (co.polarr.renderer.entities.FaceItem) r4
            float[][] r4 = r4.markers
            float[] r10 = new float[r10]
            r0 = 1065353216(0x3f800000, float:1.0)
            r16 = 0
            r10[r16] = r0
            float r0 = (float) r2
            float r1 = (float) r3
            float r0 = r0 / r1
            r1 = 1
            r10[r1] = r0
            a.a.b.e.k$b r0 = a((float[][]) r4, (boolean) r1, (float[]) r10)
            r1 = 1050253722(0x3e99999a, float:0.3)
            float r11 = r11 * r1
            r1 = r16
        L_0x0113:
            if (r1 >= r15) goto L_0x01c9
            r4 = r9[r1]
            float[][] r10 = r0.d
            float r4 = a.a.b.e.a.a((float[]) r4, (float[][]) r10)
            int r10 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            r17 = 1132396544(0x437f0000, float:255.0)
            if (r10 > 0) goto L_0x0134
            float r4 = r4 / r11
            r10 = 1065353216(0x3f800000, float:1.0)
            float r4 = java.lang.Math.min(r10, r4)
            float r4 = r10 - r4
            int[] r10 = r13.f13a
            float r4 = r4 * r4
            float r4 = r4 * r17
            int r4 = (int) r4
            r10[r1] = r4
        L_0x0134:
            r4 = r9[r1]
            float[][] r10 = r0.e
            float r4 = a.a.b.e.a.a((float[]) r4, (float[][]) r10)
            int r10 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r10 > 0) goto L_0x0151
            float r4 = r4 / r11
            r10 = 1065353216(0x3f800000, float:1.0)
            float r4 = java.lang.Math.min(r10, r4)
            float r4 = r10 - r4
            int[] r10 = r13.f14b
            float r4 = r4 * r4
            float r4 = r4 * r17
            int r4 = (int) r4
            r10[r1] = r4
        L_0x0151:
            r4 = r9[r1]
            float[][] r10 = r0.v
            float r4 = a.a.b.e.a.a((float[]) r4, (float[][]) r10)
            int r10 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r10 > 0) goto L_0x016e
            float r4 = r4 / r11
            r10 = 1065353216(0x3f800000, float:1.0)
            float r4 = java.lang.Math.min(r10, r4)
            float r4 = r10 - r4
            int[] r10 = r13.c
            float r4 = r4 * r4
            float r4 = r4 * r17
            int r4 = (int) r4
            r10[r1] = r4
        L_0x016e:
            r4 = r9[r1]
            float[][] r10 = r0.f69a
            float r4 = a.a.b.e.a.a((float[]) r4, (float[][]) r10)
            int r10 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r10 > 0) goto L_0x018b
            float r4 = r4 / r11
            r10 = 1065353216(0x3f800000, float:1.0)
            float r4 = java.lang.Math.min(r10, r4)
            float r4 = r10 - r4
            int[] r10 = r13.d
            float r4 = r4 * r4
            float r4 = r4 * r17
            int r4 = (int) r4
            r10[r1] = r4
        L_0x018b:
            r4 = r9[r1]
            float[][] r10 = r0.l
            float r4 = a.a.b.e.a.a((float[]) r4, (float[][]) r10)
            int r10 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r10 > 0) goto L_0x01a8
            float r4 = r4 / r11
            r10 = 1065353216(0x3f800000, float:1.0)
            float r4 = java.lang.Math.min(r10, r4)
            float r4 = r10 - r4
            int[] r10 = r13.e
            float r4 = r4 * r4
            float r4 = r4 * r17
            int r4 = (int) r4
            r10[r1] = r4
        L_0x01a8:
            r4 = r9[r1]
            float[][] r10 = r0.m
            float r4 = a.a.b.e.a.a((float[]) r4, (float[][]) r10)
            int r10 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r10 > 0) goto L_0x01c5
            float r4 = r4 / r11
            r10 = 1065353216(0x3f800000, float:1.0)
            float r4 = java.lang.Math.min(r10, r4)
            float r4 = r10 - r4
            int[] r10 = r13.f
            float r4 = r4 * r4
            float r4 = r4 * r17
            int r4 = (int) r4
            r10[r1] = r4
        L_0x01c5:
            int r1 = r1 + 1
            goto L_0x0113
        L_0x01c9:
            r12.e = r13
            r12.f = r0
            goto L_0x01d0
        L_0x01ce:
            r16 = r4
        L_0x01d0:
            int r8 = r8 + 1
            r0 = r20
            r1 = r22
            r4 = r16
            goto L_0x0048
        L_0x01da:
            r6.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.b.e.k.a(float, float, java.util.List, android.content.res.Resources, co.polarr.renderer.entities.Context):void");
    }

    public static void a(Resources resources, Context context, d dVar, float f) {
        if (f < 0.0f) {
            f = 0.024f;
        }
        int i = dVar.f12b;
        int i2 = dVar.c;
        d dVar2 = context.writableTexture;
        int i3 = dVar2.f12b;
        int i4 = dVar2.c;
        s.b(dVar2, i, i2);
        t a2 = t.a(resources, context);
        a2.r = new float[]{0.0f, (((float) i) / ((float) i2)) * f};
        g.a(context, dVar.f11a, context.writableTexture, (a.a.b.a.a.a) a2, false);
        a2.r = new float[]{f, 0.0f};
        g.a(context, context.writableTexture.f11a, dVar, (a.a.b.a.a.a) a2, false);
        s.b(context.writableTexture, i3, i4);
    }

    public static void a(Canvas canvas, Paint paint, float[] fArr, int i) {
        paint.setColor(i);
        float f = fArr[0];
        float f2 = fArr[1];
        canvas.drawOval(new RectF(f, f2, fArr[2] + f, fArr[3] + f2), paint);
    }

    public static void a(Canvas canvas, Paint paint, float[][] fArr, int i, boolean z) {
        paint.setColor(i);
        float[] fArr2 = fArr[fArr.length - 1];
        Path path = new Path();
        path.moveTo(fArr2[0], fArr2[1]);
        for (int i2 = 0; i2 < fArr.length; i2++) {
            float[] fArr3 = fArr[i2];
            if (fArr3 != null) {
                if (i2 < fArr.length - 1) {
                    int i3 = i2 + 1;
                    path.quadTo(fArr3[0], fArr3[1], fArr[i3][0], fArr[i3][1]);
                } else {
                    path.lineTo(fArr3[0], fArr3[1]);
                }
            }
        }
        canvas.drawPath(path, paint);
        if (z) {
            float[] fArr4 = fArr[0];
            float[] fArr5 = {a.a(0.5f, fArr4[0], fArr2[0]), a.a(0.5f, fArr4[1], fArr2[1])};
            canvas.save();
            canvas.translate(fArr5[0], fArr5[1]);
            canvas.rotate(3.1415927f);
            canvas.translate(-fArr5[0], -fArr5[1]);
            path.reset();
            path.moveTo(fArr2[0], fArr2[1]);
            for (int i4 = 0; i4 < fArr.length; i4++) {
                float[] fArr6 = fArr[i4];
                if (fArr6 != null) {
                    if (i4 < fArr.length - 1) {
                        int i5 = i4 + 1;
                        path.quadTo(fArr6[0], fArr6[1], fArr[i5][0], fArr[i5][1]);
                    } else {
                        path.lineTo(fArr6[0], fArr6[1]);
                    }
                }
            }
            canvas.drawPath(path, paint);
            canvas.restore();
        }
    }

    public static void a(List<FaceItem> list, Resources resources, Context context) {
        List<FaceItem> list2 = (List) context.renderStates.get("prevFaces");
        if (list == null || list.isEmpty() || a.a((Object) list2, (Object) list)) {
            list = list2;
        } else {
            d dVar = context.imageTexture;
            a((float) dVar.f12b, (float) dVar.c, list, resources, context);
        }
        context.renderStates.put("prevFaces", list);
    }

    public static float[] a(float[] fArr, float f, float f2) {
        float f3 = -f;
        return new float[]{(fArr[0] * f2) - (fArr[1] * f3), (fArr[0] * f3) + (fArr[1] * f2)};
    }

    public static float[] a(float[] fArr, float[] fArr2) {
        return new float[]{(fArr[0] * 0.5f) + (fArr2[0] * 0.5f), (fArr[1] * 0.5f) + (fArr2[1] * 0.5f)};
    }
}
