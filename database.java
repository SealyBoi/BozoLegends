
public class database {
	private String selectedSave = "none";
	private boolean beatBoss1 = false;
	private boolean beatBoss2 = false;
	private boolean beatBoss3 = false;
	private boolean beatBoss4 = false;
	private boolean beatBoss5 = false;
	private int currentFloor, roomCounter;

	// Floor 1
	private String[] floor1Enemies = { "Skeleton", "Undead Soldier", "Cursed Tombstone", "Graverobber", "Banshee" };
	private int[] floor1Stats = { 23, 4, 2, 67 };

	// Floor 2
	private String[] floor2Enemies = { "Wolf", "Bear", "Deer", "Cougar", "Eagle" };
	private int[] floor2Stats = { 36, 9, 3, 70 };

	// Floor 3
	private String[] floor3Enemies = { "Sorcerer", "Apprentice", "Mage", "Alchemist", "Thaumaturge" };
	private int[] floor3Stats = { 44, 12, 5, 76 };

	// Floor 4
	private String[] floor4Enemies = { "Assassin", "Bandit", "Mercenary", "Poison Master", "Thief" };
	private int[] floor4Stats = { 52, 16, 7, 82 };

	// Floor 5
	private String[] floor5Enemies = { "Shieldbearer", "Knight", "Squire", "Crusader", "Spearman" };
	private int[] floor5Stats = { 60, 20, 9, 86 };

	// Weapon List
	String[] weaponNames = { "Rock", "Wooden Club", "Hatchet", "Mace", "Sword", "Halberd", "Great Hammer",
			"Great Sword" };
	int[] weaponPrices = { 50, 125, 400, 675, 975, 1200, 1500, 1800 };
	int[] weaponDamages = { 5, 10, 14, 20, 28, 32, 36, 38 };
	int currWeaponDisplayed = 0;
	boolean[] weaponsPurchased = { false, false, false, false, false, false, false, false };
	String[] equippedWeapon = { "None", "0", "0" };
	int currEquippedWeapon = -1;

	// Armor List
	String[] armorNames = { "Leather Armor", "Scale Armor", "Plated Mail Armor", "Chainmail Armor", "Plated Iron Armor",
			"Plated Steel Armor" };
	int[] armorPrices = { 150, 300, 500, 800, 1000, 1500 };
	int[] armorHealths = { 6, 12, 18, 24, 30, 36 };
	int currArmorDisplayed = 0;
	boolean[] armorsPurchased = { false, false, false, false, false, false };
	String[] equippedArmor = { "None", "0", "0" };
	int currEquippedArmor = -1;

	// Amulet List
	String[] amuletNames = { "???", "???", "???", "???", "???" };
	int[] amuletModifiers = { 15, 3, 10, 12, 2 };
	String[] amuletDesc = { "???", "???", "???", "???", "???" };
	int currAmuletDisplayed = 0;
	boolean[] amuletsUnlocked = { false, false, false, false, false };
	String[] equippedAmulet = { "None", "0" };
	int currEquippedAmulet = -1;
	boolean doubleGold = false;

	// Amulet data storage
	String[] hiddenAmuletNames = { "Amulet of Precision", "Amulet of Speed", "Amulet of Defense", "Amulet of Power",
			"Amulet of Wealth" };
	int[] hiddenAmuletModifiers = { 15, 3, 10, 12, 2 };
	String[] hiddenAmuletDesc = { "Amulet grants user +15 Accuracy", "Amulet grants user +3 Speed",
			"Amulet grants user +10 Health", "Amulet grants user +12 Damage", "Amulet doubles user's gold rewards" };

	// Get and Set Save File
	public void setSave(String file) {
		selectedSave = file;
	}
	public String getSave() {
		return selectedSave;
	}
	
	// Get and Set beatBoss
	public void setBoss1(boolean bool) {
		beatBoss1 = bool;
	}
	public void setBoss2(boolean bool) {
		beatBoss1 = bool;
	}
	public void setBoss3(boolean bool) {
		beatBoss1 = bool;
	}
	public void setBoss4(boolean bool) {
		beatBoss1 = bool;
	}
	public void setBoss5(boolean bool) {
		beatBoss1 = bool;
	}
	public boolean getBoss1() {
		return beatBoss1;
	}
	public boolean getBoss2() {
		return beatBoss2;
	}
	public boolean getBoss3() {
		return beatBoss3;
	}
	public boolean getBoss4() {
		return beatBoss4;
	}
	public boolean getBoss5() {
		return beatBoss5;
	}
	
	// Floor Enemies, Stats, and Numbers
	public void setFloor(int newFloor) {
		currentFloor = newFloor;
	}
	public int getFloor() {
		return currentFloor;
	}
	public void setRoom(int newRoom) {
		roomCounter = newRoom;
	}
	public int getRoom() {
		return roomCounter;
	}
	public String[] getFloor1E() {
		return floor1Enemies;
	}
	public int[] getFloor1S() {
		return floor1Stats;
	}
	public String[] getFloor2E() {
		return floor2Enemies;
	}
	public int[] getFloor2S() {
		return floor2Stats;
	}
	public String[] getFloor3E() {
		return floor3Enemies;
	}
	public int[] getFloor3S() {
		return floor3Stats;
	}
	public String[] getFloor4E() {
		return floor4Enemies;
	}
	public int[] getFloor4S() {
		return floor4Stats;
	}
	public String[] getFloor5E() {
		return floor5Enemies;
	}
	public int[] getFloor5S() {
		return floor5Stats;
	}
}
