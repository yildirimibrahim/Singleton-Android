package com.singleton.SingletonClass;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ibrahim yildirim on 13/11/2017.
 */

public class AppSharedPreferences {

    private static final String PreferenceLoad = "PreferencesLoad";
    private static final String PreferenceName = "Preferences";
    private static AppSharedPreferences instance;
    private final SharedPreferences sharedPreferences;

    private AppSharedPreferences(Context context) {

        sharedPreferences = context.getApplicationContext().getSharedPreferences(PreferenceName, Context.MODE_PRIVATE);
    }

    public static AppSharedPreferences with(Context context) {

        if (instance == null) {
            instance = new AppSharedPreferences(context);
        }
        return instance;
    }

    public void setPreferenceLoad(boolean totalTime) {

        sharedPreferences
                .edit()
                .putBoolean(PreferenceLoad, totalTime)
                .apply();
    }

    public boolean getPreferenceLoad(){
        return sharedPreferences.getBoolean(PreferenceLoad, false);
    }

}
