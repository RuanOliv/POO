/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escola.visao;

import static escola.app.App.menu;
import escola.controle.TurmaControle;
import escola.dao.DaoFactory;
import escola.modelo.Turma;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Linkdesign
 */
public class TurmaForm {

    private static Scanner teclado = new Scanner(System.in);

    public static void salvar() {

        System.out.println("Digite o nome da turma: ");
        String nome = teclado.nextLine();
        System.out.println("Digite o turno: ");
        String turno = teclado.nextLine();
        System.out.println("Digite a serie: ");
        String serie = teclado.nextLine();


        TurmaControle.cadastrarTurma(nome,turno,serie);
    }
    
    public static void listar(){
        
        List<Turma> turmas = TurmaControle.listar();
        System.out.println("----- MATRICULAS CADASTRADAS -------");
        System.out.println("NOME              | TURNO             | SERIE");
        for (Turma turma : turmas) {
            System.out.println(turma.getNome()+ " | " + turma.getTurno()+ " | " + turma.getSerie());            
        }
        
    }
    
    public static Boolean delete(){
        System.out.println("----- DELETAR TURMA -------");
        System.out.println("Digite o id da turma: ");
        Integer id = Integer.parseInt(teclado.nextLine());
   
        return TurmaControle.delete(id);
        
    }
    
    
    public static void atualizar(){
        System.out.println("----- ATUALIZAR TURMA -------");
        System.out.println("Digite o id do turma: ");
        Integer id = Integer.parseInt(teclado.nextLine());
        

        if(buscarPorId(id)!=null){
            System.out.println("Digite o nome da turma: ");
            String nome = teclado.nextLine();
            System.out.println("Digite o turno: ");
            String turno = teclado.nextLine();
            System.out.println("Digite a serie: ");
            String serie = teclado.nextLine();
            TurmaControle.atualizar(id, nome, turno, serie);
        }else{
            System.out.println("Matricula não encontrado.");
        }
        
        
    }
    
    public static Turma buscarPorId(Integer id){
        
        return DaoFactory.getTurmaDao().buscarPorId(id);
        
    }

}