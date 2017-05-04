package hu.adatb.rbtl.view;

import javax.swing.JButton;

import hu.adatb.rbtl.model.beans.Product;

public class ProductDetailsButton extends JButton{

	private Product product;

	public ProductDetailsButton(String string) {
		super(string);
	}
	
	public ProductDetailsButton() {
		// TODO Auto-generated constructor stub
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}