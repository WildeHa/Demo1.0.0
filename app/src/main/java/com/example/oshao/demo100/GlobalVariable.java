package com.example.oshao.demo100;

import android.app.Application;
import android.content.Context;

/**
 * Created by oshao on 2/16/2017.
 */

public class GlobalVariable extends Application {

    private static Context context;

    public GlobalVariable() {
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        GlobalVariable.context = context;
    }
}
