package com.asy.proyectobase;

import com.asy.proyectobase.inject.modules.BaseAppModule;
import com.asy.proyectobase.ui.app.base.BaseApplication;

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
