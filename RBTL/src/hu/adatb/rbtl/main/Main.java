package hu.adatb.rbtl.main;

import java.awt.EventQueue;

import javax.swing.SwingUtilities;

import hu.adatb.rbtl.controller.BookshopController;
import hu.adatb.rbtl.view.BookshopGUI;

public class Main {

	public static void main(String[] args) {
		BookshopController controller = new BookshopController();	
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new BookshopGUI(controller);
            }
       });
	}
	
}
