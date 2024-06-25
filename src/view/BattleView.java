package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.Highlighter;

import engine.Game;
import engine.Player;
import exceptions.FriendlyFireException;
import units.Archer;
import units.Army;
import units.Cavalry;
import units.Infantry;
import units.Unit;

public class BattleView extends Frame implements ActionListener, MouseListener {
	private ArrayList<BUnits> MyUnits = new ArrayList<BUnits>();
	private ArrayList<BUnits> EnemyUnits = new ArrayList<BUnits>();
	private JPanel allMyUnits = new JPanel();
	private JPanel allEnemiesUnits = new JPanel();
	private JLabel view = new JLabel();
	private Unit mySelectedUnit;
	private BUnits mySelectedButtonUnit;
	private Unit enemySelectedUnit;
	private BUnits enemySelectedButtonUnit;
	private JTextArea battleLog ;
	

	private JButton attack = new JButton();
	private JButton getAttacked = new JButton();
	private Army Enemy;
	private Army MyArmy;
	Game game;
	private JPanel battleMode;
	private JButton manualAttackButton;
	private JButton autoResolveButton;
	private JButton worldMap;
	private Clip clipBattle;

	public BattleView(Army MyArmy, Army Enemy, Game game) {
		
		try {

			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("Battle.wav").getAbsoluteFile());
			clipBattle = AudioSystem.getClip();
			clipBattle.open(audioInputStream);

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException s) {
			s.printStackTrace();
		}

		clipBattle.start();
		
		
		
		
		
		this.Enemy = Enemy;
		this.MyArmy = MyArmy;
		this.game = game;
		battleLog = new JTextArea();
		battleMode = new JPanel();
		manualAttackButton = new JButton();
		autoResolveButton = new JButton();
		worldMap= new JButton();
		
		worldMap.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		worldMap.setForeground(Color.white);
		worldMap.setBounds(1460, 40, 80, 80);
		worldMap.setToolTipText("Map");
		ImageIcon mapIcon = new ImageIcon("map button.png");
		worldMap.setIcon(mapIcon);
		worldMap.addActionListener(this);
		worldMap.setVisible(false);
		
		

		attack.setBounds(300, 450, 80, 80);
		//attack.setText("Attack");
		attack.setFont(new Font("Viner Hand ITC", Font.PLAIN, 20));
		attack.setToolTipText("Attack");
		ImageIcon attackIcon = new ImageIcon("attackInBattle.png");
		attack.setIcon(attackIcon);
		attack.addActionListener(this);
		//attack.setOpaque(true);
		attack.setContentAreaFilled(false);
		//attack.setBorder(null);

		getAttacked.setBounds(710, 450, 80, 80);
		//getAttacked.setText("getAttack");
		getAttacked.setFont(new Font("Viner Hand ITC", Font.PLAIN, 20));
		getAttacked.setToolTipText("Get Attacked");
		getAttacked.addActionListener(this);
		ImageIcon icon2 = new ImageIcon("get attacked.png");
		getAttacked.setIcon(icon2);
		//getAttacked.setOpaque(true);
		getAttacked.setContentAreaFilled(false);
		//getAttacked.setBorder(null);

		ImageIcon icon = new ImageIcon("Battle view.png");
		view.setIcon(icon);
		view.setBounds(0, 0, 1560, 900);

		battleLog.setBounds(400, 400, 290, 50);
		battleLog.setVisible(true);
		battleLog.setOpaque(true);
		battleLog.setFont(new Font("Viner Hand ITC", Font.PLAIN, 20));
		battleLog.setForeground(Color.red);
		battleLog.setEditable(false);

		allMyUnits.setBounds(10, 10, 800, 330);

		allMyUnits.setVisible(false);
		allMyUnits.setOpaque(false);
		allMyUnits.setLayout(new GridLayout());

		this.add(allMyUnits);

		allEnemiesUnits = new JPanel();
		allEnemiesUnits.setBounds(400, 530, 750, 330);

		allEnemiesUnits.setVisible(false);
		allEnemiesUnits.setOpaque(false);
		allEnemiesUnits.setLayout(new GridLayout());

		battleMode.setLayout(new GridLayout());
		battleMode.setBounds(0, 0, 1650, 1080);
		battleMode.setOpaque(false);
		battleMode.setVisible(true);

