package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.k;
import androidx.lifecycle.e;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() {
        /* renamed from: a */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* renamed from: a */
        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    };
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int[] mCurrentMaxLifecycleStates;
    final ArrayList<String> mFragmentWhos;
    final int mIndex;
    final String mName;
    final int[] mOldMaxLifecycleStates;
    final int[] mOps;
    final boolean mReorderingAllowed;
    final ArrayList<String> mSharedElementSourceNames;
    final ArrayList<String> mSharedElementTargetNames;
    final int mTransition;
    final int mTransitionStyle;

    public int describeContents() {
        return 0;
    }

    public BackStackState(a aVar) {
        int size = aVar.d.size();
        this.mOps = new int[(size * 5)];
        if (aVar.k) {
            this.mFragmentWhos = new ArrayList<>(size);
            this.mOldMaxLifecycleStates = new int[size];
            this.mCurrentMaxLifecycleStates = new int[size];
            int i = 0;
            int i2 = 0;
            while (i < size) {
                k.a aVar2 = (k.a) aVar.d.get(i);
                int i3 = i2 + 1;
                this.mOps[i2] = aVar2.f873a;
                this.mFragmentWhos.add(aVar2.f874b != null ? aVar2.f874b.mWho : null);
                int i4 = i3 + 1;
                this.mOps[i3] = aVar2.c;
                int i5 = i4 + 1;
                this.mOps[i4] = aVar2.d;
                int i6 = i5 + 1;
                this.mOps[i5] = aVar2.e;
                this.mOps[i6] = aVar2.f;
                this.mOldMaxLifecycleStates[i] = aVar2.g.ordinal();
                this.mCurrentMaxLifecycleStates[i] = aVar2.h.ordinal();
                i++;
                i2 = i6 + 1;
            }
            this.mTransition = aVar.i;
            this.mTransitionStyle = aVar.j;
            this.mName = aVar.m;
            this.mIndex = aVar.c;
            this.mBreadCrumbTitleRes = aVar.n;
            this.mBreadCrumbTitleText = aVar.o;
            this.mBreadCrumbShortTitleRes = aVar.p;
            this.mBreadCrumbShortTitleText = aVar.q;
            this.mSharedElementSourceNames = aVar.r;
            this.mSharedElementTargetNames = aVar.s;
            this.mReorderingAllowed = aVar.t;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.mOps = parcel.createIntArray();
        this.mFragmentWhos = parcel.createStringArrayList();
        this.mOldMaxLifecycleStates = parcel.createIntArray();
        this.mCurrentMaxLifecycleStates = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mTransitionStyle = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        this.mBreadCrumbTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSharedElementSourceNames = parcel.createStringArrayList();
        this.mSharedElementTargetNames = parcel.createStringArrayList();
        this.mReorderingAllowed = parcel.readInt() != 0;
    }

    public a instantiate(i iVar) {
        a aVar = new a(iVar);
        int i = 0;
        int i2 = 0;
        while (i < this.mOps.length) {
            k.a aVar2 = new k.a();
            int i3 = i + 1;
            aVar2.f873a = this.mOps[i];
            if (i.f849b) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i2 + " base fragment #" + this.mOps[i3]);
            }
            String str = this.mFragmentWhos.get(i2);
            if (str != null) {
                aVar2.f874b = iVar.g.get(str);
            } else {
                aVar2.f874b = null;
            }
            aVar2.g = e.b.values()[this.mOldMaxLifecycleStates[i2]];
            aVar2.h = e.b.values()[this.mCurrentMaxLifecycleStates[i2]];
            int[] iArr = this.mOps;
            int i4 = i3 + 1;
            aVar2.c = iArr[i3];
            int i5 = i4 + 1;
            aVar2.d = iArr[i4];
            int i6 = i5 + 1;
            aVar2.e = iArr[i5];
            aVar2.f = iArr[i6];
            aVar.e = aVar2.c;
            aVar.f = aVar2.d;
            aVar.g = aVar2.e;
            aVar.h = aVar2.f;
            aVar.a(aVar2);
            i2++;
            i = i6 + 1;
        }
        aVar.i = this.mTransition;
        aVar.j = this.mTransitionStyle;
        aVar.m = this.mName;
        aVar.c = this.mIndex;
        aVar.k = true;
        aVar.n = this.mBreadCrumbTitleRes;
        aVar.o = this.mBreadCrumbTitleText;
        aVar.p = this.mBreadCrumbShortTitleRes;
        aVar.q = this.mBreadCrumbShortTitleText;
        aVar.r = this.mSharedElementSourceNames;
        aVar.s = this.mSharedElementTargetNames;
        aVar.t = this.mReorderingAllowed;
        aVar.a(1);
        return aVar;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.mOps);
        parcel.writeStringList(this.mFragmentWhos);
        parcel.writeIntArray(this.mOldMaxLifecycleStates);
        parcel.writeIntArray(this.mCurrentMaxLifecycleStates);
        parcel.writeInt(this.mTransition);
        parcel.writeInt(this.mTransitionStyle);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel, 0);
        parcel.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel, 0);
        parcel.writeStringList(this.mSharedElementSourceNames);
        parcel.writeStringList(this.mSharedElementTargetNames);
        parcel.writeInt(this.mReorderingAllowed ? 1 : 0);
    }
}
