package com.oppo.camera.f;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import java.util.HashMap;

/* compiled from: CameraMetadataKey */
public class c {
    public static final CaptureResult.Key<int[]> A = new CaptureResult.Key<>("com.oplus.iris.aperture.switching", int[].class);
    public static final CaptureResult.Key<int[]> B = new CaptureResult.Key<>("com.oplus.beauty3d.analyses.result", int[].class);
    public static final CaptureResult.Key<int[]> C = new CaptureResult.Key<>("com.oplus.beauty3d.analyses.ffd", int[].class);
    public static final CaptureResult.Key<int[]> D = new CaptureResult.Key<>("com.oplus.beauty3d.custom.result", int[].class);
    public static final CaptureResult.Key<int[]> E = new CaptureResult.Key<>("com.oplus.beauty3d.scan.result", int[].class);
    public static final CaptureResult.Key<int[]> F = new CaptureResult.Key<>("com.oplus.zoom.state", int[].class);
    public static final CaptureResult.Key<Integer> G = new CaptureResult.Key<>("display.iso", Integer.class);
    public static final CaptureResult.Key<Integer> H = new CaptureResult.Key<>("post.process", Integer.class);
    public static final CaptureResult.Key<byte[]> I = new CaptureResult.Key<>("com.oplus.SensorName", byte[].class);
    public static final CaptureResult.Key<int[]> J = new CaptureResult.Key<>("com.mediatek.control.capture.next.ready", int[].class);
    public static final CaptureResult.Key<int[]> K = new CaptureResult.Key<>("com.oplus.fb.face.info", int[].class);
    public static final CaptureResult.Key<Integer> L = new CaptureResult.Key<>("scene.binning", Integer.class);
    public static final CaptureResult.Key<Integer> M = new CaptureResult.Key<>("capture.state", Integer.class);
    public static final CaptureResult.Key<int[]> N = new CaptureResult.Key<>("org.codeaurora.qcamera3.manualWB.color_temperature", int[].class);
    public static final CaptureResult.Key<float[]> O = new CaptureResult.Key<>("com.oplus.rawhdr.isp.luxindex", float[].class);
    public static final CaptureResult.Key<float[]> P = new CaptureResult.Key<>("com.qti.chi.statsaec.AecLux", float[].class);
    public static final CaptureResult.Key<int[]> Q = new CaptureResult.Key<>("com.mediatek.3afeature.aeLuxIndex", int[].class);
    public static final CaptureResult.Key<int[]> R = new CaptureResult.Key<>("com.oplus.focus.is.depth.based", int[].class);
    public static final CaptureResult.Key<int[]> S = new CaptureResult.Key<>("com.oplus.flashtrigger.state", int[].class);
    public static final CaptureResult.Key<int[]> T = new CaptureResult.Key<>("com.oplus.MicroDistance", int[].class);
    public static final CaptureResult.Key<int[]> U = new CaptureResult.Key<>("com.qti.stats_control.is_lls_needed", int[].class);
    public static final CaptureResult.Key<int[]> V = new CaptureResult.Key<>("com.oplus.lls.state", int[].class);
    public static final CaptureResult.Key<int[]> W = new CaptureResult.Key<>("com.oplus.night.shake.state", int[].class);
    public static final CaptureResult.Key<int[]> X = new CaptureResult.Key<>("focus.distance", int[].class);
    public static final CaptureResult.Key<int[]> Y = new CaptureResult.Key<>("com.oplus.facebeauty.level", int[].class);
    public static final CaptureResult.Key<int[]> Z = new CaptureResult.Key<>("com.oplus.facebeauty.custom", int[].class);

