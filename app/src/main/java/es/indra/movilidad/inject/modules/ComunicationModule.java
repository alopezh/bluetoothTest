package es.indra.movilidad.inject.modules;

import es.indra.movilidad.ui.app.base.BaseActivity;
import es.indra.movilidad.ui.app.base.BaseDialogFragment;
import es.indra.movilidad.ui.app.base.BaseFragment;
import es.indra.movilidad.ui.app.base.BaseInteractor;
import es.indra.movilidad.ui.app.base.BasePresenter;
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
