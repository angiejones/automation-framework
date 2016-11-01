package lab;

import javax.swing.JOptionPane;

public class BirthdayCake extends Cake {

	private int candles;

	public BirthdayCake(){
		super("White");
	}

	public int getCandles() {
		return candles;
	}

	public void setCandles(int candles) {
		this.candles = candles;
	}

	@Override
	public void showMessage(){
		String message = String.format("Thank you for your purchase of the %s birthday cake with %d candles", getFlavor(), candles);
		JOptionPane.showMessageDialog(null, message);
	}
}
