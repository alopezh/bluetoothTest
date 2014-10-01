package es.indra.movilidad.ui.app.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import es.indra.movilidad.R;
import es.indra.movilidad.inject.ObjectGraphProvider;

/**
 * Created by Alejandro on 19/09/14.
 */
public abstract class BaseDialogFragment extends DialogFragment implements BackEventListener {

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


    @Override
    public void onActivityCreated(Bundle arg0) {
        super.onActivityCreated(arg0);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
    }


}
