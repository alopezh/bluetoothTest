package es.indra.movilidad.app.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import es.indra.movilidad.app.base.BaseActivity;
import es.indra.movilidad.app.ui.UserController;
import es.indra.movilidad.app.ui.login.LoginActivity;
import es.indra.movilidad.app.ui.login.LoginPresenterImpl;
import es.indra.movilidad.inject.modules.AndroidModule;
import es.indra.movilidad.inject.qualifiers.ForActivity;

@Module(
        injects = {
                //AÑADIR LOS FRAGMENTS QUE SE VAYAN CREANDO!!
                LoginActivity.class,
                LoginPresenterImpl.class

        },
        addsTo = AndroidModule.class,
        library = true
)
public class BaseActivityModule {


    private final BaseActivity activity;

    public BaseActivityModule( BaseActivity activity ) {
        this.activity = activity;
    }

    /**
     * Allow the activity context to be injected but require that it be annotated with
     * {@link es.indra.movilidad.inject.qualifiers.ForActivity @ForActivity} to explicitly differentiate it from application context.
     */
    @Provides
    @Singleton
    @ForActivity
    Context provideActivityContext() {
        return activity;
    }

    /* Añadir los providers que se necesiten a nivel de Actividad */
    @Provides
    @Singleton
    UserController provideUserController() {
        return new UserController();
    }


}
