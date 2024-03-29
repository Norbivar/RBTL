package hu.adatb.rbtl.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;



import hu.adatb.rbtl.model.beans.Book;

public class TopListScreen extends JPanel implements ActionListener, ItemListener {
	private JPanel buttonpanel;
	private JButton weekly_toplist_button, monthly_toplist_button, back_button, list_genre;
	private JPanel resultpanel;
	private List<Book> result = new ArrayList<Book>();
	private JScrollPane scrollpane, genre_toplist_scroll;
	private JComboBox genre_combobox;
	private GridLayout layout = new GridLayout(0,1);
	private BookshopGUI gui;
	
	public TopListScreen(BookshopGUI gui){
		super();
		this.gui = gui;
		
		gui.setTitle(Labels.TOP_LIST_TITLE);
		//gui.setLayout(new GridLayout(0, 1));
		buttonpanel = new JPanel();
		buttonpanel.setLayout(new FlowLayout());
		
		weekly_toplist_button = new JButton(Labels.TOP_LIST_WEEKLY);
		monthly_toplist_button = new JButton(Labels.TOP_LIST_MONTHLY);
		genre_toplist_scroll = new JScrollPane();
		back_button = new JButton(Labels.TOP_LIST_BACK_BUTTON);
		list_genre = new JButton(Labels.TOP_LIST_BY_GENRE);
		
		weekly_toplist_button.addActionListener(this);
		monthly_toplist_button.addActionListener(this);
		back_button.addActionListener(this);
		list_genre.addActionListener(this);
		
		
		
		buttonpanel.add(weekly_toplist_button);
		buttonpanel.add(monthly_toplist_button);
		buttonpanel.add(genre_toplist_scroll);
		buttonpanel.add(list_genre);
	
		add(buttonpanel);
		
		genre_combobox = new JComboBox<String>(this.gui.getController().getAllGenre());
		add(genre_combobox);
		
		buttonpanel.add(back_button);
		
		resultpanel = new JPanel();
		resultpanel.setLayout(layout);
		
		//resultpanel.setBackground(Color.RED);
		
		scrollpane = new JScrollPane(resultpanel);

		scrollpane.getVerticalScrollBar().setUnitIncrement(16);
		gui.add(scrollpane, BorderLayout.CENTER);
		scrollpane.setBounds(5, 40, 800, 800);
	    scrollpane.setBackground(Color.red);
	    
	    layout.setHgap(10);
	    layout.setVgap(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		resultpanel.removeAll();
		int j=2;
		if(e.getSource() == back_button){
			gui.getContentPane().removeAll();
			gui.getContentPane().add(new WelcomeScreen());
			gui.getContentPane().revalidate();
			
			
		}else if(e.getSource()  == weekly_toplist_button){
			result =gui.getController().getBooksFromWeeklyTopList();
			for(int i = 0; i<result.size(); i++){
				resultpanel.add(gui.displayProductInList(result.get(i)));
			}
			
		}else if(e.getSource() == monthly_toplist_button){
			result = gui.getController().getBooksFromMonthlyTopList();
			for(int i = 0; i<result.size(); i++){
				resultpanel.add(gui.displayProductInList(result.get(i)));
			}
		}else if(e.getSource() == list_genre){
			String genre = String.valueOf(genre_combobox.getSelectedItem().toString());
			System.out.println(genre);
			result = gui.getController().getBooksByGenreTopList(genre);
			for(int i = 0; i<result.size();i++){
				resultpanel.add(gui.displayProductInList(result.get(i)));
			}
		}
		resultpanel.revalidate();
		scrollpane.revalidate();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED){
			
		}
		
	}

}
