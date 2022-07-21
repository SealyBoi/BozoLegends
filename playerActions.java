import java.util.Random;
import javax.swing.JLabel;

public class playerActions {
	
	private player player = listener.player;
	private enemy enemy = listener.enemy;
	
	Random generator = new Random(System.currentTimeMillis());
	int rand;
	
	public int[] lightAttack(JLabel enemyHealthLabel, JLabel playerHealthLabel) {
		boolean enemySuccess = false;
		boolean playerSuccess = false;
		int damageDealt = 0;
		int damageTaken = 0;
		if (generator.nextInt(100) <= player.getAccuracy()) {
			damageDealt = dealLightDamage(enemyHealthLabel);
			playerSuccess = true;
		}
		if (generator.nextInt(100) <= enemy.getAccuracy()) {
			damageTaken = takeDamage(playerHealthLabel);
			enemySuccess = true;
		}
		int[] result = {0, damageTaken, damageDealt};
		if (enemySuccess && playerSuccess) {
			return result;
		} else if (enemySuccess && !playerSuccess) {
			result[0] = 1;
			return result;
		} else if (!enemySuccess && playerSuccess) {
			result[0] = 2;
			return result;
		} else {
			result[0] = 3;
			return result;
		}
	}
	
	public int[] heavyAttack(JLabel enemyHealthLabel, JLabel playerHealthLabel) {
		boolean enemySuccess = false;
		boolean playerSuccess = false;
		int damageDealt = 0;
		int damageTaken = 0;
		if (generator.nextInt(100) <= player.getAccuracy() - 15) {
			damageDealt = dealHeavyDamage(enemyHealthLabel);
			playerSuccess = true;
		}
		if (generator.nextInt(100) <= enemy.getAccuracy()) {
			damageTaken = takeDamage(playerHealthLabel);
			enemySuccess = true;
		}
		int[] result = {0, damageTaken, damageDealt};
		if (enemySuccess && playerSuccess) {
			return result;
		} else if (enemySuccess && !playerSuccess) {
			result[0] = 1;
			return result;
		} else if (!enemySuccess && playerSuccess) {
			result[0] = 2;
			return result;
		} else {
			result[0] = 3;
			return result;
		}
	}
	
	public int[] specialAttack(JLabel enemyHealthLabel, JLabel playerHealthLabel) {
		int randomDamage = generator.nextInt(3);
		int damageDealt = player.getDamage() - 2 + randomDamage;
		int[] result = {0, damageDealt};
		if(player.getBuild().equals("warrior")) {
			if (player.getHealth() + (player.getMaxHealth()/3) > player.getMaxHealth()) {
				player.setHealth(player.getMaxHealth());
			} else {
				player.setHealth(player.getHealth() + (player.getMaxHealth()/3));
			}
			playerHealthLabel.setText("Your HP: " + player.getHealth());
		} else if(player.getBuild().equals("mercenary")) {
			damageDealt = damageDealt * 2;
			enemy.setHealth(enemy.getHealth() - damageDealt);
			enemyHealthLabel.setText("Enemy HP: " + enemy.getHealth());
			result[0] = 1;
			result[1] = damageDealt;
		} else if(player.getBuild().equals("paladin")) {
			enemy.setHealth(enemy.getHealth() - player.getMaxHealth()/5);
			enemyHealthLabel.setText("Enemy HP: " + enemy.getHealth());
			if (player.getHealth() + player.getMaxHealth()/5 > player.getMaxHealth()) {
				player.setHealth(player.getMaxHealth());
			} else {
				player.setHealth(player.getHealth() + player.getMaxHealth()/5);
			}
			result[0] = 2;
		}
		return result;
	}
	
	public int[] flee(JLabel playerHealthLabel) {
		int damageTaken = 0;
		int[] result = {0, damageTaken};
		rand = generator.nextInt(2);
		if (rand == 0) {
			damageTaken = takeDamage(playerHealthLabel);
			result[1] = damageTaken;
			if (player.getHealth() <= 0) {
				result[0] = 1;
			}
		} else {
			result[0] = 2;
		}
		return result;
	}
	
	private int takeDamage(JLabel playerHealthLabel) {
		int damageTaken = enemy.getDamage();
		player.setHealth(player.getHealth() - (damageTaken));
		playerHealthLabel.setText("Your HP: " + player.getHealth());
		return damageTaken;
	}

	private int dealLightDamage(JLabel enemyHealthLabel) {
		int randomDamage = generator.nextInt(3);
		int damageDealt = player.getDamage() - 2 + randomDamage;
		if ( generator.nextInt(10) == 0) {
			damageDealt = damageDealt * 2;
		}
		enemy.setHealth(enemy.getHealth() - damageDealt);
		enemyHealthLabel.setText("Enemy HP: " + enemy.getHealth());
		return damageDealt;
	}
	
	private int dealHeavyDamage(JLabel enemyHealthLabel) {
		int randomDamage = generator.nextInt(3);
		int damageDealt = player.getDamage() - 2 + randomDamage;
		damageDealt = damageDealt + player.getDamage();
		if ( generator.nextInt(10) == 0) {
			damageDealt = damageDealt * 2;
		}
		enemy.setHealth(enemy.getHealth() - damageDealt);
		enemyHealthLabel.setText("Enemy HP: " + enemy.getHealth());
		return damageDealt;
	}
}
