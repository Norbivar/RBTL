package hu.adatb.rbtl.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import hu.adatb.rbtl.model.beans.Book;
import hu.adatb.rbtl.model.beans.Product;

public class ShopByBookScreen extends JPanel implements ActionListener{

	private BookshopGUI gui;
	private JPanel gridpanel, buttonpanel, searchpanel, resultpanel;
	private JScrollPane resultScrollPanel;
	
	private JLabel label_title, label_isbn, label_pages, label_kotes, label_size, label_price, label_publisher, label_publishdate;
	private JComboBox<String> combobox_kotes, combobox_publisher;
	private String[] available_categories, available_bindings, available_publishers;
	private JTextField input_title, input_isbn, input_size, input_publishdate, input_publisher;
	private JSpinner spinner_pages, spinner_price, spinner_publishyear;
	private JButton okbutton, cancelbutton;
	
	public ShopByBookScreen(BookshopGUI gui){
		this.gui = gui;
		setLayout(new GridLayout(2, 1));
		
		searchpanel = new JPanel();
		searchpanel.setLayout(new BorderLayout());
		
		/*----------------------------Grid panel----------------------------*/
		gridpanel = new JPanel(new GridLayout(8, 2));
		
		label_title = new JLabel(Labels.SEARCH_PRODUCTS_TITLE);
		label_isbn = new JLabel(Labels.SEARCH_PRODUCTS_ISBN);
		label_pages = new JLabel(Labels.SEARCH_PRODUCTS_PAGES);
		label_kotes = new JLabel(Labels.SEARCH_PRODUCTS_BINDING);
		label_size = new JLabel(Labels.SEARCH_PRODUCTS_SIZE);
		label_price = new JLabel(Labels.SEARCH_PRODUCTS_PRICE);
		label_publisher = new JLabel(Labels.SEARCH_PDORUCTS_PUBLISHER);
		label_publishdate = new JLabel(Labels.SEARCH_PRODUCTS_DATE_OF_PUBLISHING);
		
		available_categories = new String[4];
		available_categories[0] = "Book";
		available_categories[1] = "Film";
		available_categories[2] = "Music";
		available_categories[3] = "E-book";
	
		
		available_bindings = this.gui.getController().getAllBindings();
		
		combobox_kotes = new JComboBox<>(available_bindings);
		
		/*available_publishers = gui.getController().getAllPublishers();		
		combobox_publisher = new JComboBox<>(available_publishers);*/
		
		input_title = new JTextField();
		input_isbn = new JTextField();
		input_size = new JTextField();
		input_publisher = new JTextField();
		//input_publishdate = new JTextField();
		
		spinner_pages = new JSpinner();
		spinner_price = new JSpinner();
		spinner_publishyear = new JSpinner();
		
		gridpanel.add(label_isbn);
		gridpanel.add(input_isbn);
		
		gridpanel.add(label_title);
		gridpanel.add(input_title);
		
		gridpanel.add(label_pages);
		gridpanel.add(spinner_pages);
		
		gridpanel.add(label_kotes);
		gridpanel.add(combobox_kotes);
		
		gridpanel.add(label_size);
		gridpanel.add(input_size);
		
		gridpanel.add(label_price);
		gridpanel.add(spinner_price);
		
		gridpanel.add(label_publisher);
		gridpanel.add(input_publisher);
		
		gridpanel.add(label_publishdate);
		gridpanel.add(spinner_publishyear);

		searchpanel.add(gridpanel, BorderLayout.CENTER);
		/*-------------------------------------------------------------------*/
		
		/*-----------Button panel containing ok and cancel buttons-----------*/
		buttonpanel = new JPanel(new FlowLayout());
		okbutton = new JButton(Labels.SEARCH_PRODUCTS_OKBUTTON);
		cancelbutton = new JButton(Labels.SEARCH_PRODUCTS_CANCELBUTTON);
		
		cancelbutton.addActionListener(this);
		okbutton.addActionListener(this);
		
		buttonpanel.add(okbutton);
		buttonpanel.add(cancelbutton);
		
		searchpanel.add(buttonpanel, BorderLayout.SOUTH);
		
		/*--------------------------------------------------------------------*/
		
		add(searchpanel);
		
		resultpanel = new JPanel();
		resultpanel.setLayout(new GridLayout(0, 1));
		
		resultScrollPanel = new JScrollPane(resultpanel);
		resultScrollPanel.getVerticalScrollBar().setUnitIncrement(16);
		add(resultScrollPanel);	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelbutton){			//The cancel button was clicked
			gui.getContentPane().removeAll();
			gui.getContentPane().add(new WelcomeScreen());
			gui.getContentPane().revalidate();
		} else if (e.getSource() == okbutton){		//The ok button was clicked
			resultpanel.removeAll();
			Book book = new Book();
			
			book.setIsbn(input_isbn.getText());
			book.setTitle(input_title.getText());
			book.setNumOfPages((Integer) spinner_pages.getValue());
			book.setKotesNev(String.valueOf(combobox_kotes.getSelectedItem()));
			book.setSize(input_size.getText());
			book.setPrice((Integer) spinner_price.getValue());
			book.setPublisher(input_publisher.getText());
			book.setPublishYear((Integer) spinner_publishyear.getValue());
			
			List<Product> result = gui.getController().searchBook(book);
			
			for(int i = 0; i<result.size(); i++){
				resultpanel.add(gui.displayProductInShopSearch((result.get(i))));
			}
			
			resultpanel.revalidate();
			resultScrollPanel.revalidate();
		}
	}
}
