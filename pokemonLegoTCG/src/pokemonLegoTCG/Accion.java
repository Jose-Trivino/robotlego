package pokemonLegoTCG;

public class Accion {
    String nombre;
    public Accion(String name){nombre=name;}

    public void isUsed(BattleDriver battleDriver){
        if(nombre.equals("ataque")){
                Ataque ataque = battleDriver.playerChooseAttack();
                battleDriver.jugador.attack(battleDriver.oponente,ataque);
                Boolean isActivePokemonDown = battleDriver.oponente.isActivePokemonDown();
                //forma en que battledriver maneja que el pokemon haya muerto
            }
        }
        else if(){ //distintas acciones a elegir

        }
        else {

        }
    }
}
