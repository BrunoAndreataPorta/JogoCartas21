import model.Baralho;
import model.Dealer;
import model.Jogador;

import java.util.Scanner;

/*
Regra do 21 consiste em alcançar uma soma de cartas o mais próximo possível de 21,
sem ultrapassá-lo. O Ás vale 1, as cartas de 2 a 10 valem
o número correspondente e o valete, dama e rei valem 10.
O jogador compete contra o dealer, tentando fazer uma pontuação maior,
mas sem passar de 21, o que resulta em perda imediata. (OBS: O "dealer" é obrigado
a comprar cartas até chegar no mínimo em 17 pontos).
Ambos começam com 2 cartas.
 */

public class JogarJogo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Jogador jogador = new Jogador();
        Dealer dealer = new Dealer();

        //Criar o Baralho
        Baralho baralho = new Baralho();
        baralho.embaralhar();

        System.out.println("Vamos comecar o jogo!");

        // Jogador compra duas cartas
        jogador.adicionarCarta(baralho.tirarCarta());
        jogador.adicionarCarta(baralho.tirarCarta());

        // Dealer compra duas cartas
        dealer.adicionarCarta(baralho.tirarCarta());
        dealer.adicionarCarta(baralho.tirarCarta());

        // Mostra a mao
        System.out.println("Suas cartas atuais sao:");
        jogador.verMao();

        String resposta = "Y";
        while(resposta.equalsIgnoreCase("Y")){
            System.out.println("Deseja comprar uma carta? (Digite Y para sim ou qualquer outra coisa para não)");
            resposta = sc.nextLine();

            if (resposta.equalsIgnoreCase("Y")) {
                jogador.adicionarCarta(baralho.tirarCarta());

                System.out.println("Suas cartas atuais sao:");
                jogador.verMao();

                // Verificar se o jogador estourou
                if (jogador.calcularPontuacao() > 21) {
                    System.out.println("Voce estourou! Dealer vence.");
                    return;
                }
            }
        }

        System.out.println("E a vez do dealer tirar as cartas!");
        dealer.jogar(baralho);

        System.out.println("Cartas do dealer sao:");
        dealer.verMao();

        System.out.println();
        System.out.println("A sua pontuação final é: " + jogador.calcularPontuacao());
        System.out.println("A pontuação final do dealer é: " + dealer.calcularPontuacao());
        System.out.println();

        if (dealer.calcularPontuacao() > 21 || jogador.calcularPontuacao() > dealer.calcularPontuacao()) {
            System.out.println("Você venceu!");
        } else if (jogador.calcularPontuacao() == dealer.calcularPontuacao()) {
            System.out.println("Empate!");
        } else {
            System.out.println("Dealer venceu!");
        }
    }
}
