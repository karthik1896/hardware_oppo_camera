package co.polarr.renderer;

import a.a.b.a;
import a.a.b.a.ak;
import a.a.b.d;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import co.polarr.renderer.entities.BrushItem;
import co.polarr.renderer.entities.DrawingItem;
import co.polarr.renderer.entities.FaceItem;
import co.polarr.renderer.entities.LutItem;
import co.polarr.renderer.entities.MagicEraserPath;
import java.util.List;
import java.util.Map;

public class PolarrRender {
    public static final int EXTERNAL_OES = 1;
    public static final int TEXTURE_2D = 0;
    public d instance = new d();

    public static void SetStaticResPath(String str) {
        ak.b(str);
    }

    public static String Version() {
        return "1.6.13_oppo_camera";
    }

    public static void clearTextureHelper(int i, int i2, int i3) {
        a.a(i, i2, i3);
    }

    public static void enableLogger(boolean z) {
        a.a(z);
    }

    @Deprecated
    public static Map<String, Object> getRenderStatesFromJson(String str) {
        return a.b(str);
    }

    public static void magicEraserOneTime(Resources resources, int i, int i2, int i3, MagicEraserPath magicEraserPath) {
        magicEraserOneTime(resources, i, i2, i3, magicEraserPath, 0.0f, 0.0f, 1.0f);
    }

    public static void magicEraserOneTime(Resources resources, int i, int i2, int i3, MagicEraserPath magicEraserPath, float f, float f2, float f3) {
        if (f3 != 1.0f) {
            magicEraserPath = magicEraserPath.copy();
            magicEraserPath.points = d.a(magicEraserPath.points, f, f2, f3);
            magicEraserPath.radius /= f3;
        }
        a.a(resources, i, i2, i3, magicEraserPath, 0);
    }

    public static void magicEraserOneTimeCompatible(Resources resources, int i, int i2, int i3, MagicEraserPath magicEraserPath, int i4) {
        a.a(resources, i, i2, i3, magicEraserPath, i4);
    }

    public static List<Bitmap> renderBitmaps(Resources resources, Bitmap bitmap, List<String> list) {
        return a.a(resources, bitmap, list);
    }

    public static List<Bitmap> renderBitmaps(Resources resources, Bitmap bitmap, List<String> list, float f) {
        return a.a(resources, bitmap, list, f, 0.0f);
    }

    public static List<Bitmap> renderBitmaps(Resources resources, Bitmap bitmap, List<String> list, float f, float f2) {
        return a.a(resources, bitmap, list, f, f2);
    }

    public static byte[] renderNV12(Context context, byte[] bArr, int i, int i2, String str, float f, boolean z) {
        return a.b(context, bArr, i, i2, str, f, z);
    }

    public static byte[] renderNV21(Context context, byte[] bArr, int i, int i2, String str, float f, boolean z) {
        a.a(context, bArr, i, i2, str, f, z);
        throw null;
    }

    public static void setupVignetteParams(float f, float f2, float f3, float f4, float f5, float f6) {
        a.a(f, f2, f3, f4, f5, f6);
    }

    public static void updateGlobalScreenOrientation(int i) {
        synchronized (PolarrRender.class) {
            try {
                a.a(i);
            } catch (Throwable th) {
                Class<PolarrRender> cls = PolarrRender.class;
                throw th;
            }
        }
    }

    public void addBrushPathPoint(BrushItem brushItem, PointF pointF) {
        this.instance.a(brushItem, pointF);
    }

    @Deprecated
    public void autoEnhanceFace(Map<String, Object> map, int i, float f, boolean z) {
        this.instance.a(map, i, f, z);
    }

    public Map<String, Object> autoEnhanceGlobal(float f) {
        return this.instance.a(f, (Map<String, Object>) null);
    }

    public Map<String, Object> autoEnhanceGlobal(float f, Map<String, Object> map) {
        return this.instance.a(f, map);
    }

    @Deprecated
    public Map<String, Object> autoEnhanceGlobalForFace(float f) {
        return this.instance.a(f);
    }

    public int brushPaintAdd(List<PointF> list) {
        return this.instance.a(list);
    }

