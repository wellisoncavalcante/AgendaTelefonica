package teste;

import dominio.Contato;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgendaTeste01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Contato> agenda = new ArrayList<Contato>();

        while (true) {
            showMenu();
            if (!scanner.hasNextInt()) {
                mostrarMensagem("Digite apenas números");
                scanner.nextLine();
                continue;
            }
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 0:
                    scanner.close();
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
                    mostrarMensagem("Opção inválida");
            }
        }
    }

    public static void adicionarContato(List<Contato> agenda, Scanner scanner) {
        System.out.println("Digite o nome do contato: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o numero do contato: ");
        String numero = scanner.nextLine();

        System.out.println("Digite o e-mail do contato: ");
        String email = scanner.nextLine();

        if (!validarEmail(email)) {
            mostrarMensagem("Email inválido! Contato não adicionado.");
            return;
        }

        Contato contato = new Contato(nome, numero, email);
        agenda.add(contato);

        mostrarMensagem("Contato adicionado com sucesso!");

    }

    public static void listarContatos(List<Contato> agenda) {
        for (int i = 0; i < agenda.size(); i++) {
            mostrarMensagem("Contato: " + (1 + i));
            System.out.println(agenda.get(i).toString());
        }
    }

    public static void procurarContato(List<Contato> agenda, Scanner scanner) {
        System.out.println("Informe o nome do contato: ");
        String procurar = scanner.nextLine();

        boolean contatoEncontrado = false;

        for (int i = 0; i < agenda.size(); i++) {
            if (procurar.equals(agenda.get(i).getNome())) {
                mostrarMensagem("Contato encontrado com sucesso! ");
                System.out.println(agenda.get(i).toString());
                contatoEncontrado = true;
                break;
            }
        }
        if (!contatoEncontrado) {
            mostrarMensagem("Contato não encontrado");
        }
    }

    public static void excluirContato(List<Contato> agenda, Scanner scanner) {
        System.out.println("Informe o nome do contato que deseja excluir: ");
        String procurar = scanner.nextLine();

        boolean contatoEncontrado = false;

        for (int i = 0; i < agenda.size(); i++) {
            if (procurar.equals(agenda.get(i).getNome())) {
                agenda.remove(i);
                mostrarMensagem("Contato excluido com sucesso!");
                contatoEncontrado = true;
                break;
            }
        }
        if (!contatoEncontrado) {
            mostrarMensagem("Contato não encontrado");
        }
    }

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public static boolean validarEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static void showMenu() {
        System.out.println("Menu de opções da Agenda");
        System.out.println("(1) - Adicionar contato");
        System.out.println("(2) - Listar contatos");
        System.out.println("(3) - Procurar contato");
        System.out.println("(4) - Excluir contato");
        System.out.println("(0) - Sair");
    }

    public static void separadorLinha() {
        System.out.println("=========================================================================");
    }

    public static void mostrarMensagem(String mensagem) {
        separadorLinha();
        System.out.println(mensagem);
        separadorLinha();
    }
}
