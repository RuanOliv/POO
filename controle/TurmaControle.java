package escola.controle;

import escola.modelo.Turma;


public class TurmaControle {
    
    public static Turma cadastrarTurma(String nome, String turno, String serie){
        
        Turma t = new Turma();
        t.setNome(nome);
        t.setTurno(turno);
        t.setSerie(serie);
        
        return t;
        
    }
    
}