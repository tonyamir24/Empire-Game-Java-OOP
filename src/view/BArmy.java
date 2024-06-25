package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BArmy extends JButton {
	
	private int i;
	public BArmy() {
		ImageIcon i =new ImageIcon("army.png");
		this.setIcon(i);
		this.setContentAreaFilled(false);
		this.setBorder(null);
		this.setVisible(true);
		this.setToolTipText("Army");
		
		
		
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
}
