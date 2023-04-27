package com.oppo.camera.ui.menu;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.e;
import com.oppo.camera.entry.b;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: PreferenceMenuOptionGroup */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?>[] f4096a = {Context.class, AttributeSet.class};

    /* renamed from: b  reason: collision with root package name */
    private static final String f4097b = PreferenceMenuOptionInfo.class.getPackage().getName();
    private static final HashMap<String, Constructor<?>> c = new HashMap<>();
    private CopyOnWriteArrayList<a> d = null;
    private Context e = null;
    private boolean f = false;

    public g(Context context, int i, boolean z) {
        this.e = context;
        this.d = new CopyOnWriteArrayList<>();
        this.f = z;
        a(i);
    }

    private void a(int i) {
        e.a("PreferenceMenuOptionGroup", "inflate");
        if (i == 0) {
            e.e("PreferenceMenuOptionGroup", "Invalid resources id!");
            return;
        }
        this.d.clear();
        XmlResourceParser xml = this.e.getResources().getXml(i);
        Object[] objArr = {this.e, Xml.asAttributeSet(xml)};
        while (true) {
            try {
                int next = xml.next();
                if (next == 1) {
                    break;
                } else if (next == 2) {
                    if (!xml.getName().equals("PreferenceMenuOptionGroup")) {
                        a a2 = a(xml.getName(), objArr);
                        if (!this.f) {
                            if (!CameraConfig.checkKeyInMenuList(b.c(a2.getOptionKey()))) {
                                a2.release();
                            }
                        }
                        this.d.add(a2);
                    }
                }
            } catch (XmlPullParserException e2) {
                throw new InflateException(e2);
            } catch (IOException e3) {
                throw new InflateException(xml.getPositionDescription(), e3);
            }
        }
        if (this.d.size() == 0) {
            throw new InflateException("No root element found");
        }
    }

    private a a(String str, Object[] objArr) {
        String str2 = f4097b + "." + str;
        Constructor<?> constructor = c.get(str2);
        if (constructor == null) {
            try {
                constructor = this.e.getClassLoader().loadClass(str2).getConstructor(f4096a);
                c.put(str2, constructor);
            } catch (NoSuchMethodException e2) {
                throw new InflateException("Error inflating class " + str2, e2);
            } catch (ClassNotFoundException e3) {
                throw new InflateException("No such class: " + str2, e3);
            } catch (Exception e4) {
                throw new InflateException("While create instance of" + str2, e4);
            }
        }
        return (a) constructor.newInstance(objArr);
    }

    public a a(String str) {
        CopyOnWriteArrayList<a> copyOnWriteArrayList;
        if (str == null || str.equals("") || (copyOnWriteArrayList = this.d) == null) {
            return null;
        }
        Iterator<a> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null && next.getOptionKey().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public void a() {
        CopyOnWriteArrayList<a> copyOnWriteArrayList = this.d;
        if (copyOnWriteArrayList != null) {
            Iterator<a> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.release();
                }
            }
            this.d.clear();
            this.d = null;
        }
    }
}
