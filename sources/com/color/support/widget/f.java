package com.color.support.widget;

import com.color.support.widget.ColorLockPatternView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ColorLockPatternUtils */
public class f {
    public static List<ColorLockPatternView.Cell> a(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            byte b2 = (byte) (bytes[i] - 49);
            arrayList.add(ColorLockPatternView.Cell.a(b2 / 3, b2 % 3));
        }
        return arrayList;
    }

    public static String a(List<ColorLockPatternView.Cell> list) {
        if (list == null) {
            return "";
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            ColorLockPatternView.Cell cell = list.get(i);
            bArr[i] = (byte) ((cell.getRow() * 3) + cell.getColumn() + 49);
        }
        return new String(bArr);
    }
}
