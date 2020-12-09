package com.example.login_signup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class Utils {
    private final Context context;

    public Utils(Context context) {
        this.context = context;
    }

    public Object getSharedPreferences(String key, Object _default) {
        SharedPreferences pref = context.getSharedPreferences("DB_ShopUser", Context.MODE_PRIVATE);
        if (_default instanceof String) {
            return pref.getString(key, (String) _default);
        } else if (_default instanceof Boolean) {
            return pref.getBoolean(key, (Boolean) _default);
        } else if (_default instanceof Integer) {
            return pref.getInt(key, (Integer) _default);
        } else if (_default instanceof Long) {
            return pref.getLong(key, (Long) _default);
        } else if (_default instanceof Float) {
            return pref.getFloat(key, (Float) _default);
        }
        return null;

    }

    public void setSharedPreferences(String key, Object data) {
        SharedPreferences pref = context.getSharedPreferences("DB_ShopUser", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        if (data instanceof String) {
            editor.putString(key, (String) data);
        } else if (data instanceof Boolean) {
            editor.putBoolean(key, (Boolean) data);
        } else if (data instanceof Integer) {
            editor.putInt(key, (Integer) data);
        } else if (data instanceof Long) {
            editor.putLong(key, (Long) data);
        } else if (data instanceof Float) {
            editor.putFloat(key, (Float) data);
        }
        editor.apply();
    }

    public void goToPage(Activity activity, Class _class) {
        Intent intent = new Intent(context, _class);
        activity.startActivity(intent);
    }
}
