package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ArmyInfo extends JFrame {
	JPanel p = new JPanel();
	
	private JTextArea f = new JTextArea();

	public ArmyInfo(String s) {
		this.setBounds(580, 295, 150, 500);
		p = new JPanel();
		p.setBounds(90, 285, 150, 500);
		p.setVisible(true);
		p.setLayout(new GridLayout(1, 1, 500, 500));
		p.setVisible(true);
		f.setFont(new Font("Viner Hand ITC", Font.PLAIN, 30));
		f.setForeground(Color.white);
		this.setVisible(true);
		f.setText(s);
		f.setVisible(true);
		f.setOpaque(true);
		p.add(f);
		f.setEditable(false);
		f.setBackground(new Color(0xfada6e));
		this.add(p);
		repaint();
		revalidate();
		this.pack();

	}
public static void main(String[] args) {
	new ArmyInfo("sdhfgshd");
}	

}