package es.indra.movilidad.ui.app.base;

import android.app.Application;

import es.indra.movilidad.Modules;
import es.indra.movilidad.inject.Injector;
import es.indra.movilidad.inject.ObjectGraphProvider;

import dagger.ObjectGraph;

/**
 * Created by Alejandro on 19/09/14.
 */
public class BaseApplication extends Application implements Injector, ObjectGraphProvider {

    ObjectGraph mObjectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        initDaggerAndInject();
    }

    private void initDaggerAndInject() {
        mObjectGraph = ObjectGraph.create(Modules.list(this));
        inject(this);
    }

    @Override
    public void inject(Object target) {
        mObjectGraph.inject(target);
    }

    @Override
    public ObjectGraph getObjectGraph() {
        return mObjectGraph;
    }
}
