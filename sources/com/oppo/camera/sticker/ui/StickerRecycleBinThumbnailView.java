package com.oppo.camera.sticker.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;

public class StickerRecycleBinThumbnailView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private String f3685a;

    /* renamed from: b  reason: collision with root package name */
    private String f3686b;
    private Drawable c;
    private Drawable d;

    public StickerRecycleBinThumbnailView(Context context) {
        this(context, (AttributeSet) null);
    }

    public StickerRecycleBinThumbnailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StickerRecycleBinThumbnailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3685a = null;
        this.f3686b = null;
        this.c = null;
        this.d = null;
    }

    public void setNormalDrawableUri(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.f3685a)) {
            this.f3685a = str;
            Uri parse = Uri.parse(str);
            Drawable drawable = this.c;
            if (drawable != null) {
                drawable.setCallback((Drawable.Callback) null);
            }
            this.c = a(getContext(), parse);
            Drawable drawable2 = this.c;
            if (drawable2 != null) {
                a(drawable2, this.d);
            }
        }
    }

    public void setSelectedDrawableUri(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.f3686b)) {
            this.f3686b = str;
            Uri parse = Uri.parse(str);
            Drawable drawable = this.d;
            if (drawable != null) {
                drawable.setCallback((Drawable.Callback) null);
            }
            this.d = a(getContext(), parse);
            Drawable drawable2 = this.d;
            if (drawable2 != null) {
                a(this.c, drawable2);
            }
        }
    }

    private void a(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        setImageDrawable(stateListDrawable);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0032 A[SYNTHETIC, Splitter:B:25:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0048 A[SYNTHETIC, Splitter:B:32:0x0048] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable a(android.content.Context r3, android.net.Uri r4) {
        /*
            r2 = this;
            android.content.ContentResolver r0 = r3.getContentResolver()
            r1 = 0
            java.io.InputStream r4 = r0.openInputStream(r4)     // Catch:{ FileNotFoundException -> 0x002b, all -> 0x0028 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r4)     // Catch:{ FileNotFoundException -> 0x0026 }
            if (r0 == 0) goto L_0x001e
            android.graphics.drawable.BitmapDrawable r3 = com.oppo.camera.util.Util.a((android.content.Context) r3, (android.graphics.Bitmap) r0)     // Catch:{ FileNotFoundException -> 0x0026 }
            if (r4 == 0) goto L_0x001d
            r4.close()     // Catch:{ IOException -> 0x0019 }
            goto L_0x001d
        L_0x0019:
            r4 = move-exception
            r4.printStackTrace()
        L_0x001d:
            return r3
        L_0x001e:
            if (r4 == 0) goto L_0x003a
            r4.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0024:
            r3 = move-exception
            goto L_0x0046
        L_0x0026:
            r0 = move-exception
            goto L_0x002d
        L_0x0028:
            r3 = move-exception
            r4 = r1
            goto L_0x0046
        L_0x002b:
            r0 = move-exception
            r4 = r1
        L_0x002d:
            r0.printStackTrace()     // Catch:{ all -> 0x0024 }
            if (r4 == 0) goto L_0x003a
            r4.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r4 = move-exception
            r4.printStackTrace()
        L_0x003a:
            android.content.res.Resources r3 = r3.getResources()
            r4 = 2131231969(0x7f0804e1, float:1.8080034E38)
            android.graphics.drawable.Drawable r3 = r3.getDrawable(r4, r1)
            return r3
        L_0x0046:
            if (r4 == 0) goto L_0x0050
            r4.close()     // Catch:{ IOException -> 0x004c }
            goto L_0x0050
        L_0x004c:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0050:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.ui.StickerRecycleBinThumbnailView.a(android.content.Context, android.net.Uri):android.graphics.drawable.Drawable");
    }
}
