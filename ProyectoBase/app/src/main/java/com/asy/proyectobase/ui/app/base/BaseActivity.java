package com.asy.proyectobase.ui.app.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.asy.proyectobase.inject.Injector;
import com.asy.proyectobase.inject.ModuleProvider;
import com.asy.proyectobase.inject.ObjectGraphProvider;
import com.asy.proyectobase.ui.modules.BaseActivityModule;

import dagger.ObjectGraph;

/**
 * Created by Alejandro on 19/09/14.
 */
public class BaseActivity extends ActionBarActivity implements Injector, ObjectGraphProvider, ModuleProvider {

    private ObjectGraph mObjectGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        blockLandScapeOrientation();
        initDaggerAndInject();
    }

    private void blockLandScapeOrientation() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    private void initDaggerAndInject() {
        mObjectGraph = ((ObjectGraphProvider) getApplicationContext()).getObjectGraph().plus(getModules());
        inject(this);
    }

    @Override
    public void inject(Object target) {
        mObjectGraph.inject(target);
    }

    @Override
    public Object[] getModules() {
        return new Object[]{
                new BaseActivityModule(this)
        };
    }

    @Override
    public ObjectGraph getObjectGraph() {
        return mObjectGraph;
    }
}
