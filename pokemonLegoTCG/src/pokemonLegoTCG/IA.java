package pokemonLegoTCG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class IA {
    Pokemon pokemonActivo;

    public IA(Pokemon pokemon){
        pokemonActivo = pokemon;
    }
    public void setPokemonActivo(Pokemon pokemon){
        this.pokemonActivo = pokemon;
    }

    public Pokemon getPokemonActivo(){
        return this.pokemonActivo;
    }

    public void attack(Entrenador entrenador){
        int index;
        Random random = new Random();
        double num = random.nextDouble();
        if(num<0.25) //random attack, could be different chances, depending on type affinity.
            index=0;
        else if(0.25<=num && num<0.5)
            index=2;
        else if(0.5<=num && num<0.75)
            index=3;
        else
            index=4;

        Ataque ataque = this.pokemonActivo.getAttacks().get(index);
        this.pokemonActivo.attack(entrenador.getActivePokemon(),ataque);
    }

}