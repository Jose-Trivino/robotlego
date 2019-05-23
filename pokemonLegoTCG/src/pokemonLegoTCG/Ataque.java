package pokemonLegoTCG;

public class Ataque {
	public String name;
	public int baseDamage;
	public String descripcion;
	
	public Ataque(String nombre, int newBaseDamage, String description){
		name = nombre;
		baseDamage = (newBaseDamage>0)? newBaseDamage : 0;
		descripcion = description;
	}
	
	public int getBaseDamage(){
		return this.baseDamage;
	}
	public String getName(){
		return this.name;
	}
	}