package com.oppo.camera.aps.update;

import android.text.TextUtils;
import androidx.annotation.Keep;

@Keep
public class ApsUpdateParam {
    private String mUpdateContent = null;
    private String mUpdateFilePath = null;

    public String getUpdateFilePath() {
        return this.mUpdateFilePath;
    }

    public void setUpdateFilePath(String str) {
        this.mUpdateFilePath = str;
    }

    public String getUpdateContent() {
        return this.mUpdateContent;
    }

    public void setUpdateContent(String str) {
        this.mUpdateContent = str;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.mUpdateFilePath) && !TextUtils.isEmpty(this.mUpdateContent);
    }

    public String toString() {
        return "ApsUpdateParam{mUpdateFilePath: '" + this.mUpdateFilePath + '\'' + ", mUpdateContent: '" + this.mUpdateContent + '\'' + '}';
    }
}
