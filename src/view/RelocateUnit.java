package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.*;

public class RelocateUnit extends JFrame implements ActionListener {

	private JPanel PanelD = new JPanel();
	private JPanel PanelF = new JPanel();
	private JPanel PanelR = new JPanel();
	private JButton ButtonDef = new JButton();
	ArrayList<BArmy> a = new ArrayList<BArmy>();

	private int z;

	public RelocateUnit(ArrayList<BArmy> a) {
		this.a = a;

		setResizable(true);
		setBounds(0, 0, 1800, 1800);
		setVisible(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		ButtonDef.setBounds(0, 0, 420, 400);
		ButtonDef.setText("Defending Army");
		ButtonDef.setFont(new Font("Viner Hand ITC", Font.PLAIN, 70));
		ButtonDef.setContentAreaFilled(false);
		ButtonDef.setBackground(Color.gray);
		ButtonDef.setBorder(null);
		ButtonDef.setVisible(true);
		ButtonDef.addActionListener(this);


		PanelF.setBounds(0, 0, 1800, 1890);
		PanelF.setFont(new Font("Viner Hand ITC", Font.BOLD, 70));
		PanelF.setForeground(Color.red);
		PanelF.setBackground(Color.white);
		PanelF.setVisible(true);

		PanelD.setBounds(0, 0, 1540, 400);
		PanelD.setVisible(true);
		PanelD.setOpaque(true);
		PanelD.setLayout(new GridLayout());
		PanelD.setBackground(Color.black);

		PanelR.setBackground(Color.black);
		PanelR.setBounds(0, 500, 1650, 500);
		PanelR.setVisible(true);
		PanelR.setOpaque(true);
		PanelR.setLayout(new GridLayout());

		add(PanelD);
		PanelD.add(ButtonDef);
		add(PanelR);
		this.add(PanelF);

		for (BArmy b : a) {
			b.setVisible(true);
			b.addActionListener(this);
			PanelR.add(b);

		}

		repaint();
		revalidate();
	}

	public static void main(String[] args) {
		// new RelocateUnit();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ButtonDef) {
			setZ(-1);

		}
		for (int i = 0; i < a.size(); i++) {
			if (e.getSource() == a.get(i)) {
				setZ(i);
			}
			this.setVisible(false);
		}

	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
}
