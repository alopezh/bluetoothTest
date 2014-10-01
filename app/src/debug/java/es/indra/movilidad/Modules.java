package es.indra.movilidad;

import es.indra.movilidad.inject.modules.BaseAppModule;
import es.indra.movilidad.ui.app.base.BaseApplication;

public class Modules {

    public static Object[] list(BaseApplication app) {
        return new Object[]{
                new BaseAppModule(app),
        };
    }

    private Modules() {
        // No instances
    }

}
