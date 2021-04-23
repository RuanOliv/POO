/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escola.visao;

import static escola.app.App.menu;
import escola.controle.AlunoControle;
import escola.dao.DaoFactory;
import escola.modelo.Aluno;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Linkdesign
 */
public class AlunoForm {

    private static Scanner teclado = new Scanner(System.in);

    public static void salvar() {

        System.out.println("Digite o nome do aluno: ");
        String nome = teclado.nextLine();
        System.out.println("Digite a matricula: ");
        String matricula = teclado.nextLine();
        AlunoControle.cadastrarAluno(nome, matricula);
    }
    
    public static void listar(){
        
        List<Aluno> alunos = AlunoControle.listar();
        System.out.println("----- ALUNOS CADASTRADOS -------");
        System.out.println("NOME                 | MATRICULA");
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome() + " | " + aluno.getMatricula());            
        }
        
    }
    
    public static Boolean delete(){
        System.out.println("----- DELETAR ALUNO -------");
        System.out.println("Digite o id do aluno: ");
        Integer id = Integer.parseInt(teclado.nextLine());
   
        return AlunoControle.delete(id);
        
    }
    
    
    public static void atualizar(){
        System.out.println("----- ATUALIZAR ALUNO -------");
        System.out.println("Digite o id do aluno: ");
        Integer id = Integer.parseInt(teclado.nextLine());

        if(buscarPorId(id)!=null){
            System.out.println("Digite o nome do aluno: ");
            String nome = teclado.nextLine();
            System.out.println("Digite a matricula: ");
            String matricula = teclado.nextLine();
            AlunoControle.atualizar(id, nome, matricula);
        }else{
            System.out.println("Aluno não encontrado.");
        }
        
        
    }
    
    public static Aluno buscarPorId(Integer id){
        
        return DaoFactory.getAlunoDao().buscarPorId(id);
        
    }

}