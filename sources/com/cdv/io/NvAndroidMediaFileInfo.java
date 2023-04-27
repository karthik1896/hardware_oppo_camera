package com.cdv.io;

public class NvAndroidMediaFileInfo {

    public static class MediaInfo {
        long audioStreamDurationUs = 0;
        int channelCount = 0;
        int frameRate = 0;
        boolean hasAudioStream = false;
        boolean hasVideoStream = false;
        int height = 0;
        String mime;
        int rotation = 0;
        int sampleRate = 0;
        long videoStreamDurationUs = 0;
        int width = 0;

        MediaInfo() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.cdv.io.NvAndroidMediaFileInfo.MediaInfo getMediaInfoFromFile(java.lang.String r10, android.content.Context r11, android.content.res.AssetManager r12) {
        /*
            java.lang.String r0 = "frame-rate"
            java.lang.String r1 = "rotation-degrees"
            r2 = 0
            android.media.MediaExtractor r9 = new android.media.MediaExtractor     // Catch:{ Exception -> 0x00e6, all -> 0x00e3 }
            r9.<init>()     // Catch:{ Exception -> 0x00e6, all -> 0x00e3 }
            if (r12 != 0) goto L_0x0037
            java.lang.String r12 = "content://"
            boolean r12 = r10.startsWith(r12)     // Catch:{ Exception -> 0x00e1 }
            if (r12 == 0) goto L_0x0033
            if (r11 != 0) goto L_0x001a
            r9.release()
            return r2
        L_0x001a:
            android.content.ContentResolver r11 = r11.getContentResolver()     // Catch:{ Exception -> 0x00e1 }
            android.net.Uri r10 = android.net.Uri.parse(r10)     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r12 = "r"
            android.os.ParcelFileDescriptor r10 = r11.openFileDescriptor(r10, r12)     // Catch:{ Exception -> 0x00e1 }
            java.io.FileDescriptor r11 = r10.getFileDescriptor()     // Catch:{ Exception -> 0x00e1 }
            r9.setDataSource(r11)     // Catch:{ Exception -> 0x00e1 }
            r10.close()     // Catch:{ Exception -> 0x00e1 }
            goto L_0x004e
        L_0x0033:
            r9.setDataSource(r10)     // Catch:{ Exception -> 0x00e1 }
            goto L_0x004e
        L_0x0037:
            android.content.res.AssetFileDescriptor r10 = r12.openFd(r10)     // Catch:{ Exception -> 0x00e1 }
            java.io.FileDescriptor r4 = r10.getFileDescriptor()     // Catch:{ Exception -> 0x00e1 }
            long r5 = r10.getStartOffset()     // Catch:{ Exception -> 0x00e1 }
            long r7 = r10.getLength()     // Catch:{ Exception -> 0x00e1 }
            r3 = r9
            r3.setDataSource(r4, r5, r7)     // Catch:{ Exception -> 0x00e1 }
            r10.close()     // Catch:{ Exception -> 0x00e1 }
        L_0x004e:
            int r10 = r9.getTrackCount()     // Catch:{ Exception -> 0x00e1 }
            r11 = 0
            r12 = -1
            r3 = r12
        L_0x0055:
            java.lang.String r4 = "mime"
            if (r11 >= r10) goto L_0x007b
            android.media.MediaFormat r5 = r9.getTrackFormat(r11)     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ Exception -> 0x00e1 }
            if (r12 >= 0) goto L_0x006d
            java.lang.String r5 = "video/"
            boolean r5 = r4.startsWith(r5)     // Catch:{ Exception -> 0x00e1 }
            if (r5 == 0) goto L_0x006d
            r12 = r11
            goto L_0x0078
        L_0x006d:
            if (r3 >= 0) goto L_0x0078
            java.lang.String r5 = "audio/"
            boolean r4 = r4.startsWith(r5)     // Catch:{ Exception -> 0x00e1 }
            if (r4 == 0) goto L_0x0078
            r3 = r11
        L_0x0078:
            int r11 = r11 + 1
            goto L_0x0055
        L_0x007b:
            com.cdv.io.NvAndroidMediaFileInfo$MediaInfo r10 = new com.cdv.io.NvAndroidMediaFileInfo$MediaInfo     // Catch:{ Exception -> 0x00e1 }
            r10.<init>()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r11 = "durationUs"
            r5 = 1
            if (r12 < 0) goto L_0x00bf
            android.media.MediaFormat r12 = r9.getTrackFormat(r12)     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r4 = r12.getString(r4)     // Catch:{ Exception -> 0x00e1 }
            r10.mime = r4     // Catch:{ Exception -> 0x00e1 }
            long r6 = r12.getLong(r11)     // Catch:{ Exception -> 0x00e1 }
            r10.videoStreamDurationUs = r6     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r4 = "width"
            int r4 = r12.getInteger(r4)     // Catch:{ Exception -> 0x00e1 }
            r10.width = r4     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r4 = "height"
            int r4 = r12.getInteger(r4)     // Catch:{ Exception -> 0x00e1 }
            r10.height = r4     // Catch:{ Exception -> 0x00e1 }
            boolean r4 = r12.containsKey(r1)     // Catch:{ Exception -> 0x00e1 }
            if (r4 == 0) goto L_0x00b1
            int r1 = r12.getInteger(r1)     // Catch:{ Exception -> 0x00e1 }
            r10.rotation = r1     // Catch:{ Exception -> 0x00e1 }
        L_0x00b1:
            boolean r1 = r12.containsKey(r0)     // Catch:{ Exception -> 0x00e1 }
            if (r1 == 0) goto L_0x00bd
            int r12 = r12.getInteger(r0)     // Catch:{ Exception -> 0x00e1 }
            r10.frameRate = r12     // Catch:{ Exception -> 0x00e1 }
        L_0x00bd:
            r10.hasVideoStream = r5     // Catch:{ Exception -> 0x00e1 }
        L_0x00bf:
            if (r3 < 0) goto L_0x00dd
            android.media.MediaFormat r12 = r9.getTrackFormat(r3)     // Catch:{ Exception -> 0x00e1 }
            long r0 = r12.getLong(r11)     // Catch:{ Exception -> 0x00e1 }
            r10.audioStreamDurationUs = r0     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r11 = "channel-count"
            int r11 = r12.getInteger(r11)     // Catch:{ Exception -> 0x00e1 }
            r10.channelCount = r11     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r11 = "sample-rate"
            int r11 = r12.getInteger(r11)     // Catch:{ Exception -> 0x00e1 }
            r10.sampleRate = r11     // Catch:{ Exception -> 0x00e1 }
            r10.hasAudioStream = r5     // Catch:{ Exception -> 0x00e1 }
        L_0x00dd:
            r9.release()
            return r10
        L_0x00e1:
            r10 = move-exception
            goto L_0x00e8
        L_0x00e3:
            r10 = move-exception
            r9 = r2
            goto L_0x00f2
        L_0x00e6:
            r10 = move-exception
            r9 = r2
        L_0x00e8:
            r10.printStackTrace()     // Catch:{ all -> 0x00f1 }
            if (r9 == 0) goto L_0x00f0
            r9.release()
        L_0x00f0:
            return r2
        L_0x00f1:
            r10 = move-exception
        L_0x00f2:
            if (r9 == 0) goto L_0x00f7
            r9.release()
        L_0x00f7:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cdv.io.NvAndroidMediaFileInfo.getMediaInfoFromFile(java.lang.String, android.content.Context, android.content.res.AssetManager):com.cdv.io.NvAndroidMediaFileInfo$MediaInfo");
    }
}
