package com.asy.proyectobase.ui.app.base;

import com.asy.proyectobase.inject.Injector;
import com.squareup.otto.Bus;

import javax.inject.Inject;

/**
 * Created by Alejandro on 19/09/14.
 */
public abstract class BasePresenter {

    Injector injector;

    @Inject
    Bus eventBus;

    protected BasePresenter(Injector injector) {
        this.injector = injector;
        this.injector.inject(this);
    }

    public Injector getInjector() {
        return injector;
    }

    public Bus getEventBus() {
        return eventBus;
    }

    public abstract void onDestroy();

}
