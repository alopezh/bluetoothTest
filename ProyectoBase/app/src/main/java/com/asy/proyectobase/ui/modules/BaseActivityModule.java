package com.asy.proyectobase.ui.modules;

import com.asy.proyectobase.inject.modules.BaseAppModule;
import com.asy.proyectobase.ui.MainActivity;
import com.asy.proyectobase.ui.app.base.BaseActivity;

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
