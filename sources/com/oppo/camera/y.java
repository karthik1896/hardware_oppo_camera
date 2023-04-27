package com.oppo.camera;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Size;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.c;
import com.oppo.camera.f.a;
import com.oppo.camera.o;
import com.oppo.camera.util.Util;
import java.util.HashSet;

/* compiled from: SloganUtil */
public class y extends c {
    private static Typeface S;
    private String T = null;
    private String U = null;
    private String V = "Shot on ";
    private String W = "Shot by ";
    private String X = "MP";
    private String Y = " AI ";
    private String Z = " Camera";
    private String aa = "";
    private String ab = "";
    private String ac = "";
    private String ad = "";
    private String ae = "";
    private boolean af = false;

    public y(Activity activity, k kVar, int i) {
        super(activity, kVar, i);
    }

    public void a(Size size, o.a aVar, HashSet<String> hashSet, boolean z, int i, int i2, int i3) {
        a(size, aVar, hashSet, z, i, i2 != 0, i3);
    }

    public void a(Size size, o.a aVar, HashSet<String> hashSet, boolean z, int i, boolean z2, int i2) {
        this.R.e = i2;
        super.a(size, aVar, hashSet, z, i, z2);
    }

    private float a(Size size) {
        float f;
        int i;
        if (size.getHeight() >= size.getWidth()) {
            f = ((float) size.getWidth()) * 1.0f;
            i = Util.E();
        } else {
            f = ((float) size.getHeight()) * 1.0f;
            i = Util.E();
        }
        return f / ((float) i);
    }

    private Typeface h() {
        Typeface typeface = S;
        if (typeface != null) {
            return typeface;
        }
        try {
            S = Typeface.createFromAsset(this.j.getAssets(), "fonts/RadomirTinkovGilroy-Medium.otf");
            e.a("BaseSloganUtil", "create RadomirTinkovGilroy-Medium.otf typeface successful");
        } catch (Exception unused) {
            S = Typeface.DEFAULT;
            e.e("BaseSloganUtil", "create RadomirTinkovGilroy-Medium.otf typeface fail");
        }
        return S;
    }

