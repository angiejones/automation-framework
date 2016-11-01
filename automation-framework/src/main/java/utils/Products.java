package utils;

public enum Products {

	APPLE_TV("Apple TV", 89);

	private int productId;
	private String displayName;

	private Products(String displayName, int productId) {
		this.displayName = displayName;
		this.productId = productId;
	}

	public String getDisplayName(){
		return displayName;
	}

	public int getProductId(){
		return productId;
	}

	public static int getProductId(String displayName){
		for(Products product : Products.values()){
			if(product.getDisplayName().equals(displayName)){
				return product.getProductId();
			}
		}

		return -1;
	}
}
