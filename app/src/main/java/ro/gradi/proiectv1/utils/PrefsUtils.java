package ro.gradi.proiectv1.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsUtils {

    private static final String MY_PREFS_FILENAME = "pubs_prefs";
    private static final String PREF_USERNAME = "pref_username";

    public static void saveUsername(Context context, String username) {
        SharedPreferences sharedPrefs = context.getSharedPreferences(MY_PREFS_FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        if (username == null) {
            editor.remove(PREF_USERNAME);
        } else {
            editor.putString(PREF_USERNAME, username);
        }
        editor.commit();
    }

    public static String readUsername(Context context) {
        SharedPreferences sharedPrefs = context.getSharedPreferences(MY_PREFS_FILENAME, Context.MODE_PRIVATE);
        return sharedPrefs.getString(PREF_USERNAME, null);
    }
}
