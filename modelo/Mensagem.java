
package escola.modelo;

import java.util.Date;

public class Mensagem {
    

    private String descricao;
    private Date data; 
    private String tipo; 

    
    public void setDescricao (String descricao){
        this.descricao = descricao;
    }
     public void setData (Date data){
        this.data = data;
    }
      public void setTipo (String tipo){
        this.tipo = tipo;
    }
       public String getDescricao (){
        return this.descricao;
    }
     public Date getData (){
        return this.data;
    }
      public String getTipo (){
        return this.tipo;
    }
   
}
