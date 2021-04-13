
package escola.dao;

import escola.app.App;
import escola.modelo.Matricula;
import escola.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MatriculaDao {
    List<Matricula> matriculas = new ArrayList<>();
    
    public static Integer salvar(Matricula m) {
        Integer last_inserted_id = null;
        try {
            
            Connection con = ConnectionFactory.getConexao();
            PreparedStatement stmt = con.prepareStatement("insert into matricula(status)values(?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, m.getStatus());
           
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next())
                {
                    last_inserted_id = rs.getInt(1);
                }

            stmt.close();
            ConnectionFactory.closeConexao(con);
            

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return last_inserted_id;
    }  
    public static void getMatriculas(List<Matricula> matriculas){
        try {
                    Connection con = ConnectionFactory.getConexao();
                    PreparedStatement stmt = con.prepareStatement("select id, status from matricula");
                    ResultSet rs = stmt.executeQuery();

                    while (rs.next()) {
                        Matricula m = new Matricula();
                        m.setId(rs.getInt("id"));
                        m.setStatus(rs.getString("status"));
                        

                        matriculas.add(m);
                    }
                    rs.close();
                    stmt.close();
                    ConnectionFactory.closeConexao(con);

                } catch (SQLException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }

    }
}
