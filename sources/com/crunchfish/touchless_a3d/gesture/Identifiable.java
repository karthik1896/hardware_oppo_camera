package com.crunchfish.touchless_a3d.gesture;

public abstract class Identifiable {
    private final String mId;
    private final Type mType;

    /* renamed from: com.crunchfish.touchless_a3d.gesture.Identifiable$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$crunchfish$touchless_a3d$gesture$Identifiable$Type = new int[Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.crunchfish.touchless_a3d.gesture.Identifiable$Type[] r0 = com.crunchfish.touchless_a3d.gesture.Identifiable.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$crunchfish$touchless_a3d$gesture$Identifiable$Type = r0
                int[] r0 = $SwitchMap$com$crunchfish$touchless_a3d$gesture$Identifiable$Type     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.crunchfish.touchless_a3d.gesture.Identifiable$Type r1 = com.crunchfish.touchless_a3d.gesture.Identifiable.Type.POSE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$crunchfish$touchless_a3d$gesture$Identifiable$Type     // Catch:{ NoSuchFieldError -> 0x001f }
                com.crunchfish.touchless_a3d.gesture.Identifiable$Type r1 = com.crunchfish.touchless_a3d.gesture.Identifiable.Type.SWIPE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.crunchfish.touchless_a3d.gesture.Identifiable.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Type {
        POSE,
        SWIPE;

        public String toString() {
            int i = AnonymousClass1.$SwitchMap$com$crunchfish$touchless_a3d$gesture$Identifiable$Type[ordinal()];
            if (i == 1) {
                return "POSE";
            }
            if (i == 2) {
                return "SWIPE";
            }
            throw new IllegalArgumentException();
        }
    }

    protected Identifiable(Type type, String str) {
        this.mType = type;
        this.mId = str;
    }

    public final Type getType() {
        return this.mType;
    }

    public final String getId() {
        return this.mId;
    }

    public String toString() {
        return "Identifiable{id='" + this.mId + "', type=" + this.mType + "}";
    }
}
