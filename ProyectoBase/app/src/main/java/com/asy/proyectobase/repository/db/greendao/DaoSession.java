package com.asy.proyectobase.repository.db.greendao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 *
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDbDaoConfig;

    private final UserDbDao userDbDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDbDaoConfig = daoConfigMap.get(UserDbDao.class).clone();
        userDbDaoConfig.initIdentityScope(type);

        userDbDao = new UserDbDao(userDbDaoConfig, this);

        registerDao(UserDb.class, userDbDao);
    }

    public void clear() {
        userDbDaoConfig.getIdentityScope().clear();
    }

    public UserDbDao getUserDbDao() {
        return userDbDao;
    }

}
