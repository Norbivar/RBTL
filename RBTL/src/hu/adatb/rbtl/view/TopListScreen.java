package hu.adatb.rbtl.view;

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

public class TopListScreen extends JPanel implements ActionListener {
	private JPanel buttonpanel;
	private JButton weekly_toplist_button, monthly_toplist_button, genre_toplist_button, back_button;
	
	private JPanel resultpanel;
	private List<Book> result = new ArrayList<Book>();
	private JScrollPane scrollpane;
	
	private BookshopGUI gui;
	
	public TopListScreen(BookshopGUI gui){
		super();
		this.gui = gui;
		
		gui.setTitle(Labels.TOP_LIST_TITLE);
		gui.setLayout(new GridLayout(0, 1));
		buttonpanel = new JPanel();
		buttonpanel.setLayout(new FlowLayout());
		
		weekly_toplist_button = new JButton(Labels.TOP_LIST_WEEKLY);
		monthly_toplist_button = new JButton(Labels.TOP_LIST_MONTHLY);
		genre_toplist_button = new JButton(Labels.TOP_LIST_BY_GENRE);
		back_button = new JButton(Labels.TOP_LIST_BACK_BUTTON);
		
		weekly_toplist_button.addActionListener(this);
		monthly_toplist_button.addActionListener(this);
		genre_toplist_button.addActionListener(this);
		back_button.addActionListener(this);
		
		buttonpanel.add(weekly_toplist_button);
		buttonpanel.add(monthly_toplist_button);
		buttonpanel.add(genre_toplist_button);
		buttonpanel.add(back_button);
		
		add(buttonpanel);
		
		resultpanel = new JPanel();
		resultpanel.setLayout(new GridLayout(0, 1));
		
		scrollpane = new JScrollPane(resultpanel);
		scrollpane.getVerticalScrollBar().setUnitIncrement(16);
		add(scrollpane);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		resultpanel.removeAll();
		if(e.getSource() == back_button){
			gui.getContentPane().removeAll();
			gui.getContentPane().add(new WelcomeScreen());
			gui.getContentPane().revalidate();
		}else if(e.getSource()  == weekly_toplist_button){
			result = gui.getController().getBooksFromWeeklyTopList();
			for(int i = 0; i<result.size(); i++){
				resultpanel.add(gui.displayProductInList(result.get(i)));
			}
		}else if(e.getSource() == monthly_toplist_button){
			result = gui.getController().getBooksFromMonthlyTopList();
			for(int i = 0; i<result.size(); i++){
				resultpanel.add(gui.displayProductInList(result.get(i)));
			}
		}else if(e.getSource() == genre_toplist_button){
			
		}
		resultpanel.revalidate();
		scrollpane.revalidate();
	}

	
}
