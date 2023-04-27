package com.oppo.camera;

/* compiled from: AISSnapshotManager */
public class b implements d {
    private boolean d = false;
    private boolean e = false;
    private int f = -1;
    private int g = -1;
    private com.oppo.camera.e.b h = null;

    public b(com.oppo.camera.e.b bVar) {
        this.h = bVar;
    }

    private int g() {
        if (!this.e) {
            return -1;
        }
        return this.f;
    }

    public boolean a() {
        com.oppo.camera.e.b bVar = this.h;
        if (bVar == null || !bVar.q()) {
            com.oppo.camera.e.b bVar2 = this.h;
            if (bVar2 == null || bVar2.q()) {
                return false;
            }
            if ((!this.d || this.g <= 0) && g() <= 0) {
                return false;
            }
            return true;
        } else if ((!this.d || 1 >= this.g) && 1 >= g()) {
            return false;
        } else {
            return true;
        }
    }

    public void a(int i, int i2, int i3) {
        this.g = i2;
        boolean z = false;
        this.d = 1 == i;
        if (1 == i3) {
            z = true;
        }
        this.e = z;
        e.a("AISSnapshotManager", "updateAISStatus, mbAisNeeded: " + this.d + ", mAISMotionType: " + this.g + ", onSODStatusCheck: " + g() + ", mbAISWithinTriggered: " + this.e);
    }

    public void a(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            this.f = -1;
        } else {
            this.f = iArr[1] == 0 ? iArr[0] : 2;
        }
        e.a("AISSnapshotManager", "updateSODStatus, mSODMovementLevel: " + this.f);
    }

    private void a(boolean z) {
        com.oppo.camera.e.b bVar = this.h;
        if (bVar != null) {
            bVar.b(z);
        }
    }

    public void b() {
        this.d = false;
        this.e = false;
        this.f = -1;
        this.g = -1;
    }

    public void c() {
        e.b("AISSnapshotManager", "onPause");
        b();
    }

    public void d() {
        e.b("AISSnapshotManager", "onDestroy");
        b();
        this.h = null;
    }

    public boolean e() {
        e.a("AISSnapshotManager", "makeAISDecision");
        com.oppo.camera.e.b bVar = this.h;
        boolean z = false;
        if (bVar == null || !bVar.o()) {
            e.a("AISSnapshotManager", "makeAISDecision, not support");
            return false;
        }
        if (g() > 0) {
            a(false);
        } else {
            if (3 > this.g) {
                z = true;
            }
            a(z);
        }
        return true;
    }

    public int f() {
        com.oppo.camera.e.b bVar = this.h;
        if (bVar == null || !bVar.o()) {
            return -1;
        }
        if (2 == g()) {
            return 11;
        }
        if (this.d && 2 < this.g) {
            return 11;
        }
        if (1 == g() || (this.d && this.g > 0)) {
            return 1;
        }
        return -1;
    }
}
