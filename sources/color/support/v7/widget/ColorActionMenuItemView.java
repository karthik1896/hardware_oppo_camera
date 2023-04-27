package color.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.b;
import androidx.appcompat.view.menu.j;
import color.support.v7.appcompat.R;

@SuppressLint({"RestrictedApi"})
public class ColorActionMenuItemView extends b {
    private int e;
    private int f;
    private int g;
    private int h;

    public ColorActionMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ColorActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = context.getResources().getDimensionPixelSize(R.dimen.color_toolbar_menu_bg_padding_horizontal);
        this.f = context.getResources().getDimensionPixelSize(R.dimen.color_toolbar_menu_bg_padding_vertical);
        this.h = context.getResources().getDimensionPixelSize(R.dimen.color_toolbar_text_menu_bg_padding_horizontal);
        this.g = context.getResources().getDimensionPixelSize(R.dimen.color_toolbar_text_menu_bg_padding_vertical);
    }

    public void initialize(j jVar, int i) {
        super.initialize(jVar, i);
        boolean z = jVar.getIcon() == null;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = z ? -2 : -1;
        setLayoutParams(layoutParams);
        setBackgroundResource(z ? R.drawable.color_toolbar_text_menu_bg : R.drawable.color_toolbar_menu_bg);
        if (!z) {
            int i2 = this.e;
            int i3 = this.f;
            setPadding(i2, i3, i2, i3);
            return;
        }
        int i4 = this.h;
        int i5 = this.g;
        setPadding(i4, i5, i4, i5);
    }
}
