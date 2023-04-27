package com.crunchfish.touchless_a3d.exception;

public class LicenseServerUnavailableException extends Exception {
    private static final long serialVersionUID = 1;

    public LicenseServerUnavailableException() {
    }

    public LicenseServerUnavailableException(String str) {
        super(str);
    }

    public LicenseServerUnavailableException(Throwable th) {
        super(th);
    }

    public LicenseServerUnavailableException(String str, Throwable th) {
        super(str, th);
    }
}
