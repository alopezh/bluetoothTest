package es.indra.movilidad.inject.modules;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import es.indra.movilidad.app.base.BaseApplication;

/**
 * Created by Alejandro on 19/09/14.
 */
@Module( library = true, complete=false )
public class NetworkModule {

    @Provides
    @Singleton
    public RequestQueue providesRequestQueue(BaseApplication application) {
        return Volley.newRequestQueue(application);
    }
}
