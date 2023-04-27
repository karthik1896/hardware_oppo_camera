package com.oppo.camera.ui.control;

/* compiled from: MainShutterButtonInfo */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private int f3915a;

    /* renamed from: b  reason: collision with root package name */
    private String f3916b;
    private String c;
    private int d;
    private boolean e;
    private boolean f;

    public c() {
        this.f3915a = 0;
        this.f3916b = null;
        this.c = null;
        this.d = 0;
        this.e = false;
        this.f = false;
        this.f3915a = 1;
        this.f3916b = "button_color_inside_none";
        this.c = "button_shape_ring_none";
        this.d = 0;
    }

    public c(int i) {
        this.f3915a = 0;
        this.f3916b = null;
        this.c = null;
        this.d = 0;
        this.e = false;
        this.f = false;
        this.f3915a = i;
        this.f3916b = "button_color_inside_none";
        this.c = "button_shape_ring_none";
        this.d = 0;
    }

    public c(int i, String str) {
        this.f3915a = 0;
        this.f3916b = null;
        this.c = null;
        this.d = 0;
        this.e = false;
        this.f = false;
        this.f3915a = i;
        this.f3916b = str;
        this.c = "button_shape_ring_none";
        this.d = 0;
    }

    public c(int i, String str, String str2, int i2) {
        this.f3915a = 0;
        this.f3916b = null;
        this.c = null;
        this.d = 0;
        this.e = false;
        this.f = false;
        this.f3915a = i;
        this.f3916b = str;
        this.c = str2;
        this.d = i2;
    }

    public c(int i, String str, String str2) {
        this.f3915a = 0;
        this.f3916b = null;
        this.c = null;
        this.d = 0;
        this.e = false;
        this.f = false;
        this.f3915a = i;
        this.f3916b = str;
        this.c = str2;
        this.d = 1;
    }

    public int a() {
        return this.f3915a;
    }

    public void a(int i) {
        this.f3915a = i;
    }

    public String b() {
        return this.f3916b;
    }

    public void a(String str) {
        this.f3916b = str;
    }

    public String c() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public int d() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public boolean e() {
        return this.f;
    }

    public boolean f() {
        return this.e;
    }

    public void b(boolean z) {
        this.e = z;
    }
}
