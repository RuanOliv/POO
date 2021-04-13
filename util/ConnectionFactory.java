
package escola.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    
    private static final String URL = "jdbc:mysql://localhost:3306/escola";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection getConexao(){
        try{
            return DriverManager.getConnection(URL,USER,PASS);
        }catch(SQLException ex){
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public static void closeConexao(Connection con){
        try{
            con.close();
        }catch(SQLException ex){
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
     
        }
        
    }
}
