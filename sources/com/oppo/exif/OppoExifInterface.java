package com.oppo.exif;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.SparseIntArray;
import com.meicam.sdk.NvsMediaFileConvertor;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public class OppoExifInterface {
    private static final String DATETIME_FORMAT_STR = "yyyy:MM:dd HH:mm:ss";
    public static final ByteOrder DEFAULT_BYTE_ORDER = ByteOrder.BIG_ENDIAN;
    public static final int DEFINITION_NULL = 0;
    private static final String GPS_DATE_FORMAT_STR = "yyyy:MM:dd";
    public static final int IFD_NULL = -1;
    private static final String NULL_ARGUMENT_STRING = "Argument is null";
    public static final int TAG_APERTURE_VALUE = defineTag(2, -28158);
    public static final int TAG_ARTIST = defineTag(0, 315);
    public static final int TAG_BITS_PER_SAMPLE = defineTag(0, 258);
    public static final int TAG_BRIGHTNESS_VALUE = defineTag(2, -28157);
    public static final int TAG_CFA_PATTERN = defineTag(2, -23806);
    public static final int TAG_COLOR_SPACE = defineTag(2, -24575);
    public static final int TAG_COMPONENTS_CONFIGURATION = defineTag(2, -28415);
    public static final int TAG_COMPRESSED_BITS_PER_PIXEL = defineTag(2, -28414);
    public static final int TAG_COMPRESSION = defineTag(0, 259);
    public static final int TAG_CONTRAST = defineTag(2, -23544);
    public static final int TAG_COPYRIGHT = defineTag(0, -32104);
    public static final int TAG_CUSTOM_RENDERED = defineTag(2, -23551);
    public static final int TAG_DATE_TIME = defineTag(0, 306);
    public static final int TAG_DATE_TIME_DIGITIZED = defineTag(2, -28668);
    public static final int TAG_DATE_TIME_ORIGINAL = defineTag(2, -28669);
    public static final int TAG_DEVICE_SETTING_DESCRIPTION = defineTag(2, -23541);
    public static final int TAG_DIGITAL_ZOOM_RATIO = defineTag(2, -23548);
    public static final int TAG_EXIF_IFD = defineTag(0, -30871);
    public static final int TAG_EXIF_VERSION = defineTag(2, -28672);
    public static final int TAG_EXPOSURE_BIAS_VALUE = defineTag(2, -28156);
    public static final int TAG_EXPOSURE_INDEX = defineTag(2, -24043);
    public static final int TAG_EXPOSURE_MODE = defineTag(2, -23550);
    public static final int TAG_EXPOSURE_PROGRAM = defineTag(2, -30686);
    public static final int TAG_EXPOSURE_TIME = defineTag(2, -32102);
    public static final int TAG_FILE_SOURCE = defineTag(2, -23808);
    public static final int TAG_FLASH = defineTag(2, -28151);
    public static final int TAG_FLASHPIX_VERSION = defineTag(2, -24576);
    public static final int TAG_FLASH_ENERGY = defineTag(2, -24053);
    public static final int TAG_FOCAL_LENGTH = defineTag(2, -28150);
    public static final int TAG_FOCAL_LENGTH_IN_35_MM_FILE = defineTag(2, -23547);
    public static final int TAG_FOCAL_PLANE_RESOLUTION_UNIT = defineTag(2, -24048);
    public static final int TAG_FOCAL_PLANE_X_RESOLUTION = defineTag(2, -24050);
    public static final int TAG_FOCAL_PLANE_Y_RESOLUTION = defineTag(2, -24049);
    public static final int TAG_F_NUMBER = defineTag(2, -32099);
    public static final int TAG_GAIN_CONTROL = defineTag(2, -23545);
    public static final int TAG_GPS_ALTITUDE = defineTag(4, 6);
    public static final int TAG_GPS_ALTITUDE_REF = defineTag(4, 5);
    public static final int TAG_GPS_AREA_INFORMATION = defineTag(4, 28);
    public static final int TAG_GPS_DATE_STAMP = defineTag(4, 29);
    public static final int TAG_GPS_DEST_BEARING = defineTag(4, 24);
    public static final int TAG_GPS_DEST_BEARING_REF = defineTag(4, 23);
    public static final int TAG_GPS_DEST_DISTANCE = defineTag(4, 26);
    public static final int TAG_GPS_DEST_DISTANCE_REF = defineTag(4, 25);
    public static final int TAG_GPS_DEST_LATITUDE = defineTag(4, 20);
    public static final int TAG_GPS_DEST_LATITUDE_REF = defineTag(4, 19);
    public static final int TAG_GPS_DEST_LONGITUDE = defineTag(4, 22);
    public static final int TAG_GPS_DEST_LONGITUDE_REF = defineTag(4, 21);
    public static final int TAG_GPS_DIFFERENTIAL = defineTag(4, 30);
    public static final int TAG_GPS_DOP = defineTag(4, 11);
    public static final int TAG_GPS_IFD = defineTag(0, -30683);
    public static final int TAG_GPS_IMG_DIRECTION = defineTag(4, 17);
    public static final int TAG_GPS_IMG_DIRECTION_REF = defineTag(4, 16);
    public static final int TAG_GPS_LATITUDE = defineTag(4, 2);
    public static final int TAG_GPS_LATITUDE_REF = defineTag(4, 1);
    public static final int TAG_GPS_LONGITUDE = defineTag(4, 4);
    public static final int TAG_GPS_LONGITUDE_REF = defineTag(4, 3);
    public static final int TAG_GPS_MAP_DATUM = defineTag(4, 18);
    public static final int TAG_GPS_MEASURE_MODE = defineTag(4, 10);
    public static final int TAG_GPS_PROCESSING_METHOD = defineTag(4, 27);
    public static final int TAG_GPS_SATTELLITES = defineTag(4, 8);
    public static final int TAG_GPS_SPEED = defineTag(4, 13);
    public static final int TAG_GPS_SPEED_REF = defineTag(4, 12);
    public static final int TAG_GPS_STATUS = defineTag(4, 9);
    public static final int TAG_GPS_TIME_STAMP = defineTag(4, 7);
    public static final int TAG_GPS_TRACK = defineTag(4, 15);
    public static final int TAG_GPS_TRACK_REF = defineTag(4, 14);
    public static final int TAG_GPS_VERSION_ID = defineTag(4, 0);
    public static final int TAG_IMAGE_DESCRIPTION = defineTag(0, 270);
    public static final int TAG_IMAGE_LENGTH = defineTag(0, 257);
    public static final int TAG_IMAGE_UNIQUE_ID = defineTag(2, -23520);
    public static final int TAG_IMAGE_WIDTH = defineTag(0, 256);
    public static final int TAG_INTEROPERABILITY_IFD = defineTag(2, -24571);
    public static final int TAG_INTEROPERABILITY_INDEX = defineTag(3, 1);
    public static final int TAG_ISO_SPEED_RATINGS = defineTag(2, -30681);
    public static final int TAG_JPEG_INTERCHANGE_FORMAT = defineTag(1, 513);
    public static final int TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = defineTag(1, 514);
    public static final int TAG_LIGHT_SOURCE = defineTag(2, -28152);
    public static final int TAG_MAKE = defineTag(0, 271);
    public static final int TAG_MAKER_NOTE = defineTag(2, -28036);
    public static final int TAG_MAX_APERTURE_VALUE = defineTag(2, -28155);
    public static final int TAG_METERING_MODE = defineTag(2, -28153);
    public static final int TAG_MODEL = defineTag(0, 272);
    public static final int TAG_NULL = -1;
    public static final int TAG_OECF = defineTag(2, -30680);
    public static final int TAG_OFFSET_TIME_ORIGINAL = defineTag(2, -28655);
    public static final int TAG_ORIENTATION = defineTag(0, 274);
    public static final int TAG_PHOTOMETRIC_INTERPRETATION = defineTag(0, 262);
    public static final int TAG_PIXEL_X_DIMENSION = defineTag(2, -24574);
    public static final int TAG_PIXEL_Y_DIMENSION = defineTag(2, -24573);
    public static final int TAG_PLANAR_CONFIGURATION = defineTag(0, 284);
    public static final int TAG_PRIMARY_CHROMATICITIES = defineTag(0, 319);
    public static final int TAG_REFERENCE_BLACK_WHITE = defineTag(0, 532);
    public static final int TAG_RELATED_SOUND_FILE = defineTag(2, -24572);
    public static final int TAG_RESOLUTION_UNIT = defineTag(0, 296);
    public static final int TAG_ROWS_PER_STRIP = defineTag(0, 278);
    public static final int TAG_SAMPLES_PER_PIXEL = defineTag(0, 277);
    public static final int TAG_SATURATION = defineTag(2, -23543);
    public static final int TAG_SCENE_CAPTURE_TYPE = defineTag(2, -23546);
    public static final int TAG_SCENE_TYPE = defineTag(2, -23807);
    public static final int TAG_SENSING_METHOD = defineTag(2, -24041);
    public static final int TAG_SHARPNESS = defineTag(2, -23542);
    public static final int TAG_SHUTTER_SPEED_VALUE = defineTag(2, -28159);
    public static final int TAG_SOFTWARE = defineTag(0, 305);
    public static final int TAG_SPATIAL_FREQUENCY_RESPONSE = defineTag(2, -24052);
    public static final int TAG_SPECTRAL_SENSITIVITY = defineTag(2, -30684);
    public static final int TAG_STRIP_BYTE_COUNTS = defineTag(0, 279);
    public static final int TAG_STRIP_OFFSETS = defineTag(0, 273);
    public static final int TAG_SUBJECT_AREA = defineTag(2, -28140);
    public static final int TAG_SUBJECT_DISTANCE = defineTag(2, -28154);
    public static final int TAG_SUBJECT_DISTANCE_RANGE = defineTag(2, -23540);
    public static final int TAG_SUBJECT_LOCATION = defineTag(2, -24044);
    public static final int TAG_SUB_SEC_TIME = defineTag(2, -28016);
    public static final int TAG_SUB_SEC_TIME_DIGITIZED = defineTag(2, -28014);
    public static final int TAG_SUB_SEC_TIME_ORIGINAL = defineTag(2, -28015);
    public static final int TAG_TRANSFER_FUNCTION = defineTag(0, 301);
    public static final int TAG_USER_COMMENT = defineTag(2, -28026);
    public static final int TAG_WHITE_BALANCE = defineTag(2, -23549);
    public static final int TAG_WHITE_POINT = defineTag(0, 318);
    public static final int TAG_X_RESOLUTION = defineTag(0, 282);
    public static final int TAG_Y_CB_CR_COEFFICIENTS = defineTag(0, 529);
    public static final int TAG_Y_CB_CR_POSITIONING = defineTag(0, 531);
    public static final int TAG_Y_CB_CR_SUB_SAMPLING = defineTag(0, 530);
    public static final int TAG_Y_RESOLUTION = defineTag(0, 283);
    protected static final HashSet<Short> sBannedDefines = new HashSet<>(sOffsetTags);
    private static HashSet<Short> sOffsetTags = new HashSet<>();
    private OppoExifData mData = new OppoExifData(DEFAULT_BYTE_ORDER);
    private final DateFormat mDateTimeStampFormat = new SimpleDateFormat(DATETIME_FORMAT_STR);
    private final DateFormat mGPSDateStampFormat = new SimpleDateFormat(GPS_DATE_FORMAT_STR);
    private final Calendar mGPSTimeStampCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    private SparseIntArray mTagInfo = null;

    public interface ColorSpace {
        public static final short SRGB = 1;
        public static final short UNCALIBRATED = -1;
    }

    public interface ComponentsConfiguration {
        public static final short B = 6;
        public static final short CB = 2;
        public static final short CR = 3;
        public static final short G = 5;
        public static final short NOT_EXIST = 0;
        public static final short R = 4;
        public static final short Y = 1;
    }

    public interface Compression {
        public static final short JPEG = 6;
        public static final short UNCOMPRESSION = 1;
    }

    public interface Contrast {
        public static final short HARD = 2;
        public static final short NORMAL = 0;
        public static final short SOFT = 1;
    }

    public interface ExposureMode {
        public static final short AUTO_BRACKET = 2;
        public static final short AUTO_EXPOSURE = 0;
        public static final short MANUAL_EXPOSURE = 1;
    }

    public interface ExposureProgram {
        public static final short ACTION_PROGRAM = 6;
        public static final short APERTURE_PRIORITY = 3;
        public static final short CREATIVE_PROGRAM = 5;
        public static final short LANDSCAPE_MODE = 8;
        public static final short MANUAL = 1;
        public static final short NORMAL_PROGRAM = 2;
        public static final short NOT_DEFINED = 0;
        public static final short PROTRAIT_MODE = 7;
        public static final short SHUTTER_PRIORITY = 4;
    }

    public interface FileSource {
        public static final short DSC = 3;
    }

    public interface Flash {
        public static final short DID_NOT_FIRED = 0;
        public static final short FIRED = 1;
        public static final short FUNCTION_NO_FUNCTION = 32;
        public static final short FUNCTION_PRESENT = 0;
        public static final short MODE_AUTO_MODE = 24;
        public static final short MODE_COMPULSORY_FLASH_FIRING = 8;
        public static final short MODE_COMPULSORY_FLASH_SUPPRESSION = 16;
        public static final short MODE_UNKNOWN = 0;
        public static final short RED_EYE_REDUCTION_NO_OR_UNKNOWN = 0;
        public static final short RED_EYE_REDUCTION_SUPPORT = 64;
        public static final short RETURN_NO_STROBE_RETURN_DETECTION_FUNCTION = 0;
        public static final short RETURN_STROBE_RETURN_LIGHT_DETECTED = 6;
        public static final short RETURN_STROBE_RETURN_LIGHT_NOT_DETECTED = 4;
    }

    public interface GainControl {
        public static final short HIGH_DOWN = 4;
        public static final short HIGH_UP = 2;
        public static final short LOW_DOWN = 3;
        public static final short LOW_UP = 1;
        public static final short NONE = 0;
    }

    public interface GpsAltitudeRef {
        public static final short SEA_LEVEL = 0;
        public static final short SEA_LEVEL_NEGATIVE = 1;
    }

    public interface GpsDifferential {
        public static final short DIFFERENTIAL_CORRECTION_APPLIED = 1;
        public static final short WITHOUT_DIFFERENTIAL_CORRECTION = 0;
    }

    public interface GpsLatitudeRef {
        public static final String NORTH = "N";
        public static final String SOUTH = "S";
    }

    public interface GpsLongitudeRef {
        public static final String EAST = "E";
        public static final String WEST = "W";
    }

    public interface GpsMeasureMode {
        public static final String MODE_2_DIMENSIONAL = "2";
        public static final String MODE_3_DIMENSIONAL = "3";
    }

    public interface GpsSpeedRef {
        public static final String KILOMETERS = "K";
        public static final String KNOTS = "N";
        public static final String MILES = "M";
    }

    public interface GpsStatus {
        public static final String INTEROPERABILITY = "V";
        public static final String IN_PROGRESS = "A";
    }

    public interface GpsTrackRef {
        public static final String MAGNETIC_DIRECTION = "M";
        public static final String TRUE_DIRECTION = "T";
    }

    public interface LightSource {
        public static final short CLOUDY_WEATHER = 10;
        public static final short COOL_WHITE_FLUORESCENT = 14;
        public static final short D50 = 23;
        public static final short D55 = 20;
        public static final short D65 = 21;
        public static final short D75 = 22;
        public static final short DAYLIGHT = 1;
        public static final short DAYLIGHT_FLUORESCENT = 12;
        public static final short DAY_WHITE_FLUORESCENT = 13;
        public static final short FINE_WEATHER = 9;
        public static final short FLASH = 4;
        public static final short FLUORESCENT = 2;
        public static final short ISO_STUDIO_TUNGSTEN = 24;
        public static final short OTHER = 255;
        public static final short SHADE = 11;
        public static final short STANDARD_LIGHT_A = 17;
        public static final short STANDARD_LIGHT_B = 18;
        public static final short STANDARD_LIGHT_C = 19;
        public static final short TUNGSTEN = 3;
        public static final short UNKNOWN = 0;
        public static final short WHITE_FLUORESCENT = 15;
    }

    public interface MeteringMode {
        public static final short AVERAGE = 1;
        public static final short CENTER_WEIGHTED_AVERAGE = 2;
        public static final short MULTISPOT = 4;
        public static final short OTHER = 255;
        public static final short PARTAIL = 6;
        public static final short PATTERN = 5;
        public static final short SPOT = 3;
        public static final short UNKNOWN = 0;
    }

    public interface Orientation {
        public static final short BOTTOM_LEFT = 3;
        public static final short BOTTOM_RIGHT = 4;
        public static final short LEFT_BOTTOM = 7;
        public static final short LEFT_TOP = 5;
        public static final short RIGHT_BOTTOM = 8;
        public static final short RIGHT_TOP = 6;
        public static final short TOP_LEFT = 1;
        public static final short TOP_RIGHT = 2;
    }

    public interface PhotometricInterpretation {
        public static final short RGB = 2;
        public static final short YCBCR = 6;
    }

    public interface PlanarConfiguration {
        public static final short CHUNKY = 1;
        public static final short PLANAR = 2;
    }

    public interface ResolutionUnit {
        public static final short CENTIMETERS = 3;
        public static final short INCHES = 2;
    }

    public interface Saturation {
        public static final short HIGH = 2;
        public static final short LOW = 1;
        public static final short NORMAL = 0;
    }

    public interface SceneCapture {
        public static final short LANDSCAPE = 1;
        public static final short NIGHT_SCENE = 3;
        public static final short PROTRAIT = 2;
        public static final short STANDARD = 0;
    }

    public interface SceneType {
        public static final short DIRECT_PHOTOGRAPHED = 1;
    }

    public interface SensingMethod {
        public static final short COLOR_SEQUENTIAL_AREA = 5;
        public static final short COLOR_SEQUENTIAL_LINEAR = 8;
        public static final short NOT_DEFINED = 1;
        public static final short ONE_CHIP_COLOR = 2;
        public static final short THREE_CHIP_COLOR = 4;
        public static final short TRILINEAR = 7;
        public static final short TWO_CHIP_COLOR = 3;
    }

    public interface Sharpness {
        public static final short HARD = 2;
        public static final short NORMAL = 0;
        public static final short SOFT = 1;
    }

    public interface SubjectDistance {
        public static final short CLOSE_VIEW = 2;
        public static final short DISTANT_VIEW = 3;
        public static final short MACRO = 1;
        public static final short UNKNOWN = 0;
    }

    public interface WhiteBalance {
        public static final short AUTO = 0;
        public static final short MANUAL = 1;
    }

    public interface YCbCrPositioning {
        public static final short CENTERED = 1;
        public static final short CO_SITED = 2;
    }

    public static int defineTag(int i, short s) {
        return (i << 16) | (s & ColorSpace.UNCALIBRATED);
    }

    protected static int getAllowedIfdFlagsFromInfo(int i) {
        return i >>> 24;
    }

    protected static int getComponentCountFromInfo(int i) {
        return i & NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN;
    }

    public static int getRotationForOrientationValue(short s) {
        if (s == 1) {
            return 0;
        }
        if (s == 3) {
            return 180;
        }
        if (s != 6) {
            return s != 8 ? 0 : 270;
        }
        return 90;
    }

    public static int getTrueIfd(int i) {
        return i >>> 16;
    }

    public static short getTrueTagKey(int i) {
        return (short) i;
    }

    protected static short getTypeFromInfo(int i) {
        return (short) ((i >> 16) & 255);
    }

    static {
        sOffsetTags.add(Short.valueOf(getTrueTagKey(TAG_GPS_IFD)));
        sOffsetTags.add(Short.valueOf(getTrueTagKey(TAG_EXIF_IFD)));
        sOffsetTags.add(Short.valueOf(getTrueTagKey(TAG_JPEG_INTERCHANGE_FORMAT)));
        sOffsetTags.add(Short.valueOf(getTrueTagKey(TAG_INTEROPERABILITY_IFD)));
        sOffsetTags.add(Short.valueOf(getTrueTagKey(TAG_STRIP_OFFSETS)));
        sBannedDefines.add(Short.valueOf(getTrueTagKey(-1)));
        sBannedDefines.add(Short.valueOf(getTrueTagKey(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH)));
        sBannedDefines.add(Short.valueOf(getTrueTagKey(TAG_STRIP_BYTE_COUNTS)));
    }

    public OppoExifInterface() {
        this.mGPSDateStampFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public void readExif(byte[] bArr) throws IOException {
        readExif((InputStream) new ByteArrayInputStream(bArr));
    }

    public void readExif(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            OppoExifData oppoExifData = null;
            try {
                oppoExifData = new OppoExifReader(this).read(inputStream);
            } catch (OppoExifInvalidFormatException e) {
                throw new IOException("Invalid exif format : " + e);
            } catch (Throwable th) {
                Log.e("OppoExifInterface", "e = " + th);
            }
            this.mData = oppoExifData;
            return;
        }
        throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
    }

    public void readExif(String str) throws FileNotFoundException, IOException {
        if (str != null) {
            BufferedInputStream bufferedInputStream = null;
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
                try {
                    readExif((InputStream) bufferedInputStream2);
                    bufferedInputStream2.close();
                } catch (IOException e) {
                    e = e;
                    bufferedInputStream = bufferedInputStream2;
                    closeSilently(bufferedInputStream);
                    throw e;
                }
            } catch (IOException e2) {
                e = e2;
                closeSilently(bufferedInputStream);
                throw e;
            }
        } else {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
    }

    public void setExif(Collection<OppoExifTag> collection) {
        clearExif();
        setTags(collection);
    }

    public void clearExif() {
        this.mData = new OppoExifData(DEFAULT_BYTE_ORDER);
    }

    public void writeExif(byte[] bArr, OutputStream outputStream) throws IOException {
        if (bArr == null || outputStream == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        OutputStream exifWriterStream = getExifWriterStream(outputStream);
        exifWriterStream.write(bArr, 0, bArr.length);
        exifWriterStream.flush();
    }

    public void writeExif(Bitmap bitmap, OutputStream outputStream) throws IOException {
        if (bitmap == null || outputStream == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        OutputStream exifWriterStream = getExifWriterStream(outputStream);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, exifWriterStream);
        exifWriterStream.flush();
    }

    public void writeExif(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream == null || outputStream == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        OutputStream exifWriterStream = getExifWriterStream(outputStream);
        doExifStreamIO(inputStream, exifWriterStream);
        exifWriterStream.flush();
    }

    public void writeExif(byte[] bArr, String str) throws FileNotFoundException, IOException {
        if (bArr == null || str == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        OutputStream outputStream = null;
        try {
            outputStream = getExifWriterStream(str);
            outputStream.write(bArr, 0, bArr.length);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            closeSilently(outputStream);
            throw e;
        }
    }

    public void writeExif(Bitmap bitmap, String str) throws FileNotFoundException, IOException {
        if (bitmap == null || str == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        OutputStream outputStream = null;
        try {
            outputStream = getExifWriterStream(str);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            closeSilently(outputStream);
            throw e;
        }
    }

    public void writeExif(InputStream inputStream, String str) throws FileNotFoundException, IOException {
        if (inputStream == null || str == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        OutputStream outputStream = null;
        try {
            outputStream = getExifWriterStream(str);
            doExifStreamIO(inputStream, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            closeSilently(outputStream);
            throw e;
        }
    }

    public void writeExif(String str, String str2) throws FileNotFoundException, IOException {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                writeExif((InputStream) fileInputStream2, str2);
                fileInputStream2.close();
            } catch (IOException e) {
                e = e;
                fileInputStream = fileInputStream2;
                closeSilently(fileInputStream);
                throw e;
            }
        } catch (IOException e2) {
            e = e2;
            closeSilently(fileInputStream);
            throw e;
        }
    }

    public OutputStream getExifWriterStream(OutputStream outputStream) {
        if (outputStream != null) {
            OppoExifOutputStream oppoExifOutputStream = new OppoExifOutputStream(outputStream, this);
            oppoExifOutputStream.setExifData(this.mData);
            return oppoExifOutputStream;
        }
        throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
    }

    public OutputStream getExifWriterStream(String str) throws FileNotFoundException {
        if (str != null) {
            try {
                return getExifWriterStream((OutputStream) new FileOutputStream(str));
            } catch (FileNotFoundException e) {
                closeSilently((Closeable) null);
                throw e;
            }
        } else {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
    }

    /* JADX WARNING: type inference failed for: r11v6, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean rewriteExif(java.lang.String r11, java.util.Collection<com.oppo.exif.OppoExifTag> r12) throws java.io.FileNotFoundException, java.io.IOException {
        /*
            r10 = this;
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x005f, all -> 0x005c }
            r1.<init>(r11)     // Catch:{ IOException -> 0x005f, all -> 0x005c }
            java.io.BufferedInputStream r11 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x005f, all -> 0x005c }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x005f, all -> 0x005c }
            r2.<init>(r1)     // Catch:{ IOException -> 0x005f, all -> 0x005c }
            r11.<init>(r2)     // Catch:{ IOException -> 0x005f, all -> 0x005c }
            com.oppo.exif.OppoExifParser r2 = com.oppo.exif.OppoExifParser.parse(r11, r10)     // Catch:{ OppoExifInvalidFormatException -> 0x0053 }
            int r2 = r2.getOffsetToExifEndFromSOF()     // Catch:{ IOException -> 0x0051 }
            long r7 = (long) r2     // Catch:{ IOException -> 0x0051 }
            r11.close()     // Catch:{ IOException -> 0x0051 }
            java.io.RandomAccessFile r11 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x005f, all -> 0x005c }
            java.lang.String r2 = "rw"
            r11.<init>(r1, r2)     // Catch:{ IOException -> 0x005f, all -> 0x005c }
            long r1 = r11.length()     // Catch:{ IOException -> 0x004c, all -> 0x004a }
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 < 0) goto L_0x0042
            java.nio.channels.FileChannel r3 = r11.getChannel()     // Catch:{ IOException -> 0x004c, all -> 0x004a }
            java.nio.channels.FileChannel$MapMode r4 = java.nio.channels.FileChannel.MapMode.READ_WRITE     // Catch:{ IOException -> 0x004c, all -> 0x004a }
            r5 = 0
            java.nio.MappedByteBuffer r1 = r3.map(r4, r5, r7)     // Catch:{ IOException -> 0x004c, all -> 0x004a }
            boolean r12 = r10.rewriteExif((java.nio.ByteBuffer) r1, (java.util.Collection<com.oppo.exif.OppoExifTag>) r12)     // Catch:{ IOException -> 0x004c, all -> 0x004a }
            closeSilently(r0)
            closeSilently(r11)
            return r12
        L_0x0042:
            java.io.IOException r12 = new java.io.IOException     // Catch:{ IOException -> 0x004c, all -> 0x004a }
            java.lang.String r1 = "Filesize changed during operation"
            r12.<init>(r1)     // Catch:{ IOException -> 0x004c, all -> 0x004a }
            throw r12     // Catch:{ IOException -> 0x004c, all -> 0x004a }
        L_0x004a:
            r12 = move-exception
            goto L_0x0066
        L_0x004c:
            r12 = move-exception
            r9 = r0
            r0 = r11
            r11 = r9
            goto L_0x0061
        L_0x0051:
            r12 = move-exception
            goto L_0x0061
        L_0x0053:
            r12 = move-exception
            java.io.IOException r1 = new java.io.IOException     // Catch:{ IOException -> 0x0051 }
            java.lang.String r2 = "Invalid exif format : "
            r1.<init>(r2, r12)     // Catch:{ IOException -> 0x0051 }
            throw r1     // Catch:{ IOException -> 0x0051 }
        L_0x005c:
            r12 = move-exception
            r11 = r0
            goto L_0x0066
        L_0x005f:
            r12 = move-exception
            r11 = r0
        L_0x0061:
            throw r12     // Catch:{ all -> 0x0062 }
        L_0x0062:
            r12 = move-exception
            r9 = r0
            r0 = r11
            r11 = r9
        L_0x0066:
            closeSilently(r0)
            closeSilently(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.exif.OppoExifInterface.rewriteExif(java.lang.String, java.util.Collection):boolean");
    }

    public boolean rewriteExif(ByteBuffer byteBuffer, Collection<OppoExifTag> collection) throws IOException {
        try {
            OppoExifModifier oppoExifModifier = new OppoExifModifier(byteBuffer, this);
            for (OppoExifTag modifyTag : collection) {
                oppoExifModifier.modifyTag(modifyTag);
            }
            return oppoExifModifier.commit();
        } catch (OppoExifInvalidFormatException e) {
            throw new IOException("Invalid exif format : " + e);
        }
    }

    public void forceRewriteExif(String str, Collection<OppoExifTag> collection) throws FileNotFoundException, IOException {
        if (collection != null && !rewriteExif(str, collection)) {
            OppoExifData oppoExifData = this.mData;
            this.mData = new OppoExifData(DEFAULT_BYTE_ORDER);
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    doExifStreamIO(fileInputStream2, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    readExif(byteArray);
                    setTags(collection);
                    writeExif(byteArray, str);
                    closeSilently(fileInputStream2);
                    this.mData = oppoExifData;
                } catch (IOException e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    try {
                        closeSilently(fileInputStream);
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        closeSilently(fileInputStream2);
                        this.mData = oppoExifData;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeSilently(fileInputStream2);
                    this.mData = oppoExifData;
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                closeSilently(fileInputStream);
                throw e;
            }
        }
    }

    public void forceRewriteExif(String str) throws FileNotFoundException, IOException {
        forceRewriteExif(str, getAllTags());
    }

    public List<OppoExifTag> getAllTags() {
        return this.mData.getAllTags();
    }

    public List<OppoExifTag> getTagsForTagId(short s) {
        return this.mData.getAllTagsForTagId(s);
    }

    public List<OppoExifTag> getTagsForIfdId(int i) {
        return this.mData.getAllTagsForIfd(i);
    }

    public OppoExifTag getTag(int i, int i2) {
        if (!OppoExifTag.isValidIfd(i2)) {
            return null;
        }
        return this.mData.getTag(getTrueTagKey(i), i2);
    }

    public OppoExifTag getTag(int i) {
        return getTag(i, getDefinedTagDefaultIfd(i));
    }

    public Object getTagValue(int i, int i2) {
        OppoExifTag tag = getTag(i, i2);
        if (tag == null) {
            return null;
        }
        return tag.getValue();
    }

    public Object getTagValue(int i) {
        return getTagValue(i, getDefinedTagDefaultIfd(i));
    }

    public String getTagStringValue(int i, int i2) {
        OppoExifTag tag = getTag(i, i2);
        if (tag == null) {
            return null;
        }
        return tag.getValueAsString();
    }

    public String getTagStringValue(int i) {
        return getTagStringValue(i, getDefinedTagDefaultIfd(i));
    }

    public Long getTagLongValue(int i, int i2) {
        long[] tagLongValues = getTagLongValues(i, i2);
        if (tagLongValues == null || tagLongValues.length <= 0) {
            return null;
        }
        return new Long(tagLongValues[0]);
    }

    public Long getTagLongValue(int i) {
        return getTagLongValue(i, getDefinedTagDefaultIfd(i));
    }

    public Integer getTagIntValue(int i, int i2) {
        int[] tagIntValues = getTagIntValues(i, i2);
        if (tagIntValues == null || tagIntValues.length <= 0) {
            return null;
        }
        return new Integer(tagIntValues[0]);
    }

    public Integer getTagIntValue(int i) {
        return getTagIntValue(i, getDefinedTagDefaultIfd(i));
    }

    public Byte getTagByteValue(int i, int i2) {
        byte[] tagByteValues = getTagByteValues(i, i2);
        if (tagByteValues == null || tagByteValues.length <= 0) {
            return null;
        }
        return new Byte(tagByteValues[0]);
    }

    public Byte getTagByteValue(int i) {
        return getTagByteValue(i, getDefinedTagDefaultIfd(i));
    }

    public OppoRational getTagRationalValue(int i, int i2) {
        OppoRational[] tagRationalValues = getTagRationalValues(i, i2);
        if (tagRationalValues == null || tagRationalValues.length == 0) {
            return null;
        }
        return new OppoRational(tagRationalValues[0]);
    }

    public OppoRational getTagRationalValue(int i) {
        return getTagRationalValue(i, getDefinedTagDefaultIfd(i));
    }

    public long[] getTagLongValues(int i, int i2) {
        OppoExifTag tag = getTag(i, i2);
        if (tag == null) {
            return null;
        }
        return tag.getValueAsLongs();
    }

    public long[] getTagLongValues(int i) {
        return getTagLongValues(i, getDefinedTagDefaultIfd(i));
    }

    public int[] getTagIntValues(int i, int i2) {
        OppoExifTag tag = getTag(i, i2);
        if (tag == null) {
            return null;
        }
        return tag.getValueAsInts();
    }

    public int[] getTagIntValues(int i) {
        return getTagIntValues(i, getDefinedTagDefaultIfd(i));
    }

    public byte[] getTagByteValues(int i, int i2) {
        OppoExifTag tag = getTag(i, i2);
        if (tag == null) {
            return null;
        }
        return tag.getValueAsBytes();
    }

    public byte[] getTagByteValues(int i) {
        return getTagByteValues(i, getDefinedTagDefaultIfd(i));
    }

    public OppoRational[] getTagRationalValues(int i, int i2) {
        OppoExifTag tag = getTag(i, i2);
        if (tag == null) {
            return null;
        }
        return tag.getValueAsRationals();
    }

    public OppoRational[] getTagRationalValues(int i) {
        return getTagRationalValues(i, getDefinedTagDefaultIfd(i));
    }

    public boolean isTagCountDefined(int i) {
        int i2 = getTagInfo().get(i);
        if (i2 == 0 || getComponentCountFromInfo(i2) == 0) {
            return false;
        }
        return true;
    }

    public int getDefinedTagCount(int i) {
        int i2 = getTagInfo().get(i);
        if (i2 == 0) {
            return 0;
        }
        return getComponentCountFromInfo(i2);
    }

    public int getActualTagCount(int i, int i2) {
        OppoExifTag tag = getTag(i, i2);
        if (tag == null) {
            return 0;
        }
        return tag.getComponentCount();
    }

    public int getDefinedTagDefaultIfd(int i) {
        if (getTagInfo().get(i) == 0) {
            return -1;
        }
        return getTrueIfd(i);
    }

    public short getDefinedTagType(int i) {
        int i2 = getTagInfo().get(i);
        if (i2 == 0) {
            return -1;
        }
        return getTypeFromInfo(i2);
    }

    protected static boolean isOffsetTag(short s) {
        return sOffsetTags.contains(Short.valueOf(s));
    }

    public OppoExifTag buildTag(int i, int i2, Object obj) {
        int i3 = getTagInfo().get(i);
        if (i3 == 0 || obj == null) {
            return null;
        }
        short typeFromInfo = getTypeFromInfo(i3);
        int componentCountFromInfo = getComponentCountFromInfo(i3);
        boolean z = componentCountFromInfo != 0;
        if (!isIfdAllowed(i3, i2)) {
            return null;
        }
        OppoExifTag oppoExifTag = new OppoExifTag(getTrueTagKey(i), typeFromInfo, componentCountFromInfo, i2, z);
        if (!oppoExifTag.setValue(obj)) {
            return null;
        }
        return oppoExifTag;
    }

    public OppoExifTag buildTag(int i, Object obj) {
        return buildTag(i, getTrueIfd(i), obj);
    }

    /* access modifiers changed from: protected */
    public OppoExifTag buildUninitializedTag(int i) {
        int i2 = getTagInfo().get(i);
        if (i2 == 0) {
            return null;
        }
        short typeFromInfo = getTypeFromInfo(i2);
        int componentCountFromInfo = getComponentCountFromInfo(i2);
        boolean z = componentCountFromInfo != 0;
        return new OppoExifTag(getTrueTagKey(i), typeFromInfo, componentCountFromInfo, getTrueIfd(i), z);
    }

    public boolean setTagValue(int i, int i2, Object obj) {
        OppoExifTag tag = getTag(i, i2);
        if (tag == null) {
            return false;
        }
        return tag.setValue(obj);
    }

    public boolean setTagValue(int i, Object obj) {
        return setTagValue(i, getDefinedTagDefaultIfd(i), obj);
    }

    public OppoExifTag setTag(OppoExifTag oppoExifTag) {
        return this.mData.addTag(oppoExifTag);
    }

    public void setTags(Collection<OppoExifTag> collection) {
        for (OppoExifTag tag : collection) {
            setTag(tag);
        }
    }

    public void deleteTag(int i, int i2) {
        this.mData.removeTag(getTrueTagKey(i), i2);
    }

    public void deleteTag(int i) {
        deleteTag(i, getDefinedTagDefaultIfd(i));
    }

    public int setTagDefinition(short s, int i, short s2, short s3, int[] iArr) {
        int defineTag;
        if (sBannedDefines.contains(Short.valueOf(s)) || !OppoExifTag.isValidType(s2) || !OppoExifTag.isValidIfd(i) || (defineTag = defineTag(i, s)) == -1) {
            return -1;
        }
        int[] tagDefinitionsForTagId = getTagDefinitionsForTagId(s);
        SparseIntArray tagInfo = getTagInfo();
        boolean z = false;
        for (int i2 : iArr) {
            if (i == i2) {
                z = true;
            }
            if (!OppoExifTag.isValidIfd(i2)) {
                return -1;
            }
        }
        if (!z) {
            return -1;
        }
        int flagsFromAllowedIfds = getFlagsFromAllowedIfds(iArr);
        if (tagDefinitionsForTagId != null) {
            for (int i3 : tagDefinitionsForTagId) {
                if ((getAllowedIfdFlagsFromInfo(tagInfo.get(i3)) & flagsFromAllowedIfds) != 0) {
                    return -1;
                }
            }
        }
        getTagInfo().put(defineTag, (flagsFromAllowedIfds << 24) | (s2 << 16) | s3);
        return defineTag;
    }

    /* access modifiers changed from: protected */
    public int getTagDefinition(short s, int i) {
        return getTagInfo().get(defineTag(i, s));
    }

    /* access modifiers changed from: protected */
    public int[] getTagDefinitionsForTagId(short s) {
        int[] ifds = OppoIfdData.getIfds();
        int[] iArr = new int[ifds.length];
        SparseIntArray tagInfo = getTagInfo();
        int i = 0;
        for (int defineTag : ifds) {
            int defineTag2 = defineTag(defineTag, s);
            if (tagInfo.get(defineTag2) != 0) {
                iArr[i] = defineTag2;
                i++;
            }
        }
        if (i == 0) {
            return null;
        }
        return Arrays.copyOfRange(iArr, 0, i);
    }

    /* access modifiers changed from: protected */
    public int getTagDefinitionForTag(OppoExifTag oppoExifTag) {
        return getTagDefinitionForTag(oppoExifTag.getTagId(), oppoExifTag.getDataType(), oppoExifTag.getComponentCount(), oppoExifTag.getIfd());
    }

    /* access modifiers changed from: protected */
    public int getTagDefinitionForTag(short s, short s2, int i, int i2) {
        boolean z;
        int[] tagDefinitionsForTagId = getTagDefinitionsForTagId(s);
        if (tagDefinitionsForTagId == null) {
            return -1;
        }
        SparseIntArray tagInfo = getTagInfo();
        for (int i3 : tagDefinitionsForTagId) {
            int i4 = tagInfo.get(i3);
            short typeFromInfo = getTypeFromInfo(i4);
            int componentCountFromInfo = getComponentCountFromInfo(i4);
            int[] allowedIfdsFromInfo = getAllowedIfdsFromInfo(i4);
            int length = allowedIfdsFromInfo.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    int i6 = i2;
                    z = false;
                    break;
                } else if (allowedIfdsFromInfo[i5] == i2) {
                    z = true;
                    break;
                } else {
                    i5++;
                }
            }
            if (!z) {
                short s3 = s2;
            } else if (s2 == typeFromInfo) {
                if (i == componentCountFromInfo || componentCountFromInfo == 0) {
                    return i3;
                }
            }
            int i7 = i;
        }
        return -1;
    }

    public void removeTagDefinition(int i) {
        getTagInfo().delete(i);
    }

    public void resetTagDefinitions() {
        this.mTagInfo = null;
    }

    public Bitmap getThumbnailBitmap() {
        if (this.mData.hasCompressedThumbnail()) {
            byte[] compressedThumbnail = this.mData.getCompressedThumbnail();
            return BitmapFactory.decodeByteArray(compressedThumbnail, 0, compressedThumbnail.length);
        }
        this.mData.hasUncompressedStrip();
        return null;
    }

    public byte[] getThumbnailBytes() {
        if (this.mData.hasCompressedThumbnail()) {
            return this.mData.getCompressedThumbnail();
        }
        this.mData.hasUncompressedStrip();
        return null;
    }

    public byte[] getThumbnail() {
        return this.mData.getCompressedThumbnail();
    }

    public boolean isThumbnailCompressed() {
        return this.mData.hasCompressedThumbnail();
    }

    public boolean hasThumbnail() {
        return this.mData.hasCompressedThumbnail();
    }

    public boolean setCompressedThumbnail(byte[] bArr) {
        this.mData.clearThumbnailAndStrips();
        this.mData.setCompressedThumbnail(bArr);
        return true;
    }

    public boolean setCompressedThumbnail(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!bitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream)) {
            return false;
        }
        return setCompressedThumbnail(byteArrayOutputStream.toByteArray());
    }

    public void removeCompressedThumbnail() {
        this.mData.setCompressedThumbnail((byte[]) null);
    }

    public String getUserComment() {
        return this.mData.getUserComment();
    }

    public static short getOrientationValueForRotation(int i) {
        int i2 = i % 360;
        if (i2 < 0) {
            i2 += 360;
        }
        if (i2 < 90) {
            return 1;
        }
        if (i2 < 180) {
            return 6;
        }
        return i2 < 270 ? (short) 3 : 8;
    }

    public static double convertLatOrLongToDouble(OppoRational[] oppoRationalArr, String str) {
        try {
            double d = oppoRationalArr[0].toDouble() + (oppoRationalArr[1].toDouble() / 60.0d) + (oppoRationalArr[2].toDouble() / 3600.0d);
            return (str.equals(GpsLatitudeRef.SOUTH) || str.equals(GpsLongitudeRef.WEST)) ? -d : d;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException();
        }
    }

    public double[] getLatLongAsDoubles() {
        OppoRational[] tagRationalValues = getTagRationalValues(TAG_GPS_LATITUDE);
        String tagStringValue = getTagStringValue(TAG_GPS_LATITUDE_REF);
        OppoRational[] tagRationalValues2 = getTagRationalValues(TAG_GPS_LONGITUDE);
        String tagStringValue2 = getTagStringValue(TAG_GPS_LONGITUDE_REF);
        if (tagRationalValues == null || tagRationalValues2 == null || tagStringValue == null || tagStringValue2 == null || tagRationalValues.length < 3 || tagRationalValues2.length < 3) {
            return null;
        }
        return new double[]{convertLatOrLongToDouble(tagRationalValues, tagStringValue), convertLatOrLongToDouble(tagRationalValues2, tagStringValue2)};
    }

    public boolean addDateTimeStampTag(int i, long j, TimeZone timeZone) {
        if (i != TAG_DATE_TIME && i != TAG_DATE_TIME_DIGITIZED && i != TAG_DATE_TIME_ORIGINAL) {
            return false;
        }
        this.mDateTimeStampFormat.setTimeZone(timeZone);
        OppoExifTag buildTag = buildTag(i, this.mDateTimeStampFormat.format(Long.valueOf(j)));
        if (buildTag == null) {
            return false;
        }
        setTag(buildTag);
        return true;
    }

    public boolean addGpsTags(double d, double d2) {
        OppoExifTag buildTag = buildTag(TAG_GPS_LATITUDE, toExifLatLong(d));
        OppoExifTag buildTag2 = buildTag(TAG_GPS_LONGITUDE, toExifLatLong(d2));
        OppoExifTag buildTag3 = buildTag(TAG_GPS_LATITUDE_REF, d >= 0.0d ? "N" : GpsLatitudeRef.SOUTH);
        OppoExifTag buildTag4 = buildTag(TAG_GPS_LONGITUDE_REF, d2 >= 0.0d ? GpsLongitudeRef.EAST : GpsLongitudeRef.WEST);
        if (buildTag == null || buildTag2 == null || buildTag3 == null || buildTag4 == null) {
            return false;
        }
        setTag(buildTag);
        setTag(buildTag2);
        setTag(buildTag3);
        setTag(buildTag4);
        return true;
    }

    public boolean addGpsDateTimeStampTag(long j) {
        OppoExifTag buildTag = buildTag(TAG_GPS_DATE_STAMP, this.mGPSDateStampFormat.format(Long.valueOf(j)));
        if (buildTag == null) {
            return false;
        }
        setTag(buildTag);
        this.mGPSTimeStampCalendar.setTimeInMillis(j);
        OppoExifTag buildTag2 = buildTag(TAG_GPS_TIME_STAMP, new OppoRational[]{new OppoRational((long) this.mGPSTimeStampCalendar.get(11), 1), new OppoRational((long) this.mGPSTimeStampCalendar.get(12), 1), new OppoRational((long) this.mGPSTimeStampCalendar.get(13), 1)});
        if (buildTag2 == null) {
            return false;
        }
        setTag(buildTag2);
        return true;
    }

    private static OppoRational[] toExifLatLong(double d) {
        double abs = Math.abs(d);
        int i = (int) abs;
        double d2 = (abs - ((double) i)) * 60.0d;
        int i2 = (int) d2;
        return new OppoRational[]{new OppoRational((long) i, 1), new OppoRational((long) i2, 1), new OppoRational((long) ((int) ((d2 - ((double) i2)) * 6000.0d)), 100)};
    }

    private void doExifStreamIO(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        int read = inputStream.read(bArr, 0, 1024);
        while (read != -1) {
            outputStream.write(bArr, 0, read);
            read = inputStream.read(bArr, 0, 1024);
        }
    }

    protected static void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public SparseIntArray getTagInfo() {
        if (this.mTagInfo == null) {
            this.mTagInfo = new SparseIntArray();
            initTagInfo();
        }
        return this.mTagInfo;
    }

    private void initTagInfo() {
        int flagsFromAllowedIfds = getFlagsFromAllowedIfds(new int[]{0, 1}) << 24;
        SparseIntArray sparseIntArray = this.mTagInfo;
        int i = TAG_MAKE;
        int i2 = flagsFromAllowedIfds | STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_VIDEO;
        int i3 = i2 | 0;
        sparseIntArray.put(i, i3);
        SparseIntArray sparseIntArray2 = this.mTagInfo;
        int i4 = TAG_IMAGE_WIDTH;
        int i5 = flagsFromAllowedIfds | STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE;
        int i6 = i5 | 1;
        sparseIntArray2.put(i4, i6);
        this.mTagInfo.put(TAG_IMAGE_LENGTH, i6);
        int i7 = flagsFromAllowedIfds | 196608;
        this.mTagInfo.put(TAG_BITS_PER_SAMPLE, i7 | 3);
        int i8 = i7 | 1;
        this.mTagInfo.put(TAG_COMPRESSION, i8);
        this.mTagInfo.put(TAG_PHOTOMETRIC_INTERPRETATION, i8);
        this.mTagInfo.put(TAG_ORIENTATION, i8);
        this.mTagInfo.put(TAG_SAMPLES_PER_PIXEL, i8);
        this.mTagInfo.put(TAG_PLANAR_CONFIGURATION, i8);
        this.mTagInfo.put(TAG_Y_CB_CR_SUB_SAMPLING, i7 | 2);
        this.mTagInfo.put(TAG_Y_CB_CR_POSITIONING, i8);
        int i9 = flagsFromAllowedIfds | 327680;
        int i10 = i9 | 1;
        this.mTagInfo.put(TAG_X_RESOLUTION, i10);
        this.mTagInfo.put(TAG_Y_RESOLUTION, i10);
        this.mTagInfo.put(TAG_RESOLUTION_UNIT, i8);
        int i11 = i5 | 0;
        this.mTagInfo.put(TAG_STRIP_OFFSETS, i11);
        this.mTagInfo.put(TAG_ROWS_PER_STRIP, i6);
        this.mTagInfo.put(TAG_STRIP_BYTE_COUNTS, i11);
        this.mTagInfo.put(TAG_TRANSFER_FUNCTION, i7 | 768);
        this.mTagInfo.put(TAG_WHITE_POINT, i9 | 2);
        int i12 = i9 | 6;
        this.mTagInfo.put(TAG_PRIMARY_CHROMATICITIES, i12);
        this.mTagInfo.put(TAG_Y_CB_CR_COEFFICIENTS, i9 | 3);
        this.mTagInfo.put(TAG_REFERENCE_BLACK_WHITE, i12);
        this.mTagInfo.put(TAG_DATE_TIME, i2 | 20);
        this.mTagInfo.put(TAG_IMAGE_DESCRIPTION, i3);
        this.mTagInfo.put(TAG_MAKE, i3);
        this.mTagInfo.put(TAG_MODEL, i3);
        this.mTagInfo.put(TAG_SOFTWARE, i3);
        this.mTagInfo.put(TAG_ARTIST, i3);
        this.mTagInfo.put(TAG_COPYRIGHT, i3);
        this.mTagInfo.put(TAG_EXIF_IFD, i6);
        this.mTagInfo.put(TAG_GPS_IFD, i6);
        SparseIntArray sparseIntArray3 = this.mTagInfo;
        int i13 = TAG_JPEG_INTERCHANGE_FORMAT;
        int flagsFromAllowedIfds2 = (getFlagsFromAllowedIfds(new int[]{1}) << 24) | STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE | 1;
        sparseIntArray3.put(i13, flagsFromAllowedIfds2);
        this.mTagInfo.put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, flagsFromAllowedIfds2);
        int flagsFromAllowedIfds3 = getFlagsFromAllowedIfds(new int[]{2}) << 24;
        int i14 = flagsFromAllowedIfds3 | 458752;
        int i15 = i14 | 4;
        this.mTagInfo.put(TAG_EXIF_VERSION, i15);
        this.mTagInfo.put(TAG_FLASHPIX_VERSION, i15);
        int i16 = flagsFromAllowedIfds3 | 196608;
        int i17 = i16 | 1;
        this.mTagInfo.put(TAG_COLOR_SPACE, i17);
        this.mTagInfo.put(TAG_COMPONENTS_CONFIGURATION, i15);
        int i18 = flagsFromAllowedIfds3 | 327680 | 1;
        this.mTagInfo.put(TAG_COMPRESSED_BITS_PER_PIXEL, i18);
        int i19 = 262144 | flagsFromAllowedIfds3 | 1;
        this.mTagInfo.put(TAG_PIXEL_X_DIMENSION, i19);
        this.mTagInfo.put(TAG_PIXEL_Y_DIMENSION, i19);
        int i20 = i14 | 0;
        this.mTagInfo.put(TAG_MAKER_NOTE, i20);
        this.mTagInfo.put(TAG_USER_COMMENT, i20);
        SparseIntArray sparseIntArray4 = this.mTagInfo;
        int i21 = TAG_RELATED_SOUND_FILE;
        int i22 = flagsFromAllowedIfds3 | STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_VIDEO;
        sparseIntArray4.put(i21, i22 | 13);
        int i23 = i22 | 20;
        this.mTagInfo.put(TAG_DATE_TIME_ORIGINAL, i23);
        this.mTagInfo.put(TAG_DATE_TIME_DIGITIZED, i23);
        int i24 = i22 | 0;
        this.mTagInfo.put(TAG_SUB_SEC_TIME, i24);
        this.mTagInfo.put(TAG_SUB_SEC_TIME_ORIGINAL, i24);
        this.mTagInfo.put(TAG_SUB_SEC_TIME_DIGITIZED, i24);
        this.mTagInfo.put(TAG_OFFSET_TIME_ORIGINAL, i24);
        this.mTagInfo.put(TAG_IMAGE_UNIQUE_ID, i22 | 33);
        this.mTagInfo.put(TAG_EXPOSURE_TIME, i18);
        this.mTagInfo.put(TAG_F_NUMBER, i18);
        this.mTagInfo.put(TAG_EXPOSURE_PROGRAM, i17);
        this.mTagInfo.put(TAG_SPECTRAL_SENSITIVITY, i24);
        int i25 = i16 | 0;
        this.mTagInfo.put(TAG_ISO_SPEED_RATINGS, i25);
        this.mTagInfo.put(TAG_OECF, i20);
        int i26 = flagsFromAllowedIfds3 | 655360 | 1;
        this.mTagInfo.put(TAG_SHUTTER_SPEED_VALUE, i26);
        this.mTagInfo.put(TAG_APERTURE_VALUE, i18);
        this.mTagInfo.put(TAG_BRIGHTNESS_VALUE, i26);
        this.mTagInfo.put(TAG_EXPOSURE_BIAS_VALUE, i26);
        this.mTagInfo.put(TAG_MAX_APERTURE_VALUE, i18);
        this.mTagInfo.put(TAG_SUBJECT_DISTANCE, i18);
        this.mTagInfo.put(TAG_METERING_MODE, i17);
        this.mTagInfo.put(TAG_LIGHT_SOURCE, i17);
        this.mTagInfo.put(TAG_FLASH, i17);
        this.mTagInfo.put(TAG_FOCAL_LENGTH, i18);
        this.mTagInfo.put(TAG_SUBJECT_AREA, i25);
        this.mTagInfo.put(TAG_FLASH_ENERGY, i18);
        this.mTagInfo.put(TAG_SPATIAL_FREQUENCY_RESPONSE, i20);
        this.mTagInfo.put(TAG_FOCAL_PLANE_X_RESOLUTION, i18);
        this.mTagInfo.put(TAG_FOCAL_PLANE_Y_RESOLUTION, i18);
        this.mTagInfo.put(TAG_FOCAL_PLANE_RESOLUTION_UNIT, i17);
        this.mTagInfo.put(TAG_SUBJECT_LOCATION, 2 | i16);
        this.mTagInfo.put(TAG_EXPOSURE_INDEX, i18);
        this.mTagInfo.put(TAG_SENSING_METHOD, i17);
        int i27 = i14 | 1;
        this.mTagInfo.put(TAG_FILE_SOURCE, i27);
        this.mTagInfo.put(TAG_SCENE_TYPE, i27);
        this.mTagInfo.put(TAG_CFA_PATTERN, i20);
        this.mTagInfo.put(TAG_CUSTOM_RENDERED, i17);
        this.mTagInfo.put(TAG_EXPOSURE_MODE, i17);
        this.mTagInfo.put(TAG_WHITE_BALANCE, i17);
        this.mTagInfo.put(TAG_DIGITAL_ZOOM_RATIO, i18);
        this.mTagInfo.put(TAG_FOCAL_LENGTH_IN_35_MM_FILE, i17);
        this.mTagInfo.put(TAG_SCENE_CAPTURE_TYPE, i17);
        this.mTagInfo.put(TAG_GAIN_CONTROL, i18);
        this.mTagInfo.put(TAG_CONTRAST, i17);
        this.mTagInfo.put(TAG_SATURATION, i17);
        this.mTagInfo.put(TAG_SHARPNESS, i17);
        this.mTagInfo.put(TAG_DEVICE_SETTING_DESCRIPTION, i20);
        this.mTagInfo.put(TAG_SUBJECT_DISTANCE_RANGE, i17);
        this.mTagInfo.put(TAG_INTEROPERABILITY_IFD, i19);
        int flagsFromAllowedIfds4 = getFlagsFromAllowedIfds(new int[]{4}) << 24;
        int i28 = 65536 | flagsFromAllowedIfds4;
        this.mTagInfo.put(TAG_GPS_VERSION_ID, i28 | 4);
        SparseIntArray sparseIntArray5 = this.mTagInfo;
        int i29 = TAG_GPS_LATITUDE_REF;
        int i30 = flagsFromAllowedIfds4 | STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_VIDEO;
        int i31 = i30 | 2;
        sparseIntArray5.put(i29, i31);
        this.mTagInfo.put(TAG_GPS_LONGITUDE_REF, i31);
        int i32 = flagsFromAllowedIfds4 | 655360 | 3;
        this.mTagInfo.put(TAG_GPS_LATITUDE, i32);
        this.mTagInfo.put(TAG_GPS_LONGITUDE, i32);
        this.mTagInfo.put(TAG_GPS_ALTITUDE_REF, i28 | 1);
        int i33 = 327680 | flagsFromAllowedIfds4;
        int i34 = i33 | 1;
        this.mTagInfo.put(TAG_GPS_ALTITUDE, i34);
        this.mTagInfo.put(TAG_GPS_TIME_STAMP, i33 | 3);
        int i35 = i30 | 0;
        this.mTagInfo.put(TAG_GPS_SATTELLITES, i35);
        this.mTagInfo.put(TAG_GPS_STATUS, i31);
        this.mTagInfo.put(TAG_GPS_MEASURE_MODE, i31);
        this.mTagInfo.put(TAG_GPS_DOP, i34);
        this.mTagInfo.put(TAG_GPS_SPEED_REF, i31);
        this.mTagInfo.put(TAG_GPS_SPEED, i34);
        this.mTagInfo.put(TAG_GPS_TRACK_REF, i31);
        this.mTagInfo.put(TAG_GPS_TRACK, i34);
        this.mTagInfo.put(TAG_GPS_IMG_DIRECTION_REF, i31);
        this.mTagInfo.put(TAG_GPS_IMG_DIRECTION, i34);
        this.mTagInfo.put(TAG_GPS_MAP_DATUM, i35);
        this.mTagInfo.put(TAG_GPS_DEST_LATITUDE_REF, i31);
        this.mTagInfo.put(TAG_GPS_DEST_LATITUDE, i34);
        this.mTagInfo.put(TAG_GPS_DEST_BEARING_REF, i31);
        this.mTagInfo.put(TAG_GPS_DEST_BEARING, i34);
        this.mTagInfo.put(TAG_GPS_DEST_DISTANCE_REF, i31);
        this.mTagInfo.put(TAG_GPS_DEST_DISTANCE, i34);
        int i36 = 458752 | flagsFromAllowedIfds4 | 0;
        this.mTagInfo.put(TAG_GPS_PROCESSING_METHOD, i36);
        this.mTagInfo.put(TAG_GPS_AREA_INFORMATION, i36);
        this.mTagInfo.put(TAG_GPS_DATE_STAMP, i30 | 11);
        this.mTagInfo.put(TAG_GPS_DIFFERENTIAL, flagsFromAllowedIfds4 | 196608 | 11);
        this.mTagInfo.put(TAG_INTEROPERABILITY_INDEX, (getFlagsFromAllowedIfds(new int[]{3}) << 24) | STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_VIDEO | 0);
    }

    protected static int[] getAllowedIfdsFromInfo(int i) {
        int allowedIfdFlagsFromInfo = getAllowedIfdFlagsFromInfo(i);
        int[] ifds = OppoIfdData.getIfds();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            if (((allowedIfdFlagsFromInfo >> i3) & 1) == 1) {
                arrayList.add(Integer.valueOf(ifds[i3]));
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            iArr[i2] = ((Integer) it.next()).intValue();
            i2++;
        }
        return iArr;
    }

    protected static boolean isIfdAllowed(int i, int i2) {
        int[] ifds = OppoIfdData.getIfds();
        int allowedIfdFlagsFromInfo = getAllowedIfdFlagsFromInfo(i);
        for (int i3 = 0; i3 < ifds.length; i3++) {
            if (i2 == ifds[i3] && ((allowedIfdFlagsFromInfo >> i3) & 1) == 1) {
                return true;
            }
        }
        return false;
    }

    protected static int getFlagsFromAllowedIfds(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return 0;
        }
        int[] ifds = OppoIfdData.getIfds();
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int length = iArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (ifds[i2] == iArr[i3]) {
                    i |= 1 << i2;
                    break;
                }
                i3++;
            }
        }
        return i;
    }
}
