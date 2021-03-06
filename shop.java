import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;

public class shop {
	player player = listener.player;
	
	private int currItemDisplayed = 0;
	private int currItemEquipped = 0;
	
	public void enterShop(String shopName, JLabel itemName, JLabel itemCost, JLabel itemMod, String[] itemNames, int[] itemPrices, int[] itemMods, JLabel itemDisplayedCounter, JButton previousItem, JButton nextItem, int numberOfItems, boolean[] itemsPurchased, JButton equipItem, JButton purchaseItem) {
		itemName.setText(itemNames[0]);
		itemCost.setText(itemPrices[0] + " Gold");
		switch (shopName) {
		case "weapon":
			itemMod.setText((itemMods[0] - 2) + "-" + (itemMods[0] + 1) + " Damage");
			break;
		case "armor":
			itemMod.setText((itemMods[0] + " Extra Health"));
			break;
		}
		currItemDisplayed = 0;
		itemDisplayedCounter.setText((currItemDisplayed + 1) + "/" + numberOfItems);
		previousItem.setBackground(Color.darkGray);
		nextItem.setBackground(Color.green);
		if (itemsPurchased[0]) {
			equipItem.setVisible(true);
			purchaseItem.setVisible(false);
			if (currItemDisplayed == currItemEquipped) {
				equipItem.setText("Equipped");
			} else {
				equipItem.setText("Equip");
			}
		} else {
			purchaseItem.setVisible(true);
			equipItem.setVisible(false);
		}
	}
	
	public boolean purchaseItem(int[] itemPrices, boolean[] itemsPurchased, JButton purchaseItem, JButton equipItem) {
		if (itemPrices[currItemDisplayed] <= player.getGold()) {
			player.setGold(player.getGold() - itemPrices[currItemDisplayed]);
			itemsPurchased[currItemDisplayed] = true;
			purchaseItem.setVisible(false);
			equipItem.setVisible(true);
			equipItem.setText("Equip");
			return true;
		} else {
			return false;
		}
	}
	
	public void equipItem(String shopName, String[] equippedItem, JButton equipItem, JLabel townItemEquipped, String[] itemNames, int[] itemPrices, int[] itemMods) {
		equippedItem[0] = itemNames[currItemDisplayed];
		equippedItem[1] = "" + itemPrices[currItemDisplayed];
		equippedItem[2] = "" + itemMods[currItemDisplayed];
		equipItem.setText("Equipped");
		player.setDamage(itemMods[currItemDisplayed]);
		currItemEquipped = currItemDisplayed;
		switch (shopName) {
		case "weapon":
			townItemEquipped.setText("Weapon: " + equippedItem[0]);
			break;
		case "armor":
			townItemEquipped.setText("Armor: " + equippedItem[0]);
			break;
		}
	}
	
	public void nextItem(String shopName, int numberOfItems, JLabel itemDisplayedCounter, JLabel itemName, JLabel itemCost, JLabel itemMod, String[] itemNames, int[] itemPrices, int[] itemMods, JButton nextItem, JButton previousItem, boolean[] itemsPurchased, JButton equipItem, JButton purchaseItem) {
		if (currItemDisplayed < numberOfItems - 1) {
			currItemDisplayed++;
			itemDisplayedCounter.setText((currItemDisplayed + 1) + "/" + numberOfItems);
			itemName.setText(itemNames[currItemDisplayed]);
			itemCost.setText(itemPrices[currItemDisplayed] + " Gold");
			switch (shopName) {
			case "weapon":
				itemMod.setText((itemMods[currItemDisplayed] - 2) + "-" + (itemMods[currItemDisplayed] + 1) + " Damage");
				break;
			case "armor":
				itemMod.setText(itemMods[currItemDisplayed] + " Extra Health");
				break;
			}
			if (currItemDisplayed >= numberOfItems - 1) {
				nextItem.setBackground(Color.darkGray);
			}
			previousItem.setBackground(Color.green);
			if (itemsPurchased[currItemDisplayed]) {
				equipItem.setVisible(true);
				purchaseItem.setVisible(false);
				if (currItemEquipped == currItemDisplayed) {
					equipItem.setText("Equipped");
				} else {
					equipItem.setText("Equip");
				}
			} else {
				purchaseItem.setVisible(true);
				equipItem.setVisible(false);
			}
		}
	}
	
	public void previousItem(String shopName, int numberOfItems, JLabel itemDisplayedCounter, JLabel itemName, JLabel itemCost, JLabel itemMod, String[] itemNames, int[] itemPrices, int[] itemMods, JButton nextItem, JButton previousItem, boolean[] itemsPurchased, JButton equipItem, JButton purchaseItem) {
		if (currItemDisplayed > 0) {
			currItemDisplayed--;
			itemDisplayedCounter.setText((currItemDisplayed + 1) + "/" + numberOfItems);
			itemName.setText(itemNames[currItemDisplayed]);
			itemCost.setText(itemPrices[currItemDisplayed] + " Gold");
			switch (shopName) {
			case "weapon":
				itemMod.setText((itemMods[currItemDisplayed] - 2) + "-" + (itemMods[currItemDisplayed] + 1) + " Damage");
				break;
			case "armor":
				itemMod.setText(itemMods[currItemDisplayed] + " Extra Health");
				break;
			}
			if (currItemDisplayed <= 0) {
				previousItem.setBackground(Color.darkGray);
			}
			nextItem.setBackground(Color.green);
			if (itemsPurchased[currItemDisplayed]) {
				equipItem.setVisible(true);
				purchaseItem.setVisible(false);
				if (currItemEquipped == currItemDisplayed) {
					equipItem.setText("Equipped");
				} else {
					equipItem.setText("Equip");
				}
			} else {
				purchaseItem.setVisible(true);
				equipItem.setVisible(false);
			}
		}
	}
}
