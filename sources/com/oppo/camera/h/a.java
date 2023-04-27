package com.oppo.camera.h;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.meicam.sdk.NvsFxDescription;
import com.oppo.camera.e;
import com.sensetime.stmobile.sticker_module_types.STStickerMakeupParamType;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.apache.commons.codec.CharEncoding;

/* compiled from: CameraExifInterface */
public class a {
    private static final c[][] A;
    private static final c[] B = {new c("SubIFDPointer", 330, 4), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("InteroperabilityIFDPointer", 40965, 4), new c("CameraSettingsIFDPointer", 8224, 1), new c("ImageProcessingIFDPointer", 8256, 1)};
    private static final c C = new c("JPEGInterchangeFormat", (int) a.a.b.a.a.a.KEY_INDEX, 4);
    private static final c D = new c("JPEGInterchangeFormatLength", 514, 4);
    private static final HashMap[] E;
    private static final HashMap[] F;
    private static final HashSet<String> G = new HashSet<>(Arrays.asList(new String[]{"FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"}));
    private static final HashMap<Integer, Integer> H = new HashMap<>();
    /* access modifiers changed from: private */
    public static final Charset I = Charset.forName(CharEncoding.US_ASCII);
    private static final byte[] J = "Exif\u0000\u0000".getBytes(I);
    private static final byte[] K = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(I);

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f3329a = {-1, -40, -1};
    private static final Pattern ae = Pattern.compile(".*[1-9].*");
    private static final Pattern af = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f3330b = {102, 116, 121, 112};
    private static final byte[] c = {109, 105, 102, 49};
    private static final byte[] d = {104, 101, 105, 99};
    private static final byte[] e = {79, 76, 89, 77, 80, 0};
    private static final byte[] f = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static SimpleDateFormat g = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    private static SimpleDateFormat h = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss XXX");
    /* access modifiers changed from: private */
    public static final String[] i = {"", "BYTE", NvsFxDescription.ParamInfoObject.PARAM_TYPE_STRING, "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    /* access modifiers changed from: private */
    public static final int[] j = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    /* access modifiers changed from: private */
    public static final byte[] k = {65, 83, 67, 73, 73, 0, 0, 0};
    private static final int[] l = {8, 8, 8};
    private static final int[] m = {4};
    private static final int[] n = {8};
    private static final c[] q = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ImageWidth", 256, 3, 4), new c("ImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", (int) a.a.b.a.a.a.KEY_INDEX, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("SensorTopBorder", 4, 4), new c("SensorLeftBorder", 5, 4), new c("SensorBottomBorder", 6, 4), new c("SensorRightBorder", 7, 4), new c("ISO", 23, 3), new c("JpgFromRaw", 46, 7), new c("Xmp", (int) STStickerMakeupParamType.ST_STICKER_PARAM_MAKEUP_FLOAT_SCALE, 1), new c("DateTimeOriginal", 36867, 2), new c("SubSecTimeOriginal", 37521, 2), new c("OffsetTimeOriginal", 36881, 2)};
    private static final c[] r = {new c("ExposureTime", 33434, 5), new c("FNumber", 33437, 5), new c("ExposureProgram", 34850, 3), new c("SpectralSensitivity", 34852, 2), new c("ISOSpeedRatings", 34855, 3), new c("OECF", 34856, 7), new c("ExifVersion", 36864, 2), new c("DateTimeOriginal", 36867, 2), new c("DateTimeDigitized", 36868, 2), new c("OffsetTime", 36880, 2), new c("OffsetTimeOriginal", 36881, 2), new c("OffsetTimeDigitized", 36882, 2), new c("ComponentsConfiguration", 37121, 7), new c("CompressedBitsPerPixel", 37122, 5), new c("ShutterSpeedValue", 37377, 10), new c("ApertureValue", 37378, 5), new c("BrightnessValue", 37379, 10), new c("ExposureBiasValue", 37380, 10), new c("MaxApertureValue", 37381, 5), new c("SubjectDistance", 37382, 5), new c("MeteringMode", 37383, 3), new c("LightSource", 37384, 3), new c("Flash", 37385, 3), new c("FocalLength", 37386, 5), new c("SubjectArea", 37396, 3), new c("MakerNote", 37500, 7), new c("UserComment", 37510, 7), new c("SubSecTime", 37520, 2), new c("SubSecTimeOriginal", 37521, 2), new c("SubSecTimeDigitized", 37522, 2), new c("FlashpixVersion", 40960, 7), new c("ColorSpace", 40961, 3), new c("PixelXDimension", 40962, 3, 4), new c("PixelYDimension", 40963, 3, 4), new c("RelatedSoundFile", 40964, 2), new c("InteroperabilityIFDPointer", 40965, 4), new c("FlashEnergy", 41483, 5), new c("SpatialFrequencyResponse", 41484, 7), new c("FocalPlaneXResolution", 41486, 5), new c("FocalPlaneYResolution", 41487, 5), new c("FocalPlaneResolutionUnit", 41488, 3), new c("SubjectLocation", 41492, 3), new c("ExposureIndex", 41493, 5), new c("SensingMethod", 41495, 3), new c("FileSource", 41728, 7), new c("SceneType", 41729, 7), new c("CFAPattern", 41730, 7), new c("CustomRendered", 41985, 3), new c("ExposureMode", 41986, 3), new c("WhiteBalance", 41987, 3), new c("DigitalZoomRatio", 41988, 5), new c("FocalLengthIn35mmFilm", 41989, 3), new c("SceneCaptureType", 41990, 3), new c("GainControl", 41991, 3), new c("Contrast", 41992, 3), new c("Saturation", 41993, 3), new c("Sharpness", 41994, 3), new c("DeviceSettingDescription", 41995, 7), new c("SubjectDistanceRange", 41996, 3), new c("ImageUniqueID", 42016, 2), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
    private static final c[] s = {new c("GPSVersionID", 0, 1), new c("GPSLatitudeRef", 1, 2), new c("GPSLatitude", 2, 5), new c("GPSLongitudeRef", 3, 2), new c("GPSLongitude", 4, 5), new c("GPSAltitudeRef", 5, 1), new c("GPSAltitude", 6, 5), new c("GPSTimeStamp", 7, 5), new c("GPSSatellites", 8, 2), new c("GPSStatus", 9, 2), new c("GPSMeasureMode", 10, 2), new c("GPSDOP", 11, 5), new c("GPSSpeedRef", 12, 2), new c("GPSSpeed", 13, 5), new c("GPSTrackRef", 14, 2), new c("GPSTrack", 15, 5), new c("GPSImgDirectionRef", 16, 2), new c("GPSImgDirection", 17, 5), new c("GPSMapDatum", 18, 2), new c("GPSDestLatitudeRef", 19, 2), new c("GPSDestLatitude", 20, 5), new c("GPSDestLongitudeRef", 21, 2), new c("GPSDestLongitude", 22, 5), new c("GPSDestBearingRef", 23, 2), new c("GPSDestBearing", 24, 5), new c("GPSDestDistanceRef", 25, 2), new c("GPSDestDistance", 26, 5), new c("GPSProcessingMethod", 27, 7), new c("GPSAreaInformation", 28, 7), new c("GPSDateStamp", 29, 2), new c("GPSDifferential", 30, 3)};
    private static final c[] t = {new c("InteroperabilityIndex", 1, 2)};
    private static final c[] u = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ThumbnailImageWidth", 256, 3, 4), new c("ThumbnailImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", (int) a.a.b.a.a.a.KEY_INDEX, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
    private static final c v = new c("StripOffsets", 273, 3);
    private static final c[] w = {new c("ThumbnailImage", 256, 7), new c("CameraSettingsIFDPointer", 8224, 4), new c("ImageProcessingIFDPointer", 8256, 4)};
    private static final c[] x = {new c("PreviewImageStart", 257, 4), new c("PreviewImageLength", 258, 4)};
    private static final c[] y = {new c("AspectFrame", 4371, 3)};
    private static final c[] z = {new c("ColorSpace", 55, 3)};
    private String L;
    private FileDescriptor M;
    private AssetManager.AssetInputStream N;
    private boolean O;
    private int P;
    private final HashMap[] Q;
    private Set<Integer> R;
    private ByteOrder S;
    private boolean T;
    private int U;
    private int V;
    private byte[] W;
    private int X;
    private int Y;
    private int Z;
    private int aa;
    private int ab;
    private int ac;
    private boolean ad;
    private int[] o = null;
    private int[] p = null;

    static {
        c[] cVarArr = q;
        A = new c[][]{cVarArr, r, s, t, u, cVarArr, w, x, y, z};
        c[][] cVarArr2 = A;
        E = new HashMap[cVarArr2.length];
        F = new HashMap[cVarArr2.length];
        g.setTimeZone(TimeZone.getTimeZone("UTC"));
        h.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i2 = 0; i2 < A.length; i2++) {
            E[i2] = new HashMap();
            F[i2] = new HashMap();
            for (c cVar : A[i2]) {
                E[i2].put(Integer.valueOf(cVar.f3337a), cVar);
                F[i2].put(cVar.f3338b, cVar);
            }
        }
        H.put(Integer.valueOf(B[0].f3337a), 5);
        H.put(Integer.valueOf(B[1].f3337a), 1);
        H.put(Integer.valueOf(B[2].f3337a), 2);
        H.put(Integer.valueOf(B[3].f3337a), 3);
        H.put(Integer.valueOf(B[4].f3337a), 7);
        H.put(Integer.valueOf(B[5].f3337a), 8);
    }

    /* compiled from: CameraExifInterface */
    private static class d {

        /* renamed from: a  reason: collision with root package name */
        public final long f3339a;

        /* renamed from: b  reason: collision with root package name */
        public final long f3340b;

        private d(long j, long j2) {
            if (j2 == 0) {
                this.f3339a = 0;
                this.f3340b = 1;
                return;
            }
            this.f3339a = j;
            this.f3340b = j2;
        }

        public String toString() {
            return this.f3339a + "/" + this.f3340b;
        }

        public double a() {
            return ((double) this.f3339a) / ((double) this.f3340b);
        }
    }

    /* compiled from: CameraExifInterface */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f3335a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3336b;
        public final long c;
        public final byte[] d;

        private b(int i, int i2, byte[] bArr) {
            this(i, i2, -1, bArr);
        }

        private b(int i, int i2, long j, byte[] bArr) {
            this.f3335a = i;
            this.f3336b = i2;
            this.c = j;
            this.d = bArr;
        }

        public static b a(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.j[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putShort((short) i);
            }
            return new b(3, iArr.length, wrap.array());
        }

        public static b a(int i, ByteOrder byteOrder) {
            return a(new int[]{i}, byteOrder);
        }

        public static b a(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.j[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j : jArr) {
                wrap.putInt((int) j);
            }
            return new b(4, jArr.length, wrap.array());
        }

        public static b a(long j, ByteOrder byteOrder) {
            return a(new long[]{j}, byteOrder);
        }

        public static b a(String str) {
            byte[] bytes = (str + 0).getBytes(a.I);
            return new b(2, bytes.length, bytes);
        }

        public static b a(d[] dVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.j[5] * dVarArr.length)]);
            wrap.order(byteOrder);
            for (d dVar : dVarArr) {
                wrap.putInt((int) dVar.f3339a);
                wrap.putInt((int) dVar.f3340b);
            }
            return new b(5, dVarArr.length, wrap.array());
        }

        public static b a(d dVar, ByteOrder byteOrder) {
            return a(new d[]{dVar}, byteOrder);
        }

        public String toString() {
            return "(" + a.i[this.f3335a] + ", data length:" + this.d.length + ")";
        }

        /* access modifiers changed from: private */
        public Object d(ByteOrder byteOrder) {
            try {
                C0086a aVar = new C0086a(this.d);
                aVar.a(byteOrder);
                boolean z = true;
                int i = 0;
                switch (this.f3335a) {
                    case 1:
                    case 6:
                        if (this.d.length != 1 || this.d[0] < 0 || this.d[0] > 1) {
                            return new String(this.d, a.I);
                        }
                        return new String(new char[]{(char) (this.d[0] + 48)});
                    case 2:
                    case 7:
                        if (this.f3336b >= a.k.length) {
                            int i2 = 0;
                            while (true) {
                                if (i2 < a.k.length) {
                                    if (this.d[i2] != a.k[i2]) {
                                        z = false;
                                    } else {
                                        i2++;
                                    }
                                }
                            }
                            if (z) {
                                i = a.k.length;
                            }
                        }
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            if (i < this.f3336b) {
                                byte b2 = this.d[i];
                                if (b2 != 0) {
                                    if (b2 >= 32) {
                                        sb.append((char) b2);
                                    } else {
                                        sb.append('?');
                                    }
                                    i++;
                                }
                            }
                        }
                        return sb.toString();
                    case 3:
                        int[] iArr = new int[this.f3336b];
                        while (i < this.f3336b) {
                            iArr[i] = aVar.readUnsignedShort();
                            i++;
                        }
                        return iArr;
                    case 4:
                        long[] jArr = new long[this.f3336b];
                        while (i < this.f3336b) {
                            jArr[i] = aVar.b();
                            i++;
                        }
                        return jArr;
                    case 5:
                        d[] dVarArr = new d[this.f3336b];
                        while (i < this.f3336b) {
                            dVarArr[i] = new d(aVar.b(), aVar.b());
                            i++;
                        }
                        return dVarArr;
                    case 8:
                        int[] iArr2 = new int[this.f3336b];
                        while (i < this.f3336b) {
                            iArr2[i] = aVar.readShort();
                            i++;
                        }
                        return iArr2;
                    case 9:
                        int[] iArr3 = new int[this.f3336b];
                        while (i < this.f3336b) {
                            iArr3[i] = aVar.readInt();
                            i++;
                        }
                        return iArr3;
                    case 10:
                        d[] dVarArr2 = new d[this.f3336b];
                        while (i < this.f3336b) {
                            dVarArr2[i] = new d((long) aVar.readInt(), (long) aVar.readInt());
                            i++;
                        }
                        return dVarArr2;
                    case 11:
                        double[] dArr = new double[this.f3336b];
                        while (i < this.f3336b) {
                            dArr[i] = (double) aVar.readFloat();
                            i++;
                        }
                        return dArr;
                    case 12:
                        double[] dArr2 = new double[this.f3336b];
                        while (i < this.f3336b) {
                            dArr2[i] = aVar.readDouble();
                            i++;
                        }
                        return dArr2;
                    default:
                        return null;
                }
            } catch (IOException e) {
                Log.w("ExifInterface:", "IOException occurred during reading a value", e);
                return null;
            }
        }

        public double a(ByteOrder byteOrder) {
            Object d2 = d(byteOrder);
            if (d2 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (d2 instanceof String) {
                return Double.parseDouble((String) d2);
            } else {
                if (d2 instanceof long[]) {
                    long[] jArr = (long[]) d2;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (d2 instanceof int[]) {
                    int[] iArr = (int[]) d2;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (d2 instanceof double[]) {
                    double[] dArr = (double[]) d2;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (d2 instanceof d[]) {
                    d[] dVarArr = (d[]) d2;
                    if (dVarArr.length == 1) {
                        return dVarArr[0].a();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int b(ByteOrder byteOrder) {
            Object d2 = d(byteOrder);
            if (d2 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (d2 instanceof String) {
                return Integer.parseInt((String) d2);
            } else {
                if (d2 instanceof long[]) {
                    long[] jArr = (long[]) d2;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (d2 instanceof int[]) {
                    int[] iArr = (int[]) d2;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String c(ByteOrder byteOrder) {
            Object d2 = d(byteOrder);
            if (d2 == null) {
                return null;
            }
            if (d2 instanceof String) {
                return (String) d2;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (d2 instanceof long[]) {
                long[] jArr = (long[]) d2;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (d2 instanceof int[]) {
                int[] iArr = (int[]) d2;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (d2 instanceof double[]) {
                double[] dArr = (double[]) d2;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(d2 instanceof d[])) {
                return null;
            } else {
                d[] dVarArr = (d[]) d2;
                while (i < dVarArr.length) {
                    sb.append(dVarArr[i].f3339a);
                    sb.append('/');
                    sb.append(dVarArr[i].f3340b);
                    i++;
                    if (i != dVarArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }
    }

    /* compiled from: CameraExifInterface */
    private static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f3337a;

        /* renamed from: b  reason: collision with root package name */
        public final String f3338b;
        public final int c;
        public final int d;

        private c(String str, int i, int i2) {
            this.f3338b = str;
            this.f3337a = i;
            this.c = i2;
            this.d = -1;
        }

        private c(String str, int i, int i2, int i3) {
            this.f3338b = str;
            this.f3337a = i;
            this.c = i2;
            this.d = i3;
        }
    }

    public a(InputStream inputStream, int[] iArr) throws IOException {
        c[][] cVarArr = A;
        this.Q = new HashMap[cVarArr.length];
        this.R = new HashSet(cVarArr.length);
        this.S = ByteOrder.BIG_ENDIAN;
        this.p = iArr;
        if (inputStream != null) {
            this.L = null;
            if (inputStream instanceof AssetManager.AssetInputStream) {
                this.N = (AssetManager.AssetInputStream) inputStream;
                this.M = null;
            } else {
                if (inputStream instanceof FileInputStream) {
                    FileInputStream fileInputStream = (FileInputStream) inputStream;
                    if (a(fileInputStream.getFD())) {
                        this.N = null;
                        this.M = fileInputStream.getFD();
                    }
                }
                this.N = null;
                this.M = null;
            }
            this.O = true;
            a(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }

    public int[] a() {
        return this.o;
    }

    private b b(String str) {
        if (str != null) {
            for (int i2 = 0; i2 < A.length; i2++) {
                Object obj = this.Q[i2].get(str);
                if (obj != null) {
                    return (b) obj;
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    public String a(String str) {
        if (str != null) {
            b b2 = b(str);
            if (b2 != null) {
                if (!G.contains(str)) {
                    return b2.c(this.S);
                }
                if (!str.equals("GPSTimeStamp")) {
                    try {
                        return Double.toString(b2.a(this.S));
                    } catch (NumberFormatException unused) {
                    }
                } else if (b2.f3335a != 5 && b2.f3335a != 10) {
                    return null;
                } else {
                    d[] dVarArr = (d[]) b2.d(this.S);
                    if (dVarArr.length != 3) {
                        return null;
                    }
                    return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) dVarArr[0].f3339a) / ((float) dVarArr[0].f3340b))), Integer.valueOf((int) (((float) dVarArr[1].f3339a) / ((float) dVarArr[1].f3340b))), Integer.valueOf((int) (((float) dVarArr[2].f3339a) / ((float) dVarArr[2].f3340b)))});
                }
            }
            return null;
        }
        throw new NullPointerException("tag shouldn't be null");
    }

    private void a(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            int i2 = 0;
            while (i2 < A.length) {
                try {
                    this.Q[i2] = new HashMap();
                    i2++;
                } catch (IOException | OutOfMemoryError e2) {
                    this.ad = false;
                    Log.w("ExifInterface:", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e2);
                } catch (Throwable th) {
                    g();
                    f();
                    throw th;
                }
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            this.P = a(bufferedInputStream);
            C0086a aVar = new C0086a((InputStream) bufferedInputStream);
            switch (this.P) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 5:
                case 6:
                case 8:
                case 11:
                    a(aVar);
                    break;
                case 4:
                    a(aVar, 0, 0);
                    break;
                case 7:
                    d(aVar);
                    break;
                case 9:
                    b(aVar);
                    break;
                case 10:
                    e(aVar);
                    break;
                case 12:
                    c(aVar);
                    break;
            }
            g(aVar);
            this.ad = true;
            g();
            f();
            return;
        }
        throw new NullPointerException("inputstream shouldn't be null");
    }

    private static boolean a(FileDescriptor fileDescriptor) throws IOException {
        try {
            Os.lseek(fileDescriptor, 0, OsConstants.SEEK_CUR);
            return true;
        } catch (ErrnoException unused) {
            return false;
        }
    }

    private void f() {
        for (int i2 = 0; i2 < this.Q.length; i2++) {
            Log.d("ExifInterface:", "The size of tag group[" + i2 + "]: " + this.Q[i2].size());
            for (Map.Entry entry : this.Q[i2].entrySet()) {
                b bVar = (b) entry.getValue();
                Log.d("ExifInterface:", "tagName: " + entry.getKey() + ", tagType: " + bVar.toString() + ", tagValue: '" + bVar.c(this.S) + "'");
            }
        }
    }

    private int a(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        int read = bufferedInputStream.read(bArr);
        if (read <= 0) {
            e.d("ExifInterface:", "getMimeType, in.read(signatureCheckBytes): " + read);
        }
        bufferedInputStream.reset();
        if (a(bArr)) {
            return 4;
        }
        if (b(bArr)) {
            return 9;
        }
        if (c(bArr)) {
            return 12;
        }
        if (d(bArr)) {
            return 7;
        }
        return e(bArr) ? 10 : 0;
    }

    private static boolean a(byte[] bArr) throws IOException {
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f3329a;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private boolean b(byte[] bArr) throws IOException {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes();
        for (int i2 = 0; i2 < bytes.length; i2++) {
            if (bArr[i2] != bytes[i2]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(byte[] r17) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r1 = "ExifInterface:"
            r2 = 0
            r3 = 0
            com.oppo.camera.h.a$a r4 = new com.oppo.camera.h.a$a     // Catch:{ Exception -> 0x00ae }
            r4.<init>((byte[]) r0)     // Catch:{ Exception -> 0x00ae }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.BIG_ENDIAN     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            r4.a((java.nio.ByteOrder) r3)     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            int r3 = r4.readInt()     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            long r5 = (long) r3     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            r3 = 4
            byte[] r7 = new byte[r3]     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            int r8 = r4.read(r7)     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            if (r8 > 0) goto L_0x0032
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            r9.<init>()     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            java.lang.String r10 = "isHeifFormat, signatureInputStream.read(chunkType): "
            r9.append(r10)     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            r9.append(r8)     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            java.lang.String r8 = r9.toString()     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            com.oppo.camera.e.d(r1, r8)     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
        L_0x0032:
            byte[] r8 = f3330b     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            boolean r7 = java.util.Arrays.equals(r7, r8)     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            if (r7 != 0) goto L_0x003e
            r4.close()
            return r2
        L_0x003e:
            r7 = 1
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            r10 = 16
            r12 = 8
            if (r9 != 0) goto L_0x0054
            long r5 = r4.readLong()     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            int r9 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r9 >= 0) goto L_0x0055
            r4.close()
            return r2
        L_0x0054:
            r10 = r12
        L_0x0055:
            int r9 = r0.length     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            long r14 = (long) r9     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            int r9 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r9 <= 0) goto L_0x005d
            int r0 = r0.length     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            long r5 = (long) r0
        L_0x005d:
            long r5 = r5 - r10
            int r0 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r0 >= 0) goto L_0x0066
            r4.close()
            return r2
        L_0x0066:
            byte[] r0 = new byte[r3]     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            r9 = 0
            r3 = r2
            r11 = r3
        L_0x006c:
            r12 = 4
            long r12 = r5 / r12
            int r12 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r12 >= 0) goto L_0x00a2
            int r12 = r4.read(r0)     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            int r13 = r0.length     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            if (r12 == r13) goto L_0x007f
            r4.close()
            return r2
        L_0x007f:
            int r12 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r12 != 0) goto L_0x0084
            goto L_0x00a0
        L_0x0084:
            byte[] r12 = c     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            boolean r12 = java.util.Arrays.equals(r0, r12)     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            r13 = 1
            if (r12 == 0) goto L_0x008f
            r3 = r13
            goto L_0x0098
        L_0x008f:
            byte[] r12 = d     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            boolean r12 = java.util.Arrays.equals(r0, r12)     // Catch:{ Exception -> 0x00a8, all -> 0x00a6 }
            if (r12 == 0) goto L_0x0098
            r11 = r13
        L_0x0098:
            if (r3 == 0) goto L_0x00a0
            if (r11 == 0) goto L_0x00a0
            r4.close()
            return r13
        L_0x00a0:
            long r9 = r9 + r7
            goto L_0x006c
        L_0x00a2:
            r4.close()
            goto L_0x00b9
        L_0x00a6:
            r0 = move-exception
            goto L_0x00ba
        L_0x00a8:
            r0 = move-exception
            r3 = r4
            goto L_0x00af
        L_0x00ab:
            r0 = move-exception
            r4 = r3
            goto L_0x00ba
        L_0x00ae:
            r0 = move-exception
        L_0x00af:
            java.lang.String r4 = "Exception parsing HEIF file type box."
            android.util.Log.d(r1, r4, r0)     // Catch:{ all -> 0x00ab }
            if (r3 == 0) goto L_0x00b9
            r3.close()
        L_0x00b9:
            return r2
        L_0x00ba:
            if (r4 == 0) goto L_0x00bf
            r4.close()
        L_0x00bf:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.h.a.c(byte[]):boolean");
    }

    private boolean d(byte[] bArr) throws IOException {
        C0086a aVar = new C0086a(bArr);
        this.S = f(aVar);
        aVar.a(this.S);
        short readShort = aVar.readShort();
        return readShort == 20306 || readShort == 21330;
    }

    private boolean e(byte[] bArr) throws IOException {
        C0086a aVar = new C0086a(bArr);
        this.S = f(aVar);
        aVar.a(this.S);
        return aVar.readShort() == 85;
    }

    private boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0186 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e6 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.oppo.camera.h.a.C0086a r20, int r21, int r22) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "getJpegAttributes starting with: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "ExifInterface:"
            android.util.Log.d(r5, r4)
            java.nio.ByteOrder r4 = java.nio.ByteOrder.BIG_ENDIAN
            r1.a((java.nio.ByteOrder) r4)
            long r6 = (long) r2
            r1.a((long) r6)
            byte r4 = r20.readByte()
            java.lang.String r6 = "Invalid marker: "
            r7 = -1
            if (r4 != r7) goto L_0x01d0
            r8 = 1
            int r2 = r2 + r8
            byte r9 = r20.readByte()
            r10 = -40
            if (r9 != r10) goto L_0x01b5
            int r2 = r2 + r8
        L_0x003b:
            byte r4 = r20.readByte()
            if (r4 != r7) goto L_0x0198
            int r2 = r2 + r8
            byte r4 = r20.readByte()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r9 = "Found JPEG segment indicator: "
            r6.append(r9)
            r9 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r10 = java.lang.Integer.toHexString(r9)
            r6.append(r10)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r5, r6)
            int r2 = r2 + r8
            r6 = -39
            if (r4 == r6) goto L_0x0192
            r6 = -38
            if (r4 != r6) goto L_0x006b
            goto L_0x0192
        L_0x006b:
            int r6 = r20.readUnsignedShort()
            int r6 = r6 + -2
            int r2 = r2 + 2
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "JPEG segment: "
            r10.append(r11)
            java.lang.String r9 = java.lang.Integer.toHexString(r9)
            r10.append(r9)
            java.lang.String r9 = " (length: "
            r10.append(r9)
            int r9 = r6 + 2
            r10.append(r9)
            java.lang.String r9 = ")"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            android.util.Log.d(r5, r9)
            java.lang.String r9 = "Invalid length"
            if (r6 < 0) goto L_0x018c
            r10 = -31
            r11 = 0
            if (r4 == r10) goto L_0x0119
            r10 = -2
            if (r4 == r10) goto L_0x00ee
            switch(r4) {
                case -64: goto L_0x00b4;
                case -63: goto L_0x00b4;
                case -62: goto L_0x00b4;
                case -61: goto L_0x00b4;
                default: goto L_0x00a9;
            }
        L_0x00a9:
            switch(r4) {
                case -59: goto L_0x00b4;
                case -58: goto L_0x00b4;
                case -57: goto L_0x00b4;
                default: goto L_0x00ac;
            }
        L_0x00ac:
            switch(r4) {
                case -55: goto L_0x00b4;
                case -54: goto L_0x00b4;
                case -53: goto L_0x00b4;
                default: goto L_0x00af;
            }
        L_0x00af:
            switch(r4) {
                case -51: goto L_0x00b4;
                case -50: goto L_0x00b4;
                case -49: goto L_0x00b4;
                default: goto L_0x00b2;
            }
        L_0x00b2:
            goto L_0x0172
        L_0x00b4:
            int r4 = r1.skipBytes(r8)
            if (r4 != r8) goto L_0x00e6
            java.util.HashMap[] r4 = r0.Q
            r4 = r4[r3]
            int r10 = r20.readUnsignedShort()
            long r10 = (long) r10
            java.nio.ByteOrder r12 = r0.S
            com.oppo.camera.h.a$b r10 = com.oppo.camera.h.a.b.a((long) r10, (java.nio.ByteOrder) r12)
            java.lang.String r11 = "ImageLength"
            r4.put(r11, r10)
            java.util.HashMap[] r4 = r0.Q
            r4 = r4[r3]
            int r10 = r20.readUnsignedShort()
            long r10 = (long) r10
            java.nio.ByteOrder r12 = r0.S
            com.oppo.camera.h.a$b r10 = com.oppo.camera.h.a.b.a((long) r10, (java.nio.ByteOrder) r12)
            java.lang.String r11 = "ImageWidth"
            r4.put(r11, r10)
            int r6 = r6 + -5
            goto L_0x0172
        L_0x00e6:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid SOFx"
            r1.<init>(r2)
            throw r1
        L_0x00ee:
            byte[] r4 = new byte[r6]
            int r10 = r1.read(r4)
            if (r10 != r6) goto L_0x0111
            java.lang.String r6 = "UserComment"
            java.lang.String r10 = r0.a((java.lang.String) r6)
            if (r10 != 0) goto L_0x0171
            java.util.HashMap[] r10 = r0.Q
            r10 = r10[r8]
            java.lang.String r12 = new java.lang.String
            java.nio.charset.Charset r13 = I
            r12.<init>(r4, r13)
            com.oppo.camera.h.a$b r4 = com.oppo.camera.h.a.b.a((java.lang.String) r12)
            r10.put(r6, r4)
            goto L_0x0171
        L_0x0111:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid exif"
            r1.<init>(r2)
            throw r1
        L_0x0119:
            byte[] r4 = new byte[r6]
            r1.readFully(r4)
            int r6 = r6 + r2
            byte[] r10 = J
            boolean r10 = r0.a((byte[]) r4, (byte[]) r10)
            if (r10 == 0) goto L_0x0139
            byte[] r10 = J
            int r12 = r10.length
            int r2 = r2 + r12
            long r12 = (long) r2
            int r2 = r10.length
            int r10 = r4.length
            byte[] r2 = java.util.Arrays.copyOfRange(r4, r2, r10)
            r0.a((byte[]) r2, (int) r3)
            int r2 = (int) r12
            r0.Y = r2
            goto L_0x0170
        L_0x0139:
            byte[] r10 = K
            boolean r10 = r0.a((byte[]) r4, (byte[]) r10)
            if (r10 == 0) goto L_0x0170
            byte[] r10 = K
            int r12 = r10.length
            int r2 = r2 + r12
            long r14 = (long) r2
            int r2 = r10.length
            int r10 = r4.length
            byte[] r2 = java.util.Arrays.copyOfRange(r4, r2, r10)
            java.lang.String r4 = "Xmp"
            java.lang.String r10 = r0.a((java.lang.String) r4)
            if (r10 != 0) goto L_0x0170
            java.util.HashMap[] r10 = r0.Q
            r10 = r10[r11]
            com.oppo.camera.h.a$b r13 = new com.oppo.camera.h.a$b
            r16 = 1
            int r12 = r2.length
            r18 = 0
            r17 = r12
            r12 = r13
            r7 = r13
            r13 = r16
            r15 = r14
            r14 = r17
            r17 = r2
            r12.<init>(r13, r14, r15, r17)
            r10.put(r4, r7)
        L_0x0170:
            r2 = r6
        L_0x0171:
            r6 = r11
        L_0x0172:
            if (r6 < 0) goto L_0x0186
            int r4 = r1.skipBytes(r6)
            if (r4 != r6) goto L_0x017e
            int r2 = r2 + r6
            r7 = -1
            goto L_0x003b
        L_0x017e:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid JPEG segment"
            r1.<init>(r2)
            throw r1
        L_0x0186:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r9)
            throw r1
        L_0x018c:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r9)
            throw r1
        L_0x0192:
            java.nio.ByteOrder r2 = r0.S
            r1.a((java.nio.ByteOrder) r2)
            return
        L_0x0198:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid marker:"
            r2.append(r3)
            r3 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01b5:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            r3 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01d0:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            r3 = r4 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.h.a.a(com.oppo.camera.h.a$a, int, int):void");
    }

    private void a(C0086a aVar) throws IOException {
        b bVar;
        a(aVar, aVar.available());
        b(aVar, 0);
        d(aVar, 0);
        d(aVar, 5);
        d(aVar, 4);
        b((InputStream) aVar);
        if (this.P == 8 && (bVar = (b) this.Q[1].get("MakerNote")) != null) {
            C0086a aVar2 = new C0086a(bVar.d);
            aVar2.a(this.S);
            aVar2.a(6);
            b(aVar2, 9);
            b bVar2 = (b) this.Q[9].get("ColorSpace");
            if (bVar2 != null) {
                this.Q[1].put("ColorSpace", bVar2);
            }
        }
    }

    private void b(C0086a aVar) throws IOException {
        aVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        int read = aVar.read(bArr);
        if (read <= 0) {
            e.d("ExifInterface:", "getRafAttributes, in.read(jpegOffsetBytes): " + read);
        }
        aVar.skipBytes(4);
        int read2 = aVar.read(bArr2);
        if (read2 <= 0) {
            e.d("ExifInterface:", "getRafAttributes, in.read(cfaHeaderOffsetBytes): " + read2);
        }
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        a(aVar, i2, 5);
        aVar.a((long) i3);
        aVar.a(ByteOrder.BIG_ENDIAN);
        int readInt = aVar.readInt();
        Log.d("ExifInterface:", "numberOfDirectoryEntry: " + readInt);
        for (int i4 = 0; i4 < readInt; i4++) {
            int readUnsignedShort = aVar.readUnsignedShort();
            int readUnsignedShort2 = aVar.readUnsignedShort();
            if (readUnsignedShort == v.f3337a) {
                short readShort = aVar.readShort();
                short readShort2 = aVar.readShort();
                b a2 = b.a((int) readShort, this.S);
                b a3 = b.a((int) readShort2, this.S);
                this.Q[0].put("ImageLength", a2);
                this.Q[0].put("ImageWidth", a3);
                Log.d("ExifInterface:", "Updated to length: " + readShort + ", width: " + readShort2);
                return;
            }
            aVar.skipBytes(readUnsignedShort2);
        }
    }

    private void c(final C0086a aVar) throws IOException {
        String str;
        String str2;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(new MediaDataSource() {

                /* renamed from: a  reason: collision with root package name */
                long f3331a;

                public void close() throws IOException {
                }

                public long getSize() throws IOException {
                    return -1;
                }

                public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
                    if (i2 == 0) {
                        return 0;
                    }
                    if (j < 0) {
                        return -1;
                    }
                    try {
                        if (this.f3331a != j) {
                            if (this.f3331a >= 0 && j >= this.f3331a + ((long) aVar.available())) {
                                return -1;
                            }
                            aVar.a(j);
                            this.f3331a = j;
                        }
                        if (i2 > aVar.available()) {
                            i2 = aVar.available();
                        }
                        int read = aVar.read(bArr, i, i2);
                        if (read >= 0) {
                            this.f3331a += (long) read;
                            return read;
                        }
                    } catch (IOException unused) {
                    }
                    this.f3331a = -1;
                    return -1;
                }
            });
            String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
            String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
            String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
            String str3 = null;
            if ("yes".equals(extractMetadata3)) {
                str3 = mediaMetadataRetriever.extractMetadata(29);
                str2 = mediaMetadataRetriever.extractMetadata(30);
                str = mediaMetadataRetriever.extractMetadata(31);
            } else if ("yes".equals(extractMetadata4)) {
                str3 = mediaMetadataRetriever.extractMetadata(18);
                str2 = mediaMetadataRetriever.extractMetadata(19);
                str = mediaMetadataRetriever.extractMetadata(24);
            } else {
                str2 = null;
                str = null;
            }
            if (str3 != null) {
                this.Q[0].put("ImageWidth", b.a(Integer.parseInt(str3), this.S));
            }
            if (str2 != null) {
                this.Q[0].put("ImageLength", b.a(Integer.parseInt(str2), this.S));
            }
            if (str != null) {
                int i2 = 1;
                int parseInt = Integer.parseInt(str);
                if (parseInt == 90) {
                    i2 = 6;
                } else if (parseInt == 180) {
                    i2 = 3;
                } else if (parseInt == 270) {
                    i2 = 8;
                }
                this.Q[0].put("Orientation", b.a(i2, this.S));
            }
            if (!(extractMetadata == null || extractMetadata2 == null)) {
                int parseInt2 = Integer.parseInt(extractMetadata);
                int parseInt3 = Integer.parseInt(extractMetadata2);
                if (parseInt3 > 6) {
                    aVar.a((long) parseInt2);
                    byte[] bArr = new byte[6];
                    if (aVar.read(bArr) == 6) {
                        int i3 = parseInt3 - 6;
                        if (Arrays.equals(bArr, J)) {
                            byte[] bArr2 = new byte[i3];
                            if (aVar.read(bArr2) == i3) {
                                a(bArr2, 0);
                            } else {
                                throw new IOException("Can't read exif");
                            }
                        } else {
                            throw new IOException("Invalid identifier");
                        }
                    } else {
                        throw new IOException("Can't read identifier");
                    }
                } else {
                    throw new IOException("Invalid exif length");
                }
            }
            Log.d("ExifInterface:", "Heif meta: " + str3 + "x" + str2 + ", rotation " + str);
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    private void d(C0086a aVar) throws IOException {
        a(aVar);
        b bVar = (b) this.Q[1].get("MakerNote");
        if (bVar != null) {
            C0086a aVar2 = new C0086a(bVar.d);
            aVar2.a(this.S);
            byte[] bArr = new byte[e.length];
            aVar2.readFully(bArr);
            aVar2.a(0);
            byte[] bArr2 = new byte[f.length];
            aVar2.readFully(bArr2);
            if (Arrays.equals(bArr, e)) {
                aVar2.a(8);
            } else if (Arrays.equals(bArr2, f)) {
                aVar2.a(12);
            }
            b(aVar2, 6);
            b bVar2 = (b) this.Q[7].get("PreviewImageStart");
            b bVar3 = (b) this.Q[7].get("PreviewImageLength");
            if (!(bVar2 == null || bVar3 == null)) {
                this.Q[5].put("JPEGInterchangeFormat", bVar2);
                this.Q[5].put("JPEGInterchangeFormatLength", bVar3);
            }
            b bVar4 = (b) this.Q[8].get("AspectFrame");
            if (bVar4 != null) {
                int[] iArr = new int[4];
                int[] iArr2 = (int[]) bVar4.d(this.S);
                if (iArr2[2] > iArr2[0] && iArr2[3] > iArr2[1]) {
                    int i2 = (iArr2[2] - iArr2[0]) + 1;
                    int i3 = (iArr2[3] - iArr2[1]) + 1;
                    if (i2 < i3) {
                        int i4 = i2 + i3;
                        i3 = i4 - i3;
                        i2 = i4 - i3;
                    }
                    b a2 = b.a(i2, this.S);
                    b a3 = b.a(i3, this.S);
                    this.Q[0].put("ImageWidth", a2);
                    this.Q[0].put("ImageLength", a3);
                }
            }
        }
    }

    private void e(C0086a aVar) throws IOException {
        a(aVar);
        if (((b) this.Q[0].get("JpgFromRaw")) != null) {
            a(aVar, this.ac, 5);
        }
        b bVar = (b) this.Q[0].get("ISO");
        b bVar2 = (b) this.Q[1].get("ISOSpeedRatings");
        if (bVar != null && bVar2 == null) {
            this.Q[1].put("ISOSpeedRatings", bVar);
        }
    }

    private void a(byte[] bArr, int i2) throws IOException {
        C0086a aVar = new C0086a(bArr);
        a(aVar, bArr.length);
        b(aVar, i2);
    }

    private void g() {
        String a2 = a("DateTimeOriginal");
        if (a2 != null && a("DateTime") == null) {
            this.Q[0].put("DateTime", b.a(a2));
        }
        if (a("ImageWidth") == null) {
            this.Q[0].put("ImageWidth", b.a(0, this.S));
        }
        if (a("ImageLength") == null) {
            this.Q[0].put("ImageLength", b.a(0, this.S));
        }
        if (a("Orientation") == null) {
            this.Q[0].put("Orientation", b.a(0, this.S));
        }
        if (a("LightSource") == null) {
            this.Q[1].put("LightSource", b.a(0, this.S));
        }
    }

    private ByteOrder f(C0086a aVar) throws IOException {
        short readShort = aVar.readShort();
        if (readShort == 18761) {
            Log.d("ExifInterface:", "readExifSegment: Byte Align II");
            return ByteOrder.LITTLE_ENDIAN;
        } else if (readShort == 19789) {
            Log.d("ExifInterface:", "readExifSegment: Byte Align MM");
            return ByteOrder.BIG_ENDIAN;
        } else {
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
    }

    private void a(C0086a aVar, int i2) throws IOException {
        this.S = f(aVar);
        aVar.a(this.S);
        int readUnsignedShort = aVar.readUnsignedShort();
        int i3 = this.P;
        if (i3 == 7 || i3 == 10 || readUnsignedShort == 42) {
            int readInt = aVar.readInt();
            if (readInt < 8 || readInt >= i2) {
                throw new IOException("Invalid first Ifd offset: " + readInt);
            }
            int i4 = readInt - 8;
            if (i4 > 0 && aVar.skipBytes(i4) != i4) {
                throw new IOException("Couldn't jump to first Ifd: " + i4);
            }
            return;
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0156  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(com.oppo.camera.h.a.C0086a r29, int r30) throws java.io.IOException {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            r2 = r30
            java.util.Set<java.lang.Integer> r3 = r0.R
            int r4 = r29.g
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.add(r4)
            int r3 = r29.g
            r4 = 2
            int r3 = r3 + r4
            int r5 = r29.f
            if (r3 <= r5) goto L_0x0020
            return
        L_0x0020:
            short r3 = r29.readShort()
            int r5 = r29.g
            int r6 = r3 * 12
            int r5 = r5 + r6
            int r6 = r29.f
            if (r5 > r6) goto L_0x03eb
            if (r3 > 0) goto L_0x0035
            goto L_0x03eb
        L_0x0035:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "numberOfDirectoryEntry: "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "ExifInterface:"
            android.util.Log.d(r6, r5)
            r5 = -1
            r9 = r5
            r8 = 0
        L_0x004e:
            r14 = 4
            if (r8 >= r3) goto L_0x0365
            int r15 = r29.readUnsignedShort()
            int r11 = r29.readUnsignedShort()
            int r12 = r29.readInt()
            int r18 = r29.a()
            int r4 = r18 + 4
            long r13 = (long) r4
            java.util.HashMap[] r4 = E
            r4 = r4[r2]
            java.lang.Integer r7 = java.lang.Integer.valueOf(r15)
            java.lang.Object r4 = r4.get(r7)
            com.oppo.camera.h.a$c r4 = (com.oppo.camera.h.a.c) r4
            int[] r7 = r0.p
            if (r7 == 0) goto L_0x00a6
            int r10 = r7.length
            if (r10 <= 0) goto L_0x00a6
            int[] r10 = r0.o
            if (r10 != 0) goto L_0x008f
            int r7 = r7.length
            int[] r7 = new int[r7]
            r0.o = r7
            r7 = 0
        L_0x0083:
            int[] r10 = r0.p
            int r10 = r10.length
            if (r7 >= r10) goto L_0x008f
            int[] r10 = r0.o
            r10[r7] = r5
            int r7 = r7 + 1
            goto L_0x0083
        L_0x008f:
            r10 = r9
            r7 = 0
            r9 = 0
        L_0x0092:
            int[] r5 = r0.p
            r23 = r3
            int r3 = r5.length
            if (r7 >= r3) goto L_0x00a4
            r3 = r5[r7]
            if (r3 != r15) goto L_0x009f
            r10 = r7
            r9 = 1
        L_0x009f:
            int r7 = r7 + 1
            r3 = r23
            goto L_0x0092
        L_0x00a4:
            r3 = 5
            goto L_0x00ab
        L_0x00a6:
            r23 = r3
            r10 = r9
            r3 = 5
            r9 = 0
        L_0x00ab:
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r30)
            r7 = 0
            r3[r7] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r15)
            r7 = 1
            r3[r7] = r5
            if (r4 == 0) goto L_0x00c0
            java.lang.String r5 = r4.f3338b
            goto L_0x00c1
        L_0x00c0:
            r5 = 0
        L_0x00c1:
            r7 = 2
            r3[r7] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)
            r7 = 3
            r3[r7] = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r12)
            r19 = 4
            r3[r19] = r5
            java.lang.String r5 = "ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d"
            java.lang.String r3 = java.lang.String.format(r5, r3)
            android.util.Log.d(r6, r3)
            if (r4 != 0) goto L_0x00f8
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Skip the tag entry since tag number is not defined: "
            r3.append(r5)
            r3.append(r15)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r6, r3)
            r5 = r8
            r20 = r9
            r24 = r10
            goto L_0x0149
        L_0x00f8:
            if (r11 <= 0) goto L_0x0130
            int[] r3 = j
            int r5 = r3.length
            if (r11 < r5) goto L_0x0100
            goto L_0x0130
        L_0x0100:
            r5 = r8
            long r7 = (long) r12
            r3 = r3[r11]
            r20 = r9
            r24 = r10
            long r9 = (long) r3
            long r7 = r7 * r9
            r9 = 0
            int r3 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r3 < 0) goto L_0x011a
            r9 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r3 <= 0) goto L_0x0118
            goto L_0x011a
        L_0x0118:
            r3 = 1
            goto L_0x014c
        L_0x011a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r9 = "Skip the tag entry since the number of components is invalid: "
            r3.append(r9)
            r3.append(r12)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r6, r3)
            r3 = 0
            goto L_0x014c
        L_0x0130:
            r5 = r8
            r20 = r9
            r24 = r10
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r7 = "Skip the tag entry since data format is invalid: "
            r3.append(r7)
            r3.append(r11)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r6, r3)
        L_0x0149:
            r3 = 0
            r7 = 0
        L_0x014c:
            if (r3 != 0) goto L_0x0156
            r1.a((long) r13)
            r25 = r5
        L_0x0153:
            r11 = 2
            goto L_0x0358
        L_0x0156:
            r9 = 4
            int r3 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            java.lang.String r9 = "Compression"
            if (r3 <= 0) goto L_0x020a
            int r3 = r29.readInt()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r25 = r5
            java.lang.String r5 = "seek to data offset: "
            r10.append(r5)
            r10.append(r3)
            java.lang.String r5 = r10.toString()
            android.util.Log.d(r6, r5)
            int r5 = r0.P
            r10 = 7
            if (r5 != r10) goto L_0x01d0
            java.lang.String r5 = r4.f3338b
            java.lang.String r10 = "MakerNote"
            if (r5 != r10) goto L_0x0186
            r0.Z = r3
            goto L_0x01cb
        L_0x0186:
            r5 = 6
            if (r2 != r5) goto L_0x01cb
            java.lang.String r10 = r4.f3338b
            java.lang.String r5 = "ThumbnailImage"
            if (r10 != r5) goto L_0x01cb
            r0.aa = r3
            r0.ab = r12
            java.nio.ByteOrder r5 = r0.S
            r10 = 6
            com.oppo.camera.h.a$b r5 = com.oppo.camera.h.a.b.a((int) r10, (java.nio.ByteOrder) r5)
            int r10 = r0.aa
            r21 = r11
            long r10 = (long) r10
            java.nio.ByteOrder r2 = r0.S
            com.oppo.camera.h.a$b r2 = com.oppo.camera.h.a.b.a((long) r10, (java.nio.ByteOrder) r2)
            int r10 = r0.ab
            long r10 = (long) r10
            r22 = r12
            java.nio.ByteOrder r12 = r0.S
            com.oppo.camera.h.a$b r10 = com.oppo.camera.h.a.b.a((long) r10, (java.nio.ByteOrder) r12)
            java.util.HashMap[] r11 = r0.Q
            r12 = 4
            r11 = r11[r12]
            r11.put(r9, r5)
            java.util.HashMap[] r5 = r0.Q
            r5 = r5[r12]
            java.lang.String r11 = "JPEGInterchangeFormat"
            r5.put(r11, r2)
            java.util.HashMap[] r2 = r0.Q
            r2 = r2[r12]
            java.lang.String r5 = "JPEGInterchangeFormatLength"
            r2.put(r5, r10)
            goto L_0x01e0
        L_0x01cb:
            r21 = r11
            r22 = r12
            goto L_0x01e0
        L_0x01d0:
            r21 = r11
            r22 = r12
            r2 = 10
            if (r5 != r2) goto L_0x01e0
            java.lang.String r2 = r4.f3338b
            java.lang.String r5 = "JpgFromRaw"
            if (r2 != r5) goto L_0x01e0
            r0.ac = r3
        L_0x01e0:
            long r10 = (long) r3
            long r26 = r10 + r7
            int r2 = r29.f
            r12 = r4
            long r4 = (long) r2
            int r2 = (r26 > r4 ? 1 : (r26 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x01f1
            r1.a((long) r10)
            goto L_0x0211
        L_0x01f1:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Skip the tag entry since data offset is invalid: "
            r2.append(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r6, r2)
            r1.a((long) r13)
            goto L_0x0153
        L_0x020a:
            r25 = r5
            r21 = r11
            r22 = r12
            r12 = r4
        L_0x0211:
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r2 = H
            java.lang.Integer r3 = java.lang.Integer.valueOf(r15)
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "nextIfdType: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r4 = " byteCount: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r6, r3)
            r3 = 8
            if (r2 == 0) goto L_0x02e1
            r4 = -1
            r10 = r21
            r7 = 3
            if (r10 == r7) goto L_0x0262
            r7 = 4
            if (r10 == r7) goto L_0x025d
            if (r10 == r3) goto L_0x0258
            r3 = 9
            if (r10 == r3) goto L_0x0253
            r3 = 13
            if (r10 == r3) goto L_0x0253
        L_0x0251:
            r11 = 2
            goto L_0x0268
        L_0x0253:
            int r3 = r29.readInt()
            goto L_0x0266
        L_0x0258:
            short r3 = r29.readShort()
            goto L_0x0266
        L_0x025d:
            long r4 = r29.b()
            goto L_0x0251
        L_0x0262:
            int r3 = r29.readUnsignedShort()
        L_0x0266:
            long r4 = (long) r3
            goto L_0x0251
        L_0x0268:
            java.lang.Object[] r3 = new java.lang.Object[r11]
            java.lang.Long r7 = java.lang.Long.valueOf(r4)
            r8 = 0
            r3[r8] = r7
            java.lang.String r7 = r12.f3338b
            r8 = 1
            r3[r8] = r7
            java.lang.String r7 = "Offset: %d, tagName: %s"
            java.lang.String r3 = java.lang.String.format(r7, r3)
            android.util.Log.d(r6, r3)
            r7 = 0
            int r3 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r3 <= 0) goto L_0x02c8
            int r3 = r29.f
            long r7 = (long) r3
            int r3 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r3 >= 0) goto L_0x02c8
            java.util.Set<java.lang.Integer> r3 = r0.R
            int r7 = (int) r4
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            boolean r3 = r3.contains(r7)
            if (r3 != 0) goto L_0x02a6
            r1.a((long) r4)
            int r2 = r2.intValue()
            r0.b((com.oppo.camera.h.a.C0086a) r1, (int) r2)
            goto L_0x02dc
        L_0x02a6:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r7 = "Skip jump into the IFD since it has already been read: IfdType "
            r3.append(r7)
            r3.append(r2)
            java.lang.String r2 = " (at "
            r3.append(r2)
            r3.append(r4)
            java.lang.String r2 = ")"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            android.util.Log.d(r6, r2)
            goto L_0x02dc
        L_0x02c8:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Skip jump into the IFD since its offset is invalid: "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r6, r2)
        L_0x02dc:
            r1.a((long) r13)
            goto L_0x0358
        L_0x02e1:
            r10 = r21
            r11 = 2
            int r2 = r29.a()
            if (r20 == 0) goto L_0x02ee
            int[] r4 = r0.o
            r4[r24] = r2
        L_0x02ee:
            int r4 = (int) r7
            byte[] r4 = new byte[r4]
            r1.readFully(r4)
            com.oppo.camera.h.a$b r5 = new com.oppo.camera.h.a$b
            long r7 = (long) r2
            r2 = 0
            r16 = r5
            r17 = r10
            r18 = r22
            r19 = r7
            r21 = r4
            r22 = r2
            r16.<init>(r17, r18, r19, r21)
            java.util.HashMap[] r2 = r0.Q
            r2 = r2[r30]
            java.lang.String r4 = r12.f3338b
            r2.put(r4, r5)
            java.lang.String r2 = r12.f3338b
            java.lang.String r4 = "DNGVersion"
            if (r2 != r4) goto L_0x0319
            r2 = 3
            r0.P = r2
        L_0x0319:
            java.lang.String r2 = r12.f3338b
            java.lang.String r4 = "Make"
            if (r2 == r4) goto L_0x0325
            java.lang.String r2 = r12.f3338b
            java.lang.String r4 = "Model"
            if (r2 != r4) goto L_0x033b
        L_0x0325:
            java.nio.ByteOrder r2 = r0.S
            java.lang.String r2 = r5.c(r2)
            if (r2 == 0) goto L_0x033b
            java.nio.ByteOrder r2 = r0.S
            java.lang.String r2 = r5.c(r2)
            java.lang.String r4 = "PENTAX"
            boolean r2 = r2.contains(r4)
            if (r2 != 0) goto L_0x034a
        L_0x033b:
            java.lang.String r2 = r12.f3338b
            if (r2 != r9) goto L_0x034c
            java.nio.ByteOrder r2 = r0.S
            int r2 = r5.b(r2)
            r4 = 65535(0xffff, float:9.1834E-41)
            if (r2 != r4) goto L_0x034c
        L_0x034a:
            r0.P = r3
        L_0x034c:
            int r2 = r29.a()
            long r2 = (long) r2
            int r2 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r2 == 0) goto L_0x0358
            r1.a((long) r13)
        L_0x0358:
            int r8 = r25 + 1
            short r8 = (short) r8
            r2 = r30
            r4 = r11
            r3 = r23
            r9 = r24
            r5 = -1
            goto L_0x004e
        L_0x0365:
            int r2 = r29.a()
            r3 = 4
            int r2 = r2 + r3
            int r3 = r29.f
            if (r2 > r3) goto L_0x03eb
            int r2 = r29.readInt()
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            r5 = 0
            r3[r5] = r4
            java.lang.String r4 = "nextIfdOffset: %d"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            android.util.Log.d(r6, r3)
            long r3 = (long) r2
            r7 = 0
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x03d7
            int r5 = r29.f
            if (r2 >= r5) goto L_0x03d7
            java.util.Set<java.lang.Integer> r5 = r0.R
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)
            boolean r5 = r5.contains(r7)
            if (r5 != 0) goto L_0x03c2
            r1.a((long) r3)
            java.util.HashMap[] r2 = r0.Q
            r3 = 4
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x03b3
            r0.b((com.oppo.camera.h.a.C0086a) r1, (int) r3)
            goto L_0x03eb
        L_0x03b3:
            java.util.HashMap[] r2 = r0.Q
            r3 = 5
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x03eb
            r0.b((com.oppo.camera.h.a.C0086a) r1, (int) r3)
            goto L_0x03eb
        L_0x03c2:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since re-reading an IFD may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r6, r1)
            goto L_0x03eb
        L_0x03d7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since a wrong offset may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r6, r1)
        L_0x03eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.h.a.b(com.oppo.camera.h.a$a, int):void");
    }

    private void c(C0086a aVar, int i2) throws IOException {
        b bVar;
        b bVar2 = (b) this.Q[i2].get("ImageLength");
        b bVar3 = (b) this.Q[i2].get("ImageWidth");
        if ((bVar2 == null || bVar3 == null) && (bVar = (b) this.Q[i2].get("JPEGInterchangeFormat")) != null) {
            a(aVar, bVar.b(this.S), i2);
        }
    }

    private void g(C0086a aVar) throws IOException {
        HashMap hashMap = this.Q[4];
        b bVar = (b) hashMap.get("Compression");
        if (bVar != null) {
            this.X = bVar.b(this.S);
            int i2 = this.X;
            if (i2 != 1) {
                if (i2 == 6) {
                    a(aVar, hashMap);
                    return;
                } else if (i2 != 7) {
                    return;
                }
            }
            if (a(hashMap)) {
                b(aVar, hashMap);
                return;
            }
            return;
        }
        a(aVar, hashMap);
    }

    private void a(C0086a aVar, HashMap hashMap) throws IOException {
        int i2;
        b bVar = (b) hashMap.get("JPEGInterchangeFormat");
        b bVar2 = (b) hashMap.get("JPEGInterchangeFormatLength");
        if (bVar != null && bVar2 != null) {
            int b2 = bVar.b(this.S);
            int min = Math.min(bVar2.b(this.S), aVar.c() - b2);
            int i3 = this.P;
            if (i3 == 4 || i3 == 9 || i3 == 10) {
                i2 = this.Y;
            } else {
                if (i3 == 7) {
                    i2 = this.Z;
                }
                Log.d("ExifInterface:", "Setting thumbnail attributes with offset: " + b2 + ", length: " + min);
                if (b2 > 0 && min > 0) {
                    this.T = true;
                    this.U = b2;
                    this.V = min;
                    this.X = 6;
                    if (this.L == null && this.N == null && this.M == null) {
                        byte[] bArr = new byte[min];
                        aVar.a((long) b2);
                        aVar.readFully(bArr);
                        this.W = bArr;
                        return;
                    }
                    return;
                }
            }
            b2 += i2;
            Log.d("ExifInterface:", "Setting thumbnail attributes with offset: " + b2 + ", length: " + min);
            if (b2 > 0) {
            }
        }
    }

    private void b(C0086a aVar, HashMap hashMap) throws IOException {
        b bVar = (b) hashMap.get("StripOffsets");
        b bVar2 = (b) hashMap.get("StripByteCounts");
        if (bVar != null && bVar2 != null) {
            long[] a2 = a(bVar.d(this.S));
            long[] a3 = a(bVar2.d(this.S));
            if (a2 == null) {
                Log.w("ExifInterface:", "stripOffsets should not be null.");
            } else if (a3 == null) {
                Log.w("ExifInterface:", "stripByteCounts should not be null.");
            } else {
                byte[] bArr = new byte[((int) Arrays.stream(a3).sum())];
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < a2.length; i4++) {
                    int i5 = (int) a3[i4];
                    int i6 = ((int) a2[i4]) - i2;
                    if (i6 < 0) {
                        Log.d("ExifInterface:", "Invalid strip offset value");
                    }
                    aVar.a((long) i6);
                    int i7 = i2 + i6;
                    byte[] bArr2 = new byte[i5];
                    int read = aVar.read(bArr2);
                    if (read <= 0) {
                        e.d("ExifInterface:", "handleThumbnailFromStrips, in.read(stripBytes): " + read);
                    }
                    i2 = i7 + i5;
                    System.arraycopy(bArr2, 0, bArr, i3, bArr2.length);
                    i3 += bArr2.length;
                }
                this.T = true;
                this.W = bArr;
                this.V = bArr.length;
            }
        }
    }

    private boolean a(HashMap hashMap) throws IOException {
        b bVar;
        int b2;
        b bVar2 = (b) hashMap.get("BitsPerSample");
        if (bVar2 != null) {
            int[] iArr = (int[]) bVar2.d(this.S);
            if (Arrays.equals(l, iArr)) {
                return true;
            }
            if (this.P == 3 && (bVar = (b) hashMap.get("PhotometricInterpretation")) != null && (((b2 = bVar.b(this.S)) == 1 && Arrays.equals(iArr, n)) || (b2 == 6 && Arrays.equals(iArr, l)))) {
                return true;
            }
        }
        Log.d("ExifInterface:", "Unsupported data type value");
        return false;
    }

    private boolean b(HashMap hashMap) throws IOException {
        b bVar = (b) hashMap.get("ImageLength");
        b bVar2 = (b) hashMap.get("ImageWidth");
        if (bVar == null || bVar2 == null) {
            return false;
        }
        return bVar.b(this.S) <= 512 && bVar2.b(this.S) <= 512;
    }

    private void b(InputStream inputStream) throws IOException {
        a(0, 5);
        a(0, 4);
        a(5, 4);
        b bVar = (b) this.Q[1].get("PixelXDimension");
        b bVar2 = (b) this.Q[1].get("PixelYDimension");
        if (!(bVar == null || bVar2 == null)) {
            this.Q[0].put("ImageWidth", bVar);
            this.Q[0].put("ImageLength", bVar2);
        }
        if (this.Q[4].isEmpty() && b(this.Q[5])) {
            HashMap[] hashMapArr = this.Q;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap();
        }
        if (!b(this.Q[4])) {
            Log.d("ExifInterface:", "No image meets the size requirements of a thumbnail image.");
        }
    }

    private void d(C0086a aVar, int i2) throws IOException {
        b bVar;
        b bVar2;
        b bVar3 = (b) this.Q[i2].get("DefaultCropSize");
        b bVar4 = (b) this.Q[i2].get("SensorTopBorder");
        b bVar5 = (b) this.Q[i2].get("SensorLeftBorder");
        b bVar6 = (b) this.Q[i2].get("SensorBottomBorder");
        b bVar7 = (b) this.Q[i2].get("SensorRightBorder");
        if (bVar3 != null) {
            if (bVar3.f3335a == 5) {
                d[] dVarArr = (d[]) bVar3.d(this.S);
                bVar2 = b.a(dVarArr[0], this.S);
                bVar = b.a(dVarArr[1], this.S);
            } else {
                int[] iArr = (int[]) bVar3.d(this.S);
                bVar2 = b.a(iArr[0], this.S);
                bVar = b.a(iArr[1], this.S);
            }
            this.Q[i2].put("ImageWidth", bVar2);
            this.Q[i2].put("ImageLength", bVar);
        } else if (bVar4 == null || bVar5 == null || bVar6 == null || bVar7 == null) {
            c(aVar, i2);
        } else {
            int b2 = bVar4.b(this.S);
            int b3 = bVar6.b(this.S);
            int b4 = bVar7.b(this.S);
            int b5 = bVar5.b(this.S);
            if (b3 > b2 && b4 > b5) {
                b a2 = b.a(b3 - b2, this.S);
                b a3 = b.a(b4 - b5, this.S);
                this.Q[i2].put("ImageLength", a2);
                this.Q[i2].put("ImageWidth", a3);
            }
        }
    }

    /* renamed from: com.oppo.camera.h.a$a  reason: collision with other inner class name */
    /* compiled from: CameraExifInterface */
    private static class C0086a extends InputStream implements DataInput {

        /* renamed from: a  reason: collision with root package name */
        private static final ByteOrder f3333a = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: b  reason: collision with root package name */
        private static final ByteOrder f3334b = ByteOrder.BIG_ENDIAN;
        private DataInputStream c;
        private InputStream d;
        private ByteOrder e;
        /* access modifiers changed from: private */
        public final int f;
        /* access modifiers changed from: private */
        public int g;

        public C0086a(InputStream inputStream) throws IOException {
            this.e = ByteOrder.BIG_ENDIAN;
            this.d = inputStream;
            this.c = new DataInputStream(inputStream);
            this.f = this.c.available();
            this.g = 0;
            this.c.mark(this.f);
        }

        public C0086a(byte[] bArr) throws IOException {
            this((InputStream) new ByteArrayInputStream(bArr));
        }

        public void a(ByteOrder byteOrder) {
            this.e = byteOrder;
        }

        public void a(long j) throws IOException {
            int i = this.g;
            if (((long) i) > j) {
                this.g = 0;
                this.c.reset();
                this.c.mark(this.f);
            } else {
                j -= (long) i;
            }
            int i2 = (int) j;
            if (skipBytes(i2) != i2) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public int a() {
            return this.g;
        }

        public int available() throws IOException {
            return this.c.available();
        }

        public int read() throws IOException {
            this.g++;
            return this.c.read();
        }

        public int readUnsignedByte() throws IOException {
            this.g++;
            return this.c.readUnsignedByte();
        }

        public String readLine() throws IOException {
            Log.d("ExifInterface:", "Currently unsupported");
            return null;
        }

        public boolean readBoolean() throws IOException {
            this.g++;
            return this.c.readBoolean();
        }

        public char readChar() throws IOException {
            this.g += 2;
            return this.c.readChar();
        }

        public String readUTF() throws IOException {
            this.g += 2;
            return this.c.readUTF();
        }

        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            this.g += i2;
            if (this.g > this.f) {
                throw new EOFException();
            } else if (this.c.read(bArr, i, i2) != i2) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public void readFully(byte[] bArr) throws IOException {
            this.g += bArr.length;
            if (this.g > this.f) {
                throw new EOFException();
            } else if (this.c.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        public byte readByte() throws IOException {
            this.g++;
            if (this.g <= this.f) {
                int read = this.c.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public short readShort() throws IOException {
            this.g += 2;
            if (this.g <= this.f) {
                int read = this.c.read();
                int read2 = this.c.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.e;
                    if (byteOrder == f3333a) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == f3334b) {
                        return (short) ((read << 8) + read2);
                    }
                    throw new IOException("Invalid byte order: " + this.e);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public int readInt() throws IOException {
            this.g += 4;
            if (this.g <= this.f) {
                int read = this.c.read();
                int read2 = this.c.read();
                int read3 = this.c.read();
                int read4 = this.c.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.e;
                    if (byteOrder == f3333a) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == f3334b) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    throw new IOException("Invalid byte order: " + this.e);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public int skipBytes(int i) throws IOException {
            int min = Math.min(i, this.f - this.g);
            int i2 = 0;
            while (i2 < min) {
                i2 += this.c.skipBytes(min - i2);
            }
            this.g += i2;
            return i2;
        }

        public int readUnsignedShort() throws IOException {
            this.g += 2;
            if (this.g <= this.f) {
                int read = this.c.read();
                int read2 = this.c.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.e;
                    if (byteOrder == f3333a) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == f3334b) {
                        return (read << 8) + read2;
                    }
                    throw new IOException("Invalid byte order: " + this.e);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public long b() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        public long readLong() throws IOException {
            this.g += 8;
            if (this.g <= this.f) {
                int read = this.c.read();
                int read2 = this.c.read();
                int read3 = this.c.read();
                int read4 = this.c.read();
                int read5 = this.c.read();
                int read6 = this.c.read();
                int read7 = this.c.read();
                int read8 = this.c.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.e;
                    if (byteOrder == f3333a) {
                        return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                    }
                    int i = read2;
                    if (byteOrder == f3334b) {
                        return (((long) read) << 56) + (((long) i) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                    }
                    throw new IOException("Invalid byte order: " + this.e);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        public int c() {
            return this.f;
        }
    }

    private void a(int i2, int i3) throws IOException {
        if (this.Q[i2].isEmpty() || this.Q[i3].isEmpty()) {
            Log.d("ExifInterface:", "Cannot perform swap since only one image data exists");
            return;
        }
        b bVar = (b) this.Q[i2].get("ImageLength");
        b bVar2 = (b) this.Q[i2].get("ImageWidth");
        b bVar3 = (b) this.Q[i3].get("ImageLength");
        b bVar4 = (b) this.Q[i3].get("ImageWidth");
        if (bVar == null || bVar2 == null) {
            Log.d("ExifInterface:", "First image does not contain valid size information");
        } else if (bVar3 == null || bVar4 == null) {
            Log.d("ExifInterface:", "Second image does not contain valid size information");
        } else {
            int b2 = bVar.b(this.S);
            int b3 = bVar2.b(this.S);
            int b4 = bVar3.b(this.S);
            int b5 = bVar4.b(this.S);
            if (b2 < b4 && b3 < b5) {
                HashMap[] hashMapArr = this.Q;
                HashMap hashMap = hashMapArr[i2];
                hashMapArr[i2] = hashMapArr[i3];
                hashMapArr[i3] = hashMap;
            }
        }
    }

    private static long[] a(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jArr[i2] = (long) iArr[i2];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }

    public static void a(byte[] bArr, long j2) {
        try {
            int[] a2 = new a(new ByteArrayInputStream(bArr), new int[]{36867, 37521, 36881}).a();
            ZonedDateTime ofInstant = ZonedDateTime.ofInstant(Instant.ofEpochMilli(j2), ZoneId.systemDefault());
            if (a2[0] > 0) {
                byte[] bytes = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss").format(ofInstant).getBytes();
                System.arraycopy(bytes, 0, bArr, a2[0], bytes.length);
            }
            if (a2[1] > 0) {
                byte[] bytes2 = ("000" + DateTimeFormatter.ofPattern("SSS").format(ofInstant) + "\u0000").getBytes();
                System.arraycopy(bytes2, 0, bArr, a2[1], bytes2.length);
            }
            if (a2[2] > 0) {
                String format = DateTimeFormatter.ofPattern("XXX").format(ofInstant);
                byte[] bytes3 = (format + "\u0000").getBytes();
                System.arraycopy(bytes3, 0, bArr, a2[2], bytes3.length);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
