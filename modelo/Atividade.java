
package escola.modelo;

import java.util.Date;

public class Atividade {
    
    private String descricao;
    private Date data; 
    private String disciplina; 
    private Turma turmas;
    
    public void setDescricao (String descricao){
        this.descricao = descricao;
    }
     public void setData (Date data){
        this.data = data;
    }
      public void setDisciplina (String disciplina){
        this.disciplina = disciplina;
    }
       public void setTurmas(Turma turmas){
        this.turmas = turmas;
    }
       public String getDescricao (){
        return this.descricao;
    }
     public Date getData (){
        return this.data;
    }
      public String getDisciplina (){
        return this.disciplina;
    }
       public Turma getTurmas (){
        return this.turmas;
    }
}
