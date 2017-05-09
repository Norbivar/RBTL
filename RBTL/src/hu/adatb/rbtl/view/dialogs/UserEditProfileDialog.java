package hu.adatb.rbtl.view.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hu.adatb.rbtl.view.BookshopGUI;
import hu.adatb.rbtl.view.Labels;
import hu.adatb.rbtl.view.WelcomeScreen;

public class UserEditProfileDialog extends JDialog implements ActionListener{

	private BookshopGUI gui;
	private JButton cancelbutton, okbutton;
	private JPanel buttonpanel, labelpanel;
	private JLabel enterpassword;

	public UserEditProfileDialog(BookshopGUI gui){
		super();
		this.gui = gui;
		setLayout(new BorderLayout());
		setTitle(Labels.USER_EDIT_DIALOG_TITLE);
		setSize(400, 200);
		setLocationRelativeTo(null);
		setModal(true);
		setResizable(false);
		
		labelpanel = new JPanel(new FlowLayout());
		enterpassword = new JLabel(Labels.USER_EDIT_ENTER_CURRENT_PASSWORD);
		
		labelpanel.add(enterpassword);
		add(labelpanel, BorderLayout.CENTER);
		
		buttonpanel = new JPanel(new FlowLayout());
		okbutton = new JButton(Labels.USER_EDIT_DIALOG_OKBUTTON);
		cancelbutton = new JButton(Labels.USER_EDIT_DIALOG_CANCELBUTTON);
		
		cancelbutton.addActionListener(this);
		okbutton.addActionListener(this);
		
		buttonpanel.add(okbutton);
		buttonpanel.add(cancelbutton);
		
		add(buttonpanel, BorderLayout.SOUTH);
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == okbutton){
			dispose();
		}else if(e.getSource() == cancelbutton){
			dispose();
			gui.getContentPane().removeAll();
			gui.getContentPane().add(new WelcomeScreen());
			gui.revalidate();
		}
		
		
	}
	
}
