package escola.controle;

import escola.modelo.Aluno;
import escola.modelo.Matricula;
import escola.modelo.Turma;



public class MatriculaControle {
    
    public static Matricula cadastrarMatricula(String status){
        
        Matricula m = new Matricula();
        m.setStatus(status);
        
        return m;
        
    }
    
}