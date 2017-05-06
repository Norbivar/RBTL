package hu.adatb.rbtl.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import hu.adatb.rbtl.model.beans.Book;
import hu.adatb.rbtl.model.beans.Product;

public class ShopListScreen extends JPanel implements MouseListener{

	private BookshopGUI gui;
	private JPanel productpanel, shoppanel, upperpanel;
	private JScrollPane shopScrollPanel;
	
	private JLabel isbn_label, title_label, oldalszam_label, kotes_label, meret_label, ar_label, kiado_label, kiadaseve_label, szerzo_label;
	private JLabel isbn, title, oldalszam, kotes, meret, ar, kiado, kiadaseve, szerzo;
	private JLabel back_arrow;
	
	public ShopListScreen(BookshopGUI gui, Product product){
		super();
		this.gui = gui;
		this.setLayout(new GridLayout(0, 1));
		
		
		upperpanel = new JPanel();
		upperpanel.setLayout(new FlowLayout());
		
		productpanel = new JPanel();
		productpanel.setLayout(new GridLayout(0, 2));
		
		Book book = gui.getController().getBookByID((product).getId());
		
		isbn_label = new JLabel(Labels.PRODUCT_ISBN);
		title_label = new JLabel(Labels.PRODUCT_TITLE);
		oldalszam_label = new JLabel(Labels.PRODUCT_OLDALSZAM);
		kotes_label = new JLabel(Labels.PRODUCT_KOTES);
		meret_label = new JLabel(Labels.PRODUCT_MERET);
		ar_label = new JLabel(Labels.PRODUCT_AR);
		kiado_label = new JLabel(Labels.PRODUCT_KIADO);
		kiadaseve_label = new JLabel(Labels.PRODUCT_KIADASEVE);
		szerzo_label = new JLabel(Labels.PRODUCT_SZERZO);
		
		isbn = new JLabel(book.getIsbn());
		title = new JLabel(book.getTitle());
		oldalszam = new JLabel(String.valueOf(book.getNumOfPages()));
		kotes = new JLabel(book.getKotesNev());
		meret = new JLabel(book.getSize());
		ar = new JLabel(String.valueOf(book.getPrice()));
		kiado = new JLabel(book.getPublisher());
		kiadaseve = new JLabel(String.valueOf(book.getPublishYear()));
		szerzo = new JLabel(book.getAuthor());			
		
		productpanel.add(isbn_label);
		productpanel.add(isbn);
		
		productpanel.add(title_label);
		productpanel.add(title);
		
		productpanel.add(szerzo_label);
		productpanel.add(szerzo);
		
		productpanel.add(kiado_label);
		productpanel.add(kiado);
		
		productpanel.add(kiadaseve_label);
		productpanel.add(kiadaseve);
		
		productpanel.add(oldalszam_label);
		productpanel.add(oldalszam);
		
		productpanel.add(kotes_label);
		productpanel.add(kotes);
		
		productpanel.add(meret_label);
		productpanel.add(meret);
		
		productpanel.add(ar_label);
		productpanel.add(ar);
		
		
		back_arrow = new JLabel(new ImageIcon(this.getClass().getResource("/images/back_arrow.png")));
		back_arrow.addMouseListener(this);
		
		upperpanel.add(back_arrow);		
		upperpanel.add(productpanel);
		add(upperpanel);
		
		shoppanel = new JPanel();
		shoppanel.setLayout(new GridLayout(0, 1));
		
		List<String> shopIDList = gui.getController().getShopOfBook(book);
		List<String> shopAddressAndNameList = new ArrayList<String>();
		List<String> result = new ArrayList<String>();
		
		for(int i = 0; i<shopIDList.size(); i++){
			result.add(gui.getController().getShopAddressAndNameByID(Integer.parseInt(shopIDList.get(i))));
		}
		
		/*for(int i = 0; i<shopAddressAndNameList.size(); i++){
			result.add(shopAddressAndNameList.get(i));
		}*/
		
		for(int i = 0; i<result.size();i++){
			shoppanel.add(new JLabel(result.get(i)));
		}
		
		shopScrollPanel = new JScrollPane(shoppanel);
		
		add(shopScrollPanel);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == back_arrow){
			gui.getContentPane().remove(getComponentCount()-1);
			gui.getContentPane().getComponent(getComponentCount()-2).setVisible(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
