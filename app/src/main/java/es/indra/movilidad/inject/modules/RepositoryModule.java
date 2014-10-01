package es.indra.movilidad.inject.modules;

import es.indra.movilidad.repository.DbManager;
import es.indra.movilidad.repository.parking.IUserRepository;
import es.indra.movilidad.repository.parking.UserRepository;
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
