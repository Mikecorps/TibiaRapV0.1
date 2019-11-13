package com.example.tibiarapv01.Common;

import android.app.Application;
import android.content.Context;

public class ThisApp extends Application {
    private static  ThisApp instace;

    public static  ThisApp getInstance(){
        return  instace;
    }
    public  static Context getContext(){
        return instace;
    }

    @Override
    public void onCreate(){
        instace = this;
        super.onCreate();
    }


}
