package pokemonLegoTCG;

import java.util.ArrayList;

public class Entrenador{
	public ArrayList<Pokemon> equipo;
	public Pokemon activePokemon;
	
	public Entrenador(ArrayList<Pokemon> pokemones){
		this.equipo = pokemones;
	}		
	
	public ArrayList<Pokemon> getEquipo(){
		return this.equipo;
	}
	
	public Pokemon getActivePokemon(){
		return this.activePokemon;
	}
	
	public void setActivePokemon(Pokemon pokemon){
		this.activePokemon=pokemon;
	}
	
	public boolean isActivePokemonDown(){
		return this.activePokemon.getHP()>0;
	}
	
	public boolean emptyTeam(){ 
		return this.equipo.size()<1;
	}

	public ArrayList<Ataque> getAttacks(){
		return this.activePokemon.getAttacks();
	}
	/**
	 * Metodo que deja que el entrenador elija el ataque de su pokemon activo
	 * @param index
	 * @return
	 */
	public Ataque selectAttack(int index){
		return this.activePokemon.getAttack(index);
	}

	public void changeActivePokemon(int index){
		
	}
}