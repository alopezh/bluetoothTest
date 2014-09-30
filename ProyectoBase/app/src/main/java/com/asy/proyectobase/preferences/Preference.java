package com.asy.proyectobase.preferences;

public interface Preference<T> {

    T get();

    void set(T elem);

    T getDefaultValue();

    boolean isSet();

}
