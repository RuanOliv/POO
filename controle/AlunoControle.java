package escola.controle;

import escola.modelo.Aluno;


public class AlunoControle {
    
    public static Aluno cadastrarAluno(String nome, String matricula){
        
        Aluno a = new Aluno();
        a.setNome(nome);
        a.setMatricula(matricula);
        
        return a;
        
    }
    
}