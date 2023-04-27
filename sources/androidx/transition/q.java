package androidx.transition;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionSet */
public class q extends m {

    /* renamed from: a  reason: collision with root package name */
    int f1304a;

    /* renamed from: b  reason: collision with root package name */
    boolean f1305b = false;
    private ArrayList<m> c = new ArrayList<>();
    private boolean d = true;
    private int e = 0;

    public q a(int i) {
        if (i == 0) {
            this.d = true;
        } else if (i == 1) {
            this.d = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
        return this;
    }

    public q a(m mVar) {
        b(mVar);
        if (this.mDuration >= 0) {
            mVar.setDuration(this.mDuration);
        }
        if ((this.e & 1) != 0) {
            mVar.setInterpolator(getInterpolator());
        }
        if ((this.e & 2) != 0) {
            mVar.setPropagation(getPropagation());
        }
        if ((this.e & 4) != 0) {
            mVar.setPathMotion(getPathMotion());
        }
        if ((this.e & 8) != 0) {
            mVar.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    private void b(m mVar) {
        this.c.add(mVar);
        mVar.mParent = this;
    }

    public int a() {
        return this.c.size();
    }

    public m b(int i) {
        if (i < 0 || i >= this.c.size()) {
            return null;
        }
        return this.c.get(i);
    }

    /* renamed from: a */
    public q setDuration(long j) {
        ArrayList<m> arrayList;
        super.setDuration(j);
        if (this.mDuration >= 0 && (arrayList = this.c) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.c.get(i).setDuration(j);
            }
        }
        return this;
    }

    /* renamed from: b */
    public q setStartDelay(long j) {
        return (q) super.setStartDelay(j);
    }

    /* renamed from: a */
    public q setInterpolator(TimeInterpolator timeInterpolator) {
        this.e |= 1;
        ArrayList<m> arrayList = this.c;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.c.get(i).setInterpolator(timeInterpolator);
            }
        }
        return (q) super.setInterpolator(timeInterpolator);
    }

    /* renamed from: a */
    public q addTarget(View view) {
        for (int i = 0; i < this.c.size(); i++) {
            this.c.get(i).addTarget(view);
        }
        return (q) super.addTarget(view);
    }

