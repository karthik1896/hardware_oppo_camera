package com.heytap.tingle.ipc.c;

import java.util.concurrent.locks.ReentrantLock;

/* compiled from: SystemServiceProxy */
public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    protected static String f2659a;

    /* renamed from: b  reason: collision with root package name */
    protected ThreadLocal<String> f2660b = new ThreadLocal<>();
    protected String c;
    protected boolean d;
    private final ReentrantLock e = new ReentrantLock(true);

    protected a() {
        f2659a = getClass().getName();
        this.d = true;
    }
}
