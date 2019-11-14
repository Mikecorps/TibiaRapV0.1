package com.example.tibiarapv01.Retrofit;

import com.example.tibiarapv01.Common.SharePreferenceManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        String token  = SharePreferenceManager.getAppSettingsFile("PREF_TOKEN");
        Request request =   chain .request().newBuilder().addHeader("Authorization","Bearer "+token)
                                                        .header("content-type", "application/json")
                                                        .header("X-Requested-With","XMLHttpRequest").build();
        return chain.proceed(request);
    }
}
