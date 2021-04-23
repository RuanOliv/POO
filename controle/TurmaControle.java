package escola.controle;

import escola.dao.DaoFactory;
import escola.modelo.Turma;
import java.util.List;


public class TurmaControle {
    
    public static Turma cadastrarTurma(String nome, String turno, String serie){
        
        Turma t = new Turma();
        t.setNome(nome);
        t.setTurno(turno);
        t.setSerie(serie);
        
        t.setId(DaoFactory.getTurmaDao().salvar(t));
        
        return t;
        
    }
    public static List<Turma> listar(){
        
        return DaoFactory.getTurmaDao().getTurmas();
        
    }
    
    public static Boolean delete(Integer id){
        
        return DaoFactory.getTurmaDao().delete(id);
        
    }
    
    
    public static Boolean atualizar(Integer id, String turno, String nome, String serie){
        Turma t = new Turma();
        t.setId(id); 
        t.setNome(nome);
        t.setTurno(turno);
        t.setSerie(serie);
        
        return DaoFactory.getTurmaDao().atualizar(t);
        
    }
    
    public static Turma buscarPorId(Integer id){
        
        return DaoFactory.getTurmaDao().buscarPorId(id);
        
    }
    
    
}