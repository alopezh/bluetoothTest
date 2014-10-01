package es.indra.movilidad.app.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import es.indra.movilidad.inject.GraphRetriever;
import es.indra.movilidad.inject.ModuleProvider;
import es.indra.movilidad.app.modules.BaseActivityModule;

/**
 * Created by Alejandro on 19/09/14.
 */
public class BaseActivity extends ActionBarActivity implements ModuleProvider {

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
        GraphRetriever.from(this).inject(this);
    }

    @Override
    public Object[] getModules() {
        return new Object[]{
                new BaseActivityModule(this)
        };
    }

}
