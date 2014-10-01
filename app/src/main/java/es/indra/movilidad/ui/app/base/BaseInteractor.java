package es.indra.movilidad.ui.app.base;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import es.indra.movilidad.inject.Injector;

import javax.inject.Inject;

/**
 * Created by Alejandro on 19/09/14.
 */
public abstract class BaseInteractor {

    private static final String TAG = BaseInteractor.class.getSimpleName();

    @Inject
    RequestQueue mRequestQueue;

    protected BaseInteractor(Injector injector) {
        injector.inject(this);
    }

    private Response.ErrorListener mErrorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError volleyError) {
            Log.e(TAG, "Error en petición");
        }
    };

    public Response.ErrorListener getmErrorListener() {
        return mErrorListener;
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }
}
