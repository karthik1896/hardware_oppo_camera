package com.cdv.io;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import com.cdv.utils.NvAndroidUtils;
import com.sensetime.stmobile.sticker_module_types.STStickerFilterParamType;
import java.nio.ByteBuffer;

public class NvAndroidAudioFileReader {
    private static final int ERROR_EOF = 1;
    private static final int ERROR_FAIL = 2;
    private static final int ERROR_OK = 0;
    private static final String TAG = "NvAndroidAudioFileReader";
    private static final boolean m_verbose = false;
    private int m_audioTrackIndex;
    private MediaCodec.BufferInfo m_bufferInfo;
    private int m_channelCount;
    private MediaCodec m_decoder;
    ByteBuffer[] m_decoderInputBuffers;
    ByteBuffer[] m_decoderOutputBuffers;
    private boolean m_decoderSetupFailed;
    private boolean m_decoderStarted;
    private long m_duration;
    private MediaExtractor m_extractor;
    private MediaFormat m_format;
    private boolean m_inputBufferQueued;
    private int m_pcmEncoding;
    private int m_pendingInputFrameCount;
    private int m_sampleRate;
    private boolean m_sawInputEOS;
    private boolean m_sawOutputEOS;

    public static class AudioFrame {
        ByteBuffer audioFrame;
        int channelCount;
        long pts;
        int retCode;
        int sampleCount;
        int sampleRate;
        int sampleSize;
    }

    NvAndroidAudioFileReader() {
        this.m_extractor = null;
        this.m_audioTrackIndex = -1;
        this.m_format = null;
        this.m_duration = 0;
        this.m_channelCount = 1;
        this.m_sampleRate = 44100;
        this.m_pcmEncoding = 2;
        this.m_bufferInfo = null;
        this.m_decoder = null;
        this.m_decoderSetupFailed = false;
        this.m_decoderStarted = false;
        this.m_decoderInputBuffers = null;
        this.m_decoderOutputBuffers = null;
        this.m_inputBufferQueued = false;
        this.m_pendingInputFrameCount = 0;
        this.m_sawInputEOS = false;
        this.m_sawOutputEOS = false;
        this.m_bufferInfo = new MediaCodec.BufferInfo();
    }

    public boolean openFile(String str, Context context) {
        if (isValid()) {
            Log.e(TAG, "You can't call OpenFile() twice!");
            return false;
        }
        this.m_extractor = NvAndroidUtils.createMediaExtractorFromMediaFilePath(context, str);
        MediaExtractor mediaExtractor = this.m_extractor;
        if (mediaExtractor == null) {
            return false;
        }
        int trackCount = mediaExtractor.getTrackCount();
        int i = 0;
        while (true) {
            if (i >= trackCount) {
                break;
            } else if (this.m_extractor.getTrackFormat(i).getString("mime").startsWith("audio/")) {
                this.m_audioTrackIndex = i;
                break;
            } else {
                i++;
            }
        }
        int i2 = this.m_audioTrackIndex;
        if (i2 < 0) {
            Log.e(TAG, "Failed to find a audio track from " + str);
            closeFile();
            return false;
        }
        this.m_extractor.selectTrack(i2);
        this.m_format = this.m_extractor.getTrackFormat(this.m_audioTrackIndex);
        int i3 = Build.VERSION.SDK_INT;
        this.m_duration = this.m_format.getLong("durationUs");
        String string = this.m_format.getString("mime");
        this.m_decoderSetupFailed = false;
        if (setupDecoder(string)) {
            return true;
        }
        this.m_decoderSetupFailed = true;
        closeFile();
        return false;
    }

    public boolean hasDecoderSetupFailed() {
        return this.m_decoderSetupFailed;
    }

