package pokemonLegoTCG;

import java.util.LinkedList;

public class Example {

    public void run(){
        LinkedList<Pokemon> pokemonesEntrenador = null;
        Pokemon pokemon = null;
        Entrenador jugador = new Entrenador(pokemonesEntrenador);
        IA ia = new IA(pokemon);

        BattleDriver battleDriver = new BattleDriver(ia,jugador);
        battleDriver.chooseStarter();
        battleDriver.turn();




    }
    public static void main(String[] args){
        new Example().run();
    }

}
