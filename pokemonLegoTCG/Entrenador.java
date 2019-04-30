package pokemonLegoTCG;

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
		return this.equipo.length()>
}