package hu.adatb.rbtl.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import hu.adatb.rbtl.model.beans.User;

public class EditProfileScreen extends JPanel implements ActionListener {
	private BookshopGUI gui;
	private JLabel a, panel_title,label_new_password1,label_new_password2,label_current_password, label_user_name, label_email;
	private JPanel gridpanel, buttonpanel, gridpanel_user_name;
	private JLabel account_name, email;
	private JTextField input_account,input_user_name,input_email,input_current_password, input_new_password_1, input_new_password_2;
	private JButton okbutton, cancelbutton;
	
	public EditProfileScreen(BookshopGUI gui){
		super();
		this.gui = gui;
		
		setLayout(new BorderLayout());
		
		panel_title = new JLabel(Labels.EDIT_PROFILE_PANE_TITLE, SwingConstants.CENTER);
		add(panel_title, BorderLayout.NORTH);
		
		
		
		/*----------------------------Grid panel----------------------------*/
		gridpanel = new JPanel(new GridLayout(5, 2));
		
		label_user_name = new JLabel(Labels.EDIT_PROFILE_USER_NAME);
		label_email = new JLabel(Labels.EDIT_PROFILE_EMAIL);
		label_current_password = new JLabel(Labels.EDIT_PROFILE_CURRENT_PASSWORD);
		label_new_password1 = new JLabel(Labels.EDIT_PROFILE_NEW_PASSWORD1);
		label_new_password2 = new JLabel(Labels.EDIT_PROFILE_NEW_PASSWORD2);
		
		
		input_user_name = new JTextField();
		input_email = new JTextField();
		input_new_password_1 = new JTextField();
		input_new_password_2 = new JTextField();
		input_current_password  = new JTextField();
		
		gridpanel.add(label_user_name );
		gridpanel.add(input_user_name);
		
		gridpanel.add(label_email);
		gridpanel.add(input_email);
		
		gridpanel.add(label_current_password);
		gridpanel.add(input_current_password);
		
		gridpanel.add(label_new_password1);
		gridpanel.add(input_new_password_1);
		
		gridpanel.add(label_new_password2);
		gridpanel.add(input_new_password_2);
		
		add(gridpanel, BorderLayout.CENTER);
		/*-------------------------------------------------------------------*/
		
		/*-----------Button panel containing ok and cancel buttons-----------*/
		buttonpanel = new JPanel(new FlowLayout());
		okbutton = new JButton(Labels.EDIT_PROFILE_OKBUTTON);
		cancelbutton = new JButton(Labels.EDIT_PROFILE_CANCELBUTTON);
		
		cancelbutton.addActionListener(this);
		okbutton.addActionListener(this);
		
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
			user.setName(input_account.getText());
			user.setEmail(input_email.getText());
			
			if(input_account.getText().length()>0){
				
			}else if(input_email.getText().length()>0){
				
			}
		}
		
	}
	
	
	}

