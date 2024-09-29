package view;

import java.util.Scanner;

public class Main {
    private static Sistema sistema = new Sistema();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Adicionando um usuário de exemplo
        sistema.cadastrarUsuario("admin", "admin123");

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Cadastrar Usuário");
            System.out.println("3. Cadastrar Produto");
            System.out.println("4. Consultar Produtos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();  // Limpar buffer

            switch (escolha) {
                case 1:
                    realizarLogin();
                    break;
                case 2:
                    cadastrarUsuario();
                    break;
                case 3:
                    cadastrarProduto();
                    break;
                case 4:
                    consultarProdutos();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void realizarLogin() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        if (sistema.autenticar(username, senha)) {
            System.out.println("Login bem-sucedido.");
        } else {
            System.out.println("Login falhou. Verifique seu usuário e senha.");
        }
    }

    private static void cadastrarUsuario() {
        System.out.print("Digite o nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        if (sistema.cadastrarUsuario(username, senha)) {
            System.out.println("Usuário cadastrado com sucesso.");
        } else {
            System.out.println("Usuário já existe. Escolha outro nome de usuário.");
        }
    }

    private static void cadastrarProduto() {
        System.out.print("Número de identificação: ");
        int identificacao = scanner.nextInt();
        scanner.nextLine();  // Limpar buffer
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Preço do produto: ");
        double preco = scanner.nextDouble();
        System.out.print("Quantidade do produto: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();  // Limpar buffer

        sistema.adicionarProduto(new Produto(identificacao, nome, preco, quantidade));
        System.out.println("Produto cadastrado com sucesso.");
    }

    private static void consultarProdutos() {
        System.out.println(sistema.consultarProdutos());
    }
}
