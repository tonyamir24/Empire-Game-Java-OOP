package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import units.Unit;

public class BUnits extends JButton{
private Unit unit;
	BUnits(String s){
		ImageIcon i;
		if(s.equalsIgnoreCase("Archer")) {
			i=new ImageIcon("Archer.png");
			
			
		}
		else if(s.equalsIgnoreCase("Cavalry")) {
			i=new ImageIcon("Knight.png");
		}
		else {
			i=new ImageIcon("infantry.png");
		}
		
		this.setIcon(i);
		this.setContentAreaFilled(false);
		this.setBorder(null);
		this.setVisible(true);
		this.setToolTipText(s);
		
		
}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	
	
}
