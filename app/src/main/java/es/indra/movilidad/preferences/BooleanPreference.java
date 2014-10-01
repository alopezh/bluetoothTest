package es.indra.movilidad.preferences;

import android.content.SharedPreferences;

public class BooleanPreference implements Preference<Boolean> {

    private SharedPreferences sharedPreferences;
    private String key;
    private boolean defaultValue;

    public BooleanPreference(SharedPreferences sharedPreferences, String key) {
        this(sharedPreferences, key, false);
    }

    public BooleanPreference(SharedPreferences sharedPreferences, String key, boolean defaultValue) {
        this.sharedPreferences = sharedPreferences;
        this.key = key;
        this.defaultValue = defaultValue;
    }

    @Override
    public Boolean get() {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    @Override
    public void set(Boolean elem) {
        sharedPreferences.edit().putBoolean(key, elem).apply();
    }

    @Override
    public Boolean getDefaultValue() {
        return defaultValue;
    }

    @Override
    public boolean isSet() {
        return sharedPreferences.contains(key);
    }

}