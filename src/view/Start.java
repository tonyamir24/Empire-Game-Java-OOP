package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import engine.Game;

import engine.Player;

public class Start extends Frame implements ActionListener, MouseListener {
	private JTextField field = new JTextField();

	public JTextField getField() {
		return field;
	}

	public Player getPlayer() {
		return player;
	}

	public Game getGame() {
		return game;
	}

	public Clip getClip() {
		return clip;
	}

	public Clip getClip1() {
		return clip1;
	}

	public Clip getClip2() {
		return clip2;
	}

	public Clip getClip3() {
		return clip3;
	}

	private JButton start = new JButton();

	private JButton cairo = new JButton();
	private JButton rome = new JButton();
	private JButton sparta = new JButton();
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel();
	private JLabel label2 = new JLabel();
	private JLabel label3 = new JLabel();
	private JLabel labelCairo = new JLabel();
	private JLabel labelRome = new JLabel();
	private JLabel labelSparta = new JLabel();
	private JTextArea Title;
	private String city;

	public String getCity() {
		return city;
	}

	private Player player;
	private Game game;

	private Clip clip;
	private Clip clip1;
	private Clip clip2;
	private Clip clip3;

	Start() {

		label.setText("The Conqueror");
		label.setHorizontalTextPosition(JLabel.CENTER);

		label.setBounds(300, 50, 800, 150);
		label.setFont(new Font("Viner Hand ITC", Font.BOLD, 100));
		field.setVisible(true);
		label3.setFont(new Font("Viner Hand ITC", Font.BOLD, 25));
		label3.setBounds(527, 175, 700, 150);
		label3.setHorizontalTextPosition(JLabel.CENTER);
		label3.setText("Choose your Empire!");
		labelCairo.setFont(new Font("Viner Hand ITC", Font.PLAIN, 20));
		labelCairo.setBounds(217, 355, 700, 150);
		labelCairo.setHorizontalTextPosition(JLabel.CENTER);
		labelCairo.setText("Cairo");
		labelRome.setFont(new Font("Viner Hand ITC", Font.PLAIN, 20));
		labelRome.setBounds(627, 355, 700, 150);
		labelRome.setHorizontalTextPosition(JLabel.CENTER);
		labelRome.setText("Rome");
		labelSparta.setFont(new Font("Viner Hand ITC", Font.PLAIN, 20));
		labelSparta.setBounds(1010, 355, 700, 150);
		labelSparta.setHorizontalTextPosition(JLabel.CENTER);
		labelSparta.setText("Sparta");

		field.setPreferredSize(new Dimension(400, 40));
		field.setFont(new Font("Viner Hand ITC", Font.PLAIN, 25));
		field.setForeground(Color.black);
		field.setBackground(Color.black);
		field.setCaretColor(Color.white);
		field.setBounds(465, 610, 250, 50);
		field.setOpaque(false);
		field.setText("Enter your name here");

		start.setText("Start");
		start.setFont(new Font("Viner Hand ITC", Font.PLAIN, 25));
		start.setForeground(Color.white);

		ImageIcon icon = new ImageIcon("babe.png");
		label2.setIcon(icon);
		label2.setBounds(0, 0, 1650, 900);

		start.setBounds(735, 610, 100, 50);
		start.addMouseListener(this);
		start.setBackground(Color.black);
		start.setEnabled(false);

		ImageIcon icon2 = new ImageIcon("Cairo flag.png");
		cairo.setIcon(icon2);
		cairo.setText("cairo");
		cairo.setBounds(150, 305, 185, 100);
		cairo.addMouseListener(this);
		ImageIcon icon1 = new ImageIcon("Rome flag.png");
		rome.setIcon(icon1);
		rome.setBounds(550, 305, 200, 100);
		rome.addMouseListener(this);
		rome.setBackground(Color.black);

		ImageIcon icon3 = new ImageIcon("Sparta flag.png");
		sparta.setIcon(icon3);
		sparta.setText("sparta");
		sparta.setBounds(950, 305, 185, 100);
		sparta.addMouseListener(this);
		sparta.setBackground(Color.black);

		try {

			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("forstart.wav").getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
		try {

			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("cairosound.wav").getAbsoluteFile());
			clip1 = AudioSystem.getClip();
			clip1.open(audioInputStream);

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException s) {
			s.printStackTrace();
		}
		try {

			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("romesound.wav").getAbsoluteFile());
			clip2 = AudioSystem.getClip();
			clip2.open(audioInputStream);

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException s) {
			s.printStackTrace();
		}
		try {

			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("spartasound.wav").getAbsoluteFile());
			clip3 = AudioSystem.getClip();
			clip3.open(audioInputStream);

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException s) {
			s.printStackTrace();
		}

		this.add(field);
		this.add(sparta);
		this.add(rome);
		this.add(start);
		this.add(cairo);
		this.add(label);
		this.add(labelCairo);
		this.add(labelRome);
		this.add(labelSparta);
		this.add(label3);

		this.add(label2);

		// label.setVisible(true);

		// label.setText("Titla");
		this.revalidate();
		this.repaint();
		// this.add(label);
		clip.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public JButton getStart() {
		return start;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (!(cairo.isEnabled() || sparta.isEnabled() || rome.isEnabled())) {
			if (e.getSource() == start) {
				try {
					game = new Game(field.getText(), city);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				player = new Player(field.getText());

			}
		}
		if (e.getSource() == cairo) {

			if (cairo.isEnabled()) {
				city = "Cairo";
				try {

					AudioInputStream audioInputStream = AudioSystem
							.getAudioInputStream(new File("cairosound.wav").getAbsoluteFile());
					clip1 = AudioSystem.getClip();
					clip1.open(audioInputStream);

					clip1.start();
					clip2.stop();
					clip3.stop();
					clip.stop();
					/*
					 * while (true) { if(clip1.getMicrosecondLength() ==
					 * clip1.getMicrosecondPosition()) { break; }
					 * 
					 * }
					 */

					clip.start();

				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException s) {
					s.printStackTrace();
				}
			}
			cairo.setEnabled(false);
			sparta.setEnabled(true);
			rome.setEnabled(true);
			start.setEnabled(true);
		}
		if (e.getSource() == rome) {

			if (rome.isEnabled()) {
				city = "Rome";
				try {

					AudioInputStream audioInputStream = AudioSystem
							.getAudioInputStream(new File("romesound.wav").getAbsoluteFile());
					clip2 = AudioSystem.getClip();
					clip2.open(audioInputStream);
					clip2.start();
					clip.stop();
					clip1.stop();
					clip3.stop();
					/*
					 * while (clip2.getMicrosecondLength() != clip2.getMicrosecondPosition()) { if
					 * (e.getSource() == start || e.getSource() == sparta || e.getSource() == cairo
					 * || e.getSource() == exit) { break; } }
					 */
					clip.start();

				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException s) {
					s.printStackTrace();
				}
				cairo.setEnabled(true);
				sparta.setEnabled(true);
				rome.setEnabled(false);
				start.setEnabled(true);
			}
		}
		if (e.getSource() == sparta) {

			if (sparta.isEnabled()) {
				city = "Sparta";
				try {

					AudioInputStream audioInputStream = AudioSystem
							.getAudioInputStream(new File("spartasound.wav").getAbsoluteFile());
					clip3 = AudioSystem.getClip();
					clip3.open(audioInputStream);
					clip3.start();
					clip2.stop();
					clip1.stop();
					clip.stop();
					/*
					 * while (clip3.getMicrosecondLength() != clip3.getMicrosecondPosition()) { if
					 * (e.getSource() == start || e.getSource() == cairo || e.getSource() == rome ||
					 * e.getSource() == exit) { break; } }
					 */
					clip.start();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException s) {
					s.printStackTrace();
				}
				cairo.setEnabled(true);
				sparta.setEnabled(false);
				rome.setEnabled(true);
				start.setEnabled(true);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == start) {

		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == start || e.getSource() == cairo || e.getSource() == sparta || e.getSource() == rome)
			playSound("hover.wav");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		new Start();
	}

}