		manualAttackButton.setBorder(null);
		manualAttackButton.setVisible(true);
		manualAttackButton.setText("Use manual attack mode to attack the enemy.");
		manualAttackButton.setFont(new Font("Viner Hand ITC", Font.PLAIN, 30));
		manualAttackButton.setBackground(Color.black);

//		// ImageIcon manualAttackButton = new ImageIcon("attack button.png");
//		// manualAttackButton.setIcon(attackIcon);
		
		

		
		autoResolveButton.setBorder(null);
		autoResolveButton.setVisible(true);
		autoResolveButton.setText("Use auto-resolve mode to attack the enemy.");
		autoResolveButton.setFont(new Font("Viner Hand ITC", Font.PLAIN, 30));
		autoResolveButton.setBackground(Color.red);
		
		battleMode.add(manualAttackButton);
		battleMode.add(autoResolveButton);

		manualAttackButton.addActionListener(this);
		autoResolveButton.addActionListener(this);
		
		
		this.add(worldMap);
		this.add(battleMode);

		this.add(battleLog);
		this.add(allEnemiesUnits);

		this.add(attack);
		this.add(getAttacked);
		this.add(view);

		for (Unit u : MyArmy.getUnits()) {
			if (u instanceof Archer) {
				BUnits b = new BUnits("Archer");

				b.addActionListener(this);
				b.setVisible(true);
				MyUnits.add(b);
				allMyUnits.add(b);

			} else if (u instanceof Cavalry) {
				BUnits b = new BUnits("Cavalry");

				b.addActionListener(this);
				b.setVisible(true);
				MyUnits.add(b);
				allMyUnits.add(b);

			} else {
				BUnits b = new BUnits("Infantry");

				b.addActionListener(this);
				b.setVisible(true);
				MyUnits.add(b);
				allMyUnits.add(b);

			}

		}

		for (Unit u : Enemy.getUnits()) {
			if (u instanceof Archer) {
				BUnits b = new BUnits("Archer");
				b.addActionListener(this);
				b.setVisible(true);
				EnemyUnits.add(b);
				allEnemiesUnits.add(b);

			} else if (u instanceof Cavalry) {
				BUnits b = new BUnits("Cavalry");
				b.addActionListener(this);
				b.setVisible(true);
				EnemyUnits.add(b);
				allEnemiesUnits.add(b);

			} else {
				BUnits b = new BUnits("Infantry");
				b.addActionListener(this);
				b.setVisible(true);
				EnemyUnits.add(b);
				allEnemiesUnits.add(b);

			}

		}

