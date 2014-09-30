package com.asy.proyectobase.inject.modules;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.asy.proyectobase.ui.app.base.BaseActivity;
import com.asy.proyectobase.ui.app.base.BaseApplication;
import com.asy.proyectobase.ui.app.base.BaseDialogFragment;
import com.asy.proyectobase.ui.app.base.BaseFragment;
import com.asy.proyectobase.ui.app.base.BaseInteractor;
import com.asy.proyectobase.ui.app.base.BasePresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alejandro on 19/09/14.
 */
@Module(
        injects = {
                BaseActivity.class,
                BaseFragment.class,
                BaseDialogFragment.class,
                BaseInteractor.class,
                BasePresenter.class
        },
        library = true,
        complete = false
)
public class NetworkModule {

    @Provides
    @Singleton
    public RequestQueue providesRequestQueue(BaseApplication application) {
        return Volley.newRequestQueue(application);
    }
}
