package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import engine.City;
import engine.Game;
import engine.Player;
import exceptions.FriendlyCityException;
import exceptions.TargetNotReachedException;
import units.Archer;
import units.Army;
import units.Infantry;
import units.Status;
import units.Unit;

public class WorldMap extends SubFrame implements ActionListener, MouseListener {
	private JLabel map = new JLabel();
	private ArrayList<BArmy> B = new ArrayList<BArmy>();
	private int Bindex;
	private JLabel ButtonCairo = new JLabel();
	private JLabel ButtonRome = new JLabel();
	private JLabel ButtonSparta = new JLabel();
	private JPanel PC = new JPanel();
	private JPanel PR = new JPanel();
	private JPanel PS = new JPanel();
	private JPanel PM = new JPanel();
	private JPanel Pl = new JPanel();
	private JButton LaySeige = new JButton();
	private JButton Attack = new JButton();
	private JButton ArmyCairo = new JButton();
	private JButton ArmyRome = new JButton();
	private JButton ArmySparta = new JButton();
	private Game game;
	private Army a;
	private int layOrAttack;

	public CityFrame getCityFrame() {
		return cityFrame;
	}

	public void setCityFrame(CityFrame cityFrame) {
		
		this.cityFrame = cityFrame;
	}

	private CityFrame cityFrame;

