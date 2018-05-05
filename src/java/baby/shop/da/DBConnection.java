/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby.shop.da;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author viquy
 */
//public class DBConnection {
//    private static Connection connection;
//    
//    
//    public static Connection getConnection() throws ClassNotFoundException, SQLException {
//        String hostName = "localhost";
//        String sqlInstanceName = "MSSQLSERVER";
//        String database = "ecommerce";
//        String userName = "sa";
//        String password = "123456";
//        if(connection== null){
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String connectionURL = "jdbc:sqlserver://" + hostName + ":1433" //
//                + ";instance=" + sqlInstanceName + ";databaseName=" + database;
//            connection = DriverManager.getConnection(connectionURL, userName, password);
//        }
//        return connection;
//    }
//}
public class DBConnection implements Serializable{
    public static Connection makeConnection() throws NamingException, SQLException{
        Context context = new InitialContext();
        Context tomcatCtx = (Context)context.lookup("java:comp/env");
        DataSource ds = (DataSource)tomcatCtx.lookup("Struts2BabyShop");
        Connection con = ds.getConnection();
        return con;
    }
}
