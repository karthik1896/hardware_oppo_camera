package com.color.support.widget;

import android.content.res.Configuration;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.CalendarView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.color.support.widget.ColorNumberPicker;
import java.util.Calendar;
import java.util.Locale;

public class ColorLunarDatePicker extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2070a = "ColorLunarDatePicker";

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f2071b = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"};
    private static String c;
    private static Calendar d = Calendar.getInstance();
    private static Calendar e = Calendar.getInstance();
    private final LinearLayout f;
    /* access modifiers changed from: private */
    public final ColorNumberPicker g;
    /* access modifiers changed from: private */
    public final ColorNumberPicker h;
    /* access modifiers changed from: private */
    public final ColorNumberPicker i;
    private Locale j;
    private b k;
    private String[] l;
    private int m;
    /* access modifiers changed from: private */
    public a n;
    /* access modifiers changed from: private */
    public a o;
    private boolean p;

    public interface b {
        void a(ColorLunarDatePicker colorLunarDatePicker, int i, int i2, int i3);
    }

    /* access modifiers changed from: private */
    public void c() {
    }

    public CalendarView getCalendarView() {
        return null;
    }

    public boolean getCalendarViewShown() {
        return false;
    }

    public void setCalendarViewShown(boolean z) {
    }

    static {
        d.set(1910, 2, 10, 0, 0);
        e.set(2036, 11, 31, 23, 59);
    }

    /* renamed from: com.color.support.widget.ColorLunarDatePicker$1  reason: invalid class name */
    class AnonymousClass1 implements ColorNumberPicker.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ColorLunarDatePicker f2072a;

        public void a(ColorNumberPicker colorNumberPicker, int i, int i2) {
            this.f2072a.n.a(this.f2072a.o);
            g.a(this.f2072a.n.a(1), this.f2072a.n.a(2) + 1, this.f2072a.n.a(5));
            if (colorNumberPicker == this.f2072a.g) {
                this.f2072a.n.b(5, i, i2);
            } else if (colorNumberPicker == this.f2072a.h) {
                this.f2072a.n.b(2, i, i2);
            } else if (colorNumberPicker == this.f2072a.i) {
                this.f2072a.n.b(1, i, i2);
            } else {
                throw new IllegalArgumentException();
            }
            ColorLunarDatePicker colorLunarDatePicker = this.f2072a;
            colorLunarDatePicker.setDate(colorLunarDatePicker.n);
            this.f2072a.b();
            this.f2072a.c();
            this.f2072a.d();
        }
    }

    private static String a(a aVar) {
        int[] a2 = g.a(aVar.a(1), aVar.a(2) + 1, aVar.a(5));
        return a(a2[0], a2[1], a2[2], a2[3]);
    }

    private static String a(int i2, int i3, int i4, int i5) {
        String str = "";
        if (i2 != Integer.MIN_VALUE) {
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append("年");
            if (i5 == 0) {
                str = c;
            }
            sb.append(str);
            sb.append(f2071b[i3 - 1]);
            sb.append("月");
            sb.append(g.d(i4));
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        if (i5 == 0) {
            str = c;
        }
        sb2.append(str);
        sb2.append(f2071b[i3 - 1]);
        sb2.append("月");
        sb2.append(g.d(i4));
        return sb2.toString();
    }

    public long getMinDate() {
        return d.getTimeInMillis();
    }

    public void setMinDate(long j2) {
        this.n.a(j2);
        if (this.n.a(1) != d.get(1) || this.n.a(6) == d.get(6)) {
            d.setTimeInMillis(j2);
            if (this.o.b(d)) {
                this.o.a(d.getTimeInMillis());
                c();
            }
            b();
            return;
        }
        String str = f2070a;
        Log.w(str, "setMinDate failed!:" + this.n.a(1) + "<->" + d.get(1) + ":" + this.n.a(6) + "<->" + d.get(6));
    }

    public long getMaxDate() {
        return e.getTimeInMillis();
    }

    public void setMaxDate(long j2) {
        this.n.a(j2);
        if (this.n.a(1) != e.get(1) || this.n.a(6) == e.get(6)) {
            e.setTimeInMillis(j2);
            if (this.o.d(e)) {
                this.o.a(e.getTimeInMillis());
                c();
            }
            b();
            return;
        }
        String str = f2070a;
        Log.w(str, "setMaxDate failed!:" + this.n.a(1) + "<->" + e.get(1) + ":" + this.n.a(6) + "<->" + e.get(6));
    }

    public boolean isEnabled() {
        return this.p;
    }

    public void setEnabled(boolean z) {
        if (this.p != z) {
            super.setEnabled(z);
            this.g.setEnabled(z);
            this.h.setEnabled(z);
            this.i.setEnabled(z);
            this.p = z;
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(DateUtils.formatDateTime(getContext(), this.o.a(), 20));
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    public boolean getSpinnersShown() {
        return this.f.isShown();
    }

    public void setSpinnersShown(boolean z) {
        this.f.setVisibility(z ? 0 : 8);
    }

    private void setCurrentLocale(Locale locale) {
        if (!locale.equals(this.j)) {
            this.j = locale;
            this.n = a(this.n, locale);
            d = a(d, locale);
            e = a(e, locale);
            this.o = a(this.o, locale);
        }
    }

    private a a(a aVar, Locale locale) {
        if (aVar == null) {
            return new a(locale);
        }
        a aVar2 = new a(locale);
        if (!aVar.g) {
            aVar2.a(aVar.a());
        } else {
            aVar2.a(aVar);
        }
        return aVar2;
    }

    private Calendar a(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar instance = Calendar.getInstance(locale);
        instance.setTimeInMillis(timeInMillis);
        return instance;
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getYear(), getMonth(), getDayOfMonth(), (AnonymousClass1) null);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        a(savedState.mYear, savedState.mMonth, savedState.mDay);
        b();
        c();
    }

    private void a(int i2, int i3, int i4) {
        this.o.a(i2, i3, i4);
        a();
    }

    /* access modifiers changed from: private */
    public void setDate(a aVar) {
        this.o.a(aVar);
        a();
    }

    private void a() {
        this.o.a(d, e);
    }

    /* JADX WARNING: type inference failed for: r1v16, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r1v23, types: [java.lang.Object[]] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01bd A[LOOP:3: B:51:0x01bb->B:52:0x01bd, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r16 = this;
            r0 = r16
            com.color.support.widget.ColorLunarDatePicker$a r1 = r0.o
            r2 = 1
            int r1 = r1.a((int) r2)
            com.color.support.widget.ColorLunarDatePicker$a r3 = r0.o
            r4 = 2
            int r3 = r3.a((int) r4)
            int r3 = r3 + r2
            com.color.support.widget.ColorLunarDatePicker$a r5 = r0.o
            r6 = 5
            int r5 = r5.a((int) r6)
            int[] r3 = com.color.support.widget.g.a(r1, r3, r5)
            r5 = 0
            r7 = r3[r5]
            int r7 = com.color.support.widget.g.c(r7)
            r8 = r3[r2]
            com.color.support.widget.ColorLunarDatePicker$a r9 = r0.o
            java.lang.String r9 = a((com.color.support.widget.ColorLunarDatePicker.a) r9)
            if (r7 != 0) goto L_0x0030
        L_0x002d:
            int r8 = r8 + -1
            goto L_0x0040
        L_0x0030:
            if (r8 >= r7) goto L_0x0035
            if (r7 == 0) goto L_0x0035
            goto L_0x002d
        L_0x0035:
            if (r8 != r7) goto L_0x0040
            java.lang.String r10 = c
            boolean r10 = r9.contains(r10)
            if (r10 != 0) goto L_0x0040
            goto L_0x002d
        L_0x0040:
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != r10) goto L_0x004b
            r11 = 3
            r11 = r3[r11]
            if (r11 != 0) goto L_0x004b
            int r8 = r8 + 12
        L_0x004b:
            r11 = 13
            r12 = 24
            r13 = 12
            if (r1 != r10) goto L_0x0056
            r0.m = r12
            goto L_0x005e
        L_0x0056:
            if (r7 == 0) goto L_0x005c
            r0.m = r11
            r14 = r2
            goto L_0x005f
        L_0x005c:
            r0.m = r13
        L_0x005e:
            r14 = r5
        L_0x005f:
            r15 = r3[r5]
            r6 = r3[r2]
            int r6 = com.color.support.widget.g.a(r15, r6)
            if (r7 == 0) goto L_0x0079
            if (r8 != r7) goto L_0x0079
            java.lang.String r15 = c
            boolean r9 = r9.contains(r15)
            if (r9 == 0) goto L_0x0079
            r6 = r3[r5]
            int r6 = com.color.support.widget.g.b(r6)
        L_0x0079:
            com.color.support.widget.ColorLunarDatePicker$a r9 = r0.o
            java.util.Calendar r15 = d
            boolean r9 = r9.c(r15)
            r15 = 0
            if (r9 == 0) goto L_0x00b2
            com.color.support.widget.ColorNumberPicker r9 = r0.g
            r9.setDisplayedValues(r15)
            com.color.support.widget.ColorNumberPicker r9 = r0.g
            r11 = r3[r4]
            r9.setMinValue(r11)
            com.color.support.widget.ColorNumberPicker r9 = r0.g
            r9.setMaxValue(r6)
            com.color.support.widget.ColorNumberPicker r6 = r0.g
            r6.setWrapSelectorWheel(r5)
            com.color.support.widget.ColorNumberPicker r6 = r0.h
            r6.setDisplayedValues(r15)
            com.color.support.widget.ColorNumberPicker r6 = r0.h
            r6.setMinValue(r8)
            com.color.support.widget.ColorNumberPicker r6 = r0.h
            int r9 = r0.m
            int r9 = r9 - r2
            r6.setMaxValue(r9)
            com.color.support.widget.ColorNumberPicker r6 = r0.h
            r6.setWrapSelectorWheel(r5)
            goto L_0x0112
        L_0x00b2:
            com.color.support.widget.ColorLunarDatePicker$a r9 = r0.o
            java.util.Calendar r11 = e
            boolean r9 = r9.e(r11)
            if (r9 == 0) goto L_0x00e7
            com.color.support.widget.ColorNumberPicker r6 = r0.g
            r6.setDisplayedValues(r15)
            com.color.support.widget.ColorNumberPicker r6 = r0.g
            r6.setMinValue(r2)
            com.color.support.widget.ColorNumberPicker r6 = r0.g
            r9 = r3[r4]
            r6.setMaxValue(r9)
            com.color.support.widget.ColorNumberPicker r6 = r0.g
            r6.setWrapSelectorWheel(r5)
            com.color.support.widget.ColorNumberPicker r6 = r0.h
            r6.setDisplayedValues(r15)
            com.color.support.widget.ColorNumberPicker r6 = r0.h
            r6.setMinValue(r5)
            com.color.support.widget.ColorNumberPicker r6 = r0.h
            r6.setMaxValue(r8)
            com.color.support.widget.ColorNumberPicker r6 = r0.h
            r6.setWrapSelectorWheel(r5)
            goto L_0x0112
        L_0x00e7:
            com.color.support.widget.ColorNumberPicker r9 = r0.g
            r9.setDisplayedValues(r15)
            com.color.support.widget.ColorNumberPicker r9 = r0.g
            r9.setMinValue(r2)
            com.color.support.widget.ColorNumberPicker r9 = r0.g
            r9.setMaxValue(r6)
            com.color.support.widget.ColorNumberPicker r6 = r0.g
            r6.setWrapSelectorWheel(r2)
            com.color.support.widget.ColorNumberPicker r6 = r0.h
            r6.setDisplayedValues(r15)
            com.color.support.widget.ColorNumberPicker r6 = r0.h
            r6.setMinValue(r5)
            com.color.support.widget.ColorNumberPicker r6 = r0.h
            int r9 = r0.m
            int r9 = r9 - r2
            r6.setMaxValue(r9)
            com.color.support.widget.ColorNumberPicker r6 = r0.h
            r6.setWrapSelectorWheel(r2)
        L_0x0112:
            int r6 = r0.m
            java.lang.String[] r9 = new java.lang.String[r6]
            java.lang.String[] r6 = new java.lang.String[r6]
            if (r1 != r10) goto L_0x0142
            r1 = r5
        L_0x011b:
            if (r1 >= r12) goto L_0x01a4
            if (r1 >= r13) goto L_0x0126
            java.lang.String[] r6 = r0.l
            r6 = r6[r1]
            r9[r1] = r6
            goto L_0x013f
        L_0x0126:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = c
            r6.append(r7)
            java.lang.String[] r7 = r0.l
            int r10 = r1 + -12
            r7 = r7[r10]
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r9[r1] = r6
        L_0x013f:
            int r1 = r1 + 1
            goto L_0x011b
        L_0x0142:
            if (r14 == 0) goto L_0x018e
            r1 = r5
        L_0x0145:
            if (r1 >= r7) goto L_0x0150
            java.lang.String[] r9 = r0.l
            r9 = r9[r1]
            r6[r1] = r9
            int r1 = r1 + 1
            goto L_0x0145
        L_0x0150:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = c
            r9.append(r10)
            java.lang.String[] r10 = r0.l
            int r11 = r7 + -1
            r10 = r10[r11]
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r6[r7] = r9
            int r1 = r1 + r2
            r7 = 13
        L_0x016c:
            if (r1 >= r7) goto L_0x0179
            java.lang.String[] r9 = r0.l
            int r10 = r1 + -1
            r9 = r9[r10]
            r6[r1] = r9
            int r1 = r1 + 1
            goto L_0x016c
        L_0x0179:
            com.color.support.widget.ColorNumberPicker r1 = r0.h
            int r1 = r1.getMinValue()
            com.color.support.widget.ColorNumberPicker r7 = r0.h
            int r7 = r7.getMaxValue()
            int r7 = r7 + r2
            java.lang.Object[] r1 = java.util.Arrays.copyOfRange(r6, r1, r7)
            r9 = r1
            java.lang.String[] r9 = (java.lang.String[]) r9
            goto L_0x01a4
        L_0x018e:
            java.lang.String[] r1 = r0.l
            com.color.support.widget.ColorNumberPicker r6 = r0.h
            int r6 = r6.getMinValue()
            com.color.support.widget.ColorNumberPicker r7 = r0.h
            int r7 = r7.getMaxValue()
            int r7 = r7 + r2
            java.lang.Object[] r1 = java.util.Arrays.copyOfRange(r1, r6, r7)
            r9 = r1
            java.lang.String[] r9 = (java.lang.String[]) r9
        L_0x01a4:
            com.color.support.widget.ColorNumberPicker r1 = r0.h
            r1.setDisplayedValues(r9)
            com.color.support.widget.ColorNumberPicker r1 = r0.g
            int r1 = r1.getMaxValue()
            com.color.support.widget.ColorNumberPicker r6 = r0.g
            int r6 = r6.getMinValue()
            int r7 = r1 - r6
            int r7 = r7 + r2
            java.lang.String[] r7 = new java.lang.String[r7]
            r9 = r6
        L_0x01bb:
            if (r9 > r1) goto L_0x01c8
            int r10 = r9 - r6
            java.lang.String r11 = com.color.support.widget.g.d(r9)
            r7[r10] = r11
            int r9 = r9 + 1
            goto L_0x01bb
        L_0x01c8:
            com.color.support.widget.ColorNumberPicker r1 = r0.g
            r1.setDisplayedValues(r7)
            java.util.Calendar r1 = d
            int r1 = r1.get(r2)
            java.util.Calendar r6 = d
            int r6 = r6.get(r4)
            int r6 = r6 + r2
            java.util.Calendar r7 = d
            r9 = 5
            int r7 = r7.get(r9)
            int[] r1 = com.color.support.widget.g.a(r1, r6, r7)
            java.util.Calendar r6 = e
            int r6 = r6.get(r2)
            java.util.Calendar r7 = e
            int r7 = r7.get(r4)
            int r7 = r7 + r2
            int[] r6 = com.color.support.widget.g.a(r6, r7, r7)
            com.color.support.widget.ColorNumberPicker r7 = r0.i
            r1 = r1[r5]
            r7.setMinValue(r1)
            com.color.support.widget.ColorNumberPicker r1 = r0.i
            r6 = r6[r5]
            r1.setMaxValue(r6)
            com.color.support.widget.ColorNumberPicker r1 = r0.i
            r1.setWrapSelectorWheel(r2)
            com.color.support.widget.ColorNumberPicker r1 = r0.i
            r2 = r3[r5]
            r1.setValue(r2)
            com.color.support.widget.ColorNumberPicker r1 = r0.h
            r1.setValue(r8)
            com.color.support.widget.ColorNumberPicker r1 = r0.g
            r2 = r3[r4]
            r1.setValue(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.widget.ColorLunarDatePicker.b():void");
    }

    public int getYear() {
        return this.o.a(1);
    }

    public int getMonth() {
        return this.o.a(2);
    }

    public int getDayOfMonth() {
        return this.o.a(5);
    }

    /* access modifiers changed from: private */
    public void d() {
        sendAccessibilityEvent(4);
        b bVar = this.k;
        if (bVar != null) {
            bVar.a(this, getYear(), getMonth(), getDayOfMonth());
        }
    }

    public int[] getLunarDate() {
        return g.a(this.o.a(1), this.o.a(2) + 1, this.o.a(5));
    }

    public int getLeapMonth() {
        return g.c(this.o.a(1));
    }

    public b getOnDateChangedListener() {
        return this.k;
    }

    public void setOnDateChangedListener(b bVar) {
        this.k = bVar;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private Calendar f2073a;

        /* renamed from: b  reason: collision with root package name */
        private int f2074b;
        private int c;
        private int d;
        private int e;
        private int f;
        /* access modifiers changed from: private */
        public boolean g;

        a() {
            a(Calendar.getInstance());
        }

        a(Locale locale) {
            a(Calendar.getInstance(locale));
        }

        /* access modifiers changed from: package-private */
        public void a(Calendar calendar) {
            this.f2073a = calendar;
            this.g = false;
        }

        public void a(a aVar) {
            this.f2073a.setTimeInMillis(aVar.f2073a.getTimeInMillis());
            this.f2074b = aVar.f2074b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.f = aVar.f;
            this.g = aVar.g;
        }

        /* access modifiers changed from: package-private */
        public long a() {
            return this.f2073a.getTimeInMillis();
        }

        /* access modifiers changed from: package-private */
        public void a(long j) {
            this.f2073a.setTimeInMillis(j);
            this.g = false;
        }

        /* access modifiers changed from: package-private */
        public int a(int i) {
            if (!this.g) {
                return this.f2073a.get(i);
            }
            if (i == 5) {
                return this.d;
            }
            if (i == 2) {
                return this.c;
            }
            if (i == 1) {
                return this.f2074b;
            }
            return this.f2073a.get(i);
        }

        /* access modifiers changed from: package-private */
        public void a(int i, int i2, int i3) {
            if (i != Integer.MIN_VALUE) {
                this.f2073a.set(1, i);
                this.f2073a.set(2, i2);
                this.f2073a.set(5, i3);
                this.g = false;
                return;
            }
            this.f2074b = Integer.MIN_VALUE;
            this.c = i2;
            this.d = i3;
            this.g = true;
        }

        /* access modifiers changed from: package-private */
        public boolean b(Calendar calendar) {
            if (!this.g) {
                return this.f2073a.before(calendar);
            }
            return false;
        }

        public boolean c(Calendar calendar) {
            if (this.g) {
                return false;
            }
            if (this.f2073a.before(calendar) || this.f2073a.equals(calendar)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean d(Calendar calendar) {
            if (!this.g) {
                return this.f2073a.after(calendar);
            }
            return false;
        }

        public boolean e(Calendar calendar) {
            if (this.g) {
                return false;
            }
            if (this.f2073a.after(calendar) || this.f2073a.equals(calendar)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void a(Calendar calendar, Calendar calendar2) {
            if (this.g) {
                return;
            }
            if (this.f2073a.before(calendar)) {
                a(calendar.getTimeInMillis());
            } else if (this.f2073a.after(calendar2)) {
                a(calendar2.getTimeInMillis());
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x006e  */
        /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(int r7, int r8, int r9) {
            /*
                r6 = this;
                r0 = 1
                int r1 = r6.a((int) r0)
                r2 = 2
                int r3 = r6.a((int) r2)
                int r3 = r3 + r0
                r4 = 5
                int r5 = r6.a((int) r4)
                int[] r1 = com.color.support.widget.g.a(r1, r3, r5)
                if (r7 != r4) goto L_0x0040
                boolean r7 = r6.g
                if (r7 != 0) goto L_0x003c
                r7 = 27
                if (r8 <= r7) goto L_0x0028
                if (r9 != r0) goto L_0x0028
                java.util.Calendar r7 = r6.f2073a
                int r0 = r0 - r8
                r7.add(r4, r0)
                goto L_0x00fc
            L_0x0028:
                if (r8 != r0) goto L_0x0034
                if (r9 <= r7) goto L_0x0034
                java.util.Calendar r7 = r6.f2073a
                int r9 = r9 - r0
                r7.add(r4, r9)
                goto L_0x00fc
            L_0x0034:
                java.util.Calendar r7 = r6.f2073a
                int r9 = r9 - r8
                r7.add(r4, r9)
                goto L_0x00fc
            L_0x003c:
                r6.d = r9
                goto L_0x00fc
            L_0x0040:
                r8 = 0
                if (r7 != r2) goto L_0x007b
                boolean r7 = r6.g
                if (r7 != 0) goto L_0x0077
                int r9 = r9 + r0
                r7 = r1[r8]
                int r7 = com.color.support.widget.g.c(r7)
                if (r7 != 0) goto L_0x0052
            L_0x0050:
                r0 = r8
                goto L_0x005e
            L_0x0052:
                if (r9 > r7) goto L_0x0055
                goto L_0x0050
            L_0x0055:
                int r3 = r7 + 1
                if (r9 != r3) goto L_0x005b
                r9 = r7
                goto L_0x005e
            L_0x005b:
                int r9 = r9 + -1
                goto L_0x0050
            L_0x005e:
                r7 = r1[r8]
                r2 = r1[r2]
                int r7 = com.color.support.widget.g.b(r7, r9, r2, r0)
                r8 = r1[r8]
                java.util.Date r7 = com.color.support.widget.g.a((int) r8, (int) r9, (int) r7, (boolean) r0)
                if (r7 == 0) goto L_0x00fc
                long r7 = r7.getTime()
                r6.a((long) r7)
                goto L_0x00fc
            L_0x0077:
                r6.c = r9
                goto L_0x00fc
            L_0x007b:
                if (r7 != r0) goto L_0x00fc
                boolean r7 = r6.g
                r3 = 3
                r4 = -2147483648(0xffffffff80000000, float:-0.0)
                if (r7 != 0) goto L_0x0094
                if (r9 == r4) goto L_0x0094
                r7 = r1[r0]
                r8 = r1[r2]
                r0 = r1[r3]
                com.color.support.widget.ColorLunarDatePicker$a r7 = com.color.support.widget.g.a((int) r9, (int) r7, (int) r8, (int) r0)
                r6.a((com.color.support.widget.ColorLunarDatePicker.a) r7)
                goto L_0x00fc
            L_0x0094:
                boolean r7 = r6.g
                r5 = 12
                if (r7 != 0) goto L_0x00c3
                if (r9 != r4) goto L_0x00c3
                r6.g = r0
                r6.f2074b = r9
                r7 = r1[r0]
                int r7 = r7 - r0
                r9 = r1[r3]
                if (r9 != r0) goto L_0x00a8
                goto L_0x00a9
            L_0x00a8:
                r8 = r5
            L_0x00a9:
                int r7 = r7 + r8
                r6.c = r7
                r7 = r1[r2]
                r6.d = r7
                java.util.Calendar r7 = r6.f2073a
                r8 = 11
                int r7 = r7.get(r8)
                r6.e = r7
                java.util.Calendar r7 = r6.f2073a
                int r7 = r7.get(r5)
                r6.f = r7
                goto L_0x00fc
            L_0x00c3:
                boolean r7 = r6.g
                if (r7 == 0) goto L_0x00fa
                if (r9 == r4) goto L_0x00fa
                r6.g = r8
                r6.f2074b = r9
                int r7 = r6.c
                int r9 = r7 % 12
                int r9 = r9 + r0
                int r7 = r7 / r5
                if (r7 <= 0) goto L_0x00de
                int r7 = r6.f2074b
                int r7 = com.color.support.widget.g.c(r7)
                if (r7 != r9) goto L_0x00de
                r8 = r0
            L_0x00de:
                int r7 = r6.f2074b
                int r0 = r6.d
                int r7 = com.color.support.widget.g.b(r7, r9, r0, r8)
                r6.d = r7
                int r7 = r6.f2074b
                int r0 = r6.d
                java.util.Date r7 = com.color.support.widget.g.a((int) r7, (int) r9, (int) r0, (boolean) r8)
                if (r7 == 0) goto L_0x00fc
                long r7 = r7.getTime()
                r6.a((long) r7)
                goto L_0x00fc
            L_0x00fa:
                r6.f2074b = r9
            L_0x00fc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.color.support.widget.ColorLunarDatePicker.a.b(int, int, int):void");
        }
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (AnonymousClass1) null);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        /* access modifiers changed from: private */
        public final int mDay;
        /* access modifiers changed from: private */
        public final int mMonth;
        /* access modifiers changed from: private */
        public final int mYear;

        /* synthetic */ SavedState(Parcel parcel, AnonymousClass1 r2) {
            this(parcel);
        }

        /* synthetic */ SavedState(Parcelable parcelable, int i, int i2, int i3, AnonymousClass1 r5) {
            this(parcelable, i, i2, i3);
        }

        private SavedState(Parcelable parcelable, int i, int i2, int i3) {
            super(parcelable);
            this.mYear = i;
            this.mMonth = i2;
            this.mDay = i3;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mYear = parcel.readInt();
            this.mMonth = parcel.readInt();
            this.mDay = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mYear);
            parcel.writeInt(this.mMonth);
            parcel.writeInt(this.mDay);
        }
    }
}
