package com.oppo.camera;

import android.view.KeyEvent;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: OnKeyEventManager */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private static volatile q f3148a;

    /* renamed from: b  reason: collision with root package name */
    private List<a> f3149b = new CopyOnWriteArrayList();

    /* compiled from: OnKeyEventManager */
    public interface a {
        void a(int i, KeyEvent keyEvent);
    }

    private q() {
    }

    public static q a() {
        if (f3148a == null) {
            synchronized (q.class) {
                if (f3148a == null) {
                    f3148a = new q();
                }
            }
        }
        return f3148a;
    }

    public void a(int i, KeyEvent keyEvent) {
        e.a("OnKeyEventManager", "notifyOnKeyDown, mOnKeyEventListenerList.size: " + this.f3149b.size());
        for (a a2 : this.f3149b) {
            a2.a(i, keyEvent);
        }
    }

    public void a(a aVar) {
        e.a("OnKeyEventManager", "addOnKeyEventListener, listener: " + aVar);
        this.f3149b.add(aVar);
    }

    public void b(a aVar) {
        e.a("OnKeyEventManager", "removeOnKeyEventListener, listener: " + aVar);
        this.f3149b.remove(aVar);
    }
}
