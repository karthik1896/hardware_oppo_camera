package androidx.room;

import android.content.Context;
import android.util.Log;
import androidx.f.a.b;
import androidx.f.a.c;
import androidx.room.b.a;
import androidx.room.b.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/* compiled from: SQLiteCopyOpenHelper */
class m implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1216a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1217b;
    private final File c;
    private final int d;
    private final c e;
    private a f;
    private boolean g;

    m(Context context, String str, File file, int i, c cVar) {
        this.f1216a = context;
        this.f1217b = str;
        this.c = file;
        this.d = i;
        this.e = cVar;
    }

    public String a() {
        return this.e.a();
    }

    public void a(boolean z) {
        this.e.a(z);
    }

    public synchronized b b() {
        if (!this.g) {
            c();
            this.g = true;
        }
        return this.e.b();
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f = aVar;
    }

    private void c() {
        String a2 = a();
        File databasePath = this.f1216a.getDatabasePath(a2);
        a aVar = this.f;
        a aVar2 = new a(a2, this.f1216a.getFilesDir(), aVar == null || aVar.j);
        try {
            aVar2.a();
            if (!databasePath.exists()) {
                a(databasePath);
                aVar2.b();
            } else if (this.f == null) {
                aVar2.b();
            } else {
                try {
                    int a3 = androidx.room.b.c.a(databasePath);
                    if (a3 == this.d) {
                        aVar2.b();
                    } else if (this.f.a(a3, this.d)) {
                        aVar2.b();
                    } else {
                        if (this.f1216a.deleteDatabase(a2)) {
                            try {
                                a(databasePath);
                            } catch (IOException e2) {
                                Log.w("ROOM", "Unable to copy database file.", e2);
                            }
                        } else {
                            Log.w("ROOM", "Failed to delete database file (" + a2 + ") for a copy destructive migration.");
                        }
                        aVar2.b();
                    }
                } catch (IOException e3) {
                    Log.w("ROOM", "Unable to read database version.", e3);
                    aVar2.b();
                }
            }
        } catch (IOException e4) {
            throw new RuntimeException("Unable to copy database file.", e4);
        } catch (Throwable th) {
            aVar2.b();
            throw th;
        }
    }

    private void a(File file) throws IOException {
        ReadableByteChannel readableByteChannel;
        if (this.f1217b != null) {
            readableByteChannel = Channels.newChannel(this.f1216a.getAssets().open(this.f1217b));
        } else {
            File file2 = this.c;
            if (file2 != null) {
                readableByteChannel = new FileInputStream(file2).getChannel();
            } else {
                throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
            }
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f1216a.getCacheDir());
        createTempFile.deleteOnExit();
        d.a(readableByteChannel, new FileOutputStream(createTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        } else if (!createTempFile.renameTo(file)) {
            throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
        }
    }
}
