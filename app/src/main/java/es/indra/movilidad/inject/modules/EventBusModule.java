package es.indra.movilidad.inject.modules;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module( library = true, complete=false )
public class EventBusModule {

    @Provides
    @Singleton
    Bus provideEventBus() {
        return new Bus(ThreadEnforcer.ANY);
    }

}
