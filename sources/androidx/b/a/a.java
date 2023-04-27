package androidx.b.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.b.a.b;

/* compiled from: CursorAdapter */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f475a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f476b;
    protected Cursor c;
    protected Context d;
    protected int e;
    protected C0010a f;
    protected DataSetObserver g;
    protected b h;
    protected FilterQueryProvider i;

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract void a(View view, Context context, Cursor cursor);

    public boolean hasStableIds() {
        return true;
    }

    @Deprecated
    public a(Context context, Cursor cursor) {
        a(context, cursor, 1);
    }

    public a(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? 1 : 2);
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, Cursor cursor, int i2) {
        boolean z = false;
        if ((i2 & 1) == 1) {
            i2 |= 2;
            this.f476b = true;
        } else {
            this.f476b = false;
        }
        if (cursor != null) {
            z = true;
        }
        this.c = cursor;
        this.f475a = z;
        this.d = context;
        this.e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i2 & 2) == 2) {
            this.f = new C0010a();
            this.g = new b();
        } else {
            this.f = null;
            this.g = null;
        }
        if (z) {
            C0010a aVar = this.f;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public Cursor a() {
        return this.c;
    }

    public int getCount() {
        Cursor cursor;
        if (!this.f475a || (cursor = this.c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public Object getItem(int i2) {
        Cursor cursor;
        if (!this.f475a || (cursor = this.c) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.c;
    }

    public long getItemId(int i2) {
        Cursor cursor;
        if (!this.f475a || (cursor = this.c) == null || !cursor.moveToPosition(i2)) {
            return 0;
        }
        return this.c.getLong(this.e);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f475a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.c.moveToPosition(i2)) {
            if (view == null) {
                view = a(this.d, this.c, viewGroup);
            }
            a(view, this.d, this.c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i2);
        }
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f475a) {
            return null;
        }
        this.c.moveToPosition(i2);
        if (view == null) {
            view = b(this.d, this.c, viewGroup);
        }
        a(view, this.d, this.c);
        return view;
    }

    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return a(context, cursor, viewGroup);
    }

    public void a(Cursor cursor) {
        Cursor c2 = c(cursor);
        if (c2 != null) {
            c2.close();
        }
    }

    public Cursor c(Cursor cursor) {
        Cursor cursor2 = this.c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0010a aVar = this.f;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.c = cursor;
        if (cursor != null) {
            C0010a aVar2 = this.f;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.e = cursor.getColumnIndexOrThrow("_id");
            this.f475a = true;
            notifyDataSetChanged();
        } else {
            this.e = -1;
            this.f475a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    public CharSequence b(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor a(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.i;
        if (filterQueryProvider != null) {
            return filterQueryProvider.runQuery(charSequence);
        }
        return this.c;
    }

    public Filter getFilter() {
        if (this.h == null) {
            this.h = new b(this);
        }
        return this.h;
    }

    /* access modifiers changed from: protected */
    public void b() {
        Cursor cursor;
        if (this.f476b && (cursor = this.c) != null && !cursor.isClosed()) {
            this.f475a = this.c.requery();
        }
    }

    /* renamed from: androidx.b.a.a$a  reason: collision with other inner class name */
    /* compiled from: CursorAdapter */
    private class C0010a extends ContentObserver {
        public boolean deliverSelfNotifications() {
            return true;
        }

        C0010a() {
            super(new Handler());
        }

        public void onChange(boolean z) {
            a.this.b();
        }
    }

    /* compiled from: CursorAdapter */
    private class b extends DataSetObserver {
        b() {
        }

        public void onChanged() {
            a aVar = a.this;
            aVar.f475a = true;
            aVar.notifyDataSetChanged();
        }

        public void onInvalidated() {
            a aVar = a.this;
            aVar.f475a = false;
            aVar.notifyDataSetInvalidated();
        }
    }
}
