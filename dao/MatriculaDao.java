
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

public class MatriculaDao extends Dao {
   
    
    public Boolean atulizar(Matricula m) {
        try {

            PreparedStatement stmt = this.con.prepareStatement("update matricula set status=? where id=?");
            stmt.setString(1, m.getStatus());
            stmt.setInt(2, m.getId());
            stmt.executeUpdate();
            stmt.close();
            ConnectionFactory.closeConexao(this.con);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public Integer salvar(Matricula m) {
        Integer last_inserted_id = null;
        try {
            
           
            PreparedStatement stmt = this.con.prepareStatement("insert into matricula(status)values(?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, m.getStatus());
           
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next())
                {
                    last_inserted_id = rs.getInt(1);
                }

            stmt.close();
            ConnectionFactory.closeConexao(this.con);
            

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return last_inserted_id;
    }  
    public Boolean delete(Integer id) {
        try {

            PreparedStatement stmt = this.con.prepareStatement("delete from matricula where id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();

            stmt.close();
            ConnectionFactory.closeConexao(this.con);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public List<Matricula> getMatriculas(){
        try {
                    List<Matricula> matriculas = new ArrayList<>();
                   
                    PreparedStatement stmt = this.con.prepareStatement("select id, status from matricula");
                    ResultSet rs = stmt.executeQuery();

                    while (rs.next()) {
                        Matricula m = new Matricula();
                        m.setId(rs.getInt("id"));
                        m.setStatus(rs.getString("status"));
                        

                        matriculas.add(m);
                    }
                    rs.close();
                    stmt.close();
                   ConnectionFactory.closeConexao(this.con);
                    return matriculas;
                   
                } catch (SQLException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }

    }
    public Matricula buscarPorId(Integer id) {
        try {
            Matricula m = new Matricula();
            

            PreparedStatement stmt = this.con.prepareStatement("select id, status from matricula where id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {               
                m.setId(rs.getInt("id"));
                m.setStatus(rs.getString("status"));
            }
            rs.close();
            stmt.close();
            ConnectionFactory.closeConexao(this.con);
            
            return m;

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
}
