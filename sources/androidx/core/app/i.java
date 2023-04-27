package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.h;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: NotificationCompatBuilder */
class i implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Notification.Builder f597a;

    /* renamed from: b  reason: collision with root package name */
    private final h.d f598b;
    private RemoteViews c;
    private RemoteViews d;
    private final List<Bundle> e = new ArrayList();
    private final Bundle f = new Bundle();
    private int g;
    private RemoteViews h;

    i(h.d dVar) {
        this.f598b = dVar;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f597a = new Notification.Builder(dVar.f593a, dVar.I);
        } else {
            this.f597a = new Notification.Builder(dVar.f593a);
        }
        Notification notification = dVar.P;
        this.f597a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.h).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.d).setContentText(dVar.e).setContentInfo(dVar.j).setContentIntent(dVar.f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.g, (notification.flags & 128) != 0).setLargeIcon(dVar.i).setNumber(dVar.k).setProgress(dVar.r, dVar.s, dVar.t);
        if (Build.VERSION.SDK_INT < 21) {
            this.f597a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f597a.setSubText(dVar.p).setUsesChronometer(dVar.n).setPriority(dVar.l);
            Iterator<h.a> it = dVar.f594b.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            if (dVar.B != null) {
                this.f.putAll(dVar.B);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (dVar.x) {
                    this.f.putBoolean("android.support.localOnly", true);
                }
                if (dVar.u != null) {
                    this.f.putString("android.support.groupKey", dVar.u);
                    if (dVar.v) {
                        this.f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                if (dVar.w != null) {
                    this.f.putString("android.support.sortKey", dVar.w);
                }
            }
            this.c = dVar.F;
            this.d = dVar.G;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.f597a.setShowWhen(dVar.m);
            if (Build.VERSION.SDK_INT < 21 && dVar.Q != null && !dVar.Q.isEmpty()) {
                this.f.putStringArray("android.people", (String[]) dVar.Q.toArray(new String[dVar.Q.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f597a.setLocalOnly(dVar.x).setGroup(dVar.u).setGroupSummary(dVar.v).setSortKey(dVar.w);
            this.g = dVar.M;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f597a.setCategory(dVar.A).setColor(dVar.C).setVisibility(dVar.D).setPublicVersion(dVar.E).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = dVar.Q.iterator();
            while (it2.hasNext()) {
                this.f597a.addPerson(it2.next());
            }
            this.h = dVar.H;
            if (dVar.c.size() > 0) {
                Bundle bundle = dVar.a().getBundle("android.car.EXTENSIONS");
                bundle = bundle == null ? new Bundle() : bundle;
                Bundle bundle2 = new Bundle();
                for (int i = 0; i < dVar.c.size(); i++) {
                    bundle2.putBundle(Integer.toString(i), j.a(dVar.c.get(i)));
                }
                bundle.putBundle("invisible_actions", bundle2);
                dVar.a().putBundle("android.car.EXTENSIONS", bundle);
                this.f.putBundle("android.car.EXTENSIONS", bundle);
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f597a.setExtras(dVar.B).setRemoteInputHistory(dVar.q);
            if (dVar.F != null) {
                this.f597a.setCustomContentView(dVar.F);
            }
            if (dVar.G != null) {
                this.f597a.setCustomBigContentView(dVar.G);
            }
            if (dVar.H != null) {
                this.f597a.setCustomHeadsUpContentView(dVar.H);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f597a.setBadgeIconType(dVar.J).setShortcutId(dVar.K).setTimeoutAfter(dVar.L).setGroupAlertBehavior(dVar.M);
            if (dVar.z) {
                this.f597a.setColorized(dVar.y);
            }
            if (!TextUtils.isEmpty(dVar.I)) {
                this.f597a.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f597a.setAllowSystemGeneratedContextualActions(dVar.N);
            this.f597a.setBubbleMetadata(h.c.a(dVar.O));
        }
    }

    public Notification.Builder a() {
        return this.f597a;
    }

    public Notification b() {
        Bundle a2;
        RemoteViews d2;
        RemoteViews c2;
        h.e eVar = this.f598b.o;
        if (eVar != null) {
            eVar.a((g) this);
        }
        RemoteViews b2 = eVar != null ? eVar.b(this) : null;
        Notification c3 = c();
        if (b2 != null) {
            c3.contentView = b2;
        } else if (this.f598b.F != null) {
            c3.contentView = this.f598b.F;
        }
        if (!(Build.VERSION.SDK_INT < 16 || eVar == null || (c2 = eVar.c(this)) == null)) {
            c3.bigContentView = c2;
        }
        if (!(Build.VERSION.SDK_INT < 21 || eVar == null || (d2 = this.f598b.o.d(this)) == null)) {
            c3.headsUpContentView = d2;
        }
        if (!(Build.VERSION.SDK_INT < 16 || eVar == null || (a2 = h.a(c3)) == null)) {
            eVar.a(a2);
        }
        return c3;
    }

    private void a(h.a aVar) {
        Notification.Action.Builder builder;
        Bundle bundle;
        Icon icon;
        if (Build.VERSION.SDK_INT >= 20) {
            if (Build.VERSION.SDK_INT >= 23) {
                IconCompat b2 = aVar.b();
                if (b2 == null) {
                    icon = null;
                } else {
                    icon = b2.c();
                }
                builder = new Notification.Action.Builder(icon, aVar.c(), aVar.d());
            } else {
                builder = new Notification.Action.Builder(aVar.a(), aVar.c(), aVar.d());
            }
            if (aVar.g() != null) {
                for (RemoteInput addRemoteInput : k.a(aVar.g())) {
                    builder.addRemoteInput(addRemoteInput);
                }
            }
            if (aVar.e() != null) {
                bundle = new Bundle(aVar.e());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.f());
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.f());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.h());
            if (Build.VERSION.SDK_INT >= 28) {
                builder.setSemanticAction(aVar.h());
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder.setContextual(aVar.i());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.k());
            builder.addExtras(bundle);
            this.f597a.addAction(builder.build());
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.e.add(j.a(this.f597a, aVar));
        }
    }

    /* access modifiers changed from: protected */
    public Notification c() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f597a.build();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Notification build = this.f597a.build();
            if (this.g != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.g != 2)) {
                    a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.g == 1) {
                    a(build);
                }
            }
            return build;
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.f597a.setExtras(this.f);
            Notification build2 = this.f597a.build();
            RemoteViews remoteViews = this.c;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.d;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.h;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.g != 0) {
                if (!(build2.getGroup() == null || (build2.flags & 512) == 0 || this.g != 2)) {
                    a(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.g == 1) {
                    a(build2);
                }
            }
            return build2;
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.f597a.setExtras(this.f);
            Notification build3 = this.f597a.build();
            RemoteViews remoteViews4 = this.c;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.d;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.g != 0) {
                if (!(build3.getGroup() == null || (build3.flags & 512) == 0 || this.g != 2)) {
                    a(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.g == 1) {
                    a(build3);
                }
            }
            return build3;
        } else if (Build.VERSION.SDK_INT >= 19) {
            SparseArray<Bundle> a2 = j.a(this.e);
            if (a2 != null) {
                this.f.putSparseParcelableArray("android.support.actionExtras", a2);
            }
            this.f597a.setExtras(this.f);
            Notification build4 = this.f597a.build();
            RemoteViews remoteViews6 = this.c;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.d;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        } else if (Build.VERSION.SDK_INT < 16) {
            return this.f597a.getNotification();
        } else {
            Notification build5 = this.f597a.build();
            Bundle a3 = h.a(build5);
            Bundle bundle = new Bundle(this.f);
            for (String str : this.f.keySet()) {
                if (a3.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a3.putAll(bundle);
            SparseArray<Bundle> a4 = j.a(this.e);
            if (a4 != null) {
                h.a(build5).putSparseParcelableArray("android.support.actionExtras", a4);
            }
            RemoteViews remoteViews8 = this.c;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.d;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        }
    }

    private void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
