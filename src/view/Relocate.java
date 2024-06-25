package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class Relocate extends JButton{
	Relocate(){
		setText("Relocate Unit");
		setFont(new Font("Viner Hand ITC", Font.PLAIN, 25));
		setForeground(Color.cyan);
		//setBounds(535, 0, 190, 70);
		setBackground(Color.black);
		setVisible(false);
	}
}
