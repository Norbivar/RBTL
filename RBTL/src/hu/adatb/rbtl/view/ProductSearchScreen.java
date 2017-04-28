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
	private JTextField input_title, input_isbn, input_size, input_publishdate;
	private JSpinner spinner_pages, spinner_price;
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
		
		//TODO k�t�seket adatb�zisb�l lek�rdezni
		available_bindings = new String[5];
		available_bindings[0] = "Paperback";
		available_bindings[1] = "Leatherback";
		available_bindings[2] = "Soft Paperback";
		available_bindings[3] = "Plasticback";
		
		combobox_kotes = new JComboBox<>(available_bindings);
		
		//TODO kiad�kat adatb�zisb�l lek�rdezni
		available_publishers = new String[3];
		available_publishers[0] = "Publisher1";
		available_publishers[1] = "Publisher2";
		available_publishers[2] = "Publisher3";
		
		combobox_publisher = new JComboBox<>(available_publishers);
		
		input_title = new JTextField();
		input_isbn = new JTextField();
		input_size = new JTextField();
		input_publishdate = new JTextField();
		
		spinner_pages = new JSpinner();
		spinner_price = new JSpinner();
		
		
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
		gridpanel.add(combobox_publisher);
		
		gridpanel.add(label_publishdate);
		gridpanel.add(input_publishdate);
		
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
		}
	}

}
