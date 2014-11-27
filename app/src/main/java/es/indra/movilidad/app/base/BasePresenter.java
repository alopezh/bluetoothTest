package es.indra.movilidad.app.base;

import com.squareup.otto.Bus;

import javax.inject.Inject;

/**
 * Created by Alejandro on 19/09/14.
 */
public abstract class BasePresenter {

    @Inject
    Bus eventBus;

    public Bus getEventBus() {
        return eventBus;
    }


}
