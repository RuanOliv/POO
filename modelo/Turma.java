
package escola.modelo;


public class Turma {
    private Integer id;
    private String nome;
    private String turno; 
    private String serie;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setNome (String nome){
        this.nome = nome;
    }
     public void setTurno (String turno){
        this.turno = turno;
    }
      public void setSerie (String serie){
        this.serie = serie;
    }
       public String getNome (){
        return this.nome;
    }
     public String getTurno (){
        return this.turno;
    }
      public String getSerie (){
        return this.serie;
    }
    
}


