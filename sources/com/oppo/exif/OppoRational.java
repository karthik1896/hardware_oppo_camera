package com.oppo.exif;

public class OppoRational {
    private final long mDenominator;
    private final long mNumerator;

    public OppoRational(long j, long j2) {
        this.mNumerator = j;
        this.mDenominator = j2;
    }

    public OppoRational(OppoRational oppoRational) {
        this.mNumerator = oppoRational.mNumerator;
        this.mDenominator = oppoRational.mDenominator;
    }

    public long getNumerator() {
        return this.mNumerator;
    }

    public long getDenominator() {
        return this.mDenominator;
    }

    public double toDouble() {
        return ((double) this.mNumerator) / ((double) this.mDenominator);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OppoRational)) {
            return false;
        }
        OppoRational oppoRational = (OppoRational) obj;
        if (this.mNumerator == oppoRational.mNumerator && this.mDenominator == oppoRational.mDenominator) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        return this.mNumerator + "/" + this.mDenominator;
    }
}
