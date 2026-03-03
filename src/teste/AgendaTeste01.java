package teste;

import dominio.Contato;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaTeste01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Contato> agenda = new ArrayList<Contato>();

        while (true) {
            showMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 0:
                    return;
                case 1:
                    adicionarContato(agenda, scanner);
                    break;
                case 2:
                    listarContatos(agenda);
                    break;
                case 3:
                    procurarContato(agenda, scanner);
                    break;
                case 4:
                    excluirContato(agenda, scanner);
                    break;
                default:
                    separadorLinha();
                    System.out.println("Opção inválida");
                    separadorLinha();
            }
        }
    }

    public static void adicionarContato(List<Contato> agenda, Scanner scanner){
        System.out.println("Digite o nome do contato: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o numero do contato: ");
        String numero = scanner.nextLine();

        System.out.println("Digite o e-mail do contato: ");
        String email = scanner.nextLine();

        Contato contato = new Contato(nome, numero, email);
        agenda.add(contato);

        separadorLinha();
        System.out.println("Contato adicionado com sucesso!");
        separadorLinha();

    }

    public static void listarContatos(List<Contato> agenda){
        for (int i = 0; i < agenda.size(); i++) {
            separadorLinha();
            System.out.println("Contato: "+(1+i));
            System.out.println(agenda.get(i).toString());
            separadorLinha();
        }
    }

    public static void procurarContato(List<Contato> agenda, Scanner scanner){
        System.out.println("Informe o nome do contato: ");
        String procurar = scanner.nextLine();

        boolean contatoEncontrado = false;

        for (int i = 0; i < agenda.size() ; i++){
            if (procurar.equals(agenda.get(i).getNome())){
                separadorLinha();
                System.out.println("Contato encontrado com sucesso! ");
                System.out.println(agenda.get(i).toString());
                separadorLinha();
                contatoEncontrado = true;
                break;
            }
        }
        if (!contatoEncontrado){
            separadorLinha();
            System.out.println("Contato não encontrado");
            separadorLinha();
        }
    }

    public static void excluirContato(List<Contato> agenda, Scanner scanner){
        System.out.println("Informe o nome do contato que deseja excluir: ");
        String procurar = scanner.nextLine();

        boolean contatoEncontrado = false;

        for (int i = 0; i < agenda.size() ; i++){
            if (procurar.equals(agenda.get(i).getNome())){
                agenda.remove(i);
                separadorLinha();
                System.out.println("Contato excluido com sucesso!");
                separadorLinha();
                contatoEncontrado = true;
                break;
            }
        }
        if (!contatoEncontrado){
            separadorLinha();
            System.out.println("Contato não encontrado");
            separadorLinha();
        }
    }

    public static void showMenu() {
        System.out.println("Menu de opções da Agenda");
        System.out.println("(1) - Adicionar contato");
        System.out.println("(2) - Listar contatos");
        System.out.println("(3) - Procurar contato");
        System.out.println("(4) - Excluir contato");
        System.out.println("(0) - Sair");
    }

    public static void separadorLinha(){
        System.out.println("=========================================================================");
    }
}
