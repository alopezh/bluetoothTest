package es.indra.movilidad.inject;

import es.indra.movilidad.app.base.BaseActivity;
import es.indra.movilidad.app.base.BaseApplication;
import es.indra.movilidad.app.modules.BaseActivityModule;
import es.indra.movilidad.inject.modules.AndroidModule;

/**
 * Created by Alejandro on 02/10/14.
 */
public class Modules {

    public static Object[] listModulesForApplication(BaseApplication app) {
        return new Object[]{
                new AndroidModule( app ),
        };
    }

    public static Object[] listModulesForActivity(BaseActivity activity) {
        return new Object[]{
                new BaseActivityModule( activity ),
        };
    }

    private Modules() {
        // No instances
    }
}
