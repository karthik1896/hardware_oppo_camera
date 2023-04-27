package com.oppo.camera.ui.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.oppo.camera.R;

public class PreferenceMenuOptionInfo extends a {
    private static final String TAG = "PreferenceMenuOptionInfo";

    public PreferenceMenuOptionInfo(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CameraMenuOptionInfo, 0, 0);
        initMenuOptionInfo(context, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    /* JADX WARNING: Removed duplicated region for block: B:85:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x019e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initMenuOptionInfo(android.content.Context r13, android.content.res.TypedArray r14) {
        /*
            r12 = this;
            if (r14 == 0) goto L_0x01a2
            r0 = 3
            r1 = -1
            int r0 = r14.getInt(r0, r1)
            r12.setOptionType(r0)
            r0 = 9
            java.lang.String r0 = r14.getString(r0)
            r12.setOptionKey(r0)
            r0 = 15
            java.lang.String r0 = r14.getString(r0)
            r12.setOptionTitle(r0)
            r0 = 2
            java.lang.String r0 = r14.getString(r0)
            r12.setOptionDefaultValue(r0)
            r0 = 10
            r2 = 0
            boolean r0 = r14.getBoolean(r0, r2)
            r12.setOptionOnOff(r0)
            r0 = 8
            boolean r0 = r14.getBoolean(r0, r2)
            r12.setImageTitleMode(r0)
            r0 = 7
            boolean r0 = r14.getBoolean(r0, r2)
            r12.setImageTitleColorChangeable(r0)
            r0 = 14
            boolean r0 = r14.getBoolean(r0, r2)
            r12.setSwitchIconNeedAnim(r0)
            r0 = 5
            java.lang.String r0 = r14.getString(r0)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x005b
            int r0 = java.lang.Integer.parseInt(r0)
            r12.setGroupType(r0)
        L_0x005b:
            r0 = 1
            int r3 = r14.getResourceId(r0, r2)
            r4 = 17
            int r4 = r14.getResourceId(r4, r2)
            r5 = 16
            int r5 = r14.getResourceId(r5, r2)
            r6 = 6
            int r6 = r14.getResourceId(r6, r2)
            r7 = 13
            int r7 = r14.getResourceId(r7, r2)
            r8 = 4
            int r8 = r14.getResourceId(r8, r2)
            r9 = 11
            int r9 = r14.getResourceId(r9, r2)
            int r14 = r14.getResourceId(r2, r2)
            r10 = 0
            if (r3 == 0) goto L_0x0098
            android.content.res.Resources r11 = r13.getResources()     // Catch:{ all -> 0x0092 }
            android.content.res.TypedArray r3 = r11.obtainTypedArray(r3)     // Catch:{ all -> 0x0092 }
            goto L_0x0099
        L_0x0092:
            r13 = move-exception
            r3 = r10
            r4 = r3
        L_0x0095:
            r5 = r4
            goto L_0x018d
        L_0x0098:
            r3 = r10
        L_0x0099:
            if (r4 == 0) goto L_0x00a7
            android.content.res.Resources r11 = r13.getResources()     // Catch:{ all -> 0x00a4 }
            android.content.res.TypedArray r4 = r11.obtainTypedArray(r4)     // Catch:{ all -> 0x00a4 }
            goto L_0x00a8
        L_0x00a4:
            r13 = move-exception
            r4 = r10
            goto L_0x0095
        L_0x00a7:
            r4 = r10
        L_0x00a8:
            if (r5 == 0) goto L_0x00b7
            android.content.res.Resources r11 = r13.getResources()     // Catch:{ all -> 0x00b3 }
            android.content.res.TypedArray r5 = r11.obtainTypedArray(r5)     // Catch:{ all -> 0x00b3 }
            goto L_0x00b8
        L_0x00b3:
            r13 = move-exception
            r5 = r10
            goto L_0x018d
        L_0x00b7:
            r5 = r10
        L_0x00b8:
            if (r6 == 0) goto L_0x00c6
            android.content.res.Resources r11 = r13.getResources()     // Catch:{ all -> 0x00c3 }
            android.content.res.TypedArray r10 = r11.obtainTypedArray(r6)     // Catch:{ all -> 0x00c3 }
            goto L_0x00c6
        L_0x00c3:
            r13 = move-exception
            goto L_0x018d
        L_0x00c6:
            if (r7 == 0) goto L_0x00cf
            android.graphics.Bitmap r6 = com.oppo.camera.util.Util.a((android.content.Context) r13, (int) r7)     // Catch:{ all -> 0x00c3 }
            r12.setOptionSingleIcon(r6)     // Catch:{ all -> 0x00c3 }
        L_0x00cf:
            if (r8 == 0) goto L_0x00d8
            android.graphics.drawable.Drawable r6 = r13.getDrawable(r8)     // Catch:{ all -> 0x00c3 }
            r12.setOptionExpandIcon(r6)     // Catch:{ all -> 0x00c3 }
        L_0x00d8:
            if (r9 == 0) goto L_0x00e5
            android.content.res.Resources r6 = r13.getResources()     // Catch:{ all -> 0x00c3 }
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeResource(r6, r9)     // Catch:{ all -> 0x00c3 }
            r12.setOpenAnimationIcon(r6)     // Catch:{ all -> 0x00c3 }
        L_0x00e5:
            if (r14 == 0) goto L_0x00ee
            android.graphics.Bitmap r14 = com.oppo.camera.util.Util.a((android.content.Context) r13, (int) r14)     // Catch:{ all -> 0x00c3 }
            r12.setCloseAnimationIcon(r14)     // Catch:{ all -> 0x00c3 }
        L_0x00ee:
            boolean r14 = r12.checkTypedArray(r4)     // Catch:{ all -> 0x00c3 }
            java.lang.String r6 = "PreferenceMenuOptionInfo"
            if (r14 != 0) goto L_0x0110
            java.lang.String r13 = "initMenuOptionInfo, give preference value info Error."
            com.oppo.camera.e.a(r6, r13)     // Catch:{ all -> 0x00c3 }
            if (r3 == 0) goto L_0x0100
            r3.recycle()
        L_0x0100:
            if (r4 == 0) goto L_0x0105
            r4.recycle()
        L_0x0105:
            if (r5 == 0) goto L_0x010a
            r5.recycle()
        L_0x010a:
            if (r10 == 0) goto L_0x010f
            r10.recycle()
        L_0x010f:
            return
        L_0x0110:
            boolean r14 = r12.checkTypedArray(r5)     // Catch:{ all -> 0x00c3 }
            if (r14 != 0) goto L_0x0130
            java.lang.String r13 = "initMenuOptionInfo, give preference value name info Error."
            com.oppo.camera.e.a(r6, r13)     // Catch:{ all -> 0x00c3 }
            if (r3 == 0) goto L_0x0120
            r3.recycle()
        L_0x0120:
            if (r4 == 0) goto L_0x0125
            r4.recycle()
        L_0x0125:
            if (r5 == 0) goto L_0x012a
            r5.recycle()
        L_0x012a:
            if (r10 == 0) goto L_0x012f
            r10.recycle()
        L_0x012f:
            return
        L_0x0130:
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x00c3 }
            r14.<init>()     // Catch:{ all -> 0x00c3 }
        L_0x0135:
            int r6 = r4.length()     // Catch:{ all -> 0x00c3 }
            if (r2 >= r6) goto L_0x0175
            com.oppo.camera.ui.menu.d r6 = new com.oppo.camera.ui.menu.d     // Catch:{ all -> 0x00c3 }
            r6.<init>()     // Catch:{ all -> 0x00c3 }
            java.lang.String r7 = r4.getString(r2)     // Catch:{ all -> 0x00c3 }
            r6.a((java.lang.String) r7)     // Catch:{ all -> 0x00c3 }
            java.lang.String r7 = r5.getString(r2)     // Catch:{ all -> 0x00c3 }
            r6.c(r7)     // Catch:{ all -> 0x00c3 }
            boolean r7 = r12.checkTypedArray(r3)     // Catch:{ all -> 0x00c3 }
            if (r7 == 0) goto L_0x015b
            java.lang.String r7 = r3.getString(r2)     // Catch:{ all -> 0x00c3 }
            r6.b(r7)     // Catch:{ all -> 0x00c3 }
        L_0x015b:
            if (r10 == 0) goto L_0x016f
            int r7 = r10.length()     // Catch:{ all -> 0x00c3 }
            int r7 = r7 - r0
            if (r2 > r7) goto L_0x016f
            int r7 = r10.getResourceId(r2, r1)     // Catch:{ all -> 0x00c3 }
            android.graphics.drawable.Drawable r7 = r13.getDrawable(r7)     // Catch:{ all -> 0x00c3 }
            r6.a((android.graphics.drawable.Drawable) r7)     // Catch:{ all -> 0x00c3 }
        L_0x016f:
            r14.add(r6)     // Catch:{ all -> 0x00c3 }
            int r2 = r2 + 1
            goto L_0x0135
        L_0x0175:
            r12.setOptionItems(r14)     // Catch:{ all -> 0x00c3 }
            if (r3 == 0) goto L_0x017d
            r3.recycle()
        L_0x017d:
            if (r4 == 0) goto L_0x0182
            r4.recycle()
        L_0x0182:
            if (r5 == 0) goto L_0x0187
            r5.recycle()
        L_0x0187:
            if (r10 == 0) goto L_0x01a2
            r10.recycle()
            goto L_0x01a2
        L_0x018d:
            if (r3 == 0) goto L_0x0192
            r3.recycle()
        L_0x0192:
            if (r4 == 0) goto L_0x0197
            r4.recycle()
        L_0x0197:
            if (r5 == 0) goto L_0x019c
            r5.recycle()
        L_0x019c:
            if (r10 == 0) goto L_0x01a1
            r10.recycle()
        L_0x01a1:
            throw r13
        L_0x01a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.menu.PreferenceMenuOptionInfo.initMenuOptionInfo(android.content.Context, android.content.res.TypedArray):void");
    }

    private boolean checkTypedArray(TypedArray typedArray) {
        return typedArray != null && typedArray.length() > 0;
    }
}
