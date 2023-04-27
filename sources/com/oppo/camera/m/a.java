package com.oppo.camera.m;

import android.content.Context;
import android.graphics.Bitmap;
import com.oppo.camera.aps.adapter.ApsExifData;
import com.oppo.camera.aps.constant.ApsConstant;
import com.oppo.camera.e;
import com.oppo.camera.jni.FormatConverter;
import com.oppo.camera.util.Util;
import com.oppo.camera.z;
import com.oppo.exif.OppoExifInterface;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/* compiled from: HeicProcessUtil */
public class a {
    public static OppoExifInterface a(ApsExifData apsExifData, long j) {
        if (apsExifData == null) {
            e.e("HeicProcessUtil", "buildExifInterface, exifData is null!");
            return null;
        }
        OppoExifInterface oppoExifInterface = new OppoExifInterface();
        if (apsExifData.mExifManufacture != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_MAKE, apsExifData.mExifManufacture));
        }
        if (apsExifData.mExifModel != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_MODEL, apsExifData.mExifModel));
        }
        if (apsExifData.mExifDateTime != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_DATE_TIME, apsExifData.mExifDateTime));
        }
        if (apsExifData.mExifDateTime != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_DATE_TIME_ORIGINAL, apsExifData.mExifDateTime));
        }
        if (apsExifData.mExifDateTime != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_DATE_TIME_DIGITIZED, apsExifData.mExifDateTime));
        }
        if (apsExifData.mExifSubDateTime != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_SUB_SEC_TIME, apsExifData.mExifSubDateTime));
        }
        ZonedDateTime ofInstant = ZonedDateTime.ofInstant(Instant.ofEpochMilli(j), ZoneId.systemDefault());
        if (!(ofInstant == null || ofInstant.getOffset() == null)) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_OFFSET_TIME_ORIGINAL, 2, ofInstant.getOffset().toString()));
        }
        if (apsExifData.mExifSubDateTime != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_SUB_SEC_TIME_ORIGINAL, apsExifData.mExifSubDateTime));
        }
        if (apsExifData.mExifSubDateTime != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_SUB_SEC_TIME_DIGITIZED, apsExifData.mExifSubDateTime));
        }
        if (apsExifData.mExifComments != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_USER_COMMENT, apsExifData.mExifComments));
        }
        if (apsExifData.mExifFNumber != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_F_NUMBER, apsExifData.mExifFNumber));
        }
        if (apsExifData.mExifExpTime != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_EXPOSURE_TIME, apsExifData.mExifExpTime));
        }
        if (apsExifData.mExifAperture != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_APERTURE_VALUE, apsExifData.mExifAperture));
        }
        if (apsExifData.mExifExposureBias != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_EXPOSURE_BIAS_VALUE, apsExifData.mExifExposureBias));
        }
        if (apsExifData.mImageWidth != 0) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_IMAGE_WIDTH, Integer.valueOf(apsExifData.mImageWidth)));
        }
        if (apsExifData.mImageHeight != 0) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_IMAGE_LENGTH, Integer.valueOf(apsExifData.mImageHeight)));
        }
        if (apsExifData.mTiffYcrcbPositioning != 0) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_Y_CB_CR_POSITIONING, Integer.valueOf(apsExifData.mTiffYcrcbPositioning)));
        }
        if (apsExifData.mTiffResolutionUnit != 0) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_RESOLUTION_UNIT, Integer.valueOf(apsExifData.mTiffResolutionUnit)));
        }
        if (apsExifData.mTiffXResolution != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_X_RESOLUTION, apsExifData.mTiffXResolution));
        }
        if (apsExifData.mTiffYResolution != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_Y_RESOLUTION, apsExifData.mTiffYResolution));
        }
        if (apsExifData.mExifFocalLength != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_FOCAL_LENGTH, apsExifData.mExifFocalLength));
        }
        if (apsExifData.mExifRotate >= 0) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_ORIENTATION, Integer.valueOf(apsExifData.mExifRotate)));
        }
        if (-1 != apsExifData.mExifIso) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_ISO_SPEED_RATINGS, Short.valueOf((short) ((int) apsExifData.mExifIso))));
        }
        if (-1 != apsExifData.mExifWhiteBalanceMode) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_WHITE_BALANCE, Integer.valueOf(apsExifData.mExifWhiteBalanceMode)));
        }
        if (-1 != apsExifData.mFlashValue) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_FLASH, Integer.valueOf(apsExifData.mFlashValue)));
        }
        if (apsExifData.mExifExposureProgram != 0) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_EXPOSURE_PROGRAM, Integer.valueOf(apsExifData.mExifExposureProgram)));
        }
        if (apsExifData.mExifVersion != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_EXIF_VERSION, apsExifData.mExifVersion));
        }
        if (apsExifData.mExifComponentsConfig != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_COMPONENTS_CONFIGURATION, apsExifData.mExifComponentsConfig));
        }
        if (apsExifData.mExifShutterSpeed != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_SHUTTER_SPEED_VALUE, apsExifData.mExifShutterSpeed));
        }
        if (apsExifData.mExifBrightness != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_BRIGHTNESS_VALUE, apsExifData.mExifBrightness));
        }
        if (apsExifData.mExifMaxAperture != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_MAX_APERTURE_VALUE, apsExifData.mExifMaxAperture));
        }
        if (apsExifData.mExifMeteringMode != 0) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_METERING_MODE, Integer.valueOf(apsExifData.mExifMeteringMode)));
        }
        if (apsExifData.mExifMakerNote != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_MAKER_NOTE, apsExifData.mExifMakerNote));
        }
        if (apsExifData.mExifFlashPixVersion != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_FLASHPIX_VERSION, apsExifData.mExifFlashPixVersion));
        }
        if (apsExifData.mExifColorSpace != 0) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_COLOR_SPACE, Integer.valueOf(apsExifData.mExifColorSpace)));
        }
        if (apsExifData.mExifSensingMethod != 0) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_SENSING_METHOD, Integer.valueOf(apsExifData.mExifSensingMethod)));
        }
        if (apsExifData.mExifSceneType != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_SCENE_TYPE, apsExifData.mExifSceneType));
        }
        if (apsExifData.mExifExposureMode != 0) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_EXPOSURE_MODE, Integer.valueOf(apsExifData.mExifExposureMode)));
        }
        if (apsExifData.mExifFocalLength35Mm != 0) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_FOCAL_LENGTH_IN_35_MM_FILE, Integer.valueOf(apsExifData.mExifFocalLength35Mm)));
        }
        if (apsExifData.mExifSceneCaptureType != 0) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_SCENE_CAPTURE_TYPE, Integer.valueOf(apsExifData.mExifSceneCaptureType)));
        }
        if (apsExifData.mInteropIndexStr != null) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_INTEROPERABILITY_INDEX, apsExifData.mInteropIndexStr));
        }
        if (apsExifData.mbSupportLocation) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_GPS_LATITUDE_REF, apsExifData.mExifLatitudeRef));
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_GPS_LATITUDE, apsExifData.mExifLatitude));
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_GPS_LONGITUDE_REF, apsExifData.mExifLongitudeRef));
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_GPS_LONGITUDE, apsExifData.mExifLongitude));
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_GPS_ALTITUDE_REF, Integer.valueOf(apsExifData.mExifAltitudeRef)));
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_GPS_ALTITUDE, apsExifData.mExifAltitude));
        }
        if (apsExifData.mbSupportLocationTimeStamp) {
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_GPS_DATE_STAMP, apsExifData.mDocExifGpsDateStamp));
            oppoExifInterface.setTag(oppoExifInterface.buildTag(OppoExifInterface.TAG_GPS_TIME_STAMP, apsExifData.mDocExifGpsTimeStamp));
        }
        return oppoExifInterface;
    }

    public static void a(z.a aVar, Context context) {
        if (ApsConstant.CAPTURE_MODE_PANORAMA.equals(aVar.k)) {
            aVar.N = com.oppo.camera.panorama.e.a(context, aVar.e, aVar.q, aVar.r);
            return;
        }
        aVar.N = Util.a(aVar.q, aVar.r, Bitmap.Config.ARGB_8888);
        FormatConverter formatConverter = new FormatConverter();
        FormatConverter formatConverter2 = formatConverter;
        long nv21ToBitmapInit = formatConverter2.nv21ToBitmapInit(aVar.q, aVar.r, aVar.s, aVar.t, aVar.s, aVar.q, aVar.r, 1.0f, 1, 0, 0, 0, 2);
        formatConverter2.nv21ToBitmapProcess(nv21ToBitmapInit, aVar.e, 0, aVar.N, aVar.q);
        formatConverter.nv21ToBitmapUnInit(nv21ToBitmapInit);
    }
}
