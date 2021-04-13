
package escola.modelo;

import java.util.Date;


public class Matricula {
    
    private Integer id;
    private String status;
    private Date data;
    private Turma turma;
    private Aluno aluno;
    
     public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public void setData(Date data){
        this.data = data;
    }
    public void setTurma(Turma turma){
        this.turma = turma;
    }
    public void setAluno (Aluno aluno){
        this.aluno = aluno;
    }
    public String getStatus(){
        return this.status;
    }
    public Date getData(){
        return this.data;
    }
    public Turma getTurma(){
        return this.turma;
    }
    public String getAluno(){
        return this.aluno.getNome();
    }
   
}
