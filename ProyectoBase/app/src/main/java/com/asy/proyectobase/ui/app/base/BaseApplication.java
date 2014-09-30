package com.asy.proyectobase.ui.app.base;

import android.app.Application;

import com.asy.proyectobase.Modules;
import com.asy.proyectobase.inject.Injector;
import com.asy.proyectobase.inject.ObjectGraphProvider;

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
