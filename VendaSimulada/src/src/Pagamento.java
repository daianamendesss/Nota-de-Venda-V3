package src;

public class Pagamento {
    public static final int CREDITO = 1;
    public static final int DEBITO = 2;
    public static final int DINHEIRO_PIX = 3;

    public static double calcularValorFinal(double valorTotal, int formaPagamento) {
        switch (formaPagamento) {
            case CREDITO:
                return valorTotal * 1.05;
            case DINHEIRO_PIX:
                return valorTotal * 0.95; 
            case DEBITO:
            default:
                return valorTotal; 
        }
    }

    public static String obterFormaPagamento(int formaPagamento) {
        switch (formaPagamento) {
            case CREDITO:
                return "Cartão de Crédito";
            case DEBITO:
                return "Cartão de Débito";
            case DINHEIRO_PIX:
                return "Dinheiro/Pix";
            default:
                return "Forma de pagamento desconhecida";
        }
    }
}