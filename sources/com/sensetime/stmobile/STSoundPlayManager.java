package com.sensetime.stmobile;

import android.content.Context;
import android.media.MediaPlayer;
import com.oppo.camera.e;
import com.oppo.camera.q.a;
import com.sensetime.stmobile.STSoundPlay;
import java.io.File;
import java.util.HashMap;

public class STSoundPlayManager {
    private static final String CACHED_FOLDER = "Audio";
    private static final String TAG = "STSoundPlayManager";
    /* access modifiers changed from: private */
    public String mCachedPath;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (STSoundPlayManager.this.mMediaPlayer == null) {
                e.e(STSoundPlayManager.TAG, "onCompletion err, mMediaPlayer: " + STSoundPlayManager.this.mMediaPlayer);
                return;
            }
            try {
                SoundMetaData soundMetaData = (SoundMetaData) STSoundPlayManager.this.mSoundMetaDataMap.get(STSoundPlayManager.this.mCurrentPlaying);
                if (soundMetaData != null) {
                    int i = soundMetaData.loop - 1;
                    soundMetaData.loop = i;
                    if (i > 0) {
                        e.a(STSoundPlayManager.TAG, "onCompletion, loop: " + soundMetaData.loop);
                        STSoundPlayManager.this.mMediaPlayer.start();
                        return;
                    }
                }
                e.a(STSoundPlayManager.TAG, "onCompletion, play done");
                if (!(soundMetaData == null || STSoundPlay.getInstance() == null)) {
                    STSoundPlay.getInstance().setSoundPlayDone(soundMetaData.name);
                }
                STSoundPlayManager.this.mMediaPlayer.stop();
                STSoundPlayManager.this.mMediaPlayer.reset();
            } catch (Exception e) {
                e.d(STSoundPlayManager.TAG, "onCompletion err", e);
            }
        }
    };
    private Context mContext;
    /* access modifiers changed from: private */
    public String mCurrentPlaying;
    private MediaPlayer.OnErrorListener mErrorListener = new MediaPlayer.OnErrorListener() {
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            e.e(STSoundPlayManager.TAG, "MediaPlayer what: " + i + ", extra: " + i2);
            return true;
        }
    };
    /* access modifiers changed from: private */
    public MediaPlayer mMediaPlayer;
    private MyPlayControlListener mPlayControlDefaultListener;
    /* access modifiers changed from: private */
    public HashMap<String, SoundMetaData> mSoundMetaDataMap = new HashMap<>();
    /* access modifiers changed from: private */
    public String mSoundName;

    private static class SoundMetaData {
        String cachePath;
        int loop;
        String name;

        private SoundMetaData() {
        }
    }

    public STSoundPlayManager(Context context) {
        this.mContext = context.getApplicationContext();
        this.mCachedPath = this.mContext.getFilesDir().getAbsolutePath() + File.separator + CACHED_FOLDER;
        if (!new File(this.mCachedPath).exists()) {
            a.f(this.mCachedPath);
        }
        if (this.mPlayControlDefaultListener == null) {
            this.mPlayControlDefaultListener = new MyPlayControlListener();
        }
        if (STSoundPlay.getInstance() != null) {
            STSoundPlay.getInstance().setPlayControlListener(this.mPlayControlDefaultListener);
        }
        initMediaPlayer();
    }

    public void release() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.mMediaPlayer.reset();
            }
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
    }

    public void setPauseState(boolean z) {
        MyPlayControlListener myPlayControlListener = this.mPlayControlDefaultListener;
        if (myPlayControlListener != null) {
            myPlayControlListener.setPauseState(z);
        }
    }

    private void initMediaPlayer() {
        this.mMediaPlayer = new MediaPlayer();
        this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
        this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
        this.mMediaPlayer.reset();
    }

    public class MyPlayControlListener implements STSoundPlay.PlayControlListener {
        private boolean mbPause = false;

        public MyPlayControlListener() {
        }

        public void setPauseState(boolean z) {
            this.mbPause = z;
        }

        public void onSoundLoaded(String str, byte[] bArr) {
            e.a(STSoundPlayManager.TAG, "onSoundLoaded, name: " + str);
            if (str != null) {
                String access$300 = STSoundPlayManager.this.saveSoundToFile(str, bArr);
                if (access$300 != null) {
                    SoundMetaData soundMetaData = (SoundMetaData) STSoundPlayManager.this.mSoundMetaDataMap.get(str);
                    if (soundMetaData == null) {
                        soundMetaData = new SoundMetaData();
                    }
                    soundMetaData.cachePath = access$300;
                    soundMetaData.name = str;
                    STSoundPlayManager.this.mSoundMetaDataMap.put(str, soundMetaData);
                    return;
                }
                e.e(STSoundPlayManager.TAG, "onSoundLoaded, SoundFilePath is null");
            }
        }

        public void onStartPlay(String str, int i) {
            e.a(STSoundPlayManager.TAG, "onStartPlay, name: " + str + ", loop: " + i);
            String unused = STSoundPlayManager.this.mSoundName = str;
            SoundMetaData soundMetaData = (SoundMetaData) STSoundPlayManager.this.mSoundMetaDataMap.get(str);
            if (soundMetaData == null || STSoundPlayManager.this.mMediaPlayer == null) {
                e.e(STSoundPlayManager.TAG, "onStartPlay, data: " + soundMetaData + ", mMediaPlayer: " + STSoundPlayManager.this.mMediaPlayer);
                return;
            }
            soundMetaData.loop = i;
            if (STSoundPlayManager.this.mMediaPlayer.isPlaying()) {
                STSoundPlayManager.this.mMediaPlayer.reset();
            }
            try {
                MediaPlayer access$000 = STSoundPlayManager.this.mMediaPlayer;
                access$000.setDataSource(STSoundPlayManager.this.mCachedPath + File.separator + str);
                STSoundPlayManager.this.mMediaPlayer.prepare();
            } catch (Exception e) {
                e.d(STSoundPlayManager.TAG, "onStartPlay err: " + e.toString(), e);
            }
            String unused2 = STSoundPlayManager.this.mCurrentPlaying = str;
            if (i == 0) {
                STSoundPlayManager.this.mMediaPlayer.setLooping(true);
            }
            if (!this.mbPause) {
                STSoundPlayManager.this.mMediaPlayer.start();
            }
        }

        public void onStopPlay(String str) {
            e.a(STSoundPlayManager.TAG, "onStopPlay, name:  " + str);
            STSoundPlayManager.this.clearSoundCache();
            if (STSoundPlayManager.this.mMediaPlayer != null) {
                STSoundPlayManager.this.mMediaPlayer.reset();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        r2 = r5;
        r5 = r4;
        r4 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String saveSoundToFile(java.lang.String r4, byte[] r5) {
        /*
            r3 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r3.mCachedPath
            r0.<init>(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r0 = r0.getPath()
            r1.append(r0)
            java.lang.String r0 = java.io.File.separator
            r1.append(r0)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0 = 0
            java.lang.String r1 = com.oppo.camera.q.a.i     // Catch:{ Exception -> 0x0051 }
            java.io.OutputStream r1 = com.oppo.camera.q.a.a((java.lang.String) r4, (java.lang.String) r1)     // Catch:{ Exception -> 0x0051 }
            if (r1 == 0) goto L_0x004b
            r1.write(r5)     // Catch:{ Throwable -> 0x0034, all -> 0x0031 }
            if (r1 == 0) goto L_0x0030
            r1.close()     // Catch:{ Exception -> 0x0051 }
        L_0x0030:
            return r4
        L_0x0031:
            r4 = move-exception
            r5 = r0
            goto L_0x003a
        L_0x0034:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0036 }
        L_0x0036:
            r5 = move-exception
            r2 = r5
            r5 = r4
            r4 = r2
        L_0x003a:
            if (r1 == 0) goto L_0x004a
            if (r5 == 0) goto L_0x0047
            r1.close()     // Catch:{ Throwable -> 0x0042 }
            goto L_0x004a
        L_0x0042:
            r1 = move-exception
            r5.addSuppressed(r1)     // Catch:{ Exception -> 0x0051 }
            goto L_0x004a
        L_0x0047:
            r1.close()     // Catch:{ Exception -> 0x0051 }
        L_0x004a:
            throw r4     // Catch:{ Exception -> 0x0051 }
        L_0x004b:
            if (r1 == 0) goto L_0x0050
            r1.close()     // Catch:{ Exception -> 0x0051 }
        L_0x0050:
            return r0
        L_0x0051:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r1 = "saveSoundToFile, write file failed: "
            r5.append(r1)
            java.lang.String r1 = r4.toString()
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            java.lang.String r1 = "STSoundPlayManager"
            com.oppo.camera.e.d(r1, r5, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensetime.stmobile.STSoundPlayManager.saveSoundToFile(java.lang.String, byte[]):java.lang.String");
    }

    public void pauseSound() {
        MediaPlayer mediaPlayer;
        e.a(TAG, "pauseSound");
        if (this.mSoundMetaDataMap.get(this.mSoundName) != null && (mediaPlayer = this.mMediaPlayer) != null && mediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
        }
    }

    public void resumeSound() {
        e.a(TAG, "resumeSound");
        if (this.mSoundMetaDataMap.get(this.mSoundName) == null) {
            e.e(TAG, "No meta-data when Resume");
            return;
        }
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    /* access modifiers changed from: private */
    public void clearSoundCache() {
        HashMap<String, SoundMetaData> hashMap = this.mSoundMetaDataMap;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.mSoundName = null;
    }
}
