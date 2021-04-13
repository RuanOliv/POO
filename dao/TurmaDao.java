
package escola.dao;

import escola.app.App;
import escola.modelo.Turma;
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

public class TurmaDao {
    List<Turma> turmas = new ArrayList<>();
    
    public static Integer salvar(Turma t) {
        Integer last_inserted_id = null;
        try {
            
            Connection con = ConnectionFactory.getConexao();
            PreparedStatement stmt = con.prepareStatement("insert into turma(nome,turno,serie)values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
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
            ConnectionFactory.closeConexao(con);
            

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return last_inserted_id;
    }  
    public static void getTurmas(List<Turma> turmas){
        try {
                    Connection con = ConnectionFactory.getConexao();
                    PreparedStatement stmt = con.prepareStatement("select id, nome, turno, serie from turma");
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
                    ConnectionFactory.closeConexao(con);

                } catch (SQLException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }

    }
}
