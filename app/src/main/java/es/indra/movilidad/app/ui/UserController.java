package es.indra.movilidad.app.ui;

import es.indra.movilidad.repository.db.greendao.UserDb;

/**
 * Created by alopezh on 01/10/2014.
 */
public class UserController {

    private UserDb user;

    public UserDb getUser() {
        return user;
    }

    public void setUser(UserDb user) {
        this.user = user;
    }
}
