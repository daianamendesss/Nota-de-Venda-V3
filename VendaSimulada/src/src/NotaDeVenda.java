package src;

import java.util.Scanner;

public class NotaDeVenda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Produto[] produtos = {
            new Produto("Produto A", 10.0),
            new Produto("Produto B", 20.0),
            new Produto("Produto C", 15.0)
        };

        double valorTotal = 0;

        System.out.println("Lista de produtos:");
        for (int i = 0; i < produtos.length; i++) {
            System.out.printf("%d. %s - R$%.2f\n", i + 1, produtos[i].getNome(), produtos[i].getPreco());
        }

        System.out.println("\nInforme a quantidade para cada produto:");
        for (Produto produto : produtos) {
            System.out.printf("%s: ", produto.getNome());
            int quantidade = scanner.nextInt();
            produto.setQuantidade(quantidade);
            valorTotal += produto.calcularTotal();
        }

        System.out.println("\nEscolha a forma de pagamento:");
        System.out.println("1. Cartão de Crédito (5% de juros)");
        System.out.println("2. Cartão de Débito (sem juros)");
        System.out.println("3. Dinheiro/Pix (5% de desconto)");
        int formaPagamento = scanner.nextInt();

        double valorFinal = Pagamento.calcularValorFinal(valorTotal, formaPagamento);
        String formaPagamentoTexto = Pagamento.obterFormaPagamento(formaPagamento);

        System.out.println("\nNota de Venda:");
        for (Produto produto : produtos) {
            if (produto.getQuantidade() > 0) {
                System.out.printf("%s: %d x R$%.2f = R$%.2f\n", 
                    produto.getNome(), produto.getQuantidade(), produto.getPreco(), produto.calcularTotal());
            }
        }
        System.out.printf("\nValor Total: R$%.2f\n", valorTotal);
        System.out.printf("Forma de Pagamento: %s\n", formaPagamentoTexto);
        System.out.printf("Valor a Pagar: R$%.2f\n", valorFinal);

        scanner.close();
    }
}
