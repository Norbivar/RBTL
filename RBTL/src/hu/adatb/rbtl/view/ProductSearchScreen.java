package hu.adatb.rbtl.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import hu.adatb.rbtl.model.beans.Book;
import hu.adatb.rbtl.model.beans.Film;

/**
 * The panel what is displayed when the user is browsing products.
 * @author Attila Uhrin
 *
 */
public class ProductSearchScreen extends JPanel implements ActionListener {

	private BookshopGUI gui;
	private JPanel gridpanel, buttonpanel;
	private JLabel panel_title, label_category, label_title, label_isbn, label_pages, label_kotes, label_size, label_price, label_publisher, label_publishdate;
	private JComboBox<String> combobox_category, combobox_kotes, combobox_publisher;
	private String[] available_categories, available_bindings, available_publishers;
	private JTextField input_title, input_isbn, input_size, input_publishdate, input_publisher;
	private JSpinner spinner_pages, spinner_price, spinner_publishyear;
	private JButton okbutton, cancelbutton;
	
	public ProductSearchScreen(BookshopGUI gui) {
		super();
		//this.contentPane = contentPane;	//in this way we can access the main contentPane and repaint the gui when the user selects another menu
		this.gui = gui;		//in this way we can access the main contentPane and repaint the gui when the user selects another menu
		setLayout(new BorderLayout());
		
		panel_title = new JLabel(Labels.SEARCH_PRODUCTS_PANE_TITLE, SwingConstants.CENTER);
		add(panel_title, BorderLayout.NORTH);
		
		/*----------------------------Grid panel----------------------------*/
		gridpanel = new JPanel(new GridLayout(9, 2));
		
		label_category = new JLabel(Labels.SEARCH_PRODUCTS_CATEGORY);
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
		
		combobox_category = new JComboBox<>(available_categories);
		
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
		
		gridpanel.add(label_category);
		gridpanel.add(combobox_category);
		
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

		add(gridpanel, BorderLayout.CENTER);
		/*-------------------------------------------------------------------*/
		
		/*-----------Button panel containing ok and cancel buttons-----------*/
		buttonpanel = new JPanel(new FlowLayout());
		okbutton = new JButton(Labels.SEARCH_PRODUCTS_OKBUTTON);
		cancelbutton = new JButton(Labels.SEARCH_PRODUCTS_CANCELBUTTON);
		
		cancelbutton.addActionListener(this);
		okbutton.addActionListener(this);
		
		buttonpanel.add(okbutton);
		buttonpanel.add(cancelbutton);
		
		add(buttonpanel, BorderLayout.SOUTH);
		
		/*--------------------------------------------------------------------*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelbutton){			//The cancel button was clicked
			gui.getContentPane().removeAll();
			gui.getContentPane().add(new WelcomeScreen());
			gui.getContentPane().revalidate();
		} else if (e.getSource() == okbutton){		//The ok button was clicked
			//TODO implement query
			gui.getContentPane().removeAll();
			if(combobox_category.getSelectedItem().toString().equals("Book")){
				Book book = new Book();
				book.setIsbn(input_isbn.getText());
				book.setTitle(input_title.getText());
				book.setNumOfPages((Integer)spinner_pages.getValue());
				book.setKotesNev(String.valueOf(combobox_kotes.getSelectedItem()));
				book.setSize(input_size.getText());
				book.setPrice((Integer)spinner_price.getValue());
				book.setPublisher(input_publisher.getText());
				book.setPublishYear((Integer)spinner_publishyear.getValue());
				
				gui.getContentPane().add(new ProductSearchResultScreen(gui, gui.getController().searchBook(book)));
			} else if (combobox_category.getSelectedItem().toString().equals("Film")){
				Film film = new Film();
				film.setTitle(input_title.getText());
				
				gui.getContentPane().add(new ProductSearchResultScreen(gui, gui.getController().searchFilm(film)));
			}			
			gui.getContentPane().revalidate();
		}
	}

}