    private String b(int i) {
        this.aa = this.V + this.L;
        if (!a.c(i)) {
            int ak = Util.ak();
            e.b("BaseSloganUtil", "getSloganInfo, highPictureMP: " + ak);
            if (ak >= 48) {
                this.ac = ak + this.X;
            }
            if (this.af && ak == 108) {
                this.aa += " | " + ak + this.X;
            }
            int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_CUSTOM_CAMERA_REAR_NUM);
            e.b("BaseSloganUtil", "getSloganInfo, physicalBackCameraNum: " + configIntValue);
            if (configIntValue == -1 || configIntValue == 1) {
                this.ad = null;
            } else if (configIntValue == 2) {
                this.ad = this.m.getString(R.string.camera_watermark_back_camera_num_2);
            } else if (configIntValue == 3) {
                this.ad = this.m.getString(R.string.camera_watermark_back_camera_num_3);
            } else if (configIntValue != 4) {
                this.ad = this.m.getString(R.string.camera_watermark_back_camera_num_super);
            } else {
                this.ad = this.m.getString(R.string.camera_watermark_back_camera_num_4);
            }
            if (this.ad != null) {
                this.ae = (this.ac + this.Y + this.ad + this.Z).trim().toUpperCase();
            } else {
                this.ae = (this.ac + this.Y + this.Z.trim()).trim().toUpperCase();
            }
        } else {
            this.ae = (this.Y + this.Z.trim()).trim().toUpperCase();
        }
        e.b("BaseSloganUtil", "getSloganInfo, mXXMPAIBackCameraNumCamera: " + this.ae);
        return this.ae;
    }

    private void a(Canvas canvas, Bitmap bitmap, float f, float f2) {
        Paint paint = new Paint();
        Matrix matrix = new Matrix();
        matrix.postTranslate(f, f2);
        paint.setAlpha(255);
        canvas.drawBitmap(bitmap, matrix, paint);
    }

    private void a(Canvas canvas, String str, float f, float f2, Paint paint) {
        canvas.drawText(str, f, f2, paint);
    }

    /* access modifiers changed from: protected */
    public Bitmap b(c.b bVar, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        String str;
        Canvas canvas;
        c.b bVar2 = bVar;
        int i7 = bVar2.e;
        Size size = bVar2.f2782a;
        String str2 = bVar2.f2783b;
        String str3 = bVar2.d;
        String str4 = bVar2.c;
        this.af = !TextUtils.isEmpty(this.L) && ("realme 8".equals(this.L) || "realme 8 Pro".equals(this.L));
        e.a("BaseSloganUtil", "createBitmap, cameraId: " + i7 + ", pictureSize: Width x Height = " + size.getWidth() + "x" + size.getHeight());
        boolean z = this.y;
        boolean z2 = this.x;
        boolean z3 = this.w;
        e.e("BaseSloganUtil", "createBitmap, deviceOn: " + z + ", locationOn: " + z3 + ", timeOn: " + z2);
        if (z || z2 || z3) {
            float a2 = a(size) / 2.77777f;
            float dimensionPixelSize = ((float) this.m.getDimensionPixelSize(R.dimen.slogan_text_padding_ai_shot_gap)) * a2;
            float dimensionPixelSize2 = ((float) this.m.getDimensionPixelSize(R.dimen.slogan_text_padding_r_shot_gap)) * a2;
            int color2 = this.m.getColor(R.color.slogan_text_shadow_color);
            Size size2 = size;
            float dimensionPixelSize3 = ((float) this.m.getDimensionPixelSize(R.dimen.slogan_logo_shot_gap)) * a2;
            c.a a3 = a(a2);
            Bitmap a4 = a(a3, a2);
            float f = dimensionPixelSize3;
            Paint paint = new Paint();
            String str5 = "BaseSloganUtil";
            paint.setTypeface(h());
            paint.setTextSize(a3.n);
            String str6 = str4;
            paint.setColor(this.j.getColor(R.color.camera_white));
            paint.setShadowLayer((float) this.m.getDimensionPixelSize(R.dimen.slogan_text_shadow_radius), (float) this.m.getDimensionPixelSize(R.dimen.slogan_text_shadow_x), (float) this.m.getDimensionPixelSize(R.dimen.slogan_text_shadow_y), color2);
            paint.setAlpha(253);
            int height = a3.h + a4.getHeight() + a3.f2779b;
            if (z) {
                b(i7);
                if (!TextUtils.isEmpty(str2)) {
                    this.ab = this.W + str2;
                }
                Rect rect = new Rect();
                String str7 = this.ae;
                i2 = 0;
                paint.getTextBounds(str7, 0, str7.length(), rect);
                i3 = rect.height();
            } else {
                i2 = 0;
                i3 = 0;
            }
            if (z3) {
                i5 = (int) paint.measureText(str3);
                Rect rect2 = new Rect();
                paint.getTextBounds(str3, i2, str3.length(), rect2);
                i4 = rect2.height();
            } else {
                i5 = 0;
                i4 = 0;
            }
            if (z2) {
                str = str6;
                i6 = (int) paint.measureText(str);
            } else {
                str = str6;
                i6 = 0;
            }
            int i8 = i6 > i5 ? i6 : i5;
            if (i3 > 0) {
                i4 = i3;
            }
            String str8 = str;
            StringBuilder sb = new StringBuilder();
            boolean z4 = z2;
            sb.append("createBitmap, timeWidth: ");
            sb.append(i6);
            sb.append(", locationWidth:");
            sb.append(i5);
            sb.append(", locationHeight: ");
            sb.append(i4);
            sb.append(", textAICameraHeight:");
            sb.append(i3);
            sb.append(", locationTimeMaxPadding: ");
            sb.append(i8);
            String sb2 = sb.toString();
            String str9 = str5;
            e.a(str9, sb2);
            int width = size2.getWidth();
            if (width % 2 != 0) {
                width++;
            }
            int i9 = width;
            if (height % 2 != 0) {
                height++;
            }
            e.b(str9, "createBitmap, composeWidth: " + i9 + ", composeHeight: " + height);
            Bitmap a5 = Util.a(i9, height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(a5);
            canvas2.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            if (z) {
                paint.setTextSize(a3.n);
                float width2 = (((((float) size2.getWidth()) - paint.measureText(TextUtils.isEmpty(str2) ? this.aa : this.ab)) - ((float) a4.getWidth())) - f) / 2.0f;
                a(canvas2, a4, width2, (float) a3.h);
                canvas = canvas2;
                a(canvas2, TextUtils.isEmpty(str2) ? this.aa : this.ab, width2 + ((float) a4.getWidth()) + f, ((float) a3.h) + dimensionPixelSize2, paint);
            } else {
                canvas = canvas2;
            }
            if (z3) {
                paint.setTextSize(a3.m);
                a(canvas, str3, (float) ((i9 - i8) - a3.f2778a), ((float) a3.h) + dimensionPixelSize2, paint);
                e.a(str9, "createBitmap, drawText mCurrentAddress: " + str3);
            }
            if (z4) {
                paint.setTextSize(a3.m);
                String str10 = str8;
                a(canvas, str10, (((float) i9) - paint.measureText(str10)) / 2.0f, ((float) a3.h) + dimensionPixelSize2 + dimensionPixelSize, paint);
                e.a(str9, "createBitmap, drawText mDateTime: " + str10);
            }
            if (i9 <= size2.getWidth() || a5 == null) {
                return a5;
            }
            float f2 = (float) i9;
            int width3 = (int) (f2 / ((1.0f * f2) / ((float) size2.getWidth())));
            int i10 = width3 % 2;
            int i11 = i10 != 0 ? width3 - 1 : width3;
            if (i10 != 0) {
                width3--;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a5, i11, width3, true);
            e.d(str9, "createBitmap, createScaledBitmap now");
            return createScaledBitmap;
        }
        e.e("BaseSloganUtil", "createBitmap, all watermark options are closed, so need not to draw slogan, return null ");
        return null;
    }

    /* access modifiers changed from: protected */
    public c.a a(float f, int i) {
        c.a aVar = new c.a();
        aVar.g = R.drawable.realme_slogan_copyright_normal;
        if (this.af) {
            aVar.g = R.drawable.watermark_infinite_logo;
        }
        aVar.h = (int) (((float) this.m.getDimensionPixelSize(R.dimen.slogan_text_margin_top)) * f);
        aVar.f2778a = (int) (((float) this.m.getDimensionPixelSize(R.dimen.slogan_text_padding_left)) * f);
        aVar.f2779b = (int) (((float) this.m.getDimensionPixelSize(R.dimen.slogan_text_padding_bottom)) * f);
        aVar.m = (float) ((int) (this.m.getDimension(R.dimen.slogan_ai_camera_text_size) * f));
        aVar.n = (float) ((int) (this.m.getDimension(R.dimen.slogan_shot_on_by_text_size) * f));
        aVar.i = (int) (this.m.getDimension(R.dimen.slogan_shot_on_by_text_size) * f);
        aVar.j = (int) (this.m.getDimension(R.dimen.slogan_shot_on_by_text_size) * f);
        return aVar;
    }

    /* access modifiers changed from: protected */
    public Bitmap a(c.a aVar, float f) {
        Bitmap decodeResource = BitmapFactory.decodeResource(this.j.getResources(), aVar.g);
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        return Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, true);
    }
}
