package hu.adatb.rbtl.view;

import javax.swing.JButton;

import hu.adatb.rbtl.model.beans.Product;

public class ProductDetailsButton extends JButton{

	private Product product;

	public ProductDetailsButton(String string) {
		super(string);
	}
	
	public ProductDetailsButton(String string, Product product){
		super(string);
		this.product = product;
	}
	
	public ProductDetailsButton() {
		
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
