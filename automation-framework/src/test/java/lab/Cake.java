package lab;

import javax.swing.JOptionPane;

public class Cake {

	private String flavor;

	public Cake(String flavor){
		this.flavor = flavor;
	}

	public String getFlavor(){
		return flavor;
	}

	public void setFlavor(String flavor){
		this.flavor = flavor;
	}

	public void showMessage(){
		String message = String.format("Thank you for your purchase of the %s cake", flavor);
		JOptionPane.showMessageDialog(null, message);
	}
}
