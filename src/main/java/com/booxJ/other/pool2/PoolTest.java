package com.booxJ.other.pool2;

import java.sql.Connection;

/**
 * @Description:
 * @Author: wb
 * @CreateDate: 2018-04-27 10:34
 * @version:
 **/
public class PoolTest {

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 200; i++) {
//               // 1 单线程不归还连接
//               Connection conn = JDBCPool.getInstance().getConnection();
//               System.out.println(conn.hashCode());
//               // 2 单线程归还连接
//               JDBCPool.returnConnection(conn);
                // 3 多线程不归还
                new Thread(new thread()).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class thread implements Runnable {

        @Override
        public void run() {
            try {
                Connection connection = JdbcPoolBean.getInstance().getConnection();
                System.out.println(Thread.currentThread().getName() + ":" + connection.hashCode());
                Thread.sleep(2000);
                JdbcPoolBean.returnConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
