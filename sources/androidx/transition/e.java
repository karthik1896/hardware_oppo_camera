package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.n;
import androidx.transition.m;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"RestrictedApi"})
/* compiled from: FragmentTransitionSupport */
public class e extends n {
    public boolean a(Object obj) {
        return obj instanceof m;
    }

    public Object b(Object obj) {
        if (obj != null) {
            return ((m) obj).clone();
        }
        return null;
    }

    public Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        q qVar = new q();
        qVar.a((m) obj);
        return qVar;
    }

    public void a(Object obj, View view, ArrayList<View> arrayList) {
        q qVar = (q) obj;
        List<View> targets = qVar.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            a(targets, arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        a((Object) qVar, arrayList);
    }

    public void a(Object obj, View view) {
        if (view != null) {
            final Rect rect = new Rect();
            a(view, rect);
            ((m) obj).setEpicenterCallback(new m.c() {
                public Rect a(m mVar) {
                    return rect;
                }
            });
        }
    }

    public void a(Object obj, ArrayList<View> arrayList) {
        m mVar = (m) obj;
        if (mVar != null) {
            int i = 0;
            if (mVar instanceof q) {
                q qVar = (q) mVar;
                int a2 = qVar.a();
                while (i < a2) {
                    a((Object) qVar.b(i), arrayList);
                    i++;
                }
            } else if (!a(mVar) && a((List) mVar.getTargets())) {
                int size = arrayList.size();
                while (i < size) {
                    mVar.addTarget(arrayList.get(i));
                    i++;
                }
            }
        }
    }

    private static boolean a(m mVar) {
        return !a((List) mVar.getTargetIds()) || !a((List) mVar.getTargetNames()) || !a((List) mVar.getTargetTypes());
    }

    public Object a(Object obj, Object obj2, Object obj3) {
        q qVar = new q();
        if (obj != null) {
            qVar.a((m) obj);
        }
        if (obj2 != null) {
            qVar.a((m) obj2);
        }
        if (obj3 != null) {
            qVar.a((m) obj3);
        }
        return qVar;
    }

    public void b(Object obj, final View view, final ArrayList<View> arrayList) {
        ((m) obj).addListener(new m.d() {
            public void a(m mVar) {
            }

            public void c(m mVar) {
            }

            public void d(m mVar) {
            }

            public void e(m mVar) {
            }

            public void b(m mVar) {
                mVar.removeListener(this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((View) arrayList.get(i)).setVisibility(0);
                }
            }
        });
    }

    public Object b(Object obj, Object obj2, Object obj3) {
        m mVar = (m) obj;
        m mVar2 = (m) obj2;
        m mVar3 = (m) obj3;
        if (mVar != null && mVar2 != null) {
            mVar = new q().a(mVar).a(mVar2).a(1);
        } else if (mVar == null) {
            mVar = mVar2 != null ? mVar2 : null;
        }
        if (mVar3 == null) {
            return mVar;
        }
        q qVar = new q();
        if (mVar != null) {
            qVar.a(mVar);
        }
        qVar.a(mVar3);
        return qVar;
    }

    public void a(ViewGroup viewGroup, Object obj) {
        o.a(viewGroup, (m) obj);
    }

    public void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        final Object obj5 = obj2;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj6 = obj3;
        final ArrayList<View> arrayList5 = arrayList2;
        final Object obj7 = obj4;
        final ArrayList<View> arrayList6 = arrayList3;
        ((m) obj).addListener(new n() {
            public void e(m mVar) {
                Object obj = obj5;
                if (obj != null) {
                    e.this.b(obj, (ArrayList<View>) arrayList4, (ArrayList<View>) null);
                }
                Object obj2 = obj6;
                if (obj2 != null) {
                    e.this.b(obj2, (ArrayList<View>) arrayList5, (ArrayList<View>) null);
                }
                Object obj3 = obj7;
                if (obj3 != null) {
                    e.this.b(obj3, (ArrayList<View>) arrayList6, (ArrayList<View>) null);
                }
            }

            public void b(m mVar) {
                mVar.removeListener(this);
            }
        });
    }

    public void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        q qVar = (q) obj;
        if (qVar != null) {
            qVar.getTargets().clear();
            qVar.getTargets().addAll(arrayList2);
            b((Object) qVar, arrayList, arrayList2);
        }
    }

    public void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int i;
        m mVar = (m) obj;
        int i2 = 0;
        if (mVar instanceof q) {
            q qVar = (q) mVar;
            int a2 = qVar.a();
            while (i2 < a2) {
                b((Object) qVar.b(i2), arrayList, arrayList2);
                i2++;
            }
        } else if (!a(mVar)) {
            List<View> targets = mVar.getTargets();
            if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    i = 0;
                } else {
                    i = arrayList2.size();
                }
                while (i2 < i) {
                    mVar.addTarget(arrayList2.get(i2));
                    i2++;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    mVar.removeTarget(arrayList.get(size));
                }
            }
        }
    }

    public void b(Object obj, View view) {
        if (obj != null) {
            ((m) obj).addTarget(view);
        }
    }

    public void c(Object obj, View view) {
        if (obj != null) {
            ((m) obj).removeTarget(view);
        }
    }

    public void a(Object obj, final Rect rect) {
        if (obj != null) {
            ((m) obj).setEpicenterCallback(new m.c() {
                public Rect a(m mVar) {
                    Rect rect = rect;
                    if (rect == null || rect.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }
}
