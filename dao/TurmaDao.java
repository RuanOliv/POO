
package escola.dao;

import escola.app.App;
import escola.modelo.Turma;
import escola.util.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TurmaDao extends Dao {
    
    
    public Boolean atualizar(Turma t) {
        try {

            PreparedStatement stmt = this.con.prepareStatement("update turma set nome=? where id=?");
            stmt.setString(1, t.getNome());
            stmt.setInt(2, t.getId());
            stmt.executeUpdate();
            stmt.close();
            ConnectionFactory.closeConexao(this.con);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public Integer salvar(Turma t) {
        Integer last_inserted_id = null;
        try {
            
            
            PreparedStatement stmt = this.con.prepareStatement("insert into turma(nome,turno,serie)values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, t.getNome());
            stmt.setString(2, t.getTurno());
            stmt.setString(3, t.getSerie());
           
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

            PreparedStatement stmt = this.con.prepareStatement("delete from turma where id=?");
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
    public List<Turma> getTurmas(){
        try {
                   List<Turma> turmas = new ArrayList<>();
                    PreparedStatement stmt = this.con.prepareStatement("select id, nome, turno, serie from turma");
                    ResultSet rs = stmt.executeQuery();

                    while (rs.next()) {
                        Turma t = new Turma();
                        t.setId(rs.getInt("id"));
                        t.setNome(rs.getString("nome"));
                        t.setTurno(rs.getString("turno"));
                        t.setSerie(rs.getString("serie"));

                        turmas.add(t);
                    }
                    rs.close();
                    stmt.close();
                    ConnectionFactory.closeConexao(this.con);
                    return turmas;

                } catch (SQLException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }

    }
    public Turma buscarPorId(Integer id) {
        try {
            Turma t = new Turma();
            

            PreparedStatement stmt = this.con.prepareStatement("select id, nome, turno, serie from turma where id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {               
                t.setId(rs.getInt("id"));
                t.setNome(rs.getString("nome"));
                t.setTurno(rs.getString("turno"));
                t.setSerie(rs.getString("serie"));
            }
            rs.close();
            stmt.close();
            ConnectionFactory.closeConexao(this.con);
            
            return t;

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
}
}
