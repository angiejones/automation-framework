package search;

import org.junit.Assert;
import org.junit.Test;

import utils.BaseTests;
import widgets.SearchResults;

public class SearchTests extends BaseTests{

	@Test
	public void testSearchForDiscountedProduct(){

		String productName = "Apple TV";
		SearchResults searchResults = homePage.search(productName);
		Assert.assertTrue(productName + " is in search results", searchResults.isProductListed(productName));
		Assert.assertEquals(productName + " original price", "$89.00", searchResults.getOriginalPrice(productName));
		Assert.assertEquals(productName + " current price", "$80.00", searchResults.getCurrentPrice(productName));
		Assert.assertEquals("Number of search results", 1, searchResults.getNumberOfListedProducts());
	}
}
