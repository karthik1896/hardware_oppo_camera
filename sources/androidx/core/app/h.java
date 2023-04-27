package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* compiled from: NotificationCompat */
public class h {

    /* compiled from: NotificationCompat */
    public static class d {
        String A;
        Bundle B;
        int C = 0;
        int D = 0;
        Notification E;
        RemoteViews F;
        RemoteViews G;
        RemoteViews H;
        String I;
        int J = 0;
        String K;
        long L;
        int M = 0;
        boolean N;
        c O;
        Notification P = new Notification();
        @Deprecated
        public ArrayList<String> Q;

        /* renamed from: a  reason: collision with root package name */
        public Context f593a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a> f594b = new ArrayList<>();
        ArrayList<a> c = new ArrayList<>();
        CharSequence d;
        CharSequence e;
        PendingIntent f;
        PendingIntent g;
        RemoteViews h;
        Bitmap i;
        CharSequence j;
        int k;
        int l;
        boolean m = true;
        boolean n;
        e o;
        CharSequence p;
        CharSequence[] q;
        int r;
        int s;
        boolean t;
        String u;
        boolean v;
        String w;
        boolean x = false;
        boolean y;
        boolean z;

        public d(Context context, String str) {
            this.f593a = context;
            this.I = str;
            this.P.when = System.currentTimeMillis();
            this.P.audioStreamType = -1;
            this.l = 0;
            this.Q = new ArrayList<>();
            this.N = true;
        }

        public d a(long j2) {
            this.P.when = j2;
            return this;
        }

        public d a(int i2) {
            this.P.icon = i2;
            return this;
        }

        public d a(CharSequence charSequence) {
            this.e = c(charSequence);
            return this;
        }

        public d a(PendingIntent pendingIntent) {
            this.f = pendingIntent;
            return this;
        }

        public d b(CharSequence charSequence) {
            this.P.tickerText = c(charSequence);
            return this;
        }

        public d a(boolean z2) {
            a(2, z2);
            return this;
        }

        public d b(boolean z2) {
            a(16, z2);
            return this;
        }

        public d a(String str) {
            this.A = str;
            return this;
        }

        public d b(int i2) {
            Notification notification = this.P;
            notification.defaults = i2;
            if ((i2 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        private void a(int i2, boolean z2) {
            if (z2) {
                Notification notification = this.P;
                notification.flags = i2 | notification.flags;
                return;
            }
            Notification notification2 = this.P;
            notification2.flags = (~i2) & notification2.flags;
        }

        public d c(int i2) {
            this.l = i2;
            return this;
        }

        public Bundle a() {
            if (this.B == null) {
                this.B = new Bundle();
            }
            return this.B;
        }

        public d a(e eVar) {
            if (this.o != eVar) {
                this.o = eVar;
                e eVar2 = this.o;
                if (eVar2 != null) {
                    eVar2.a(this);
                }
            }
            return this;
        }

        public Notification b() {
            return new i(this).b();
        }

        protected static CharSequence c(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }
    }

    /* compiled from: NotificationCompat */
    public static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        protected d f595a;

        /* renamed from: b  reason: collision with root package name */
        CharSequence f596b;
        CharSequence c;
        boolean d = false;

        public void a(Bundle bundle) {
        }

        public void a(g gVar) {
        }

        public RemoteViews b(g gVar) {
            return null;
        }

        public RemoteViews c(g gVar) {
            return null;
        }

        public RemoteViews d(g gVar) {
            return null;
        }

        public void a(d dVar) {
            if (this.f595a != dVar) {
                this.f595a = dVar;
                d dVar2 = this.f595a;
                if (dVar2 != null) {
                    dVar2.a(this);
                }
            }
        }
    }

    /* compiled from: NotificationCompat */
    public static class b extends e {
        private CharSequence e;

        public b a(CharSequence charSequence) {
            this.f596b = d.c(charSequence);
            return this;
        }

        public void a(g gVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(gVar.a()).setBigContentTitle(this.f596b).bigText(this.e);
                if (this.d) {
                    bigText.setSummaryText(this.c);
                }
            }
        }
    }

    /* compiled from: NotificationCompat */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Bundle f589a;

        /* renamed from: b  reason: collision with root package name */
        boolean f590b;
        @Deprecated
        public int c;
        public CharSequence d;
        public PendingIntent e;
        private IconCompat f;
        private final k[] g;
        private final k[] h;
        private boolean i;
        private final int j;
        private final boolean k;

        @Deprecated
        public int a() {
            return this.c;
        }

        public IconCompat b() {
            int i2;
            if (this.f == null && (i2 = this.c) != 0) {
                this.f = IconCompat.a((Resources) null, "", i2);
            }
            return this.f;
        }

        public CharSequence c() {
            return this.d;
        }

        public PendingIntent d() {
            return this.e;
        }

        public Bundle e() {
            return this.f589a;
        }

        public boolean f() {
            return this.i;
        }

        public k[] g() {
            return this.g;
        }

        public int h() {
            return this.j;
        }

        public boolean i() {
            return this.k;
        }

        public k[] j() {
            return this.h;
        }

        public boolean k() {
            return this.f590b;
        }
    }

    /* compiled from: NotificationCompat */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private PendingIntent f591a;

        /* renamed from: b  reason: collision with root package name */
        private PendingIntent f592b;
        private IconCompat c;
        private int d;
        private int e;
        private int f;

        public PendingIntent a() {
            return this.f591a;
        }

        public PendingIntent b() {
            return this.f592b;
        }

        public IconCompat c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }

        public boolean f() {
            return (this.f & 1) != 0;
        }

        public boolean g() {
            return (this.f & 2) != 0;
        }

        public static Notification.BubbleMetadata a(c cVar) {
            if (cVar == null) {
                return null;
            }
            Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setAutoExpandBubble(cVar.f()).setDeleteIntent(cVar.b()).setIcon(cVar.c().c()).setIntent(cVar.a()).setSuppressNotification(cVar.g());
            if (cVar.d() != 0) {
                suppressNotification.setDesiredHeight(cVar.d());
            }
            if (cVar.e() != 0) {
                suppressNotification.setDesiredHeightResId(cVar.e());
            }
            return suppressNotification.build();
        }
    }

    public static Bundle a(Notification notification) {
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return j.a(notification);
        }
        return null;
    }
}
