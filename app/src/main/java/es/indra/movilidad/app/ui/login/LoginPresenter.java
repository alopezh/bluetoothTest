package es.indra.movilidad.app.ui.login;

/**
 * Created by alopezh on 01/10/2014.
 */
public interface LoginPresenter {

    void onCreate();

    void onPause();

    void onResume();

    void validate(String user, String password);
}
