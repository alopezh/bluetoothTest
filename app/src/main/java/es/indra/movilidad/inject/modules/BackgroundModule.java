package es.indra.movilidad.inject.modules;

import es.indra.movilidad.ui.app.base.BaseActivity;
import es.indra.movilidad.ui.app.base.BaseApplication;
import es.indra.movilidad.ui.app.base.BaseDialogFragment;
import es.indra.movilidad.ui.app.base.BaseFragment;
import es.indra.movilidad.ui.app.base.BaseInteractor;
import es.indra.movilidad.ui.app.base.BasePresenter;
import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.config.Configuration;
import com.path.android.jobqueue.log.CustomLogger;

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
        complete = false,
        library = true
)
public class BackgroundModule {


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
