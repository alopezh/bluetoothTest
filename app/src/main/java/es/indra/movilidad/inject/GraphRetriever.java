package es.indra.movilidad.inject;

import dagger.ObjectGraph;

public final class GraphRetriever {


    public static synchronized ObjectGraph from(Object object) {
        try {

            return ((GraphProvider)object).getGraph();

        } catch (ClassCastException e) {
            throw new ClassCastException(object.getClass().getName() + "  must implement GraphProvider interface!");
        }
    }



    private GraphRetriever(){
        //No instances!
    }

}
