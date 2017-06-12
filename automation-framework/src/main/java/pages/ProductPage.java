package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends Page {

	public ProductPage(WebDriver webDriver){
		super(webDriver);
	}

	private By title	= By.className("prodtitle");

	public String getTitle(){
		return webDriver.findElement(title).getText();
	}
}
