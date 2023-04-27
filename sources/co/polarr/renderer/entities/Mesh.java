package co.polarr.renderer.entities;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.List;

public class Mesh {
    public float[] coords;
    public float[] delta;
    public float[] distortion;
    public float[] lines;
    public FloatBuffer mDeltaBuffer;
    public FloatBuffer mDistortionBuffer;
    public FloatBuffer mTexBuffer;
    public FloatBuffer mVerBuffer;
    public ShortBuffer trianglesBuffer;
    public float[] vertices;

    public static class Options {
        public boolean coords = true;
        public boolean delta = true;
        public int detail = 1;
        public int detailX = 1;
        public int detailY = 1;
        public boolean distortion = true;
        public boolean lines;
        public boolean triangles;

        public Options(int i) {
            this.detailY = i;
            this.detailX = i;
            this.detail = i;
        }

        public Options(boolean z, boolean z2, boolean z3, int i) {
            this.coords = z;
            this.distortion = z2;
            this.delta = z3;
            this.detailY = i;
            this.detailX = i;
            this.detail = i;
        }
    }

    public static float[] getJoinedArray(float[][] fArr) {
        float[] fArr2 = new float[(fArr.length * 2)];
        for (int i = 0; i < fArr.length; i++) {
            int i2 = i * 2;
            fArr2[i2] = fArr[i][0];
            fArr2[i2 + 1] = fArr[i][1];
        }
        return fArr2;
    }

    public static float[][] getPointsArray(float[] fArr) {
        float[][] fArr2 = new float[(fArr.length / 2)][];
        for (int i = 0; i < fArr.length; i += 2) {
            fArr2[i / 2] = new float[]{fArr[i], fArr[i + 1]};
        }
        return fArr2;
    }

    public static Mesh plane(Options options) {
        Options options2 = options;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList<Short> arrayList5 = new ArrayList<>();
        new ArrayList();
        Mesh mesh = new Mesh();
        int i = options2.detailX;
        int i2 = options2.detailY;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            char c = 2;
            if (i4 > i2) {
                break;
            }
            float f = ((float) i4) / ((float) i2);
            int i5 = i3;
            while (i5 <= i) {
                float f2 = ((float) i5) / ((float) i);
                float[] fArr = new float[3];
                fArr[i3] = (f2 * 2.0f) - 1.0f;
                fArr[1] = (2.0f * f) - 1.0f;
                fArr[c] = 0.0f;
                arrayList.add(Float.valueOf(fArr[i3]));
                arrayList.add(Float.valueOf(fArr[1]));
                arrayList.add(Float.valueOf(0.0f));
                if (options2.distortion) {
                    arrayList3.add(Float.valueOf(fArr[i3]));
                    arrayList3.add(Float.valueOf(fArr[1]));
                }
                if (options2.coords) {
                    arrayList2.add(Float.valueOf(f2));
                    arrayList2.add(Float.valueOf(f));
                }
                if (options2.delta) {
                    arrayList4.add(Float.valueOf(0.0f));
                    arrayList4.add(Float.valueOf(0.0f));
                }
                if (i5 < i && i4 < i2) {
                    int i6 = ((i + 1) * i4) + i5;
                    arrayList5.add(Short.valueOf((short) i6));
                    short s = (short) (i6 + 1);
                    arrayList5.add(Short.valueOf(s));
                    int i7 = i6 + i;
                    short s2 = (short) (i7 + 1);
                    arrayList5.add(Short.valueOf(s2));
                    arrayList5.add(Short.valueOf(s2));
                    arrayList5.add(Short.valueOf(s));
                    arrayList5.add(Short.valueOf((short) (i7 + 2)));
                }
                i5++;
                i3 = 0;
                c = 2;
            }
            i4++;
            i3 = 0;
        }
        mesh.vertices = toFloatArray(arrayList);
        mesh.distortion = toFloatArray(arrayList3);
        mesh.coords = toFloatArray(arrayList2);
        mesh.delta = toFloatArray(arrayList4);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(arrayList5.size() * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        mesh.trianglesBuffer = allocateDirect.asShortBuffer();
        for (Short shortValue : arrayList5) {
            mesh.trianglesBuffer.put(shortValue.shortValue());
        }
        mesh.trianglesBuffer.position(0);
        mesh.compile();
        return mesh;
    }

    public static float[] toFloatArray(List<Float> list) {
        float[] fArr = new float[list.size()];
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = list.get(i).floatValue();
        }
        return fArr;
    }

    public void compile() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.vertices.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.mVerBuffer = allocateDirect.asFloatBuffer();
        this.mVerBuffer.put(this.vertices);
        this.mVerBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.coords.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.mTexBuffer = allocateDirect2.asFloatBuffer();
        this.mTexBuffer.put(this.coords);
        this.mTexBuffer.position(0);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(this.distortion.length * 4);
        allocateDirect3.order(ByteOrder.nativeOrder());
        this.mDistortionBuffer = allocateDirect3.asFloatBuffer();
        this.mDistortionBuffer.put(this.distortion);
        this.mDistortionBuffer.position(0);
        ByteBuffer allocateDirect4 = ByteBuffer.allocateDirect(this.delta.length * 4);
        allocateDirect4.order(ByteOrder.nativeOrder());
        this.mDeltaBuffer = allocateDirect4.asFloatBuffer();
        this.mDeltaBuffer.put(this.delta);
        this.mDeltaBuffer.position(0);
    }

    public float[][] getDeltaPoints() {
        return getPointsArray(this.delta);
    }

    public float[][] getDistortionPoints() {
        return getPointsArray(this.distortion);
    }

    public void setDeltaPoints(float[][] fArr) {
        this.delta = getJoinedArray(fArr);
    }

    public void setDistortionPoints(float[][] fArr) {
        this.distortion = getJoinedArray(fArr);
    }
}
