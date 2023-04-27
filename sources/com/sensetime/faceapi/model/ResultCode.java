package com.sensetime.faceapi.model;

import com.oppo.camera.facebeauty.OppoFaceBeauty;

public enum ResultCode {
    OK(0),
    E_INVALIDARG(-1),
    E_HANDLE(-2),
    E_OUTOFMEMORY(-3),
    E_FAIL(-4),
    E_DELNOTFOUND(-5),
    E_INVALID_PIXEL_FORMAT(-6),
    E_FILE_NOT_FOUND(-7),
    E_INVALID_FILE_FORMAT(-8),
    E_FILE_EXPIRE(-9),
    E_INVALID_AUTH(-13),
    E_INVALID_APPID(-14),
    E_AUTH_EXPIRE(-15),
    E_UUID_MISMATCH(-16),
    E_ONLINE_AUTH_CONNECT_FAIL(-17),
    E_ONLINE_AUTH_TIMEOUT(-18),
    E_ONLINE_AUTH_INVALID(-19),
    E_LICENSE_IS_NOT_ACTIVABLE(-20),
    E_ACTIVE_FAIL(-21),
    E_ACTIVE_CODE_INVALID(-22),
    E_UNSUPPORTED(-1000),
    E_MISSLICENSE(-1001),
    E_MULTI_CALLS(-1002);
    
    private static final String DESCRIPTION_E_ACTIVE_CODE_INVALID = "invalid active code";
    private static final String DESCRIPTION_E_ACTIVE_FAIL = "license active failed";
    private static final String DESCRIPTION_E_AUTH_EXPIRE = "date expired";
    private static final String DESCRIPTION_E_DELNOTFOUND = "define not found";
    private static final String DESCRIPTION_E_FAIL = "run in fail inside";
    private static final String DESCRIPTION_E_FILE_EXPIRE = "model out of date";
    private static final String DESCRIPTION_E_FILE_NOT_FOUND = "file no found";
    private static final String DESCRIPTION_E_HANDLE = "handle Error,may be cause by sdk out of date or model file incorrect";
    private static final String DESCRIPTION_E_INVALIDARG = "invalid argument";
    private static final String DESCRIPTION_E_INVALID_APPID = "invalid appid";
    private static final String DESCRIPTION_E_INVALID_AUTH = "invalid license";
    private static final String DESCRIPTION_E_INVALID_FILE_FORMAT = "model format error";
    private static final String DESCRIPTION_E_INVALID_PIXEL_FORMAT = "invalid pixel format";
    private static final String DESCRIPTION_E_LICENSE_IS_NOT_ACTIVABLE = "invalid active code";
    private static final String DESCRIPTION_E_MISSLICENSE = "con't find license";
    private static final String DESCRIPTION_E_MULTI_CALLS = "multi calls init license";
    private static final String DESCRIPTION_E_ONLINE_AUTH_CONNECT_FAIL = "online auth connect fail";
    private static final String DESCRIPTION_E_ONLINE_AUTH_INVALID = "check online fail";
    private static final String DESCRIPTION_E_ONLINE_AUTH_TIMEOUT = "check online timeout";
    private static final String DESCRIPTION_E_OUTOFMEMORY = "out of memory";
    private static final String DESCRIPTION_E_UNSUPPORTED = "unsupport function called";
    private static final String DESCRIPTION_E_UUID_MISMATCH = "uuid mismatch";
    private static final String DESCRIPTION_OK = "OK";
    private final int resultCode;

    public static String getDescription(int i) {
        switch (i) {
            case -1002:
                return DESCRIPTION_E_MULTI_CALLS;
            case -1001:
                return DESCRIPTION_E_MISSLICENSE;
            case -1000:
                return DESCRIPTION_E_UNSUPPORTED;
            default:
                switch (i) {
                    case -22:
                        return "invalid active code";
                    case -21:
                        return DESCRIPTION_E_ACTIVE_FAIL;
                    case -20:
                        return "invalid active code";
                    case -19:
                        return DESCRIPTION_E_ONLINE_AUTH_INVALID;
                    case -18:
                        return DESCRIPTION_E_ONLINE_AUTH_TIMEOUT;
                    case -17:
                        return DESCRIPTION_E_ONLINE_AUTH_CONNECT_FAIL;
                    case -16:
                        return DESCRIPTION_E_UUID_MISMATCH;
                    case -15:
                        return DESCRIPTION_E_AUTH_EXPIRE;
                    case -14:
                        return DESCRIPTION_E_INVALID_APPID;
                    case -13:
                        return DESCRIPTION_E_INVALID_AUTH;
                    default:
                        switch (i) {
                            case OppoFaceBeauty.FACEBEAUTY_PARAM_NULL:
                                return DESCRIPTION_E_FILE_EXPIRE;
                            case OppoFaceBeauty.MODEL_PATH_PATH_NULL:
                                return DESCRIPTION_E_INVALID_FILE_FORMAT;
                            case OppoFaceBeauty.ATTR_RESULT_NULL:
                                return DESCRIPTION_E_FILE_NOT_FOUND;
                            case -6:
                                return DESCRIPTION_E_INVALID_PIXEL_FORMAT;
                            case -5:
                                return DESCRIPTION_E_DELNOTFOUND;
                            case -4:
                                return DESCRIPTION_E_FAIL;
                            case -3:
                                return DESCRIPTION_E_OUTOFMEMORY;
                            case -2:
                                return DESCRIPTION_E_HANDLE;
                            case -1:
                                return DESCRIPTION_E_INVALIDARG;
                            case 0:
                                return DESCRIPTION_OK;
                            default:
                                return null;
                        }
                }
        }
    }

    private ResultCode(int i) {
        this.resultCode = i;
    }

    public int getValue() {
        return this.resultCode;
    }
}
