package com.example.simplesimon;

import android.app.Application;
import android.content.Context;

import org.aviran.cookiebar2.Tools;

public class SimpleSimonApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Tools.setContext(base);
    }
}
