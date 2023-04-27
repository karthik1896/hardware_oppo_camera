package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R;
import androidx.appcompat.app.b;
import androidx.appcompat.view.menu.n;
import com.sensetime.stmobile.STMobileHumanActionNative;

/* compiled from: MenuDialogHelper */
class i implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, n.a {

    /* renamed from: a  reason: collision with root package name */
    f f267a;

    /* renamed from: b  reason: collision with root package name */
    private h f268b;
    private b c;
    private n.a d;

    public i(h hVar) {
        this.f268b = hVar;
    }

    public void a(IBinder iBinder) {
        h hVar = this.f268b;
        b.a aVar = new b.a(hVar.getContext());
        this.f267a = new f(aVar.getContext(), R.layout.abc_list_menu_item_layout);
        this.f267a.setCallback(this);
        this.f268b.addMenuPresenter(this.f267a);
        aVar.setAdapter(this.f267a.a(), this);
        View headerView = hVar.getHeaderView();
        if (headerView != null) {
            aVar.setCustomTitle(headerView);
        } else {
            aVar.setIcon(hVar.getHeaderIcon()).setTitle(hVar.getHeaderTitle());
        }
        aVar.setOnKeyListener(this);
        this.c = aVar.create();
        this.c.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_VIDEO;
        this.c.show();
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.c.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f268b.close(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f268b.performShortcut(i, keyEvent, 0);
    }

    public void a() {
        b bVar = this.c;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f267a.onCloseMenu(this.f268b, true);
    }

    public void a(h hVar, boolean z) {
        if (z || hVar == this.f268b) {
            a();
        }
        n.a aVar = this.d;
        if (aVar != null) {
            aVar.a(hVar, z);
        }
    }

    public boolean a(h hVar) {
        n.a aVar = this.d;
        if (aVar != null) {
            return aVar.a(hVar);
        }
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f268b.performItemAction((j) this.f267a.a().getItem(i), 0);
    }
}
