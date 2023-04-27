package androidx.core.f;

import android.util.Log;
import java.io.Writer;

/* compiled from: LogWriter */
public class b extends Writer {

    /* renamed from: a  reason: collision with root package name */
    private final String f674a;

    /* renamed from: b  reason: collision with root package name */
    private StringBuilder f675b = new StringBuilder(128);

    public b(String str) {
        this.f674a = str;
    }

    public void close() {
        a();
    }

    public void flush() {
        a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == 10) {
                a();
            } else {
                this.f675b.append(c);
            }
        }
    }

    private void a() {
        if (this.f675b.length() > 0) {
            Log.d(this.f674a, this.f675b.toString());
            StringBuilder sb = this.f675b;
            sb.delete(0, sb.length());
        }
    }
}
