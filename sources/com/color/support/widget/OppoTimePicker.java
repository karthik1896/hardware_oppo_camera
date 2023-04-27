package com.color.support.widget;

import android.content.res.Configuration;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;

public class OppoTimePicker extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f2141a = (!OppoTimePicker.class.desiredAssertionStatus());

    /* renamed from: b  reason: collision with root package name */
    private static final a f2142b = new a() {
        public void a(OppoTimePicker oppoTimePicker, int i, int i2) {
        }
    };
    private final ColorNumberPicker c;
    private final ColorNumberPicker d;
    private final ColorNumberPicker e;
    private final Button f;
    private final String[] g;
    private boolean h;
    private boolean i;
    private TextView j;
    private TextView k;
    private boolean l;
    private a m;
    private Calendar n;
    private Locale o;
    private ViewGroup p;

    public interface a {
        void a(OppoTimePicker oppoTimePicker, int i, int i2);
    }

    public void setTextVisibility(boolean z) {
        if (z) {
            this.j.setVisibility(0);
            this.k.setVisibility(0);
            return;
        }
        this.j.setVisibility(8);
        this.k.setVisibility(8);
    }

    public void setEnabled(boolean z) {
        if (this.l != z) {
            super.setEnabled(z);
            this.d.setEnabled(z);
            this.c.setEnabled(z);
            ColorNumberPicker colorNumberPicker = this.e;
            if (colorNumberPicker != null) {
                colorNumberPicker.setEnabled(z);
            } else {
                this.f.setEnabled(z);
            }
            this.l = z;
        }
    }

    public boolean isEnabled() {
        return this.l;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setCurrentLocale(configuration.locale);
    }

    private void setCurrentLocale(Locale locale) {
        if (!locale.equals(this.o)) {
            this.o = locale;
            this.n = Calendar.getInstance(locale);
        }
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private final int mHour;
        private final int mMinute;

        private SavedState(Parcelable parcelable, int i, int i2) {
            super(parcelable);
            this.mHour = i;
            this.mMinute = i2;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mHour = parcel.readInt();
            this.mMinute = parcel.readInt();
        }

        /* access modifiers changed from: package-private */
        public int getHour() {
            return this.mHour;
        }

        /* access modifiers changed from: package-private */
        public int getMinute() {
            return this.mMinute;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mHour);
            parcel.writeInt(this.mMinute);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getCurrentHour().intValue(), getCurrentMinute().intValue());
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentHour(Integer.valueOf(savedState.getHour()));
        setCurrentMinute(Integer.valueOf(savedState.getMinute()));
    }

    public void setOnTimeChangedListener(a aVar) {
        this.m = aVar;
    }

    public Integer getCurrentHour() {
        int value = this.c.getValue();
        if (a()) {
            return Integer.valueOf(value);
        }
        if (this.i) {
            return Integer.valueOf(value % 12);
        }
        return Integer.valueOf((value % 12) + 12);
    }

    public void setCurrentHour(Integer num) {
        if (num != null && num != getCurrentHour()) {
            if (!a()) {
                if (num.intValue() >= 12) {
                    this.i = false;
                    if (num.intValue() > 12) {
                        num = Integer.valueOf(num.intValue() - 12);
                    }
                } else {
                    this.i = true;
                    if (num.intValue() == 0) {
                        num = 12;
                    }
                }
                d();
            }
            this.c.setValue(num.intValue());
            f();
        }
    }

    public void setIs24HourView(Boolean bool) {
        if (this.h != bool.booleanValue()) {
            int intValue = getCurrentHour().intValue();
            this.h = bool.booleanValue();
            c();
            setCurrentHour(Integer.valueOf(intValue));
            d();
            this.c.requestLayout();
        }
    }

    public boolean a() {
        return this.h;
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(this.d.getValue());
    }

    public void setCurrentMinute(Integer num) {
        if (!num.equals(getCurrentMinute())) {
            this.d.setValue(num.intValue());
            f();
        }
    }

    public int getBaseline() {
        return this.c.getBaseline();
    }

    private void c() {
        if (a()) {
            this.c.setMinValue(0);
            this.c.setMaxValue(23);
            this.c.a();
        } else {
            this.c.setMinValue(1);
            this.c.setMaxValue(12);
        }
        this.c.setWrapSelectorWheel(true);
        this.d.setWrapSelectorWheel(true);
    }

    private void d() {
        if (a()) {
            ColorNumberPicker colorNumberPicker = this.e;
            if (colorNumberPicker != null) {
                colorNumberPicker.setVisibility(8);
                e();
            } else {
                this.f.setVisibility(8);
            }
        } else {
            int i2 = !this.i;
            ColorNumberPicker colorNumberPicker2 = this.e;
            if (colorNumberPicker2 != null) {
                colorNumberPicker2.setValue(i2);
                this.e.setVisibility(0);
                e();
            } else {
                this.f.setText(this.g[i2]);
                this.f.setVisibility(0);
            }
        }
        e();
    }

    public boolean b() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    private void e() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.p.getLayoutParams();
        if (a()) {
            if (!b()) {
                layoutParams.weight = 1.0f;
                layoutParams2.weight = 1.0f;
            }
            this.c.setLayoutParams(layoutParams);
            this.p.setLayoutParams(layoutParams2);
            return;
        }
        String bestDateTimePattern = DateFormat.getBestDateTimePattern(Locale.getDefault(), "hm");
        if (b()) {
            bestDateTimePattern = TextUtils.getReverse(bestDateTimePattern, 0, bestDateTimePattern.length()).toString();
        }
        if (!bestDateTimePattern.startsWith("a")) {
            layoutParams.weight = 1.0f;
            layoutParams2.weight = 0.0f;
        } else {
            layoutParams.weight = 0.0f;
            if (!b()) {
                layoutParams2.weight = 1.0f;
            }
        }
        this.c.setLayoutParams(layoutParams);
        this.p.setLayoutParams(layoutParams2);
    }

    private void f() {
        a aVar = this.m;
        if (aVar != null) {
            aVar.a(this, getCurrentHour().intValue(), getCurrentMinute().intValue());
        }
    }

    public void setRowNumber(int i2) {
        ColorNumberPicker colorNumberPicker;
        if (i2 > 0 && (colorNumberPicker = this.c) != null && this.d != null && this.e != null) {
            colorNumberPicker.setPickerRowNumber(i2);
            this.d.setPickerRowNumber(i2);
            this.e.setPickerRowNumber(i2);
        }
    }
}
