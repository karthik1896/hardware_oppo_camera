package com.oppo.camera.ui.menu;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CameraMenuOptionInfo */
public class a {
    public static final int GROUP_TYPE_IMAGE_MENU = 3;
    public static final int GROUP_TYPE_MENU_EXPANDABLE = 2;
    public static final int GROUP_TYPE_NOMAL = 0;
    public static final int GROUP_TYPE_SHARE_RESOURCE = 1;
    private int mDrawerType;
    private int mGroupType;
    private boolean mImageTitleColorChangeable;
    private boolean mImageTitleMode;
    private Bitmap mOffAnimationIcon;
    private Bitmap mOnAnimationIcon;
    private String mOptionDefaultValue;
    private Drawable mOptionExpandIcon;
    private ArrayList<d> mOptionItems;
    private String mOptionKey;
    private Bitmap mOptionSingleIcon;
    private String mOptionTitle;
    private boolean mbOptionOnOff;
    private boolean mbSwitchIconNeedAnim;

    public a() {
        this.mOptionKey = null;
        this.mOptionTitle = null;
        this.mOptionDefaultValue = null;
        this.mOptionItems = null;
        this.mbOptionOnOff = false;
        this.mOptionSingleIcon = null;
        this.mOptionExpandIcon = null;
        this.mOffAnimationIcon = null;
        this.mOnAnimationIcon = null;
        this.mbSwitchIconNeedAnim = false;
        this.mGroupType = 0;
        this.mImageTitleMode = false;
        this.mImageTitleColorChangeable = false;
        this.mDrawerType = 0;
        this.mOptionKey = null;
        this.mOptionTitle = null;
        this.mOptionDefaultValue = null;
        this.mOptionItems = null;
        this.mbOptionOnOff = false;
        this.mDrawerType = -1;
    }

    public int getOptionType() {
        return this.mDrawerType;
    }

    public void setOptionType(int i) {
        this.mDrawerType = i;
    }

    public String getOptionKey() {
        return this.mOptionKey;
    }

    public void setOptionKey(String str) {
        this.mOptionKey = str;
    }

    public String getOptionTitle() {
        return this.mOptionTitle;
    }

    public void setOptionTitle(String str) {
        this.mOptionTitle = str;
    }

    public String getOptionDefaultValue() {
        return this.mOptionDefaultValue;
    }

    public void setOptionDefaultValue(String str) {
        this.mOptionDefaultValue = str;
    }

    public boolean getOptionOnOff() {
        return this.mbOptionOnOff;
    }

    public void setGroupType(int i) {
        this.mGroupType = i;
    }

    public int getGroupType() {
        return this.mGroupType;
    }

    public void setOptionOnOff(boolean z) {
        this.mbOptionOnOff = z;
    }

    public void setImageTitleMode(boolean z) {
        this.mImageTitleMode = z;
    }

    public void setImageTitleColorChangeable(boolean z) {
        this.mImageTitleColorChangeable = z;
    }

    public boolean getImageTitleMode() {
        return this.mImageTitleMode;
    }

    public boolean getImageTitleColorChangeable() {
        return this.mImageTitleColorChangeable;
    }

    public Bitmap getOptionSingleIcon() {
        return this.mOptionSingleIcon;
    }

    public void setOptionSingleIcon(Bitmap bitmap) {
        this.mOptionSingleIcon = bitmap;
    }

    public Drawable getOptionExpandIcon() {
        return this.mOptionExpandIcon;
    }

    public void setOptionExpandIcon(Drawable drawable) {
        this.mOptionExpandIcon = drawable;
    }

    public ArrayList<d> getOptionItems() {
        return this.mOptionItems;
    }

    public void setOptionItems(ArrayList<d> arrayList) {
        this.mOptionItems = arrayList;
    }

    public Bitmap getOnAnimationIcon() {
        return this.mOnAnimationIcon;
    }

    public void setOpenAnimationIcon(Bitmap bitmap) {
        this.mOnAnimationIcon = bitmap;
    }

    public void setSwitchIconNeedAnim(boolean z) {
        this.mbSwitchIconNeedAnim = z;
    }

    public boolean getSwitchIconNeedAnim() {
        return this.mbSwitchIconNeedAnim;
    }

    public Bitmap getOffAnimationIcon() {
        return this.mOffAnimationIcon;
    }

    public void setCloseAnimationIcon(Bitmap bitmap) {
        this.mOffAnimationIcon = bitmap;
    }

    public void release() {
        ArrayList<d> arrayList = this.mOptionItems;
        if (arrayList != null) {
            Iterator<d> it = arrayList.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next != null) {
                    next.e();
                }
            }
            this.mOptionItems.clear();
            this.mOptionItems = null;
        }
        Bitmap bitmap = this.mOptionSingleIcon;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mOptionSingleIcon.recycle();
            this.mOptionSingleIcon = null;
        }
        this.mOptionDefaultValue = null;
        this.mOptionKey = null;
        this.mOptionTitle = null;
    }
}