	WorldMap(Game game) {
		super(game);
		
		
		this.game = game;

		LaySeige.setText("LaySeige!!");
		LaySeige.setFont(new Font("Viner Hand ITC", Font.PLAIN, 35));
		LaySeige.setForeground(Color.white);
		// LaySeige.setBounds(0, 809, 700, 55);
		LaySeige.addActionListener(this);
		LaySeige.setBorder(null);
		LaySeige.setForeground(Color.ORANGE);
		LaySeige.setBackground(Color.black);
		LaySeige.setVisible(true);

		Attack.setText("Attack!!");
		Attack.setFont(new Font("Viner Hand ITC", Font.PLAIN, 35));
		Attack.setForeground(Color.white);
		// Attack.setBounds(0, 809, 700, 55);
		Attack.addActionListener(this);
		Attack.setBorder(null);
		Attack.setForeground(Color.ORANGE);
		Attack.setBackground(Color.black);
		Attack.setVisible(true);

		Pl = new JPanel();
		Pl.setLayout(new GridLayout());
		Pl.setBounds(0, 809, 700, 55);
		Pl.setVisible(false);
		Pl.setOpaque(false);

		PM = new JPanel();
		PM.setLayout(new GridLayout());
		PM.setBounds(690, 400, 290, 140);
		PM.setVisible(true);
		PM.setOpaque(false);

		PC = new JPanel();
		PC.setLayout(new GridLayout());
		PC.setBounds(930, 30, 130, 340);
		PC.setVisible(true);
		PC.setOpaque(false);

		PR = new JPanel();
		PR.setLayout(new GridLayout());
		PR.setBounds(170, 750, 575, 100);
		PR.setVisible(true);
		PR.setOpaque(false);

		PS = new JPanel();
		PS.setLayout(new GridLayout());
		PS.setBounds(1130, 350, 355, 140);
		PS.setVisible(true);
		PS.setOpaque(false);
		// for (Army aa : this.game.getPlayer().getControlledArmies()) {
		// System.out.println(aa.getCurrentLocation());
		// if (aa.getCurrentLocation().equalsIgnoreCase(""))
		// System.out.println("noooo");
		// }
//		for (City c : this.getGame().getAvailableCities()) {
//			if (c.isUnderSiege()) {
//				if (c.getTurnsUnderSiege() == 3) {
//					System.out.println(this.game.getPlayer().getControlledArmies().size());
//					// System.out.println("noooooo");
//					System.out.println(Bindex);
//					new BattleView(this.a, c.getDefendingArmy(), this.game);
//					this.dispose();
//
//				}
//			}
//		}

		/*
		 * String s = "";
		 * if(!this.getGame().getPlayer().getControlledArmies().isEmpty()) for (Army a :
		 * this.getGame().getPlayer().getControlledArmies()) { //
		 * if(a.getCurrentStatus()==Status.IDLE) // s+="Idle :"+"\n" // an so on for
		 * (Unit b : a.getUnits()) { if (b instanceof Archer) { s += "Type:Archer" +
		 * "\n" + "Level:" + b.getLevel() + "\n" + "Current Soldier Count:" +
		 * b.getCurrentSoldierCount() + "\n" + "Max Soldier Count:" +
		 * b.getMaxSoldierCount(); } else if (b instanceof Infantry) { s +=
		 * "Type:Infantry" + "\n" + "Level:" + b.getLevel() + "\n" +
		 * "Current Soldier Count:" + b.getCurrentSoldierCount() + "\n" +
		 * "Max Soldier Count:" + b.getMaxSoldierCount(); } else { s += "Type:Cavalry" +
		 * "\n" + "Level:" + b.getLevel() + "\n" + "Current Soldier Count:" +
		 * b.getCurrentSoldierCount() + "\n" + "Max Soldier Count:" +
		 * b.getMaxSoldierCount(); } }
		 * 
		 * } new ArmyInfo(s);
		 */

		/////////////////////////////////////////////////////////

		for (int i = 0; i < this.getGame().getPlayer().getControlledArmies().size(); i++) {
			Army v = this.getGame().getPlayer().getControlledArmies().get(i);
			if (v.getCurrentStatus() == Status.MARCHING) {
				BArmy b = new BArmy();
				b.setToolTipText(v.getDistancetoTarget() + " Steps To: " + v.getTarget());
				b.setVisible(true);
				b.setI(i);
				b.addActionListener(this);
				this.B.add(b);
				PM.add(b);

			} else if (v.getCurrentStatus() == Status.BESIEGING || v.getCurrentStatus() == Status.IDLE) {
				BArmy b = new BArmy();
				b.setVisible(true);
				int x = 0;
				if (v.getCurrentLocation().equalsIgnoreCase("Cairo")) {
					for (City ci : this.getGame().getAvailableCities()) {
						if (ci.getName().equalsIgnoreCase("Cairo"))
							x = ci.getTurnsUnderSiege();
					}
					b.setToolTipText("" + x);
					b.addActionListener(this);
					this.B.add(b);
					PC.add(b);
				} else if (v.getCurrentLocation().equalsIgnoreCase("Rome")) {
					for (City ci : this.getGame().getAvailableCities()) {
						if (ci.getName().equalsIgnoreCase("Rome"))
							x = ci.getTurnsUnderSiege();
					}
					b.setToolTipText("" + x);
					b.addActionListener(this);
					this.B.add(b);
					PR.add(b);
				} else if (v.getCurrentLocation().equalsIgnoreCase("Sparta")) {
					for (City ci : this.getGame().getAvailableCities()) {
						if (ci.getName().equalsIgnoreCase("Sparta"))
							x = ci.getTurnsUnderSiege();
					}
					b.setToolTipText("" + x);
					b.addActionListener(this);
					this.B.add(b);
					PS.add(b);
				}
			}
		}

		for (City c : game.getPlayer().getControlledCities()) {
			if (c.getName().equalsIgnoreCase("cairo")) {
				ImageIcon icon = new ImageIcon("Location.png");
				ArmyCairo.setIcon(icon);
				ArmyCairo.setBounds(1080, 190, 100, 100);
				ArmyCairo.addMouseListener(this);
				ArmyCairo.setBorder(null);
				ArmyCairo.setContentAreaFilled(false);

			} else if (c.getName().equalsIgnoreCase("rome")) {
				ImageIcon icon = new ImageIcon("Location.png");
				ArmyRome.setIcon(icon);
				ArmyRome.setBounds(280, 400, 100, 100);
				ArmyRome.addMouseListener(this);
				ArmyRome.setBorder(null);
				ArmyRome.setContentAreaFilled(false);
			} else {
				ImageIcon icon = new ImageIcon("Location.png");
				ArmySparta.setIcon(icon);
				ArmySparta.setBounds(1160, 500, 100, 100);
				ArmySparta.addMouseListener(this);
				ArmySparta.setBorder(null);
				ArmySparta.setContentAreaFilled(false);
			}
			if (c.isUnderSiege()) {
				if (c.getName().equalsIgnoreCase("Cairo")) {
					JButton TurnsU = new JButton();
					ImageIcon icon = new ImageIcon("Location.png");
					TurnsU.setIcon(icon);
					TurnsU.setBounds(1080, 200, 100, 100);
					TurnsU.addMouseListener(this);
					TurnsU.setBorder(null);
					TurnsU.setToolTipText("Defending Army");
					TurnsU.setContentAreaFilled(false);
				} else if (c.getName().equalsIgnoreCase("Rome")) {
					JButton TurnsU = new JButton();
					ImageIcon icon = new ImageIcon("Location.png");
					TurnsU.setIcon(icon);
					TurnsU.setBounds(280, 450, 100, 100);
					TurnsU.addMouseListener(this);
					TurnsU.setBorder(null);
					TurnsU.setToolTipText("Defending Army");
					TurnsU.setContentAreaFilled(false);
				} else if (c.getName().equalsIgnoreCase("Sparta")) {
					JButton TurnsU = new JButton();
					ImageIcon icon = new ImageIcon("Location.png");
					TurnsU.setIcon(icon);
					TurnsU.setBounds(1160, 550, 100, 100);
					TurnsU.addMouseListener(this);
					TurnsU.setBorder(null);
					TurnsU.setToolTipText("Defending Army");
					TurnsU.setContentAreaFilled(false);
				}
			}

		}

		ImageIcon icon = new ImageIcon("EpicMap1.png");
		map.setIcon(icon);
		map.setBounds(0, 0, 1560, 900);

		ButtonCairo.setText("Cairo");
		ButtonCairo.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
		ButtonCairo.setForeground(Color.white);
		ButtonCairo.setBounds(1060, -50, 400, 400);
		ButtonCairo.addMouseListener(this);
		ButtonCairo.setBackground(Color.black);
		ButtonCairo.setOpaque(false);
		ButtonCairo.setBorder(null);

		ButtonSparta.setText("Sparta");
		ButtonSparta.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
		ButtonSparta.setForeground(Color.white);
		ButtonSparta.setBounds(1160, 500, 450, 320);
		ButtonSparta.addMouseListener(this);
		ButtonSparta.setBackground(Color.black);
		ButtonSparta.setOpaque(false);
		ButtonSparta.setBorder(null);

		ButtonRome.setText("Rome");
		ButtonRome.setFont(new Font("Viner Hand ITC", Font.BOLD, 50));
		ButtonRome.setForeground(Color.white);
		ButtonRome.setBounds(280, 400, 550, 370);
		ButtonRome.addMouseListener(this);
		ButtonRome.setBackground(Color.black);
		ButtonRome.setOpaque(false);
		ButtonRome.setBorder(null);

		Pl.add(LaySeige);
		Pl.add(Attack);
		this.add(Pl);
		this.add(PC);
		this.add(PM);
		this.add(PS);
		this.add(PR);

		this.add(ArmyCairo);
		this.add(ArmyRome);
		this.add(ArmySparta);
		this.add(ButtonCairo);
		this.add(ButtonSparta);
		this.add(ButtonRome);
		this.add(map);

		this.revalidate();
		this.repaint();
	}

