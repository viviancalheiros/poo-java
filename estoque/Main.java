package estoque;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        Produto[] estoque = new Produto[20];
        int qtd_produtos = 0;

        do {
            System.out.println("\n1 - Cadastrar produto");
            System.out.println("2 - Mostrar dados de um produto");
            System.out.println("3 - Acrescentar no estoque");
            System.out.println("4 - Saída do estoque");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            String nome;
            int qtd_estoque;
            double preco;

            if (opcao == 1) {
                System.out.print("Nome do produto: ");
                nome = scanner.nextLine();
                System.out.print("Preço: ");
                preco = scanner.nextDouble();
                System.out.print("Quantidade: ");
                qtd_estoque = scanner.nextInt();
                estoque[qtd_produtos] = new Produto(nome, preco, qtd_estoque);
                qtd_produtos++;
            } 
            else if (opcao == 2) {
                System.out.print("Nome do produto: ");
                nome = scanner.nextLine();
                for (int i = 0; i < qtd_produtos; i++) {
                    if (nome.equals(estoque[i].getNome())) {
                        estoque[i].exibirProduto();
                        break;
                    }
                }
            } 
            else if (opcao == 3) {
                System.out.print("Nome do produto: ");
                nome = scanner.nextLine();
                for (int i = 0; i < qtd_produtos; i++) {
                    if (nome.equals(estoque[i].getNome())) {
                        System.out.print("Quantidade: ");
                        qtd_estoque = scanner.nextInt();
                        estoque[i].aumentaEstoque(qtd_estoque);
                        estoque[i].exibirProduto();
                        break;
                    }
                }
            } 
            else if (opcao == 4) {
                System.out.print("Nome do produto: ");
                nome = scanner.nextLine();
                for (int i = 0; i < qtd_produtos; i++) {
                    if (nome.equals(estoque[i].getNome())) {
                        System.out.print("Quantidade: ");
                        qtd_estoque = scanner.nextInt();
                        estoque[i].diminuiEstoque(qtd_estoque);
                        estoque[i].exibirProduto();
                        break;
                    }
                }
            }
        } while (opcao != 0);

        scanner.close();
    }
}