		// autoResolve();
		this.revalidate();
		this.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == worldMap) {
			this.dispose();
			new WorldMap(game);
			clipBattle.close();
		}
		
		if (e.getSource() == manualAttackButton) {
			battleMode.setVisible(false);
			allMyUnits.setVisible(true);
			allEnemiesUnits.setVisible(true);
			
		}
		if (e.getSource() == autoResolveButton) {
			autoResolve();
			attack.setVisible(false);
			getAttacked.setVisible(false);
			if (Enemy.getUnits().isEmpty()) {
				
				
				battleLog.setText("You have won your battle");
				worldMap.setVisible(true);
				
				//allMyUnits.setVisible(true);
				//allEnemiesUnits.setVisible(true);
				
			}
			else
				battleLog.setText("You have lost your battle");
				battleMode.setVisible(false);
				worldMap.setVisible(true);
				//allMyUnits.setVisible(true);
				//allEnemiesUnits.setVisible(true);
			
			
		}
		for (int i = 0; i < this.MyArmy.getUnits().size(); i++) {
			BUnits b = MyUnits.get(i);
			Unit u = MyArmy.getUnits().get(i);
			if (e.getSource() == b) {
				mySelectedButtonUnit = b;
				mySelectedUnit = u;
				b.setEnabled(false);
				new Exception(
						"Level: " + mySelectedUnit.getLevel() + " Count: " + mySelectedUnit.getCurrentSoldierCount());

			} else {
				b.setEnabled(true);
			}

		}

		for (int i = 0; i < this.Enemy.getUnits().size(); i++) {
			BUnits b = EnemyUnits.get(i);
			Unit u = Enemy.getUnits().get(i);
			if (e.getSource() == b) {
				enemySelectedButtonUnit = b;
				enemySelectedUnit = u;
				b.setEnabled(false);
				new Exception("Level: " + enemySelectedUnit.getLevel() + " Count: "
						+ enemySelectedUnit.getCurrentSoldierCount());

			} else {
				b.setEnabled(true);
			}

		}
		if(mySelectedUnit!=null && enemySelectedUnit!=null)
		if (e.getSource() == attack) {
			try {
				int x = enemySelectedUnit.getCurrentSoldierCount();

				mySelectedUnit.attack(enemySelectedUnit);
				attack.setEnabled(false);
				getAttacked.setEnabled(true);
				Enemy.handleAttackedUnit(enemySelectedUnit);

				if (Enemy.getUnits().isEmpty()) {
					attack.setVisible(false);
					getAttacked.setVisible(false);
					allEnemiesUnits.setVisible(false);
					game.occupy(MyArmy, Enemy.getCurrentLocation());
					battleLog.setText("You have won your battle ");
					worldMap.setVisible(true);
				} else {
					int y = enemySelectedUnit.getCurrentSoldierCount();
					battleLog.setText("Enemy has lost: " + (x - y) + " units");
				}

				if (enemySelectedUnit.getCurrentSoldierCount() == 0) {
					allEnemiesUnits.remove(enemySelectedButtonUnit);
					EnemyUnits.remove(enemySelectedButtonUnit);

				}

			} catch (FriendlyFireException e1) {

				new Exception(e1.getMessage());
			}

		}

		if (e.getSource() == getAttacked) {
			try {
				int y = (int) ((Math.random() * EnemyUnits.size()));
				int x = (int) ((Math.random() * MyUnits.size()));

				mySelectedButtonUnit = MyUnits.get(x);
				mySelectedUnit = MyArmy.getUnits().get(x);
				mySelectedButtonUnit.setEnabled(false);

				enemySelectedButtonUnit = EnemyUnits.get(y);
				enemySelectedUnit = Enemy.getUnits().get(y);
				enemySelectedButtonUnit.setEnabled(false);

				getAttacked.setEnabled(false);
				attack.setEnabled(true);
				int a = mySelectedUnit.getCurrentSoldierCount();

				enemySelectedUnit.attack(mySelectedUnit);
				MyArmy.handleAttackedUnit(mySelectedUnit);
				if (MyArmy.getUnits().isEmpty()) {
					attack.setVisible(false);
					getAttacked.setVisible(false);
					allMyUnits.setVisible(false);
					battleLog.setText("You have lost your army ");
					worldMap.setVisible(true);
				} else {
					int b = mySelectedUnit.getCurrentSoldierCount();
					battleLog.setText("You have lost: " + (a - b) + " units");
				}
				if (mySelectedUnit.getCurrentSoldierCount() == 0) {
					allMyUnits.remove(mySelectedButtonUnit);
					MyUnits.remove(mySelectedButtonUnit);

				}

			} catch (FriendlyFireException e1) {
				new Exception(e1.getMessage());
			}

		}

	}

	public void autoResolve() {
		try {
			game.autoResolve(MyArmy, Enemy);
		} catch (FriendlyFireException e) {
			new Exception(e.getMessage());
		}
		/*
		 * for (BUnits b : MyUnits) { b.removeActionListener(this); } for (BUnits b :
		 * EnemyUnits) { b.removeActionListener(this); } while ((!MyUnits.isEmpty()) ||
		 * ((!EnemyUnits.isEmpty()))) {
		 * 
		 * try { int w = (int) ((Math.random() * EnemyUnits.size())); int z = (int)
		 * ((Math.random() * MyUnits.size()));
		 * 
		 * mySelectedButtonUnit = MyUnits.get(z); mySelectedUnit =
		 * MyArmy.getUnits().get(z); mySelectedButtonUnit.setEnabled(false);
		 * 
		 * enemySelectedButtonUnit = EnemyUnits.get(w); enemySelectedUnit =
		 * Enemy.getUnits().get(w); enemySelectedButtonUnit.setEnabled(false);
		 * 
		 * int x = enemySelectedUnit.getCurrentSoldierCount();
		 * mySelectedUnit.attack(enemySelectedUnit); attack.setEnabled(false);
		 * getAttacked.setEnabled(true); Enemy.handleAttackedUnit(enemySelectedUnit); if
		 * (enemySelectedUnit.getCurrentSoldierCount() == 0) {
		 * allEnemiesUnits.remove(enemySelectedButtonUnit); }
		 * 
		 * int y = enemySelectedUnit.getCurrentSoldierCount();
		 * battleLog.setText("Enemy has lost: " + (x - y) + " units");
		 * 
		 * if (MyArmy.getUnits().size() != 0) game.occupy(MyArmy,
		 * Enemy.getCurrentLocation());
		 * 
		 * } catch (FriendlyFireException e) { new Exception(e.getMessage()); }
		 * 
		 * try { int y = (int) ((Math.random() * EnemyUnits.size())); int x = (int)
		 * ((Math.random() * MyUnits.size()));
		 * 
		 * mySelectedButtonUnit = MyUnits.get(x); mySelectedUnit =
		 * MyArmy.getUnits().get(x); mySelectedButtonUnit.setEnabled(false);
		 * 
		 * enemySelectedButtonUnit = EnemyUnits.get(y); enemySelectedUnit =
		 * Enemy.getUnits().get(y); enemySelectedButtonUnit.setEnabled(false);
		 * 
		 * getAttacked.setEnabled(false); attack.setEnabled(true); int a =
		 * mySelectedUnit.getCurrentSoldierCount();
		 * 
		 * enemySelectedUnit.attack(mySelectedUnit);
		 * MyArmy.handleAttackedUnit(mySelectedUnit);
		 * 
		 * if (mySelectedUnit.getCurrentSoldierCount() == 0) {
		 * allMyUnits.remove(mySelectedButtonUnit);
		 * 
		 * }
		 * 
		 * int b = mySelectedUnit.getCurrentSoldierCount();
		 * 
		 * battleLog.setText("You have lost: " + (a - b) + " units");
		 * 
		 * } catch (FriendlyFireException e1) { new Exception(e1.getMessage()); }
		 * 
		 * repaint(); revalidate();
		 * 
		 * }
		 */
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		Game g;
		try {
			g = new Game("tonton", "Cairo");
			Army a = new Army("Cairo");
			Army b = new Army("sparta");

			Unit u = (new Archer(1, 60, 0.4, 0.5, 0.6));
			u.setParentArmy(a);
			a.getUnits().add(u);
			u = (new Infantry(3, 60, 0.6, 0.7, 0.8));
			u.setParentArmy(a);
			a.getUnits().add(u);
			u = (new Cavalry(2, 40, 0.6, 0.7, 0.75));
			u.setParentArmy(a);
			a.getUnits().add(u);
			/*
			 * a.getUnits().add(u); u = (new Infantry(3, 60, 0.6, 0.7, 0.8));
			 * u.setParentArmy(a); a.getUnits().add(u); u = (new Cavalry(2, 40, 0.6, 0.7,
			 * 0.75)); u.setParentArmy(a); a.getUnits().add(u); a.getUnits().add(u); u =
			 * (new Infantry(3, 60, 0.6, 0.7, 0.8)); u.setParentArmy(a);
			 * a.getUnits().add(u); u = (new Cavalry(2, 40, 0.6, 0.7, 0.75));
			 * u.setParentArmy(a); a.getUnits().add(u);
			 */

			// b.getUnits().add(u);
			u = (new Infantry(3, 60, 0.6, 0.7, 0.8));
			u.setParentArmy(b);
			b.getUnits().add(u);
			u = (new Cavalry(2, 40, 0.6, 0.7, 0.75));
			u.setParentArmy(b);
			b.getUnits().add(u);
			// b.getUnits().add(u);
			
			  u = (new Infantry(3, 60, 0.6, 0.7, 0.8)); u.setParentArmy(b);
			  b.getUnits().add(u); u = (new Cavalry(2, 40, 0.6, 0.7, 0.75));
			  u.setParentArmy(b); b.getUnits().add(u); b.getUnits().add(u); u = (new
			  Infantry(3, 60, 0.6, 0.7, 0.8)); u.setParentArmy(b); b.getUnits().add(u); u =
			  (new Cavalry(2, 40, 0.6, 0.7, 0.75)); u.setParentArmy(b);
			  b.getUnits().add(u);
			 
			new BattleView(a, b, g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static Object getGame() {
		// TODO Auto-generated method stub
		return null;
	}
}
