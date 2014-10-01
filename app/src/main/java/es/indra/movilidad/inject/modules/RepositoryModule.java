package es.indra.movilidad.inject.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import es.indra.movilidad.repository.DbManager;
import es.indra.movilidad.repository.parking.IUserRepository;
import es.indra.movilidad.repository.parking.UserRepository;
import es.indra.movilidad.app.base.BaseApplication;

/**
 * Created by Alejandro on 19/09/14.
 */
@Module( library = true, complete=false )
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
