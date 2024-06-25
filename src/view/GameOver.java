package view;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class GameOver extends Frame {
	JLabel GameOver = new JLabel();
	JPanel PanelOver = new JPanel();
	Clip clipOver;

	public GameOver() {
		try {

			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("forstart.wav").getAbsoluteFile());
			clipOver = AudioSystem.getClip();
			clipOver.open(audioInputStream);

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException s) {
			s.printStackTrace();
		}

		clipOver.start();
		double i = 0;

		exit.setBounds(-20, -20, 1800, 1890);

		exit.setForeground(Color.black);
		exit.setBackground(Color.black);
		exit.setOpaque(false);

		PanelOver.setBounds(0, 0, 1800, 1890);

		PanelOver.setFont(new Font("Viner Hand ITC", Font.BOLD, 70));
		PanelOver.setForeground(Color.red);
		PanelOver.setBackground(Color.black);
		PanelOver.setVisible(true);
		

		for (i = 1; i < 450; i = i + 0.1) {

			GameOver.setBounds((int) i, 400, 650, 100);
			GameOver.setText("GAME OVER");
			GameOver.setFont(new Font("Viner Hand ITC", Font.BOLD, 100));
			GameOver.setForeground(Color.red);
			GameOver.setBackground(Color.black);
			this.add(GameOver);
			this.add(PanelOver);

		}

		repaint();
		revalidate();
	}

	public static void main(String[] args) {
		new GameOver();
	}
}