	public JLabel getButtonCairo() {
		return ButtonCairo;
	}

	public JLabel getButtonRome() {
		return ButtonRome;
	}

	public JLabel getButtonSparta() {
		return ButtonSparta;
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == ButtonCairo) {
			for (City c : game.getPlayer().getControlledCities()) {
				if (c.getName().equalsIgnoreCase("Cairo")) {

					new CityFrame(game, c);
					this.setVisible(false);
				}
			}
		}
		if (e.getSource() == ButtonRome) {
			for (City c : game.getPlayer().getControlledCities()) {
				if (c.getName().equalsIgnoreCase("Rome")) {
					new CityFrame(game, c);
					this.setVisible(false);
				}
			}
		}
		if (e.getSource() == ButtonSparta) {
			for (City c : game.getPlayer().getControlledCities()) {
				if (c.getName().equalsIgnoreCase("Sparta")) {

					new CityFrame(game, c);
					this.setVisible(false);
				}
			}
		}

		if (e.getSource() == ArmyCairo) {
			for (City c : game.getPlayer().getControlledCities()) {
				if (c.getName().equalsIgnoreCase("cairo")) {
					String s = "";
					for (Unit u : c.getDefendingArmy().getUnits()) {

						if (u instanceof Archer) {
							s += "Type:Archer" + "\n" + "Level:" + u.getLevel() + "\n" + "Current Soldier Count:"
									+ u.getCurrentSoldierCount() + "\n" + "Max Soldier Count:" + u.getMaxSoldierCount();
						} else if (u instanceof Infantry) {
							s += "Type:Infantry" + "\n" + "Level:" + u.getLevel() + "\n" + "Current Soldier Count:"
									+ u.getCurrentSoldierCount() + "\n" + "Max Soldier Count:" + u.getMaxSoldierCount();
						} else {
							s += "Type:Cavalry" + "\n" + "Level:" + u.getLevel() + "\n" + "Current Soldier Count:"
									+ u.getCurrentSoldierCount() + "\n" + "Max Soldier Count:" + u.getMaxSoldierCount();
						}
					}
					new ArmyInfo(s);
				}
			}
		}

