package com.crunchfish.touchless_a3d.exception;

public class DeadInstanceException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public DeadInstanceException() {
    }

    public DeadInstanceException(String str) {
        super(str);
    }

    public DeadInstanceException(Throwable th) {
        super(th);
    }

    public DeadInstanceException(String str, Throwable th) {
        super(str, th);
    }
}
