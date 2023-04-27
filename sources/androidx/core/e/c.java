package androidx.core.e;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.concurrent.Executor;

/* compiled from: PrecomputedTextCompat */
public class c implements Spannable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f659a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Executor f660b = null;
    private final Spannable c;
    private final a d;
    private final PrecomputedText e;

    /* compiled from: PrecomputedTextCompat */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final PrecomputedText.Params f661a;

        /* renamed from: b  reason: collision with root package name */
        private final TextPaint f662b;
        private final TextDirectionHeuristic c;
        private final int d;
        private final int e;

        /* renamed from: androidx.core.e.c$a$a  reason: collision with other inner class name */
        /* compiled from: PrecomputedTextCompat */
        public static class C0017a {

            /* renamed from: a  reason: collision with root package name */
            private final TextPaint f663a;

            /* renamed from: b  reason: collision with root package name */
            private TextDirectionHeuristic f664b;
            private int c;
            private int d;

            public C0017a(TextPaint textPaint) {
                this.f663a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.c = 1;
                    this.d = 1;
                } else {
                    this.d = 0;
                    this.c = 0;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f664b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f664b = null;
                }
            }

            public C0017a a(int i) {
                this.c = i;
                return this;
            }

            public C0017a b(int i) {
                this.d = i;
                return this;
            }

            public C0017a a(TextDirectionHeuristic textDirectionHeuristic) {
                this.f664b = textDirectionHeuristic;
                return this;
            }

            public a a() {
                return new a(this.f663a, this.f664b, this.c, this.d);
            }
        }

        @SuppressLint({"NewApi"})
        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f661a = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f661a = null;
            }
            this.f662b = textPaint;
            this.c = textDirectionHeuristic;
            this.d = i;
            this.e = i2;
        }

        public a(PrecomputedText.Params params) {
            this.f662b = params.getTextPaint();
            this.c = params.getTextDirection();
            this.d = params.getBreakStrategy();
            this.e = params.getHyphenationFrequency();
            this.f661a = Build.VERSION.SDK_INT < 29 ? null : params;
        }

        public TextPaint a() {
            return this.f662b;
        }

        public TextDirectionHeuristic b() {
            return this.c;
        }

        public int c() {
            return this.d;
        }

        public int d() {
            return this.e;
        }

        public boolean a(a aVar) {
            if ((Build.VERSION.SDK_INT >= 23 && (this.d != aVar.c() || this.e != aVar.d())) || this.f662b.getTextSize() != aVar.a().getTextSize() || this.f662b.getTextScaleX() != aVar.a().getTextScaleX() || this.f662b.getTextSkewX() != aVar.a().getTextSkewX()) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 21 && (this.f662b.getLetterSpacing() != aVar.a().getLetterSpacing() || !TextUtils.equals(this.f662b.getFontFeatureSettings(), aVar.a().getFontFeatureSettings()))) || this.f662b.getFlags() != aVar.a().getFlags()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if (!this.f662b.getTextLocales().equals(aVar.a().getTextLocales())) {
                    return false;
                }
            } else if (Build.VERSION.SDK_INT >= 17 && !this.f662b.getTextLocale().equals(aVar.a().getTextLocale())) {
                return false;
            }
            if (this.f662b.getTypeface() == null) {
                if (aVar.a().getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.f662b.getTypeface().equals(aVar.a().getTypeface())) {
                return false;
            } else {
                return true;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!a(aVar)) {
                return false;
            }
            return Build.VERSION.SDK_INT < 18 || this.c == aVar.b();
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return androidx.core.f.c.a(Float.valueOf(this.f662b.getTextSize()), Float.valueOf(this.f662b.getTextScaleX()), Float.valueOf(this.f662b.getTextSkewX()), Float.valueOf(this.f662b.getLetterSpacing()), Integer.valueOf(this.f662b.getFlags()), this.f662b.getTextLocales(), this.f662b.getTypeface(), Boolean.valueOf(this.f662b.isElegantTextHeight()), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e));
            } else if (Build.VERSION.SDK_INT >= 21) {
                return androidx.core.f.c.a(Float.valueOf(this.f662b.getTextSize()), Float.valueOf(this.f662b.getTextScaleX()), Float.valueOf(this.f662b.getTextSkewX()), Float.valueOf(this.f662b.getLetterSpacing()), Integer.valueOf(this.f662b.getFlags()), this.f662b.getTextLocale(), this.f662b.getTypeface(), Boolean.valueOf(this.f662b.isElegantTextHeight()), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e));
            } else if (Build.VERSION.SDK_INT >= 18) {
                return androidx.core.f.c.a(Float.valueOf(this.f662b.getTextSize()), Float.valueOf(this.f662b.getTextScaleX()), Float.valueOf(this.f662b.getTextSkewX()), Integer.valueOf(this.f662b.getFlags()), this.f662b.getTextLocale(), this.f662b.getTypeface(), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e));
            } else if (Build.VERSION.SDK_INT >= 17) {
                return androidx.core.f.c.a(Float.valueOf(this.f662b.getTextSize()), Float.valueOf(this.f662b.getTextScaleX()), Float.valueOf(this.f662b.getTextSkewX()), Integer.valueOf(this.f662b.getFlags()), this.f662b.getTextLocale(), this.f662b.getTypeface(), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e));
            } else {
                return androidx.core.f.c.a(Float.valueOf(this.f662b.getTextSize()), Float.valueOf(this.f662b.getTextScaleX()), Float.valueOf(this.f662b.getTextSkewX()), Integer.valueOf(this.f662b.getFlags()), this.f662b.getTypeface(), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e));
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f662b.getTextSize());
            sb.append(", textScaleX=" + this.f662b.getTextScaleX());
            sb.append(", textSkewX=" + this.f662b.getTextSkewX());
            if (Build.VERSION.SDK_INT >= 21) {
                sb.append(", letterSpacing=" + this.f662b.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f662b.isElegantTextHeight());
            }
            if (Build.VERSION.SDK_INT >= 24) {
                sb.append(", textLocale=" + this.f662b.getTextLocales());
            } else if (Build.VERSION.SDK_INT >= 17) {
                sb.append(", textLocale=" + this.f662b.getTextLocale());
            }
            sb.append(", typeface=" + this.f662b.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
                sb.append(", variationSettings=" + this.f662b.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.c);
            sb.append(", breakStrategy=" + this.d);
            sb.append(", hyphenationFrequency=" + this.e);
            sb.append("}");
            return sb.toString();
        }
    }

    public PrecomputedText a() {
        Spannable spannable = this.c;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    public a b() {
        return this.d;
    }

    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.e.setSpan(obj, i, i2, i3);
        } else {
            this.c.setSpan(obj, i, i2, i3);
        }
    }

    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.e.removeSpan(obj);
        } else {
            this.c.removeSpan(obj);
        }
    }

    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.e.getSpans(i, i2, cls);
        }
        return this.c.getSpans(i, i2, cls);
    }

    public int getSpanStart(Object obj) {
        return this.c.getSpanStart(obj);
    }

    public int getSpanEnd(Object obj) {
        return this.c.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.c.getSpanFlags(obj);
    }

    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.c.nextSpanTransition(i, i2, cls);
    }

    public int length() {
        return this.c.length();
    }

    public char charAt(int i) {
        return this.c.charAt(i);
    }

    public CharSequence subSequence(int i, int i2) {
        return this.c.subSequence(i, i2);
    }

    public String toString() {
        return this.c.toString();
    }
}
