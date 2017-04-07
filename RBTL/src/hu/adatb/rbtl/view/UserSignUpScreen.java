package hu.adatb.rbtl.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * The panel what we display as the Sign Up interface
 * @author Attila Uhrin
 *
 */
public class UserSignUpScreen extends JPanel implements ActionListener{

	private Container contentPane;
	
	private JLabel title;
	private JPanel gridpanel, buttonpanel;
	private JLabel label_name, label_email, label_password;
	private JTextField input_name, input_email;
	private JPasswordField input_password;
	private JButton okbutton, cancelbutton;
	
	
	public UserSignUpScreen(Container contentPane){
		super();
		this.contentPane = contentPane;
		setLayout(new BorderLayout());
		
		title = new JLabel(Labels.USER_SIGNUP_TITLE, SwingConstants.CENTER);
		add(title, BorderLayout.NORTH);
		
		/*-----------Grid panel containing the labels and input fields-----------*/
		gridpanel = new JPanel();
		gridpanel.setLayout(new GridLayout(3, 2));
		
		label_name = new JLabel(Labels.USER_SIGNUP_NAME);
		label_email = new JLabel(Labels.USER_SIGNUP_EMAIL);
		label_password = new JLabel(Labels.USER_SIGNUP_PASSWORD);
		
		input_name = new JTextField();
		input_email = new JTextField();
		input_password = new JPasswordField();
		
		gridpanel.add(label_name);
		gridpanel.add(input_name);
		
		gridpanel.add(label_email);
		gridpanel.add(input_email);
		
		gridpanel.add(label_password);
		gridpanel.add(input_password);
		
		add(gridpanel, BorderLayout.CENTER);
		/*-------------------------------------------------------------------*/
		
		/*-----------Button panel containing ok and cancel buttons-----------*/
		buttonpanel = new JPanel(new FlowLayout());
		okbutton = new JButton(Labels.USER_SIGNUP_OKBUTTON);
		cancelbutton = new JButton(Labels.USER_SIGNUP_CANCELBUTTON);
		
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
			contentPane.removeAll();
			contentPane.add(new WelcomeScreen());
			contentPane.revalidate();
		} else if (e.getSource() == okbutton){		//The ok button was clicked
			//TODO implement writing to database
		}		
	}
}
