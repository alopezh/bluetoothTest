package es.indra.movilidad.preferences;

public interface Preference<T> {

    T get();

    void set(T elem);

    T getDefaultValue();

    boolean isSet();

}
