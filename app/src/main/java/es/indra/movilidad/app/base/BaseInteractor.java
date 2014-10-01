package es.indra.movilidad.app.base;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import javax.inject.Inject;

/**
 * Created by Alejandro on 19/09/14.
 */
public abstract class BaseInteractor {

    private static final String TAG = BaseInteractor.class.getSimpleName();

    @Inject
    RequestQueue mRequestQueue;

    private Response.ErrorListener mErrorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError volleyError) {
            Log.e(TAG, "Error en petición");
        }
    };

    public Response.ErrorListener getmErrorListener() {
        return mErrorListener;
    }


}
