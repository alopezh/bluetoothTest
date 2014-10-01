package es.indra.movilidad.preferences;

import android.content.SharedPreferences;

public class StringPreference implements Preference<String> {

    private SharedPreferences sharedPreferences;
    private String key;
    private String defaultValue;

    public StringPreference(SharedPreferences sharedPreferences, String key) {
        this.sharedPreferences = sharedPreferences;
        this.key = key;
    }

    public StringPreference(SharedPreferences sharedPreferences, String key, String defaultValue) {
        this.sharedPreferences = sharedPreferences;
        this.key = key;
        this.defaultValue = defaultValue;
    }

    @Override
    public String get() {
        return sharedPreferences.getString(key, defaultValue);
    }

    @Override
    public void set(String elem) {
        sharedPreferences.edit().putString(key, elem).apply();
    }

    @Override
    public String getDefaultValue() {
        return defaultValue;
    }

    @Override
    public boolean isSet() {
        return sharedPreferences.contains(key);
    }

}