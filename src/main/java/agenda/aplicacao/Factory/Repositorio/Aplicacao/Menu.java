package agenda.aplicacao.Factory.Repositorio.Aplicacao;

import agenda.aplicacao.Classes.Agenda;
import agenda.aplicacao.Factory.Repositorio.agendaDB;

import java.util.Scanner;

public class Menu {
    private static final Agenda agenda = new Agenda();

    public static void Todolist(){
        Scanner ler = new Scanner(System.in);

        System.out.println("Digite uma dessas opções:");
        System.out.println(" ");
        System.out.println("1 para adicionar uma tarefa.");
        System.out.println("2 para atualizar os status da tarefa.");
        System.out.println("3 para vizualizar as tarefas a serem feitas.");
        System.out.println("4 para deletar alguma tarefa.");
        System.out.println(" ");
        switch (ler.nextInt()){

            case 1:
                System.out.println("Digite a sua tarefa");
                String tarefa = ler.nextLine();
                agenda.setTask(tarefa);
                System.out.println("Digite um indentificador(numero) para essa tarefa:");
                int num = ler.nextInt();
                agenda.setId(num);
                agendaDB.insert(agenda);
                break;
            case 2:
                System.out.println("Digite o id ta tarefa que voce realizou: ");
                int id = ler.nextInt();
                agendaDB.update(true,id);
                break;
            case 3:
                System.out.println("Listando as tarefas a serem realizadas...");
                agendaDB.select();
                break;
            case 4:
                System.out.println("Digite o id da tarefa que queira excluir");
                int id2 = ler.nextInt();
                agendaDB.delete(id2);
                break;
            default:
                System.out.println("Fechando o programa...");
        }
    }
}
