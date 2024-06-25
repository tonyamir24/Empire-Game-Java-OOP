package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import buildings.ArcheryRange;
import buildings.Barracks;
import buildings.Building;
import buildings.EconomicBuilding;
import buildings.Farm;
import buildings.Market;
import buildings.MilitaryBuilding;
import buildings.Stable;
import engine.City;
import engine.Game;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxCapacityException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import units.Archer;
import units.Army;
import units.Cavalry;
import units.Infantry;
import units.Status;
import units.Unit;

public class CityFrame extends SubFrame implements ActionListener, MouseListener {

	private ArrayList<BUnits> Units = new ArrayList<BUnits>();

	private ArrayList<Relocate> relocateD = new ArrayList<Relocate>();

	private ArrayList<Intiate> intiateD = new ArrayList<Intiate>();

	private ArrayList<Relocate> relocateC = new ArrayList<Relocate>();

	private ArrayList<BArmy> ArmyList = new ArrayList<BArmy>();

	private int j = 0;
	private int q = 0;
	private JButton Map = new JButton();
	private JButton Build = new JButton();
	private JButton BuildingArcheryR = new JButton();
	private JButton BuildingStable = new JButton();
	private JButton BuildingBarracks = new JButton();
	private JPanel buildPanel;
	private JPanel TopPanel = new JPanel();
	private JLabel cityMap;
	private JButton BuildingMarket = new JButton();
	private JButton BuildingFarm = new JButton();
//	private WorldMap map;
	private JButton BuildingArcheryR2 = new JButton();
	private JButton BuildingStable2 = new JButton();
	private JButton BuildingBarracks2 = new JButton();
	private JButton BuildingMarket2 = new JButton();
	private JButton BuildingFarm2 = new JButton();
	private JButton Controlled = new JButton();
	private JButton Target = new JButton();
	private JButton Target1 = new JButton();
	private JLabel LabelP = new JLabel();
	private JLabel LabelP1 = new JLabel();
	private JLabel LabelP2 = new JLabel();
	private JLabel LabelP3 = new JLabel();
	private JLabel LabelP4 = new JLabel();
	private JPanel Bpanel;
	private JPanel UnitPanel = new JPanel();
	private JPanel UnitPanel1 = new JPanel();
	private JButton upgrade = new JButton();
	private JButton recruit = new JButton();
	private JPanel Bpanel1;
	private JButton upgrade1 = new JButton();
	private JButton recruit1 = new JButton();
	private JPanel Bpanel2;
	private JButton upgrade2 = new JButton();
	private JButton recruit2 = new JButton();
	private JPanel Bpanel3;
	private JButton upgrade3 = new JButton();
	private JPanel Bpanel4;
	private JButton upgrade4 = new JButton();
	private JButton Relocate = new JButton();
	private JButton Initiate = new JButton();
	private JButton Relocate1 = new JButton();

