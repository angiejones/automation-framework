package cucumber.stepdefs;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ProductPage;

public class SearchStepDefs {

	BaseStepDefs stepData;

	public SearchStepDefs(BaseStepDefs stepData) {
		this.stepData = stepData;
	}

	@When("I search for the product")
	public void search(){
		stepData.searchResults = stepData.currentPage.search(stepData.productName);
	}

	@When("^I click the product$")
	public void clickProduct(){
		stepData.currentPage = stepData.searchResults.clickProduct(stepData.productName);
	}

	@When("^I add the product to the cart$")
	public void clickAddProductToCart(){
		stepData.currentPage = stepData.searchResults.addProductToCart(stepData.productName);
	}

	@Then("^(\\d+) products? should be returned$")
	public void verifyNumberOfProductsListed(int expectedCount){
		Assert.assertTrue(stepData.productName + "is listed", stepData.searchResults.isProductListed(stepData.productName));
		Assert.assertEquals("Number of products listed", expectedCount, stepData.searchResults.getNumberOfListedProducts());
	}

	@Then("^its original price should be (.*)$")
	public void setOriginalPrice(String price){
		Assert.assertEquals("Original price", price, stepData.searchResults.getOriginalPrice(stepData.productName));

	}

	@Then("^its current price should be (.*)$")
	public void verifyCurrentPrice(String price){
		Assert.assertEquals("Current price", price, stepData.searchResults.getCurrentPrice(stepData.productName));
	}

	@Then("^I should be taken to the product page$")
	public void verifyProductPage(){
		ProductPage productPage = (ProductPage)stepData.currentPage;
		Assert.assertEquals("Page title",stepData. productName, productPage.getTitle());
	}

}
