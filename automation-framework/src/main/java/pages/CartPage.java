package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends Page {

	private WebElement cart;

	private By cartTable					= By.className("checkout_cart");
	private By productPrice					= By.xpath(".//td[not(@class)]/span[@class='pricedisplay']");
	private By productQuantity				= By.name("quantity");
	private 	By productRow					= By.xpath(".//tr[contains(@class,'product_row')]");
	private By productTitle					= By.xpath(".//td[contains(@class, 'wpsc_product_name')]");
	private By productTotal					= By.xpath(".//td[contains(@class,'wpsc_product_price')]/span[@class='pricedisplay']");
	private By productUpdateQuantityButton	= By.xpath(".//input[@type='submit' and @value='Update']");


	public CartPage(WebDriver webDriver){
		super(webDriver);
		cart = findCartTable();
	}

	public boolean isProductInCart(String productName){
		return findProduct(productName) != null;
	}

	public CartPage updateQuantity(String productName, int quantity) {
		setQuantity(productName, quantity);
		WebElement product = findProduct(productName, true);
		product.findElement(productUpdateQuantityButton).click();
		return new CartPage(webDriver);
	}

	public void setQuantity(String productName, int quantity){
		WebElement product = findProduct(productName, true);
		WebElement field = product.findElement(productQuantity);
		field.clear();
		field.sendKeys(String.valueOf(quantity));
	}

	public String getPrice(String productName) {
		WebElement product = findProduct(productName, true);
		return product.findElement(productPrice).getText();
	}

	public String getTotal(String productName) {
		WebElement product = findProduct(productName, true);
		return product.findElement(productTotal).getText();
	}

	private WebElement findProduct(String productName, boolean failIfNotFound){
		List<WebElement> products = cart.findElements(productRow);
		for(WebElement product : products){
			if(product.findElement(productTitle).getText().equalsIgnoreCase(productName)){
				return product;
			}
		}

		if(failIfNotFound){
			throw new IllegalStateException("Product " + productName + " is not in the cart");
		}

		return null;
	}

	private WebElement findProduct(String productName){
		return findProduct(productName, false);
	}

	private WebElement findCartTable(){
		WebDriverWait wait = new WebDriverWait(webDriver, 5);
		return wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(cartTable)));
	}

	public int getNumberOfProducts(){
		return findAllProducts().size();
	}

	private List<WebElement> findAllProducts(){
		return webDriver.findElements(productRow);
	}


}
