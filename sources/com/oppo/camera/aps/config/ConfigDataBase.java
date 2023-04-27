package com.oppo.camera.aps.config;

import android.content.Context;
import com.anc.humanvideo.BuildConfig;
import com.oppo.camera.MyApplication;
import com.oppo.camera.aps.adapter.ApsUtils;
import com.oppo.camera.aps.update.UpdateHelper;
import com.oppo.camera.e;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.statistics.model.FilmModeMsgData;
import com.oppo.camera.statistics.model.FocusAimMsgData;
import com.oppo.camera.statistics.model.MenuClickMsgData;
import com.oppo.camera.ui.menu.b;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigDataBase {
    protected static final String BACK_DEFAULT = "_back_camera";
    protected static final String BACK_SUPPORTED = "_back_camera_supported";
    protected static final String DEFAULT = "_default";
    protected static final String FRONT_DEFAULT = "_front_camera";
    protected static final String FRONT_SUPPORTED = "_front_camera_supported";
    public static final String KEY_10_BITS_HEIC_ENCODE_SUPPORT = "com.oplus.10bits.heic.encode.support";
    public static final String KEY_AF_HYPERFOCALDISTANCE_SUPPORT = "com.oplus.af.hyperfocaldistance";
    public static final String KEY_AIS_SNAPSHOT_USE_MFNR = "com.oplus.aissnapshot.use.mfnr";
    public static final String KEY_AI_ENHANCEMENT_FRONT_VIDEO = "com.oplus.feature.ai.enhancement.front.video.support";
    public static final String KEY_AI_ENHANCEMENT_REAR_VIDEO_1080P_SIZE = "com.oplus.feature.ai.enhancement.rear.video.1080p.support";
    public static final String KEY_AI_ENHANCEMENT_VIDEO = "com.oplus.feature.ai.enhancement.video.support";
    public static final String KEY_AI_VIDEO_ENHANCE_FRONT_RESOLUTION = "com.oplus.feature.ai.enhancement.video.front.resolution";
    public static final String KEY_AI_VIDEO_ENHANCE_REAR_RESOLUTION = "com.oplus.feature.ai.enhancement.video.rear.resolution";
    public static final String KEY_ALIGNED_BITS = "com.oplus.aligned.bits";
    public static final String KEY_ALLMIGHTY_VIDEO = "com.oplus.feature.allmighty.video.support";
    public static final String KEY_ANIMOJI = "com.oplus.app.feature.animoji.support";
    public static final String KEY_APS_SUPPORT_VIDEO_SUPER_EIS = "com.oplus.aps.support.video.super.eis";
    public static final String KEY_ARCSOFT_SINGLE_BOKEH_SUPPORT = "com.oplus.feature.arscoft.single.bokeh.support";
    public static final String KEY_ATHENA_SUPPORT = "com.oplus.athena.support";
    public static final String KEY_BACK_NIGHT_LOW_MEMORY_RAW_PICTURE_SIZE = "com.oplus.back.night.low.memory.raw.picturesize";
    public static final String KEY_BACK_NIGHT_RAW_PICTURE_SIZE = "com.oplus.back.night.raw.picturesize";
    public static final String KEY_BACK_PORTRAIT_NORMAL_MODE_PIC_SIZE = "com.oplus.tunning.back.portrait.normal.picturesize";
    public static final String KEY_BACK_PURE_3RD_BOKEH_PREVIEW = "com.oplus.back.pure.3rd.bokeh.preview.support";
    public static final String KEY_BEAUTY3D = "com.oplus.feature.beauty3d.support";
    public static final String KEY_BOKEH_BEAUTY_OPEN_DEFAULT = "com.oplus.bokeh.beauty.open.default";
    public static final String KEY_BOKEH_BEAUTY_SUPPORT = "com.oplus.bokeh.beauty.support";
    public static final String KEY_BURSTSHOT_THUMB_ANIM_STEP_TIME = "com.oplus.feature.burstshot.thumb.anim.step.time";
    public static final String KEY_BURST_SHOT_CACHE_SUPPORT = "com.oplus.burstshot.cache.support";
    public static final String KEY_CACHE_CLICK_CAPTURE_SUPPORT = "com.oplus.cache.click.capture.support";
    public static final String KEY_CAMERA_VIDEO_BRIGHTNESS = "com.oplus.camera.video.brightness";
    public static final String KEY_CAPTURE_WITH_DETACH = "com.oplus.capture.with.detach";
    public static final String KEY_COMMON_AUTO_NIGHT_SCENCE = "com.oplus.feature.auto.night.scence.support";
    public static final String KEY_CONTROL_PREVIEW_SIZE = "com.oplus.control.preview.sizes";
    public static final String KEY_CSHOT_FIRST_REQUEST_NUM = "com.oplus.tunning.continue.shot.first.request.num";
    public static final String KEY_CUSTOM_BEAUTY_FRONT_VIDEO = "com.oplus.feature.custom.beauty.front.video.support";
    public static final String KEY_CUSTOM_CAMERA_REAR_NUM = "com.oplus.camera.rear.num";
    public static final String KEY_DECREASE_BRIGHTNESS_SUPPORT = "com.oplus.decrease.brightness.support";
    public static final String KEY_DEFAULT_SENSOR_SIZE_SCALE = "com.oplus.default.sensor.size.scale";
    public static final String KEY_DEFAULT_TO_FRONT_SWITCH_ANIM_TIME = "com.oplus.tunning.rear.to.front.switchtime";
    public static final String KEY_DEFAULT_TO_REAL_SWITCH_ANIM_TIME = "com.oplus.tunning.front.to.rear.switchtime";
    public static final String KEY_DISABLE_RAW = "com.oplus.disable.raw";
    public static final String KEY_DOUBLE_EXPOSURE_SUPPORT = "com.oplus.feature.doubleexposure.support";
    public static final String KEY_FACE_BEAUTY_PREVIEW_SIZE = "com.oplus.feature.facebeauty.previewsize";
    public static final String KEY_FACE_BEAUTY_PREVIEW_SIZE_SUPPORT = "com.oplus.feature.facebeauty.previewsize.support";
    public static final String KEY_FACE_BEAUTY_VERSION_CODE = "com.oplus.facebeauty.version";
    public static final String KEY_FACE_RECTIFY_CONFIG_VALUE = "com.oplus.face.rectify.config.value";
    public static final String KEY_FACE_RECTIFY_SUPPORT = "com.oplus.face.rectify.support";
    public static final String KEY_FEATURE_DCIP3_SUPPORT = "com.oplus.feature.DCIP3.support";
    public static final String KEY_FIXED_FPS_IN_4K = "com.oplus.video.fixed.fps.in.4k";
    public static final String KEY_FRONT_INVERSE_COLOR = "com.oplus.front.inverse.color";
    public static final String KEY_FRONT_PANORAMA_MAX_HEIGHT = "com.oplus.tunning.front.panorama.max.height";
    public static final String KEY_FRONT_PORTRAIT_NORMAL_MODE_PIC_SIZE = "com.oplus.front.portrait.normal.picturesize";
    public static final String KEY_FRONT_PORTRAIT_PREVIEW_SIZE = "com.oplus.front.portrait.previewsize";
    public static final String KEY_FRONT_SENSOR_BINNING = "com.oplus.front.sensor.binning";
    public static final String KEY_FRONT_SUPER_EIS_AND_AI_VIDEO_ENHANCE_COEXIST = "com.oplus.feature.front.super.eis.ai.enhance.coexist";
    public static final String KEY_FRONT_TORCH_COLOR = "com.oplus.front.torch.color";
    public static final String KEY_GROUP_SHOT = "com.oplus.feature.groupshot.support";
    public static final String KEY_HAL_MEMORY_COMMON = "com.oplus.hal.memory.common";
    public static final String KEY_HAL_MEMORY_COMMON_12G = "com.oplus.hal.memory.common.12G";
    public static final String KEY_HAL_MEMORY_COMMON_6G = "com.oplus.hal.memory.common.6G";
    public static final String KEY_HAL_MEMORY_COMMON_8G = "com.oplus.hal.memory.common.8G";
    public static final String KEY_HAL_MEMORY_COMMON_SUPPORT_DIFFERENCE = "com.oplus.hal.memory.common.support.difference";
    public static final String KEY_HAL_MEMORY_HIGH_DEFINITION = "com.oplus.hal.memory.highDefinition";
    public static final String KEY_HAL_MEMORY_NIGHT = "com.oplus.hal.memory.night";
    public static final String KEY_HAL_MEMORY_PANORAMA = "com.oplus.hal.memory.panorama";
    public static final String KEY_HAL_MEMORY_PORTRAIT = "com.oplus.hal.memory.portrait";
    public static final String KEY_HAL_MEMORY_PROFESSIONAL = "com.oplus.hal.memory.professional";
    public static final String KEY_HAL_MEMORY_STICKER = "com.oplus.hal.memory.sticker";
    public static final String KEY_HIGHPICTURE_PRO_MODE_SUPPORT = "com.oplus.highpicture.pro.support";
    public static final String KEY_HIGH_MFNR_PICTURE_SIZE = "com.oplus.high.mfnr.picturesize";
    public static final String KEY_HIGH_PICTURE_SIZE = "com.oplus.high.picturesize";
    public static final String KEY_HIGH_PICTURE_SIZE_FRONT = "com.oplus.high.picturesize_front";
    public static final String KEY_HIGH_PICTURE_SIZE_NAME = "com.oplus.high.picturesize.name";
    public static final String KEY_HIGH_PICTURE_SIZE_NAME_FRONT = "com.oplus.high.picturesize.name_front";
    public static final String KEY_HIGH_TEMPERATURE_ULTIMATE_LIMIT = "com.oplus.tunning.temperature.ultimate.limit";
    public static final String KEY_HW_MANUFACTURER_QUALCOMM = "com.oplus.feature.hw.manufacturer.qualcomm";
    public static final String KEY_HYPER_LAPSE = "com.oplus.feature.hyper.lapse.support";
    public static final String KEY_HYPER_LAPSE_ULTRA_WIDE_SUPPORT = "com.oplus.feature.video.hyper.lapse.ultra.wide.support";
    public static final String KEY_ID_PHOTO = "com.oplus.feature.id.photo.support";
    public static final String KEY_INSENSOR_ZOOM_POINT_3X_SUPPORT = "com.oplus.zoom.point.3x.support";
    public static final String KEY_IS_UW_FIXED_FOCUS = "com.oplus.isUWFixedFocus";
    public static final String KEY_LOCK_AE_BEFORE_CAPTURE_SUPPORT = "com.oplus.lock.ae.before.capture.support";
    public static final String KEY_LOW_MEMORY_MAX_BURST_SHOT_NUM = "com.oplus.low.memory.max.burst.shot.num";
    public static final String KEY_MACROLENS_EQUAL_ULTRAWIDELENS = "com.oplus.feature.macrolens.equal.ultrawidelens";
    public static final String KEY_MACRO_BEST_FOCUS_DISTANCE = "com.oplus.macro.best.focus.distance";
    public static final String KEY_MAINCAMERA_ASD_AISCENE_SUPPORT = "com.oplus.maincamera.asd.aiscene.support";
    public static final String KEY_MEMORY_NOT_ENOUGH_HINT = "com.oplus.memory.not.enough.hint";
    public static final String KEY_MEMORY_NOT_ENOUGH_PORTRAIT_HINT = "com.oplus.memory.not.enough.portrait.hint";
    public static final String KEY_MFNR = "com.oplus.mfnr.support";
    public static final String KEY_MICROSCOPE_SUPPORT = "com.oppo.feature.microscope.support";
    public static final String KEY_MOTOR_DOWN_DELAY = "com.oplus.motor.down.delay";
    public static final String KEY_MOTOR_FLASHLIGHT = "com.oplus.feature.motor.flashlight.support";
    public static final String KEY_MOVIE_DEFAULT_VIDEO_FRAME_RECORD_SUPPORT = "com.oplus.movie.default.video.frame.record.support";
    public static final String KEY_MOVIE_ULTRA_WIDE_FLASH_EIS_SUPPORT = "com.oplus.feature.movie_ultra_wide_flash_eis_support";
    public static final String KEY_MTK_FACE_BEAUTY_REMOSAIC_SUPPORT = "com.oplus.feature.mtk.face.beauty.remosaic.support";
    public static final String KEY_MULTI_VIDEO_MODE_1080P_SUPPORT = "com.oplus.multi.video.mode.1080p.support";
    public static final String KEY_MULTI_VIDEO_MODE_SUPPORT = "com.oplus.multi.video.mode.support";
    public static final String KEY_NEED_HAL_HANDING_FACE_BEAUTY = "com.oplus.need.hal.handler.facebeauty";
    public static final String KEY_NIGHT = "com.oplus.feature.suppernight.support";
    public static final String KEY_NIGHT_FILTER_SUPPORT = "com.oplus.night.filter.support";
    public static final String KEY_NIGHT_FILTER_TYPE_LIST = "com.oplus.night.filter.type.list";
    public static final String KEY_NIGHT_MODE_DELETE_RECTANGLESIZE = "com.oplus.night.mode.delete.rectanglesize";
    public static final String KEY_NIGHT_PICTURE_HAND_PROCESS_TIME = "com.oplus.night.hand.process.time";
    public static final String KEY_NIGHT_PICTURE_TIMER_SUPPORT = "com.oplus.night.picture.timer.support";
    public static final String KEY_NIGHT_PRO_MODE_SUPPORT = "com.oplus.night.pro.support";
    public static final String KEY_NIGHT_SENSOR_MASK_SUPPORT = "com.oplus.night.sensor.mark.support";
    public static final String KEY_NIGHT_STARRY_MODE_ZOOM_SUPPORT = "com.oplus.night.starry.zoom.support";
    public static final String KEY_NIGHT_TRIPOD_RAM_THRESHOLD = "com.oplus.night.tripod.ram.threshold";
    public static final String KEY_NIGHT_TRIPOD_SUPPORT = "com.oplus.night.tripod.support";
    public static final String KEY_NIGHT_TRIPOD_ZOOM_HIDE_ULTRA_WIDE = "com.oplus.night.tripod.zoom.hide.ultra.wide.support";
    public static final String KEY_NONE_SAT_FRONT_MODE = "com.oplus.feature.none.sat.front.mode";
    public static final String KEY_NONE_SAT_REAR_MODE = "com.oplus.feature.none.sat.rear.mode";
    public static final String KEY_NONE_SAT_TELE_SUPPORT = "com.oplus.feature.none.sat.tele.support";
    public static final String KEY_PANORAMA_TO_FRONT_SWITCH_ANIM_TIME = "com.oplus.tunning.panorama.rear.to.front.switchtime";
    public static final String KEY_PANORAMA_TO_REAL_SWITCH_ANIM_TIME = "com.oplus.tunning.panorama.front.to.rear.switchtime";
    public static final String KEY_PI = "com.oplus.feature.pi.support";
    public static final String KEY_PI_AI = "com.oplus.feature.pi.ai.support";
    public static final String KEY_PORTRAIT_BLUR_LEVEL_ENABLE = "com.oplus.portrait.blur.level.enable";
    public static final String KEY_PORTRAIT_FRONT_MAX_SIZE_SUPPORT = "com.oplus.portrait.front.max.size.support";
    public static final String KEY_PORTRAIT_FRONT_RETENTION_SUPPORT = "com.oplus.feature.portrait.front.retention.support";
    public static final String KEY_PORTRAIT_HALF_BODY_REMOSAIC_SUPPORT = "com.oplus.portrait.half.body.remosaic.support";
    public static final String KEY_PORTRAIT_HALF_BODY_SUPPORT = "com.oplus.portrait.half.body.support";
    public static final String KEY_PORTRAIT_MODE_PHYSICAL_CAMERAID_1X = "com.oplus.portrait.mode.physical.cameraid.1x";
    public static final String KEY_PORTRAIT_MODE_PHYSICAL_CAMERAID_2X = "com.oplus.portrait.mode.physical.cameraid.2x";
    public static final String KEY_PORTRAIT_MODE_PICTURE_SIZE_1X = "com.oplus.portrait.mode.picture.size.1x";
    public static final String KEY_PORTRAIT_MODE_PICTURE_SIZE_2X = "com.oplus.portrait.mode.picture.size.2x";
    public static final String KEY_PORTRAIT_MODE_SET_DEFAULT_LOGIC_CAMERA_TYPE = "com.oplus.portrait.mode.default.logic.camera.type";
    public static final String KEY_PORTRAIT_NEON_SUPPORT = "com.oplus.feature.portrait.neon.support";
    public static final String KEY_PORTRAIT_NEW_STYLE = "com.oplus.feature.portrait.new.style.support";
    public static final String KEY_PORTRAIT_REAR_NEON_SUPPORT_FILTER = "com.oplus.portrait.rear.neon.support.filter";
    public static final String KEY_PORTRAIT_RETENTION_SUPPORT = "com.oplus.feature.portrait.retention.support";
    public static final String KEY_PORTRAIT_SINGLE_BLUR_MODEL = "com.oplus.portrait.single_blur.model";
    public static final String KEY_PORTRAIT_SINGLE_BLUR_OPERATING = "com.oplus.portrait.single_blur_operating";
    public static final String KEY_PORTRAIT_STREAMER_SUPPORT = "com.oplus.feature.portrait.streamer.support";
    public static final String KEY_PORTRAIT_ZOOM_VALUE_DEFAULT = "com.oplus.portrait.zoom.value.default";
    public static final String KEY_PREVIEW_BUFFER_CACHE_SUPPORT = "com.oplus.preview.buffer.cache.support";
    public static final String KEY_PREVIEW_FPS_HFR_1080P = "com.oplus.tunning.1080p.hfr.fps";
    public static final String KEY_PREVIEW_FPS_HFR_720P = "com.oplus.tunning.720p.hfr.fps";
    public static final String KEY_PREVIEW_YUV_FORMAT_NV12 = "com.oplus.preview.format.nv12";
    public static final String KEY_PROFESSIONAL_RAW_CAMERA_TYPE_SUPPORT = "com.oplus.feature.raw.camera.type.support";
    public static final String KEY_PROFESSIONAL_SWITCH_CAMERA_TYPE = "com.oplus.professional.switch.camera.type";
    public static final String KEY_QUADCFA_BLURLESS = "com.oplus.quadcfa.blurless";
    public static final String KEY_QUALCOMM_PHYSICAL_ID_SUPPORT = "com.oplus.qualcomm.physical.id.support";
    public static final String KEY_QUALITY_HIGH_1080P_SUPPORT = "com.oplus.quality.high.1080p.support";
    public static final String KEY_RAW_ZOOM_MUTEX_SUPPORT = "com.oplus.feature.raw.zoom.mutex.support";
    public static final String KEY_REAR_PANORAMA_MAX_HEIGHT = "com.oplus.tunning.rear.panorama.max.height";
    public static final String KEY_REAR_PORTRAIT_PREVIEW_SIZE = "com.oplus.rear.portrait.previewsize";
    public static final String KEY_SAT_MAIN_ZOOM_RANGE = "com.oplus.sat.main.zoom.range";
    public static final String KEY_SAT_NEED_SET_ZOOMRATIO = "com.oplus.sat.need.set.zoomratio";
    public static final String KEY_SAT_SUPPORT_PREVERSION = "com.oplus.sat.support.preversion";
    public static final String KEY_SAT_TELE_PICTURE_SIZE = "com.oplus.sat.tele.support.imagesizes";
    public static final String KEY_SAT_TELE_ZOOM_RANGE = "com.oplus.sat.tele.zoom.range";
    public static final String KEY_SAT_ULTRAWIDE_ZOOM_RANGE = "com.oplus.sat.ultrawide.zoom.range";
    public static final String KEY_SAT_ULTRA_PICTURE_SIZE = "com.oplus.sat.ultra.support.imagesizes";
    public static final String KEY_SAT_USE_HAL = "com.oplus.sat.use.hal";
    public static final String KEY_SAT_WIDE_PICTURE_SIZE = "com.oplus.sat.wide.support.imagesizes";
    public static final String KEY_SAVE_JPG_AFTER_PAUSE = "com.oplus.feature.postprocess.savejpeg.support";
    public static final String KEY_SCREEN_BRIGHTNESS_RECOVER_THRESHOLD = "com.oplus.feature.screen.bright.recover.threshold";
    public static final String KEY_SCREEN_BRIGHTNESS_THRESHOLD = "com.oplus.feature.screen.bright.threshold";
    public static final String KEY_SCREEN_BRIGHTNESS_VALUE = "com.oplus.feature.screen.bright.value";
    public static final String KEY_SCREEN_BRIGHTNESS_VIDEO_VALUE = "com.oplus.feature.screen.bright.video.value";
    public static final String KEY_SHARE_EDIT_SUPPORT = "com.oplus.share.edit.support";
    public static final String KEY_SINGLE_CAMERA_USE_COMMOM_PORTRAIT_PREVIEW_SIZE = "com.oplus.single.camera.use.commom.portrait.previewsize";
    public static final String KEY_SLOGAN_LOCATION_SUPPORT = "com.oplus.feature.slogan.location.support";
    public static final String KEY_SLOW_MOTION_H265_SUPPORT = "com.oplus.slowmotion.h265.support";
    public static final String KEY_SLOW_VIDEO_1080P_DEFAULT_VALUE = "com.oplus.slow.video.1080p.default.value";
    public static final String KEY_SLOW_VIDEO_720P_DEFAULT_VALUE = "com.oplus.slow.video.720p.default.value";
    public static final String KEY_SLOW_VIDEO_HFR_120FPS_VIDOETYPE = "com.oplus.slow.video.hfr.120fps.videotype";
    public static final String KEY_SLOW_VIDEO_HFR_240FPS_VIDOETYPE = "com.oplus.slow.video.hfr.240fps.videotype";
    public static final String KEY_SLOW_VIDEO_HFR_480FPS_VIDOETYPE = "com.oplus.slow.video.hfr.480fps.videotype";
    public static final String KEY_SLOW_VIDEO_HFR_960FPS_VIDOETYPE = "com.oplus.slow.video.hfr.960fps.videotype";
    public static final String KEY_SLOW_VIDEO_RED_DOT_SUPPORT = "com.oplus.feature.slow.video.red.dot.support";
    public static final String KEY_STARRY_MODE_CAPTURE_EXPOSURETIME = "com.oplus.starry.capture.exposuretime";
    public static final String KEY_STARRY_MODE_CAPTURE_ISO = "com.oplus.starry.capture.iso";
    public static final String KEY_STARRY_MODE_PROCESS_TIME = "com.oplus.starry.process.time";
    public static final String KEY_STARRY_MODE_SUPPORT_PREVERSION = "com.oplus.starry.mode.support.preversion";
    public static final String KEY_STAR_VIDEO_SIZE_TYPE = "com.oplus.star.video.size.type";
    public static final String KEY_STICKER = "com.oplus.app.feature.sticker.support";
    public static final String KEY_STICKER_SUPPORT_MAX_FACE_NUM = "com.oplus.sticker.support.max.face.num";
    public static final String KEY_STICKER_TARGET_PREVIEW_HEIGHT = "com.oplus.sticker_target_preview_height";
    public static final String KEY_STICKER_USE_NV12 = "com.oplus.sticker.use.nv12";
    public static final String KEY_STREAM_SUPPORT_PREVERSION = "com.oplus.stream.support.preversion";
    public static final String KEY_SUPER_CLEAR_PORTRAIT = "com.oplus.feature.super.clear.portrait.support";
    public static final String KEY_SUPER_NIGHT_CAMERA_MODE = "com.oplus.tunning.super.night.camera.mode";
    public static final String KEY_SUPER_TEXT = "com.oplus.feature.super.text.support";
    public static final String KEY_SUPER_TEXT_CPU_PROCESS = "com.oplus.feature.super.text.cpu.process";
    public static final String KEY_SUPER_TEXT_SCANNER_SUPPORT = "com.oplus.feature.super.text.scanner.support";
    public static final String KEY_SUPPORT_ALLMIGHTY_VIDEO_SCENE = "com.oplus.feature.allmighty.video.scene.support";
    public static final String KEY_SUPPORT_ALLMIGHTY_VIDEO_SCENE_FUNCTION_OFF = "com.oplus.feature.allmighty.video.scene.function.off.support";
    public static final String KEY_SUPPORT_AUTO_MICRO = "com.oplus.feature.auto.micro";
    public static final String KEY_SUPPORT_BACK_DARK_TIPS_THRESHOLD = "com.oplus.feature.back.dark.tips.threshold";
    public static final String KEY_SUPPORT_BREENO_SCAN = "com.oplus.feature.breeno.scan";
    public static final String KEY_SUPPORT_CAPTURE_RAW = "com.oplus.feature.capture.mode.raw.support";
    public static final String KEY_SUPPORT_DEFAULT_VIDEO_FRAME_RECORD = "com.oplus.feature.default.video.frame.record.support";
    public static final String KEY_SUPPORT_DIRTY_DETECT = "com.oplus.feature.dirty.detect.support";
    public static final String KEY_SUPPORT_DUMP_960FPS_ORIGINAL = "com.oplus.dump.960fps.original.support";
    public static final String KEY_SUPPORT_EIS_PRO_LOW_LIGHT_HINT = "com.oplus.feature.eis.pro.low.light.hint.support";
    public static final String KEY_SUPPORT_END_VIDEO_EIS_STREAM = "com.oplus.feature.end.video.eis.stream.support";
    public static final String KEY_SUPPORT_FAST_VIDEO_SAT = "com.oplus.feature.fast.video.sat.support";
    public static final String KEY_SUPPORT_FLASH_FULL_ZOOM = "com.oplus.feature.flash.full.zoom.support";
    public static final String KEY_SUPPORT_FRONT_720P_SLOW_VIDEO = "com.oplus.feature.front.720p.slow.video.support";
    public static final String KEY_SUPPORT_FRONT_AI_VIDEO_SCENE = "com.oplus.feature.front.ai.video.scene.support";
    public static final String KEY_SUPPORT_FRONT_DARK_TIPS_THRESHOLD = "com.oplus.feature.front.dark.tips.threshold";
    public static final String KEY_SUPPORT_FRONT_FACE_POINT_ANIMATION = "com.oplus.front.face.point.animaiton.support";
    public static final String KEY_SUPPORT_FRONT_SLOW_VIDEO = "com.oplus.feature.front.slow.video.support";
    public static final String KEY_SUPPORT_HIGH_DEFINITION = "com.oplus.feature.high.definition.support";
    public static final String KEY_SUPPORT_HIGH_PICTURE_ULTRA_RESOLUTION_MODE = "com.oplus.high.picturesize.ultra.resolution.mode.support";
    public static final String KEY_SUPPORT_HIGH_RESOLUTION = "com.oplus.high.resolution.support";
    public static final String KEY_SUPPORT_IMPRECISE_RAW_SIZE = "com.oplus.feature.imprecise.raw.size.support";
    public static final String KEY_SUPPORT_INSENSOR_ZOOM_20X = "com.oplus.feature.insensor.zoom.20x.support";
    public static final String KEY_SUPPORT_INTELLIGENT_HIGH_FRAME = "com.oplus.feature.intelligent.high.frame.support";
    public static final String KEY_SUPPORT_LANDSCAPE_CAMERA_SENSOR = "com.oplus.feature.landscape.camera.sensor.support";
    public static final String KEY_SUPPORT_MACRO_MODE = "com.oplus.feature.macro.mode.support";
    public static final String KEY_SUPPORT_MMCAMERA_PROFESSIONAL = "com.oplus.mmcamera.professional.support";
    public static final String KEY_SUPPORT_MOVIE_MODE = "com.oplus.feature.movie.mode.support";
    public static final String KEY_SUPPORT_MOVIE_MODE_V2 = "com.oplus.feature.movie.mode.V2.support";
    public static final String KEY_SUPPORT_MTK_INSENSOR_ZOOM = "com.oplus.feature.mtk.insensor.zoom";
    public static final String KEY_SUPPORT_NIGHT_GESTURE_SHUTTER = "com.oplus.support.night.gesture_shutter";
    public static final String KEY_SUPPORT_PANORAMA_REAR_PROCESS_IMAGE = "com.oplus.feature.panorama.rear.process.image";
    public static final String KEY_SUPPORT_PHOTO_CODEC = "com.oplus.feature.photocodec.support";
    public static final String KEY_SUPPORT_PORTRAIT = "com.oplus.feature.portrait.support";
    public static final String KEY_SUPPORT_PROFESSIONAL_RAW = "com.oplus.feature.professional.raw.support";
    public static final String KEY_SUPPORT_PROFESSIONAL_SUPER_RAW = "com.oplus.feature.professional.super.raw.support";
    public static final String KEY_SUPPORT_QR_CODE_ENABLE = "com.oplus.feature.qr.code.enable.support";
    public static final String KEY_SUPPORT_RAW_HDR = "com.oplus.support.raw.hdr";
    public static final String KEY_SUPPORT_SCREENHOLE = "com.oplus.feature.screenhole.support";
    public static final String KEY_SUPPORT_SCREEN_BRIGHTNESS = "com.oplus.feature.screen.bright.support";
    public static final String KEY_SUPPORT_SCREEN_BRIGHTNESS_PORTRAIT = "com.oplus.feature.screen.bright.portrait.support";
    public static final String KEY_SUPPORT_SCREEN_BRIGHTNESS_VIDEO = "com.oplus.feature.screen.bright.video.support";
    public static final String KEY_SUPPORT_SHOW_SOLOOP = "com.oplus.show.soloop.support";
    public static final String KEY_SUPPORT_SHOW_SOLOOP_SAME = "com.oplus.show.soloop.support.same";
    public static final String KEY_SUPPORT_SLOWMOTION_FOR_PLATFORM = "com.oplus.feature.slowmotion.platform";
    public static final String KEY_SUPPORT_SLOWVIDEO_1080P = "com.oplus.feature.slowvideo.1080p.support";
    public static final String KEY_SUPPORT_SLOW_VIDEO = "com.oplus.feature.slow.video.support";
    public static final String KEY_SUPPORT_SLOW_VIDEO_ZOOM = "com.oplus.feature.slow.video.zoom.support";
    public static final String KEY_SUPPORT_STARRY_MODE = "com.oplus.starry.support";
    public static final String KEY_SUPPORT_STAR_VIDEO = "com.oplus.star.video.support";
    public static final String KEY_SUPPORT_TILT_SHIFT = "com.oplus.feature.tilt.shift.support";
    public static final String KEY_SUPPORT_ULTAR_WIDE_VIDEO_4K_OR_60FPS = "com.oplus.ultra.wide.4K.or.60fps.support";
    public static final String KEY_SUPPORT_VIDEO_1080_60_FPS = "com.oplus.feature.video.1080p.60fps.support";
    public static final String KEY_SUPPORT_VIDEO_3HDR = "com.oplus.feature.video.3hdr.support";
    public static final String KEY_SUPPORT_VIDEO_3HDR_10BIT = "com.oplus.feature.video.3hdr.10bit.support";
    public static final String KEY_SUPPORT_VIDEO_4K_60FPS_ULTRA_WIDE = "com.oplus.feature.video.4k60fps.ultrawide.support";
    public static final String KEY_SUPPORT_VIDEO_4K_60_FPS = "com.oplus.feature.video.4k.60fps.support";
    public static final String KEY_SUPPORT_VIDEO_720_60_FPS = "com.oplus.feature.video.720p.60fps.support";
    public static final String KEY_SUPPORT_VIDEO_BLUR_1080P = "com.oplus.feature.video.blur.1080p.support";
    public static final String KEY_SUPPORT_VIDEO_BLUR_ULTRA_WIDE = "com.oplus.feature.videoblur.ultrawide.support";
    public static final String KEY_SUPPORT_VIDEO_DYNAMIC_FPS_RANGE = "com.oplus.feature.video.dynamic.fps.range.support";
    public static final String KEY_SUPPORT_VIDEO_ELEVATE_AUDIO_BIT_RATE = "com.oplus.feature.elevate.audio.bit.video.support";
    public static final String KEY_SUPPORT_VIDEO_FRONT_EIS = "com.oplus.feature.front.eis.support";
    public static final String KEY_SUPPORT_VIDEO_FRONT_EIS_FORCE_ULTRA_WIDE = "com.oplus.feature.front.eis.wide.force.support";
    public static final String KEY_SUPPORT_VIDEO_LIVE_HDR = "com.oplus.feature.video.live.hdr.support";
    public static final String KEY_SUPPORT_VIDEO_MODE_INERTIAL_ZOOM = "com.oplus.video.inertial.zoom.support";
    public static final String KEY_SUPPORT_VIDEO_SAT = "com.oplus.feature.video.sat.support";
    public static final String KEY_SUPPORT_VIDEO_SUPER_EIS_PROCESS = "com.oplus.feature.video.super.eis.support";
    public static final String KEY_SUPPORT_VIDEO_SUPER_EIS_WIDE = "com.oplus.feature.video.super.eis.wide.support";
    public static final String KEY_SUPPORT_VIDEO_SUPER_EIS_WIDE_60_FPS = "com.oplus.feature.video.super.eis.wide.60fps.support";
    public static final String KEY_SUPPORT_VIDEO_THUMBNAIL_SIMULTANEOUS_4K = "com.oplus.feature.video.4k.thumbnail.simultaneous.support";
    public static final String KEY_SUPPORT_VIVID_EFFECT = "com.oplus.feature.vivid.support";
    public static final String KEY_SUPPORT_YUV_NIGHT = "com.oplus.yuv.night.support";
    public static final String KEY_SURPERNIGHT_REPROCESS_EXTRA_YUV = "com.oplus.supernight.reprocess.extra.yuv";
    public static final String KEY_SURPERNIGHT_REPROCESS_PREVIEW = "com.oplus.surpernight.reprocess.preview.support";
    public static final String KEY_TEMPERATURE_CONTROL_STOP_VIDEO_RECORDING = "com.oplus.temperature.control.stop_video_recording";
    public static final String KEY_TORCH_FLASH = "com.oplus.torch.flash.support";
    public static final String KEY_TORCH_SOFT_LIGHT = "com.oplus.feature.torch.softlight.support";
    public static final String KEY_TRACK_FOCUS_SUPPORT = "com.oplus.track.focus.support";
    public static final String KEY_TRACK_FOCUS_ULTRA_WIDE_SUPPORT = "com.oplus.track.focus.ultra.wide.support";
    public static final String KEY_TUNING_DATA_BUFFER_SUPPORT = "com.oplus.tuning.data.buffer.support";
    public static final String KEY_UI_SHUTTER_BUTTON_TYPE_LOW_LIGHT = "com.oplus.ui.shutterbutton.type.lowlight";
    public static final String KEY_ULTRA_HIGH_RESOLUTION_FULL_ZOOM_SUPPORT = "com.oplus.feature.ultra.high.resolution.full.zoom.support";
    public static final String KEY_ULTRA_HIGH_RESOLUTION_SUPPORT = "com.oplus.feature.ultra.high.resolution.support";
    public static final String KEY_ULTRA_HIGH_RESOLUTION_SWITCH_CAMERA_SUPPORT = "com.oplus.ultra.high.resolution.switch.camera.support";
    public static final String KEY_ULTRA_NIGHT_VIDEO = "com.oplus.feature.ultra.night.video.support";
    public static final String KEY_ULTRA_NIGHT_VIDEO_WIDE_ANGLE = "com.oplus.feature.ultra.night.video.wide.angle.support";
    public static final String KEY_ULTRA_WIDE_ANGLE_SUPPORT = "com.oplus.ultrawide.support";
    public static final String KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE = "com.oplus.ultra.wide.high.picturesize";
    public static final String KEY_VIDEO_4K_TRACK_FOCUS_SUPPORT = "com.oplus.video.4k.track.focus.support";
    public static final String KEY_VIDEO_COLOR_EXTRACTION_SUPPORT = "com.oplus.video.color_extraction.support";
    public static final String KEY_VIDEO_EIS = "com.oplus.feature.video.eis.support";
    public static final String KEY_VIDEO_EIS_AF_AUTO_LOCK = "com.oplus.feature.video.eis.af.auto.lock";
    public static final String KEY_VIDEO_EIS_FPS = "com.oplus.feature.video.eis.fps";
    public static final String KEY_VIDEO_EIS_FPS_SETTING_SUPPORT = "com.oplus.feature.video.eis.fps.setting.suppot";
    public static final String KEY_VIDEO_EIS_PREVIEW_SCALE = "com.oplus.tunning.video.eis.preview.scale";
    public static final String KEY_VIDEO_EIS_SURFACE_SIZE = "com.oplus.feature.video.eis.surface.size";
    public static final String KEY_VIDEO_FRONT_FACE_BEAUTY_LEVEL = "com.oplus.video.front.facebeauty.level";
    public static final String KEY_VIDEO_NONE_SAT_ULTRA_WIDE_ANGLE_RESOLUTION_LIMIT = "com.oplus.feature.video.resolution.limit.ultrawide.support";
    public static final String KEY_VIDEO_RETENTION_SUPPORT = "com.oplus.video.retention.support";
    public static final String KEY_VIDEO_SAT_60FPS_MAIN_ZOOM_RANGE = "com.oplus.video.sat.60fps.main.zoom.range";
    public static final String KEY_VIDEO_SAT_MASK = "com.oplus.feature.video.sat.mask";
    public static final String KEY_VIDEO_SIZE_4K = "com.oplus.feature.video.4k.support";
    public static final String KEY_VIDEO_SUPER_EIS_WIDE_OPEN_DEFAULT = "com.oplus.feature.video.super.eis.wide.open.default";
    public static final String KEY_VIDEO_WATERMARK_HAL_SUPPORT = "com.oplus.video.watermark.hal.support";
    public static final String KEY_VIDEO_WATERMARK_SUPPORT = "com.oplus.video.watermark.support";
    public static final String KEY_VIDEO_WIDE_ONLY_MEDIACODEC_SUPPORT = "com.oplus.video.wide.only.mediacodec.support";
    public static final String KEY_WIDECAMERA_ASD_AISCENE_SUPPORT = "com.oplus.widecamera.asd.aiscene.support";
    public static final String KEY_WIDE_NORMAL_PREVIEW_SIZE = "com.oplus.feature.wide.normal.previewsize";
    public static final String KEY_WIDE_VIDEO_ONLY_720P_SUPPORT = "com.oplus.feature.wide.video.only720p.support";
    public static final String KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT = "com.oplus.feature.wide.angle.open.default";
    public static final String KEY_ZSL_SUPPORT_PREVERSION = "com.oplus.zsl.support.preversion";
    private static final String TAG = "ConfigDataBase";
    protected HashMap<String, String> mDefaultMenuSettingConfigMap = null;
    protected List<String> mMenuPanelList = null;
    protected List<String> mMenuSettingList = null;
    protected List<b> mOptionItemConfigList = null;
    protected HashMap<String, String> mProjectConfigMap = null;

    public HashMap<String, String> getProjectMap() {
        return this.mProjectConfigMap;
    }

    public void parseMenuPanel() {
        if (this.mMenuPanelList == null) {
            this.mMenuPanelList = new ArrayList();
        }
        this.mMenuPanelList.clear();
        this.mMenuPanelList.add("pref_video_hyper_lapse_key");
        this.mMenuPanelList.add("pref_camera_torch_mode_key");
        this.mMenuPanelList.add("pref_camera_flashmode_key");
        this.mMenuPanelList.add("pref_camera_videoflashmode_key");
        this.mMenuPanelList.add("pref_video_super_eis_key");
        this.mMenuPanelList.add("key_ai_enhancement_video");
        if (CameraConfig.getConfigBooleanValue(KEY_ULTRA_NIGHT_VIDEO)) {
            this.mMenuPanelList.add("key_ultra_night_video");
        }
        this.mMenuPanelList.add("pref_camera_hdr_mode_key");
        if (CameraConfig.getConfigBooleanValue(KEY_SUPPORT_TILT_SHIFT)) {
            this.mMenuPanelList.add("pref_video_tilt_shift_key");
            this.mMenuPanelList.add("pref_photo_tilt_shift_key");
        }
        this.mMenuPanelList.add("pref_video_timelapse_tilt_shift_key");
        this.mMenuPanelList.add("pref_night_tripod_mode_key");
        if (CameraConfig.getConfigBooleanValue(KEY_PI_AI)) {
            this.mMenuPanelList.add("pref_camera_pi_ai_mode_key");
        } else {
            this.mMenuPanelList.add("pref_camera_pi_mode_key");
        }
        this.mMenuPanelList.add("pref_camera_vivid_effect_key");
        this.mMenuPanelList.add("pref_high_resolution_key");
        this.mMenuPanelList.add("pref_video_blur_menu");
        this.mMenuPanelList.add("pref_video_filter_menu");
        this.mMenuPanelList.add("pref_portrait_blur_menu");
        this.mMenuPanelList.add("pref_filter_menu");
        this.mMenuPanelList.add("pref_night_filter_menu");
        this.mMenuPanelList.add("pref_portrait_new_style_menu");
        this.mMenuPanelList.add("pref_switch_camera_key");
        this.mMenuPanelList.add("pref_raw_control_key");
        this.mMenuPanelList.add("pref_super_raw_control_key");
        this.mMenuPanelList.add("key_slow_video_frame_seek_bar_menu_key");
        this.mMenuPanelList.add("pref_intelligent_high_frame_selected_key");
        this.mMenuPanelList.add("key_multicamera_type_menu_key");
        this.mMenuPanelList.add("pref_subsetting_key");
        this.mMenuPanelList.add("pref_camera_photo_ratio_key");
        this.mMenuPanelList.add("pref_camera_timer_shutter_key");
        if (!CameraConfig.getConfigBooleanValue(KEY_SUPPORT_HIGH_DEFINITION)) {
            this.mMenuPanelList.add("pref_camera_high_resolution_key");
        }
        if (CameraConfig.getConfigBooleanValue(KEY_SUPPORT_VIDEO_3HDR) || CameraConfig.getConfigBooleanValue(KEY_SUPPORT_VIDEO_LIVE_HDR)) {
            this.mMenuPanelList.add("key_video_hdr");
        }
        this.mMenuPanelList.add("pref_platform_slow_video_fps_key");
        this.mMenuPanelList.add("pref_setting_key");
    }

    public List<String> getMenuPanelList() {
        return this.mMenuPanelList;
    }

    public void parseMenuSetting() {
        if (this.mMenuSettingList == null) {
            this.mMenuSettingList = new ArrayList();
        }
        this.mMenuSettingList.clear();
        if (Util.h("oplus.software.fingerprint.shutter")) {
            this.mMenuSettingList.add("pref_camera_fingerprint_shutter_key");
        }
        this.mMenuSettingList.add("pref_volume_key_function_key");
        this.mMenuSettingList.add("pref_assist_gradienter");
        this.mMenuSettingList.add("pref_camera_sound_key");
        this.mMenuSettingList.add("pref_camera_recordlocation_key");
        this.mMenuSettingList.add("pref_camera_storage_key");
        this.mMenuSettingList.add("pref_mirror_key");
        this.mMenuSettingList.add("pref_lens_dirty_detection_key");
        this.mMenuSettingList.add("pref_camera_quick_launch_key");
        this.mMenuSettingList.add("pref_share_and_edit_key");
        this.mMenuSettingList.add("pref_10bits_heic_encode_key");
        if (!CameraConfig.getConfigBooleanValue(KEY_PI_AI)) {
            this.mMenuSettingList.add("pref_ai_scene_key");
        }
        if (CameraConfig.getConfigBooleanValue(KEY_SUPPORT_VIDEO_MODE_INERTIAL_ZOOM)) {
            this.mMenuSettingList.add("pref_inertial_zoom_key");
        }
        if (CameraConfig.getConfigBooleanValue(KEY_SUPER_CLEAR_PORTRAIT)) {
            this.mMenuSettingList.add("pref_super_clear_portrait");
        }
        this.mMenuSettingList.add("pref_face_rectify_key");
        this.mMenuSettingList.add("pref_camera_photo_ratio_key");
        this.mMenuSettingList.add("pref_camera_countdown_effect_key");
        this.mMenuSettingList.add("pref_camera_tap_shutter_key");
        this.mMenuSettingList.add("pref_camera_gesture_shutter_key");
        if (Util.S() && this.mMenuSettingList.contains("pref_camera_sound_key")) {
            this.mMenuSettingList.remove("pref_camera_sound_key");
        }
        this.mMenuSettingList.add("pref_slogan_customize_key");
        this.mMenuSettingList.add("pref_video_slogan_customize_key");
        this.mMenuSettingList.add("pref_slogan_location_key");
        this.mMenuSettingList.add("pref_video_slogan_location_key");
        this.mMenuSettingList.add("pref_slogan_time_key");
        this.mMenuSettingList.add("pref_video_slogan_time_key");
        this.mMenuSettingList.add("pref_slogan_device_key");
        this.mMenuSettingList.add("pref_video_slogan_device_key");
        this.mMenuSettingList.add("pref_camera_slogan_key");
        this.mMenuSettingList.add("pref_camera_video_slogan_key");
        this.mMenuSettingList.add("pref_video_codec_key");
        this.mMenuSettingList.add("pref_sound_mode_types_key");
        this.mMenuSettingList.add("pref_video_ratio_key");
        this.mMenuSettingList.add("pref_track_focus_key");
        this.mMenuSettingList.add("pref_photo_slogan_key");
        this.mMenuSettingList.add("pref_video_slogan_key");
        if (!CameraConfig.getConfigBooleanValue(KEY_SUPPORT_SLOWMOTION_FOR_PLATFORM)) {
            this.mMenuSettingList.add("pref_slow_video_size_key");
        }
        this.mMenuSettingList.add("pref_sound_types_key_rear");
        this.mMenuSettingList.add("pref_sound_types_key_front");
        this.mMenuSettingList.add("pref_video_sell_eis");
        this.mMenuSettingList.add("pref_help_and_feedback_key");
        this.mMenuSettingList.add("pref_advance_setting_key");
        this.mMenuSettingList.add("pref_build_image_setting_key");
        this.mMenuSettingList.add("pref_watermark_setting_key");
        this.mMenuSettingList.add("pref_camera_code_key");
        this.mMenuSettingList.add("pref_shutter_help_key");
        this.mMenuSettingList.add("pref_video_sound_key");
        if (CameraConfig.getConfigBooleanValue(KEY_SUPPORT_QR_CODE_ENABLE) && Util.T()) {
            this.mMenuSettingList.add("pref_qr_code_key");
        }
    }

    public List<String> getMenuSettingList() {
        return this.mMenuSettingList;
    }

    public void parseDefaultProjectConfig() {
        if (this.mProjectConfigMap == null) {
            this.mProjectConfigMap = new HashMap<>();
        }
        this.mProjectConfigMap.clear();
        this.mProjectConfigMap.put(KEY_COMMON_AUTO_NIGHT_SCENCE, "1");
        this.mProjectConfigMap.put(KEY_VIDEO_EIS, "1");
        this.mProjectConfigMap.put(KEY_VIDEO_EIS_FPS, FilmModeMsgData.FUNC_KEY_ID_MENU_RESOLUTION);
        this.mProjectConfigMap.put(KEY_VIDEO_EIS_FPS_SETTING_SUPPORT, "1");
        this.mProjectConfigMap.put(KEY_VIDEO_EIS_AF_AUTO_LOCK, "0");
        this.mProjectConfigMap.put(KEY_VIDEO_EIS_PREVIEW_SCALE, "1.25f");
        this.mProjectConfigMap.put(KEY_FRONT_PANORAMA_MAX_HEIGHT, "1920");
        this.mProjectConfigMap.put(KEY_REAR_PANORAMA_MAX_HEIGHT, "1944");
        this.mProjectConfigMap.put(KEY_STICKER, "1");
        this.mProjectConfigMap.put(KEY_STICKER_USE_NV12, "0");
        this.mProjectConfigMap.put(KEY_PREVIEW_YUV_FORMAT_NV12, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_PHOTO_CODEC, "0");
        this.mProjectConfigMap.put(KEY_GROUP_SHOT, "0");
        this.mProjectConfigMap.put(KEY_NIGHT, "1");
        this.mProjectConfigMap.put(KEY_NIGHT_PICTURE_TIMER_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_NIGHT_PICTURE_HAND_PROCESS_TIME, "6000");
        this.mProjectConfigMap.put(KEY_SUPER_TEXT, "0");
        this.mProjectConfigMap.put(KEY_SUPER_TEXT_CPU_PROCESS, "0");
        this.mProjectConfigMap.put(KEY_SUPER_TEXT_SCANNER_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_SAVE_JPG_AFTER_PAUSE, "1");
        this.mProjectConfigMap.put(KEY_SUPPORT_VIVID_EFFECT, "0");
        this.mProjectConfigMap.put(KEY_REAR_PORTRAIT_PREVIEW_SIZE, "1440x1080");
        this.mProjectConfigMap.put(KEY_FRONT_PORTRAIT_PREVIEW_SIZE, "1440x1080");
        this.mProjectConfigMap.put(KEY_SINGLE_CAMERA_USE_COMMOM_PORTRAIT_PREVIEW_SIZE, "1");
        this.mProjectConfigMap.put(KEY_BACK_PORTRAIT_NORMAL_MODE_PIC_SIZE, "4608x3456");
        this.mProjectConfigMap.put(KEY_HIGH_TEMPERATURE_ULTIMATE_LIMIT, "480");
        this.mProjectConfigMap.put(KEY_PORTRAIT_NEW_STYLE, "1");
        this.mProjectConfigMap.put(KEY_BEAUTY3D, "1");
        this.mProjectConfigMap.put(KEY_PI, "0");
        this.mProjectConfigMap.put(KEY_PI_AI, "0");
        this.mProjectConfigMap.put(KEY_SUPER_CLEAR_PORTRAIT, "0");
        this.mProjectConfigMap.put(KEY_HYPER_LAPSE, "0");
        this.mProjectConfigMap.put(KEY_TORCH_SOFT_LIGHT, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_SLOWVIDEO_1080P, "0");
        this.mProjectConfigMap.put(KEY_PREVIEW_FPS_HFR_1080P, "120");
        this.mProjectConfigMap.put(KEY_PREVIEW_FPS_HFR_720P, "240");
        this.mProjectConfigMap.put(KEY_DEFAULT_TO_REAL_SWITCH_ANIM_TIME, "650");
        this.mProjectConfigMap.put(KEY_DEFAULT_TO_FRONT_SWITCH_ANIM_TIME, "650");
        this.mProjectConfigMap.put(KEY_PANORAMA_TO_REAL_SWITCH_ANIM_TIME, "650");
        this.mProjectConfigMap.put(KEY_PANORAMA_TO_FRONT_SWITCH_ANIM_TIME, "650");
        this.mProjectConfigMap.put(KEY_ALIGNED_BITS, "64");
        this.mProjectConfigMap.put(KEY_BURSTSHOT_THUMB_ANIM_STEP_TIME, "35");
        this.mProjectConfigMap.put(KEY_PROFESSIONAL_SWITCH_CAMERA_TYPE, "0");
        this.mProjectConfigMap.put(KEY_STICKER_TARGET_PREVIEW_HEIGHT, "1080");
        this.mProjectConfigMap.put(KEY_SUPPORT_FRONT_DARK_TIPS_THRESHOLD, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_BACK_DARK_TIPS_THRESHOLD, "0");
        this.mProjectConfigMap.put(KEY_VIDEO_FRONT_FACE_BEAUTY_LEVEL, "-1");
        this.mProjectConfigMap.put(KEY_SUPPORT_SCREEN_BRIGHTNESS, "1");
        this.mProjectConfigMap.put(KEY_SUPPORT_SCREEN_BRIGHTNESS_PORTRAIT, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_SCREEN_BRIGHTNESS_VIDEO, "0");
        this.mProjectConfigMap.put(KEY_SCREEN_BRIGHTNESS_VALUE, BuildConfig.BUILD_NUMBER);
        this.mProjectConfigMap.put(KEY_SCREEN_BRIGHTNESS_VIDEO_VALUE, "50");
        this.mProjectConfigMap.put(KEY_SCREEN_BRIGHTNESS_THRESHOLD, "330");
        this.mProjectConfigMap.put(KEY_SCREEN_BRIGHTNESS_RECOVER_THRESHOLD, "285");
        this.mProjectConfigMap.put(KEY_VIDEO_SIZE_4K, "1");
        this.mProjectConfigMap.put(KEY_ULTRA_NIGHT_VIDEO, "0");
        this.mProjectConfigMap.put(KEY_SURPERNIGHT_REPROCESS_PREVIEW, "0");
        this.mProjectConfigMap.put(KEY_SURPERNIGHT_REPROCESS_EXTRA_YUV, "0");
        this.mProjectConfigMap.put(KEY_AI_ENHANCEMENT_VIDEO, "0");
        this.mProjectConfigMap.put(KEY_AI_ENHANCEMENT_FRONT_VIDEO, "0");
        this.mProjectConfigMap.put(KEY_AI_ENHANCEMENT_REAR_VIDEO_1080P_SIZE, "1");
        this.mProjectConfigMap.put(KEY_CUSTOM_BEAUTY_FRONT_VIDEO, "0");
        this.mProjectConfigMap.put(KEY_ALLMIGHTY_VIDEO, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_FRONT_AI_VIDEO_SCENE, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_ALLMIGHTY_VIDEO_SCENE, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_ALLMIGHTY_VIDEO_SCENE_FUNCTION_OFF, "0");
        this.mProjectConfigMap.put(KEY_ULTRA_NIGHT_VIDEO_WIDE_ANGLE, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_SCREENHOLE, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_VIDEO_720_60_FPS, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_VIDEO_1080_60_FPS, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_VIDEO_4K_60_FPS, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_VIDEO_THUMBNAIL_SIMULTANEOUS_4K, "1");
        this.mProjectConfigMap.put(KEY_SUPPORT_VIDEO_DYNAMIC_FPS_RANGE, "0");
        this.mProjectConfigMap.put(KEY_FIXED_FPS_IN_4K, "0");
        this.mProjectConfigMap.put(KEY_SUPER_NIGHT_CAMERA_MODE, "-1");
        this.mProjectConfigMap.put(KEY_CSHOT_FIRST_REQUEST_NUM, "3");
        this.mProjectConfigMap.put(KEY_STICKER_SUPPORT_MAX_FACE_NUM, CameraStatisticsUtil.FUNC_KEY_SETTING);
        this.mProjectConfigMap.put(KEY_SUPPORT_HIGH_RESOLUTION, "0");
        this.mProjectConfigMap.put(KEY_ATHENA_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_HIGH_PICTURE_SIZE, (Object) null);
        this.mProjectConfigMap.put(KEY_HIGH_MFNR_PICTURE_SIZE, (Object) null);
        this.mProjectConfigMap.put(KEY_SUPPORT_HIGH_PICTURE_ULTRA_RESOLUTION_MODE, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_HIGH_DEFINITION, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_TILT_SHIFT, "1");
        this.mProjectConfigMap.put(KEY_HIGH_PICTURE_SIZE_NAME, "0");
        this.mProjectConfigMap.put(KEY_HIGH_PICTURE_SIZE_FRONT, (Object) null);
        this.mProjectConfigMap.put(KEY_HIGH_PICTURE_SIZE_NAME_FRONT, "0");
        this.mProjectConfigMap.put(KEY_ULTRA_WIDE_HIGH_PICTURE_SIZE, "0");
        this.mProjectConfigMap.put(KEY_MOTOR_FLASHLIGHT, "0");
        this.mProjectConfigMap.put(KEY_MOTOR_DOWN_DELAY, String.valueOf(1000));
        this.mProjectConfigMap.put(KEY_SUPPORT_PORTRAIT, "1");
        this.mProjectConfigMap.put(KEY_FACE_BEAUTY_VERSION_CODE, "-1");
        this.mProjectConfigMap.put(KEY_FEATURE_DCIP3_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_CAPTURE_RAW, "1");
        this.mProjectConfigMap.put(KEY_SUPPORT_SLOW_VIDEO, "1");
        this.mProjectConfigMap.put(KEY_SUPPORT_MOVIE_MODE, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_MOVIE_MODE_V2, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_LANDSCAPE_CAMERA_SENSOR, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_MACRO_MODE, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_INTELLIGENT_HIGH_FRAME, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_VIDEO_3HDR, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_VIDEO_3HDR_10BIT, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_VIDEO_LIVE_HDR, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_VIDEO_SAT, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_FRONT_SLOW_VIDEO, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_FRONT_720P_SLOW_VIDEO, "1");
        this.mProjectConfigMap.put(KEY_SUPPORT_SLOW_VIDEO_ZOOM, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_FAST_VIDEO_SAT, "0");
        this.mProjectConfigMap.put(KEY_VIDEO_SAT_MASK, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_VIDEO_SUPER_EIS_PROCESS, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_VIDEO_SUPER_EIS_WIDE, "0");
        this.mProjectConfigMap.put(KEY_FRONT_SUPER_EIS_AND_AI_VIDEO_ENHANCE_COEXIST, "1");
        this.mProjectConfigMap.put(KEY_SUPPORT_VIDEO_FRONT_EIS_FORCE_ULTRA_WIDE, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_VIDEO_FRONT_EIS, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_VIDEO_SUPER_EIS_WIDE_60_FPS, "1");
        this.mProjectConfigMap.put(KEY_SUPPORT_VIDEO_BLUR_1080P, "1");
        this.mProjectConfigMap.put(KEY_SUPPORT_INSENSOR_ZOOM_20X, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_VIDEO_BLUR_ULTRA_WIDE, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_VIDEO_4K_60FPS_ULTRA_WIDE, "0");
        this.mProjectConfigMap.put(KEY_VIDEO_NONE_SAT_ULTRA_WIDE_ANGLE_RESOLUTION_LIMIT, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_IMPRECISE_RAW_SIZE, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_PROFESSIONAL_RAW, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_PROFESSIONAL_SUPER_RAW, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_END_VIDEO_EIS_STREAM, "0");
        this.mProjectConfigMap.put(KEY_WIDE_VIDEO_ONLY_720P_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_WIDE_NORMAL_PREVIEW_SIZE, (Object) null);
        this.mProjectConfigMap.put(KEY_CONTROL_PREVIEW_SIZE, (Object) null);
        this.mProjectConfigMap.put(KEY_FACE_BEAUTY_PREVIEW_SIZE_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_NEED_HAL_HANDING_FACE_BEAUTY, "0");
        this.mProjectConfigMap.put(KEY_FACE_BEAUTY_PREVIEW_SIZE, (Object) null);
        this.mProjectConfigMap.put(KEY_SAT_WIDE_PICTURE_SIZE, (Object) null);
        this.mProjectConfigMap.put(KEY_SAT_ULTRA_PICTURE_SIZE, (Object) null);
        this.mProjectConfigMap.put(KEY_SAT_TELE_PICTURE_SIZE, (Object) null);
        this.mProjectConfigMap.put(KEY_BACK_NIGHT_RAW_PICTURE_SIZE, (Object) null);
        this.mProjectConfigMap.put(KEY_BACK_NIGHT_LOW_MEMORY_RAW_PICTURE_SIZE, (Object) null);
        this.mProjectConfigMap.put(KEY_SAT_ULTRAWIDE_ZOOM_RANGE, "0,0");
        this.mProjectConfigMap.put(KEY_SAT_MAIN_ZOOM_RANGE, "1.0,2.0");
        this.mProjectConfigMap.put(KEY_VIDEO_SAT_60FPS_MAIN_ZOOM_RANGE, (Object) null);
        this.mProjectConfigMap.put(KEY_SAT_TELE_ZOOM_RANGE, "2.0,20.0");
        this.mProjectConfigMap.put(KEY_DEFAULT_SENSOR_SIZE_SCALE, (Object) null);
        this.mProjectConfigMap.put(KEY_HAL_MEMORY_COMMON, "732");
        this.mProjectConfigMap.put(KEY_HAL_MEMORY_COMMON_SUPPORT_DIFFERENCE, "0");
        this.mProjectConfigMap.put(KEY_HAL_MEMORY_COMMON_6G, "732");
        this.mProjectConfigMap.put(KEY_HAL_MEMORY_COMMON_8G, "1000");
        this.mProjectConfigMap.put(KEY_HAL_MEMORY_COMMON_12G, "1500");
        this.mProjectConfigMap.put(KEY_HAL_MEMORY_NIGHT, "730");
        this.mProjectConfigMap.put(KEY_HAL_MEMORY_PANORAMA, "428");
        this.mProjectConfigMap.put(KEY_HAL_MEMORY_PORTRAIT, "502");
        this.mProjectConfigMap.put(KEY_HAL_MEMORY_PROFESSIONAL, "449");
        this.mProjectConfigMap.put(KEY_HAL_MEMORY_STICKER, "448");
        this.mProjectConfigMap.put(KEY_HAL_MEMORY_HIGH_DEFINITION, "732");
        this.mProjectConfigMap.put(KEY_ULTRA_WIDE_ANGLE_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_VIDEO_WIDE_ONLY_MEDIACODEC_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_HYPER_LAPSE_ULTRA_WIDE_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_NONE_SAT_FRONT_MODE, "null");
        this.mProjectConfigMap.put(KEY_NONE_SAT_REAR_MODE, "null");
        this.mProjectConfigMap.put(KEY_NONE_SAT_TELE_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_NIGHT_TRIPOD_SUPPORT, "1");
        this.mProjectConfigMap.put(KEY_NIGHT_TRIPOD_RAM_THRESHOLD, FocusAimMsgData.KEY_HYPER_LAPSE_FOCUS_TYPE);
        this.mProjectConfigMap.put(KEY_NIGHT_FILTER_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_BOKEH_BEAUTY_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_BOKEH_BEAUTY_OPEN_DEFAULT, "1");
        this.mProjectConfigMap.put(KEY_ULTRA_HIGH_RESOLUTION_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_ULTRA_HIGH_RESOLUTION_FULL_ZOOM_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_ULTRA_HIGH_RESOLUTION_SWITCH_CAMERA_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_SLOGAN_LOCATION_SUPPORT, "1");
        this.mProjectConfigMap.put(KEY_PORTRAIT_HALF_BODY_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_PORTRAIT_HALF_BODY_REMOSAIC_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_MTK_FACE_BEAUTY_REMOSAIC_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_PORTRAIT_FRONT_MAX_SIZE_SUPPORT, "1");
        this.mProjectConfigMap.put(KEY_TORCH_FLASH, "0");
        this.mProjectConfigMap.put(KEY_FACE_RECTIFY_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_NIGHT_TRIPOD_ZOOM_HIDE_ULTRA_WIDE, "0");
        this.mProjectConfigMap.put(KEY_MFNR, "0");
        this.mProjectConfigMap.put(KEY_FACE_RECTIFY_CONFIG_VALUE, (Object) null);
        this.mProjectConfigMap.put(KEY_QUADCFA_BLURLESS, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_EIS_PRO_LOW_LIGHT_HINT, "1");
        this.mProjectConfigMap.put(KEY_AF_HYPERFOCALDISTANCE_SUPPORT, "1");
        this.mProjectConfigMap.put(KEY_SLOW_VIDEO_RED_DOT_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_DECREASE_BRIGHTNESS_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_VIDEO_WATERMARK_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_VIDEO_WATERMARK_HAL_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_UI_SHUTTER_BUTTON_TYPE_LOW_LIGHT, "0");
        this.mProjectConfigMap.put(KEY_SAT_USE_HAL, "0");
        this.mProjectConfigMap.put(KEY_FRONT_TORCH_COLOR, "#FFC8C8C8");
        this.mProjectConfigMap.put(KEY_SLOW_MOTION_H265_SUPPORT, "1");
        this.mProjectConfigMap.put(KEY_FRONT_INVERSE_COLOR, "#FFFFF8E0");
        this.mProjectConfigMap.put(KEY_APS_SUPPORT_VIDEO_SUPER_EIS, "1");
        this.mProjectConfigMap.put(KEY_VIDEO_COLOR_EXTRACTION_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_VIDEO_EIS_SURFACE_SIZE, "1920x1080");
        this.mProjectConfigMap.put(KEY_SUPPORT_AUTO_MICRO, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_MTK_INSENSOR_ZOOM, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_FLASH_FULL_ZOOM, "0");
        this.mProjectConfigMap.put(KEY_PORTRAIT_RETENTION_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_PORTRAIT_FRONT_RETENTION_SUPPORT, "1");
        this.mProjectConfigMap.put(KEY_PORTRAIT_NEON_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_PORTRAIT_STREAMER_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_MICROSCOPE_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_PORTRAIT_BLUR_LEVEL_ENABLE, "1");
        this.mProjectConfigMap.put(KEY_PORTRAIT_SINGLE_BLUR_OPERATING, "0");
        this.mProjectConfigMap.put(KEY_PORTRAIT_SINGLE_BLUR_MODEL, "0");
        this.mProjectConfigMap.put(KEY_VIDEO_RETENTION_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_HW_MANUFACTURER_QUALCOMM, "0");
        this.mProjectConfigMap.put(KEY_NIGHT_SENSOR_MASK_SUPPORT, "1");
        this.mProjectConfigMap.put(KEY_SUPPORT_BREENO_SCAN, com.oppo.camera.w.b.a());
        this.mProjectConfigMap.put(KEY_CUSTOM_CAMERA_REAR_NUM, "1");
        this.mProjectConfigMap.put(KEY_PORTRAIT_ZOOM_VALUE_DEFAULT, "1.0");
        this.mProjectConfigMap.put(KEY_MOVIE_ULTRA_WIDE_FLASH_EIS_SUPPORT, "1");
        this.mProjectConfigMap.put(KEY_MOVIE_DEFAULT_VIDEO_FRAME_RECORD_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_QUALCOMM_PHYSICAL_ID_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_MMCAMERA_PROFESSIONAL, "0");
        this.mProjectConfigMap.put(KEY_TUNING_DATA_BUFFER_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_PROFESSIONAL_RAW_CAMERA_TYPE_SUPPORT, "camera_main,camera_ultra_wide,camera_tele");
        this.mProjectConfigMap.put(KEY_MACROLENS_EQUAL_ULTRAWIDELENS, "0");
        this.mProjectConfigMap.put(KEY_RAW_ZOOM_MUTEX_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_MACRO_BEST_FOCUS_DISTANCE, FocusAimMsgData.KEY_HYPER_LAPSE_FOCUS_TYPE);
        this.mProjectConfigMap.put(KEY_TRACK_FOCUS_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_VIDEO_4K_TRACK_FOCUS_SUPPORT, "1");
        this.mProjectConfigMap.put(KEY_TRACK_FOCUS_ULTRA_WIDE_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_NIGHT_FILTER_TYPE_LIST, "null");
        this.mProjectConfigMap.put(KEY_SUPPORT_DEFAULT_VIDEO_FRAME_RECORD, "0");
        this.mProjectConfigMap.put(KEY_ID_PHOTO, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_SHOW_SOLOOP, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_SHOW_SOLOOP_SAME, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_VIDEO_ELEVATE_AUDIO_BIT_RATE, "0");
        this.mProjectConfigMap.put(KEY_FRONT_PORTRAIT_NORMAL_MODE_PIC_SIZE, "5760x4312");
        this.mProjectConfigMap.put(KEY_SUPPORT_ULTAR_WIDE_VIDEO_4K_OR_60FPS, "1");
        this.mProjectConfigMap.put(KEY_SUPPORT_YUV_NIGHT, "0");
        this.mProjectConfigMap.put(KEY_QUALITY_HIGH_1080P_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_ZOOM_WIDE_ANGLE_OPEN_DEFAULT, "0");
        this.mProjectConfigMap.put(KEY_VIDEO_SUPER_EIS_WIDE_OPEN_DEFAULT, "0");
        this.mProjectConfigMap.put(KEY_NIGHT_MODE_DELETE_RECTANGLESIZE, "0");
        this.mProjectConfigMap.put(KEY_MEMORY_NOT_ENOUGH_HINT, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_SLOWMOTION_FOR_PLATFORM, "0");
        this.mProjectConfigMap.put(KEY_MEMORY_NOT_ENOUGH_PORTRAIT_HINT, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_PANORAMA_REAR_PROCESS_IMAGE, "0");
        this.mProjectConfigMap.put(KEY_SLOW_VIDEO_HFR_120FPS_VIDOETYPE, "120,video_size_1080p");
        this.mProjectConfigMap.put(KEY_SLOW_VIDEO_HFR_240FPS_VIDOETYPE, "240,video_size_720p");
        this.mProjectConfigMap.put(KEY_SLOW_VIDEO_HFR_480FPS_VIDOETYPE, "120,video_size_1080p");
        this.mProjectConfigMap.put(KEY_SLOW_VIDEO_HFR_960FPS_VIDOETYPE, "240,video_size_720p");
        this.mProjectConfigMap.put(KEY_SLOW_VIDEO_1080P_DEFAULT_VALUE, "480");
        this.mProjectConfigMap.put(KEY_SLOW_VIDEO_720P_DEFAULT_VALUE, "960");
        this.mProjectConfigMap.put(KEY_SUPPORT_DUMP_960FPS_ORIGINAL, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_STARRY_MODE, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_STAR_VIDEO, "0");
        this.mProjectConfigMap.put(KEY_STAR_VIDEO_SIZE_TYPE, "video_size_4kuhd");
        this.mProjectConfigMap.put(KEY_STARRY_MODE_PROCESS_TIME, "7000");
        this.mProjectConfigMap.put(KEY_NIGHT_STARRY_MODE_ZOOM_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_NIGHT_PRO_MODE_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_HIGHPICTURE_PRO_MODE_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_FRONT_SENSOR_BINNING, "0");
        this.mProjectConfigMap.put(KEY_STARRY_MODE_CAPTURE_EXPOSURETIME, "16000");
        this.mProjectConfigMap.put(KEY_STARRY_MODE_CAPTURE_ISO, "300");
        this.mProjectConfigMap.put(KEY_STARRY_MODE_SUPPORT_PREVERSION, "0");
        this.mProjectConfigMap.put(KEY_MULTI_VIDEO_MODE_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_MULTI_VIDEO_MODE_1080P_SUPPORT, "1");
        this.mProjectConfigMap.put(KEY_DISABLE_RAW, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_RAW_HDR, "1");
        this.mProjectConfigMap.put(KEY_PORTRAIT_MODE_PHYSICAL_CAMERAID_1X, (Object) null);
        this.mProjectConfigMap.put(KEY_PORTRAIT_MODE_PHYSICAL_CAMERAID_2X, (Object) null);
        this.mProjectConfigMap.put(KEY_PORTRAIT_MODE_PICTURE_SIZE_1X, (Object) null);
        this.mProjectConfigMap.put(KEY_PORTRAIT_MODE_PICTURE_SIZE_2X, (Object) null);
        this.mProjectConfigMap.put(KEY_PORTRAIT_MODE_SET_DEFAULT_LOGIC_CAMERA_TYPE, "0");
        this.mProjectConfigMap.put(KEY_IS_UW_FIXED_FOCUS, "0");
        this.mProjectConfigMap.put(KEY_AIS_SNAPSHOT_USE_MFNR, "0,0");
        this.mProjectConfigMap.put(KEY_SUPPORT_VIDEO_MODE_INERTIAL_ZOOM, "1");
        this.mProjectConfigMap.put(KEY_SAT_NEED_SET_ZOOMRATIO, "0");
        this.mProjectConfigMap.put(KEY_SAT_SUPPORT_PREVERSION, "0");
        this.mProjectConfigMap.put(KEY_10_BITS_HEIC_ENCODE_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_FRONT_FACE_POINT_ANIMATION, "0");
        this.mProjectConfigMap.put(KEY_ARCSOFT_SINGLE_BOKEH_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_STREAM_SUPPORT_PREVERSION, "0");
        this.mProjectConfigMap.put(KEY_ZSL_SUPPORT_PREVERSION, "0");
        this.mProjectConfigMap.put(KEY_TEMPERATURE_CONTROL_STOP_VIDEO_RECORDING, "0");
        this.mProjectConfigMap.put(KEY_CAPTURE_WITH_DETACH, "1");
        this.mProjectConfigMap.put(KEY_SUPPORT_QR_CODE_ENABLE, "0");
        this.mProjectConfigMap.put(KEY_SUPPORT_NIGHT_GESTURE_SHUTTER, "1");
        this.mProjectConfigMap.put(KEY_SUPPORT_DIRTY_DETECT, "1");
        this.mProjectConfigMap.put(KEY_BACK_PURE_3RD_BOKEH_PREVIEW, "0");
        this.mProjectConfigMap.put(KEY_SHARE_EDIT_SUPPORT, "1");
        this.mProjectConfigMap.put(KEY_AI_VIDEO_ENHANCE_FRONT_RESOLUTION, (Object) null);
        this.mProjectConfigMap.put(KEY_AI_VIDEO_ENHANCE_REAR_RESOLUTION, (Object) null);
        this.mProjectConfigMap.put(KEY_LOCK_AE_BEFORE_CAPTURE_SUPPORT, "1");
        this.mProjectConfigMap.put(KEY_DOUBLE_EXPOSURE_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_INSENSOR_ZOOM_POINT_3X_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_PREVIEW_BUFFER_CACHE_SUPPORT, "1");
        this.mProjectConfigMap.put(KEY_MAINCAMERA_ASD_AISCENE_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_WIDECAMERA_ASD_AISCENE_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_CAMERA_VIDEO_BRIGHTNESS, "191");
        this.mProjectConfigMap.put(KEY_BURST_SHOT_CACHE_SUPPORT, "0");
        this.mProjectConfigMap.put(KEY_CACHE_CLICK_CAPTURE_SUPPORT, "1");
        this.mProjectConfigMap.put(KEY_PORTRAIT_REAR_NEON_SUPPORT_FILTER, "1");
        this.mProjectConfigMap.put(KEY_LOW_MEMORY_MAX_BURST_SHOT_NUM, String.valueOf(20));
    }

    public void parseProjectConfigFromConfigFile() {
        Context d = MyApplication.d();
        ApsUtils.initConfigData(UpdateHelper.tryRusUpdatePath(d, ApsUtils.CONFIG_JSON_PATH + ApsUtils.VENDOR_TAG_CONFIG_NAME), 0);
        for (Map.Entry next : this.mProjectConfigMap.entrySet()) {
            String str = (String) next.getKey();
            String vendorTagConfig = ApsUtils.getVendorTagConfig(str);
            e.c(TAG, "parseProjectConfigFromConfigFile, key: " + str + ", value: " + vendorTagConfig);
            if (vendorTagConfig != null) {
                next.setValue(vendorTagConfig);
            }
        }
    }

    public HashMap<String, String> getDefaultMenuSettingConfig() {
        return this.mDefaultMenuSettingConfigMap;
    }

    public void parseDefaultMenuSettingConfigMap() {
        if (this.mDefaultMenuSettingConfigMap == null) {
            this.mDefaultMenuSettingConfigMap = new HashMap<>();
        }
        this.mDefaultMenuSettingConfigMap.clear();
        this.mDefaultMenuSettingConfigMap.put("pref_camera_hdr_mode_key_default_back_camera", MenuClickMsgData.VALUE_PROFESSION_AUTO);
        this.mDefaultMenuSettingConfigMap.put("pref_camera_hdr_mode_key_default_front_camera", MenuClickMsgData.VALUE_PROFESSION_AUTO);
        String str = "video_size_1080p";
        this.mDefaultMenuSettingConfigMap.put("pref_video_size_key_default_back_camera", str);
        HashMap<String, String> hashMap = this.mDefaultMenuSettingConfigMap;
        if (!CameraConfig.getConfigBooleanValue(KEY_CUSTOM_BEAUTY_FRONT_VIDEO)) {
            str = "video_size_720p";
        }
        hashMap.put("pref_video_size_key_default_front_camera", str);
        if (CameraConfig.getConfigBooleanValue(KEY_SUPPORT_SLOWMOTION_FOR_PLATFORM)) {
            this.mDefaultMenuSettingConfigMap.put("pref_platform_slow_video_fps_key_default_back_camera", CameraConfig.getConfigStringValue(KEY_SLOW_VIDEO_720P_DEFAULT_VALUE));
        }
    }

    public void parseOptionItemConfig() {
        if (this.mOptionItemConfigList == null) {
            this.mOptionItemConfigList = new ArrayList();
        }
        this.mOptionItemConfigList.clear();
        addVideoBackOptionItem();
        addVideoFrontOptionItem();
        addTorchModeOptionItem();
        if (CameraConfig.getConfigBooleanValue(KEY_SUPPORT_SLOWMOTION_FOR_PLATFORM)) {
            addSlowMotionOptionItem();
        }
    }

    private void addVideoBackOptionItem() {
        b bVar = new b();
        bVar.a("pref_video_size_key_back_camera_supported");
        bVar.b("video_size_720p");
        bVar.b("video_size_1080p");
        if (CameraConfig.getConfigBooleanValue(KEY_VIDEO_SIZE_4K)) {
            bVar.b("video_size_4kuhd");
        }
        this.mOptionItemConfigList.add(bVar);
    }

    private void addVideoFrontOptionItem() {
        b bVar = new b();
        bVar.a("pref_video_size_key_front_camera_supported");
        bVar.b("video_size_1080p");
        bVar.b("video_size_720p");
        this.mOptionItemConfigList.add(bVar);
    }

    private void addTorchModeOptionItem() {
        b bVar = new b();
        bVar.a("pref_camera_torch_mode_key");
        bVar.b("off");
        bVar.b("on");
        if (!CameraConfig.getConfigBooleanValue(KEY_TORCH_SOFT_LIGHT)) {
            bVar.b(MenuClickMsgData.VALUE_PROFESSION_AUTO);
        }
        this.mOptionItemConfigList.add(bVar);
    }

    private void addSlowMotionOptionItem() {
        b bVar = new b();
        bVar.a("pref_platform_slow_video_fps_key_back_camera_supported");
        if (CameraConfig.isApsSupportVendorTag(KEY_SLOW_VIDEO_HFR_120FPS_VIDOETYPE)) {
            bVar.b(String.valueOf(120));
        }
        if (CameraConfig.isApsSupportVendorTag(KEY_SLOW_VIDEO_HFR_240FPS_VIDOETYPE)) {
            bVar.b(String.valueOf(240));
        }
        if (CameraConfig.isApsSupportVendorTag(KEY_SLOW_VIDEO_HFR_480FPS_VIDOETYPE)) {
            bVar.b(String.valueOf(480));
        }
        if (CameraConfig.isApsSupportVendorTag(KEY_SLOW_VIDEO_HFR_960FPS_VIDOETYPE)) {
            bVar.b(String.valueOf(960));
        }
        this.mOptionItemConfigList.add(bVar);
    }

    public List<b> getOptionItemConfigs() {
        return this.mOptionItemConfigList;
    }
}
