import java.sql.SQLOutput;
import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o limite do seu cartão de crédito: ");
        double limite = entrada.nextDouble();
        CartaoCredito cartao = new CartaoCredito(limite);

        int sair = 1;

        while (sair != 0) {
            System.out.println("Digite o que você deseja comprar: ");
            String descricao = entrada.next();

            System.out.println("Agora digite o valor de sua compra");
            double valor = entrada.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraFeita = cartao.lancaCompra(compra);
            if (compraFeita) {
                System.out.println("Sua compra foi feita com sucesso!!!");
                System.out.println("Se deseja continuar digite 1 ou digite 0 para sair");
                sair = entrada.nextInt();
            } else {
                System.out.println("Saldo insuficiente!!!");
                sair = 0;
            }
        }

        System.out.println("**********************");
        System.out.println("Compras realizadas:\n");
        Collections.sort(cartao.getCompras());
        for (Compra compra : cartao.getCompras()) {
            System.out.println(compra.getDescricao() + " - " + compra.getValor());
        }
        System.out.println("\n*********************");
        System.out.println("\nSaldo do cartão é: " + cartao.getSaldo());


        entrada.close();
    }
}