package es.indra.movilidad.inject.modules;

import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.config.Configuration;
import com.path.android.jobqueue.log.CustomLogger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import es.indra.movilidad.app.base.BaseApplication;

/**
 * Created by Alejandro on 19/09/14.
 */
@Module( library = true, complete=false )
public class JobModule {

    @Provides
    @Singleton
    CustomLogger provideJobManagerLogger() {
        return new CustomLogger() {
            @Override
            public boolean isDebugEnabled() {
                return false;
            }

            @Override
            public void d(String text, Object... args) {
            }

            @Override
            public void e(Throwable t, String text, Object... args) {
            }

            @Override
            public void e(String text, Object... args) {
            }
        };
    }

    @Provides
    @Singleton
    Configuration provideConfiguration(BaseApplication application, CustomLogger customLogger) {
        return new Configuration.Builder(application)
                .customLogger(customLogger)
                .minConsumerCount(1)    //1 como minimo
                .maxConsumerCount(3)    //3 como maximo
                .loadFactor(3)          //3 jobs por consumidor
                .consumerKeepAlive(120) //2 minutos maximo
                .build();

    }

    @Provides
    @Singleton
    JobManager provideJobManager(BaseApplication application, Configuration configuration) {
        return new JobManager(application, configuration);
    }

}
