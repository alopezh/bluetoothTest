package es.indra.movilidad.app.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.squareup.otto.Bus;

import javax.inject.Inject;

import dagger.ObjectGraph;
import es.indra.movilidad.inject.GraphProvider;
import es.indra.movilidad.inject.GraphRetriever;
import es.indra.movilidad.inject.Modules;

/**
 * Created by Alejandro on 19/09/14.
 */
public class BaseActivity extends ActionBarActivity implements GraphProvider {

    @Inject
    Bus mEventBus;

    private ObjectGraph graph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        blockLandScapeOrientation();
        GraphRetriever.from(this).inject(this);
    }

    private void blockLandScapeOrientation() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public Bus getEventBus() {
        return mEventBus;
    }

    public void changeActionBarTitle(String title){
        this.getSupportActionBar().setTitle( title );
    }

    public void changeActionBarTitle(int titleResId){
        this.getSupportActionBar().setTitle( titleResId );
    }

    @Override
    public ObjectGraph getGraph() {
        if (this.graph == null) {
            this.graph = GraphRetriever.from(this.getApplication()).plus(Modules.listModulesForActivity( BaseActivity.this ));
        }
        return this.graph;
    }
}
