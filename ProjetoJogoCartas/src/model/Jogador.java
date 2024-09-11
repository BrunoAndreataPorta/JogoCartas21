package model;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private List<Carta> mao = new ArrayList<>();

    public List<Carta> getMao() {
        return mao;
    }

    public void adicionarCarta(Carta carta){
        mao.add(carta);
    }

    public int calcularPontuacao()
    {
        int pontuacao = 0;
        for(Carta carta : mao)
        {
            int valor = carta.getValor().getValorNumerico();
            pontuacao += valor;
        }

        return pontuacao;
    }

    public void verMao(){
        for(Carta carta : mao)
        {
            System.out.println(carta);
        }
    }

}
