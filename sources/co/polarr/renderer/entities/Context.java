package co.polarr.renderer.entities;

import a.a.b.b.b;
import a.a.b.b.d;
import a.a.b.b.f;
import a.a.b.b.g;
import a.a.b.e.o;
import a.a.b.e.s;
import a.a.b.e.t;
import android.content.res.AssetManager;
import android.content.res.Resources;
import co.polarr.renderer.entities.Mesh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {
    public static final int DESIGN_FOR_SDK_HEIGHT = 800;
    public static final float DESIGN_FOR_SDK_IMAGE = 2073600.0f;
    public static final int DESIGN_FOR_SDK_WIDTH = 800;
    public static Mesh DefaultMesh = null;
    public static final int GRAIN_TEXTURE_SIZE = 1024;
    public static Context LutContext = null;
    public static final int P4_3_OVERLAY_TEXTURE_SIZE = 1000;
    public static float[] backgroundColor = {0.11764706f, 0.11764706f, 0.11764706f};
    public static Mesh overlayMesh;
    public AssetManager assetManager;
    public d[] brushTextures = new d[4];
    public Map<String, d> brushes;
    public d cacheTexture;
    public float[] compositeCoords = {0.0f, 0.0f, 0.0f, 0.0f};
    public float[] compositeResolution = {0.0f, 0.0f};
    public android.content.Context context;
    public float[] cropMatrix = o.a();
    public boolean cropMode = false;
    public float cropScale = 1.0f;
    public g currentRender;
    public d dehazeTexture;
    public float[][] deltaVertices;
    public d denoiseTexture;
    public a.a.b.e.d distortion = new a.a.b.e.d();
    public float[][] distortionVertices;
    public float downsampleFactor = 1.0f;
    public d exportTexture;
    public f[] faceMasks;
    public float fov;
    public b glRenderView;
    public d grainTexture;
    public boolean grainTextureBinded = false;
    public d imageTexture;
    public d intermediateTexture;
    public float invFov;
    public boolean isLutRender = false;
    public boolean isOES = false;
    public boolean isSDK = false;
    public d lensBlurTexture;
    public float margin = 0.0f;
    public float[] margins = {0.0f, 0.0f, 0.0f, 0.0f};
    public float[] matrix = o.a();
    public float[] matrixInv = o.a();
    public int maxTextureSize;
    public Mesh mesh;
    public float minZoom;
    public boolean needUpdateFace = false;
    public float[] offset = {0.0f, 0.0f};
    public int orientation = 0;
    public Overlay overlay = new Overlay();
    public float[] overlayMask = {0.0f, 0.0f, 0.0f, 0.0f};
    public float[] overlayMatrix = o.a();
    public d overlayTexture;
    public boolean overlayTextureBinded = false;
    public d paintTexture;
    public Map<String, d> patterns;
    public float[] perspectiveMatrix = o.a();
    public boolean photoLoaded = false;
    public float[] projectionMatrix = o.a();
    public float[] projectionMatrixInv = o.a();
    public d readableTexture;
    public Map<String, Object> renderStates = new HashMap();
    public Resources resources;
    public d retouchTexture;
    public float rotation = 0.0f;
    public float[] rotation90Matrix = o.a();
    public float[] rotation90MatrixInv = o.a();
    public float[] rotationMatrix = o.a();
    public float[] scaleMatrix = o.a();
    public Screen screen = new Screen();
    public float[] screenMatrix = o.a();
    public d screenTexture;
    public t shaderUtil;
    public float[] skinColor = {0.0f, 0.0f, 0.0f};
    public d tempTexture;
    public List<d> textLayers = new ArrayList();
    public int[] textures = new int[0];
    public float[] thresholdAverage = {1.0f, 1.0f, 1.0f};
    public float[] tmpMatrix = o.a();
    public float[] translationMatrix = o.a();
    public float[] viewMatrix = o.a();
    public WatermarkOptions watermarkOptions = new WatermarkOptions();
    public d watermarkTexture;
    public d writableTexture;
    public float zoom = 1.0f;

    public static class FaceFeaturesState {
        public float chin_height = 0.0f;
        public float[] eye_size = {0.0f, 0.0f};
        public float face_width = 0.0f;
        public float forehead_height = 0.0f;
        public float mouth_height = 0.0f;
        public float mouth_width = 0.0f;
        public float nose_height = 0.0f;
        public float nose_width = 0.0f;
        public float smile = 0.0f;
    }

    public static class FaceState {
        public float eyes_brightness = 0.0f;
        public float eyes_clarity = 0.0f;
        public float eyes_contrast = 0.0f;
        public float lips_brightness = 0.0f;
        public float lips_saturation = 0.0f;
        public float skin_highlights = 0.0f;
        public float skin_hue = 0.0f;
        public float skin_saturation = 0.0f;
        public float skin_shadows = 0.0f;
        public float skin_smoothness = 0.0f;
        public float skin_tone = 0.0f;
        public float teeth_brightness = 0.0f;
        public float teeth_whitening = 0.0f;
    }

    public static class LocalState {
        public float balance = -1.0f;
        public float blur = 0.0f;
        public float clarity = 0.0f;
        public float contrast = 0.0f;
        public float dehaze = 0.0f;
        public float exposure = 0.0f;
        public float gamma = 0.0f;
        public float highlights = 0.0f;
        public String mosaic_pattern;
        public float mosaic_size = 0.0f;
        public float saturation = 0.0f;
        public float shadows = 0.0f;
        public float shadows_hue = 0.0f;
        public float shadows_saturation = 0.0f;
        public float temperature = 0.0f;
        public float tint = 0.0f;
        public float vibrance = 0.0f;
    }

    public static class Overlay {
        public int flipX;
        public int flipY;
        public float height;
        public float imageHeight;
        public float imageWidth;
        public float rotation;
        public float tx;
        public float ty;
        public float width;
    }

    public static class Screen {
        public float[] center = {0.5f, 0.5f};
        public float[] offset = {0.0f, 0.0f};
        public int orientation = 0;
        public float[] rotation = {0.0f, 0.0f, 0.0f};
        public float zoom = 1.0f;
    }

    public static class WatermarkOptions {
        public boolean addMetadata = false;
        public String artist;
        public String copyright;
        public String description;
        public boolean enabled = false;
        public int height;
        public float opacity = 1.0f;
        public float[] position = {0.95f, 0.95f};
        public boolean preview = false;
        public float rotation = 0.0f;
        public float scale = 0.2f;
        public int width;
    }

    public Context() {
        init();
    }

    public Context(boolean z) {
        if (!z) {
            init();
            return;
        }
        a.a.b.f.a(this.renderStates);
        this.mesh = Mesh.plane(new Mesh.Options(1));
    }

    private void init() {
        a.a.b.f.a(this.renderStates);
        this.mesh = Mesh.plane(new Mesh.Options(64));
        if (DefaultMesh == null) {
            DefaultMesh = Mesh.plane(new Mesh.Options(64));
        }
        if (overlayMesh == null) {
            overlayMesh = Mesh.plane(new Mesh.Options(true, false, false, 32));
        }
        if (LutContext == null) {
            LutContext = new Context(true);
            Context context2 = LutContext;
            context2.isLutRender = true;
            context2.imageTexture = s.b(0, 6408, 32, 32);
        }
        this.distortionVertices = this.mesh.getDistortionPoints();
        this.deltaVertices = this.mesh.getDeltaPoints();
    }

    public static Map<String, Object> makeCompatible(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        a.a.b.f.a(hashMap);
        HashMap hashMap2 = new HashMap();
        for (String next : map.keySet()) {
            Object a2 = t.a(next, map.get(next));
            if (hashMap.containsKey(next)) {
                hashMap2.put(next, a2);
            }
        }
        List list = (List) hashMap2.get("local_adjustments");
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Object obj = list.get(i);
                if (obj instanceof HashMap) {
                    Adjustment.fromDecodedHashMap((HashMap) obj).adjustments = new LocalState();
                } else if (obj instanceof Adjustment) {
                    Adjustment adjustment = (Adjustment) obj;
                }
            }
        }
        return hashMap2;
    }

    public static Map<String, Object> prepareAdjustments(Map<String, Object> map) {
        Map<String, Object> makeCompatible = makeCompatible(map);
        float[] fArr = (float[]) makeCompatible.get("crop");
        if (fArr != null && Arrays.equals(fArr, new float[]{0.0f, 0.0f, 1.0f, 1.0f})) {
            makeCompatible.remove("crop");
        }
        makeCompatible.remove("faces");
        makeCompatible.remove("face_features");
        makeCompatible.remove("spots");
        makeCompatible.remove("text");
        if (makeCompatible.get("rotation") != null && ((Float) makeCompatible.get("rotation")).floatValue() == 0.0f) {
            makeCompatible.remove("rotation");
        }
        makeCompatible.remove("rotate90");
        makeCompatible.remove("distortion_horizontal");
        makeCompatible.remove("distortion_vertical");
        makeCompatible.remove("distortion_mesh");
        return makeCompatible;
    }

    public void reset() {
        this.mesh = Mesh.plane(new Mesh.Options(64));
        this.distortionVertices = this.mesh.getDistortionPoints();
        this.deltaVertices = this.mesh.getDeltaPoints();
        overlayMesh = Mesh.plane(new Mesh.Options(true, false, false, 32));
        this.screen = new Screen();
        this.textLayers.clear();
        a.a.b.f.a(this.renderStates);
    }
}
