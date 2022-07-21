import java.awt.*;
import javax.swing.*;

public class window {
	listener listen;
	
	JFrame window;
	JPanel mainMenuPanel, characterCreationPanel, classSelectionPanel, enterNamePanel, introductionPanel, townPanel,
			townSelectPanel, dungeonPanel, dungeonOptionsPanel, dungeonEnemyDefeatedPanel, weaponShopPanel,
			currentWeaponDisplay, armorShopPanel, currentArmorDisplay, floorSelectPanel, floorSelectButtonsPanel,
			saveSelectPanel, saveSelectButtonsPanel, trainingPanel, accuracyPanel, speedPanel, amuletPanel,
			amuletDisplay;
	JButton playGame, quitGame, confirmClass, confirmPlayerName, continueIntro, continueIntro2, weaponShop, armorShop,
			dungeonEntrance, dungeonLightAttack, dungeonHeavyAttack, dungeonSpecialMove, dungeonFlee, dungeonContinue,
			dungeonLeave, continueBoss1, purchaseWeapon, equipWeapon, leaveWeaponShop, nextWeapon, previousWeapon,
			purchaseArmor, equipArmor, leaveArmorShop, nextArmor, previousArmor, selectFloor, leaveFloorSelection,
			continueBoss2, continueBoss3, continueBoss4, continueBoss5, selectSave, leaveSaveSelection, leaveTown,
			accuracy1, accuracy2, accuracy3, speed1, speed2, speed3, trainingGrounds, leaveTrainingGrounds, equipAmulet,
			leaveAmuletShop, amuletShop, nextAmulet, previousAmulet;
	JLabel title, classSelection, warriorBio, mercenaryBio, paladinBio, enterName, currentEnemyName, currentEnemyHealth,
			playerHealthLabel, playerNameLabel, goldCounter, currentRoom, weaponName, weaponCost, weaponDamage,
			weaponDisplayedCounter, armorName, armorCost, armorHealth, armorDisplayedCounter, townWeaponEquipped,
			townArmorEquipped, accuracy1Cost, accuracy2Cost, accuracy3Cost, speed1Cost, speed2Cost, speed3Cost,
			displayAccuracy, displaySpeed, amuletName, amuletDescription, amuletDisplayedCounter, townAmuletEquipped;
	JRadioButton warriorClass, mercenaryClass, paladinClass, firstFloor, secondFloor, thirdFloor, fourthFloor,
			fifthFloor, save1, save2, save3, save4, save5;
	JTextField playerName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 84);
	static Font textFont = new Font("Times New Roman", Font.PLAIN, 32);
	Font shopFont = new Font("Times New Roman", Font.PLAIN, 24);
	private static JDialog intro1, intro2, boss1, boss2, boss3, boss4, boss5;
	
	public void displayDialog(String name) {
		if (name.equals("intro1")) {
			intro1.setVisible(true);
		} else if (name.equals("intro2")) {
			intro2.setVisible(true);
		} else if (name.equals("boss1")) {
			boss1.setVisible(true);
		} else if (name.equals("boss2")) {
			boss2.setVisible(true);
		} else if (name.equals("boss3")) {
			boss3.setVisible(true);
		} else if (name.equals("boss4")) {
			boss4.setVisible(true);
		} else if (name.equals("boss5")) {
			boss5.setVisible(true);
		}
	}
	
	public void hideDialog(String name) {
		if (name.equals("intro1")) {
			intro1.setVisible(false);
		} else if (name.equals("intro2")) {
			intro2.setVisible(false);
		} else if (name.equals("boss1")) {
			boss1.setVisible(false);
		} else if (name.equals("boss2")) {
			boss2.setVisible(false);
		} else if (name.equals("boss3")) {
			boss3.setVisible(false);
		} else if (name.equals("boss4")) {
			boss4.setVisible(false);
		} else if (name.equals("boss5")) {
			boss5.setVisible(false);
		}
	}
	
	public void window() {
		// Main Menu Panel
				mainMenuPanel = new JPanel();
				mainMenuPanel.setBounds(0, 0, 900, 650);
				mainMenuPanel.setBackground(Color.black);
				mainMenuPanel.setLayout(null);
				playGame = new JButton("Play Game");
				playGame.setBounds(350, 280, 200, 50);
				playGame.setBackground(Color.gray);
				playGame.addActionListener(listen);
				listen = new listener(playGame);
				mainMenuPanel.add(playGame);
				quitGame = new JButton("Quit Game");
				quitGame.setBounds(350, 350, 200, 50);
				quitGame.setBackground(Color.gray);
				quitGame.addActionListener(listen);
				mainMenuPanel.add(quitGame);
				title = new JLabel("Bozo Legends");
				title.setFont(titleFont);
				title.setForeground(Color.yellow);
				title.setBounds(230, 100, 500, 100);
				mainMenuPanel.add(title);
				mainMenuPanel.setVisible(true);
				
				// Character Creation Panel
				characterCreationPanel = new JPanel();
				characterCreationPanel.setBounds(0, 0, 900, 650);
				characterCreationPanel.setBackground(Color.black);
				characterCreationPanel.setLayout(null);
				classSelectionPanel = new JPanel();
				classSelectionPanel.setBounds(45, 90, 800, 350);
				classSelectionPanel.setBackground(Color.gray);
				classSelectionPanel.setLayout(null);
				classSelectionPanel.setVisible(false);
				characterCreationPanel.add(classSelectionPanel);
				classSelection = new JLabel("Select a class:");
				classSelection.setFont(textFont);
				classSelection.setBounds(20, 30, 200, 30);
				classSelectionPanel.add(classSelection);
				warriorClass = new JRadioButton("Warrior");
				warriorClass.setBounds(100, 80, 100, 30);
				mercenaryClass = new JRadioButton("Mercenary");
				mercenaryClass.setBounds(220, 80, 100, 30);
				paladinClass = new JRadioButton("Paladin");
				paladinClass.setBounds(340, 80, 100, 30);
				ButtonGroup classSelectionButtons = new ButtonGroup();
				classSelectionButtons.add(warriorClass);
				classSelectionButtons.add(mercenaryClass);
				classSelectionButtons.add(paladinClass);
				classSelectionPanel.add(warriorClass);
				classSelectionPanel.add(mercenaryClass);
				classSelectionPanel.add(paladinClass);
				warriorBio = new JLabel(
						"Warrior[HP: 18, Damage: 2, Speed: 4, Accuracy: 84] Special Move: Heal for 1/3 of max health.");
				warriorBio.setBounds(100, 120, 900, 30);
				mercenaryBio = new JLabel(
						"Mercenary[HP: 14, Damage: 3, Speed: 1, Accuracy: 72] Special Move: Guaranteed Heavy Attack.");
				mercenaryBio.setBounds(100, 150, 900, 30);
				paladinBio = new JLabel(
						"Paladin[HP: 22, Damage: 1, Speed: 2, Accuracy: 80] Special Move: Damage enemy and heal for 1/5 of max health.");
				paladinBio.setBounds(100, 180, 900, 30);
				classSelectionPanel.add(warriorBio);
				classSelectionPanel.add(mercenaryBio);
				classSelectionPanel.add(paladinBio);
				classSelectionPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				confirmClass = new JButton("Confirm Class");
				confirmClass.setBounds(325, 270, 150, 50);
				confirmClass.addActionListener(listen);
				classSelectionPanel.add(confirmClass);
				enterNamePanel = new JPanel();
				enterNamePanel.setBounds(45, 90, 800, 350);
				enterNamePanel.setBackground(Color.gray);
				enterNamePanel.setLayout(null);
				enterNamePanel.setVisible(false);
				enterNamePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				characterCreationPanel.add(enterNamePanel);
				enterName = new JLabel("Enter your character's name:");
				enterName.setFont(textFont);
				enterName.setBounds(230, 80, 400, 50);
				enterNamePanel.add(enterName);
				playerName = new JTextField("");
				playerName.setBounds(210, 150, 400, 30);
				enterNamePanel.add(playerName);
				confirmPlayerName = new JButton("Confirm Name");
				confirmPlayerName.setBounds(325, 270, 150, 50);
				confirmPlayerName.addActionListener(listen);
				enterNamePanel.add(confirmPlayerName);
				characterCreationPanel.setVisible(false);
				
				// Introduction Panel
				introductionPanel = new JPanel();
				introductionPanel.setBounds(0, 0, 900, 650);
				introductionPanel.setBackground(Color.black);
				introductionPanel.setLayout(null);
				intro1 = new JDialog(window, "Introduction", true);
				intro1.setLayout(new FlowLayout());
				continueIntro = new JButton("Continue");
				continueIntro.addActionListener(listen);
				intro1.add(new JLabel("Long long ago, there was legend of a true bozo warrior."));
				intro1.add(new JLabel("He was fabled to be the strongest in the land, with weapons of mass destruction"));
				intro1.add(new JLabel("that could only be dreamt up by the imagination. After his time passed,"));
				intro1.add(new JLabel("darkness rose again to reclaim their lost kingdom. It is up to you now intrepid"));
				intro1.add(new JLabel("adventurer. Reclaim our land! Slay the four Kings of Darkness! SAVE US!"));
				intro1.setLocation(200, 200);
				intro1.add(continueIntro);
				intro1.setSize(550, 200);
				intro2 = new JDialog(window, "Introduction", false);
				intro2.setLayout(new FlowLayout());
				continueIntro2 = new JButton("Continue");
				continueIntro2.addActionListener(listen);
				intro2.add(new JLabel("'You...adventurer...what is your name? Not a speaker, eh? Hm. Peculiar."));
				intro2.add(new JLabel("You seek to save us yet from this dire situation we find ourselves in, yes?"));
				intro2.add(new JLabel("Well in that case you will need tools. Head to town down the road from here."));
				intro2.add(new JLabel("There you will find multiple shops with the things you will need. And here, take"));
				intro2.add(new JLabel("this gold to start you off. It should be enough to get yourself a weapon. Good luck.'"));
				intro2.setLocation(200, 200);
				intro2.add(continueIntro2);
				intro2.setSize(550, 200);
				introductionPanel.setVisible(false);
				
				// Boss 1
				boss1 = new JDialog(window, "Floor Boss", false);
				boss1.setLayout(new FlowLayout());
				continueBoss1 = new JButton("Continue");
				continueBoss1.addActionListener(listen);
				boss1.add(new JLabel("You walk to the end of the graveyard to find a large shadow looming over you."));
				boss1.add(new JLabel("The shadow notices you and begins to grow bigger as it approaches."));
				boss1.add(new JLabel("All of a sudden, the shadow shrinks, and a small gnome appears in the doorway"));
				boss1.add(new JLabel("wielding a tiny hammer. He yells 'GIMME THEM TOES BITCH"));
				boss1.setLocation(200, 200);
				boss1.add(continueBoss1);
				boss1.setSize(550, 200);
				
				// Boss 2
				boss2 = new JDialog(window, "Floor Boss", false);
				boss2.setLayout(new FlowLayout());
				boss2.add(new JLabel("As the forest grows darker the trees grow closer together, making it"));
				boss2.add(new JLabel("difficult to navigate the terrain. The trees suddenly part ways to reveal"));
				boss2.add(new JLabel("a small clearing, with a tree standing tall in the center. The tree begins"));
				boss2.add(new JLabel("to move, with no intention of letting you leave it's domain alive."));
				boss2.setLocation(200, 200);
				boss2.setSize(550, 200);
				continueBoss2 = new JButton("Continue");
				continueBoss2.addActionListener(listen);
				boss2.add(continueBoss2);

				// Boss 3
				boss3 = new JDialog(window, "Floor Boss", false);
				boss3.setLayout(new FlowLayout());
				boss3.add(new JLabel("The library halls converge into a main study area, with a cauldron in the"));
				boss3.add(new JLabel("middle. Smoke begins to rise from the cauldron as an entity makes its"));
				boss3.add(new JLabel("known. The being looks down upon you, ready to take you from this world."));
				boss3.setLocation(200, 200);
				boss3.setSize(550, 200);
				continueBoss3 = new JButton("Continue");
				continueBoss3.addActionListener(listen);
				boss3.add(continueBoss3);

				// Boss 4
				boss4 = new JDialog(window, "Floor Boss", false);
				boss4.setLayout(new FlowLayout());
				boss4.add(new JLabel("The shadows collect into one spot and form a man in a cloak. With dagger"));
				boss4.add(new JLabel("in hand, he stares you down with a menacing grin. He extends his hand out"));
				boss4.add(new JLabel("and beckons you forward to make the first move."));
				boss4.setLocation(200, 200);
				boss4.setSize(550, 200);
				continueBoss4 = new JButton("Continue");
				continueBoss4.addActionListener(listen);
				boss4.add(continueBoss4);

				// Boss 5
				boss5 = new JDialog(window, "Floor Boss", false);
				boss5.setLayout(new FlowLayout());
				boss5.add(new JLabel("The corridors lead you to the king's hall, where a knight in golden armor"));
				boss5.add(new JLabel("awaits. 'It has been a while since I have faced a bozo of such renown', he"));
				boss5.add(new JLabel("says. 'Come forth bozo. Prove the legends of you are as true as many make"));
				boss5.add(new JLabel("them seem to be.'"));
				boss5.setLocation(200, 200);
				boss5.setSize(550, 200);
				continueBoss5 = new JButton("Continue");
				continueBoss5.addActionListener(listen);
				boss5.add(continueBoss5);

				// Town Panel
				townPanel = new JPanel();
				townPanel.setBounds(0, 0, 900, 650);
				townPanel.setBackground(Color.black);
				townPanel.setLayout(null);
				townSelectPanel = new JPanel();
				townSelectPanel.setBounds(45, 220, 800, 350);
				townSelectPanel.setBackground(Color.gray);
				townSelectPanel.setLayout(null);
				townSelectPanel.setVisible(false);
				townSelectPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				townPanel.add(townSelectPanel);
				weaponShop = new JButton("Weapon Shop");
				weaponShop.setBounds(50, 80, 200, 50);
				weaponShop.addActionListener(listen);
				townSelectPanel.add(weaponShop);
				armorShop = new JButton("Armor Shop");
				armorShop.setBounds(50, 160, 200, 50);
				armorShop.addActionListener(listen);
				townSelectPanel.add(armorShop);
				dungeonEntrance = new JButton("Dungeon Entrance");
				dungeonEntrance.setBounds(50, 240, 200, 50);
				dungeonEntrance.addActionListener(listen);
				townSelectPanel.add(dungeonEntrance);
				trainingGrounds = new JButton("Training Grounds");
				trainingGrounds.setBounds(300, 80, 200, 50);
				trainingGrounds.addActionListener(listen);
				townSelectPanel.add(trainingGrounds);
				amuletShop = new JButton("Amulets");
				amuletShop.setBounds(300, 160, 200, 50);
				amuletShop.addActionListener(listen);
				townSelectPanel.add(amuletShop);
				leaveTown = new JButton("Return to Menu");
				leaveTown.setBounds(550, 240, 200, 50);
				leaveTown.addActionListener(listen);
				townSelectPanel.add(leaveTown);
				goldCounter = new JLabel("");
				goldCounter.setBounds(550, 10, 300, 80);
				goldCounter.setFont(textFont);
				goldCounter.setForeground(Color.yellow);
				goldCounter.setHorizontalAlignment(SwingConstants.RIGHT);
				townWeaponEquipped = new JLabel("Weapon: Fists");
				townWeaponEquipped.setBounds(40, 10, 500, 80);
				townWeaponEquipped.setFont(textFont);
				townWeaponEquipped.setForeground(Color.white);
				townWeaponEquipped.setHorizontalAlignment(SwingConstants.LEFT);
				townArmorEquipped = new JLabel("Armor: None");
				townArmorEquipped.setBounds(40, 50, 500, 80);
				townArmorEquipped.setFont(textFont);
				townArmorEquipped.setForeground(Color.white);
				townArmorEquipped.setHorizontalAlignment(SwingConstants.LEFT);
				townAmuletEquipped = new JLabel("Amulet: None");
				townAmuletEquipped.setBounds(40, 90, 500, 80);
				townAmuletEquipped.setFont(textFont);
				townAmuletEquipped.setForeground(Color.white);
				townAmuletEquipped.setHorizontalAlignment(SwingConstants.LEFT);
				townPanel.add(townWeaponEquipped);
				townPanel.add(townArmorEquipped);
				townPanel.add(townAmuletEquipped);
				townPanel.add(goldCounter);
				townPanel.setVisible(false);

				// Training Panel
				trainingPanel = new JPanel();
				trainingPanel.setBounds(0, 0, 900, 650);
				trainingPanel.setBackground(Color.black);
				trainingPanel.setLayout(null);
				accuracyPanel = new JPanel();
				accuracyPanel.setBounds(100, 75, 300, 400);
				accuracyPanel.setBackground(Color.gray);
				accuracyPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				accuracyPanel.setLayout(null);
				trainingPanel.add(accuracyPanel);
				displayAccuracy = new JLabel("Your Accuracy: ");
				displayAccuracy.setBounds(50, 20, 200, 50);
				displayAccuracy.setHorizontalAlignment(SwingConstants.CENTER);
				displayAccuracy.setFont(shopFont);
				accuracyPanel.add(displayAccuracy);
				accuracy1 = new JButton("Accuracy +1");
				accuracy1.setBounds(50, 95, 200, 50);
				accuracy1.addActionListener(listen);
				accuracy1Cost = new JLabel("100 Gold");
				accuracy1Cost.setBounds(50, 135, 200, 50);
				accuracy1Cost.setHorizontalAlignment(SwingConstants.CENTER);
				accuracy1Cost.setFont(shopFont);
				accuracyPanel.add(accuracy1);
				accuracyPanel.add(accuracy1Cost);
				accuracy2 = new JButton("Accuracy +2");
				accuracy2.setBounds(50, 195, 200, 50);
				accuracy2.addActionListener(listen);
				accuracy2Cost = new JLabel("180 Gold");
				accuracy2Cost.setBounds(50, 235, 200, 50);
				accuracy2Cost.setHorizontalAlignment(SwingConstants.CENTER);
				accuracy2Cost.setFont(shopFont);
				accuracyPanel.add(accuracy2);
				accuracyPanel.add(accuracy2Cost);
				accuracy3 = new JButton("Accuracy +3");
				accuracy3.setBounds(50, 295, 200, 50);
				accuracy3.addActionListener(listen);
				accuracy3Cost = new JLabel("240 Gold");
				accuracy3Cost.setBounds(50, 335, 200, 50);
				accuracy3Cost.setHorizontalAlignment(SwingConstants.CENTER);
				accuracy3Cost.setFont(shopFont);
				accuracyPanel.add(accuracy3);
				accuracyPanel.add(accuracy3Cost);
				speedPanel = new JPanel();
				speedPanel.setBounds(475, 75, 300, 400);
				speedPanel.setBackground(Color.gray);
				speedPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				speedPanel.setLayout(null);
				trainingPanel.add(speedPanel);
				displaySpeed = new JLabel("Your Speed: ");
				displaySpeed.setBounds(50, 20, 200, 50);
				displaySpeed.setHorizontalAlignment(SwingConstants.CENTER);
				displaySpeed.setFont(shopFont);
				speedPanel.add(displaySpeed);
				speed1 = new JButton("Speed +1");
				speed1.setBounds(50, 95, 200, 50);
				speed1.addActionListener(listen);
				speed1Cost = new JLabel("175 Gold");
				speed1Cost.setBounds(50, 135, 200, 50);
				speed1Cost.setHorizontalAlignment(SwingConstants.CENTER);
				speed1Cost.setFont(shopFont);
				speedPanel.add(speed1);
				speedPanel.add(speed1Cost);
				speed2 = new JButton("Speed +2");
				speed2.setBounds(50, 195, 200, 50);
				speed2.addActionListener(listen);
				speed2Cost = new JLabel("250 Gold");
				speed2Cost.setBounds(50, 235, 200, 50);
				speed2Cost.setHorizontalAlignment(SwingConstants.CENTER);
				speed2Cost.setFont(shopFont);
				speedPanel.add(speed2);
				speedPanel.add(speed2Cost);
				speed3 = new JButton("Speed +3");
				speed3.setBounds(50, 295, 200, 50);
				speed3.addActionListener(listen);
				speed3Cost = new JLabel("310 Gold");
				speed3Cost.setBounds(50, 335, 200, 50);
				speed3Cost.setHorizontalAlignment(SwingConstants.CENTER);
				speed3Cost.setFont(shopFont);
				speedPanel.add(speed3);
				speedPanel.add(speed3Cost);
				leaveTrainingGrounds = new JButton("Return to Town");
				leaveTrainingGrounds.setBounds(363, 500, 150, 40);
				leaveTrainingGrounds.addActionListener(listen);
				trainingPanel.add(leaveTrainingGrounds);
				trainingPanel.setVisible(false);

				// Save Select Panel
				saveSelectPanel = new JPanel();
				saveSelectPanel.setBounds(0, 0, 900, 650);
				saveSelectPanel.setBackground(Color.black);
				saveSelectPanel.setLayout(null);
				saveSelectButtonsPanel = new JPanel();
				saveSelectButtonsPanel.setBounds(300, 50, 300, 500);
				saveSelectButtonsPanel.setBackground(Color.gray);
				saveSelectButtonsPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				saveSelectButtonsPanel.setLayout(null);
				saveSelectPanel.add(saveSelectButtonsPanel);
				save1 = new JRadioButton("Empty Save");
				save1.setBounds(25, 50, 250, 30);
				save2 = new JRadioButton("Empty Save");
				save2.setBounds(25, 100, 250, 30);
				save3 = new JRadioButton("Empty Save");
				save3.setBounds(25, 150, 250, 30);
				save4 = new JRadioButton("Empty Save");
				save4.setBounds(25, 200, 250, 30);
				save5 = new JRadioButton("Empty Save");
				save5.setBounds(25, 250, 250, 30);
				ButtonGroup saveSelection = new ButtonGroup();
				saveSelection.add(save1);
				saveSelection.add(save2);
				saveSelection.add(save3);
				saveSelection.add(save4);
				saveSelection.add(save5);
				selectSave = new JButton("Select Save");
				selectSave.setBounds(75, 375, 150, 30);
				selectSave.addActionListener(listen);
				leaveSaveSelection = new JButton("Return to Menu");
				leaveSaveSelection.setBounds(75, 425, 150, 30);
				leaveSaveSelection.addActionListener(listen);
				saveSelectButtonsPanel.add(save1);
				saveSelectButtonsPanel.add(save2);
				saveSelectButtonsPanel.add(save3);
				saveSelectButtonsPanel.add(save4);
				saveSelectButtonsPanel.add(save5);
				saveSelectButtonsPanel.add(selectSave);
				saveSelectButtonsPanel.add(leaveSaveSelection);
				saveSelectPanel.setVisible(false);

				// Floor Select Panel
				floorSelectPanel = new JPanel();
				floorSelectPanel.setBounds(0, 0, 900, 650);
				floorSelectPanel.setBackground(Color.black);
				floorSelectPanel.setLayout(null);
				floorSelectButtonsPanel = new JPanel();
				floorSelectButtonsPanel.setBounds(300, 50, 300, 500);
				floorSelectButtonsPanel.setBackground(Color.gray);
				floorSelectButtonsPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				floorSelectButtonsPanel.setLayout(null);
				floorSelectPanel.add(floorSelectButtonsPanel);
				firstFloor = new JRadioButton("Floor 1");
				firstFloor.setBounds(100, 50, 100, 30);
				secondFloor = new JRadioButton("Floor 2");
				secondFloor.setBounds(100, 100, 100, 30);
				thirdFloor = new JRadioButton("Floor 3");
				thirdFloor.setBounds(100, 150, 100, 30);
				fourthFloor = new JRadioButton("Floor 4");
				fourthFloor.setBounds(100, 200, 100, 30);
				fifthFloor = new JRadioButton("Floor 5");
				fifthFloor.setBounds(100, 250, 100, 30);
				ButtonGroup floorSelection = new ButtonGroup();
				floorSelection.add(firstFloor);
				floorSelection.add(secondFloor);
				floorSelection.add(thirdFloor);
				floorSelection.add(fourthFloor);
				floorSelection.add(fifthFloor);
				selectFloor = new JButton("Enter Floor");
				selectFloor.setBounds(75, 375, 150, 30);
				selectFloor.addActionListener(listen);
				leaveFloorSelection = new JButton("Return to Town");
				leaveFloorSelection.setBounds(75, 425, 150, 30);
				leaveFloorSelection.addActionListener(listen);
				floorSelectButtonsPanel.add(firstFloor);
				floorSelectButtonsPanel.add(secondFloor);
				floorSelectButtonsPanel.add(thirdFloor);
				floorSelectButtonsPanel.add(fourthFloor);
				floorSelectButtonsPanel.add(fifthFloor);
				floorSelectButtonsPanel.add(selectFloor);
				floorSelectButtonsPanel.add(leaveFloorSelection);
				floorSelectPanel.setVisible(false);

				// Dungeon Panel
				dungeonPanel = new JPanel();
				dungeonPanel.setBounds(0, 0, 900, 650);
				dungeonPanel.setBackground(Color.black);
				dungeonPanel.setLayout(null);
				dungeonOptionsPanel = new JPanel();
				dungeonOptionsPanel.setBounds(45, 270, 800, 290);
				dungeonOptionsPanel.setBackground(Color.gray);
				dungeonOptionsPanel.setLayout(null);
				dungeonOptionsPanel.setVisible(false);
				dungeonOptionsPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				dungeonPanel.add(dungeonOptionsPanel);
				dungeonLightAttack = new JButton("Light Attack");
				dungeonLightAttack.setBounds(10, 30, 380, 100);
				dungeonLightAttack.addActionListener(listen);
				dungeonOptionsPanel.add(dungeonLightAttack);
				dungeonHeavyAttack = new JButton("Heavy Attack");
				dungeonHeavyAttack.setBounds(410, 30, 380, 100);
				dungeonHeavyAttack.addActionListener(listen);
				dungeonOptionsPanel.add(dungeonHeavyAttack);
				dungeonSpecialMove = new JButton("Special Move");
				dungeonSpecialMove.setBounds(10, 150, 380, 100);
				dungeonSpecialMove.addActionListener(listen);
				dungeonOptionsPanel.add(dungeonSpecialMove);
				dungeonFlee = new JButton("Flee");
				dungeonFlee.setBounds(410, 150, 380, 100);
				dungeonFlee.addActionListener(listen);
				dungeonOptionsPanel.add(dungeonFlee);
				currentEnemyName = new JLabel("");
				currentEnemyName.setBounds(50, 30, 400, 80);
				currentEnemyName.setFont(textFont);
				currentEnemyName.setForeground(Color.white);
				currentEnemyHealth = new JLabel("");
				currentEnemyHealth.setBounds(50, 120, 300, 80);
				currentEnemyHealth.setFont(textFont);
				currentEnemyHealth.setForeground(Color.white);
				dungeonPanel.add(currentEnemyName);
				dungeonPanel.add(currentEnemyHealth);
				playerNameLabel = new JLabel("");
				playerNameLabel.setBounds(540, 30, 300, 80);
				playerNameLabel.setFont(textFont);
				playerNameLabel.setForeground(Color.white);
				playerNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
				playerHealthLabel = new JLabel("");
				playerHealthLabel.setBounds(540, 120, 300, 80);
				playerHealthLabel.setFont(textFont);
				playerHealthLabel.setForeground(Color.white);
				playerHealthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
				dungeonPanel.add(playerNameLabel);
				dungeonPanel.add(playerHealthLabel);
				dungeonEnemyDefeatedPanel = new JPanel();
				dungeonEnemyDefeatedPanel.setBounds(45, 270, 800, 290);
				dungeonEnemyDefeatedPanel.setBackground(Color.gray);
				dungeonEnemyDefeatedPanel.setLayout(null);
				dungeonEnemyDefeatedPanel.setVisible(false);
				dungeonEnemyDefeatedPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				dungeonPanel.add(dungeonEnemyDefeatedPanel);
				dungeonContinue = new JButton("Delve Deeper");
				dungeonContinue.setBounds(10, 100, 380, 100);
				dungeonContinue.addActionListener(listen);
				dungeonLeave = new JButton("Return to Town");
				dungeonLeave.setBounds(410, 100, 380, 100);
				dungeonLeave.addActionListener(listen);
				dungeonEnemyDefeatedPanel.add(dungeonContinue);
				dungeonEnemyDefeatedPanel.add(dungeonLeave);
				currentRoom = new JLabel("Room 1");
				currentRoom.setBounds(50, 0, 300, 80);
				currentRoom.setFont(textFont);
				currentRoom.setForeground(Color.white);
				dungeonPanel.add(currentRoom);
				dungeonPanel.setVisible(false);

				// Weapon Shop
				weaponShopPanel = new JPanel();
				weaponShopPanel.setBounds(0, 0, 900, 650);
				weaponShopPanel.setBackground(Color.black);
				weaponShopPanel.setLayout(null);
				currentWeaponDisplay = new JPanel();
				currentWeaponDisplay.setBounds(245, 50, 400, 500);
				currentWeaponDisplay.setBackground(Color.gray);
				currentWeaponDisplay.setLayout(null);
				currentWeaponDisplay.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				weaponShopPanel.add(currentWeaponDisplay);
				weaponName = new JLabel();
				weaponName.setBounds(50, 30, 300, 50);
				weaponName.setFont(textFont);
				weaponName.setForeground(Color.white);
				weaponName.setHorizontalAlignment(SwingConstants.CENTER);
				weaponCost = new JLabel();
				weaponCost.setBounds(100, 75, 200, 30);
				weaponCost.setFont(shopFont);
				weaponCost.setForeground(Color.white);
				weaponCost.setHorizontalAlignment(SwingConstants.CENTER);
				weaponDamage = new JLabel();
				weaponDamage.setBounds(100, 100, 200, 30);
				weaponDamage.setFont(shopFont);
				weaponDamage.setForeground(Color.white);
				weaponDamage.setHorizontalAlignment(SwingConstants.CENTER);
				currentWeaponDisplay.add(weaponName);
				currentWeaponDisplay.add(weaponCost);
				currentWeaponDisplay.add(weaponDamage);
				purchaseWeapon = new JButton("Purchase Weapon");
				purchaseWeapon.setBounds(100, 320, 200, 50);
				purchaseWeapon.addActionListener(listen);
				equipWeapon = new JButton("Equip Weapon");
				equipWeapon.setBounds(100, 320, 200, 50);
				equipWeapon.addActionListener(listen);
				leaveWeaponShop = new JButton("Leave Shop");
				leaveWeaponShop.setBounds(100, 390, 200, 50);
				leaveWeaponShop.addActionListener(listen);
				currentWeaponDisplay.add(purchaseWeapon);
				currentWeaponDisplay.add(equipWeapon);
				currentWeaponDisplay.add(leaveWeaponShop);
				equipWeapon.setVisible(false);
				nextWeapon = new JButton(">");
				nextWeapon.setBounds(650, 250, 50, 80);
				nextWeapon.addActionListener(listen);
				nextWeapon.setBackground(Color.green);
				previousWeapon = new JButton("<");
				previousWeapon.setBounds(190, 250, 50, 80);
				previousWeapon.addActionListener(listen);
				previousWeapon.setBackground(Color.darkGray);
				weaponShopPanel.add(nextWeapon);
				weaponShopPanel.add(previousWeapon);
				weaponDisplayedCounter = new JLabel();
				weaponDisplayedCounter.setBounds(150, 10, 100, 30);
				weaponDisplayedCounter.setHorizontalAlignment(SwingConstants.CENTER);
				currentWeaponDisplay.add(weaponDisplayedCounter);
				weaponShopPanel.setVisible(false);

				// Armor Shop
				armorShopPanel = new JPanel();
				armorShopPanel.setBounds(0, 0, 900, 650);
				armorShopPanel.setBackground(Color.black);
				armorShopPanel.setLayout(null);
				currentArmorDisplay = new JPanel();
				currentArmorDisplay.setBounds(245, 50, 400, 500);
				currentArmorDisplay.setBackground(Color.gray);
				currentArmorDisplay.setLayout(null);
				currentArmorDisplay.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				armorShopPanel.add(currentArmorDisplay);
				armorName = new JLabel();
				armorName.setBounds(50, 30, 300, 50);
				armorName.setFont(textFont);
				armorName.setForeground(Color.white);
				armorName.setHorizontalAlignment(SwingConstants.CENTER);
				armorCost = new JLabel();
				armorCost.setBounds(100, 75, 200, 30);
				armorCost.setFont(shopFont);
				armorCost.setForeground(Color.white);
				armorCost.setHorizontalAlignment(SwingConstants.CENTER);
				armorHealth = new JLabel();
				armorHealth.setBounds(100, 100, 200, 30);
				armorHealth.setFont(shopFont);
				armorHealth.setForeground(Color.white);
				armorHealth.setHorizontalAlignment(SwingConstants.CENTER);
				currentArmorDisplay.add(armorName);
				currentArmorDisplay.add(armorCost);
				currentArmorDisplay.add(armorHealth);
				purchaseArmor = new JButton("Purchase Armor");
				purchaseArmor.setBounds(100, 320, 200, 50);
				purchaseArmor.addActionListener(listen);
				equipArmor = new JButton("Equip Armor");
				equipArmor.setBounds(100, 320, 200, 50);
				equipArmor.addActionListener(listen);
				leaveArmorShop = new JButton("Leave Shop");
				leaveArmorShop.setBounds(100, 390, 200, 50);
				leaveArmorShop.addActionListener(listen);
				currentArmorDisplay.add(purchaseArmor);
				currentArmorDisplay.add(equipArmor);
				currentArmorDisplay.add(leaveArmorShop);
				equipArmor.setVisible(false);
				nextArmor = new JButton(">");
				nextArmor.setBounds(650, 250, 50, 80);
				nextArmor.addActionListener(listen);
				nextArmor.setBackground(Color.green);
				previousArmor = new JButton("<");
				previousArmor.setBounds(190, 250, 50, 80);
				previousArmor.addActionListener(listen);
				previousArmor.setBackground(Color.darkGray);
				armorShopPanel.add(nextArmor);
				armorShopPanel.add(previousArmor);
				armorDisplayedCounter = new JLabel();
				armorDisplayedCounter.setBounds(150, 10, 100, 30);
				armorDisplayedCounter.setHorizontalAlignment(SwingConstants.CENTER);
				currentArmorDisplay.add(armorDisplayedCounter);
				armorShopPanel.setVisible(false);

				// Amulet Collection
				amuletPanel = new JPanel();
				amuletPanel.setBounds(0, 0, 900, 650);
				amuletPanel.setBackground(Color.black);
				amuletPanel.setLayout(null);
				amuletDisplay = new JPanel();
				amuletDisplay.setBounds(245, 50, 400, 500);
				amuletDisplay.setBackground(Color.gray);
				amuletDisplay.setLayout(null);
				amuletDisplay.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				amuletPanel.add(amuletDisplay);
				amuletName = new JLabel();
				amuletName.setBounds(50, 30, 300, 50);
				amuletName.setFont(textFont);
				amuletName.setForeground(Color.white);
				amuletName.setHorizontalAlignment(SwingConstants.CENTER);
				amuletDescription = new JLabel();
				amuletDescription.setBounds(90, 100, 210, 30);
				amuletDescription.setForeground(Color.white);
				amuletDescription.setHorizontalAlignment(SwingConstants.CENTER);
				amuletDisplay.add(amuletName);
				amuletDisplay.add(amuletDescription);
				equipAmulet = new JButton("Equip Amulet");
				equipAmulet.setBounds(100, 320, 200, 50);
				equipAmulet.addActionListener(listen);
				equipAmulet.setVisible(false);
				leaveAmuletShop = new JButton("Return to Town");
				leaveAmuletShop.setBounds(100, 390, 200, 50);
				leaveAmuletShop.addActionListener(listen);
				amuletDisplay.add(equipAmulet);
				amuletDisplay.add(leaveAmuletShop);
				nextAmulet = new JButton(">");
				nextAmulet.setBounds(650, 250, 50, 80);
				nextAmulet.addActionListener(listen);
				nextAmulet.setBackground(Color.green);
				previousAmulet = new JButton("<");
				previousAmulet.setBounds(190, 250, 50, 80);
				previousAmulet.addActionListener(listen);
				previousAmulet.setBackground(Color.darkGray);
				amuletPanel.add(nextAmulet);
				amuletPanel.add(previousAmulet);
				amuletDisplayedCounter = new JLabel();
				amuletDisplayedCounter.setBounds(150, 10, 100, 30);
				amuletDisplayedCounter.setHorizontalAlignment(SwingConstants.CENTER);
				amuletDisplay.add(amuletDisplayedCounter);
				amuletPanel.setVisible(false);

				// JFrame Settings
				window = new JFrame("Bozo Legends");
				window.setSize(900, 650);
				window.setLayout(null);
				window.setVisible(true);
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setResizable(false);

				// Adding Panels to JFrame
				window.add(mainMenuPanel);
				window.add(characterCreationPanel);
				window.add(introductionPanel);
				window.add(townPanel);
				window.add(dungeonPanel);
				window.add(weaponShopPanel);
				window.add(armorShopPanel);
				window.add(floorSelectPanel);
				window.add(saveSelectPanel);
				window.add(trainingPanel);
				window.add(amuletPanel);
	}
}
