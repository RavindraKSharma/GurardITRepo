package org.aviran.cookiebar2;

import android.content.Context;

public class Tools {
    private static Context sContext;

    public static void setContext(Context pContext) {
        sContext = pContext;
    }

    public static Context getContext() {
        return sContext;
    }
}
