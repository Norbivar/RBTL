package hu.adatb.rbtl.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import hu.adatb.rbtl.model.BookshopDAOImplementation;
import hu.adatb.rbtl.model.beans.User;
import hu.adatb.rbtl.view.dialogs.EditProfilePasswordDialog;
import hu.adatb.rbtl.view.dialogs.UserEditProfileDialog;

public class EditProfileScreen extends JPanel implements ActionListener {
	private BookshopGUI gui;
	private JLabel label_user_email, panel_title,label_new_password1,label_new_password2,label_current_password, label_user_name, label_email, label_address;
	private JPanel gridpanel, buttonpanel;
	private JTextField input_user_email,input_user_name,input_current_password, input_new_password_1, input_new_password_2, input_address;
	private JButton okbutton, cancelbutton;
	
	public EditProfileScreen(BookshopGUI gui){
		super();
		this.gui = gui;
		
		setLayout(new BorderLayout());
		
		panel_title = new JLabel(Labels.EDIT_PROFILE_PANE_TITLE, SwingConstants.CENTER);
		add(panel_title, BorderLayout.NORTH);
		
		
		
		/*----------------------------Grid panel----------------------------*/
		gridpanel = new JPanel(new GridLayout(6, 2));
		
		label_user_email = new JLabel(Labels.EDIT_PROFILE_USER_EMAIL);
		label_user_name = new JLabel(Labels.EDIT_PROFILE_USER_NAME);
		label_current_password = new JLabel(Labels.EDIT_PROFILE_CURRENT_PASSWORD);
		label_new_password1 = new JLabel(Labels.EDIT_PROFILE_NEW_PASSWORD1);
		label_new_password2 = new JLabel(Labels.EDIT_PROFILE_NEW_PASSWORD2);
		label_address = new JLabel(Labels.EDIT_PROFILE_ADDRESS);
		
		input_user_email = new JTextField();
		input_user_name = new JTextField();
		input_new_password_1 = new JPasswordField();
		input_new_password_2 = new JPasswordField();
		input_current_password  = new JPasswordField();
		input_address = new JTextField();
		
		gridpanel.add(label_user_email);
		gridpanel.add(input_user_email);
		
		gridpanel.add(label_user_name );
		gridpanel.add(input_user_name);
		
		
		gridpanel.add(label_current_password);
		gridpanel.add(input_current_password);
		
		gridpanel.add(label_new_password1);
		gridpanel.add(input_new_password_1);
		
		gridpanel.add(label_new_password2);
		gridpanel.add(input_new_password_2);
		
		gridpanel.add(label_address);
		gridpanel.add(input_address);
		
		add(gridpanel, BorderLayout.CENTER);
		/*-------------------------------------------------------------------*/
		
		/*-----------Button panel containing ok and cancel buttons-----------*/
		buttonpanel = new JPanel(new FlowLayout());
		okbutton = new JButton(Labels.EDIT_PROFILE_OKBUTTON);
		cancelbutton = new JButton(Labels.EDIT_PROFILE_CANCELBUTTON);
		
		okbutton.addActionListener(this);
		cancelbutton.addActionListener(this);
		
		buttonpanel.add(okbutton);
		buttonpanel.add(cancelbutton);
		
		add(buttonpanel, BorderLayout.SOUTH);
		
		/*--------------------------------------------------------------------*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelbutton){
			gui.getContentPane().removeAll();
			gui.getContentPane().add(new WelcomeScreen());
			gui.getContentPane().revalidate();
		}else if(e.getSource() == okbutton){
			User user = gui.getController().getLoggedinUser();

			if(input_current_password.getText().equals(gui.getController().getLoggedinUser().getPassword()))
			{
				//Norbi:
				// address adding
				if(input_address.getText() != null && !input_address.getText().equals("")) {
					if(gui.getController().AddAddressForUser(input_address.getText(), gui.getController().getLoggedinUser())) {
						JOptionPane.showMessageDialog(this, 
								"Address successfully added!", 
								"Address", 
								JOptionPane.INFORMATION_MESSAGE);		
					}
				}			
			
				//username change
				if(!input_user_name.getText().equals("")) {
					if(gui.getController().updateUserNameEditProfile(user, input_user_name.getText())){
						System.out.println("nev megvaltoztatva");
					}
					else
						JOptionPane.showMessageDialog(this, 
								"Username change was unsuccessful sadly!", 
								"Username Change", 
								JOptionPane.ERROR_MESSAGE);		
				}
				if(!input_new_password_1.getText().equals("")) {
				//password change:
					if(input_new_password_2.getText().equals(input_new_password_1.getText())) {
						if(gui.getController().updatePasswordEditProfile(user, input_new_password_1.getText())){
							JOptionPane.showMessageDialog(this, 
									Labels.EDIT_PROFILE_PASSWORD_DIALOG_PASSWORD, 
									Labels.EDIT_PROFILE_PASSWORD_DIALOG_TITLE, 
									JOptionPane.INFORMATION_MESSAGE);
						}
						else
							JOptionPane.showMessageDialog(this, 
									"We encountered an error!", 
									"Password Change", 
									JOptionPane.ERROR_MESSAGE);
					}
					else
						JOptionPane.showMessageDialog(this, 
								"New passwords do not match or simply left blank!", 
								"Password Change", 
								JOptionPane.ERROR_MESSAGE);	
				}
			}
			else
				JOptionPane.showMessageDialog(this, 
						"Your current password always needs to be typed in to allow editing!", 
						"Editing failed!", 
						JOptionPane.ERROR_MESSAGE);	
			gui.getController().refreshUserData();
		}	
	}	
}

