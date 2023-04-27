package com.oppo.camera.m;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ParcelFileDescriptor;
import androidx.c.d;
import com.oplus.media.OplusHeifWriter;
import com.oppo.camera.e;
import com.oppo.exif.OppoExifInterface;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/* compiled from: HeicProcessor */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private HandlerThread f3441a = null;

    /* renamed from: b  reason: collision with root package name */
    private Handler f3442b = null;
    private ParcelFileDescriptor c = null;

    public b(boolean z) {
        e.b("HeicProcessor", "HeicProcessor constructor, is8bits: " + z);
        if (z) {
            this.f3441a = new HandlerThread("HeifThread", -2);
            this.f3441a.start();
            this.f3442b = new Handler(this.f3441a.getLooper());
        }
    }

    private byte[] a(OppoExifInterface oppoExifInterface) {
        if (oppoExifInterface == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            OutputStream exifWriterStream = oppoExifInterface.getExifWriterStream((OutputStream) byteArrayOutputStream);
            byte[] bArr = new byte[2];
            Arrays.fill(bArr, (byte) 0);
            bArr[0] = -1;
            bArr[1] = -40;
            oppoExifInterface.writeExif(bArr, exifWriterStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.e("HeicProcessor", "exif io exception:" + e.toString());
            return null;
        }
    }

    public void a(Bitmap bitmap, int i, int i2, OppoExifInterface oppoExifInterface, ContentResolver contentResolver, Uri uri) {
        long currentTimeMillis = System.currentTimeMillis();
        a(bitmap, bitmap.getWidth(), bitmap.getHeight(), i, i2, oppoExifInterface, contentResolver, uri);
        e.b("HeicProcessor", "process, use bitmap, end, costTime: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* JADX INFO: finally extract failed */
    public void a(byte[] bArr, OppoExifInterface oppoExifInterface, int i, int i2, int i3, int i4, int i5, int i6, int i7, ContentResolver contentResolver, Uri uri) {
        byte[] bArr2 = bArr;
        ContentResolver contentResolver2 = contentResolver;
        Uri uri2 = uri;
        if (bArr2 == null || contentResolver2 == null || uri2 == null) {
            e.e("HeicProcessor", "process error, resolver: " + contentResolver2 + ", uri: " + uri2 + ", heicData: " + bArr2);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        FileDescriptor a2 = a(contentResolver2, uri2);
        byte[] a3 = a(oppoExifInterface);
        byte[] copyOfRange = Arrays.copyOfRange(a3, 6, a3.length);
        try {
            OplusHeifWriter oplusHeifWriter = new OplusHeifWriter();
            oplusHeifWriter.createPrimaryImage(i, i2, i3, i4, i5, i6, i7);
            oplusHeifWriter.processPrimaryImage(bArr2, copyOfRange, a2);
            a(this.c);
            this.c = null;
            e.b("HeicProcessor", "process, use heicData, end, costTime: " + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Throwable th) {
            a(this.c);
            this.c = null;
            throw th;
        }
    }

    private void a(Bitmap bitmap, int i, int i2, int i3, int i4, OppoExifInterface oppoExifInterface, ContentResolver contentResolver, Uri uri) {
        d dVar;
        e.b("HeicProcessor", "encodeHeicByBitmap started, bitmap: " + bitmap);
        if (contentResolver == null || uri == null) {
            e.e("HeicProcessor", "encodeHeicByBitmap error, resolver: " + contentResolver + ", uri: " + uri);
            return;
        }
        try {
            dVar = new d.a(a(contentResolver, uri), i, i2, 2).a(i3).a(true).c(1).b(i4).d(0).a(this.f3442b).a();
        } catch (IOException e) {
            e.printStackTrace();
            dVar = null;
        }
        if (dVar == null) {
            a(this.c);
            this.c = null;
            return;
        }
        dVar.a();
        byte[] a2 = a(oppoExifInterface);
        if (a2 != null) {
            dVar.a(0, a2, 6, a2.length - 6);
        }
        dVar.a(bitmap);
        try {
            dVar.a(0);
        } catch (Exception e2) {
            e.d("HeicProcessor", "encodeHeicByBitmap, stop heifWriter error, heifWriter: " + dVar, e2);
        } catch (Throwable th) {
            dVar.close();
            a(this.c);
            this.c = null;
            throw th;
        }
        dVar.close();
        a(this.c);
        this.c = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.FileDescriptor a(android.content.ContentResolver r5, android.net.Uri r6) {
        /*
            r4 = this;
            java.lang.String r0 = "HeicProcessor"
            r1 = 0
            java.lang.String r2 = "rw"
            android.os.ParcelFileDescriptor r5 = r5.openFileDescriptor(r6, r2)     // Catch:{ Exception -> 0x0016 }
            r4.c = r5     // Catch:{ Exception -> 0x0016 }
            android.os.ParcelFileDescriptor r5 = r4.c     // Catch:{ Exception -> 0x0016 }
            if (r5 == 0) goto L_0x002b
            android.os.ParcelFileDescriptor r5 = r4.c     // Catch:{ Exception -> 0x0016 }
            java.io.FileDescriptor r5 = r5.getFileDescriptor()     // Catch:{ Exception -> 0x0016 }
            goto L_0x002c
        L_0x0016:
            r5 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getFileDescriptor, dup fd error, uri: "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            com.oppo.camera.e.d(r0, r2, r5)
        L_0x002b:
            r5 = r1
        L_0x002c:
            if (r5 == 0) goto L_0x0034
            boolean r2 = r5.valid()
            if (r2 != 0) goto L_0x0050
        L_0x0034:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r2 = "getFileDescriptor, fd error, uri: "
            r5.append(r2)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.oppo.camera.e.e(r0, r5)
            android.os.ParcelFileDescriptor r5 = r4.c
            r4.a((android.os.ParcelFileDescriptor) r5)
            r4.c = r1
            r5 = r1
        L_0x0050:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.m.b.a(android.content.ContentResolver, android.net.Uri):java.io.FileDescriptor");
    }

    public void a() {
        HandlerThread handlerThread = this.f3441a;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            try {
                this.f3441a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void a(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e) {
                e.d("HeicProcessor", "closeParcelFD, close parcelFD error, parcelFD: " + parcelFileDescriptor, e);
            }
        }
    }
}
