package color.support.v7.app;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import androidx.b.a.a;
import color.support.v7.appcompat.R;
import com.color.support.widget.OppoCheckBox;
import java.util.HashSet;

/* compiled from: ChoiceListCursorAdapter */
class d extends a {
    private int j;
    private boolean k;
    private HashSet<Integer> l;
    private int m;
    private int n;
    private int o;
    private String p;
    private String q;
    private String r;

    public d(Context context, Cursor cursor, int i, String str, String str2) {
        this(context, cursor, i, str, (String) null, str2, false);
    }

    public d(Context context, Cursor cursor, int i, String str, String str2, String str3, boolean z) {
        this(context, cursor);
        this.k = z;
        this.p = str;
        this.r = str3;
        this.q = str2;
        this.j = i;
        this.l = new HashSet<>();
        this.m = cursor.getColumnIndexOrThrow(this.p);
        String str4 = this.r;
        if (str4 != null) {
            this.o = cursor.getColumnIndexOrThrow(str4);
        }
        if (z) {
            this.n = cursor.getColumnIndexOrThrow(this.q);
            if (cursor == null || !cursor.moveToFirst()) {
                cursor.moveToFirst();
            }
            do {
                if (cursor.getInt(this.n) == 1) {
                    this.l.add(Integer.valueOf(cursor.getPosition()));
                }
            } while (cursor.moveToNext());
            cursor.moveToFirst();
        }
    }

    public d(Context context, Cursor cursor) {
        super(context, cursor);
        this.k = false;
        this.n = 0;
    }

    public View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(this.j, viewGroup, false);
    }

    public void a(View view, Context context, Cursor cursor) {
        TextView textView = (TextView) view.findViewById(16908308);
        TextView textView2 = (TextView) view.findViewById(R.id.summary_text2);
        int i = this.l.contains(Integer.valueOf(cursor.getPosition())) ? 2 : 0;
        if (this.k) {
            ((OppoCheckBox) view.findViewById(R.id.checkbox)).setState(i);
        }
        textView.setText(cursor.getString(this.m));
        if (this.r == null) {
            textView2.setVisibility(8);
            return;
        }
        textView2.setVisibility(0);
        textView2.setText(cursor.getString(this.o));
    }

    /* access modifiers changed from: package-private */
    public void a(int i, int i2, ListView listView) {
        int firstVisiblePosition = i2 - listView.getFirstVisiblePosition();
        if (firstVisiblePosition >= 0) {
            ((OppoCheckBox) listView.getChildAt(firstVisiblePosition).findViewById(R.id.checkbox)).setState(i);
            if (i == 2) {
                this.l.add(Integer.valueOf(i2));
            } else {
                this.l.remove(Integer.valueOf(i2));
            }
        }
    }
}
