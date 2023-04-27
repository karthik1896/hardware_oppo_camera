package com.heytap.compat.os;

import android.os.UserHandle;
import android.util.Log;
import com.color.inner.os.UserHandleWrapper;
import com.heytap.compat.d.a.b;
import com.heytap.reflect.RefClass;
import com.heytap.reflect.RefMethod;
import com.heytap.reflect.RefStaticMethod;
import com.heytap.reflect.RefStaticObject;

public class UserHandleNative {
    public static UserHandle CURRENT = null;
    public static UserHandle OWNER = null;
    public static UserHandle SYSTEM = ((UserHandle) a.SYSTEM.get());
    private static final String TAG = "UserHandleNative";
    public static int USER_ALL;
    public static int USER_CURRENT;
    public static int USER_SYSTEM;

    private UserHandleNative() {
    }

    private static class a {
        /* access modifiers changed from: private */
        public static RefStaticObject<UserHandle> OWNER;
        /* access modifiers changed from: private */
        public static RefStaticObject<UserHandle> SYSTEM;

        /* renamed from: a  reason: collision with root package name */
        private static Class<?> f2569a = RefClass.load(a.class, (Class<?>) UserHandle.class);
        /* access modifiers changed from: private */
        public static RefMethod<Integer> getIdentifier;
        /* access modifiers changed from: private */
        public static RefStaticMethod<Integer> myUserId;

        private a() {
        }
    }

    static {
        if (b.a()) {
            OWNER = (UserHandle) a.OWNER.get();
        }
        if (b.b()) {
            OWNER = UserHandleWrapper.OWNER;
            USER_CURRENT = -2;
            USER_ALL = -1;
            CURRENT = UserHandleWrapper.CURRENT;
            USER_SYSTEM = 0;
        } else if (b.g()) {
            if (b.c()) {
                USER_ALL = -1;
            }
            if (b.e()) {
                USER_SYSTEM = 0;
            }
            USER_CURRENT = -2;
            CURRENT = UserHandle.CURRENT;
            OWNER = UserHandle.OWNER;
        } else {
            Log.e(TAG, "not supported before R");
        }
    }

    public static int myUserId() throws com.heytap.compat.d.a.a {
        if (b.a()) {
            return ((Integer) a.myUserId.call(new Object[0])).intValue();
        }
        if (b.b()) {
            return UserHandleWrapper.myUserId();
        }
        if (b.g()) {
            return UserHandle.myUserId();
        }
        throw new com.heytap.compat.d.a.a("not supported before L");
    }

    public static int getIdentifier(UserHandle userHandle) throws com.heytap.compat.d.a.a {
        if (b.a()) {
            return ((Integer) a.getIdentifier.call(userHandle, new Object[0])).intValue();
        }
        if (b.b()) {
            return UserHandleWrapper.getIdentifier(userHandle);
        }
        if (b.c()) {
            return userHandle.getIdentifier();
        }
        throw new com.heytap.compat.d.a.a("not supported before P");
    }

    public static int getUserId(int i) throws com.heytap.compat.d.a.a {
        if (b.b()) {
            return UserHandleWrapper.getUserId(i);
        }
        if (b.c()) {
            return UserHandle.getUserId(i);
        }
        throw new com.heytap.compat.d.a.a();
    }

    public static UserHandle createUserHandle(int i) throws com.heytap.compat.d.a.a {
        if (b.b()) {
            return UserHandleWrapper.createUserHandle(i);
        }
        if (b.c()) {
            return new UserHandle(i);
        }
        throw new com.heytap.compat.d.a.a();
    }
}
