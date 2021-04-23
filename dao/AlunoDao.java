package escola.dao;
import escola.app.App;
import escola.modelo.Aluno;
import escola.util.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDao extends Dao {

    public Boolean atualizar(Aluno a) {
        try {

            PreparedStatement stmt = this.con.prepareStatement("update aluno set nome=? where id=?");
            stmt.setString(1, a.getNome());
            stmt.setInt(2, a.getId());
            stmt.executeUpdate();
            stmt.close();
            ConnectionFactory.closeConexao(this.con);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Integer salvar(Aluno a) {
        Integer last_inserted_id = null;
        try {

            PreparedStatement stmt = this.con.prepareStatement("insert into aluno(nome,matricula)values(?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getMatricula());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
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

            PreparedStatement stmt = this.con.prepareStatement("delete from aluno where id=?");
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

    public List<Aluno> getAlunos() {
        try {
            
            List<Aluno> alunos = new ArrayList<>();

            PreparedStatement stmt = this.con.prepareStatement("select id, nome, matricula from aluno");
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
            ConnectionFactory.closeConexao(this.con);
            
            return alunos;

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
        
        public Aluno buscarPorId(Integer id) {
        try {
            Aluno a = new Aluno();
            

            PreparedStatement stmt = this.con.prepareStatement("select id, nome, matricula from aluno where id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {               
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setMatricula(rs.getString("matricula"));
            }
            rs.close();
            stmt.close();
            ConnectionFactory.closeConexao(this.con);
            
            return a;

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}