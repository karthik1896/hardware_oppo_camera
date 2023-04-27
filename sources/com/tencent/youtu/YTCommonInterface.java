package com.tencent.youtu;

public class YTCommonInterface {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f4640a = (!YTCommonInterface.class.desiredAssertionStatus());

    /* renamed from: b  reason: collision with root package name */
    private static String f4641b = "YTCommon";

    private static native int nativeInitAuthByAssets(String str, String str2);

    public static int a(String str, String str2) {
        if (f4640a || str != null) {
            if (str2 == null) {
                str2 = "";
            }
            return nativeInitAuthByAssets(str, str2);
        }
        throw new AssertionError();
    }
}
