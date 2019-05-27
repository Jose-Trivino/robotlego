package pokemonLegoTCG;

import java.util.LinkedList;

public class Example {

    public void run(){
        LinkedList<Pokemon> pokemonesEntrenador = null;
        Pokemon pokemon = null;
        Entrenador jugador = new Entrenador(pokemonesEntrenador);
        Oponente oponente = new Oponente(pokemon);

        BattleDriver battleDriver = new BattleDriver(oponente,jugador);
        battleDriver.setReferences();
        battleDriver.chooseStarter();
        battleDriver.turn();




    }
    public static void main(String[] args){
        new Example().run();
    }

}
