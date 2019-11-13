package com.example.tibiarapv01.Common;

import android.app.Application;
import android.content.Context;

public class ContextApp extends Application {
    private static ContextApp instance;


    public  static ContextApp getInstance(){
        return instance;
    }

    public  static Context getContext(){
        return  instance;
    }


    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }
}
