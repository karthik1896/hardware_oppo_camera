package com.coloros.statistics.dcs;

import android.content.Context;
import android.text.TextUtils;
import com.coloros.statistics.dcs.b.f;
import com.coloros.statistics.dcs.e.d;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

/* compiled from: StatisticsExceptionHandler */
public class b implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private Context f2527a;

    /* renamed from: b  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f2528b = Thread.getDefaultUncaughtExceptionHandler();

    public b(Context context) {
        this.f2527a = context.getApplicationContext();
    }

    public void a() {
        if (this != this.f2528b) {
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        d.a("NearMeStatistics", "StatisticsExceptionHandler: get the uncaughtException.");
        String a2 = a(th);
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(a2)) {
            f fVar = new f();
            fVar.a(1);
            fVar.a(currentTimeMillis);
            fVar.a(a2);
            com.coloros.statistics.dcs.a.f.a(this.f2527a, fVar);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f2528b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    /* JADX INFO: finally extract failed */
    private String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            th.printStackTrace(printWriter);
            String stringWriter2 = stringWriter.toString();
            printWriter.close();
            return stringWriter2;
        } catch (Exception e) {
            d.a("NearMeStatistics", (Throwable) e);
            printWriter.close();
            return null;
        } catch (Throwable th2) {
            printWriter.close();
            throw th2;
        }
    }
}
