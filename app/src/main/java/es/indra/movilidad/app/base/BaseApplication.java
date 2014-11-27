package es.indra.movilidad.app.base;

import android.app.Application;

import dagger.ObjectGraph;
import es.indra.movilidad.inject.GraphProvider;
import es.indra.movilidad.inject.Modules;


/**
 * Created by Alejandro on 19/09/14.
 */
public class BaseApplication extends Application implements GraphProvider {

    private ObjectGraph graph;

    @Override
    public ObjectGraph getGraph() {
        if (graph == null) {
            graph = ObjectGraph.create(Modules.listModulesForApplication( BaseApplication.this ));
        }
        return graph;
    }
}
