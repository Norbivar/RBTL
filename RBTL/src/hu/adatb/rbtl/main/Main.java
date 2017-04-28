package hu.adatb.rbtl.main;

import hu.adatb.rbtl.controller.BookshopController;
import hu.adatb.rbtl.view.BookshopGUI;

public class Main {

	public static void main(String[] args) {
		BookshopController controller = new BookshopController();
		new BookshopGUI(controller);
	}
	
}
