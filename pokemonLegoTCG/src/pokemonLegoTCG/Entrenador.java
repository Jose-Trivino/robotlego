package pokemonLegoTCG;

import java.util.ArrayList;
import java.util.LinkedList;
public class Entrenador{
	public LinkedList<Pokemon> equipo; //solo para el jugador, la ia no lo necesita.
	public Pokemon activePokemon;
	
	public Entrenador(LinkedList<Pokemon> pokemones){
		this.equipo = pokemones;
	}		

	public Entrenador(Pokemon pokemon){
		this.activePokemon = pokemon;
	}
	public LinkedList<Pokemon> getEquipo(){
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

	/**
	 * Getter for the Active Pokemon's list of attacks.
	 * @return Pokemon's attack list.
	 */
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

	/**
	 * Metodo para intercambiar el pokemon activo por uno del equipo.
	 * @param index
	 */
	public void changeActivePokemon(int index){
		equipo.offer(this.activePokemon);
		this.activePokemon=equipo.get(index);
	}

	/**
	 * Método para cambiar pokemon activo por uno no usado anteriormente (cuando se lee una carta nueva).
	 * @param pokemon
	 */

	public void changeActivePokemon(Pokemon pokemon){
		equipo.offer(this.activePokemon);
		this.activePokemon = pokemon;
	}

	public void attack(IA ia, Ataque ataque){

		this.activePokemon.attack(ia.getActivePokemon(), ataque);
	}

	public boolean isPokemonDown(){
		if(this.getActivePokemon().getHP()==0)
			return true;
		return false;
	}

	public void changeDeadpokemon(Pokemon pokemon){
		this.activePokemon = pokemon;
	}
}