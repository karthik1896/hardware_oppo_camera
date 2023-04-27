package com.crunchfish.touchless_a3d.gesture;

import com.crunchfish.touchless_a3d.gesture.Identifiable;

public class Swipe extends Identifiable {
    private final Direction mDirection;

    /* renamed from: com.crunchfish.touchless_a3d.gesture.Swipe$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$crunchfish$touchless_a3d$gesture$Swipe$Direction = new int[Direction.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.crunchfish.touchless_a3d.gesture.Swipe$Direction[] r0 = com.crunchfish.touchless_a3d.gesture.Swipe.Direction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$crunchfish$touchless_a3d$gesture$Swipe$Direction = r0
                int[] r0 = $SwitchMap$com$crunchfish$touchless_a3d$gesture$Swipe$Direction     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.crunchfish.touchless_a3d.gesture.Swipe$Direction r1 = com.crunchfish.touchless_a3d.gesture.Swipe.Direction.SWIPE_LEFT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$crunchfish$touchless_a3d$gesture$Swipe$Direction     // Catch:{ NoSuchFieldError -> 0x001f }
                com.crunchfish.touchless_a3d.gesture.Swipe$Direction r1 = com.crunchfish.touchless_a3d.gesture.Swipe.Direction.SWIPE_RIGHT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.crunchfish.touchless_a3d.gesture.Swipe.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Direction {
        SWIPE_LEFT,
        SWIPE_RIGHT;

        public String toString() {
            int i = AnonymousClass1.$SwitchMap$com$crunchfish$touchless_a3d$gesture$Swipe$Direction[ordinal()];
            if (i == 1) {
                return "LEFT";
            }
            if (i == 2) {
                return "RIGHT";
            }
            throw new IllegalArgumentException();
        }
    }

    Swipe(String str, Direction direction) {
        super(Identifiable.Type.SWIPE, str);
        this.mDirection = direction;
    }

    public Direction getDirection() {
        return this.mDirection;
    }

    public String toString() {
        return "Swipe{id='" + getId() + "', direction=" + this.mDirection + "}";
    }
}
