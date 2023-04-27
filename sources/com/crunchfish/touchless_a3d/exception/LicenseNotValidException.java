package com.crunchfish.touchless_a3d.exception;

public class LicenseNotValidException extends Exception {
    private static final long serialVersionUID = 1;

    public LicenseNotValidException() {
    }

    public LicenseNotValidException(String str) {
        super(str);
    }

    public LicenseNotValidException(Throwable th) {
        super(th);
    }

    public LicenseNotValidException(String str, Throwable th) {
        super(str, th);
    }
}