    public void brushPaintFinish() {
        this.instance.a();
    }

    public void brushStart(BrushItem brushItem) {
        this.instance.a(brushItem);
    }

    public void clearTexture(int i, int i2, int i3) {
        this.instance.a(i, i2, i3);
    }

    public void clearThumbCache() {
        this.instance.b();
    }

    public void combine(int i, int i2) {
        this.instance.a(i, i2);
    }

    public void createInputTexture() {
        this.instance.c();
    }

    public void drawFiltersFrame(List<DrawingItem> list, int i) {
        this.instance.a(list, i);
    }

    public void drawFiltersFrame(List<DrawingItem> list, int i, boolean z, float f, float f2, float f3) {
        this.instance.a(list, i, z, f, f2, f3);
    }

    public void drawFrame() {
        this.instance.e();
    }

    public void drawFrameWithVignette() {
        this.instance.f();
    }

    public void enableDemoire(boolean z) {
        this.instance.b(z);
    }

    public void enableRealTimeAutoEnhancement(boolean z) {
        this.instance.c(z);
    }

    @Deprecated
    public void fastAutoEnhancement(boolean z) {
        this.instance.d(z);
    }

    public Bitmap fastRenderBitmap(Bitmap bitmap, String str) {
        return this.instance.a(bitmap, str);
    }

    public Bitmap fastRenderBitmap(Bitmap bitmap, String str, float f) {
        return this.instance.a(bitmap, str, f);
    }

    public void fastUpdateFilter(String str) {
        this.instance.a(str);
    }

    public void fastUpdateFilter(String str, float f) {
        this.instance.b(str, f);
    }

    public void fastUpdateLutsFilter(List<LutItem> list) {
        this.instance.b(list);
    }

    public void fastUseCombineLut() {
        this.instance.i();
    }

    public int getBrushLastPaint() {
        return this.instance.j();
    }

    public ak getLookup2DFilter() {
        return this.instance.k();
    }

    public int getOutputId() {
        return this.instance.l();
    }

    public int getTextureId() {
        return this.instance.m();
    }

    @Deprecated
    public void initAllFilters() {
        this.instance.n();
    }

    public void initRender(Resources resources, int i, int i2, boolean z) {
        this.instance.a(resources, i, i2, z);
    }

    public void initRender(Resources resources, int i, int i2, boolean z, int i3) {
        this.instance.a(resources, i, i2, z, i3);
    }

    @Deprecated
    public boolean isUseVignette() {
        return false;
    }

    public void magicEraserPathOverLay(MagicEraserPath magicEraserPath, int i, int i2, int i3) {
        this.instance.a(magicEraserPath, i, i2, i3);
    }

    public void release() {
        this.instance.o();
    }

    public void releaseGLRes() {
        this.instance.r();
    }

    public void releaseNonGLRes() {
        this.instance.t();
    }

    public Bitmap renderBitmap(Bitmap bitmap, Map<String, Object> map) {
        return this.instance.a(bitmap, map);
    }

    public void setBrushLastPaintingTex(int i) {
        this.instance.a(i);
    }

    public void setFilterIntensity(float f) {
        this.instance.b(f);
    }

    public void setGrainAmount(float f) {
        this.instance.c(f);
    }

    public void setInputTexture(int i) {
        this.instance.b(i);
    }

    public void setNeedDrawScreen(boolean z) {
        this.instance.f(z);
    }

    public void setOutputTexture(int i) {
        this.instance.c(i);
    }

    @Deprecated
    public void setUseVignette(boolean z) {
    }

    public void updateBrushPoints(BrushItem brushItem) {
        this.instance.b(brushItem);
    }

    @Deprecated
    public void updateFaces(List<FaceItem> list, float f) {
        this.instance.a(list, f);
    }

    public void updateInputTexture() {
        this.instance.w();
    }

    public void updateOffsetScale(float f, float f2, float f3) {
        this.instance.a(f, f2, f3);
    }

    public void updateSize(int i, int i2) {
        this.instance.c(i, i2);
    }

    @Deprecated
    public void updateStates(String str) {
        this.instance.b(str);
    }

    public void updateStates(Map<String, Object> map) {
        this.instance.b(map);
    }
}
