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
			User user = new User();
			//user.setName(input_account.getText());
			//user.setEmail(input_email.getText());
			
			if((input_current_password.getText().equals("") || input_user_email.getText().equals(""))){
				//UserEditProfileDialog dialog = new UserEditProfileDialog(gui);
				JOptionPane.showMessageDialog(this, 
						Labels.USER_EDIT_ENTER_CURRENT_PASSWORD, 
						Labels.USER_EDIT_DIALOG_TITLE, 
						JOptionPane.ERROR_MESSAGE);
				
			}else {
				if(gui.getController().validateUserEditProfile(input_user_email.getText(), input_current_password.getText())){
					
					//the user has typed in a new user name
					if(!(input_user_name.getText().equals(""))){
						if(gui.getController().updateUserNameEditProfile(user, input_user_name.getText())){
							System.out.println("nev megvaltoztatva");
						}
					}
					
					//the user has typed in a new password
					if(!(input_new_password_1.equals("") && input_new_password_2.equals(""))){
						// pwd1 and pwd2 are the same
						if(input_new_password_1.getText().equals(input_new_password_2.getText())){
							gui.getController().updatePasswordEditProfile(user, input_new_password_1.getText());
							
							//pwd1 and pwd2 are not the same
						}else if(!(input_new_password_1.getText().equals(input_new_password_2.getText()))){
							EditProfilePasswordDialog editProfilePasswordDialog = new EditProfilePasswordDialog(gui);
						}
					}
					
				}
				
				
			}
		}
		
	}
	
	
	}

