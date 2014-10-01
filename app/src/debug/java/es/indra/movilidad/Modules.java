package es.indra.movilidad;

import es.indra.movilidad.inject.modules.AndroidModule;
import es.indra.movilidad.app.base.BaseApplication;

public class Modules {

    public static Object[] list(BaseApplication app) {
        return new Object[]{
                new AndroidModule(app),
        };
    }

    private Modules() {
        // No instances
    }

}
