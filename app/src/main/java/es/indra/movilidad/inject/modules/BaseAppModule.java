package es.indra.movilidad.inject.modules;

/**
 * Created by Alejandro on 19/09/14.
 */

import android.content.Context;

import es.indra.movilidad.inject.qualifiers.ForApplication;
import es.indra.movilidad.ui.app.base.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                BaseApplication.class
        },
        includes = {
                NetworkModule.class,
                PreferencesModule.class,
                BackgroundModule.class,
                RepositoryModule.class,
                ComunicationModule.class,
        },
        library = true,
        complete = false
)
public class BaseAppModule {

    private final BaseApplication mApplication;

    public BaseAppModule(BaseApplication application) {
        this.mApplication = application;
    }

    @Provides
    @Singleton
    public BaseApplication provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    @ForApplication
    public Context provideApplicationContext() {
        return this.mApplication.getApplicationContext();
    }

}
