package pokemonLegoTCG;

import java.util.ArrayList;
import java.util.Random;

public class BattleDriver {
    public IA oponente;
    public Entrenador jugador;
    public int currentTurn; //0 para ia, 1 para jugador

    //hay que definir aquí un bufferedStream para recibir los input de texto.
    public BattleDriver(IA opponent, Entrenador player) {
        oponente = opponent;
        jugador = player;
    }


    /**
     * Método que entrega la lista de ataques del Pokemon activo del jugador, en formato de lista.
     *
     * @return String que lista los ataques.
     */
    public String displayActivePokemonAttacks() {
        ArrayList<Ataque> lista = this.jugador.getAttacks();
        String display = "";
        for (Ataque i : lista) {
            display += i.getName() + "\n";
        }
        return display;
    }

    /**
     * Metodo que determina cual entrenador comienza la batalla
     */
    public void chooseStarter() {
        Random random = new Random();
        currentTurn = random.nextInt(2); //numero random desde 0 hasta 1
    }

    /**
     * Metodo general para
     */
    public void turn(){
        if(currentTurn==0) {
            this.opponentTurn();
            currentTurn = 1; //le toca al jugador
        }
        else {
            this.playerTurn();
            currentTurn = 0; //le toca a la ia
        }
    }
    public void playerTurn(){
        Accion accion= this.playerChooseAction();
        accion.isUsed(this);
        while(!accion.nombre.equals("ataque")) { //infinitas elecciones hasta que se elige atacar
            accion = this.playerChooseAction();
            accion.isUsed(this);
        }




        //se notifica si el pokemon enemigo muere
    }

    /**
     * Metodo que regula la eleccion de la eleccion del jugador durante su turno.
     * @return Accion elegida
     */
    public Accion playerChooseAction(){
        //dar lista de opciones
        //en mpv 3, debe ser estilizado para el ladrillo, con refreshes de la pantalla
        Accion accion = null;
        //eleccion de la accion, por consola ahora, estilizado para el mpv3

        return accion;
    }

    /**
     * Metodo que describe la forma en que se ataca al jugador.
     */
    public void opponentTurn(){
        this.oponente.attack(this.jugador);
        Boolean activePokemonDown = this.jugador.isActivePokemonDown();

        //ver cómo se notifica al driver
    }

    public Ataque playerChooseAttack(){
        //display de los ataques
        //eleccion de los ataques
        int index = 0; //cambiar 0 por metodo de eleccion del ataque.
        Ataque ataque = jugador.selectAttack(index);
        return ataque;
    }
}
