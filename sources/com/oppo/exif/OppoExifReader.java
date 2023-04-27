package com.oppo.exif;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

class OppoExifReader {
    private static final String TAG = "ExifReader";
    private final OppoExifInterface mInterface;

    OppoExifReader(OppoExifInterface oppoExifInterface) {
        this.mInterface = oppoExifInterface;
    }

    /* access modifiers changed from: protected */
    public OppoExifData read(InputStream inputStream) throws OppoExifInvalidFormatException, IOException {
        OppoExifParser parse = OppoExifParser.parse(inputStream, this.mInterface);
        OppoExifData oppoExifData = new OppoExifData(parse.getByteOrder());
        for (int next = parse.next(); next != 5; next = parse.next()) {
            if (next == 0) {
                oppoExifData.addIfdData(new OppoIfdData(parse.getCurrentIfd()));
            } else if (next == 1) {
                OppoExifTag tag = parse.getTag();
                if (!tag.hasValue()) {
                    parse.registerForTagValue(tag);
                } else {
                    oppoExifData.getIfdData(tag.getIfd()).setTag(tag);
                }
            } else if (next == 2) {
                OppoExifTag tag2 = parse.getTag();
                if (tag2.getDataType() == 7) {
                    parse.readFullTagValue(tag2);
                }
                oppoExifData.getIfdData(tag2.getIfd()).setTag(tag2);
            } else if (next == 3) {
                byte[] bArr = new byte[parse.getCompressedImageSize()];
                if (bArr.length == parse.read(bArr)) {
                    oppoExifData.setCompressedThumbnail(bArr);
                } else {
                    Log.w(TAG, "Failed to read the compressed thumbnail");
                }
            } else if (next == 4) {
                byte[] bArr2 = new byte[parse.getStripSize()];
                if (bArr2.length == parse.read(bArr2)) {
                    oppoExifData.setStripBytes(parse.getStripIndex(), bArr2);
                } else {
                    Log.w(TAG, "Failed to read the strip bytes");
                }
            }
        }
        return oppoExifData;
    }
}
