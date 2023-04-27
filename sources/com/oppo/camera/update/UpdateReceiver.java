package com.oppo.camera.update;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.oppo.camera.e;
import java.util.ArrayList;

public class UpdateReceiver extends BroadcastReceiver {
    private static final String ROM_UPDATE_ACTION = "oppo.intent.action.ROM_UPDATE_CONFIG_SUCCESS";
    private static final String TAG = "UpdateReceiver";
    private static final String UPDATE_LIST_KEY = "ROM_UPDATE_CONFIG_LIST";

    public void onReceive(Context context, Intent intent) {
        if (ROM_UPDATE_ACTION.equals(intent.getAction())) {
            ArrayList<String> arrayList = null;
            try {
                arrayList = intent.getStringArrayListExtra(UPDATE_LIST_KEY);
            } catch (Exception e) {
                e.printStackTrace();
            }
            e.a(TAG, "onReceive, updateList: " + arrayList);
            if (arrayList != null) {
                UpdateUtil.getInstance(context).startUpdate(arrayList.contains(UpdateUtil.APP_TO_UPDATE), arrayList.contains(UpdateUtil.APS_TO_UPDATE));
            }
        }
    }
}
