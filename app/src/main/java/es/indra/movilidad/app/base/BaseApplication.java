package es.indra.movilidad.app.base;

import android.app.Application;

import es.indra.movilidad.inject.ModuleProvider;
import es.indra.movilidad.inject.modules.AndroidModule;

/**
 * Created by Alejandro on 19/09/14.
 */
public class BaseApplication extends Application implements ModuleProvider {

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public Object[] getModules() {
        return new Object[] {
             new AndroidModule(this)
        };
    }
}
