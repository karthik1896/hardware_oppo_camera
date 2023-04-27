package com.color.support.widget.floatingbutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class ColorFloatingButtonItem implements Parcelable {
    public static final Parcelable.Creator<ColorFloatingButtonItem> CREATOR = new Parcelable.Creator<ColorFloatingButtonItem>() {
        /* renamed from: a */
        public ColorFloatingButtonItem createFromParcel(Parcel parcel) {
            return new ColorFloatingButtonItem(parcel);
        }

        /* renamed from: a */
        public ColorFloatingButtonItem[] newArray(int i) {
            return new ColorFloatingButtonItem[i];
        }
    };
    public static final int RESOURCE_NOT_SET = Integer.MIN_VALUE;
    /* access modifiers changed from: private */
    public boolean mColorFloatingButtonExpandEnable;
    /* access modifiers changed from: private */
    public final int mColorFloatingButtonItemLocation;
    /* access modifiers changed from: private */
    public ColorStateList mFabBackgroundColor;
    /* access modifiers changed from: private */
    public final Drawable mFabImageDrawable;
    /* access modifiers changed from: private */
    public final int mFabImageResource;
    /* access modifiers changed from: private */
    public final String mLabel;
    /* access modifiers changed from: private */
    public ColorStateList mLabelBackgroundColor;
    /* access modifiers changed from: private */
    public ColorStateList mLabelColor;
    /* access modifiers changed from: private */
    public final int mLabelRes;

    public int describeContents() {
        return 0;
    }

    private ColorFloatingButtonItem(a aVar) {
        this.mFabBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mLabelColor = ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mLabelBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mColorFloatingButtonExpandEnable = true;
        this.mLabel = aVar.d;
        this.mLabelRes = aVar.e;
        this.mFabImageResource = aVar.f2190b;
        this.mFabImageDrawable = aVar.c;
        this.mFabBackgroundColor = aVar.f;
        this.mLabelColor = aVar.g;
        this.mLabelBackgroundColor = aVar.h;
        this.mColorFloatingButtonExpandEnable = aVar.i;
        this.mColorFloatingButtonItemLocation = aVar.f2189a;
    }

    public int getColorFloatingButtonItemLocation() {
        return this.mColorFloatingButtonItemLocation;
    }

    public String getLabel(Context context) {
        String str = this.mLabel;
        if (str != null) {
            return str;
        }
        int i = this.mLabelRes;
        if (i != Integer.MIN_VALUE) {
            return context.getString(i);
        }
        return null;
    }

    public Drawable getFabImageDrawable(Context context) {
        Drawable drawable = this.mFabImageDrawable;
        if (drawable != null) {
            return drawable;
        }
        int i = this.mFabImageResource;
        if (i != Integer.MIN_VALUE) {
            return androidx.appcompat.a.a.a.b(context, i);
        }
        return null;
    }

    public ColorStateList getFabBackgroundColor() {
        return this.mFabBackgroundColor;
    }

    public ColorStateList getLabelColor() {
        return this.mLabelColor;
    }

    public ColorStateList getLabelBackgroundColor() {
        return this.mLabelBackgroundColor;
    }

    public boolean isColorFloatingButtonExpandEnable() {
        return this.mColorFloatingButtonExpandEnable;
    }

    public a createFabWithLabelView(Context context) {
        a aVar = new a(context);
        aVar.setColorFloatingButtonItem(this);
        return aVar;
    }

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f2189a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f2190b;
        /* access modifiers changed from: private */
        public Drawable c;
        /* access modifiers changed from: private */
        public String d;
        /* access modifiers changed from: private */
        public int e = Integer.MIN_VALUE;
        /* access modifiers changed from: private */
        public ColorStateList f = ColorStateList.valueOf(Integer.MIN_VALUE);
        /* access modifiers changed from: private */
        public ColorStateList g = ColorStateList.valueOf(Integer.MIN_VALUE);
        /* access modifiers changed from: private */
        public ColorStateList h = ColorStateList.valueOf(Integer.MIN_VALUE);
        /* access modifiers changed from: private */
        public boolean i = true;

        public a(int i2, int i3) {
            this.f2189a = i2;
            this.f2190b = i3;
            this.c = null;
        }

        public a(ColorFloatingButtonItem colorFloatingButtonItem) {
            this.d = colorFloatingButtonItem.mLabel;
            this.e = colorFloatingButtonItem.mLabelRes;
            this.f2190b = colorFloatingButtonItem.mFabImageResource;
            this.c = colorFloatingButtonItem.mFabImageDrawable;
            this.f = colorFloatingButtonItem.mFabBackgroundColor;
            this.g = colorFloatingButtonItem.mLabelColor;
            this.h = colorFloatingButtonItem.mLabelBackgroundColor;
            this.i = colorFloatingButtonItem.mColorFloatingButtonExpandEnable;
            this.f2189a = colorFloatingButtonItem.mColorFloatingButtonItemLocation;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a a(ColorStateList colorStateList) {
            this.f = colorStateList;
            return this;
        }

        public a b(ColorStateList colorStateList) {
            this.g = colorStateList;
            return this;
        }

        public a c(ColorStateList colorStateList) {
            this.h = colorStateList;
            return this;
        }

        public ColorFloatingButtonItem a() {
            return new ColorFloatingButtonItem(this);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mLabel);
        parcel.writeInt(this.mLabelRes);
        parcel.writeInt(this.mFabImageResource);
        parcel.writeInt(this.mColorFloatingButtonItemLocation);
    }

    protected ColorFloatingButtonItem(Parcel parcel) {
        this.mFabBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mLabelColor = ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mLabelBackgroundColor = ColorStateList.valueOf(Integer.MIN_VALUE);
        this.mColorFloatingButtonExpandEnable = true;
        this.mLabel = parcel.readString();
        this.mLabelRes = parcel.readInt();
        this.mFabImageResource = parcel.readInt();
        this.mFabImageDrawable = null;
        this.mColorFloatingButtonItemLocation = parcel.readInt();
    }
}
