package com.asy.proyectobase;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class BaseDaoGenerator {

    public static void main(String args[]) throws Exception {
        Schema schema = new Schema(1, "com.asy.proyectobase.repository.db.greendao");

        Entity user = schema.addEntity("UserDb");
        user.addIdProperty();
        user.addStringProperty("username").unique().notNull();
        user.addStringProperty("password").notNull();

        new DaoGenerator().generateAll(schema, args[0]);
    }
}
