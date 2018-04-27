package com.booxJ.other.pool2;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description:
 * @Author: wb
 * @CreateDate: 2018-04-27 10:12
 * @version:
 **/
public class JdbcPoolBean {

    private volatile static JdbcPoolBean instance;

    private static GenericObjectPool<Connection> pool;

    public static JdbcPoolBean getInstance() {
        if (instance == null) {
            synchronized (JdbcPoolBean.class) {
                if (instance == null) {
                    instance = new JdbcPoolBean();
                }
            }
        }
        return instance;
    }

    private JdbcPoolBean() {
        pool = new GenericObjectPool<Connection>(new JdbcPooledFactory(), getDefaultConfig());
    }

    public JdbcPoolBean(GenericObjectPoolConfig config) {
        if (config == null) {
            config = getDefaultConfig();
        }
        pool = new GenericObjectPool<Connection>(new JdbcPooledFactory(), config);
    }

    public GenericObjectPool<Connection> getConnectionPool() {
        return pool;
    }

    public Connection getConnection() throws Exception {
        return getConnectionPool().borrowObject();
    }

    public static void returnConnection(Connection conn) {
        pool.returnObject(conn);
    }

    public static void returnConnectionAndClose(Connection conn, PreparedStatement ps, ResultSet rs) {
        closePsAndRs(ps, rs);
        returnConnection(conn);
    }

    public static void closePsAndRs(PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                rs = null;
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                ps = null;
            }
        }
    }



    private GenericObjectPoolConfig getDefaultConfig() {
        GenericObjectPoolConfig conf = new GenericObjectPoolConfig();
        // TODO -- 默认8,8,0
        conf.setMaxTotal(8);
        conf.setMaxIdle(8);
        conf.setMinIdle(0);
        conf.setMaxWaitMillis(60000);
        return conf;
    }
}
