package com.asy.proyectobase.inject.modules;

import com.asy.proyectobase.ui.app.base.BaseActivity;
import com.asy.proyectobase.ui.app.base.BaseDialogFragment;
import com.asy.proyectobase.ui.app.base.BaseFragment;
import com.asy.proyectobase.ui.app.base.BaseInteractor;
import com.asy.proyectobase.ui.app.base.BasePresenter;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                BaseActivity.class,
                BaseFragment.class,
                BaseDialogFragment.class,
                BasePresenter.class,
                BaseInteractor.class
        },
        complete = false,
        library = false
)
public class ComunicationModule {

    @Provides
    @Singleton
    Bus provideEventBus() {
        return new Bus(ThreadEnforcer.ANY);
    }

}
