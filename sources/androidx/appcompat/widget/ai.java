package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ResourcesWrapper */
class ai extends Resources {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f397a;

    public ai(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f397a = resources;
    }

    public CharSequence getText(int i) throws Resources.NotFoundException {
        return this.f397a.getText(i);
    }

    public CharSequence getQuantityText(int i, int i2) throws Resources.NotFoundException {
        return this.f397a.getQuantityText(i, i2);
    }

    public String getString(int i) throws Resources.NotFoundException {
        return this.f397a.getString(i);
    }

    public String getString(int i, Object... objArr) throws Resources.NotFoundException {
        return this.f397a.getString(i, objArr);
    }

    public String getQuantityString(int i, int i2, Object... objArr) throws Resources.NotFoundException {
        return this.f397a.getQuantityString(i, i2, objArr);
    }

    public String getQuantityString(int i, int i2) throws Resources.NotFoundException {
        return this.f397a.getQuantityString(i, i2);
    }

    public CharSequence getText(int i, CharSequence charSequence) {
        return this.f397a.getText(i, charSequence);
    }

    public CharSequence[] getTextArray(int i) throws Resources.NotFoundException {
        return this.f397a.getTextArray(i);
    }

    public String[] getStringArray(int i) throws Resources.NotFoundException {
        return this.f397a.getStringArray(i);
    }

    public int[] getIntArray(int i) throws Resources.NotFoundException {
        return this.f397a.getIntArray(i);
    }

    public TypedArray obtainTypedArray(int i) throws Resources.NotFoundException {
        return this.f397a.obtainTypedArray(i);
    }

    public float getDimension(int i) throws Resources.NotFoundException {
        return this.f397a.getDimension(i);
    }

    public int getDimensionPixelOffset(int i) throws Resources.NotFoundException {
        return this.f397a.getDimensionPixelOffset(i);
    }

    public int getDimensionPixelSize(int i) throws Resources.NotFoundException {
        return this.f397a.getDimensionPixelSize(i);
    }

    public float getFraction(int i, int i2, int i3) {
        return this.f397a.getFraction(i, i2, i3);
    }

    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        return this.f397a.getDrawable(i);
    }

    public Drawable getDrawable(int i, Resources.Theme theme) throws Resources.NotFoundException {
        return this.f397a.getDrawable(i, theme);
    }

    public Drawable getDrawableForDensity(int i, int i2) throws Resources.NotFoundException {
        return this.f397a.getDrawableForDensity(i, i2);
    }

    public Drawable getDrawableForDensity(int i, int i2, Resources.Theme theme) {
        return this.f397a.getDrawableForDensity(i, i2, theme);
    }

    public Movie getMovie(int i) throws Resources.NotFoundException {
        return this.f397a.getMovie(i);
    }

    public int getColor(int i) throws Resources.NotFoundException {
        return this.f397a.getColor(i);
    }

    public ColorStateList getColorStateList(int i) throws Resources.NotFoundException {
        return this.f397a.getColorStateList(i);
    }

    public boolean getBoolean(int i) throws Resources.NotFoundException {
        return this.f397a.getBoolean(i);
    }

    public int getInteger(int i) throws Resources.NotFoundException {
        return this.f397a.getInteger(i);
    }

    public XmlResourceParser getLayout(int i) throws Resources.NotFoundException {
        return this.f397a.getLayout(i);
    }

    public XmlResourceParser getAnimation(int i) throws Resources.NotFoundException {
        return this.f397a.getAnimation(i);
    }

    public XmlResourceParser getXml(int i) throws Resources.NotFoundException {
        return this.f397a.getXml(i);
    }

    public InputStream openRawResource(int i) throws Resources.NotFoundException {
        return this.f397a.openRawResource(i);
    }

    public InputStream openRawResource(int i, TypedValue typedValue) throws Resources.NotFoundException {
        return this.f397a.openRawResource(i, typedValue);
    }

    public AssetFileDescriptor openRawResourceFd(int i) throws Resources.NotFoundException {
        return this.f397a.openRawResourceFd(i);
    }

    public void getValue(int i, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f397a.getValue(i, typedValue, z);
    }

    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f397a.getValueForDensity(i, i2, typedValue, z);
    }

    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f397a.getValue(str, typedValue, z);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f397a.obtainAttributes(attributeSet, iArr);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f397a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.f397a.getDisplayMetrics();
    }

    public Configuration getConfiguration() {
        return this.f397a.getConfiguration();
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.f397a.getIdentifier(str, str2, str3);
    }

    public String getResourceName(int i) throws Resources.NotFoundException {
        return this.f397a.getResourceName(i);
    }

    public String getResourcePackageName(int i) throws Resources.NotFoundException {
        return this.f397a.getResourcePackageName(i);
    }

    public String getResourceTypeName(int i) throws Resources.NotFoundException {
        return this.f397a.getResourceTypeName(i);
    }

    public String getResourceEntryName(int i) throws Resources.NotFoundException {
        return this.f397a.getResourceEntryName(i);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.f397a.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.f397a.parseBundleExtra(str, attributeSet, bundle);
    }
}
