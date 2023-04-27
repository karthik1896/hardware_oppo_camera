package com.oppo.camera.f;

import android.location.Location;
import co.polarr.renderer.FilterPackageUtil;
import com.oppo.camera.aps.adapter.ApsAdapterDecision;
import java.util.Map;
import java.util.Set;

/* compiled from: CameraRequestTag */
public class d {
    public String A = "";
    public boolean B = false;
    public int C = 0;
    public String D = "";
    public String E = "";
    public int F = -1;
    public String[] G = null;
    public int[] H = null;
    public long[] I = null;
    public boolean J = false;
    public boolean K = false;
    public boolean L = false;
    public ApsAdapterDecision.DecisionResult M = null;
    public int N = 0;
    public boolean O = false;
    public boolean P = false;
    public boolean Q = false;
    public boolean R = false;
    public boolean S = false;
    public int T = 60;
    public int U = 0;
    public int V = 1;
    public int W = 1;
    public int[] X = null;
    public int Y = 0;
    public int Z = 0;

    /* renamed from: a  reason: collision with root package name */
    public boolean f3190a = false;
    public int aa = 0;
    public int ab = 0;
    public int ac = 0;
    public int ad = -1;
    public int ae = 0;
    public int af = 0;
    public int ag = 0;
    public boolean ah = false;
    public boolean ai = false;
    public String aj = null;
    public Set<String> ak = null;
    public Map<String, Long> al = null;
    public Location am = null;
    public long an = 0;
    public boolean ao = false;
    public float ap = 1.0f;
    public int aq = 0;
    public boolean ar = false;
    public boolean as = false;
    private a at = a.PREVIEW;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3191b = false;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public String n = FilterPackageUtil.F_DEFAULT;
    public boolean o = false;
    public boolean p = false;
    public int q = 1;
    public int r = 0;
    public boolean s = false;
    public boolean t = false;
    public String u = "";
    public int v = 0;
    public int w = 0;
    public String x = "";
    public boolean y = false;
    public String z = "";

    /* compiled from: CameraRequestTag */
    public enum a {
        PREVIEW,
        CAPTURE,
        CAPTURE_RAW,
        CAPTURE_REPROCESS
    }

    public d() {
    }

    public d(a aVar) {
        this.at = aVar;
    }

    public void a(a aVar) {
        this.at = aVar;
    }

    public a a() {
        return this.at;
    }
}
