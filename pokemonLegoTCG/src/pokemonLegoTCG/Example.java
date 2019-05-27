package pokemonLegoTCG;

import java.util.LinkedList;

public class Example {

    public void run(){
        LinkedList<Pokemon> pokemonesJugador = null;
        Pokemon pokemonActivo = null;
        LinkedList<Pokemon> pokemonesOponente = null; //ponerle cinco
        Entrenador jugador = new Entrenador(pokemonesJugador);
        Oponente oponente = new Oponente(pokemon);

        BattleDriver battleDriver = new BattleDriver(oponente,jugador);
        battleDriver.setReferences();
        System.out.println("Bienvenido al simulador de batallas");
        System.out.println(battleDriver.printDatosOponente());
        battleDriver.chooseStarter();
        while(algo)
            battleDriver.turn();

        battleDriver.announceWinner();





    }
    public static void main(String[] args){
        new Example().run();
    }

}
