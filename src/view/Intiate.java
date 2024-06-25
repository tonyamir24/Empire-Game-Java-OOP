package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class Intiate extends JButton {
	Intiate(){
		setText("Initiate Army");
		setFont(new Font("Viner Hand ITC", Font.PLAIN, 25));
		setForeground(Color.cyan);
		//setBounds(735, 0, 240, 70);
		setBackground(Color.black);
		setVisible(false);
	}
}
