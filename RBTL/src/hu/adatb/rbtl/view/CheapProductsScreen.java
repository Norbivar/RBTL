package hu.adatb.rbtl.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import hu.adatb.rbtl.model.beans.Book;

//TODO * „Olcsó könyvek” kilistázása árkategóriánként.
public class CheapProductsScreen extends JPanel implements ActionListener{

	private JPanel buttonpanel;
	//<10, 10-20, 20-30, 30-40, 40-50, 50<
	private JButton label_10, label_20, label_30, label_40, label_50, label_more;
	
	private JPanel resultpanel;
	private List<Book> result = new ArrayList<Book>();
	private JScrollPane scrollpane;
	
	private BookshopGUI gui;
	
	
	public CheapProductsScreen(BookshopGUI gui){
		super();
		this.gui = gui;
		
		this.setLayout(new BorderLayout());
		
		buttonpanel = new JPanel();
		buttonpanel.setLayout(new FlowLayout());
		
		label_10 = new JButton(Labels.CHEAPBOOK_10);
		label_20 = new JButton(Labels.CHEAPBOOK_20);
		label_30 = new JButton(Labels.CHEAPBOOK_30);
		label_40 = new JButton(Labels.CHEAPBOOK_40);
		label_50 = new JButton(Labels.CHEAPBOOK_50);
		label_more = new JButton(Labels.CHEAPBOOK_MORE);
		
		label_10.addActionListener(this);
		label_20.addActionListener(this);
		label_30.addActionListener(this);
		label_40.addActionListener(this);
		label_50.addActionListener(this);
		label_more.addActionListener(this);
		
		buttonpanel.add(label_10);
		buttonpanel.add(label_20);
		buttonpanel.add(label_30);
		buttonpanel.add(label_40);
		buttonpanel.add(label_50);
		buttonpanel.add(label_more);
		
		add(buttonpanel, BorderLayout.NORTH);
		
		resultpanel = new JPanel();
		resultpanel.setLayout(new GridLayout(0, 1));
		
		scrollpane = new JScrollPane(resultpanel);
		scrollpane.getVerticalScrollBar().setUnitIncrement(16);
		add(scrollpane, BorderLayout.CENTER);		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		resultpanel.removeAll();
		if(e.getSource() == label_10){
			result = gui.getController().getBooksByPriceRange(0, 9);
			for(int i = 0; i<result.size(); i++){
				resultpanel.add(gui.displayProductInList(result.get(i)));
			}
		} else if (e.getSource() == label_20){
			result = gui.getController().getBooksByPriceRange(10, 20);
			for(int i = 0; i<result.size(); i++){
				resultpanel.add(gui.displayProductInList(result.get(i)));
			}
		} else if (e.getSource() == label_30){
			result = gui.getController().getBooksByPriceRange(20, 30);
			for(int i = 0; i<result.size(); i++){
				resultpanel.add(gui.displayProductInList(result.get(i)));
			}
		} else if (e.getSource() == label_40){
			result = gui.getController().getBooksByPriceRange(30, 40);
			for(int i = 0; i<result.size(); i++){
				resultpanel.add(gui.displayProductInList(result.get(i)));
			}
		} else if (e.getSource() == label_50){
			result = gui.getController().getBooksByPriceRange(40, 50);
			for(int i = 0; i<result.size(); i++){
				resultpanel.add(gui.displayProductInList(result.get(i)));
			}
		} else if (e.getSource() == label_more){
			result = gui.getController().getBooksByPriceRange(50, 300);
			for(int i = 0; i<result.size(); i++){
				resultpanel.add(gui.displayProductInList(result.get(i)));
			}
		} 
		resultpanel.revalidate();
		scrollpane.revalidate();
	}
}
