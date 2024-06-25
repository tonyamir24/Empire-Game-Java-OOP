package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import buildings.Building;
import engine.City;
import engine.Game;
import engine.Player;
import exceptions.BuildingInCoolDownException;
import exceptions.FriendlyCityException;
import exceptions.MaxLevelException;
import exceptions.NotEnoughGoldException;
import exceptions.TargetNotReachedException;
import units.Army;
import units.Status;
import units.Unit;

public class Gui extends JFrame implements ActionListener, MouseListener {
	private Game game;
	private CityFrame main;
	private Start start;
	private WorldMap map;
	private Clip clip4;

	Gui() {
		try {

			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("ingame.wav").getAbsoluteFile());
			clip4 = AudioSystem.getClip();
			clip4.open(audioInputStream);

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();

		}
		start = new Start();

		start.getStart().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				start.getClip().stop();
				start.getClip1().stop();
				start.getClip2().stop();
				start.getClip3().stop();
				try {
					game = new Game(start.getField().getText(), start.getCity());
				} catch (IOException e1) {

					new Exception(e1.getMessage());
				}

				map = new WorldMap(game);
				game = map.getGame();
				start.setVisible(false);
				clip4.start();
				
			}
		});
	}

	public void onRecruit(Unit u) {

	}

	public void onBuild(Building b) {

	}

	public void onupgradeBuilding(Building b) {

	}

	public void oninitiateArmy(City city, Unit unit) {

	}

	public void onlaySiege(Army army, City city) throws TargetNotReachedException, FriendlyCityException {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// if(e.getSource()==start.getStart()) {

		// new WorldMap();
		// }

	}

	public static void main(String[] args) {
		new Gui();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

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
}
