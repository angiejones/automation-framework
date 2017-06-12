package services;

import org.openqa.selenium.WebDriver;

import pages.Page;
import utils.Links;
import utils.Products;

public class CartServices {

	public static void addProductToCart(String productName, WebDriver webDriver){
		int productId = Products.getProductId(productName);
		String postUrl = String.format("%s?wpsc_ajax_action=add_to_cart&product_id=%d", Links.HOME, productId);
		new Page(webDriver).goTo(postUrl);
	}
}
