package com.asy.proyectobase.inject.modules;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.asy.proyectobase.inject.qualifiers.ExamplePreference;
import com.asy.proyectobase.preferences.Preferences;
import com.asy.proyectobase.preferences.StringPreference;
import com.asy.proyectobase.ui.app.base.BaseActivity;
import com.asy.proyectobase.ui.app.base.BaseApplication;
import com.asy.proyectobase.ui.app.base.BaseDialogFragment;
import com.asy.proyectobase.ui.app.base.BaseFragment;
import com.asy.proyectobase.ui.app.base.BaseInteractor;
import com.asy.proyectobase.ui.app.base.BasePresenter;

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
