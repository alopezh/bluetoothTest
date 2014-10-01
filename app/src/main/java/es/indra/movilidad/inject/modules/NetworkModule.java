package es.indra.movilidad.inject.modules;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import es.indra.movilidad.ui.app.base.BaseActivity;
import es.indra.movilidad.ui.app.base.BaseApplication;
import es.indra.movilidad.ui.app.base.BaseDialogFragment;
import es.indra.movilidad.ui.app.base.BaseFragment;
import es.indra.movilidad.ui.app.base.BaseInteractor;
import es.indra.movilidad.ui.app.base.BasePresenter;

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
