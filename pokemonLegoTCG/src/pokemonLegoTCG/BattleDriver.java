package pokemonLegoTCG;

import java.util.ArrayList;
import java.util.Random;

public class BattleDriver {
    public IA oponente;
    public Entrenador jugador;
    public int currentTurn; //0 para ia, 1 para jugador
    public BattleDriver(IA opponent, Entrenador player){
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

    public void chooseStarter(){
        Random random = new Random();
        currentTurn = random.nextInt(2); //numero random desde 0 hasta 1
    }

    public void turn(){
        if(currentTurn==0)
            this.opponentTurn();
        else
            this.playerTurn();
    }
    public void playerTurn(){

    }

    public void opponentTurn(){
        this.oponente.attack(this.jugador);
    }
}