    public void closeFile() {
        cleanupDecoder();
        MediaExtractor mediaExtractor = this.m_extractor;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.m_extractor = null;
            this.m_audioTrackIndex = -1;
            this.m_format = null;
            this.m_duration = 0;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:15|16|17|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int startPlayback(long r5) {
        /*
            r4 = this;
            boolean r0 = r4.isValid()
            r1 = 1
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            r2 = 0
            long r5 = java.lang.Math.max(r5, r2)
            long r2 = r4.m_duration
            int r0 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x0015
            return r1
        L_0x0015:
            r0 = 2
            android.media.MediaExtractor r1 = r4.m_extractor     // Catch:{ Exception -> 0x0046 }
            r2 = 0
            r1.seekTo(r5, r2)     // Catch:{ Exception -> 0x0046 }
            boolean r5 = r4.m_sawInputEOS     // Catch:{ Exception -> 0x0046 }
            if (r5 != 0) goto L_0x0033
            boolean r5 = r4.m_sawOutputEOS     // Catch:{ Exception -> 0x0046 }
            if (r5 == 0) goto L_0x0025
            goto L_0x0033
        L_0x0025:
            boolean r5 = r4.m_inputBufferQueued     // Catch:{ Exception -> 0x0046 }
            if (r5 == 0) goto L_0x0045
            android.media.MediaCodec r5 = r4.m_decoder     // Catch:{ Exception -> 0x002e }
            r5.flush()     // Catch:{ Exception -> 0x002e }
        L_0x002e:
            r4.m_inputBufferQueued = r2     // Catch:{ Exception -> 0x0046 }
            r4.m_pendingInputFrameCount = r2     // Catch:{ Exception -> 0x0046 }
            goto L_0x0045
        L_0x0033:
            r4.cleanupDecoder()     // Catch:{ Exception -> 0x0046 }
            android.media.MediaFormat r5 = r4.m_format     // Catch:{ Exception -> 0x0046 }
            java.lang.String r6 = "mime"
            java.lang.String r5 = r5.getString(r6)     // Catch:{ Exception -> 0x0046 }
            boolean r5 = r4.setupDecoder(r5)     // Catch:{ Exception -> 0x0046 }
            if (r5 != 0) goto L_0x0045
            return r0
        L_0x0045:
            return r2
        L_0x0046:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = ""
            r6.append(r1)
            java.lang.String r1 = r5.getMessage()
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            java.lang.String r1 = "NvAndroidAudioFileReader"
            android.util.Log.e(r1, r6)
            r5.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cdv.io.NvAndroidAudioFileReader.startPlayback(long):int");
    }

    public AudioFrame getNextAudioFrameForPlayback() {
        if (!isValid()) {
            AudioFrame audioFrame = new AudioFrame();
            audioFrame.retCode = 1;
            return audioFrame;
        }
        try {
            return decodeNextFrame();
        } catch (Exception e) {
            Log.e(TAG, "" + e.getMessage());
            e.printStackTrace();
            cleanupDecoder();
            return null;
        }
    }

    private boolean isValid() {
        return this.m_decoder != null;
    }

    private boolean setupDecoder(String str) {
        try {
            this.m_decoder = MediaCodec.createDecoderByType(str);
            this.m_decoder.configure(this.m_format, (Surface) null, (MediaCrypto) null, 0);
            this.m_decoder.start();
            this.m_decoderStarted = true;
            this.m_decoderInputBuffers = this.m_decoder.getInputBuffers();
            this.m_decoderOutputBuffers = this.m_decoder.getOutputBuffers();
            return true;
        } catch (Exception e) {
            Log.e(TAG, "" + e.getMessage());
            e.printStackTrace();
            cleanupDecoder();
            return false;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cleanupDecoder() {
        /*
            r5 = this;
            android.media.MediaCodec r0 = r5.m_decoder
            r1 = 0
            if (r0 == 0) goto L_0x0042
            boolean r2 = r5.m_decoderStarted
            r3 = 0
            if (r2 == 0) goto L_0x003b
            boolean r2 = r5.m_inputBufferQueued     // Catch:{ Exception -> 0x0019 }
            if (r2 == 0) goto L_0x0013
            r0.flush()     // Catch:{ Exception -> 0x0011 }
        L_0x0011:
            r5.m_inputBufferQueued = r1     // Catch:{ Exception -> 0x0019 }
        L_0x0013:
            android.media.MediaCodec r0 = r5.m_decoder     // Catch:{ Exception -> 0x0019 }
            r0.stop()     // Catch:{ Exception -> 0x0019 }
            goto L_0x0037
        L_0x0019:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = ""
            r2.append(r4)
            java.lang.String r4 = r0.getMessage()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "NvAndroidAudioFileReader"
            android.util.Log.e(r4, r2)
            r0.printStackTrace()
        L_0x0037:
            r5.m_decoderStarted = r1
            r5.m_decoderInputBuffers = r3
        L_0x003b:
            android.media.MediaCodec r0 = r5.m_decoder
            r0.release()
            r5.m_decoder = r3
        L_0x0042:
            r5.m_pendingInputFrameCount = r1
            r5.m_sawInputEOS = r1
            r5.m_sawOutputEOS = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cdv.io.NvAndroidAudioFileReader.cleanupDecoder():void");
    }

    private AudioFrame decodeNextFrame() {
        int dequeueInputBuffer;
        int max = Math.max(this.m_decoderInputBuffers.length / 3, 2);
        AudioFrame audioFrame = new AudioFrame();
        int i = 0;
        while (true) {
            boolean z = true;
            if (!this.m_sawOutputEOS) {
                if (!this.m_sawInputEOS && (dequeueInputBuffer = this.m_decoder.dequeueInputBuffer(500)) >= 0) {
                    int readSampleData = this.m_extractor.readSampleData(this.m_decoderInputBuffers[dequeueInputBuffer], 0);
                    if (readSampleData < 0) {
                        this.m_decoder.queueInputBuffer(dequeueInputBuffer, 0, 0, 0, 4);
                        this.m_sawInputEOS = true;
                    } else {
                        if (this.m_extractor.getSampleTrackIndex() != this.m_audioTrackIndex) {
                            Log.w(TAG, "WEIRD: got sample from track " + this.m_extractor.getSampleTrackIndex() + ", expected " + this.m_audioTrackIndex);
                        }
                        this.m_decoder.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, this.m_extractor.getSampleTime(), 0);
                        this.m_inputBufferQueued = true;
                        this.m_pendingInputFrameCount++;
                        this.m_extractor.advance();
                    }
                }
                int dequeueOutputBuffer = this.m_decoder.dequeueOutputBuffer(this.m_bufferInfo, (long) ((this.m_pendingInputFrameCount > max || this.m_sawInputEOS) ? STStickerFilterParamType.ST_STICKER_PARAM_FILTER_FLOAT_STRENGTH : 0));
                int i2 = i + 1;
                if (dequeueOutputBuffer != -1) {
                    if (dequeueOutputBuffer == -3) {
                        this.m_decoderOutputBuffers = this.m_decoder.getOutputBuffers();
                    } else if (dequeueOutputBuffer == -2) {
                        parseMediaFormat(this.m_decoder.getOutputFormat());
                    } else if (dequeueOutputBuffer < 0) {
                        Log.e(TAG, "Unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                        return null;
                    } else {
                        if ((this.m_bufferInfo.flags & 4) != 0) {
                            this.m_sawOutputEOS = true;
                        } else {
                            this.m_pendingInputFrameCount--;
                        }
                        if (this.m_bufferInfo.size == 0) {
                            z = false;
                        }
                        if (z) {
                            audioFrame.channelCount = this.m_channelCount;
                            audioFrame.sampleRate = this.m_sampleRate;
                            audioFrame.sampleSize = 16;
                            int i3 = this.m_pcmEncoding;
                            if (i3 == 3) {
                                audioFrame.sampleSize = 8;
                            } else if (i3 == 4) {
                                audioFrame.sampleSize = 32;
                            }
                            audioFrame.sampleCount = this.m_bufferInfo.size / ((audioFrame.sampleSize / 8) * audioFrame.channelCount);
                            try {
                                ByteBuffer byteBuffer = this.m_decoderOutputBuffers[dequeueOutputBuffer];
                                byteBuffer.position(0);
                                byteBuffer.limit(this.m_bufferInfo.size);
                                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.m_bufferInfo.size);
                                allocateDirect.put(byteBuffer);
                                audioFrame.audioFrame = allocateDirect;
                                audioFrame.pts = this.m_bufferInfo.presentationTimeUs;
                                audioFrame.retCode = 0;
                            } catch (Exception e) {
                                e.printStackTrace();
                                audioFrame.retCode = 2;
                                z = false;
                            }
                        }
                        this.m_decoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if (z) {
                            return audioFrame;
                        }
                    }
                }
                if (i2 > 100) {
                    Log.e(TAG, "We have tried too many times and can't decode a frame!");
                    return null;
                }
                i = i2;
            } else {
                audioFrame.retCode = 1;
                return audioFrame;
            }
        }
    }

    private void parseMediaFormat(MediaFormat mediaFormat) {
        if (mediaFormat.containsKey("channel-count")) {
            this.m_channelCount = mediaFormat.getInteger("channel-count");
        }
        if (mediaFormat.containsKey("sample-rate")) {
            this.m_sampleRate = mediaFormat.getInteger("sample-rate");
        }
        if (mediaFormat.containsKey("pcm-encoding")) {
            this.m_pcmEncoding = mediaFormat.getInteger("pcm-encoding");
        }
    }
}
