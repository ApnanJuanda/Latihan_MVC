/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.sql.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 *
 * @author ASUS
 */
public class Koneksi {
    private Connection connection=null;
    
    
    public Connection getConnection(){
        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName("localhost");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("mccoc_latihan");
            dataSource.setUser("root");
            
            connection=(Connection) dataSource.getConnection();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
      return connection;
    }

    
            
    
}
