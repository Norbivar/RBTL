package hu.adatb.rbtl.view.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import hu.adatb.rbtl.view.BookshopGUI;
import hu.adatb.rbtl.view.Labels;

public class UserEditProfileDialog extends JDialog implements ActionListener{

	private BookshopGUI gui;
	private JButton cancelbutton, okbutton;
	private JPanel buttonpanel;

	public UserEditProfileDialog(BookshopGUI gui){
		super();
		this.gui = gui;
		setLayout(new BorderLayout());
		setTitle(Labels.USER_SIGNUP_TITLE);
		setSize(400, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		
		buttonpanel = new JPanel(new FlowLayout());
		okbutton = new JButton(Labels.USER_SIGNUP_OKBUTTON);
		cancelbutton = new JButton(Labels.USER_SIGNUP_CANCELBUTTON);
		
		cancelbutton.addActionListener(this);
		okbutton.addActionListener(this);
		
		buttonpanel.add(okbutton);
		buttonpanel.add(cancelbutton);
		
		add(buttonpanel, BorderLayout.SOUTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