	public CityFrame(Game game, City city) {
		super(game, city);
		
		if(game.getAvailableCities().size()==game.getPlayer().getControlledCities().size()) {
			this.dispose();
			new Winner();
		}

		
		
		
		
		this.add(Map);
		Bpanel = new JPanel();
		Bpanel.setBounds(0, 250, 150, 300);

		Bpanel.setVisible(false);
		Bpanel.setOpaque(true);
		Bpanel.setLayout(new GridLayout(3, 1, 0, 0));
		this.add(Bpanel);

		TopPanel.setBounds(500, 0, 500, 70);
		TopPanel.setLayout(new GridLayout(1, 2, 0, 0));
		TopPanel.setBackground(Color.black);
		TopPanel.setVisible(false);
		this.add(TopPanel);

		LabelP.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
		LabelP.setBounds(527, 175, 700, 150);
		LabelP.setHorizontalTextPosition(JLabel.CENTER);
		LabelP.setOpaque(true);
		LabelP.setVisible(true);
		LabelP.setForeground(Color.white);
		LabelP.setBackground(Color.black);
		Bpanel.add(LabelP);

		upgrade.setText("Upgrade");
		upgrade.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		upgrade.setForeground(Color.white);
		upgrade.setBackground(Color.black);
		upgrade.addActionListener(this);
		upgrade.setVisible(true);
		Bpanel.add(upgrade);

		recruit.setText("Recruit");
		recruit.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		recruit.setForeground(Color.white);
		recruit.setBackground(Color.black);
		recruit.addActionListener(this);
		upgrade.setVisible(true);
		Bpanel.add(recruit);

		Bpanel1 = new JPanel();
		Bpanel1.setBounds(0, 250, 150, 300);

		Bpanel1.setVisible(false);
		Bpanel1.setOpaque(true);
		Bpanel1.setLayout(new GridLayout(3, 1, 0, 0));
		this.add(Bpanel1);

		LabelP1.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
		LabelP1.setBounds(527, 175, 700, 150);
		LabelP1.setHorizontalTextPosition(JLabel.CENTER);
		LabelP1.setOpaque(true);
		LabelP1.setVisible(true);
		LabelP1.setForeground(Color.white);
		LabelP1.setBackground(Color.black);
		Bpanel1.add(LabelP1);

		upgrade1.setText("Upgrade");
		upgrade1.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		upgrade1.setForeground(Color.white);
		upgrade1.setBackground(Color.black);
		upgrade1.addActionListener(this);
		upgrade1.setVisible(true);
		Bpanel1.add(upgrade1);

		recruit1.setText("Recruit");
		recruit1.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		recruit1.setForeground(Color.white);
		recruit1.setBackground(Color.black);
		recruit1.addActionListener(this);
		upgrade1.setVisible(true);
		Bpanel1.add(recruit1);

		Bpanel2 = new JPanel();
		Bpanel2.setBounds(0, 250, 150, 300);

		Bpanel2.setVisible(false);
		Bpanel2.setOpaque(true);
		Bpanel2.setLayout(new GridLayout(3, 1, 0, 0));
		this.add(Bpanel2);

		LabelP2.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
		LabelP2.setBounds(527, 175, 700, 150);
		LabelP2.setHorizontalTextPosition(JLabel.CENTER);
		LabelP2.setOpaque(true);
		LabelP2.setVisible(true);
		LabelP2.setForeground(Color.white);
		LabelP2.setBackground(Color.black);
		Bpanel2.add(LabelP2);

		upgrade2.setText("Upgrade");
		upgrade2.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		upgrade2.setForeground(Color.white);
		upgrade2.setBackground(Color.black);
		upgrade2.addActionListener(this);
		upgrade2.setVisible(true);
		Bpanel2.add(upgrade2);

		recruit2.setText("Recruit");
		recruit2.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		recruit2.setForeground(Color.white);
		recruit2.setBackground(Color.black);
		recruit2.addActionListener(this);
		upgrade2.setVisible(true);
		Bpanel2.add(recruit2);

		Bpanel3 = new JPanel();
		Bpanel3.setBounds(0, 250, 150, 300);

		Bpanel3.setVisible(false);
		Bpanel3.setOpaque(true);
		Bpanel3.setLayout(new GridLayout(2, 1, 0, 0));
		this.add(Bpanel3);

		LabelP3.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
		LabelP3.setBounds(527, 175, 700, 150);
		LabelP3.setHorizontalTextPosition(JLabel.CENTER);
		LabelP3.setOpaque(true);
		LabelP3.setVisible(true);
		LabelP3.setForeground(Color.white);
		LabelP3.setBackground(Color.black);
		Bpanel3.add(LabelP3);

		upgrade3.setText("Upgrade");
		upgrade3.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		upgrade3.setForeground(Color.white);
		upgrade3.setBackground(Color.black);
		upgrade3.addActionListener(this);
		upgrade3.setVisible(true);
		Bpanel3.add(upgrade3);

		Bpanel4 = new JPanel();
		Bpanel4.setBounds(0, 250, 150, 300);

		Bpanel4.setVisible(false);
		Bpanel4.setOpaque(true);
		Bpanel4.setLayout(new GridLayout(2, 1, 0, 0));
		this.add(Bpanel4);

		LabelP4.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
		LabelP4.setBounds(527, 175, 700, 150);
		LabelP4.setHorizontalTextPosition(JLabel.CENTER);
		LabelP4.setOpaque(true);
		LabelP4.setVisible(true);
		LabelP4.setForeground(Color.white);
		LabelP4.setBackground(Color.black);
		Bpanel4.add(LabelP4);

		upgrade4.setText("Upgrade");
		upgrade4.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		upgrade4.setForeground(Color.white);
		upgrade4.setBackground(Color.black);
		upgrade4.addActionListener(this);
		upgrade4.setVisible(true);
		Bpanel4.add(upgrade4);

		Target.addActionListener(this);
		Target.setFont(new Font("Viner Hand ITC", Font.PLAIN, 25));
		Target.setForeground(Color.green);
		Target.setBackground(Color.black);
		Target.setVisible(false);

		Target1.addActionListener(this);
		Target1.setFont(new Font("Viner Hand ITC", Font.PLAIN, 25));
		Target1.setForeground(Color.green);
		Target1.setBackground(Color.black);
		Target1.setVisible(false);

		ImageIcon BuildingAI = new ImageIcon("Archery Range.png");
		BuildingArcheryR2.setIcon(BuildingAI);
		BuildingArcheryR2.setBounds(595, 80, 520, 306);
		BuildingArcheryR2.setContentAreaFilled(false);
		BuildingArcheryR2.setBorder(null);
		BuildingArcheryR2.setVisible(false);
		BuildingArcheryR2.addActionListener(this);

		ImageIcon BuildingS = new ImageIcon("Stable.png");
		BuildingStable2.setIcon(BuildingS);
		BuildingStable2.setBounds(600, 570, 520, 306);
		BuildingStable2.setContentAreaFilled(false);
		BuildingStable2.setBorder(null);
		BuildingStable2.setVisible(false);
		BuildingStable2.addActionListener(this);

		ImageIcon BuildingB = new ImageIcon("Barracks.png");
		BuildingBarracks2.setIcon(BuildingB);
		BuildingBarracks2.setBounds(690, 180, 520, 500);
		BuildingBarracks2.setContentAreaFilled(false);
		BuildingBarracks2.setBorder(null);
		BuildingBarracks2.setVisible(false);
		BuildingBarracks2.addActionListener(this);

		ImageIcon BuildingM = new ImageIcon("Market.png");
		BuildingMarket2.setIcon(BuildingM);
		BuildingMarket2.setBounds(1080, 160, 520, 500);
		BuildingMarket2.setContentAreaFilled(false);
		BuildingMarket2.setBorder(null);
		BuildingMarket2.setVisible(false);
		BuildingMarket2.addActionListener(this);

		ImageIcon BuildingF = new ImageIcon("Farm.png");
		BuildingFarm2.setIcon(BuildingF);
		BuildingFarm2.setBounds(1000, 0, 520, 400);
		BuildingFarm2.setContentAreaFilled(false);
		BuildingFarm2.setBorder(null);
		BuildingFarm2.setVisible(false);
		BuildingFarm2.addActionListener(this);
		// Map.setText("Map");
		Map.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		Map.setForeground(Color.white);
		Map.setBounds(1460, 40, 80, 80);
		Map.setToolTipText("Map");
		ImageIcon mapIcon = new ImageIcon("map button.png");
		Map.setIcon(mapIcon);
		Map.addMouseListener(this);
		// Build.setText("Build");
		Build.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		Build.setForeground(Color.white);
		Build.setBounds(0, 785, 80, 80);
		Build.setBackground(Color.black);
		Build.setToolTipText("Build");
		ImageIcon buildIcon = new ImageIcon("build button.png");
		Build.setIcon(buildIcon);
		Build.addActionListener(this);
		buildPanel = new JPanel();
		buildPanel.setBounds(0, 285, 150, 500);
		this.add(buildPanel);
		buildPanel.setVisible(false);

		buildPanel.setLayout(new GridLayout(5, 1, 0, 0));

		UnitPanel = new JPanel();
		UnitPanel.setLayout(new GridLayout());
		UnitPanel.setBounds(220, 130, 415, 670);
		UnitPanel.setVisible(true);
		UnitPanel.setOpaque(false);

		UnitPanel1 = new JPanel();
		UnitPanel1.setLayout(new GridLayout());
		UnitPanel1.setBounds(1130, 520, 407, 344);
		UnitPanel1.setVisible(true);
		UnitPanel1.setOpaque(false);

		BuildingArcheryR.setText("Archery " + "\n " + "Range");
		BuildingArcheryR.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
		BuildingArcheryR.setForeground(Color.white);
		BuildingArcheryR.setBackground(Color.black);
		BuildingArcheryR.addActionListener(this);
		BuildingStable.setText("Stable");
		BuildingStable.setFont(new Font("Viner Hand ITC", Font.BOLD, 20));
		BuildingStable.setForeground(Color.white);
		BuildingStable.setBackground(Color.black);
		BuildingStable.addActionListener(this);

		BuildingBarracks.setText("Barracks");
		BuildingBarracks.setFont(new Font("Viner Hand ITC", Font.BOLD, 25));
		BuildingBarracks.setForeground(Color.white);
		BuildingBarracks.setBackground(Color.black);
		BuildingBarracks.addActionListener(this);

		BuildingMarket.setText("Market");
		BuildingMarket.setFont(new Font("Viner Hand ITC", Font.BOLD, 25));
		BuildingMarket.setForeground(Color.white);
		BuildingMarket.setBackground(Color.black);
		BuildingMarket.addActionListener(this);

		BuildingFarm.setText("Farm");
		BuildingFarm.setFont(new Font("Viner Hand ITC", Font.BOLD, 25));
		BuildingFarm.setForeground(Color.white);
		BuildingFarm.setBackground(Color.black);
		BuildingFarm.addActionListener(this);
		///////////////////////////////////////////////////////////////////////////////

		this.add(Controlled);
		this.add(UnitPanel);
		this.add(UnitPanel1);
		this.add(BuildingMarket2);
		this.add(BuildingBarracks2);
		this.add(BuildingArcheryR2);
		this.add(BuildingStable2);
		this.add(BuildingFarm2);

		buildPanel.add(BuildingArcheryR);
		buildPanel.add(BuildingStable);
		buildPanel.add(BuildingBarracks);
		buildPanel.add(BuildingMarket);
		buildPanel.add(BuildingFarm);
		this.add(Build);

		// this.add(BuildingArcheryR);
		// this.add(BuildingBarracks);
		// this.add(BuildingStable);

		ImageIcon ControlledV = new ImageIcon("attack button.png");
		Controlled.setIcon(ControlledV);
		Controlled.setBounds(1467, 215, 72, 92);
		Controlled.setVisible(true);
		Controlled.addActionListener(this);
		Controlled.setToolTipText("ControlledArmies");
		Controlled.setEnabled(true);

		cityMap = new JLabel();
		ImageIcon icon;
		if (city.getName().equalsIgnoreCase("cairo"))
			icon = new ImageIcon("Cairo1.png");
		else if (city.getName().equalsIgnoreCase("sparta"))
			icon = new ImageIcon("Sparta1.png");
		else
			icon = new ImageIcon("Rome1.png");

		cityMap.setIcon(icon);

		cityMap.setBounds(0, -66, 1650, 1000);
		cityMap.addMouseListener(this);

		this.add(cityMap);

		this.getEnd().addActionListener(this);
		
		for (City c : this.getGame().getPlayer().getControlledCities()) {
			if(c.getName().equalsIgnoreCase(city.getName()))
			for (MilitaryBuilding b : c.getMilitaryBuildings()) {
				if (b instanceof ArcheryRange) {
					BuildingArcheryR2.setVisible(true);
					BuildingArcheryR.setEnabled(false);
				} else if (b instanceof Barracks) {
					BuildingBarracks2.setVisible(true);
					BuildingBarracks.setEnabled(false);
				} else {
					BuildingStable2.setVisible(true);
					BuildingStable.setEnabled(false);
				}
			}
			for (EconomicBuilding b : c.getEconomicalBuildings()) {
				if(c.getName().equalsIgnoreCase(city.getName()))
				if (b instanceof Market) {
					BuildingMarket2.setVisible(true);
					BuildingMarket.setEnabled(false);
				} else {
					BuildingFarm2.setVisible(true);
					BuildingFarm.setEnabled(false);
				}
			}
			for (Unit u : c.getDefendingArmy().getUnits()) {
				if (u instanceof Archer) {
					BUnits b = new BUnits("Archer");
					b.setToolTipText("Archer" + u.getLevel());
					Relocate r = new Relocate();
					Intiate i = new Intiate();
					relocateD.add(r);
					intiateD.add(i);
					i.addActionListener(this);
					r.addActionListener(this);
					b.addActionListener(this);
					this.add(r);
					this.add(i);
					UnitPanel.add(b);
					Units.add(b);
				} else if (u instanceof Cavalry) {
					BUnits b = new BUnits("Cavalry");
					b.setToolTipText("Cavalry" + u.getLevel());
					Relocate r = new Relocate();
					Intiate i = new Intiate();
					relocateD.add(r);
					intiateD.add(i);
					i.addActionListener(this);
					r.addActionListener(this);
					b.addActionListener(this);
					this.add(r);
					this.add(i);
					UnitPanel.add(b);
					Units.add(b);
				} else if (u instanceof Infantry) {

					BUnits b = new BUnits("Infantry");
					b.setToolTipText("Infantry" + u.getLevel());
					Relocate r = new Relocate();
					Intiate i = new Intiate();
					relocateD.add(r);
					intiateD.add(i);
					i.addActionListener(this);
					r.addActionListener(this);
					b.addActionListener(this);
					this.add(r);
					this.add(i);
					UnitPanel.add(b);
					Units.add(b);
				}
			}

			for (Army A : this.getGame().getPlayer().getControlledArmies()) {
				if (A.getCurrentLocation().equalsIgnoreCase(city.getName())) {
					BArmy a = new BArmy();
					a.addActionListener(this);
					a.setVisible(true);
					UnitPanel1.setVisible(true);
					ArmyList.add(a);
					UnitPanel1.add(a);
				}

			}

		}

		this.revalidate();
		this.repaint();

	}