    /* renamed from: a  reason: collision with root package name */
    public static final CaptureRequest.Key<byte[]> f3188a = new CaptureRequest.Key<>("com.oplus.caller.package.name", byte[].class);
    public static final CameraCharacteristics.Key<int[]> aA = new CameraCharacteristics.Key<>("com.mediatek.multicamfeature.availableMultiCamFeatureMode", int[].class);
    public static final CameraCharacteristics.Key<int[]> aB = new CameraCharacteristics.Key<>("org.codeaurora.qcamera3.logicalCameraType.logical_camera_type", int[].class);
    public static final CameraCharacteristics.Key<int[]> aC = new CameraCharacteristics.Key<>("com.oplus.logical.camera.type", int[].class);
    public static final CameraCharacteristics.Key<int[]> aD = new CameraCharacteristics.Key<>("com.oplus.custom.front.portrait.size", int[].class);
    public static final CaptureRequest.Key<byte[]> aE = new CaptureRequest.Key<>("com.mediatek.control.capture.ispMetaEnable", byte[].class);
    public static final CaptureRequest.Key<byte[]> aF = new CaptureRequest.Key<>("com.mediatek.control.capture.ispTuningRequest", byte[].class);
    public static final CameraCharacteristics.Key<int[]> aG = new CameraCharacteristics.Key<>("com.mediatek.control.capture.ispMetaSizeForYuv", int[].class);
    public static final CameraCharacteristics.Key<int[]> aH = new CameraCharacteristics.Key<>("com.mediatek.control.capture.ispMetaSizeForRaw", int[].class);
    public static final CaptureRequest.Key<int[]> aI = new CaptureRequest.Key<>("com.mediatek.control.capture.inSensorZoom.mode", int[].class);
    public static final CameraCharacteristics.Key<byte[]> aJ = new CameraCharacteristics.Key<>("com.oplus.custom.video.endofstream", byte[].class);
    public static final CameraCharacteristics.Key<int[]> aK = new CameraCharacteristics.Key<>("com.mediatek.smvrfeature.availableSmvrModes", int[].class);
    public static final CameraCharacteristics.Key<Integer> aL = new CameraCharacteristics.Key<>("com.oplus.low.ram", Integer.TYPE);
    public static final CameraCharacteristics.Key<float[]> aM = new CameraCharacteristics.Key<>("com.oplus.fov.Angle", float[].class);
    public static final CameraCharacteristics.Key<int[]> aN = new CameraCharacteristics.Key<>("com.oplus.vendor.tag.count", int[].class);
    public static final CameraCharacteristics.Key<int[]> aO = new CameraCharacteristics.Key<>("com.oplus.vendor.tag.ids", int[].class);
    public static final CameraCharacteristics.Key<byte[]> aP = new CameraCharacteristics.Key<>("com.oplus.vendor.tag.names", byte[].class);
    public static final CaptureRequest.Key<int[]> aQ = new CaptureRequest.Key<>("com.qti.izoom_control.state_izoom_snapshot", int[].class);
    public static final CaptureRequest.Key<int[]> aR = new CaptureRequest.Key<>("com.oplus.MFSRFrameNum", int[].class);
    public static final CaptureRequest.Key<Byte> aS = new CaptureRequest.Key<>("org.quic.camera.CustomNoiseReduction.CustomNoiseReduction", Byte.TYPE);
    public static final CaptureRequest.Key<int[]> aT = new CaptureRequest.Key<>("com.mediatek.streamingfeature.pipDevices", int[].class);
    public static final CaptureRequest.Key<Integer> aU = new CaptureRequest.Key<>("com.oplus.dualscene.master", Integer.class);
    public static final CaptureRequest.Key<int[]> aV = new CaptureRequest.Key<>("com.oplus.aps.multiframe.count", int[].class);
    public static final CaptureResult.Key<long[]> aW = new CaptureResult.Key<>("com.oplus.count.down.estimator", long[].class);
    public static final CaptureRequest.Key<Byte> aX = new CaptureRequest.Key<>("com.qti.chi.metadataOwnerInfo.MetadataOwner", Byte.TYPE);
    public static final CaptureResult.Key<Integer> aY = new CaptureResult.Key<>("com.oplus.af.focus.out.of.range", Integer.class);
    public static final CaptureRequest.Key<Integer> aZ = new CaptureRequest.Key<>("com.oplus.BracketMode", Integer.class);
    public static final CaptureResult.Key<int[]> aa = new CaptureResult.Key<>("com.oplus.manualWB.color_temperature", int[].class);
    public static final CaptureResult.Key<Integer> ab = new CaptureResult.Key<>("org.quic.camera.eislookahead.FrameDelay", Integer.TYPE);
    public static final CaptureResult.Key<int[]> ac = new CaptureResult.Key<>("com.oplus.ai.scene.app.data", int[].class);
    public static final CaptureResult.Key<int[]> ad = new CaptureResult.Key<>("com.oplus.portrait.bokeh.state", int[].class);
    public static final CaptureResult.Key<byte[]> ae = new CaptureResult.Key<>("com.oplus.tof.info", byte[].class);
    public static final CaptureResult.Key<int[]> af = new CaptureResult.Key<>("com.oplus.af.mw.info", int[].class);
    public static final CaptureResult.Key<Integer> ag = new CaptureResult.Key<>("com.oplus.ai.scene.app.data.video", Integer.class);
    public static final CaptureResult.Key<Integer> ah = new CaptureResult.Key<>("com.oplus.camera.lens.dirty", Integer.class);
    public static final CaptureResult.Key<Integer> ai = new CaptureResult.Key<>("com.oplus.aps.sat.snapshot.sensors.number", Integer.class);
    public static final CameraCharacteristics.Key<int[]> aj = new CameraCharacteristics.Key<>("com.oplus.bokeh.picture.size", int[].class);
    public static final CaptureResult.Key<Integer> ak = new CaptureResult.Key<>("com.oplus.capture.request.need.preview.stream", Integer.class);
    public static final CaptureRequest.Key<int[]> al = new CaptureRequest.Key<>("com.mediatek.configure.setting.initrequest", int[].class);
    public static final CaptureRequest.Key<int[]> am = new CaptureRequest.Key<>("com.mediatek.multicamfeature.multiCamConfigScalerCropRegion", int[].class);
    public static final CameraCharacteristics.Key<int[]> an = new CameraCharacteristics.Key<>("com.mediatek.hdrfeature.availableHdrModesVideo", int[].class);
    public static final CameraCharacteristics.Key<int[]> ao = new CameraCharacteristics.Key<>("com.oplus.feature.3hdr.support", int[].class);
    public static final CaptureRequest.Key<int[]> ap = new CaptureRequest.Key<>("com.mediatek.control.capture.hintForIspTuning", int[].class);
    public static final CaptureRequest.Key<Integer> aq = new CaptureRequest.Key<>("com.mediatek.control.capture.hintForIspFrameCount", Integer.class);
    public static final CaptureRequest.Key<Integer> ar = new CaptureRequest.Key<>("com.mediatek.control.capture.hintForIspFrameIndex", Integer.class);
    public static final CaptureRequest.Key<int[]> as = new CaptureRequest.Key<>("com.mediatek.control.capture.packedRaw.enable", int[].class);
    public static final CaptureRequest.Key<Integer> at = new CaptureRequest.Key<>("com.mediatek.control.capture.processRaw.enable", Integer.class);
    public static final CaptureRequest.Key<int[]> au = new CaptureRequest.Key<>("com.mediatek.control.capture.raw.bpp", int[].class);
    public static final CameraCharacteristics.Key<float[]> av = new CameraCharacteristics.Key<>("com.oplus.custom.zoom.range", float[].class);
    public static final CameraCharacteristics.Key<float[]> aw = new CameraCharacteristics.Key<>("com.oplus.expert.zoom.range", float[].class);
    public static final CameraCharacteristics.Key<float[]> ax = new CameraCharacteristics.Key<>("com.oplus.ultrawide.zoom.range", float[].class);
    public static final CameraCharacteristics.Key<float[]> ay = new CameraCharacteristics.Key<>("com.oplus.custom.video.zoom.range", float[].class);
    public static final CameraCharacteristics.Key<float[]> az = new CameraCharacteristics.Key<>("com.oplus.custom.video.60fps.zoom.range", float[].class);

