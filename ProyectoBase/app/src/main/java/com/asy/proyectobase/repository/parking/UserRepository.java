package com.asy.proyectobase.repository.parking;

import com.asy.proyectobase.repository.BaseRepository;
import com.asy.proyectobase.repository.db.greendao.UserDb;

import de.greenrobot.dao.AbstractDao;

/**
 * Created by Alejandro on 19/09/14.
 */
public class UserRepository extends BaseRepository<UserDb> implements IUserRepository {

    public UserRepository(AbstractDao<UserDb, Long> dao) {
        super(dao);
    }

}
