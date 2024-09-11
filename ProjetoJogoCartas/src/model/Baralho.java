package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private List<Carta> cartas = new ArrayList<>();

    //Método construtor deve montar o baralho
    public Baralho(){
        for(Naipe naipe : Naipe.values()){
            for(Valor valor : Valor.values()){
                Carta carta = new Carta(valor, naipe);
                cartas.add(carta);
            }
        }
    }

    //misturar - embaralhar
    public void embaralhar(){
        Collections.shuffle(cartas);
    }

    //remove a primeira carta do baralho
    public Carta tirarCarta() {
        if (!cartas.isEmpty()) {
            return cartas.remove(0);
        }
        return null;
    }

}
