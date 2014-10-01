package es.indra.movilidad.inject.modules;

/**
 * Created by Alejandro on 19/09/14.
 */

import android.content.Context;
import android.location.LocationManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import es.indra.movilidad.inject.qualifiers.ForApplication;
import es.indra.movilidad.app.base.BaseApplication;
import static android.content.Context.LOCATION_SERVICE;

@Module(
        includes = {
                EventBusModule.class,
                JobModule.class,
                NetworkModule.class,
                PreferencesModule.class,
                RepositoryModule.class
        },
        library = true,
        complete=false
)
public class AndroidModule {

    private final BaseApplication application;

    public AndroidModule(BaseApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public BaseApplication provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    @ForApplication
    public Context provideApplicationContext() {
        return this.application.getApplicationContext();
    }

    @Provides
    @Singleton
    LocationManager provideLocationManager() {
        return (LocationManager) application.getSystemService(LOCATION_SERVICE);
    }

}
