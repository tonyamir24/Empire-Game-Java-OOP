package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import engine.City;
import engine.Game;

public class SubFrame extends Frame {
	private JLabel info1;
	private JLabel info2;
	private JLabel info3;
	private Game game;
	private City city;
	private JButton End = new JButton();

	public SubFrame(Game game, City city) {
		this.setGame(game);
		this.setCity(city);

		info1 = new JLabel();
		info2 = new JLabel();
		info3 = new JLabel();
		info1.setBounds(10, -30, 200, 100);
		info2.setBounds(10, -10, 200, 100);
		info3.setBounds(10, 10, 500, 100);
		info1.setText(game.getPlayer().getName());
		info2.setText(city.getName());
		info3.setText("Gold: " + game.getPlayer().getTreasury() + "    Food: " + game.getPlayer().getFood());
		info1.setFont(new Font("Viner Hand ITC", Font.PLAIN, 20));
		info2.setFont(new Font("Viner Hand ITC", Font.PLAIN, 20));
		info3.setFont(new Font("Viner Hand ITC", Font.PLAIN, 20));
		info1.setOpaque(false);
		info2.setOpaque(false);
		info3.setOpaque(false);
		info1.setForeground(Color.WHITE);
		info2.setForeground(Color.WHITE);
		info3.setForeground(Color.WHITE);
		
		ImageIcon ControlledV = new ImageIcon("End.png");
		End.setIcon(ControlledV);
		End.setBounds(1347, 715, 202, 152);
		End.setBorder(null);
		End.setVisible(true);
		End.setContentAreaFilled(false);
		//End.addActionListener(this);
		End.setToolTipText("End");
		End.setEnabled(true);
		
		this.add(End);
		this.add(info1);
		this.add(info2);
		this.add(info3);
		this.repaint();
		this.revalidate();

	}

	public JButton getEnd() {
		return End;
	}

	public JLabel getInfo1() {
		return info1;
	}

	public void setInfo1(JLabel info1) {
		this.info1 = info1;
	}

	public JLabel getInfo2() {
		return info2;
	}

	public void setInfo2(JLabel info2) {
		this.info2 = info2;
	}

	public JLabel getInfo3() {
		return info3;
	}

	public void setInfo3(JLabel info3) {
		this.info3 = info3;
	}

	public SubFrame(Game game) {
		this.setGame(game);

		info1 = new JLabel();

		info3 = new JLabel();
		info1.setBounds(10, -30, 200, 100);

		info3.setBounds(10, 10, 200, 100);
		info1.setText(game.getPlayer().getName());

		info3.setText("Gold: " + game.getPlayer().getTreasury() + "    Food: " + game.getPlayer().getFood());
		info1.setFont(new Font("Viner Hand ITC", Font.PLAIN, 20));

		info3.setFont(new Font("Viner Hand ITC", Font.PLAIN, 20));
		info1.setOpaque(false);

		info3.setOpaque(false);
		info1.setForeground(Color.WHITE);

		info3.setForeground(Color.WHITE);
		this.add(info1);

		this.add(info3);
		this.repaint();
		this.revalidate();

	}

	public static void main(String[] args) {

		try {
			new SubFrame(new Game("Paula", "Cairo"), new City("Cairo"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
