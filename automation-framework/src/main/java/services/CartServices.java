package services;

import pages.Page;
import utils.Links;
import utils.Products;

public class CartServices {

	public static void addProductToCart(String productName){
		int productId = Products.getProductId(productName);
		String postUrl = String.format("%s?wpsc_ajax_action=add_to_cart&product_id=%d", Links.HOME, productId);
		new Page().goTo(postUrl);
	}
}
