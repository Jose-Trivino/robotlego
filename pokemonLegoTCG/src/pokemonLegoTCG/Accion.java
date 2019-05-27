package pokemonLegoTCG;

public class Accion {
    String nombre;

    public Accion(String name){nombre=name;}

    public void isUsed(BattleDriver battleDriver){
        if(nombre.equals("ataque")){
                Ataque ataque = battleDriver.playerChooseAttack();
                battleDriver.jugador.attack(battleDriver.oponente,ataque);
                Boolean isActivePokemonDown = battleDriver.oponente.isActivePokemonDown();
                if(isActivePokemonDown)
                    System.out.println("El pokemon oponente no puede seguir peleando");
                    battleDriver.oponente.changePokemon();
                //forma en que battledriver maneja que el pokemon haya muerto
            }

        else if(nombre.equals("cambiarPokemon")){
            System.out.println("Seleccione el pokemon con el que quiere batallar:");

        }
        else {

        }
    }
}
