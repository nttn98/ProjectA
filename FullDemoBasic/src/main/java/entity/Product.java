package entity;

import java.io.Serializable;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productID;
	private String productName;
	private String title;
	private float price;
	private int quantity;

	public Product(String productID, String productName, String title, float price, int quantity) {
		this.productID = productID;
		this.productName = productName;
		this.title = title;
		this.price = price;
		this.quantity = quantity;

	}



	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductID() {
		return productID;
	}

	public String getProductInfor() {
		String str = this.productID;
		str += "," + this.productName;
		str += "," + this.title;
		str += "," + this.price;
		str += "," + this.quantity;

		return str;
	}

}
