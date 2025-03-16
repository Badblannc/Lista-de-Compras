import java.util.ArrayList;
import java.util.Scanner;

class Item {
    String nome;
    int quantidade;
    String unidade;
    double valorUnitario;
    double total;

    public Item(String nome, int quantidade, String unidade, double valorUnitario) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.valorUnitario = valorUnitario;
        this.total = quantidade * valorUnitario;
    }
}

public class ListaDeCompras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lista para armazenar os itens comprados
        ArrayList<Item> itens = new ArrayList<>();

        System.out.print("Digite a quantidade total de itens que deseja comprar: ");
        int totalItens = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        int itensAdicionados = 0;
        double totalCompra = 0;

        do {
            System.out.println("\nDigite os detalhes do item #" + (itensAdicionados + 1) + ":");

            System.out.print("Nome do item: ");
            String nome = scanner.nextLine();

            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();

            System.out.print("Unidade do item (ex: kg, litros, unidades): ");
            scanner.nextLine(); // Consumir a quebra de linha
            String unidade = scanner.nextLine();

            System.out.print("Valor unitário: ");
            double valorUnitario = scanner.nextDouble();
            scanner.nextLine(); // Consumir a quebra de linha

            // Criar e armazenar o item
            Item item = new Item(nome, quantidade, unidade, valorUnitario);
            itens.add(item);

            totalCompra += item.total;
            itensAdicionados++;

            // Perguntar ao usuário se deseja continuar ou encerrar
            if (itensAdicionados < totalItens) {
                System.out.print("\nDeseja adicionar mais itens? (1 - Continuar, 2 - Encerrar): ");
                int escolha = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha

                if (escolha == 2) {
                    break;
                }
            }
        } while (itensAdicionados < totalItens);

        // Exibir o resumo da compra
        System.out.println("\nResumo da sua lista de compras:");
        for (Item item : itens) {
            System.out.printf("- %s: %d %s x R$ %.2f = R$ %.2f\n",
                    item.nome, item.quantidade, item.unidade, item.valorUnitario, item.total);
        }

        System.out.printf("\nTotal da compra: R$ %.2f\n", totalCompra);

        System.out.println("Obrigado por usar a lista de compras!");
        scanner.close();
    }
}
