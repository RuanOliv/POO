
package escola.modelo;

import java.util.Date;

public class Aluno extends Pessoa {
    
    
    private String matricula;
    
    
    public void setMatricula(String matricula){
        this.matricula = matricula; 
    }
    
    public String getMatricula(){
        return this.matricula;
    }
    
    
    public void CadastrarAluno(String nome, String logradouro, String numero, String bairro, String cidade, String uf, String cpf, String matricula){
        super.setNome(nome);
        super.setLogradouro(logradouro);
        super.setNumero(numero);
        super.setBairro(bairro);
        super.setCidade(cidade);
        super.setUf(uf);
        super.setCpf(cpf);
        this.setMatricula(matricula);
    }
    public void ListarAluno(){
        System.out.println("Listar Alunos");
        System.out.println("--------------------------");
        System.out.println("Nome    Nascimento  Logradouro  Numero  Bairro  Cidade  UF  CPF Matricula");
        System.out.println(super.getNome()+" "+super.getNascimento()+"    "+super.getLogradouro()+"    "+super.getNumero()
                +"    "+super.getBairro()+"  "+super.getCidade()+super.getUf()+"   "+super.getCpf()+"   "+this.getMatricula());
    }
}
