package hu.adatb.rbtl.view.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import hu.adatb.rbtl.model.beans.User;
import hu.adatb.rbtl.view.BookshopGUI;
import hu.adatb.rbtl.view.Labels;

/**
 * The log in dialog where users can log in to their accounts stored in the database.
 * @author Attila Uhrin
 *
 */
public class UserLoginDialog extends JDialog implements ActionListener{

	private BookshopGUI gui;
	private JPanel gridpanel, buttonpanel;
	private JLabel label_email, label_password;
	private JTextField input_email;
	private JPasswordField input_password;
	private JButton okbutton, cancelbutton;
	
	public UserLoginDialog(BookshopGUI gui) {
		super();
		this.gui = gui;
		setLayout(new BorderLayout());
		setTitle(Labels.USER_LOGIN_TITLE);
		setSize(400, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		
		/*-----------Grid panel containing the labels and input fields-----------*/
		gridpanel = new JPanel();
		gridpanel.setLayout(new GridLayout(2, 2, 0, 10));
		
		label_email = new JLabel(Labels.USER_LOGIN_EMAIL);
		label_password = new JLabel(Labels.USER_LOGIN_PASSWORD);
		
		input_email = new JTextField();
		input_password = new JPasswordField();
		
		gridpanel.add(label_email);
		gridpanel.add(input_email);
		
		gridpanel.add(label_password);
		gridpanel.add(input_password);
		
		add(gridpanel, BorderLayout.CENTER);
		/*-------------------------------------------------------------------*/
		
		/*-----------Button panel containing OK and cancel buttons-----------*/
		buttonpanel = new JPanel(new FlowLayout());
		okbutton = new JButton(Labels.USER_LOGIN_OKBUTTON);
		cancelbutton = new JButton(Labels.USER_LOGIN_CANCELBUTTON);
		
		cancelbutton.addActionListener(this);
		okbutton.addActionListener(this);
		
		buttonpanel.add(okbutton);
		buttonpanel.add(cancelbutton);
		
		add(buttonpanel, BorderLayout.SOUTH);
		/*--------------------------------------------------------------------*/
		
		setVisible(true);
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelbutton){			//The cancel button was clicked
			dispose();
		} else if (e.getSource() == okbutton) {		//The ok button was clicked
			User user = new User("", input_email.getText(), String.valueOf(input_password.getPassword()));
			if(gui.getController().validateUser(user)) {
				this.dispose();
				gui.getController().setLoggedinUser(user);
				JOptionPane.showMessageDialog(this, 
						Labels.USER_LOGIN_SUCCESSFUL, 
						Labels.USER_LOGIN_TITLE, 
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, 
						Labels.USER_LOGIN_FAILED, 
						Labels.USER_LOGIN_TITLE, 
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
