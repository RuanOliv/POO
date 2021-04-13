
package escola.dao;

import escola.app.App;
import escola.modelo.Aluno;
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

public class AlunoDao {
    List<Aluno> alunos = new ArrayList<>();
    
    public static Integer salvar(Aluno a) {
        Integer last_inserted_id = null;
        try {
            
            Connection con = ConnectionFactory.getConexao();
            PreparedStatement stmt = con.prepareStatement("insert into aluno(nome,matricula)values(?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getMatricula());
           
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
    public static void getAlunos(List<Aluno> alunos){
        try {
                    Connection con = ConnectionFactory.getConexao();
                    PreparedStatement stmt = con.prepareStatement("select id, nome, matricula from aluno");
                    ResultSet rs = stmt.executeQuery();

                    while (rs.next()) {
                        Aluno a = new Aluno();
                        a.setId(rs.getInt("id"));
                        a.setNome(rs.getString("nome"));
                        a.setMatricula(rs.getString("matricula"));
                        alunos.add(a);
                    }
                    rs.close();
                    stmt.close();
                    ConnectionFactory.closeConexao(con);

                } catch (SQLException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }

    }
}
