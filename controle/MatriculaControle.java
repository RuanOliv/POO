package escola.controle;

import escola.dao.DaoFactory;
import java.util.List;
import escola.modelo.Matricula;




public class MatriculaControle {
    
    public static Matricula cadastrarMatricula(String status){
        
        Matricula m = new Matricula();
        m.setStatus(status);
        
        m.setId(DaoFactory.getMatriculaDao().salvar(m));
        return m;
        
    }
    public static List<Matricula> listar(){
        
        return DaoFactory.getMatriculaDao().getMatriculas();
        
    }
    public static Boolean delete(Integer id){
        
        return DaoFactory.getMatriculaDao().delete(id);
        
    }
    
    
    public static Boolean atualizar(Integer id, String status){
        Matricula m = new Matricula();
        m.setId(id);
        m.setStatus(status);
        
        return DaoFactory.getMatriculaDao().atulizar(m);
        
    }
    
    public static Matricula buscarPorId(Integer id){
        
        return DaoFactory.getMatriculaDao().buscarPorId(id);
        
    }
    
}