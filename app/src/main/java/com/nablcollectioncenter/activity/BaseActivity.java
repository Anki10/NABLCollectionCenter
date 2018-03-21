package com.nablcollectioncenter.activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import com.nablcollectioncenter.util.AppConstant;

/**
 * Created by raj on 3/19/2018.
 */

public class BaseActivity extends AppCompatActivity {


     /*....Shared preference for storing local value.....*/

    public void saveIntoPrefs(String key, String value) {
        SharedPreferences prefs = getSharedPreferences(AppConstant.PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString(key, value);
        edit.commit();
    }

    public String getFromPrefs(String key) {
        SharedPreferences prefs = getSharedPreferences(AppConstant.PREF_NAME, MODE_PRIVATE);
        return prefs.getString(key, AppConstant.DEFAULT_VALUE);
    }


}
