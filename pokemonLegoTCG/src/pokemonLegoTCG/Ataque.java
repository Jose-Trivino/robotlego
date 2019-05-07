package pokemonLegoTCG;

public class Ataque{
	public String name;
	public int baseDamage;
	
	public Ataque(String nombre, int newBaseDamage){
		name=nombre;
		baseDamage=newBaseDamage;
	}
	
	public int getBaseDamage(){
		return this.baseDamage;
	}
	public String getName(){
		return this.name;
	}
	}