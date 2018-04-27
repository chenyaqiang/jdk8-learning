package com.booxJ.other.pool2;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Description:
 * @Author: wb
 * @CreateDate: 2018-04-27 10:21
 * @version:
 **/
public class JdbcPooledFactory extends BasePooledObjectFactory<Connection> {

    static {
        try {
            Class.forName(JdbcConfig.DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Connection create() throws Exception {
        return DriverManager.getConnection(JdbcConfig.URL, JdbcConfig.USERNAME, JdbcConfig.PASSWD);
    }

    @Override
    public PooledObject<Connection> wrap(Connection conn) {
        return new DefaultPooledObject<>(conn);
    }
}
