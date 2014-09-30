package com.asy.proyectobase.inject.modules;

import com.asy.proyectobase.repository.DbManager;
import com.asy.proyectobase.repository.parking.IUserRepository;
import com.asy.proyectobase.repository.parking.UserRepository;
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
public class RepositoryModule {


    @Provides
    @Singleton
    DbManager provideDbManager(BaseApplication application) {
        return new DbManager(application);
    }

    @Singleton
    @Provides
    IUserRepository providesParkingRepository(DbManager dbManager) {
        return new UserRepository(dbManager.getUserDao());
    }
}
