package es.indra.movilidad.app.ui.login;

import es.indra.movilidad.app.base.BasePresenter;

/**
 * Created by alopezh on 01/10/2014.
 */
public class LoginPresenterImpl extends BasePresenter implements LoginPresenter {

    private LoginView loginView;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {
        getEventBus().unregister(this);
    }

    @Override
    public void onResume() {
        getEventBus().register(this);
    }

    @Override
    public void validate(String user, String password) {
        //TODO: llamar servicio
        if (user.equals("AAA")) {
            loginView.validationOK();
        } else {
            loginView.validationError("ERROR");
        }

    }


}
