package es.indra.movilidad.repository;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import es.indra.movilidad.repository.db.greendao.DaoMaster;
import es.indra.movilidad.repository.db.greendao.DaoSession;
import es.indra.movilidad.repository.db.greendao.UserDbDao;

public class DbManager {

    public DaoSession daoSession;

    public DbManager(Application application) {
        setupDatabase(application);
    }

    private void setupDatabase(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "db_", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public UserDbDao getUserDao() {
        return daoSession.getUserDbDao();
    }

}
