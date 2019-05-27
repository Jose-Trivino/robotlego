package pokemonLegoTCG;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BattleDriver {
    public Oponente oponente;
    public Entrenador jugador;
    public int currentTurn; //0 para ia, 1 para jugador
    public Scanner scanner = new Scanner(System.in);

    //hay que definir aquí un bufferedStream (input) para recibir los input de texto.


    public BattleDriver(Oponente opponent, Entrenador player) {
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
            System.out.print( | 30/60")
            System.out.print("Pikachu | 30/60")
            System.out.print("Turno del Oponente")
            this.opponentTurn();
            currentTurn = 1; //le toca al jugador
        }
        else {
            System.out.print("Turno del Oponente")
            System.out.print("Pikachu | 30/60")
            System.out.print("Turno del Jugador")
            this.playerTurn();
            currentTurn = 0; //le toca a la ia
        }
    }
    public void playerTurn(){
        Accion accion= this.playerChooseAction();
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
        System.out.print("Elige tu siguiente acción (1/2)")
        System.out.print("Atacar")
        System.out.print("Cambiar Pokémon")
        String nombre = this.scanner.nextLine();
        Accion accion;
        if(nombre.equals("ataque") || nombre.equals("cambiarPokemon"))
            accion = new Accion(nombre);
        else

        //eleccion de la accion, por consola ahora, estilizado para el mpv3

        //para imprimir:    System.out.print(texto)
        //                  System.out.println(texto)

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
        int index = ;
        Ataque ataque = jugador.selectAttack(index);
        return ataque;
    }

    public String getTurn(){
        if(this.currentTurn==0){
            return "Turno del rival";
        }
        else
            return "Turno del jugador";
    }

    public void setReferences(){
        oponente.setBattleDriver(this);
        jugador.setBattleDriver(this);
    }
         
    public string displayActivePlayer(){
        
    }
                             
    public string displayActivePlayer(){
    }
                             
}
