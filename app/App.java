package escola.app;

import escola.modelo.Aluno;
import escola.modelo.Turma;
import escola.visao.AlunoForm;
import escola.visao.MatriculaForm;
import escola.visao.TurmaForm;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {

    public static void main(String[] args) {

        List<Aluno> alunos = new ArrayList<>();
        List<Turma> turmas = new ArrayList<>();

        int opcao = 0;
        Scanner teclado = new Scanner(System.in);

        do {

            menu();
            opcao = Integer.parseInt(teclado.nextLine());

            switch (opcao) {
                case 1:
                    AlunoForm.salvar();
                    break;
                case 2:
                    TurmaForm.salvar();
                    break;    
                case 3:
                    MatriculaForm.salvar();
                    break;
                case 4:
                    AlunoForm.listar();
                    break;
                case 5:
                    TurmaForm.listar();
                    break;    
                case 6:
                    MatriculaForm.listar();
                    break;
                case 7:
                    AlunoForm.atualizar();
                    break;
                case 8:
                    TurmaForm.atualizar();
                    break;
                case 9:
                    MatriculaForm.atualizar();
                    break;
                case 10:
                    AlunoForm.delete();
                    break;
                case 11:
                    TurmaForm.delete();
                    break;
                case 12:
                    MatriculaForm.delete();
                    break;

            }

        } while (opcao != 0);

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
                + "7 - Atualizar Aluno\n"                                
                + "8 - Atualizar Turma\n"
                + "9 - Atualizar Matricula\n"
                + "10 - Deletar Aluno\n"
                + "11 - Deletar Turma\n"
                + "12 - Deletar Matricula\n"
                + "0 – Sair\n"
                + "---------------------------------\n"
                + "\n"
                + "Digite a opção: ");
    }


}