    /* renamed from: c */
    public q addTarget(int i) {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            this.c.get(i2).addTarget(i);
        }
        return (q) super.addTarget(i);
    }

    /* renamed from: a */
    public q addTarget(String str) {
        for (int i = 0; i < this.c.size(); i++) {
            this.c.get(i).addTarget(str);
        }
        return (q) super.addTarget(str);
    }

    /* renamed from: a */
    public q addTarget(Class<?> cls) {
        for (int i = 0; i < this.c.size(); i++) {
            this.c.get(i).addTarget(cls);
        }
        return (q) super.addTarget(cls);
    }

    /* renamed from: a */
    public q addListener(m.d dVar) {
        return (q) super.addListener(dVar);
    }

    /* renamed from: d */
    public q removeTarget(int i) {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            this.c.get(i2).removeTarget(i);
        }
        return (q) super.removeTarget(i);
    }

    /* renamed from: b */
    public q removeTarget(View view) {
        for (int i = 0; i < this.c.size(); i++) {
            this.c.get(i).removeTarget(view);
        }
        return (q) super.removeTarget(view);
    }

    /* renamed from: b */
    public q removeTarget(Class<?> cls) {
        for (int i = 0; i < this.c.size(); i++) {
            this.c.get(i).removeTarget(cls);
        }
        return (q) super.removeTarget(cls);
    }

    /* renamed from: b */
    public q removeTarget(String str) {
        for (int i = 0; i < this.c.size(); i++) {
            this.c.get(i).removeTarget(str);
        }
        return (q) super.removeTarget(str);
    }

    public m excludeTarget(View view, boolean z) {
        for (int i = 0; i < this.c.size(); i++) {
            this.c.get(i).excludeTarget(view, z);
        }
        return super.excludeTarget(view, z);
    }

    public m excludeTarget(String str, boolean z) {
        for (int i = 0; i < this.c.size(); i++) {
            this.c.get(i).excludeTarget(str, z);
        }
        return super.excludeTarget(str, z);
    }

    public m excludeTarget(int i, boolean z) {
        for (int i2 = 0; i2 < this.c.size(); i2++) {
            this.c.get(i2).excludeTarget(i, z);
        }
        return super.excludeTarget(i, z);
    }

    public m excludeTarget(Class<?> cls, boolean z) {
        for (int i = 0; i < this.c.size(); i++) {
            this.c.get(i).excludeTarget(cls, z);
        }
        return super.excludeTarget(cls, z);
    }

    /* renamed from: b */
    public q removeListener(m.d dVar) {
        return (q) super.removeListener(dVar);
    }

    public void setPathMotion(g gVar) {
        super.setPathMotion(gVar);
        this.e |= 4;
        if (this.c != null) {
            for (int i = 0; i < this.c.size(); i++) {
                this.c.get(i).setPathMotion(gVar);
            }
        }
    }

    private void b() {
        a aVar = new a(this);
        Iterator<m> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().addListener(aVar);
        }
        this.f1304a = this.c.size();
    }

    /* compiled from: TransitionSet */
    static class a extends n {

        /* renamed from: a  reason: collision with root package name */
        q f1308a;

        a(q qVar) {
            this.f1308a = qVar;
        }

        public void e(m mVar) {
            if (!this.f1308a.f1305b) {
                this.f1308a.start();
                this.f1308a.f1305b = true;
            }
        }

        public void b(m mVar) {
            q qVar = this.f1308a;
            qVar.f1304a--;
            if (this.f1308a.f1304a == 0) {
                q qVar2 = this.f1308a;
                qVar2.f1305b = false;
                qVar2.end();
            }
            mVar.removeListener(this);
        }
    }

    /* access modifiers changed from: protected */
    public void createAnimators(ViewGroup viewGroup, u uVar, u uVar2, ArrayList<t> arrayList, ArrayList<t> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            m mVar = this.c.get(i);
            if (startDelay > 0 && (this.d || i == 0)) {
                long startDelay2 = mVar.getStartDelay();
                if (startDelay2 > 0) {
                    mVar.setStartDelay(startDelay2 + startDelay);
                } else {
                    mVar.setStartDelay(startDelay);
                }
            }
            mVar.createAnimators(viewGroup, uVar, uVar2, arrayList, arrayList2);
        }
    }

    /* access modifiers changed from: protected */
    public void runAnimators() {
        if (this.c.isEmpty()) {
            start();
            end();
            return;
        }
        b();
        if (!this.d) {
            for (int i = 1; i < this.c.size(); i++) {
                final m mVar = this.c.get(i);
                this.c.get(i - 1).addListener(new n() {
                    public void b(m mVar) {
                        mVar.runAnimators();
                        mVar.removeListener(this);
                    }
                });
            }
            m mVar2 = this.c.get(0);
            if (mVar2 != null) {
                mVar2.runAnimators();
                return;
            }
            return;
        }
        Iterator<m> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().runAnimators();
        }
    }

    public void captureStartValues(t tVar) {
        if (isValidTarget(tVar.f1312b)) {
            Iterator<m> it = this.c.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next.isValidTarget(tVar.f1312b)) {
                    next.captureStartValues(tVar);
                    tVar.c.add(next);
                }
            }
        }
    }

    public void captureEndValues(t tVar) {
        if (isValidTarget(tVar.f1312b)) {
            Iterator<m> it = this.c.iterator();
            while (it.hasNext()) {
                m next = it.next();
                if (next.isValidTarget(tVar.f1312b)) {
                    next.captureEndValues(tVar);
                    tVar.c.add(next);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void capturePropagationValues(t tVar) {
        super.capturePropagationValues(tVar);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.c.get(i).capturePropagationValues(tVar);
        }
    }

    public void pause(View view) {
        super.pause(view);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.c.get(i).pause(view);
        }
    }

    public void resume(View view) {
        super.resume(view);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.c.get(i).resume(view);
        }
    }

    /* access modifiers changed from: protected */
    public void cancel() {
        super.cancel();
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.c.get(i).cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.c.get(i).forceToEnd(viewGroup);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public q setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.c.get(i).setSceneRoot(viewGroup);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public void setCanRemoveViews(boolean z) {
        super.setCanRemoveViews(z);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.c.get(i).setCanRemoveViews(z);
        }
    }

    public void setPropagation(p pVar) {
        super.setPropagation(pVar);
        this.e |= 2;
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.c.get(i).setPropagation(pVar);
        }
    }

    public void setEpicenterCallback(m.c cVar) {
        super.setEpicenterCallback(cVar);
        this.e |= 8;
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.c.get(i).setEpicenterCallback(cVar);
        }
    }

    /* access modifiers changed from: package-private */
    public String toString(String str) {
        String mVar = super.toString(str);
        for (int i = 0; i < this.c.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(mVar);
            sb.append("\n");
            sb.append(this.c.get(i).toString(str + "  "));
            mVar = sb.toString();
        }
        return mVar;
    }

    public m clone() {
        q qVar = (q) super.clone();
        qVar.c = new ArrayList<>();
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            qVar.b(this.c.get(i).clone());
        }
        return qVar;
    }
}
