  
package escola.app;

import escola.controle.AlunoControle;
import escola.controle.MatriculaControle;
import escola.controle.TurmaControle;
import escola.dao.AlunoDao;
import escola.dao.MatriculaDao;
import escola.dao.TurmaDao;
import escola.modelo.Aluno;
import escola.modelo.Matricula;
import escola.modelo.Turma;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App{

    public static void main(String[] args) {

        List<Aluno> alunos = new ArrayList<>();
        List<Turma> turmas = new ArrayList<>();
        List<Matricula> matriculas = new ArrayList<>();

        int opcao = 7;
        Scanner teclado = new Scanner(System.in);

        do {

            menu();
            opcao = Integer.parseInt(teclado.nextLine());

            switch(opcao) {
                case 1:
                System.out.println("Digite o nome do aluno: ");
                String nome = teclado.nextLine();
                System.out.println("Digite a matricula: ");
                String matricula = teclado.nextLine();

                Aluno a1 = AlunoControle.cadastrarAluno(nome, matricula);
                a1.setId(AlunoDao.salvar(a1));
                System.out.println("id: " + a1.getId());
                AlunoDao.getAlunos(alunos);
                break;
                case 2:
                System.out.println("Digite o nome da turma: ");
                String nometurma = teclado.nextLine();
                System.out.println("Digite o turno: ");
                String turno = teclado.nextLine();
                System.out.println("Digite a serie: ");
                String serie = teclado.nextLine();

                Turma t1 = TurmaControle.cadastrarTurma(nometurma, turno, serie);
                t1.setId(TurmaDao.salvar(t1));
                System.out.println("id: " + t1.getId());
                TurmaDao.getTurmas(turmas);
                break;
                case 3:
                System.out.println("Digite o status da matricula: ");
                String status = teclado.nextLine();

                Matricula m1 = MatriculaControle.cadastrarMatricula(status);
                m1.setId(MatriculaDao.salvar(m1));
                System.out.println("id: " + m1.getId());
                MatriculaDao.getMatriculas(matriculas);
                break;
                case 4:
                listarAlunos(alunos);
                break;
                case 5:
                listarTurmas(turmas);
                break;
                case 6:
                listarMatriculas(matriculas);
                break;
            }
        } while (opcao != 7);

    }

    

    public static void menu() {
        System.out.println("Menu\n"
                + "---------------------------------\n"
                + "1 – Cadastrar Aluno\n"
                + "2 – Cadastrar Turma\n"
                + "3 – Matricular\n"
                + "4 – Listar Alunos\n"
                + "5 – Listar Turmas\n"
                + "6 – Listar Matrículas\n"
                + "7 – Sair\n"
                + "---------------------------------\n"
                + "\n"
                + "Digite a opção: ");
    }

    public static void listarAlunos(List<Aluno> alunos) {
        System.out.println("\n\n---------LISTANDO OS ALUNOS CADASTRADOS -----------\n");

        for (Aluno aluno : alunos) {
            System.out.println("Nome: " + aluno.getNome() + "  Matricula: " + aluno.getMatricula() + "\n");
        }
        
    }
    public static void listarTurmas(List<Turma> turmas) {
        System.out.println("\n\n---------LISTANDO OS ALUNOS CADASTRADOS -----------\n");

        for (Turma turma : turmas) {
            System.out.println("Nome: " + turma.getNome() + " -  Turno: " + turma.getTurno()+ " - Serie: " + turma.getSerie() + "\n");
        }
        
    }
    public static void listarMatriculas(List<Matricula> matriculas) {
        System.out.println("\n\n---------LISTANDO OS ALUNOS CADASTRADOS -----------\n");

        for (Matricula matricula : matriculas) {
            System.out.println("Status: " + matricula.getStatus() + "\n");
        }
        
    }
    
    

}