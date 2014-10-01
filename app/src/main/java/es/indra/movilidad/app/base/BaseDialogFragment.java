package es.indra.movilidad.app.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import javax.inject.Inject;

import es.indra.movilidad.R;
import es.indra.movilidad.app.ui.UserController;
import es.indra.movilidad.inject.GraphRetriever;

/**
 * Created by Alejandro on 19/09/14.
 */
public abstract class BaseDialogFragment extends DialogFragment implements BackEventListener {

    @Inject
    UserController userController;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        GraphRetriever.from(activity).inject(this);

    }


    @Override
    public void onActivityCreated(Bundle arg0) {
        super.onActivityCreated(arg0);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
    }


}
