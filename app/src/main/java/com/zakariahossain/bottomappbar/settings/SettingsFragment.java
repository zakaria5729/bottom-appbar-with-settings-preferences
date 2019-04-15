package com.zakariahossain.bottomappbar.settings;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.zakariahossain.bottomappbar.R;

import androidx.preference.PreferenceFragmentCompat;

public class SettingsFragment extends PreferenceFragmentCompat {

    public static final String PREF_SYNC_CONNECTION_TYPE = "pref_sync_connection_type";
    private SharedPreferences.OnSharedPreferenceChangeListener preferenceChangeListener;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);

        preferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                if (key.equals(PREF_SYNC_CONNECTION_TYPE)) {
                    findPreference(key).setSummary(sharedPreferences.getString(key, "Wifi"));
                }
            }
        };
    }

    @Override
    public void onResume() {
        super.onResume();

        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(preferenceChangeListener);
        findPreference(PREF_SYNC_CONNECTION_TYPE).setSummary(getPreferenceScreen().getSharedPreferences().getString(PREF_SYNC_CONNECTION_TYPE, "Wifi"));
    }

    @Override
    public void onPause() {
        super.onPause();

        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(preferenceChangeListener);
    }
}