	public JButton getBuildingArcheryR() {
		return BuildingArcheryR;
	}

	public JButton getBuildingStable() {
		return BuildingStable;
	}

	public JButton getBuildingBarracks() {
		return BuildingBarracks;
	}

	public JButton getBuildingMarket() {
		return BuildingMarket;
	}

	public JButton getBuildingFarm() {
		return BuildingFarm;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource() == cityMap) {
			TopPanel.setVisible(false);
			Initiate.setVisible(false);

			Bpanel4.setVisible(false);
			Bpanel3.setVisible(false);
			Bpanel2.setVisible(false);
			Bpanel1.setVisible(false);
			Bpanel.setVisible(false);
		}
		if (e.getSource() == Map) {
			this.setVisible(false);
			new WorldMap(this.getGame());
			// map.setCityFrame(this);
			// setMap(map);

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// if (e.getSource()==Build)

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for (City city : this.getGame().getPlayer().getControlledCities()) {
			for (int i = 0; i < ArmyList.size(); i++) {
				if (!ArmyList.isEmpty())
					if (e.getSource() == ArmyList.get(i)) {
						TopPanel.removeAll();
						TopPanel.setVisible(true);
						TopPanel.add(Target);
						TopPanel.add(Target1);
						q = i;
						if (city.getName().equalsIgnoreCase("Cairo")) {
							Target.setText("Target Rome");
							Target.setVisible(true);
							Target1.setText("Target Sparta");
							Target1.setVisible(true);
						} else if (city.getName().equalsIgnoreCase("Rome")) {
							Target.setText("Target Sparta");
							Target.setVisible(true);
							Target1.setText("Target Cairo");
							Target1.setVisible(true);
						} else if (city.getName().equalsIgnoreCase("Sparta")) {
							Target.setText("Target Rome");
							Target.setVisible(true);
							Target1.setText("Target Cairo");
							Target1.setVisible(true);
						}

					}
			}
			if (city.getName().equalsIgnoreCase("Cairo")) {
				if (e.getSource() == Target) {
					this.getGame().targetCity(this.getGame().getPlayer().getControlledArmies().get(q), "Rome");
					ArmyList.remove(q);
					UnitPanel1.remove(q);
					if (ArmyList.isEmpty()) {
						UnitPanel1.setVisible(false);
					}
				} else if (e.getSource() == Target1) {
					this.getGame().targetCity(this.getGame().getPlayer().getControlledArmies().get(q), "Sparta");
					ArmyList.remove(q);
					UnitPanel1.remove(q);
					if (ArmyList.isEmpty()) {
						UnitPanel1.setVisible(false);
					}
				}
			} else if (city.getName().equalsIgnoreCase("Rome")) {
				if (e.getSource() == Target) {
					this.getGame().targetCity(this.getGame().getPlayer().getControlledArmies().get(q), "Sparta");
					ArmyList.remove(q);
					UnitPanel1.remove(q);
					if (ArmyList.isEmpty()) {
						UnitPanel1.setVisible(false);
					}
				} else if (e.getSource() == Target1) {
					this.getGame().targetCity(this.getGame().getPlayer().getControlledArmies().get(q), "Cairo");
					ArmyList.remove(q);
					UnitPanel1.remove(q);
					if (ArmyList.isEmpty()) {
						UnitPanel1.setVisible(false);
					}
				}
			} else if (city.getName().equalsIgnoreCase("Sparta")) {
				if (e.getSource() == Target) {
					this.getGame().targetCity(this.getGame().getPlayer().getControlledArmies().get(q), "Rome");
					ArmyList.remove(q);
					UnitPanel1.remove(q);
					if (ArmyList.isEmpty()) {
						UnitPanel1.setVisible(false);
					}
				} else if (e.getSource() == Target1) {
					this.getGame().targetCity(this.getGame().getPlayer().getControlledArmies().get(q), "Cairo");
					ArmyList.remove(q);
					UnitPanel1.remove(q);
					if (ArmyList.isEmpty()) {
						UnitPanel1.setVisible(false);
					}
				}
			}
		}

		for (City city : this.getGame().getPlayer().getControlledCities()) {
			if (city.getName().equalsIgnoreCase(this.getCity().getName())) {
				// System.out.println(1);

				for (int i = 0; i < city.getDefendingArmy().getUnits().size(); i++) {

					if (e.getSource() == Units.get(i)) {
						TopPanel.removeAll();
						TopPanel.setVisible(true);
						intiateD.get(i).setVisible(true);
						relocateD.get(i).setVisible(true);
						relocateD.get(i).setToolTipText("Choose Army First");
						TopPanel.add(relocateD.get(i));
						TopPanel.add(intiateD.get(i));

					} else {
						
						TopPanel.remove(relocateD.get(i));
						TopPanel.remove(intiateD.get(i));
						TopPanel.setVisible(false);
					}

					if (intiateD.size() > i)
						if (e.getSource() == intiateD.get(i)) {

							this.getGame().getPlayer().initiateArmy(city, city.getDefendingArmy().getUnits().get(i));
							BArmy a = new BArmy();
							a.addActionListener(this);
							a.setVisible(true);
							UnitPanel1.setVisible(true);
							ArmyList.add(a);
							UnitPanel1.add(a);

							Units.get(i).setVisible(false);
							Units.remove(i);
							UnitPanel.remove(i);

							intiateD.get(i).setVisible(false);
							relocateD.get(i).setVisible(false);

							relocateD.remove(i);
							intiateD.remove(i);

						}
					if (relocateD.size() > i) {
						if(!this.getGame().getPlayer().getControlledArmies().isEmpty())
						if (e.getSource() == relocateD.get(i)) {
							
							try {
								RelocateUnit u = new RelocateUnit(ArmyList);

								if ((u.getZ() != -1)) {
									Units.get(i).setVisible(false);

									Units.remove(i);
									UnitPanel.remove(i);

									intiateD.get(i).setVisible(false);
									relocateD.get(i).setVisible(false);
									
									relocateD.remove(i);
									intiateD.remove(i);
									
									this.getGame().getPlayer().getControlledArmies().get(u.getZ())
											.relocateUnit(city.getDefendingArmy().getUnits().get(i));
									
									
									
								}
							} catch (MaxCapacityException e1) {
								new Exception(e1.getMessage());
							}
							
						}
					
					
				}
					

				}
			}
		}

		if (e.getSource() == this.getEnd()) {
			this.getGame().endTurn();
			
			for (City c : this.getGame().getAvailableCities()) {

				if (c.getTurnsUnderSiege() == 3) {
					this.dispose();
					
					for(Army b :this.getGame().getPlayer().getControlledArmies())
					if(c.getName().equalsIgnoreCase(b.getCurrentLocation())) {
						
						new BattleView(b, c.getDefendingArmy(), this.getGame()) ;
						if(!getGame().getPlayer().getControlledArmies().isEmpty()) 
						this.getGame().getPlayer().getControlledArmies().remove(b);
						
							this.dispose();	
						}
					}

				}
				this.dispose();
				new CityFrame(this.getGame(),this.getCity());
				
			
		
			if (this.getGame().isGameOver()) {
				if (this.getGame().getAvailableCities().size() == this.getGame().getPlayer().getControlledCities()
						.size()) {new Winner();

				} else {
					new GameOver();
					this.dispose();
				}
			} else {
				this.getInfo3().setText("Gold: " + this.getGame().getPlayer().getTreasury() + "    Food: "
						+ this.getGame().getPlayer().getFood());

			}
//			for (City c : this.getGame().getPlayer().getControlledCities()) {
//
//				for (Unit u : c.getDefendingArmy().getUnits()) {
//					double x1;
//					if ((c.getDefendingArmy().getCurrentStatus().compareTo(Status.IDLE)) == 0) {
//						// double x1 = u.getIdleUpkeep();
//					}
//				}
//			}
//			

		}

		if (e.getSource() == Controlled) {
			String s = "";
			if(!this.getGame().getPlayer().getControlledArmies().isEmpty())
			for (Army a : this.getGame().getPlayer().getControlledArmies()) {
				// if(a.getCurrentStatus()==Status.IDLE)
				// s+="Idle :"+"\n"
				// an so on
				for (Unit b : a.getUnits()) {
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

			}
			new ArmyInfo(s);
		}

		if (e.getSource() == recruit)

		{
			try {

				for (City c : this.getGame().getPlayer().getControlledCities()) {
					if (c.getName().equalsIgnoreCase(this.getCity().getName())) {
						this.getGame().getPlayer().recruitUnit("Archer", this.getCity().getName());
						BUnits b = new BUnits("archer");

						Relocate r = new Relocate();
						Intiate i = new Intiate();
						relocateD.add(r);
						intiateD.add(i);
						i.addActionListener(this);
						r.addActionListener(this);
						b.addActionListener(this);

						UnitPanel.add(b);
						Units.add(b);
						this.getInfo3().setText("Gold: " + this.getGame().getPlayer().getTreasury() + "    Food: "
								+ this.getGame().getPlayer().getFood());

					}
				}

			} catch (BuildingInCoolDownException | MaxRecruitedException | NotEnoughGoldException e1) {

				new Exception(e1.getMessage());
			}

		}
		if (e.getSource() == recruit1) {
			try {

				for (City c : this.getGame().getPlayer().getControlledCities()) {
					if (c.getName().equalsIgnoreCase(this.getCity().getName())) {
						BUnits b = new BUnits("Cavalry");
						this.getGame().getPlayer().recruitUnit("Cavalry", this.getCity().getName());
						Relocate r = new Relocate();
						Intiate i = new Intiate();
						relocateD.add(r);
						intiateD.add(i);
						i.addActionListener(this);
						r.addActionListener(this);
						b.addActionListener(this);
						this.add(r);
						this.add(i);
						UnitPanel.add(b);
						Units.add(b);
						this.getInfo3().setText("Gold: " + this.getGame().getPlayer().getTreasury() + "    Food: "
								+ this.getGame().getPlayer().getFood());

					}
				}

			} catch (BuildingInCoolDownException | MaxRecruitedException | NotEnoughGoldException e1) {

				new Exception(e1.getMessage());
			}

		}
		if (e.getSource() == recruit2) {
			try {

				for (City c : this.getGame().getPlayer().getControlledCities()) {
					if (c.getName().equalsIgnoreCase(this.getCity().getName())) {
						BUnits b = new BUnits("Infantry");
						this.getGame().getPlayer().recruitUnit("Infantry", this.getCity().getName());
						Relocate r = new Relocate();
						Intiate i = new Intiate();
						relocateD.add(r);
						intiateD.add(i);
						i.addActionListener(this);
						r.addActionListener(this);
						b.addActionListener(this);
						this.add(r);
						this.add(i);
						UnitPanel.add(b);
						Units.add(b);
						this.getInfo3().setText("Gold: " + this.getGame().getPlayer().getTreasury() + "    Food: "
								+ this.getGame().getPlayer().getFood());

					}
				}

			} catch (BuildingInCoolDownException | MaxRecruitedException | NotEnoughGoldException e1) {

				new Exception(e1.getMessage());
			}

		}

		if (e.getSource() == BuildingArcheryR2) {

			Bpanel.setVisible(true);

			for (City c : this.getGame().getPlayer().getControlledCities()) {
				if (c.getName().equalsIgnoreCase(getCity().getName())) {
					for (Building b : c.getMilitaryBuildings()) {
						if (b instanceof ArcheryRange) {

							LabelP.setText("    Archery Range  " + b.getLevel());

							LabelP.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
							String s = "" + b.getUpgradeCost();
							upgrade.setToolTipText(s);

							recruit.setToolTipText("" + ((ArcheryRange) b).getRecruitmentCost());
							
							break;
						}
					}
				}

			}

		} else {
			Bpanel.setVisible(false);
		}

		if (e.getSource() == BuildingStable2) {
			Bpanel1.setVisible(true);

			for (City c : this.getGame().getPlayer().getControlledCities()) {
				if (c.getName().equalsIgnoreCase(getCity().getName())) {
					for (Building b : c.getMilitaryBuildings()) {
						if (b instanceof Stable) {

							LabelP1.setText("    Stable  " + b.getLevel());

							LabelP1.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
							String s = "" + b.getUpgradeCost();
							upgrade1.setToolTipText(s);

							recruit1.setToolTipText("" + ((Stable) b).getRecruitmentCost());

							break;
						}
					}
				}

			}
		} else {
			Bpanel1.setVisible(false);
		}

		if (e.getSource() == BuildingBarracks2) {
			Bpanel2.setVisible(true);

			for (City c : this.getGame().getPlayer().getControlledCities()) {
				if (c.getName().equalsIgnoreCase(getCity().getName())) {
					for (Building b : c.getMilitaryBuildings()) {
						if (b instanceof Barracks) {

							LabelP2.setText("    Barracks  " + b.getLevel());

							LabelP2.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
							String s = "" + b.getUpgradeCost();
							upgrade2.setToolTipText(s);

							recruit2.setToolTipText("" + ((Barracks) b).getRecruitmentCost());

							break;
						}
					}
				}

			}
		} else {
			Bpanel2.setVisible(false);
		}
		if (e.getSource() == BuildingFarm2) {
			Bpanel3.setVisible(true);

			for (City c : this.getGame().getPlayer().getControlledCities()) {
				if (c.getName().equalsIgnoreCase(getCity().getName())) {
					for (Building b : c.getEconomicalBuildings()) {
						if (b instanceof Farm) {

							LabelP3.setText("    Farm  " + b.getLevel());

							LabelP3.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
							String s = "" + b.getUpgradeCost();
							upgrade3.setToolTipText(s);

							break;
						}
					}
				}

			}

		} else {
			Bpanel3.setVisible(false);
		}
		if (e.getSource() == BuildingMarket2) {
			Bpanel4.setVisible(true);

			for (City c : this.getGame().getPlayer().getControlledCities()) {
				if (c.getName().equalsIgnoreCase(getCity().getName())) {
					for (Building b : c.getEconomicalBuildings()) {
						if (b instanceof Market) {

							LabelP4.setText("    Market  " + b.getLevel());

							LabelP4.setFont(new Font("Viner Hand ITC", Font.BOLD, 15));
							String s = "" + b.getUpgradeCost();
							upgrade4.setToolTipText(s);

							break;
						}
					}
				}

			}
		} else {
			Bpanel4.setVisible(false);
		}

		if (e.getSource() == Build) {
			buildPanel.setVisible(true);
		} else {
			buildPanel.setVisible(false);
		}
		if (e.getSource() == BuildingArcheryR) {
			try {
				this.getGame().getPlayer().build("archeryrange", this.getCity().getName());
				this.getInfo3().setText("Gold: " + getGame().getPlayer().getTreasury() + "    Food: "
						+ getGame().getPlayer().getFood());
				BuildingArcheryR2.setVisible(true);
				BuildingArcheryR.setEnabled(false);

			} catch (NotEnoughGoldException e1) {
				new Exception(e1.getMessage());

			}

		} else if (e.getSource() == BuildingStable) {
			try {
				this.getGame().getPlayer().build("stable", this.getCity().getName());
				this.getInfo3().setText("Gold: " + getGame().getPlayer().getTreasury() + "    Food: "
						+ getGame().getPlayer().getFood());
				BuildingStable2.setVisible(true);
				BuildingStable.setEnabled(false);
			} catch (NotEnoughGoldException e1) {
				new Exception(e1.getMessage());

			}

		} else if (e.getSource() == BuildingBarracks) {
			try {
				this.getGame().getPlayer().build("barracks", this.getCity().getName());
				this.getInfo3().setText("Gold: " + getGame().getPlayer().getTreasury() + "    Food: "
						+ getGame().getPlayer().getFood());
				BuildingBarracks2.setVisible(true);
				BuildingBarracks.setEnabled(false);
			} catch (NotEnoughGoldException e1) {
				new Exception(e1.getMessage());

			}

		} else if (e.getSource() == BuildingMarket) {
			try {
				this.getGame().getPlayer().build("market", this.getCity().getName());
				this.getInfo3().setText("Gold: " + getGame().getPlayer().getTreasury() + "    Food: "
						+ getGame().getPlayer().getFood());
				BuildingMarket2.setVisible(true);
				BuildingMarket.setEnabled(false);
			} catch (NotEnoughGoldException e1) {
				new Exception(e1.getMessage());

			}

		} else if (e.getSource() == BuildingFarm) {
			try {
				this.getGame().getPlayer().build("farm", this.getCity().getName());
				this.getInfo3().setText("Gold: " + getGame().getPlayer().getTreasury() + "    Food: "
						+ getGame().getPlayer().getFood());
				BuildingFarm2.setVisible(true);
				BuildingFarm.setEnabled(false);
			} catch (NotEnoughGoldException e1) {
				new Exception(e1.getMessage());

			}
		}

		if (e.getSource() == upgrade) {
			for (City c : this.getGame().getPlayer().getControlledCities()) {
				if (c.getName().equalsIgnoreCase(getCity().getName())) {
					for (Building b : c.getMilitaryBuildings()) {
						if (b instanceof ArcheryRange) {
							try {
								this.getGame().getPlayer().upgradeBuilding(b);
							} catch (NotEnoughGoldException | BuildingInCoolDownException | MaxLevelException e1) {
								new Exception(e1.getMessage());

							}
							this.getInfo3().setText("Gold: " + this.getGame().getPlayer().getTreasury() + "    Food: "
									+ this.getGame().getPlayer().getFood());

							break;
						}
					}
				}

			}
		}
		if (e.getSource() == upgrade1) {
			for (City c : this.getGame().getPlayer().getControlledCities()) {
				if (c.getName().equalsIgnoreCase(getCity().getName())) {
					for (Building b : c.getMilitaryBuildings()) {
						if (b instanceof Stable) {
							try {
								this.getGame().getPlayer().upgradeBuilding(b);
							} catch (NotEnoughGoldException | BuildingInCoolDownException | MaxLevelException e1) {
								new Exception(e1.getMessage());

							}
							this.getInfo3().setText("Gold: " + this.getGame().getPlayer().getTreasury() + "    Food: "
									+ this.getGame().getPlayer().getFood());

							break;
						}
					}
				}

			}
		}
		if (e.getSource() == upgrade2) {
			for (City c : this.getGame().getPlayer().getControlledCities()) {
				if (c.getName().equalsIgnoreCase(getCity().getName())) {
					for (Building b : c.getMilitaryBuildings()) {
						if (b instanceof Barracks) {
							try {
								this.getGame().getPlayer().upgradeBuilding(b);
							} catch (NotEnoughGoldException | BuildingInCoolDownException | MaxLevelException e1) {
								new Exception(e1.getMessage());

							}
							this.getInfo3().setText("Gold: " + this.getGame().getPlayer().getTreasury() + "    Food: "
									+ this.getGame().getPlayer().getFood());

							break;
						}
					}
				}

			}
		}

		if (e.getSource() == upgrade3) {
			for (City c : this.getGame().getPlayer().getControlledCities()) {
				if (c.getName().equalsIgnoreCase(getCity().getName())) {
					for (Building b : c.getEconomicalBuildings()) {
						if (b instanceof Farm) {
							try {
								this.getGame().getPlayer().upgradeBuilding(b);
							} catch (NotEnoughGoldException | BuildingInCoolDownException | MaxLevelException e1) {
								new Exception(e1.getMessage());

							}
							this.getInfo3().setText("Gold: " + this.getGame().getPlayer().getTreasury() + "    Food: "
									+ this.getGame().getPlayer().getFood());

							break;
						}
					}
				}

			}
		}
		if (e.getSource() == upgrade4) {
			//System.out.println("noooo");
			for (City c : this.getGame().getPlayer().getControlledCities()) {

				if (c.getName().equalsIgnoreCase(getCity().getName())) {
					for (Building b : c.getEconomicalBuildings()) {
						if (b instanceof Market) {
							try {
								this.getGame().getPlayer().upgradeBuilding(b);
							} catch (NotEnoughGoldException | BuildingInCoolDownException | MaxLevelException e1) {
								System.out.println("noooo");
								new Exception(e1.getMessage());

							}
							this.getInfo3().setText("Gold: " + this.getGame().getPlayer().getTreasury() + "    Food: "
									+ this.getGame().getPlayer().getFood());

							break;
						}
					}
				}

			}
		}

	}

	public void setMap(JButton map) {
		Map = map;
	}

//	public WorldMap getMap() {
//		return map;
//	}
//
//	public void setMap(WorldMap map) {
//		this.map = map;
//	}

	public static void main(String[] args) {
		Game g;
		try {
			g = new Game("tony", "Rome");
			new CityFrame(g, new City("Rome"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
