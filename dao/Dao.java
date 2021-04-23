package escola.dao;

import escola.util.ConnectionFactory;
import java.sql.Connection;

public class Dao {
    
    protected Connection con;
    
    public Dao(){
        this.con = ConnectionFactory.getConexao();
    }
    
}