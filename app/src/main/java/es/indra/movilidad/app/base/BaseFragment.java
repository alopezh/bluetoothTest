package es.indra.movilidad.app.base;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.squareup.otto.Bus;

import javax.inject.Inject;

import es.indra.movilidad.inject.GraphRetriever;

/**
 * Created by Alejandro on 19/09/14.
 */
public abstract class BaseFragment extends Fragment implements BackEventListener {

    @Inject
    Bus mEventBus;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        GraphRetriever.from(activity).inject(this);

    }

}