    /* renamed from: b  reason: collision with root package name */
    public static final CaptureRequest.Key<Integer> f3189b = new CaptureRequest.Key<>("com.oplus.capture.request.idx", Integer.TYPE);
    public static final CaptureResult.Key<float[]> ba = new CaptureResult.Key<>("com.qti.stats_control.sgwRGRatio", float[].class);
    public static final CaptureResult.Key<float[]> bb = new CaptureResult.Key<>("com.qti.stats_control.sgwBGRatio", float[].class);
    public static final CaptureResult.Key<float[]> bc = new CaptureResult.Key<>("org.quic.camera2.statsconfigs.AWBDecisionAfterTC", float[].class);
    public static final CaptureResult.Key<float[]> bd = new CaptureResult.Key<>("com.oplus.awb.colorsensor.CCT", float[].class);
    public static final CaptureResult.Key<float[]> be = new CaptureResult.Key<>("com.qti.stats_control.drc_gain", float[].class);
    public static final CaptureResult.Key<float[]> bf = new CaptureResult.Key<>("com.oplus.gyroSqrCutom", float[].class);
    public static final CaptureResult.Key<int[]> bg = new CaptureResult.Key<>("com.qti.stats_control.ais_motion_type", int[].class);
    public static final CaptureResult.Key<int[]> bh = new CaptureResult.Key<>("com.qti.stats_control.is_ais_needed", int[].class);
    public static final CaptureResult.Key<int[]> bi = new CaptureResult.Key<>("com.oplus.af.focus.roi", int[].class);
    public static final CaptureResult.Key<int[]> bj = new CaptureResult.Key<>("com.oplus.af.focus.method", int[].class);
    public static final CaptureResult.Key<int[]> bk = new CaptureResult.Key<>("com.oplus.focus.time.cost", int[].class);
    public static final CaptureResult.Key<Integer> bl = new CaptureResult.Key<>("com.oplus.is.laser.dirty", Integer.TYPE);
    public static final CaptureResult.Key<float[]> bm = new CaptureResult.Key<>("com.oplus.mfnr.sharpnessVal", float[].class);
    public static final CaptureRequest.Key<Integer> bn = new CaptureRequest.Key<>("com.oplus.asd.scene.value", Integer.class);
    public static final CaptureRequest.Key<Integer> bo = new CaptureRequest.Key<>("com.oplus.aelock.bytouch", Integer.class);
    public static final CaptureResult.Key<int[]> c = new CaptureResult.Key<>("com.qti.stats_control.is_ais_needed", int[].class);
    public static final CaptureResult.Key<int[]> d = new CaptureResult.Key<>("com.qti.stats_control.ais_motion_type", int[].class);
    public static final CaptureResult.Key<int[]> e = new CaptureResult.Key<>("com.qti.stats_control.ais_is_within_trigger_rgn", int[].class);
    public static final CaptureResult.Key<Byte> f = new CaptureResult.Key<>("com.oplus.is.pdaf.done", Byte.TYPE);
    public static final CaptureResult.Key<int[]> g = new CaptureResult.Key<>("com.oplus.salientobj.move.info", int[].class);
    public static final CaptureRequest.Key<int[]> h = new CaptureRequest.Key<>("com.oplus.BlurlessFrameNum", int[].class);
    public static CaptureRequest.Key<int[]> i = new CaptureRequest.Key<>("org.codeaurora.qcamera3.iso_exp_priority.select_priority", int[].class);
    public static CaptureRequest.Key<long[]> j = new CaptureRequest.Key<>("org.codeaurora.qcamera3.iso_exp_priority.use_iso_exp_priority", long[].class);
    public static final CaptureRequest.Key<Long> k = new CaptureRequest.Key<>("com.oplus.exiftag.datetime", Long.class);
    public static final CaptureRequest.Key<byte[]> l = new CaptureRequest.Key<>("com.oplus.exiftag.offsettime", byte[].class);
    public static final CaptureResult.Key<int[]> m = new CaptureResult.Key<>("com.oplus.sod.track.region", int[].class);
    public static final CameraCharacteristics.Key<int[]> n = new CameraCharacteristics.Key<>("com.oplus.custom.jpeg.size", int[].class);
    public static final CameraCharacteristics.Key<int[]> o = new CameraCharacteristics.Key<>("org.codeaurora.qcamera3.manualWB.color_temperature_range", int[].class);
    public static final CameraCharacteristics.Key<int[]> p = new CameraCharacteristics.Key<>("com.oplus.manualWB.color_temperature_range", int[].class);
    public static final CameraCharacteristics.Key<int[]> q = new CameraCharacteristics.Key<>("com.oplus.supported.cameraid.type", int[].class);
    public static final CameraCharacteristics.Key<int[]> r = new CameraCharacteristics.Key<>("com.mediatek.cshotfeature.availableCShotModes", int[].class);
    public static final CameraCharacteristics.Key<int[]> s = new CameraCharacteristics.Key<>("com.mediatek.control.capture.early.notification.support", int[].class);
    public static final CameraCharacteristics.Key<int[]> t = new CameraCharacteristics.Key<>("com.mediatek.bgservicefeature.availableprereleasemodes", int[].class);
    public static final CameraCharacteristics.Key<int[]> u = new CameraCharacteristics.Key<>("com.oplus.superEis.available.target.fps.ranges", int[].class);
    public static final CaptureRequest.Key<int[]> v = new CaptureRequest.Key<>("com.mediatek.cshotfeature.capture", int[].class);
    public static final CaptureRequest.Key<int[]> w = new CaptureRequest.Key<>("com.mediatek.control.capture.early.notification.trigger", int[].class);
    public static final CaptureRequest.Key<Integer> x = new CaptureRequest.Key<>("com.oplus.video.stabilization.mode", Integer.class);
    public static final CaptureRequest.Key<Integer> y = new CaptureRequest.Key<>("com.oplus.aps.feature.type", Integer.class);
    public static final CaptureRequest.Key<Long> z = new CaptureRequest.Key<>("com.oplus.sensor.exposureTime", Long.class);
    private HashMap<String, CaptureRequest.Key<?>> bp;
    private HashMap<String, CaptureResult.Key<?>> bq;

    public c() {
        this.bp = null;
        this.bq = null;
        this.bp = new HashMap<>();
        this.bq = new HashMap<>();
    }

    public static Object a(CaptureResult captureResult, CaptureResult.Key<?> key) {
        try {
            return captureResult.get(key);
        } catch (Exception unused) {
            return null;
        }
    }
}
