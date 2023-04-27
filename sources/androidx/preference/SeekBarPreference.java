package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.Preference;

public class SeekBarPreference extends Preference {

    /* renamed from: a  reason: collision with root package name */
    int f986a;

    /* renamed from: b  reason: collision with root package name */
    int f987b;
    boolean c;
    SeekBar d;
    boolean e;
    boolean f;
    private int g;
    private int h;
    private TextView i;
    private boolean j;
    private SeekBar.OnSeekBarChangeListener k;
    private View.OnKeyListener l;

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.k = new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (!z || (!SeekBarPreference.this.f && SeekBarPreference.this.c)) {
                    SeekBarPreference seekBarPreference = SeekBarPreference.this;
                    seekBarPreference.k(i + seekBarPreference.f987b);
                    return;
                }
                SeekBarPreference.this.a(seekBar);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                SeekBarPreference.this.c = true;
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                SeekBarPreference.this.c = false;
                if (seekBar.getProgress() + SeekBarPreference.this.f987b != SeekBarPreference.this.f986a) {
                    SeekBarPreference.this.a(seekBar);
                }
            }
        };
        this.l = new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                if ((!SeekBarPreference.this.e && (i == 21 || i == 22)) || i == 23 || i == 66) {
                    return false;
                }
                if (SeekBarPreference.this.d != null) {
                    return SeekBarPreference.this.d.onKeyDown(i, keyEvent);
                }
                Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
                return false;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SeekBarPreference, i2, i3);
        this.f987b = obtainStyledAttributes.getInt(R.styleable.SeekBarPreference_min, 0);
        i(obtainStyledAttributes.getInt(R.styleable.SeekBarPreference_android_max, 100));
        h(obtainStyledAttributes.getInt(R.styleable.SeekBarPreference_seekBarIncrement, 0));
        this.e = obtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_adjustable, true);
        this.j = obtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_showSeekBarValue, false);
        this.f = obtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_updatesContinuously, false);
        obtainStyledAttributes.recycle();
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarPreferenceStyle);
    }

    public void a(l lVar) {
        super.a(lVar);
        lVar.itemView.setOnKeyListener(this.l);
        this.d = (SeekBar) lVar.a(R.id.seekbar);
        this.i = (TextView) lVar.a(R.id.seekbar_value);
        if (this.j) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
            this.i = null;
        }
        SeekBar seekBar = this.d;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.k);
        this.d.setMax(this.g - this.f987b);
        int i2 = this.h;
        if (i2 != 0) {
            this.d.setKeyProgressIncrement(i2);
        } else {
            this.h = this.d.getKeyProgressIncrement();
        }
        this.d.setProgress(this.f986a - this.f987b);
        k(this.f986a);
        this.d.setEnabled(y());
    }

    /* access modifiers changed from: protected */
    public void a(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        j(g(((Integer) obj).intValue()));
    }

    /* access modifiers changed from: protected */
    public Object a(TypedArray typedArray, int i2) {
        return Integer.valueOf(typedArray.getInt(i2, 0));
    }

    public final void h(int i2) {
        if (i2 != this.h) {
            this.h = Math.min(this.g - this.f987b, Math.abs(i2));
            i();
        }
    }

    public final void i(int i2) {
        int i3 = this.f987b;
        if (i2 < i3) {
            i2 = i3;
        }
        if (i2 != this.g) {
            this.g = i2;
            i();
        }
    }

    private void a(int i2, boolean z) {
        int i3 = this.f987b;
        if (i2 < i3) {
            i2 = i3;
        }
        int i4 = this.g;
        if (i2 > i4) {
            i2 = i4;
        }
        if (i2 != this.f986a) {
            this.f986a = i2;
            k(this.f986a);
            f(i2);
            if (z) {
                i();
            }
        }
    }

    public void j(int i2) {
        a(i2, true);
    }

    /* access modifiers changed from: package-private */
    public void a(SeekBar seekBar) {
        int progress = this.f987b + seekBar.getProgress();
        if (progress == this.f986a) {
            return;
        }
        if (b((Object) Integer.valueOf(progress))) {
            a(progress, false);
            return;
        }
        seekBar.setProgress(this.f986a - this.f987b);
        k(this.f986a);
    }

    /* access modifiers changed from: package-private */
    public void k(int i2) {
        TextView textView = this.i;
        if (textView != null) {
            textView.setText(String.valueOf(i2));
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable k() {
        Parcelable k2 = super.k();
        if (D()) {
            return k2;
        }
        SavedState savedState = new SavedState(k2);
        savedState.mSeekBarValue = this.f986a;
        savedState.mMin = this.f987b;
        savedState.mMax = this.g;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void a(Parcelable parcelable) {
        if (!parcelable.getClass().equals(SavedState.class)) {
            super.a(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.a(savedState.getSuperState());
        this.f986a = savedState.mSeekBarValue;
        this.f987b = savedState.mMin;
        this.g = savedState.mMax;
        i();
    }

    private static class SavedState extends Preference.BaseSavedState {
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
        int mMax;
        int mMin;
        int mSeekBarValue;

        SavedState(Parcel parcel) {
            super(parcel);
            this.mSeekBarValue = parcel.readInt();
            this.mMin = parcel.readInt();
            this.mMax = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mSeekBarValue);
            parcel.writeInt(this.mMin);
            parcel.writeInt(this.mMax);
        }
    }
}
