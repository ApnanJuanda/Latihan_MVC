
package Helper;

/*Note: Pada bagian helper ini gunanya untuk meng set database mana yang akan
diakses bisa dikatakan helper ini mediator lah untuk menghubungkan antara
java dengan MySQL
Connection itu adalah sesuatu tipe untuk menyatakan nilai fungsinya seperti int dan 
String di Function
*/
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection; //memanggil library connection supaya terhubung dengan MySQL 
import java.sql.SQLException; 




public class Koneksi {
    static Connection con; //pembuatan objek dari si connectionnya
    
    public static Connection getConnection(){ 
        if (con == null)
        {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("db_crud");
            data.setUser("root");
            data.setPassword("");
            
            //pengeksekusian koneksi ke MySQL
            try {
                con= data.getConnection();
                System.out.println("Koneksi berhasil");
                
            } catch (SQLException e) 
            
                {
                    System.out.println("tidak konek");
                }
            
        }
        return con;
    }
    

}
