package com.asy.proyectobase.ui.app.base;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.asy.proyectobase.inject.ObjectGraphProvider;
import com.squareup.otto.Bus;

import javax.inject.Inject;

/**
 * Created by Alejandro on 19/09/14.
 */
public abstract class BaseFragment extends Fragment implements BackEventListener {

    @Inject
    Bus mEventBus;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            if (activity != null)
                ((ObjectGraphProvider) activity).getObjectGraph().inject(this);
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must be a subclass of O61Activity or implement ObjectGraphProvider interface!");
        }
    }

    public Bus getEventBus() {
        return mEventBus;
    }
}
