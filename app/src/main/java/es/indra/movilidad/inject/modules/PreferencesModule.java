package es.indra.movilidad.inject.modules;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import es.indra.movilidad.inject.qualifiers.ExamplePreference;
import es.indra.movilidad.preferences.Preferences;
import es.indra.movilidad.preferences.StringPreference;
import es.indra.movilidad.ui.app.base.BaseActivity;
import es.indra.movilidad.ui.app.base.BaseApplication;
import es.indra.movilidad.ui.app.base.BaseDialogFragment;
import es.indra.movilidad.ui.app.base.BaseFragment;
import es.indra.movilidad.ui.app.base.BaseInteractor;
import es.indra.movilidad.ui.app.base.BasePresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alejandro on 19/09/14.
 */
@Module(
        injects = {
                BaseActivity.class,
                BaseFragment.class,
                BaseDialogFragment.class,
                BasePresenter.class,
                BaseInteractor.class
        },
        library = true,
        complete = false
)
public class PreferencesModule {

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(BaseApplication app) {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }

    @Provides
    @Singleton
    @ExamplePreference
    StringPreference provideDataVersionPreference(SharedPreferences sharedPreferences) {
        return new StringPreference(sharedPreferences, Preferences.PREFERENCE_ID, "");
    }


}
