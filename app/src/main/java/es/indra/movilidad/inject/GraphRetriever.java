package es.indra.movilidad.inject;

import android.app.Activity;
import android.app.Application;
import android.app.Service;

import dagger.ObjectGraph;

public class GraphRetriever {

    public static ObjectGraph from(Application application) {
        try {
            return ObjectGraph.create(((ModuleProvider) application).getModules());
        } catch (ClassCastException e) {
            throw new ClassCastException("Application must implement ModuleProvider interface!");
        }
    }

	public static ObjectGraph from(Activity activity) {
        try {
            return from(activity.getApplication()).plus(((ModuleProvider) activity).getModules());
        } catch (ClassCastException e) {
            throw new ClassCastException("Application and Activity must implement ModuleProvider interface!");
        }
    }
	
	public static ObjectGraph from(Service service) {
        try {
            return from(service.getApplication()).plus(((ModuleProvider) service).getModules());
        } catch (ClassCastException e) {
            throw new ClassCastException("Application and Servicie must implement ModuleProvider interface!");
        }
	}

}
