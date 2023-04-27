package com.oppo.camera.professional;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import com.anc.humanvideo.BuildConfig;
import com.oppo.camera.e.b;
import com.oppo.camera.professional.i;
import com.oppo.camera.ui.e;
import com.oppo.camera.util.Util;
import java.util.HashMap;

/* compiled from: HighPictureProMenuManager */
public class a extends i {

    /* renamed from: com.oppo.camera.professional.a$a  reason: collision with other inner class name */
    /* compiled from: HighPictureProMenuManager */
    public interface C0091a extends i.b {
        void b(long j);
    }

    public a(Activity activity, b bVar, e eVar, String str) {
        super(activity, bVar, eVar, str);
    }

    public HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pref_professional_iso_key", BuildConfig.BUILD_NUMBER);
        hashMap.put("pref_professional_exposure_time_key", "1/50s");
        hashMap.put("pref_professional_whitebalance_key", "2000");
        hashMap.put("pref_professional_focus_mode_key", "0.00");
        hashMap.put("pref_professional_exposure_compensation_key", "0.00");
        return hashMap;
    }

    public void b() {
        if (this.g != null) {
            this.g.scrollTo(4, this.g.b(4).indexOf(this.g.a(4)));
        }
    }

    public boolean c() {
        if (this.i == null || !this.i.isSelected()) {
            return false;
        }
        Util.a((View) this.j, 4, (Animation.AnimationListener) null, 300);
        this.d.a(0);
        this.g.e();
        this.i.a();
        this.h.g();
        return true;
    }

    public void a(long j) {
        ((C0091a) this.h).b(j);
        super.a(j);
    }

    public void a(byte[] bArr, boolean z, boolean z2) {
        if (d(w()) && !i()) {
            this.d.a(0);
        }
        super.a(bArr, z, z2);
    }
}
