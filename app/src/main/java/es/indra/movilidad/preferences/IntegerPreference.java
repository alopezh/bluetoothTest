package es.indra.movilidad.preferences;

import android.content.SharedPreferences;

public class IntegerPreference implements Preference<Integer> {

    private SharedPreferences sharedPreferences;
    private String key;
    private int defaultValue;

    public IntegerPreference(SharedPreferences sharedPreferences, String key) {
        this(sharedPreferences, key, 0);
    }

    public IntegerPreference(SharedPreferences sharedPreferences, String key, int defaultValue) {
        this.sharedPreferences = sharedPreferences;
        this.key = key;
        this.defaultValue = defaultValue;
    }

    @Override
    public Integer get() {
        return sharedPreferences.getInt(key, defaultValue);
    }

    @Override
    public void set(Integer elem) {
        sharedPreferences.edit().putInt(key, elem).apply();
    }

    @Override
    public Integer getDefaultValue() {
        return defaultValue;
    }

    @Override
    public boolean isSet() {
        return sharedPreferences.contains(key);
    }

}