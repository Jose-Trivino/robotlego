package pokemonLegoTCG;

import java.util.ArrayList;

public class Pokemon{
	public String name;
	public int hp;	
	public String type;
	public ArrayList<Ataque> attacks;
	public String weakType;
	public String resistantType;
	
	public Pokemon(String nombre, int healthPoints, String tipo,
				   ArrayList<Ataque> ataque, String tipoDebil, String tipoResistente){
		name=nombre;
		hp=healthPoints;
		type=tipo;
		attacks =ataque;
		weakType=tipoDebil;
		resistantType=tipoResistente;
	}
	public int getHP(){
		return this.hp;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getType(){
		return this.type;
	}
	
	public String getWeakType(){
		return this.weakType;
	}
	
	public String getResistanType(){
		return this.resistantType;
	}
	
	public void setHP(int newHP){
		this.hp=newHP;
	}
		
		
	public ArrayList<Ataque> getAttacks(){
		return this.attacks;
	}

	public Ataque getAttack(int index){
		return this.attacks.get(index);
	}
	private String getResistantType() {
		return this.resistantType;
	}

	/**
	 * Metodo que recibe un ataque del Pokemon que atacará (usar en conjunto con que el entrenador elija un ataque)
	 * @param pokemonRival
	 * @param ataque
	 */
	public void attack(Pokemon pokemonRival, Ataque ataque){
		int damage = ataque.getBaseDamage();
		if(this.getType().equals(pokemonRival.getWeakType()))
		{
			damage*=2;
			}

		else if(this.getType().equals(pokemonRival.getResistantType())){
			damage=damage-20;
		}
		pokemonRival.setHP(pokemonRival.getHP()-damage);
	}



}