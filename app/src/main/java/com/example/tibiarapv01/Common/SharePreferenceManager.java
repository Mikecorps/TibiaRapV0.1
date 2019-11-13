package com.example.tibiarapv01.Common;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreferenceManager {

    private  static final String APP_SETTINGS_FILE = "APP_SETTINGS";

    private  SharePreferenceManager(){}

    private static  SharedPreferences getSharePrefenrece()
    {
        return  ThisApp.getContext().getSharedPreferences(APP_SETTINGS_FILE,Context.MODE_PRIVATE);
    }

    public static void setAppSettingsFile( String key, String value){
        SharedPreferences.Editor editor = getSharePrefenrece().edit();
        editor.putString( key, value);
        editor.commit();
    }


}
