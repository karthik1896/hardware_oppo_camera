package com.oppo.camera.ui.beauty3d;

import java.util.Stack;

/* compiled from: Beauty3DEditStack */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private Stack<b> f3833a = new Stack<>();

    /* renamed from: b  reason: collision with root package name */
    private Stack<b> f3834b = new Stack<>();

    public b a() {
        if (this.f3833a.size() < 0) {
            return null;
        }
        return this.f3833a.pop();
    }

    public b b() {
        if (this.f3834b.size() < 0) {
            return null;
        }
        return this.f3834b.pop();
    }

    public b a(b bVar) {
        return this.f3833a.push(bVar);
    }

    public b b(b bVar) {
        return this.f3834b.push(bVar);
    }

    public int c() {
        return this.f3833a.size();
    }

    public int d() {
        return this.f3834b.size();
    }

    public void e() {
        while (!this.f3834b.isEmpty()) {
            this.f3834b.pop();
        }
    }

    public void f() {
        while (!this.f3833a.isEmpty()) {
            this.f3833a.pop();
        }
        while (!this.f3834b.isEmpty()) {
            this.f3834b.pop();
        }
    }
}
