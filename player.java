public class player{
	
	private String name;
	private String build;
	private int maxHealth;
	private int health;
	private int damage;
	private int speed;
	private int accuracy;
	private int gold;
	private int specialMoveCounter;
	
	// Set Player Stats
	public void setName(String newName) {
		name = newName;
	}
	public void setBuild(String newBuild) {
		build = newBuild;
	}
	public void setMaxHealth(int newHealth) {
		maxHealth = newHealth;
		health = maxHealth;
	}
	public void setHealth(int newHealth) {
		health = newHealth;
	}
	public void setDamage(int newDamage) {
		damage = newDamage;
	}
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}
	public void setAccuracy(int newAccuracy) {
		accuracy = newAccuracy;
	}
	public void setGold(int newGold) {
		gold = newGold;
	}
	public void setSMC(int newSMC) {
		specialMoveCounter = newSMC;
	}
	public void restoreHealth() {
		health = maxHealth;
	}
	
	// Get Player Stats
	public String getName() {
		return name;
	}
	public String getBuild() {
		return build;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public int getHealth() {
		return health;
	}
	public int getDamage() {
		return damage;
	}
	public int getSpeed() {
		return speed;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public int getGold() {
		return gold;
	}
	public int getSMC() {
		return specialMoveCounter;
	}
}
