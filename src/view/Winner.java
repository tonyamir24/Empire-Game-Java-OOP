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

public class Winner extends Frame {

	JLabel GameWinner = new JLabel();
	JPanel PanelWinner = new JPanel();
	JLabel wallpaper = new JLabel();
	Clip clipWinner;

	public Winner() {
		try {

			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("winner.wav").getAbsoluteFile());
			clipWinner = AudioSystem.getClip();
			clipWinner.open(audioInputStream);

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException s) {
			s.printStackTrace();
		}

		clipWinner.start();
		double i = 0;

		exit.setBounds(-20, -20, 1800, 1890);

		exit.setForeground(Color.black);
		exit.setBackground(Color.black);
		exit.setOpaque(false);

		PanelWinner.setBounds(0, 0, 1800, 1890);

		PanelWinner.setFont(new Font("Viner Hand ITC", Font.BOLD, 70));
		PanelWinner.setForeground(Color.red);
		PanelWinner.setBackground(Color.white);
		PanelWinner.setVisible(true);
		PanelWinner.setOpaque(false);

//		ImageIcon c = new ImageIcon("Winner.png");
//		wallpaper.setIcon(c);
//		wallpaper.setBounds(0, 0, 1540, 1000);
//// 		wallpaper.setText("YOU ARE THE CONQUEROR!");
//		wallpaper.setFont(new Font("Viner Hand ITC", Font.BOLD, 60));
//		wallpaper.setForeground(Color.red);
//		wallpaper.setBackground(Color.white);
//		this.add(wallpaper);

		while (i < 1600) {

			GameWinner.setBounds((int) i, 400, 850, 100);
			GameWinner.setText("YOU ARE THE CONQUEROR!");
			GameWinner.setFont(new Font("Viner Hand ITC", Font.BOLD, 60));
			GameWinner.setForeground(Color.red);
			GameWinner.setBackground(Color.white);
			i = i + 0.1;

			this.add(GameWinner);
			this.add(PanelWinner);
			if (i > 1540) {
				i = -800;
			}
			repaint();
			revalidate();

		}

	}

	public static void main(String[] args) {
		new Winner();
	}
}
