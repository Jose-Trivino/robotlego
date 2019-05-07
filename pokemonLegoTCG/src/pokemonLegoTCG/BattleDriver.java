package pokemonLegoTCG;

import java.util.ArrayList;

public class BattleDriver {
    public Entrenador oponente;
    public Entrenador jugador;

    public BattleDriver(Entrenador opponent, Entrenador player){
        oponente = opponent;
        jugador = player;
    }

    public String displayActivePokemonAttacks(){
        ArrayList<Ataque> lista = this.jugador.getAttacks();
        String display="";
        for(Ataque i:lista){
            display+=i.getName()+"\n";
        }
        return display;
    }



}
