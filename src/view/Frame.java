package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;



public class Frame extends JFrame {
	JButton exit = new JButton();

	Frame() {
		setLayout(null);
		setTitle("JFrame title goes here");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1650, 1080);
		setUndecorated(true);
		setVisible(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		exit.setBounds(1460, 0, 80, 30);

		exit.setText("Exit");
		exit.setBackground(Color.black);
		exit.setFont(new Font("Viner Hand ITC", Font.PLAIN, 20));
		exit.setForeground(Color.red);
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		add(exit);
		this.revalidate();
		this.repaint();

	}

	public void playSound(String filepath) {
		try {

			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		//System.out.println("yeah");
		new Frame();
	}

	
	
}
