package co.polarr.renderer.entities;

import com.oppo.camera.statistics.model.VideoRecordMsgData;

public class FontItem {
    public String fontFamily;
    public String src;
    public String style;
    public int weight;

    public FontItem(String str, int i, String str2) {
        this.fontFamily = str;
        this.weight = i;
        this.style = VideoRecordMsgData.END_TYPE_NORMAL;
        this.src = str2;
    }

    public FontItem(String str, int i, String str2, String str3) {
        this.fontFamily = str;
        this.weight = i;
        this.style = str2;
        this.src = str3;
    }

    public FontItem(String str, String str2) {
        this.fontFamily = str;
        this.weight = 600;
        this.style = VideoRecordMsgData.END_TYPE_NORMAL;
        this.src = str2;
    }

    public FontItem(String str, String str2, String str3) {
        this.fontFamily = str;
        this.weight = 600;
        this.style = str2;
        this.src = str3;
    }
}
