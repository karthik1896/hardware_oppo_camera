package com.color.support.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.recyclerview.widget.ColorLinearLayoutManager;
import androidx.recyclerview.widget.ColorRecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import com.color.support.widget.ExpandableRecyclerConnector;
import java.util.ArrayList;

public class ColorExpandableRecyclerView extends ColorRecyclerView {
    private d f;
    private ExpandableRecyclerConnector g;
    private b h;
    private a i;
    private c j;
    private d k;

    public interface a {
        boolean a(ColorRecyclerView colorRecyclerView, View view, int i, int i2, long j);
    }

    public interface b {
        boolean a(ColorExpandableRecyclerView colorExpandableRecyclerView, View view, int i, long j);
    }

    public interface c {
        void a(int i);
    }

    public interface d {
        void a(int i);
    }

    public void setLayoutManager(RecyclerView.i iVar) {
        if (!(iVar instanceof ColorLinearLayoutManager)) {
            throw new RuntimeException("only ColorLinearLayoutManager");
        } else if (((ColorLinearLayoutManager) iVar).getOrientation() == 1) {
            super.setLayoutManager(iVar);
        } else {
            throw new RuntimeException("only vertical orientation");
        }
    }

    public void setItemAnimator(RecyclerView.f fVar) {
        if (fVar == null) {
            super.setItemAnimator((RecyclerView.f) null);
            return;
        }
        throw new RuntimeException("not set ItemAnimator");
    }

    public void setAdapter(d dVar) {
        this.f = dVar;
        this.g = new ExpandableRecyclerConnector(dVar, this);
        super.setAdapter(this.g);
    }

    private long a(l lVar) {
        if (lVar.d == 1) {
            return this.f.b(lVar.f2223a, lVar.f2224b);
        }
        return this.f.d(lVar.f2223a);
    }

    /* access modifiers changed from: package-private */
    public boolean a(View view, int i2) {
        ExpandableRecyclerConnector.g b2 = this.g.b(i2);
        long a2 = a(b2.f2136a);
        boolean z = true;
        if (b2.f2136a.d == 2) {
            b bVar = this.h;
            if (bVar != null) {
                if (bVar.a(this, view, b2.f2136a.f2223a, a2)) {
                    b2.a();
                    return true;
                }
            }
            if (b2.b()) {
                a(b2.f2136a.f2223a);
            } else {
                b(b2.f2136a.f2223a);
            }
        } else {
            a aVar = this.i;
            if (aVar != null) {
                return aVar.a(this, view, b2.f2136a.f2223a, b2.f2136a.f2224b, a2);
            }
            z = false;
        }
        b2.a();
        return z;
    }

    public void setAdapter(RecyclerView.a aVar) {
        throw new RuntimeException("adapter instansof ColorExpandableRecyclerAdapter");
    }

    public void setOnGroupClickListener(b bVar) {
        this.h = bVar;
    }

    public void setOnChildClickListener(a aVar) {
        this.i = aVar;
    }

    public boolean a(int i2) {
        if (!this.g.a(i2)) {
            return false;
        }
        this.g.b();
        c cVar = this.j;
        if (cVar == null) {
            return true;
        }
        cVar.a(i2);
        return true;
    }

    public boolean b(int i2) {
        d dVar;
        boolean e = this.g.e(i2);
        if (e && (dVar = this.k) != null) {
            dVar.a(i2);
        }
        return e;
    }

    public void setOnGroupCollapseListener(c cVar) {
        this.j = cVar;
    }

    public void setOnGroupExpandListener(d dVar) {
        this.k = dVar;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        ArrayList<ExpandableRecyclerConnector.GroupMetadata> expandedGroupMetadataList;

        SavedState(Parcelable parcelable, ArrayList<ExpandableRecyclerConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.expandedGroupMetadataList = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.expandedGroupMetadataList = new ArrayList<>();
            parcel.readList(this.expandedGroupMetadataList, ExpandableRecyclerConnector.class.getClassLoader());
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.expandedGroupMetadataList);
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        ExpandableRecyclerConnector expandableRecyclerConnector = this.g;
        return new SavedState(onSaveInstanceState, expandableRecyclerConnector != null ? expandableRecyclerConnector.c() : null);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.g != null && savedState.expandedGroupMetadataList != null) {
            this.g.a(savedState.expandedGroupMetadataList);
        }
    }
}
