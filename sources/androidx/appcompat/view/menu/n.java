package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;

/* compiled from: MenuPresenter */
public interface n {

    /* compiled from: MenuPresenter */
    public interface a {
        void a(h hVar, boolean z);

        boolean a(h hVar);
    }

    boolean collapseItemActionView(h hVar, j jVar);

    boolean expandItemActionView(h hVar, j jVar);

    boolean flagActionItems();

    int getId();

    void initForMenu(Context context, h hVar);

    void onCloseMenu(h hVar, boolean z);

    void onRestoreInstanceState(Parcelable parcelable);

    Parcelable onSaveInstanceState();

    boolean onSubMenuSelected(s sVar);

    void setCallback(a aVar);

    void updateMenuView(boolean z);
}
