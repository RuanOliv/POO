/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escola.visao;

import static escola.app.App.menu;
import escola.controle.MatriculaControle;
import escola.dao.DaoFactory;
import escola.modelo.Aluno;
import escola.modelo.Matricula;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Linkdesign
 */
public class MatriculaForm {

    private static Scanner teclado = new Scanner(System.in);

    public static void salvar() {

        System.out.println("Digite o status da matricula: ");
        String status = teclado.nextLine();

        MatriculaControle.cadastrarMatricula(status);
    }
    
    public static void listar(){
        
        List<Matricula> matriculas = MatriculaControle.listar();
        System.out.println("----- MATRICULAS CADASTRADAS -------");
        System.out.println("STATUS");
        for (Matricula matricula : matriculas) {
            System.out.println(matricula.getStatus());            
        }
        
    }
    
    public static Boolean delete(){
        System.out.println("----- DELETAR MATRICULA -------");
        System.out.println("Digite o id da matricula: ");
        Integer id = Integer.parseInt(teclado.nextLine());
   
        return MatriculaControle.delete(id);
        
    }
    
    
    public static void atualizar(){
        System.out.println("----- ATUALIZAR MATRICULA -------");
        System.out.println("Digite o id do matricula: ");
        Integer id = Integer.parseInt(teclado.nextLine());

        if(buscarPorId(id)!=null){
            System.out.println("Digite o status da matricula: ");
            String status = teclado.nextLine();
            MatriculaControle.atualizar(id, status);
        }else{
            System.out.println("Matricula não encontrado.");
        }
        
        
    }
    
    public static Matricula buscarPorId(Integer id){
        
        return DaoFactory.getMatriculaDao().buscarPorId(id);
        
    }

}