package pages;

import org.openqa.selenium.By;

public class ProductPage extends Page {

	By title	= By.className("prodtitle");

	public String getTitle(){
		return webDriver.findElement(title).getText();
	}
}
