package es.indra.movilidad.inject;

/**
 * Enables the class to inject objects.
 */
public interface Injector {

    /**
     * Inject the object
     *
     * @param target What object you want to inject
     */
    void inject(Object target);

}
