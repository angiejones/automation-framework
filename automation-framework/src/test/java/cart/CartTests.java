package cart;

import org.junit.Assert;
import org.junit.Test;

import pages.CartPage;
import services.CartServices;
import utils.BaseTests;

public class CartTests extends BaseTests{

	@Test
	public void testIncreaseQuantity(){
		String productName = "Apple TV";
		CartServices.addProductToCart(productName);

		CartPage cartPage = homePage.clickCart();
		cartPage = cartPage.updateQuantity(productName, 3);

		Assert.assertEquals(productName + "'s price", "$80.00", cartPage.getPrice(productName));
		Assert.assertEquals(productName + "'s total", "$240.00", cartPage.getTotal(productName));
	}
}
