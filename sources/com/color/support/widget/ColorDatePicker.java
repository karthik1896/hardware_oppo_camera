package com.color.support.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.CalendarView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.color.support.widget.ColorNumberPicker;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;

public class ColorDatePicker extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2020a = "ColorDatePicker";

    /* renamed from: b  reason: collision with root package name */
    private static char[] f2021b = {'d', 'M', 'y'};
    private final LinearLayout c;
    /* access modifiers changed from: private */
    public final ColorNumberPicker d;
    /* access modifiers changed from: private */
    public final ColorNumberPicker e;
    /* access modifiers changed from: private */
    public final ColorNumberPicker f;
    private Context g;
    /* access modifiers changed from: private */
    public Locale h;
    private c i;
    /* access modifiers changed from: private */
    public String[] j;
    private int k;
    /* access modifiers changed from: private */
    public b l;
    private Calendar m;
    private Calendar n;
    /* access modifiers changed from: private */
    public b o;
    private boolean p;
    private a q;
    private a r;
    private a s;
    private int t;
    private int u;

    public interface c {
        void a(ColorDatePicker colorDatePicker, int i, int i2, int i3);
    }

    /* access modifiers changed from: private */
    public void e() {
    }

    public CalendarView getCalendarView() {
        return null;
    }

    public boolean getCalendarViewShown() {
        return false;
    }

    public void setCalendarViewShown(boolean z) {
    }

    /* renamed from: com.color.support.widget.ColorDatePicker$1  reason: invalid class name */
    class AnonymousClass1 implements ColorNumberPicker.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ColorDatePicker f2022a;

        public void a(ColorNumberPicker colorNumberPicker, int i, int i2) {
            this.f2022a.l.a(this.f2022a.o);
            if (colorNumberPicker == this.f2022a.d) {
                this.f2022a.l.a(5, i2);
            } else if (colorNumberPicker == this.f2022a.e) {
                this.f2022a.l.a(2, i2);
            } else if (colorNumberPicker == this.f2022a.f) {
                this.f2022a.l.a(1, i2);
            } else {
                throw new IllegalArgumentException();
            }
            ColorDatePicker colorDatePicker = this.f2022a;
            colorDatePicker.setDate(colorDatePicker.l);
            this.f2022a.d();
            this.f2022a.e();
            this.f2022a.f();
        }
    }

    private String a() {
        if (!this.o.f2026b) {
            return DateUtils.formatDateTime(this.g, this.o.f2025a.getTimeInMillis(), 20);
        }
        return DateUtils.formatDateTime(this.g, this.o.f2025a.getTimeInMillis(), 24);
    }

    public long getMinDate() {
        return this.m.getTimeInMillis();
    }

    public void setMinDate(long j2) {
        this.l.a(j2);
        if (this.l.a(1) != this.m.get(1) || this.l.a(6) == this.m.get(6)) {
            this.m.setTimeInMillis(j2);
            if (this.o.a(this.m)) {
                this.o.a(this.m.getTimeInMillis());
                e();
            }
            d();
        }
    }

    public long getMaxDate() {
        return this.n.getTimeInMillis();
    }

    public void setMaxDate(long j2) {
        this.l.a(j2);
        if (this.l.a(1) != this.n.get(1) || this.l.a(6) == this.n.get(6)) {
            this.n.setTimeInMillis(j2);
            if (this.o.b(this.n)) {
                this.o.a(this.n.getTimeInMillis());
                e();
            }
            d();
        }
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackground(int i2) {
        setBackgroundDrawable(getContext().getResources().getDrawable(i2));
    }

    public void setNormalColor(int i2) {
        this.t = i2;
        b();
    }

    public void setFocusColor(int i2) {
        this.u = i2;
        b();
    }

    private void b() {
        int i2 = this.t;
        if (i2 != -1) {
            this.d.setPickerNormalColor(i2);
            this.e.setPickerNormalColor(this.t);
            this.f.setPickerNormalColor(this.t);
        }
        int i3 = this.u;
        if (i3 != -1) {
            this.d.setPickerFocusColor(i3);
            this.e.setPickerFocusColor(this.u);
            this.f.setPickerFocusColor(this.u);
        }
    }

    public boolean isEnabled() {
        return this.p;
    }

    public void setEnabled(boolean z) {
        if (this.p != z) {
            super.setEnabled(z);
            this.d.setEnabled(z);
            this.e.setEnabled(z);
            this.f.setEnabled(z);
            this.p = z;
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.getText().add(a());
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    public boolean getSpinnersShown() {
        return this.c.isShown();
    }

    public void setSpinnersShown(boolean z) {
        this.c.setVisibility(z ? 0 : 8);
    }

    private void setCurrentLocale(Locale locale) {
        if (!locale.equals(this.h)) {
            this.h = locale;
            this.l = a(this.l, locale);
            this.m = a(this.m, locale);
            this.n = a(this.n, locale);
            this.o = a(this.o, locale);
            this.k = this.l.c(2) + 1;
            this.j = new String[this.k];
        }
    }

    private b a(b bVar, Locale locale) {
        if (bVar == null) {
            return new b(locale);
        }
        b bVar2 = new b(locale);
        if (!bVar.f2026b) {
            bVar2.a(bVar.a());
        } else {
            bVar2.a(bVar);
        }
        return bVar2;
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
        d();
        e();
    }

    private void a(int i2, int i3, int i4) {
        this.o.a(i2, i3, i4);
        c();
    }

    /* access modifiers changed from: private */
    public void setDate(b bVar) {
        this.o.a(bVar);
        c();
    }

    private void c() {
        this.o.a(this.m, this.n);
    }

    /* access modifiers changed from: private */
    public void d() {
        this.e.setFormatter(this.r);
        boolean z = false;
        if (this.o.a(1) == this.m.get(1) && this.o.a(1) != this.n.get(1)) {
            this.e.setMinValue(this.m.get(2));
            this.e.setMaxValue(this.m.getActualMaximum(2));
            this.e.setWrapSelectorWheel(this.m.get(2) == 0);
        } else if (this.o.a(1) != this.m.get(1) && this.o.a(1) == this.n.get(1)) {
            this.e.setMinValue(0);
            this.e.setMaxValue(this.n.get(2));
            this.e.setWrapSelectorWheel(this.n.get(2) == this.n.getActualMaximum(2));
        } else if (this.o.a(1) == this.m.get(1) && this.o.a(1) == this.n.get(1)) {
            this.e.setMinValue(this.m.get(2));
            this.e.setMaxValue(this.n.get(2));
            this.e.setWrapSelectorWheel(this.n.get(2) == this.n.getActualMaximum(2) && this.m.get(2) == 0);
        } else {
            this.e.setMinValue(this.o.b(2));
            this.e.setMaxValue(this.o.c(2));
            this.e.setWrapSelectorWheel(true);
        }
        if (this.o.a(1) == this.m.get(1) && this.o.a(2) == this.m.get(2) && (this.o.a(1) != this.n.get(1) || this.o.a(2) != this.n.get(2))) {
            this.d.setMinValue(this.m.get(5));
            this.d.setMaxValue(this.m.getActualMaximum(5));
            ColorNumberPicker colorNumberPicker = this.d;
            if (this.m.get(5) == 1) {
                z = true;
            }
            colorNumberPicker.setWrapSelectorWheel(z);
        } else if (!(this.o.a(1) == this.m.get(1) && this.o.a(2) == this.m.get(2)) && this.o.a(1) == this.n.get(1) && this.o.a(2) == this.n.get(2)) {
            this.d.setMinValue(1);
            this.d.setMaxValue(this.n.get(5));
            ColorNumberPicker colorNumberPicker2 = this.d;
            if (this.n.get(5) == this.n.getActualMaximum(5)) {
                z = true;
            }
            colorNumberPicker2.setWrapSelectorWheel(z);
        } else if (this.o.a(1) == this.m.get(1) && this.o.a(2) == this.m.get(2) && this.o.a(1) == this.n.get(1) && this.o.a(2) == this.n.get(2)) {
            this.d.setMinValue(this.m.get(5));
            this.d.setMaxValue(this.n.get(5));
            ColorNumberPicker colorNumberPicker3 = this.d;
            if (this.n.get(5) == this.n.getActualMaximum(5) && this.m.get(5) == 1) {
                z = true;
            }
            colorNumberPicker3.setWrapSelectorWheel(z);
        } else {
            this.d.setMinValue(this.o.b(5));
            this.d.setMaxValue(this.o.c(5));
            this.d.setWrapSelectorWheel(true);
        }
        String[] strArr = (String[]) Arrays.copyOfRange(this.j, this.e.getMinValue(), this.e.getMaxValue() + 1);
        this.f.setMinValue(this.m.get(1));
        this.f.setMaxValue(this.n.get(1));
        this.f.setWrapSelectorWheel(true);
        this.f.setFormatter(this.q);
        this.f.setValue(this.o.a(1));
        this.e.setValue(this.o.a(2));
        this.d.setValue(this.o.a(5));
        this.d.setFormatter(this.s);
        if (this.d.getValue() > 27) {
            this.d.invalidate();
        }
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
    public void f() {
        sendAccessibilityEvent(4);
        c cVar = this.i;
        if (cVar != null) {
            cVar.a(this, getYear(), getMonth(), getDayOfMonth());
        }
    }

    public c getOnDateChangedListener() {
        return this.i;
    }

    public void setOnDateChangedListener(c cVar) {
        this.i = cVar;
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

    private static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Calendar f2025a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f2026b;

        public b(Locale locale) {
            this.f2025a = Calendar.getInstance(locale);
        }

        public void a(b bVar) {
            this.f2025a.setTimeInMillis(bVar.f2025a.getTimeInMillis());
            this.f2026b = bVar.f2026b;
        }

        public long a() {
            return this.f2025a.getTimeInMillis();
        }

        public void a(long j) {
            this.f2025a.setTimeInMillis(j);
            this.f2026b = false;
        }

        public int a(int i) {
            if (!this.f2026b) {
                return this.f2025a.get(i);
            }
            if (i == 5) {
                return this.f2025a.get(i);
            }
            if (i == 2) {
                return this.f2025a.get(i);
            }
            if (i == 1) {
                return Integer.MIN_VALUE;
            }
            return this.f2025a.get(i);
        }

        public void a(int i, int i2) {
            if (i == 1) {
                if (i2 != Integer.MIN_VALUE) {
                    this.f2026b = false;
                    int i3 = this.f2025a.get(2);
                    int i4 = this.f2025a.get(5);
                    this.f2025a.clear();
                    this.f2025a.set(1, i2);
                    this.f2025a.set(2, i3);
                    this.f2025a.set(5, d(i4));
                    return;
                }
                this.f2026b = true;
                int i5 = this.f2025a.get(2);
                int i6 = this.f2025a.get(5);
                this.f2025a.clear();
                this.f2025a.set(i, 2020);
                this.f2025a.set(2, i5);
                this.f2025a.set(5, d(i6));
            } else if (i == 2) {
                int i7 = this.f2025a.get(1);
                int i8 = this.f2025a.get(5);
                this.f2025a.clear();
                this.f2025a.set(1, i7);
                this.f2025a.set(2, i2);
                this.f2025a.set(5, d(i8));
            } else if (i == 5) {
                this.f2025a.set(5, d(i2));
            }
        }

        public void a(int i, int i2, int i3) {
            a(1, i);
            a(2, i2);
            a(5, i3);
        }

        public boolean a(Calendar calendar) {
            if (!this.f2026b) {
                return this.f2025a.before(calendar);
            }
            return false;
        }

        public boolean b(Calendar calendar) {
            if (!this.f2026b) {
                return this.f2025a.after(calendar);
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public int b(int i) {
            return this.f2025a.getActualMinimum(i);
        }

        /* access modifiers changed from: package-private */
        public int c(int i) {
            return this.f2025a.getActualMaximum(i);
        }

        /* access modifiers changed from: package-private */
        public void a(Calendar calendar, Calendar calendar2) {
            if (this.f2026b) {
                return;
            }
            if (this.f2025a.before(calendar)) {
                a(1, calendar.get(1));
                a(2, calendar.get(2));
                a(5, calendar.get(5));
            } else if (this.f2025a.after(calendar2)) {
                a(1, calendar2.get(1));
                a(2, calendar2.get(2));
                a(5, calendar2.get(5));
            }
        }

        /* access modifiers changed from: package-private */
        public int d(int i) {
            int actualMaximum = this.f2025a.getActualMaximum(5);
            return i > actualMaximum ? actualMaximum : i;
        }
    }

    class a implements ColorNumberPicker.c {

        /* renamed from: a  reason: collision with root package name */
        int f2023a;

        /* renamed from: b  reason: collision with root package name */
        String f2024b;
        final /* synthetic */ ColorDatePicker c;

        public String a(int i) {
            if (this.f2024b.equals("MONTH")) {
                return this.c.j[i];
            }
            if (!Locale.getDefault().getLanguage().equals("zh")) {
                Formatter formatter = new Formatter(new StringBuilder(), this.c.h);
                if (this.f2024b.equals("YEAR")) {
                    formatter.format("%d", new Object[]{Integer.valueOf(i)});
                    return formatter.toString();
                } else if (this.f2024b.equals("DAY")) {
                    formatter.format("%02d", new Object[]{Integer.valueOf(i)});
                    return formatter.toString();
                }
            }
            return i + this.c.getResources().getString(this.f2023a);
        }
    }
}
