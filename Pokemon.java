package pokemonLegoTCG;
public class Pokemon{
	public String name;
	public int hp;	
	public String type;
	public Ataque attack;
	public String weakType;
	public String resistantType;
	
	public Pokemon{String nombre, int healthPoints, String tipo, Ataque ataque, String tipoDebil, String tipoResistente){
		name=nombre;
		hp=healthPoints;
		type=tipo;
		attack=ataque;
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
		
		
	public Ataque getAttack(){
		return this.attack;
	}
	
	public void attack(Pokemon pokemonRival, Ataque ataque){
		int damage = this.getAttack().getBaseDamage();
		if(this.getType().equals(pokemonRival.getWeakType()){
			damage*=2;
			}
		else if(this.getType().equals(pokemonRival.getResistantType()){
			damage=damage-20;
		}
		pokemonRival.setHP(pokemonRival.getHP()-daño);
	}
	
}