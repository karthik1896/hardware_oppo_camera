package com.oppo.camera.ui;

import com.oppo.camera.e;
import com.oppo.camera.ui.menu.a;
import com.oppo.camera.ui.menu.d;
import java.util.ArrayList;

/* compiled from: CameraUITool */
public class h {
    public static int a(String str, ArrayList<d> arrayList) {
        if (str == null || arrayList == null) {
            return -1;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (a((Object) str, (Object) arrayList.get(i).b())) {
                return i;
            }
        }
        return -1;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean b(String str, ArrayList<d> arrayList) {
        if (!(str == null || arrayList == null)) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (a((Object) str, (Object) arrayList.get(i).b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(a aVar) {
        if (aVar == null) {
            e.a("CameraUITool", "checkCameraMenuOptionInfo, mCameraMenuOptionInfo is null.");
            return false;
        } else if (aVar.getOptionKey() == null || aVar.getOptionKey().equals("")) {
            e.a("CameraUITool", "checkCameraMenuOptionInfo, mCameraMenuOptionInfo.mOptionKey is null.");
            return false;
        } else if (aVar.getOptionItems() == null || aVar.getOptionItems().size() <= 0) {
            e.a("CameraUITool", "checkCameraMenuOptionInfo, mCameraMenuOptionInfo has no items.");
            return false;
        } else if (aVar.getOptionTitle() != null && !aVar.getOptionTitle().equals("")) {
            return true;
        } else {
            e.a("CameraUITool", "checkCameraMenuOptionInfo, mCameraMenuOptionInfo.mOptionTitle is null.");
            return true;
        }
    }
}
