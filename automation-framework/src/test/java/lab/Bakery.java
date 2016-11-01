package lab;

import javax.swing.JOptionPane;

public class Bakery {

	public static void main(String[] args) {

		String flavor = JOptionPane.showInputDialog("Let's order a birthday cake! What flavor would you like?");
		int candles = Integer.parseInt(JOptionPane.showInputDialog("And how many candles?"));
		makeBirthdayCake(candles, flavor);

		flavor = JOptionPane.showInputDialog("Let's order a wedding cake! What flavor would you like?");
		int tiers = Integer.parseInt(JOptionPane.showInputDialog("And how many tiers?"));
		makeWeddingCake(tiers, flavor);

		flavor = JOptionPane.showInputDialog("Let's order a cake! What flavor would you like?");
		makeCake(flavor);

		System.exit(0);

	}

	public static void makeBirthdayCake(int candles, String flavor){
		BirthdayCake cake = new BirthdayCake();
		cake.setFlavor(flavor);
		cake.setCandles(candles);
		cake.showMessage();
	}

	public static void makeWeddingCake(int tiers, String flavor){
		WeddingCake cake = new WeddingCake(tiers, flavor);
		cake.showMessage();
	}

	public static void makeCake(String flavor){
		Cake cake = new Cake(flavor);
		cake.showMessage();
	}

}
