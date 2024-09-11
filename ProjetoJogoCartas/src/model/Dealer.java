package model;

public class Dealer extends Jogador{
    public void jogar(Baralho baralho)
    {
        while(calcularPontuacao() < 17)
        {
            adicionarCarta(baralho.tirarCarta());
        }
    }
}
