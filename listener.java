import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class listener implements ActionListener{
	window window = main.window;
	static player player = new player();
	static enemy enemy = new enemy();
	playerData playerData = new playerData();
	playerActions playerActions = new playerActions();
	shop shop = new shop();
	database database = playerData.database;
	dungeon dungeon = new dungeon();

	// Random Generator
	Random generator = new Random(System.currentTimeMillis());
	int rand = 0;
	
	public listener(JButton button) {
		button.addActionListener(this);
	}

	// When button is pressed, do the thing
	public void actionPerformed(ActionEvent e) {
		// New Game Button
		if (e.getSource() == window.playGame) {
			window.mainMenuPanel.setVisible(false);
			window.saveSelectPanel.setVisible(true);
			playerData.displayFile("save1.txt", window.save1);
			playerData.displayFile("save2.txt", window.save2);
			playerData.displayFile("save3.txt", window.save3);
			playerData.displayFile("save4.txt", window.save4);
			playerData.displayFile("save5.txt", window.save5);
		}

		// Save Selection
		if (e.getSource() == window.selectSave) {
			String file = "na";
			if (window.save1.isSelected()) {
				file = "save1.txt";
			} else if (window.save2.isSelected()) {
				file = "save2.txt";
			} else if (window.save3.isSelected()) {
				file = "save3.txt";
			} else if (window.save4.isSelected()) {
				file = "save4.txt";
			} else if (window.save5.isSelected()) {
				file = "save5.txt";
			} else {
				JOptionPane.showMessageDialog(window.window, "Please select a save.");
			}
			if (file != "na") {
				if (playerData.selectFile(file)) {
					window.goldCounter.setText("Gold: " + player.getGold());
					window.townWeaponEquipped.setText("Weapon: " + database.equippedWeapon[0]);
					window.townArmorEquipped.setText("Armor: " + database.equippedArmor[0]);
					window.townAmuletEquipped.setText("Amulet: " + database.equippedAmulet[0]);
					window.saveSelectPanel.setVisible(false);
					window.townPanel.setVisible(true);
					window.townSelectPanel.setVisible(true);
				} else {
					window.saveSelectPanel.setVisible(false);
					window.characterCreationPanel.setVisible(true);
					window.classSelectionPanel.setVisible(true);
				}
			}
		}
		if (e.getSource() == window.leaveSaveSelection) {
			window.saveSelectPanel.setVisible(false);
			window.mainMenuPanel.setVisible(true);
		}

		// Quit Game Button
		if (e.getSource() == window.quitGame) {
			System.exit(0);
		}

		// Confirm Class Button
		if (e.getSource() == window.confirmClass) {
			if (window.warriorClass.isSelected()) {
				player.setMaxHealth(18);
				player.setDamage(2);
				player.setSpeed(4);
				player.setAccuracy(84);
				player.setBuild("warrior");
				window.dungeonSpecialMove.setText("Health Potion");
				window.classSelectionPanel.setVisible(false);
				window.enterNamePanel.setVisible(true);
			} else if (window.mercenaryClass.isSelected()) {
				player.setMaxHealth(14);
				player.setDamage(3);
				player.setSpeed(1);
				player.setAccuracy(72);
				player.setBuild("mercenary");
				window.dungeonSpecialMove.setText("Double Strike");
				window.classSelectionPanel.setVisible(false);
				window.enterNamePanel.setVisible(true);
			} else if (window.paladinClass.isSelected()) {
				player.setMaxHealth(22);
				player.setDamage(1);
				player.setSpeed(2);
				player.setAccuracy(80);
				player.setBuild("paladin");
				window.dungeonSpecialMove.setText("Life Steal");
				window.classSelectionPanel.setVisible(false);
				window.enterNamePanel.setVisible(true);
			} else
				JOptionPane.showMessageDialog(window.window, "Please select a class");
		}

		// Confirm Player Name
		if (e.getSource() == window.confirmPlayerName) {
			if (window.playerName.getText().equals("")) {
				JOptionPane.showMessageDialog(window.window, "Please input a name");
			} else {
				player.setName(window.playerName.getText());
				window.enterNamePanel.setVisible(false);
				window.characterCreationPanel.setVisible(false);
				window.introductionPanel.setVisible(true);
				window.displayDialog("intro1");
			}
		}

		// Leave Town
		if (e.getSource() == window.leaveTown) {
			window.townPanel.setVisible(false);
			window.mainMenuPanel.setVisible(true);
			playerData.Save(database.getSave());
			playerData.resetTown();
		}

		// Continue Intro
		if (e.getSource() == window.continueIntro) {
			window.hideDialog("intro1");
			window.displayDialog("intro2");
		}
		if (e.getSource() == window.continueIntro2) {
			window.hideDialog("intro2");
			window.introductionPanel.setVisible(false);
			window.townPanel.setVisible(true);
			window.townSelectPanel.setVisible(true);
			player.setGold(50);
			window.goldCounter.setText("Gold: " + player.getGold());
			playerData.Save(database.getSave());
		}

		// Town Buttons
		// Weapon Shop
		if (e.getSource() == window.weaponShop) {
			window.weaponShopPanel.setVisible(true);
			window.townPanel.setVisible(false);
			shop.enterShop("weapon", window.weaponName, window.weaponCost, window.weaponDamage, database.weaponNames,
					database.weaponPrices, database.weaponDamages, window.weaponDisplayedCounter, window.previousWeapon,
					window.nextWeapon, 8, database.weaponsPurchased, window.equipWeapon, window.purchaseWeapon);
		}
		if (e.getSource() == window.purchaseWeapon) {
			if (!shop.purchaseItem(database.weaponPrices, database.weaponsPurchased, window.purchaseWeapon,
					window.equipWeapon)) {
				JOptionPane.showMessageDialog(window.window, "You broke bitch, you don't have the money to buy that!");
			}
		}
		if (e.getSource() == window.equipWeapon) {
			shop.equipItem("weapon", database.equippedWeapon, window.equipWeapon, window.townWeaponEquipped,
					database.weaponNames, database.weaponPrices, database.weaponDamages);
		}
		if (e.getSource() == window.leaveWeaponShop) {
			window.weaponShopPanel.setVisible(false);
			window.townPanel.setVisible(true);
			window.goldCounter.setText("Gold: " + player.getGold());
			playerData.Save(database.getSave());
		}
		if (e.getSource() == window.nextWeapon) {
			shop.nextItem("weapon", 8, window.weaponDisplayedCounter, window.weaponName, window.weaponCost,
					window.weaponDamage, database.weaponNames, database.weaponPrices, database.weaponDamages,
					window.nextWeapon, window.previousWeapon, database.weaponsPurchased, window.equipWeapon,
					window.purchaseWeapon);
		}
		if (e.getSource() == window.previousWeapon) {
			shop.previousItem("weapon", 8, window.weaponDisplayedCounter, window.weaponName, window.weaponCost,
					window.weaponDamage, database.weaponNames, database.weaponPrices, database.weaponDamages,
					window.nextWeapon, window.previousWeapon, database.weaponsPurchased, window.equipWeapon,
					window.purchaseWeapon);
		}
		// Armor Shop
		if (e.getSource() == window.armorShop) {
			window.armorShopPanel.setVisible(true);
			window.townPanel.setVisible(false);
			shop.enterShop("armor", window.armorName, window.armorCost, window.armorHealth, database.armorNames,
					database.armorPrices, database.armorHealths, window.armorDisplayedCounter, window.previousArmor,
					window.nextArmor, 6, database.armorsPurchased, window.equipArmor, window.purchaseArmor);
		}
		if (e.getSource() == window.purchaseArmor) {
			if (!shop.purchaseItem(database.armorPrices, database.armorsPurchased, window.purchaseArmor,
					window.equipArmor)) {
				JOptionPane.showMessageDialog(window.window, "You broke bitch, you don't have the money to buy that!");
			}
		}
		if (e.getSource() == window.equipArmor) {
			shop.equipItem("armor", database.equippedArmor, window.equipArmor, window.townArmorEquipped,
					database.armorNames, database.armorPrices, database.armorHealths);
		}
		if (e.getSource() == window.leaveArmorShop) {
			window.armorShopPanel.setVisible(false);
			window.townPanel.setVisible(true);
			window.goldCounter.setText("Gold: " + player.getGold());
			playerData.Save(database.getSave());
		}
		if (e.getSource() == window.nextArmor) {
			shop.nextItem("armor", 6, window.armorDisplayedCounter, window.armorName, window.armorCost,
					window.armorHealth, database.armorNames, database.armorPrices, database.armorHealths,
					window.nextArmor, window.previousArmor, database.armorsPurchased, window.equipArmor,
					window.purchaseArmor);
		}
		if (e.getSource() == window.previousArmor) {
			shop.previousItem("armor", 6, window.armorDisplayedCounter, window.armorName, window.armorCost,
					window.armorHealth, database.armorNames, database.armorPrices, database.armorHealths,
					window.nextArmor, window.previousArmor, database.armorsPurchased, window.equipArmor,
					window.purchaseArmor);
		}
		// DungeonEntrance
		if (e.getSource() == window.dungeonEntrance) {
			window.townPanel.setVisible(false);
			window.floorSelectPanel.setVisible(true);
		}
		if (e.getSource() == window.selectFloor) {
			if (window.firstFloor.isSelected()) {
				window.floorSelectPanel.setVisible(false);
				window.dungeonPanel.setVisible(true);
				window.dungeonOptionsPanel.setVisible(true);
				dungeon.createRoom(database.getFloor1E(), database.getFloor1S(), true);
				database.setRoom(1);
				database.setFloor(1);
			} else if (window.secondFloor.isSelected()) {
				window.floorSelectPanel.setVisible(false);
				window.dungeonPanel.setVisible(true);
				window.dungeonOptionsPanel.setVisible(true);
				dungeon.createRoom(database.getFloor2E(), database.getFloor2S(), true);
				database.setRoom(1);;
				database.setFloor(2);
			} else if (window.thirdFloor.isSelected()) {
				window.floorSelectPanel.setVisible(false);
				window.dungeonPanel.setVisible(true);
				window.dungeonOptionsPanel.setVisible(true);
				dungeon.createRoom(database.getFloor3E(), database.getFloor3S(), true);
				database.setRoom(1);
				database.setFloor(3);
			} else if (window.fourthFloor.isSelected()) {
				window.floorSelectPanel.setVisible(false);
				window.dungeonPanel.setVisible(true);
				window.dungeonOptionsPanel.setVisible(true);
				dungeon.createRoom(database.getFloor4E(), database.getFloor4S(), true);
				database.setRoom(1);
				database.setFloor(4);
			} else if (window.fifthFloor.isSelected()) {
				window.floorSelectPanel.setVisible(false);
				window.dungeonPanel.setVisible(true);
				window.dungeonOptionsPanel.setVisible(true);
				dungeon.createRoom(database.getFloor5E(), database.getFloor5S(), true);
				database.setRoom(1);
				database.setFloor(5);
			} else {
				JOptionPane.showMessageDialog(window.window, "Please select a floor.");
			}
		}
		if (e.getSource() == window.leaveFloorSelection) {
			window.townPanel.setVisible(true);
			window.floorSelectPanel.setVisible(false);
		}
		// Training Grounds
		if (e.getSource() == window.trainingGrounds) {
			window.townPanel.setVisible(false);
			window.trainingPanel.setVisible(true);
			window.displayAccuracy.setText("Your Accuracy: " + player.getAccuracy());
			window.displaySpeed.setText("Your Speed: " + player.getSpeed());
		}
		if (e.getSource() == window.accuracy1) {
			if (player.getGold() >= 100 && player.getAccuracy() != 100) {
				player.setGold(player.getGold() - 100);
				player.setAccuracy(player.getAccuracy() + 1);
				window.displayAccuracy.setText("Your Accuracy: " + player.getAccuracy());
			} else if (player.getAccuracy() == 100) {
				JOptionPane.showMessageDialog(window.window,
						"I LIKE PENNIES! (You can't increase this any more stoopid)");
			} else {
				JOptionPane.showMessageDialog(window.window, "I LIKE PENNIES! (You don't have enough money dummy)");
			}
		}
		if (e.getSource() == window.accuracy2) {
			if (player.getGold() >= 180 && player.getAccuracy() != 100) {
				player.setGold(player.getGold() - 180);
				player.setAccuracy(player.getAccuracy() + 2);
				if (player.getAccuracy() > 100) {
					player.setAccuracy(100);
				}
				window.displayAccuracy.setText("Your Accuracy: " + player.getAccuracy());
			} else if (player.getAccuracy() == 100) {
				JOptionPane.showMessageDialog(window.window,
						"I LIKE PENNIES! (You can't increase this any more stoopid)");
			} else {
				JOptionPane.showMessageDialog(window.window, "I LIKE PENNIES! (You don't have enough money dummy)");
			}
		}
		if (e.getSource() == window.accuracy3) {
			if (player.getGold() >= 240 && player.getAccuracy() != 100) {
				player.setGold(player.getGold() - 240);
				player.setAccuracy(player.getAccuracy() + 3);
				if (player.getAccuracy() > 100) {
					player.setAccuracy(100);
				}
				window.displayAccuracy.setText("Your Accuracy: " + player.getAccuracy());
			} else if (player.getAccuracy() == 100) {
				JOptionPane.showMessageDialog(window.window,
						"I LIKE PENNIES! (You can't increase this any more stoopid)");
			} else {
				JOptionPane.showMessageDialog(window.window, "I LIKE PENNIES! (You don't have enough money dummy)");
			}
		}
		if (e.getSource() == window.speed1) {
			if (player.getGold() >= 175 && player.getSpeed() != 10) {
				player.setGold(player.getGold() - 175);
				player.setSpeed(player.getSpeed() + 1);
				window.displaySpeed.setText("Your Speed: " + player.getSpeed());
			} else if (player.getSpeed() == 10) {
				JOptionPane.showMessageDialog(window.window,
						"I LIKE QUARTERS! (You can't increase this any more stoopid)");
			} else {
				JOptionPane.showMessageDialog(window.window, "I LIKE QUARTERS! (You don't have enough money dummy)");
			}
		}
		if (e.getSource() == window.speed2) {
			if (player.getGold() >= 250 && player.getSpeed() != 10) {
				player.setGold(player.getGold() - 250);
				player.setSpeed(player.getSpeed() + 2);
				if (player.getSpeed() > 10) {
					player.setSpeed(10);
				}
				window.displaySpeed.setText("Your Speed: " + player.getSpeed());
			} else if (player.getSpeed() == 10) {
				JOptionPane.showMessageDialog(window.window,
						"I LIKE QUARTERS! (You can't increase this any more stoopid)");
			} else {
				JOptionPane.showMessageDialog(window.window, "I LIKE QUARTERS! (You don't have enough money dummy)");
			}
		}
		if (e.getSource() == window.speed3) {
			if (player.getGold() >= 310 && player.getSpeed() != 10) {
				player.setGold(player.getGold() - 310);
				player.setSpeed(player.getSpeed() + 3);
				if (player.getSpeed() > 10) {
					player.setSpeed(10);
				}
				window.displaySpeed.setText("Your Speed: " + player.getSpeed());
			} else if (player.getSpeed() == 10) {
				JOptionPane.showMessageDialog(window.window,
						"I LIKE QUARTERS! (You can't increase this any more stoopid)");
			} else {
				JOptionPane.showMessageDialog(window.window, "I LIKE QUARTERS! (You don't have enough money dummy)");
			}
		}
		if (e.getSource() == window.leaveTrainingGrounds) {
			window.townPanel.setVisible(true);
			window.trainingPanel.setVisible(false);
			window.goldCounter.setText("Gold: " + player.getGold());
			playerData.Save(database.getSave());
		}
		if (e.getSource() == window.amuletShop) {
			window.townPanel.setVisible(false);
			window.amuletPanel.setVisible(true);
			window.amuletName.setText(database.amuletNames[0]);
			window.amuletDescription.setText(database.amuletDesc[0]);
			database.currAmuletDisplayed = 0;
			window.amuletDisplayedCounter.setText((database.currAmuletDisplayed + 1) + "/5");
			window.previousAmulet.setBackground(Color.darkGray);
			window.nextAmulet.setBackground(Color.green);
			if (database.amuletsUnlocked[0]) {
				window.equipAmulet.setVisible(true);
				if (database.currAmuletDisplayed == database.currEquippedAmulet) {
					window.equipAmulet.setText("Equipped");
				} else {
					window.equipAmulet.setText("Equip Amulet");
				}
			} else {
				window.equipAmulet.setVisible(false);
			}
		}
		if (e.getSource() == window.equipAmulet) {
			switch (database.currEquippedAmulet) {
			case 0:
				player.setAccuracy(player.getAccuracy() - Integer.parseInt(database.equippedAmulet[1]));
				break;
			case 1:
				player.setSpeed(player.getSpeed() - Integer.parseInt(database.equippedAmulet[1]));
				break;
			case 2:
				player.setMaxHealth(player.getMaxHealth() - Integer.parseInt(database.equippedAmulet[1]));
				break;
			case 3:
				player.setDamage(player.getDamage() - Integer.parseInt(database.equippedAmulet[1]));
				break;
			case 4:
				database.doubleGold = false;
				break;
			}
			database.equippedAmulet[0] = database.amuletNames[database.currAmuletDisplayed];
			database.equippedAmulet[1] = "" + database.amuletModifiers[database.currAmuletDisplayed];
			window.equipAmulet.setText("Equipped");
			database.currEquippedAmulet = database.currAmuletDisplayed;
			switch (database.currEquippedAmulet) {
			case 0:
				player.setAccuracy(player.getAccuracy() + Integer.parseInt(database.equippedAmulet[1]));
				break;
			case 1:
				player.setSpeed(player.getSpeed() + Integer.parseInt(database.equippedAmulet[1]));
				break;
			case 2:
				player.setHealth(player.getHealth() + Integer.parseInt(database.equippedAmulet[1]));
				break;
			case 3:
				player.setDamage(player.getDamage() + Integer.parseInt(database.equippedAmulet[1]));
				break;
			case 4:
				database.doubleGold = true;
				break;
			}
			window.townAmuletEquipped.setText("Amulet: " + database.equippedAmulet[0]);
		}
		if (e.getSource() == window.nextAmulet) {
			if (database.currAmuletDisplayed < database.amuletNames.length - 1) {
				database.currAmuletDisplayed++;
				window.amuletDisplayedCounter.setText((database.currAmuletDisplayed + 1) + "/5");
				window.amuletName.setText(database.amuletNames[database.currAmuletDisplayed]);
				window.amuletDescription.setText(database.amuletDesc[database.currAmuletDisplayed]);
				if (database.currAmuletDisplayed >= database.amuletNames.length - 1) {
					window.nextAmulet.setBackground(Color.darkGray);
				}
				window.previousAmulet.setBackground(Color.green);
				if (database.amuletsUnlocked[database.currAmuletDisplayed]) {
					window.equipAmulet.setVisible(true);
					if (database.currEquippedAmulet == database.currAmuletDisplayed) {
						window.equipAmulet.setText("Equipped");
					} else {
						window.equipAmulet.setText("Equip Amulet");
					}
				} else {
					window.equipAmulet.setVisible(false);
				}
			}
		}
		if (e.getSource() == window.previousAmulet) {
			if (database.currAmuletDisplayed > 0) {
				database.currAmuletDisplayed--;
				window.amuletDisplayedCounter.setText((database.currAmuletDisplayed + 1) + "/5");
				window.amuletName.setText(database.amuletNames[database.currAmuletDisplayed]);
				window.amuletDescription.setText(database.amuletDesc[database.currAmuletDisplayed]);
				if (database.currAmuletDisplayed <= 0) {
					window.previousAmulet.setBackground(Color.darkGray);
				}
				window.nextAmulet.setBackground(Color.green);
				if (database.amuletsUnlocked[database.currAmuletDisplayed]) {
					window.equipAmulet.setVisible(true);
					if (database.currEquippedAmulet == database.currAmuletDisplayed) {
						window.equipAmulet.setText("Equipped");
					} else {
						window.equipAmulet.setText("Equip Amulet");
					}
				} else {
					window.equipAmulet.setVisible(false);
				}
			}
		}
		if (e.getSource() == window.leaveAmuletShop) {
			window.amuletPanel.setVisible(false);
			window.townPanel.setVisible(true);
			window.goldCounter.setText("Gold: " + player.getGold());
			playerData.Save(database.getSave());
		}

		// Dungeon Options
		if (e.getSource() == window.dungeonLightAttack) {
			int result[] = playerActions.lightAttack(window.currentEnemyHealth, window.playerHealthLabel);
			switch (result[0]) {
			case 0:
				JOptionPane.showMessageDialog(window.window,
						"You took " + result[1] + " damage, and dealt " + result[2] + " damage!");
				break;
			case 1:
				JOptionPane.showMessageDialog(window.window,
						"You took " + result[1] + " damage, and you missed your attack!");
				break;
			case 2:
				JOptionPane.showMessageDialog(window.window,
						"The enemy missed their attack and you dealt " + result[2] + " damage!");
				break;
			case 3:
				JOptionPane.showMessageDialog(window.window, "How did both of you dumbasses miss.");
				break;
			}
			if (player.getHealth() <= 0) {
				window.dungeonPanel.setVisible(false);
				window.townPanel.setVisible(true);
				JOptionPane.showMessageDialog(window.window,
						"You passed out from all of your injuries and were brought back to town! The doctor took some of your gold as expenses!");
				player.setGold(player.getGold() - player.getGold() / 20);
				window.goldCounter.setText("Gold: " + player.getGold());
				playerData.Save(database.getSave());
			}
			if (enemy.getHealth() <= 0) {
				window.dungeonEnemyDefeatedPanel.setVisible(true);
				window.dungeonOptionsPanel.setVisible(false);
				if (database.getRoom() >= 10) {
					int tempGold = 0;
					int dropAmulet = 0;
					switch (database.getFloor()) {
					case 1:
						if (database.getBoss1()) {
							tempGold = generator.nextInt(10) + 5;
							JOptionPane.showMessageDialog(window.window,
									"You defeated the enemy and gained " + tempGold + " gold!");
							player.setGold(player.getGold() + tempGold);
						} else {
							JOptionPane.showMessageDialog(window.window,
									"You have defeated the boss and completed this floor!  You gained 50 gold!");
							player.setGold(player.getGold() + 50);
							database.setBoss1(true);
						}
						dropAmulet = generator.nextInt(20);
						if (dropAmulet == 0) {
							database.amuletsUnlocked[0] = true;
							JOptionPane.showMessageDialog(window.window,
									"You look to the floor to find a small amulet. Inscribed on it is a small crosshair.");
							database.amuletNames[0] = database.hiddenAmuletNames[0];
							database.amuletDesc[0] = database.hiddenAmuletDesc[0];
						}
						break;
					case 2:
						if (database.getBoss2()) {
							tempGold = generator.nextInt(20) + 15;
							JOptionPane.showMessageDialog(window.window,
									"You defeated the enemy and gained " + tempGold + " gold!");
							player.setGold(player.getGold() + tempGold);
						} else {
							JOptionPane.showMessageDialog(window.window,
									"You have defeated the boss and completed this floor!  You gained 175 gold!");
							player.setGold(player.getGold() + 150);
							database.setBoss2(true);
						}
						dropAmulet = generator.nextInt(20);
						if (dropAmulet == 0) {
							database.amuletsUnlocked[1] = true;
							JOptionPane.showMessageDialog(window.window,
									"You look to the floor to find a small amulet. Inscribed on it is a rabbit.");
							database.amuletNames[1] = database.hiddenAmuletNames[1];
							database.amuletDesc[1] = database.hiddenAmuletDesc[1];
						}
						break;
					case 3:
						if (database.getBoss3()) {
							tempGold = generator.nextInt(30) + 25;
							JOptionPane.showMessageDialog(window.window,
									"You defeated the enemy and gained " + tempGold + " gold!");
							player.setGold(player.getGold() + tempGold);
						} else {
							JOptionPane.showMessageDialog(window.window,
									"You have defeated the boss and completed this floor!  You gained 300 gold!");
							player.setGold(player.getGold() + 250);
							database.setBoss3(true);
						}
						dropAmulet = generator.nextInt(20);
						if (dropAmulet == 0) {
							database.amuletsUnlocked[2] = true;
							JOptionPane.showMessageDialog(window.window,
									"You look to the floor to find a small amulet. Inscribed on it is a shield.");
							database.amuletNames[2] = database.hiddenAmuletNames[2];
							database.amuletDesc[2] = database.hiddenAmuletDesc[2];
						}
						break;
					case 4:
						if (database.getBoss4()) {
							tempGold = generator.nextInt(40) + 35;
							JOptionPane.showMessageDialog(window.window,
									"You defeated the enemy and gained " + tempGold + " gold!");
							player.setGold(player.getGold() + tempGold);
						} else {
							JOptionPane.showMessageDialog(window.window,
									"You have defeated the boss and completed this floor!  You gained 425 gold!");
							player.setGold(player.getGold() + 350);
							database.setBoss4(true);
						}
						dropAmulet = generator.nextInt(20);
						if (dropAmulet == 0) {
							database.amuletsUnlocked[3] = true;
							JOptionPane.showMessageDialog(window.window,
									"You look to the floor to find a small amulet. Inscribed on it is a dagger.");
							database.amuletNames[3] = database.hiddenAmuletNames[3];
							database.amuletDesc[3] = database.hiddenAmuletDesc[3];
						}
						break;
					case 5:
						if (database.getBoss5()) {
							tempGold = generator.nextInt(50) + 45;
							JOptionPane.showMessageDialog(window.window,
									"You defeated the enemy and gained " + tempGold + " gold!");
							player.setGold(player.getGold() + tempGold);
						} else {
							JOptionPane.showMessageDialog(window.window,
									"You have defeated the boss and completed this floor!  You gained 550 gold!");
							player.setGold(player.getGold() + 500);
							database.setBoss5(true);
						}
						dropAmulet = generator.nextInt(20);
						if (dropAmulet == 0) {
							database.amuletsUnlocked[4] = true;
							JOptionPane.showMessageDialog(window.window,
									"You look to the floor to find a small amulet. Inscribed on it is a gold coin.");
							database.amuletNames[4] = database.hiddenAmuletNames[4];
							database.amuletDesc[4] = database.hiddenAmuletDesc[4];
						}
						break;
					}
					window.dungeonEnemyDefeatedPanel.setVisible(false);
					window.dungeonOptionsPanel.setVisible(true);
					window.dungeonPanel.setVisible(false);
					window.townPanel.setVisible(true);
					window.goldCounter.setText("Gold: " + player.getGold());
					playerData.Save(database.getSave());
				} else {
					int tempGold = 0;
					switch (database.getFloor()) {
					case 1:
						tempGold = generator.nextInt(10) + 5;
						break;
					case 2:
						tempGold = generator.nextInt(20) + 15;
						break;
					case 3:
						tempGold = generator.nextInt(30) + 25;
						break;
					case 4:
						tempGold = generator.nextInt(40) + 35;
						break;
					case 5:
						tempGold = generator.nextInt(50) + 45;
						break;
					}
					JOptionPane.showMessageDialog(window.window,
							"You defeated the enemy and gained " + tempGold + " gold!");
					player.setGold(player.getGold() + tempGold);
				}
			}
		}
		if (e.getSource() == window.dungeonHeavyAttack) {
			int[] result = playerActions.heavyAttack(window.currentEnemyHealth, window.playerHealthLabel);
			switch (result[0]) {
			case 0:
				JOptionPane.showMessageDialog(window.window,
						"You took " + result[1] + " damage, and dealt " + result[2] + " damage!");
				break;
			case 1:
				JOptionPane.showMessageDialog(window.window,
						"You took " + result[1] + " damage, and you missed your attack!");
				break;
			case 2:
				JOptionPane.showMessageDialog(window.window,
						"The enemy missed their attack and you dealt " + result[2] + " damage!");
				break;
			case 3:
				JOptionPane.showMessageDialog(window.window, "How did both of you dumbasses miss.");
				break;
			}
			if (player.getHealth() <= 0) {
				window.dungeonPanel.setVisible(false);
				window.townPanel.setVisible(true);
				JOptionPane.showMessageDialog(window.window,
						"You passed out from all of your injuries and were brought back to town! The doctor took some of your gold as expenses!");
				player.setGold(player.getGold() - player.getGold() / 20);
				window.goldCounter.setText("Gold: " + player.getGold());
				playerData.Save(database.getSave());
			}
			if (enemy.getHealth() <= 0) {
				window.dungeonEnemyDefeatedPanel.setVisible(true);
				window.dungeonOptionsPanel.setVisible(false);
				if (database.getRoom() >= 10) {
					int tempGold = 0;
					int dropAmulet = 0;
					switch (database.getFloor()) {
					case 1:
						if (database.getBoss1()) {
							tempGold = generator.nextInt(10) + 5;
							JOptionPane.showMessageDialog(window.window,
									"You defeated the enemy and gained " + tempGold + " gold!");
							player.setGold(player.getGold() + tempGold);
						} else {
							JOptionPane.showMessageDialog(window.window,
									"You have defeated the boss and completed this floor!  You gained 50 gold!");
							player.setGold(player.getGold() + 50);
							database.setBoss1(true);
						}
						dropAmulet = generator.nextInt(20);
						if (dropAmulet == 0) {
							database.amuletsUnlocked[0] = true;
							JOptionPane.showMessageDialog(window.window,
									"You look to the floor to find a small amulet. Inscribed on it is a small crosshair.");
							database.amuletNames[0] = database.hiddenAmuletNames[0];
							database.amuletDesc[0] = database.hiddenAmuletDesc[0];
						}
						break;
					case 2:
						if (database.getBoss2()) {
							tempGold = generator.nextInt(20) + 15;
							JOptionPane.showMessageDialog(window.window,
									"You defeated the enemy and gained " + tempGold + " gold!");
							player.setGold(player.getGold() + tempGold);
						} else {
							JOptionPane.showMessageDialog(window.window,
									"You have defeated the boss and completed this floor!  You gained 175 gold!");
							player.setGold(player.getGold() + 150);
							database.setBoss2(true);
						}
						dropAmulet = generator.nextInt(20);
						if (dropAmulet == 0) {
							database.amuletsUnlocked[1] = true;
							JOptionPane.showMessageDialog(window.window,
									"You look to the floor to find a small amulet. Inscribed on it is a rabbit.");
							database.amuletNames[1] = database.hiddenAmuletNames[1];
							database.amuletDesc[1] = database.hiddenAmuletDesc[1];
						}
						break;
					case 3:
						if (database.getBoss3()) {
							tempGold = generator.nextInt(30) + 25;
							JOptionPane.showMessageDialog(window.window,
									"You defeated the enemy and gained " + tempGold + " gold!");
							player.setGold(player.getGold() + tempGold);
						} else {
							JOptionPane.showMessageDialog(window.window,
									"You have defeated the boss and completed this floor!  You gained 300 gold!");
							player.setGold(player.getGold() + 250);
							database.setBoss3(true);
						}
						dropAmulet = generator.nextInt(20);
						if (dropAmulet == 0) {
							database.amuletsUnlocked[2] = true;
							JOptionPane.showMessageDialog(window.window,
									"You look to the floor to find a small amulet. Inscribed on it is a shield.");
							database.amuletNames[2] = database.hiddenAmuletNames[2];
							database.amuletDesc[2] = database.hiddenAmuletDesc[2];
						}
						break;
					case 4:
						if (database.getBoss4()) {
							tempGold = generator.nextInt(40) + 35;
							JOptionPane.showMessageDialog(window.window,
									"You defeated the enemy and gained " + tempGold + " gold!");
							player.setGold(player.getGold() + tempGold);
						} else {
							JOptionPane.showMessageDialog(window.window,
									"You have defeated the boss and completed this floor!  You gained 425 gold!");
							player.setGold(player.getGold() + 350);
							database.setBoss4(true);
						}
						dropAmulet = generator.nextInt(20);
						if (dropAmulet == 0) {
							database.amuletsUnlocked[3] = true;
							JOptionPane.showMessageDialog(window.window,
									"You look to the floor to find a small amulet. Inscribed on it is a dagger.");
							database.amuletNames[3] = database.hiddenAmuletNames[3];
							database.amuletDesc[3] = database.hiddenAmuletDesc[3];
						}
						break;
					case 5:
						if (database.getBoss5()) {
							tempGold = generator.nextInt(50) + 45;
							JOptionPane.showMessageDialog(window.window,
									"You defeated the enemy and gained " + tempGold + " gold!");
							player.setGold(player.getGold() + tempGold);
						} else {
							JOptionPane.showMessageDialog(window.window,
									"You have defeated the boss and completed this floor!  You gained 550 gold!");
							player.setGold(player.getGold() + 500);
							database.setBoss5(true);
						}
						dropAmulet = generator.nextInt(20);
						if (dropAmulet == 0) {
							database.amuletsUnlocked[4] = true;
							JOptionPane.showMessageDialog(window.window,
									"You look to the floor to find a small amulet. Inscribed on it is a gold coin.");
							database.amuletNames[4] = database.hiddenAmuletNames[4];
							database.amuletDesc[4] = database.hiddenAmuletDesc[4];
						}
						break;
					}
					window.dungeonEnemyDefeatedPanel.setVisible(false);
					window.dungeonOptionsPanel.setVisible(true);
					window.dungeonPanel.setVisible(false);
					window.townPanel.setVisible(true);
					window.goldCounter.setText("Gold: " + player.getGold());
					playerData.Save(database.getSave());
				} else {
					int tempGold = 0;
					switch (database.getFloor()) {
					case 1:
						tempGold = generator.nextInt(10) + 5;
						break;
					case 2:
						tempGold = generator.nextInt(20) + 15;
						break;
					case 3:
						tempGold = generator.nextInt(30) + 25;
						break;
					case 4:
						tempGold = generator.nextInt(40) + 35;
						break;
					case 5:
						tempGold = generator.nextInt(50) + 45;
						break;
					}
					JOptionPane.showMessageDialog(window.window,
							"You defeated the enemy and gained " + tempGold + " gold!");
					player.setGold(player.getGold() + tempGold);
				}
			}
		}
		if (e.getSource() == window.dungeonSpecialMove) {
			if (player.getSMC() > 0) {
				int[] result = playerActions.specialAttack(window.currentEnemyHealth, window.playerHealthLabel);
				player.setSMC(player.getSMC() - 1);
				switch (result[0]) {
				case 0:
					JOptionPane.showMessageDialog(window.window,
							"You pull back and heal for " + player.getMaxHealth() / 3 + " health! You have "
									+ player.getSMC() + " uses left!");
					break;
				case 1:
					JOptionPane.showMessageDialog(window.window, "You double strike the enemy for " + result[1]
							+ " damage! You have " + player.getSMC() + " uses left!");
					break;
				case 2:
					JOptionPane.showMessageDialog(window.window,
							"You stole some of the enemies life force and healed yourself for "
									+ player.getMaxHealth() / 5 + " HP! You have " + player.getSMC()
									+ " uses left!");
					break;
				}
			} else {
				JOptionPane.showMessageDialog(window.window,
						"You can't do this anymore dummy, you used all your special skills!");
			}
			if (enemy.getHealth() <= 0) {
				window.dungeonEnemyDefeatedPanel.setVisible(true);
				window.dungeonOptionsPanel.setVisible(false);
				if (database.getRoom() >= 10) {
					int tempGold = 0;
					int dropAmulet = 0;
					switch (database.getFloor()) {
					case 1:
						if (database.getBoss1()) {
							tempGold = generator.nextInt(10) + 5;
							JOptionPane.showMessageDialog(window.window,
									"You defeated the enemy and gained " + tempGold + " gold!");
							player.setGold(player.getGold() + tempGold);
						} else {
							JOptionPane.showMessageDialog(window.window,
									"You have defeated the boss and completed this floor!  You gained 50 gold!");
							player.setGold(player.getGold() + 50);
							database.setBoss1(true);
						}
						dropAmulet = generator.nextInt(20);
						if (dropAmulet == 0) {
							database.amuletsUnlocked[0] = true;
							JOptionPane.showMessageDialog(window.window,
									"You look to the floor to find a small amulet. Inscribed on it is a small crosshair.");
							database.amuletNames[0] = database.hiddenAmuletNames[0];
							database.amuletDesc[0] = database.hiddenAmuletDesc[0];
						}
						break;
					case 2:
						if (database.getBoss2()) {
							tempGold = generator.nextInt(20) + 15;
							JOptionPane.showMessageDialog(window.window,
									"You defeated the enemy and gained " + tempGold + " gold!");
							player.setGold(player.getGold() + tempGold);
						} else {
							JOptionPane.showMessageDialog(window.window,
									"You have defeated the boss and completed this floor!  You gained 175 gold!");
							player.setGold(player.getGold() + 150);
							database.setBoss2(true);
						}
						dropAmulet = generator.nextInt(20);
						if (dropAmulet == 0) {
							database.amuletsUnlocked[1] = true;
							JOptionPane.showMessageDialog(window.window,
									"You look to the floor to find a small amulet. Inscribed on it is a rabbit.");
							database.amuletNames[1] = database.hiddenAmuletNames[1];
							database.amuletDesc[1] = database.hiddenAmuletDesc[1];
						}
						break;
					case 3:
						if (database.getBoss3()) {
							tempGold = generator.nextInt(30) + 25;
							JOptionPane.showMessageDialog(window.window,
									"You defeated the enemy and gained " + tempGold + " gold!");
							player.setGold(player.getGold() + tempGold);
						} else {
							JOptionPane.showMessageDialog(window.window,
									"You have defeated the boss and completed this floor!  You gained 300 gold!");
							player.setGold(player.getGold() + 250);
							database.setBoss3(true);
						}
						dropAmulet = generator.nextInt(20);
						if (dropAmulet == 0) {
							database.amuletsUnlocked[2] = true;
							JOptionPane.showMessageDialog(window.window,
									"You look to the floor to find a small amulet. Inscribed on it is a shield.");
							database.amuletNames[2] = database.hiddenAmuletNames[2];
							database.amuletDesc[2] = database.hiddenAmuletDesc[2];
						}
						break;
					case 4:
						if (database.getBoss4()) {
							tempGold = generator.nextInt(40) + 35;
							JOptionPane.showMessageDialog(window.window,
									"You defeated the enemy and gained " + tempGold + " gold!");
							player.setGold(player.getGold() + tempGold);
						} else {
							JOptionPane.showMessageDialog(window.window,
									"You have defeated the boss and completed this floor!  You gained 425 gold!");
							player.setGold(player.getGold() + 350);
							database.setBoss4(true);
						}
						dropAmulet = generator.nextInt(20);
						if (dropAmulet == 0) {
							database.amuletsUnlocked[3] = true;
							JOptionPane.showMessageDialog(window.window,
									"You look to the floor to find a small amulet. Inscribed on it is a dagger.");
							database.amuletNames[3] = database.hiddenAmuletNames[3];
							database.amuletDesc[3] = database.hiddenAmuletDesc[3];
						}
						break;
					case 5:
						if (database.getBoss5()) {
							tempGold = generator.nextInt(50) + 45;
							JOptionPane.showMessageDialog(window.window,
									"You defeated the enemy and gained " + tempGold + " gold!");
							player.setGold(player.getGold() + tempGold);
						} else {
							JOptionPane.showMessageDialog(window.window,
									"You have defeated the boss and completed this floor!  You gained 550 gold!");
							player.setGold(player.getGold() + 500);
							database.setBoss5(true);
						}
						dropAmulet = generator.nextInt(20);
						if (dropAmulet == 0) {
							database.amuletsUnlocked[4] = true;
							JOptionPane.showMessageDialog(window.window,
									"You look to the floor to find a small amulet. Inscribed on it is a gold coin.");
							database.amuletNames[4] = database.hiddenAmuletNames[4];
							database.amuletDesc[4] = database.hiddenAmuletDesc[4];
						}
						break;
					}
					window.dungeonEnemyDefeatedPanel.setVisible(false);
					window.dungeonOptionsPanel.setVisible(true);
					window.dungeonPanel.setVisible(false);
					window.townPanel.setVisible(true);
					window.goldCounter.setText("Gold: " + player.getGold());
					playerData.Save(database.getSave());
				} else {
					int tempGold = 0;
					switch (database.getFloor()) {
					case 1:
						tempGold = generator.nextInt(10) + 5;
						break;
					case 2:
						tempGold = generator.nextInt(20) + 15;
						break;
					case 3:
						tempGold = generator.nextInt(30) + 25;
						break;
					case 4:
						tempGold = generator.nextInt(40) + 35;
						break;
					case 5:
						tempGold = generator.nextInt(50) + 45;
						break;
					}
					JOptionPane.showMessageDialog(window.window,
							"You defeated the enemy and gained " + tempGold + " gold!");
					player.setGold(player.getGold() + tempGold);
				}
			}
		}
		if (e.getSource() == window.dungeonFlee) {
			int result[] = playerActions.flee(window.playerHealthLabel);
			switch (result[0]) {
			case 0:
				JOptionPane.showMessageDialog(window.window,
						"You were unable to escape and took " + result[1] + " damage!");
				break;
			case 1:
				window.dungeonPanel.setVisible(false);
				window.townPanel.setVisible(true);
				JOptionPane.showMessageDialog(window.window,
						"You passed out from all of your injuries and were brought back to town! The doctor took some of your gold as expenses!");
				player.setGold(player.getGold() - player.getGold() / 20);
				window.goldCounter.setText("Gold: " + player.getGold());
				playerData.Save(database.getSave());
				break;
			case 2:
				window.dungeonPanel.setVisible(false);
				window.townPanel.setVisible(true);
				JOptionPane.showMessageDialog(window.window, "You successfully escaped!");
				window.goldCounter.setText("Gold: " + player.getGold());
				player.restoreHealth();
				playerData.Save(database.getSave());
				break;
			}
		}

		// Enemy Defeated Options
		if (e.getSource() == window.dungeonContinue) {
			database.setRoom(database.getRoom() + 1);
			window.dungeonOptionsPanel.setVisible(true);
			window.dungeonEnemyDefeatedPanel.setVisible(false);
			if (database.getRoom() <= 9) {
				switch (database.getFloor()) {
				case 1:
					dungeon.createRoom(database.getFloor1E(), database.getFloor1S(), false);
					break;
				case 2:
					dungeon.createRoom(database.getFloor2E(), database.getFloor2S(), false);
					break;
				case 3:
					dungeon.createRoom(database.getFloor3E(), database.getFloor3S(), false);
					break;
				case 4:
					dungeon.createRoom(database.getFloor4E(), database.getFloor4S(), false);
					break;
				case 5:
					dungeon.createRoom(database.getFloor5E(), database.getFloor5S(), false);
					break;
				}
				window.currentRoom.setText("Room " + database.getRoom());
			} else {
				switch (database.getFloor()) {
				case 1:
					dungeon.createBoss("Harold the Gnome", 32, 3, 5, 88);
					window.displayDialog("boss1");
					break;
				case 2:
					dungeon.createBoss("Agrius, King of the Wilds", 48, 11, 7, 76);
					window.displayDialog("boss2");
					break;
				case 3:
					dungeon.createBoss("Veneficus, King of Magic", 62, 14, 4, 82);
					window.displayDialog("boss3");
					break;
				case 4:
					dungeon.createBoss("Sicarius, King of Shadows", 72, 22, 6, 84);
					window.displayDialog("boss4");
					break;
				case 5:
					dungeon.createBoss("Eques, King of Man", 84, 26, 8, 86);
					window.displayDialog("boss5");
					break;
				}
			}
		}
		if (e.getSource() == window.dungeonLeave) {
			window.dungeonOptionsPanel.setVisible(true);
			window.dungeonEnemyDefeatedPanel.setVisible(false);
			window.dungeonPanel.setVisible(false);
			window.townPanel.setVisible(true);
			window.goldCounter.setText("Gold: " + player.getGold());
			player.restoreHealth();
			playerData.Save(database.getSave());
		}

		// Boss Intros
		if (e.getSource() == window.continueBoss1) {
			window.hideDialog("boss1");
		}
		if (e.getSource() == window.continueBoss2) {
			window.hideDialog("boss2");
		}
		if (e.getSource() == window.continueBoss3) {
			window.hideDialog("boss3");
		}
		if (e.getSource() == window.continueBoss4) {
			window.hideDialog("boss4");
		}
		if (e.getSource() == window.continueBoss5) {
			window.hideDialog("boss5");
		}
	}
}
