package com.booxJ.other.pool2;

/**
 * @Description:
 * @Author: wb
 * @CreateDate: 2018-04-27 10:15
 * @version:
 **/
public class JdbcConfig {

    /**
     * 默认配置，可以继承InitializingBean从配置文件中动态读取
     */
    public final static String URL = "jdbc:mysql://localhost:3306/test";
    public final static String USERNAME = "root";
    public final static String PASSWD = "root";
    public final static String DRIVER = "com.mysql.jdbc.Driver";

    /**
     * 是否初始化
     */
    private static boolean isInit = false;

    public static void init() {
        synchronized (JdbcConfig.class) {
            if (!isInit) {
                //参配初始化
            }
        }
    }

}
