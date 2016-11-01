package lab;

import javax.swing.JOptionPane;

public class WeddingCake extends Cake {

	private int tiers;

	public WeddingCake(int tiers, String flavor){
		super(flavor);
		this.tiers = tiers;
	}

	public int getTiers() {
		return tiers;
	}

	public void setTiers(int tiers) {
		this.tiers = tiers;
	}

	@Override
	public void showMessage(){
		String message = String.format("Thank you for your purchase of the %s wedding cake with %d tiers", getFlavor(), tiers);
		JOptionPane.showMessageDialog(null, message);
	}
}
