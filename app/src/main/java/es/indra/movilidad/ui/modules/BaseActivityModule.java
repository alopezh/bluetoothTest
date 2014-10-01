package es.indra.movilidad.ui.modules;

import es.indra.movilidad.inject.modules.BaseAppModule;
import es.indra.movilidad.ui.MainActivity;
import es.indra.movilidad.ui.app.base.BaseActivity;

import dagger.Module;

@Module(
        addsTo = BaseAppModule.class,
        injects = {
                //AÑADIR LOS FRAGMENTS QUE SE VAYAN CREANDO!!
                MainActivity.class

        },
        library = false,
        complete = true
)
public class BaseActivityModule {

    private BaseActivity mActivity;

    public BaseActivityModule(BaseActivity activity) {
        this.mActivity = activity;
    }
}
