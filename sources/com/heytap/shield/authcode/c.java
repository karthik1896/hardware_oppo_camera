package com.heytap.shield.authcode;

import com.crunchfish.touchless_a3d.TouchlessA3D;

/* compiled from: CommonStatusCodes */
public class c {
    public static String a(int i) {
        switch (i) {
            case 1001:
                return "AUTHENTICATE_SUCCESS";
            case TouchlessA3D.Parameters.EXTENDED_RANGE:
                return "AUTHENTICATE_FAIL";
            case 1003:
                return "TIME_EXPIRED";
            case 1004:
                return "AUTHCODE_EXPECTED";
            case 1005:
                return "VERSION_INCOMPATIBLE";
            case 1006:
                return "AUTHCODE_RECYCLE";
            case 1007:
                return "AUTHCODE_INVALID";
            case 1008:
                return "CAPABILITY_EXCEPTION";
            case 1009:
                return "INTERNAL_EXCEPTION";
            case 1010:
                return "NONE_PERMISSION";
            default:
                return "unknown status code: " + i;
        }
    }
}
