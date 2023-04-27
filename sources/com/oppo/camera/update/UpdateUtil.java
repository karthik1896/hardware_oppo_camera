package com.oppo.camera.update;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.oppo.camera.aps.update.ApsUpdateParam;
import com.oppo.camera.e;
import com.oppo.camera.q.a;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UpdateUtil {
    public static final String APP_TO_UPDATE = "camera_update_app_operation";
    private static final String APP_UPDATE_TYPE_PREFERENCE_LATER = "update_sharePreference_later";
    private static final String APP_UPDATE_TYPE_PREFERENCE_NOW = "update_sharePreference_now";
    public static final String APS_TO_UPDATE = "apps_camera_update_aps_param";
    private static final String BACK_UP = "_BACK_UP";
    private static final String COLUMN_FIME_NAME = "filterName";
    private static final String COLUMN_MD5 = "md5";
    private static final String COLUMN_VERSION = "version";
    private static final String COLUMN_XML = "xml";
    private static final String EQUAL_TOKEN = "equal";
    public static final String FILE_NAME_TO_UPDATE = "camera_update_file_name";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_MD5 = "md5";
    private static final String KEY_UPDATE_STATE = "updateState";
    private static final String KEY_VERSION = "version";
    /* access modifiers changed from: private */
    public static final Object LOCK = new Object();
    private static final int MAX_FILE_NUM = 50;
    private static final int MAX_TRY_TIME = 3;
    private static final String NEED_UPDATE_TOKEN = "needUpdate";
    private static final String PREFIX_DRIVER = "hardware";
    private static final String PREFIX_EFFECT = "quality";
    private static final String SPLIT_TOKEN = "\n";
    private static final String TAG = "UpdateUtil";
    private static final String TARGET_FOLDER = (File.separator + "data" + File.separator + ".camera" + File.separator);
    private static final String UPDATED_TOKEN = "updated";
    private static final Uri UPDATE_URI = Uri.parse("content://com.nearme.romupdate.provider.db/update_list");
    private static final String VERSION = "_VERSION";
    private static UpdateUtil sUpdateUtil;
    private ArrayList<UpdateOperation> mAppLaterUpdateOperationList;
    private Context mContext;
    private Gson mGson;
    private int mNowTryTime = 0;
    private SharedPreferences mSharedPreferences;
    private ArrayList<UpdateOperation> mUpdateOperationList;

    public void onPause() {
    }

    private UpdateUtil(Context context) {
        this.mContext = context;
    }

    public static synchronized UpdateUtil getInstance(Context context) {
        UpdateUtil updateUtil;
        synchronized (UpdateUtil.class) {
            if (sUpdateUtil == null) {
                sUpdateUtil = new UpdateUtil(context.getApplicationContext());
            }
            updateUtil = sUpdateUtil;
        }
        return updateUtil;
    }

    public static synchronized void release() {
        synchronized (UpdateUtil.class) {
            sUpdateUtil = null;
        }
    }

    private void resetList() {
        ArrayList<UpdateOperation> arrayList = this.mUpdateOperationList;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<UpdateOperation> arrayList2 = this.mAppLaterUpdateOperationList;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
    }

    public void startUpdateAllPara() {
        startUpdate(true, true);
    }

    public void startUpdate(final boolean z, final boolean z2) {
        new Thread(new Runnable() {
            public void run() {
                synchronized (UpdateUtil.LOCK) {
                    if (z) {
                        UpdateUtil.this.startUpdateAppParameter();
                    }
                    if (z2) {
                        UpdateUtil.this.startUpdateApsParameter();
                    }
                }
            }
        }).start();
    }

    private boolean startUpdateDriverContent(String[] strArr) {
        boolean z = true;
        do {
            int i = this.mNowTryTime;
            if (i >= 3) {
                break;
            }
            this.mNowTryTime = i + 1;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                while (i2 < strArr.length && (z = startUpdateParameter(strArr[i2]))) {
                    i2++;
                }
            }
        } while (!z);
        return z;
    }

    private boolean deleteFile(File file) {
        if (!file.exists()) {
            return true;
        }
        return a.c(file.getAbsolutePath());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0083, code lost:
        if (r8 == null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0085, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0093, code lost:
        if (r8 == null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
        com.oppo.camera.e.a(TAG, "queryUpdateRomProvider, content: " + r1 + ", md5: " + r4 + ", version: " + r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00be, code lost:
        if (android.text.TextUtils.isEmpty(r1) != false) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c4, code lost:
        if (android.text.TextUtils.isEmpty(r4) != false) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c6, code lost:
        if (r14 > 0) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d2, code lost:
        if (r4.equals(com.oppo.camera.update.MD5Utils.getMD5(r1)) != false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d4, code lost:
        com.oppo.camera.e.a(TAG, "queryUpdateRomProvider, file damage");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d9, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00da, code lost:
        r0 = java.lang.Integer.parseInt(getSharedPreferences().getString(r0 + VERSION, "0"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00fd, code lost:
        if (r0 <= r14) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ff, code lost:
        com.oppo.camera.e.a(TAG, "queryUpdateRomProvider, do not need to update, nowVersion: " + r0 + ", version: " + r14);
        r2.put(KEY_UPDATE_STATE, UPDATED_TOKEN);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x011d, code lost:
        if (r0 != r14) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x011f, code lost:
        com.oppo.camera.e.a(TAG, "queryUpdateRomProvider, do not need to update, nowVersion: " + r0 + ", version: " + r14);
        r2.put(KEY_UPDATE_STATE, EQUAL_TOKEN);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x013d, code lost:
        r2.put(KEY_UPDATE_STATE, NEED_UPDATE_TOKEN);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0142, code lost:
        r2.put(KEY_CONTENT, r1);
        r2.put("md5", r4);
        r2.put(com.oppo.camera.statistics.CameraStatisticsUtil.RUS_FILE_VERSION, java.lang.String.valueOf(r14));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0151, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0152, code lost:
        com.oppo.camera.e.a(TAG, "queryUpdateRomProvider, content is not correct");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0157, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x015c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, java.lang.String> queryUpdateRomProvider(java.lang.String r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.String r1 = ""
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "queryUpdateRomProvider, fileName: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "UpdateUtil"
            com.oppo.camera.e.a(r3, r2)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r4 = "xml"
            java.lang.String r5 = "md5"
            java.lang.String r6 = "version"
            java.lang.String r7 = "filterName"
            java.lang.String[] r10 = new java.lang.String[]{r4, r7, r6, r5}
            r7 = 0
            r14 = 0
            r15 = r17
            android.content.Context r8 = r15.mContext     // Catch:{ Exception -> 0x008c, all -> 0x0089 }
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch:{ Exception -> 0x008c, all -> 0x0089 }
            android.net.Uri r9 = UPDATE_URI     // Catch:{ Exception -> 0x008c, all -> 0x0089 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008c, all -> 0x0089 }
            r11.<init>()     // Catch:{ Exception -> 0x008c, all -> 0x0089 }
            java.lang.String r12 = "filtername = \""
            r11.append(r12)     // Catch:{ Exception -> 0x008c, all -> 0x0089 }
            r11.append(r0)     // Catch:{ Exception -> 0x008c, all -> 0x0089 }
            java.lang.String r12 = "\""
            r11.append(r12)     // Catch:{ Exception -> 0x008c, all -> 0x0089 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x008c, all -> 0x0089 }
            r12 = 0
            r13 = 0
            android.database.Cursor r8 = r8.query(r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x008c, all -> 0x0089 }
            if (r8 == 0) goto L_0x0082
            boolean r9 = r8.moveToFirst()     // Catch:{ Exception -> 0x0080 }
            if (r9 == 0) goto L_0x0082
            int r4 = r8.getColumnIndex(r4)     // Catch:{ Exception -> 0x0080 }
            java.lang.String r4 = r8.getString(r4)     // Catch:{ Exception -> 0x0080 }
            int r9 = r8.getColumnIndex(r5)     // Catch:{ Exception -> 0x007a }
            java.lang.String r1 = r8.getString(r9)     // Catch:{ Exception -> 0x007a }
            int r9 = r8.getColumnIndex(r6)     // Catch:{ Exception -> 0x007a }
            int r9 = r8.getInt(r9)     // Catch:{ Exception -> 0x007a }
            r14 = r9
            r16 = r4
            r4 = r1
            r1 = r16
            goto L_0x0083
        L_0x007a:
            r16 = r4
            r4 = r1
            r1 = r16
            goto L_0x008e
        L_0x0080:
            r4 = r1
            goto L_0x008e
        L_0x0082:
            r4 = r1
        L_0x0083:
            if (r8 == 0) goto L_0x0096
        L_0x0085:
            r8.close()
            goto L_0x0096
        L_0x0089:
            r0 = move-exception
            goto L_0x015a
        L_0x008c:
            r4 = r1
            r8 = r7
        L_0x008e:
            java.lang.String r9 = "queryUpdateRomProvider, query uri err"
            com.oppo.camera.e.a(r3, r9)     // Catch:{ all -> 0x0158 }
            if (r8 == 0) goto L_0x0096
            goto L_0x0085
        L_0x0096:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "queryUpdateRomProvider, content: "
            r8.append(r9)
            r8.append(r1)
            java.lang.String r9 = ", md5: "
            r8.append(r9)
            r8.append(r4)
            java.lang.String r9 = ", version: "
            r8.append(r9)
            r8.append(r14)
            java.lang.String r8 = r8.toString()
            com.oppo.camera.e.a(r3, r8)
            boolean r8 = android.text.TextUtils.isEmpty(r1)
            if (r8 != 0) goto L_0x0152
            boolean r8 = android.text.TextUtils.isEmpty(r4)
            if (r8 != 0) goto L_0x0152
            if (r14 > 0) goto L_0x00ca
            goto L_0x0152
        L_0x00ca:
            java.lang.String r8 = com.oppo.camera.update.MD5Utils.getMD5(r1)
            boolean r8 = r4.equals(r8)
            if (r8 != 0) goto L_0x00da
            java.lang.String r0 = "queryUpdateRomProvider, file damage"
            com.oppo.camera.e.a(r3, r0)
            return r7
        L_0x00da:
            android.content.SharedPreferences r7 = r17.getSharedPreferences()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r0)
            java.lang.String r0 = "_VERSION"
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            java.lang.String r8 = "0"
            java.lang.String r0 = r7.getString(r0, r8)
            int r0 = java.lang.Integer.parseInt(r0)
            java.lang.String r7 = "queryUpdateRomProvider, do not need to update, nowVersion: "
            java.lang.String r8 = "updateState"
            if (r0 <= r14) goto L_0x011d
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r7)
            r10.append(r0)
            r10.append(r9)
            r10.append(r14)
            java.lang.String r0 = r10.toString()
            com.oppo.camera.e.a(r3, r0)
            java.lang.String r0 = "updated"
            r2.put(r8, r0)
            goto L_0x0142
        L_0x011d:
            if (r0 != r14) goto L_0x013d
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r7)
            r10.append(r0)
            r10.append(r9)
            r10.append(r14)
            java.lang.String r0 = r10.toString()
            com.oppo.camera.e.a(r3, r0)
            java.lang.String r0 = "equal"
            r2.put(r8, r0)
            goto L_0x0142
        L_0x013d:
            java.lang.String r0 = "needUpdate"
            r2.put(r8, r0)
        L_0x0142:
            java.lang.String r0 = "content"
            r2.put(r0, r1)
            r2.put(r5, r4)
            java.lang.String r0 = java.lang.String.valueOf(r14)
            r2.put(r6, r0)
            return r2
        L_0x0152:
            java.lang.String r0 = "queryUpdateRomProvider, content is not correct"
            com.oppo.camera.e.a(r3, r0)
            return r7
        L_0x0158:
            r0 = move-exception
            r7 = r8
        L_0x015a:
            if (r7 == 0) goto L_0x015f
            r7.close()
        L_0x015f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.update.UpdateUtil.queryUpdateRomProvider(java.lang.String):java.util.Map");
    }

    private SharedPreferences getSharedPreferences() {
        if (this.mSharedPreferences == null) {
            this.mSharedPreferences = this.mContext.getSharedPreferences("rom_update_info", 0);
        }
        return this.mSharedPreferences;
    }

    /* access modifiers changed from: private */
    public void startUpdateApsParameter() {
        Map<String, String> queryUpdateRomProvider = queryUpdateRomProvider(APS_TO_UPDATE);
        if (queryUpdateRomProvider != null) {
            e.a(TAG, "startUpdateApsParameter, content: " + queryUpdateRomProvider.get(KEY_CONTENT));
            if (NEED_UPDATE_TOKEN.equals(queryUpdateRomProvider.get(KEY_UPDATE_STATE))) {
                try {
                    ApsUpdateHelper.updateApsParamToFile(this.mContext, (ApsUpdateParam) new Gson().fromJson(queryUpdateRomProvider.get(KEY_CONTENT), ApsUpdateParam.class));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void startUpdateAppParameter() {
        resetList();
        Map<String, String> queryUpdateRomProvider = queryUpdateRomProvider(APP_TO_UPDATE);
        if (queryUpdateRomProvider != null) {
            e.a(TAG, "startUpdateAppParameter, content: " + queryUpdateRomProvider.get(KEY_CONTENT));
            if (NEED_UPDATE_TOKEN.equals(queryUpdateRomProvider.get(KEY_UPDATE_STATE)) && updateAppParameter(queryUpdateRomProvider.get(KEY_CONTENT))) {
                updateSharePreference("camera_update_app_operation_VERSION", queryUpdateRomProvider.get(CameraStatisticsUtil.RUS_FILE_VERSION));
            }
        }
    }

    private boolean startUpdateParameter(String str) {
        Map<String, String> queryUpdateRomProvider;
        e.a(TAG, "startUpdateParameter, fileName: " + str);
        if (!TextUtils.isEmpty(str) && (queryUpdateRomProvider = queryUpdateRomProvider(str)) != null) {
            e.a(TAG, "startUpdateParameter, content: " + queryUpdateRomProvider.get(KEY_CONTENT));
            if (str.contains(PREFIX_DRIVER) || str.contains(PREFIX_EFFECT)) {
                String str2 = TARGET_FOLDER + str;
                File file = new File(str2);
                if (!NEED_UPDATE_TOKEN.equals(queryUpdateRomProvider.get(KEY_UPDATE_STATE))) {
                    if (!file.exists()) {
                        writeContentToTargetFile(str2, queryUpdateRomProvider.get(KEY_CONTENT));
                        if (!queryUpdateRomProvider.get("md5").equals(MD5Utils.md5Sum(str2))) {
                            e.a(TAG, "startUpdateParameter, update fail");
                            deleteFile(file);
                            return false;
                        } else if (UPDATED_TOKEN.equals(queryUpdateRomProvider.get(KEY_UPDATE_STATE))) {
                            updateSharePreference(str + VERSION, queryUpdateRomProvider.get(CameraStatisticsUtil.RUS_FILE_VERSION));
                        }
                    }
                    return true;
                }
                File file2 = new File(str2 + BACK_UP);
                if (file.exists()) {
                    a.b(str2, str2 + BACK_UP);
                }
                writeContentToTargetFile(str2, queryUpdateRomProvider.get(KEY_CONTENT));
                if (!queryUpdateRomProvider.get("md5").equals(MD5Utils.md5Sum(str2))) {
                    e.a(TAG, "startUpdateParameter, update fail");
                    deleteFile(file);
                    File file3 = new File(str2);
                    if (file2.exists()) {
                        a.b(file2.getAbsolutePath(), file3.getAbsolutePath());
                    }
                    return false;
                }
                deleteFile(file2);
                updateSharePreference(str + VERSION, queryUpdateRomProvider.get(CameraStatisticsUtil.RUS_FILE_VERSION));
                return true;
            }
        }
        return false;
    }

    private void updateSharePreference(String str, String str2) {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putString(str, str2);
        edit.apply();
        if (str.contains(VERSION)) {
            CameraStatisticsUtil.onCommon(this.mContext, CameraStatisticsUtil.EVENT_RUS, CameraStatisticsUtil.format(CameraStatisticsUtil.RUS_FILE_NAME, str) + " " + CameraStatisticsUtil.format(CameraStatisticsUtil.RUS_FILE_VERSION, str2), true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r3 = r0.getString(r3, (java.lang.String) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean getBooleanValue(java.lang.String r3, boolean r4) {
        /*
            r2 = this;
            android.content.SharedPreferences r0 = r2.getSharedPreferences()
            if (r0 == 0) goto L_0x0016
            r1 = 0
            java.lang.String r3 = r0.getString(r3, r1)
            if (r3 == 0) goto L_0x0016
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            boolean r3 = r3.booleanValue()
            return r3
        L_0x0016:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.update.UpdateUtil.getBooleanValue(java.lang.String, boolean):boolean");
    }

    private void writeContentToTargetFile(String str, String str2) {
        e.a(TAG, "writeContentToTargetFile, targetFile: " + str + ", content: " + str2);
        a.b(str, a.f3583b, str2.getBytes());
    }

    private boolean updateAppParameter(String str) {
        if (this.mGson == null) {
            this.mGson = new Gson();
        }
        try {
            this.mUpdateOperationList = (ArrayList) this.mGson.fromJson(str, new TypeToken<List<UpdateOperation>>() {
            }.getType());
            if (this.mUpdateOperationList == null) {
                e.e(TAG, "updateAppParameter fail, mUpdateOperationList is null!");
                return false;
            }
            for (int i = 0; i < this.mUpdateOperationList.size(); i++) {
                UpdateOperation updateOperation = this.mUpdateOperationList.get(i);
                if (APP_UPDATE_TYPE_PREFERENCE_NOW.equals(updateOperation.getOperation())) {
                    updateSharePreference(updateOperation.getKey(), updateOperation.getValue());
                }
                if (APP_UPDATE_TYPE_PREFERENCE_LATER.equals(updateOperation.getOperation())) {
                    if (this.mAppLaterUpdateOperationList == null) {
                        this.mAppLaterUpdateOperationList = new ArrayList<>();
                    }
                    this.mAppLaterUpdateOperationList.add(updateOperation);
                }
            }
            return true;
        } catch (Exception e) {
            e.e(TAG, "updateAppParameter fail, e: " + e.getMessage());
            return false;
        }
    }
}
