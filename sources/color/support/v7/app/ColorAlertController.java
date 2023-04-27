package color.support.v7.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.f;
import color.support.v7.app.a;
import color.support.v7.appcompat.R;
import color.support.v7.internal.widget.ButtonBarLayout;
import color.support.v7.internal.widget.ColorAlertLinearLayout;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class ColorAlertController extends a {
    private boolean B;
    /* access modifiers changed from: private */
    public Context C;
    /* access modifiers changed from: private */
    public Handler D;
    /* access modifiers changed from: private */
    public ContentObserver E = new ContentObserver(this.D) {
        public void onChange(boolean z) {
            if (Settings.Secure.getInt(ColorAlertController.this.C.getContentResolver(), "manual_hide_navigationbar", -1) == 0) {
                ColorAlertController.this.D.sendMessage(Message.obtain(ColorAlertController.this.D, 1, ColorAlertController.this));
            } else {
                ColorAlertController.this.D.sendMessage(Message.obtain(ColorAlertController.this.D, 2, ColorAlertController.this));
            }
        }
    };
    /* access modifiers changed from: private */
    public ComponentCallbacks F = new ComponentCallbacks() {
        public void onLowMemory() {
        }

        public void onConfigurationChanged(Configuration configuration) {
            ColorAlertController.this.f();
            ColorAlertController.this.x();
            ColorAlertController.this.s();
            ColorAlertController.this.t();
        }
    };

    public ColorAlertController(Context context, f fVar, Window window) {
        super(context, fVar, window);
        this.C = context;
        this.D = new a(this);
    }

    /* access modifiers changed from: protected */
    public int b() {
        return h() ? super.b() : R.layout.color_bottom_alert_dialog;
    }

    /* access modifiers changed from: private */
    public void f() {
        Point g = g();
        boolean z = g.x < g.y;
        DisplayMetrics displayMetrics = this.C.getResources().getDisplayMetrics();
        WindowManager.LayoutParams attributes = this.f1461b.getAttributes();
        this.f1461b.clearFlags(-2147482112);
        if (h()) {
            attributes.windowAnimations = R.style.Animation_ColorSupport_Dialog_Alpha;
            if (z) {
                attributes.width = Math.min(g.x, displayMetrics.widthPixels);
                attributes.height = -2;
            } else {
                attributes.width = Math.min(g.y, displayMetrics.widthPixels);
                attributes.height = this.C.getResources().getDimensionPixelSize(R.dimen.alert_dialog_central_max_height);
            }
            this.f1461b.setGravity(17);
            this.f1461b.setAttributes(attributes);
            return;
        }
        attributes.windowAnimations = R.style.ColorDialogAnimation;
        if (z) {
            this.f1461b.setGravity(80);
            attributes.width = Math.min(g.x, displayMetrics.widthPixels);
            attributes.height = -2;
            if (Build.VERSION.SDK_INT >= 30 && q()) {
                attributes.setFitInsetsTypes(WindowInsets.Type.statusBars());
                attributes.setFitInsetsSides(WindowInsets.Side.all() & -9);
                attributes.setFitInsetsIgnoringVisibility(true);
                this.f1461b.getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        return new WindowInsets.Builder(windowInsets).setInsets(WindowInsets.Type.navigationBars(), Insets.NONE).build();
                    }
                });
            }
        } else {
            this.f1461b.setGravity(17);
            attributes.width = Math.min(g.y, displayMetrics.widthPixels);
            attributes.height = this.C.getResources().getDimensionPixelSize(R.dimen.alert_dialog_central_max_height);
        }
        this.f1461b.setAttributes(attributes);
    }

    private Point g() {
        Point point = new Point();
        ((WindowManager) this.C.getSystemService("window")).getDefaultDisplay().getRealSize(point);
        return point;
    }

    private boolean h() {
        return e() == 0;
    }

    private void i() {
        if (!h()) {
            j();
        }
        if (p()) {
            x();
            WindowManager.LayoutParams attributes = this.f1461b.getAttributes();
            a(attributes);
            this.f1461b.setAttributes(attributes);
        }
    }

    private void j() {
        this.C.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("manual_hide_navigationbar"), false, this.E);
    }

    private int k() {
        int i;
        if (!q()) {
            return 0;
        }
        if (o()) {
            i = 0;
        } else if (m()) {
            i = l();
        } else {
            i = this.C.getResources().getDimensionPixelSize(R.dimen.alert_dialog_padding_bottom);
        }
        if (!this.B) {
            return 0;
        }
        return i;
    }

    private int l() {
        Resources resources = this.C.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    private boolean m() {
        if (!n()) {
            return false;
        }
        int i = Settings.Secure.getInt(this.C.getContentResolver(), "hide_navigationbar_enable", 0);
        int i2 = Settings.Secure.getInt(this.C.getContentResolver(), "manual_hide_navigationbar", 0);
        this.B = (i == -1 || i2 == -1) ? false : true;
        if (i == 0 || (i == 1 && i2 == 0)) {
            return true;
        }
        return false;
    }

    private boolean n() {
        Resources resources = this.C.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"qemu.hw.mainkeys"});
            if ("1".equals(str)) {
                return false;
            }
            if ("0".equals(str)) {
                return true;
            }
            return z;
        } catch (Exception e) {
            Log.d("ColorAlertController", "fail to get navigation bar status message is " + e.getMessage());
            return z;
        }
    }

    private boolean o() {
        return this.f1461b.getAttributes().gravity == 17;
    }

    private boolean p() {
        return !h() && q();
    }

    private boolean q() {
        Activity a2;
        if (Build.VERSION.SDK_INT < 24 || (a2 = a(this.C)) == null) {
            return true;
        }
        return !a2.isInMultiWindowMode();
    }

    private Activity a(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private void r() {
        if (o()) {
            this.f1461b.clearFlags(-2147482112);
        } else if (m()) {
            this.f1461b.setNavigationBarColor(-1);
            this.f1461b.clearFlags(134217728);
            this.f1461b.getDecorView().setSystemUiVisibility(16);
            this.f1461b.addFlags(-2147482112);
        }
    }

    private void a(WindowManager.LayoutParams layoutParams) {
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField("privateFlags");
            declaredField.setAccessible(true);
            declaredField.set(layoutParams, Integer.valueOf(declaredField.getInt(layoutParams) | 16777216 | 64));
        } catch (Exception e) {
            Log.d("ColorAlertController", "addPrivateFlag failed.Fail msg is " + e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void s() {
        View findViewById = this.f1461b.findViewById(R.id.parentPanel);
        if (findViewById != null && (findViewById instanceof ColorAlertLinearLayout)) {
            ColorAlertLinearLayout colorAlertLinearLayout = (ColorAlertLinearLayout) findViewById;
            if (o()) {
                colorAlertLinearLayout.setNeedClip(true);
                colorAlertLinearLayout.setHasShadow(true);
                return;
            }
            colorAlertLinearLayout.setNeedClip(false);
            colorAlertLinearLayout.setHasShadow(false);
        }
    }

    /* access modifiers changed from: private */
    public void t() {
        if (this.A && h()) {
            Point g = g();
            WindowManager.LayoutParams attributes = this.f1461b.getAttributes();
            View findViewById = this.f1461b.findViewById(R.id.parentPanel);
            if (findViewById != null && g.x < g.y) {
                DisplayMetrics displayMetrics = this.C.getResources().getDisplayMetrics();
                int dimensionPixelSize = this.C.getResources().getDimensionPixelSize(R.dimen.color_dialog_max_height) + findViewById.getPaddingTop() + findViewById.getPaddingBottom();
                int paddingBottom = findViewById.getPaddingBottom() + this.C.getResources().getDimensionPixelSize(R.dimen.color_dialog_max_height_landscape) + findViewById.getPaddingTop();
                int i = displayMetrics.heightPixels;
                if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
                    paddingBottom = dimensionPixelSize;
                }
                attributes.height = Math.min(i, paddingBottom);
                this.f1461b.setAttributes(attributes);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void d() {
        f();
        i();
        s();
        t();
        ListView c = c();
        if (c instanceof ColorRecyclerListView) {
            ((ColorRecyclerListView) c).setNeedClip(u());
        }
        super.d();
    }

    private boolean u() {
        return !v() && !w() && !h();
    }

    /* access modifiers changed from: protected */
    public void c(ViewGroup viewGroup) {
        super.c(viewGroup);
        if (!h() && !this.y && !this.z && (viewGroup instanceof ButtonBarLayout)) {
            ((ButtonBarLayout) viewGroup).setForceVertical(true);
            ((Button) viewGroup.findViewById(16908313)).setTextColor(this.C.getResources().getColor(R.color.color_bottom_alert_dialog_button_text_color));
            ((Button) viewGroup.findViewById(16908314)).setTextColor(this.C.getResources().getColor(R.color.color_bottom_alert_dialog_button_text_color));
            ((Button) viewGroup.findViewById(16908315)).setTextColor(this.C.getResources().getColor(R.color.color_bottom_alert_dialog_button_warning_color));
        }
    }

    /* access modifiers changed from: protected */
    public void b(final ViewGroup viewGroup) {
        super.b(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.listPanel);
        if (!(this.d == null || viewGroup2 == null || this.e == null)) {
            viewGroup2.addView(this.e, new ViewGroup.LayoutParams(-1, -1));
            ImageView imageView = (ImageView) viewGroup.findViewById(R.id.color_alert_dialog_list_divider);
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        }
        if (!h()) {
            e(viewGroup2);
            if ((this.y || this.z) && v() && w()) {
                d(viewGroup);
            }
        } else if (this.d != null) {
            f(viewGroup);
        }
        viewGroup.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View view) {
                ColorAlertController.this.C.registerComponentCallbacks(ColorAlertController.this.F);
            }

            public void onViewDetachedFromWindow(View view) {
                viewGroup.removeOnAttachStateChangeListener(this);
                if (ColorAlertController.this.F != null) {
                    ColorAlertController.this.C.unregisterComponentCallbacks(ColorAlertController.this.F);
                    ComponentCallbacks unused = ColorAlertController.this.F = null;
                }
                ColorAlertController.this.C.getContentResolver().unregisterContentObserver(ColorAlertController.this.E);
            }
        });
    }

    private void d(ViewGroup viewGroup) {
        if (this.o != null) {
            this.o.setPadding(this.o.getPaddingLeft(), this.C.getResources().getDimensionPixelSize(R.dimen.center_dialog_scroll_padding_top), this.o.getPaddingRight(), this.C.getResources().getDimensionPixelSize(R.dimen.center_dialog_scroll_padding_bottom));
        }
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.setMarginStart(this.C.getResources().getDimensionPixelSize(R.dimen.bottom_choice_dialog_message_margin_start));
        layoutParams.setMarginEnd(this.C.getResources().getDimensionPixelSize(R.dimen.bottom_choice_dialog_message_margin_end));
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(0, (float) this.C.getResources().getDimensionPixelSize(R.dimen.TD07));
        textView.setTextColor(this.C.getResources().getColor(R.color.color_alert_dialog_content_text_color));
        f(viewGroup);
    }

    private void e(ViewGroup viewGroup) {
        if (this.x) {
            if (this.o != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.getLayoutParams();
                layoutParams.height = 0;
                layoutParams.weight = 1.0f;
                this.o.setLayoutParams(layoutParams);
            }
            if (viewGroup != null) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams2.height = 0;
                layoutParams2.weight = 1.0f;
                viewGroup.setLayoutParams(layoutParams2);
            }
        }
    }

    private void f(ViewGroup viewGroup) {
        final TextView textView = (TextView) viewGroup.findViewById(16908299);
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (textView.getLineCount() > 1) {
                    textView.setTextAlignment(2);
                } else {
                    textView.setTextAlignment(4);
                }
                TextView textView = textView;
                textView.setText(textView.getText());
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    private boolean v() {
        return !TextUtils.isEmpty(this.d);
    }

    private boolean w() {
        return !TextUtils.isEmpty(this.c);
    }

    /* access modifiers changed from: private */
    public void x() {
        View findViewById;
        ViewGroup viewGroup = (ViewGroup) this.f1461b.findViewById(R.id.parentPanel);
        if (!(viewGroup == null || (findViewById = viewGroup.findViewById(R.id.alert_dialog_bottom_space)) == null)) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = k();
            findViewById.setLayoutParams(layoutParams);
        }
        r();
        WindowManager.LayoutParams attributes = this.f1461b.getAttributes();
        if (b(attributes)) {
            if (!m()) {
                attributes.y = 0;
            } else if (o()) {
                attributes.y = 0;
            } else if (Build.VERSION.SDK_INT < 30 || !q()) {
                attributes.y -= l();
            } else {
                attributes.y = 0;
            }
        }
        this.f1461b.setAttributes(attributes);
    }

    private boolean b(WindowManager.LayoutParams layoutParams) {
        return layoutParams.type == 2003 || layoutParams.type == 2038 || layoutParams.type == 2303;
    }

    private static final class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<ColorAlertController> f1455a;

        public a(ColorAlertController colorAlertController) {
            this.f1455a = new WeakReference<>(colorAlertController);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1 || i == 2) {
                ((ColorAlertController) message.obj).x();
            }
        }
    }

    public static class ColorRecyclerListView extends a.d {

        /* renamed from: a  reason: collision with root package name */
        private Path f1453a;

        /* renamed from: b  reason: collision with root package name */
        private int f1454b;
        private boolean c;
        private float[] d;
        private RectF e;

        public ColorRecyclerListView(Context context) {
            this(context, (AttributeSet) null);
        }

        public ColorRecyclerListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1454b = context.getResources().getDimensionPixelOffset(R.dimen.alert_dialog_bottom_corner_radius);
            this.f1453a = new Path();
            this.e = new RectF();
            int i = this.f1454b;
            this.d = new float[]{(float) i, (float) i, (float) i, (float) i, 0.0f, 0.0f, 0.0f, 0.0f};
        }

        public void draw(Canvas canvas) {
            canvas.save();
            if (this.c) {
                canvas.clipPath(this.f1453a);
            }
            super.draw(canvas);
            canvas.restore();
        }

        public void setNeedClip(boolean z) {
            this.c = z;
        }

        /* access modifiers changed from: protected */
        public void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            this.f1453a.reset();
            this.e.set(0.0f, 0.0f, (float) i, (float) i2);
            this.f1453a.addRoundRect(this.e, this.d, Path.Direction.CW);
        }
    }

    public static class b extends a.C0045a {
        public String V;

        public b(Context context) {
            super(context);
        }

        public void a(a aVar) {
            super.a(aVar);
            if (this.w != null || this.N != null || this.z != null) {
                b(aVar);
            }
        }

        private void b(final a aVar) {
            if (this.J) {
                if (this.N == null) {
                    final a aVar2 = aVar;
                    aVar.p = new c(this.f1471a, aVar.t, this.w, this.x, this.I, true) {
                        public View getView(int i, View view, ViewGroup viewGroup) {
                            View view2 = super.getView(i, view, viewGroup);
                            if (b.this.I != null && b.this.I[i]) {
                                aVar2.e.setItemChecked(i, true);
                            }
                            return view2;
                        }
                    };
                } else {
                    final a aVar3 = aVar;
                    aVar.p = new d(this, this.f1471a, this.N, aVar.t, this.O, this.P, this.V, this.J) {
                        final /* synthetic */ b k;

                        {
                            this.k = r10;
                        }

                        public void a(View view, Context context, Cursor cursor) {
                            super.a(view, context, cursor);
                            int columnIndexOrThrow = cursor.getColumnIndexOrThrow(this.k.P);
                            ListView listView = aVar3.e;
                            int position = cursor.getPosition();
                            int i = cursor.getInt(columnIndexOrThrow);
                            boolean z = true;
                            if (i != 1) {
                                z = false;
                            }
                            listView.setItemChecked(position, z);
                        }
                    };
                }
            } else if (this.K) {
                int i = aVar.u;
                if (this.N != null) {
                    aVar.p = new d(this.f1471a, this.N, i, this.O, this.V);
                } else if (this.z == null) {
                    aVar.p = new c(this.f1471a, i, this.w, this.x);
                }
            }
            if (this.M != null) {
                aVar.e.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (b.this.I != null) {
                            b.this.I[i] = aVar.e.isItemChecked(i);
                        }
                        b.this.M.onClick(aVar.f1460a, i, aVar.e.isItemChecked(i));
                        if (b.this.J) {
                            int i2 = aVar.e.isItemChecked(i) ? 2 : 0;
                            if (b.this.N == null) {
                                ((c) aVar.p).a(i2, i, aVar.e);
                            } else {
                                ((d) aVar.p).a(i2, i, aVar.e);
                            }
                        }
                    }
                });
            }
        }
    }
}
