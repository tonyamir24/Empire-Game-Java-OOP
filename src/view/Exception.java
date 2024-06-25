package view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Exception extends JFrame {
	private JPanel p = new JPanel();
	
	private JLabel f = new JLabel();

	public Exception(String s) {
		this.setBounds(580, 395, 150, 500);
		p = new JPanel();
		p.setBounds(90, 285, 150, 500);
		p.setVisible(true);
		p.setLayout(new GridLayout(1, 1, 500, 500));
		p.setVisible(true);
		f.setFont(new Font("Consolas", Font.PLAIN, 30));
		this.setVisible(true);
		f.setText(s);
		f.setVisible(true);
		f.setOpaque(true);
		p.add(f);

		this.add(p);
		repaint();
		revalidate();
		this.pack();

	}
	public static void main(String[] args) {
		new Exception("GOGo ");
	}
	
}