		if (e.getSource() == ArmyRome) {
			for (City c : game.getPlayer().getControlledCities()) {
				if (c.getName().equalsIgnoreCase("rome")) {
					String s = "";
					for (Unit u : c.getDefendingArmy().getUnits()) {

						if (u instanceof Archer) {
							s += "Type:Archer" + "\n" + "Level:" + u.getLevel() + "\n" + "Current Soldier Count:"
									+ u.getCurrentSoldierCount() + "\n" + "Max Soldier Count:" + u.getMaxSoldierCount();
						} else if (u instanceof Infantry) {
							s += "Type:Infantry" + "\n" + "Level:" + u.getLevel() + "\n" + "Current Soldier Count:"
									+ u.getCurrentSoldierCount() + "\n" + "Max Soldier Count:" + u.getMaxSoldierCount();
						} else {
							s += "Type:Cavalry" + "\n" + "Level:" + u.getLevel() + "\n" + "Current Soldier Count:"
									+ u.getCurrentSoldierCount() + "\n" + "Max Soldier Count:" + u.getMaxSoldierCount();
						}
					}
					new ArmyInfo(s);
				}
			}
		}

		if (e.getSource() == ArmySparta) {
			for (City c : game.getPlayer().getControlledCities()) {
				if (c.getName().equalsIgnoreCase("sparta")) {
					String s = "";
					for (Unit u : c.getDefendingArmy().getUnits()) {
						if (u instanceof Archer) {
							s += "Type:Archer" + "\n" + "Level:" + u.getLevel() + "\n" + "Current Soldier Count:"
									+ u.getCurrentSoldierCount() + "\n" + "Max Soldier Count:" + u.getMaxSoldierCount();
						} else if (u instanceof Infantry) {
							s += "Type:Infantry" + "\n" + "Level:" + u.getLevel() + "\n" + "Current Soldier Count:"
									+ u.getCurrentSoldierCount() + "\n" + "Max Soldier Count:" + u.getMaxSoldierCount();
						} else {
							s += "Type:Cavalry" + "\n" + "Level:" + u.getLevel() + "\n" + "Current Soldier Count:"
									+ u.getCurrentSoldierCount() + "\n" + "Max Soldier Count:" + u.getMaxSoldierCount();
						}
					}
					new ArmyInfo(s);
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == ButtonCairo) {

		}
		if (e.getSource() == ButtonSparta) {

		}
		if (e.getSource() == ButtonRome) {

		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == ButtonCairo) {

		}
		if (e.getSource() == ButtonRome) {

		}
		if (e.getSource() == ButtonSparta) {

		}
		if (e.getSource() == map) {

		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < this.getGame().getPlayer().getControlledArmies().size(); i++) {
			if (e.getSource() == B.get(i)) {
				layOrAttack = i;
				Pl.setVisible(true);

				String s = "";

				Army ar = this.getGame().getPlayer().getControlledArmies().get(i);
				for (Unit b : ar.getUnits()) {
					if (b instanceof Archer) {
						s += "Type:Archer" + "\n" + "Level:" + b.getLevel() + "\n" + "Current Soldier Count:"
								+ b.getCurrentSoldierCount() + "\n" + "Max Soldier Count:" + b.getMaxSoldierCount();
					} else if (b instanceof Infantry) {
						s += "Type:Infantry" + "\n" + "Level:" + b.getLevel() + "\n" + "Current Soldier Count:"
								+ b.getCurrentSoldierCount() + "\n" + "Max Soldier Count:" + b.getMaxSoldierCount();
					} else {
						s += "Type:Cavalry" + "\n" + "Level:" + b.getLevel() + "\n" + "Current Soldier Count:"
								+ b.getCurrentSoldierCount() + "\n" + "Max Soldier Count:" + b.getMaxSoldierCount();
					}
				}

				new ArmyInfo(s);
			} else {
				Pl.setVisible(false);
			}

		}

		if (e.getSource() == LaySeige) {

			try {
				for (City y : this.getGame().getAvailableCities()) {
					// if (!this.getGame().getPlayer().getControlledCities().contains(y)) {
					// for (Army z : this.getGame().getPlayer().getControlledArmies()) {
					Army z = this.getGame().getPlayer().getControlledArmies().get(layOrAttack);
					if(y.getName().equalsIgnoreCase(z.getCurrentLocation())) {
					
					this.getGame().getPlayer().laySiege(z, y);
					B.get(layOrAttack).setToolTipText(""+y.getTurnsUnderSiege());
					}
					// }
				}
			} catch (TargetNotReachedException | FriendlyCityException e1) {
				// TODO Auto-generated catch block
				new Exception(e1.getMessage());

			}

		}

		if (e.getSource() == Attack) {
			for (City y : this.getGame().getAvailableCities()) {
				if (!this.getGame().getPlayer().getControlledCities().contains(y)) {
					// for (Army z : this.getGame().getPlayer().getControlledArmies()) {
					System.out.println(layOrAttack);
					Army z = this.getGame().getPlayer().getControlledArmies().get(layOrAttack);
					if (z.getCurrentLocation().equalsIgnoreCase(y.getName())) {

						new BattleView(z, y.getDefendingArmy(), this.getGame());

						this.getGame().getPlayer().getControlledArmies().remove(z);

						this.dispose();

					}

				}
			}
		}

//		if (!B.isEmpty())
//			for (int i = 0; i < B.size(); i++) {
//				if (e.getSource() == B.get(i)) {
//					LaySeige.setVisible(true);
//					Bindex = i;
//				}
//			}
//
	}

	/*
	 * Army a = this.getGame().getPlayer().getControlledArmies().get(Bindex);
	 * this.a=a; for (City c : this.getGame().getAvailableCities()) { if
	 * (a.getCurrentLocation().equalsIgnoreCase(c.getName()) ||
	 * a.getTarget().equalsIgnoreCase(c.getName()))
	 * 
	 * //System.out.println(1); this.getGame().getPlayer().laySiege(a, c);
	 * 
	 * if (c.getName().equalsIgnoreCase("Cairo")) { JButton TurnsU = new JButton();
	 * ImageIcon icon = new ImageIcon("Location.png"); TurnsU.setIcon(icon);
	 * TurnsU.setBounds(1080, 200, 100, 100); TurnsU.addMouseListener(this);
	 * TurnsU.setBorder(null); TurnsU.setContentAreaFilled(false); } else if
	 * (c.getName().equalsIgnoreCase("Rome")) { JButton TurnsU = new JButton();
	 * ImageIcon icon = new ImageIcon("Location.png"); TurnsU.setIcon(icon);
	 * TurnsU.setBounds(280, 450, 100, 100); TurnsU.addMouseListener(this);
	 * TurnsU.setBorder(null); TurnsU.setContentAreaFilled(false); } else if
	 * (c.getName().equalsIgnoreCase("Sparta")) { JButton TurnsU = new JButton();
	 * ImageIcon icon = new ImageIcon("Location.png"); TurnsU.setIcon(icon);
	 * TurnsU.setBounds(1160, 550, 100, 100); TurnsU.addMouseListener(this);
	 * TurnsU.setBorder(null); TurnsU.setContentAreaFilled(false); }
	 */
	/*
	 * try {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * } catch (TargetNotReachedException | FriendlyCityException e1) { new
	 * Exception(e1.getMessage()); }
	 * 
	 * } } /*else { LaySeige.setVisible(false); }
	 */

	public static void main(String[] args) {
		try {
			Game g = new Game("tony", "cairo");
			new WorldMap(g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
