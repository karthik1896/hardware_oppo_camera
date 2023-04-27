package com.coloros.anim.d;

import com.coloros.anim.k;

/* compiled from: FileExtension */
public enum a {
    JSON(".json"),
    ZIP(".zip");
    
    public final String extension;

    private a(String str) {
        this.extension = str;
    }

    public static a forFile(String str) {
        for (a aVar : values()) {
            if (str.endsWith(aVar.extension)) {
                return aVar;
            }
        }
        k.b("Unable to find correct extension for " + str);
        return JSON;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    public String toString() {
        return this.extension;
    }
}
