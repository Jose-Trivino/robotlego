package pokemonLegoTCG;

import java.util.ArrayList;

public class BattleDriver {
    public Entrenador oponente;
    public Entrenador jugador;

    public BattleDriver(Entrenador opponent, Entrenador player){
        oponente = opponent;
        jugador = player;
    }

    /**
     * Método que entrega la lista de ataques del Pokemon activo del jugador, en formato de lista.
     * @return String que lista los ataques.
     */
    public String displayActivePokemonAttacks(){
        ArrayList<Ataque> lista = this.jugador.getAttacks();
        String display="";
        for(Ataque i:lista){
            display+=i.getName()+"\n";
        }
        return display;
    }

    public void playerTurn(){

    }
    public void main(String[] args){ //not sure if it should be here.

    }
}
