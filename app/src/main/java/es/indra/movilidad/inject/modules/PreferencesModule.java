package es.indra.movilidad.inject.modules;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import es.indra.movilidad.inject.qualifiers.ExamplePreference;
import es.indra.movilidad.preferences.Preferences;
import es.indra.movilidad.preferences.StringPreference;
import es.indra.movilidad.app.base.BaseApplication;

/**
 * Created by Alejandro on 19/09/14.
 */
@Module( library = true, complete=false )
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
